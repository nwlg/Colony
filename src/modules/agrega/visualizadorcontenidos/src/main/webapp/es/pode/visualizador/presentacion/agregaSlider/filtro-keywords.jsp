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

<h2><bean:message key="agregaSlider.palabrasClave.cabecera"/></h2>


<!--		Inicio del formulario principal		-->

<form id="agregaSliderFiltroKeywordsSiguienteForm" action='<html:rewrite action="/AgregaSlider/FiltroKeywordsSiguiente"/>' method="post" >

	<p class="parrafo_comun" id="separacion2"><bean:message key='agregaSlider.textoExplicativoKeywords'/></p>
	
	
	<!--		INICIO GLOBO GRIS		-->
	
	<div class="globo_gris" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
				
				
					<!--		INICIO CAJA DE FORMULARIO		-->
					
					<div id="formulario" >
					
					
						<!--		CAMPO DE keywords		-->
						
						<div class="fila_de_tabla">
							
							<div class="contenedor_izquierda">
		  						<div class="text"><label for="Tipo"><bean:message key="agregaSlider.palabras.texto"/></label></div>
		 					</div>
		 					
							<div class="contenedor_derecha">
					
								<div class="text">
									<label for="keywords"><span class="oculto"><bean:message key="agregaSlider.buscarKeywords"/></span></label>
									<input name="keywords" class="nombreGrupo" value="${form.keywords}" id="keywords" type="text" title="<bean:message key="agregaSlider.introduzcaKeywords"/>"  />
								</div>
							
							</div>
		  				
							<br class="oculto" />
						</div>
						
						
						
						<!--		CAMPO DE IDIOMA		-->
						
						<div class="fila_de_tabla">
  							
  							<div class="contenedor_izquierda">
  								<div class="text"><label for="Idioma"><bean:message key="agregaSlider.idioma.texto"/></label></div>
 							</div>
 							
							<div class="contenedor_derecha">
								
								<bean:define id="idiomaAlt"><bean:message key="agregaSlider.idioma.alt"/></bean:define>
								<c:choose>
			                        <c:when test="${!empty form.idiomasComboBackingList}">
			                           <html:select name="form" property="idiomasCombo" styleId="Idioma" title="${idiomaAlt}">
			                               <html:optionsCollection name="form" property="idiomasComboBackingList" label="label" value="value"/>
			                           </html:select>
			                        </c:when>
			                        <c:otherwise>
			                            <html:select name="form" property="idiomasCombo" styleId="Idioma" title="${idiomaAlt}"/>
			                        </c:otherwise>
			                    </c:choose>
								
							</div>
							
							<div class="linea_separadora"></div>
							<br class="oculto" />
						</div>
						
						
						
					</div>
					
					<!--		FIN CAJA DE FORMULARIO		-->
					
					
				</div>
			</div>
		</div>
	</div>
	
	<!--		FIN GLOBO GRIS		-->
	
	
	<!--		Boton siguiente		  -->
	
	<input class="boton_125 tipo ft_centrada"  type="submit"  value="<bean:message key='agregaSlider.botonSiguiente'/>" />


</form>

<!--		Fin del Formulario principal		-->

	

</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>