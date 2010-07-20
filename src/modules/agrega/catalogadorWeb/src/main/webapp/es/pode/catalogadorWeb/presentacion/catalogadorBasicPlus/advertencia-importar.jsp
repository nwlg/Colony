<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>
<tiles:insert definition="layout-principal">
<tiles:put name="title" type="string">
	<bean:message key="title.BasicPlus"/>
</tiles:put>

<tiles:put name="body" type="string">
<jsp:include page="/layout/messages.jsp" flush="true"/>

<div class="plantilla_contenido">
<h2><bean:message key="catalogadorBasicPlus.importar.advertencia.titulo"/></h2>

<form method="post" action="<html:rewrite action="/CatalogadorBasicPlus/AdvertenciaImportarSubmit"/>">


<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" class="ali_c">
			<br />
			 <p><bean:message key="catalogadorBasicPlus.importar.advertencia.mensaje"/></p>

			</div>
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS   -->



<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<fieldset class="tipo">
<button class="boton_125_de_2_izq" name="accion" type="submit"  value="<bean:message key="catalogadorBasicPlus.importar.advertencia.cancelar"/>" >
	<bean:message key="catalogadorBasicPlus.importar.advertencia.cancelar"/>
</button>
<button class="boton_125_de_2" name="accion" type="submit"  value="<bean:message key="catalogadorBasicPlus.importar.advertencia.aceptar"/>" >
	<bean:message key="catalogadorBasicPlus.importar.advertencia.aceptar"/>
</button>
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->



</form>
</div>	<!-- Fin plantilla contenido  -->
</tiles:put>

</tiles:insert>








