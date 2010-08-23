/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point

package es.pode.publicacion.negocio.servicios;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.log4j.Logger;

import es.agrega.galeriaimg.rmi.GaleriaImgServer;
 

/**
 * @see es.pode.publicacion.negocio.servicios.SrvGaleriaImgService
 * Generated file: es/pode/publicacion/negocio/servicios/SrvGaleriaImgService
 */
public class SrvGaleriaImgServicioImpl
     implements es.pode.publicacion.negocio.servicios.SrvGaleriaImgServicio, MessageListener 
    		
	
{
   
	protected static Logger logger = Logger.getLogger(SrvGaleriaImgServicioImpl.class);

	private es.pode.publicacion.negocio.servicios.SrvPublicacionService srvPublicacionService;
      
	private GaleriaImgServer imgServer = null;
   
  // --------- Default Constructor ----------
    
    public SrvGaleriaImgServicioImpl()
    {
        super();
    }
    /**
	 * Este metodo trata el mensaje que le llega.
	 * @param message El mensaje a tratar
	 * @throws RuntimeException
	 */
     public  void onMessage(Message message) throws RuntimeException 
     {
     
     	 try
    	 {
    		 if (logger.isDebugEnabled())
    			 logger.debug("Begin:onMessage");
	         // Implementation
	    	 if (message instanceof ObjectMessage)
	    	 {
	    		 if (logger.isDebugEnabled())
	    			 logger.debug("Transformo el mensaje");
	    		 ObjectMessage obj = (ObjectMessage) message;
	    		 OdeVO ode = (OdeVO)obj.getObject();
	    		 if (logger.isDebugEnabled())
	    			 logger.debug("El ode es id ["+ode.getIdentificadorMEC()+"] MainFile ["+ode.getMainFile()+"]");
	    		 //Si todo ha ido bien hago la petición RMI pasando el Objeto
	    		 if (logger.isDebugEnabled())
	    			 logger.debug("Solicitud RMI");
	    		 this.generateImage4Id(ode);
	    		 
	    		 if (logger.isDebugEnabled())
	    			 logger.debug("Fin Solicitud RMI");
	    	 }
	    	 else
	    	 {
	    		 if (logger.isDebugEnabled())
	    			 logger.debug("No hay más mensajes que tratar");
	    	 } 
	    	 //session.close();
    		 if (logger.isDebugEnabled())
    			 logger.debug("End:onMessage");
    	 }
    	 catch (Exception ex)
    	 {
			 if (message != null) {
				logger.error("Se ha producido un error al leer el mensaje ["+message+"]", ex);
			 }
    		 throw new RuntimeException(ex);
    	 }
    }
      /**
       * Este metodo genera la imagen 
     * @param ode El ode al que hay que insertarle la imagen
       */
      public void generateImage4Id(OdeVO ode)
      {
      	try
      	{
      		if (logger.isDebugEnabled())
      			logger.debug("Begin:generateImage4Id");
      		if (logger.isDebugEnabled())
      			logger.debug("El ode es id ["+ode.getIdentificadorMEC()+"] MainFile ["+ode.getMainFile()+"] y el servidor es ["+ode.getServerOn()+"]");
      		//Si todo ha ido bien hago la petición RMI pasando el Objeto
      		if (logger.isDebugEnabled())
      			logger.debug("Solicitud RMI");
      		this.getImgServer().getImageUrlForId(ode.getIdentificadorMEC(), ode.getMainFile(), ode.getServerOn());
      		if (logger.isDebugEnabled())
      			logger.debug("End:generateImage4Id");
      	}
      	catch (Exception ex)
      	{
      		logger.error("Se ha producido un error al SOLICITAR rmi ["+ode.getIdentificadorMEC()+"]", ex);
      		throw new CreateImageException("Se ha producido un error al SOLICITAR rmi ["+ode.getIdentificadorMEC()+"]",ex);
      	}
      }

      /**
       * Este metodo hace la llamada al servicio de publicacion
     * @param srvPublicacionService Servicio de publicacion
       */
    public void setSrvPublicacionService(es.pode.publicacion.negocio.servicios.SrvPublicacionService srvPublicacionService)
    {
        this.srvPublicacionService = srvPublicacionService;
    }


    /**
     * Este metodo hace la llamada al servicio de publicacion
     */
    protected es.pode.publicacion.negocio.servicios.SrvPublicacionService getSrvPublicacionService()
    {
        return this.srvPublicacionService;
    }
    
	public GaleriaImgServer getImgServer() {
		return imgServer;
	}


	public void setImgServer(GaleriaImgServer imgServer) {
		this.imgServer = imgServer;
	}

    

}