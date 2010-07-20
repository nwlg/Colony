<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>


<tiles:insert definition="${sessionScope.offline == true ? 'layout-offline' : 'layout-administrador'}">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">

<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">
<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />

<h2><bean:message key="resultadosBusqueda.anyadirObjeto"/></h2>
<!--  INICIO CAJA REDONDEADA BLANCA   -->		
<c:if test="${!empty form.seleccionados}">
	<div class="globo_gris" id="conmargen2" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
				<!--  Inicio CAJA DE FORMULARIO   -->
					<div id="formulario" >
<form method="post" action="<html:rewrite action="/ResultadosBuscarObjeto/ResultadosBusquedaAnadir" />">
				<html:link action="/ResultadosBuscarObjeto/ResultadosBusquedaEliminarTodos" styleClass="resultados_d" ><bean:message key="resultadosBusqueda.eliminarObjetos"/></html:link>
				<h3 ><bean:message key="resultadosBusqueda.objetosSeleccionados"/></h3>
<!--  INICIO CAPA TABLA   -->
<!--  INICIO CAPA TABLA   -->					
 <div class="caja_tabla bordeada"   >
<display:table name="${form.seleccionados}" id="fila" export="false" class="generica_02 sin_clear" cellpadding="0" cellspacing="0" summary="Tabla de Objetos seleccionados" sort="list" pagesize="8">
	<display:setProperty name="css.tr.odd" value="tr_gris"/>
	<display:setProperty name="css.tr.even" value="tr_blanco"/>
	<display:setProperty name="basic.show.header" value="false"/>	
	<!-- Columna de título -->
	<display:column style="valign:top;" class="td_larga"><span class="paquete">${fila.titulo}</span></display:column>
	<!-- Columna de enlace a Eliminar -->
	<c:if test="${!empty fila.localizadorODE}">
		<display:column style="valign:top;" class="td_corta_sin" ><html:link action="/ResultadosBuscarObjeto/ResultadosBusquedaEliminar?path=${fila.localizadorODE}"><bean:message key="comun.eliminar"/></html:link></display:column>
	</c:if>
 </display:table>
 
<fieldset class="ft_centrada"  ><input class="boton_125" name="action" type="submit"  value="<bean:message key="resultadosObjetos.anadir"/>"/></fieldset>
			<br/>
	<!--  FIN CAPA TABLA  La capa div de la tabla se cierra en el banner de paginacion -->		
</form>
</div>
<!--  FIN CAJA DE FORMULARIO   -->
				</div>
			</div>

		</div>
	</div>
</c:if>
	<!--  FIN CAJA REDONDEADA BLANCA   -->
<form method="post" action="<html:rewrite action="/ResultadosBuscarObjeto/ResultadosBusquedaSubmit" />">
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->

			<div id="formulario_02" >
			
 <div class="caja_tabla bordeada" >
 <bean:define id="sinResultados"><bean:message key="resultadosObjetos.sinResultados"/></bean:define>
<display:table name="${form.resultados}" id="resultado" class="administracion_tareas" cellpadding="0" cellspacing="0" summary="Tabla de Objetos Digitales" sort="list" pagesize="8">
	<display:setProperty name="css.tr.odd" value="tr_gris"/>
	<display:setProperty name="css.tr.even" value="tr_blanco"/>
	<display:setProperty name="basic.show.header" value="false"/>	
	<display:setProperty name="basic.empty.showtable" value="true"/>
	<display:setProperty name="basic.msg.empty_list_row"><tr class="tr_gris"><td valign="top" align="left"  class="tar2"><span>${sinResultados }</span></td></tr></display:setProperty>
	<display:column class="sin_b">
		<input type="checkbox"  name="localizadorODERowSelectionAsArray" value="${resultado.localizadorODE}" />
	</display:column>
	<display:column style="valign:top;" class="tar2">${resultado.titulo} </display:column>

</display:table>
</div>
	<!--  FIN CAPA TABLA  La capa div de la tabla se cierra en el banner de paginacion -->		

			
<!--  FIN CAJA DE FORMULARIO   -->


			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->	

<!-- Inicio Botones  -->
<!-- Inicio Botones  -->

<fieldset class="tipo ft_centrada">
<!-- Boton de Seleccionar-->
<input class="boton_125_de_2"  type="submit"  name="action" value="<bean:message key="comun.seleccionar"/>" />
<input class="boton_125_de_2_izq" type="submit" name="action" value="<bean:message key="comun.volver"/>" />
<input class="boton_125" type="submit" name="action" value="<bean:message key="comun.seleccionarTodos"/>" />
</fieldset>
</form>
		<!-- Fin Botones  -->

<!-- Fin Botones  -->
<!-- Fin Botones  -->
	

</div>
<!-- Fin plantilla contenido  -->

    </tiles:put>

</tiles:insert>
