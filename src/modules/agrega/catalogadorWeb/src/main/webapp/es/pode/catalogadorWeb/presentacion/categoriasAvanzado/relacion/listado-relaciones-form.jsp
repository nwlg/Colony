<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/categoriasAvanzado/relacion/listado-relaciones-form-vars.jspf" %>
<jsp:include page="/layout/messages.jsp" flush="true"/>

<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">
<form method="post" action="<html:rewrite action="/Relacion/ListadoRelacionesFormEliminar"/>">
<p class="parrafo_comun" id="separacion2"><bean:message key="relaciones.Explicacion"/></p>


<div class="caja_tabla" >
	<c:set var="indice" value="1" />
	<bean:define id="summary"><bean:message key="relaciones.tablaSummary"/></bean:define>
	<display:table name="${listadoRelaciones}" id="relacion" style="border:1;width:100%" class="administracion_noticias" cellpadding="0" 
		  cellspacing="0" summary="${summary}"  requestURI="" sort="list" pagesize="10" partialList="false">
		<display:caption><strong> <bean:message key="relaciones.tablaSummary"/></strong></display:caption>
		<display:setProperty name="css.tr.odd" value="tr_gris"/>
		<display:setProperty name="css.tr.even" value="tr_blanco"/>
		<display:setProperty name="basic.show.header" value="false"/>
		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:setProperty name="basic.msg.empty_list"><bean:message key="listaVaciaRelaciones"/></display:setProperty>
		
		
		<!-- definimos las columnas -->
		<display:column style="valign:top" class="sin_b">
				<input type="checkbox" name="tituloRelacionRowSelectionAsArray" value="${indice }" title="Seleccione"/>
		</display:column>
		<display:column style="valign:top" class="new">
			  	<bean:message key="relaciones.Relacion"/> ${indice }
		</display:column>
		<display:column style="valign:top"> 
				<span class="oculto">-</span>
				<html:link action="/Relacion/ListadoRelacionesFormDetallesRelacion?botonPulsado=Modificar&tituloRelacion=${indice }">
					<bean:message key="relaciones.Modificar" />
				</html:link>
		</display:column>
		<c:set var="indice" value="${indice + 1 }" />
	</display:table>
</div>

<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<c:set var="numeroRel" value="${fn:length(listadoRelaciones)}" />
	<fieldset class="tipo ft_centrada">
		<c:choose>
			<c:when test="${numeroRel==0}">
				<button class="boton_125_de_2" disabled="disabled" type="submit" name="accion" value="<bean:message key="relaciones.Eliminar"/>"> 
					<bean:message key="relaciones.Eliminar"/>
				</button>
			</c:when>
			<c:otherwise>
				<button class="boton_125_de_2" type="submit" name="accion" value="<bean:message key="relaciones.Eliminar"/>"> 
					<bean:message key="relaciones.Eliminar"/>
				</button>
			</c:otherwise>
		</c:choose>
</form>
<form action="<html:rewrite action="/Relacion/ListadoRelacionesFormCancelar"/>" method="post">
		<button class="boton_125_de_2_izq" type="submit" name="accion" value="<bean:message key="relaciones.InicioCatalogador"/>"> 
			<bean:message key="relaciones.InicioCatalogador"/>
		</button>
	</form>
	<form action="<html:rewrite action="/Relacion/ListadoRelacionesFormDetallesRelacion?botonPulsado=Crear"/>" method="post"><!-- CREAR-->
		<button class="boton_125" type="submit" name="accion" value="<bean:message key="relaciones.Crear"/>"> 
			<bean:message key="relaciones.Crear"/>
		</button>
	</form>	
	</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->

</div>
<!-- Fin plantilla contenido  -->

</tiles:put>

</tiles:insert>
	