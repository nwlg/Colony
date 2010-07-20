/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.agrega.soporte.filter;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.pode.soporte.constantes.ConstantesAgrega;

public class HelpFilter implements Filter {
	protected static Log logger = LogFactory.getLog(HelpFilter.class);
	public static final String HELP_URL_KEY = "HELP_URL";
	protected FilterConfig fc = null;
	
	public void destroy() {
	    this.fc = null;

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException 
	{
		String sUrl = null;
		// Chequeo si la request es HttpServeltRequest y si lo es obtengo la URI
		if (request != null && request instanceof HttpServletRequest) 
		{
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			sUrl = httpRequest.getRequestURI();
			if (logger.isDebugEnabled())
				logger.debug("La URL de ayuda es = " + sUrl);
			if (request != null && request instanceof HttpServletRequest && ((HttpServletRequest)request).getSession()!=null && ((Locale)((HttpServletRequest)request).getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE))!=null && ((Locale)((HttpServletRequest)request).getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage()!=null){
				if(((Locale)((HttpServletRequest)request).getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage().equals("es"))
					sUrl = fc.getInitParameter("HELP_URL")+sUrl;
				else
					sUrl = fc.getInitParameter("HELP_URL").replaceFirst("/wiki", "/wiki-"+((Locale)((HttpServletRequest)request).getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage())+sUrl;
			}else
				sUrl = fc.getInitParameter("HELP_URL")+sUrl;
			if (logger.isDebugEnabled())
				logger.debug("La URL de ayuda final es = " + sUrl);
		}
		//Tengo que coger la URL de los parámetros del filtro y sumarle la URI
		// e introducirla en un atributo
		request.setAttribute(HelpFilter.HELP_URL_KEY, sUrl);
		/// pass the request/response on
	    chain.doFilter(request, response);

	}

	public void init(FilterConfig filterConfig) throws ServletException {
	    this.fc = filterConfig;

	}

}
