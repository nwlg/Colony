/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.buscador.presentacion.basico.introducirComentarios;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;


import es.agrega.soporte.serverProperties.DependentServerProperties;
import es.agrega.soporte.serverProperties.DependentServerPropertiesItf;
import es.pode.buscador.presentacion.mail.MailSender;

import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
import es.pode.valoracion.negocio.servicios.ComentarioVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.buscador.presentacion.basico.introducirComentarios.IntroducirComentariosController
 */
public class IntroducirComentariosControllerImpl extends IntroducirComentariosController
{

	private static final long serialVersionUID = 6786491288970950374L;
	
	private java.util.Properties springProperties = null;	

	private static Logger logger = Logger.getLogger(IntroducirComentariosControllerImpl.class);
	
	private final static String SUBJECT_EMAIL = "mandar.email.contenido.inapropiado.subject";
	private final static String BODY_EMAIL_HOLA = "mandar.email.contenido.inapropiado.body.hola";
	private final static String BODY_EMAIL = "mandar.email.contenido.inapropiado.body";
	private final static String BODY_EMAIL2 = "mandar.email.contenido.inapropiado.body2";	
	private final static String BODY_EMAIL_COMENTARIO = "mandar.email.contenido.inapropiado.body.comentario.comentario"; 
	private final static String BODY_EMAIL_VALORACION = "mandar.email.contenido.inapropiado.body.comentario.valoracion";
	private final static String BODY_EMAIL_COMUNIDAD = "mandar.email.contenido.inapropiado.body.comentario.comunidad";
	private final static String BODY_EMAIL_COMENTARIO_DESPEDIDA1 = "mandar.email.contenido.inapropiado.body.comentario.despedida1"; 
	private final static String BODY_EMAIL_COMENTARIO_DESPEDIDA2 = "mandar.email.contenido.inapropiado.body.comentario.despedida2";
	private final static String TEXTO_BODY_ALT = "texto.body.imagen.alt";
	private final static String TEXTO_BODY_TITULO = "texto.body.un.amigo.titulo";
	private final static String TEXTO_URL = "texto.url";	
	private final static String BARRA = "/";
	
	private final static String IMAGEN_HTTP = "url.imagen.http";
	private final static String IMAGEN_STATIC = "url.imagen.static";	
	private final static String COLOR_HEXADECIMAL = "color.hexadecimal";
		
	
	private final static int MAX_COMENTARIO = 1100;
	private final static String SI = "SI";
	private final static String NO = "NO";	
	private final static String FICHERO="application-resources";	
	private final static String COMENTARIOS = "identificadoresComentarios";	

	private final static String ERROR_OBTENIENDO_COMENTARIOS = "introducir.comentarios.ode.errorObteniendoComentarios";	
	private final static String ERROR_INSERTANDO_COMENTARIO = "introducir.comentarios.ode.errorInsertandoComentario";
	private final static String ERROR_RECUPERANDO_IDS = "introducir.comentarios.ode.errorRecuperandoIdsOdesEliminar";
	private final static String ERROR_ELIMINANDO_COMENTARIO = "introducir.comentarios.ode.errorEliminandoComentario";
	private final static String ERROR_COMENTARIO_VACIO = "introducir.comentarios.ode.errorComentarioVacio";	
	private final static String ERROR_MAX_CARACTERES_COMENTARIO = "introducir.comentarios.ode.errorMaxCaracteresComentario";
	private final static String ERROR_PULSAR_ELIMINAR = "introducir.comentarios.ode.errorPulsarEliminar";



    /**
     * @see es.pode.buscador.presentacion.basico.introducirComentarios.IntroducirComentariosController#recuperarComentarios(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.basico.introducirComentarios.RecuperarComentariosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperarComentariosODE(ActionMapping mapping, es.pode.buscador.presentacion.basico.introducirComentarios.RecuperarComentariosODEForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
//		Tenemos que recuperar todos los comentarios que haya asociados a este ODE.
//    	Llamamos al servicio de valoracion para esta tarea.
    	try{
	    	log("IntroducirComentariosControllerImpl - recuperarComentariosODE.");
	    	form.setListaVacia(new Boolean(true));
	        String idODE = form.getIdODE();       
	        Comentario_VO_date[] comentariosDate= new Comentario_VO_date[0];
	        ComentarioVO[] comentarios = null;
	        try {
	        	comentarios= this.getSrvValoracionService().obtenerComentarios(idODE);
	        	
	        	//Se comprueba el numero de comentarios
	        	if(comentarios!=null && comentarios.length>0)
	        		form.setListaVacia(new Boolean(false));
	        	if(comentarios != null && comentarios.length >0){
	        		comentariosDate = new Comentario_VO_date[comentarios.length];
	        	}
	        	for (int i = 0; comentarios != null && i < comentarios.length ; i++) {
	        		comentariosDate[i]= map_comentario(comentarios[i]);
				}
			} catch (Exception e) {
				logger.error("Error obteniendo comentarios del ODE con id["+idODE+"].["+ e.getCause()+"]");
				saveErrorMessage(request, ERROR_OBTENIENDO_COMENTARIOS);
			}
			
			form.setComentarios(java.util.Arrays.asList(comentariosDate));
			
			//Cargamos el locale
			Locale locale = null;
			try {
				locale = devuelveLocale(request);
			} catch (Exception e) {
				logger.error("Error recogiendo el locale",e);			
			}			
	        //Compruebo si es administrador o no
	        form.setUsuarioAdministrador(new Boolean(LdapUserDetailsUtils.esAdministrador()));
    	} catch (Exception e) {
			logger.error("IntroducirComentariosControllerImpl - recuperarComentariosODE:",e);			
		}
    }


    /**
     * @see es.pode.buscador.presentacion.basico.introducirComentarios.IntroducirComentariosController#analizaPulsacion(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.basico.introducirComentarios.AnalizaPulsacionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String analizaPulsacion(ActionMapping mapping, es.pode.buscador.presentacion.basico.introducirComentarios.AnalizaPulsacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	return form.getAction();
    }

    /**
     * @see es.pode.buscador.presentacion.basico.introducirComentarios.IntroducirComentariosController#insertarComentarioODE(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.basico.introducirComentarios.InsertarComentarioODEForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void insertarComentarioODE(ActionMapping mapping, es.pode.buscador.presentacion.basico.introducirComentarios.InsertarComentarioODEForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    { 
    	try {
	    	log("IntroducirComentariosControllerImpl - insertarComentarioODE.");
			if (!validaFormularioInsercion(form, request)){
				return;
			}	
			Locale locale = null;
			try {
				locale = devuelveLocale(request);
			} catch (Exception e) {
				logger.error("Error recuperando el locale", e);			
			}
	//		Hay que tener en cuenta si el contenido es inapropiado o no, y si es asi, hay que mandar un correo electornico al administrador
	//		con la informacion necesaria que se puede obtener del propio formulario.		
			String[] administradores = this.getSrvAdminUsuariosService().getEmailAdmin();
			String hrefLogo = this.getPropertyValue(IMAGEN_HTTP) + request.getServerName();
	    	String imagen = this.getPropertyValue(IMAGEN_HTTP) + request.getServerName() + form.getImagen();
	    	String srcImagen = this.getPropertyValue(IMAGEN_HTTP) + request.getServerName() + this.getPropertyValue(IMAGEN_STATIC); 
	    	String url = this.getPropertyValue(IMAGEN_HTTP) + request.getServerName() + BARRA + form.getUrlODE() + BARRA + form.getIdiomaODE() + BARRA + form.getIdODE();
	    	DependentServerPropertiesItf properties = DependentServerProperties.getInstance();
			String nodo = (String) properties.getProperty("ccaa");
	    	log("Valores de href: ["+hrefLogo+"], imagen: ["+imagen+"], srcImagen: ["+srcImagen+"], url: ["+url+"] y nodo ["+nodo+"]");
	    	log("Valoracion igual ["+form.getValoracion()+"]");
	    	
	    	//Analizamos la valoracion
	    	String valoracion = form.getValoracion();
	    	if (valoracion != null && !("").equals(valoracion) && ("0.0".equals(valoracion) || "-1.0".equals(valoracion)))    		
				valoracion = "Sin valorar";
	    	
	    	log("El valor de la valoracion que se envia al correo es ["+valoracion+"]");
	    	
	    	
			if(form.getConInaprop()!=null && form.getConInaprop().booleanValue()){	
				for(int i=0; administradores!=null && i<administradores.length; i++){
					if(enviarCorreo(administradores[i], this.getResource(SUBJECT_EMAIL, FICHERO, locale), construirBodyEmail(url, hrefLogo, srcImagen, imagen, form.getTituloODE(),form.getComentario(), valoracion , nodo, request), null))			
						logger.debug("Envio correcto del email para el administrador ["+administradores[i]+"]");
					else
						logger.debug("El email no se ha enviado correctamente al administrador ["+administradores[i]+"]");
				}			
			}
			
			try {
				this.getSrvValoracionService().introducirComentario(form.getIdODE(), form.getComentario(),form.getIdiomaODE(), LdapUserDetailsUtils.getLogin());			
	//			En el caso de ir todo bien, se reinicia el formulario para una nueva insercion
				reiniciaFormularioInsercion(form, locale);
			} catch (Exception e) {
				logger.error("Error insertando comentario con idODE["+form.getIdODE()+"] comentarios["+form.getComentario()+"] idiomaODE["+form.getIdiomaODE()+"]",e);
				saveErrorMessage(request, ERROR_INSERTANDO_COMENTARIO);
			}
    	} catch (Exception e) {
			logger.error("insertarComentarioODE: Error en la inserción comentario con idODE["+form.getIdODE()+"] comentarios["+form.getComentario()+"] idiomaODE["+form.getIdiomaODE()+"]",e);
			saveErrorMessage(request, ERROR_INSERTANDO_COMENTARIO);
		}
     }

    /**
     * @see es.pode.buscador.presentacion.basico.introducirComentarios.IntroducirComentariosController#eliminarComentarios(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.basico.introducirComentarios.EliminarComentariosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarComentarios(ActionMapping mapping, es.pode.buscador.presentacion.basico.introducirComentarios.EliminarComentariosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	log("IntroducirComentariosControllerImpl - eliminarComentarios.");
    	 try {	
	        	Long[] identificadoresLong = null;
	    		String[] identificadoresString = (String[])request.getSession().getAttribute(COMENTARIOS);
	    		if(identificadoresString!=null)
	    			identificadoresLong = new Long[identificadoresString.length];
	    		//Se transforma el array de string a long
	    		for(int i=0; identificadoresString!=null && i<identificadoresString.length; i++){
	    			for(int j=i; j<=i; j++){
	    			identificadoresLong[j] = Long.valueOf(identificadoresString[i]);
	    			}
	    		}	
	    	    this.getSrvValoracionService().eliminarComentarios(identificadoresLong);	        	
			} catch (Exception e) {
				logger.error("Error eliminando los comentarios",e);
				saveErrorMessage(request, ERROR_ELIMINANDO_COMENTARIO);
			}		
     }

    /**
     * @see es.pode.buscador.presentacion.basico.introducirComentarios.IntroducirComentariosController#recuperarSeleccionIds(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.basico.introducirComentarios.RecuperarSeleccionIdsForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperarSeleccionIds(ActionMapping mapping, es.pode.buscador.presentacion.basico.introducirComentarios.RecuperarSeleccionIdsForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	log("IntroducirComentariosControllerImpl - recuperarSeleccionIds.");
    	String[] idString = null;		
        try {
        	if(form.getIdRowSelectionAsArray()!=null)
        	{
        		idString = new String[form.getIdRowSelectionAsArray().length];        		
        		idString=form.getIdRowSelectionAsArray();
        	}
    		request.getSession().setAttribute(COMENTARIOS, idString);   
    			    		
		} catch (Exception e) {
			//logger.error("Error obteniendo el array de los identificadores de los odes a eliminar["+form.getIdRowSelectionAsArray()+"].");
			saveErrorMessage(request, ERROR_RECUPERANDO_IDS);				
			return; 
		}
     }

    /**
     * @see es.pode.buscador.presentacion.basico.introducirComentarios.IntroducirComentariosController#validaBotonEliminar(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.basico.introducirComentarios.ValidaBotonEliminarForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String validaBotonEliminar(ActionMapping mapping, es.pode.buscador.presentacion.basico.introducirComentarios.ValidaBotonEliminarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
//    	Comprueba si al pulsar el boton de eliminar comentario habia seleccionado alguno o no.
		String[] ids = (String[])request.getSession().getAttribute(COMENTARIOS);
		if(ids==null){
			logger.error("Error al pulsar el boton de eliminar.");
			saveErrorMessage(request, ERROR_PULSAR_ELIMINAR);	
			return NO;
		}else
			return SI;	
    }
    
    private Comentario_VO_date map_comentario (ComentarioVO tr)
    {
    	Comentario_VO_date tr_date = new Comentario_VO_date();
    	
    	tr_date.setComentario(tr.getComentario());  
    	tr_date.setUsuario(tr.getUsuario());
    	tr_date.setFecha(tr.getFecha().getTime());
    	tr_date.setIdODE(tr.getIdODE());    	 	
    	tr_date.setId(tr.getId());
    	return tr_date;
    	
    }
	
    
    public class Comentario_VO_date {
    	
    	  /* Identificador del ODE */
        private java.lang.String idODE;
        
        /* Usuario que ha creado el comentario*/
        private java.lang.String usuario;

        /* El comentario de la valoracion. */
        private java.lang.String comentario;

        /* La fecha de la valoracion. */
        private java.util.Date fecha;          
        
        /* Id del comentario*/
        private java.lang.Long id;
        
		public java.lang.String getComentario() {
			return comentario;
		}

		public void setComentario(java.lang.String comentario) {
			this.comentario = comentario;
		}

		public java.util.Date getFecha() {
			return fecha;
		}

		public void setFecha(java.util.Date fecha) {
			this.fecha = fecha;
		}

		public java.lang.String getIdODE() {
			return idODE;
		}

		public void setIdODE(java.lang.String idODE) {
			this.idODE = idODE;
		}				

		public java.lang.Long getId() {
			return id;
		}

		public void setId(java.lang.Long id) {
			this.id = id;
		}
		
		public java.lang.String getUsuario() 
		{
			return usuario;
		}
		public void setUsuario(java.lang.String usuario)
		{
			this.usuario = usuario;
		}
    }
    
	private boolean validaFormularioInsercion(es.pode.buscador.presentacion.basico.introducirComentarios.InsertarComentarioODEForm form, HttpServletRequest request) throws Exception
	{
		boolean valido=true;			
		if (form.getComentario() == null || form.getComentario().trim().equals(""))
		{
			logger.error("Error insertando comentario con texto vacio.");
			saveErrorMessage(request,ERROR_COMENTARIO_VACIO);
			valido=false;			
		}		
		if (form.getComentario()!=null && !("").equals(form.getComentario().trim()) && form.getComentario().length()>MAX_COMENTARIO)
		{
			logger.error("Error insertando comentario excediendo el numero de caracteres permitido para el texto de comentario");
			saveErrorMessage(request,ERROR_MAX_CARACTERES_COMENTARIO);
			valido=false;			
		}	
		
		return valido;
	}
	
	private void reiniciaFormularioInsercion(es.pode.buscador.presentacion.basico.introducirComentarios.InsertarComentarioODEForm form, Locale locale) throws Exception
	{
		form.setComentario("");		
		form.setConInaprop(new Boolean(false));
	}	
	private boolean enviarCorreo(String to, String asunto, StringBuffer body, String from) throws Exception {
		// Envio de correo necesitamos conocer el
		// resultado del envio para mostrarselo al usuario	
			boolean flag = true;
			log("Envio de correo");		
			try {
			    MailSender mailSender = new MailSender();
			    mailSender.send(to, asunto, body, from);
			} catch (Exception e) {
			   logger.debug("error al enviar el correo",e);
			   flag = false;
			}
			return flag;
	    }
	
	private StringBuffer construirBodyEmail(String url, String hrefLogo, String srcImagen, String urlImagen, String tituloODE, String comentario, String valoracion, String comunidad, HttpServletRequest request) throws IOException{
		
		StringBuffer contenido = new StringBuffer();
		
		Locale locale = null;
		try {
			locale = devuelveLocale(request);
		} catch (Exception e) {
			logger.error("Error construyendo el body del email",e);			
		}
		
//		REALIZAMOS EL TRATAMIENTO DE LOS LITERALES PARA PODER INTRODUCIRLOS EN EL CÓDIGO HTML		
		String bodyEmailHola = this.getResource(BODY_EMAIL_HOLA, FICHERO, locale);
		String bodyEmail = this.getResource(BODY_EMAIL, FICHERO, locale);
		String bodyEmail2 = this.getResource(BODY_EMAIL2, FICHERO, locale);
		String textoBodyAlt=this.getResource(TEXTO_BODY_ALT, FICHERO,locale);		
		String bodyEmailComentario = this.getResource(BODY_EMAIL_COMENTARIO, FICHERO, locale);	
		String bodyEmailValoracion = this.getResource(BODY_EMAIL_VALORACION, FICHERO, locale);	
		String bodyEmailComunidad = this.getResource(BODY_EMAIL_COMUNIDAD, FICHERO, locale);	
		String bodyEmailComentarioDespedida1 = this.getResource(BODY_EMAIL_COMENTARIO_DESPEDIDA1, FICHERO, locale);	
		String bodyEmailComentarioDespedida2 = this.getResource(BODY_EMAIL_COMENTARIO_DESPEDIDA2, FICHERO, locale);	
		String textoBodyTitulo=this.getResource(TEXTO_BODY_TITULO, FICHERO,locale);
		String textoUrl=this.getResource(TEXTO_URL, FICHERO,locale);
		
		String textoBodyReturn = LdapUserDetailsUtils.getNombreCompleto() + " " + "(" + LdapUserDetailsUtils.getMail() + ")" + " " + bodyEmail;
					
		//Codigo html
		contenido.append("<html>");			
		contenido.append("<a href=" + hrefLogo + " target=\"_blank\"><img  src=" + srcImagen + " border=\"0\"/></a>");
		contenido.append("<hr size=\"2\" color=\""+ this.getPropertyValue(COLOR_HEXADECIMAL) +"\"/>");		
		contenido.append("<br>");		
		contenido.append(bodyEmailHola);	
		contenido.append("<br>");	
		contenido.append("<br>");	
		contenido.append(textoBodyReturn);
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
					contenido.append("<b>"+ tituloODE + "</b>");
					contenido.append("<br>");	
					contenido.append("<a href=" + url + ">");	
					contenido.append(textoUrl);
					contenido.append("</a>");
					contenido.append("</td>");
				contenido.append("</tr>");
			contenido.append("</table>");
		contenido.append("</blockquote>");
		contenido.append("</blockquote>");			
		contenido.append(bodyEmail2);		
		contenido.append("<br>");				
		contenido.append("<b>");
			contenido.append(bodyEmailComentario);
		contenido.append("</b>");
		contenido.append(" " + comentario);		
		contenido.append("<br>");		
		contenido.append("<b>");
			contenido.append(bodyEmailValoracion);
		contenido.append("</b>");
		contenido.append(" " + valoracion);		
		contenido.append("<br>");
		contenido.append("<b>");
			contenido.append(bodyEmailComunidad);
		contenido.append("</b>");
		contenido.append(" " + " " + comunidad!=null?comunidad:"");
		contenido.append("<br>");	
		contenido.append("<br>");
		contenido.append("<br>");
		contenido.append(bodyEmailComentarioDespedida1);
		contenido.append("<br>");
		contenido.append(bodyEmailComentarioDespedida2);		
		contenido.append("</br>");
		contenido.append("</html>");		
		
		return contenido;		
	
	}	
	
    private String getPropertyValue(String sKey) throws IOException {
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream(
				"/spring_buscador.properties");
		if (this.springProperties == null) {
			springProperties = new java.util.Properties();
			springProperties.load(fIsSpringProperties);
		}
		fIsSpringProperties.close();
		this.logger.debug("Propiedad recuperada: " + sKey + " : "
				+ springProperties.getProperty(sKey));
		// devolvemos la propiedad
		return springProperties.getProperty(sKey);
	}
    
//	MÉTODOS PARA PINTAR LOS MENSAJES INTERNACIONALIZADOS
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
	private Locale devuelveLocale(HttpServletRequest request) throws Exception
	{	
		
		Locale locale=null;
		if (request instanceof HttpServletRequest) {
			locale = (Locale)((HttpServletRequest)request).getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
			
		}
		else{ 	    					
			try {
				locale=new Locale(I18n.getInstance().obtenerIdiomaDefectoPlataforma());
			} catch (Exception e) {								
				logger.error("DevuelveLocale-- Error recuperando el locale del request", e);
			}
		}
		return locale;
	}
	
	private void log(String traza){
		if (logger.isDebugEnabled())logger.debug(traza);
	}
}