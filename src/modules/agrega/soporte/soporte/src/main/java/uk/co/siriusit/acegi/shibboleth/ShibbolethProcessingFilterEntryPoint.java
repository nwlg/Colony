package uk.co.siriusit.acegi.shibboleth;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.AuthenticationException;
import org.acegisecurity.ui.AuthenticationEntryPoint;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

public class ShibbolethProcessingFilterEntryPoint implements
		AuthenticationEntryPoint, InitializingBean {

	private java.util.Properties pSpringProperties = null;
    private String loginHost;
    private String loginPath;

    @Override
	public void commence(ServletRequest servletRequest, ServletResponse servletResponse,
			AuthenticationException authException) throws IOException,
			ServletException {
    	
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final HttpServletRequest request = (HttpServletRequest) servletRequest;

        response.sendRedirect(this.loginHost + request.getContextPath() + this.loginPath);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO currently forced override to avoid needing to edit all the config files! if(this.loginHost == null)
			this.loginHost = getPropertyValue("http.server");
		
        Assert.hasLength(this.loginHost, "loginHost must be specified");
        Assert.hasLength(this.loginPath, "loginPath must be specified");
	}

	public void setLoginHost(String loginHost) {
		this.loginHost = loginHost;
	}
	
	public void setLoginPath(String loginPath) {
		this.loginPath = loginPath;
	}
	
	private String getPropertyValue(String sKey) throws IOException {
    	
		if (this.pSpringProperties == null) {
			InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/authbackend.properties");
		    pSpringProperties = new java.util.Properties();
		    pSpringProperties.load(fIsSpringProperties);
		}
		
		return pSpringProperties.getProperty(sKey);
	}
}
