/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.buscar.negocio.monitorizar.pool;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.log4j.Logger;

/**
 * A thread subclass for searching a single searchable 
 */
public class MultiSearcherThread extends Thread {

	private Logger logger = Logger.getLogger(this.getClass());
	private Exception ex;
	private String result;
	private String urlService;
	private boolean done;
	boolean running;
	private boolean stopped;
  
	public MultiSearcherThread() {
	    
	}

	 /**
	 * Método de ejecución del hilo.
	 * @param urlService La URL del servicio al que se llama.
	 */
	public synchronized void execute(String urlService) {
		this.urlService = urlService;
		this.done = false;
		if (!running) { //Si es la primera ejecución, lanza el hilo
	        this.setDaemon(false);
	        this.start();
		} else { // Ya teníamos un hilo corriendo, así que lo despertamos
			this.notifyAll();
		}
	}
	
	private void execute() throws Exception{	
    	
//        		miramos si está levantado
            Service service = new Service();
            Call call = null;
            try {
                call = (Call) service.createCall();    
        		call.setTargetEndpointAddress( new java.net.URL(this.urlService) );           
        		Object res =  call.invoke("estoyActivo",null);  
        		this.result = "estadoServicio.ACTIVO";
        		logger.info("SERVICIO ACTIVO: " + this.urlService);
            } catch (Exception e) {
            	this.result = "estadoServicio.INACTIVO";
        		logger.info("SERVICIO INACTIVO: " + this.urlService + " --> " +e);
            	
            }
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
	    				this.wait(); //Wait until we get a task to execute.
	    			} catch (InterruptedException e) {
	    				stopped = true;
	    				logger.error("Run InterruptedException =", e);
	    			}
	            }
	         } else { //There is a task....let us execute it.
	        	 try {
	        		 execute();
	        	 } catch (Exception e) {
	        		 logger.error("#### Run exception :"+ e.toString());
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
		this.done = true;
		this.urlService = null;
	}

	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}

   public Exception getException() {
		return ex;
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

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
	
	public String getUrlService() {
		return urlService;
	}

	public void setUrlService(String urlService) {
		this.urlService = urlService;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
