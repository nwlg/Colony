<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<?xml version="1.0" encoding="iso-8859-1" ?>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">

<head lang="es" dir="ltr">
<%@ include file="/taglib-imports.jspf" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %> 
  <title>
	<tiles:insert attribute="title" flush="true"/>
  </title>
  <link rel="shortcut icon" href="<rewrite:rewrite url='static/img/favicon.ico'/>" />

	  <link rel="stylesheet" media="screen" href="<rewrite:rewrite url='static/css/red.css'/>" type="text/css" />
      <script type="text/javascript" src="<rewrite:rewrite url='static/js/plantilla.js'/>"></script>
      <script type="text/javascript" src="<rewrite:rewrite url='static/js/mootools.js'/>"></script>
	  <script type="text/javascript" src="<rewrite:rewrite url='static/js/calendar.rc4.js'/>"></script>
<!--[if lte IE 8]>
<style title="Hoja de estilo oculta para Internet Explorer">
@import url("<rewrite:rewrite url='static/css/ancho_maximo.css'/>"); 
</style>
<![endif]-->		

</head>

<body>
<!--  INICIO CAPA MADRE   -->
<div id="capa_madre">
<!--  INICIO CUERPO GENERAL   -->
<div id="cuerpo">
<div class="minwidth">
<div class="contenido_general">

<!-- INICIO CABECERA  -->
<div id="cabecera">
	<h1 class="oculto"><span class="oculto"><bean:message key="layout.principal.comunidadMadrid"/></span></h1>
	<!-- INICIO METANAVEGACION   -->
	<tiles:insert attribute="metanavegacion" flush="true"/>
	<c:set var="sesion" value="${catalogadorAvSession.MDSesion}"/>
	<c:set var="tituloGeneral" value=""/>
	<c:if test="${!empty sesion.general}">
	   <c:if test="${!empty sesion.general.titulo}">
	    	<c:if test="${!empty sesion.general.titulo.textos }">
	    		<c:set var="textosTit" value="${sesion.general.titulo.textos}"/>
	    		<c:if test="${!empty textosTit}">
	    			<c:forEach var="unText" items="${textosTit}" begin="0" end="0">
	    				<c:set var="tituloGeneral" value="${unText.texto}"/>
	    			</c:forEach>
	    		</c:if>
	    	</c:if>
	   </c:if>
	</c:if>
	<c:choose>
	<c:when test="${!empty tituloGeneral}">
		<h2 class="h2_paq">${tituloGeneral}</h2><!-- cuando un ode se cataloge se sustituira por el titulo  -->
	</c:when>
	<c:otherwise>
		<h2>&nbsp;</h2>
	</c:otherwise>
	</c:choose> 
	<br class="oculto"/>
</div>
<!-- FIN CABECERA  -->

<!-- Inicio cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->
<div class="tronco_de_contenido">
<div id="madre_barra"><div class="fondolat"></div></div>

<!-- Inicio Contenido ESPECÍFICO  -->
<div id="contenido_central_largo">
	<tiles:insert attribute="body" flush="true"/>
</div>
</div>
<!-- Fin Contenido ESPECÍFICO  -->

<!-- INICIO PIE DE PAGINA -->
<tiles:insert attribute="pie" flush="true"/>
<!-- FIN PIE DE PAGINA -->
</div>
<!-- Fin cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->
</div>
</div>
</div>
<!--  FIN CAPA MADRE   -->
</body>
</html>