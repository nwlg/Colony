/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.fuentestaxonomicas.negocio.servicio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import org.apache.log4j.Logger;

import es.pode.fuentestaxonomicas.negocio.soporte.VdexComparator;
import es.pode.soporte.i18n.I18n;
import es.pode.validador.negocio.servicio.SrvValidadorVDEXService;
import es.pode.validador.negocio.servicio.ValidaVdexVO;



/**
 * @see es.pode.fuentestaxonomicas.negocio.dominio.SrvEstructurasEducativasService
 * 
 * 
 */

public class SrvEstructurasEducativasServiceImpl
    extends es.pode.fuentestaxonomicas.negocio.servicio.SrvEstructurasEducativasServiceBase
{
	private static Logger logger= Logger.getLogger(SrvEstructurasEducativasService.class);
	private static final String TIPO_TESAURO= "TESAURO";
	private static final String TIPO_TESAURO_BACK= "TESAUROBACK";
	private static final String TIPO_VDEX= "VDEX";
	private static final String TIPO_ARBOL_CURRICULAR= "ARBOL";
	private static final String TIPO_TAXONOMIA_BACK= "TAXONOMIABACK";
	
	private static final String E_GENERICO="0";
	private static final String E_EXISTE="1";
	private static final String E_FORMATO_NOMBRE="2";
	private static final String E_NO_VALIDO="3";

	private static final String SUF_TESAURO= "TES";
	private static final String SUF_TAXONOMIA= "TAX";
	
	
	
	protected Boolean handleChequearIdiomaArbolCurricular
		(String nombre)
	throws Exception {
		
		boolean resultado= false;
		String idioma= obtenerIdioma(nombre);
		if(obtenerFicheroVDEX(idioma,TIPO_ARBOL_CURRICULAR)!=null)
		{
			if(logger.isDebugEnabled()) logger.debug("ya existe un Arbol curricular del mimo idioma del que se intenta subir");
			resultado=true;
		}
		return new Boolean(resultado);
	}

	
	
	
	protected Boolean handleChequearIdiomaTesauro(String nombre)
			throws Exception {
		boolean resultado= false;
		String idioma= obtenerIdioma(nombre);
		if(obtenerFicheroVDEX(idioma,TIPO_TESAURO)!=null)
		{
			if(logger.isDebugEnabled()) logger.debug("ya existe un Tesauro del mismo idioma del que se intenta subir");
			resultado=true;
		}
		return new Boolean(resultado);
	}

	
	/**
	 * Método que permite eliminar una lista de ficheros xml correspondientes a Arboles Curriculares
	 * 
	 * @param nombres array de String conteniendo los nombres de los ficheros que se desean eliminar
	 * @return un array de enteros indicando por cada posición si se pudo eliminar o no el fichero correspondiente
	 */
	protected int[] handleEliminarArbolesCurriculares(String[] nombres) 
	throws Exception 
	{
		int[] resultado= eliminarVdex(nombres,TIPO_ARBOL_CURRICULAR);
		
		boolean sinError=false;
		
		for (int i = 0; i < resultado.length && !sinError; i++) 
		{
			if(resultado[i]>0)
			{
				sinError=true;
				logger.debug("se eliminó el siguiente fichero: " + nombres[i] );
			}
		}
		
		if(sinError)
		{
			logger.debug("llamo a recargar de SrvTaxonomiaService..");
			this.getSrvTaxonomiaService().recargar();
		}
		return resultado;

	}


	/**
	 * Método que permite eliminar una lista de ficheros xml correspondientes a Tesauros
	 * 
	 * @param nombres array de String conteniendo los nombres de los ficheros que se desean eliminar
	 * @return un array de enteros indicando por cada posición si se pudo eliminar o no el fichero correspondiente
	 */
	protected int[] handleEliminarTesauros(String[] nombres) 
	throws Exception 
	{
		int[] resultado= eliminarVdex(nombres,TIPO_TESAURO);
		
		boolean sinError=false;
		
		for (int i = 0; i < resultado.length && !sinError; i++) 
		{
			if(resultado[i]>0)
			{
				sinError=true;
				logger.debug("se eliminó el siguiente fichero: " + nombres[i] );
			}
		}
		
		if(sinError)
		{
			logger.debug("llamo a recargar de SrvTesaurosServices..");
			this.getSrvTesaurosServices().recargar();
		}
		return resultado;

	}
	
	

	
	protected int[] handleEliminarBackups(
			String[] nombres) 
	throws Exception 
	{
		//inicializo un array con los resultados de la eliminación
		int[] resultado = new int[nombres.length];
		
		String sufijo;
		String nombre;
		boolean eliminado;
		
		//recorro el arrya de nombres para llamar al metodo eliminarVDEX
		for (int i = 0; i < nombres.length; i++) 
		{
			eliminado=false;
			sufijo = nombres[i].substring(nombres[i].length() - 3 );
			nombre = nombres[i].substring(0,nombres[i].length() - 3 );
			//verifico que tipo de vdex comprobando el sufijo del nombre
			if(SUF_TESAURO.equals(sufijo))
			{
				eliminado = eliminarVDEX(nombre, TIPO_TESAURO_BACK).booleanValue() ;
			}else{
				eliminado= eliminarVDEX(nombre, TIPO_TAXONOMIA_BACK).booleanValue();
			}
			
			if(eliminado)
				resultado[i]=1;
			else
				resultado[i]=0;
		}
		
		
		boolean sinError=false;
		
		for (int i = 0; i < resultado.length && !sinError; i++) 
		{
			if(resultado[i]>0)
			{
				sinError=true;
				logger.debug("se eliminó el siguiente fichero: " + nombres[i] );
			}
		}
		
		if(sinError)
		{
			logger.debug("llamo a recargar de SrvTesaurosServices..");
			this.getSrvTesaurosServices().recargar();
		}
		return resultado;
	}

	

	/**
	 * Método que permite listar los TESAUROS existentes en la carpeta contenedora.
	 * 
	 * @return Array de VdexVO indicando todos los ficheros xml existentes en la carpeta contenedora. 
	 * 	si no existen ficheros, regresa un array vacio.
	 */
    protected VdexVO[] handleListarTesauros() throws Exception {
		return listarVDEX(TIPO_TESAURO);
	}
	
	

	


	/**
	 * Método que permite listar los ARBOLES CURRICULARES existentes en la carpeta contenedora.
	 * 
	 * @return Array de VdexVO indicando todos los ficheros xml existentes en la carpeta contenedora. 
	 * 	si no existen ficheros, regresa un array vacio.
	 */
	protected VdexVO[] handleListarArbolCurricular() throws Exception {
		return listarVDEX(TIPO_ARBOL_CURRICULAR);
	}

	

	protected VdexVO[] handleListarBackups() 
	throws Exception 
	{
		ArrayList listaVdex= new ArrayList();
		
		VdexVO[] listaTes = listarVDEX(TIPO_TESAURO_BACK);
		listaVdex.addAll(Arrays.asList(listaTes));
		
		VdexVO[] listaTax = listarVDEX(TIPO_TAXONOMIA_BACK);
		listaVdex.addAll(Arrays.asList(listaTax));
		
		VdexVO[] resultado= (VdexVO[]) listaVdex.toArray(new VdexVO[listaVdex.size()]);
		
		Arrays.sort(resultado, new VdexComparator());
		
		return resultado;
	}

	
	
	/**
	 * Método que permite añadir un unevo Arbol Curricular a la carpeta contenedora correspondiente.
	 * Realiza diferentes comprobaciones antes de añadir el nuevo fichero xml.
	 * 
	 * @param arboles  array de ParamVdexVO que empaquetan los ficheros xml que desea añadir
	 * @return regresa un array de VdexVO que contiene en cada posición un objeto VdexVO si se ha 
	 * añadido con éxito al fichero o un  null si no se ha podido añadir el fichero .
	 */
	protected VdexVO[] handleSubirArbolesCurriculares(ParamVdexVO[] arboles) 
	throws Exception 
	{

		VdexVO[] resultado=new VdexVO[arboles.length];
		int i;
		for (i = 0; i < arboles.length; i++) 
		{
			logger.debug("llamo al metodo nuevoVdex para el fichero: " + arboles[i].getNombreFichero());
			resultado[i]= nuevoVDEX(arboles[i].getFicheroXml(), arboles[i].getNombreFichero(), TIPO_ARBOL_CURRICULAR);
		}
		
		boolean hayError=false;
		for (i = 0; i < resultado.length && !hayError; i++) 
		{
			if(!resultado[i].getCodigoError().equals(""))
			{
				hayError=true;
				logger.debug("hubo un error con el siguiente fichero: " + arboles[i].getNombreFichero());
			}
				
		}
		
		if(!hayError)
		{
			logger.debug("no hubo errores, por lo que llamo a recargar de SrvTaxonomiaService..");
			this.getSrvTaxonomiaService().recargar();
		}
		return resultado;

	}


	/**
	 * Método que permite añadir un nuevo Tesauro a la carpeta contenedora correspondiente.
	 * Realiza diferentes comprobaciones antes de añadir el nuevo fichero xml.
	 * 
	 * @param tesauros  array de ParamVdexVO empquetan los ficheros xml que desea añadir
	 * @return regresa un array de VdexVO que contiene en cada posición un objeto VdexVO si se ha 
	 * añadido con éxito al fichero o un  null si no se ha podido añadir el fichero .
	 */

	protected VdexVO[] handleSubirTesauros(ParamVdexVO[] tesauros) 
	throws Exception 
	{
		VdexVO[] resultado=new VdexVO[tesauros.length];
		int i;
		for (i = 0; i < tesauros.length; i++) 
		{
			logger.debug("llamo al metodo nuevoVdex para el fichero: " + tesauros[i].getNombreFichero());
			resultado[i]= nuevoVDEX(tesauros[i].getFicheroXml(), tesauros[i].getNombreFichero(), TIPO_TESAURO);
		}
		
		boolean correcto=false;
		for (i = 0; i < resultado.length && !correcto; i++) 
		{
			if(resultado[i].getCodigoError().equals(""))
			{
				logger.debug("hubo un error con el siguiente fichero: " + tesauros[i].getNombreFichero());
				correcto=true;
			}
		}
		
		if(correcto)
		{
			logger.debug("no hubo errores, por lo que llamo a recargar de SrvTesaurosServices..");
			this.getSrvTesaurosServices().recargar();
		}
		return resultado;

	}


	protected VdexVO[] handleSubirBackups
		(ParamVdexVO[] listaVdex)
	throws Exception 
	{

		VdexVO[] resultado=new VdexVO[listaVdex.length];
		int i;
		for (i = 0; i < listaVdex.length; i++) 
		{
			logger.debug("llamo al metodo nuevoVdex para el fichero: " + listaVdex[i].getNombreFichero());
			
			resultado[i]= nuevoVDEX(listaVdex[i].getFicheroXml(), listaVdex[i].getNombreFichero(), TIPO_VDEX);
		}
		boolean hayError=false;
		for (i = 0; i < resultado.length && !hayError; i++) 
		{
			if(!resultado[i].getCodigoError().equals(""))
			{
				logger.debug("hubo un error con el siguiente fichero: " + listaVdex[i].getNombreFichero());
				hayError=true;
			}
		}
		
		if(!hayError)
		{
			logger.debug("no hubo errores, por lo que llamo a recargar de SrvTaxonomiaService..");
			this.getSrvTaxonomiaService().recargar();
		}

		return resultado;
	}

	
	/**
	 * Método privado que determina si el idioma es uno de los soportados por la plataforma, si es asi,
	 * regresa un String de 2 caracteres correspondiente al idioma. si el parámetro nombre no contiene 
	 * idioma o no es uno de los soportados por la plataforma, regresa un null.
	 * 
	 * @param nombre String que indica el nombre del fichero xml del cual se quiere conocer el idioma
	 * @return String indicando el idioma correspondiente. null si no se puede determinar el idioma en
	 * el nombre del fichero xml.
	 * 
	 */
	private String obtenerIdioma(String nombre) throws Exception
	{
		String idioma=null;
		if(nombre==null || nombre.equals(""))
		{
			if(logger.isDebugEnabled()) logger.debug("no se ha indicado el nombre del fichero xml. regresa null");
			return idioma;
		}
		
		String[] idiomas= I18n.getInstance().obtenerIdiomasPlataforma();
		
		if(idiomas==null || idiomas.length==0)
		{
			if(logger.isDebugEnabled()) logger.debug("No hay idiomas disponibles en la plataforma");
			return idioma;
		}

		String term;
		int dif;
		for (int i = 0; i < idiomas.length && idioma==null; i++) 
		{
			term="_" + idiomas[i]+".xml";
			dif=nombre.length() - term.length();
			if(dif>0 && nombre.substring(dif).equals(term))
				idioma=idiomas[i];
		}
		
		if(idioma!=null){ 
			if(logger.isDebugEnabled()) logger.debug("el idioma del fichero es " + idioma);
		}else
			if(logger.isDebugEnabled()) logger.debug("no se pudo determinar el idioma del fichero");
		
		return idioma;
	}

	
	/**
	 * Método privado que comprueba si existe en la carpeta contenedora correspondiente algun Vdex
	 * del idioma indicado. Regresa un String con el nombre del fichero xml que se 
	 * corresponde con el idioma indicado. si no existe ningun Vdex de ese idioma, regresa null
	 * 
	 * @param idioma String de dos caracteres que indica el idioma que se quiere comprobar
	 * @param tipoVDEX indica el tipo de vdex (tesauro,taxonomia,arbol curricular)
	 * @return String indicando el nombre del fichero xml del Arbol curricular del idioma seleccionado
	 * 	null si no encuentra Arbol curricular del idioma indicado.
	 */
	private String obtenerFicheroVDEX(String idioma,String tipoVDEX) throws Exception
	{
		String resultado= null;
		
		if(idioma==null || idioma.equals(""))
		{
			if(logger.isDebugEnabled()) logger.debug("no se ha indicado el idioma.");
			return resultado;
		}
		String directorio= obtenerCarpetaVdex(tipoVDEX);
		if(directorio==null)
		{
			if(logger.isDebugEnabled()) logger.debug("no se ha podido determinar la carpeta de arboles curriculares.");
			return resultado;
		}
		File carpeta= new File(directorio);
		
		if(carpeta.exists())
		{
			String[] nombres=carpeta.list();
			String term=idioma+".xml";
			for (int i = 0; i < nombres.length && resultado==null; i++) 
			{
				if(nombres[i].substring(nombres[i].length() - term.length()).equals(term))
				{
					if(logger.isDebugEnabled()) logger.debug("vdex del idioma " + idioma + " : " + nombres[i]);
					resultado=nombres[i];
				}
			}
		}
		carpeta=null;
		
		if(resultado==null)
			if(logger.isDebugEnabled()) logger.debug("no se ha encontrado ningun vdex para el idioma " + idioma);
		return resultado;
	}

	
	
	/**
	 * Método privado que permite obtener la carpeta contenedora de ficheros xml de una determinada
	 * estructura educativa.
	 *  
	 * @param tipoVDEX indica el tipo de vdex (tesauro,taxonomia,arbol curricular)
	 * para el cual se solicita la carpeta contenedora.
	 * @return regresa un String con el path de la carpeta contenedora de xml para el tipo de vdex 
	 * seleccionado. regresa null si no puede determinar la carpeta para el tipo vdex indicado
	 */
	private String obtenerCarpetaVdex(String tipoVDEX) throws Exception
	{
		String resultado=null;
		if(tipoVDEX==null || tipoVDEX.equals(""))
		{
			if(logger.isDebugEnabled()) logger.debug("no se ha indicado el tipo de vdex");
			return resultado;
		}
    	InputStream is= this.getClass().getResourceAsStream("/fuentestaxonomicas.properties");
		Properties properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			if(logger.isDebugEnabled()) logger.debug("error IO al cargar las properties  ");
			return resultado;
		}
		
		if(TIPO_TESAURO.equals(tipoVDEX))
		{
			resultado= properties.getProperty("rutaTesauro");
		}else if(TIPO_TESAURO_BACK.equals(tipoVDEX))
		{
			resultado= properties.getProperty("rutaTesauroBackup");
		}else if(TIPO_TAXONOMIA_BACK.equals(tipoVDEX))
		{
			resultado= properties.getProperty("rutaTaxonomia");
		}else if(TIPO_ARBOL_CURRICULAR.equals(tipoVDEX))
		{
			resultado= properties.getProperty("rutaArbolCurricular");
		} 
		
		File carpetaFile= new File(resultado);
		if(!carpetaFile.exists())
		{
			carpetaFile.mkdirs();
		}else{
			if(!carpetaFile.canRead())
				logger.debug("la carpeta " + resultado + " no tiene permisos de escritura.");
		}
		carpetaFile =null;
			
		if(logger.isDebugEnabled()) logger.debug("vdex seleccionado:" + tipoVDEX +" path correspondiente " + resultado);
		return resultado;
	}

	/**
	 * Método privado que permite eliminar una lista de ficheros xml
	 *  de la correspondiente carpeta contenedora. 
	 * 
	 * @param nombres array de String con los nombres de ficheros xml de los vdex que se desea eliminar.
	 * @param tipoVDEX String que indica el tipo de vdex a eliminar.
	 * @return regresa un array de enteros. cada entero tiene 3 posibles valores:
	 *  1 si se pudo eliminar el fichero
	 *  0 si no se pudo eliminar el fichero
	 *  -1 solo en el caso que el tipovdex sea ARBOL y se ha intentado eliminar un arbol correspondiente al idioma castellano
	 */

	private int[] eliminarVdex(String[] nombres,String tipoVDEX)
	throws Exception
	{
		if(nombres==null)
		{
			if(logger.isDebugEnabled()) logger.debug("el listado de arboles es null, regresa un array vacio ");
			return new int[0];
		}
			

		int[] resultado = new int[nombres.length];
		// recorro la lista de nombres
		for (int i = 0; i < nombres.length; i++) 
		{
			if((tipoVDEX.equals(TIPO_ARBOL_CURRICULAR) || tipoVDEX.equals(TIPO_TESAURO) ) && nombres[i].toLowerCase().endsWith("es.xml"))
			{
				// si el tipoVDEX es Arbol Curricular verifico que sea  en español
				// si es asi, no puedo eliminar el fichero y regreso un -1 en esa posicion
				if(logger.isDebugEnabled()) logger.debug("el tipoVDEX es Arbol Curricular o Tesauro y se ha intentado eliminar el idioma Español, por lo que no se elimina el fichero");
				resultado[i]=-1;
			}else{
				if(eliminarVDEX(nombres[i], tipoVDEX).booleanValue())
				{
					//se ha podido eliminar el fichero con exito
					if(logger.isDebugEnabled()) logger.debug("se ha eliminado el fichero : " + nombres[i]);
					resultado[i]=1;
				}
				else
				{
					// no se ha podido eliminar el fichero
					if(logger.isDebugEnabled()) logger.debug("NO SE HA PODIDO ELIMINAR EL FICHERO: " + nombres[i]);
					resultado[i]=0;
				}
			}
		}
		
		return resultado;
	}
	

	/**
	 * Método privado que permite eliminar el fichero xml (corespondiente al vdex indicado)
	 *  de la correspondiente carpeta contenedora. 
	 * 
	 * @param nombre String nombre del fichero xml del vdex que se quiere eliminar.
	 * @param tipoVDEX String que indica el tipo de vdex a eliminar.
	 * @return regresa un True si se pudo eliminar el fichero xml y un false si no se pudo eliminar.
	 */
	private Boolean eliminarVDEX(String nombre,String tipoVDEX) throws Exception
	{
		boolean resultado= false;
		
		if(nombre==null || nombre.equals(""))
		{
			if(logger.isDebugEnabled()) logger.debug("no se ha indicado el nombre del fichero xml.");
			return new Boolean(resultado);
		}
		String directorio= obtenerCarpetaVdex(tipoVDEX);
		if(directorio==null)
		{
			if(logger.isDebugEnabled()) logger.debug("no se ha podido determinar la carpeta contenedora");
			return new Boolean(resultado);
		}
		File fichero= new File( directorio+nombre);
		if(fichero.exists())
		{
			if(logger.isDebugEnabled()) logger.debug("se procede a eliminar el fichero " +  fichero.getAbsolutePath());
			fichero.delete();
			resultado=true;
		}
		fichero=null;
		if(!resultado)
			if(logger.isDebugEnabled()) logger.debug("no se ha podido eliminar el fichero indicado");
		return new Boolean(resultado);
	}




	/**
	 * Método privado que permite listar los ficheros xml existentes en la carpeta contenedora del 
	 * vdex indicado
	 * 
	 * @param tipoVDEX String que indica el tipo de vdex del cual se quiere obtener un listado
	 * @return Array de VdexVO indicando todos los ficheros xml existentes en la carpeta contenedora. 
	 * 	si no existen ficheros, regresa un array vacio.
	 */
	private VdexVO[] listarVDEX(String tipoVDEX) throws Exception
	{
		VdexVO[] listaVdex=new VdexVO[0];
		String directorio= obtenerCarpetaVdex(tipoVDEX);
		if(directorio==null)
		{
			if(logger.isDebugEnabled()) logger.debug("no se ha podido determinar la carpeta contenedora del tipoVdex indicado");
			return listaVdex;
		}
		File fDir= new File(directorio);
		if(fDir.exists() && fDir.isDirectory())
		{	
			String[] lista= fDir.list();
			
			listaVdex =new VdexVO[lista.length];
			for (int i = 0; i < lista.length ; i++) 
			{
				if(logger.isDebugEnabled()) logger.debug("listaVDEX[" + i + "]: " + lista[i]);
				VdexVO vdex= new VdexVO();
				vdex.setNombre(lista[i]);
				vdex.setCodigoError("");
				
				if(TIPO_TESAURO_BACK.equals(tipoVDEX))
				{
					vdex.setSufijo(SUF_TESAURO);
				}else if(TIPO_TAXONOMIA_BACK.equals(tipoVDEX))
				{
					vdex.setSufijo(SUF_TAXONOMIA);
				}
				
				listaVdex[i]=vdex;
			}
		}
		if(listaVdex.length >0)
			if(logger.isDebugEnabled()) logger.debug("la carpeta contenedora está vacia, se devuelve un array vacio");

		Arrays.sort(listaVdex, new VdexComparator());
		
		return listaVdex;
	}
	



	
	/**
	 * Método privado que permite añadir un nuevo Vdex a la carpeta contenedora correspondiente.
	 * Realiza diferentes comprobaciones antes de añadir el nuevo fichero xml.
	 * 
	 * @param dataHandler contenido del fichero xml que se desea añadir
	 * @param nombre String que indica el nombre del fichero xml que se desea añadir
	 * @param tipoVdex  String que indica el tipo de VDEX que se desea añadir
	 * @return regresa siempre objeto VdexVO. si se ha podido añadir el fichero, el campo codigoError esta vacio, 
	 * si no se ha podido añadir el campo codigoError contiene el codigo del error correspondiente 
	 */
	private VdexVO nuevoVDEX(DataHandler dataHandler,String nombre,String tipoVdex) throws Exception
	{
		VdexVO resultado=new VdexVO();
		resultado.setNombre("");
		resultado.setCodigoError("");
		
    	//chequear parametros
    	if(dataHandler==null || nombre==null || nombre.equals(""))
    	{
    		if(logger.isDebugEnabled()) logger.debug("el datahandler es null");
    		resultado.setCodigoError(E_GENERICO);// regreso un error generico
    		return resultado;
    	}
    	//eliminar espacios en el nombre
		nombre= nombre.trim().replaceAll(" ", "_");
    	

		//comprobar si el idioma existe en el nombre y si es un idioma válido
		String idioma=obtenerIdioma(nombre);

		if(idioma==null)
		{
			if(logger.isDebugEnabled()) logger.debug("el fichero no termina con ninguno de los idiomas especificados");
    		resultado.setCodigoError(E_FORMATO_NOMBRE);//regreso un error de formato del nombre
    		return resultado;
		}
    	
    	
    	//copiar el contenido del datahandler en la carpeta temporal
    	InputStream is= this.getClass().getResourceAsStream("/fuentestaxonomicas.properties");
		Properties properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			if(logger.isDebugEnabled()) logger.debug("no se han podido cargar las propiedades.");
    		resultado.setCodigoError(E_GENERICO);//error al leer propiedades
    		return resultado;
		}
        
		String rutaTemp= properties.getProperty("rutaTemp");
		File carpetaTemp= new File(rutaTemp);
		if(!carpetaTemp.exists())
			carpetaTemp.mkdirs();
		
		String rutaXml=rutaTemp + "tmp_"+nombre;
		File vdex=null;
		if(rutaXml!=null && !rutaXml.equals(""))
		{
			if(logger.isDebugEnabled()) logger.debug("se descarga los datos del datahandler a un fichero temporal en la carpeta temporal");
			try{
				vdex= new File(rutaXml);
				vdex.createNewFile();
				vdex.deleteOnExit();
				if(logger.isDebugEnabled()) logger.debug("fichero temporal: " + vdex.getAbsolutePath());
				FileOutputStream fos= new FileOutputStream(vdex.getAbsolutePath());
				dataHandler.writeTo(fos);
				fos.close();
			}catch(FileNotFoundException fnfe)
			{
				logger.debug("no se ha podido crear el fileOutputStream");
	    		resultado.setCodigoError(E_GENERICO);//error al mover el fichero
	    		return resultado;
			}catch(IOException ioe){
				logger.debug("no se ha podido crear el nuevo fichero o llenar el fichero desde el datahandler");
	    		resultado.setCodigoError(E_GENERICO);//error al mover el fichero
	    		return resultado;
			}
		}

		
		ValidaVdexVO valida=null;
		try{
			//validar
			SrvValidadorVDEXService validador = this.getSrvValidadorVDEXService();
			if(TIPO_ARBOL_CURRICULAR.equals(tipoVdex))
			{
				valida =validador.obtenerValidacionTaxonomia( vdex.getAbsolutePath());
			}else if(TIPO_VDEX.equals(tipoVdex))
			{
				valida=validador.obtenerValidacionVdex(vdex.getAbsolutePath());
			}else if(TIPO_TESAURO.equals(tipoVdex))
			{
				valida=validador.obtenerValidacionTesauro(vdex.getAbsolutePath());
			}
			
		}catch(Exception e)
		{
			logger.debug("Exception en la validación, envio error de validación.");
    		resultado.setCodigoError(E_NO_VALIDO);//regreso un error de validacion
    		return resultado;
		}
		
		if(!valida.getValido().booleanValue())
		{
			logger.debug("el vdex no valida, envio error de validación.");
    		resultado.setCodigoError(E_NO_VALIDO);//regreso un error de validacion
    		return resultado;
		}
		// si es un arbol curricular o tesauro, verifico el idioma y, 
		// si existe algun arbol curricular o un terauro con el mismo idioma, 
		// copio ese fichero a la carpeta de taxonomias
		if(TIPO_ARBOL_CURRICULAR.equals(tipoVdex) || TIPO_TESAURO.equals(tipoVdex))
		{
			String vdexExistente=obtenerFicheroVDEX(idioma, tipoVdex);
			
			if(vdexExistente!=null)
			{
				if(logger.isDebugEnabled()) logger.debug("ya existe un vdex con el mismo idioma.");
				//existe, muevo el anterior a taxonomias
				String origen= obtenerCarpetaVdex(tipoVdex )+vdexExistente;
				String carpetaDestino;
				if(TIPO_ARBOL_CURRICULAR.equals(tipoVdex))
					carpetaDestino =obtenerCarpetaVdex(TIPO_TAXONOMIA_BACK);
				else
					carpetaDestino =obtenerCarpetaVdex(TIPO_TESAURO_BACK);
				
				boolean movido = false;
				boolean existe=(buscarVDEX(nombre, tipoVdex)!=null);
				if(!existe)
				{
					movido = moverFichero(origen, carpetaDestino, vdexExistente);
				}
				if(existe )
				{
					logger.debug("El fichero existe.. por lo que lo machaco sin moverlo a la carpeta de taxonomias");
				}else if(!existe && movido)
				{
					logger.debug("se ha movido el fichero con éxito");
				}else {
					logger.debug("el vdex no se ha podido mover a la carpeta de taxonomias por algun motivo.");
		    		resultado.setCodigoError(E_GENERICO);//no se pudo mover el fichero, error interno
		    		return resultado;
				}
			}
			
		}
		
		
		//copiar a la carpeta destino
		String rutaFinal;
		if(TIPO_VDEX.equals(tipoVdex))
		{
			if(valida.getTipoVdex().equals(SUF_TESAURO))
			{
				rutaFinal= obtenerCarpetaVdex(TIPO_TESAURO_BACK);
			}else
			{
				rutaFinal= obtenerCarpetaVdex(TIPO_TAXONOMIA_BACK);
			}
		}else
		{
			rutaFinal= obtenerCarpetaVdex(tipoVdex);
		}
		
		
		String rutaFicheroTemp=vdex.getAbsolutePath();
		boolean subido=moverFichero(rutaFicheroTemp, rutaFinal , nombre);
		if(subido)
		{
			if(logger.isDebugEnabled()) logger.debug("se ha movido el fichero xml a la carpeta contenedora correspondiente");
		}else{
			if(logger.isDebugEnabled()) logger.debug("no se ha podido mover el fichero xml a la carpeta contenedora");
    		resultado.setCodigoError(E_GENERICO);//no se pudo mover el ficheor a la carpeta de arboles curriculares
    		return resultado;
		}
		

		//regresar un vdex
		
		resultado.setNombre(nombre);
        return resultado;
	}

	/**
	 * Metodo privado utilizado para mover ficheros xml a un directorio dado
	 * 
	 * @param fileOrigen path del fichero que se desea mover
	 * @param carpetaDestino path al directorio destino donde se desea mover el fichero
	 * @param nombreFichero nombre que se desea que tenga el fichero en la carpeta destino
	 * @return true si se ha podido mover el fichero; false si no se ha podido mover el fichero
	 */
	private boolean moverFichero(String fileOrigen,String carpetaDestino,String nombreFichero) throws Exception
	{
		boolean resultado;
		File fOrigen= new File(fileOrigen);
		if(logger.isDebugEnabled()) logger.debug("fichero que se va a mover: " + fOrigen.getAbsolutePath());
		File dirDestino=new File(carpetaDestino);
		if(logger.isDebugEnabled()) logger.debug("carpeta destino: " + dirDestino.getAbsolutePath());
		File fileDestino= new File(carpetaDestino + nombreFichero);
		if(logger.isDebugEnabled()) logger.debug("fichero destino: " + fileDestino.getAbsolutePath());
		if(fileDestino.exists())
			fileDestino.delete();
		
		resultado= fOrigen.renameTo(new File(dirDestino,nombreFichero));
		if(resultado)
		{
			if(logger.isDebugEnabled()) logger.debug("el fichero se ha movido con exito ");
		}else
		{
			if(logger.isDebugEnabled()) logger.debug("el fichero no se pudo mover ");
		}
		return resultado;

	}
	
	
	/**
	 * Método privado que permite buscar un fichero xml con el nombre y tipo vdex indicado.
	 * Si encuentra el fichero, regresa un objeto VdexVO con los datos del fichero encontrado, 
	 * si no lo encuentra, regresa null.
	 * 
	 * @param nombre String que indica el nombre del fichero que se quiere recuperar.
	 * @param tipoVDEX String indicando el tipo de VDEX que se quiere buscar
	 * @return VdexVO indicando el nombre del fichero encontrado. regresa null en cualquiel otro caso.
	 */
	private VdexVO buscarVDEX(String nombre, String tipoVDEX) throws Exception
	{
		VdexVO resultado=null;
		if(nombre==null || nombre.equals(""))
		{
			if(logger.isDebugEnabled()) logger.debug("no se a indicado el nombre del vdex");
			return resultado;
		}
		String directorio= obtenerCarpetaVdex(tipoVDEX);
		if(directorio==null)
		{
			if(logger.isDebugEnabled()) logger.debug("no se ha podido determinar la carpeta contenedora del vdex indicado");
			return resultado;
		}
			
		File fDir= new File(directorio);
		if(fDir.exists() && fDir.isDirectory())
		{	
			String[] lista= fDir.list();
			for (int i = 0; i < lista.length && resultado==null; i++) 
			{
				if(nombre.equals(lista[i]))
				{
					if(logger.isDebugEnabled()) logger.debug("se ha encontrado el vdex indicado: " + nombre);
					resultado= new VdexVO();
					resultado.setNombre(nombre);
				}
					
			}
		}
		if(resultado==null ) 
			if(logger.isDebugEnabled()) logger.debug("no se ha podido encontrar el vdex indicado");
		return resultado;
	}
    



	protected DataHandler handleExportarVdex(
			String nombre, 
			TipoVdex tipoVdex)
	throws Exception 
	{
		DataHandler resultado=null;
		try{
			String carpeta=null;
			if(tipoVdex.equals(TipoVdex.ARBOL))
			{
				carpeta= obtenerCarpetaVdex(TIPO_ARBOL_CURRICULAR);
			}else if(tipoVdex.equals(TipoVdex.TESAURO))
			{
				carpeta= obtenerCarpetaVdex(TIPO_TESAURO);
			}else if(tipoVdex.equals(TipoVdex.TAXONOMIA))
			{
				carpeta= obtenerCarpetaVdex(TIPO_TAXONOMIA_BACK);
			}else if(tipoVdex.equals(TipoVdex.TESAURO_BACK))
			{
				carpeta= obtenerCarpetaVdex(TIPO_TESAURO_BACK);
			}
			if(carpeta!=null)
			{
				File fichero = new File(carpeta + nombre);
				if(fichero.exists())
				{
					DataSource ds= new FileDataSource(fichero);
					resultado= new DataHandler(ds);
				}
				fichero=null;
			}
		}catch(Exception e)
		{
			logger.debug("error en exportarVdex: " + e.getMessage());
		}
		
		return resultado;
	}

}