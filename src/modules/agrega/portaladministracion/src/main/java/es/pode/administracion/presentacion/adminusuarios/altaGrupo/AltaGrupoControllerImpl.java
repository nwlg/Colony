/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.altaGrupo;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import es.pode.adminusuarios.negocio.servicios.GrupoVO;
import es.pode.adminusuarios.negocio.servicios.RolVO;
import es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @see es.pode.administracion.presentacion.adminusuarios.altaGrupo.AltaGrupoController
 */
public class AltaGrupoControllerImpl extends AltaGrupoController {

    private static Logger log = Logger.getLogger(AltaGrupoControllerImpl.class);

    /**
         * @see es.pode.adminusuarios.presentacion.altaGrupo.AltaGrupoController#altaGrupo(org.apache.struts.action.ActionMapping,
         *      es.pode.adminusuarios.presentacion.altaGrupo.AltaGrupoForm,
         *      javax.servlet.http.HttpServletRequest,
         *      javax.servlet.http.HttpServletResponse)
         * 
         */
    public final void altaGrupo(ActionMapping mapping, AltaGrupoForm form, HttpServletRequest request,
	    HttpServletResponse response) throws Exception {
	try {
	    GrupoVO grupoVO = new GrupoVO();
	    AltaGrupoBSession altaGrupoBSession = this.getAltaGrupoBSession(request);
	    grupoVO.setDescripcion(altaGrupoBSession.getDescripcion());
	    String[] ids = form.getIdRowSelectionAsArray();
	    if ((ids == null) || (ids.length == 0)) {

	    	if(log.isDebugEnabled())log.debug("No se ha seleccionado ningun permiso");
		throw new ValidatorException("{errors.altagrupo.roles}");
	    }

	    SrvAdminUsuariosService srvAdminUsuariosService = this.getSrvAdminUsuariosService();
	    RolVO[] rolVO = new RolVO[ids.length];

	    Long idL = null;
	    for (int i = 0; i < ids.length; i++) {
		idL = new Long(ids[i]);
		RolVO rolG = srvAdminUsuariosService.getRol(idL);

		// rolG.setId(idL);
		rolVO[i] = rolG;

	    }
	    grupoVO.setRols(rolVO);
	    if(log.isDebugEnabled())log.debug("Elimino de la sesion la descripcion del grupo");
	    this.removeAltaGrupoBSession(request);
	    Long idCreado = srvAdminUsuariosService.altaGrupo(grupoVO);
	    form.setIdModificado(idCreado);
	    // /Elimino de la sesion la descripcion del grupo
	} catch (ValidatorException e) {
	    throw e;
	} catch (Exception e) {
	    log.error("Error: " + e);
	    throw new ValidatorException("{errors.altagrupo}");
	}

    }

    /**
         * @see es.pode.adminusuarios.presentacion.altaGrupo.AltaGrupoController#recuperarRoles(org.apache.struts.action.ActionMapping,
         *      es.pode.adminusuarios.presentacion.altaGrupo.RecuperarRolesForm,
         *      javax.servlet.http.HttpServletRequest,
         *      javax.servlet.http.HttpServletResponse) Obtiene los roles que
         *      estan dados de alta en el sistema
         */
    public final void recuperarRoles(ActionMapping mapping, RecuperarRolesForm form, HttpServletRequest request,
	    HttpServletResponse response) throws Exception {
    	
   
	String descripcion = form.getDescripcion();
	Pattern mask = Pattern.compile("[^\\¿\\?\\¡\\!\\>\\#\\&\\<\\@\\$\\/\\\'\\\"]+");
    Matcher matcher = null;
	
	if ((descripcion == null) || (descripcion.length() == 0)) {
		if(log.isDebugEnabled())log.debug("La descripcion introducida es nula");
	    throw new ValidatorException("{errors.altagrupo.descripcion}");
		
	}else {
		
		matcher = mask.matcher(descripcion);
	    if (!matcher.matches()) {
	    	if(log.isDebugEnabled())log.debug("nombre caracter ilegal");
	    	throw new ValidatorException("{errors.altagrupo.descripcion.caracterIlegal}");
	    }
		
	    if ((this.getSrvAdminUsuariosService().existeDescripcion(descripcion, Long.valueOf("-1"))).booleanValue()) {
		if(log.isDebugEnabled())log.debug("ya existe la descripcion");
		throw new ValidatorException("{errors.altagrupo.descripcionExistente}");
	    } else {
		this.getAltaGrupoBSession(request).setDescripcion(descripcion);
		if(log.isDebugEnabled())log.debug("Guardamos en sesion la descripcion del grupo");
	    }
	}
	RolVO[] rolVO = this.getSrvAdminUsuariosService().listarRoles();
	form.setRolesAsArray(rolVO);
    }

   

}