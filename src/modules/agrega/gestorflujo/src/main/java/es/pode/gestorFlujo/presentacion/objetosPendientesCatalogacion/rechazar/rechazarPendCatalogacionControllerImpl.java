/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.rechazar;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.publicacion.negocio.servicios.ResultadoOperacionVO;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.rechazar.rechazarPendCatalogacionController
 */
public class rechazarPendCatalogacionControllerImpl extends rechazarPendCatalogacionController
{



	private Logger logger = Logger.getLogger(rechazarPendCatalogacionController.class);


    /**
     * @see es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.rechazar.rechazarPendCatalogacionController#rechazarODE(org.apache.struts.action.ActionMapping, es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.rechazar.RechazarODEForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void rechazarODE(ActionMapping mapping, es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.rechazar.RechazarODEForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	ResultadoOperacionVO resultado;
		logger.info("Rechazando ODE :" + form.getIdODE() + " de titulo: " + form.getTitulo());
		if (form.getComentarios() != null) {
			// ponemos 2500 pero en el mensaje 2000 para que el usuario no se
			// sienta estafado con falta de caracteres
			if ((form.getComentarios().trim().length() > 0) && (form.getComentarios().length() < 2500)) {
				try {
					if(logger.isDebugEnabled())
					logger.debug("Comentarios correctos rechazando ODE :" + form.getIdODE() + " de titulo: "
							+ form.getTitulo() + " Comentarios: " + form.getComentarios() + ";");
					resultado = this.getSrvPublicacionService().rechazar(form.getIdODE(),
							LdapUserDetailsUtils.getUsuario(), form.getComentarios(), form.getTitulo());
				} catch (Exception ex) {
					logger.error("ERROR (excepción) rechazando el ODE con IdODE[" + form.getIdODE() + "] usuario["
							+ LdapUserDetailsUtils.getUsuario() + "]comentarios[" + form.getComentarios()
							+ "] y titulo[" + form.getTitulo() + "]" + "\nEXCEPCION: " + ex.getMessage());
					throw new ValidatorException("{gestorFlujo.excepcion.rechazar.rechazar}");
				}

				if (!resultado.getIdResultado().equals("0.0")) {
					logger.error("Error rechazando para publicacion el ODE con IdODE[" + form.getIdODE() + "] usuario["
							+ LdapUserDetailsUtils.getUsuario() + "]comentarios[" + form.getComentarios()
							+ "] y titulo[" + form.getTitulo() + "]");

					saveErrorMessage(request, "gestorFlujo.error.rechazar", new String[] { form.getTitulo(),
							resultado.getDescripcion() });

				} else {
					logger.info("Rechazado correctamente: ODE con IdODE[" + form.getIdODE() + "] usuario["
							+ LdapUserDetailsUtils.getUsuario() + "]comentarios[" + form.getComentarios()
							+ "] y titulo[" + form.getTitulo() + "]");
				}
			} else {
				logger.warn("Longitud de comentario no válida al rechazar el ODE con IdODE[" + form.getIdODE()
						+ "] usuario[" + LdapUserDetailsUtils.getUsuario() + "]comentarios[" + form.getComentarios()
						+ "] y titulo[" + form.getTitulo() + "]; longitud: " + form.getComentarios().length());
				throw new ValidatorException("{gestorFlujo.comentario.longitud}");
			}
		} else {
			logger.warn("No se han introducido comentarios al rechazar el ODE con IdODE[" + form.getIdODE()
					+ "] usuario[" + LdapUserDetailsUtils.getUsuario() + "]comentarios[" + form.getComentarios()
					+ "] y titulo[" + form.getTitulo() + "]");
			throw new ValidatorException("{gestorFlujo.comentario.obligatorio}");
		}
	}







    /**
     * @see es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.rechazar.rechazarPendCatalogacionController#cargaFormularioRechazar(org.apache.struts.action.ActionMapping, es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.rechazar.CargaFormularioRechazarForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargaFormularioRechazar(ActionMapping mapping, es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.rechazar.CargaFormularioRechazarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    }

}