<?xml version="1.0" encoding="iso-8859-1" ?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/tags-empaquetador.tld" prefix="emp" %>
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

	<li class="oculto"><a href="#contenido_central" title="Contenido Principal"><strong><bean:message key="tipovisualizador.contenido"/></strong></a></li>
	<li><a href="javascript:window.close();" title="Salir" id="li_inicial"><bean:message key="tipovisualizador.cerrarVentana"/></a></li>
		
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
<%@ include file="/layout/messages.jsp" %>

<h2><bean:message key="tipovisualizador.cabecera"/></h2>
<form method="post" action="<html:rewrite action="/Previsualizar/TipoVisualizadorAceptar"/>" >
<p class="parrafo_comun" id="separacion2"><bean:message key="tipovisualizador.texto1"/>&nbsp;<a href="http://www.adlnet.gov" target="_blank"><bean:message key="tipovisualizador.texto2"/></a>&nbsp;<bean:message key="tipovisualizador.texto3"/>&nbsp;<bean:message key="tipovisualizador.label.visAdl.adladvierte"/></p>
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >

			 <div class="fila_de_tabla">
  						<div class="text ft_lateral" ><input type="radio" class="boton_radio" id="Previsual01" checked="checked" name="tipoVisualizador" value="agrega"/><label for="Previsual01" class="alineada"><bean:message key="tipovisualizador.label.agrega"/></label></div>
				<div class="linea_separadora"></div>
				<br class="oculto" />
				</div>
				<!--     -->
			<div class="fila_de_tabla">
  						<div class="text ft_lateral"><input type="radio" class="boton_radio" id="Previsual02"  name="tipoVisualizador" value="adl"/><label for="Previsual02"  class="alineada2"><bean:message key="tipovisualizador.label.adl"/></label></div>

				<div class="linea_separadora"></div>
				<br class="oculto" />
				</div>
				<!--     -->
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
<fieldset class="tipo">
<input class="boton_125_de_2_izq" onclick="javascript:window.close();" type="button" name="action" value="<bean:message key="comunes.cancelar"/>" />
<input class="boton_125_de_2"  type="submit" name="action" value="<bean:message key="comunes.aceptar"/>" />
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>

</div>
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
