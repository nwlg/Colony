// license-header java merge-point
/* Autogenerated by AndroMDA (MessageDrivenBean.vsl) - do not edit */

package es.pode.planificador.negocio.servicios.jms;

import java.util.Map;


/**
 * Autogenerated JMS message driven EJB class for the SrvTareaModificadorService bean.
 * Generated file: es/pode/planificador/negocio/servicios/jms/SrvTareaModificadorService
 */



public interface  SrvTareaModificadorService 
{
    

    public void sendMessage( String message);
    
    public void sendMessage( final Map map);
    

    // -------- User Defined Methods  --------------
    

  
  
        public  java.lang.Boolean ejecutarTareaModificacion(java.lang.Long idModificacion);
   
  
 
}