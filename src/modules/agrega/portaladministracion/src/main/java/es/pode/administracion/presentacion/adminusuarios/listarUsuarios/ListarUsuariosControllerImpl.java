/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.listarUsuarios;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.adminusuarios.negocio.servicios.UsuarioVO;

/**
 * @see es.pode.administracion.presentacion.adminusuarios.listarUsuarios.ListarUsuariosController
 */
public class ListarUsuariosControllerImpl extends ListarUsuariosController {

    private static Logger log = Logger.getLogger(ListarUsuariosControllerImpl.class);

    /**
         * @see es.pode.administracion.presentacion.adminusuarios.listarUsuarios.ListarUsuariosController#obtenerUsuarios(org.apache.struts.action.ActionMapping,
         *      es.pode.administracion.presentacion.adminusuarios.listarUsuarios.ObtenerUsuariosForm,
         *      javax.servlet.http.HttpServletRequest,
         *      javax.servlet.http.HttpServletResponse)
         */
    public final void obtenerUsuarios(ActionMapping mapping,
	    es.pode.administracion.presentacion.adminusuarios.listarUsuarios.ObtenerUsuariosForm form,
	    HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	//AltaUsuarioBSession altaUsuarioBSession = this.getAltaUsuarioBSession(request);
		// el idioma será el que tenga en el atributo idioma del usuario
		// que esta en sesion.
		try {
			this.removeAltaUsuarioBSession(request);
			this.removeModificarUsuarioBSession(request);
			
		    UsuarioVO[] usuarioVO = this.getSrvAdminUsuariosService().listarUsuarios();
		    if(log.isDebugEnabled())log.debug("Obtenemos los usuarios");
		    form.setUsuariosAsArray(usuarioVO);
		} catch (Exception e) {
		    log.error("Error: " + e);
		    throw new ValidatorException("{errors.listarUsuario}");
		}
    }

    /**
         * @see es.pode.administracion.presentacion.adminusuarios.listarUsuarios.ListarUsuariosController#obtenerIdentificadores(org.apache.struts.action.ActionMapping,
         *      es.pode.administracion.presentacion.adminusuarios.listarUsuarios.ObtenerIdentificadoresForm,
         *      javax.servlet.http.HttpServletRequest,
         *      javax.servlet.http.HttpServletResponse)
         */

    public final void getIds(ActionMapping mapping,
	    es.pode.administracion.presentacion.adminusuarios.listarUsuarios.GetIdsForm form,
	    HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
		try {
		    List lista = ((FormularioListadoUsuariosBajaFormImpl) form).getIdRowSelection();
		    if (lista == null) {
	
			throw new ValidatorException("{errors.borrarUsuario.idNulo}");
		    } else {
	
			Long[] usuariosAdmin = this.getSrvAdminUsuariosService().obtenerUsuariosAdministrador();
	
			List gruposAdminList = Arrays.asList(usuariosAdmin);
	
			int num_Admin = usuariosAdmin.length;
			int usuarioDeleted = 0;
			Iterator iter = lista.iterator();
			while (iter.hasNext()) {
			    Long identificador = new Long((String) iter.next());
			    if (gruposAdminList.contains(identificador)) {
				usuarioDeleted = usuarioDeleted + 1;
			    }
			}
	
			if (usuarioDeleted == num_Admin) {
				if(log.isDebugEnabled())log.debug("Se intenta eliminar todos los usuarios que son administrador no se permite");
			    throw new ValidatorException("{errors.borrarUsuario.todosUsuariosAdmin}");
			}
			form.setIds(lista);
		    }
		} catch (ValidatorException validator) {
		    log.error("Se ha producido la siguiente exception " + validator);
		    throw validator;
		} catch (Exception e) {
		    log.error("Se produce una excepcion ", e);
		    throw new ValidatorException("{errors.borrarUsuario}");
		}

    }

    /**
         * @see es.pode.administracion.presentacion.adminusuarios.listarUsuarios.ListarUsuariosController#obtenerIdentificadores(org.apache.struts.action.ActionMapping,
         *      es.pode.administracion.presentacion.adminusuarios.listarUsuarios.ObtenerIdentificadoresForm,
         *      javax.servlet.http.HttpServletRequest,
         *      javax.servlet.http.HttpServletResponse)
         */

 

}