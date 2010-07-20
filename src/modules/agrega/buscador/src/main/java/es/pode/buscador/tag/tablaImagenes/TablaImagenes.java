/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.buscador.tag.tablaImagenes;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.log4j.Logger;

import es.pode.buscador.presentacion.basico.listar.ListarAreaCurricularColumDecorator;
import es.pode.buscador.presentacion.basico.listar.ListarTipoRecursoColumDecorator;
import es.pode.buscador.tag.formato.FormatoTag;
import es.pode.buscador.tag.valoracion.ValoracionTag;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
import org.apache.commons.lang.StringUtils;

public class TablaImagenes extends BodyTagSupport {
	
	private java.util.Properties pSpringProperties = null;
	private static Logger logger = Logger.getLogger(TablaImagenes.class);	
	
	private final static String PUNTO = "\\.";
	
	private static final long serialVersionUID = 1L;	
	private static final int divisionPar=2;
	private String titulo = null;
	private String identificadorODE = null;
	private String url = null;
	private String valoracion = null;	
	private String descripcion = null;
	private String[] autores = null;
    private String size = null;
    private String typLearningTime = null;
	
	private String nivelAgregacionTexto = null;
	private String[] formato = null;
    private String[] cProviders = null;
	private String numeroODE = null;
	private String urlImagen = null;
	private String nodo = null;
	private int contador = 0;	
	private Object areaCurricular = null;
	private Object tipoRecurso = null;	
	private boolean usuarioAdministrador =false;
	private Boolean esVisualizable = null;
	
	
	public String getIdentificadorODE() {
		return identificadorODE;
	}
	public void setIdentificadorODE(String identificadorODE) {
		this.identificadorODE = identificadorODE;
	}
	public Object getTipoRecurso() {
		return tipoRecurso;
	}
	public void setTipoRecurso(Object tipoRecurso) {
		this.tipoRecurso = tipoRecurso;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}		
	public String[] getAutores() {
		return autores;
	}
	public void setAutores(String[] autores) {
		this.autores = autores;
	}		
	public Object getAreaCurricular() {
		return areaCurricular;
	}
	public void setAreaCurricular(Object areaCurricular) {
		this.areaCurricular = areaCurricular;
	}
	public String getValoracion() {
		return valoracion;
	}
	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getnivelAgregacionTexto(){
		return nivelAgregacionTexto;
	}
	public void setnivelAgregacionTexto (String nivelAgregacionTexto){
		this.nivelAgregacionTexto = nivelAgregacionTexto;
	}
	public String[] getFormato() {
		return formato;
	}
	public void setFormato(String[] formato) {
		this.formato = formato;
	}
	public String[] getContentProviders() {
		return cProviders;
	}
	public void setContentProviders(String[] cProviders) {
		this.cProviders = cProviders;
	}
	public String getNumeroODE() {
		return numeroODE;
	}
	public void setNumeroODE(String numeroODE) {
		this.numeroODE = numeroODE;
	}
	public String getUrlImagen() {
		return urlImagen;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}	
	public boolean getUsuarioAdministrador() {
		return usuarioAdministrador;
	}
	public void setUsuarioAdministrador(boolean usuarioAdministrador) {
		this.usuarioAdministrador = usuarioAdministrador;
	}
	public Boolean getEsVisualizable(){
		return esVisualizable;
	}
	public void setEsVisualizable (Boolean esVisualizable){
		this.esVisualizable = esVisualizable;
	}
    public String getSize() {
        return this.size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public String getTypicalLearningTime() {
        return this.typLearningTime;
    }
    public void setTypicalLearningTime(String typLearningTime) {
        this.typLearningTime = typLearningTime;
    }

	/**
	* doStartTag is called by the JSP container when the tag is encountered
	*/
	    public int doStartTag() throws JspException{
	    	try {	    		
	    		
	    		JspWriter out = pageContext.getOut();	    		
	    		
	    		//RECUPERAMOS EL AREA CURRICULAR DEL DECORATOR
	    		ListarAreaCurricularColumDecorator areaCurricularTag = new ListarAreaCurricularColumDecorator();
	    			String htmlAreaCurricular = (String)areaCurricularTag.decorate(areaCurricular, pageContext, null);
	    			
	    		//RECUPERAMOS EL TIPO DE RECURSO DEL DECORATOR 
    			ListarTipoRecursoColumDecorator tipoRecursoTag = new ListarTipoRecursoColumDecorator();    			
    				String htmlTipoRecurso = (String)tipoRecursoTag.decorate(tipoRecurso, pageContext, null);
    				String htmlCuadroTipoRecurso = (String)tipoRecursoTag.concatenaArrayString((String[])tipoRecurso);
    			    				
    			//RECUPERAMOS EL NIVEL DE AGREGACION
    				String htmlNivelAgregacion = this.getnivelAgregacionTexto();
    				
    			//RECUPERAMOS LOS TIPOS DE FORMATO
    				String[] tiposFormato = this.getFormato();
    				
//    				String htmlTiposFormato = "";
//    				for (int i=0;i<tiposFormato.length;i++){
//    					htmlTiposFormato = htmlTiposFormato + tiposFormato[i]+", ";
//    				}
    				
    				
    			//REALIZAMOS EL TRATAMIENTO DE LOS LITERALES PARA PODER INTRODUCIRLOS EN EL CÓDIGO HTML
    			String fichero="application-resources";
    			Locale locale = null;
				try {
					locale = devuelveLocale();
				} catch (Exception e) {
					logger.error("Error recuperando el locale",e);
				}
    			String literalTitu=this.getResource("listar.odecu.mostrar.resultados.consulta.vo.titulo", fichero, locale);	
    			String literalDescripcion=this.getResource("listar.odecu.mostrar.resultados.consulta.vo.descripcion", fichero, locale);	
    			String literalAutores=this.getResource("listar.odecu.mostrar.resultados.consulta.vo.autor", fichero, locale);	
    			String literalArea=this.getResource("listar.odecu.mostrar.resultados.consulta.vo.area.curricular", fichero, locale);
    			String literalAgregacion=this.getResource("listar.odecu.mostrar.resultados.consulta.vo.nivel.agregacion", fichero, locale);
    			String literalRecurso=this.getResource("listar.odecu.mostrar.resultados.consulta.vo.tipo.recurso", fichero, locale);
    			String literalFormato=this.getResource("listar.odecu.mostrar.resultados.consulta.vo.tipo.formato", fichero, locale);
    			String literalValora=this.getResource("listar.odecu.mostrar.resultados.consulta.vo.valoracion", fichero, locale);    
    			String literalVerMasRecursos=this.getResource("listar.odecu.mostrar.resultados.consulta.vo.ver.mas", fichero, locale);
    			String literalAplicacion=this.getResource("listar.odecu.mostrar.resultados.consulta.vo.aplicacion", fichero, locale);
    			String literalTexto=this.getResource("listar.odecu.mostrar.resultados.consulta.vo.texto", fichero, locale);
    			String literalImagen=this.getResource("listar.odecu.mostrar.resultados.consulta.vo.imagen", fichero, locale);
    			String literalAudio=this.getResource("listar.odecu.mostrar.resultados.consulta.vo.audio", fichero, locale);
    			String literalVideo=this.getResource("listar.odecu.mostrar.resultados.consulta.vo.video", fichero, locale);
                String literalSize=this.getResource("listar.odecu.mostrar.resultados.consulta.vo.size", fichero, locale);
                String literalCProviders=this.getResource("listar.odecu.mostrar.resultados.consulta.vo.contentProvider", fichero, locale);
                String literalTypLearningTime=this.getResource("listar.odecu.mostrar.resultados.consulta.vo.typicalLearningTime", fichero, locale);

//    			Ampliar la imagen de la galeria
    			String urlImagenReturn = "";
    			String imagenSmall = this.getPropertyValue("imagen.ampliada.png");
    			String imagenAmpliada = this.getPropertyValue("imagen.ampliada.captured");    			
    			String[] urlImagenArray = urlImagen.split(PUNTO);
    			for(int i=0; urlImagenArray!=null && i<urlImagenArray.length; i++){
    				if((imagenSmall).equals(urlImagenArray[i]))
    					urlImagenArray[i] = imagenAmpliada;
    				urlImagenReturn = urlImagenReturn + urlImagenArray[i];
    			}
    			
    			if(nodo!=null && !nodo.trim().equals("")){
    				urlImagenReturn = "http://"+nodo+urlImagenReturn.trim();
    				urlImagen="http://"+nodo+urlImagen.trim();
    			}else{
    				urlImagenReturn = "http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+urlImagenReturn.trim();
    				urlImagen="http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+urlImagen.trim();
    			}
    	

			// NEW: Results table layout based upon CSS
			// Output the surrounding white box
			out.println("<div class=\"results_outline\">");

			// IE6/7 alert: we need a positioned ancestor for
			// the image thumbnail to appear in the right place
			out.println("<div class=\"results_outline_wrapper\">");

			// If an administrator, supply a link allowing us to unpublish
			if (usuarioAdministrador && (this.nodo==null || this.nodo.equals(""))){
	    			out.println("<div class=\"results_select\">");
    				out.println("<label for=\"ch01\" class=\"etiq_invisible\" >Seleccione </label><input type=\"checkbox\" id=\"" + this.getIdentificadorODE() + "\" "	+ " name=\"idRowSelectionAsArray\" value=\"" + this.getIdentificadorODE() + "\"/>");
	    			out.println("</div>");
    			}

			// Output the search counter followed by the title
			out.println("<div class=\"results_title\">" + this.contador + ". ");

			// Add the link if available
			if (esVisualizable.booleanValue()){
				out.println("<a href=\""+"http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+url+"\">" + titulo + "</a>");
			}else{
				out.println("<span class=\"restringido\">"+titulo + "</span>");
			}
			out.println("</div>");

			// Output the image
			out.println("<div class=\"results_image\">");

			// Display the thumbnail 
    			if (esVisualizable.booleanValue()){
    				out.println("<a href=\"" + "http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+url + "\" class=\"imagen_tab\"><img  src=\"" + urlImagen + "\" alt=\"Imagen&nbsp;" + numeroODE + "\" /></a>");
    			}else{
    				out.println("<img  src=\"" + urlImagen + "\" alt=\"Imagen&nbsp;" + numeroODE + "\" />");
    			}
			out.println("</div>");

			// Output a div containing the search results
			out.println("<div class=\"results_table\">");

			// Output the description
			out.println("<div class=\"results_row1\">");
			out.println("<span class=\"results_fieldheading\">" + literalDescripcion + ":</span>");
			out.println("<span class=\"results_fieldtext\">");
			out.println(this.descripcion);
			out.println("</span>");
			out.println("</div>");

			// Output the format
			out.println("<div class=\"results_row2\">");

			// Output the author
			out.println("<div class=\"results_fields_right\">");
			out.println("<span class=\"results_fieldheading\">" + literalAutores + ":</span>");
			out.println("<span class=\"results_fieldtext\">");
			out.println(array2String(autores, ", "));
			out.println("</span>");
			out.println("<br class=\"results_field\">");

			// Output the "Contributor"
			out.println("<span class=\"results_fieldheading\">" + literalCProviders + ":</span>");
			out.println("<span class=\"results_fieldtext\">" + array2String(cProviders, ", ") + "</span>");
			out.println("<br class=\"results_field\">");

			// Output the rating
			out.println("<span class=\"results_fieldheading\">" + literalValora + ":</span>");
			out.println("<span class=\"results_fieldtext\">");

			//REALIZAMOS EL TRATAMIENTO DE LAS ESTRELLAS DE VALORACION LLAMANDO AL MÉTODO YA EXISTENTE

			ValoracionTag estrellasValoracion = new ValoracionTag();
			estrellasValoracion.calcularEstrellas(valoracion,out,pageContext.getRequest(),"");

			out.println("</span>");
			out.println("</div>");

			out.println("<div class=\"results_fields_left\">");
			out.println("<span class=\"results_fieldheading\">" + literalFormato + ":</span>");
            		FormatoTag tagFormato = new FormatoTag();
			out.println("<span class=\"results_fieldtext\">");
			tagFormato.pintarFormato(tiposFormato,literalAplicacion,literalTexto,literalImagen,literalAudio,literalVideo,out);
			out.println("</span>");
			out.println("<br />");

			// Output the "Typical Learning Time"
			out.println("<span class=\"results_fieldheading\">" + literalTypLearningTime + ":</span>");
			out.println("<span class=\"results_fieldtext\">" + typLearningTime + "</span>");
			out.println("<br class=\"results_field\">");

            		// Output Curricular
			out.println("<span class=\"results_fieldheading\">" + literalArea + ":</span>");
			out.println("<span class=\"results_fieldtext\">" + htmlAreaCurricular + "</span>");

			out.println("</div>");
			out.println("</div>");

			// End of the search results table
			out.println("</div>");

			// Clear the float so that the white fills downwards
			out.println("<div class=\"results_table_end\">&nbsp;</div>");

			// Finish the IE6/7 wrapper div
			out.println("</div>");

			// Finish the surrounding white box
			out.println("</div>");

/*	
    			//CÓDIGO HTML	    		
    			out.println("<tr class=\"tr_blanco\">");

			// Output a summary row
			out.println("<td class=\"results_title\" style=\"border: 1px red solid;\" valign=\"top\" class=\"ancho_det sin_e_pad\" colspan=\"2\">");
			out.println(this.contador + ". " + titulo);
			out.println("</td>");	
			out.println("</tr>");

    			out.println("<tr class=\"tr_blanco\">");

			// Only display a thumbnail if one is available
    			if (esVisualizable.booleanValue()){
    				out.println("<td  valign=\"top\" class=\"ancho_det sin_e_pad\"><a href=\"" + "http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+url + "\" class=\"imagen_tab\"><img  src=\"" + urlImagen + "\" alt=\"Imagen&nbsp;" + numeroODE + "\" /></a></td>");
    			}else{
    				out.println("<td  valign=\"top\" class=\"ancho_det sin_e_pad\"><img  src=\"" + urlImagen + "\" alt=\"Imagen&nbsp;" + numeroODE + "\" /></td>");
    			}

    			out.println("<td valign=\"top\"  class=\"sin_e_pad\"><strong class=\"numeracion_imagen\">" + numeroODE + "</strong>");
    			if (usuarioAdministrador && (this.nodo==null || this.nodo.equals(""))){
	    			out.println("<div class=\"check_flotante\">");
    				out.println("<label for=\"ch01\" class=\"etiq_invisible\" >Seleccione </label><input type=\"checkbox\" id=\"" + this.getIdentificadorODE() + "\" "	+ " name=\"idRowSelectionAsArray\" value=\"" + this.getIdentificadorODE() + "\"/>");
	    			out.println("</div>");
    			}
			    			
   			out.println("<table border=\"0\" style=\"border:0\" class=\"resultados_listados\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" summary=\"Tabla de Resultado de Búsqueda\">");

			// Output the Description and Resource Type headers
    			out.println("<tr>");
			out.println("<td class=\"ancho_tab_min_0\" valign=\"top\"><span>" + literalDescripcion + "<br/></span>");
			out.println("<span>" + this.descripcion + "</span></td>");
			out.println("<td class=\"ancho_tab_min_0\"  valign=\"top\"><span>" + literalRecurso + "</span></td>");
    			out.println("</tr>");
    			out.println("<tr>");
			out.println("<td class=\"ancho_tab_min\" valign=\"top\"><span>" + this.descripcion + "</span></td>");
			out.println("<td class=\"ancho_tab_min\" valign=\"top\"><span>" + htmlTipoRecurso + "</span></td>");
    			out.println("</tr>");

			// Output the Format and Author headers
    			out.println("<tr>");
			out.println("<td class=\"ancho_tab_min_0\" valign=\"top\"><span>" + literalFormato + "</span></td>");
			out.println("<td class=\"ancho_tab_min_0\" valign=\"top\"><span>" + literalAutores + "</span></td>");
    			out.println("</tr>");
    			out.println("<tr>");
			out.println("<td class=\"ancho_tab_min\" valign=\"top\">");

			FormatoTag tagFormato = new FormatoTag();
			tagFormato.pintarFormato(tiposFormato,literalAplicacion,literalTexto,literalImagen,literalAudio,literalVideo,out);
			out.println("</td>");
			out.println("<td class=\"ancho_tab_min\" valign=\"top\"><span>Fiona Inglesias</span></td>");
			out.println("</tr>");


			// Output the Rating and Curriculum headers
			out.println("<tr>");
			out.println("<td class=\"ancho_tab_min_0\" valign=\"top\"><span>" + literalValora + "</span></td>");
			out.println("<td class=\"ancho_tab_min_0\" valign=\"top\"><span>" + literalArea + "</span></td>");
			out.println("</tr>");
			
			//out.println("<div class=\"valoracion\">");
			//out.println("<ul>");
			//REALIZAMOS EL TRATAMIENTO DE LAS ESTRELLAS DE VALORACION LLAMANDO AL MÉTODO YA EXISTENTE

			// Temporarily make the stars interesting...
			out.println("<tr>");
	    		out.println("<td class=\"ancho_tab_min\" valign=\"top\">");

			valoracion = new Float(Math.random() * 5).toString();
			ValoracionTag estrellasValoracion = new ValoracionTag();
			estrellasValoracion.calcularEstrellas(valoracion,out,pageContext.getRequest(),"");

	    		out.println("</td>");
			out.println("<td class=\"ancho_tab_min\" valign=\"top\">" + htmlAreaCurricular + "</td>");

			//out.println("</ul>");
    			//out.println("</div>");

	    		out.println("</td>");
		    	out.println("</tr>");
*/
/*			MCA: Leave this for a bit...
			if (htmlTipoRecurso.endsWith("...</span></p></a>")){
				out.println("&nbsp;" +"<a href=\"#\" class=\"mas_informacion\">"+ "<em>"+ literalVerMasRecursos+"</em>"+ htmlCuadroTipoRecurso + "</td>");
			}
*/
/*
			out.println("</table>");
			out.println("</td>");
			out.println("</tr>");					
*/					
	    	} catch (IOException e) {
	    		// TODO Auto-generated catch block
	    		logger.error("TablaImagenes - Error formando tabla de imágenes",e);	    		
	    	}catch (Exception e) {
	    		// TODO Auto-generated catch block
	    		logger.error("TablaImagenes - Error formando tabla de imágenes",e);	    		
	    	}
	    	return SKIP_BODY;	
	    }	    
	    /**
		 * doEndTag is called by the JSP container when the tag is closed
		 */
			public int doEndTag(){
				return SKIP_BODY; 
			}
			
//			MÉTODOS PARA PINTAR LOS MENSAJES INTERNACIONALIZADOS
		public static String getResource(String key, String baseName, Locale locale){
	        String recurso = "";
	        try{
	        	ResourceBundle theResourceBundle = getResource(baseName,locale);
	        	if (theResourceBundle!=null){
	               recurso = theResourceBundle.getString(key);
	           }
	        }catch (MissingResourceException mre){
	        	recurso = key;
	        }catch (Exception e){
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
	        }catch (Exception e){
	        	logger.error("TablaImagenes - Error recuperando literal para="+baseName+" ",e);
	        	return null;
	        }
	    }   
	    
	        
	    //Método que comprueba si el contador es par o impar. De esta manera el fondo de la tabla será gris o blanco
	    private boolean esPar(int contador){	    	
	    	if(contador%divisionPar==0)
	    		return true;
	    	else
	    		return false;
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
	    
	    private String getPropertyValue(String sKey) throws IOException {
	    	try{
	    		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/spring_buscador.properties");
				if (this.pSpringProperties == null) {
					pSpringProperties = new java.util.Properties();
					pSpringProperties.load(fIsSpringProperties);
				}
				fIsSpringProperties.close();
				logger.debug("BuscarAvanzadoControllerImpl - getPropertyValue: Propiedad recuperada: " + sKey + " : "+ pSpringProperties.getProperty(sKey));
//				 devolvemos la propiedad
	            
	        }catch (Exception e){
        		logger.error("TablaImagenes - Error recuperando propiedad de spring_buscador.properties=",e);
	        }
			
			return pSpringProperties.getProperty(sKey);
		}
		public String getNodo() {
			return nodo;
		}
		public void setNodo(String nodo) {
			this.nodo = nodo;
		}
		private String array2String(String arr[], String sep)
		{
			return StringUtils.join(arr, sep);
		}
}
