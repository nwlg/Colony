<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">
<h2><bean:message key="title.Validacion"/></h2>
<form method="post" action="<html:rewrite action="/Tecnica/TecnicaNoValidaVolver" />">
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" class="ali_c">
			<br />
			 <p><em class="incorrecto"><bean:message key="catalogador.basico.validador.mensError"/></em></p>
				<br />
				</div>
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS   -->
<p class="parrafo_comun" id="separacion3">
	<bean:message key="catalogador.basico.validador.mensACont"/>:
</p>
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario_02" >
			<br />
			 <ul class="lista_validacion">
			   <logic:iterate id="mensaje"  name="form" property="mensajesError">
					<li>${mensaje}</li>	 
				 </logic:iterate>
			 </ul>
				<br />
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
<fieldset class="tipo ft_centrada">
	 <input type="submit" class="boton_125" value="<bean:message key="catalogadoravanzado.validacion.Volver"/>"/>
</fieldset>
<!-- Fin Botones  -->
</form>
</div>
<!-- Fin plantilla contenido  -->
</tiles:put>
</tiles:insert>