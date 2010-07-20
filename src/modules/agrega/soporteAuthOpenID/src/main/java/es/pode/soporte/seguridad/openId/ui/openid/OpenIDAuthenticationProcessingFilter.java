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
import org.acegisecurity.AuthenticationServiceException;
import org.acegisecurity.context.SecurityContextHolder;
import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.soporte.seguridad.openId.providers.openid.OpenIDAuthenticationProvider;
import es.pode.soporte.seguridad.openId.providers.openid.OpenIDAuthenticationToken;
import es.pode.soporte.seguridad.openId.ui.openid.consumers.OpenID4JavaConsumer;
import org.openid4java.consumer.ConsumerException;
import org.springframework.util.StringUtils;
import org.acegisecurity.ui.webapp.AuthenticationProcessingFilter;
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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.acegisecurity.ui.AbstractProcessingFilter;
import es.pode.soporte.seguridad.encriptacion.EncriptacionUtiles;




public class OpenIDAuthenticationProcessingFilter extends AbstractProcessingFilter{ 
//implements Filter { 
//extends AbstractProcessingFilter {
    //~ Static fields/initializers =====================================================================================

    private static final Log log = LogFactory.getLog(OpenIDAuthenticationProcessingFilter.class);
    public static final String DEFAULT_CLAIMED_IDENTITY_FIELD = "username";
  	private static final String valorCookieAuntenticado = "SI";
	private static final String nombreCookieOpenId = "OPENID";
	private static final String valorCookieOpenId = "SI";
	
    
    //~ Instance fields ================================================================================================

    private OpenIDConsumer consumer;
    private String claimedIdentityFieldName = DEFAULT_CLAIMED_IDENTITY_FIELD;
    private Map realmMapping = new HashMap();

    //~ Methods ========================================================================================================

    public void afterPropertiesSet() throws Exception {
    	 if (log.isDebugEnabled())
  			log.debug("[OpenIDAuthenticationProcessingFilter] afterPropertiesSet()");
        //super.afterPropertiesSet();
        if (consumer == null) {
            consumer = new OpenID4JavaConsumer();
        }
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
    	log.info("[OpenIDAuthenticationProcessingFilter] doFilter");
    	//Miro la url a la que se redigirá
    	if (log.isDebugEnabled())
				log.debug("((HttpServletRequest)request).getSession().getAttribute(AbstractProcessingFilter.ACEGI_SAVED_REQUEST_KEY) "+((HttpServletRequest)request).getSession().getAttribute(AbstractProcessingFilter.ACEGI_SAVED_REQUEST_KEY));
	   	if (consumer == null) {
    		 if (log.isDebugEnabled())
       			log.debug("consumer es null");
            
			try
			{
				consumer = new OpenID4JavaConsumer();
				log.info("[OpenIDAuthenticationProcessingFilter] instanciamos el consumer");
			} catch (ConsumerException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
    	if(!(request instanceof HttpServletRequest))
        {
            throw new ServletException("Can only process HttpServletRequest");
        }
        if(!(response instanceof HttpServletResponse))
        {
            throw new ServletException("Can only process HttpServletResponse");
        }
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        String urlreturnTo = httpRequest.getParameter("openid.return_to");
           
        if(requiresAuthentication(httpRequest, httpResponse))
        {
        	 Authentication authResult;
             try
             {
                 onPreAuthentication(httpRequest, httpResponse);
                 authResult = attemptAuthentication(httpRequest);
                 log.info("Se ha realizado la autenticacion openid");
                 if (log.isDebugEnabled())
           			log.debug("authResult ["+authResult+"]");
                 if(authResult == null)
                 {
                	 if (log.isDebugEnabled())
                			log.debug("Lanzamos una excepcion AuthenticationServiceException");
                	 throw new AuthenticationServiceException("Autenticacion nula");
                 }
             }
             catch(AuthenticationException failed)
             {
                 unsuccessfulAuthentication(httpRequest, httpResponse, failed);
                 return;
             }
   
            
             if(isContinueChainBeforeSuccessfulAuthentication())
             {
            	log.info("autenticacion correcta");
                chain.doFilter(request, response);
             }
             //Metemos en la httpsession el contexto de acegi, esto es necesario para que los filtros de Acegi que filtran todas las peticiones
             //detecten que el contexto ya ha sido creado
             
             httpRequest.getSession().setAttribute("ACEGI_SECURITY_CONTEXT",SecurityContextHolder.getContext());
             
             //Se guarda la url de openId en la cookie encriptada
             try
             {
            	 if (log.isDebugEnabled())
           			log.debug("AuthenticationProcessingFilter.ACEGI_SECURITY_FORM_USERNAME_KEY vale "+AuthenticationProcessingFilter.ACEGI_SECURITY_FORM_USERNAME_KEY);
            	 if (log.isDebugEnabled())
            			log.debug("Metemos en la cookie openid["+(String)httpRequest.getSession().getAttribute(AuthenticationProcessingFilter.ACEGI_SECURITY_FORM_USERNAME_KEY));
            	 this.setCookieAutenticado(httpResponse,EncriptacionUtiles.encriptar((String)httpRequest.getSession().getAttribute(AuthenticationProcessingFilter.ACEGI_SECURITY_FORM_USERNAME_KEY)));
            	 //Se comprueba si existe la cookie AUTENTICADO en ese caso se invalidará
            	 this.invalidateCookieAutenticado(httpResponse);
            	 if (log.isDebugEnabled())
            			log.debug("Asignamos la cookie openId");
             }catch(Exception e)
             {
            	 log.error("Exception al intentar almacenar en la cookie", e);
             }
          
            successfulAuthenticationOpenID(httpRequest, httpResponse, authResult);
            return;
         } else
         {
             chain.doFilter(request, response);
             return;
         }
       
    }

    
    /**
	 * Valida contra el proveedor OpenId la url openid del usuario
	 * @param HttpServletRequest Request del usuario
	 * @throws AuthenticationException
	 */
  public Authentication attemptAuthentication(HttpServletRequest req) throws AuthenticationException {
        OpenIDAuthenticationToken token;
        if (log.isDebugEnabled())
 			log.debug("[OpenIDAuthenticationProcessingFilter] attemptAuthentication");
        String identity = req.getParameter("openid.identity");
        if (log.isDebugEnabled())
 			log.debug("identity "+identity);
              
        if (!StringUtils.hasText(identity)) {
        	
            // Obtenemos el usuario de la request
            String username = obtainUsername(req);
            if (log.isDebugEnabled())
     			log.debug("username "+username);
            setLastUsername(username, req);
            throw new OpenIDAuthenticationRequiredException("External Authentication Required", username);
        }
       
        try {
        	        	
        	//Obtenemos la respuesta del proveedor
        	token = consumer.endConsumption(req);
            if (log.isDebugEnabled())
     			log.debug("token "+token);
        } catch (OpenIDConsumerException oice) {
            throw new AuthenticationServiceException("Consumer error", oice);
            //aqui habrá que devolver un acceso prohibido y que vuelva a la página del cas?
        }
        
        if (log.isDebugEnabled())
 			log.debug("authenticationDetailsSource.buildDetails(req) "+authenticationDetailsSource.buildDetails(req));
        token.setDetails(authenticationDetailsSource.buildDetails(req));
        
        if (log.isDebugEnabled())
 			log.debug("despues de token.setDetails");
        // delegate to the auth provider
       
        OpenIDAuthenticationProvider openIDAuthenticationProvider = new OpenIDAuthenticationProvider();
        if (log.isDebugEnabled())
 			log.debug("openIDAuthenticationProvider "+openIDAuthenticationProvider);
        
        //Authentication authentication = this.getAuthenticationManager().authenticate(token);
        Authentication authentication = openIDAuthenticationProvider.authenticate(token);
        if (log.isDebugEnabled())
 			log.debug("authentication "+authentication);
        if(authentication == null)
        {
        	 if (log.isDebugEnabled())
      			log.debug("No esta autenticado ");
        	return null;
        }else
        {
        if (authentication.isAuthenticated()) {
        	 if (log.isDebugEnabled())
      			log.debug("authentication.isAuthenticated() "+authentication.isAuthenticated());
            setLastUsername(token.getIdentityUrl(), req);
      
        }
        }
        if (log.isDebugEnabled())
 			log.debug("authentication "+authentication);
       return authentication;
     
    
    }

    private void setLastUsername(String username, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (log.isDebugEnabled())
 			log.debug("[OpenIDAuthenticationProcessingFilter] setLastUsername");
        //if (session != null || getAllowSessionCreation()) {
        if (session != null) {
            request.getSession().setAttribute(AuthenticationProcessingFilter.ACEGI_SECURITY_FORM_USERNAME_KEY, username);
            if (log.isDebugEnabled())
     			log.debug("AuthenticationProcessingFilter.ACEGI_SECURITY_FORM_USERNAME_KEY "+AuthenticationProcessingFilter.ACEGI_SECURITY_FORM_USERNAME_KEY);
        }
    }

    protected String determineFailureUrl(HttpServletRequest request, AuthenticationException failed) {
    	 if (log.isDebugEnabled())
  			log.debug("[OpenIDAuthenticationProcessingFilter] determineFailureUrl");
        if (failed instanceof OpenIDAuthenticationRequiredException) {
            OpenIDAuthenticationRequiredException openIdRequiredException = (OpenIDAuthenticationRequiredException) failed;
            if (log.isDebugEnabled())
     			log.debug("openIdRequiredException "+openIdRequiredException);
            String claimedIdentity = openIdRequiredException.getClaimedIdentity();
            if (StringUtils.hasText(claimedIdentity)) {
            	
                try {
                    String returnToUrl = buildReturnToUrl(request);
                    if (log.isDebugEnabled())
             			log.debug("returnToUrl "+returnToUrl);
                    String realm = lookupRealm(returnToUrl);
                    return consumer.beginConsumption(request, claimedIdentity, returnToUrl, realm);
                } catch (OpenIDConsumerException e) {
                    log.error("Unable to consume claimedIdentity [" + claimedIdentity + "]", e);
                    
                }
            }
        }
        else if((failed instanceof AuthenticationServiceException)||(failed instanceof AuthenticationException))
        {
        	
        		log.info("Se redirige a la pagina de error del portalAdministracion no tiene acceso a esta parte de la aplicacion");
        		return request.getContextPath()+"/error-page.jsp?code=403";
        		
        }else
        {
        	if (log.isDebugEnabled())
     			log.debug("La excepcion que salta no es de ningún tipo de los anteriores");
        }
     
       return "";
    }

    protected String lookupRealm(String returnToUrl) {
    	 if (log.isDebugEnabled())
  			log.debug("[OpenIDAuthenticationProcessingFilter] lookupRealm");
        String mapping = (String) realmMapping.get(returnToUrl);

        if (mapping == null) {
            try {

                URL url = new URL(returnToUrl);
                int port = (url.getPort() == -1) ? 80 : url.getPort();
                StringBuffer realmBuffer = new StringBuffer(returnToUrl.length())
                        .append(url.getProtocol())
                        .append("://")
                        .append(url.getHost())
                        .append(":").append(port)
                        .append("/");
                mapping = realmBuffer.toString();
            } catch (MalformedURLException e) {
                log.warn("returnToUrl was not a valid URL: [" + returnToUrl + "]", e);
            }
        }
        log.debug("[devuelvo] "+returnToUrl);
        return returnToUrl;
       // return mapping;
    }

    protected String buildReturnToUrl(HttpServletRequest request) {
    	
    	//Modificado para ver si salimos a las conexiones http
    	  		
    	 if (log.isDebugEnabled())
 			log.debug("[salida ]"+request.getRequestURL().toString()); 
        return request.getRequestURL().toString();
         
        
    }

    public String getClaimedIdentityFieldName() {
        return claimedIdentityFieldName;
    }

    public OpenIDConsumer getConsumer() {
        return consumer;
    }

    public String getDefaultFilterProcessesUrl() {
        return "/j_spring_openid_security_check";
    }

    protected boolean isAuthenticated(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return (auth != null) && auth.isAuthenticated();
    }

    /**
     * The OpenIdAuthenticationProcessingFilter will ignore the request coming in if this method returns false.
     * The default functionality checks if the request scheme starts with http. <br/
     * > This method should be overridden in subclasses that wish to consider a different strategy
     *
     * @param request HttpServletRequest we're processing
     * @return true if this request is determined to be an OpenID request.
     */
    protected boolean isOpenIdRequest(HttpServletRequest request) {
        String username = obtainUsername(request);
        return (StringUtils.hasText(username)) && username.toLowerCase().startsWith("http");
    }

    protected String obtainUsername(ServletRequest req) {
        return req.getParameter(claimedIdentityFieldName);
    	
    }

    protected void onUnsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                                AuthenticationException failed) throws IOException {
        if (failed instanceof OpenIDAuthenticationRequiredException) {
            OpenIDAuthenticationRequiredException openIdAuthenticationRequiredException = (OpenIDAuthenticationRequiredException) failed;
            request.setAttribute(OpenIDAuthenticationRequiredException.class.getName(),
                    openIdAuthenticationRequiredException.getClaimedIdentity());
        }
    }

    public void setClaimedIdentityFieldName(String claimedIdentityFieldName) {
        this.claimedIdentityFieldName = claimedIdentityFieldName;
    }

    public void setConsumer(OpenIDConsumer consumer) {
        this.consumer = consumer;
    }

    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException {
    	  SecurityContextHolder.getContext().setAuthentication(null);
         
    	  if (log.isDebugEnabled())
   			log.debug("Updated SecurityContextHolder to contain null Authentication");
         
          String failureUrl = determineFailureUrl(request, failed);
          if (log.isDebugEnabled())
     			log.debug("failureUrl: " + failureUrl);
          if (log.isDebugEnabled())
   			log.debug("Authentication request failed: " + failed.toString());
         
        //  if(getAllowSessionCreation())
         // {
              try
              {
                  request.getSession().setAttribute("SPRING_SECURITY_LAST_EXCEPTION", failed);
              }
              catch(Exception ignored) { }
        //  }
          
          response.sendRedirect(failureUrl);
    }

    public int getOrder() {
    
    	return 1;
    }
 

    /**
     * Maps the return_to url to a realm.<br/>
     * For example http://www.example.com/j_spring_openid_security_check -> http://www.example.com/realm<br/>
     * If no mapping is provided then the returnToUrl will be parsed to extract the protocol, hostname and port followed
     * by a trailing slash.<br/>
     * This means that http://www.example.com/j_spring_openid_security_check will automatically
     * become http://www.example.com:80/
     *
     * @return Map containing returnToUrl -> realm mappings
     */
    public Map getRealmMapping() {
        return realmMapping;
    }

    /**
     * Maps the return_to url to a realm.<br/>
     * For example http://www.example.com/j_spring_openid_security_check -> http://www.example.com/realm<br/>
     * If no mapping is provided then the returnToUrl will be parsed to extract the protocol, hostname and port followed
     * by a trailing slash.<br/>
     * This means that http://www.example.com/j_spring_openid_security_check will automatically
     * become http://www.example.com:80/
     *
     * @param realmMapping containing returnToUrl -> realm mappings
     */
    public void setRealmMapping(Map realmMapping) {
        this.realmMapping = realmMapping;
    }

	public void destroy()
	{
		 if (log.isDebugEnabled())
	 			log.debug("[OpenIDAuthenticationProcessingFilter] destroy");
		
	}

	public void init(FilterConfig arg0) throws ServletException
	{
		 if (log.isDebugEnabled())
	 			log.debug("[OpenIDAuthenticationProcessingFilter] init");
		
	}
	
	
	protected void successfulAuthenticationOpenID(HttpServletRequest request, HttpServletResponse response,
	        Authentication authResult) throws IOException {
	        if (logger.isDebugEnabled()) {
	            logger.debug("Authentication success: " + authResult.toString());
	        }

	        SecurityContextHolder.getContext().setAuthentication(authResult);

	        if (logger.isDebugEnabled()) {
	            logger.debug("Updated SecurityContextHolder to contain the following Authentication: '" + authResult + "'");
	        }

	        String targetUrl = obtainFullRequestUrl(request);
	        if (logger.isDebugEnabled()) {
	            logger.debug("[targetUrl vale] " + targetUrl);
	        }
	       

	        if (targetUrl == null) {
	          //  targetUrl = request.getContextPath() + "/PortadaAdministracion/PortadaAdministracion.do";
	        	targetUrl = "http://"+this.getAgregaPropertyValue("host") + this.getAgregaPropertyValue("admin.ws.subdominio") +"/portaladministracion/PortadaAdministracion/PortadaAdministracion.do";
	            if (logger.isDebugEnabled()) {
		            logger.debug("targetUrl es null redirecting to target URL from HTTP Session (or default): " + targetUrl);
		        }
	            response.sendRedirect(response.encodeRedirectURL(targetUrl));
	        }else
	        {
	        	 if (logger.isDebugEnabled()) {
	 	            logger.debug("Redirecting to target URL from HTTP Session (or default): " + targetUrl);
	 	        }
	        	 successfulAuthentication(request, response, authResult);
	        }
    
	        
	    }
	
	private void setCookieAutenticado(HttpServletResponse response,String claimedIdentity) throws IOException{
		
		Cookie cookieOpenId = new Cookie(nombreCookieOpenId, claimedIdentity);
		cookieOpenId.setPath("/");
		//El tiempo de expiración de la cookie se recogerá del Agrega.properties
		
		int caducidadCookie = new Long(((System.currentTimeMillis())*1000)).intValue() + (new Integer(this.getAgregaPropertyValue(AgregaProperties.TIMEOUTCOOKIEOPENID))).intValue();
		 if (log.isDebugEnabled())
	 			log.debug("caducidadCookie "+caducidadCookie);
		cookieOpenId.setMaxAge(caducidadCookie);
		//cookieOpenId.setMaxAge(-1);
		response.addCookie(cookieOpenId);
		
	}
	
	  private String getAgregaPropertyValue(String sKey) throws IOException
		{
	    	
			AgregaProperties properties = AgregaPropertiesImpl.getInstance();
			// devolvemos la propiedad
			return properties.getProperty(sKey);
		}
	  
	  private String getCookieValor(HttpServletRequest request, String nombreCookie) {
			Cookie cookie = null;
			String valor = null;
			cookie = getCookie(nombreCookie, request.getCookies());
			valor = cookie.getValue();
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
		 * Invalida la cookie AUTENTICADO
		 * @param response
		 * @param request
		 */
		private void invalidateCookieAutenticado(HttpServletResponse response) throws IOException{
			
			Cookie cookieAutenticado = new Cookie("AUTENTICADO", "");
			cookieAutenticado.setPath("/");
			cookieAutenticado.setMaxAge(0);
			response.addCookie(cookieAutenticado);
			
		}
  
	
}
