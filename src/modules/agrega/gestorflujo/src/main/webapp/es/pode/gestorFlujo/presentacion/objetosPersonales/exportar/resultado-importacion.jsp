<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<tiles:insert definition="layout-gestor-flujo-con-style">

	<tiles:put name="title" type="string">
		<bean:message key="title.Comun" />
	</tiles:put>
	<tiles:put name="body" type="string">

		<!--************************          Inicio plantilla contenido       ****************************-->
		<div class="plantilla_contenido"><!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
		<jsp:include page="/layout/messages.jsp" flush="true" />


		<h2><bean:message key="gestorFlujo.mostrarOdes.exportar" /></h2>


		<!--		Inicio del formulario principal		--> <!--		INICIO GLOBO GRIS		-->

				<div class="globo_gris">
				<div class="globo_gris_01">
				<div class="globo_gris_02">
				<div class="globo_gris_03"><!--		INICIO CAJA DE FORMULARIO		-->
<!--  INICIO CAJA DE FORMULARIO   -->

			<div id="formulario" class="ali_c">
			<br />

				<p><em class="incorrecto"><bean:message key="gestorFlujo.error.exportar.validacion" />&nbsp;<a href="${form.href }"><bean:message key="gestorFlujo.error.exportar.aqui" /></a>&nbsp;<bean:message key="gestorFlujo.error.exportar.validacion2" /></em></p>
				<br />
				</div>
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>

	</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->
<p class="parrafo_comun" id="separacion3"><bean:message key="gestorFlujo.error.exportar.acontinuacion"/></p>
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<form method="post"	action='<html:rewrite action="/${initParam.url_exportar_aceptar}"/>'>
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">

			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario_02" >
			<br />

				<ul class="lista_validacion">

					<logic:iterate id="errores" collection="${form.mensajes}">
						<li>${errores}</li>
					</logic:iterate>
				</ul>

				</div>
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->

			

		<!--		FIN GLOBO GRIS		-->


		<!--		Boton aceptar		-->
		
		<fieldset class="tipo ft_centrada">
		<input class="boton_125" type="submit"
			value="<bean:message key="gestorFlujo.aceptar"/>" /></fieldset></form>

		<!--		Fin formulario principal		-->


		</div>



		<!-- Fin plantilla CONTENIDO -->
	</tiles:put>

</tiles:insert>
