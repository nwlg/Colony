<?xml version="1.0" encoding="iso-8859-1" ?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">

<head lang="es" dir="ltr">

<title><tiles:insert attribute="title" flush="true"/></title>

<link rel="shortcut icon" href="/static/img/favicon.ico" />
<link rel="stylesheet" media="screen" href="/static/css/red_neutro.css" type="text/css" />
<script type="text/javascript" src="/static/js/plantilla.js"></script>
<script type="text/javascript" src="/static/js/menu_arbol.js"></script>

<!--[if lte IE 6]>
<style title="Hoja de estilo oculta para Internet Explorer">
@import url("/static/css/ancho_maximo.css"); 
</style>
<![endif]-->

</head>

<body>

<!--  CAPA QUE CONTIENE TODAS LAS DEMAS  -->
<!--  INICIO CAPA MADRE   -->
<div id="capa_madre">

<!--  INICIO CUERPO GENERAL   -->
<!--  INICIO CUERPO GENERAL   -->
<div id="cuerpo">
<div class="minwidth">
<div class="contenido_general">


<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- INICIO CABECERA  -->
<div id="cabecera">

<h1 class="oculto"><span class="oculto">Agrega</span></h1>

<!-- INICIO METANAVEGACION   -->
<!-- INICIO METANAVEGACION   -->
<div id="metanavegacion">
<ol>
	<li class="oculto"><a href="#contenido_central" title="Contenido Principal"><strong>Contenido</strong></a></li>
	<li><a <c:if test="${empty sessionScope.urlCerrar }">onclick="javascript:window.close();"</c:if> href="${empty sessionScope.urlCerrar ? '#' : sessionScope.urlCerrar }" title="<bean:message key="metanavegacion.salir"/>" id="li_inicial"><bean:message key="metanavegacion.salir"/></a></li>
	<li><a target="_blank" href="/help/Manual_de_Usuario.pdf" title="<bean:message key="metanavegacion.ayuda"/>" id="ayuda"><bean:message key="metanavegacion.ayuda"/></a></li>
</ol>
</div>

<!-- FIN METANAVEGACION   -->
<!-- FIN METANAVEGACION   -->

<br class="oculto" />
<div title="<bean:message key="layout.cabecera.volver"/>" id="logo"><span><bean:message key="layout.cabecera.volver"/></span></div><br class="oculto" />
</div>

<!-- Inicio cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->
<!-- Inicio cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->
<div class="tronco_de_contenido">

<!-- Inicio MENU PRINCIPAL -->
<!-- Inicio MENU PRINCIPAL -->
<div id="madre_barra" ><div class="fondolat"></div></div>
<!-- Fin MENU PRINCIPAL -->
<!-- Fin MENU PRINCIPAL -->



<!-- Inicio Contenido ESPECÍFICO  -->
<!-- Inicio Contenido ESPECÍFICO  -->
<div id="contenido_central_largo">

<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- ATENCION!! AQUÍ ES DONDE VA LA PLANTILLA DE CONTENIDO (REEMPLAZAR LA CAPA: "plantilla_contenido" DE LA PLANTILLA DE CONTENIDO QUE SE DESEE POR LA CAPA QUE VIENE A CONTINUACION  -->
<tiles:insert attribute="body" flush="true"/>
<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
</div>
<!-- Fin Contenido ESPECÍFICO  -->

<!-- Inicio Contenido ESPECÍFICO  -->
</div>
<!-- Fin cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->
<!-- Fin cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->


<tiles:insert attribute="pie" flush="true"/>

</div>
</div>
</div>
<!--  FIN CUERPO GENERAL   -->
<!--  FIN CUERPO GENERAL   -->

</div>
<!--  FIN CAPA MADRE   -->
<!--  FIN CAPA MADRE   -->
</body>
</html>
