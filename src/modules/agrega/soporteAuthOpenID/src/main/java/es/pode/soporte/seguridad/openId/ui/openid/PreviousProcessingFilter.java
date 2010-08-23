/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/* Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package es.pode.soporte.seguridad.openId.ui.openid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationException;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.context.SecurityContextImpl;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.acegisecurity.ui.AbstractProcessingFilter;
import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsAgrega;
//import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
//import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
import es.pode.soporte.seguridad.ldap.WrapperSrvAdminUsuarios;
import es.pode.soporte.seguridad.servicios.UsuarioVO;
import es.pode.soporte.seguridad.encriptacion.EncriptacionUtiles;
import org.acegisecurity.context.SecurityContext;
///import es.indra.sawa.support.serializer.XmlSerializer;
import org.acegisecurity.userdetails.UserDetails;




public class PreviousProcessingFilter extends AbstractProcessingFilter{ 
//implements Filter { 
//extends AbstractProcessingFilter {
    //~ Static fields/initializers =====================================================================================

    private static final Log log = LogFactory.getLog(PreviousProcessingFilter.class);
    private static final String nombreCookieOpenId = "OPENID";
    private final static String ROLE_ANONYMOUS = "ANONYMOUS";
    private Class context = SecurityContextImpl.class;
    private static final String nombreCookieModificarPerfil = "MODIFICAR_PERFIL";

	private static final String sesionModificarPerfil = "perfilModificado";
	
    
    //~ Instance fields ================================================================================================

    

    //~ Methods ========================================================================================================

    public void afterPropertiesSet() throws Exception {
    	 if (log.isDebugEnabled())
  			log.debug("[OpenIDAuthenticationProcessingFilter] afterPropertiesSet()");
      
    }
  
    
    /**
	 * Filtra todas las peticiones de validación de openId
	 * @param ServletRequest 
	 * @param ServletResponse
	 * @param FilterChain
	 * @throws IOException, ServletException
	 */
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException
{
    	log.info("[PreviousProcessingFilter] doFilter");
    	HttpSession session = ((HttpServletRequest)request).getSession();
    	HttpServletRequest httpRequest = (HttpServletRequest)request;
    	SecurityContext sc = null;
    	boolean auntenticadoRoles = false;
    	 if (log.isDebugEnabled())
  			log.debug("El valor de la cookie nombreCookieOpenId "+this.getCookieValor(httpRequest, nombreCookieOpenId));
    	    Object contextoSesion = httpRequest.getSession().getAttribute("ACEGI_SECURITY_CONTEXT");
    	    if (log.isDebugEnabled())
      			log.debug("contextoSesion vale ["+contextoSesion+"]");
    	    auntenticadoRoles = this.estaAutenticado((SecurityContext)contextoSesion);
    	    if(!auntenticadoRoles)
    	    {
    	    	if (log.isDebugEnabled())
          			log.debug("No esta autenticado miro si esta la cookie openid");
    	    	String valorCookie = this.getCookieValor(httpRequest, nombreCookieOpenId);
    	    	if(!(valorCookie == null) && !(valorCookie == "") && !(valorCookie == " "))
    	    	{
    	    		log.debug("No esta autenticado pero tengo la cookie openid");
    	    		this.actualizaCookie((HttpServletRequest)request, (HttpServletResponse)response, nombreCookieOpenId);
    	    		LdapUserDetailsAgrega.Essence user = null;
    	   		    Authentication token = null;
    	   		    try
    	   		    {
    	   		    valorCookie = EncriptacionUtiles.desencriptar(this.getCookieValor(httpRequest, nombreCookieOpenId));
    	   			try
    	   			{
    	   				//Se comprueba si la url de OpenId del usuario tiene una barra al final (el proveedor de OpenId lo puede devolver así), en ese caso se eliminaría
    	   				//antes de enviárselo a adminUsuarios
    	   				if((valorCookie.substring(valorCookie.length() -1)).equalsIgnoreCase("/"))
    	   				{
    	   				 if (log.isDebugEnabled())
    	    	   	 			log.debug("La url de openid finaliza con una barra");
    	   				 valorCookie = valorCookie.substring(0,valorCookie.length() - 1);
    	   				if (log.isDebugEnabled())
	    	   	 			log.debug("valorCookie vale ["+valorCookie+"]");
    	   				}
    	   				
    	   			   UsuarioVO usuario = this.obtenerUsuario(valorCookie);
    	   			   if (log.isDebugEnabled())
    	   	 			log.debug("Se obtienen los datos del usuario[" + usuario+"]");		
    	   				   				
    	   				user = new LdapUserDetailsAgrega.Essence();							
    	   				user.setUsername(usuario.getUsuario());
    	   				user.setDatosUsuario(usuario.getUsuario());
    	   							
    	   				if (log.isDebugEnabled())
    	   	   	 			log.debug("Se añade el rol anónimo");
    	   				
    	   				// Añadimos el rol anónimo 
    	   				GrantedAuthority permisosAnadir[] = new GrantedAuthority[1];
    	   				permisosAnadir[0] = new GrantedAuthorityImpl(ROLE_ANONYMOUS);
    	   				if (log.isDebugEnabled())
    	   					log.debug("Se recuperan los roles del usuario en la BBDD");
    	   		
    	   				// Obtenemos los roles del usuario */
    	   				GrantedAuthority permisosUsuario[] = null;
    	   				permisosUsuario = WrapperSrvAdminUsuarios.obtenerAnadirRoles(permisosAnadir, usuario.getUsuario(), null);
    	   				
    	   				// Auntenticamos el usuario y lo ponemos en el contexto de seguridad del usuario 
    	   			 //Añado los roles al Essence
    	   				user.setAuthorities(permisosUsuario, usuario.getUsuario(), null);
    	   				if (log.isDebugEnabled())
    	   					log.debug("permisosUsuario "+permisosUsuario);
    	   				token = new UsernamePasswordAuthenticationToken(user.createUserDetails(), null, permisosUsuario);
    	   				//Creamos un nuevo contexto para añadirlo el nuevo token
    	   				sc = (SecurityContext) this.context.newInstance();
    	   				sc.setAuthentication(token);
    	   				SecurityContextHolder.setContext(sc);
    	   				
    	   				if (log.isDebugEnabled())
         	   	 			log.debug("sc [ "+sc+"]");
    	   				
    	   			}
    	   			catch (Exception e)
    	   			{
    	   				log.error("Error al autenticar y añadir la seguridad al proceso"+ e);
    	   				
    	   				
    	   			}
    	   			httpRequest.getSession().setAttribute("ACEGI_SECURITY_CONTEXT",sc);
    	   			SecurityContextHolder.setContext(sc);
    	    		chain.doFilter(request, response);
    	    		return;
    	   		    }catch(Exception e)
    	   		    {
    	   		    	log.error("Exception al desencriptar ["+e+"]");
    	   		    }
    	    	}else
    	    	{
    	    		if (log.isDebugEnabled())
         	 			log.debug("No tengo la cookie de openId continuo con los filtros");
        	    	 chain.doFilter(request, response);
        	    	 return;
    	    	}
    	    	 
    	    }else
    	    {
    	    	if (log.isDebugEnabled())
     	 			log.debug("Esta autenticado paso al siguiente filtro");
    	    	//Compruebo si tiene cookie openid, en ese caso vuelvo a actualizar el timeout
    	    	String valorCookie = this.getCookieValor(httpRequest, nombreCookieOpenId);
    	    	if(!(valorCookie == null) && !(valorCookie == "") && !(valorCookie == " "))
    	    	{
    	    		if (log.isDebugEnabled())
         	 			log.debug("Actualizo la cookie");
    	    		this.actualizaCookie((HttpServletRequest)request, (HttpServletResponse)response, nombreCookieOpenId);
    	    	}
    	    	String cookieModificarPerfil = this.getCookieValor((HttpServletRequest) request, nombreCookieModificarPerfil);
    			String modficarPerfil = (String)(httpRequest.getSession()).getAttribute(sesionModificarPerfil);
    			if (cookieModificarPerfil != null && cookieModificarPerfil != "" && (!(cookieModificarPerfil.equals(modficarPerfil)))) // Existe la cookie de modificar perfil
    			{
    				if (log.isDebugEnabled())
         	 			log.debug("Modifico el contexto " + cookieModificarPerfil);
    				if (log.isDebugEnabled())
         	 			log.debug("ModificarPerfile vale " + modficarPerfil);
    				/* Modificación del contexto de Acegi con el nuevo perfil */
    				modificacionContextoAcegi(contextoSesion,httpRequest);
    				if (log.isDebugEnabled())
         	 			log.debug("Se añade un valor a la sesion para no actualizarlo más veces");
    				(httpRequest.getSession()).setAttribute(sesionModificarPerfil, cookieModificarPerfil);
    			}
    	    	 chain.doFilter(request, response);
    	    	 return;
    	    }
    	     	   
}


    protected String buildReturnToUrl(HttpServletRequest request) {
        return request.getRequestURL().toString();
    }

    public String getDefaultFilterProcessesUrl() {
        return "/j_spring_openid_security_check";
    }

    protected boolean isAuthenticated(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return (auth != null) && auth.isAuthenticated();
    }

   
    public int getOrder() {
      //  return FilterChainOrder.OPENID_PROCESSING_FILTER;
     // Devuelve el orden del filtro, es el primero de todos
    	return 1;
    }
 

   
	public void destroy()
	{
		 if (log.isDebugEnabled())
	 			log.debug("[OpenIDAuthenticationProcessingFilter] destroy");
		
	}

	public void init(FilterConfig arg0) throws ServletException
	{
		 if (log.isDebugEnabled())
	 			log.debug("[PreviousProcessingFilter] init");
		
	}
	
	/**
	 * Devuelve el valor de la cookie de OpenId
	 * @param ServletRequest 
	 * @param ServletResponse
	 * @param nombreCookie
	*/	
	private String getCookieValor(HttpServletRequest request, String nombreCookie) {
		Cookie cookie = null;
		String valor = null;

		 if (log.isDebugEnabled())
	 			log.debug("Se coge la cookie " + nombreCookie);
		cookie = getCookie(nombreCookie, request.getCookies());
		valor = cookie.getValue();
		 if (log.isDebugEnabled())
	 			log.debug("Valor cookie:" + valor);
		return valor;
	}
	
	/**
	 * Actualiza el timeout de la cookie de OpenId
	 * @param ServletRequest 
	 * @param ServletResponse
	 * @param nombreCookie
	 * @throws IOException
	*/
	private void actualizaCookie(HttpServletRequest request, HttpServletResponse response, String nombreCookie) throws IOException
	{
		Cookie cookie = null;
		if (log.isDebugEnabled())
 			log.debug("Se coge la cookie " + nombreCookie);
		cookie = getCookie(nombreCookie, request.getCookies());
		int caducidadCookie = (new Integer(this.getAgregaPropertyValue(AgregaProperties.TIMEOUTCOOKIEOPENID))).intValue();
		if (log.isDebugEnabled())
	 			log.debug("caducidadCookie "+caducidadCookie);
		cookie.setMaxAge(caducidadCookie);
		cookie.setPath("/");
		response.addCookie(cookie);
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
	 * Recupera el usuario cuyo url de OpenId se pasa como parámetro
	 * @param openidUrl: url de OpenId
	 * @return UsuarioVO
	 */
	private UsuarioVO obtenerUsuario(String openidUrl)
    {
    	
		 if (log.isDebugEnabled())
	 			log.debug("[obtenerUsuario]");
             try 
             {
            	 if (log.isDebugEnabled())
          			log.debug("Se añaden los datos del usuario recuperados de un web service");
            	
             	UsuarioVO datosUsuario = WrapperSrvAdminUsuarios.obtenerDatosUsuarioOpenId(openidUrl);
             	return datosUsuario;
             }catch(Exception e)
             {
            	log.error("se produce la siguiente excepcion "+e);
            	return null;
             }
             

    }

	@Override
	public Authentication attemptAuthentication(HttpServletRequest arg0) throws AuthenticationException
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	/** 
	 * Recupera el valor de la propiedad que se pasa por parámetro del fichero de agrega.properties
	 * @param sKey
	 * @return String
	 */
	 private String getAgregaPropertyValue(String sKey) throws IOException
		{
	    	if (log.isDebugEnabled())
			log.debug("getAgregaPropertyValue");
			AgregaProperties properties = AgregaPropertiesImpl.getInstance();
			// devolvemos la propiedad
			if (log.isDebugEnabled())
				log.debug("properties.getProperty(sKey) "+properties.getProperty(sKey));
			return properties.getProperty(sKey);
		}
	 
	 private boolean estaAutenticado(SecurityContext ctx)
	    {
		 if (log.isDebugEnabled())
				log.debug("estaAutenticado ");
	        boolean correctCredentials = false;
	        if(ctx != null && 
	        ctx.getAuthentication() != null && 
	        ctx.getAuthentication().getPrincipal() != null && 
	        ctx.getAuthentication().getPrincipal() instanceof UserDetails)
	        	correctCredentials = true;
        	else
        		correctCredentials = false;
	        
	        return correctCredentials;
	    }
	 
	 private void modificacionContextoAcegi(Object contexto,HttpServletRequest request) {

		 log.info("Vamos a modificar el contexto de acegi");
		 try
		 {
			 SecurityContext context = (SecurityContext)contexto;
			 String usuario = ((LdapUserDetailsAgrega)(context.getAuthentication().getPrincipal())).getLogin();
			 if (log.isDebugEnabled())
				 log.debug("el valor del usuario es " + usuario);
			 GrantedAuthority[] ldapGranted = ((LdapUserDetailsAgrega)(context.getAuthentication().getPrincipal())).getAuthorities();
			 Object creden = context.getAuthentication().getCredentials();
			 LdapUserDetailsAgrega.Essence user = new LdapUserDetailsAgrega.Essence((LdapUserDetailsAgrega) context.getAuthentication().getPrincipal());
			 if (log.isDebugEnabled())
				 log.debug("Se crea un nuevo objeto LdapUserDetailsAgrega para machacar los datos del usuario");
			 user.setDatosUsuario(usuario);
			 Authentication currentAuth = new UsernamePasswordAuthenticationToken(user.createUserDetails(), creden, ldapGranted);
			 if (log.isDebugEnabled())
				 log.debug("modifico el contexto ");
			 SecurityContextHolder.getContext().setAuthentication(currentAuth);
			 if (log.isDebugEnabled())
				 log.debug("modifico el contexto ");
			 request.getSession().setAttribute("ACEGI_SECURITY_CONTEXT",SecurityContextHolder.getContext());
		 }catch(Exception e)
		 {
			 log.error("Se produce una excepcion al modificar el contexto "+e);
		 }
		}

	
}
