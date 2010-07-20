/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * 
 */
package es.pode.soporte.zip;

/**
 * Interfaz que ofrece los métodos necesarios para la gestión de archivos
 * comprimidos.
 * 
 * @author fjespino
 * 
 */
public interface ZipDao {

	/**
	 * Descomprime el archivo <em>rutaArchivo</em> en la localizacion definida
	 * por <em>rutaDestino</em>.
	 * 
	 * @param rutaArchivo
	 * @param rutaDestino
	 */
	public void descomprimir(String rutaArchivo, String rutaDestino)
			throws ZipDaoException;

	/**
	 * Comprime todos los ficheros / carpetas bajo <em>rutaOrigen</em> en el
	 * archivo comprimido <em>rutaArchivo</em>. Las entradas se crean con
	 * rutas relativas a <em>rutaOrigen</em>.
	 * 
	 * @param rutaArchivo
	 * @param rutaOrigen
	 */
	public void comprimir(String rutaArchivo, String rutaOrigen)
			throws ZipDaoException;

	/**
	 * 
	 * Comprime todos los ficheros / carpetas bajo <em>rutaOrigen</em> en el
	 * archivo comprimido <em>rutaArchivo</em> excluyendo los ficheros /
	 * carpetas del array <em>exclude</em>. Los fichero a excluir son rutas
	 * relativas a <em>rutaOrigen</em>.
	 * 
	 * @param rutaArchivo
	 * @param rutaOrigen
	 * @param exclude
	 * @throws ZipDaoException
	 * @throws Exception 
	 */
	public void comprimir(String rutaArchivo, String rutaOrigen,
			String[] exclude) throws ZipDaoException, Exception;

	/**
	 * Comprueba la existencia del fichero / carpeta <em>entrada</em> en el
	 * archivo comprimido <em>archivo</em>.
	 * 
	 * @param entrada
	 * @param archivo
	 * @return True si la entrada existe en el archivo, False en caso contrario.
	 */
	public boolean chequearEntrada(String entrada, String archivo);

	/**
	 * Comprueba si el fichero <em>archivo</em> es un archivo comprimido que
	 * pueda ser gestionado por este DAO.
	 * 
	 * @param archivo
	 * @return True si el archivo es un archivo comprimido compatible, False en
	 *         caso contrario.
	 */
	public boolean esZip(String archivo);

	/**
	 * Extrae un fichero contenido en un archivo a la carpeta destino
	 * especificada. Si la entrada del fichero especifica una ruta relativa, se
	 * creará la ruta bajo la carpeta destino.
	 * 
	 * @param fichero
	 *            Fichero a extraer.
	 * @param archivo
	 *            Archivo comprimido.
	 * @param destino
	 *            Carpeta destino donde extraer el fichero (si la entrada del
	 *            fichero especifica una ruta relativa, se creará la ruta bajo
	 *            la carpeta destino).
	 */
	public void extraerFichero(String fichero, String archivo, String destino);
}
