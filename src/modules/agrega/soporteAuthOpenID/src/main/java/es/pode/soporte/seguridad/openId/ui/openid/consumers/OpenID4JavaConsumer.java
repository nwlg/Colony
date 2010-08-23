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
package es.pode.soporte.seguridad.openId.ui.openid.consumers;

import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.soporte.seguridad.openId.providers.openid.OpenIDAuthenticationStatus;
import es.pode.soporte.seguridad.openId.providers.openid.OpenIDAuthenticationToken;
import es.pode.soporte.seguridad.openId.ui.openid.OpenIDConsumer;
import es.pode.soporte.seguridad.openId.ui.openid.OpenIDConsumerException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openid4java.association.AssociationException;
import org.openid4java.consumer.ConsumerException;
import org.openid4java.consumer.ConsumerManager;
import org.openid4java.consumer.VerificationResult;
import org.openid4java.discovery.DiscoveryException;
import org.openid4java.discovery.DiscoveryInformation;
import org.openid4java.discovery.Identifier;
import org.openid4java.message.AuthRequest;
import org.openid4java.message.AuthSuccess;
import org.openid4java.message.MessageException;
import org.openid4java.message.MessageExtension;
import org.openid4java.message.ParameterList;
import org.openid4java.util.HttpClientFactory;
import org.openid4java.util.ProxyProperties;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.openid4java.message.ax.AxMessage;
import org.openid4java.message.ax.FetchRequest;
import org.openid4java.message.ax.FetchResponse;
import org.openid4java.message.sreg.SRegMessage;




/**
 *
 * @author Ray Krueger
 */
public class OpenID4JavaConsumer implements OpenIDConsumer {
    //~ Instance fields ================================================================================================

    private final ConsumerManager consumerManager;
    
    private static final Log log = LogFactory.getLog(OpenID4JavaConsumer.class);

    //~ Constructors ===================================================================================================

    public OpenID4JavaConsumer(ConsumerManager consumerManager) {
    	
        this.consumerManager = consumerManager;
    }

    public OpenID4JavaConsumer() throws ConsumerException,IOException {
    	 

    	//this.consumerManager = new ConsumerManager(this.getAgregaPropertyValue(AgregaProperties.USAPROXY),this.getAgregaPropertyValue(AgregaProperties.HOSTPROXY), this.getAgregaPropertyValue(AgregaProperties.PORTPROXY), this.getAgregaPropertyValue(AgregaProperties.USUARIOPROXY), this.getAgregaPropertyValue(AgregaProperties.CLAVEPROXY));
    	this(new ConsumerManager());
        
    }
   
    //~ Methods ========================================================================================================

    public String beginConsumption(HttpServletRequest req, String identityUrl, String returnToUrl) throws OpenIDConsumerException {
       /// return beginConsumption(req, identityUrl,  returnToUrl, returnToUrl);
    	log.info("beginconsumption");
    	String realm = "";
    	log.debug("returnToUrl"+returnToUrl);
    	int posicionBarras = returnToUrl.indexOf("//");
    	int posicionModulo = returnToUrl.indexOf("/",posicionBarras); //Apartir de esta posicion nos quedaremos para montar la url de realm
    	String cadenaRealm = returnToUrl.substring(posicionModulo +1);
    	log.debug("[cadenaRealm] "+cadenaRealm);
    	try
    	{
    		realm = "http://" + this.getAgregaPropertyValue("host") + this.getAgregaPropertyValue("admin.ws.port") + cadenaRealm;
    	}catch(IOException io)
    	{
    		log.error("io "+io);
    		realm = returnToUrl;
    	}
    	if (log.isDebugEnabled())
    		log.debug("realm "+realm);
    	return beginConsumption(req, identityUrl,  returnToUrl, realm);
    }

    public String beginConsumption(HttpServletRequest req, String identityUrl, String returnToUrl, String realm)
            throws OpenIDConsumerException {
        List discoveries;
        
        try
        {
        	
        if((this.getAgregaPropertyValue(AgregaProperties.USAPROXY)).equalsIgnoreCase("true"))
        {
        	if (log.isDebugEnabled())
        		log.debug("La aplicacion necesita proxy");
        	ProxyProperties proxyProps = new ProxyProperties();
        	proxyProps.setProxyHostName(this.getAgregaPropertyValue(AgregaProperties.HOSTPROXY));
        	proxyProps.setProxyPort(new Integer(this.getAgregaPropertyValue(AgregaProperties.PORTPROXY)).intValue());
        	proxyProps.setUserName(this.getAgregaPropertyValue(AgregaProperties.USUARIOPROXY));
        	proxyProps.setPassword(this.getAgregaPropertyValue(AgregaProperties.CLAVEPROXY));
        	HttpClientFactory.setProxyProperties(proxyProps);
        }
        
        }catch(IOException ioe)
        {
        	log.error("Exception al obtener datos del proxy del fichero agrega.properties",ioe);
        }
        DiscoveryInformation discovered = null;
        try {
        	
            discoveries = consumerManager.discover(identityUrl);
            // attempt to associate with the OpenID provider
            // and retrieve one service endpoint for authentication
            discovered = consumerManager.associate(discoveries);

            
        } catch (DiscoveryException e) {
            throw new OpenIDConsumerException("Error during discovery", e);
        }

        DiscoveryInformation information = consumerManager.associate(discoveries);
        HttpSession session = req.getSession(true);
        session.setAttribute(DiscoveryInformation.class.getName(), information);

        AuthRequest authReq;

        try {
        	
        	FetchRequest fetch = FetchRequest.createFetchRequest();

        	
        	fetch.addAttribute("email", "http://axschema.org/contact/email", true);
        	


        	authReq= consumerManager.authenticate(information, returnToUrl, realm);
        	authReq.addExtension(fetch);
        	
            if (log.isDebugEnabled())
        		log.debug("Despues de añadir los atributos openid.ext1 ");
            
            if (log.isDebugEnabled())
        		log.debug("discovered.isVersion2() "+discovered.isVersion2());
                    
        } catch (MessageException e) {
            throw new OpenIDConsumerException("Error processing ConumerManager authentication", e);
        } catch (ConsumerException e) {
            throw new OpenIDConsumerException("Error processing ConumerManager authentication", e);
        } 
        log.debug("authReq.getDestinationUrl(true) "+authReq.getDestinationUrl(true));
        return authReq.getDestinationUrl(true);
    }

    public OpenIDAuthenticationToken endConsumption(HttpServletRequest request)
        throws OpenIDConsumerException {
        // extract the parameters from the authentication response
        // (which comes in as a HTTP request from the OpenID provider)
        ParameterList openidResp = new ParameterList(request.getParameterMap());
        try
        {
        if((this.getAgregaPropertyValue(AgregaProperties.USAPROXY)).equalsIgnoreCase("true"))
        {
        	if (log.isDebugEnabled())
        		log.debug("La aplicacion necesita proxy");
        	ProxyProperties proxyProps = new ProxyProperties();
        	proxyProps.setProxyHostName(this.getAgregaPropertyValue(AgregaProperties.HOSTPROXY));
        	proxyProps.setProxyPort(new Integer(this.getAgregaPropertyValue(AgregaProperties.PORTPROXY)).intValue());
        	proxyProps.setUserName(this.getAgregaPropertyValue(AgregaProperties.USUARIOPROXY));
        	proxyProps.setPassword(this.getAgregaPropertyValue(AgregaProperties.CLAVEPROXY));
        	HttpClientFactory.setProxyProperties(proxyProps);
        }
        }catch(IOException ioe)
        {
        	log.error("Exception al obtener datos del proxy del fichero agrega.properties",ioe);
        }
  
        // retrieve the previously stored discovery information
        DiscoveryInformation discovered = (DiscoveryInformation) request.getSession()
                                                                        .getAttribute(DiscoveryInformation.class.getName());

        // extract the receiving URL from the HTTP request
        StringBuffer receivingURL = request.getRequestURL();
        String queryString = request.getQueryString();

        if ((queryString != null) && (queryString.length() > 0)) {
            receivingURL.append("?").append(request.getQueryString());
        }

        // verify the response
        VerificationResult verification;

        try {
            verification = consumerManager.verify(receivingURL.toString(), openidResp, discovered);
            if (log.isDebugEnabled())
        		log.debug("verification vale  "+verification);
        } catch (MessageException e) {
            throw new OpenIDConsumerException("Error verifying openid response", e);
        } catch (DiscoveryException e) {
            throw new OpenIDConsumerException("Error verifying openid response", e);
        } catch (AssociationException e) {
            throw new OpenIDConsumerException("Error verifying openid response", e);
        }
 
        // examine the verification result and extract the verified identifier
        Identifier verified = verification.getVerifiedId();
        if (log.isDebugEnabled())
    		log.debug("verified vale  "+verified);
        
        
        if (verified != null) {
        	String signedText = "";
        	String email = "";
        	 try
             {
        	AuthSuccess authSuccess = (AuthSuccess) verification.getAuthResponse();
        	////////Saco los atributos de authSuccess //////////
        	
        	//Se comprueba si en la cadena SignedText de authSuccess nos llega el email. Sólo se tendrá en cuenta como usuario de openId
        	//si es una cuenta de correo de gmail, para el resto de proveedores (yahoo) se va a considerar la uri de openid
        	
        	signedText = authSuccess.getSignedText();
        	if (log.isDebugEnabled())
        		log.debug("[signedText ]"+signedText);
        	if(!((authSuccess.getSignedText()).indexOf("ext1.value.email:") == -1))
        	{
        		if (log.isDebugEnabled())
            		log.debug("Nos llega el email del proveedor");
        		int longitudCadenaEmail = 17; //longitud de la cadena ext1.type.email:
        		
        		email = (signedText.substring((authSuccess.getSignedText()).indexOf("ext1.value.email:")+longitudCadenaEmail)).trim();
        		if (log.isDebugEnabled())
            		log.debug("[email] "+email);
        	}
        	
        	
        	if (log.isDebugEnabled())
        		log.debug("authSuccess "+authSuccess);
        	if (log.isDebugEnabled())
        		log.debug("authSuccess.hasExtension(AxMessage.OPENID_NS_AX) "+authSuccess.hasExtension(AxMessage.OPENID_NS_AX));
        	if (log.isDebugEnabled())
        		log.debug("authSuccess.hasExtension(SRegMessage.OPENID_NS_SREG) "+authSuccess.hasExtension(SRegMessage.OPENID_NS_SREG));
        	if (authSuccess.hasExtension(AxMessage.OPENID_NS_AX))
        	{
        	    MessageExtension ext = authSuccess.getExtension(AxMessage.OPENID_NS_AX);

        	    if (ext instanceof FetchResponse)
        	    {
        	    	if (log.isDebugEnabled())
                		log.debug("ext instanceof FetchResponse");
        	        FetchResponse fetchResp = (FetchResponse) ext;
        	        if (log.isDebugEnabled())
                		log.debug("fetchResp "+fetchResp);
        	      
        	        // can have multiple values
        	        List emails = fetchResp.getAttributeValues("Email");
        	        if (log.isDebugEnabled())
                		log.debug("[emails ]"+emails);
        	    }
        	    else 
        	    {
        	    	if (log.isDebugEnabled())
                		log.debug("No es  instance of FetchResponse");
        	    }
        	}
        
             }catch(Exception e)
             {
             	log.error("Se produce una exception "+e);
             }
             //Sólo se considera el email cuando el proveedor es gmail
             if(!(email.indexOf("gmail") == -1))
             {
            	 return new OpenIDAuthenticationToken(OpenIDAuthenticationStatus.SUCCESS, email,"some message"); 
             }else
             {
            	 return new OpenIDAuthenticationToken(OpenIDAuthenticationStatus.SUCCESS, verified.getIdentifier(),"some message");
             }
    
        } else {
        	if(discovered == null)
        	{
        		return new OpenIDAuthenticationToken(OpenIDAuthenticationStatus.FAILURE,
                        "", "Discovered information verification failed ");
        	}else
        	{
        		return new OpenIDAuthenticationToken(OpenIDAuthenticationStatus.FAILURE,
                        discovered.getClaimedIdentifier().getIdentifier(),
                        "Verification status message: [" + verification.getStatusMsg() + "]");
        	}
            
        }
    }
    
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
}
