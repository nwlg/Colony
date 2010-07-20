<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>



<tiles:insert definition="layout-gestor-flujo-con-style">

	<tiles:put name="title" type="string">
		<bean:message key="title.Comun" />
	</tiles:put>
	<tiles:put name="body" type="string">

		<!--************************          Inicio plantilla contenido       ****************************-->
		<div class="plantilla_contenido"><!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
		<jsp:include page="/layout/messages.jsp" flush="true" />


		


		<!--		Inicio del formulario principal		--> <!--		INICIO GLOBO GRIS		-->


	
				<div class="globo_gris">
				<div class="globo_gris_01">
				<div class="globo_gris_02">
				<div class="globo_gris_03"><!--		INICIO CAJA DE FORMULARIO		-->

				<div id="formulario" class="ali_c">
				<br/>
				<c:if test="${fn:length(form.mensajes)==0}">
					<p><em class="correcto"><bean:message
						key="gestorFlujo.proponer.exito" /></em></p>
						
						
				</c:if> 
				<c:if test="${fn:length(form.mensajes)!=0}">
					<p><em class="incorrecto"><bean:message
						key="gestorFlujo.error.validacion" /></em></p>
						
						<ol>
						<logic:iterate id="errores" collection="${form.mensajes}">
							<li>${errores}</li>
								<br/>							
								
						</logic:iterate>
						</ol>
				</c:if>

				</div>

					<!--		FIN CAJA DE FORMULARIO		-->					
				</div>
				</div>
				</div>
				</div>
				<br/>
			
	


		<!--		FIN GLOBO GRIS		-->


		<!--		Boton aceptar		-->
		<form method="post"
			action='<html:rewrite action="/${initParam.url_objetosPersonales }"/>'>
		<fieldset class="tipo ft_centrada">
		<input class="boton_125" type="submit"
			value="<bean:message key="gestorFlujo.aceptar"/>" /></fieldset></form>

		<!--		Fin formulario principal		-->


		</div>



		<!-- Fin plantilla CONTENIDO -->
	</tiles:put>

</tiles:insert>
