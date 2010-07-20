package uk.co.siriusit.acegi.shibboleth;

import org.acegisecurity.AcegiMessageSource;
import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationException;
import org.acegisecurity.BadCredentialsException;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.providers.AuthenticationProvider;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.util.Assert;

import es.pode.soporte.seguridad.ldap.LdapUserDetailsAgrega;
import es.pode.soporte.seguridad.ldap.WrapperSrvAdminUsuarios;
import es.pode.soporte.seguridad.servicios.UsuarioVO;

public class ShibbolethPassThroughAuthenticationProvider implements AuthenticationProvider, InitializingBean, MessageSourceAware {

    private static final Log logger = LogFactory.getLog(ShibbolethAuthenticationProvider.class);
	
	protected MessageSourceAccessor messages = AcegiMessageSource.getAccessor();
    protected boolean hideUserNotFoundExceptions = true;
    
    public static final String PASS_THROUGH_AUTH_TOKEN = "ier6Eihaish4jahDaile";

    @Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		
        Assert.isInstanceOf(UsernamePasswordAuthenticationToken.class, authentication,
        		messages.getMessage("ShibbolethPassThroughAuthenticationProvider.onlySupports", "For the WS pass-through auth only UsernamePasswordToken is supported"));

        logger.debug("Authenticating with a pass-through details from Shibboleth...");
        
        if(!authentication.getCredentials().equals(PASS_THROUGH_AUTH_TOKEN)) {
        	logger.debug("Credentials are wrong for pass-through, we're ignoring this one");
        	return null;
        }
        
        String username = authentication.getName();

        UserDetails user = null;

        try {
            user = retrieveUser(username, (UsernamePasswordAuthenticationToken) authentication);
        }
        catch (UsernameNotFoundException notFound) {
            if (hideUserNotFoundExceptions) {
                throw new BadCredentialsException(messages.getMessage(
                        "ShibbolethPassThroughAuthenticationProvider.badCredentials", "Bad credentials"));
            } else {
                throw notFound;
            }
        }

        Assert.notNull(user, "retrieveUser returned null - a violation of the interface contract");
/* TODO
        if (!user.isAccountNonLocked()) {
            throw new LockedException(messages.getMessage("ShibbolethAuthenticationProvider.locked",
                    "User account is locked"));
        }

        if (!user.isEnabled()) {
            throw new DisabledException(messages.getMessage("ShibbolethAuthenticationProvider.disabled",
                    "User is disabled"));
        }

        if (!user.isAccountNonExpired()) {
            throw new AccountExpiredException(messages.getMessage("ShibbolethAuthenticationProvider.expired",
                    "User account has expired"));
        }

        if (!user.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(messages.getMessage(
                    "ShibbolethAuthenticationProvider.credentialsExpired", "User credentials have expired"));
        }
*/
        return createSuccessAuthentication(username, authentication, user);
	}

    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    	
		UsuarioVO usuario = null;

		try {
			logger.debug("Requesting user details from admin web service");

			usuario = WrapperSrvAdminUsuarios.obtenerDatosUsuario(username);
		} catch (Exception e) {
			throw new UsernameNotFoundException(messages.getMessage(
					"ShibbolethAuthenticationProvider.notFound",
					"Username not found"));
		}

		if(usuario == null)
			throw new UsernameNotFoundException(messages.getMessage(
					"ShibbolethAuthenticationProvider.notFound",
					"Username not found"));
		
		logger.debug("Retrieved user [" + usuario + "]");

		LdapUserDetailsAgrega.Essence user = new LdapUserDetailsAgrega.Essence();
		user.setUsername(usuario.getUsuario());
		user.setDatosUsuario(usuario.getUsuario());

		GrantedAuthority permisosAnadir[] = new GrantedAuthority[1];
		permisosAnadir[0] = new GrantedAuthorityImpl("ANONYMOUS");

		GrantedAuthority permisosUsuario[] = null;
		permisosUsuario = WrapperSrvAdminUsuarios.obtenerAnadirRoles(
				permisosAnadir, usuario.getUsuario(), null);

		user.setAuthorities(permisosUsuario, usuario.getUsuario(), null);
		if (logger.isDebugEnabled())
			logger.debug("permisosUsuario " + permisosUsuario);

		return user.createUserDetails();
    }
	
    protected Authentication createSuccessAuthentication(String principal, Authentication authentication, UserDetails user) {
        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(user, PASS_THROUGH_AUTH_TOKEN, user.getAuthorities());
        result.setDetails(user);

        return result;
    }
	
	@Override
	public boolean supports(Class authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

	@Override
	public void afterPropertiesSet() throws Exception {
        Assert.notNull(this.messages, "A message source must be set");
	}

    @Override
	public void setMessageSource(MessageSource messageSource) {
		messages = new MessageSourceAccessor(messageSource);
	}

	public void setHideUserNotFoundExceptions(boolean hideUserNotFoundExceptions) {
		this.hideUserNotFoundExceptions = hideUserNotFoundExceptions;
	}

}
