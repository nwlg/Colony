/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.agrega.soporte.tag.redireccionRoles;



import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.acegisecurity.GrantedAuthority;
import org.apache.log4j.Logger;

import es.pode.soporte.menu.MenuController;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

public class RedireccionRolesTag extends BodyTagSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(RedireccionRolesTag.class);	
	
	protected static final String FILE_NAME_PROPERTIES = "/menu.properties";
	
	protected static final String ROLE_INACTIVO = MenuController.getPropertyValue("inactivo",RedireccionRolesTag.FILE_NAME_PROPERTIES);
	protected static final String ROLE_EMPAQUETADOR = MenuController.getPropertyValue("empaquetador",RedireccionRolesTag.FILE_NAME_PROPERTIES);
	
	
	/**
	* doStartTag is called by the JSP container when the tag is encountered
	*/
	    public int doStartTag() throws JspException{
	    	try {
	    		
	    		JspWriter out = pageContext.getOut();
	    		if(LdapUserDetailsUtils.estaAutenticado())
	    		{ 
	    			GrantedAuthority[] roles = LdapUserDetailsUtils.getRoles();
	    			if((roles.length == 2)&&((roles[1].getAuthority().equalsIgnoreCase(ROLE_EMPAQUETADOR)))||(roles[1].getAuthority().equalsIgnoreCase(ROLE_INACTIVO)))
	    			{
	    				
	    				HttpServletResponse response = (HttpServletResponse)pageContext.getResponse();
	    				response.sendRedirect("/visualizadorcontenidos/Portada/Portada.do");
	    			}
	    			
	    		}
	    		 
	    	}catch(Exception e)
	    	{
	    		logger.error("exception "+e);
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