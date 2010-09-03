<?xml version="1.0" encoding="iso-8859-1" ?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">

<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tags/serverProperties.tld" prefix="server" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<%@ taglib uri="/WEB-INF/tags/agregaProperties.tld" prefix="agrega" %>

<%@ page import="es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils" %>

<head lang="es" dir="ltr">

<title>
	<tiles:insert attribute="title" flush="true"/>
</title>
<link rel="search" type="application/opensearchdescription+xml" title="NDRB" href="<rewrite:rewrite url="searchPlugin/searchPlugin.xml"/>">
<link rel="shortcut icon" href="<rewrite:rewrite url="static/img/favicon.ico"/>"/>
<link rel="stylesheet" media="screen" href="<rewrite:rewrite url="static/css/red.css"/>" type="text/css" />
<script type="text/javascript" src="<rewrite:rewrite url="static/js/plantilla.js"/>"></script>

<style type="text/css">
.plantilla_contenido {height:auto !important;height:30em}
#capa_madre {max-width:1024px !important;}
</style>


</head>

<body>

<!--  CAPA QUE CONTIENE TODAS LAS DEMAS  -->
<!--  INICIO CAPA MADRE   -->
<div id="capa_madre">
<!--  INICIO CUERPO GENERAL   -->

<div class="minwidth">
<div class="contenido_general">

<!-- NDRB logo header -->
<div id="cabecera" class="heading_text">
<a href="http://<agrega:agregaProperties property="host"/>">
<div class="cabecera_logo">
</div>
</a>

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


<div class="cabecera_text">
national digital resource bank
</div>
</div>

<!-- Header bar (menu bar underneath logo) -->
<div class="header_bar">

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

<!-- Menu de cabecera -->
<tiles:insert attribute="menu-principal" flush="true"/>
<!-- Inicio Contenido ESPECÍFICO  -->

<tiles:insert attribute="body" flush="true"/>


<!-- Fin cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->

<!-- Pie de pagina -->
<tiles:insert attribute="pie" flush="true"/>


</div>
</div>
<!--  FIN CUERPO GENERAL   -->

</div>
<!--  FIN CAPA MADRE   -->
</body>
</html>
