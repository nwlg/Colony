/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.proponer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.publicacion.negocio.servicios.ResultadoOperacionVO;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.proponer.ProponerController
 */
public class ProponerControllerImpl extends ProponerController
{

	private final String SPLITTER = ";";
	private Logger logger = Logger.getLogger(ProponerControllerImpl.class);

    /**
     * @see es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.proponer.ProponerController#proponerODEPublicacion(org.apache.struts.action.ActionMapping, es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.proponer.ProponerODEPublicacionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void proponerODEPublicacion(ActionMapping mapping, es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.proponer.ProponerODEPublicacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    

    		ResultadoOperacionVO resultado;
    		if(logger.isDebugEnabled())
    		logger.debug("Proponiendo para publicacion ODE con titulo: " + form.getTitulo() + " idODE: " + form.getIdODE());
    		//El comentario no es obligatorio!!!!!!!!! Y el publicacion no da ningún error si no lleva comentarios
//    		if (form.getComentarios() == null && form.getComentarios().trim().length()==0) {
//    			logger.debug("Sin comentarios");
//    			form.setComentarios("");
//    		}
			// ponemos 2500 pero en el mensaje 2000 para que el usuario no se
			// sienta estafado con falta de caracteres
			if ((form.getComentarios().length() < 2500)) {
				try {
					
					resultado = this.getSrvPublicacionService().proponerPublicacion(form.getIdODE(),
							LdapUserDetailsUtils.getUsuario(), form.getComentarios(), form.getTitulo());
				} catch (Exception ex) {
					logger.error("ERROR (excepción) proponiendo el ODE con IdODE[" + form.getIdODE() + "] usuario["
							+ LdapUserDetailsUtils.getUsuario() + "]comentarios[" + form.getComentarios()
							+ "] y titulo[" + form.getTitulo() + "]" + "\nEXCEPCION: " ,ex);
					throw new ValidatorException("{gestorFlujo.excepcion.proponer.proponer}");
				}

				if (!resultado.getIdResultado().equals("0.0")) {
					logger.error("Error proponiendo para publicacion el ODE con IdODE[" + form.getIdODE()
							+ "] usuario[" + LdapUserDetailsUtils.getUsuario() + "]comentarios["
							+ form.getComentarios() + "] y titulo[" + form.getTitulo() + "]");

					// throw new ValidatorException(resultado.getDescripcion());
//    					saveErrorMessage(request, "gestorFlujo.error.proponer.validar", new String[] { form.getTitulo(),
//    							resultado.getDescripcion() });
					form.setMensajes(resultado.getDescripcion().substring(0,resultado.getDescripcion().length()-2).split(SPLITTER));

				} else {
					logger.info("Propuesto correctamente: ODE con IdODE[" + form.getIdODE() + "] usuario["
							+ LdapUserDetailsUtils.getUsuario() + "]comentarios[" + form.getComentarios()
							+ "] y titulo[" + form.getTitulo() + "]");
					// saveSuccessMessage(request,
					// "gestorFlujo.error.proponer.validar",new
					// String[]{form.getTitulo(),resultado.getDescripcion()});
				}
			} else {
				logger.warn("Longitud de comentario no válida al proponer el ODE con IdODE[" + form.getIdODE()
						+ "] usuario[" + LdapUserDetailsUtils.getUsuario() + "]comentarios[" + form.getComentarios()
						+ "] y titulo[" + form.getTitulo() + "]; longitud: " + form.getComentarios().length());
				throw new ValidatorException("{gestorFlujo.comentario.longitud}");
			}
    		

    	}

    



    /**
     * @see es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.proponer.ProponerController#cargaFormularioProponer(org.apache.struts.action.ActionMapping, es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.proponer.CargaFormularioProponerForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargaFormularioProponer(ActionMapping mapping, es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.proponer.CargaFormularioProponerForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    
     }









}