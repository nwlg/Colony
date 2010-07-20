/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.utiles.ficheros;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;

import es.pode.soporte.zip.TrueZipDaoImpl;


public class UtilesFicheros 
{
	private static Logger logger = Logger.getLogger(UtilesFicheros.class);

	/**
	 * Explora el path proporcionado en busca de una lista de paths apuntando a
	 * ODEs. Los criterios para considerar un path como ODE son:
	 * <ul>
	 * <li>El path apunta a un ZIP</li>
	 * <li>El path apunta a un directorio conteniendo un imsmanifest.xml</li>
	 * </ul>
	 * 
	 * @param path	Path de la carpeta que se desea explorar
	 * @param recursivo	Si es true, se interna en las subcarpetas para localizar ODEs
	 * @param soloZip Solo considera ODEs los ficheros ZIP
	 * @return Array de los paths que se consideran ODEs dentro del path proporcionado
	 * @throws NullPointerException Si path es null
	 */
	public static String[] obtenerOdesDePath(String path, Boolean recursivo, Boolean soloZip) {
		
		if (logger.isDebugEnabled())
			logger.debug("Explorando " + path
					+ " en busca de odes con opciones recursivo = " + recursivo
					+ " y soloZip = " + soloZip);
		if(path==null) throw new NullPointerException("path==null");
		ArrayList<String> listaPaths = new ArrayList<String>();
		
		java.io.File fPath = new java.io.File(path);
		if(!fPath.isDirectory()) {
			logger.warn("El path " + path + " no es un directorio");
		} else {
			TrueZipDaoImpl zipDao = new TrueZipDaoImpl();
			java.io.File[] subPaths = fPath.listFiles();
			for(int i=0;i<subPaths.length;i++) {
				if(subPaths[i].isDirectory()) {
					// Comprobar si esta entrada tiene un imsmanifest.xml. En
					// caso contrario, internarse si recursivo=true
					String[] manifiestos = subPaths[i].list(new FilenameFilter() {
						public boolean accept(File path, String name) {
							return "imsmanifest.xml".equals(name);
						}
					});
					if(!soloZip && manifiestos!=null && manifiestos.length > 0) {
						// El path corresponde a un posible ODE descomprimido
						if(logger.isDebugEnabled()) logger.debug("El path " + subPaths[i] + " es un posible ODE descomprimido");
						listaPaths.add(subPaths[i].getPath());					
					}
					else if(recursivo){ 
						// Explora la subcarpeta en busca de odes
						if(logger.isDebugEnabled()) logger.debug("El path " + subPaths[i] + " no es un ODE. Exploro contenidos de la carpeta");
						listaPaths.addAll(Arrays.asList(obtenerOdesDePath(subPaths[i].getPath(), recursivo, soloZip)));
					} else if(logger.isDebugEnabled()) logger.debug("El path " + subPaths[i] + " no es un ODE");
				} else if(zipDao.esZip(subPaths[i].getPath())) {
					if(logger.isDebugEnabled()) logger.debug("El path " + subPaths[i] + " es un posible ODE comprimido");
					listaPaths.add(subPaths[i].getPath());
				} else {
					if(logger.isDebugEnabled()) logger.debug("El path " + subPaths[i] + " no es un ODE");
				}
			}
		}
		
		return listaPaths.toArray(new String[listaPaths.size()]);
	}
	
	
	public static void eliminar(File fichero) throws Exception 
	{
		if (fichero.exists())
		{
			// es un directorio?
			if (fichero.isDirectory()) 
			{
				// cargamos los archivos del directorio en un array
				File[] archivoEliminar = fichero.listFiles();
				// eliminamos elementos del array
				for (int i = 0; i < archivoEliminar.length; i++) 
				{
					UtilesFicheros.eliminar(archivoEliminar[i]);
				}
				// eliminamos directorio
				fichero.delete();
			} 
			else 
			{
				fichero.delete();
			}
		}
	}
	
	
    public static void copiar(File oldDir, File newDir) throws Exception 
    {
    	try{
    	if (oldDir.isDirectory())
    	{
    		newDir.mkdirs();
    		String list[] = oldDir.list();

    		for (int i = 0; i < list.length; i++)
    		{
    			String dest1 = newDir.getAbsolutePath() + "/" + list[i];
    			String src1 = oldDir.getAbsolutePath() + "/" + list[i];
    			copiar(new File(src1), new File(dest1));
    		}
    	}
    	else if (oldDir.isFile() && newDir.isDirectory())
      	{
      		FileInputStream fin = new FileInputStream(oldDir);
      		FileOutputStream fos = new FileOutputStream (newDir.getPath()+"/"+oldDir.getName());
      		
      		FileChannel sourceChannel = fin.getChannel();
      		FileChannel targetChannel = fos.getChannel();
      		sourceChannel.transferTo(0, sourceChannel.size(), targetChannel);
      		sourceChannel.close();
      		targetChannel.close();
  	    
      	} 
    	else if (oldDir.isFile())
    	{
    		FileInputStream fin = new FileInputStream(oldDir);
    		FileOutputStream fos = new FileOutputStream (newDir);
    		
    		FileChannel sourceChannel = fin.getChannel();
    	    FileChannel targetChannel = fos.getChannel();
    	    sourceChannel.transferTo(0, sourceChannel.size(), targetChannel);
    	    sourceChannel.close();
    	    targetChannel.close();
      	}
    	
    	}catch(Exception e){
      		throw new Exception ("Estas intentando copiar un directorio en un archivo (OldDir: " + 
			oldDir.getAbsolutePath() + ", NewDir: " + newDir.getAbsolutePath() + ")" ,e);
      	}
    }
    
    /**
     * Este método copia un fichero identificado por su URL a un fichero en disco
     * 
     * */
    public static void copiarFileFormURI(String address, String localFileName) throws Exception 
    {
    	try{
    	OutputStream out = null;
		URLConnection conn = null;
		InputStream  in = null;
		try {
			URL url = new URL(address);
			out = new BufferedOutputStream(
				new FileOutputStream(localFileName));
			conn = url.openConnection();
			in = conn.getInputStream();
			byte[] buffer = new byte[1024];
			int numRead;
			long numWritten = 0;
			while ((numRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, numRead);
				numWritten += numRead;
			}
			if(logger.isDebugEnabled()) logger.debug(localFileName + "\t" + numWritten);
		} catch (Exception exception) {
			throw new Exception ("Error escribiendo fichero [ "+localFileName+" ] ",exception);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException ioe) {
				throw new Exception ("Error cerrando ficheros [ "+in+" o "+out+" ]", ioe);
			}
		}

    	
//    		oldDir.exists();
//    		oldDir.canRead();
//    		FileInputStream fin = new FileInputStream(oldDir);
//    		FileOutputStream fos = new FileOutputStream (newDir);
//    		
//    		FileChannel sourceChannel = fin.getChannel();
//    	    FileChannel targetChannel = fos.getChannel();
//    	    sourceChannel.transferTo(0, sourceChannel.size(), targetChannel);
//    	    sourceChannel.close();
//    	    targetChannel.close();
    	}catch(Exception e){
      		throw new Exception ("Estas intentando copiar un directorio en un archivo",e);
      	}
    }
}
