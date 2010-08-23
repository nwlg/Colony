/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.empaquetador.presentacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.tiles.TilesRequestProcessor;

import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

public class PEProcessor extends TilesRequestProcessor {

	private static Logger logger = Logger.getLogger(PEProcessor.class);
	
	/* (non-Javadoc)
	 * @see org.apache.struts.action.RequestProcessor#processPreprocess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected boolean processPreprocess(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		EmpaquetadorSession empSession = (EmpaquetadorSession)session.getAttribute(EmpaquetadorSession.SESSION_KEY);
		if(logger.isDebugEnabled()) 
			logger.debug("Checkeando session caducada. Existe empSession? " + (empSession!=null));
		boolean result = true;
		if(!(request.getServletPath().endsWith("/InicioEmpaquetador.do") 
				|| request.getServletPath().startsWith("/SesionCaducada"))) {
			if(empSession==null /*|| empSession.getOde()==null*/) {
				logger.debug("No se ha encontrado el ODE en la session");
				try {
					String redirect = request.getContextPath() + "/SesionCaducada/SesionCaducada.do";
					//URLs tipo host/agrega
					redirect="http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+(redirect.startsWith("/")?"":"/")+redirect;
					if(logger.isDebugEnabled()) logger.debug("Redirigiendo a " + redirect);
					result = false;
					response.sendRedirect(redirect);
				} catch (Exception e) {
					logger.error("Error en el redirect de sesion caducada",e);
					result = false;
				}
			}
		}
		return result;
	}
}
