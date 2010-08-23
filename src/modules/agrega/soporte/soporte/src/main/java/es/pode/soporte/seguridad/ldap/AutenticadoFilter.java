/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.seguridad.ldap;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.acegisecurity.AccessDeniedException;
import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationException;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/** 
 * Clase filtro para marcar al usuario que ha sido auntenticado en algún módulo 
 * y para actualizar el perfil del usuario en la sesión activa.
 * 
 * @author jsimon
 */

public class AutenticadoFilter implements Filter {
	private static Log log = LogFactory.getLog(AutenticadoFilter.class);

	private static final String nombreCookieAuntenticado = "AUTENTICADO";
	
	private static final String nombreCookieOpenId = "OPENID";

	private static final String valorCookieAuntenticado = "SI";

	private static final String nombreCookieModificarPerfil = "MODIFICAR_PERFIL";

	private static final String sesionModificarPerfil = "perfilModificado";

	
	public AutenticadoFilter() {
	}

	public void init(FilterConfig filterconfig) throws ServletException {
	}

	public void destroy() {
	}

	/** 
	 * Filtrado para marcar los usuarios que han sido auntenticado en algún módulo. Primero se comprobará si existe la cookie de OpenId
	 * en ese caso no se creará la cookie AUTENTICADO ni se comprobará si tiene roles
	 * Casos:
	 * 	1- No tiene Roles y no tiene cookie: Usuario anónimo -> No se hace nada 
	 * 	2- Tiene Roles y tiene cookie: Usuario autenticado y con los roles..
	 * 		1. No se ha modificado el perfil -> No se hace nada 
	 *      2. Si se ha modificado el perfil -> Se actualiza el contexto de seguridad
	 *      	Existe la cookie MODIFICAR_PERFIL 
	 *      	Y el valor de la cookie tiene que ser igual a la variable perfilModificado de la sesión  
	 *  	 
	 * 	3- No tiene Roles y tiene cookie: Usuario autenticado en otro módulo y no tiene los roles -> Se lanza la excepción para que vaya al CAS y luego carge los roles. 
	 *  4- Tiene Roles y no tiene cookie: Usuario que acaba de ser autenticado en el CAS -> Se le pone la cookie.    
	 * @param request Objeto request
	 * @param response Objeto response
	 * @param chain Objeto filtro al que se devuelve el control
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, AuthenticationException {
		boolean auntenticadoRoles = LdapUserDetailsUtils.estaAutenticado();
		String cookieAuntenticado = this.getCookieValor((HttpServletRequest) request, nombreCookieAuntenticado);
		final HttpSession sesion = ((HttpServletRequest) request).getSession();

		//Comprobamos si existe la cookie OpenId
		String cookieOpenId = this.getCookieValor((HttpServletRequest) request, nombreCookieOpenId);
		log("cookieOpenId ["+cookieOpenId+"]");
		if((cookieOpenId == null)||(cookieOpenId == "")||(cookieOpenId== " "))
		{
		//No nos hemos logado como OpenId se comprobará la cookie AUTENTICADO y los roles
		if (!auntenticadoRoles && valorCookieAuntenticado.equals(cookieAuntenticado)) /* 3- No tiene Roles y tiene cookie */
		{
			log("No tiene roles y si tiene la cookie de autenticado. Se lanza la excepción");
			throw new AccessDeniedException("Auntenticado en otro módulo y sin roles");
		} else if (auntenticadoRoles && !valorCookieAuntenticado.equals(cookieAuntenticado)) /* 4- Tiene Roles y no tiene cookie */
		{
			log("Tiene roles y no tiene la cookie de autenticado. Se pone la cookie");
			this.setCookieAutenticado((HttpServletResponse) response);
		} else if (!auntenticadoRoles && !valorCookieAuntenticado.equals(cookieAuntenticado)) /* 1- No tiene Roles y no tiene cookie */
		{
			log("No tiene Roles y no tiene cookie ");
		} else if (auntenticadoRoles && valorCookieAuntenticado.equals(cookieAuntenticado)) /* 2- Tiene Roles y tiene cookie */
		{
			log("Tiene Roles y tiene cookie");

			/* Se comprueba si se ha modificado el perfil para actualizar el contexto de seguridad 
			 * Para actualizar el perfil: 
			 * 1- Tiene que existir la cookie 
			 * 2- Y el valor de la cookie tiene que ser igual a la variable perfilModificado de la sesión 
			 * */
			String cookieModificarPerfil = this.getCookieValor((HttpServletRequest) request, nombreCookieModificarPerfil);
			String modficarPerfil = (String) sesion.getAttribute(sesionModificarPerfil);
			if (cookieModificarPerfil != null && cookieModificarPerfil != "" && (!(cookieModificarPerfil.equals(modficarPerfil)))) // Existe la cookie de modificar perfil
			{
				log("El perfil se ha modificado en esta sesión. cookieModificarPerfil: " + cookieModificarPerfil);
				log("ModificarPerfile vale " + modficarPerfil);
				/* Modificación del contexto de Acegi con el nuevo perfil */
				modificacionContextoAcegi();
				log("Se añade un valor a la sesion para no actualizarlo más veces");
				sesion.setAttribute(sesionModificarPerfil, cookieModificarPerfil);
			}
		}
		}else
		{
			log("Tenemos la cookie de openid no hacemos nada");
		}
		chain.doFilter(request, response);
	}

	private void setCookieAutenticado(HttpServletResponse response) {
		log("Se pone la cookie " + nombreCookieAuntenticado);
		Cookie cookie = new Cookie(nombreCookieAuntenticado, valorCookieAuntenticado);
		cookie.setPath("/");
		cookie.setMaxAge(-1);
		response.addCookie(cookie);

		log("Despues de añadir la cookie " + nombreCookieAuntenticado + ": " + cookie + " con valor: " + valorCookieAuntenticado + " al objeto response");
	}

	private void eliminarCookieModificarPerfil(HttpServletResponse response) {
		log("Se elimina la cookie " + nombreCookieModificarPerfil);
		Cookie cookie = new Cookie(nombreCookieModificarPerfil, null);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);

		log("Despues de eliminar la cookie " + nombreCookieModificarPerfil);
	}

	/** 
	 * Se recupera el valor almacenado de una determinada cookie
	 * @param request Objeto request
	 * @param nombreCookie Nombre de la cookie a recuperar
	 */
	private String getCookieValor(HttpServletRequest request, String nombreCookie) {
		Cookie cookie = null;
		String valor = null;

		log("Se coge la cookie " + nombreCookieAuntenticado);
		cookie = getCookie(nombreCookie, request.getCookies());
		valor = cookie.getValue();
		log("Valor cookie:" + valor);
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

	/**
	 * Modificación el contexto de seguridad de Acegi con los datos nuevos del usuario 
	 * 
	 */

	void modificacionContextoAcegi() {

		log("Vamos a modificar el contexto de acegi");
		String usuario = LdapUserDetailsUtils.getUsuario();
		log("el valor del usuario es " + usuario);
		GrantedAuthority[] ldapGranted = LdapUserDetailsUtils.getRoles();
		Object creden = SecurityContextHolder.getContext().getAuthentication().getCredentials();
		LdapUserDetailsAgrega.Essence user = new LdapUserDetailsAgrega.Essence((LdapUserDetailsAgrega) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		log("Se crea un nuevo objeto LdapUserDetailsAgrega para machacar los datos del usuario");
		user.setDatosUsuario(usuario);
		log("Se modifican los datos del usuario");
		log("Permisos del user " + user.getGrantedAuthorities());
		Authentication currentAuth = new UsernamePasswordAuthenticationToken(user.createUserDetails(), creden, ldapGranted);
		log("currentAuth " + currentAuth);
		SecurityContextHolder.getContext().setAuthentication(currentAuth);
	}

	private void log(Object obj) {
		if (log.isDebugEnabled())
			log.debug(obj);
	}
}