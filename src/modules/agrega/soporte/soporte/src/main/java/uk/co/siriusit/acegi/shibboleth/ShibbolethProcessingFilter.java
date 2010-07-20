package uk.co.siriusit.acegi.shibboleth;

import javax.servlet.http.HttpServletRequest;

import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationCredentialsNotFoundException;
import org.acegisecurity.AuthenticationException;
import org.acegisecurity.ui.AbstractProcessingFilter;

import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;

public class ShibbolethProcessingFilter extends AbstractProcessingFilter {

	protected static final String SHIBBOLETH_SESSION_ID_ATTR = "Shib-Session-ID";
	protected static final String SHIBBOLETH_USERNAME_ATTR = "uid";
	protected static final String SHIBBOLETH_FIRST_NAME_ATTR = "givenName";
	protected static final String SHIBBOLETH_LAST_NAME_ATTR = "sn";
	protected static final String SHIBBOLETH_EMAIL_ATTR = "mail";
	//protected static final String SHIBBOLETH_QUOTA_ATTR = "quota";
	protected static final String SHIBBOLETH_TARGETED_ID_ATTR = "persistent-id";
	protected static final String SHIBBOLETH_NDRB_ENTITLEMENT_ATTR = "entitlement";

	protected static String shibbolethDefaultEmail;
	protected static String defaultQuota;

	public ShibbolethProcessingFilter() {
		// Grab the default email address and default quota from agrega.properties
		AgregaProperties properties = AgregaPropertiesImpl.getInstance();
		shibbolethDefaultEmail = properties.getProperty("shibbolethDefaultEmail");
		defaultQuota = properties.getProperty("valorCuotaDefecto");
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request)
			throws AuthenticationException {
		Object sessId = request.getAttribute(SHIBBOLETH_SESSION_ID_ATTR);
		Object userId = request.getAttribute(SHIBBOLETH_USERNAME_ATTR);
		Object firstName = request.getAttribute(SHIBBOLETH_FIRST_NAME_ATTR);
		Object lastName = request.getAttribute(SHIBBOLETH_LAST_NAME_ATTR);
		Object name = firstName + " " + lastName;
		Object email = request.getAttribute(SHIBBOLETH_EMAIL_ATTR);
		Object quota = new Long(defaultQuota) * 1024L * 1024L; //request.getAttribute(SHIBBOLETH_QUOTA_ATTR);
		Object targetedId = request.getAttribute(SHIBBOLETH_TARGETED_ID_ATTR);
                Object entitlement = request.getAttribute(SHIBBOLETH_NDRB_ENTITLEMENT_ATTR);
		// TODO: Object permissions = request.getAttribute(SHIBBOLETH_NDRB_PERMISSIONS_ATTR);

                // Currently email addresses are required in the database, but may not necessarily be
                // stored by LDAP (think of primary schools where there may only be one email address
                // per class/year group). Hence if one has not been supplied, we auto-generate one.
                if (email == null) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("NOTE: E-mail address has not been supplied by IDP; using the default (" + shibbolethDefaultEmail + ")");
                    }
		    email = shibbolethDefaultEmail;
                }

                // Log what we *did* get from Shibboleth for debugging purposes
                if(logger.isDebugEnabled()) {
		    logger.debug("Checking for Shibboleth authentication; got the following attributes:");
                    logger.debug("Session ID: " + sessId);
                    logger.debug("User ID: " + userId);
                    logger.debug("Name: " + name);
                    logger.debug("Email: " + email);
                    logger.debug("Targeted (persistent) ID: " + targetedId);
                    logger.debug("Entitlement: " + entitlement);
                }

		if(sessId == null || userId == null || name == null || firstName == null || lastName == null || quota == null || targetedId == null)
			throw new AuthenticationCredentialsNotFoundException("Could not find Shibboleth authentication headers");
		
		return new ShibbolethAuthenticationToken(sessId.toString(), userId.toString(), name.toString(), firstName.toString(), lastName.toString(), email.toString(), quota.toString(), targetedId.toString());
	}

	@Override
	public String getDefaultFilterProcessesUrl() {
		return "/j_acegi_shibboleth_security_check";
	}

}
