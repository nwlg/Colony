/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.VerGrupo;


import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import es.pode.adminusuarios.negocio.servicios.GrupoVO;
import es.pode.adminusuarios.negocio.servicios.RolVO;


/**
 * @see es.pode.administracion.presentacion.adminusuarios.VerGrupo.VerGrupoController
 */
public class VerGrupoControllerImpl extends VerGrupoController {

	private static Logger log = Logger.getLogger(VerGrupoControllerImpl.class);

	

	/**
	 * @see es.pode.administracion.presentacion.adminusuarios.VerGrupo.VerGrupoController#recuperarDescripcion(org.apache.struts.action.ActionMapping,
	 *      es.pode.administracion.presentacion.adminusuarios.VerGrupo.RecuperarDescripcionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void recuperarDescripcion(
			ActionMapping mapping,
			es.pode.administracion.presentacion.adminusuarios.VerGrupo.RecuperarDescripcionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		try {
			
			Long id = Long.valueOf(request.getParameter("id"));
			GrupoVO grupo = this.getSrvAdminUsuariosService().descripcionGrupo(
					id);
			form.setDescripcion(grupo.getDescripcion());
			form.setId(id);
			Set set = new HashSet();
			RolVO[] grupos = this.getSrvAdminUsuariosService()
					.descripcionGrupo(id).getRols();
			for (int i = 0; i < grupos.length; i++) {
				set.add(grupos[i]);
			}
			if(log.isDebugEnabled())log.debug("Tamanio de la lista de roles del grupo seleccionado "
					+ set.size());
			form.setRoles(set);
			
		} catch (Exception e) {
			log.error("Error: " + e);
			throw new ValidatorException("{verGrupo.error}");
		}
	}

}