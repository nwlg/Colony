/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.buscar.negocio.buscar.pool;

import org.apache.log4j.Logger;

import es.pode.buscar.negocio.buscar.servicios.ParametrosBusquedaAvanzadaVO;
import es.pode.buscar.negocio.buscar.servicios.ParametrosDocsCountVO;
import es.pode.buscar.negocio.buscar.servicios.SrvBuscarServiceImpl;
import es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaImportService;
import es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaServiceServiceLocator;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

/**
 * A thread subclass for searching a single searchable 
 */
public class MultiSearcherThread extends Thread {

	private Logger logger = Logger.getLogger(this.getClass());
	private Exception ex;
	private Object result;
	private String node;
	private String serverPort;
	private String urlService;
	private Object params;
	private Object syncObject;
	private boolean done;
	boolean running;
	private boolean stopped;
  
	public MultiSearcherThread() {
	    
	}

	 /**
	 * Método de ejecución del hilo.
	 * @param node El nodo de la federación sobre el que se ejecuta.
	 * @param port el puerto del nodo.
	 * @param urlService La URL del servicio al que se llama.
	 * @param params Parámetros necesarios para hacer la llamada.
	 */
	public synchronized void execute(String node, String port, String urlService, Object params, Object synObj) {
        if(logger.isDebugEnabled()) logger.debug("Se ejecuta el hilo");
		this.node = node;
		this.serverPort = port;
		this.urlService = urlService;
		this.params = params;
		this.syncObject = synObj;
		this.done = false;
        if(logger.isDebugEnabled())
            logger.debug("done false: Id: " + this.toString() + " direccion: " + this.getAdress());
		if (!running) { //Si es la primera ejecución, lanza el hilo
            if(logger.isDebugEnabled())
                logger.debug("Primera vez que se ejecuta el hilo. Id: " + this.toString());
	        this.setDaemon(false);
	        this.start();
		} else { // Ya teníamos un hilo corriendo, así que lo despertamos
            if(logger.isDebugEnabled())
                logger.debug("No es la primera vez que se ejecuta el hilo notifyAll. Id: " + this.toString());
			this.notifyAll();
		}
	}
	
	private void execute() throws Exception{
		es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaServiceService srvBuscarFederadaService = new SrvBuscarFederadaServiceServiceLocator();
	    ((SrvBuscarFederadaServiceServiceLocator)srvBuscarFederadaService).setSrvBuscarFederadaServiceAddress(this.getAdress());
	    SrvBuscarFederadaImportService port = srvBuscarFederadaService.getSrvBuscarFederadaService();
        if(logger.isDebugEnabled())
	        logger.debug(this.getAdress()+" #### srvBuscarFederadaEndPointAddress del fichero --> " + srvBuscarFederadaService.getSrvBuscarFederadaServiceAddress());
	    if(ParametrosBusquedaAvanzadaVO.class.equals(this.params.getClass()))this.result = port.busquedaFederada((ParametrosBusquedaAvanzadaVO)this.params);
	    else if(ParametrosDocsCountVO.class.equals(this.params.getClass())) this.result = port.solicitarDocsCountArbolCurricular((ParametrosDocsCountVO)this.params);
        if(logger.isDebugEnabled())
            logger.debug(this.getAdress()+" #### Execution Result OK= " + result);
	}
	
	/**
	 * Método de ejecución del hilo.
	 */
	public void run(){
		running = true;
	    while (!stopped) { // El hilo sigue corriendo.
	    	if (done) { // We are waiting for a task now.
	    		synchronized (this) {
	    			try {
                        if(logger.isDebugEnabled())
	    				    logger.debug("Wait until we get a task to execute. Id: " + this.toString());
	    				this.wait(); //Wait until we get a task to execute.
	    			} catch (InterruptedException e) {
	    				stopped = true;
	    				logger.error("Run InterruptedException =" + this.getAdress(), e);
	    			}
	            }
	         } else { //There is a task....let us execute it.
	    		try {
                    if(logger.isDebugEnabled())
	    			    logger.debug("Se ejecuta Id: " + this.toString());
	        		 execute();
	        	 } catch (Exception e) {
	        		 logger.error("#### Run exception ="+this.getAdress() ,e);
	        	 } finally {
	        		 reset();
	        	 }
	         }
	    }
	}
	
 	/**
	 * Método para poner a null los parámetros de ejecución del hilo.
	 */
	public void reset() {
        if(logger.isDebugEnabled())
		    logger.debug("reset()");
		this.done = true;
		this.node = null;
		this.serverPort = null;
		this.urlService = null;
		this.params = null;
		this.syncObject = null;
	}

	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}

    public Object getResult() {
    	return result;
	}
	
	  
	public Exception getException() {
		return ex;
	}

	public Object getMethodParams() {
		return params;
	}

	public void setMethodParams(Object params) {
		this.params = params;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public boolean isStopped() {
		return stopped;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Object getParams() {
		return params;
	}

	public void setParams(Object params) {
		this.params = params;
	}

	public String getServerPort() {
		return serverPort;
	}

	public void setServerPort(String port) {
		this.serverPort = port;
	}

	public Object getSyncObject() {
		return syncObject;
	}

	public void setSyncObject(Object syncObject) {
		this.syncObject = syncObject;
	}

	public String getUrlService() {
		return urlService;
	}

	public void setUrlService(String urlService) {
		this.urlService = urlService;
	}
	
	private String getAdress() {
		if(this.serverPort!=null && !this.serverPort.trim().equals(""))return "http://"+this.node+((this.serverPort!=null && !this.serverPort.equals(""))?":"+this.serverPort:"")+((this.node.equals(SrvBuscarServiceImpl.LOCALHOST))?LdapUserDetailsUtils.getSubdominioServices():"")+this.urlService;
		else return "http://"+this.node+this.urlService;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}
}
