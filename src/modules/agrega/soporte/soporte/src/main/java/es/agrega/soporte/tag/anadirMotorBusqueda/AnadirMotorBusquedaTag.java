/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.agrega.soporte.tag.anadirMotorBusqueda;

import java.io.IOException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.UnhandledException;

import org.apache.log4j.Logger;

import es.agrega.soporte.http.BrowserDetector;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

public class AnadirMotorBusquedaTag extends BodyTagSupport {
	
	private static Logger logger = Logger.getLogger(AnadirMotorBusquedaTag.class);	

	private static final String COOKIENAME = "motorBusquedaCookie";	
	
	private static final String FICHERO = "application-resources";
	private static final String LITERALTEXTO = "motor.busqueda.texto";
	private static final String BARRA = "/";	
	private static final String HTTP = "http";
	private static final String DOSPUNTOS = ":";
	private static final String COMILLASIMPLE = "'";
	private static final String LITERALBOTONACEPTAR = "motor.busqueda.boton.aceptar";
	private static final String LITERALBOTONCANCELAR = "motor.busqueda.boton.cancelar";	
	
	private static final String MOZILLA = "Mozilla";
	private static final String IEXPLORER = "MSIE";
	
	private String urlMotorBusqueda = null;
	private String navegador = null;
	
	private static final long serialVersionUID = 1L;	
	
	public String getUrlMotorBusqueda() {
		return urlMotorBusqueda;
	}
	public void setUrlMotorBusqueda(String urlMotorBusqueda) {
		this.urlMotorBusqueda = urlMotorBusqueda;
	}
	
	public String getNavegador() {
		return navegador;
	}
	public void setNavegador(String navegador) {
		this.navegador = navegador;
	}

	/**
	* doStartTag is called by the JSP container when the tag is encountered
	*/
	    public int doStartTag() throws JspException{
	    	try {	    		
	    		
//	    		<!--  INICIO WIDGET   -->
//	    		<!--  INICIO WIDGET   -->
//	    		<div class="widget">
//		    		<div class="capaflotante">
//			    		<span>Ejemplo de buscador</span>
//			    		<a href="#" class="buscar" title="Aceptar">Aceptar</a>
//			    		<a href="#" class="cancel" >Cancelar</a>
//			    		<br  class="oculto" />
//		    		</div>
//		    		<p>Añadir agrega a los motores de búsqueda de su navegador</p>
//		    		<br  class="oculto" />
//	    		</div>
//	    		<!--  FIN WIDGET   -->
//	    		<!--  FIN WIDGET   -->
	    		
	    		//Validamos el navegador
	    		String nameNavegator = "";
	    		float versionNavegator = 0;	    		
	    		BrowserDetector browser = new BrowserDetector(((HttpServletRequest)pageContext.getRequest()));	    		
	    			nameNavegator = browser.getBrowserName();
	    			versionNavegator = browser.getBrowserVersion();
	    		if (logger.isDebugEnabled()) logger.debug("El navegador es ["+nameNavegator+"] y su version es ["+versionNavegator+"]");
	    		
	    		JspWriter out = pageContext.getOut();	   
	    		String url = HTTP + DOSPUNTOS + BARRA + BARRA + ((HttpServletRequest) pageContext.getRequest()).getServerName()+LdapUserDetailsUtils.getSubdominio()+BARRA + urlMotorBusqueda;	    		
	    		String onClickAceptarPrevio = COMILLASIMPLE + HTTP + DOSPUNTOS + BARRA + BARRA + ((HttpServletRequest) pageContext.getRequest()).getServerName() + DOSPUNTOS + ((HttpServletRequest) pageContext.getRequest()).getServerPort() + LdapUserDetailsUtils.getSubdominio()+ "/searchPlugin/searchPlugin.xml" + COMILLASIMPLE;
	    		String onClickAceptar = "window.external.AddSearchProvider(" + onClickAceptarPrevio + ");document.getElementById('motorBusqueda').style.display='none';";
	    		String onClickCancel = "document.getElementById('motorBusqueda').style.display='none';";  		    		
	    		
	    		//Tratamiento de los textos internacionalizados	    		
				Locale locale = null;
				try {
					locale = devuelveLocale();
				} catch (Exception e1) {
					logger.error("Error obteniendo el locale", e1);					
				}
				String literalTexto = this.getResource(LITERALTEXTO, FICHERO, locale);
				String literalBotonAceptar = this.getResource(LITERALBOTONACEPTAR, FICHERO, locale);
				String literalBotonCancelar = this.getResource(LITERALBOTONCANCELAR, FICHERO, locale);
	    		
	    		//Se hallan las cookies
	    		Cookie[] cookies = ((HttpServletRequest) pageContext.getRequest()).getCookies();
	    		Cookie cookieMotorBusqueda = getCookie(COOKIENAME, cookies);
	    		
	    		logger.debug("El valor de valorCookieMotor es ["+cookieMotorBusqueda.getValue()+"]");
	    		//Se pinta "añadir buscador como motor de busqueda" si no habia sido añadido previamente	    		
	    		
	    		//Para poder pintar el motor de busqueda el navegador tiene que ser firefox o internet explorer > 6
	    		
	    	
				if(pintarMotorBusqueda(nameNavegator, versionNavegator, cookieMotorBusqueda.getValue()))
				{
				out.println("<!--  INICIO WIDGET   -->");	
				out.println("<!--  INICIO WIDGET   -->");	
				out.println("<div class=\"widget\" id=\"motorBusqueda\">");	    		
					out.println("<div class=\"capaflotante\">");
						out.println("<span>Ejemplo de buscador</span>");
						out.println("<a href=\"" + url + "\" onClick=\"" + onClickAceptar + "\" class=\"buscar\" title=" + literalBotonAceptar + ">"+ literalBotonAceptar +"</a>");
						out.println("<a href=\"" + url + "\" onClick=\"" + onClickCancel + "\"" +"class=\"cancel\" >"+ literalBotonCancelar +"</a>");
						out.println("<br  class=\"oculto\" />");
					out.println("</div>");
					out.println("<p>" + literalTexto + "</p>");
					out.println("<br  class=\"oculto\" />");
				out.println("</div>");
				out.println("<!--  FIN WIDGET   -->");
				out.println("<!--  FIN WIDGET   -->");
				}				   	
	    		
	    	} catch (IOException e) {	    		
	    		logger.debug("Error en el tag de añadir motor de busqueda",e);
	    	}
	    	return SKIP_BODY;	
	    }	    
	    /**
		 * doEndTag is called by the JSP container when the tag is closed
		 */
			public int doEndTag(){
				return SKIP_BODY; 
			}		
		
		/** 
		 * Recupera la información almacenada en una cookie
		 * @param nombre: nombre de la cookie
		 * @param cookies: cookies
		 */
		Cookie getCookie(String name, Cookie[] cookies) {
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					Cookie cookie = cookies[i];
					if (cookie.getName().equals(name))
						return cookie;
				}
			}

			return new Cookie(name, "");
		}
		
		private boolean pintarMotorBusqueda (String nombreNavegador, float versionNavegador, String cookie) throws UnhandledException
		{
			boolean pintar = false;
		
			try{			
			
				//El navegador es Internet explorer
				if (IEXPLORER.equals(nombreNavegador) && versionNavegador > 6.0 && "".equals(cookie)) pintar = true;
				//El navegador es mozilla
				else if (MOZILLA.equals(nombreNavegador) && "".equals(cookie)) pintar = true;				
			
			}catch (UnhandledException e)
			{
				logger.error("Error al intentar pintar el motor de busqueda");
			}
			return pintar;
			
		}
		
		public static String getResource(String key, String baseName, Locale locale){
	        String recurso = "";
	        ResourceBundle theResourceBundle = getResource(baseName,locale);
	        try{
	        	if (theResourceBundle!=null){
	               recurso = theResourceBundle.getString(key);
	           }
	        }catch (MissingResourceException mre){
	        	recurso = key;
	        }
	        return recurso;
	    }
		
		public static ResourceBundle getResource(String baseName, Locale locale){
	        try{
	        	return ResourceBundle.getBundle(baseName,locale);
	            
	        }catch (MissingResourceException mre){
	        		locale = new Locale("","");
	        		return ResourceBundle.getBundle(baseName,locale);
	             
	        }
	    }
		
		private Locale devuelveLocale() throws Exception
		{
			Locale locale=null;
			if (pageContext.getRequest() instanceof HttpServletRequest) {
				locale = (Locale)((HttpServletRequest)pageContext.getRequest()).getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
				
			}
			else{ 	    					
				try {
					locale=new Locale(I18n.getInstance().obtenerIdiomaDefectoPlataforma());
				} catch (Exception e) {								
					logger.error("Error obteniendo el locale de la request",e);
				}
			}
			return locale;
		}
		
}