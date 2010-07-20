<%@ page import="edu.internet2.middleware.shibboleth.idp.authn.LoginContext" %>
<%@ page import="edu.internet2.middleware.shibboleth.idp.session.*" %>
<%@ page import="edu.internet2.middleware.shibboleth.idp.util.HttpServletHelper" %>
<%@ page import="org.opensaml.saml2.metadata.*" %>

<%
    LoginContext loginContext = HttpServletHelper.getLoginContext(HttpServletHelper.getStorageService(application),
                                                                  application, request);
                                                                  
    EntityDescriptor entityDescriptor = HttpServletHelper.getRelyingPartyMetadata(loginContext.getRelyingPartyId(),
                                                   HttpServletHelper.getRelyingPartyConfirmationManager(application)); 
                                                    
    Session userSession = HttpServletHelper.getUserSession(request);
%>

<jsp:include page="header.jsp" />

<!-- Debug info
Existing Session: <%= userSession != null %>
Requested Authentication Methods: <%= loginContext.getRequestedAuthenticationMethods() %>
Attempting Authentication Method: <%= loginContext.getAttemptedAuthnMethod() %>
Is Forced Authentication: <%= loginContext.isForceAuthRequired() %>
-->

<!-- Contents -->

<div id="content">

	<h1>Shibboleth Identity Provider</h1>

	<div id="border">

		<% if ("true".equals(request.getAttribute("loginFailed"))) { %>
			<p><font color="red">Authentication Failed</font></p>
		<% } %>
	
		<% if(request.getAttribute("actionUrl") != null){ %>
			<form action="<%=request.getAttribute("actionUrl")%>" method="post">
		<% }else{ %>
			<form action="j_security_check" method="post">
		<% } %>

		<table width="100%">
			<tbody><tr>
				<td align="right" width="30%">Username:</td>
				<td width="70%"><input name="j_username" type="text" tabindex="1" /></td>
			</tr>

			<tr>
				<td align="right">Password:</td>
				<td><input name="j_password" type="password" tabindex="2" /></td>
			</tr>
			</tbody>
		</table>

		<p></p><center><input value="Login" class="button" type="submit" tabindex="3" /></center><p></p>

	</div>
</div>
        
<!-- Contents ends -->

<jsp:include page="footer.jsp" />
