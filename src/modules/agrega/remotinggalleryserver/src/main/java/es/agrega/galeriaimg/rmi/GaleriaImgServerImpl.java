/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * 
 */
package es.agrega.galeriaimg.rmi;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author aleal
 *
 */
public class GaleriaImgServerImpl implements GaleriaImgServer {

	/**
	 * 
	 */
	private String uploadsPath = null;
	private String htmlScriptPath = null;
	private String imgScriptPath = null;
	private String resizedExtensions = null;
	
	private static Properties props = null;
	
	private static Logger logger = Logger.getLogger(GaleriaImgServerImpl.class);
	
	protected final static String FILE_SEPARATOR="/";

	public GaleriaImgServerImpl() throws RemoteException {
		super();
		try
		{
			if (logger.isDebugEnabled())
				logger.debug("Constructor OK");
		}
		catch (Exception ex)
		{
			logger.error("Constructor Error",ex);
			throw new RemoteException("Constructor Error",ex);
		}
	}

	/* (non-Javadoc)
	 * @see es.agrega.galeriaimg.server.GaleriaImgServer#getImageUrlForId(java.lang.String)
	 */
	public void getImageUrlForId(String identifier,String mainFile,String serverOn) throws Exception /*throws RemoteException*/ {
		String sPath = null;
		try
		{
			sPath = this.getTotalPath(serverOn,identifier);
			if (!existsURL(sPath))
			{
				logger.debug("La URL no existe y vamos a crear la imagen del identificador["+identifier+"]");
				this.scriptExecute(identifier, mainFile,serverOn,this.mustBeResizeImage(mainFile));
				logger.debug("Vamos a ejecutar el script");
			}
            else
                logger.debug("No se crea la imagen por que ya existe");
		}
		catch (Exception ex)
		{
			logger.error("Se ha producido un error en el path ["+sPath+"]", ex);
			throw ex;
		}
	}

	/* (non-Javadoc)
	 * @see es.agrega.galeriaimg.server.GaleriaImgServer#getImagesUrlsForIds(java.lang.String[])
	 */
	public void getImagesUrlsForIds(String[] identifiers, String[] mainFiles, String serverOn) throws Exception {
		if (identifiers != null && identifiers.length > 0)
		{
			for (int i=0; i < identifiers.length; i++)
			{
				try
				{
					this.getImageUrlForId(identifiers[i],mainFiles[i], serverOn);
				}
				catch (Exception ex)
				{
					logger.error("No se ha podido generar la imagen para el identificador ["+identifiers[i]+"]", ex);
					throw ex;
					
				}
			}
		}
	}
	
	private boolean mustBeResizeImage(String sMainFile)
	{
		boolean mustBeResized = false;
		// Cojo la extensión del fichero y si está 
		//en la lista de posible de posibles imagenes
		//devuelvo true.
		if (logger.isDebugEnabled())
			logger.debug("Chequeamos la extension del MainFile["+sMainFile+"]");
		String[] arrayExtensions = this.getResizedExtensions().split(",");
		String extension = sMainFile.substring(sMainFile.lastIndexOf('.')+1);
		if (logger.isDebugEnabled())
			logger.debug("La extensión del MainFile es ["+extension+"]");
		//Chequeo si existe en la lista
		if (arrayExtensions != null && arrayExtensions.length >0 && extension != null && !extension.equals(""))
		{
			for (int i = 0; i < arrayExtensions.length && !mustBeResized; i++)
			{
				mustBeResized = arrayExtensions[i].equalsIgnoreCase(extension);
			}
		}
		if (logger.isDebugEnabled())
			logger.debug("Se debe redimensionar? ["+mustBeResized+"]");
		return mustBeResized;
	}
	
	private boolean existsURL(String sPath) throws Exception
	{
		boolean exists = false;
		try
		{
			File directorio = new File(sPath);
			if (logger.isDebugEnabled())
				logger.debug("Se chequea el path["+sPath+"]");
			exists = directorio.isDirectory() && directorio.exists();
			if (logger.isDebugEnabled())
				logger.debug("El path["+sPath+"] existe ["+exists+"]");
		}
		catch (Exception ex)
		{
			logger.error("Se ha producido un error al chequear el path["+sPath+"]",ex);
			throw ex;
		}
		return exists;
	}
	
	private String getTotalPath(String serverOn, String sIdentifier) throws Exception
	{
		StringBuffer sb = new StringBuffer();
		sb.append(this.getUploadsPath());
		sb.append(GaleriaImgServerImpl.FILE_SEPARATOR);
		sb.append(serverOn);
		sb.append(GaleriaImgServerImpl.FILE_SEPARATOR);
		sb.append(getMD5(sIdentifier).substring(0, 2));
		sb.append(GaleriaImgServerImpl.FILE_SEPARATOR);
		sb.append(sIdentifier);
		sb.append(GaleriaImgServerImpl.FILE_SEPARATOR);
		return sb.toString();
	}
	
	private String getMainFileTotalPath(String serverOn, String mainFile) throws Exception
	{
		StringBuffer sb = new StringBuffer();
		sb.append(this.getProperty(serverOn+".path"));
		sb.append(GaleriaImgServerImpl.FILE_SEPARATOR);
		sb.append(mainFile);
		if (logger.isDebugEnabled())
			logger.debug("El fichero que vamos a capturar es ["+sb+"]");

		return sb.toString();
	}
	
	private synchronized void scriptExecute(String identifier, String mainFile, String serverOn, boolean mustBeResized) throws Exception
	{
		String[] cmdarray = new String[5];
		try
		{
			if (mustBeResized)
				cmdarray[0]=this.getImgScriptPath();
			else
				cmdarray[0]=this.getHtmlScriptPath();

			if (logger.isDebugEnabled())
				logger.debug("Vamos a ejecutar el script ["+cmdarray[0]+"] con parámetros id="+identifier+" mainfile = "+mainFile);

			cmdarray[1]=identifier;
			cmdarray[2]=mainFile;
			cmdarray[3]=serverOn;

			/*
			 * Extract a thumbnail destination path prefix from the image file
			 * path, to meet the image URL that the search results expect.
			 *
			 * eg
			 * 
			 * "29042009/5f/es-sx_20090429_1_9185833/People/images/group photo.jpg"
			 * yields the prefix "5f/es-sx_20090429_1_9185833".
			 */
			cmdarray[4]=mainFile.replaceFirst(
					"^.*/([^/]+)/(es-sx_[0-9]+_[0-9]+_[0-9]+)/.*$", "$1/$2");

			if (logger.isDebugEnabled()) {
				logger.debug("Executing script: " +	Arrays.toString(cmdarray));
			}

			Process process = Runtime.getRuntime().exec(cmdarray);
			if (logger.isDebugEnabled())
				logger.debug("hemos ejecutado el proceso ["+process.getClass()+"]");

			if (logger.isTraceEnabled())
			{
				traceScript(process.getInputStream(), "STDOUT");
				traceScript(process.getErrorStream(), "STDERR");
			}

            // check for ls failure
             if (process.waitFor() != 0) {
                    logger.error("exit value = " + process.exitValue());
                }
		}
		catch (Exception ex)
		{
			logger.error("Se ha producido un error al ejecutar el script [" + cmdarray[0] + "]", ex);
			throw ex;
		}
	}
	
	private String getProperty(String sKey) throws Exception
	{
		String sReturn = null;
		try
		{
			if (props == null)
			{
				props = new Properties();
				props.load(this.getClass().getResourceAsStream("/agrega.properties"));
			}
			
			sReturn = props.getProperty(sKey);
		}
		catch (Exception ex)
		{
			logger.error("Se ha producido un error al ejecutar el script [" + this.getHtmlScriptPath() + "]", ex);
			throw ex;
		}
		return sReturn;
	}
	
	public static void main(String[] args) {
		try
		{
	        String[] paths = {"server-applicationContext.xml"};
	        new ClassPathXmlApplicationContext(paths);
	        if (logger.isDebugEnabled())
	        	logger.debug("Contexto cargado....");
			if (logger.isDebugEnabled())
				logger.debug("El servidor está listo");
		}
		catch(Exception e1)
		{
			logger.error("Se ha producido un error al intentar ejecutar el servidor",e1);
		}
	}

	public String getHtmlScriptPath() {
		return htmlScriptPath;
	}

	public void setHtmlScriptPath(String scriptPath) {
		this.htmlScriptPath = scriptPath;
	}

	public String getUploadsPath() {
		return uploadsPath;
	}

	public void setUploadsPath(String uploadsPath) {
		this.uploadsPath = uploadsPath;
	}

	public String getImgScriptPath() {
		return imgScriptPath;
	}

	public void setImgScriptPath(String imgScriptPath) {
		this.imgScriptPath = imgScriptPath;
	}

	public String getResizedExtensions() {
		return resizedExtensions;
	}

	public void setResizedExtensions(String resizedExtensions) {
		this.resizedExtensions = resizedExtensions;
	}

	private String getMD5(String input){
		String res = "";
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(input.getBytes());
			byte[] md5 = algorithm.digest();
			String tmp = "";
			for (int i = 0; i < md5.length; i++) {
				tmp = (Integer.toHexString(0xFF & md5[i]));
				if (tmp.length() == 1) {
					res += "0" + tmp;
				} else {
					res += tmp;
				}
			}
		} catch (NoSuchAlgorithmException ex) {}
		return res;
    }

	private void traceScript(InputStream processInStream, String streamName)
			throws IOException {
		BufferedReader in = new BufferedReader(
				new InputStreamReader(processInStream));

		String line = null;
		while ((line = in.readLine()) != null) {
			logger.trace(streamName + "> " + line);
		}
	}
}
