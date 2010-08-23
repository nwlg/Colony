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
import java.util.HashMap;

public class FormatoTag extends BodyTagSupport {
	
	private static Logger logger = Logger.getLogger(FormatoTag.class);

        private static String SPECIAL_MIME_CONTENT_TYPE = "listar.odecu.mostrar.resultados.consulta.vo.extra_mime_content_type";


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







//I know that is not the best place to put in!!!
//17/08/2010 Fernando Garcia:
/* The idea is fill hashCustomMimeContentTypes where keys are the custom mime content types
 * and the values are the custom html code to print
 */
        public HashMap<String, ItemStringBooleanVO> getCustomMimeContentTypes(String fichero, Locale locale,
                String literalAplicacion, String literalTexto, String literalImagen, String literalAudio, String literalVideo
                ) {
logger.info("getCustomMimeContentTypes INI");
            HashMap<String, ItemStringBooleanVO> hashCustomMimeContentTypes = new HashMap<String, ItemStringBooleanVO>(5);
            String customMimeContentType = null;
            String customMimeContentTypeText = null;
            String customMimeContentTypeImage = null;

            int index = 1;//It will start always like 1
            customMimeContentType = this.getResource(SPECIAL_MIME_CONTENT_TYPE+index, fichero, locale);
logger.debug("getCustomMimeContentTypes index="+index);
            //!customMimeContentType.equals(SPECIAL_MIME_CONTENT_TYPE+index ... WHY?
            //getResource if doesn't find the resource assigns key like value ... so
            // this.getResource(SPECIAL_MIME_CONTENT_TYPE+index, fichero, locale) ==
            // == SPECIAL_MIME_CONTENT_TYPE+index if it doesn't exists
            while (!customMimeContentType.equals(SPECIAL_MIME_CONTENT_TYPE+index)){//if exists
                customMimeContentTypeText =
                        this.getResource(SPECIAL_MIME_CONTENT_TYPE+index+".text", fichero, locale)!=null?
                            this.getResource(SPECIAL_MIME_CONTENT_TYPE+index+".text", fichero, locale)
                            :
                            getDefaultText( customMimeContentType,  literalAplicacion,  literalTexto,  literalImagen,  literalAudio,  literalVideo);
                customMimeContentTypeImage =
                        this.getResource(SPECIAL_MIME_CONTENT_TYPE+index+".image", fichero, locale)!=null?
                            this.getResource(SPECIAL_MIME_CONTENT_TYPE+index+".image", fichero, locale)
                            :
                            getDefaultImage( customMimeContentType);

                //And we store it into the hash
                hashCustomMimeContentTypes.put(customMimeContentType.toLowerCase().trim(),
                        new ItemStringBooleanVO(
                    "<img src='http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio() +
                    customMimeContentTypeImage + "' alt="+customMimeContentTypeText+" title="+customMimeContentTypeText+" />" + "&nbsp;"
                        , false)
                );

                index++; //Try next one
                customMimeContentType = this.getResource(SPECIAL_MIME_CONTENT_TYPE+index, fichero, locale);
                logger.debug("getCustomMimeContentTypes index="+index);
            }
        logger.info("getCustomMimeContentTypes END");
        return hashCustomMimeContentTypes;
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
//17/08/2010 Fernando Garcia: We have to prepare to struture with custom mime content-types
                        HashMap<String, ItemStringBooleanVO> hashCustomMimeContentTypes = getCustomMimeContentTypes
                        (fichero, locale, literalAplicacion, literalTexto, literalImagen, literalAudio, literalVideo );

			this.pintarFormato(tiposFormato, hashCustomMimeContentTypes, literalAplicacion,literalTexto,literalImagen,literalAudio,literalVideo,out);
		
		} catch (Exception e) {			
			logger.error("Error al dibujar los formatos", e);			
		}
		return SKIP_BODY;	
	}

/**
 * 17/08/2010 Fernando Garcia
 * Default text for a kind of mime content type
 * @param mimeContentType
 * @param literalAplicacion
 * @param literalTexto
 * @param literalImagen
 * @param literalAudio
 * @param literalVideo
 * @return defaul text
 */
        private String getDefaultText(String mimeContentType, String literalAplicacion, String literalTexto, String literalImagen, String literalAudio, String literalVideo) {

            if (mimeContentType.toLowerCase().trim().startsWith("application/")){
                return literalAplicacion;
            }
            if (mimeContentType.toLowerCase().trim().startsWith("text/")){
                return literalAplicacion;
            }
            if (mimeContentType.toLowerCase().trim().startsWith("image/")){
                return literalAplicacion;
            }
            if (mimeContentType.toLowerCase().trim().startsWith("audio/")){
                return literalAplicacion;
            }
            if (mimeContentType.toLowerCase().trim().startsWith("video/")){
                return literalAplicacion;
            }

            return "";//no recognized

        }

 /**
  * 17/08/2010 Fernando Garcia
  * Default image for a kind of mime content type
  * @param mimeContentType
  * @return default image path
  */
        private String getDefaultImage(String mimeContentType) {

            if (mimeContentType.toLowerCase().trim().startsWith("application/")){
                return "/static/img/icon_aplicacion.gif";
            }
            if (mimeContentType.toLowerCase().trim().startsWith("text/")){
                return "/static/img/icon_texto.gif";
            }
            if (mimeContentType.toLowerCase().trim().startsWith("image/")){
                return "/static/img/icon_imagen.gif";
            }
            if (mimeContentType.toLowerCase().trim().startsWith("audio/")){
                return "/static/img/icon_audio.gif";
            }
            if (mimeContentType.toLowerCase().trim().startsWith("video/")){
                return "/static/img/icon_video.gif";
            }

            return "";//no recognized

        }




	public int doEndTag() throws JspException {
		return SKIP_BODY;
	}	

/**
 * 17/08/2010 Fernando Garcia: I have modified this method. Now behavior is first try to find out if is
 * a custom mime content-type. If no, it will paint it like a general type (there are 5 general types)
 *
 */

	public void pintarFormato (String[] tiposFormato, HashMap<String, ItemStringBooleanVO> hashCustomMimeContentTypes, String literalAplicacion, String literalTexto, String literalImagen, String literalAudio, String literalVideo, JspWriter out) throws IOException{

logger.info("pintarFormato INI");
    	boolean[] existe= new boolean[5];

        for (int i=0;i<tiposFormato.length;i++){
            logger.debug("pintarFormato i="+i);
            //for every tiposFormato
            // first we have to see if is a custom mime content-type at hashCustomMimeContentTypes
            if (hashCustomMimeContentTypes.containsKey(tiposFormato[i].toLowerCase().trim())
                &&
                !hashCustomMimeContentTypes.get(tiposFormato[i].toLowerCase().trim()).itemBoolean
                    ) {
                //we know this custom mime c.-t. and it's first time that we deal with it
                hashCustomMimeContentTypes.get(tiposFormato[i].toLowerCase().trim()).itemBoolean = true;//we won't use it again
                out.println(hashCustomMimeContentTypes.get(tiposFormato[i].toLowerCase().trim()).itemString);//print out

            } else {
                if (!hashCustomMimeContentTypes.containsKey(tiposFormato[i].toLowerCase().trim())) {//it's a general type?
                    if (tiposFormato[i].trim().startsWith("application/") && !existe[0]){
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
	}//for
logger.info("pintarFormato END");
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
