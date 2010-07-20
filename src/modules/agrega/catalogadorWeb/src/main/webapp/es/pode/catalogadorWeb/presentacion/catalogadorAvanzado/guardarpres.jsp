<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">

<div class="plantilla_contenido">

<h2><bean:message key="catalogadorAvanzado.guardarpres.Guardar" /></h2>
<form method="post" enctype="multipart/form-data" action="<html:rewrite action="/CatalogadorAvanzado/GuardarpresAceptarGuardar"/>" >

<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" class="ali_c">
			<br />
			 <p><bean:message key="catalogadorAvanzado.guardarpres.textoSeguro"/></p>
				<br />
				</div>
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS   -->

<!-- Inicio Botones  -->
<input type="submit" class="boton_125_de_2" value="<bean:message key="catalogadorAvanzado.Si"/>"/>
</form>	
<form method="post" enctype="multipart/form-data" action="<html:rewrite action="/CatalogadorAvanzado/CatalogadorAvanzado"/>">
  <input class="boton_125_de_2_izq"  type="submit"  value="<bean:message key="catalogadorAvanzado.No"/>"/>
</form>
<!-- Fin Botones  -->
<!-- Fin plantilla contenido  -->
</div>
</tiles:put>
</tiles:insert>