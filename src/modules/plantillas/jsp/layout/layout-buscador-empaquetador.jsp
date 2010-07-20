<?xml version="1.0" encoding="iso-8859-1" ?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<head lang="es" dir="ltr">

<title><tiles:insert attribute="title" flush="true"/></title>
<link rel="shortcut icon" href="<rewrite:rewrite url="static/img/favicon.ico"/>" />
<link rel="stylesheet" media="screen" href="/<rewrite:rewrite url="static/css/red.css"/>" type="text/css" />
<script type="text/javascript" src="<rewrite:rewrite url="static/js/plantilla.js"/>"></script>

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
<h1 class="oculto"><span class="oculto"><bean:message key="cabecera.buscador.empaquetador"/></span></h1>

<!-- INICIO METANAVEGACION   -->
<!-- INICIO METANAVEGACION   -->
<div id="metanavegacion">
<ol>
		<li class="oculto"><a href="#contenido_central" title="Contenido Principal"><strong>Contenido</strong></a></li>
		<li><a href="#" onclick="window.close()" title="<bean:message key="metanavegacion.cerrar"/>" id="li_inicial"><bean:message key="metanavegacion.cerrar"/></a></li>
</ol>
</div>
<!-- FIN METANAVEGACION   -->
<!-- FIN METANAVEGACION   -->

<h2 id="arb"><span><bean:message key="cabecera.buscador.empaquetador"/></span></h2>

<div class="limpiar"><br class="oculto" /></div>

</div>

<!-- Inicio cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->
<!-- Inicio cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->
<div class="tronco_de_contenido">

<div id="madre_barra">
<div class="fondolat"></div>
</div>

<!-- Inicio Contenido ESPECÍFICO  -->
<!-- Inicio Contenido ESPECÍFICO  -->
<div id="contenido_central_largo">
<tiles:insert attribute="body" flush="true"/>
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
