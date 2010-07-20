/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.catalogar;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.empaquetador.presentacion.CatalogacionBean;
import es.pode.empaquetador.presentacion.EmpaquetadorSession;
import es.pode.empaquetador.presentacion.GestorSesion;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

/**
 * @see es.pode.empaquetador.presentacion.catalogar.CatalogarController
 */
public class CatalogarControllerImpl extends CatalogarController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	private GestorSesion gs = new GestorSesion();
	
	public final void catalogar(ActionMapping mapping,
			es.pode.empaquetador.presentacion.catalogar.CatalogarForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);

		List submanifestPath = sesEmpaq.getSubmanifestPath();
		
		String identificador = sesEmpaq.getIdLocalizador();

		String idElemento = "";
		String href = form.getHref();
		if (form.getHref() != null) {
			idElemento = form.getIdentifier().concat(form.getHref());
		} else {
			idElemento = form.getIdentifier();
		}
		String idioma = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		String usuario = gs.obtenerUsuario(request);
		if(logger.isDebugEnabled()) logger.debug("Usuario recuperado " + usuario);
		String url = request.getSession().getServletContext().getInitParameter(
				"url_catalogador");
		
		url = ( url + "?idioma=" + idioma + "&usuario=" + usuario
				+ "&identificador=" + idElemento);
	
		if(form.getReturnURL()!=null && !form.getReturnURL().equals(""))
		{
			url= url.concat("&returnURL="+form.getReturnURL());
		}
		if(logger.isDebugEnabled()) logger.debug("Llamando al servicio para preparar la catalogacion con identificador = " + identificador + " , idElemento = " + form.getIdentifier() + " , href = "  + href);
		this.getSrvGestorManifestService().prepararCatalogacion(identificador,
				form.getIdentifier(), href);

		/*
		 * Registramos en la lista de pendientes de Asignacion de Lom un bean
		 * con identifier y href del elemento catalogado
		 */
		if(logger.isDebugEnabled()) logger.debug("Registrando en la sesion un bean con los datos del objeto catalogado");
		CatalogacionBean bean = new CatalogacionBean();
		bean.setIdentifier(form.getIdentifier());
		bean.setHref(href);
		sesEmpaq.getPendientesCatalogacion().add(bean);

		/*
		 * Session Timeout: Para evitar que caduque la sesion del empaquetador
		 * mientras se trabaja con el catalogador variamos el time-out de la
		 * sesion. En el punto de retorno se restaura al valor normal.
		 */
		request.getSession().setAttribute("timeout.empaquetador", new Integer(request.getSession().getMaxInactiveInterval()));
		logger.debug("Timeout previo al cambio = " + request.getSession().getMaxInactiveInterval() + "s");
		String timeoutExtendido = AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.TIMEOUT_EXTENDIDO);
		logger.debug("Modificando el timeout del empaquetador a " + timeoutExtendido);
		request.getSession().setMaxInactiveInterval(Integer.parseInt(timeoutExtendido));
		// Concatenamos host y subdominio para URLs tipo http://host/agrega
		url = "http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+"/"+url;
		if(logger.isDebugEnabled()) logger.debug("Redirigiendo a " + url);
		response.sendRedirect(url);
	}

}