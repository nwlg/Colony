package uk.co.siriusit.acegi.shibboleth;

import java.util.Calendar;

import org.acegisecurity.AcegiMessageSource;
import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationException;
import org.acegisecurity.BadCredentialsException;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.providers.AuthenticationProvider;
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
import es.pode.soporte.seguridad.servicios.GrupoVO;
import es.pode.soporte.seguridad.servicios.SrvAdminUsuariosService;
import es.pode.soporte.seguridad.servicios.SrvAdminUsuariosServiceService;
import es.pode.soporte.seguridad.servicios.SrvAdminUsuariosServiceServiceLocator;
import es.pode.soporte.seguridad.servicios.UsuarioVO;

public class ShibbolethAuthenticationProvider implements AuthenticationProvider, InitializingBean, MessageSourceAware {

    private static final Log logger = LogFactory.getLog(ShibbolethAuthenticationProvider.class);
    private static final String BASIC_GROUP_NAME = "basic";
    protected MessageSourceAccessor messages = AcegiMessageSource.getAccessor();
    protected boolean hideUserNotFoundExceptions = true;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        Assert.isInstanceOf(ShibbolethAuthenticationToken.class, authentication,
                messages.getMessage("ShibbolethAuthenticationProvider.onlySupports", "Only ShibbolethAuthenticationToken is supported"));

        logger.debug("Authenticating with a Shibboleth Token...");

        String username = authentication.getName();

        UserDetails user = null;

        try {
            user = retrieveUser(username, (ShibbolethAuthenticationToken) authentication);
        } catch (UsernameNotFoundException notFound) {
            if (hideUserNotFoundExceptions) {
                throw new BadCredentialsException(messages.getMessage(
                        "ShibbolethAuthenticationProvider.badCredentials", "Bad credentials"));
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
        Authentication sAuth = createSuccessAuthentication(user.getUsername(), authentication, user);
        logger.debug("Passing back successful authentication [" + sAuth + "]");
        return sAuth;
    }

    protected UserDetails retrieveUser(String username, ShibbolethAuthenticationToken authentication) throws AuthenticationException {
        Util      util    = new Util();
        UsuarioVO usuario = null;

        try {
            logger.debug("Requesting user details from admin web service");

            //
            // User IDs are not guaranteed to be unique across IdPs; compare the
            // Shibboleth persistent-id with the Agrega open-id-url field to
            // perform user lookup.
            //
            logger.debug("Looking up '" + username + "' with persistent-id:" +
                        authentication.getTargetedId());
            usuario = util.getSrvAdminUsuariosService().obtenerUsuarioConOpenId(
                        authentication.getTargetedId());

        } catch (Exception e) {
            logger.debug("We failed to find the requested user, but we can still try auto-creating them");
        }

        if (usuario == null) {
            try {
                SrvAdminUsuariosService srvAdminUsuariosService = util.getSrvAdminUsuariosService();

                GrupoVO[] groupList = srvAdminUsuariosService.listarGrupos();
                GrupoVO basicGroup = null;
                for(GrupoVO g: groupList) {
                    if(g.getDescripcion().equals(BASIC_GROUP_NAME))
                        basicGroup = g;
                }
                String usuarioId = util.generateUsuario(
                    authentication.getTargetedId(), "UTF-8");

                // user not found, so we need to create one!
                UsuarioVO user = new UsuarioVO(null, authentication.getFirstName(), authentication.getLastName(), "" /* second surname -- not available, do not pass a null reference as agrega will display that as a "null" string */, authentication.getEmail(), null /* nif */, usuarioId, null /* password */, "en", "en", "basico", Calendar.getInstance(), null, null, null /* encrypted password */, null, "basicplus", authentication.getQuota(), authentication.getTargetedId(), new GrupoVO[] { basicGroup }, null);

                Long userId = srvAdminUsuariosService.altaUsuario(user, user);
                if (userId == null) {
                    throw new UsernameNotFoundException(messages.getMessage(
                            "ShibbolethAuthenticationProvider.notFound",
                            "Username not found"));
                }

                usuario = WrapperSrvAdminUsuarios.obtenerDatosUsuario(usuarioId);

            } catch (Exception e) {
                logger.error("Exception occurred while creating a new user " +
                             "[" + authentication + "]", e);
                throw new UsernameNotFoundException(messages.getMessage(
                        "ShibbolethAuthenticationProvider.notFound",
                        "Username not found"));
            }
        }

        logger.debug("Retrieved user [" + usuario + "]");

        LdapUserDetailsAgrega.Essence user = new LdapUserDetailsAgrega.Essence();
        user.setUsername(usuario.getUsuario());
        user.setDatosUsuario(usuario.getUsuario());

        GrantedAuthority permisosAnadir[] = new GrantedAuthority[2];
        permisosAnadir[0] = new GrantedAuthorityImpl("ANONYMOUS");
        // This shouldn't be needed as we setup new users in the "basic" group, but I've not tested without it yet...
        permisosAnadir[1] = new GrantedAuthorityImpl("DEMOUSER");

        GrantedAuthority permisosUsuario[] = null;
        permisosUsuario = WrapperSrvAdminUsuarios.obtenerAnadirRoles(
                permisosAnadir, usuario.getUsuario(), null);

        user.setAuthorities(permisosUsuario, usuario.getUsuario(), null);
        logger.debug("permisosUsuario " + permisosUsuario);

        return user.createUserDetails();
    }

    protected Authentication createSuccessAuthentication(String principal, Authentication authentication, UserDetails user) {
        ShibbolethAuthenticationToken result = new ShibbolethAuthenticationToken(principal, user.getAuthorities());
        result.setDetails(user);

        return result;
    }

    @Override
    public boolean supports(Class authentication) {
        return (ShibbolethAuthenticationToken.class.isAssignableFrom(authentication));
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
