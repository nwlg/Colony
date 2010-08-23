/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.administracion.tag.banderas;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.log4j.Logger;

import es.pode.administracion.tag.noticias.NoticiasTag;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

public class BanderasTag extends BodyTagSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(BanderasTag.class);	
	private java.util.Properties pSpringProperties = null;	
	
	private static final String ACTIONLISTADO = "actionListado";
	private static final String ACTIONPESTANHA = "actionPestanhas";
	private static final String ACTIONPESTANHAACTIVA = "actionPestanhasSeleccionada";
	private static final String FICHERO = "application-resources";
	
	private static final String CASTELLANO = "globos.castellano";
	private static final String INGLES = "globos.ingles";
	private static final String CATALAN = "globos.catalan";
	private static final String EUSKERA = "globos.euskera";
	private static final String VALENCIANO = "globos.valenciano";
	private static final String GALLEGO = "globos.gallego";

	private String banderas = null;
	private String action = null;
	
	public String getBanderas() {
		return banderas;
	}
	
	public void setBanderas(String banderas) {
		this.banderas = banderas;
	}
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}	
	
	/**
	* doStartTag is called by the JSP container when the tag is encountered
	*/
	    public int doStartTag() throws JspException{
	    	try {   				
		    		JspWriter out = pageContext.getOut();  				    		
		    		
		    		if (logger.isDebugEnabled()) logger.debug("Los idiomas recibidos son ["+banderas+"]");
//		    		Ordenar las banderas: Castellano, catalán, inglés, euskera, gallego y valenciano
		    		logger.debug("Se ordenan los banderas de los idiomas: Castellano, catalán, inglés, euskera, gallego y valenciano");
		    		String[] banderasArray = ordenarArrayBanderas(banderas.split(","));
		    		if (logger.isDebugEnabled()) logger.debug("El tamanho del vector banderasArray es ["+banderasArray.length+"]");   				    		
		    		
		    		//Se obtiene el locale		    		
		    		Locale locale = null;
					try {
						locale = devuelveLocale();
					} catch (Exception e) {
						logger.error("Error recuperando el locale",e);
					}
					
					NoticiasTag tagNoticias = new NoticiasTag();
			    	String castellano = tagNoticias.getResource(CASTELLANO, FICHERO, locale);
			    	String ingles = tagNoticias.getResource(INGLES, FICHERO, locale);
			    	String catalan = tagNoticias.getResource(CATALAN, FICHERO, locale);	    	
			    	String euskera = tagNoticias.getResource(EUSKERA, FICHERO, locale);
			    	String gallego = tagNoticias.getResource(GALLEGO, FICHERO, locale);	 
			    	String valenciano = tagNoticias.getResource(VALENCIANO, FICHERO, locale);			    	
					
//		    		Pintamos la bandera del idioma
		    		for (int i = 0;banderasArray != null && i < banderasArray.length; i++)
		    		{
		    			try {
		    				if (logger.isDebugEnabled()) logger.debug("Pintando la bandera de ["+banderasArray[i]+"]");	
		    				if (ACTIONLISTADO.equals(action))
		    					pintarBanderas(banderasArray[i], out, castellano, ingles, catalan, euskera, gallego, valenciano );
		    				else if (ACTIONPESTANHA.equals(action) || ACTIONPESTANHAACTIVA.equals(action))
		    				{
		    					if (ACTIONPESTANHAACTIVA.equals(action))
		    						out.println("<a href=\"http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+"/portaladministracion/Faqs/Faqs.do?idiomaSeleccionado="+banderasArray[i].trim()+"\" id=\"seleccionada\">");
		    					else
		    						out.println("<a href=\"http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+"/portaladministracion/Faqs/Faqs.do?idiomaSeleccionado="+banderasArray[i].trim()+"\">");
		    						pintarBanderasPestanha(banderasArray[i], out, castellano, ingles, catalan, euskera, gallego, valenciano );
		    					out.println("</a>");
		    				}
		    				else
		    					pintarBanderasGlobo(banderasArray[i], out, locale);
								
						} catch (Exception e) {
							logger.error("Error pintando los banderas",e);
						}	
					}
		
	    		
	    		} catch (IOException e) {	    			
	    			logger.error("Error pintando los banderas",e);	    			
	    		}
	    		catch (Exception e) 
	    		 {
	    			 logger.error("Error pintando los banderas",e);
	    		 }
	    		return SKIP_BODY;	
	    }
	    
	    private String[] ordenarArrayBanderas(String[] banderas)throws Exception
	    {	    	
	    	ArrayList banderasReturnList = new ArrayList();	    	
//	    	Se busca el castellano
	    	if (estaBanderaIdioma(banderas, this.getPropertyValue("castellano"))) banderasReturnList.add(this.getPropertyValue("castellano"));
//	    	Se busca el gallego
	    	if (estaBanderaIdioma(banderas, this.getPropertyValue("gallego"))) banderasReturnList.add(this.getPropertyValue("gallego"));
//	    	Se busca el catalan
	    	if (estaBanderaIdioma(banderas, this.getPropertyValue("catalan"))) banderasReturnList.add(this.getPropertyValue("catalan"));
//	    	Se busca el valenciano
	    	if (estaBanderaIdioma(banderas, this.getPropertyValue("valenciano"))) banderasReturnList.add(this.getPropertyValue("valenciano"));
//	    	Se busca el euskera
	    	if (estaBanderaIdioma(banderas, this.getPropertyValue("euskera"))) banderasReturnList.add(this.getPropertyValue("euskera"));
//	    	Se busca el inglés
	    	if (estaBanderaIdioma(banderas, this.getPropertyValue("ingles"))) banderasReturnList.add(this.getPropertyValue("ingles"));
 
	    	
	    	return (String[])banderasReturnList.toArray(new String[0]);
	    }
	    
	    private boolean estaBanderaIdioma (String[] banderas, String idioma) throws Exception
	    {
	    	boolean esta = false;
	    	for (int i = 0; !esta && i < banderas.length; i++)	    	
	    		if (banderas[i] != null && !"".equals(banderas[i]) && idioma.equals(banderas[i])) esta = true;
	    	
	    	return esta;
	    }
	    
	    public void pintarBanderasListado(String bandera, JspWriter out) throws Exception
	    {	    	
//	    	<h3 class=\"h3_espanol\">Castellano</h3>"//	    	
//	    	<h3 class=\"h3_ingles\">English</h3>//	    	
//	    	<h3 class=\"h3_catalan\">Catalá</h3>//	    	
//	    	<h3 class=\"h3_vasco\">Euskera</h3>
//	    	<h3 class=\"h3_valenciano\">Valenciano</h3>//	    	
//	    	<h3 class=\"h3_gallego\">Galego</h3>	    	
	    	if (this.getPropertyValue("castellano").equals(bandera))
	    		out.println("<h3 class=\"h3_espanol\"></h3>");			    		
    		if (this.getPropertyValue("ingles").equals(bandera))		    		
    			out.println("<h3 class=\"h3_ingles\"></h3>");    		
    		if (this.getPropertyValue("catalan").equals(bandera))		    		
    			out.println("<h3 class=\"h3_catalan\"></h3>");    		
    		if (this.getPropertyValue("euskera").equals(bandera))		    		
    			out.println("<h3 class=\"h3_vasco\"></h3>");
    		if (this.getPropertyValue("gallego").equals(bandera))		    		
    			out.println("<h3 class=\"h3_gallego\"></h3>");
    		if (this.getPropertyValue("valenciano").equals(bandera))		    		
    			out.println("<h3 class=\"h3_valenciano\"></h3>");   		
    		
	    }
	    public void pintarBanderasGlobo(String bandera, JspWriter out, Locale locale) throws Exception
	    {	    	
//	    	<h3 class=\"h3_espanol\">Castellano</h3>"//	    	
//	    	<h3 class=\"h3_ingles\">English</h3>//	    	
//	    	<h3 class=\"h3_catalan\">Catalá</h3>//	    	
//	    	<h3 class=\"h3_vasco\">Euskera</h3>
//	    	<h3 class=\"h3_valenciano\">Valenciano</h3>//	    	
//	    	<h3 class=\"h3_gallego\">Galego</h3>
	    	
	    	NoticiasTag tagNoticias = new NoticiasTag();
	    	String castellano = tagNoticias.getResource(CASTELLANO, FICHERO, locale);
	    	String ingles = tagNoticias.getResource(INGLES, FICHERO, locale);
	    	String catalan = tagNoticias.getResource(CATALAN, FICHERO, locale);	    	
	    	String euskera = tagNoticias.getResource(EUSKERA, FICHERO, locale);
	    	String gallego = tagNoticias.getResource(GALLEGO, FICHERO, locale);	 
	    	String valenciano = tagNoticias.getResource(VALENCIANO, FICHERO, locale);	
	    	   	
	    	if (this.getPropertyValue("castellano").equals(bandera))
	    		out.println("<h3 class=\"h3_espanol\">"+castellano+"</h3>");			    		
    		if (this.getPropertyValue("ingles").equals(bandera))		    		
    			out.println("<h3 class=\"h3_ingles\">"+ingles+"</h3>");    		
    		if (this.getPropertyValue("catalan").equals(bandera))		    		
    			out.println("<h3 class=\"h3_catalan\">"+catalan+"</h3>");    		
    		if (this.getPropertyValue("euskera").equals(bandera))		    		
    			out.println("<h3 class=\"h3_vasco\">"+euskera+"</h3>"); 
    		if (this.getPropertyValue("gallego").equals(bandera))		    		
    			out.println("<h3 class=\"h3_gallego\">"+gallego+"</h3>");
    		if (this.getPropertyValue("valenciano").equals(bandera))		    		
    			out.println("<h3 class=\"h3_valenciano\">"+valenciano+"</h3>");  		    		
	    }
	    
	    public void pintarBanderas(String bandera, JspWriter out, String castellano, String ingles, String catalan, String euskera, String gallego, String valenciano) throws Exception
	    {	    	
	    	if (this.getPropertyValue("castellano").equals(bandera))		    				    			
	    		out.println("<span class=\"idi_espanol\" title=\""+castellano+"\">&nbsp;<em>"+castellano+"</em></span>");	
			
			if (this.getPropertyValue("ingles").equals(bandera))
				out.println("<span class=\"idi_ingles\" title=\""+ingles+"\">&nbsp;<em>"+ingles+"</em></span>");	
			
			if (this.getPropertyValue("catalan").equals(bandera))	
				out.println("<span class=\"idi_catalan\" title=\""+catalan+"\">&nbsp;<em>"+catalan+"</em></span>");			
			
			if (this.getPropertyValue("euskera").equals(bandera))		    		
				out.println("<span class=\"idi_vasco\" title=\""+euskera+"\">&nbsp;<em>"+euskera+"</em></span>");
			
			if (this.getPropertyValue("gallego").equals(bandera))		    		
				out.println("<span class=\"idi_gallego\" title=\""+gallego+"\">&nbsp;<em>"+gallego+"</em></span>");
			
			if (this.getPropertyValue("valenciano").equals(bandera))		    		
				out.println("<span class=\"idi_valenciano\" title=\""+valenciano+"\">&nbsp;<em>"+valenciano+"</em></span>");
    		
	    }
	    public void pintarBanderasPestanha (String bandera, JspWriter out, String castellano, String ingles, String catalan, String euskera, String gallego, String valenciano) throws Exception
	    {	    	
	    	
	    	if (this.getPropertyValue("castellano").equals(bandera))		    				    			
	    		out.println("<img src='/static/img/01_castellano.gif' alt='"+castellano+"' title='"+castellano+"'/></a>");	
			
			if (this.getPropertyValue("ingles").equals(bandera))		    		
				out.println("<img src='/static/img/06_ingles.gif' alt='"+ingles+"' title='"+ingles+"'/></a>");
			
			if (this.getPropertyValue("catalan").equals(bandera))		    		
				out.println("<img src='/static/img/02_catalan.gif' alt='"+catalan+"' title='"+catalan+"'/></a>");
			
			if (this.getPropertyValue("euskera").equals(bandera))		    		
				out.println("<img src='/static/img/05_vasco.gif' alt='"+euskera+"' title='"+euskera+"'/></a>");
			
			if (this.getPropertyValue("gallego").equals(bandera))		    		
				out.println("<img src='/static/img/03_gallego.gif' alt='"+gallego+"' title='"+gallego+"'/></a>");
			
			if (this.getPropertyValue("valenciano").equals(bandera))		    		
				out.println("<img src='/static/img/04_valenciano.gif' alt='"+valenciano+"' title='"+valenciano+"'/></a>");
	    }


	/**
	 * doEndTag is called by the JSP container when the tag is closed
	 */
		public int doEndTag(){
			return SKIP_BODY; 
		}
		
		private String getPropertyValue(String sKey) throws IOException {
			InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/portaladministracion.properties");
			if (this.pSpringProperties == null) {
				pSpringProperties = new java.util.Properties();
				pSpringProperties.load(fIsSpringProperties);
			}
			fIsSpringProperties.close();
			if (logger.isDebugEnabled())logger.debug("getPropertyValue: Propiedad recuperada: " + sKey + " : "+ pSpringProperties.getProperty(sKey));
//			 devolvemos la propiedad
			return pSpringProperties.getProperty(sKey);
		}
		
		public Locale devuelveLocale() throws Exception
		{
			Locale locale=null;
			if (pageContext.getRequest() instanceof HttpServletRequest) {
				locale = (Locale)((HttpServletRequest)pageContext.getRequest()).getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
				
			}
			else{ 	    					
				try {
					locale=new Locale(I18n.getInstance().obtenerIdiomaDefectoPlataforma());
				} catch (Exception e) {	
					logger.error("Error recuperando el locale de la request",e);					
				}
			}
			return locale;
		}
}