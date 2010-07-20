package uk.co.siriusit.axis.handler;

import org.acegisecurity.Authentication;
import org.acegisecurity.context.SecurityContextHolder;
import org.apache.axis.AxisFault;
import org.apache.axis.MessageContext;
import org.apache.axis.handlers.BasicHandler;

import uk.co.siriusit.acegi.shibboleth.ShibbolethAuthenticationToken;
import uk.co.siriusit.acegi.shibboleth.ShibbolethPassThroughAuthenticationProvider;

public class ShibbolethUserSender extends BasicHandler {

	private static final long serialVersionUID = 1L;

	public ShibbolethUserSender() {
		super();
	}

	@Override
	public void invoke(MessageContext msgContext) throws AxisFault {
		if(msgContext.isClient()) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null && auth.isAuthenticated()) {
				if (auth instanceof ShibbolethAuthenticationToken ||
					credentialsMatchPassThroughToken(auth.getCredentials())) {
					msgContext.setUsername(auth.getName());
					msgContext.setPassword(ShibbolethPassThroughAuthenticationProvider.PASS_THROUGH_AUTH_TOKEN);
				}
			}
		}
	}

	private boolean credentialsMatchPassThroughToken(Object credentials) {
		if (credentials == null) {
			return false;
		} else {
			return ShibbolethPassThroughAuthenticationProvider.
				PASS_THROUGH_AUTH_TOKEN.equals(credentials.toString());
		}
	}

}
