/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.administracion.tag.faqs;

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
import es.pode.administracion.tag.noticias.NoticiasTag;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;

public class FaqsTag extends BodyTagSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(NoticiasTag.class);	
	
	private static final String FICHERO = "application-resources";
	private static final String GENERICOCLAVEIDIOMAS = "categorias.noticia.clave.";
	private static final String ACTIONALTAFAQ = "altaFaq";
	private static final String ACTIONALTACATEGORIAFAQ = "altaCategoriaFaq";
	private static final String ACTIONVERCATEGORIAFAQ = "verCategoriaFaq";
	private static final String ACTIONMODIFICARCATEGORIAFAQ = "modificaCategoriaFaq";
	private static final String ACTIONVERFAQ = "verFaq";
	private static final String ACTIONMODIFICARFAQ = "modificarFaq";
	
	private static final String BARRA = "/";	
	private static final String HTTP = "http";
	private static final String DOSPUNTOS = ":";	

	private static final String XSTANDARMESSAGE = "xstandard.message";
	private static final String INTRODUZCANOMBRE = "categorias.noticias.introduzca.nombre";
	private static final String NOMBRECATEGORIA = "categorias.noticias.nombre";
	private static final String TITULOFAQ = "faqs.crear.dos.titulo";
	private static final String TITULOFAQTOOLTIP = "faqs.crear.dos.titulo.tooltip";
	private static final String DESCRIPCIONFAQTOOLTIP = "faqs.formulario.introduzcaDescripcion";
	private static final String DESCRIPCIONFAQ = "modificar.faq.formulario.Descripcion";
	private static final String CATEGORIANOTICIA = "noticias.crear.dos.titulo.categoria";
	private static final String POSICIONFAQ = "faqs.posicion.literal";
	private static final String POSICIONFAQTOOLTIP = "faqs.posicion.literal.tooltip";
	private static final String VERCAMPOSFAQ = "faqs.crear.desplegable.ver.campos";
	private static final String OCULTARCAMPOSFAQ = "faqs.crear.desplegable.ocultar.campos";
	private static final String VERCAMPOSCATEGORIA = "categorias.crear.desplegable.ver.campos";
	private static final String OCULTARCAMPOSCATEGORIA = "categorias.crear.desplegable.ocultar.campos";
	private static final String LITERALCOMBOSELECCIONE = "comun.seleccione";
	private static final String LITERALCOMBOPRIMERAPOSICION = "faqs.posicion.literalComboPrimeraPosicion";
	
	private java.util.Properties pSpringProperties = null;
	private static final String COMA = ",";
	
	private String action = null;	
	private Object nombreCategoria = null;
	private Object idiomas = null;	
	private String sessionScope = null;	
	private Object titulo = null;
	private Object descripcion = null;	
	private Object idiomasAlta = null;
	private Object idiomasCategoriasBBDD = null;
	private Object posicionesCastellano = null;
	private Object posicionesIngles = null;
	private Object posicionesValenciano = null;
	private Object posicionesGallego = null;
	private Object posicionesCatalan = null;
	private Object posicionesEuskera = null;
	private Object valuePosicion = null;
	
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
	public Object getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(Object descripcion) {
		this.descripcion = descripcion;
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
	public Object getPosicionesCastellano() {
		return posicionesCastellano;
	}
	public void setPosicionesCastellano(Object posicionesCastellano) {
		this.posicionesCastellano = posicionesCastellano;
	}
	public Object getPosicionesIngles() {
		return posicionesIngles;
	}
	public void setPosicionesIngles(Object posicionesIngles) {
		this.posicionesIngles = posicionesIngles;
	}
	public Object getPosicionesCatalan() {
		return posicionesCatalan;
	}
	public void setPosicionesCatalan(Object posicionesCatalan) {
		this.posicionesCatalan = posicionesCatalan;
	}
	public Object getPosicionesValenciano() {
		return posicionesValenciano;
	}
	public void setPosicionesValenciano(Object posicionesValenciano) {
		this.posicionesValenciano = posicionesValenciano;
	}
	public Object getPosicionesGallego() {
		return posicionesGallego;
	}
	public void setPosicionesGallego(Object posicionesGallego) {
		this.posicionesGallego = posicionesGallego;
	}
	public Object getPosicionesEuskera() {
		return posicionesEuskera;
	}
	public void setPosicionesEuskera(Object posicionesEuskera) {
		this.posicionesEuskera = posicionesEuskera;
	}
	public Object getValuePosicion() {
		return valuePosicion;
	}
	public void setValuePosicion(Object valuePosicion) {
		this.valuePosicion = valuePosicion;
	}
	/**
	* doStartTag is called by the JSP container when the tag is encountered
	*/
	    public int doStartTag() throws JspException{
	    	try {	    		
	    		
	    		JspWriter out = pageContext.getOut();	    		
	    		String valueNombreCategoria = "";	
	    		String valueTitulo = "";
	    		String valueDescripcion = "";
	    		String valuePos = "";
	    		Collection idiomasCategoriasBBDDCollection = null;
	    		String[] idiomasCategoriasBBDDArray = null;	    		
    			String[] posicion = null;

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
	    			
	    			String literalVerCamposFaq = this.getResource(VERCAMPOSFAQ, FICHERO, locale);
	    			String literalOcultarCamposFaq = this.getResource(OCULTARCAMPOSFAQ, FICHERO, locale);	    			

	    			String literalVerCamposCategoria = this.getResource(VERCAMPOSCATEGORIA, FICHERO, locale);
	    			String literalOcultarCamposCategoria = this.getResource(OCULTARCAMPOSCATEGORIA, FICHERO, locale);
	    			
		    			    
	    			if (nombreCategoria != null && !"".equals(nombreCategoria))
	    			{
						Collection idiomasCollection = (Collection)idiomas;
			    		Collection nombreCategoriaCollection = (Collection)nombreCategoria;	    		    		
			    		String[] idiomasArray = (String[])idiomasCollection.toArray(new String[0]);
						String[] nombreCategoriaArray = (String[])nombreCategoriaCollection.toArray(new String[0]);
						valueNombreCategoria = dameValue (idiomasArray,nombreCategoriaArray, idiomasTraducibles[i].trim());
	    			}
					
		    		
		    		if (ACTIONALTAFAQ.equals(action) || ACTIONVERFAQ.equals(action) || ACTIONMODIFICARFAQ.equals(action))
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
		    				if (descripcion != null && !"".equals(descripcion))
		    				{
		    					Collection descripcionCollection = (Collection)descripcion;
		    					String[] descripcionArray = (String[])descripcionCollection.toArray(new String[0]);
		    					valueDescripcion = dameValue (idiomasAltaArray,descripcionArray, idiomasTraducibles[i].trim());
		    					if (ACTIONVERFAQ.equals(action) && valueDescripcion != null && !valueDescripcion.equals(""))
		    						valueDescripcion = devuelveDescripcionVerNoticia(valueDescripcion);
		    				}
		    				if (valuePosicion != null && !"".equals(valuePosicion))
		    				{
		    					Collection valuePosicionCollection = (Collection)valuePosicion;
		    					String[] valuePosicionArray = (String[])valuePosicionCollection.toArray(new String[0]);
		    					valuePos = dameValue (idiomasAltaArray,valuePosicionArray, idiomasTraducibles[i].trim());//		    					
		    				}		    				
	    				}	
	    				
	    				if (ACTIONALTAFAQ.equals(action) || ACTIONMODIFICARFAQ.equals(action))
		    			{ 
		    				//Tratamiento de la posicion
		    				posicion = dameArrayPosicion(posicionesCastellano, posicionesIngles, posicionesValenciano, posicionesGallego, posicionesEuskera, posicionesCatalan, idiomasTraducibles[i].trim());
		    			}
	    				
	    			}
		    		
		    		if (ACTIONALTACATEGORIAFAQ.equals(action) || ACTIONVERCATEGORIAFAQ.equals(action) || ACTIONMODIFICARCATEGORIAFAQ.equals(action) )
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
				    									out.println("<div class=\"text\"><label for=\"Faq\">" + literalNombreCategoria + ":</label></div>");
				    									out.println("</div>");
				    									out.println("<div class=\"contenedor_derecha\">");
					    									out.println("<div class=\"text\">");
					    									if (ACTIONVERCATEGORIAFAQ.equals(action))
		    													out.println("<input DISABLED style=\"background:#e1e1e1\"  name=\"categoriaFaq" + idiomasTraducibles[i].trim() +"\"  value=\""+valueNombreCategoria+"\" onblur=\"this.style.backgroundColor='#e1e1e1'\" id=\"categoriaFaq\" type=\"text\" title=\"" + literalIntroduzcaNombre + "\" />");
		    												else
		    													out.println("<input style=\"background:#e1e1e1\"  name=\"categoriaFaq" + idiomasTraducibles[i].trim() +"\"  value=\""+valueNombreCategoria+"\"  onblur=\"this.style.backgroundColor='#e1e1e1'\" id=\"categoriaFaq\" type=\"text\" title=\"" + literalIntroduzcaNombre + "\" />");
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
		    		else if (ACTIONALTAFAQ.equals(action) || ACTIONVERFAQ.equals(action) || ACTIONMODIFICARFAQ.equals(action))
		    		{
		    			logger.debug("Se pinta el codifo html en la creacion/modificacion de la faq");		    				
	    				
	    				String xstandarmessage = this.getResource(XSTANDARMESSAGE, FICHERO, locale);
	    				String urlRaiz = HTTP + DOSPUNTOS + BARRA + BARRA + ((HttpServletRequest) pageContext.getRequest()).getServerName() + DOSPUNTOS + ((HttpServletRequest) pageContext.getRequest()).getServerPort() + ((HttpServletRequest) pageContext.getRequest()).getContextPath();
	    				String codeBase = urlRaiz + BARRA + "XStandard.cab#Version=2,0,0,0";
	    				String urlRaizStyles = urlRaiz + BARRA + "styles.xml";
	    				String urlRaizScreenreader = urlRaiz + BARRA + "screenreader.xsl";
	    				String urlRaizLocalization = urlRaiz + BARRA + "localization.xml";    					
	    				String soap = "http://soap.xstandard.com/library/";
	    				
	    				String literalTituloFaq = this.getResource(TITULOFAQ, FICHERO, locale);	
	    				String literalTituloFaqTooltip = this.getResource(TITULOFAQTOOLTIP, FICHERO, locale);	
	    				String literalDescripcionFaqTooltip = this.getResource(DESCRIPCIONFAQTOOLTIP, FICHERO, locale);
	    				String literalDescripcionFaq = this.getResource(DESCRIPCIONFAQ, FICHERO, locale);
	    				String literalCategoriaFaq = this.getResource(CATEGORIANOTICIA, FICHERO, locale); 
	    				String literalPosicionFaq = this.getResource(POSICIONFAQ, FICHERO, locale);
	    				String literalPosicionFaqTooltip = this.getResource(POSICIONFAQTOOLTIP, FICHERO, locale);
	    				String literalComboSeleccione = this.getResource(LITERALCOMBOSELECCIONE, FICHERO, locale);
	    				String literalComboPrimeraPosicion = this.getResource(LITERALCOMBOPRIMERAPOSICION, FICHERO, locale);
		    			
		    			out.println("<!--  INICIO GLOBO GRIS   -->");		    			
		    			out.println("<div class=\"globo_gris uno_b\">");
		    				out.println("<div class=\"globo_gris_01\">");
		    					out.println("<div class=\"globo_gris_02\">");
		    						out.println("<div class=\"globo_gris_03\">");
		    						if (abrirGloboFaq(valueTitulo, valueDescripcion, valuePos, valueNombreCategoria, idiomasTraducibles[i], idiomasCategoriasBBDDArray))
		    							out.println("<div class=\"caja_dinamica\"><a class=\"desplegado\" id=\"pm"+idiomasTraducibles[i].trim()+"\" href=\"#\" onclick=\"expandirCaja('m"+idiomasTraducibles[i].trim()+"', '"+literalVerCamposFaq+"', '"+literalOcultarCamposFaq+"');return false;\" onkeypress=\"expandirCaja('m"+idiomasTraducibles[i].trim()+"', '"+literalVerCamposFaq+"', '"+literalOcultarCamposFaq+"');return false;\"><br class=\"falso\" /><strong id=\"dm"+idiomasTraducibles[i].trim()+"\" >"+literalOcultarCamposFaq+"</strong></a>");
		    						else
		    							out.println("<div class=\"caja_dinamica\"><a class=\"desplegado\" id=\"pm"+idiomasTraducibles[i].trim()+"\" href=\"#\" onclick=\"expandirCaja('m"+idiomasTraducibles[i].trim()+"', '"+literalVerCamposFaq+"', '"+literalOcultarCamposFaq+"');return false;\" onkeypress=\"expandirCaja('m"+idiomasTraducibles[i].trim()+"', '"+literalVerCamposFaq+"', '"+literalOcultarCamposFaq+"');return false;\"><br class=\"falso\" /><strong id=\"dm"+idiomasTraducibles[i].trim()+"\" >"+literalVerCamposFaq+"</strong></a>");
		    						banderasTag.pintarBanderasGlobo(idiomasTraducibles[i].trim(), out, locale);
			    					out.println("</div>");
	//		    					Si hay valor el globo estara abierto
			    					if (abrirGloboFaq(valueTitulo, valueDescripcion, valuePos, valueNombreCategoria, idiomasTraducibles[i], idiomasCategoriasBBDDArray))
			    						out.println("<div id=\"m"+idiomasTraducibles[i].trim()+"\" class=\"caja_abierta\"><br/>");
			    					else
		    							out.println("<div id=\"m"+idiomasTraducibles[i].trim()+"\" class=\"caja_cerrada\"><br/>");			    						
		    							
			    					out.println("<br />");
			    						
		    								out.println("<!--  INICIO CAJA DE FORMULARIO   -->");
		    								out.println("<div class=\"formu\">"); 									    								

//	    									Tratamiento de la posicion	
		    								if (ACTIONVERFAQ.equals(action))
		    								{
		    									out.println("<div class=\"fila_de_tabla\">");		    							
	    										out.println("<div class=\"contenedor_izquierda\">");
	    											out.println("<div class=\"text\"><label for=\"posicion\">"+literalPosicionFaq+"</label></div>");
	    											out.println("</div>");
	    											out.println("<div class=\"contenedor_derecha\">");										    											
				    									out.println("<div class=\"text\"><input DISABLED style=\"background=#ccc\" name=\"posVer\"  value=\""+valuePos+"\"  onblur=\"this.style.backgroundColor='#e1e1e1'\" id=\"Pos\" type=\"text\" title=\""+literalPosicionFaqTooltip+"\"/></div>");											
																    											
	    										out.println("</div>");
	    										out.println("<div class=\"linea_separadora\"></div>");
	    										out.println("<br class=\"oculto\"/>");
	    									out.println("</div>");
		    								}
			    							if (posicion != null && posicion.length > 1)
			    							{
			    											    								
			    								out.println("<p>Seleccione el punto donde desea que aparezca la nueva FAQ (Aparecerá justo debajo del punto seleccionado)</p>");
			    								out.println("<br/>");
			    								out.println("<!-- ***********************      DESPLEGABLE DE POSICION     **************************-->");
			    								out.println("<div class=\"fila_de_tabla\">");
	    											out.println("<div class=\"contenedor_izquierda\">");
	    												out.println("<div class=\"text\"><label for=\"Posicion\">"+literalPosicionFaq+"</label></div>");
	    											out.println("</div>");
	    											out.println("<div class=\"contenedor_derecha\">");
	    												out.println("<div class=\"text\"><select  style=\"width:320px\" name=\"posicionFaq" + idiomasTraducibles[i].trim() + "\" title=\""+literalPosicionFaqTooltip+"\" id=\"Posicion\">");		    												
	    													out.println("<option value=\"0\" class=\"oscura\">"+literalComboSeleccione+"</option>");
	    													if (valuePos != null && !"".equals(valuePos) && valuePos.equals("1"))
	    														out.println("<option value=\"1\" class=\"oscura\" selected=\"selected\">"+literalComboPrimeraPosicion+"</option>");
	    													else
	    														out.println("<option value=\"1\" class=\"oscura\">"+literalComboPrimeraPosicion+"</option>");	
	    													for (int r = 1; r <= posicion.length; r++)
	    													{
	    														Integer rInteger = new Integer(r);	  
	    														Integer rMasUno = new Integer(r+1);
	    														//Se comprueba si hay alguna posicion seleccionada
	    														if (valuePos != null && !"".equals(valuePos) && valuePos.equals(rMasUno.toString()))
	    															out.println("<option value=\""+r+"\" selected=\"selected\">"+posicion[r-1]+"</option>");
	    														else
	    														{	    															
	    															//Si viene con valor, se elimina ese del combo   																    															
	    															if (!valuePos.equals(rInteger.toString()))
	    															{
	    																if (ACTIONMODIFICARFAQ.equals(action))
		    															{
	    																	//Se comprueba si viene con valor
	    																	if (valuePos == null || "".equals(valuePos))
	    																		out.println("<option value=\""+rMasUno.intValue()+"\" >"+posicion[r-1]+"</option>");
	    																	else{
				    															Integer valuePosInt = Integer.valueOf(valuePos);
				    															if (r > valuePosInt.intValue())
				    																out.println("<option value=\""+r+"\" >"+posicion[r-1]+"</option>");
				    															else
				    																out.println("<option value=\""+rMasUno.intValue()+"\" >"+posicion[r-1]+"</option>");
	    																	}
		    															}
	    																else
	    																	out.println("<option value=\""+rMasUno.intValue()+"\" >"+posicion[r-1]+"</option>");
	    															}
	    														}
	    													}	    										 
	    													out.println("</select>");
	    												out.println("</div>");
	    											out.println("</div>");
	    											out.println("<div class=\"linea_separadora\"></div>");
	    											out.println("<br class=\"oculto\" />");
	    										out.println("</div>");	
	    										out.println("<!-- -->");			    								
			    							}
		    								
		    									out.println("<!-- ***********************     CAMPO CATEGORIA      **************************-->");
		    									out.println("<div class=\"fila_de_tabla\">");		    							
		    										out.println("<div class=\"contenedor_izquierda\">");
		    											out.println("<div class=\"text\"><label for=\"Categoria\">*"+literalNombreCategoria+":</label></div>");
		    											out.println("</div>");
		    											out.println("<div class=\"contenedor_derecha\">");	
		    											
		    											if (ACTIONVERFAQ.equals(action) || (estaLleno(valueNombreCategoria) && estaBBDD(idiomasTraducibles[i], idiomasCategoriasBBDDArray)))
					    									out.println("<div class=\"text\"><input DISABLED style=\"background=#ccc\" name=\"categoriaFaq" + idiomasTraducibles[i].trim() + "\"  value=\""+valueNombreCategoria+"\"  onblur=\"this.style.backgroundColor='#e1e1e1'\" id=\"Faq\" type=\"text\" title=\""+literalCategoriaFaq+"\"/></div>");											
														else
															out.println("<div class=\"text\"><input name=\"categoriaFaq" + idiomasTraducibles[i].trim() + "\"  value=\""+valueNombreCategoria+"\"  onblur=\"this.style.backgroundColor='#e1e1e1'\" id=\"Faq\" type=\"text\" title=\""+literalCategoriaFaq+"\"/></div>");
		    														    											
		    										out.println("</div>");
		    										out.println("<div class=\"linea_separadora\"></div>");
		    										out.println("<br class=\"oculto\"/>");
		    									out.println("</div>");
		    									out.println("<!-- -->");										    									
		    									
		    									out.println("<!-- ***********************     CAMPO TITULO      **************************-->");	
		    									out.println("<div class=\"fila_de_tabla\">");
		    										out.println("<div class=\"contenedor_izquierda\">");
		    											out.println("<div class=\"text\"><label for=\"FAQ\">*"+literalTituloFaq+":</label></div>");
		    										out.println("</div>");
		    										out.println("<div class=\"contenedor_derecha\">");
		    											out.println("<div class=\"text\">");
		    											
		    											if (ACTIONMODIFICARFAQ.equals(action) || ACTIONALTAFAQ.equals(action))
    														out.println("<input name=\"tituloFaq" + idiomasTraducibles[i].trim() + "\"  value=\""+valueTitulo+"\"  onblur=\"this.style.backgroundColor='#e1e1e1'\" id=\"Faq\" type=\"text\" title=\""+literalTituloFaqTooltip+"\" />");
    													else
    														out.println("<input DISABLED name=\"tituloFaq" + idiomasTraducibles[i].trim() + "\"  value=\""+valueTitulo+"\"  onblur=\"this.style.backgroundColor='#e1e1e1'\" id=\"Faq\" type=\"text\" title=\""+literalTituloFaqTooltip+"\" />");
		    											
		    											out.println("</div>");
		    										out.println("</div>");
		    										out.println("<div class=\"linea_separadora\"></div>");
		    										out.println("<br class=\"oculto\"/>");
		    									out.println("</div>");
		    									out.println("<!-- -->");
		    									
		    									out.println("<!-- ***********************     CAMPO DESCRIPCION      **************************-->");
		    									out.println("<div class=\"fila_de_tabla\">");
			    								out.println("<div class=\"contenedor_izquierda\">");
			    									out.println("<div class=\"text\"><label>"+ literalDescripcionFaq + "</label></div>");				    									
			    								out.println("</div>");
			    								if (ACTIONMODIFICARFAQ.equals(action) || ACTIONALTAFAQ.equals(action))
    											{	
			    								out.println("<div class=\"contenedor_derecha\">");
			    									out.println("<div class=\"text\">");
			    										out.println("<object type=\"application/x-xstandard\" codebase=\"" + codeBase + "\" name=\"descripcionFaq" + idiomasTraducibles[i].trim() + "\"  id=\"DescripcionFaq\" width=\"350\" height=\"420\" title=\"" + literalDescripcionFaqTooltip + "\">");    													
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
			    											out.println("<param name=\"Value\" value=\""+valueDescripcion+"\"/>");
			    											out.println("<span class=\"message\"><p style=\"width:350px\">" + xstandarmessage + "</p>");		    											
			    											out.println("<textarea name=\"descripcionFaq" + idiomasTraducibles[i].trim() + "\" rows=\"10\" style=\"width:350px\" class=\"ta_minimo_ancho\" id=\"DescripcionFaq\" title=\"" + literalDescripcionFaqTooltip + "\"></textarea>");
			    										out.println("</span></object>");
    													}else
		    											{						    														    											
    														out.println("<div class=\"contenedor_derecha\">");
    															out.println("<div class=\"text\">");
    																out.println("<textarea DISABLED name=\"descripcionFaq\" rows=\"10\" cols=\"40\" class=\"ta_minimo_ancho\"  style=\"width:350px\" onblur=\"this.style.backgroundColor='#e1e1e1'\" id=\"comentario\"  title=\"" + literalDescripcionFaqTooltip + "\" >"+valueDescripcion+"");
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
	   			logger.error("Error pintando el alta de faqs",e);	    			
	   		 }
	   		 catch (Exception e) 
	   		 {
	   			 logger.error("Error pintando el alta de faqs",e);
	   		 }
	    	return SKIP_BODY;
	    }	    
	    /**
		 * doEndTag is called by the JSP container when the tag is closed
		 */
			public int doEndTag(){
				return SKIP_BODY; 
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
						logger.error("Error recuperando el locale de la request",e);					
					}
				}
				return locale;
			}
			
//			MÉTODOS PARA PINTAR LOS MENSAJES INTERNACIONALIZADOS
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
		
		private String[] dameArrayPosicion(Object es, Object en, Object va, Object gl, Object eu, Object ca, String idioma) throws Exception
		{
			String[] array = null;
			if (this.getPropertyValue("castellano").equals(idioma))
			{ 
				Collection esCollection = (Collection)es;
				String[] esArray = (String[])esCollection.toArray(new String[0]);
				array = esArray;
			}
			
			else if (this.getPropertyValue("ingles").equals(idioma))
			{
				Collection enCollection = (Collection)en;
				String[] enArray = (String[])enCollection.toArray(new String[0]);
				array = enArray;
			}
			
			else if (this.getPropertyValue("catalan").equals(idioma))
			{
				Collection caCollection = (Collection)ca;
				String[] caArray = (String[])caCollection.toArray(new String[0]);
				array = caArray;
			}
			
			else if (this.getPropertyValue("valenciano").equals(idioma))
			{
				Collection vaCollection = (Collection)va;
				String[] vaArray = (String[])vaCollection.toArray(new String[0]);
				array = vaArray;
			}
			
			else if (this.getPropertyValue("gallego").equals(idioma))
			{
				Collection glCollection = (Collection)gl;
				String[] glArray = (String[])glCollection.toArray(new String[0]);
				array = glArray;
			
			}
			else if (this.getPropertyValue("euskera").equals(idioma))
			{
				Collection euCollection = (Collection)eu;
				String[] euArray = (String[])euCollection.toArray(new String[0]);
				array = euArray;
			
			}
			return array;
			
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
		
		private boolean estaLleno (String var) throws Exception
		{
			return (var != null && !"".equals(var));
		}
		
		private boolean abrirGloboFaq (String valueTitulo, String valueDescripcion, String valuePos, String valueCategoria, String idiomaCategoria, String[] idiomasBBDD) throws Exception
		{
			return (estaLleno(valueTitulo) || estaLleno(valueDescripcion) || (estaLleno(valuePos) && !"0".equals(valuePos)) || (estaLleno(valueCategoria) && !estaBBDD(idiomaCategoria, idiomasBBDD) && !ACTIONVERFAQ.equals(action)));
		}
		
		private boolean estaBBDD(String idiomaCategoria, String[] idiomasBBDD) throws Exception
		{
			boolean encontrado = false;
			for (int i = 0; idiomasBBDD != null && !encontrado && i < idiomasBBDD.length; i++)			
				if (idiomaCategoria.equals(idiomasBBDD[i])) encontrado = true;
			return encontrado;			
		}
		
		private String devuelveDescripcionVerNoticia (String descripcion) throws Exception
		{
			//Se quita el parrafo (<p> y </p>)
			String[] descripcionSplit = descripcion.split("<p>");
			String descripcionAux = descripcionSplit[1];
			String[] descripcionSplitAux = descripcionAux.split("</p>");
			return (descripcionSplitAux[0]);		
		}
	
}