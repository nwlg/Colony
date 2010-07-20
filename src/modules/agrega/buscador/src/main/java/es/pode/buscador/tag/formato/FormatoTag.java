/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.buscador.tag.formato;

import java.io.IOException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.log4j.Logger;

import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

public class FormatoTag extends BodyTagSupport {
	
	private static Logger logger = Logger.getLogger(FormatoTag.class);
	
	private String literalApli = null;
	private String literalText = null;
	private String literalImag = null;
	private String literalAud = null;
	private String literalVid = null;
	private String formato = null;

	
	public String getLiteralApli() {
		return literalApli;
	}
	public void setLiteralApli(String literalApli) {
		this.literalApli = literalApli;
	}
	public String getLiteralText() {
		return literalText;
	}
	public void setLiteralText(String literalText) {
		this.literalText = literalText;
	}
	public String getLiteralImag() {
		return literalImag;
	}
	public void setLiteralImag(String literalImag) {
		this.literalImag = literalImag;
	}
	public String getLiteralAud() {
		return literalAud;
	}
	public void setLiteralAud(String literalAud) {
		this.literalAud = literalAud;
	}
	public String getLiteralVid() {
		return literalVid;
	}
	public void setLiteralVid(String literalVid) {
		this.literalVid = literalVid;
	}
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();

		try {	
			
//			REALIZAMOS EL TRATAMIENTO DE LOS LITERALES PARA PODER INTRODUCIRLOS EN EL CÓDIGO HTML
			String fichero="application-resources";
			Locale locale = null;
			try {
				locale = devuelveLocale();
			} catch (Exception e) {
				logger.error("Error recuperando el locale",e);
			}
			
			String literalAplicacion=this.getResource(literalApli, fichero, locale);
			String literalTexto=this.getResource(literalText, fichero, locale);
			String literalImagen=this.getResource(literalImag, fichero, locale);
			String literalAudio=this.getResource(literalAud, fichero, locale);
			String literalVideo=this.getResource(literalVid, fichero, locale);

//			RECUPERAMOS LOS TIPOS DE FORMATO			
			String[] tiposFormato = formato.split(",");			
			//Se pinta los formatos
			this.pintarFormato(tiposFormato,literalAplicacion,literalTexto,literalImagen,literalAudio,literalVideo,out);
		
		} catch (Exception e) {			
			logger.error("Error al dibujar los formatos", e);			
		}
		return SKIP_BODY;	
	}

	public int doEndTag() throws JspException {
		return SKIP_BODY;
	}	
	
	public void pintarFormato (String[] tiposFormato,String literalAplicacion, String literalTexto, String literalImagen, String literalAudio, String literalVideo, JspWriter out) throws IOException{
    	
    	boolean[] existe= new boolean[5];
		for (int i=0;i<tiposFormato.length;i++){
			if ((tiposFormato[i].trim().equals("application/pdf") || tiposFormato[i].trim().equals("application/msword")) && !existe[1]){
				out.println("<img src='http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+"/static/img/icon_texto.gif' alt="+literalTexto+" title="+literalTexto+" />" + "&nbsp;");
				existe[1]=true;
				}else if (tiposFormato[i].trim().startsWith("application/") && !existe[0]){
					out.println("<img src='http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+"/static/img/icon_aplicacion.gif' alt="+literalAplicacion+" title="+literalAplicacion+" />" + "&nbsp;");
					existe[0]=true;
					}else if (tiposFormato[i].trim().startsWith("text/") && !existe[1]){
						out.println("<img src='http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+"/static/img/icon_texto.gif' alt="+literalTexto+" title="+literalTexto+" />" + "&nbsp;");
						existe[1]=true;
						}else if (tiposFormato[i].trim().startsWith("image/") && !existe[2]){
							out.println("<img src='http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+"/static/img/icon_imagen.gif' alt="+literalImagen+" title="+literalImagen+" />" + "&nbsp;");
							existe[2]=true;
							}else if (tiposFormato[i].trim().startsWith("audio/") && !existe[3]){
								out.println("<img src='http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+"/static/img/icon_audio.gif' alt="+literalAudio+" title="+literalAudio+" />" + "&nbsp;");
								existe[3]=true;
								}else if (tiposFormato[i].trim().startsWith("video/") && !existe[4]){
									out.println("<img src='http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+"/static/img/icon_video.gif' alt="+literalVideo+" title="+literalVideo+" />" + "&nbsp;");
									existe[4]=true;
								}
		}
    }
	
//	MÉTODOS PARA PINTAR LOS MENSAJES INTERNACIONALIZADOS
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
	
}
