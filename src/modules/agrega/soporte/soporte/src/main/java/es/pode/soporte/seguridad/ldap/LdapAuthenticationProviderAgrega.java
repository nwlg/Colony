/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.seguridad.ldap;

import org.acegisecurity.AuthenticationException;
import org.acegisecurity.AuthenticationServiceException;
import org.acegisecurity.BadCredentialsException;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.acegisecurity.providers.dao.AbstractUserDetailsAuthenticationProvider;
import org.acegisecurity.providers.ldap.LdapAuthenticationProvider;
import org.acegisecurity.providers.ldap.LdapAuthenticator;
import org.acegisecurity.providers.ldap.LdapAuthoritiesPopulator;
import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.ldap.LdapUserDetails;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.util.StringUtils;

/**
 * 
 * Esta clase supone una modificacion de LdapAuthenticationProvider de acegi, para que se construya 
 * el user details personalizado de Agrega
 * 
 * */
public class LdapAuthenticationProviderAgrega extends AbstractUserDetailsAuthenticationProvider {

    //~ Static fields/initializers =====================================================================================

    private static final Logger logger = Logger.getLogger(LdapAuthenticationProvider.class);

    //~ Instance fields ================================================================================================

    private LdapAuthenticator authenticator;
    private LdapAuthoritiesPopulator authoritiesPopulator;

    //~ Constructors ===================================================================================================

    public LdapAuthenticationProviderAgrega(LdapAuthenticator authenticator, LdapAuthoritiesPopulator authoritiesPopulator) {
        log("authenticator: " + authenticator);
        log("authoritiesPopulator: " + authoritiesPopulator);

        this.authenticator = authenticator;
        this.authoritiesPopulator = authoritiesPopulator;
    }

    //~ Methods ========================================================================================================

    protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                  UsernamePasswordAuthenticationToken authentication)
        throws AuthenticationException {
    	log("additionalAuthenticationChecks UserDetails: " + userDetails + " UsernamePasswordAuthenticationToken: " + authentication);
        if (!userDetails.getPassword().equals(authentication.getCredentials().toString())) {
            throw new BadCredentialsException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"), userDetails);
        }
    }

    /**
     * Creates the final <tt>UserDetails</tt> object that will be returned by the provider once the user has
     * been authenticated.<p>The <tt>LdapAuthoritiesPopulator</tt> will be used to create the granted
     * authorites for the user.</p>
     *  <p>Can be overridden to customize the creation of the final UserDetails instance. The default will
     * merge any additional authorities retrieved from the populator with the propertis of original <tt>ldapUser</tt>
     * object and set the values of the username and password.</p>
     *
     * @param ldapUser The intermediate LdapUserDetails instance returned by the authenticator.
     * @param username the username submitted to the provider
     * @param password the password submitted to the provider
     *
     * @return The UserDetails for the successfully authenticated user.
     */
    protected UserDetails createUserDetails(LdapUserDetails ldapUser, String username, String password) {
    	
    	username = username.toLowerCase();
    	es.pode.soporte.seguridad.ldap.LdapUserDetailsAgrega.Essence user = new es.pode.soporte.seguridad.ldap.LdapUserDetailsAgrega.Essence(ldapUser);
    	log("Creción del Essence del user " + user);
        org.acegisecurity.GrantedAuthority authorities[] = authoritiesPopulator.getGrantedAuthorities(ldapUser);
        log("Autorizaciones " + authorities);
        user.setUsername(username);
        user.setPassword(password);        
        user.setAuthorities(authorities,user.instance.getUsername(),user.instance.getPassword());
        UserDetails ud = user.createUserDetails();
        log("UserDetail creado " + ud);
        return ud;   	

    }

    protected LdapAuthoritiesPopulator getAuthoritiesPoulator() {
    	log("getAuthoritiesPoulator: " + authoritiesPopulator);
        return authoritiesPopulator;
    }

    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
        throws AuthenticationException {
        if (!StringUtils.hasLength(username)) {
            throw new BadCredentialsException(messages.getMessage("LdapAuthenticationProvider.emptyUsername",
                    "Empty Username"));
        }

        log("Recuperando el usuario " + username);
        
        String password = (String) authentication.getCredentials();        
 
        if (password.length() == 0) {
            	log("Rechazo de clave vacia para el usuario " + username);
            throw new BadCredentialsException(messages.getMessage("LdapAuthenticationProvider.emptyPassword",
                    "Empty Password"));
        }

        try {
            LdapUserDetails ldapUser = authenticator.authenticate(username, password);
            log("Usuario LDAP " + ldapUser);
            return createUserDetails(ldapUser, username, password);
        } 
        catch (DataAccessException ldapAccessFailure) {
            throw new AuthenticationServiceException(ldapAccessFailure.getMessage(), ldapAccessFailure);
        }
    }
    
	private static void log (Object obj)
	{
		if (logger.isDebugEnabled())
			logger.debug(obj);
	}
}
