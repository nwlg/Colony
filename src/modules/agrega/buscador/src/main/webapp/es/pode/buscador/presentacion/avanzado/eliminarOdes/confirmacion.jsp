<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<tiles:insert definition="layout-sinlateral">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>


<!-- 		INICIO DEL BODY		  -->

<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>


<!--		Inicio plantilla contenido		-->

<div class="plantilla_contenido">


<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />

<h2><bean:message key="buscador.eliminacionOdes.cabecera"/></h2>


<!--		Inicio del formulario principal		-->

<form id="eliminarOdesCUConfirmacionAceptarForm" action='<html:rewrite action="/EliminarOdesCU/ConfirmacionAceptar"/>' method="post"  >

	<!--		INICIO GLOBO GRIS		-->
	
	<div class="globo_gris" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
					
					
					<!--		INICIO CAJA DE FORMULARIO		-->
					
					<div id="formulario" class="ali_c">
					
			<input type="hidden" name="listaIds" value="${form.listaIds}"/>	
			<input type="hidden" name="idioma" value="${form.idioma}"/>	
			<input type="hidden" name="idHits" value="${form.idHits}"/>	
			<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>	
						
			<p><bean:message key="buscador.eliminacionOdes.confirmacion"/></p>
				<p>
				<!--		INICIO CAJA TABLA		-->
					<div class="caja_tabla" >
						
						<display:table name="${form.odes}" uid="fila" requestURI="${pageContext.request.requestURL}"
			        	export="false" pagesize="10" style="border:1;width:100%;" class="administracion_tareas"
						cellpadding="0" cellspacing="0" summary="${summary}">
						
					        <display:setProperty name="css.tr.odd" value="tr_blanco"/>
			        		<display:setProperty name="css.tr.even" value="tr_gris"/>  		        		
						
							<!--		COLUMNA DE USUARIOS		-->
						
								<display:column>
			            			${fila.titulo}
			        			</display:column>
			           	</display:table>
					</div>	
				</p>
				<!--		FIN CAJA DE FORMULARIO		-->
									
				</div>
			</div>
		</div>
	</div>
	
	<!--		FIN GLOBO GRIS		-->

	<!-- Inicio Botones  -->

	<input class="boton_125_de_2 tipo"  type="submit"  value="<bean:message key='odes.aceptar'/>" />
	
</form>

<!--		Formulario secundario y boton cancelar		-->

<form id="eliminarOdesCUConfirmacionCancelarForm" action='<html:rewrite action="/EliminarOdesCU/ConfirmacionCancelar"/>' method="post">
	<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key='odes.cancelar'/>" />
	<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
</form>

</div>

<!--		Fin de la capa plantilla_contenido		-->

</tiles:put>

<!--		FIN DEL BODY		-->

</tiles:insert>