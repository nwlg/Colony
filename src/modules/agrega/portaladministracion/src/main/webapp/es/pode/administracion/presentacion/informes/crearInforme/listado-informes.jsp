
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>


<tiles:insert definition="layout-administrador">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>


<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/es/pode/administracion/presentacion/informes/crearInforme/listado-informes-vars.jspf" %>


<!--		Inicio plantilla contenido		-->

<div class="plantilla_contenido">


<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />


	<!--		Inicio del formulario		-->

	<form id="crearInformeListadoInformesAceptarForm" action='<html:rewrite action="/CrearInforme/ListadoInformesAceptar"/>' method="post" target="blank">

		<h2><bean:message key="informes.crearInforme.cabecera"/></h2>
	
	
		<!--		Inicio de la caja_tabla		-->
		
		<div class="caja_tabla" >
		
		
		<display:table name="${form.informesAsArray}" uid="fila" requestURI=""
		        export="false" pagesize="8" sort="list" style="border:1;width:100%;" class="administracion_tareas"
				cellpadding="0" cellspacing="0" summary="${summary}"
				decorator="es.pode.administracion.presentacion.informes.crearInforme.MarcarInformePorDefecto">
				
				<display:setProperty name="css.tr.odd" value="tr_gris"/>
				<display:setProperty name="css.tr.even" value="tr_blanco"/>
				<display:setProperty name="basic.show.header" value="true"/>
				
				
				<!--		Columna de radio buton		-->
				
		        <display:column style="valign:top;" class="sin_b" property="check" title=""/>
				
				
				<!--		Columna de informes		-->
				
				<bean:define id="nodoValue"><b><bean:message key="informes.cabecera"/></b></bean:define>
				<display:column sortable="true" sortProperty="informe" style="valign:top;" class="tar" title="${nodoValue}">
					${fila.informe}
				</display:column>
				
				<!--		Columna	-->
				
				<display:column sortable="true" sortProperty="fila" style="valign:top;" class="tar" title="">
				
				</display:column>
								
		</display:table>
		
		
		<!-- </div> Fin de la caja tabla (SE CIERRA EN displaytag.properties) -->
		<!-- en caso de no tener registros de usuarios se tiene que poner el div		-->
			
			<c:if test="${fn:length(form.informesAsArray) < 1}" >

            	</div>
                  
				<!--		Fin caja tabla		-->
				
            </c:if>
		
	
	
		<!--		Boton de Aceptar		-->
	
		<input class="boton_125_de_2"  type="submit"  value="<bean:message key='comun.aceptar'/>" />
	
	</form>

	<!--		Fin del formulario		-->
	
	
</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>