<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/categoriasAvanzado/anotacion/listado-anotaciones-form-vars.jspf" %>
<jsp:include page="/layout/messages.jsp" flush="true"/>

<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">
<form method="post" action="<html:rewrite action="/Anotacion/ListadoAnotacionesFormEliminar" />" >
<p class="parrafo_comun" id="separacion2"><bean:message key="anotaciones.Explicacion"/></p>

<div class="caja_tabla" >
	<c:set var="indice" value="1" />
	<bean:define id="summary"><bean:message key="anotaciones.tablaSummary"/></bean:define>
	<display:table name="${listadoAnotaciones}" id="anotaciones" 
		style="border:1;width:100%" class="administracion_noticias" cellpadding="0" 
		cellspacing="0" 
		summary="${summary}"  requestURI="" sort="list" pagesize="10" partialList="false">				
	
		<display:caption><strong> <bean:message key="anotaciones.tablaSummary"/></strong></display:caption>
      		<display:setProperty name="css.tr.odd" value="tr_gris"/>
      		<display:setProperty name="css.tr.even" value="tr_blanco"/>
      		<display:setProperty name="basic.show.header" value="false"/>
      		<display:setProperty name="paging.banner.placement" value="bottom" />
      		<display:setProperty name="basic.msg.empty_list"><bean:message key="listaVaciaAnotaciones"/></display:setProperty>
      		<!-- definimos las columnas -->
      		
        <display:column style="valign:top" class="sin_b">
			<input type="checkbox" name="tituloAnotacionRowSelectionAsArray" value="${indice }" title="<bean:message key="anotaciones.Seleccione"/>"/>	
		  </display:column>
		  <display:column style="valign:top" class="new">
		  	<bean:message key="anotaciones.Anotacion"/> ${indice }
		  </display:column>
		  <display:column style="valign:top"> 
			<span class="oculto">-</span>
			<html:link action="/Anotacion/ListadoAnotacionesFormDetalles?botonPulsado=Modificar&tituloAnotacion=${indice }">
				<bean:message key="anotaciones.Modificar" />
			</html:link>
		 </display:column>
		 <c:set var="indice" value="${indice + 1 }" />	        
	</display:table>
</div>


<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<c:set var="numeroAnota" value="${fn:length(listadoAnotaciones)}" />
<fieldset class="tipo ft_centrada">
		<c:choose>
			<c:when test="${numeroAnota==0}">
				<button class="boton_125_de_2" disabled="disabled" type="submit" name="accion" value="<bean:message key="anotaciones.Eliminar"/>"> 
					<bean:message key="anotaciones.Eliminar"/>
				</button>
			</c:when>
			<c:otherwise>
				<button class="boton_125_de_2" type="submit" name="accion" value="<bean:message key="anotaciones.Eliminar"/>"> 
					<bean:message key="anotaciones.Eliminar"/>
				</button>
			</c:otherwise>
		</c:choose>
</form>
	<form action="<html:rewrite action="/Anotacion/ListadoAnotacionesFormInicioAvanzado"/>" method="post">
		<button class="boton_125_de_2_izq" type="submit" name="accion" value="<bean:message key="anotaciones.InicioCatalogador"/>"> 
			<bean:message key="anotaciones.InicioCatalogador"/>
		</button>
	</form>	
	<form action="<html:rewrite action="/Anotacion/ListadoAnotacionesFormDetalles?botonPulsado=Crear"/>" method="post"><!-- CREAR-->
		<button class="boton_125" type="submit" name="accion" value="<bean:message key="anotaciones.Crear"/>"> 
			<bean:message key="anotaciones.Crear"/>
		</button>
	</form>
	
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->

</div>
<!-- Fin plantilla contenido  -->

</tiles:put>

</tiles:insert>