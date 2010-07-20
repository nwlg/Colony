<%@ include file="/taglib-imports.jspf" %>

<%@ page import="org.acegisecurity.ui.AbstractProcessingFilter" %>
<%@ page import="org.acegisecurity.AuthenticationException" %>

<html>
  <head>
    <title>Login to CAS failed!</title>
  </head>

  <body>
    <h1>Login to CAS failed!</h1>

      <font color="red">
        Your CAS credentials were rejected.<BR><BR>
        Reason: <%= ((AuthenticationException) session.getAttribute(AbstractProcessingFilter.ACEGI_SECURITY_LAST_EXCEPTION_KEY)).getMessage() %>
      </font>

  </body>
</html>
