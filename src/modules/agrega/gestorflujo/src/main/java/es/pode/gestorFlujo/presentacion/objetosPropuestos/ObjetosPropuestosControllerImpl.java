/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPropuestos;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.publicacion.negocio.servicios.SrvPublicacionService;
import es.pode.publicacion.negocio.servicios.TransicionVO;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

/**
 *  * @see es.pode.gestorFlujo.presentacion.objetosPropuestos.ObjetosPropuestosController
 */
public class ObjetosPropuestosControllerImpl extends ObjetosPropuestosController {

	private Logger logger = Logger.getLogger(ObjetosPropuestosController.class);

	/**
	 * @see es.pode.gestorFlujo.presentacion.objetosPropuestos.ObjetosPropuestosController#cargarODESPropuestos(org.apache.struts.action.ActionMapping, es.pode.gestorFlujo.presentacion.objetosPropuestos.CargarODESPropuestosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public final void cargarODESPropuestos(ActionMapping mapping,
			es.pode.gestorFlujo.presentacion.objetosPropuestos.CargarODESPropuestosForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		SrvPublicacionService publi = this.getSrvPublicacionService();
		if(logger.isDebugEnabled())
		logger.debug("Cargando odes propuestos catalogación y publicación para: " + LdapUserDetailsUtils.getUsuario());
		
		try {
			
			int recorrido = publi.obtenODEsPropuestosPorUsuario(LdapUserDetailsUtils.getUsuario()).length;
			if (recorrido > 0) {
				form.setListaODESAsArray(publi.obtenODEsPropuestosPorUsuario(LdapUserDetailsUtils.getUsuario()));
				recorrido = publi.obtenODESPropuestosCatalogacionPorUsuario(LdapUserDetailsUtils.getUsuario()).length;
				if (recorrido > 0) {
					ArrayList collect = new ArrayList(form.getListaODES());
					for (int i = 0; i < recorrido; i++) {
						TransicionVO trVO = publi.obtenODESPropuestosCatalogacionPorUsuario(LdapUserDetailsUtils
								.getUsuario())[i];
						collect.add(trVO);
					}
					form.setListaODES(collect);
				}
			} else
				form.setListaODESAsArray(publi.obtenODESPropuestosCatalogacionPorUsuario(LdapUserDetailsUtils
						.getUsuario()));
		
			
		} catch (Exception ex) {
			logger.error("Error inesperado cargando objetos propuestos. ", ex);
			throw new ValidatorException("{gestorFlujo.error.inesperado}");
		}
	}
}