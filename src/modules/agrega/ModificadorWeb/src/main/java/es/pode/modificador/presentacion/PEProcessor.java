/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * 
 */
package es.pode.modificador.presentacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.tiles.TilesRequestProcessor;

import es.pode.modificador.presentacion.configurar.ConfigurarModificacionSession;
import es.pode.modificador.presentacion.informes.InformeSession;

/**
 * @author dgonzalezd
 *
 */
public class PEProcessor extends TilesRequestProcessor {

	private static Logger logger = Logger.getLogger(PEProcessor.class);
	
	/* (non-Javadoc)
	 * @see org.apache.struts.action.RequestProcessor#processPreprocess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected boolean processPreprocess(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		ConfigurarModificacionSession modSession= (ConfigurarModificacionSession)session.getAttribute(ConfigurarModificacionSession.SESSION_KEY);
		InformeSession infSession= (InformeSession)session.getAttribute(InformeSession.SESSION_KEY);
		if(logger.isDebugEnabled()) {
			logger.debug("Checkeando session caducada. Existe session ConfigurarModificacion? " + (modSession!=null));
			logger.debug("Checkeando session caducada. Existe session Informe? " + (infSession!=null));
		}
		boolean result = true;
		String path = request.getServletPath();
		
		if(!(path.startsWith("/Modifica") 
				|| request.getServletPath().startsWith("/Planifica")
				|| request.getServletPath().startsWith("/SesionCaducada") 
				|| request.getServletPath().startsWith("/ImportarModificacion"))
				&&!path.startsWith("/Informe")) {
			if(modSession==null) {
				result = redirect(request, response);
			}
		}
		if(path.startsWith("/Informe")) {
			if(infSession==null) {
				result = redirect(request, response);
			}
		}
		return result;
	}

	private boolean redirect(HttpServletRequest request,
			HttpServletResponse response) {
		boolean result;
		logger.debug("No se ha encontrado la session");
		try {
			String redirect = request.getContextPath() + "/SesionCaducada/SesionCaducada.do";
			if(logger.isDebugEnabled()) logger.debug("Redirigiendo a " + redirect);
			result = false;
			response.sendRedirect(redirect);
		} catch (Exception e) {
			logger.error("Error en el redirect de sesion caducada",e);
			result = false;
		}
		return result;
	}

}

