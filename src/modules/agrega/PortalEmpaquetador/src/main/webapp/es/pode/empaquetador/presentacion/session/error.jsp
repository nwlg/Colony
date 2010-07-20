<?xml version="1.0" encoding="iso-8859-1" ?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tags/link.tld" prefix="link" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<head lang="es" dir="ltr">

<title><bean:message key="comunes.titulo"/></title>
<link rel="stylesheet" media="screen" href="<rewrite:rewrite url="static/css/red.css"/>" type="text/css" />
<script type="text/javascript" src="<rewrite:rewrite url="static/js/plantilla.js"/>"></script>
<link rel="shortcut icon" href="<rewrite:rewrite url="static/img/favicon.ico"/>" />

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
<bean:define id="titleAyuda"><bean:message key="cabecera.ayuda"/></bean:define>
<ol>
	<li class="oculto">
	<a href="#contenido_central" title="<bean:message key="metanavegacion.contenido" />"><strong><bean:message key="metanavegacion.contenido" /></strong></a></li>
	<li><a href="#" title="<bean:message key="metanavegacion.cerrar" />" id="li_inicial"><bean:message key="metanavegacion.cerrar" /></a></li>
	<li><link:link attrProperty="HELP_URL" title="${titleAyuda}" id="ayuda" target="_blank" i18nMessage="cabecera.ayuda"/></li>
	<li><a href="#" title="<bean:message key="cabecera.catalogar" />"><bean:message key="cabecera.catalogar" /></a></li>
	<li><a href="#" title="<bean:message key="cabecera.previsualizar" />" target="_blank"><bean:message key="cabecera.previsualizar" /></a></li>
	<li><a href="#" title="<bean:message key="cabecera.validar" />"><bean:message key="cabecera.validar" /></a></li>
	<li><a href="#" title="<bean:message key="cabecera.guardar" />" id="contacto"><bean:message key="cabecera.guardar" /></a></li>
</ol>
</div>
<!-- FIN METANAVEGACION   -->
<!-- FIN METANAVEGACION   -->



<br class="oculto" />

</div>

<!-- Inicio cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->
<!-- Inicio cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->

<div class="tronco_de_contenido">
<div id="madre_barra"><div class="fondolat"></div></div>


<!-- Inicio Contenido ESPECÍFICO  -->
<!-- Inicio Contenido ESPECÍFICO  -->
<div id="contenido_central_largo">
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- ATENCION!! RREMPLAZAR ESTA CAPA DE LA  PLANTILLA DE CONTENIDO ("plantilla_contenido") POR LA QUE SE DESEE EN LA PLANTILLA BASE  -->
<!-- Inicio plantilla contenido  -->
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">


<h2><bean:message key="sesion.caducada.title"/></h2>
<form method="post" action="<html:rewrite action="/SesionCaducada/ErrorAceptar"/>" >

<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" class="ali_c">

			<br />
			 <p><bean:message key="sesion.caducada.mensaje"/></p>
				<br />
				</div>
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>

	</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->

<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<fieldset class="tipo ft_centrada">
<input class="boton_125"  type="submit"  value="<bean:message key="sesion.caducada.boton"/>" />
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>
</div>
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

<jsp:include flush="true" page="/layout/pie.jsp"/>
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
