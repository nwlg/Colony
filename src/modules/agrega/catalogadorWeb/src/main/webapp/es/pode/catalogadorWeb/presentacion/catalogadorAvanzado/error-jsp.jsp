<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">

<div class="plantilla_contenido">
<h2><bean:message key="catalogadorAvanzado.importar.advertencia.titulo"/></h2>

<form method="post" action="<html:rewrite action="/InicioPortal/InicioPortal"/>" enctype="multipart/form-data">
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" class="ali_c">
			<br />
			 <p><bean:message key="catalogadorWeb.ErrorSesion"/></p>

			</div>
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<fieldset class="tipo ft_centrada">
<button class="boton_125" name="accion" type="submit"  value="<bean:message key="catalogadorAvanzado.importar.advertencia.aceptar"/>" >
	<bean:message key="catalogadorAvanzado.importar.advertencia.aceptar"/>
</button>
</fieldset>

<!-- Fin Botones  -->
</form>
</div>	<!-- Fin plantilla contenido  -->
</tiles:put>

</tiles:insert>








