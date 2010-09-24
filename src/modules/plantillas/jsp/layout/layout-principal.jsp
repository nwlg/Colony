<?xml version="1.0" encoding="iso-8859-1" ?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">
<%@ include file="/taglib-imports.jspf" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tags/serverProperties.tld" prefix="server" %>
<%@ taglib uri="/WEB-INF/tags/link.tld" prefix="link" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<%@ taglib uri="/WEB-INF/tags/agregaProperties.tld" prefix="agrega" %>

<%@ page import="es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils" %>

<head lang="en" dir="ltr">

<title>
	<tiles:insert attribute="title" flush="true"/>
</title>
<link rel="search" type="application/opensearchdescription+xml" title="NDRB" href="<rewrite:rewrite url="searchPlugin/searchPlugin.xml"/>"/>
<link rel="shortcut icon" href="<rewrite:rewrite url="static/img/favicon.ico"/>" />
  <link rel="stylesheet" media="screen" href="<rewrite:rewrite url="static/css/red.css"/>" type="text/css" />
      <!--[if IE 6]>
      <link rel="stylesheet" media="screen" href="<rewrite:rewrite url="static/css/ie6compat.css"/>" type="text/css" />
      <![endif]-->
      <script type="text/javascript" src="<rewrite:rewrite url="static/js/plantilla.js"/>"></script>
      <script type="text/javascript" src="<rewrite:rewrite url="static/js/mootools.js"/>"></script>
	  <script type="text/javascript" src="<rewrite:rewrite url="static/js/calendar.rc4.js"/>"></script>

</head>

<body>

<!--  CAPA QUE CONTIENE TODAS LAS DEMAS  -->
<!--  INICIO CAPA MADRE   -->
<div id="capa_madre">
<!--  INICIO CUERPO GENERAL   -->
<div id="cuerpo">
<div class="minwidth">
<div class="contenido_general">

	<!-- AÑADIR MOTOR DE BUSQUEDA -->
	<tiles:insert attribute="motorBusqueda" flush="true"/>	

<!-- Aqui va la cabecera -->


<!-- NDRB logo header -->
<div id="cabecera" class="heading_text">
<a href="http://<agrega:agregaProperties property="host"/>">
<div class="cabecera_logo">
</div>
</a>

<%-- 08/09/2010 Fernando Garcia --%>
<%-- 		new block only appears if user didn't log in --%>
<%
		if(!LdapUserDetailsUtils.estaAutenticado()){
%>
<a href='<bean:message key="cabecera.joinnowbutton.url"/>'>
<div class="cabecera_button">
		<img src="/static/img/joinnowbutton.png" />
</div>
</a>
<%
		}
%>
<%-- 08/09/2010 Fernando Garcia --%>
<%-- 		End of new block --%>


<div class="cabecera_text">
national digital resource bank
</div>
</div>

<!-- Header bar (menu bar underneath logo) -->
<div class="header_bar">

<!-- Insert the definition of the RHS status (current indicates users/objects on front page) -->
<tiles:insert attribute="menu.cabacera.top.rhs" flush="true"/>

<!-- Menu/User options set by each page -->
<div style="margin: 4px 4px;">
<tiles:insert definition="menu.cabecera.metanavegacion" flush="true"/>
</div>

<!-- End of header bar -->
</div>


<!-- MCA: THIS WILL GO SOON!
<div id="cabecera">
<h1>
	<span>
		<server:serverProperties property="ccaa"/>
	</span>
</h1>
</div>

-->

<!-- Inicio cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->
<div class="tronco_de_contenido">

<!-- Full-width container for everything below the header -->
<div class="full_body">

<!-- Menu de cabecera -->
<tiles:insert attribute="menu-principal" flush="true"/>
<!-- Fin cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->

<!-- Menu lateral -->
<tiles:insert attribute="menu-lateral" flush="true"/>

<!-- Right column -->
<tiles:insert attribute="menu-rhs" flush="true"/>
<!-- End of right column -->

<!-- Inicio Contenido ESPECÍFICO  -->
<div id="contenido_central" style="border: 1px none red;">
<tiles:insert attribute="body" flush="true"/>
</div>

<!-- Pie de pagina -->
<tiles:insert attribute="pie" flush="true"/>


</div>
<!-- End of full body container -->

</div>
</div>
</div>
<!--  FIN CUERPO GENERAL   -->

</div>
<!--  FIN CAPA MADRE   -->
</body>
</html>
