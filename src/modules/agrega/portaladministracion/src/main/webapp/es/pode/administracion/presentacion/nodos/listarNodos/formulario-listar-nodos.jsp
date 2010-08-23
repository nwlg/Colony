
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>


<tiles:insert definition="layout-administrador">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>


<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/es/pode/administracion/presentacion/nodos/listarNodos/formulario-listar-nodos-vars.jspf" %>


<!--		Inicio plantilla contenido		-->

<div class="plantilla_contenido">


<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />


	<!--		Inicio del formulario		-->

	<form id="listarNodosFormularioListarNodosEliminarForm" action='<html:rewrite action="/ListarNodos/FormularioListarNodosEliminar"/>' method="post" >

		<h2><bean:message key="nodos.cabecera"/></h2>
	
	
		<!--		Inicio de la caja_tabla		-->
		
		<div class="caja_tabla" >
		
		<display:table name="${form.nodos}" uid="fila" requestURI=""
		        export="false" pagesize="8" sort="list" style="border:1;width:100%;" class="administracion_tareas"
				cellpadding="0" cellspacing="0" summary="${summary}">
				
				<display:setProperty name="css.tr.odd" value="tr_gris"/>
				<display:setProperty name="css.tr.even" value="tr_blanco"/>
				<display:setProperty name="basic.show.header" value="true"/>
				
				
				<!--		Columna de checkbox		-->
				
				<display:column media="html" style="valign:top;" class="sin_b">
		            <input type="checkbox" name="idRowSelectionAsArray" value="${fila.id}" title='<bean:message key="nodos.seleccione"/>'/>
		        </display:column>
				
				
				<!--		Columna de Nodo		-->
				
				<bean:define id="nodoValue"><b><bean:message key="nodos.cabecera"/></b></bean:define>
				<display:column sortable="true" sortProperty="nodo" style="valign:top;" class="tar" title="${nodoValue}">
					<html:link action="/ListarNodos/FormularioListarNodosVerNodo?id=${fila.id}">
						${fila.nodo}
					</html:link>
				</display:column>
				
				
				<!--		Columna de Modificar		-->
				
				<display:column style="valign:top;">
					<html:link action="/ListarNodos/FormularioListarNodosModificarNodo?id=${fila.id}">
						<bean:message key="nodo.Modificar"/>
					</html:link>
				</display:column>
				
		</display:table>
		
		
		<!-- </div> Fin de la caja tabla (SE CIERRA EN displaytag.properties) -->
		<!-- en caso de no tener registros de usuarios se tiene que poner el div		-->
			
		<c:if test="${fn:length(form.nodos) < 1}" >

            </div>
                  
			<!--		Fin caja tabla		-->
				
		</c:if>
		
		
		<c:if test="${fn:length(form.nodos) > 0}" >
		
			<!--		Boton de Eliminar: Si no hay nodos no aparece el boton		-->
	
			<input class="boton_125_de_2 tipo"  type="submit"  value="<bean:message key='nodos.eliminar'/>" />
			
    	</c:if>
	
	</form>

	<!--		Fin del formulario		-->


	<!--		Formulario secundario y boton CrearGrupo		-->
	
	<form id="listarNodosFormularioListarNodosCrearNodoForm" action='<html:rewrite action="/ListarNodos/FormularioListarNodosCrearNodo"/>' method="post" >

		<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key='nodos.crearNodo'/>" />
	
	</form>
	
	
</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>