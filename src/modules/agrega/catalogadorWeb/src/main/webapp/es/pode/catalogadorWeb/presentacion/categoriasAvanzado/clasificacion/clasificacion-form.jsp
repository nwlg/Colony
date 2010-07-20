<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/categoriasAvanzado/clasificacion/clasificacion-form-vars.jspf" %>
<jsp:include page="/layout/messages.jsp" flush="true"/>

<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">
<form method="post" action="<html:rewrite action="/Clasificacion/ClasificacionFormEliminar" />" >
<p class="parrafo_comun" id="separacion2"><bean:message key="clasificacion.Explicacion"/></p>
 <div class="caja_tabla" >
	<c:set var="indice" value="1" />
	<c:set var="listaProposito" value="${catalogadorAvSession.listaProposito}"/> 		
	<bean:define id="summary"><bean:message key="clasificacion.tablaSummary"/></bean:define>
	<display:table name="${listadoClasificacion}" id="clasificacion" style="border:1;width:100%" class="administracion_noticias" cellpadding="0" 
	  cellspacing="0" summary="${summary}" requestURI="" sort="list" pagesize="10" partialList="false">
	  
		
	  <display:caption><strong> <bean:message key="clasificacion.tablaSummary"/></strong></display:caption>
      <display:setProperty name="css.tr.odd" value="tr_gris"/>
      <display:setProperty name="css.tr.even" value="tr_blanco"/>
      <display:setProperty name="basic.show.header" value="false"/>
      <display:setProperty name="paging.banner.placement" value="bottom" />
      <display:setProperty name="basic.msg.empty_list"><bean:message key="listaVaciaClasificaciones"/></display:setProperty>
      
      <display:column style="valign:top" class="sin_b">
		<input type="checkbox" name="tituloClasificacionRowSelectionAsArray" value="${indice }" title="<bean:message key="clasificacion.Seleccione"/>"/>	
	  </display:column>
	  <c:set var="propositoTra" value="${listaProposito[indice-1] }"/>
	  <display:column style="valign:top" class="new">
	  <logic:notEqual name="propositoTra" value="">
	  	<bean:message key="clasificacion.Clasificacion"/> ${indice } - ${propositoTra }
	  </logic:notEqual>
	  <logic:equal name="propositoTra" value="">
	  	<bean:message key="clasificacion.Clasificacion"/> ${indice }
	  </logic:equal>
	  </display:column>
	  
	  <display:column style="valign:top"> 
		<span class="oculto">-</span>
		<html:link action="/DetalleClasificacion/DetalleClasificacion?botonPulsado=Modificar&tituloClasificacion=${indice }">
			<bean:message key="clasificacion.Modificar" />
		</html:link>
	  </display:column>
	  <c:set var="indice" value="${indice + 1 }" />
    </display:table>    
 </div> 
 
<!-- Inicio Botones  -->
	<c:set var="numeroClasi" value="${fn:length(listadoClasificacion)}" />
	<fieldset class="tipo ft_centrada">
		<c:choose>
			<c:when test="${numeroClasi==0}">
				<button class="boton_125_de_2" disabled="disabled" type="submit"  value="<bean:message key="clasi.Eliminar"/>" >
					<bean:message key="clasi.Eliminar"/>
				</button>
			</c:when>
			<c:otherwise>
				<button class="boton_125_de_2"  type="submit"  value="<bean:message key="clasi.Eliminar"/>" >
					<bean:message key="clasi.Eliminar"/>
				</button>
			</c:otherwise>
		</c:choose>
</form>
	<form action="<html:rewrite action="/Clasificacion/ClasificacionFormCancelar"/>" method="post">
		<button class="boton_125_de_2_izq"  type="submit"  value="<bean:message key="clasi.InicioCatalogador"/>" >
			<bean:message key="clasi.InicioCatalogador"/>
		</button>
	</form>	
	<form action="<html:rewrite action="/DetalleClasificacion/DetalleClasificacion?botonPulsado=Crear"/>" method="post"><!-- CREAR-->
		<button class="boton_125" type="submit" value="<bean:message key="clasi.Crear"/>" >
			<bean:message key="clasi.Crear"/>
		</button>
	</form>
	
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->

</div>
<!-- Fin plantilla contenido  -->

</tiles:put>

</tiles:insert>