/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.indexador.negocio.servicios.indexado;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.DefaultSimilarity;
import org.apache.lucene.search.spell.Dictionary;
import org.apache.lucene.search.spell.LuceneDictionary;
import org.apache.lucene.search.spell.SpellChecker;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;

import es.pode.indexador.negocio.dominio.Indice;
import es.pode.indexador.negocio.dominio.IndiceDao;
import es.pode.indexador.negocio.soporte.DocumentoIndexacion;
import es.pode.parseadorXML.ParseadorException;

/**
 * @see es.pode.indexador.negocio.servicios.SrvIndexadorService
 */

public class SrvIndexadorServiceImpl extends
		es.pode.indexador.negocio.servicios.indexado.SrvIndexadorServiceBase {
	
	private Logger logger = Logger.getLogger(this.getClass());
	private Properties props = null;
	public static String SPELL_CHECKER = "spell";

	public SrvIndexadorServiceImpl() {
		
		super();
		try {
			props = new Properties();
			props.load(this.getClass().getResourceAsStream("/indexador.properties"));
		} catch (IOException e) {
			logger.error("ERROR: fichero no encontrado: indexador.properties", e);
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * Obtiene los index writers de los indices dados de alta
	 * */
	private Hashtable abrirIndicesWR() throws Exception
	{
		ArrayList listaIndices = (ArrayList) this.getIndiceDao().loadAll();
		Indice[] indices = (Indice[])listaIndices.toArray(new Indice[0]);
		Hashtable mapaIndicesWR = new Hashtable();
		if (indices == null || indices.length ==0)
		{
			logger.error("Error obteniendo indices de escritura. Tabla vacia. No se crean los IndexWriters.");
			throw new Exception("Error obteniendo indices. No se crean los IndexWriters.");
		}
		try {
			if(logger.isDebugEnabled())logger.debug("Recuperamos ["+indices.length+"] indices de escritura de indexacion.");
			for (int i = 0; i < indices.length; i++) {
				Indice indice = indices[i];
				if (indice == null)
				{
					logger.error("El indice recuperado["+i+"] es nulo, paso al siguiente.");
					continue;
				}
				if(logger.isDebugEnabled())logger.debug("Vamos a obtener el indice de escritura para el idioma con id["+indice.getIdentificador()+"]");
				IndexWriter indiceWR = null;
				try {
					indiceWR = indiceEscritura(indice.getIdentificador());
				} catch (Exception e) {
//					Si el indice peta, sigo adelante
					logger.warn("Error abriendo indice de escritura ["+indice.getFile_indice()+"]. No se tiene en cuenta.");
				}
				if (indiceWR != null) // puede que el indice no tenga un index writer asociado, no lo puedo abrir
					mapaIndicesWR.put(indice.getIdentificador(), indiceWR);
				else
					if(logger.isDebugEnabled())logger.debug("No hay indice en disco asociado al idioma["+indice.getIdentificador()+"]. No se abrira.");
			}
		} catch (Exception e) {
			logger.error("Error obteniendo indices de escritura. Error generando los IndexWriters["+e.getCause()+"].");
			throw new Exception("Error obteniendo indices de escritura. Error generando los IndexWriters.",e);
		}
		return mapaIndicesWR;
	}
	
	/*
	 * Cierra los index writers actualizando los cambios y regenerando los spell checkers de los indices que le pasan
	 * */
	private void cierraIndicesWROptimiza(Hashtable indicesAbiertosWR) throws Exception
	{
		if (indicesAbiertosWR == null || indicesAbiertosWR.isEmpty())
//			no hacemos nada
			return;
		
//		Hacemos efectivos los cambios en los indices
		try {
			for (Enumeration e = indicesAbiertosWR.elements() ; e.hasMoreElements() ;) {
				IndexWriter indiceEscritura = (IndexWriter)e.nextElement();
				indiceEscritura.flush();
				indiceEscritura.optimize();
				indiceEscritura.getDirectory().clearLock(indiceEscritura.getDirectory().getLockID());	
				indiceEscritura.getDirectory().close();
				indiceEscritura.close();
			}
		} catch (Exception e1) {
			logger.error("Error realizando flush sobre los indices abiertos["+e1.getCause()+"]");
			throw new Exception("Error realizando flush sobre los indices abiertos.", e1);
		}
//		Modificamos los  spell checker por idiomas
//		- Reseteamos los spell
//		- Regeneramos su informacion
		try {
			for (Enumeration e = indicesAbiertosWR.keys() ; e.hasMoreElements() ;) {
				String locale = (String)e.nextElement();
				Directory directorioIndiceSpell = this.indiceSpell(locale);
//				Eliminamos la informacion del spell checker para regenerarla de nuevo
				spellCheckerReset(directorioIndiceSpell);
				if (directorioIndiceSpell != null) 
				{
					this.spellCheckerAdd(this.getDirectorioPorLocale(locale),directorioIndiceSpell);
				}
			}
		} catch (Exception e) {
			logger.error("Error actualizando Spell Checkers de los indices["+e.getCause()+"]");
			throw new Exception("Error actualizando Spell Checkers de los indices.", e);
		}
	}
	
	/**
	 * Indexa un array de Objetos Digitales Educativos
	 * @param localizador Objeto donde le indicamos la localización física del fichero immsmanifiestxml 
	 * y el identificador del ODE a indexar
	 * @throws java.lang.Exception
	 * @see es.pode.indexador.negocio.servicios.SrvIndexadorService#IndexarODE(java.lang.String)
	 */
	protected IndexadorVO[] handleIndexarODE(
			es.pode.indexador.negocio.servicios.indexado.IdODEVO[] localizador)
			throws java.lang.Exception 
	{
//		A partir del objeto de descripcion del ODE que nos pasan generamos el Documento de lucene para la indexacion.
		ArrayList respuestas = new ArrayList();
		int cont = localizador.length;
		String locale = null;
		IndexWriter writer = null;
		Directory directorioIndiceSpell = null;
		Set localeSet = new HashSet();
		
		for (int x = 0; x < cont; x++) {
			if(logger.isDebugEnabled())logger.debug("Iniciamos la indexación del objeto con localizador = "+ localizador[x].getLocalizadorODE());
			if(logger.isDebugEnabled())logger.debug("Iniciamos la indexación del objeto con localizador = "+ localizador[x].getCatalogacionPrimaria().getArbolCurricular());
			
			try {
				
				locale = localizador[x].getCatalogacionPrimaria().getIdioma();
				localeSet.add(locale);
				if(logger.isDebugEnabled())logger.debug("Indexamos el ODE con id[" + localizador[x].getIdODE() +  "] en el idioma[" + locale +"]");
				
				Document doc = new Document();

				if(logger.isDebugEnabled())logger.debug("Vamos a generar el Document de Lucene para id["+ localizador[x].getIdODE() + "] e idioma [" + locale + "]");
				doc = this.generarDoc(localizador[x]);
				
				if (doc != null) 
				{
					if(logger.isDebugEnabled())logger.debug("Añadimos el doc creado al índice");
					// if (writer.getDirectory().clearLock(arg0))
					writer = this.indiceEscritura(locale);
					writer.addDocument(doc);
//					 it is not needed to flush because close do it: close() Flushes all changes to an index and closes all associated files.
					// writer.flush();
				}
					
			} 
			catch (Exception e) {
				logger.error(e);
				logger.error("La indexación Ha fallado con id ODE[" + localizador[x].getIdODE() + "] localizado en ["+localizador[x].getLocalizadorODE()+"] para idioma["+locale+"]");
				writer.getDirectory().clearLock(writer.getDirectory().getLockID());					
				writer.getDirectory().close();
				writer.close();
				respuestas.add(rellenarVO(localizador[x].getLocalizadorODE(), 1, "Indexación incorrecta"));
			} 
			finally {
				if (writer != null) {
					// vamos a realizar el optimize al final del bucle for
					//writer.optimize(); 
					writer.close();
//					 actualizamos el indice de las sugerencias.
					directorioIndiceSpell = this.indiceSpell(locale);
					if (directorioIndiceSpell != null) {
						this.spellCheckerAdd(writer.getDirectory(), directorioIndiceSpell);
					}
				}
			}
			
			if(logger.isDebugEnabled())logger.debug("La indexación se ha hecho correctamente con localizador["+ localizador[x].getIdODE()+"]");
			respuestas.add(rellenarVO(localizador[x].getLocalizadorODE(), 0, "Indexación correcta"));
		}

		Iterator setIterator = localeSet.iterator();
		IndexWriter localeWriter = null;
		while (setIterator.hasNext()) {
			String nextLocale = (String) setIterator.next();
			try {
				if (logger.isDebugEnabled()) logger.debug("Vamos a optimizar el índice '" + nextLocale +"'");
				localeWriter = this.indiceEscritura(locale);
				if (logger.isDebugEnabled()) logger.debug("Índice '" + nextLocale +"' abierto. Llamando a writer.optimize()...");
				localeWriter.optimize();
				if (logger.isDebugEnabled()) logger.debug("Índice '" + nextLocale +"' optimizado");
			} catch (Exception e) {
				logger.error("Ocurrió una excepción mientras se intentaban optimizar los índices usados", e);
				// no podemos relanzar la excepción
			} finally {
				if (logger.isDebugEnabled()) logger.debug("Índice '" + nextLocale +"' optimizado");
				try {
					if (localeWriter != null) {
						localeWriter.close();
					}
				} catch (Exception e) {
					logger.fatal("Ha sido imposible cerrar el writer.", e);
				}
			} 
		}
		
		return (IndexadorVO[]) respuestas.toArray(new IndexadorVO[respuestas.size()]);
	}

	/**
	 * Reindexado de ODEs
	 * @param localizador Objeto donde le indicamos la localización física del fichero immsmanifiestxml 
	 * y el identificador del ODE a reindexar
	 * @throws java.lang.Exception
	 * @see es.pode.indexador.negocio.servicios.SrvIndexadorService#reindexarODE(java.lang.String)
	 */
	protected IndexadorVO[] handleReindexarODE(
			es.pode.indexador.negocio.servicios.indexado.IdODEVO[] localizador)
			throws java.lang.Exception {
		// El objeto esta indexado.
		// Para reindexar un documento hay que utilizar el index writer y no el index modifier, que esta deprecated

		ArrayList respuestas = new ArrayList();
		if (localizador != null || localizador.length > 0) 
		{
//			Abrimos todos los indices de escritura para todos los idiomas en prevision de aceptar ODEs de diferentes
//			idiomas
			Hashtable indicesWR = new Hashtable();
			try {
				indicesWR = abrirIndicesWR();
			} catch (RuntimeException e) {
				logger.error("Error abriendo los indices de los idiomas indexados para reindexacion["+e.getCause()+"]");
				throw new Exception("Error abriendo los indices de los idiomas indexados para reindexacion",e);
			}
			for (int x = 0; x < localizador.length; x++) 
			{
//				Vemos si hay un indice donde reindexar el ODE. Utilizamos su idioma.
				if (localizador[x].getCatalogacionPrimaria()!= null && indicesWR.get(localizador[x].getCatalogacionPrimaria().getIdioma()) != null){
					String locale = localizador[x].getCatalogacionPrimaria().getIdioma();
			
//					procedemos a actualizar los indices
//					Obtenemos el indice de escritura para realizar la modificacion
					Analyzer analizador = this.obtenerAnalyzer(locale);
					IndexWriter  indiceAModificar = (IndexWriter)indicesWR.get(locale);
//					Borramos documento a re-indexar
					if(logger.isDebugEnabled())logger.debug("Obtenemos indice de escritura para reindexar Documento con indentificador["+ localizador[x].getIdODE()+"] en indice["+locale+"]");
//					Calculamos el termino por el que vamos a sustituir los documentos del indice
					Term terminoABorrar = new Term(props.getProperty("campo_identificadorODE"),localizador[x].getIdODE());
//					Con los campos del ODE que nos pasan para indexar generamos un documento nuevo
					Document doc = this.generarDoc(localizador[x]);
//					Actualizamos el documento dentro del indice
					indiceAModificar.updateDocument(terminoABorrar, doc, analizador);
					indiceAModificar.flush();
//					Preparamos la respuesta de exito fracaso para la vuelta
					respuestas.add(rellenarVO(localizador[x].getLocalizadorODE(), 0,"Reindexación correcta"));
				}
				else 
				{
					String idiomaFalso = (localizador[x].getCatalogacionPrimaria()!= null)?localizador[x].getCatalogacionPrimaria().getIdioma():"null";
					if(logger.isDebugEnabled())logger.debug("Error reindexando ODE con identificador["+localizador[x].getIdODE()+"] e idioma["+idiomaFalso+"]. No hay indice para este idioma de catalogacion.");
					respuestas.add(rellenarVO(localizador[x].getLocalizadorODE(), 1,"Reindexación incorrecta"));
				}
			}
//			Cerramos los indices de escritura y regeneramos los spell checkers
			try {
				cierraIndicesWROptimiza(indicesWR);
			} catch (RuntimeException e) {
				logger.error("Error cerrando los indices de escritura despues de eindexacion["+e.getCause()+"]");
				throw new Exception("Error cerrando los indices de escritura despues de eindexacion",e);
			}
		}
		else
		{
			logger.error("No hay ODEs para reindexar");
			throw new Exception("No hay ODEs para reindexar");
		}

		return (IndexadorVO[]) respuestas.toArray(new IndexadorVO[respuestas.size()]);
	}

	/**
	 * Eliminacion de ODEs de los indices.
	 * @param idODE Array de identificadores alfanumericos de los ODEs que se quieren eliminar. 
	 * @throws java.lang.Exception
	 * @see es.pode.indexador.negocio.servicios.SrvIndexadorService#eliminarODE(java.lang.String)
	 */
	protected IndexadorVO[] handleEliminarODE( String[] idODE)
			throws java.lang.Exception 
	{
		ArrayList respuestas = new ArrayList();
		if (idODE != null || idODE.length > 0) 
		{
//			Abrimos todos los indices de lectura para eliminar todos los ODEs de todos los indices que hay
			Hashtable indicesWR = new Hashtable();
			try {
				indicesWR = abrirIndicesWR();  //lo intentamos con los indices de escritura
			} catch (RuntimeException e) {
				logger.error("Error abriendo los indices de los idiomas indexados para eliminacion["+e.getCause()+"]");
				throw new Exception("Error abriendo los indices de los idiomas indexados para eliminacion",e);
			}
//			Si no hay indices sobre los que actuar, devuelvo exito.
			if (indicesWR == null || indicesWR.size() <= 0)
			{
				logger.warn("Error eliminando ODEs. No hay indices sobre los que eliminar.");
				for(int x= 0; x < idODE.length ; x++)
					respuestas.add(new IndexadorVO(idODE[x],0,"Borrado correcto."));
				return (IndexadorVO[]) respuestas.toArray(new IndexadorVO[respuestas.size()]);
			}
//			Me recorro las claves de la tabla(idiomas) para ir borrando para cada una los odes
			for (Enumeration e = indicesWR.keys(); e.hasMoreElements();) 
			{
				String terminoClave = props.getProperty("campo_identificadorODE");
				String locale = (String)e.nextElement();
				IndexWriter indiceActual = (IndexWriter)indicesWR.get(locale);
				for (int x = 0; x < idODE.length; x++) {
					Term terminoABorrar = new Term(terminoClave, idODE[x]);
					try {
						try {						
							indiceActual.deleteDocuments(terminoABorrar);
							respuestas.add(rellenarVO(idODE[x], 0,"Borrado correcto"));
							logger.info("Documento con idODE[" + idODE[x]+ "] borrado del indice["+locale+"]");
						} catch (RuntimeException e1) {
							logger.warn("Intentando borrar documento con idODE[" + idODE[x]+ "] del indice["+locale+"] imposible borrar["+e1.getCause()+"]. Continuamos con el resto del proceso.");
							respuestas.add(rellenarVO(idODE[x], 1,"Borrado incorrecto"));
							logger.warn("Añadimos de nuevo a la BD tesauros y areas curriculares del ODE "+idODE[x]+" que habiamos eliminado");
							logger.warn("Documento con idODE[" + idODE[x]+ "] no encontrado en el indice["+locale+"]");
						}
					} catch (Exception e1){
						logger.warn("Intentando borrar documento con idODE[" + idODE[x]+ "] del tesauro ["+locale+"] imposible borrar["+e1.getCause()+"]. Continuamos con el resto del proceso.");
						respuestas.add(rellenarVO(idODE[x], 1,"Borrado del tesauro incorrecto"));
						logger.warn("Documento con idODE[" + idODE[x]+ "] no encontrado en el tesauro["+locale+"]");
				
					}
					indiceActual.flush();
				}				
			}
//			Cerramos los indices de escritura y regeneramos los spell checkers
			try {
				cierraIndicesWROptimiza(indicesWR);
			} catch (RuntimeException e) {
				logger.error("Error cerrando los indices de lectura despues de borrado["+e.getCause()+"]");
				throw new Exception("Error cerrando los indices de lectura despues de borrado",e);
			}
		}
		else
		{
			logger.error("No hay ODEs para borrar");
			throw new Exception("No hay ODEs para borrar");
		}
		return (IndexadorVO[]) respuestas.toArray(new IndexadorVO[respuestas.size()]);
	}

	/**
	 * Se regenera el indice con la lista de ODEs que se le pasa. Se borra el indice del idioma indicado y se
	 * puebla con los ODEs suministrados.
	 * @param idioma Codigo de idioma correspondiente al indice que se quiere regenerar.
	 * @param odes Contenido de los ODEs que se quieren indexar.
	 * @return IndexadorVO[] Se devuelve un array con el exito o fracaso de la regeneracion para cada ode afectado.
	 * @throws Exception
	 * @see es.pode.indexador.negocio.servicios.SrvIndexadorService#RegenerarIndice(java.lang.String[])
	 */
	protected IndexadorVO[] handleRegenerarIndice(String idioma, IdODEVO[] odes) throws Exception {

//		Recuperamos el indice
		ArrayList resultado = (ArrayList) this.getIndiceDao().buscarIndicePorIdentificador(idioma);
		if (resultado == null || resultado.size() ==0 || resultado.size() > 1)
		{
			logger.error("Error obteniendo indice con identificador["+idioma+"]. Imposible regenerar indice desconocido.");
			throw new Exception("Error obteniendo indice con identificador["+idioma+"]. Imposible regenerar indice desconocido.");
		}
//		Eliminamos todos los documetos de este indice.
		this.borradoTodosDocumentos(idioma,odes);		
//		Indexamos los ODEs. La indexacion se hace para cada ode en su indice dependiendo del idioma de catalogacion
//		Se supone que el invocador de este metodo es consciente de que borra el indice del idioma dado y que los
//		ODEs pertenecen a este idioma.
		return this.handleIndexarODE(odes);
	}

	/**
	 * Este metodo regenera todos los indices del repositorio con los ODEs que se le pasan en el momento. 
	 * Toma como parametro un identificador de tarea donde escribe el resultado de la ejecucion. Cada ODE se 
	 * introduce en el indice del idioma al que pertenece.
	 * Se devuelve un array con el exito o fracaso de la regeneracion para cada ode.
	 * @param idTarea Identificador de la tarea.
	 * @param odes ODEs que se utilizan para la regeneracion de los indices.
	 * @return IndexadorVO[] Se devuelve un array con el exito o fracaso de la regeneracion para cada ode afectado.
	 * @throws Exception 
	 * @see es.pode.indexador.negocio.servicios.SrvIndexadorService#RegenerarIndices(java.lang.Long)
	 */
	protected IndexadorVO[] handleRegenerarIndices(Long idTarea, IdODEVO[] odes) throws Exception {
		
//		Recuperamos todos los indices
		ArrayList resultado = (ArrayList) this.getIndiceDao().loadAll(IndiceDao.TRANSFORM_INDICEVO);
		if (resultado == null || resultado.size() ==0)
		{
			if(logger.isDebugEnabled())logger.debug("Error obteniendo indices. Tabla vacia. No se regeneran los indices.");
			throw new Exception("Error obteniendo indices. Tabla vacia. No se regeneran los indices.");
		}
		try {
			for (int i = 0; i < resultado.size(); i++) {
//				Eliminamos todos los documetos de este indice.
				this.borradoTodosDocumentos(((IndiceVO)resultado.get(i)).getIdentificador(),odes);
			}
		} catch (Exception e) {
			logger.error("Error regenerando todos los indices["+e.getCause()+"]");
			throw new Exception("Error regenerando todos los indices",e);
		}
//		Indexamos los ODEs. La indexacion se hace para cada ode en su indice dependiendo del idioma de catalogacion
//		Se supone que el invocador de este metodo es consciente de que borra el indice del idioma dado y que los
//		ODEs pertenecen a este idioma.
		return this.handleIndexarODE(odes);
	}
	
	/*
	 * Este metodo devuelve el indice de lectura para la clave de idioma que le pasan.
	 * */
	private IndexReader indiceLectura(String clave_idioma) throws Exception
	{
//		----------------------------------
		
		IndexReader reader = null;
		if(logger.isDebugEnabled())logger.debug("Vamos a buscar el indice = " + clave_idioma);
		if (clave_idioma == null || "".equals(clave_idioma))
		{
			logger.error("Intentando obtener indice de lectura de un idioma vacio["+clave_idioma+"]. No devolvemos nada.");
			return null;
		}
		List resultado = this.getIndiceDao().buscarIndicePorIdentificador(clave_idioma);
		
		if (resultado != null && resultado.size() > 0) 
		{
			if(logger.isDebugEnabled())logger.debug("Obtenemos el indice = " + resultado);

			Indice indiceSimple = (Indice) resultado.get(0);
			if(logger.isDebugEnabled())logger.debug("Indexamos en el índice = " + indiceSimple);

			String indiceSimpleDir = indiceSimple.getPath() + File.separator + indiceSimple.getFile_indice();
			if(logger.isDebugEnabled())logger.debug("El índice está en el directorio = " + indiceSimpleDir);

			//File findexDir = new File(indiceSimpleDir);
			Directory directorioIndiceSimple = FSDirectory.getDirectory(indiceSimpleDir);
			if (IndexReader.indexExists(directorioIndiceSimple)) 
			{
				reader = IndexReader.open(directorioIndiceSimple);
			}
			else
			{
				logger.warn("No existe el indice["+indiceSimpleDir+"] para la clave de idioma["+clave_idioma+"].");
				return null;
			}
			if(logger.isDebugEnabled())logger.debug("Hemos abierto el índice para idioma["+clave_idioma+"] path["+indiceSimpleDir+"]");
		} 
		else 
		{
			logger.error("No Existe el indice["+clave_idioma+"]");
			throw new Exception("No Existe el índice = " + clave_idioma);
		}
		return reader;
	}
	
	private IndexWriter indiceEscritura(String indice_simple)
			throws IOException, Exception 
	{
		IndexWriter writer = null;
		if(logger.isDebugEnabled())logger.debug("Vamos a buscar el indice = " + indice_simple);
		if (indice_simple == null || "".equals(indice_simple))
		{
			logger.error("Intentando obtener indice de escritura de un idioma vacio["+indice_simple+"]. No devolvemos nada.");
			return null;
		}
		List resultado = this.getIndiceDao().buscarIndicePorIdentificador(indice_simple);
		
		if (resultado != null && resultado.size() > 0) 
		{
			if(logger.isDebugEnabled())logger.debug("Obtenemos el indice = " + resultado);

			Indice indiceSimple = (Indice) resultado.get(0);
			if(logger.isDebugEnabled())logger.debug("Indexamos en el índice = " + indiceSimple);

			String indiceSimpleDir = indiceSimple.getPath() + File.separator + indiceSimple.getFile_indice();
			if(logger.isDebugEnabled())logger.debug("El índice está en el directorio = " + indiceSimpleDir);

			boolean createFlag = true;
			File findexDir = new File(indiceSimpleDir);
//			TODO: hay que verificar más exhaustivamente que el directorio no este creado siendo vacio de contenido.
			createFlag = existeIndice(findexDir);
			Directory directorioIndiceSimple = FSDirectory.getDirectory(indiceSimpleDir);
			if(logger.isDebugEnabled())logger.debug("Se mira si el directorio está creado? = " + createFlag);

			Analyzer analyzer = obtenerAnalyzer(indice_simple);
			// Creamos el índice principal
			writer = new IndexWriter(directorioIndiceSimple, analyzer, !createFlag);
			writer.setSimilarity(new DefaultSimilarity());
			if(logger.isDebugEnabled())logger.debug("Hemos generado el índice");
		} 
		else 
		{
			logger.error("No Existe el indice["+indice_simple+"]");
			throw new Exception("No Existe el índice = " + indice_simple);
		}
		return writer;
	}

	private Analyzer obtenerAnalyzer(String idioma) 
	{
		Analyzer analyzer = null;
		// TODO prueba temporal. Corregir
		// Recureramos la lista de stop-words
		String stopWords = props.getProperty("stopWords." + idioma);
		if (stopWords == null || "".equals(stopWords)) {
//			Con el standard analyzer los campos numericos son buscables.
			analyzer = new StandardAnalyzer(new String[0]);
		} else {
			String[] stopWordsArray = stopWords.split(",");
			analyzer = new StandardAnalyzer(stopWordsArray);
		}
		return analyzer;
	}

	/**
	 * Generación del repositorio que nos muestra las palabras sugeridas
	 * @param directorioIndiceSimple Objeto directorio con información del directorio del repositorio de índices
	 * @param directorioIndiceSpell Objeto directorio con la información del directorio del repositorio de las palabras sugeridas
	 * @throws IOException
	 * @throws Exception
	 */
	private synchronized void spellCheckerAdd(Directory directorioIndiceSimple,
			Directory directorioIndiceSpell) throws IOException, Exception {

		if(logger.isDebugEnabled())logger.debug("Comprobamos el directorio del spellchecker = "+ directorioIndiceSpell + " y el normal = "+ directorioIndiceSimple);
		if (IndexReader.indexExists(directorioIndiceSimple)) 
		{
			if(logger.isDebugEnabled())logger.debug("El índiceSimple " + directorioIndiceSimple + "existe y lo abrimos para leer.");
			IndexReader indexReader = IndexReader.open(directorioIndiceSimple);
			String field = props.getProperty("campo_titulo");
			if(logger.isDebugEnabled())logger.debug("Creamos un diccionario para el campo = " + field);
			Dictionary dictionary = new LuceneDictionary(indexReader, field);
			if(logger.isDebugEnabled())logger.debug("Creamos el spellchecher["+directorioIndiceSpell+"]");
			SpellChecker spellChecker = new SpellChecker(directorioIndiceSpell);
			if(logger.isDebugEnabled())logger.debug("Indexamos el diccionario de ["+directorioIndiceSimple+"] en el spell ["+directorioIndiceSpell+"]");
			spellChecker.indexDictionary(dictionary);
			field = props.getProperty("campo_descripcion");
			if(logger.isDebugEnabled())logger.debug("Creamos un diccionario para el campo = " + field);
			dictionary = new LuceneDictionary(indexReader, field);
			spellChecker.indexDictionary(dictionary);
			indexReader.close();
			directorioIndiceSpell.close();
		} 
		else
		{
			logger.error("No existe el indice en el directorio["+directorioIndiceSimple+"]");
			throw new Exception("No existe el índice en el directorio = " + directorioIndiceSimple);
		}
	}

	/**
	 * Reinicio del repositorio que nos muestra las palabras sugeridas
	 * @param directorioIndiceSpell Objeto directorio con la información del directorio del repositorio de las palabras sugeridas
	 * @throws IOException
	 * @throws Exception
	 */
	private void spellCheckerReset(Directory directorioIndiceSpell) throws IOException, Exception {

		if(logger.isDebugEnabled())logger.debug("Comprobamos el directorio del spellchecker ["+ directorioIndiceSpell +"]");
		if (IndexReader.indexExists(directorioIndiceSpell)) 
		{
			if(logger.isDebugEnabled())logger.debug("Creamos el spellchecher ["+ directorioIndiceSpell +"]");
			SpellChecker spellChecker = new SpellChecker(directorioIndiceSpell);
			if(logger.isDebugEnabled())logger.debug("Reseteamos el contenido del spellchecher["+directorioIndiceSpell+"]");
			spellChecker.clearIndex();
			directorioIndiceSpell.close();
		}
//		si no existe el no es necesario reiniciarlo
//		else
//		{
//			logger.error("No existe el spellchecher en el directorio["+directorioIndiceSpell+"]");
//			throw new Exception("No existe el spellchecher en el directorio = " + directorioIndiceSpell);
//		}
	}
	
	private Document generarDoc(es.pode.indexador.negocio.servicios.indexado.IdODEVO idODEVO)
			throws IndexaODEException, ParseadorException,
			FileNotFoundException, MarshalException, ValidationException 
	{
		if(logger.isDebugEnabled())logger.debug("Vamos a generar el documento a indexar para el ODE con ID["+idODEVO.getIdODE()+"] Localizacion["+idODEVO.getLocalizadorODE()+"]");
		Document doc = new Document();
		
		if (idODEVO.getCatalogacionPrimaria() != null) 
		{
			try 
			{
				if(logger.isDebugEnabled())logger.debug("Generamos el doc para ODE con ID["+idODEVO.getIdODE()+"] con los campos primarios");
				doc = DocumentoIndexacion.GenerarCamposPrincipales(doc,idODEVO, props);
				if (idODEVO.getCatalogacionSecundaria() != null && idODEVO.getCatalogacionSecundaria().length > 0) 
				{
					if(logger.isDebugEnabled())logger.debug("Generamos el doc para ODE con ID["+idODEVO.getIdODE()+"] con los campos secundarios");
					doc = DocumentoIndexacion.GenerarCamposSecundarios(doc,idODEVO.getCatalogacionSecundaria(), props);
				}
			} 
			catch (Exception e) 
			{
				logger.error("Error generando documento de indexacion para ODE con id["+idODEVO.getIdODE()+"] excepcion["+e.getCause()+"]");
				throw new IndexaODEException("Error generando documento de indexacion para ODE con id["+idODEVO.getIdODE()+"]",e);
			}
		}
		
		return doc;
	}

	private Directory indiceSpell(String locale) throws IOException 
	{
		Directory directorioIndiceSpell = null;
		if(logger.isDebugEnabled())logger.debug("Vamos a buscar el indice para el spellChecker para el idioma= " + locale);
		List resultado = this.getIndiceDao().buscarIndicePorIdentificador(locale);

		if (resultado != null && resultado.size() > 0) 
		{
			if(logger.isDebugEnabled())logger.debug("Obtenemos el indice = " + resultado);
			Indice indiceSimple = (Indice) resultado.get(0);
			String indiceSimpleDir = indiceSimple.getPath() + File.separator
					+ indiceSimple.getFile_indice() + File.separator
					+ SrvIndexadorServiceImpl.SPELL_CHECKER;
			
			if(logger.isDebugEnabled())logger.debug("El directorio del spellchecker es = " + indiceSimpleDir);
			directorioIndiceSpell = FSDirectory.getDirectory(indiceSimpleDir);
		} 
		else 
		{
			logger.error("No existe directorio de spellchecker definido para el idioma = " + locale);
		}
		
		return directorioIndiceSpell;
	}

	private IndexadorVO rellenarVO(String localizador, int code, String mensaje) 
	{
		IndexadorVO vo = new IndexadorVO();
		vo.setCode(code);
		vo.setLocalizador(localizador);
		vo.setMensaje(mensaje);
		return vo;
	}

	private Directory getDirectorioPorLocale(String indice_simple)
			throws Exception 
	{
		Directory directorioIndiceSimple = null;
		List resultado = this.getIndiceDao().buscarIndicePorIdentificador(indice_simple);
		
		if (resultado != null && resultado.size() > 0) 
		{
			Indice indiceSimple = (Indice) resultado.get(0);
			String indiceSimpleDir = indiceSimple.getPath() + File.separator
					+ indiceSimple.getFile_indice();
			directorioIndiceSimple = FSDirectory.getDirectory(indiceSimpleDir);
		} 
		else
		{
			logger.error("No existe el indice para la clave de idioma["+indice_simple+"]");
			throw new Exception("No existe indice para el = " + indice_simple);
		}
		return directorioIndiceSimple;
	}


	/**
	 * Eliminación de todos los documentos de un repositorio de índices
	 * Ademas regenera las sugerencias eliminando los elementos que sobran y regenerandose con los que quedan.
	 * 
	 * @param locale. Nos indica el repositorio del que se quieren eliminar todos los documentos.
	 * @return Número de documentos eliminados
	 * @throws java.lang.Exception
	 */
	private int borradoTodosDocumentos(String locale, es.pode.indexador.negocio.servicios.indexado.IdODEVO[] localizadores) throws java.lang.Exception
	{
		IndexWriter indiceAModificar = null;
		int numDocumentos = 0;
		try 
		{		
			indiceAModificar = this.indiceEscritura(locale);
			if (localizadores != null)
				numDocumentos = localizadores.length;
				
			logger.debug("Numero de documentos: " + numDocumentos); 
				
			for (int i = 0; i < numDocumentos; i++)
			{
				Term terminoABorrar = new Term(props.getProperty("campo_identificadorODE"),localizadores[i].getIdODE());

				logger.debug("terminoABorrar - localizadorODE[" + localizadores[i].getIdODE() + "]"); 
				logger.debug("terminoABorrar[" + terminoABorrar + "]"); 
				indiceAModificar.deleteDocuments(terminoABorrar);
			}
			logger.debug("Se han eliminado " + numDocumentos + " documentos del índice");
			indiceAModificar.flush();
		}
		catch (Exception e) 
		{
			logger.error("Error borrando documentos " + e);
			throw new Exception(e);
		}
		finally 
		{
			if (indiceAModificar != null)
				indiceAModificar.close();
			Directory directorioIndiceSpell = this.indiceSpell(locale);
//			Eliminamos la informacion del spell checker para regenerarla de nuevo
			spellCheckerReset(directorioIndiceSpell);
			spellCheckerAdd(this.getDirectorioPorLocale(locale),directorioIndiceSpell);
		}
		
		return numDocumentos;
	}
				
	

	private String array2String(Object[] array) {
		String str = "";
		if (array != null && array.length > 0) {
			for (int i = 0; i < array.length; i++) {
				str+=array[i].toString();
				if ((i + 1) < array.length) str+= " ";
			}
		}
		return str;
	}
	private boolean existeIndice(File indice)
	{
		if (indice.exists() && indice.canRead() && indice.isDirectory())
		{
			String[] listaFicheros = indice.list();
			for (int i = 0; i < listaFicheros.length; i++) {
				if (listaFicheros[i].startsWith("segments.gen"))
					return true;
			}
		}
		return false;
	}
}
