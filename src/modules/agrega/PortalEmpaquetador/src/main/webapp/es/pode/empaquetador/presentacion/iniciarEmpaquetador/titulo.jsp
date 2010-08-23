<?xml version="1.0" encoding="iso-8859-1" ?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tlds/tags-empaquetador.tld" prefix="emp" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<head lang="es" dir="ltr">

<title><bean:message key="comunes.titulo"/></title>

<link rel="stylesheet" media="screen" href="<rewrite:rewrite url="static/css/red.css"/>" type="text/css" />
<script type="text/javascript" src="<rewrite:rewrite url="static/js/plantilla.js"/>"></script>
<link rel="shortcut icon" href="<rewrite:rewrite url="static/img/favicon.ico"/>" />
<!--[if lte IE 6]>
<style title="Hoja de estilo oculta para Internet Explorer">
@import url("/static/css/ancho_maximo.css"); 
</style>
<![endif]-->

</head>

<body>

<script language="javascript">

function doAccept()
{
	document.forms["form"].action.value = "<bean:message key="iniciarEmpaquetador.aceptar"/>";
	document.forms["form"].submit();
}

function doCancel()
{
	document.forms["form"].action.value = "<bean:message key="iniciarEmpaquetador.cancelar" />";
	document.forms["form"].submit();
}

</script>


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

<h1 class="oculto"><span class="oculto">Comunidad de Madrid</span></h1>

<!-- INICIO METANAVEGACION   -->
<!-- INICIO METANAVEGACION   -->
<div id="metanavegacion">
<ol>
	<li class="oculto"><a href="#contenido_central" title="Contenido Principal"><strong><bean:message key="metanavegacion.contenido" /></strong></a></li>
	<li><a href="<html:rewrite action="/InicioEmpaquetador/TituloSubmit"/>?action=<bean:message key="iniciarEmpaquetador.cancelar" />" title="<bean:message key="metanavegacion.cerrar" />" id="li_inicial"><bean:message key="metanavegacion.cerrar" /></a></li>
	<li><emp:link attrProperty="HELP_URL" title="Ayuda" id="ayuda" target="blank" i18nMessage="cabecera.ayuda"/></li>


<!-- 	<li><span id="identificacion">Nombre Apellido Apellido,</span></li>
		<li><a href="#" title="Catalogar">Catalogar</a></li>
		<li><a href="#" title="Previsualizar">Previsualizar</a></li>
		<li><a href="#" title="Validar">Validar</a></li>
		<li><a href="#" title="Guardar" id="sinbarra">Guardar</a></li>-->
</ol>
</div>

<!-- FIN METANAVEGACION   -->
<!-- FIN METANAVEGACION   -->


<h2 class="h2_paq"><bean:message key="iniciarEmpaquetador.titulo"/></h2>

<br class="oculto" />
</div>

<!-- Inicio cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->
<!-- Inicio cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->
<div class="tronco_de_contenido">
<!-- Inicio MENU PRINCIPAL -->
<!-- Inicio MENU PRINCIPAL -->
<div id="madre_barra">
<div class="fondolat"></div>
</div>
<!-- Fin MENU PRINCIPAL -->

<!-- Fin MENU PRINCIPAL -->

<!-- Inicio Contenido ESPEC�FICO  -->
<!-- Inicio Contenido ESPEC�FICO  -->
<div id="contenido_central_largo">

<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- ATENCION!! AQU� ES DONDE VA LA PLANTILLA DE CONTENIDO (REEMPLAZAR LA CAPA: "plantilla_contenido" DE LA PLANTILLA DE CONTENIDO QUE SE DESEE POR LA CAPA QUE VIENE A CONTINUACION  -->
<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>
<h2><bean:message key="iniciarEmpaquetador.titulo"/></h2>
<form name="form" method="post" action="<html:rewrite action="/InicioEmpaquetador/TituloSubmit"/>" >
<p class="parrafo_comun" id="separacion2"><bean:message key="iniciarEmpaquetador.mensaje"/></p>

<!-- Start of bubble -->
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">

			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >
				<br/>
				<div class="fila_de_tabla">
  						<div class="text" style="text-align:center"><label for="nombreN"><span class="oculto"><bean:message key="iniciarEmpaquetador.titulo"/></span></label><input name="titulo" class="nombreGrupo" value=""  onblur="this.style.backgroundColor='#e1e1e1'" id="nombreN" type="text" title="<bean:message key="iniciarEmpaquetador.mensaje"/>"  /></div>
					<br class="oculto" />
				</div>
				<br />
			</div>
			<!--  FIN CAJA DE FORMULARIO   -->

</div></div></div></div>
<!-- End of search box bubble -->


<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<fieldset class="tipo">

	<input type="hidden" name="action" value="">

	<div class="packer_accept">
		<!-- Start of bubble -->
		<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">

		<div class="db_bubble_content">
			<a href="javascript:doAccept();"><bean:message key="iniciarEmpaquetador.aceptar"/></a>
		</div>

		</div></div></div></div>
		<!-- End of bubble -->
	</div>

	<div class="packer_cancel">
		<!-- Start of bubble -->
		<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">

		<div class="db_bubble_content">
			<a href="javascript:doCancel();"><bean:message key="iniciarEmpaquetador.cancelar" /></a>
		</div>

		</div></div></div></div>
		<!-- End of bubble -->
	</div>


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
<!-- Fin Contenido ESPEC�FICO  -->
<!-- Inicio Contenido ESPEC�FICO  -->
</div>
<!-- Fin cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->
<!-- Fin cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->


<!-- INICIO PIE DE PAGINA -->
<!-- INICIO PIE DE PAGINA -->
<%@ include file="/layout/pie.jsp" %>
<!-- FIN PIE DE PAGINA -->
<!-- FIN PIE DE PAGINA -->

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
