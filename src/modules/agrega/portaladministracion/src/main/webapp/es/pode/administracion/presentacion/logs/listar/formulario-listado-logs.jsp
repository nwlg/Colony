<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>


<tiles:insert definition="layout-administrador">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>


<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/es/pode/administracion/presentacion/logs/listar/formulario-listado-logs-vars.jspf" %>


<!--		Inicio plantilla contenido		-->

<div class="plantilla_contenido">


<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />


	<!--		Inicio del formulario		-->

	<form id="listarLogFormularioListadoLogsEliminarForm" action='<html:rewrite action="/ListarLog/FormularioListadoLogsEliminar"/>' method="post" >

		<h2><bean:message key="logs.cabecera"/></h2>
	
	
		<!--		Inicio de la caja_tabla		-->
		
		<div class="caja_tabla" >
		
		<display:table name="${form.logs}" uid="fila" requestURI=""
		        export="false" pagesize="8" sort="list" style="border:1;width:100%;" class="administracion_tareas"
				cellpadding="0" cellspacing="0" summary="${summary}">
				
				<display:setProperty name="css.tr.odd" value="tr_gris"/>
				<display:setProperty name="css.tr.even" value="tr_blanco"/>
				<display:setProperty name="basic.show.header" value="true"/>
				
				
				<!--		Columna de checkbox		-->
				
				<display:column media="html" style="valign:top;" class="sin_b">
		            <input type="checkbox" name="nombreRowSelectionAsArray" value="${fila.nombre}" title='<bean:message key="logs.seleccione"/>'/>
		        </display:column>
				
				
				<!--		Columna de Logs		-->
				
				<bean:define id="logValue"><b><bean:message key="logs.nombre.cabecera"/></b></bean:define>
				<display:column sortable="true" sortProperty="nombre" style="valign:top;" class="tar" title="${logValue}">
					<html:link action="/ListarLog/FormularioListadoLogsRecuperar?nombre=${fila.nombre}">
						${fila.nombre}
					</html:link>
				</display:column>
				
				
				<!--		Columna de Tamaño		-->
				
				<bean:define id="logValue"><b><bean:message key="logs.size.cabecera"/></b></bean:define>
				<display:column sortable="true" sortProperty="size" style="valign:top;text-align:right;" class="tar" title="${logValue}">
					${fila.size}
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</display:column>
				
				
		</display:table>
		
		
		<!-- </div> Fin de la caja tabla (SE CIERRA EN displaytag.properties) -->
		<!-- en caso de no tener registros de usuarios se tiene que poner el div		-->
			
		<c:if test="${fn:length(form.logs) < 1}" >

            </div>
                  
			<!--		Fin caja tabla		-->
				
		</c:if>
	
	
		<!--		Boton de Eliminar: Si no hay ningun logs no se muestra el boton		-->
		
		<c:if test="${fn:length(form.logs) > 0}" >
	
			<input class="boton_125_de_2 tipo"  type="submit"  value="<bean:message key='logs.eliminar'/>" />
				
    	</c:if>
	
	</form>

	<!--		Fin del formulario		-->

	
</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>



</tiles:insert>