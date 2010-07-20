<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html 
	PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
	"DTD/xhtml1-strict.dtd">
	<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
	<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
	
	<jsp:useBean id="requestURL" scope="request" class="java.lang.String"/>
	<jsp:useBean id="errorText" scope="request" class="java.lang.String"/>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<link rel="stylesheet" type="text/css" href="main.css" />
	<title>Access System Failure</title>
</head>

<body>
<div class="head">
<img src="images/logo.jpg" alt="Logo" />
<h1>Inter-institutional Access System Failure</h1>
</div>

<p>The inter-institutional access system experienced a technical failure.</p>

<p>Please email <a href="mailto:user@domain"> administrator's name</a> and include the following error message:</p>

<logic:notEmpty name="requestURL">
<p class="error">WAYF failure at (<bean:write name="requestURL" />)</p>

<p><bean:write name="errorText" /></p>
</logic:notEmpty>
<logic:empty name="requestURL">
<p class="error">The DiscoveryService should not be called directly</p>
</logic:empty>


</body>
</html>