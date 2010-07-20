/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.listarGrupos;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.administracion.presentacion.adminusuarios.altaGrupo.AltaGrupoBSession;
import es.pode.adminusuarios.negocio.servicios.GrupoVO;
import es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService;

/**
 * @see es.pode.administracion.presentacion.adminusuarios.listarGrupos.ListarGruposController
 */
public class ListarGruposControllerImpl extends ListarGruposController {

    private static Logger log = Logger.getLogger(ListarGruposControllerImpl.class);

    /**
         * @see es.pode.administracion.presentacion.adminusuarios.listarGrupos.ListarGruposController#recuperarGrupos(org.apache.struts.action.ActionMapping,
         *      es.pode.administracion.presentacion.adminusuarios.listarGrupos.RecuperarGruposForm,
         *      javax.servlet.http.HttpServletRequest,
         *      javax.servlet.http.HttpServletResponse)
         */
    public final void recuperarGrupos(ActionMapping mapping,
	    es.pode.administracion.presentacion.adminusuarios.listarGrupos.RecuperarGruposForm form,
	    HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    
		try {
			AltaGrupoBSession altaGrupoBSession = this.getAltaGrupoBSession(request);
			this.removeAltaGrupoBSession(request);
		    GrupoVO[] grupoVO = this.getSrvAdminUsuariosService().listarGrupos();
		    form.setGruposAsArray(grupoVO);
		} catch (Exception e) {
		    log.error("Error: " + e);
		    throw new ValidatorException("{listarGrupos.error}");
		}
    }

    /**
         * @see es.pode.administracion.presentacion.adminusuarios.listarUsuarios.ListarUsuariosController#obtenerIdentificadores(org.apache.struts.action.ActionMapping,
         *      es.pode.administracion.presentacion.adminusuarios.listarUsuarios.ObtenerIdentificadoresForm,
         *      javax.servlet.http.HttpServletRequest,
         *      javax.servlet.http.HttpServletResponse)
         */
    public final java.lang.String obtenerIdentificadores(ActionMapping mapping,
	    es.pode.administracion.presentacion.adminusuarios.listarGrupos.ObtenerIdentificadoresForm form,
	    HttpServletRequest request, HttpServletResponse response) throws Exception {

		List lista = ((FormularioListadoEliminarGrupoFormImpl) form).getIdRowSelection();
	
		String resultado = "vacio";
		try {
		    if (lista == null) {
	
			throw new ValidatorException("{errors.borrarGrupo.idNulo}");
		    } else {
			// Validamos los grupos seleccionados para comprobar si tienen
	                // usuarios asociados a ellos
			Long[] ids = new Long[lista.size()];
			Iterator iter = lista.iterator();
			SrvAdminUsuariosService srvAdminUsuariosService = this.getSrvAdminUsuariosService();
			int i = 0;
			while (iter.hasNext()) {
	
			    Long id = new Long((String) iter.next());
			    GrupoVO grupoVO = srvAdminUsuariosService.descripcionGrupo(id);
	
			    if ((srvAdminUsuariosService.obtenerUsuariosGrupo(id)).booleanValue()) {
				log.error("el grupo tiene un usuario " + grupoVO.getDescripcion());
				throw new ValidatorException("{errors.borrarGrupo.GrupoConUsuarios}");
	
			    } else {
				ids[i] = id;
				i++;
			    }
			}
	
			// Comprobamos si se eliminan todos los grupos con rol
	                // administrador
			Long[] gruposAdmin = srvAdminUsuariosService.obtenerGrupoAdministrador();
			List gruposAdminList = Arrays.asList(gruposAdmin);
	
			int num_Admin = gruposAdmin.length;
			int grupoDeleted = 0;
	
			for (int j = 0; j < ids.length; j++) {
			    if (gruposAdminList.contains(ids[j])) {
			    	if(log.isDebugEnabled())log.debug("uno de los grupos seleccionados es administrador");
				grupoDeleted = grupoDeleted + 1;
			    }
			}
			if (grupoDeleted == num_Admin) {
			    log.error("Se intenta eliminar todos los grupos administradores");
			    throw new ValidatorException("{errors.borrarGrupo.todosUsuariosAdmin}");
			}
			form.setIds(lista);
			resultado = "identificadores";
			// return null;
		    }
		} catch (ValidatorException validator) {
		    log.error("Se ha producido la siguiente exception " + validator);
		    throw validator;
		} catch (Exception e) {
		    log.error("Se produce una excepcion ", e);
		    throw new ValidatorException("{errors.borrarGrupo.idNulo}");
		}
		return resultado;
    }

    /**
         * @see es.pode.administracion.presentacion.adminusuarios.listarUsuarios.ListarUsuariosController#submit(org.apache.struts.action.ActionMapping,
         *      es.pode.administracion.presentacion.adminusuarios.listarUsuarios.SubmitForm,
         *      javax.servlet.http.HttpServletRequest,
         *      javax.servlet.http.HttpServletResponse)
         */
    public final void submit(ActionMapping mapping,
	    es.pode.administracion.presentacion.adminusuarios.listarGrupos.SubmitForm form, HttpServletRequest request,
	    HttpServletResponse response) throws Exception {

    	form.setIds(form.getIds());
    }

  

}