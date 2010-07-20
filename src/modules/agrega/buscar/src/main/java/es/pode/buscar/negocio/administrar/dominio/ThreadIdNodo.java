/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.buscar.negocio.administrar.dominio;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

import es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaImportService;
import es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaServiceServiceLocator;

public class ThreadIdNodo implements Runnable {
	
	private static Logger log = Logger.getLogger(ThreadIdNodo.class);
	
	private es.pode.buscar.negocio.administrar.servicio.NodoVO nodo = null;
    private String result = null;
    private String address = null;
    
    public es.pode.buscar.negocio.administrar.servicio.NodoVO getNodo() {
		return nodo;
	}
	public void setNodo(es.pode.buscar.negocio.administrar.servicio.NodoVO nodo) {
		this.nodo = nodo;
	}		    	
	public String getResult() {
		return result;
	}
	public void setResult (String result) {
		this.result = result;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress (String address) {
		this.address = address;
	}
        // This method is called when the thread runs
        public void run()
        {	    	
        	SrvBuscarFederadaImportService port = null;
	         log.debug("La url del nodo del que queremos obtener el idNodo es ["+address+"]");
	         es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaServiceService srvBuscarFederadaService = new SrvBuscarFederadaServiceServiceLocator();
	         ((SrvBuscarFederadaServiceServiceLocator)srvBuscarFederadaService).setSrvBuscarFederadaServiceAddress(address);
	         try {
				port = srvBuscarFederadaService.getSrvBuscarFederadaService();
			} catch (ServiceException e) {				
				e.printStackTrace();
			}
	         log.debug(address+" #### srvBuscarFederadaEndPointAddress del fichero --> " + srvBuscarFederadaService.getSrvBuscarFederadaServiceAddress());

	         try {
	        	 this.result = port.obtenerIdentificadorNodo();
	         } catch (RemoteException e) {	        	 
	        	 e.printStackTrace();
	         }	         
	         log.debug(address+" #### Execution Result OK= " + result);
//	         try {
//				Thread.sleep(30000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
        }
}


