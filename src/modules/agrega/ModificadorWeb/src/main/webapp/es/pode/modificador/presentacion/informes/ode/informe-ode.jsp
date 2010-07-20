<?xml version="1.0" encoding="iso-8859-1" ?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@ taglib uri="/WEB-INF/tlds/tags-modificadorWeb.tld" prefix="mod" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">
<head lang="es" dir="ltr">
	
<title>
	<bean:message key="title.Comun"/>
</title>

<link rel="shortcut icon" href="<rewrite:rewrite url="static/img/favicon.ico"/>" />
<link rel="stylesheet" media="screen" href="<rewrite:rewrite url="static/css/red.css"/>" type="text/css" />
<script type="text/javascript" src="<rewrite:rewrite url="static/js/plantilla.js"/>"></script>

</head>


<body>
<!--  CAPA QUE CONTIENE TODAS LAS DEMAS  -->
<!--  INICIO CAPA MADRE   -->
<div id="capa_madre">

<!--  INICIO CUERPO GENERAL   -->
<!--  INICIO CUERPO GENERAL   -->
<div id="cuerpo_ventana_flotante">
<!-- INICIO CABECERA  -->
<div id="cabecera">

<!-- INICIO METANAVEGACION   -->
<!-- INICIO METANAVEGACION   -->
<div id="metanavegacion">
<ol>

	<li class="oculto"><a href="#contenido_central" title="Contenido Principal"><strong><bean:message key="informe.contenido"/></strong></a></li>
	<li><a href="javascript:window.close();" title="Salir" id="li_inicial"><bean:message key="informe.cerrarVentana"/></a></li>
		
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


	<!--  INICIO CUERPO GENERAL   -->
	<!--  INICIO CUERPO GENERAL   -->
	<div class="plantilla_contenido" >
	<form action="<html:rewrite action="/InformeODE/InformeODEVolver"/>" id="popup" method="post" >
		<h2><bean:message key="informe.masInformacion"/></h2>
		
		<!--  INICIO CAJA DE FORMULARIO   -->
		<div class="caja_de_tabla_invisible" >
			<table cellspacing="0" cellpadding="0"  border="0" width="100%"  summary="Nombre Tareas">
				<tr>
					<td class="nt" valign="top"  ><bean:message key="informe.nombreTarea"/>:</td>
					<td  class="nt2" valign="top"><label>${form.nombreTarea}</label></td>
				</tr>
				<tr>
					<td class="nt" valign="top" ><bean:message key="informe.Resultado"/>:</td>
					<td class="nt2" valign="top" ><label><bean:message key="estado.${form.resultadoTarea}"/></label><logic:notEmpty name="form" property="descResultado">- <bean:message key="${form.descResultado}"/></logic:notEmpty></td>
				</tr>
			</table>
		</div>
		<c:set var="traza" value="${fn:escapeXml(form.ode.traza)} "/>          
		<div class="parrafo_comun" id="separacion"><mod:formatlog input="${traza}"/></div>		
			<!-- Inicio Botones  -->
			<!-- Inicio Botones  -->
			<fieldset class="tipo ft_centrada">
				<input class="boton_125" type="button" value="<bean:message key="informe.cerrarVentana"/>" onclick="javascript:window.close();"/>
			</fieldset>
			<!-- Fin Botones  -->
			<!-- Fin Botones  -->
	</form>

</div>

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



</div>
<!--  FIN CUERPO GENERAL   -->
<!--  FIN CUERPO GENERAL   -->
</div>
    </body>

</html>
