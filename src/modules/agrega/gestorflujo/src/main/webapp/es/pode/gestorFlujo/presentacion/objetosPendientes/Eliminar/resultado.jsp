<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<tiles:insert definition="layout-gestor-flujo-con-style">

	<tiles:put name="title" type="string">
		<bean:message key="title.Admnistracion" />
	</tiles:put>
	<tiles:put name="body" type="string">

		<!--************************          Inicio plantilla contenido       ****************************-->
	<div class="plantilla_contenido">


<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />


<h2><bean:message key="gestorFlujo.mostrarOdes.eliminar"/></h2>


<!--		Inicio del formulario principal		-->

<form action='<html:rewrite action="${initParam.url_eliminar_resultado_volver}"/>' method="post"  >

	<!--		INICIO GLOBO GRIS		-->
	
	<div class="globo_gris" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
					
					
					<!--		INICIO CAJA DE FORMULARIO		-->
					
					<div id="formulario" class="ali_c">
							
						<p><bean:message key="gestorFuljo.eliminar.resultado"/></p>
						
						<p>
						
						<!--		INICIO CAJA TABLA		-->
						
						<div class="caja_tabla" >
						
						<display:table name="${form.titulos}" uid="fila" requestURI=""
			        	export="false" style="border:1;width:100%;" class="administracion_tareas"
						cellpadding="0" cellspacing="0" summary="${summary}">
						
						
						<!--		COLUMNA DE ODES		-->
						
						<display:column>
			            	${fila}
			        	</display:column>
			        	
			        	</display:table>
						</div>
						</p>
				
					</div>
					
					<!--		FIN CAJA DE FORMULARIO		-->
					
					
				</div>
			</div>
		</div>
	</div>
	
	<!--		FIN GLOBO GRIS		-->


	<!--		Boton aceptar		-->
	<fieldset class="tipo ft_centrada">
	<input class="boton_125"  type="submit"  value="<bean:message key="gestorFlujo.aceptar"/>" /></fieldset>

</form>

<!--		Fin formulario principal		-->


</div>

	
	
				<!-- Fin plantilla CONTENIDO -->
	</tiles:put>

</tiles:insert>