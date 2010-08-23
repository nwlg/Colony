<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado-verMetadatos">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/categoriasAvanzado/anotacion/listado-anotaciones-form-vars.jspf" %>


<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">
<form method="post" action="<html:rewrite action="/VerMetadatos/AnotacionesFormVuelveDeAnotaciones" />" >


<div class="caja_tabla" >
	<c:set var="indice" value="1" />
	<bean:define id="summary"><bean:message key="anotaciones.tablaSummary"/></bean:define>
	<display:table name="${listadoAnotaciones}" id="anotaciones" 
		style="border:1;width:100%" class="administracion_noticias" cellpadding="0" 
		cellspacing="0" 
		summary="${summary}"  requestURI="" sort="list" pagesize="10" partialList="False">				
	
		<display:caption><strong> <bean:message key="anotaciones.tablaSummary"/></strong></display:caption>
      		<display:setProperty name="css.tr.odd" value="tr_gris"/>
      		<display:setProperty name="css.tr.even" value="tr_blanco"/>
      		<display:setProperty name="basic.show.header" value="false"/>
      		<display:setProperty name="paging.banner.placement" value="bottom" />
      		<!-- definimos las columnas -->      
		  <display:column style="valign:top" class="new">
		  	<bean:message key="anotaciones.Anotacion"/> ${indice }
		  </display:column>
		  <display:column style="valign:top"> 
			<span class="oculto">-</span>
			<html:link action="/VerMetadatos/AnotacionesFormDetalleAnotacion?botonPulsado=Modificar&titulo=${indice }">
				<bean:message key="verAvanzado.ver"/>
			</html:link>
		 </display:column>
		 <c:set var="indice" value="${indice + 1 }" />	        
	</display:table>
</div>


<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<c:set var="numeroAnota" value="${fn:length(listadoAnotaciones)}" />
<fieldset class="tipo ft_centrada">
	<button class="boton_125" type="submit" name="accion" value="<bean:message key="verAvanzado.volver"/>"> 
		<bean:message key="verAvanzado.volver"/>
	</button>
</fieldset>	
	</form>
	
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->

</div>
<!-- Fin plantilla contenido  -->

</tiles:put>

</tiles:insert>