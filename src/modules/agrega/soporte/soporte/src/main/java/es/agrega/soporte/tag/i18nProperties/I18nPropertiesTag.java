/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.agrega.soporte.tag.i18nProperties;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import es.pode.soporte.i18n.I18n;
import es.pode.soporte.i18n.LocalizacionIdiomaVO;


public class I18nPropertiesTag extends BodyTagSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String property = null;
	
	/**
	* doStartTag is called by the JSP container when the tag is encountered
	*/
	    public int doStartTag() throws JspException{
	    	try {
	    		
	    		JspWriter out = pageContext.getOut();
	    		String idiomaNavegacion = this.getProperty();
	    		try
	    		{
	    			LocalizacionIdiomaVO[] localizaciones = I18n.getInstance().obtenerIdiomasBuscablesLocalizados(idiomaNavegacion);
	    			for(int i=0;i<localizaciones.length;i++)
	    			{
	    				String idLocalizacion = localizaciones[i].getIdLocalizacion();
	    				String nombre = localizaciones[i].getName();
	    				out.println("<option value='"+idLocalizacion+"'>"+nombre+"</option>");
	    			}
	    		}catch(Exception e)
	    		{
	    			out.println("<option value='es'><spring:message code='castellano'/></option>");
		    		out.println("<option value='ca'><spring:message code='catalan'/></option>");
		    		out.println("<option value='eu'><spring:message code='euskera'/></option>");
		    		out.println("<option value='en'><spring:message code='ingles'/></option>");
	    		}
	    		
	    	
	    		} catch (IOException e) {
	    			
	    			e.printStackTrace();
	    		}
	    		return SKIP_BODY;	
	    }
	   
	/**
	 * doEndTag is called by the JSP container when the tag is closed
	 */
		public int doEndTag(){
			return SKIP_BODY; 
		}
		
		public String getProperty() {
			return property;
		}

		public void setProperty(String property) {
			this.property = property;
		}
}