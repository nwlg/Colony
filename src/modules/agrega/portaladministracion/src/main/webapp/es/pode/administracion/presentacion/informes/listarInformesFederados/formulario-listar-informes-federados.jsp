<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>


<tiles:insert definition="layout-administrador">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>


<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/es/pode/administracion/presentacion/informes/listarInformes/formulario-listar-informes-vars.jspf" %>



<!--		Inicio plantilla contenido		-->

<div class="plantilla_contenido">


<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />


<!--		Inicio  PESTANIAS de FICHA		 -->
	<div id="ficha_pestanias">
		<div><h2><bean:message key="informes.federados.cabecera"/></h2></div>
		<ul>
			<li><a href="<html:rewrite action="/ListarInformes/ListarInformes.do"/>"><bean:message key="informes.pestania.listado"/></a></li>
			<li id="pest_activa"><a href="<html:rewrite action="/ListarInformesFederados/ListarInformesFederados.do"/>" id="seleccionada"><bean:message key="informes.pestania.federados"/></a></li>
		</ul>
	</div>
	<!--		Fin  PESTANIAS de FICHA		-->
	
	<!--		Inicio CONTENIDO PESTANIAS		-->

	<div class="interno_ficha">
	<div class="plantilla_contenido_pestanias">
	<fieldset>
	<form id="listarInformesFederadosFormularioListarInformesFederadosEliminarForm" action='<html:rewrite action="/ListarInformesFederados/FormularioListarInformesFederadosEliminar"/>' method="post" >
	
	
		<!--		Inicio de la caja_tabla		-->
		
		<div class="caja_tabla" >
		
		<display:table name="${form.informes}" uid="fila" requestURI=""
		        export="false" pagesize="8" sort="list" style="border:1;width:100%;" class="administracion_tareas"
				cellpadding="0" cellspacing="0" summary="${summary}">
				
				<display:setProperty name="css.tr.odd" value="tr_gris"/>
				<display:setProperty name="css.tr.even" value="tr_blanco"/>
				<display:setProperty name="basic.show.header" value="true"/>
				
				
				<!--		Columna de checkbox		-->
				
				<display:column media="html" style="valign:top;" class="sin_b">
		            <input type="checkbox" name="nombreRowSelectionAsArray" value="${fila.nombre}" title='<bean:message key="informes.seleccione"/>'/>
		        </display:column>
				
				
				<!--		Columna de Logs		-->
				
				<bean:define id="informeValue"><b><bean:message key="informes.nombre.cabecera"/></b></bean:define>
				<display:column sortable="true" sortProperty="nombre" style="valign:top;" class="tar" title="${informeValue}">
					<html:link action="/ListarInformesFederados/FormularioListarInformesFederadosRecuperar?nombre=${fila.nombre}">
						${fila.nombre}
					</html:link>
				</display:column>
				
				<!--		Columna de Fecha		-->
				
				<bean:define id="fechaValue"><bean:message key="informes.fecha.cabecera"/></bean:define>
				<display:column sortable="true" sortProperty="fecha" title="${fechaValue}"  style="valign:top;" >
					<fmt:formatDate value="${fila.fecha}" pattern="dd/MM/yyyy, HH:mm"/>
				</display:column>

				
				
		</display:table>
		
		<!-- FIN CAJA TABLA -->
		<!-- </div> Fin de la caja tabla (SE CIERRA EN displaytag.properties) -->
		<!-- en caso de no tener registros de usuarios se tiene que poner el div		-->
		<!-- Inicio Botones  -->	
		<c:if test="${fn:length(form.informes) < 1}" >

            </div>

		</c:if>
		
		<c:if test="${fn:length(form.informes) > 0}" >
		
			<!--		Boton de Eliminar: Si no hay informes no aparece el boton		-->
		
				<input class="boton_125_de_2 tipo ft_centrada"  type="submit"  value="<bean:message key='informes.eliminar'/>" />
				
		</c:if>
		
	</form>

	<!--		Fin del formulario		-->
	
	
	<!--		Formulario secundario y boton CrearGrupo		-->
	
</fieldset>
</div>
<!-- Fin CONTENIDO PESTANIAS -->


</div>	
</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>