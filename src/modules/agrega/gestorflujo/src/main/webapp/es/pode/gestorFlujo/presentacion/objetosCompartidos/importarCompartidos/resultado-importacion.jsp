<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<tiles:insert definition="layout-gestor-flujo-con-style">

	<tiles:put name="title" type="string">
		<bean:message key="title.Comun" />
	</tiles:put>
	<tiles:put name="body" type="string">

		<!--************************          Inicio plantilla contenido       ****************************-->
		<div class="plantilla_contenido"><!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
		<jsp:include page="/layout/messages.jsp" flush="true" />


		<h2><bean:message key="gestorFlujo.mostrarOdes.importar" /></h2>


		<!--		Inicio del formulario principal		--> <!--		INICIO GLOBO GRIS		-->







		<!-- los impares es el nombre del ode, los pares los posibles errores de validacion	-->
		<logic:iterate id="result" collection="${form.resultado}" indexId="indice">


			
			
				<div class="globo_gris uno_b">
				<div class="globo_gris_01">
				<div class="globo_gris_02">
				<div class="globo_gris_03">
				
				<!--		INICIO CAJA DE FORMULARIO		-->

				
				
				<c:if test="${result.valido==null}">
				
				<div id="formulario" class="ali_i">
				<br/>
					<p><em class="correcto"><bean:message key="gestorFlujo.importar.exito" /> ${result.titulo}</em></p>
				<br/>
				
						
				</div>
				</c:if> 
				<c:if test="${result.valido!=null}">



				<!--  INICIO CAJA DE FORMULARIO   -->
				<div class="caja_dinamica">
				
				<p><em class="incorrecto"><bean:message key="gestorFlujo.error.validar" arg0="${result.titulo}" /></em></p>
				</div>

				<div id="m${indice}" class="caja_abierta">
				<div class="formu" style="padding-bottom:0;">
				<p class="err_p"><bean:message key="gestorFlujo.importar.error.validar.continuacion" /></p>
				<ul class="lista_validacion">

					<logic:iterate id="errores" collection="${result.mensajes}">
						<li>${errores}</li>
						<br />
					</logic:iterate>
				</ul>

				</div>
				</div>



			</c:if>

				

					<!--		FIN CAJA DE FORMULARIO		-->					
				</div>
				</div>
				</div>
				</div>
				<br/>
			

		</logic:iterate>
		


		<!--		FIN GLOBO GRIS		-->


		<!--		Boton aceptar		-->
		<form method="post"
			action='<html:rewrite action="${initParam.url_compartidos }"/>'>
		<fieldset class="tipo ft_centrada">
		<input class="boton_125" type="submit"
			value="<bean:message key="gestorFlujo.aceptar"/>" />
			</fieldset>
			</form>

		<!--		Fin formulario principal		-->


		</div>



		<!-- Fin plantilla CONTENIDO -->
	</tiles:put>

</tiles:insert>