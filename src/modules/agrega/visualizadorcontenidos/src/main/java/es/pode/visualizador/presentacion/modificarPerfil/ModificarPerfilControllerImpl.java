/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.visualizador.presentacion.modificarPerfil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import es.pode.adminusuarios.negocio.servicios.UsuarioVO;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.i18n.LocalizacionIdiomaVO;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @see es.pode.administracion.presentacion.adminusuarios.modificarPerfil.ModificarPerfilController
 */
public class ModificarPerfilControllerImpl extends ModificarPerfilController {

    private static Logger log = Logger.getLogger(ModificarPerfilControllerImpl.class);

    private java.util.Properties pSpringProperties = null;

    /**
     * @see es.pode.administracion.presentacion.adminusuarios.modificarPerfil.ModificarPerfilController#recuperarUsuario(org.apache.struts.action.ActionMapping,
     *      es.pode.administracion.presentacion.adminusuarios.modificarPerfil.RecuperarUsuarioForm,
     *      javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public final void recuperarUsuario(ActionMapping mapping, es.pode.visualizador.presentacion.modificarPerfil.RecuperarUsuarioForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

    	
	  	String idiomaBusquedaSelected = LdapUserDetailsUtils.getIdiomaBusqueda();
		String idiomaSelected = LdapUserDetailsUtils.getIdioma();
		I18n i18n = I18n.getInstance();
		LocalizacionIdiomaVO[] localizadorBusquedaIdioma = i18n.obtenerIdiomasBuscablesLocalizados(idiomaSelected);
		form.setIdiomaBusquedaBackingList(Arrays.asList(localizadorBusquedaIdioma), "idLocalizacion", "name");
		LocalizacionIdiomaVO[] localizadorNavegacionIdioma = i18n.obtenerIdiomasPlataformaLocalizados(idiomaSelected);
		form.setIdiomaBackingList(Arrays.asList(localizadorNavegacionIdioma), "idLocalizacion", "name");
		String usuarioModificar = LdapUserDetailsUtils.getUsuario();
		UsuarioVO usuario = this.getSrvAdminUsuariosService().obtenerDatosUsuario(usuarioModificar);
		form.setTipoEmpaquetador(usuario.getTipoEmpaquetador());
		form.setApellido1(usuario.getApellido1());
		form.setNombre(usuario.getNombre());
		form.setUsuario(usuario.getUsuario());
		form.setId(usuario.getId());
		form.setEmail(usuario.getEmail());
		form.setApellido2(usuario.getApellido2());
		form.setIdioma(usuario.getIdioma());
		form.setIdiomaBusqueda(usuario.getIdiomaBusqueda());
		form.setNIF(usuario.getNIF());
		form.setTipoCatalogador(usuario.getTipoCatalogador());
		form.setOpenIdUrl(usuario.getOpenIdUrl());
		//convertimos los bytes de cuota a mbytes para mostrarlos por pantalla
		long cuota = (long)(usuario.getCuota().intValue()/1048576);
		form.setCuota(cuota);
		
		//recogemos los roles del usuario
		String[] roles = this.getSrvAdminUsuariosService().listarRolesUsuario(usuarioModificar);
		
		//Comprobamos si el rol del usuario es únicamente EMPAQUETADOR
		if((roles.length == 1)&&(roles[0].equalsIgnoreCase(getPropertyValue("rolEmpaquetador"))))
		{
			log("El usuario es empaquetador no puede modificar el tipo de empaquetador");
			form.setRolEmpaquetador("S");
		}else
		{
			form.setRolEmpaquetador("N");
		}
		
		//Comprobamos si el rol del usuario es únicamente CATALOGADOR
		if((roles.length == 1)&&(roles[0].equalsIgnoreCase(getPropertyValue("rolCatalogador"))))
		{
			log("El usuario es empaquetador no puede modificar el tipo de empaquetador");
			form.setRolCatalogador("S");
		}else
		{
			form.setRolCatalogador("N");
		}
		
		//Comprobamos si el usuario tiene rol de administrador
		String rolAdmin = new String("N");
		for(int i=0;i<roles.length;i++)
		{
			if(roles[i].equalsIgnoreCase(getPropertyValue("rolAdministrador")))
				rolAdmin = "S";
		}
			
		form.setRolAdministrador(rolAdmin);
		
		log("despues de cargar los datos en el formulario");
    }

    /**
     * @see es.pode.administracion.presentacion.adminusuarios.modificarPerfil.ModificarPerfilController#modificarUsuarioMismo(org.apache.struts.action.ActionMapping,
     *      es.pode.administracion.presentacion.adminusuarios.modificarPerfil.ModificarUsuarioMismoForm,
     *      javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public final void modificarUsuarioMismo(ActionMapping mapping, es.pode.visualizador.presentacion.modificarPerfil.ModificarUsuarioMismoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
    	    	
    	String resultado = null;
		try {
		    //String idiomaSelected = LdapUserDetailsUtils.getIdioma();
		    String nombre = request.getParameter("nombre");
		    String apellido1 = request.getParameter("apellido1");
		    Long id = Long.valueOf(request.getParameter("id"));
		    String apellido2 = request.getParameter("apellido2");
		    String email = request.getParameter("email");
		    String idioma = request.getParameter("idioma");
		    String idiomaBusqueda = request.getParameter("idiomaBusqueda");
		    String tipoEmpaquetador = request.getParameter("tipoEmpaquetador");
		    String clave = request.getParameter("clave");
		    String openIdUrl = request.getParameter("openIdUrl");
		    String repitaClave = request.getParameter("repitaClave");
		    String tipoCatalogador = request.getParameter("tipoCatalogador");
		    long cuota = 0;
		    Matcher matcher = null;
		    if(request.getParameter("cuota").length() > 0)
		    {
		    	Pattern maskNum = Pattern.compile("[0-9]+");
				matcher = maskNum.matcher(request.getParameter("cuota"));
			    if (!matcher.matches()) 
			    {
			    	if(log.isDebugEnabled())log.debug("cuota caracter ilegal");
			    	throw new ValidatorException("{errors.modificarusuario.cuota}");
			    }
			    	cuota = Long.valueOf(request.getParameter("cuota")).longValue();
			    	cuota = cuota * 1024 * 1024;
		    }
		    
		    UsuarioVO usuarioVO = this.getSrvAdminUsuariosService().descripcionUsuario(id);
		    // Validaciones de los campos que recogemos del formulario
		    Pattern mask = Pattern.compile("[^\\¿\\?\\¡\\!\\>\\#\\&\\<\\@\\$\\/\\\'\\\"]+");
    	    // Validaciones para password
    	    Pattern maskPwd = Pattern.compile("[^Ññ\\¿\\?\\¡\\!\\>\\#\\&\\<\\@\\$\\/\\\'\\\"]+");
		    
	
		    if (nombre.length() <= 0) {
			log("nombre.length() <= 0");
			throw new ValidatorException("{errors.modificarusuario.nombre}");
		    }
		    matcher = mask.matcher(nombre);
		    if (!matcher.matches()) {
			log("nombre caracter ilegal");
	
			throw new ValidatorException("{errors.modificarusuario.nombre.caracterIlegal}");
		    }
	
		    if (apellido1.length() <= 0) {
			log("apellido1.length() <= 0");
	
			throw new ValidatorException("{errors.modificarusuario.apellido1}");
		    }
		    matcher = mask.matcher(apellido1);
		    if (!matcher.matches()) {
			log("apellido1 caracter ilegal");
			throw new ValidatorException("{errors.modificarusuario.apellido1.caracterIlegal}");
		    }
		    if (apellido2.length() > 0) {
			matcher = mask.matcher(apellido2);
			if (!matcher.matches()) {
			    log("apellido2 caracter ilegal");
			    throw new ValidatorException("{errors.modificarusuario.apellido2.caracterIlegal}");
			}
		    }
		    /*
		     * if (apellido2.length() <= 0) { log("apellido2.length() <=
		     * 0");
		     * 
		     * throw new
		     * ValidatorException("{errors.modificarusuario.apellido2}"); }
		     * matcher = mask.matcher(apellido2); if (!matcher.matches()) {
		     * log("apellido2 caracter ilegal"); throw new
		     * ValidatorException("{errors.altausuario.modificarusuario.caracterIlegal}"); }
		     */
		    if (email.length() <= 0) {
			log("email.length() <= 0");
			throw new ValidatorException("{errors.modificarusuario.email}");
		    }
		    if (!((email.indexOf("@") > 0) && (email.indexOf(".") > 0))) {
			throw new ValidatorException("{errors.modificarusuario.emailIncorrecto}");
		    }
	
		    if ((clave == null) || (clave.equalsIgnoreCase(""))) {
			log("No se modifica la clave");
		    } else {
				if (clave.length() < 7) {
				    log("clave .length() <= 7");
				    throw new ValidatorException("{errors.modificarusuario.clave}");
				}
				
			    matcher = maskPwd.matcher(clave);
			    if (!matcher.matches()) {
			    	log("contraseña caracter ilegal");
			    	throw new ValidatorException(
								"{errors.modificarusuario.clave.caracterIlegal}");
			    }
		
				if (!(clave.equalsIgnoreCase(repitaClave))) {
				    throw new ValidatorException("{errors.modificarusuario.claveDistintas}");
				}
				usuarioVO.setClave(clave);
		    }
		    if(openIdUrl!=null && openIdUrl.length()>0){
		    	UsuarioVO usuariovo=this.getSrvAdminUsuariosService().obtenerUsuarioConOpenId(openIdUrl);
		    	if(usuariovo!=null && !usuariovo.getUsuario().equals(usuarioVO.getUsuario())){
		    		if(log.isDebugEnabled())log.debug("Ese identificador de openId ya existe en la base de datos");
			    	throw new ValidatorException("{errors.altausuario.existe.openId}");
		    	}
		    	
		    }
		    if (idiomaBusqueda == null) {
			throw new ValidatorException("{errors.modificarusuario.idiomaBusqueda}");
		    }
		    if (idiomaBusqueda.length() <= 0) {
			log("empaquetador .length() <= 0");
			throw new ValidatorException("{errors.modificarusuario.idiomaBusqueda}");
		    }
	
		    if (idioma == null) {
			throw new ValidatorException("{errors.modificarusuario.idioma}");
		    }
		    if (idioma.length() <= 0) {
			log("empaquetador .length() <= 0");
			throw new ValidatorException("{errors.modificarusuario.idioma}");
		    }
	
		    if (tipoEmpaquetador == null) {
			throw new ValidatorException("{errors.modificarusuario.tipoEmpaquetador}");
		    }
		    if (tipoEmpaquetador.length() <= 0) {
			log("empaquetador .length() <= 0");
			throw new ValidatorException("{errors.modificarusuario.tipoEmpaquetador}");
		    }
	
		    // /////Fin de validaciones de campo //////////
	
		    usuarioVO.setNombre(nombre);
		    usuarioVO.setApellido1(apellido1);
		    usuarioVO.setApellido2(apellido2);
		    usuarioVO.setEmail(email);
		    usuarioVO.setTipoEmpaquetador(tipoEmpaquetador);
		    usuarioVO.setIdioma(idioma);
		    usuarioVO.setIdiomaBusqueda(idiomaBusqueda);
		    usuarioVO.setTipoCatalogador(tipoCatalogador);
		    usuarioVO.setCuota(new Long(cuota));
		    usuarioVO.setOpenIdUrl(openIdUrl);
	
		    usuarioVO.setId(id);
		    resultado = this.getSrvAdminUsuariosService().modificarUsuario(usuarioVO);
		    // Fijamos la cookie de modificarPerfil
		    String cookiesPerfil = this.getPropertyValue("cookieModificarPerfil");
		    Long tiempo = new Long(System.currentTimeMillis());
		    Cookie cookie = new Cookie(cookiesPerfil, tiempo.toString());
		    cookie.setPath("/");
		    response.addCookie(cookie);
		    log("se ha creado la cookie MODIFICAR_PERFIL " + tiempo);
		} catch (ValidatorException ve) {
		    log.error("se ha producido una validatorException");
		    resultado = "FALLO.MODIFICARUSUARIO";
		    throw ve;
		} catch (Exception e) {
		    log.error("Error: " + e);
		    resultado = "FALLO.MODIFICARUSUARIO";
		    throw new ValidatorException("{modificarUsuario.error}");
	
		} finally {
	
		    // /Elimino de la sesion la descripcion del grupo
	
		    form.setResultadoModificacion(resultado);
		}

    }

    private void log(Object obj) {
    	
		if (log.isDebugEnabled())
		    log.debug(obj);
    }

    private String getPropertyValue(String sKey) throws IOException {
    	
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/spring_visualizadorcontenidos.properties");
		if (this.pSpringProperties == null) {
		    pSpringProperties = new java.util.Properties();
		    pSpringProperties.load(fIsSpringProperties);
		}

		// devolvemos la propiedad
		return pSpringProperties.getProperty(sKey);
    }

}