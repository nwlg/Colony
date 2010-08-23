/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.presentacion.contenidoInapropiado;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.agrega.soporte.mail.MailSender;
import es.pode.buscar.negocio.buscar.servicios.MetadatoBasicoVO;
import es.pode.buscar.negocio.buscar.servicios.ParametroMetadatoVO;
import es.pode.presentacion.VisualizadorSession;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



public class ContenidoInapropiadoControllerImpl extends ContenidoInapropiadoController
{

	private static Logger logger = Logger.getLogger(ContenidoInapropiadoControllerImpl.class);
	private static java.util.Properties prop=null;
	
	private final static String FICHERO="application-resources";

	private final static String TEXTO_BODY_CABECERA = "reportar.abuso.texto.body.cabecera";
	private final static String TEXTO_BODY = "reportar.abuso.texto.body";
	private final static String TEXTO_BODY_ALT = "reportar.abuso.texto.body.imagen.alt";
	private final static String TEXTO_BODY_RESUMEN = "reportar.abuso.texto.body.Resumen";	
	private final static String TEXTO_BODY_TITULO = "reportar.abuso.texto.body.un.amigo.titulo";
	private final static String TEXTO_BODY_DESPEDIDA1 = "reportar.abuso.texto.body.despedida1";
	private final static String TEXTO_BODY_DESPEDIDA2 = "reportar.abuso.texto.body.despedida2";
	private final static String TEXTO_BODY_DESPEDIDA3 = "reportar.abuso.texto.body.despedida3";	
	private final static String TEXTO_BODY_ENLACE_AGREGA = "reportar.abuso.texto.body.enlace.agrega";
	private final static String TEXTO_BODY_ENLACE_MINI_SITE = "reportar.abuso.texto.body.enlace.mini.site";
	private final static String TEXTO_SUBJECT = "reportar.abuso.texto.subject";
	private final static String TEXTO_URL = "reportar.abuso.texto.url";
	private final static String IMAGEN_HTTP = "url.imagen.http";
	private final static String IMAGEN_STATIC = "url.imagen.static";
	private final static String COLOR_HEXADECIMAL = "color.hexadecimal";
	private final static String URL_MINI_SITE = "url.mini.site";
	private final static String POSICIONADO_DETALLE = "POSICIONADO_DETALLE";

	private final static String BARRA = "/";
	private final static String DETALLE_CORTA = "url_buscadorDetalleCorta";
	
    public final void enviarMensaje(
    		ActionMapping mapping, 
    		EnviarMensajeForm form, 
    		HttpServletRequest request, 
    		HttpServletResponse response) 
    throws Exception
    {
    	try{
    		
	    	String servidor= this.getPropertyValue(IMAGEN_HTTP) + request.getServerName()  + LdapUserDetailsUtils.getSubdominio();
	    	String nombre="";
	    	String email="";
	    	
	    	
		    	if( LdapUserDetailsUtils.getNombreCompleto()!=null)
		    		nombre=LdapUserDetailsUtils.getNombreCompleto();
		    	if(LdapUserDetailsUtils.getMail()!=null)
		    		email=LdapUserDetailsUtils.getMail();
		    	
		    	
				Locale locale =(Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
				VisualizadorSession sesion= this.getVisualizadorSession(request);
		
				ParametroMetadatoVO paramMetadato= new ParametroMetadatoVO();
		    	paramMetadato.setIdentificadorODE(this.getVisualizadorSession(request).getIdentificador());
		    	paramMetadato.setIdioma(sesion.getIdiomaCat() );
		    	paramMetadato.setBusquedaSimpleAvanzada(POSICIONADO_DETALLE);
		    	
		    	String imagen=servidor ;
		    	
		    	MetadatoBasicoVO metadato=null;
		    	try{
		    		metadato= this.getSrvBuscarService().solicitarMetadato(paramMetadato);
		    		
		    	}catch (Exception e) {
		    		logger.error("no se pudo acceder al servicio SrvBuscarService");
				}
		    	if(metadato!=null && metadato.getImagen()!=null && !metadato.getImagen().equals(""))
		    	{
		    		imagen += metadato.getImagen();
		    	}else{
		    		imagen +=  BARRA + AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.URL_IMAGEN_DEFECTO);
		    	}
		
				//Formamos la url de la imagen         	
		    	String hrefLogo = servidor ;
		
		    	String srcImagen = servidor + this.getPropertyValue(IMAGEN_STATIC);
		    	
		    	String url = servidor 
		    		+ BARRA + request.getSession().getServletContext().getInitParameter(DETALLE_CORTA) 
		    		+ BARRA + sesion.getIdiomaCat() + BARRA + sesion.getIdentificador();
		
		    	StringBuffer sbBody= construirBodyEmail(
		    								this.getVisualizadorSession(request).getIdentificador(),
		    								hrefLogo,
		    								srcImagen,
		    								email,
		    								this.getVisualizadorSession(request).getTituloOde(), 
		    								url, 
		    								nombre,
		    								form.getComentario(),
		    								imagen, 
		    								locale);
		
		    	
		    	String[] destinatariosArray =this.getSrvAdminUsuariosService().getEmailPublicadores();
		    	for(int i=0; i<destinatariosArray.length; i++ )
		    	{
		    		if(enviarCorreo(destinatariosArray[i], this.getResource(TEXTO_SUBJECT, FICHERO,locale),sbBody,null))
		    			if (logger.isDebugEnabled())logger.debug("Envio correcto del email para el destinatario ["+destinatariosArray[i]+"]");
		    		else
						if (logger.isDebugEnabled())logger.debug("El email no se ha enviado correctamente al destinatario ["+destinatariosArray[i]+"]");
		    	}
		    	
    	}
    	catch (Exception e) {
    		logger.error("error en COntenidoInapropiadoControllerImpl.enviarMensaje: " + e.getMessage());
		}
     }






	private StringBuffer construirBodyEmail(
			String identificador,
			String hrefLogo, 
			String srcImagen, 
			String emailRemitente, 
			String tituloODE,
			String url, 
			String nombreRemitente, 
			String resumen, 
			String urlImagen, 
			Locale locale) 
	throws IOException
	{
		
		//String textoBodyReturn = "";
		StringBuffer contenido = new StringBuffer();				
//		REALIZAMOS EL TRATAMIENTO DE LOS CODIGOS INTERNACIONALIZABLES
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
			contenido.append("<a href='" + hrefLogo + "' target='_blank' ><img  src='" + srcImagen + "' border='0'/></a>");
			contenido.append("<hr size='2' color='"+ this.getPropertyValue(COLOR_HEXADECIMAL) +"'/>");		
			contenido.append("<br>");
			contenido.append(textoBodyCabecera + ",");
			contenido.append("<br>");
			contenido.append("<br>");			
			contenido.append(nombreRemitente);	
			contenido.append(" " + "(<a href='mailto:"+ emailRemitente +"' >"+ emailRemitente +"</a>)");
			contenido.append(" ");	
			contenido.append(textoBody);	
			contenido.append("<br>");	
			contenido.append("<br>");			
			contenido.append("<blockquote>");
			contenido.append("<blockquote>");			
				contenido.append("<table border='0' width='620'>");
					contenido.append("<tr>");
						//Primera columna con la imagen del ode
						contenido.append("<td width=\"100\">");

						contenido.append("<a href='"+ url+ "' target='_blank'>");
						contenido.append("<img src='" + urlImagen + "' alt='" + tituloODE + "' border='1' />");
						contenido.append("</a>");

//						contenido.append("<img  src='" + urlImagen + "' alt='" + textoBodyAlt + "' border='1' />");
							contenido.append("<br>");	
							contenido.append("<br>");
						contenido.append("</td>");
//						Segunda columna con el titulo y el enlace
						contenido.append("<td width='520' valign='top'>");
						contenido.append(textoBodyTitulo + " ");	
						contenido.append("<b>"+ tituloODE + "</b>");
						contenido.append("<br>");	
						contenido.append("identificador: " + identificador);
						contenido.append("<br>");	
						contenido.append("<a href='" + url + "'>");
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
					contenido.append(nombreRemitente);
					contenido.append(":");
				contenido.append("</b>");
				contenido.append(" ");
				contenido.append(resumen);
				contenido.append("<br>");
				contenido.append("<br>");					
			}
			contenido.append("<a href='"+ hrefLogo +"' target='_blank'>"+ textoBodyEnlaceAgrega +"</a>");	
			contenido.append("<br>");	
			contenido.append("<a href='"+ urlMiniSiteAgrega +"' target='_blank'>"+ textoBodyEnlaceMiniSite +"</a>");	
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


    private boolean enviarCorreo(
    		String to, 
    		String asunto, 
    		StringBuffer body, 
    		String from) 
    throws Exception 
    {
			boolean flag = true;
			if (logger.isDebugEnabled())logger.debug("ReportarAbusoControllerImpl - enviarCorreo:Envio de correo");		
			try {
				MailSender mailSender = new MailSender();			    
			    mailSender.send(to, asunto, body, from);
			} catch (Exception e) {
			   logger.error("ReportarAbusoControllerImpl - enviarCorreo ERROR:Error al enviar el correo.",e);
			   flag = false;
			}
			return flag;
	    }



	 private String getPropertyValue(String sKey) throws IOException {
			InputStream is = this.getClass().getResourceAsStream("/visualizador.properties");
			if (this.prop == null) {
				prop = new java.util.Properties();
				prop.load(is);
			}
			is.close();
			if (logger.isDebugEnabled())logger.debug("Propiedad recuperada: " + sKey + " : "+ prop.getProperty(sKey));
			// devolvemos la propiedad
			return prop.getProperty(sKey);
		}

	 
	 
    public static String getResource (
    		String key, 
    		String fichero, 
    		Locale locale)
    {
    	return getResourceByBundle(key,fichero, locale);
    }
    
    
    
    
    private static String getResourceByBundle(
    		String key,
    		String baseName, 
    		Locale locale)
    {
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









}