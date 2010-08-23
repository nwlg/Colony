/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.previsualizar;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.empaquetador.negocio.servicio.OdeVO;
import es.pode.empaquetador.presentacion.GestorSesion;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

/**
 * @see es.pode.empaquetador.presentacion.previsualizar.PrevisualizarController
 */
public class PrevisualizarControllerImpl extends PrevisualizarController {

	
	private static Logger logger = Logger.getLogger(PrevisualizarControllerImpl.class);
	/**
	 * @see es.pode.empaquetador.presentacion.previsualizar.PrevisualizarController#previsualizar(org.apache.struts.action.ActionMapping,
	 *      es.pode.empaquetador.presentacion.previsualizar.PrevisualizarForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void previsualizar(ActionMapping mapping,
			es.pode.empaquetador.presentacion.previsualizar.PrevisualizarForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		String tipoVisualizador = form.getTipoVisualizador();
		String action = form.getAction();
		if(logger.isDebugEnabled()) logger.debug("tipoVisualizador = " + tipoVisualizador + " ; action = " + action);
		
		OdeVO ode = this.getEmpaquetadorSession(request).getOde();
		String id = this.getSrvGestorManifestService().previsualizarOde(getEmpaquetadorSession(request).getIdLocalizador());
		//String id = this.getSrvEmpaquetadorBasicoService().previsualizarOde(ode);
		String url = request.getSession().getServletContext().getInitParameter(
				"url_visualizador");
		String llamada = null;
		if(tipoVisualizador==null) {// No ha pasado por la pantalla de selección de visualizador por no tener secuencia
			llamada = url + "?identificador=" + id + "&usuario=" + ode.getUsuario() + "&secuencia=false&comunidadAgrega=false"; // Llamo al previsualizador sin secuencia
		} else if(StringUtils.equalsIgnoreCase("adl", tipoVisualizador)) {//ADL
			url = request.getSession().getServletContext().getInitParameter("url_visualizador_adl");
			llamada = url + "?identificador=" + getEmpaquetadorSession(request).getIdLocalizador(); 
		} else {//Agrega
			llamada = url + "?identificador=" + id + "&usuario=" + ode.getUsuario() + "&secuencia=true&comunidadAgrega=false";
		}
		
		// URLs tipo host/agrega
		llamada = "http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+"/"+llamada;
		//20081106 dgonzalezd: Añado parámetro comunidadAgrega=false
		logger.info("Llamando a previsualizador con URL = " + llamada);
		response.sendRedirect(llamada);
	}
	
	@Override
	public String tieneSecuencia(ActionMapping mapping,
			TieneSecuenciaForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Boolean conSecuencia = getEmpaquetadorSession(request).getOde().getConSecuencia();
		String result = "no";
		if(conSecuencia) result = "si";
		if(logger.isDebugEnabled()) logger.debug("ODE " + getEmpaquetadorSession(request).getIdLocalizador() + (conSecuencia?" si ":" no ") + " tiene secuencia");
		return result;
	}

	@Override
	public String submit(ActionMapping mapping, SubmitForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		GestorSesion gs = new GestorSesion();
		boolean esAvanzado = gs.esAvanzado();
		String action = form.getAction();
		String result = "Aceptar";
		if(logger.isDebugEnabled()) logger.debug("submit con parametros action=" + action + " tipoVisualizador = " + form.getTipoVisualizador() + " esAvanzado = " + esAvanzado );
		java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		if(i18n.getString("comunes.cancelar").equalsIgnoreCase(action)) {
			// Ha pulsado Cancelar
			if(esAvanzado) result="CancelarAvanzado";
			else result="CancelarBasico";
		}
		if(logger.isDebugEnabled()) logger.debug("Retorno de submit = " + result);
		return result;
	}

}