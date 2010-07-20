<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>
<tiles:insert definition="layout-principal">
<tiles:put name="title" type="string">
	<bean:message key="title.BasicPlus"/>
</tiles:put>

<tiles:put name="body" type="string">
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>
<form id="guardarpresGuardarDatosForm" action="<html:rewrite action="/CatalogadorBasicPlus/GuardarpresGuardarDatos"/>" >
<h2><bean:message key="catalogadorBasicPlus.guardarpres.Guardar" /></h2>


<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" class="ali_c">
			<br />
			 <p><bean:message key="catalogadorBasicPlus.guardarpres.textoSeguro"/></p>
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
<input class="boton_125_de_2_izq"  type="submit" name="accion" value="<bean:message key="catalogadorBasicPlus.Cancelar"/>"/>
<input type="submit" name="accion" class="boton_125_de_2" value="<bean:message key="catalogadorBasicPlus.AceptarGuardar"/>"/>
<input type="submit" name="accion" class="boton_125" value="<bean:message key="catalogadorBasicPlus.NoGuardar"/>"/>
</fieldset>
</form>	

<!-- Fin Botones  -->
<!-- Fin plantilla contenido  -->
</div>
</tiles:put>
</tiles:insert>