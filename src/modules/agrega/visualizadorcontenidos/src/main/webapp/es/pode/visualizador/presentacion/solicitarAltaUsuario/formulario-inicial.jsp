<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<tiles:insert definition="layout-usuario">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>


<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>


<div class="plantilla_contenido">
<h2><bean:message key="usuarios.solicitarAlta.cabecera"/></h2>
<form id="solicitarAltaUsuarioCUFormularioInicialVolverForm" action='<html:rewrite action="/SolicitarAltaUsuarioCU/FormularioInicialVolver"/>' method="post">
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario">
			<p class="parrafo_comun" ><bean:message key='usuarios.solicitarAlta.texto'/></p>
			 <br/>
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
<input class="boton_125_de_2_izq"  type="submit"   value="<bean:message key='usuarios.solicitarAlta.volver'/>"/>
</fieldset>
</form>
</div>
<!-- Fin plantilla contenido  -->
</tiles:put>
</tiles:insert>