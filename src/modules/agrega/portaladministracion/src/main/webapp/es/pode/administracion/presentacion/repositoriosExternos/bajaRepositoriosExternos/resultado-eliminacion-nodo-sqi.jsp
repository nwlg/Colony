<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<tiles:insert definition="layout-administrador">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>


<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>


<!--		Inicio plantilla contenido		-->

<div class="plantilla_contenido">


<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />


<h2><bean:message key="nodos.bajaNodos.cabeceraSQI"/></h2>


<!--		Inicio del formulario principal		-->

<form id="bajaNodoSQIResultadoEliminacionNodoSQIAceptarForm" action='<html:rewrite action="/${initParam.url_nodoSQI_baja_resultado_aceptar }"/>' method="post"  >

	<!--		INICIO GLOBO GRIS		-->
	
	<div class="globo_gris" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
					
					
					<!--		INICIO CAJA DE FORMULARIO		-->
					
					<div id="formulario" class="ali_c">
				
					
						
							
						<p><bean:message key="nodos.bajaNodo.confirmacionSQI2"/></p>
						
						<p>
						
						<!--		INICIO CAJA TABLA		-->
						
						<div class="caja_tabla" >
						
						<display:table name="${form.nodosSQIEliminar}" uid="fila" requestURI="${pageContext.request.requestURL}"
			        	export="false" pagesize="8" sort="list" style="border:1;width:100%;" class="administracion_tareas"
						cellpadding="0" cellspacing="0" summary="${summary}">
						
						
						<!--		COLUMNA DE USUARIOS		-->
						
						<display:column>
			            	${fila.nombreNodo}
			        	</display:column>
			        	
			        	</display:table>
					
						</p>
				
					</div>
					
					<!--		FIN CAJA DE FORMULARIO		-->
					
					
				</div>
			</div>
		</div>
	</div>
	
	<!--		FIN GLOBO GRIS		-->


	<!--		Boton aceptar		-->

	<input class="boton_125 tipo ft_centrada"  type="submit"  value="<bean:message key="usuarios.aceptar"/>" />

</form>

<!--		Fin formulario principal		-->


</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>