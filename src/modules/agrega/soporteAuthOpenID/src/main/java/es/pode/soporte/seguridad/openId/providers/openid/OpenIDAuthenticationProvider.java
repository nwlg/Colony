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
package es.pode.soporte.seguridad.openId.providers.openid;


import org.springframework.beans.factory.InitializingBean;
import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationException;
import org.acegisecurity.AuthenticationServiceException;
import org.acegisecurity.BadCredentialsException;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
//import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.context.SecurityContext;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.context.SecurityContextImpl;
import org.acegisecurity.providers.AuthenticationProvider;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
//import org.acegisecurity.userdetails.UserDetails;
//import org.acegisecurity.userdetails.UserDetails;
//import org.acegisecurity.userdetails.UserDetailsService;
//import org.acegisecurity.userdetails.ldap.LdapUserDetails;
//import org.springframework.util.Assert;

//import es.pode.soporte.seguridad.ldap.LdapUserDetailsAgrega;
//import es.pode.soporte.seguridad.ldap.LdapUserDetailsAgrega;
//import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsAgrega;
import es.pode.soporte.seguridad.ldap.WrapperSrvAdminUsuarios;
//import es.pode.soporte.seguridad.openId.ui.openid.OpenIDAuthenticationProcessingFilter;
//import es.pode.soporte.seguridad.ldap.LdapUserDetailsAgrega.Essence;
import es.pode.soporte.seguridad.servicios.UsuarioVO;


/**
 * Finalises the OpenID authentication by obtaining local authorities for the authenticated user.
 * <p>
 * The authorities are obtained by calling the configured <tt>UserDetailsService</tt>.
 * The <code>UserDetails</code> it returns must, at minimum, contain the username and <code>GrantedAuthority[]</code>
 * objects applicable to the authenticated user. Note that by default, Spring Security ignores the password and
 * enabled/disabled status of the <code>UserDetails</code> because this is
 * authentication-related and should have been enforced by another provider server.
 * <p>
 * The <code>UserDetails</code> returned by implementations is stored in the generated <code>AuthenticationToken</code>,
 * so additional properties such as email addresses, telephone numbers etc can easily be stored.
 *
 * @author Robin Bramley, Opsera Ltd.
 */
public class OpenIDAuthenticationProvider implements AuthenticationProvider, InitializingBean {
    //~ Instance fields ================================================================================================

  //  private UserDetailsService userDetailsService;
  

    //~ Methods ========================================================================================================

	private static final Log log = LogFactory.getLog(OpenIDAuthenticationProvider.class);
	private final static String ROLE_ANONYMOUS = "ANONYMOUS";
	private Class context = SecurityContextImpl.class;
	
    public void afterPropertiesSet() throws Exception {
       // Assert.notNull(this.userDetailsService, "The userDetailsService must be set");
    }

    /* (non-Javadoc)
     * @see org.springframework.security.providers.AuthenticationProvider#authenticate(org.springframework.security.Authentication)
     */
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {

    	SecurityContext sc = null;
    	
    	
    	if (log.isDebugEnabled())
  			log.debug("[OpenIDAuthenticationProvider] authenticate");
  			if (log.isDebugEnabled())
      			log.debug("authentication "+authentication);
        if (!supports(authentication.getClass())) {
            return null;
        }

        if (authentication instanceof OpenIDAuthenticationToken) {
        	 OpenIDAuthenticationToken response = (OpenIDAuthenticationToken)authentication;
        	
             OpenIDAuthenticationStatus status = response.getStatus();
             if (log.isDebugEnabled())
       			log.debug("status "+status);
             
             if(status == OpenIDAuthenticationStatus.SUCCESS)
             {
            	 LdapUserDetailsAgrega.Essence user = null;
        		 Authentication token = null;
            	
        		 if (log.isDebugEnabled())
        	  			log.debug("response.getIdentityUrl() "+response.getIdentityUrl());
        		String identifyUrl = response.getIdentityUrl();
//        		Se comprueba si la url de OpenId del usuario tiene una barra al final (el proveedor de OpenId lo puede devolver así), en ese caso se eliminaría
	   				//antes de enviárselo a adminUsuarios
	   				if((identifyUrl.substring(identifyUrl.length() -1)).equalsIgnoreCase("/"))
	   				{
	   				 if (log.isDebugEnabled())
	    	   	 		log.debug("La url de openid finaliza con una barra");
	   				identifyUrl = identifyUrl.substring(0,identifyUrl.length() - 1);
	   				if (log.isDebugEnabled())
	   					log.debug("valorCookie vale ["+identifyUrl+"]");
	   				}
	   				
        		 
            	 UsuarioVO usuario = this.obtenerUsuario(identifyUrl);
            	 if (log.isDebugEnabled())
           			log.debug("El resultado del metodo obtenerUsuario "+usuario);
            	 if(usuario == null)
            	 {
            		 if (log.isDebugEnabled())
            	  			log.debug("El usuario es null");
            		 return null;
            	 }else
            	 {
            			try
            			{			
            				if (log.isDebugEnabled())
            		  			log.debug("Se obtienen los datos del usuario: " + usuario);		
            				   				
            				if (log.isDebugEnabled())
            		  			log.debug("Se prepara el UserDetails");
            				
            				user = new LdapUserDetailsAgrega.Essence();							
            				user.setUsername(usuario.getUsuario());
            				user.setDatosUsuario(usuario.getUsuario());
            				if (log.isDebugEnabled())
            		  			log.debug("Se añade el rol anónimo");
            				/* Añadimos el rol anónimo */
            				GrantedAuthority permisosAnadir[] = new GrantedAuthority[1];
        	   				permisosAnadir[0] = new GrantedAuthorityImpl(ROLE_ANONYMOUS);
            				
            				if (log.isDebugEnabled())
            		  			log.debug("Se recuperan los roles del usuario en la BBDD");
            		
            				/* Obtenemos los roles del usuario */
            				GrantedAuthority permisosUsuario[] = null;
            				permisosUsuario = WrapperSrvAdminUsuarios.obtenerAnadirRoles(permisosAnadir, usuario.getUsuario(), null);
            				
            				if (log.isDebugEnabled())
            		  			log.debug("Se le añade la seguridad al proceso");
            				
           	   			 if (log.isDebugEnabled())
           	   	 			log.debug("Se le añade la seguridad al proceso");
           	   				
           	   				// Auntenticamos el usuario y lo ponemos en el contexto de seguridad del usuario 
           	   			 //Añado los roles al Essence
           	   			 if (log.isDebugEnabled())
           	   	 			log.debug("user "+user);
           	   			 	user.setAuthorities(permisosUsuario, usuario.getUsuario(), null);
            				/* Auntenticamos el usuario y lo ponemos en el contexto de seguridad del usuario */
            				token = new UsernamePasswordAuthenticationToken(user.createUserDetails(), null, permisosUsuario);
            				sc = (SecurityContext) this.context.newInstance();
        	   				sc.setAuthentication(token);
        	   				SecurityContextHolder.setContext(sc);
            				///SecurityContextHolder.getContext().setAuthentication(token);
            			}
            			catch (Exception e)
            			{
            				log.error("Error al autenticar y añadir la seguridad al proceso"+ e);
            				return null;
            			}
            		
            		 return token;
            	 }
            	
             
             }
             if(status == OpenIDAuthenticationStatus.CANCELLED)
             {
                 throw new AuthenticationCancelledException("Log in cancelled");
             }
             if(status == OpenIDAuthenticationStatus.ERROR)
             {
                 throw new AuthenticationServiceException("Error message from server: " + response.getMessage());
             }
             if(status == OpenIDAuthenticationStatus.FAILURE)
             {
                 throw new BadCredentialsException("Log in failed - identity could not be verified");
             }
             if(status == OpenIDAuthenticationStatus.SETUP_NEEDED)
             {
                 throw new AuthenticationServiceException("The server responded setup was needed, which shouldn't happen");
             } else
             {
                 throw new AuthenticationServiceException("Unrecognized return value " + status.toString());
             }
        }else
        {
        	return null;
        }

        
    }
    
   
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
    
    
    private UsernamePasswordAuthenticationToken obtenerTokenError(String urlOpenId)
    {
    	GrantedAuthority permisosAnadir[] = new GrantedAuthority[1];
		permisosAnadir[0] = new GrantedAuthorityImpl("ROLE_ANONYMOUS");
    	UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(urlOpenId, null, permisosAnadir);
		return token;
    }

    /**
     * Used to load the authorities for the authenticated OpenID user.
     */
  

    /* (non-Javadoc)
     * @see org.springframework.security.providers.AuthenticationProvider#supports(java.lang.Class)
     */
    public boolean supports(Class authentication) {
       ///// return OpenIDAuthenticationToken.class.isAssignableFrom(authentication);
    	return true;
    }
}
