/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.administracion.tag.noticias;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.log4j.Logger;

import es.pode.administracion.tag.banderas.BanderasTag;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;

public class NoticiasTag extends BodyTagSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(NoticiasTag.class);	
	
	private static final String FICHERO = "application-resources";
	private static final String GENERICOCLAVEIDIOMAS = "categorias.noticia.clave.";
	private static final String ACTIONALTANOTICIA = "altaNoticia";
	private static final String ACTIONALTACATEGORIANOTICIA = "altaCategoriaNoticia";
	private static final String ACTIONVERCATEGORIANOTICIA = "verCategoriaNoticia";
	private static final String ACTIONMODIFICARCATEGORIANOTICIA = "modificaCategoriaNoticia";
	private static final String ACTIONVERNOTICIA = "verNoticia";
	private static final String ACTIONMODIFICARNOTICIA = "modificarNoticia";
	
	private static final String BARRA = "/";	
	private static final String HTTP = "http";
	private static final String DOSPUNTOS = ":";	
	
	private static final String FORMULARIOCUERPO = "modificar.noticia.formulario.Cuerpo";	
	private static final String FORMULARIOINTRONOTICIA = "modificar.noticia.formulario.introduzcaCuerpoNoticia";
	private static final String XSTANDARMESSAGE = "xstandard.message";
	private static final String INTRODUZCANOMBRE = "categorias.noticias.introduzca.nombre";
	private static final String NOMBRECATEGORIA = "categorias.noticias.nombre";
	private static final String TITULONOTICIA = "noticias.crear.dos.titulo";
	private static final String TITULONOTICIATOOLTIP = "noticias.crear.dos.titulo.tooltip";
	private static final String RESUMENNOTICIATOOLTIP = "modificar.noticia.formulario.introduzcaResumen";
	private static final String RESUMENNOTICIA = "modificar.noticia.formulario.Resumen";
	private static final String CATEGORIANOTICIA = "noticias.crear.dos.titulo.categoria";
	private static final String VERCAMPOS = "noticias.crear.desplegable.ver.campos";
	private static final String OCULTARCAMPOS = "noticias.crear.desplegable.ocultar.campos";
	private static final String VERCAMPOSCATEGORIA = "categorias.crear.desplegable.ver.campos";
	private static final String OCULTARCAMPOSCATEGORIA = "categorias.crear.desplegable.ocultar.campos";
	
	private java.util.Properties pSpringProperties = null;
	private static final String COMA = ",";
	
	private String action = null;	
	private Object nombreCategoria = null;
	private Object idiomas = null;	
	private String sessionScope = null;	
	private Object titulo = null;
	private Object resumen = null;
	private Object cuerpo = null;
	private Object idiomasAlta = null;
	private Object idiomasCategoriasBBDD = null;
	
	public String getAction() {
		return action;
	}	
	public void setAction(String action) {
		this.action = action;
	}	
	public String getSessionScope() {
		return sessionScope;
	}
	public void setSessionScope(String sessionScope) {
		this.sessionScope = sessionScope;
	}
	
	public Object getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(Object idiomas) {
		this.idiomas = idiomas;
	}
	public Object getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(Object nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	public Object getTitulo() {
		return titulo;
	}
	public void setTitulo(Object titulo) {
		this.titulo = titulo;
	}
	public Object getResumen() {
		return resumen;
	}
	public void setResumen(Object resumen) {
		this.resumen = resumen;
	}
	public Object getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(Object cuerpo) {
		this.cuerpo = cuerpo;
	}
	public Object getIdiomasAlta() {
		return idiomasAlta;
	}
	public void setIdiomasAlta(Object idiomasAlta) {
		this.idiomasAlta = idiomasAlta;
	}
	public Object getIdiomasCategoriasBBDD() {
		return idiomasCategoriasBBDD;
	}
	public void setIdiomasCategoriasBBDD(Object idiomasCategoriasBBDD) {
		this.idiomasCategoriasBBDD = idiomasCategoriasBBDD;
	}
	
	/**
	* doStartTag is called by the JSP container when the tag is encountered
	*/
	    public int doStartTag() throws JspException{
	    	try
	    	{  	    		
	    		JspWriter out = pageContext.getOut();
	    		String valueNombreCategoria = "";	
	    		String valueTitulo = "";
	    		String valueResumen = "";
	    		String valueCuerpo = "";	
	    		Collection idiomasCategoriasBBDDCollection = null;
	    		String[] idiomasCategoriasBBDDArray = null;
	    		
	    		if (idiomasCategoriasBBDD != null && !"".equals(idiomasCategoriasBBDD))
	    		{
	    			idiomasCategoriasBBDDCollection = (Collection)idiomasCategoriasBBDD;
		    		idiomasCategoriasBBDDArray = (String[]) idiomasCategoriasBBDDCollection.toArray(new String[0]);
	    		}
	    		
    			Locale locale = null;
				try {
					locale = devuelveLocale();
				} catch (Exception e) {
					logger.error("Error recuperando el locale",e);
				}
	    		String[] idiomasTraducibles = this.getPropertyValue("idiomas.traducibles").split(COMA);
	    		if (logger.isDebugEnabled()) logger.debug("Hay ["+idiomasTraducibles.length+"] en la plataforma");	
	    		
	    		BanderasTag banderasTag = new BanderasTag();
	    		
	    		   			    		
	    		for (int i = 0; idiomasTraducibles != null && i < idiomasTraducibles.length; i++)	
	    		{  
	    			String literalIdiomaCabecera = this.getResource(GENERICOCLAVEIDIOMAS + idiomasTraducibles[i].trim(), FICHERO, locale);
	    			String literalIntroduzcaNombre = this.getResource(INTRODUZCANOMBRE, FICHERO, locale);
	    			String literalNombreCategoria = this.getResource(NOMBRECATEGORIA, FICHERO, locale);
	    			
	    			String literalVerCamposNoticia = this.getResource(VERCAMPOS, FICHERO, locale);
	    			String literalOcultarCamposNoticia = this.getResource(OCULTARCAMPOS, FICHERO, locale);
	    			
	    			String literalVerCamposCategoria = this.getResource(VERCAMPOSCATEGORIA, FICHERO, locale);
	    			String literalOcultarCamposCategoria = this.getResource(OCULTARCAMPOSCATEGORIA, FICHERO, locale);
	    			 
    				if (nombreCategoria != null && !"".equals(nombreCategoria)){
    					Collection idiomasCollection = (Collection)idiomas;
    		    		Collection nombreCategoriaCollection = (Collection)nombreCategoria;	    		    		
    		    		String[] idiomasArray = (String[])idiomasCollection.toArray(new String[0]);
    					String[] nombreCategoriaArray = (String[])nombreCategoriaCollection.toArray(new String[0]);
    					valueNombreCategoria = dameValue (idiomasArray,nombreCategoriaArray, idiomasTraducibles[i].trim());
    				}    				
	    			
	    			if (ACTIONALTANOTICIA.equals(action) || ACTIONVERNOTICIA.equals(action) || ACTIONMODIFICARNOTICIA.equals(action))
	    			{   	
	    				if (nombreCategoria != null && !"".equals(nombreCategoria))
	    				{
		    				Collection idiomasCollection = (Collection)idiomas;
		    				String[] idiomasArray = (String[])idiomasCollection.toArray(new String[0]);	 
		    				Collection nombreCategoriaCollection = (Collection)nombreCategoria;
	    					String[] nombreCategoriaArray = (String[])nombreCategoriaCollection.toArray(new String[0]);
	    					valueNombreCategoria = dameValue (idiomasArray,nombreCategoriaArray, idiomasTraducibles[i].trim());
	    				}
	    				
	    				if (idiomasAlta != null && !"".equals(idiomasAlta))
	    				{	   
	    					Collection idiomasAltaCollection = (Collection)idiomasAlta;
		    				String[] idiomasAltaArray = (String[]) idiomasAltaCollection.toArray(new String[0]);		    				
		    				if (titulo != null && !"".equals(titulo))
		    				{
		    					Collection tituloCollection = (Collection)titulo;
		    					String[] tituloArray = (String[])tituloCollection.toArray(new String[0]);
		    					valueTitulo = dameValue (idiomasAltaArray,tituloArray, idiomasTraducibles[i].trim());
		    				}
		    				if (resumen != null && !"".equals(resumen))
		    				{
		    					Collection resumenCollection = (Collection)resumen;
		    					String[] resumenArray = (String[])resumenCollection.toArray(new String[0]);
		    					valueResumen = dameValue (idiomasAltaArray,resumenArray, idiomasTraducibles[i].trim());
		    				}
		    				if (cuerpo != null && !"".equals(cuerpo))
		    				{
		    					Collection cuerpoCollection = (Collection)cuerpo;
		    					String[] cuerpoArray = (String[])cuerpoCollection.toArray(new String[0]);
		    					valueCuerpo = dameValue (idiomasAltaArray,cuerpoArray, idiomasTraducibles[i].trim());
		    					if (ACTIONVERNOTICIA.equals(action) && valueCuerpo != null && !valueCuerpo.equals(""))
		    						valueCuerpo = devuelveCuerpoVerNoticia(valueCuerpo);
		    				}	 
	    				}	    			
	    			}
	    			
	    			if (ACTIONALTACATEGORIANOTICIA.equals(action) || ACTIONVERCATEGORIANOTICIA.equals(action) || ACTIONMODIFICARCATEGORIANOTICIA.equals(action) )
	    			{	   				    					    			
	    				/**
	    				 * **************************************************************************************************************************************
	    				 * **************************************** PANTALLA DE LAS CATEGORIAS NOTICIAS *******************************************************
	    				 * **************************************************************************************************************************************
	    				 * */
				    	logger.debug("Se pinta el codigo html"); 					    	
				  
				    	out.println("<!--  INICIO GLOBO GRIS   -->");
				    	out.println("<div class=\"globo_gris uno_b\" >");
				    		out.println("<div class=\"globo_gris_01\">");
				    			out.println("<div class=\"globo_gris_02\">");
				    				out.println("<div class=\"globo_gris_03\">");
				    				if ("".equals(valueNombreCategoria))
				    					out.println("<div class=\"caja_dinamica\"><a class=\"desplegado\" id=\"pm"+idiomasTraducibles[i].trim()+"\" href=\"#\" onclick=\"expandirCaja('m"+idiomasTraducibles[i].trim()+"', '"+literalVerCamposCategoria+"', '"+literalOcultarCamposCategoria+"');return false;\" onkeypress=\"expandirCaja('m"+idiomasTraducibles[i].trim()+"', '"+literalVerCamposCategoria+"', '"+literalOcultarCamposCategoria+"');return false;\"><br class=\"falso\" /><strong id=\"dm"+idiomasTraducibles[i].trim()+"\" >"+literalVerCamposCategoria+"</strong></a>");
				    				else
				    					out.println("<div class=\"caja_dinamica\"><a class=\"desplegado\" id=\"pm"+idiomasTraducibles[i].trim()+"\" href=\"#\" onclick=\"expandirCaja('m"+idiomasTraducibles[i].trim()+"', '"+literalVerCamposCategoria+"', '"+literalOcultarCamposCategoria+"');return false;\" onkeypress=\"expandirCaja('m"+idiomasTraducibles[i].trim()+"', '"+literalVerCamposCategoria+"', '"+literalOcultarCamposCategoria+"');return false;\"><br class=\"falso\" /><strong id=\"dm"+idiomasTraducibles[i].trim()+"\" >"+literalOcultarCamposCategoria+"</strong></a>");
				    					banderasTag.pintarBanderasGlobo(idiomasTraducibles[i].trim(), out, locale);
			    					out.println("</div>");
//			    					Si hay valor el globo estara abierto
		    						if ("".equals(valueNombreCategoria))
    								out.println("<div id=\"m"+idiomasTraducibles[i].trim()+"\" class=\"caja_cerrada\"><br/>");
		    						else
	    							out.println("<div id=\"m"+idiomasTraducibles[i].trim()+"\" class=\"caja_abierta\"><br/>");				    					
				    						out.println("<!--  INICIO CAJA DE FORMULARIO   -->");
				    						out.println("<div class=\"formu\">");				    						
				    							out.println("<div class=\"fila_de_tabla\">");
				    								out.println("<div class=\"contenedor_izquierda\">");
				    									out.println("<div class=\"text\"><label for=\"Noticia\">" + literalNombreCategoria + ":</label></div>");
				    									out.println("</div>");
				    									out.println("<div class=\"contenedor_derecha\">");
					    									out.println("<div class=\"text\">");
					    									if (ACTIONVERCATEGORIANOTICIA.equals(action))
		    													out.println("<input DISABLED style=\"background:#e1e1e1\"  name=\"categoriaNoticia" + idiomasTraducibles[i].trim() +"\"  value=\""+valueNombreCategoria+"\" onblur=\"this.style.backgroundColor='#e1e1e1'\" id=\"categoriaNoticia\" type=\"text\" title=\"" + literalIntroduzcaNombre + "\" />");
		    												else
		    													out.println("<input style=\"background:#e1e1e1\"  name=\"categoriaNoticia" + idiomasTraducibles[i].trim() +"\"  value=\""+valueNombreCategoria+"\"  onblur=\"this.style.backgroundColor='#e1e1e1'\" id=\"categoriaNoticia\" type=\"text\" title=\"" + literalIntroduzcaNombre + "\" />");
					    									out.println("</div>");
				    									out.println("</div>");
				    									out.println("<div class=\"linea_separadora\"></div>");
				    									out.println("<br class=\"oculto\"/>");
				    								out.println("</div>");
				    							out.println("</div>");
				    						out.println("<!--  FIN CAJA DE FORMULARIO   -->");
				    						out.println("</div>");
				    						out.println("<br />");
				    					out.println("<!--  FIN   -->");
				    					out.println("</div>");
				    				out.println("</div>");
				    			out.println("</div>");
				    	out.println("</div>");
				    	out.println("<!--  FIN GLOBO GRIS   -->");
		    		}
	    			
	    			else if (ACTIONALTANOTICIA.equals(action) || ACTIONVERNOTICIA.equals(action) || ACTIONMODIFICARNOTICIA.equals(action))
		    		{	    
	    				/**
	    				 * **************************************************************************************************************************************
	    				 * ********************************************** PANTALLA DE LAS NOTICIAS ************************************************************
	    				 * **************************************************************************************************************************************
	    				 * */
	    				String formularioCuerpo = this.getResource(FORMULARIOCUERPO, FICHERO, locale);	
	    				String formularioIntroNoticia = this.getResource(FORMULARIOINTRONOTICIA, FICHERO, locale);
	    				String xstandarmessage = this.getResource(XSTANDARMESSAGE, FICHERO, locale);
	    				String urlRaiz = HTTP + DOSPUNTOS + BARRA + BARRA + ((HttpServletRequest) pageContext.getRequest()).getServerName() + DOSPUNTOS + ((HttpServletRequest) pageContext.getRequest()).getServerPort() + ((HttpServletRequest) pageContext.getRequest()).getContextPath();
	    				String codeBase = urlRaiz + BARRA + "XStandard.cab#Version=2,0,0,0";
	    				String urlRaizStyles = urlRaiz + BARRA + "styles.xml";
	    				String urlRaizScreenreader = urlRaiz + BARRA + "screenreader.xsl";
	    				String urlRaizLocalization = urlRaiz + BARRA + "localization.xml";    					
	    				String soap = "http://soap.xstandard.com/library/";
	    				
	    				String literalTituloNoticia = this.getResource(TITULONOTICIA, FICHERO, locale);	
	    				String literalTituloNoticiaTooltip = this.getResource(TITULONOTICIATOOLTIP, FICHERO, locale);	
	    				String literalResumenNoticiaTooltip = this.getResource(RESUMENNOTICIATOOLTIP, FICHERO, locale);
	    				String literalResumenNoticia = this.getResource(RESUMENNOTICIA, FICHERO, locale);
	    				String literalCategoriaNoticia = this.getResource(CATEGORIANOTICIA, FICHERO, locale); 		    				
	    				
	    				out.println("<!--  INICIO GLOBO GRIS   -->");
				    	out.println("<div class=\"globo_gris uno_b\" id=\"ficha\">");
				    		out.println("<div class=\"globo_gris_01\">");
				    			out.println("<div class=\"globo_gris_02\">");
				    				out.println("<div class=\"globo_gris_03\">");
				    					out.println("<!--  INICIO CAJA DE FORMULARIO   -->");
				    					if (abrirGlobo(valueTitulo, valueResumen, valueCuerpo, valueNombreCategoria, idiomasTraducibles[i], idiomasCategoriasBBDDArray))
				    						out.println("<div class=\"caja_dinamica\"><a class=\"desplegado\" id=\"pm"+idiomasTraducibles[i].trim()+"\" href=\"#\" onclick=\"expandirCaja('m"+idiomasTraducibles[i].trim()+"', '"+literalVerCamposNoticia+"', '"+literalOcultarCamposNoticia+"');return false;\" onkeypress=\"expandirCaja('m"+idiomasTraducibles[i].trim()+"', '"+literalVerCamposNoticia+"', '"+literalOcultarCamposNoticia+"');return false;\"><br class=\"falso\" /><strong id=\"dm"+idiomasTraducibles[i].trim()+"\" >"+literalOcultarCamposNoticia+"</strong></a>");
				    					else
				    						out.println("<div class=\"caja_dinamica\"><a class=\"desplegado\" id=\"pm"+idiomasTraducibles[i].trim()+"\" href=\"#\" onclick=\"expandirCaja('m"+idiomasTraducibles[i].trim()+"', '"+literalVerCamposNoticia+"', '"+literalOcultarCamposNoticia+"');return false;\" onkeypress=\"expandirCaja('m"+idiomasTraducibles[i].trim()+"', '"+literalVerCamposNoticia+"', '"+literalOcultarCamposNoticia+"');return false;\"><br class=\"falso\" /><strong id=\"dm"+idiomasTraducibles[i].trim()+"\" >"+literalVerCamposNoticia+"</strong></a>");
				    						banderasTag.pintarBanderasGlobo(idiomasTraducibles[i].trim(), out, locale);
				    					out.println("</div>");
//				    					Si hay valor el globo estara abierto
				    					if (abrirGlobo(valueTitulo, valueResumen, valueCuerpo, valueNombreCategoria, idiomasTraducibles[i], idiomasCategoriasBBDDArray))
				    						out.println("<div id=\"m"+idiomasTraducibles[i].trim()+"\" class=\"caja_abierta\"><br/>");
				    					else
			    							out.println("<div id=\"m"+idiomasTraducibles[i].trim()+"\" class=\"caja_cerrada\"><br/>");			    						
			    							
				    					out.println("<br />");
				    					
				    						out.println("<!--  INICIO CAJA DE FORMULARIO   -->");
				    						out.println("<div class=\"formu\" >");
				    							out.println("<!-- ***********************     CAMPO CATEGORIA      **************************-->");
				    							out.println("<div class=\"fila_de_tabla\" >");				    					
				    								out.println("<div class=\"contenedor_izquierda\">");
				    									out.println("<div class=\"text\"><label for=\"Categoria\">*"+literalCategoriaNoticia+":</label></div>");
				    								out.println("</div>");
				    								
				    								out.println("<div class=\"contenedor_derecha\">");	
				    								if (ACTIONVERNOTICIA.equals(action) || (estaLleno(valueNombreCategoria) && estaBBDD(idiomasTraducibles[i], idiomasCategoriasBBDDArray)))
				    									out.println("<div class=\"text\"><input DISABLED style=\"background=#ccc\" name=\"categoriaNoti" + idiomasTraducibles[i].trim() + "\"  value=\""+valueNombreCategoria+"\"  onblur=\"this.style.backgroundColor='#e1e1e1'\" id=\"Noticia\" type=\"text\" title=\""+literalCategoriaNoticia+"\"/></div>");											
													else
														out.println("<div class=\"text\"><input name=\"categoriaNoti" + idiomasTraducibles[i].trim() + "\"  value=\""+valueNombreCategoria+"\"  onblur=\"this.style.backgroundColor='#e1e1e1'\" id=\"Noticia\" type=\"text\" title=\""+literalCategoriaNoticia+"\"/></div>");
													out.println("</div>");							    								
				    								out.println("<div class=\"linea_separadora\"></div>");
				    								out.println("<br class=\"oculto\"/>");
				    							out.println("</div>");
				    							out.println("<!-- -->");
				    							out.println("<!-- ***********************     CAMPO TITULO      **************************-->");
				    							out.println("<div class=\"fila_de_tabla\">");				    					
				    								out.println("<div class=\"contenedor_izquierda\">");
				    									out.println("<div class=\"text\"><label for=\"Noticia\">*"+literalTituloNoticia+":</label></div>");
				    								out.println("</div>");
				    								out.println("<div class=\"contenedor_derecha\">");
				    									out.println("<div class=\"text\">");
				    									if (ACTIONMODIFICARNOTICIA.equals(action) || ACTIONALTANOTICIA.equals(action))
    														out.println("<input name=\"tituloNoti" + idiomasTraducibles[i].trim() + "\"  value=\""+valueTitulo+"\"  onblur=\"this.style.backgroundColor='#e1e1e1'\" id=\"Noticia\" type=\"text\" title=\""+literalTituloNoticiaTooltip+"\" />");
    													else
    														out.println("<input DISABLED name=\"tituloNoti" + idiomasTraducibles[i].trim() + "\"  value=\""+valueTitulo+"\"  onblur=\"this.style.backgroundColor='#e1e1e1'\" id=\"Noticia\" type=\"text\" title=\""+literalTituloNoticiaTooltip+"\" />");		    									
				    									
				    									out.println("</div>");
				    								out.println("</div>");
				    								out.println("<div class=\"linea_separadora\"></div>");
				    								out.println("<br class=\"oculto\"/>");
				    							out.println("</div>");
				    							out.println("<!-- -->");
				    							
				    							out.println("<!-- ***********************     CAMPO RESUMEN      **************************-->");
				    							out.println("<div class=\"fila_de_tabla\">");
				    								out.println("<div class=\"contenedor_izquierda\">");
				    									out.println("<div class=\"text\"><label for=\"resumen\" >"+literalResumenNoticia+"</label></div>");				    									
				    								out.println("</div>");
				    								out.println("<div class=\"contenedor_derecha\">");
				    									out.println("<div class=\"text\">");		    									
				    									
				    									if (ACTIONMODIFICARNOTICIA.equals(action) || ACTIONALTANOTICIA.equals(action))
				    										out.println("<textarea name=\"resumenNoti" + idiomasTraducibles[i].trim() + "\"  rows=\"4\" cols=\"4\" class=\"ta_minimo_ancho\" onblur=\"this.style.backgroundColor='#e1e1e1'\" id=\"resumen\"  title=\""+literalResumenNoticiaTooltip+"\" >"+valueResumen+"</textarea>");
    													else
    														out.println("<textarea DISABLED name=\"resumenNoti" + idiomasTraducibles[i].trim() + "\" rows=\"4\" cols=\"4\" class=\"ta_minimo_ancho\" onblur=\"this.style.backgroundColor='#e1e1e1'\" id=\"resumen\"  title=\""+literalResumenNoticiaTooltip+"\" >"+valueResumen+"</textarea>");				    										
				    									out.println("</div>");
				    								out.println("</div>");
				    								out.println("<div class=\"linea_separadora\"></div>");
				    								out.println("<br class=\"oculto\"/>");
				    							out.println("</div>");
				    							out.println("<!-- -->");
				    							out.println("<div class=\"fila_de_tabla\">");
				    								out.println("<div class=\"contenedor_izquierda\">");
				    									out.println("<div class=\"text\"><label>"+ formularioCuerpo + "</label></div>");				    									
				    								out.println("</div>");
				    								if (ACTIONMODIFICARNOTICIA.equals(action) || ACTIONALTANOTICIA.equals(action))
	    											{	
				    								out.println("<div class=\"contenedor_derecha\">");
				    									out.println("<div class=\"text\">");
				    										out.println("<object type=\"application/x-xstandard\" codebase=\"" + codeBase + "\" name=\"cuerpoNoti" + idiomasTraducibles[i].trim() + "\"  id=\"CuerpoNoticia\" width=\"350\" height=\"420\" title=\"" + formularioIntroNoticia + "\">");    													
				    											out.println("<param name=\"Localization\" value=\""+ urlRaizLocalization + "\" />");
				    											out.println("<param name=\"Styles\" value=\""+ urlRaizStyles + "\" />");
				    											out.println("<param name=\"ScreenReaderXSLT\" value=\""+ urlRaizScreenreader + "\" />");
				    											out.println("<param name=\"ToolbarWysiwyg\" value=\"ordered-list,unordered-list,definition-list,,draw-layout-table,draw-data-table,image,separator,hyperlink,attachment,directory,spellchecker,,wysiwyg,source,preview,screen-reader,help\" />");
				    											out.println("<param name=\"ToolbarSource\" value=\"\" />");
				    											out.println("<param name=\"ToolbarPreview\" value=\"\" />");
				    											out.println("<param name=\"ToolbarScreenReader\" value=\"\"/>");
				    											out.println("<param name=\"ClassImageFloatLeft\" value=\"left\" />");
				    											out.println("<param name=\"ClassImageFloatRight\" value=\"right\" />");
				    											out.println("<param name=\"Options\" value=\"0\" />");
				    											out.println("<param name=\"IndentOutput\" value=\"no\" />");
				    											out.println("<param name=\"BackgroundColor\" value=\"white\" />");
				    											out.println("<param name=\"BorderColor\" value=\"#8BA6BF\" />");
				    											out.println("<param name=\"Base\" value=\""+ soap + "\" />");
				    											out.println("<param name=\"LatestVersion\" value=\"2.0.0.0\" />");
				    											out.println("<param name=\"Lang\" value=\"" + sessionScope + "\" />");
				    											out.println("<param name=\"Value\" value=\""+valueCuerpo+"\"/>");
				    											out.println("<span class=\"message\"><p style=\"width:350px\">" + xstandarmessage + "</p>");		    											
				    											out.println("<textarea name=\"cuerpoNoti" + idiomasTraducibles[i].trim() + "\" rows=\"10\" style=\"width:350px\" class=\"ta_minimo_ancho\" id=\"CuerpoNoticia\" title=\"" + formularioIntroNoticia + "\">"+valueCuerpo+"</textarea>");
				    										out.println("</span></object>");
	    													}else
			    											{						    														    											
	    														out.println("<div class=\"contenedor_derecha\">");
	    															out.println("<div class=\"text\">");
	    																out.println("<textarea DISABLED name=\"cuerponoti\" rows=\"10\" cols=\"40\" class=\"ta_minimo_ancho\"  style=\"width:350px\" onblur=\"this.style.backgroundColor='#e1e1e1'\" id=\"comentario\"  title=\"Noticia introducida\" >"+valueCuerpo+"");
	    																out.println("</textarea>");	    														
			    											}
				    									out.println("</div>");    													    									
				    								out.println("</div>");
				    								out.println("<div class=\"linea_separadora\"></div>");
				    								out.println("<br class=\"oculto\"/>");
				    							out.println("</div>");
				    							out.println("<!-- -->");
				    						out.println("</div>");
				    						out.println("<!--  FIN CAJA DE FORMULARIO   -->");
				    					out.println("</div>");
				    					out.println("<br />");
				    				out.println("<!--  FIN   -->");				    				
				    				out.println("</div>");
				    			out.println("</div>");
				    		out.println("</div>");
				    	out.println("</div>");
				    	out.println("<!--  FIN GLOBO GRIS   -->");	    					    			
		    		}
	    		}	    	
	    		
    		 } catch (IOException e)
    		 {	    			
    			logger.error("Error pintando el alta de noticias",e);	    			
    		 }
    		 catch (Exception e) 
    		 {
    			 logger.error("Error pintando el alta de noticias",e);
    		 }
	    		return SKIP_BODY;	
	    }	
	    
	    

	/**
	 * doEndTag is called by the JSP container when the tag is closed
	 */
		public int doEndTag(){
			return SKIP_BODY; 
		}	
		
//		MÉTODOS PARA PINTAR LOS MENSAJES INTERNACIONALIZADOS
		public static String getResource(String key, String baseName, Locale locale)
		{
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
		
		public static ResourceBundle getResource(String baseName, Locale locale)
		{
	        try{
	        	return ResourceBundle.getBundle(baseName,locale);
	            
	        }catch (MissingResourceException mre){
	        		locale = new Locale("","");
	        		return ResourceBundle.getBundle(baseName,locale);
	             
	        }
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
		
		private boolean estaLleno (String var) throws Exception
		{
			return (var != null && !"".equals(var));
		}
		
		private boolean abrirGlobo (String valueTitulo, String valueResumen, String valueCuerpo, String valueCategoria, String idiomaCategoria, String[] idiomasBBDD) throws Exception
		{
			return (estaLleno(valueTitulo) || estaLleno(valueResumen) || estaLleno(valueCuerpo) || (estaLleno(valueCategoria) && !estaBBDD(idiomaCategoria, idiomasBBDD) && !ACTIONVERNOTICIA.equals(action)));
		}
		
		private boolean estaBBDD(String idiomaCategoria, String[] idiomasBBDD) throws Exception
		{
			boolean encontrado = false;
			for (int i = 0; idiomasBBDD != null && !encontrado && i < idiomasBBDD.length; i++)			
				if (idiomaCategoria.equals(idiomasBBDD[i])) encontrado = true;
			return encontrado;			
		}
		 
		private String dameValue (String[] idiomasSplit, String[] valueSplit, String idioma)throws Exception
		{
			String returnSt = "";
			int posicion = 0;
			boolean encontrado = false;
//			Se busca la posicion donde se encuentra el idioma
			for (int i = 0; idiomasSplit != null && i < idiomasSplit.length; i++)
			{
				if (valueSplit[i] != null && idiomasSplit[i].trim().equals(idioma))
				{
					encontrado = true;
					posicion = i;
				}
					
			}
			if (encontrado)			
				returnSt = valueSplit[posicion];				
			
//			Reemplazar las comillas por el codigo html correspondiente
			String stringSinComillas = "";
			char[] charArray = returnSt.toCharArray();			
//			Se recorre hasta encontrar las comillas				
			for (int i = 0; i < charArray.length; i++)
			{
				if (charArray[i] == '"') stringSinComillas = stringSinComillas + "&quot;";
				else stringSinComillas = stringSinComillas + String.valueOf(charArray[i]);				
									
			}
			stringSinComillas.trim();

//			sustituimos @,",:,%,+,-,' por su codigo correspondiente en ASCII			
			stringSinComillas.replaceAll("@","&#64");
			stringSinComillas.replaceAll(":","&#58");
			stringSinComillas.replaceAll("%","&#37");
			stringSinComillas.replaceAll("\\+","&#43");
			stringSinComillas.replaceAll("-","&#45");
			stringSinComillas.replaceAll("'","&#39");						
			
			return stringSinComillas.trim();			
			
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
		
		private String devuelveCuerpoVerNoticia (String cuerpo) throws Exception
		{
			//Se quita el parrafo (<p> y </p>)
			String[] cuerpoSplit = cuerpo.split("<p>");
			String cuerpoAux = cuerpoSplit[1];
			String[] cuerpoSplitAux = cuerpoAux.split("</p>");
			return (cuerpoSplitAux[0]);		
		}
		
}