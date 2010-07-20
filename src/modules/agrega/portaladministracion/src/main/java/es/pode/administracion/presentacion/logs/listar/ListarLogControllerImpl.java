/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.logs.listar;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.contenidos.negocio.logs.servicio.FileVO;
import es.pode.contenidos.negocio.logs.servicio.SrvLogService;



/**
 * @see es.pode.administracion.presentacion.logs.listar.ListarLogController
 */
public class ListarLogControllerImpl extends ListarLogController
{


	private static Logger log = Logger.getLogger(ListarLogControllerImpl.class);

	static java.util.Properties pLogsProperties = null;
	public static final String FILE_NAME_PROPERTIES = "/agrega.properties";
	private static String no_borrar = getPropertyValue("logs_no_borrar");
	final int BUFFER_SIZE = 2048;


    /**
     * @see es.pode.administracion.presentacion.logs.listar.ListarLogController#listarLogs(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.logs.listar.ListarLogsForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void listarLogs(ActionMapping mapping, es.pode.administracion.presentacion.logs.listar.ListarLogsForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        	
    	try{
    		
			SrvLogService logService = this.getSrvLogService();
    		FileVO[] logs = logService.listarFicherosLog();
    		form.setLogsAsArray(logs);
    	}catch (Exception e){
        	log.error("Se ha producido un error al listar los ficheros de log: " + e);
        	throw new ValidatorException ("{errors.listarlogs}");
    	}
     }



    /**
     * @see es.pode.administracion.presentacion.logs.listar.ListarLogController#getLogs(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.logs.listar.GetLogsForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void getLogs(ActionMapping mapping, es.pode.administracion.presentacion.logs.listar.GetLogsForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	    	
    	try{
    		List lista = ((FormularioListadoLogsEliminarFormImpl)form).getNombreRowSelection();
    		if (lista == null){
    			throw new ValidatorException ("{errors.eliminarlogs.nombreNulo}");
	       }

    		// TODO el server.log no se borra
    		String[] logsNoBorrar = no_borrar.split(",");
    		List errores = new ArrayList();
    		for (int i=0; i<logsNoBorrar.length; i++){
				if (lista.contains(logsNoBorrar[i])){
					errores.add(logsNoBorrar[i]);
				}
    		}
    		if (errores.size()>0){
    			log.error("no se pueden borrar los siguientes ficheros: " + errores);
				throw new ValidatorException ("{errors.eliminarlogs.noBorrar}");
    		}
	
	    	form.setIds(lista);
	    	if(log.isDebugEnabled())log.debug("Se van a eliminar los siguientes ficheros de log: " + lista);
    	} catch (ValidatorException e){
    		throw e;
    	} catch (Exception e){
    		log.error("Se ha producido un error al intentar recuperar los ids de los ficheros de log a borrar: " +e);
    	}

     }



	private static String getPropertyValue(String sKey) 
    {
        String sReturn = null;
        try 
        {
            if (pLogsProperties == null)
           {
               InputStream fIsSpringProperties = ListarLogControllerImpl.class.getResourceAsStream(FILE_NAME_PROPERTIES);
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
    
	public final void recuperarFicheroLog(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.logs.listar.RecuperarFicheroLogForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception{
		try{
			String fichero = (String)form.getNombre();
			DataHandler dataHandler = null;
			SrvLogService logService = this.getSrvLogService();
			try {
				dataHandler = logService.recuperarFicheroLog(fichero);
				
				
			}catch (Exception e){
				log.error("Error al recuperar el fichero");
			}
			if (dataHandler==null){
				log.error("El fichero recuperado está vacio");
				throw new ValidatorException("{recuperarFicheroLog.FALLO}");
			}
			if (fichero.endsWith(".log")){
				response.setContentType("application/text");
			} else {
				response.setContentType("application/zip");
			}
			response.setHeader("Content-Disposition", "attachment;filename="+fichero);
			OutputStream out = response.getOutputStream();
			InputStream in = dataHandler.getInputStream();
			if(log.isDebugEnabled())log.debug("recuperando el fichero " + fichero);
			byte[] buffer = new byte[BUFFER_SIZE];
			int count;
			while((count = in.read(buffer, 0, BUFFER_SIZE))!= -1)
			{
				out.write(buffer, 0, count);
			}
			
			out.flush();
			out.close();
			
		} catch (ValidatorException e){
			throw e;
		} catch (Exception e){
			log.error("Se ha producido el siguiente error: " +e);
			throw e;
		}
    	
    }


	
	

}