/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.modificarUsuario;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
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
import es.pode.administracion.presentacion.adminusuarios.modificarUsuario.ModificarUsuarioBSession;
import es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO;
import es.pode.adminusuarios.negocio.servicios.GrupoVO;
import es.pode.adminusuarios.negocio.servicios.RolVO;
import es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService;
import es.pode.adminusuarios.negocio.servicios.UsuarioVO;
import es.pode.soporte.i18n.LocalizacionIdiomaVO;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
 
/**
 * @see es.pode.administracion.presentacion.adminusuarios.modificarUsuario.ModificarUsuarioController
 */
public class ModificarUsuarioControllerImpl extends ModificarUsuarioController {

    private static Logger log = Logger.getLogger(ModificarUsuarioControllerImpl.class);

    /**
         * @see es.pode.administracion.presentacion.adminusuarios.modificarUsuario.ModificarUsuarioController#recuperarUsuario(org.apache.struts.action.ActionMapping,
         *      es.pode.administracion.presentacion.adminusuarios.modificarUsuario.RecuperarUsuarioForm,
         *      javax.servlet.http.HttpServletRequest,
         *      javax.servlet.http.HttpServletResponse)
         */
    public final void recuperarUsuario(ActionMapping mapping,
	    es.pode.administracion.presentacion.adminusuarios.modificarUsuario.RecuperarUsuarioForm form,
	    HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	 
		try {
	
			String idiomaSelected = LdapUserDetailsUtils.getIdioma();
			I18n i18n = I18n.getInstance();
			LocalizacionIdiomaVO[] localizadorNavegacionIdioma = i18n.obtenerIdiomasPlataformaLocalizados(idiomaSelected);
			form.setIdiomaBackingList(Arrays.asList(localizadorNavegacionIdioma), "idLocalizacion", "name");
			LocalizacionIdiomaVO[] localizadorBusquedaIdioma = i18n.obtenerIdiomasBuscablesLocalizados(idiomaSelected);
			form.setIdiomaBusquedaBackingList(Arrays.asList(localizadorBusquedaIdioma), "idLocalizacion", "name");
					    
		    Long id = Long.valueOf(request.getParameter("id"));
		    if (id == null) {
			throw new ValidatorException("{errors.modificarusuario.idNulo}");
		    } else {
			UsuarioVO usuario = this.getSrvAdminUsuariosService().descripcionUsuario(id);
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
			long cuota = (long)(usuario.getCuota()/1048576);
			
			form.setCuota(Long.valueOf(cuota).toString());
			// form.setRepitaClave(usuario.getClave());
	
		    }
		} catch (ValidatorException va) {
		    throw va;
		} catch (Exception e) {
		    log.error("Error!!: " + e);
		    throw new ValidatorException("{modificarUsuario.error}");
		}
    }

    /**
    * 	Se recuperan los valores del usuario para mostrarlos en la pantalla de modificar
    * 	No se podran modificar el usuario ni el nif
    */
    public final void recuperarGrupos(ActionMapping mapping,
	    es.pode.administracion.presentacion.adminusuarios.modificarUsuario.RecuperarGruposForm form,
	    HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	
		try {
		    
		    String nombre = request.getParameter("nombre");
		    String apellido1 = request.getParameter("apellido1");
		    Long id = Long.valueOf(request.getParameter("id"));
		    String apellido2 = request.getParameter("apellido2");
		    String email = request.getParameter("email");
		    String idioma = request.getParameter("idioma");
		    String idiomaBusqueda = request.getParameter("idiomaBusqueda");
		    String tipoEmpaquetador = request.getParameter("tipoEmpaquetador");
		    String clave = request.getParameter("clave");
		    String repitaClave = request.getParameter("repitaClave");
		    String tipoCatalogador = request.getParameter("tipoCatalogador");
		    String openIdUrl=request.getParameter("openIdUrl");
		    
		    
		    UsuarioVO usuarioVO = this.getSrvAdminUsuariosService().descripcionUsuario(id);
		    // Validaciones de los campos que recogemos del formulario
		    Pattern mask = Pattern.compile("[^\\¿\\?\\¡\\!\\>\\#\\&\\<\\@\\$\\/\\\'\\\"]+");
    	    // Validaciones para password
    	    Pattern maskPwd = Pattern.compile("[^Ññ\\¿\\?\\¡\\!\\>\\#\\&\\<\\@\\$\\/\\\'\\\"]+");

		    Matcher matcher = null;
		    
		    
		    long cuota = 0;
		    if(request.getParameter("cuota").length() > 0) 
		    {
				
				//comprobamos que la cuota son unicamente numeros
				Pattern maskNum = Pattern.compile("[0-9]+");
				matcher = maskNum.matcher(request.getParameter("cuota"));
			    if (!matcher.matches()) 
			    {
			    	if(log.isDebugEnabled())log.debug("cuota caracter ilegal");
			    	throw new ValidatorException("{errors.altausuario.cuota.caracterIlegal}");
			    }
				
				//pasamos de mbytes a bytes la cuota
				cuota = Long.valueOf(request.getParameter("cuota")).longValue() * 1024 * 1024;
		    }else{//Por defecto,si no introducen nigún valor le podremos 5 Mb
		    	cuota =Long.valueOf(AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.VALOR_CUOTA_DEFECTO)).longValue() * 1024 * 1024 ;
		    }	    
		    
		    
	
		    if (nombre.length() <= 0) {
		    	
		    	if(log.isDebugEnabled())log.debug("nombre.length() <= 0");
				throw new ValidatorException("{errors.modificarusuario.nombre}");
		    }
		    
		    matcher = mask.matcher(nombre);
		    
		    if (!matcher.matches()) {
		    	
		    	if(log.isDebugEnabled())log.debug("nombre caracter ilegal");
				throw new ValidatorException("{errors.modificarusuario.nombre.caracterIlegal}");
		    }
	
		    if (apellido1.length() <= 0) {
		    	
		    	if(log.isDebugEnabled())log.debug("apellido1.length() <= 0");
				throw new ValidatorException("{errors.modificarusuario.apellido1}");
		    }
		    
		    matcher = mask.matcher(apellido1);
		    
		    if (!matcher.matches()) {
		    	
		    	if(log.isDebugEnabled())log.debug("apellido1 caracter ilegal");
				throw new ValidatorException("{errors.modificarusuario.apellido1.caracterIlegal}");
		    }
	
		    if(apellido2.length() > 0)
		    {
			    matcher = mask.matcher(apellido2);
			    
			    if (!matcher.matches()) {
			    	
			    	if(log.isDebugEnabled())log.debug("apellido2 caracter ilegal");
					throw new ValidatorException("{errors.modificarusuario.apellido2.caracterIlegal}");
			    }
		    }
	
		    if (email.length() <= 0) {
		    	
		    	if(log.isDebugEnabled())log.debug("email.length() <= 0");
				throw new ValidatorException("{errors.modificarusuario.email}");
		    }
		    
		    if (!((email.indexOf("@") > 0) && (email.indexOf(".") > 0))) {
		    	
		    	throw new ValidatorException("{errors.modificarusuario.emailIncorrecto}");
		    }
		    
		    //	  Mas validaciones del campo email
		    if(validaEmail(email) == Boolean.FALSE)
		    {
		    	
		    	if(log.isDebugEnabled())log.debug("el email es erroneo "+email);
				throw new ValidatorException("{errors.modificarusuario.emailIncorrecto}");
		    }
		    
		    if ((clave == null) || (clave.equalsIgnoreCase(""))) {
		    	if(log.isDebugEnabled())log.debug("La clave no se modifica");
		    } 
		    else {
		    	if (clave.length() < 7) {
		    		if(log.isDebugEnabled())log.debug("clave .length() <= 7");
		    		throw new ValidatorException("{errors.modificarusuario.clave}");
		    	}
	
			    matcher = maskPwd.matcher(clave);
			    if (!matcher.matches()) {
			    	if(log.isDebugEnabled())log.debug("contraseña caracter ilegal");
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
		    	
		    	if(log.isDebugEnabled())log.debug("empaquetador .length() <= 0");
		    	throw new ValidatorException("{errors.modificarusuario.idiomaBusqueda}");
		    }
	
		    if (idioma == null) {
		    	
		    	throw new ValidatorException("{errors.modificarusuario.idioma}");
		    }
		    
		    if (idioma.length() <= 0) {
		    	
		    	if(log.isDebugEnabled())log.debug("empaquetador .length() <= 0");
		    	throw new ValidatorException("{errors.modificarusuario.idioma}");
		    }
	
		    if (tipoEmpaquetador == null) {
		    	
		    	throw new ValidatorException("{errors.modificarusuario.tipoEmpaquetador}");
		    }
		    
		    if (tipoEmpaquetador.length() <= 0) {
		    	
		    	if(log.isDebugEnabled())log.debug("empaquetador .length() <= 0");
		    	throw new ValidatorException("{errors.modificarusuario.tipoEmpaquetador}");
		    }
		    
		    if (tipoCatalogador == null) {
		    	
		    	throw new ValidatorException("{errors.modificarusuario.tipoCatalogador}");
		    }
		    
		    if (tipoCatalogador.length() <= 0) {
		    	
		    	if(log.isDebugEnabled())log.debug("empaquetador .length() <= 0");
		    	throw new ValidatorException("{errors.modificarusuario.tipoCatalogador}");
		    }
		    
	
		    usuarioVO.setNombre(nombre);
		    usuarioVO.setApellido1(apellido1);
		    usuarioVO.setApellido2(apellido2);
		    usuarioVO.setEmail(email);
		    usuarioVO.setTipoEmpaquetador(tipoEmpaquetador);
		    usuarioVO.setIdioma(idioma);
		    usuarioVO.setIdiomaBusqueda(idiomaBusqueda);
		    usuarioVO.setId(id);
		    usuarioVO.setTipoCatalogador(tipoCatalogador);
		    usuarioVO.setCuota(new Long(cuota));
		    usuarioVO.setOpenIdUrl(openIdUrl);
	
		    this.getModificarUsuarioBSession(request).setUsuario(usuarioVO);
		    
		    /* Asignamos los grupos que estan seleccionados en el usuario a traves de un metodo java que rellenara la linea a pintar en
		    la jsp con el check marcado o no dependiendo de si el grupo pertenece al usuario.
		    Esto es porque si mandamos el array de grupos para pintarlos no podemos recorrerlo ya que se pintarian todos con check marcado */

		    GrupoVO[] grupoVO = this.getSrvAdminUsuariosService().listarGrupos();
		    
		    GrupoVOCheck[] grupoVOCheck = null;
		    grupoVOCheck = obtenerGrupoCheck(grupoVO, usuarioVO);
		    form.setGruposAsArray(grupoVOCheck);
		    
		    if(log.isDebugEnabled())log.debug("Se añade el login para comprobar si se permite modificar los roles desde la jsp");
		    form.setUsuario(usuarioVO.getUsuario());
		    
		} catch (ValidatorException ve) {
		    log.error("se ha producido una validatorException");
		    throw ve;
		} catch (Exception e) {
		    log.error("Error: " + e);
		    throw new ValidatorException("{modificarUsuario.error}");
		}

    }

    /**
     * Se introducen en la sesion los datos del usuario para despues recuperarlos una vez seleccionados los grupos y almacenarlos
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @throws java.lang.Exception
     */
    public void submit(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.adminusuarios.modificarUsuario.SubmitForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	UsuarioVO usuarioVO = (this.getModificarUsuarioBSession(request)).getUsuario();
		String[] ids = form.getIdRowSelectionAsArray();

		SrvAdminUsuariosService srvAdminUsuariosService = this.getSrvAdminUsuariosService();
		
		try 
		{
			if(usuarioVO.getUsuario().equalsIgnoreCase("administrador"))
			{
				if(log.isDebugEnabled())log.debug("Es el administrador no le vamos a cambiar lo roles");
			}
			else
			{
				if ((ids == null) || (ids.length == 0)) 
				{
					if(log.isDebugEnabled())log.debug("No se modifica los grupos que tiene asignados");
					throw new ValidatorException("{errors.modificacionusuario.gruposVacio}");
				} 
				else 
				{
					GrupoVO[] grupoVO = new GrupoVO[ids.length];
					Long idL = null;
					for (int i = 0; i < ids.length; i++) 
					{
						idL = new Long(ids[i]);
						GrupoVO grupoG = srvAdminUsuariosService.descripcionGrupo(idL);
						grupoVO[i] = grupoG;
					}
					usuarioVO.setGrupos(grupoVO);
					
				}
			}
			
			this.getModificarUsuarioBSession(request).setUsuario(usuarioVO);
			
		} 
		catch (ValidatorException ve) 
		{
			log.error("Se produce la siguiente excepcion " + ve);
			throw ve;
		} 
		catch (Exception e) 
		{
			log.error("Se produce la siguiente exception ", e);
			throw new ValidatorException("{modificarUsuario.error}");
		}
    }
    
    
    
    /**
     * metodo que comprueba si el usuario tiene rol catalogador o empaquetador para poder tener grupos de trabajo o no
     */
    public final java.lang.String rolParaGrupoTrabajo(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.adminusuarios.modificarUsuario.RolParaGrupoTrabajoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	ModificarUsuarioBSession modificarUsuarioBSession = this.getModificarUsuarioBSession(request);
	    UsuarioVO usuarioSesion = modificarUsuarioBSession.getUsuario();
	    String resultado = "FALLO";
	    
	    try
	    {
	    	
		    //recogemos los grupos que se han asigando al usuario y vemos que roles contienen
		    GrupoVO[] grupos = usuarioSesion.getGrupos();
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
		    
		    if(roles.indexOf(rol_catalogador) >= 0 || roles.indexOf(rol_empaquetador) >= 0 || roles.indexOf(rol_publicador) >= 0)
		    	resultado = "OK";
	    }
	    catch(Exception e)
	    {
	    	log.error("Error al obtener los roles del usuario ", e);
	    	throw new ValidatorException("{modificarUsuario.error}");
	    }
	    
	    finally 
	    {
		    form.setResultado(resultado);
		}
	    
    	return resultado;
    }
    
    
    
    /**
     * Se recuperan los grupos de trabajos que existen y se muestran para que se seleccionen.
     */
    public void recuperarGruposTrabajo(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.adminusuarios.modificarUsuario.RecuperarGruposTrabajoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	try 
    	{	
    		
    		/* Asignamos los grupos que estan seleccionados en el usuario a traves de un metodo java que rellenara la linea a pintar en
		    la jsp con el check marcado o no lo pinta, dependiendo de si el grupo pertenece al usuario.
		    Esto es porque si mandamos el array de grupos para pintarlos no podemos recorrerlo ya que se pintarian todos con check marcado */

    		//recogemos los datos del usuario
    		Long id = new Long(request.getParameter("id"));
    		UsuarioVO usuarioVO = this.getSrvAdminUsuariosService().descripcionUsuario(id);
    		
    		GrupoTrabajoVO[] grupoTrabajoVO = this.getSrvAdminUsuariosService().listarGruposTrabajo();
		    
		    GrupoTrabajoVOCheck[] grupoTabrajoVOCheck = null;
		    grupoTabrajoVOCheck = obtenerGrupoTrabajoCheck(grupoTrabajoVO, usuarioVO);
		    form.setGruposTrabajoAsArray(grupoTabrajoVOCheck);
    		
		    
		    //log("Se añade el login para comprobar si se permite modificar los roles desde la jsp");
		    //form.setUsuario(usuarioVO.getUsuario());
		} 
    	catch (Exception e) 
    	{
		    log.error("Error al obtener los grupos de trabajo " + e);
		    throw new ValidatorException("{modificarUsuario.error}");
		}
    }
    
    
    /**
     * metodo que recoge los grupos de trabajo y los mete en el usuario
     */
    public final void asignarGruposTrabajo(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.adminusuarios.modificarUsuario.AsignarGruposTrabajoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	ModificarUsuarioBSession modificarUsuarioBSession = this.getModificarUsuarioBSession(request);
	    UsuarioVO usuarioSesion = modificarUsuarioBSession.getUsuario();
	    SrvAdminUsuariosService srvAdminUsuariosService = this.getSrvAdminUsuariosService();
	    
	    try
	    {
	    	String[] ids = form.getIdentificadorRowSelectionAsArray();
	    	if(log.isDebugEnabled())log.debug("Los identificadores seleccionados son los siguientes "+ids);
		    //log("ids.length "+ids.length);
	
		    if (ids == null) 
		    {
		    	if(log.isDebugEnabled())log.debug("No se ha seleccionado ningun grupo");
				throw new ValidatorException("{errors.modificacionusuario.gruposTrabajoVacio}");
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
		    //metemos en la sesion el usuario
		    this.getModificarUsuarioBSession(request).setUsuario(usuarioSesion);
		    
	    
	    } 
	    catch (ValidatorException ve) 
		{
			log.error("Se produce la siguiente excepcion " + ve);
			throw ve;
		}
	    catch (Exception e) 
	    {
	    log.error("Error al dar de alta un usuario ", e);
	    throw new ValidatorException("{modificarUsuario.error}");
	    }
	    
    }
    
    
    /**
     *  se almacena el usuario y se devuelve resultado para ver que todo ha ido bien o no
     */
    public final String modificarUsuario(ActionMapping mapping,
	    es.pode.administracion.presentacion.adminusuarios.modificarUsuario.ModificarUsuarioForm form,
	    HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	
    	String resultado = "OK";
		
		try {
			ModificarUsuarioBSession modificarUsuarioBSession = this.getModificarUsuarioBSession(request);
		    UsuarioVO usuarioSesion = modificarUsuarioBSession.getUsuario();
		    SrvAdminUsuariosService srvAdminUsuariosService = this.getSrvAdminUsuariosService();
		  
		    
		    resultado = srvAdminUsuariosService.modificarUsuario(usuarioSesion);
		    Long idModificado = usuarioSesion.getId();
		    form.setIdModificado(idModificado);
		    if(log.isDebugEnabled())log.debug("Elimino de la sesion el usuario");
		    this.removeModificarUsuarioBSession(request);
		    
	
		} catch (Exception e) {
		    log.error("Error al dar de alta un usuario ", e);
		    resultado = "FALLO";
	
		} finally {
	
		    form.setResultado(resultado);
	
		}
		return resultado;
     
    }
   

    private ResourceBundle getFicherRecursos(Locale locale) {
		ResourceBundle ficheroRecursos = null;
		ficheroRecursos = ResourceBundle.getBundle("application-resources", locale);
		return ficheroRecursos;
	}
	
	private GrupoVOCheck[] obtenerGrupoCheck(GrupoVO[] grupoVO, UsuarioVO usuarioVO) {
		
		GrupoVOCheck[] resultado = null;
		resultado = new GrupoVOCheck[grupoVO.length];
		GrupoVO[] gruposUsuario = usuarioVO.getGrupos();
		Vector vRol = new Vector();
	
		for (int j = 0; j < gruposUsuario.length; j++) {
		    vRol.add(gruposUsuario[j].getId());
		}
	
		for (int i = 0; i < grupoVO.length; i++) {
		    GrupoVOCheck grupo = new GrupoVOCheck();
		    grupo.setId(grupoVO[i].getId());
		    grupo.setDescripcion(grupoVO[i].getDescripcion());
		    grupo.setLoginUsuario(usuarioVO.getUsuario());
		    if (vRol.contains(grupoVO[i].getId())) {
			grupo.setChecked(Boolean.TRUE);
		    } else {
			grupo.setChecked(Boolean.FALSE);
		    }
		    resultado[i] = grupo;
		}
	
		return resultado;
    }

	private GrupoTrabajoVOCheck[] obtenerGrupoTrabajoCheck(GrupoTrabajoVO[] grupoTrabajoVO, UsuarioVO usuarioVO) {
		
		GrupoTrabajoVOCheck[] resultado = null;
		resultado = new GrupoTrabajoVOCheck[grupoTrabajoVO.length];
		GrupoTrabajoVO[] gruposUsuario = usuarioVO.getGrupoTrabajo();
		Vector vRol = new Vector();
	
		for (int j = 0; j < gruposUsuario.length; j++) {
		    vRol.add(gruposUsuario[j].getIdentificador());
		}
	
		for (int i = 0; i < grupoTrabajoVO.length; i++) {
		    GrupoTrabajoVOCheck grupo = new GrupoTrabajoVOCheck();
		    grupo.setId(grupoTrabajoVO[i].getIdentificador());
		    grupo.setNombre(grupoTrabajoVO[i].getNombre());
		    grupo.setDescripcion(grupoTrabajoVO[i].getDescripcion());
		    grupo.setLoginUsuario(usuarioVO.getUsuario());
		    if (vRol.contains(grupoTrabajoVO[i].getIdentificador())) {
			grupo.setChecked(Boolean.TRUE);
		    } else {
			grupo.setChecked(Boolean.FALSE);
		    }
		    resultado[i] = grupo;
		}
	
		return resultado;
    }


    public class GrupoVOCheck {
		private Long id;
	
		private String descripcion;
	
		private Boolean checked;
		
		private String loginUsuario;
	
		public GrupoVOCheck() {
		}
	
		public Long getId() {
		    return id;
		}
	
		public void setId(Long id) {
		    this.id = id;
		}
	
		public String getDescripcion() {
		    return descripcion;
		}
	
		public void setDescripcion(String descripcion) {
		    this.descripcion = descripcion;
		}
	
		public void setChecked(Boolean checked) {
		    this.checked = checked;
		}
	
		public Boolean getChecked() {
		    return checked;
		}
		
		public String getLoginUsuario() {
		    return loginUsuario;
		}
	
		public void setLoginUsuario(String loginUsuario) {
		    this.loginUsuario = loginUsuario;
		}
    }
    
    public class GrupoTrabajoVOCheck {
		private Long id;
	
		private String nombre;
		
		private String descripcion;
	
		private Boolean checked;
		
		private String loginUsuario;
	
		public GrupoTrabajoVOCheck() {
		}
	
		public Long getId() {
		    return id;
		}
	
		public void setId(Long id) {
		    this.id = id;
		}
	
		public String getNombre() {
		    return nombre;
		}
	
		public void setNombre(String nombre) {
		    this.nombre = nombre;
		}
		
		public String getDescripcion() {
		    return descripcion;
		}
	
		public void setDescripcion(String descripcion) {
		    this.descripcion = descripcion;
		}
	
		public void setChecked(Boolean checked) {
		    this.checked = checked;
		}
	
		public Boolean getChecked() {
		    return checked;
		}
		
		public String getLoginUsuario() {
		    return loginUsuario;
		}
	
		public void setLoginUsuario(String loginUsuario) {
		    this.loginUsuario = loginUsuario;
		}
    }
    
    
    private Boolean validaEmail(String email){
    	
		Boolean resultado = Boolean.TRUE;
		
		//Pattern pattern = Pattern.compile("[^A-Za-z0-9\\.\\@_\\-~#]+");
		//Pattern pattern = Pattern.compile("^[A-Za-z0-9]([A-Za-z0-9.-_])*@[A-Za-z0-9]([A-Za-z0-9.-_])*.([A-Za-z0-9])+$");
		Pattern pattern = Pattern.compile("[A-Za-z0-9.-_]([A-Za-z0-9.-_])*@[A-Za-z0-9]([A-Za-z0-9.-_])*.([A-Za-z0-9])*");
		Matcher matcher = pattern.matcher(email);
		
		if (matcher.find()) {
			if(log.isDebugEnabled())log.debug("El email coincide con el patron es correcto el campo email");
		} else {
			resultado = Boolean.FALSE;
		}
		
		return resultado;
	}

}