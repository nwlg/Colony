<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">

<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>
<form id="volverConfirmarGuardarDatosSubmitForm" action="<html:rewrite action="/Volver/ConfirmarGuardarDatosSubmit"/>">
<h2><bean:message key="catalogador.volver.tituloGuardar"/></h2>
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->

<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" class="ali_c">

			<br />
			 <p ><bean:message key="catalogador.volver.guardaCambios"/></p>
				<br />
				</div>
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>

</div>
<!--  FIN GLOBO GRIS   -->

<!-- Inicio Botones  -->
<fieldset class="tipo ft_centrada">
	<input type="submit" name="accion" class="boton_125_de_2_izq" value="<bean:message key="volver.Cancelar"/>"/>
	<input type="submit" name="accion" class="boton_125_de_2" value="<bean:message key="volver.Si"/>" />
	<input type="submit" name="accion" class="boton_125" value="<bean:message key="volver.No"/>" />
<!-- Fin Botones  -->
</fieldset>
</form>
</div>
<!-- Fin plantilla contenido  -->
</tiles:put>
</tiles:insert>