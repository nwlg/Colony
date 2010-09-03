<?xml version="1.0" encoding="iso-8859-1" ?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">

<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tags/link.tld" prefix="link" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>

<head lang="es" dir="ltr">

<title>
	<tiles:insert attribute="title" flush="true"/>
</title>
<link rel="search" type="application/opensearchdescription+xml" title="NDRB" href="/searchPlugin/searchPlugin.xml"/>
<link rel="shortcut icon" href="<rewrite:rewrite url="static/img/favicon.ico"/>" />
<link rel="stylesheet" media="screen" href="<rewrite:rewrite url="static/css/red.css"/>" type="text/css" />
<script type="text/javascript" src="<rewrite:rewrite url="static/js/plantilla.js"/>"></script>
<script type="text/javascript" src="<rewrite:rewrite url="static/js/menu_arbol.js"/>"></script>

</head>

<body>

<!--  CAPA QUE CONTIENE TODAS LAS DEMAS  -->
<!--  INICIO CAPA MADRE   -->
<div id="capa_madre">
<!--  INICIO CUERPO GENERAL   -->
<div id="cuerpo">
<div class="minwidth">
<div class="contenido_general">
<tiles:importAttribute/>
<tiles:useAttribute id="urlGuardar" name="urlGuardar"/>
<logic:empty name="urlGuardar">
<bean:define id="urlGuardar" value="/Guardar/Guardar"/>
</logic:empty>
<!-- Aqui va la cabecera -->
<tiles:insert attribute="cabecera" flush="true">
<tiles:put name="urlGuardar"><tiles:getAsString name="urlGuardar"/></tiles:put>
<tiles:put name="parametrosCatalogar"><tiles:getAsString name="parametrosCatalogar"/></tiles:put>
</tiles:insert>
<tiles:importAttribute/>
<!-- Inicio cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->
<div class="tronco_de_contenido">
<tiles:insert attribute="barraMenu" flush="true">
<tiles:put name="selected"><tiles:getAsString name="selected"/></tiles:put>
<tiles:put name="urlArchivos"><tiles:getAsString name="urlArchivos"/></tiles:put>
<tiles:put name="urlRecursos"><tiles:getAsString name="urlRecursos"/></tiles:put>
<tiles:put name="urlOrganizaciones"><tiles:getAsString name="urlOrganizaciones"/></tiles:put>
<tiles:put name="urlSubmanifiestos"><tiles:getAsString name="urlSubmanifiestos"/></tiles:put>
<tiles:put name="urlEstructura"><tiles:getAsString name="urlEstructura"/></tiles:put>
</tiles:insert>

<!-- Inicio Contenido ESPECÍFICO  -->
<div id="contenido_central_largo">
<tiles:insert attribute="body" flush="true"/>
</div>
</div>
<!-- Fin cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->

<!-- Pie de pagina -->
<tiles:insert attribute="pie" flush="true"/>

</div>
</div>
</div>
<!--  FIN CUERPO GENERAL   -->

</div>
<!--  FIN CAPA MADRE   -->
</body>
</html>
