/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService;
import es.pode.publicacion.negocio.servicios.SrvPublicacionService;
import es.pode.publicacion.negocio.servicios.TransicionVO;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.ObjetosPendientesCatalogacionController
 */
public class ObjetosPendientesCatalogacionControllerImpl extends ObjetosPendientesCatalogacionController
{


	private Logger logger = Logger.getLogger(ObjetosPendientesCatalogacionController.class);

	public void cargarODESPendientesCatalogacion(ActionMapping mapping, CargarODESPendientesCatalogacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(logger.isDebugEnabled())
	    	logger.debug("Cargando objetos Pendientes catalogacion");
			SrvPublicacionService publi = this.getSrvPublicacionService();
			SrvAdminUsuariosService admin=this.getSrvAdminUsuariosService();
			try {
				TransicionVO[] odes =null;
				String[] todosUsuariosGrupos=admin.obtenerListaUsuariosGrupoTrabajo(LdapUserDetailsUtils.getUsuario());
//				
//				String[] todosUsuariosGrupos=new String[] {LdapUserDetailsUtils.getUsuario()};
				if(todosUsuariosGrupos!=null && todosUsuariosGrupos.length>0){
					logger.info("Obtenidos lista de usuarios de los grupos pertenecientes de usuario:["+LdapUserDetailsUtils.getUsuario()+"Numero de usuarios:["+todosUsuariosGrupos.length);
					 odes = publi.obtenODEsPropuestosCatalogacionPorUsuarios(todosUsuariosGrupos);
					logger.info("Obtenidos odes de esos usuarios, numero de odes pendientes de catalogacion["+odes.length);
				}else{
					logger.info("Obtenidos lista de todos los ODES, pues el usuario:["+LdapUserDetailsUtils.getUsuario()+" es parte de todos los grupos");
					odes=publi.obtenODESPropuestosCatalogacion();
					logger.info("Obtenidos odes de todos los usuarios, numero de odes pendientes de catalogacion["+odes.length);
				}
				form.setListaODESAsArray(odes);
			} catch (Exception ex) {
				logger.error("Imposible obtener los odes pendientes catalogacion", ex);
				throw new ValidatorException("{gestorFlujo.error.inesperado}");
			}
			form.setIdUsuario(LdapUserDetailsUtils.getUsuario());

			logger.info("Objetos Pendientes Catalogacion cargados correctamente");
	     
		
	}




    /**
     * @see es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.ObjetosPendientesCatalogacionController#cargarODESPendientesCatalogacion(org.apache.struts.action.ActionMapping, es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.CargarODESPendientesCatalogacionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */




   
}