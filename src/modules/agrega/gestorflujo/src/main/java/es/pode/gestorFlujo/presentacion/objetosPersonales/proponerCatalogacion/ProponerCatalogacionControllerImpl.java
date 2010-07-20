/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales.proponerCatalogacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.publicacion.negocio.servicios.ResultadoOperacionVO;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

/**
 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.proponerCatalogacion.ProponerCatalogacionController
 */
public class ProponerCatalogacionControllerImpl extends ProponerCatalogacionController {

	private Logger logger = Logger.getLogger(ProponerCatalogacionControllerImpl.class);
	private final String splitter = ";";

	/**
	 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.proponerCatalogacion.ProponerCatalogacionController#proponerODECatalogacion(org.apache.struts.action.ActionMapping,
	 *      es.pode.gestorFlujo.presentacion.objetosPersonales.proponerCatalogacion.ProponerODECatalogacionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void proponerODECatalogacion(ActionMapping mapping,
			es.pode.gestorFlujo.presentacion.objetosPersonales.proponerCatalogacion.ProponerODECatalogacionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		ResultadoOperacionVO resultado = null;
		if(logger.isDebugEnabled())
		logger
				.debug("Proponiendo para catalogación ODE con titulo: " + form.getTitulo() + " idODE: "
						+ form.getIdODE());
		
		if (form.getComentarios() != null) {
			// ponemos 2500 pero en el mensaje 2000 para que el usuario no se
			// sienta estafado con falta de caracteres
			
			if ((form.getComentarios().trim().length() > 0) && (form.getComentarios().length() < 2500)) {
				if(form.getSeleccion()==null || form.getSeleccion().equals("off")){//Primero validar  que se aceptan las condiciones legales
					logger.warn("No se ha seleccionado la aceptacion de las condiciones legales ["+form.getSeleccion()+"] con identificador ["
							+ form.getIdODE() + "] usuario[" + LdapUserDetailsUtils.getUsuario() + "]comentarios["
							+ form.getComentarios() + "] y titulo[" + form.getTitulo() + "]");
					throw new ValidatorException("{gestorFlujo.legal.obligatorio}");
				}
				try {
					resultado = this.getSrvPublicacionService().proponerCatalogacion(form.getIdODE(),
							LdapUserDetailsUtils.getUsuario(), form.getComentarios(), form.getTitulo());
				} catch (Exception ex) {
					logger.error("ERROR (excepción) proponiendo para catalogación el ODE con IdODE[" + form.getIdODE()
							+ "] usuario[" + LdapUserDetailsUtils.getUsuario() + "]comentarios["
							+ form.getComentarios() + "] y titulo[" + form.getTitulo() + "]" + "\nEXCEPCION: ", ex);
					throw new ValidatorException("{gestorFlujo.excepcion.proponer.proponer}");
				}

				if (!resultado.getIdResultado().equals("0.0")) {
					logger.error("Error proponiendo para catalogación el ODE con IdODE[" + form.getIdODE()
							+ "] usuario[" + LdapUserDetailsUtils.getUsuario() + "]comentarios["
							+ form.getComentarios() + "] y titulo[" + form.getTitulo() + "]. Error:["
							+ resultado.getDescripcion() + "]");

					// throw new ValidatorException(resultado.getDescripcion());
//					saveErrorMessage(request, "gestorFlujo.error.proponer.validar", new String[] { form.getTitulo(),
//							resultado.getDescripcion() });
					form.setMensajes(resultado.getDescripcion().substring(0,resultado.getDescripcion().length()-2).split(splitter));

				} else {
					logger.info("Propuesto para catalogación correctamente: ODE con IdODE[" + form.getIdODE()
							+ "] usuario[" + LdapUserDetailsUtils.getUsuario() + "]comentarios["
							+ form.getComentarios() + "] y titulo[" + form.getTitulo() + "]");
					// saveSuccessMessage(request,
					// "gestorFlujo.error.proponer.validar",new
					// String[]{form.getTitulo(),resultado.getDescripcion()});
				}
			} else {
				logger.warn("Longitud de comentario no válida proponiendo para catalogación el ODE con IdODE["
						+ form.getIdODE() + "] usuario[" + LdapUserDetailsUtils.getUsuario() + "]comentarios["
						+ form.getComentarios() + "] y titulo[" + form.getTitulo() + "]; longitud: "
						+ form.getComentarios().length());
				throw new ValidatorException("{gestorFlujo.comentario.longitud}");
			}
		} else {
			logger.warn("No se han introducido comentarios proponiendo para catalogación el ODE con IdODE["
					+ form.getIdODE() + "] usuario[" + LdapUserDetailsUtils.getUsuario() + "]comentarios["
					+ form.getComentarios() + "] y titulo[" + form.getTitulo() + "]");
			throw new ValidatorException("{gestorFlujo.comentario.obligatorio}");
		}
		
	}

	/**
	 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.proponerCatalogacion.ProponerCatalogacionController#cargaFormularioProponerCatalogacion(org.apache.struts.action.ActionMapping,
	 *      es.pode.gestorFlujo.presentacion.objetosPersonales.proponerCatalogacion.CargaFormularioProponerCatalogacionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void cargaFormularioProponerCatalogacion(
			ActionMapping mapping,
			es.pode.gestorFlujo.presentacion.objetosPersonales.proponerCatalogacion.CargaFormularioProponerCatalogacionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	}

	public String analizaCheck(ActionMapping mapping, AnalizaCheckForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return(form.getSeleccion());
	}

}