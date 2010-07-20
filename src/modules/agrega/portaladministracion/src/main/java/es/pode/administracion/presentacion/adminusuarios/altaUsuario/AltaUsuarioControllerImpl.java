/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.altaUsuario;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.administracion.presentacion.adminusuarios.altaUsuario.AltaUsuarioBSession;
import es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO;
import es.pode.adminusuarios.negocio.servicios.GrupoVO;
import es.pode.adminusuarios.negocio.servicios.RolVO;
import es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService;
import es.pode.adminusuarios.negocio.servicios.UsuarioVO;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.i18n.LocalizacionIdiomaVO;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

/**
 * @see es.pode.administracion.presentacion.adminusuarios.altaUsuario.AltaUsuarioController
 */
public class AltaUsuarioControllerImpl extends AltaUsuarioController {

    private static Logger log = Logger.getLogger(AltaUsuarioControllerImpl.class);

    /**
         * @see es.pode.administracion.presentacion.adminusuarios.altaUsuario.AltaUsuarioController#recuperarGrupos(org.apache.struts.action.ActionMapping,
         *      es.pode.administracion.presentacion.adminusuarios.altaUsuario.RecuperarGruposForm,
         *      javax.servlet.http.HttpServletRequest,
         *      javax.servlet.http.HttpServletResponse)
         */
    public final void recuperarGrupos(ActionMapping mapping,
	    es.pode.administracion.presentacion.adminusuarios.altaUsuario.RecuperarGruposForm form,
	    HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
	      	 
		String idiomaSelected = LdapUserDetailsUtils.getIdioma();
		I18n i18n = I18n.getInstance();
		LocalizacionIdiomaVO[] localizadorNavegacionIdioma = i18n.obtenerIdiomasPlataformaLocalizados(idiomaSelected);
		form.setIdiomaBackingList(Arrays.asList(localizadorNavegacionIdioma), "idLocalizacion", "name");
		LocalizacionIdiomaVO[] localizadorBusquedaIdioma = i18n.obtenerIdiomasBuscablesLocalizados(idiomaSelected);
		form.setIdiomaBusquedaBackingList(Arrays.asList(localizadorBusquedaIdioma), "idLocalizacion", "name");
		
		String usuario = form.getUsuario();
		LdapUserDetailsUtils.esAdministrador();
		try {
		    // VALIDACIONES DE LOS CAMPOS DEL FORMULARIO
		    String nombre = form.getNombre();
		    String apellido1 = form.getApellido1();
		    String apellido2 = form.getApellido2();
	
		    Pattern mask = Pattern.compile("[^\\¿\\?\\¡\\!\\>\\#\\&\\<\\@\\$\\/\\\'\\\"]+");
    	    // Validaciones para password
    	    Pattern maskPwd = Pattern.compile("[^Ññ\\¿\\?\\¡\\!\\>\\#\\&\\<\\@\\$\\/\\\'\\\"]+");

		    Matcher matcher = null;
	
		    if (nombre.length() <= 0) {
				if(log.isDebugEnabled())log.debug("nombre.length() <= 0");
				throw new ValidatorException("{errors.altausuario.nombre}");
		    }
		    matcher = mask.matcher(nombre);
		    if (!matcher.matches()) {
		    	if(log.isDebugEnabled())log.debug("nombre caracter ilegal");
	
		    	throw new ValidatorException("{errors.altausuario.nombre.caracterIlegal}");
		    }
	
		    if (apellido1.length() <= 0) {
		    	if(log.isDebugEnabled())log.debug("apellido1.length() <= 0");
	
		    	throw new ValidatorException("{errors.altausuario.apellido1}");
		    }
		    matcher = mask.matcher(apellido1);
		    if (!matcher.matches()) {
		    	if(log.isDebugEnabled())log.debug("apellido1 caracter ilegal");
		    	throw new ValidatorException("{errors.altausuario.apellido1.caracterIlegal}");
		    }
		    
		    if(apellido2.length() > 0)
		    {
			    matcher = mask.matcher(apellido2);
			    if (!matcher.matches()) {
			    	if(log.isDebugEnabled())log.debug("apellido2 caracter ilegal");
			    	throw new ValidatorException("{errors.altausuario.apellido2.caracterIlegal}");
			    }
		    }
	
		    String nif = form.getNif();

		    /*
	                 * if (!(validarNif(nif)).booleanValue()) { throw new
	                 * ValidatorException("{errors.altausuario.nifErroneo}"); }
	                 */
	
		    String email = form.getEmail();
	
		    if (email.length() <= 0) {
		    	if(log.isDebugEnabled())log.debug("email.length() <= 0");
		    	throw new ValidatorException("{errors.altausuario.email}");
		    }
		    if (!((email.indexOf("@") > 0) && (email.indexOf(".") > 0)) || (email.indexOf(" ") > 0)){
			throw new ValidatorException("{errors.altausuario.emailIncorrecto}");
		    }
	       // Mas validaciones del campo email
		    if(validaEmail(email) == Boolean.FALSE)
		    {
		    	if(log.isDebugEnabled())log.debug("el email es erroneo "+email);
		    	throw new ValidatorException("{errors.altausuario.emailIncorrecto}");
		    }
		    if (usuario.length() <= 0) {
		    	if(log.isDebugEnabled())log.debug("usuario length() <= 0");
		    	throw new ValidatorException("{errors.altausuario.usuario}");
		    }
		    matcher = mask.matcher(usuario);
		    if (!matcher.matches()) {
		    	if(log.isDebugEnabled())log.debug("nombre caracter ilegal");
		    	throw new ValidatorException(
							"{errors.altausuario.usuario.caracterIlegal}");
		    }
		    //el usuario debe ir en minúsculas - COMENTADO
		    /*
		    if (usuario.compareTo(usuario.toLowerCase())!=0){
		    	log("el usuario debe estar en minúsculas");
		    	throw new ValidatorException("{errors.altausuario.usuario.minusculas}");
		    }
		    */
		    
	
		    String clave = form.getClave();
		    if (clave.length() < 7) {
		    	if(log.isDebugEnabled())log.debug("clave .length() <= 7");
		    	throw new ValidatorException("{errors.altausuario.clave}");
		    }
		    matcher = maskPwd.matcher(clave);
		    if (!matcher.matches()) {
		    	if(log.isDebugEnabled())log.debug("contraseña caracter ilegal");
		    	throw new ValidatorException(
							"{errors.altausuario.clave.caracterIlegal}");
		    }
		    
		    String repitaClave = form.getRepitaClave();
		    if (!(clave.equalsIgnoreCase(repitaClave))) {
			throw new ValidatorException("{errors.altausuario.claveDistintas}");
		    }
		    
		    String openIdUrl=form.getOpenIdUrl();
		    if(openIdUrl!=null && openIdUrl.length()>0){
		    	UsuarioVO usuariovo=this.getSrvAdminUsuariosService().obtenerUsuarioConOpenId(openIdUrl);
		    	if(usuariovo!=null){
		    		if(log.isDebugEnabled())log.debug("Ese identificador de openId ya existe en la base de datos");
			    	throw new ValidatorException("{errors.altausuario.existe.openId}");
		    	}
		    	
		    }
		    String idiomaBusqueda = form.getIdiomaBusqueda();
	
		    if (idiomaBusqueda == null) {
			throw new ValidatorException("{errors.altausuario.idiomaBusqueda}");
		    }
		    if (idiomaBusqueda.length() <= 0) {
		    	if(log.isDebugEnabled())log.debug("empaquetador .length() <= 0");
		    	throw new ValidatorException("{errors.altausuario.idiomaBusqueda}");
		    }
	
		    String idioma = form.getIdioma();
		    if (idioma == null) {
			throw new ValidatorException("{errors.altausuario.idioma}");
		    }
		    if (idioma.length() <= 0) {
		    	if(log.isDebugEnabled())log.debug("empaquetador .length() <= 0");
		    	throw new ValidatorException("{errors.altausuario.idioma}");
		    }
	
		    String tipoEmpaquetador = form.getTipoEmpaquetador();
		    if (tipoEmpaquetador == null) {
			throw new ValidatorException("{errors.altausuario.tipoEmpaquetador}");
		    }
		    if (tipoEmpaquetador.length() <= 0) {
		    	if(log.isDebugEnabled())log.debug("empaquetador .length() <= 0");
		    	throw new ValidatorException("{errors.altausuario.tipoEmpaquetador}");
		    }
		    
		    String tipoCatalogador = form.getTipoCatalogador();
		    if (tipoCatalogador == null) {
			throw new ValidatorException("{errors.altausuario.tipoCatalogador}");
		    }
		    if (tipoCatalogador.length() <= 0) {
		    	if(log.isDebugEnabled())log.debug("catalogador.length() <= 0");
		    	throw new ValidatorException("{errors.altausuario.tipoCatalogador}");
		    }
		    
		    long cuota = 0;
		    if (form.getCuota().length() > 0) 
		    {
				
				//comprobamos que la cuota son unicamente numeros
				Pattern maskNum = Pattern.compile("[0-9]+");
				matcher = maskNum.matcher(form.getCuota());
			    if (!matcher.matches()) 
			    {
			    	if(log.isDebugEnabled())log.debug("cuota caracter ilegal");
			    	throw new ValidatorException("{errors.altausuario.cuota.caracterIlegal}");
			    }
				
				//pasamos de mbytes a bytes la cuota
				cuota = Long.valueOf(form.getCuota()).longValue() * 1024 * 1024;
		    }else{//Por defecto,si no introducen nigún valor le podremos 5 Mb
		    	cuota =Long.valueOf(AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.VALOR_CUOTA_DEFECTO)).longValue() * 1024 * 1024 ;
		    }
	
		    // Una vez recojo todos los datos del formulario compruebo si el
		    // usuario(NIF) ya esta dado de alta si lo esta y no tiene fecha
	                // de
		    // baja
		    // saco un mensaje de error.
		    UsuarioVO usuarioExistente = this.getSrvAdminUsuariosService().obtenerUsuario(nif.toUpperCase());
	
		    if (usuarioExistente == null) {
		    	if(log.isDebugEnabled())log.debug("No existe en BD otro usuario con ese mismo nif");
	
			// Chequeamos si el usuario introducido ya esta en la BD en ese
			// caso
			// sacamos un mensaje de error
			Boolean existeUsuario = this.getSrvAdminUsuariosService().existeUsuario(usuario);
			if (existeUsuario.booleanValue()) {
			    log.error("El usuario introducido en el formulario ya se encuentra registrado");
			    throw new ValidatorException("{errors.altausuario.usuarioExistente}");
			} else {
				if(log.isDebugEnabled())log.debug("El usuario introducido en el formulario no se encuentra en la BD");
			    UsuarioVO usuarioVO = new UsuarioVO();
			    usuarioVO.setApellido1(apellido1);
			    usuarioVO.setApellido2(apellido2);
			    usuarioVO.setClave(clave);
			    usuarioVO.setEmail(email);
			    usuarioVO.setIdiomaBusqueda(idiomaBusqueda);
			    usuarioVO.setNIF(nif.toUpperCase());
			    usuarioVO.setNombre(nombre);
			    usuarioVO.setUsuario(usuario);
			    usuarioVO.setTipoEmpaquetador(tipoEmpaquetador);
			    usuarioVO.setFechaAlta(new GregorianCalendar());
			    usuarioVO.setFechaSolicitudAlta(null);
			    usuarioVO.setIdioma(idioma);
			    usuarioVO.setCuota(new Long(cuota));
			    usuarioVO.setTipoCatalogador(tipoCatalogador);
			    usuarioVO.setOpenIdUrl(openIdUrl);
			    AltaUsuarioBSession altaUsuarioBSesion = this.getAltaUsuarioBSession(request);
			    if(log.isDebugEnabled())log.debug("altaUsuarioBSesion "+altaUsuarioBSesion);
			    altaUsuarioBSesion.setUsuario(usuarioVO);
			}
	
		    } else {
			if (usuarioExistente.getFechaBaja() == null) {
				if(log.isDebugEnabled())log.debug("Saco un mensaje de error ya existe un usuario con ese nif");
			    throw new ValidatorException("{errors.altausuario.nifExistente}");
			} else {
			    // Se mantendrá la fecha de alta y el usuario, se
	                        // modificara
			    // la clave en el servidor ldap
				if(log.isDebugEnabled())log.debug("Voy a hacer una modificacion mantengo el usuario, la fecha de alta y el nif");
			    usuarioExistente.setApellido1(apellido1);
			    usuarioExistente.setApellido2(apellido2);
			    usuarioExistente.setClave(clave);
			    usuarioExistente.setEmail(email);
			    usuarioExistente.setIdiomaBusqueda(idiomaBusqueda);
			    usuarioExistente.setNombre(nombre);
			    usuarioExistente.setTipoEmpaquetador(tipoEmpaquetador);
			    usuarioExistente.setIdioma(idioma);
			    usuarioExistente.setOpenIdUrl(openIdUrl);
			    usuarioExistente.setFechaBaja(null);
			    usuarioExistente.setFechaSolicitudAlta(null);
			    if(log.isDebugEnabled())log.debug("Antes de guardar en sesion el usuarioVO ");
			    this.getAltaUsuarioBSession(request).setUsuario(usuarioExistente);
			    if(log.isDebugEnabled())log.debug("Se guarda en sesion el usuarioVO ");
			}
		    }
		} catch (ValidatorException validator) {
		    log.error("Se produce la siguiente excepcion ", validator);
		    throw validator;
		} catch (Exception e) {
		    log.error("Se produce la siguiente excepcion ", e);
		    throw new ValidatorException("{errors.altausuario}");
		}
		try {
		    GrupoVO[] grupoVO = this.getSrvAdminUsuariosService().listarGrupos();
		    form.setGruposAsArray(grupoVO);
		} catch (Exception e) {
		    log.error("Error al recoger los parametros del usuario y comprobar si esta registrado en el sistema " + e);
		    throw new ValidatorException("{errors.altausuario}");
		}
    }

    /**
         * @see es.pode.administracion.presentacion.adminusuarios.altaUsuario.AltaUsuarioController#altaUsuario(org.apache.struts.action.ActionMapping,
         *      es.pode.administracion.presentacion.adminusuarios.altaUsuario.AltaUsuarioForm,
         *      javax.servlet.http.HttpServletRequest,
         *      javax.servlet.http.HttpServletResponse)
         */
    public final java.lang.String altaUsuario(ActionMapping mapping,
	    es.pode.administracion.presentacion.adminusuarios.altaUsuario.AltaUsuarioForm form,
	    HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	
		String resultado = "";
		Long idCreado = null;
		try {
		    AltaUsuarioBSession altaUsuarioBSession = this.getAltaUsuarioBSession(request);
		    UsuarioVO usuarioSesion = altaUsuarioBSession.getUsuario();
		    SrvAdminUsuariosService srvAdminUsuariosService = this.getSrvAdminUsuariosService();
	
		    if(log.isDebugEnabled())log.debug("Elimino de la sesion la descripcion del grupo");
		    if(log.isDebugEnabled())log.debug("Obtenemos el administrador que va a dar de alta al usuario");
		    String usuario = LdapUserDetailsUtils.getUsuario();
	
		    UsuarioVO adminVO = srvAdminUsuariosService.obtenerDatosUsuario(usuario);
		    if(log.isDebugEnabled())log.debug("el administrador es " + adminVO.getId());
		    idCreado = srvAdminUsuariosService.altaUsuario(usuarioSesion, adminVO);
		    form.setIdModificado(idCreado);
		    resultado = idCreado!=null?"OK":"FALLO";
		    this.removeAltaUsuarioBSession(request);
		    
	
		} catch (Exception e) {
		    log.error("Error al dar de alta un usuario ", e);
		    resultado = "FALLO";
	
		} finally {
	
		    form.setResultado(resultado);
	
		}
		return resultado;
    }

    /**
         * @see es.pode.administracion.presentacion.adminusuarios.altaUsuario.AltaUsuarioController#obtenerIdiomas(org.apache.struts.action.ActionMapping,
         *      es.pode.administracion.presentacion.adminusuarios.altaUsuario.ObtenerIdiomasForm,
         *      javax.servlet.http.HttpServletRequest,
         *      javax.servlet.http.HttpServletResponse)
         */
    public final void obtenerIdiomas(ActionMapping mapping,
	    es.pode.administracion.presentacion.adminusuarios.altaUsuario.ObtenerIdiomasForm form,
	    HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	String idiomaSelected = LdapUserDetailsUtils.getIdioma();
    	I18n i18n = I18n.getInstance();
		LocalizacionIdiomaVO[] localizadorNavegacionIdioma = i18n.obtenerIdiomasPlataformaLocalizados(idiomaSelected);
		form.setIdiomaBackingList(Arrays.asList(localizadorNavegacionIdioma), "idLocalizacion", "name");
		LocalizacionIdiomaVO[] localizadorBusquedaIdioma = i18n.obtenerIdiomasBuscablesLocalizados(idiomaSelected);
		form.setIdiomaBusquedaBackingList(Arrays.asList(localizadorBusquedaIdioma), "idLocalizacion", "name");
		
    }

    /**
         * @see es.pode.administracion.presentacion.adminusuarios.altaUsuario.AltaUsuarioController#submit(org.apache.struts.action.ActionMapping,
         *      es.pode.administracion.presentacion.adminusuarios.altaUsuario.SubmitForm,
         *      javax.servlet.http.HttpServletRequest,
         *      javax.servlet.http.HttpServletResponse)
         */
    public final void submit(ActionMapping mapping,
	    es.pode.administracion.presentacion.adminusuarios.altaUsuario.SubmitForm form, HttpServletRequest request,
	    HttpServletResponse response) throws Exception {
		try {
		    AltaUsuarioBSession altaUsuarioBSession = this.getAltaUsuarioBSession(request);
		    UsuarioVO usuarioSesion = altaUsuarioBSession.getUsuario();
		    String[] ids = form.getIdRowSelectionAsArray();
		    SrvAdminUsuariosService srvAdminUsuariosService = this.getSrvAdminUsuariosService();
	
		    if (ids == null) {
		    	if(log.isDebugEnabled())log.debug("No se ha seleccionado ningun grupo");
			 throw new ValidatorException("{errors.altausuario.gruposVacio}");
			//usuarioSesion.setGrupos(null);
	
		    } else {
			GrupoVO[] grupoVO = new GrupoVO[ids.length];
			Long idL = null;
			for (int i = 0; i < ids.length; i++) {
			    idL = new Long(ids[i]);
	
			    GrupoVO grupoG = srvAdminUsuariosService.descripcionGrupo(idL);
			    grupoVO[i] = grupoG;
	
			}
			usuarioSesion.setGrupos(grupoVO);
		    }
		    this.getAltaUsuarioBSession(request).setUsuario(usuarioSesion);
		} catch(ValidatorException ve)
		{
		   log.error("Se produce un error ValidatorException "+ve); 
		   throw ve;
		} catch (Exception e) {
		    log.error("Error al obtener los grupos seleccionados ", e);
		}
    }

    /**
     *  Metodo que recoge los roles del usuario y mira si tiene el rol catalogador o empaquetador para mostrar la pantalla de Grupos de Trabajo
     *  o no mostrarla
     */
    public final java.lang.String rolParaGruposTrabajo(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.adminusuarios.altaUsuario.RolParaGruposTrabajoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	AltaUsuarioBSession altaUsuarioBSession = this.getAltaUsuarioBSession(request);
	    UsuarioVO usuarioSesion = altaUsuarioBSession.getUsuario();
	    String resultado = "FALLO";
	    boolean siRoles = true;
	    try
	    {
	    
		    //recogemos los grupos que se han asigando al usuario y vemos que roles contienen
		    GrupoVO[] grupos = usuarioSesion.getGrupos();
		    
		    siRoles = validarRolesDocenteYCatalogador(grupos);
		    
		    if(siRoles)
		    	resultado = "OK";
	    }
	    catch(Exception e)
	    {
	    	log.error("Error al obtener los roles del usuario ", e);
	    	throw new ValidatorException("{errors.altausuario}");
	    }
	    
	    finally 
	    {
		    form.setResultado(resultado);
		}
	    
    	return resultado;
    }
    
    /** Metodo que asigna los grupos de trabajo seleccionados por el administrador al usuario
	 * @param form formulario con los datos del usuario que se quiere dar de alta
	 * @throws Exception
	 */
   
	public void asignarGruposTrabajo(ActionMapping mapping, AsignarGruposTrabajoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		try {
		    AltaUsuarioBSession altaUsuarioBSession = this.getAltaUsuarioBSession(request);
		    UsuarioVO usuarioSesion = altaUsuarioBSession.getUsuario();
		    
		    //recogemos los grupos que se han asigando al usuario y vemos que roles contienen
		    GrupoVO[] grupos = usuarioSesion.getGrupos();
		    
		    //comprobamos si ha pasado por la pantalla de grupos de catalogadores o no para validarlos
		    if(validarRolesDocenteYCatalogador(grupos))
		    {
		    
			    
			    String[] ids = form.getIdentificadorRowSelectionAsArray();
			    if(log.isDebugEnabled())log.debug("Los identificadores seleccionados son los siguientes "+ids);
			    
			    SrvAdminUsuariosService srvAdminUsuariosService = this.getSrvAdminUsuariosService();
		
			    if (ids == null) 
			    {
			    	if(log.isDebugEnabled())log.debug("No se ha seleccionado ningun grupo");
					throw new ValidatorException("{errors.altausuario.gruposTrabajoVacio}");
			    } 
			    
			    else 
			    {
					GrupoTrabajoVO[] grupoTrabajoVO = new GrupoTrabajoVO[ids.length];
					if(log.isDebugEnabled())log.debug("grupoTrabajoVO.length "+grupoTrabajoVO.length);
					Long idL = null;
					for (int i = 0; i < ids.length; i++) 
					{
					    idL = new Long(ids[i]);
			
					    GrupoTrabajoVO grupoG = srvAdminUsuariosService.descripcionGrupoTrabajo(idL);
					    grupoTrabajoVO[i] = grupoG;
			
					}
					usuarioSesion.setGrupoTrabajo(grupoTrabajoVO);
			    }
		    }
		    
		    //metemos en sesion el usuario
		    this.getAltaUsuarioBSession(request).setUsuario(usuarioSesion);
		    
		} 
		catch(ValidatorException ve)
		{
		   log.error("Se produce un error ValidatorException "+ve); 
		   throw ve;
		} 
		catch (Exception e) {
		    log.error("Error al obtener los grupos seleccionados ", e);
		}
		
	}

	/**
	 * Metodo que recupera todos los grupos de trabajo que existen en la plataforma
	 * @param form formulario con los datos del usuario que se quiere dar de alta
	 * @throws Exception
	 */
	
	public void recuperarGruposTrabajo(ActionMapping mapping, RecuperarGruposTrabajoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		try {
		    GrupoTrabajoVO[] grupoTrabajoVO = this.getSrvAdminUsuariosService().listarGruposTrabajo();
		    form.setGruposTrabajoAsArray(grupoTrabajoVO);
		} catch (Exception e) {
		    log.error("Error al obtener los grupos de trabajo " + e);
		    throw new ValidatorException("{errors.altausuario}");
		}
		
	}


    private Boolean validarNif(String nif) {

		Boolean resultado = Boolean.TRUE;
		// el valor debe tener 9 posiciones, de las cuales las primeras deben
		// ser dígitos y la última letra
		try {
		    int longitud = nif.length();
		    String dni = nif.substring(0, longitud - 1);
		    dni = dni.toUpperCase();
		    String digitoControl = nif.substring(longitud - 1, longitud);
		    digitoControl = digitoControl.toUpperCase();
	
		    if (digitoControl.matches("[A-Z]")) {
	
			String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
			int posicion_modulo = Integer.parseInt(dni) % 23;
	
			String digitoControlCalculado = letras.substring(posicion_modulo, posicion_modulo + 1);
	
			if (!digitoControl.equalsIgnoreCase(digitoControlCalculado)) {
			    resultado = Boolean.FALSE;
			}
	
		    } else {
			resultado = Boolean.FALSE;
		    }
		} catch (Exception e) {
		    log.error("Error al validar el nif " + e);
		    resultado = Boolean.FALSE;
		}
		return resultado;
    }
    
    private Boolean validaEmail(String email){
		Boolean resultado = Boolean.TRUE;
		if(log.isDebugEnabled())log.debug("VALIDAEMAIL");
		//Pattern pattern = Pattern.compile("[^A-Za-z0-9\\.\\@_\\-~#]+");
		Pattern pattern = Pattern.compile("[A-Za-z0-9.-_]([A-Za-z0-9.-_])*@[A-Za-z0-9]([A-Za-z0-9.-_])*.([A-Za-z0-9])*");
		if(log.isDebugEnabled())log.debug("pattern.toString() "+pattern.toString());
		Matcher matcher = pattern.matcher(email);
		if (matcher.find()) {
			if(log.isDebugEnabled())log.debug("El email coincide con el patron es correcto el campo email");
		} else {
			resultado = Boolean.FALSE;
		}
		return resultado;

    }

    
    /*
     * validamos si los roles que se pasan son Docente y Catalogador o Publicador
     */
    private boolean validarRolesDocenteYCatalogador(GrupoVO[] grupos)
    {
    	boolean resultado = false;
    	
    	Vector roles = new Vector();
	    RolVO[] rolParcial = null;
	    int h = 0;
	    
	    for (int i = 0; i < grupos.length; i++) 
	    {
	    	rolParcial = grupos[i].getRols();
	    	
	    	for (int j = 0; j < rolParcial.length; j++) 
	    	{
	    		roles.add(rolParcial[j].getDescripcion());
			}
		}
	    
	    String rol_catalogador=AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.ROL_CATALOGADOR);
	    String rol_empaquetador=AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.ROL_EMPAQUETADOR);
	    String rol_publicador=AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.ROL_PUBLICADOR);
	   
	    
	    if(log.isDebugEnabled())log.debug("recogemos los roles -> " + rol_catalogador + rol_empaquetador);
	    if(roles.indexOf(rol_catalogador) >= 0 || roles.indexOf(rol_empaquetador) >= 0 || roles.indexOf(rol_publicador) >= 0)
	    	resultado = true;
    	return resultado;
    }
    
    
	
}
