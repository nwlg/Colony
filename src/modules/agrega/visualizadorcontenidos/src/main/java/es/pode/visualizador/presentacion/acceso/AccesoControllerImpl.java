/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.visualizador.presentacion.acceso;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;


/**
 * @see es.pode.visualizador.presentacion.acceso.AccesoController
 */
public class AccesoControllerImpl extends AccesoController {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(AccesoControllerImpl.class);
	private java.util.Properties pSpringProperties = null;

	/**
	 * @see es.pode.visualizador.presentacion.acceso.AccesoController#validarAcceso(org.apache.struts.action.ActionMapping, es.pode.visualizador.presentacion.acceso.ValidarAccesoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public final void validarAcceso(ActionMapping mapping,
			es.pode.visualizador.presentacion.acceso.ValidarAccesoForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String base = this.getPropertyValue("http.server");
		String context = request.getContextPath();
		
		// TODO - the next line should be fetch from Spring config!
		String loginUrl = "/j_acegi_shibboleth_security_check";
		
		String redirDest = base + context + loginUrl;
		log.info("Specific login requested, sending user to: " + redirDest);

		response.sendRedirect(redirDest);
	}
	
	private String getPropertyValue(String sKey) throws IOException {
	    	
		if (this.pSpringProperties == null) {
			InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/authbackend.properties");
		    pSpringProperties = new java.util.Properties();
		    pSpringProperties.load(fIsSpringProperties);
		}
		
		return pSpringProperties.getProperty(sKey);
	}
}
