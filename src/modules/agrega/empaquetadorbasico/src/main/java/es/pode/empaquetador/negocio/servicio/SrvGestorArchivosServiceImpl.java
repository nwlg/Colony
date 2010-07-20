/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point

package es.pode.empaquetador.negocio.servicio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

import es.pode.empaquetador.negocio.gestionficheros.FicheroDao;
import es.pode.empaquetador.negocio.utilidades.Utilidades;
import es.pode.localizador.negocio.servicios.LocalizadorVO;
import es.pode.soporte.utiles.ficheros.UtilesFicheros;

/**
 * @see es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService
 */

public class SrvGestorArchivosServiceImpl extends
		es.pode.empaquetador.negocio.servicio.SrvGestorArchivosServiceBase
{

	private FicheroDao ficheroDao;
	private Logger logger = Logger.getLogger(this.getClass());
	private Utilidades utilidades = null;


	public SrvGestorArchivosServiceImpl() {
		super();
		
	}
	/**
	 * Crea una carpeta en la localización del ODE en que se está trabajando.
	 * 
	 * @param identificador
	 *            Identificador del ODE en que se esta trabajando
	 * @param carpetaPadre
	 *            Nombre de la carpeta donde se desea crear la nueva carpeta. Si
	 *            es null, se crea en la localización principal del ODE.
	 * @param fichero
	 *            Nombre de la carpeta que se desea crear.
	 * @throws Exception
	 */
	protected void handleCrearCarpeta(java.lang.String identificador,
			java.lang.String carpetaPadre, java.lang.String nombreCarpeta)
			throws java.lang.Exception
	{

				
		LocalizadorVO localizador = this.getSrvLocalizadorService().consultaLocalizador(identificador);
		String path;
		
		// compruebo si la carpeta padre es null
		if (carpetaPadre == null)
		{
			path = localizador.getPath();
		} 
		else
		{

			path = localizador.getPath().concat("/").concat(carpetaPadre);
		}

		File directorio = new File(path, nombreCarpeta);

		// si la carpeta "nombreCarpeta" no existe, la creo

//		if (nombreCarpeta == "")
		/* dgonzalezd: String comparison with "==" does not work*/
		if (nombreCarpeta.equals(""))
		{
			throw new AlmacenamientoException("La carpeta no tiene nombre");
		} 
		else
		{
			if (!directorio.exists())
			{
				logger.debug("Vamos a crear la carpeta"+directorio);
				directorio.mkdir();
			} 
			else
			{
				throw new AlmacenamientoException("La carpeta que intenta crear ya existe");
			}
		}

	}

	/**
	 * Almacena un fichero recibido como argumento (DataHandler) en la carpeta
	 * especificada dentro de la localización del ODE identificado por
	 * identificador.
	 * 
	 * @param identificador
	 *            Identificador del ODE en que se esta trabajando.
	 * @param carpetaPadre
	 *            Ruta relativa a la localizacion del ODE en la que se desea
	 *            almacenar el archivo. Si se deja a null, la carpeta es la
	 *            localización del ODE.
	 * @param fichero
	 *            Value Object que contiene el nombre del fichero a almacenar y
	 *            los datos en forma de objeto javax.activation.DataHandler
	 * @throws Exception
	 */
	protected void handleCrearArchivo(java.lang.String identificador,
			java.lang.String carpetaPadre,
			es.pode.empaquetador.negocio.servicio.FicheroVO fichero)
			throws java.lang.Exception
	{
		
		LocalizadorVO localizador = this.getSrvLocalizadorService().consultaLocalizador(identificador);
		String path;

		// compruebo si la carpeta padre es null
		if (carpetaPadre == null)
		{
			logger.debug("La carpetaPadre en handleCrearArchivo es null");
			path = localizador.getPath();
		} 
		else
		{
			logger.debug("La carpetaPadre en handleCrearArchivo es"+carpetaPadre);
			path = localizador.getPath().concat("/").concat(carpetaPadre);
		}

		File ficheroFile = new File(path, fichero.getNombre());
		if(ficheroFile.isDirectory()) {
			// Existe una carpeta con el mismo nombre: no se puede crear el archivo
			String msg = "No se puede crear el archivo " + ficheroFile.getPath() + ". Existe un directorio con el mismo nombre";
			if(logger.isDebugEnabled()) logger.error(msg);
			throw new SobreescrituraException(msg);
		} else {
			ficheroFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(ficheroFile);
			fichero.getDatos().writeTo(fos);
			fos.close();
		}
	}

	/**
	 * Modifica el nombre del fichero o carpeta deseado.
	 * 
	 * @param identificador
	 *            Identificador del ODE en que se esta trabajando.
	 * @param carpetaPadre
	 *            Carpeta que contiene el fichero/carpeta a cambiar.
	 * @param nombre
	 *            Nombre del fichero / carpeta a renombrar
	 * @param nuevoNombre
	 *            Nuevo nombre del fichero / carpeta a cambiar.
	 * @throws Exception
	 */
	protected void handleRenombrar(java.lang.String identificador,
			java.lang.String carpetaPadre, java.lang.String nombre,
			java.lang.String nuevoNombre) throws java.lang.Exception
	{
		
		LocalizadorVO localizador = this.getSrvLocalizadorService().consultaLocalizador(identificador);
		String path;
		
		if(nombre.trim().equals("")) {
			logger.error("El parametro nombre es una cadena vacia");
			throw new AlmacenamientoException("El parametro nombre es una cadena vacia");
		}
		if(nuevoNombre.trim().equals("")) {
			logger.error("El parametro nuevoNombre es una cadena vacia");
			throw new AlmacenamientoException("El parametro nuevoNombre es una cadena vacia");
		}
		
				
		// compruebo si la carpeta padre es null
		if (carpetaPadre == null)
		{
			logger.debug("La carpetaPadre en handleRenombrar es null");
			path = localizador.getPath();
		} 
		else
			if(carpetaPadre.trim().equals("")) {
				logger.debug("El parametro carpetaPadre es una cadena vacia");
				throw new AlmacenamientoException("El parametro carpetaPadre es una cadena vacia");
			}
		else
		{
			logger.debug("La carpetaPadre en handleRenombrar es"+carpetaPadre);
			path = localizador.getPath().concat("/").concat(carpetaPadre);
		}
		
		
		File directorio = new File(path, nombre);
		File directorio2 = new File(path, nuevoNombre);
		if(logger.isDebugEnabled()) logger.debug("Comprobaciones de renombrar; existe " + directorio.getPath() + "? " + directorio.exists() + " , " + directorio2.getPath() + "? " + directorio2.exists());
		// compruebo si existe el directorio al que quiero cambiar el nombre y
		// que el nuevo nombre no exista ya
		
		if (directorio.exists() && !directorio2.exists())
		{
			logger.debug("El directorio "+directorio+" existe");
			directorio.renameTo(directorio2);

		} 
		else
			if (directorio2.exists())
			{
				throw new AlmacenamientoException("Ya existe un archivo con el nombre que se desea escribir");
			}	
			else
			{
				logger.debug("El directorio / fichero que se desea renombrar no existe");
				throw new AlmacenamientoException("El directorio / fichero que se desea renombrar no existe");
			}
			
	}

	/**
	 * Descomprime el archivo
	 * 
	 * @param identificador
	 *            Identificador del ODE en que se esta trabajando.
	 * @param carpetaPadre
	 *            Ruta relativa a la localización del ODE donde se descomprimen
	 *            los contenidos del archivo.
	 * @param archivo
	 *            Objeto con el archivo comprimido serializado en un
	 *            javax.activation.DataHandler.
	 * @throws Exception
	 */
	protected void handleDescomprimirArchivo(java.lang.String identificador,java.lang.String carpetaPadre,
			es.pode.empaquetador.negocio.servicio.FicheroVO archivo)throws java.lang.Exception
	{

		try
		{
			LocalizadorVO localizador = this.getSrvLocalizadorService().consultaLocalizador(identificador);
			//String path=localizador.getPath()+"/"+props.getProperty("carpeta.temporal") +"/"+archivo.getNombre();
			
			String path=localizador.getPath();
			String carpetaTemporal = utilidades.getProperty("carpeta.temporal");
			File temp=new File(path+"/"+carpetaTemporal);
			temp.mkdir();
					
			File nuevoFichero = new File(path+"/"+carpetaTemporal+"/"+archivo.getNombre());
			nuevoFichero.createNewFile();
			FileOutputStream fos = new FileOutputStream(nuevoFichero);
			archivo.getDatos().writeTo(fos);
			fos.close();
			
			if (this.getZipDao().esZip(nuevoFichero.getPath()) && nuevoFichero.exists())
			{
				String nombreSinExtension = utilidades.nombreSinExtension(archivo.getNombre());
				String pathPadre = carpetaPadre == null ? nombreSinExtension : carpetaPadre.concat("/").concat(nombreSinExtension);
				java.io.File destino = utilidades.crearCarpetaSeguro(localizador, pathPadre);
				if(logger.isDebugEnabled()) logger.debug("Descomprimiendo a " + destino.getPath());
				this.getZipDao().descomprimir(nuevoFichero.getPath(), destino.getPath());
			}
			else
			{
				if (!this.getZipDao().esZip(nuevoFichero.getPath()))
				{
					logger.debug("el fichero no es .zip");
					throw new NoEsZipException("es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService.descomprimirArchivo(java.lang.String identificador, java.lang.String carpetaPadre, es.pode.empaquetador.negocio.servicio.FicheroVO archivo) - 'archivo' no es un fichero ZIP");
				}
				else
				{
					logger.debug("el fichero"+nuevoFichero.getPath()+"no existe");
					throw new FicheroInexistenteException("es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService.descomprimirArchivo(java.lang.String identificador, java.lang.String carpetaPadre, es.pode.empaquetador.negocio.servicio.FicheroVO archivo) - 'archivo' no existe");
				}
			}

		} 
		catch (IOException e) 
		{
			logger.warn("Fallo al descomprimir el fichero ");
		}
	}

	/**
	 * Elimina los ficheros / carpetas deseados.
	 * 
	 * @param identificador
	 *            Identificador del ODE en que se está trabajando.
	 * @param ficheros
	 *            Lista de ficheros / carpetas a eliminar.
	 * @throws Exception
	 */
	protected void handleEliminar(java.lang.String identificador,
			es.pode.empaquetador.negocio.servicio.ArchivoVO[] ficheros)
			throws java.lang.Exception
	{
		LocalizadorVO localizador = this.getSrvLocalizadorService()
				.consultaLocalizador(identificador);
		String path;

		for (int i = 0; i < ficheros.length; i++)
		{
			if(ficheros[i].getCarpetaPadre()!=null)
			{
			path = localizador.getPath().concat(
					"/" + ficheros[i].getCarpetaPadre());
			}
			else
			{
				path = localizador.getPath()+"/";
			}
			if (!(path/*.toString()*/.equals("")))
			{
				logger.debug("El path no es distinto de blanco");
				File ficheroFile = new File(path, ficheros[i].getNombre());

				// si el fichero existe lo borra
				logger.debug("Se llama UtilesFicheros.eliminar");
				UtilesFicheros.eliminar(ficheroFile);

			}
		}
	}
	
	/**
	 * Devuelve un listado de los contenidos de una carpeta.
	 * 
	 * @param identificador
	 *            Identificador del ODE en que se esta trabajando.
	 * @param carpetaPadre
	 *            Carpeta donde se desea obtener el listado. En caso de que sea
	 *            null, se devuelve el listado de archivos de la localizacion
	 *            del ODE.
	 * @throws Exception
	 */
	protected es.pode.empaquetador.negocio.servicio.ArchivoVO[] handleListar(
			java.lang.String identificador, java.lang.String carpetaPadre)
			throws java.lang.Exception
	{

		LocalizadorVO localizador = this.getSrvLocalizadorService()
				.consultaLocalizador(identificador);
		String path;
//		Boolean esFichero = null;

		if (carpetaPadre == null)
		{
			logger.debug("La carpetaPadre en handleListar es null");
			path = localizador.getPath();
		} 
		else
		{
			logger.debug("La carpetaPadre en handleListar es "+carpetaPadre);
			path = localizador.getPath().concat("/").concat(carpetaPadre);
		}

		File directorio = new File(path);
		File[] archivoAListar = directorio.listFiles();
		ArchivoVO[] lista = new ArchivoVO[archivoAListar.length];
//		ArrayList lista = new ArrayList();

		logger.debug("Recorremos la lista File[]de "+archivoAListar.length+" elementos");
		for (int i = 0; i < archivoAListar.length; i++)
		{
			ArchivoVO tmp = new ArchivoVO();
			tmp.setCarpetaPadre(carpetaPadre);
			tmp.setNombre(archivoAListar[i].getName());
			//Comprobamos si es fichero protegido
			tmp.setEsProtegido(chequearProtegido(tmp));

			if (carpetaPadre == null) {
				tmp.setHref(localizador.getUrl() + "/"
						+ archivoAListar[i].getName());
			} else {
				tmp.setHref(localizador.getUrl() + "/" + carpetaPadre + "/"
						+ archivoAListar[i].getName());
			}
			if (archivoAListar[i].isFile()) {
				logger.debug("el archivo" + tmp.getNombre()
						+ " es un fichero");
				tmp.setEsFichero(Boolean.TRUE);
			} else {
				logger.debug("El archivo " + tmp.getNombre()
						+ " NO es un fichero");
				ArchivoVO nodo = this.crearElementoArbol(localizador, archivoAListar[i], carpetaPadre);
				tmp.setEsFichero(Boolean.FALSE);
				tmp.setContenidos(nodo.getContenidos());
				
			}
			 lista[i] = tmp;
		}
		return lista;
	}
	
	/**
	 * Copia los ficheros / carpetas a la localización especificada.
	 * 
	 * @param identificador
	 *            Identificador del ODE en que se está trabajando.
	 * @param carpetaDestino
	 *            Ruta relativa a la localizacion del ODE en que se esta
	 *            trabajando donde se desean copiar los ficheros / carpetas.
	 * @param ficheros
	 *            Ficheros / carpetas que se desean copiar.
	 * @throws Exception
	 */
	protected void handleCopiar(java.lang.String identificador,
			java.lang.String carpetaDestino,
			es.pode.empaquetador.negocio.servicio.ArchivoVO[] ficheros)
			throws java.lang.Exception
	{
		LocalizadorVO localizador = this.getSrvLocalizadorService()
				.consultaLocalizador(identificador);
		String carpetaOrigen;

		if (carpetaDestino == null || carpetaDestino.equals(""))
		{
			logger.debug("la carpeta destino es null o vacia");
			carpetaDestino = localizador.getPath();
		} 
		else
		{
			logger.debug("la carpeta destino es "+carpetaDestino);
			carpetaDestino = localizador.getPath().concat("/" + carpetaDestino);
		}
		
		File directorio = new File(carpetaDestino);

		if (!directorio.exists())
		{
			throw new AlmacenamientoException("No existe la carpeta destino");
		}

		for (int i = 0; i < ficheros.length; i++)
		{
			if(ficheros[i].getCarpetaPadre()!=null)
			{
				carpetaOrigen = localizador.getPath().concat("/" + ficheros[i].getCarpetaPadre());
			}
			else
			{
				carpetaOrigen=localizador.getPath().concat("/");
			}
			if (!(carpetaOrigen/*.toString()*/.equals("")))
			{
				File ficheroFileO = new File(carpetaOrigen, ficheros[i].getNombre());
				File ficheroFileD = new File(carpetaDestino, ficheros[i].getNombre());
				// si el fichero existe lo borra
				if (ficheroFileO.exists())
				{
					logger.debug("El fichero origen "+ficheroFileO+"existe");
					UtilesFicheros.copiar(ficheroFileO, ficheroFileD);
				}
			}
		}
	}

	/**
	 * Copiar los ficheros / carpetas especificados a la carpeta de destino
	 * deseada. A continuación elimina los ficheros / carpetas de origen con una
	 * llamada a eliminar.
	 * 
	 * @param identificador
	 *            Identificador del ODE en que estamos trabajando.
	 * @param carpetaDestino
	 *            Ruta relativa a la localizacion del ODE en que se esta
	 *            trabajando donde se desean copiar los ficheros / carpetas.
	 * @param ficheros
	 *            Ficheros / carpetas que se desean copiar.
	 * @throws Exception
	 */
	protected void handleCortar(java.lang.String identificador,
			java.lang.String carpetaDestino,
			es.pode.empaquetador.negocio.servicio.ArchivoVO[] ficheros)
			throws java.lang.Exception
	{
		LocalizadorVO localizador = this.getSrvLocalizadorService()
				.consultaLocalizador(identificador);
		String pathO;
		String pathD;

		if (carpetaDestino == null || carpetaDestino.equals(""))
		{
			logger.debug("la carpeta destino es null o vacia");
			pathD = localizador.getPath().concat("/");
		} 
		else
		{
			logger.debug("la carpeta destino es "+carpetaDestino);
			pathD = localizador.getPath().concat("/" + carpetaDestino);
		}

		File directorio = new File(pathD);

		if (!directorio.exists())
		{
			throw new AlmacenamientoException("No existe la carpeta destino");
		}

		for (int i = 0; i < ficheros.length; i++)
		{
			if(ficheros[i].getCarpetaPadre()!=null)
			{
				pathO = localizador.getPath().concat("/" + ficheros[i].getCarpetaPadre());
			}
			else
			{
				pathO=localizador.getPath().concat("/");
			}
			
			if (!(pathO/*.toString()*/.equals("")))
			{
				logger.debug("El path origen es distinto de vacio");
				File ficheroFileO = new File(pathO, ficheros[i].getNombre());
				File ficheroFileD = new File(pathD, ficheros[i].getNombre());

				// si el fichero existe lo borra
				if (ficheroFileO.exists())
				{
					logger.debug("El fichero origen existe,"+ficheroFileO+" ,vamos a copiar y despues borrar");
					UtilesFicheros.copiar(ficheroFileO, ficheroFileD);
					UtilesFicheros.eliminar(ficheroFileO);
				}

			}

		}
	}

	/**
	 * Genera un backup en el directorio temporal del localizador. El backup es
	 * un archivo comprimido (ZIP) que contiene todos los archivos del ODE en el
	 * momento en que se ha generado el backup (imsmanifest.xml, esquemas,
	 * submanifiestos y recursos). Si previamente existe un backup, se llama a
	 * eliminarBackup para reemplazarlo.
	 * 
	 * @param identificador
	 *            Identificador del ode que se esta editando
	 * @throws Exception
	 */
	protected void handleGenerarBackup(String identificador) throws java.lang.Exception
	{
		LocalizadorVO localizador = this.getSrvLocalizadorService().consultaLocalizador(identificador);
		String path=localizador.getPath();
		String carpetaTemporal = utilidades.getProperty("carpeta.backups");
		
		File temp=new File(path+"/"+carpetaTemporal);
		
		if (!temp.exists())
		{
			logger.debug("No existe la carpeta backup y la voy a crear");
			temp.mkdir();
		
		}
		logger.debug("existe la carpeta temp ruta;" +temp.getPath());
		// 20081021: Cambiamos backup en ZIP por backup descomprimido. El uso de 
		// truezip produce problemas de rendimiento
		String zipName = path+"/"+carpetaTemporal+"/"+localizador.getIdentificador();
		File zipFile = new File(zipName);
		if(zipFile.exists()) {
			logger.debug("Borrando el viejo backup");
			UtilesFicheros.eliminar(zipFile);
		}
		logger.debug("voy a copiar el fichero: "+path+" en: "+zipFile.getPath());
		if(!zipFile.exists()) zipFile.mkdirs();
		UtilesFicheros.copiar(new File(path), zipFile);
		//this.getZipDao().comprimir(path+"/"+carpetaTemporal+"/"+localizador.getIdentificador()+".zip", path);
		
	}

	
	private boolean existeBackup(String ficheroComprimido, String identificador) {
		boolean test = (new File(ficheroComprimido)).isDirectory();
		if(!test) {
			logger.warn("El backup del ODE " + identificador +  " no esta generado");
		}
		return test;
	}
	
	/**
	 * Elimina el fichero de backup del ODE en edición.
	 * 
	 * @param identificador
	 *            Identificador del ode que se esta editando
	 * @throws Exception
	 */
	protected void handleEliminarBackup(String identificador) throws java.lang.Exception
	{
		LocalizadorVO localizador = this.getSrvLocalizadorService().consultaLocalizador(identificador);
		String path=localizador.getPath();
		String carpetaTemporal = utilidades.getProperty("carpeta.backups");
		
		File temp=new File(path+"/"+carpetaTemporal);
		String ficheroComprimido=temp.getPath()+"/"+localizador.getIdentificador();
		//String ficheroComprimido=path+"/"+carpetaTemporal+"/"+localizador.getIdentificador()+".zip";
		logger.debug("existe la carpeta temp ruta;" +temp.getPath());
		logger.debug("Voy a eliminar el zip");
		if (existeBackup(ficheroComprimido, identificador))
		{
			
			UtilesFicheros.eliminar(new File(ficheroComprimido));
			
		}
	}

	/**
	 * Descomprime el contenido del fichero de backup a la localización del ODE.
	 * Previamente borra cualquier fichero / carpeta que esté en dicha
	 * localización.
	 * 
	 * @param identificador
	 *            Identificador del ode que se esta editando.
	 * @throws Exception
	 */
	protected void handleRestaurarBackup(String identificador) throws java.lang.Exception
	{
		LocalizadorVO localizador = this.getSrvLocalizadorService().consultaLocalizador(identificador);
		String path=localizador.getPath();
		String carpetaBackup = utilidades.getProperty("carpeta.backups");
		
		String ficheroComprimido=path+"/"+carpetaBackup+"/"+localizador.getIdentificador();
		
		File listadoDestino=new File(path);	
		
		if (existeBackup(ficheroComprimido, identificador) )
		{
			if(logger.isDebugEnabled()) logger.debug("El backup " + ficheroComprimido + " existe. Elimino el contenido del ODE para restaurar.");
				
			UtilesFicheros.eliminar(listadoDestino);
			boolean result = listadoDestino.mkdirs();
			if(logger.isDebugEnabled()) logger.debug("Carpeta de ODE rehecha (resultado =" + result + ")");
			logger.debug("voy a descomprimir el fichero "+ficheroComprimido+" en "+listadoDestino.getPath());
			UtilesFicheros.copiar(new File(ficheroComprimido), listadoDestino);
			//this.getZipDao().descomprimir(ficheroComprimido, listadoDestino.getPath());
		}
		else
		{
			logger.debug("el fichero que intenta descomprimir no existe o no es carpeta: "+ficheroComprimido);
			throw new AlmacenamientoException("El fichero que intenta descomprimir no existe o no es carpeta");

		}	
	}

	private ArchivoVO crearElementoArbol(LocalizadorVO localizador,
			File fichero, String carpetaPadre)
	{

		ArchivoVO resultado = new ArchivoVO();
		resultado.setNombre(fichero.getName());
		String carpetaPadre2 = null;
		
		if (carpetaPadre!=null)
		{
			resultado.setHref(localizador.getUrl() + "/" + carpetaPadre +"/"+fichero.getName());
		}
		else
		{
			resultado.setHref(localizador.getUrl() + "/"+fichero.getName()) ;
		}
		// si no es carpeta
		if (fichero.isFile())
		{
			logger.debug("el subarchivo "+fichero.getName()+" NO es una carpeta");
			resultado.setEsFichero(Boolean.TRUE);
		} 
		else if (fichero.isDirectory())
		{
			// es un directorio?
			logger.debug("el archivo "+fichero.getName()+" es una carpeta");
			File[] archivoAListar = fichero.listFiles();
			resultado.setEsFichero(Boolean.FALSE);
			ArchivoVO[] lista = new ArchivoVO[archivoAListar.length];
			for (int i = 0; i < archivoAListar.length; i++)
			{
				
				if(carpetaPadre == null) carpetaPadre2=fichero.getName();
				else carpetaPadre2=carpetaPadre + "/"+fichero.getName();
				logger.debug("vamos a la llamada recursiva numero "+i+" con el archivo "+archivoAListar[i].getName()+
								" y la carpeta padre"+carpetaPadre);
				
				ArchivoVO tmp = crearElementoArbol(localizador,archivoAListar[i], carpetaPadre2);
				lista[i] = tmp;
			}
			
			resultado.setContenidos(lista);
		}
		resultado.setCarpetaPadre(carpetaPadre);
		resultado.setEsProtegido(chequearProtegido(resultado));
		return resultado;
	}

	/**
	 * Devuelve un ArchivoVO representando la raiz de la localización del ODE.
	 * El objeto devuelto contiene la estructura en árbol de todos los archivos
	 * pertenecientes al ODE. Para ello, examina la raiz del ODE listando de
	 * forma recursiva cada carpeta y generando los ArchivoVO correspondientes.
	 * 
	 * @param identificador
	 *            Identificador del ode que se esta editando
	 * @return ArchivoVO representando la raiz de la localización del ODE
	 * @throws Exception
	 */
	protected es.pode.empaquetador.negocio.servicio.ArchivoVO handleRecuperarArbol(
			String identificador) throws java.lang.Exception
	{
		LocalizadorVO localizador = this.getSrvLocalizadorService().consultaLocalizador(identificador);
		String path;
//		Boolean esFichero = null;

		path = localizador.getPath();

		File directorio = new File(path);
		File[] archivoAListar = directorio.listFiles();
		ArchivoVO[] lista = new ArchivoVO[archivoAListar.length];
		ArchivoVO resultado = new ArchivoVO();
		resultado.setNombre(identificador);
		resultado.setEsFichero(Boolean.FALSE);
		resultado.setHref(localizador.getUrl());

		for (int i = 0; i < archivoAListar.length; i++)
		{
			ArchivoVO tmp = new ArchivoVO();
			//if (tmp.getEsFichero() == esFichero.TRUE)
			if (archivoAListar[i].isFile())
			{
				logger.debug("el archivo "+archivoAListar[i].getName()+" NO es una carpeta");
				tmp.setNombre(archivoAListar[i].getName());
				tmp.setHref(localizador.getUrl() + "/"
						+ archivoAListar[i].getName());
				tmp.setEsFichero(Boolean.TRUE);
			} 
			else
			{
				// es un directorio?
				if (archivoAListar[i].isDirectory())
				{
					logger.debug("el archivo "+archivoAListar[i].getName()+" es una carpeta");
					ArchivoVO subcarpeta = crearElementoArbol(localizador,archivoAListar[i], null);
					tmp.setNombre(subcarpeta.getNombre());
					tmp.setEsFichero(subcarpeta.getEsFichero());
					tmp.setHref(subcarpeta.getHref());
					tmp.setContenidos(subcarpeta.getContenidos());
					
				}
			}
			tmp.setEsProtegido(chequearProtegido(tmp));
			lista[i] = tmp;
		}

		resultado.setContenidos(lista);
		resultado.setEsProtegido(chequearProtegido(resultado));
		return resultado;
	}

	/**
	 * @return the ficheroDao
	 */
	public FicheroDao getFicheroDao()
	{
		return ficheroDao;
	}

	/**
	 * @param ficheroDao the ficheroDao to set
	 */
	public void setFicheroDao(FicheroDao ficheroDao)
	{
		this.ficheroDao = ficheroDao;
	}
	
	/**
	 * Comprueba si el fichero es uno de los básicos para la estructura del Ode.
	 * @param fichero Fichero a comprobar
	 * @param rutaLocalizador TODO
	 * @return True si es protegido
	 */
	private Boolean chequearProtegido(ArchivoVO fichero) {
//		Boolean result = null;
		if (fichero == null) {
			throw new NullPointerException("fichero::ArchivoVO null en chequearProtegido");
		}
		String href = null;
		if(fichero.getCarpetaPadre()==null) href="";
		else href=fichero.getCarpetaPadre().concat("/");

		return chequearProtegido(href.concat(fichero.getNombre()));

	}
	
	private Boolean chequearProtegido(String href) {
		Boolean result = Boolean.FALSE;
		String rutaSchemas =utilidades.getProperty("carpeta.schema");
		// Compruebo si el href que me pasan coincide con uno de los schemas almacenado en el servidor
		if(href!=null) {
			if(href.equals(Utilidades.MANIFEST_NAME)) {
				result = Boolean.TRUE;
			} else {
				File fichero = new File(rutaSchemas,href);
				result = Boolean.valueOf(fichero.exists());
			}
		}
		logger.debug("El fichero " + href + " tiene esProtegido = " + result.booleanValue());
		return result;
	}

	/**
	 * @return the utilidades
	 */
	public Utilidades getUtilidades() {
		return utilidades;
	}

	/**
	 * @param utilidades the utilidades to set
	 */
	public void setUtilidades(Utilidades utilidades) {
		this.utilidades = utilidades;
	}
	@Override
	protected Boolean handleConsultaCuota(String identificador, Long espacioLibre, Long espacioOdeInicio) throws Exception {
		Long espacioActualOde = this.getSrvLocalizadorService().calculaEspacioLocalizador(identificador);
		Long aumento = espacioActualOde - espacioOdeInicio;
		if (espacioLibre >= aumento)
			return Boolean.TRUE;
		else
			return Boolean.FALSE;
	}


}