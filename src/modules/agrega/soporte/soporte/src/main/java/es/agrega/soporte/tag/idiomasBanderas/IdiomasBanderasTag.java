/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * 
 */
package es.agrega.soporte.tag.idiomasBanderas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

import org.apache.log4j.Logger;

public class IdiomasBanderasTag extends BodyTagSupport {
	private static Logger logger = Logger.getLogger(IdiomasBanderasTag.class);
	
	
	private String urlIdiomasBanderas = null;	
	private static final String INTERROGACION = "?";	
	private static final String TEXTOIDIOMA = "idioma";	
	private static final String IGUAL = "=";	
	private static final String BARRA = "/";	
	
	private static final long serialVersionUID = 1L;	
	
	public String getUrlIdiomasBanderas() {
		return urlIdiomasBanderas;
	}
	public void setUrlIdiomasBanderas(String urlIdiomasBanderas) {
		this.urlIdiomasBanderas = urlIdiomasBanderas;
	}


	/**
	* doStartTag is called by the JSP container when the tag is encountered
	*/
	    public int doStartTag() throws JspException{
	    	try
	    	{
	    		JspWriter out = pageContext.getOut();
	    		
	    		//Solo se pintan las banderas si el usuario esta logado
	    		if(!(LdapUserDetailsUtils.estaAutenticado()))
	    		{	    		
		    		logger.debug("El valor de la urlIdiomasBanderas es ["+urlIdiomasBanderas+"]");
		    		
		    		String urlIdiomaEn = "";
		    		String urlIdiomaVa = "";
					String urlIdiomaEu = "";
					String urlIdiomaGl = "";
					String urlIdiomaCa = "";
					String urlIdiomaEs = "";
					try {
						urlIdiomaEn = devuelveUrlBandera(urlIdiomasBanderas, "en");
						urlIdiomaVa = devuelveUrlBandera(urlIdiomasBanderas, "va");
						urlIdiomaEu = devuelveUrlBandera(urlIdiomasBanderas, "eu");
						urlIdiomaGl = devuelveUrlBandera(urlIdiomasBanderas, "gl");
						urlIdiomaCa = devuelveUrlBandera(urlIdiomasBanderas, "ca");
						urlIdiomaEs = devuelveUrlBandera(urlIdiomasBanderas, "es");
					} catch (Exception e) {
						logger.error("Error obteniendo la url del idioma", e);						
					}
		    			
					if(AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.NEUTRO)!=null && AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.NEUTRO).equals("true"))
						out.println("<li class=\"idiomas\"><a href=\"" + urlIdiomaEn + "\" title=\"English\"  id=\"idi_ingles\"><span>Idioma: English</span></a>&nbsp;</li>");
					else
						out.println("<li class=\"idiomas\"><a href=\"" + urlIdiomaEn + "\" title=\"English\"  id=\"idi_ingles\"><span>Idioma: English</span></a>&nbsp;|</li>");
		    		out.println("<li class=\"idiomas\"><a href=\"" + urlIdiomaVa + "\" title=\"Valenciá\"  id=\"idi_valenciano\"><span>Idioma: Valenciá</span></a></li>");
		    		out.println("<li class=\"idiomas\"><a href=\"" + urlIdiomaEu + "\" title=\"Euskera\"  id=\"idi_vasco\"><span>Idioma: Euskera</span></a></li>");
		    		out.println("<li class=\"idiomas\"><a href=\"" + urlIdiomaGl + "\" title=\"Galego\"  id=\"idi_gallego\"><span>Idioma: Galego</span></a></li>");
		    		out.println("<li class=\"idiomas\"><a href=\"" + urlIdiomaCa + "\" title=\"Catalá\"  id=\"idi_catalan\"><span>Idioma: Catalá</span></a></li>");
		    		out.println("<li class=\"idiomas\"><a href=\"" + urlIdiomaEs + "\" title=\"Castellano\"  id=\"idi_castellano\"><span>Idioma:Castellano</span></a></li>");
	    		
	    		}	    		
	    		
	    	} catch (IOException e)
	    	{    			
    			logger.error("Error en el tag de las banderas de los idiomas", e);
    		}
	    	
	    		
	    		return SKIP_BODY;	
	    }
	   
	/**
	 * doEndTag is called by the JSP container when the tag is closed
	 */
		public int doEndTag(){
			return SKIP_BODY; 
		}
		
	private String devuelveUrlBandera (String urlIdiomasBanderas, String codigoBandera) throws Exception
	{
		return "http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+BARRA + urlIdiomasBanderas + INTERROGACION + TEXTOIDIOMA + IGUAL + codigoBandera;
	}	
	
}