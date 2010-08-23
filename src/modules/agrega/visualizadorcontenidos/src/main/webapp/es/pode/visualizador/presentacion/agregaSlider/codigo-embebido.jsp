<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<tiles:insert definition="layout-usuario">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>


<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>


<!--		Inicio plantilla contenido		-->

<div class="plantilla_contenido" id="ventana_flotante">


<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />

<h2><bean:message key="agregaSlider.codigoEmbebido.cabecera"/></h2>


<!--		Inicio del formulario principal		-->

<form id="agregaSliderCodigoEmbebidoVolverForm" action='<html:rewrite action="/AgregaSlider/CodigoEmbebidoVolver"/>' method="post" >

	<p class="parrafo_comun" id="separacion2"><bean:message key="agregaSlider.explicacionCodigo" /></p>


	<!--		INICIO GLOBO GRIS		-->
	
	<div class="globo_gris" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
				
				
					<!--		INICIO CAJA DE FORMULARIO		-->
					
					<div id="formulario" >
					
					
						<!--		CAMPO DE codigo embebido		-->
						
						<div class="fila_de_tabla">
						
							<div class="text" style="text-align:center">
								<label for="codigo_embebido"><span class="oculto">Codigo embebido</span></label>
								<textarea name="codigo_embebido" rows="10" cols="40" class="ta_minimo_ancho"  readonly  id="codigo_embebido"  title="<bean:message key="agregaSlider.codigo" />" >${form.codigo}</textarea>
							</div>
						
						</div>
						
						
						
					</div>
					
					<!--		FIN CAJA DE FORMULARIO		-->
					
					
				</div>
			</div>
		</div>
	</div>
	
	<!--		FIN GLOBO GRIS		-->
	
	
	<!--		Boton siguiente		  -->
	
	<input class="boton_125 tipo ft_centrada"  type="submit"  value="<bean:message key='agregaSlider.botonVolver'/>" />


</form>

<!--		Fin del Formulario principal		-->

	

</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>