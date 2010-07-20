package uk.co.siriusit.acegi.shibboleth;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.providers.AbstractAuthenticationToken;

public class ShibbolethAuthenticationToken extends AbstractAuthenticationToken {

	private static final long serialVersionUID = 1L;
	private String shibSession;
	private String username;
	private String displayName;
	private String firstName;
	private String lastName;
	private String email;
	private Long quota;
	private String targetedId;

	public ShibbolethAuthenticationToken(String shibSession, String username, String displayName, String firstName, String lastName, String email, String quota, String targetedId) {
        super(null);

		this.shibSession = shibSession;
		this.username = username;
		this.displayName = displayName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.quota = Long.parseLong(quota);
		this.targetedId = targetedId;
	}
	
	/**
	 * Creates an authenticated Token with the provided GrantedAuthorities
	 * 
	 * @param shibSession
	 * @param username
	 * @param authorities
	 */
	public ShibbolethAuthenticationToken(String username, GrantedAuthority[] authorities) {
		super(authorities);
		
		this.username = username;
		
		this.setAuthenticated(true);
	}

	@Override
	public Object getCredentials() {
		return null;  // We never get to see these
	}

	@Override
	public Object getPrincipal() {
		/* TODO
		 * Acegi allows for this to return a UserDetails, but if it does, then that UserDetails is the truth.  When this token
		 * is unauthenticated, we don't have a UserDetails yet, so treating it as the truth is a BadThing.
		 * This could be solved by fixing Agrega to use getDetails() when it wants UserDetails and getPrincipal when it wants 
		 * a username (like the Acegi docs suggest).  But as changing this code is simpler for now, we'll try to cope with both 
		 * cases here.
		 */
		Object userDetails = getDetails();
		return userDetails == null ? username : userDetails;
	}

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getQuota() {
        return quota;
    }

    public String getTargetedId() {
        return targetedId;
    }

    public String getDisplayName() {
        return displayName;
    }

}
