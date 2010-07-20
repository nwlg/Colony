<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<?xml version="1.0" encoding="iso-8859-1" ?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">

<head lang="es" dir="ltr">

<title><bean:message key ="title.Comun"/></title>

<link rel="stylesheet" media="screen" href="/static/css/red.css" type="text/css" />
<script type="text/javascript" src="/static/js/plantilla.js"></script>

<style type="text/css">
.plantilla_contenido {height:auto !important;height:30em}
#capa_madre {max-width:800px !important;}
</style>

</head>

<body>

<!--  INICIO CAPA MADRE   -->
<div id="capa_madre">


<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- ATENCION!! RREMPLAZAR ESTA CAPA DE LA  PLANTILLA DE CONTENIDO ("plantilla_contenido") POR LA QUE SE DESEE EN LA PLANTILLA BASE  -->
<!-- Inicio plantilla contenido  -->
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido" id="ventana_flotante">


<h2><bean:message key ="gestorFlujo.verHistorial.titulo"/> <i>${form.titulo}</i></h2>

<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->


<bean:size id="elementos" collection="${form.historiales}" scope="request"/>

<logic:iterate id="historial" collection= "${form.historiales}" indexId="indice">


<c:if test="${indice <(elementos-1)}">
<div class="globo_gris uno_b">
</c:if>
<c:if test="${indice == (elementos-1)}">
<div class="globo_gris">
</c:if>


	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
		 
			<c:if test="${indice <(elementos-1)}">
			<div id="formulario">
			</c:if>
			
			<c:if test="${indice == (elementos-1)}">
			<div id="formulario_02">
			</c:if>
			
			<c:choose>
			<c:when test="${historial.estadoActual.clave eq 'RECHAZADO'}">
				<em class="estado operso_estado_rechazado" >
				<span><bean:message key="historial.rechazado"/></span></em>
			</c:when>
			<c:when test="${historial.estadoActual.clave eq 'PUBLICADO'}">
				<em class="estado operso_estado_publicado" >
				<span><bean:message key="historial.publicado"/></span></em>
			</c:when>
			<c:when test="${historial.estadoActual.clave eq 'CREACION'}">
				<em class="estado operso_estado_creacion" >
				<span><bean:message key="historial.creacion"/></span></em>
			</c:when>
			<c:when test="${historial.estadoActual.clave eq 'PROPUESTO'}">
				<em class="estado operso_estado_propuesto" >
				<span><bean:message key="historial.propuesto"/></span></em>
			</c:when>
			<c:when test="${historial.estadoActual.clave eq 'NO_DISPONIBLE'}">
				<em class="estado operso_estado_nodisponible" >
				<span><bean:message key="historial.nodisponible"/></span></em>
			</c:when>
			<c:when test="${historial.estadoActual.clave eq 'CATALOGACION'}">
				<em class="estado operso_estado_catalogado" >
				<span><bean:message key="historial.catalogado"/></span></em>
			</c:when>				
			</c:choose>
						
			<div class="titulares"><h3><bean:message key="gestorFlujo.verHistorial.user"/> ${historial.idUsuario}</h3>
			
			<strong class="date">
			<bean:message key="gestorFlujo.verHistorial.fecha"/>
			<fmt:formatDate value="${historial.fecha}" pattern="dd/MM/yyyy HH:mm:ss"/>		
			</strong>
			
			
			
			</div>
				<p class="parrafo_comun"> 
					${historial.comentarios}
				</p>
			</div>

				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
</logic:iterate>

<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->


<!-- Inicio Botones  -->
<!-- Inicio Botones  -->

<fieldset class="tipo ft_centrada">
<input type="button" class="boton_125" value="<bean:message key="gestorFlujo.verHistorial.cerrar"/>" onClick="window.close();"/>
</fieldset>

<!-- Fin Botones  -->
<!-- Fin Botones  -->
</div>
<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->


</div>
<!--  FIN CAPA MADRE   -->
</body>
</html>
