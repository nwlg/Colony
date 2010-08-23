
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>


<tiles:insert definition="layout-administrador">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>


<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/es/pode/administracion/presentacion/monitorizarnodos/monitorizar/formulario-monitorizar-nodos-vars.jspf" %>


<!--		Inicio plantilla contenido		-->

<div class="plantilla_contenido">


<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />


	<!--		Inicio del formulario		-->

	<form id="monitorizarNodosMonitorizarNodosForm">

		<h2><bean:message key="monitorizarnodos.cabecera"/></h2>
	
	
		<!--		Inicio de la caja_tabla		-->
		
		<div class="caja_tabla" >
		
		<display:table name="${form.estados}" uid="fila" requestURI=""
		        export="false" pagesize="8" sort="list" style="border:1;width:100%;" class="administracion_tareas"
				cellpadding="0" cellspacing="0" summary="${summary}">
				
				<display:setProperty name="css.tr.odd" value="tr_gris"/>
				<display:setProperty name="css.tr.even" value="tr_blanco"/>
				<display:setProperty name="basic.show.header" value="true"/>
				
				
				<!--		Columna de Nodo		-->
				
				<bean:define id="nodoValue"><b><bean:message key="monitorizar.nodo"/></b></bean:define>
				<display:column sortable="true" sortProperty="nodo" style="valign:top;" class="tar" title="${nodoValue}">
						${fila.nodo}
				</display:column>
				
				<!--		Columna de Servicio		-->
				
				<bean:define id="servicioValue"><b><bean:message key="monitorizar.servicio"/></b></bean:define>
				<display:column sortable="true" sortProperty="descripcionServicio" style="valign:top;" class="tar" title="${servicioValue}">
						${fila.descripcionServicio}
				</display:column>

				<!--		Columna de Estado		-->
				
				<bean:define id="estadoValue"><b><bean:message key="monitorizar.estado"/></b></bean:define>
				<display:column sortable="true" sortProperty="estado" style="valign:top;" class="tar" title="${estadoValue}">
						<bean:message key="${fila.estado}"/>
				</display:column>
				
		</display:table>
		
		
		<!-- </div> Fin de la caja tabla (SE CIERRA EN displaytag.properties) -->
		<!-- en caso de no tener registros de usuarios se tiene que poner el div		-->
			
		<c:if test="${fn:length(form.estados) < 1}" >

            </div>
                  
			<!--		Fin caja tabla		-->
				
		</c:if>
		
		
	
	</form>

	<!--		Fin del formulario		-->

</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>