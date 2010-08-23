/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.agrega.soporte.tag.buscadorCas;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.pode.soporte.nodosSQI.servicio.NodoSQIVO;
import es.pode.soporte.nodosSQI.servicio.SrvGestionSqiService;
import es.pode.soporte.nodosSQI.servicio.SrvGestionSqiServiceServiceLocator;

public class BuscadorCasTag extends BodyTagSupport {
	
	protected static Log logger = LogFactory.getLog(BuscadorCasTag.class); 
	/**
	* doStartTag is called by the JSP container when the tag is encountered
	*/
	    public int doStartTag() throws JspException{
	    	
	    try{
	    	
    		SrvGestionSqiServiceServiceLocator serviceLocator = new SrvGestionSqiServiceServiceLocator();						
    		SrvGestionSqiService servicio = null;
    		JspWriter out = pageContext.getOut();
    		
    			/* Para la invocacion del ws con seguridad*/
    			servicio = serviceLocator.getSrvGestionSqiService();
    	                        
    	        NodoSQIVO[]	nodos = servicio.obtenerNodosSQI();
    	        if (logger.isDebugEnabled())logger.debug("Numero de nodos obtenidos: " + nodos.length);
    	        if(nodos!=null && nodos.length>0){
    	        	out.println("<input type='radio' name='tipoBusqueda' value='04' id='todo_agrega' class='botonradio'><label for='todo_agrega'>Otros</label>");
    	        }
    	     }catch (Exception e){
    	    	 logger.error("ERROR al llamar al servicio SrvGestionSqiService para obtener los nodos SQI de la tabla  "+e);
    	       
    	     }	
	    		
	    	return SKIP_BODY;	
	    }
	
	    /**
		 * doEndTag is called by the JSP container when the tag is closed
		 */
			public int doEndTag(){
				return SKIP_BODY; 
			}
	
}
