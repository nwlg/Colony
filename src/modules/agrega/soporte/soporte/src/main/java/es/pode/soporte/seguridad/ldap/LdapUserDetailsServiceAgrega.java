/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.seguridad.ldap;

import org.acegisecurity.ldap.LdapUserSearch;
import org.acegisecurity.providers.ldap.LdapAuthenticationProvider;
import org.acegisecurity.providers.ldap.LdapAuthoritiesPopulator;
import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UserDetailsService;
import org.acegisecurity.userdetails.ldap.LdapUserDetailsImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

public class LdapUserDetailsServiceAgrega implements UserDetailsService, InitializingBean{
 
	private static final Logger logger = Logger.getLogger(LdapAuthenticationProvider.class);
	
	public LdapUserSearch getLdapUserSearch()
    {
        return ldapUserSearch;
    }

    public void setLdapUserSearch(LdapUserSearch ldapUserSearch)
    {
        this.ldapUserSearch = ldapUserSearch;
    }

    public LdapAuthoritiesPopulator getPopulator()
    {
        return populator;
    }

    public void setPopulator(LdapAuthoritiesPopulator populator)
    {
        this.populator = populator;
    }

    /**
     * Este metodo se sobreescribe para devolver el user details personalizado.
     * El nuevo user details va a contener la siguiente informacion adicional:
     * -mail.
     * -idioma búsqueda
     * -idioma. 
     * -nombreCompleto
     * -tipo de empaquetador
     * -login del usuario
     * 
     * @param username string con el nombre del usuario
     * @return ud UserDetails con los detalles del usuario
     * */
    public UserDetails loadUserByUsername(String username) 
    {
    	username = username.toLowerCase();
    	log("Carga del usuario a partir del login " + username);
        LdapUserDetailsImpl ldapUser = (LdapUserDetailsImpl)ldapUserSearch.searchForUser(username);
        
        if(ldapUser == null)
        {
            return null;
        } 
        else
        {
        	log("Usuario LDAP " + ldapUser);
        	es.pode.soporte.seguridad.ldap.LdapUserDetailsAgrega.Essence user = new es.pode.soporte.seguridad.ldap.LdapUserDetailsAgrega.Essence(ldapUser);
        	log("Usuario Essence " + user);        	
            org.acegisecurity.GrantedAuthority authorities[] = populator.getGrantedAuthorities(ldapUser);            
            user.setAuthorities(authorities,user.instance.getUsername(),user.instance.getPassword());
            UserDetails ud = user.createUserDetails();
            log("Detalles del usuario " + ud);        	
            return ud;
        }
    }

    public void afterPropertiesSet()
        throws Exception
    {
        Assert.notNull(populator);
        Assert.notNull(ldapUserSearch);
    }

    private LdapAuthoritiesPopulator populator;
    private LdapUserSearch ldapUserSearch;
    
	private static void log (Object obj)
	{
		if (logger.isDebugEnabled())
			logger.debug(obj);
	}
}
