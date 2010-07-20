/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.buscador.presentacion.basico.enviarMail;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.buscador.presentacion.mail.MailSender;
import es.pode.soporte.auditoria.registrar.RegistroExterno;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.buscador.presentacion.basico.enviarMail.EnviarMailController
 */
public class EnviarMailControllerImpl extends EnviarMailController
{

	private java.util.Properties pSpringProperties = null;		
	
	private final static int MAX_RESUMEN = 400;
	private final static String FICHERO="application-resources";
	private final static String FORMULARIO_VALIDO = "FORMULARIO_VALIDO";
	private final static String FORMULARIO_INVALIDO = "FORMULARIO_INVALIDO";
	
	private final static String BARRA = "/";
	
	private final static String TEXTO_BODY_CABECERA = "texto.body.cabecera";
	private final static String TEXTO_BODY = "texto.body";
	private final static String TEXTO_BODY_ALT = "texto.body.imagen.alt";
	private final static String TEXTO_BODY_RESUMEN = "texto.body.Resumen";	
	private final static String TEXTO_BODY_TITULO = "texto.body.un.amigo.titulo";
	private final static String TEXTO_BODY_DESPEDIDA1 = "texto.body.despedida1";
	private final static String TEXTO_BODY_DESPEDIDA2 = "texto.body.despedida2";
	private final static String TEXTO_BODY_DESPEDIDA3 = "texto.body.despedida3";	
	private final static String TEXTO_BODY_ENLACE_AGREGA = "texto.body.enlace.agrega";
	private final static String TEXTO_BODY_ENLACE_MINI_SITE = "texto.body.enlace.mini.site";
	private final static String TEXTO_SUBJECT = "texto.subject";	
	private final static String TEXTO_URL = "texto.url";
	private final static String IMAGEN_HTTP = "url.imagen.http";
	private final static String IMAGEN_STATIC = "url.imagen.static";	
	private final static String COLOR_HEXADECIMAL = "color.hexadecimal";
	private final static String URL_MINI_SITE = "url.mini.site";
	
	public final static String ERROR_REGISTRAR_BBDD = "enviar.email.amigo.error.registrar.baseDatos";
	public final static String MENSAJE_CORREOS_DESTINATARIO_OBLIGATORIO = "enviar.email.amigo.error.destinatario.campo.obligatorio";
	public final static String MENSAJE_NOMBRES_DESTINATARIO_OBLIGATORIO = "enviar.email.amigo.error.nombre.destinatario.campo.obligatorio";
	public final static String MENSAJE_TU_CORREO_OBLIGATORIO = "enviar.email.amigo.error.tu.correo.campo.obligatorio";
	public final static String MENSAJE_TU_NOMBRE_OBLIGATORIO = "enviar.email.amigo.error.tu.nombre.campo.obligatorio";
	public final static String MENSAJE_FORMATO_EMAIL_INCORRECTO_DESTINATARIO = "enviar.email.amigo.error.formato.incorrecto.destinatario";
	public final static String MENSAJE_FORMATO_EMAIL_INCORRECTO_REMITENTE = "enviar.email.amigo.error.formato.incorrecto.remitente";
	public final static String MENSAJE_ERROR_DISTINTO_TAMANYO="enviar.email.amigo.error.distinto.tamanyo";
	public final static String MENSAJE_ERROR_MAX_CARACTERES_RESUMEN="enviar.email.amigo.error.max.caracteres.resumen";
	
	public final static String MENSAJE_IDIOMAS_BUSQUEDA = "listar.odecu.mostrar.resultados.consulta.cabecera.errorIdiomasBusqueda";	
	
	private static Logger logger = Logger.getLogger(EnviarMailControllerImpl.class);


    /**
     * @see es.pode.buscador.presentacion.basico.enviarMail.EnviarMailController#enviarMail(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.basico.enviarMail.EnviarMailForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void enviarMail(ActionMapping mapping, es.pode.buscador.presentacion.basico.enviarMail.EnviarMailForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {       	
    	List errores = new ArrayList();	
    	List erroresValidacion = new ArrayList();	
		Locale locale =(Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
    	form.setResultadoValidacion(FORMULARIO_VALIDO);
    	log("EnviarMailControllerImpl - enviarMail.");
        //Validamos los campos del formulario
        erroresValidacion = validaFormulario(form, request);
        if(erroresValidacion!=null && erroresValidacion.size()>0)
        {
        	form.setResultadoValidacion(FORMULARIO_INVALIDO);
        	errores.addAll(erroresValidacion);
        	
        }   
        else
        {
        	//Formamos la url de la imagen         	
        	String hrefLogo = this.getPropertyValue(IMAGEN_HTTP) + LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio();
        	String imagen =  form.getUrlImagen();
        	String srcImagen = this.getPropertyValue(IMAGEN_HTTP) + LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio() + this.getPropertyValue(IMAGEN_STATIC);
        	String[] destinatariosArray = form.getCorreosHasta().split(";");	
        	String[] nombresDestinatariosArray = form.getNombresHasta().split(";");        	
        	for(int i=0; i<destinatariosArray.length; i++ ){        		
        		if(enviarCorreo(destinatariosArray[i], this.getResource(TEXTO_SUBJECT, FICHERO,locale), construirBodyEmail(hrefLogo,srcImagen,form.getCorreoDesde(),form.getTitulo(), form.getUrlODE(), form.getNombreDesde(), form.getResumen(), nombresDestinatariosArray[i], imagen, locale), null))
        			if (logger.isDebugEnabled())logger.debug("Envio correcto del email para el destinatario ["+destinatariosArray[i]+"]");
        		else
					if (logger.isDebugEnabled())logger.debug("El email no se ha enviado correctamente al destinatario ["+destinatariosArray[i]+"]");
        	}
        	//Si el checkbox está pulsado se envía tambien al remitente
        	if(form.getEnviarRemitente()!=null && form.getEnviarRemitente().booleanValue())        		
				if(enviarCorreo(form.getCorreoDesde(), this.getResource(TEXTO_SUBJECT, FICHERO,locale), construirBodyEmail(hrefLogo,srcImagen,form.getCorreoDesde(),form.getTitulo(), form.getUrlODE(), form.getNombreDesde(), form.getResumen(), form.getNombreDesde(), imagen, locale),null))			
					if (logger.isDebugEnabled())logger.debug("Envio correcto del email para el destinario ["+form.getCorreoDesde()+"] ");
				else
					if (logger.isDebugEnabled())logger.debug("El email no se ha enviado correctamente al destinatario ["+form.getCorreoDesde()+"]");
        }
        
        //Se almacena en la base de datos el envio para que este accesible en auditoria. Los odes mas enviados.
        log("Se almacena en la BBDD el envio del ode con identificador en el idioma["+form.getIdioma()+"]");
        RegistroExterno registro = new RegistroExterno();        
        if (!registro.operacionEnviarCorreo(dameIdODE(form.getUrlODE()), form.getIdioma()))
        	saveErrorMessage(request, ERROR_REGISTRAR_BBDD);
        else
        	log("El envio del correo se ha registrado correctamente en la base de datos");
        
        if(errores!=null && errores.size()>0)
        	saveErrorMessage(request, errores);
    	   
     }


    /**
     * @see es.pode.buscador.presentacion.basico.enviarMail.EnviarMailController#prepararEnvio(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.basico.enviarMail.PrepararEnvioForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void prepararEnvio(ActionMapping mapping, es.pode.buscador.presentacion.basico.enviarMail.PrepararEnvioForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String idioma = "";
		try{
			idioma=LdapUserDetailsUtils.getIdioma();
			if (idioma == null)	idioma = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
		} catch (Exception e) {
			logger.error("EnviarMailControllerImpl - enviarMail: Error en al obtener idioma usuario LDAP, se recoge idioma de fichero propiedades.");
			idioma = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
		} 
     }
    
    public String analizaValidacion(ActionMapping mapping, AnalizaValidacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return form.getResultadoValidacion();
	}		
    
    private List validaFormulario(es.pode.buscador.presentacion.basico.enviarMail.EnviarMailForm form, HttpServletRequest request) throws Exception 
    {
    	List errores = new ArrayList();	    	
    	String[] destinatariosArray = form.getCorreosHasta().split(";");
    	String[] nombresDestinatariosArray = form.getNombresHasta().split(";");
    	
    	//Validamos si todos los campos estan rellenos
    	if(!isChangeable(form.getCorreosHasta()))
    		errores.add(MENSAJE_CORREOS_DESTINATARIO_OBLIGATORIO);  		
    	if(!isChangeable(form.getNombresHasta()))    	
    		errores.add(MENSAJE_NOMBRES_DESTINATARIO_OBLIGATORIO);    	
    	if(!isChangeable(form.getCorreoDesde()))    	
    		errores.add(MENSAJE_TU_CORREO_OBLIGATORIO);    	
    	if(!isChangeable(form.getNombreDesde()))    	
    		errores.add(MENSAJE_TU_NOMBRE_OBLIGATORIO);    	
    	
    	//Validamos si se ha excedido en el numero de caracteres del resumen
    	if(form.getResumen().length()>MAX_RESUMEN)    	
    		errores.add(MENSAJE_ERROR_MAX_CARACTERES_RESUMEN);    	
    		
    	//Validamos los emails de los destinatorios
    	for (int i=0; destinatariosArray!=null && i<destinatariosArray.length; i++)
    	{
    		if(isChangeable(destinatariosArray[i])){
	    		if(!validaTodosEmailsDestino(form.getCorreosHasta()).booleanValue())	    		
	    			errores.add(MENSAJE_FORMATO_EMAIL_INCORRECTO_DESTINATARIO);	    		
    		}
    	}
    	
    	//validamos el email del remitente
    	if(isChangeable(form.getCorreoDesde()))
    		if(!validaEmail(form.getCorreoDesde()).booleanValue())    		
    			errores.add(MENSAJE_FORMATO_EMAIL_INCORRECTO_REMITENTE);    		
    	
    	//Comprobamos que el numero de email destino y nombre destino es el mismo
    	if(isChangeable(form.getCorreosHasta()) && isChangeable(form.getNombresHasta()))
    		if(destinatariosArray.length != nombresDestinatariosArray.length)    		
    			errores.add(MENSAJE_ERROR_DISTINTO_TAMANYO);   		
    	
    	return errores;
    }
    
    private boolean isChangeable(Object oValue)
	{
		return (oValue != null && !("").equals(oValue.toString().trim()));
	}

    private boolean enviarCorreo(String to, String asunto, StringBuffer body, String from) throws Exception {
		// Envio de correo necesitamos conocer el
		// resultado del envio para mostrarselo al usuario	
			boolean flag = true;
			log("EnviarMailControllerImpl - enviarCorreo:Envio de correo");		
			try {
				MailSender mailSender = new MailSender();			    
			    mailSender.send(to, asunto, body, from);
			} catch (Exception e) {
			   logger.error("EnviarMailControllerImpl - enviarCorreo ERROR:Error al enviar el correo.",e);
			   flag = false;
			}
			return flag;
	    }
	
	private StringBuffer construirBodyEmail(String hrefLogo, String srcImagen, String emailRemitente, String tituloODE, String url, String nombreRemitente, String resumen, String nombreDestinatario, String urlImagen, Locale locale) throws IOException{
			
			//String textoBodyReturn = "";
			StringBuffer contenido = new StringBuffer();				
//			REALIZAMOS EL TRATAMIENTO DE LOS CODIGOS INTERNACIONALIZABLES			
			String textoBody=this.getResource(TEXTO_BODY, FICHERO,locale);	
			String textoBodyAlt=this.getResource(TEXTO_BODY_ALT, FICHERO,locale);			
			String textoBodyCabecera=this.getResource(TEXTO_BODY_CABECERA, FICHERO,locale);			
			String textoUrl=this.getResource(TEXTO_URL, FICHERO,locale);
			String textoBodyTitulo=this.getResource(TEXTO_BODY_TITULO, FICHERO,locale);
			String textoResumen=this.getResource(TEXTO_BODY_RESUMEN, FICHERO,locale);	
			String textoBodyDespedida1=this.getResource(TEXTO_BODY_DESPEDIDA1, FICHERO,locale);	
			String textoBodyDespedida2=this.getResource(TEXTO_BODY_DESPEDIDA2, FICHERO,locale);	
			String textoBodyDespedida3=this.getResource(TEXTO_BODY_DESPEDIDA3, FICHERO,locale);	
			
			String textoBodyEnlaceAgrega=this.getResource(TEXTO_BODY_ENLACE_AGREGA, FICHERO, locale);
			String textoBodyEnlaceMiniSite=this.getResource(TEXTO_BODY_ENLACE_MINI_SITE, FICHERO, locale);
			String urlMiniSiteAgrega=this.getPropertyValue(URL_MINI_SITE);
			
			//Codigo html
			contenido.append("<html>");					
				contenido.append("<a href=\"" + hrefLogo + "\" target=\"_blank\"><img  src=\"" + srcImagen + "\" border=\"0\"/></a>");
				contenido.append("<hr size=\"2\" color=\""+ this.getPropertyValue(COLOR_HEXADECIMAL) +"\"/>");		
				contenido.append("<br>");
				contenido.append(textoBodyCabecera + " " + changeAccents(nombreDestinatario) + ",");				
				contenido.append("<br>");
				contenido.append("<br>");			
				contenido.append(changeAccents(nombreRemitente));	
				contenido.append(" " + "(" + emailRemitente + ")");	
				contenido.append(" ");	
				contenido.append(textoBody);	
				contenido.append("<br>");	
				contenido.append("<br>");			
				contenido.append("<blockquote>");
				contenido.append("<blockquote>");			
					contenido.append("<table border=\"0\" width=\"620\">");
						contenido.append("<tr>");
							//Primera columna con la imagen del ode
							contenido.append("<td width=\"100\">");
								contenido.append("<img  src="  + "\"" + urlImagen + "\"" + " alt=" + textoBodyAlt + " border=\"1\" />");
								contenido.append("<br>");	
								contenido.append("<br>");
							contenido.append("</td>");
	//						Segunda columna con el titulo y el enlace
							contenido.append("<td width=\"520\" valign=\"top\">");
							contenido.append(textoBodyTitulo + " ");	
							contenido.append("<b>"+ changeAccents(tituloODE) + "</b>");
							contenido.append("<br>");	
							contenido.append("<a href=\"" + url + "\">");	
							contenido.append(textoUrl);
							contenido.append("</a>");
							contenido.append("</td>");
						contenido.append("</tr>");
					contenido.append("</table>");
				contenido.append("</blockquote>");
				contenido.append("</blockquote>");	
				//Comentarios
				if(resumen!=null && !resumen.trim().equals("")){
					contenido.append("<b>");
						contenido.append(textoResumen + " ");
						contenido.append(changeAccents(nombreRemitente));
						contenido.append(":");
					contenido.append("</b>");
					contenido.append(" ");
					contenido.append(changeAccents(resumen));
					contenido.append("<br>");
					contenido.append("<br>");					
				}
				contenido.append("<a href=\""+ hrefLogo +"\" target=\"_blank\">"+ textoBodyEnlaceAgrega +"</a>");	
				contenido.append("<br>");	
				contenido.append("<a href=\""+ urlMiniSiteAgrega +"\" target=\"_blank\">"+ textoBodyEnlaceMiniSite +"</a>");	
				contenido.append("<br>");	
				contenido.append("<br>");					
				contenido.append(textoBodyDespedida1);
				contenido.append("<br>");
				contenido.append(textoBodyDespedida2);
				contenido.append("<br>");
				contenido.append("<br>");				
				contenido.append(textoBodyDespedida3);
				contenido.append("</br>");
			contenido.append("</html>");
			
			return contenido;		
		}
	
	private String dameIdODE(String urlODE) throws Exception
	{
		String[] urlODESplit = urlODE.split(BARRA);
		return urlODESplit[urlODESplit.length-1];
	}
	

	 private String getPropertyValue(String sKey) throws IOException {
			InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/spring_buscador.properties");
			if (this.pSpringProperties == null) {
				pSpringProperties = new java.util.Properties();
				pSpringProperties.load(fIsSpringProperties);
			}
			fIsSpringProperties.close();
			if (logger.isDebugEnabled())logger.debug("Propiedad recuperada: " + sKey + " : "+ pSpringProperties.getProperty(sKey));
			// devolvemos la propiedad
			return pSpringProperties.getProperty(sKey);
		}

	 //MÉTODOS PARA PINTAR LOS MENSAJES INTERNACIONALIZADOS
	    public static String getResource (String key, String fichero, Locale locale)
	    {
         return getResourceByBundle(key,fichero, locale);

	    }
	    private static String getResourceByBundle(String key,String baseName, Locale locale){
         String recurso = "";
         try{
            ResourceBundle theResourceBundle = ResourceBundle.getBundle(baseName,locale);
            if (theResourceBundle!=null){
               recurso = theResourceBundle.getString(key);
            }
         }catch (MissingResourceException mre){
         	recurso = key;
         }
         return recurso;

	    }		
	    
	    private Boolean validaEmail(String email) throws Exception{
			Boolean resultado = Boolean.TRUE;
			
			//Pattern pattern = Pattern.compile("[^A-Za-z0-9\\.\\@_\\-~#]+");
			Pattern pattern = Pattern.compile("^[A-Za-z0-9]([A-Za-z0-9.-_])*@[A-Za-z0-9]([A-Za-z0-9\\.\\-\\_])*.([A-Za-z0-9])+$");
			Matcher matcher = pattern.matcher(email);			
			
			if (matcher.find()) {
				log("El email coincide con el patron es correcto el campo email");
			} else {
				resultado = Boolean.FALSE;
			}
			return resultado;

	    }	  	   
	    
	    private Boolean validaTodosEmailsDestino (String emailsDestino) throws Exception{	    	
	    	Boolean resultado = Boolean.TRUE;
	    	Boolean flagEmailIncorrecto = Boolean.FALSE;	    	
	    	
	    	String[] emailsDestinoArray = emailsDestino.split(";");
	    	if(emailsDestinoArray!=null && emailsDestinoArray.length>0){
	    		for(int i=0; !flagEmailIncorrecto.booleanValue() && i<emailsDestinoArray.length; i++){
	    			if(!validaEmail(emailsDestinoArray[i].trim()).booleanValue()){
	    				flagEmailIncorrecto = Boolean.TRUE;	    				
	    			}
	    		}
	    		
	    	}
	    	
	    	if(flagEmailIncorrecto.booleanValue())
	    		//Algun email incorrecto
	    		resultado = Boolean.FALSE;
	    	
	    	return resultado;
	    	
	    }
	    
	    private void saveErrorMessage(HttpServletRequest request, List messages) throws Exception{
			log("EnviarCorreoControllerImpl - saveErrorMessage: Formulario incorrecto------------.");
			boolean encontrado;		
			if(request!=null && messages!=null && messages.size()>0)
			{
				//Pintamos la posición cero de la lista
				saveErrorMessage(request, messages.get(0).toString());
				//Recorremos el vector comprobando si el mensaje de error ha sido pintado anteriormente
				for(int i = 1; messages.size() > i ; i++){ 
					encontrado = false;
					for(int j=i; j>0 ;j--){
						if(messages.get(j-1).equals(messages.get(i)))
							encontrado = true;
					}
					if(!encontrado)
						saveErrorMessage(request, messages.get(i).toString());
				}
			}
		}

	    private void log(String traza){
			if (logger.isDebugEnabled())logger.debug(traza);
		}
	    
	    private String changeAccents(String s){
			try {
				log("EnviarCorreoControllerImpl -  changeAccents: cambiar acentos para="+s);
				s = s.replaceAll( "Á", "&Aacute;" );
				s = s.replaceAll( "É", "&Eacute;" );
				s = s.replaceAll( "Í", "&Iacute;" );
				s = s.replaceAll( "Ó", "&Oacute;" );
				s = s.replaceAll( "Ú", "&Uacute;" );
				s = s.replaceAll( "á", "&aacute;" );
				s = s.replaceAll( "é", "&eacute;" );
				s = s.replaceAll( "í", "&iacute;" );
				s = s.replaceAll( "ó", "&oacute;" );
				s = s.replaceAll( "ú", "&uacute;" );
				
				s = s.replaceAll( "Â", "&Acirc;" );
				s = s.replaceAll( "Ê", "&Ecirc;" );
				s = s.replaceAll( "Î", "&Icirc;" );
				s = s.replaceAll( "Ô", "&Ocirc;" );
				s = s.replaceAll( "Û", "&Ucirc;" );
				s = s.replaceAll( "â", "&acirc;" );
				s = s.replaceAll( "ê", "&ecirc;" );
				s = s.replaceAll( "î", "&icirc;" );
				s = s.replaceAll( "ô", "&ocirc;" );
				s = s.replaceAll( "û", "&ucirc;" );
				
				s = s.replaceAll( "À", "&Agrave;" );
				s = s.replaceAll( "È", "&Egrave;" );
				s = s.replaceAll( "Ì", "&Igrave;" );
				s = s.replaceAll( "Ò", "&Ograve;" );
				s = s.replaceAll( "Ù", "&Ugrave;" );
				s = s.replaceAll( "à", "&agrave;" );
				s = s.replaceAll( "è", "&egrave;" );
				s = s.replaceAll( "ì", "&igrave;" );
				s = s.replaceAll( "ò", "&ograve;" );
				s = s.replaceAll( "ù", "&ugrave;" );
				
				s = s.replaceAll( "Ç", "&Ccedil;" );
				s = s.replaceAll( "ç", "&ccedil;" ); 
				
				log("EnviarCorreoControllerImpl -  changeAccents: Acentos cambiados="+s);
				return s;
			} catch ( Exception ex ) {
				logger.error("EnviarCorreoControllerImpl -  changeAccents: Error cambiando acentos para cadena="+s, ex);
				return "";
			}
			
			
		}
}