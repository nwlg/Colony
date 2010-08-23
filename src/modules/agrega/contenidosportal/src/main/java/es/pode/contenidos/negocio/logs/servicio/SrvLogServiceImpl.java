/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.contenidos.negocio.logs.servicio;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.log4j.Logger;


/**
 * @see es.pode.contenidos.negocio.logs.servicio.SrvLogService
 */

public class SrvLogServiceImpl extends
		es.pode.contenidos.negocio.logs.servicio.SrvLogServiceBase {

	private static Logger log = Logger.getLogger(SrvLogServiceImpl.class);
	private static String pathLogsDir = null;
	static java.util.Properties pLogsProperties = null;
	public static final String FILE_NAME_PROPERTIES = "/agrega.properties";

	/**
	 * Devuelve un listado con los archivos de log generados por el sistema
	 * 
	 * @return listadoLog FileVO[] con los datos de los archivos de log
	 * @throws Exception
	 */
	protected es.pode.contenidos.negocio.logs.servicio.FileVO[] handleListarFicherosLog()
			throws java.lang.Exception {

		File fpathLogsDir = new File(pathLogsDir);
		FileVO[] listadoLog = null;
		try{
			if (!fpathLogsDir.exists()) {
				log.error("[ListarFicherosLog] Error: El directorio " + pathLogsDir + " no existe");
			} else {
	
				// Recorremos el directorio donde estan los ficheros de Log
				File[] arrayList = fpathLogsDir.listFiles();
				List ficheros = new ArrayList();
				File ficheroTemp = null;
				
				//creamos una lista con los ficheros para ordenarlos por nombre
				List nombres = new ArrayList();
				// Por cada fichero encontrado creamos el VO con su nombre, el path
				// y el tamaño en KB
				for (int i = 0; i < arrayList.length; i++) {
					try{
						ficheroTemp = arrayList[i];
						FileVO fileVO = new FileVO();
						fileVO.setNombre(ficheroTemp.getName());
						fileVO.setSize(ficheroTemp.length() / 1024);
						ficheros.add(fileVO);
						nombres.add(ficheroTemp.getName());
					} catch (Exception e){
						log.error("[ListarFicherosLog] Error: Se ha producido un error con un fichero de log: " + e);
					}
				}
				Collections.sort(nombres);
				listadoLog = (FileVO[]) ordenarLista(nombres, ficheros);
			}
		} catch (Exception e){
			log.error("se ha producido una excepción al intentar listar los ficheros de log" + e);
			throw e;
		}
		return listadoLog;

	}
	
	/**
	 * Devuelve una lista de ficheros ordenada
	 * 
	 * @param	listaOrdenada
	 * 					lista ordenada con los nombres de los ficheros
	 * @param	listaDesordenada
	 * 					lista desordenada con los datos de los ficheros
	 * @return listadoLog FileVO[] en orden alfabético
	 * @throws Exception
	 */
	private FileVO[] ordenarLista (List listaOrdenada, List listaDesordenada) throws Exception{
		try{
		FileVO[] filesOrdenado = new FileVO[listaDesordenada.size()];
			int posicion=0;
			for (int i=0; i<listaDesordenada.size();i++){
				posicion = listaOrdenada.indexOf(((FileVO)listaDesordenada.get(i)).getNombre().toLowerCase());
				filesOrdenado[posicion]= (FileVO)listaDesordenada.get(i);
			}
			return filesOrdenado;
		} catch (Exception e){
			log.error("[ListarFicherosLog] Error: Se ha producido un error al ordernar la lista de log: " + e);
			throw e;
		}

	}


	/**
	 * Elimina del sistema los ficheros de log seleccionados
	 * 
	 * @param	ficheros
	 * 					String[] nombres de los ficheros a eliminar
	 * @return validaBajaLogVO ValidaBajaLogVO contiene el resultado del 
	 * proceso de baja y los nombres de los ficheros borrados. 
	 * @throws Exception
	 */
	protected es.pode.contenidos.negocio.logs.servicio.ValidaBajaLogVO handleEliminarFicheroLog(
			String[] ficheros) throws java.lang.Exception {

		List ficherosBorrados = new ArrayList();
		ValidaBajaLogVO validaBajaLogVO = new ValidaBajaLogVO();
		File fichero = null;
		String ruta = pathLogsDir; 
		if (!pathLogsDir.endsWith(fichero.separator)){
			ruta = ruta + fichero.separator;
		}
			
		try{
			if (ficheros != null) {
				for (int i = 0; i < ficheros.length; i++) {
					fichero = new File(ruta + ficheros[i]);
					if (fichero.delete()){
						ficherosBorrados.add(ficheros[i]);
					} else {
						log.error("no se ha podido eliminar el siguiente fichero de log: " + ficheros[i]);
					}
				}
				validaBajaLogVO.setDescripcionBaja("ficherosBorrados.OK");
			} else {
				validaBajaLogVO.setDescripcionBaja("ficherosBorrados.FALLO");
			}
		} catch (Exception e){
			log.error("se ha producido una excepción al borrar los ficheros de log :" +e);
			validaBajaLogVO.setDescripcionBaja("ficherosBorrados.FALLO");
		}
		validaBajaLogVO.setLogsBorrados((String[])ficherosBorrados.toArray(new String[0]));
		return validaBajaLogVO;
	}
	
	public SrvLogServiceImpl(){
		super();
		pathLogsDir = getPropertyValue("path_logs");
	}
	
	/**
	 * Recupera un valor del fichero de propiedades
	 * 
	 * @param	sKey
	 * 					String código de la propiedad que se quiere recuperar
	 * @return sReturn String con el valor de la propiedad
	 */
	private static String getPropertyValue(String sKey) 
    {
        String sReturn = null;
        try 
        {
            if (pLogsProperties == null)
           {
               InputStream fIsSpringProperties = SrvLogServiceImpl.class.getResourceAsStream(FILE_NAME_PROPERTIES);
               pLogsProperties = new java.util.Properties();
               pLogsProperties.load(fIsSpringProperties);
           }
           sReturn = pLogsProperties.getProperty(sKey); 
        } 
        catch (IOException e) 
        {
           log.error(e);
        }
        return sReturn;
    }

	/**
	 * Recupera el contenido de un fichero de log para poder ser visualizado.
	 * 
	 * @param	fichero
	 * 					String nombre del fichero de log a recuperar
	 * @return dataHandler DataHandler con el contenido del fichero de log
	 * @throws Exception
	 */
	protected DataHandler handleRecuperarFicheroLog(String fichero) throws Exception {
		
		File file = null;
		String ruta = pathLogsDir; 
		if (!pathLogsDir.endsWith(file.separator)){
			ruta = ruta + file.separator;
		} 
		file = new File(ruta + fichero);
		
		if (!file.exists())
		{
			log.error("El fichero " + file.getAbsolutePath() + "  ha sido borrado o movido");
			throw new Exception ("el fichero ha sido borrado o movido");
		}
		
		FileDataSource fileDS = new FileDataSource(file);
		DataHandler dataHandler = new DataHandler(fileDS);
		
		return dataHandler;
	}


	private void log (Object obj)
	{
		if (log.isDebugEnabled())
			log.debug(obj);
	}

	

}