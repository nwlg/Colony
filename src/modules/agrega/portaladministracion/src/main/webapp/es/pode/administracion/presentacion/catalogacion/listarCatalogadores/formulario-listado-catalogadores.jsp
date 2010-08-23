<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>


<tiles:insert definition="layout-administrador">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>



<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/es/pode/administracion/presentacion/adminusuarios/listarUsuarios/formulario-listado-usuarios-vars.jspf" %>


<!--		Inicio plantilla contenido		-->

<div class="plantilla_contenido">


<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />


	<!--		Inicio del formulario		-->

	<form id="listarCatalogadoresFormularioListadoCatalogadoresEliminarCatalogadoresForm" action='<html:rewrite action="/ListarCatalogadores/FormularioListadoCatalogadoresEliminarCatalogadores"/>' method="post" >

		<h2><bean:message key="gruposTrabajo.cabecera"/></h2>
	
	
		<!--		Inicio de la caja_tabla		-->
		
		<div class="caja_tabla" >
		<bean:define id="valor" value="${form.idModificado}" scope="page"/>
		<bean:define id="atributo" value="identificador" scope="page"/>
		<display:table name="${form.gruposTrabajo}" uid="fila" requestURI=""
		        export="false" pagesize="8" sort="list" style="border:1;width:100%;" class="administracion_tareas"
				cellpadding="0" cellspacing="0" summary="${summary}"
				decorator="es.pode.administracion.presentacion.MarcarModificado">
				
				<display:setProperty name="css.tr.odd" value="tr_gris"/>
				<display:setProperty name="css.tr.even" value="tr_blanco"/>
				<display:setProperty name="basic.show.header" value="true"/>
				
				
				<!--		Columna de checkbox		-->
				
				<display:column media="html" style="valign:top;" class="sin_b">
					<logic:equal name="fila" property="nombre" value="Todos" >
			            <input DISABLED type="checkbox" name="identificadorRowSelectionAsArray" value="${fila.identificador}" title='<bean:message key="usuarios.seleccione"/>'/>
			        </logic:equal>
			        <logic:notEqual name="fila" property="nombre" value="Todos" >
			        	<input type="checkbox" name="identificadorRowSelectionAsArray" value="${fila.identificador}" title='<bean:message key="usuarios.seleccione"/>'/>
			        </logic:notEqual>
		        </display:column>
				
				
				<!--		Columna de Usuario		-->
				
				<bean:define id="grupoValue"><b><bean:message key="gruposTrabajo.cabecera"/></b></bean:define>
				<display:column sortable="true" sortProperty="nombre" style="valign:top;" class="tar" title="${grupoValue}">
					<html:link action="/ListarCatalogadores/FormularioListadoCatalogadoresVerCatalogadores?id=${fila.identificador}">
						${fila.nombre}
					</html:link>
				</display:column>
				
				
				<!--		Columna de Modificar		-->
				
				<display:column style="valign:top;">
					<html:link action="/ListarCatalogadores/FormularioListadoCatalogadoresModificarCatalogadores?id=${fila.identificador}">
						<bean:message key="tareasPendientes.Modificar"/>
					</html:link>
				</display:column>
				
		</display:table>
		
		
		<!-- </div> Fin de la caja tabla (SE CIERRA EN displaytag.properties) -->
		<!-- en caso de no tener registros de usuarios se tiene que poner el div		-->
			
		<c:if test="${fn:length(form.gruposTrabajo) < 1}" >

           	</div>
                 
			<!--		Fin caja tabla		-->
			
      	</c:if>
		
	
		<!--		Boton de Eliminar: Si hay ningun grupo no aparece el boton		-->
		
		<c:if test="${fn:length(form.gruposTrabajo) > 0}" >
	
			<input class="boton_125_de_2 tipo"  type="submit"  value="<bean:message key='grupos.eliminar'/>" />
	
		</c:if>
		
	</form>

	<!--		Fin del formulario		-->


	<!--		Formulario secundario y boton CrearGrupo		-->
	
	<form id="listarCatalogadoresFormularioListadoCatalogadoresCrearCatalogadoresForm" action='<html:rewrite action="/ListarCatalogadores/FormularioListadoCatalogadoresCrearCatalogadores"/>' method="post" >

		<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key='gruposTrabajo.crearGrupo'/>" />
	
	</form>
	
	
</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>



</tiles:insert>