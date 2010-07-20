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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

public class LanguageFilter implements Filter {
	protected static Log logger = LogFactory.getLog(LanguageFilter.class);
	protected FilterConfig fc = null;
	
	private static final String NOMBRECOOKIE = "idiomaNavegacionCookie";
	
	public void destroy() {
	    this.fc = null;

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException 
			{
				logger.debug("LanguageFilter - doFilter");
				if (request != null && request instanceof HttpServletRequest) 
				{
					String idiomaNavegacion = null;
					try
					{
						if(LdapUserDetailsUtils.estaAutenticado())
						{
				    		try
				    		{
								idiomaNavegacion=LdapUserDetailsUtils.getIdioma();
								logger.debug("LanguageFilter - idioma usuario="+idiomaNavegacion);
								if (idiomaNavegacion == null) idiomaNavegacion = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
							} catch (Exception e) {
								logger.debug("LanguageFilter - doFilter: Error al obtener idioma usuario LDAP, se recoge idioma de fichero propiedades I18n.");
								idiomaNavegacion = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
							}
							logger.debug("LanguageFilter - idioma ="+idiomaNavegacion);		
							((HttpServletRequest)request).getSession().setAttribute(ConstantesAgrega.DEFAULT_LOCALE, new Locale(idiomaNavegacion));
				    	}
						else
				    	{
							String cookieIdioma = this.getCookieValor((HttpServletRequest) request, NOMBRECOOKIE);
							//Se comprueba la cookie
							if(!cookieIdioma.equals(""))
							{
		//						Se encontro la cookie
								logger.debug("Se ha encontrado la cookie del idioma con valor ["+cookieIdioma+"]");
								//Se modifica el idioma de struts
								((HttpServletRequest)request).getSession().setAttribute(ConstantesAgrega.DEFAULT_LOCALE, new Locale(cookieIdioma));
							}					
							else{ 
						    	idiomaNavegacion = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
						    	logger.debug("LanguageFilter - idioma por defecto="+idiomaNavegacion);		
						    	((HttpServletRequest)request).getSession().setAttribute(ConstantesAgrega.DEFAULT_LOCALE, new Locale(idiomaNavegacion));
							}				    			    	
						}
					} catch (Exception ex)
					{
						logger.error("LanguageFilter - doFilter: Error al obtener idioma, se recoge idioma de explorador.",ex);
						((HttpServletRequest)request).getSession().setAttribute(ConstantesAgrega.DEFAULT_LOCALE, request.getLocale());
					}
				}
			    chain.doFilter(request, response);
			}
	
	public void init(FilterConfig filterConfig) throws ServletException {
	    this.fc = filterConfig;
	}
	
	/** 
	 * Se recupera el valor almacenado de una determinada cookie
	 * @param request Objeto request
	 * @param nombreCookie Nombre de la cookie a recuperar
	 */
	private String getCookieValor(HttpServletRequest request, String nombreCookie) {
		Cookie cookie = null;
		String valor = null;

		if (logger.isDebugEnabled()) logger.debug("Se coge la cookie " + NOMBRECOOKIE);
		cookie = getCookie(nombreCookie, request.getCookies());
		valor = cookie.getValue();
		if (logger.isDebugEnabled()) logger.debug("Valor cookie:" + valor);
		return valor;
	}
	
	/** 
	 * Recupera la información almacenada en una cookie
	 * @param nombre: nombre de la cookie
	 * @param cookies: cookies
	 */
	Cookie getCookie(String name, Cookie[] cookies) {
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookie.getName().equals(name))
					return cookie;
			}
		}

		return new Cookie(name, "");
	}

}
