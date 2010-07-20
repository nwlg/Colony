/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.organizacion;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.empaquetador.negocio.servicio.OdeVO;
import es.pode.empaquetador.negocio.servicio.OrganizacionVO;
import es.pode.soporte.constantes.ConstantesAgrega;



/**
 * @see es.pode.empaquetador.presentacion.basico.organizacion.RenombrarOrganizacionBasicoController
 */
public class RenombrarOrganizacionBasicoControllerImpl extends RenombrarOrganizacionBasicoController
{
	private Logger logger = Logger.getLogger(RenombrarOrganizacionBasicoControllerImpl.class);
    /**
     * @see es.pode.empaquetador.presentacion.basico.organizacion.RenombrarOrganizacionBasicoController#recuperarDatos(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.organizacion.RecuperarDatosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperarDatos(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.organizacion.RecuperarDatosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	// Recupero los datos de la organizacion principal
    	OdeVO ode = this.getEmpaquetadorSession(request).getOde();
    	OrganizacionVO orgPrincipal = buscarOrganizacionPrincipal(ode);
    	if(logger.isDebugEnabled()) logger.debug("Preparando renombrar organizacion basico con identifier = " + orgPrincipal.getIdentifier()  + " : title = " + orgPrincipal.getTitle());
        // this property receives a default value, just to have the application running on dummy data
        form.setTitle(orgPrincipal.getTitle());
     
     }


	private OrganizacionVO buscarOrganizacionPrincipal(OdeVO ode) {
		OrganizacionVO orgPrincipal = null;
		String idOrgPrincipal = ode.getOrganizacionPrincipal();
    	for(int i=0;i<ode.getOrganizaciones().length && orgPrincipal == null;i++) {
    		if(idOrgPrincipal.equals(ode.getOrganizaciones()[i].getIdentifier())) {
    			orgPrincipal = ode.getOrganizaciones()[i];
    		}
    	}
		return orgPrincipal;
	}

    /**
     * @see es.pode.empaquetador.presentacion.basico.organizacion.RenombrarOrganizacionBasicoController#submit(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.organizacion.SubmitForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void submit(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.organizacion.SubmitForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {

		String action = form.getAction();
		String title = form.getTitle();

		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",
				(Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
		if (i18n.getString("gestor_basico.renombrar.organizacion.aceptar")
				.equals(action)) {
			if (logger.isDebugEnabled())
				logger.debug("Aceptar pulsado en renombrar organizacion");
			if (title == null || "".equals(title.trim())) {
				throw new ValidatorException(
						"{presentacion.basico.organizacion.not.null}");
			}
			OrganizacionVO orgPrincipal = buscarOrganizacionPrincipal(this
					.getEmpaquetadorSession(request).getOde());
			orgPrincipal.setTitle(title);
			if (logger.isDebugEnabled())
				logger
						.debug("Llamando a modificar organizacion con parametros identificador = "
								+ this.getEmpaquetadorSession(request).getIdLocalizador()
								+ " : organizacion = "
								+ orgPrincipal);
			try {
				this.getSrvGestorManifestService().modificarOrganizacion(
						this.getEmpaquetadorSession(request).getIdLocalizador(), orgPrincipal);
			} catch (Exception e) {
				logger.error(e);
				throw new ValidatorException(
						"{gestor_basico.renombrar.organizacion.error}");
			}
		}

	}









}