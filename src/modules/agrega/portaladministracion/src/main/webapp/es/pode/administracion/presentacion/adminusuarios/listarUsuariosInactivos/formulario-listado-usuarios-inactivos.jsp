<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>


<tiles:insert definition="layout-administrador">


<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">


<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/es/pode/administracion/presentacion/adminusuarios/listarUsuariosInactivos/formulario-listado-usuarios-inactivos-vars.jspf" %>


<!--		Inicio plantilla contenido		-->

<div class="plantilla_contenido">


<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />
	

	<!--		Inicio  PESTANIAS de FICHA		 -->

	<div id="ficha_pestanias">
		<div><h2><bean:message key="usuarios.desactivados.cabecera"/></h2></div>
		<ul>
			<li><a href="<html:rewrite action="/ListarUsuarios/ListarUsuarios.do"/>" ><bean:message key="usuarios.pestania.listado"/></a></li>
			<li id="pest_activa"><a href="<html:rewrite action="/ListarUsuariosInactivos/ListarUsuariosInactivos.do"/>" id="seleccionada"><bean:message key="usuarios.pestania.desactivados"/></a></li>
			<!--  <li><a href="/${initParam.url_portaladministracion}/ListarUsuariosPendientes/ListarUsuariosPendientes.do"><bean:message key="usuarios.pestania.pendientes"/></a></li>-->
		</ul>
	</div>

	<!--		Fin  PESTANIAS de FICHA		-->


	<!--		Inicio CONTENIDO PESTANIAS		-->

	<div class="interno_ficha">
	<div class="plantilla_contenido_pestanias">
		

		<!--		Inicio del formulario		-->
	<fieldset>
		<form id="listarUsuariosInactivosFormularioListadoUsuariosInactivosBajaForm" action='<html:rewrite action="/ListarUsuariosInactivos/FormularioListadoUsuariosInactivosBaja"/>' method="post" >
	
	
			<!--		Inicio de la caja_tabla		-->
			
			<div class="caja_tabla" >
			
			<display:table name="${form.usuarios}" uid="fila" requestURI=""
			        export="true" pagesize="8" sort="list" style="border:1;width:100%;" class="administracion_tareas"
					cellpadding="0" cellspacing="0" summary="${summary}">
					
					<display:setProperty name="css.tr.odd" value="tr_gris"/>
					<display:setProperty name="css.tr.even" value="tr_blanco"/>
					<display:setProperty name="basic.show.header" value="true"/>
			
					
					<!--		Columna de checkbox	(html)	-->
					
					<display:column media="html" style="valign:top;" class="sin_b">
			            <input type="checkbox" name="idRowSelectionAsArray" value="${fila.id}" title='<bean:message key="usuarios.seleccione"/>'/>
			        </display:column>
					
					
					<!--		Columna de Usuario (html y exportada)		-->
					
					<bean:define id="usuarioValueExport"><bean:message key="usuarios.cabecera"/></bean:define>
				    <display:column media="excel pdf" title="${usuarioValueExport}" autolink="true" paramId="usuario">
							${fila.usuario}
					</display:column>
		        							
					<bean:define id="usuarioValue"><b><bean:message key="usuarios.cabecera"/></b></bean:define>
					<display:column media="html" sortable="true" sortProperty="usuario" style="valign:top;" class="tar" title="${usuarioValue}">
						<html:link action="/ListarUsuariosInactivos/FormularioListadoUsuariosInactivosVerUsuarioInactivo?id=${fila.id}">
							${fila.usuario}
						</html:link>	
					</display:column>
					
					
					<!--		Columna de fecha	(html)	-->
					
					<bean:define id="fechaValue"><bean:message key="tareas.cabeceraFecha"/></bean:define>
						<display:column sortable="true" sortProperty="fechaDesactivacion" title="${fechaValue}"  style="valign:top;" >
							<fmt:formatDate value="${fila.fechaDesactivacion}" pattern="dd/MM/yyyy"/>
						</display:column>
					
			        
			        
			        <!--		Columna de Activar	(html)	-->
					
					<display:column media="html" style="valign:top;"> 
						<html:link action="/ListarUsuariosInactivos/FormularioListadoUsuariosInactivosActivarUsuario?id=${fila.id}">
							<bean:message key="usuarios.activar"/>
						</html:link>
			        </display:column>
					
					
					<!--		COLUMNAS PARA SER EXPORTADAS		-->
					
					<!--		Columna Nombre	(exportada)	-->
					
					<bean:define id="nombreValueExport"><bean:message key="usuarios.nombre.cabecera"/></bean:define>
				    <display:column media="excel pdf" title="${nombreValueExport}" autolink="true" paramId="nombre">
							${fila.nombre}
					</display:column>
					
					
					<!--		Columna Apellido1	(exportada)	-->
					
					<bean:define id="apellido1ValueExport"><bean:message key="usuarios.apellido1.cabecera"/></bean:define>
				    <display:column media="excel pdf" title="${apellido1ValueExport}" autolink="true" paramId="apellido1">
							${fila.apellido1}
					</display:column>
					
					
					<!--		Columna Apellido2	(exportada)	-->
					
					<bean:define id="apellido2ValueExport"><bean:message key="usuarios.apellido2.cabecera"/></bean:define>
				    <display:column media="excel pdf" title="${apellido2ValueExport}" autolink="true" paramId="apellido2">
							${fila.apellido2}
					</display:column>
					
					
					<!--		Columna tipo empaquetador	(exportada)	-->
					
					<bean:define id="tipoEmpaquetadorValueExport"><bean:message key="usuarios.tipoEmpaquetador.cabecera"/></bean:define>
				    <display:column media="excel pdf" title="${tipoEmpaquetadorValueExport}" autolink="true" paramId="tipoEmpaquetador">
							${fila.tipoEmpaquetador}
					</display:column>
					
					
					<!--		Columna idioma aplicaciones	(exportada)	-->
					
					<bean:define id="idiomaValueExport"><bean:message key="usuarios.idioma.cabecera"/></bean:define>
				    <display:column media="excel pdf" title="${idiomaValueExport}" autolink="true" paramId="idioma">
							<bean:message key="crearTarea.Export.${fila.idioma}"/>
					</display:column>
					
					
					<!--		Columna idioma consulta	(exportada)	-->
					
					<bean:define id="idiomaBusquedaValueExport"><bean:message key="usuarios.idiomaBusqueda.cabecera"/></bean:define>
				    <display:column media="excel pdf" title="${idiomaBusquedaValueExport}" autolink="true" paramId="idiomaBusqueda">
							<bean:message key="crearTarea.Export.${fila.idiomaBusqueda}"/>
					</display:column>
					
					
			</display:table>
		
		
			<!-- </div>		Fin de la caja tabla (SE CIERRA EN displaytag.properties)		-->
			<!-- en caso de no tener registros de usuarios se tiene que poner el div		-->
			
			<c:if test="${fn:length(form.usuarios) < 1}" >

            	</div>
                  
				<!--		Fin caja tabla		-->
				
            </c:if>

	
			<!--		Boton de eliminar: Si no hay usuarios no aparece el boton		-->
			
			<c:if test="${fn:length(form.usuarios) > 0}" >
				<input class="boton_125_de_2"  type="submit"  value="<bean:message key='usuarios.eliminar'/>" />
			</c:if>
			
			</form>
	
		<!--		Fin del formulario		-->
	

		</fieldset>


	</div>
	</div>
	
	<!--		Fin CONTENIDO PESTANIAS		-->	
	
	
</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>