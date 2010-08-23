<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
 

<tiles:insert definition="layout-administrador">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/es/pode/administracion/presentacion/planificador/listarTareasEjecutadas/listar-vars.jspf" %>


<div class="plantilla_contenido">

<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />

<!-- *****************************   Inicio  PESTANIAS de FICHA      ********************************** -->

	<div id="ficha_pestanias">
		<div><h2> <bean:message key="tareas.cabecera"/> </h2></div>
		<ul>
			<li><a href="<html:rewrite action="/ListarTareasPendientes/ListarTareasPendientes.do"/>"><bean:message key="tareas.Pendientes"/></a></li>
			<li><a href="<html:rewrite action="/ListarTareasEnEjecucion/ListarTareasEnEjecucion.do"/>"><bean:message key="tareas.Ejecutandose"/></a></li>
			<li id="pest_activa"><a href="<html:rewrite action="/ListarTareasEjecutadas/ListarTareasEjecutadas.do" />" id="seleccionada"><bean:message key="tareas.Ejecutadas"/></a></li>
		</ul>
	</div>

<!-- *****************************   Fin  PESTANIAS de FICHA      ********************************** -->

<!-- ***************************** Inicio CONTENIDO PESTANIAS ****************************** -->


	<div class="interno_ficha">

		<div class="plantilla_contenido_pestanias">
			<fieldset>
			<!-- ******************************      Inicio del formulario    ************************************ -->
			<form id="listarTareasEjecutadasListarEliminarForm" action="<html:rewrite action='ListarTareasEjecutadas/ListarEliminar'/>" method="post" enctype="multipart/form-data">
			
				<!-- ******************************      CAJA TABLA     ************************************ -->
				<div class="caja_tabla">
					
					<display:table name="${form.tareasEjecutadas}" requestURI=""
					export="false" id="fila" class="administracion_tareas" 
					style="border:1;width:100%;" cellpadding="0" 
					cellspacing="0" summary="${summary}" sort="list" pagesize="8">
			
						<display:setProperty name="css.tr.odd" value="tr_gris"/>
						<display:setProperty name="css.tr.even" value="tr_blanco"/>
						<display:setProperty name="basic.show.header" value="true"/>	
						
						<!--  ******************** COLUMNA DE CHECKBOX ***********************-->
					    
						<display:column style="valign:top;" class="sin_b" >  
							<input type="checkbox" name="idRowSelectionAsArray" value="${fila.id}" title='<bean:message key="tareasEjecutadas.Seleccione"/>'/>
						</display:column>

					
						<!--  ******************** COLUMNA QUE MUESTRA LA TAREA **********************-->
						
						<bean:define id="trabajoValue"><bean:message key="tareas.cabeceraTrabajo"/></bean:define>
						<display:column property="trabajo" sortable="true" sortProperty="trabajo"  style="valign:top;" class="tar10" title="${trabajoValue}"/>
						
						
						<!--  ******************** COLUMNA QUE MUESTRA LA FECHA **********************-->
						
						<bean:define id="fechaValue"><bean:message key="tareas.cabeceraFecha"/></bean:define>
						<display:column sortable="true" sortProperty="fechaInicio" title="${fechaValue}"  style="valign:top;" >
							<fmt:formatDate value="${fila.fechaInicio}" pattern="dd/MM/yyyy, HH:mm"/>
						</display:column>
						
			
				        <!--  ******************** COLUMNA QUE MUESTRA ESTADO *******************-->
				        <bean:define id="estadoValue"><bean:message key="tareas.cabeceraEstado"/></bean:define>
						<display:column property="estado" sortable="true" sortProperty="estado" style="valign:top;" class="tar9" title="${estadoValue}"/>  
						
						
						<!--  ******************** COLUMNA QUE MUESTRA LA OPCION "VER INFORME" *******************-->
					
						<display:column style="valign:top;" class="ejec2">  
				            <html:link action="/Informe/Informe?id=${fila.id}"><bean:message key="tareasEjecutadas.VerInforme"/></html:link>
				        </display:column>
				        
					</display:table>
						
				<!-- No se cierra el div aqui porque se hace en el archivo displaytag.properties al paginar -->
				<!-- en caso de no tener registros de usuarios se tiene que poner el div		-->
			
				<c:if test="${fn:length(form.tareasEjecutadas) < 1}" >

            		</div>
                  
					<!--		Fin caja tabla		-->
				
            	</c:if>
            
				<!-- ******************************      FIN CAJA TABLA     ************************************ -->
				
				<!-- ******************************      Boton Ejecutar    ********************************** -->
				
				<c:if test="${!empty form.tareasEjecutadas}">
					<input class="boton_125_de_2" type="submit" value="<bean:message key='tareasEjecutadas.Eliminar'/>"/> 
				</c:if>					
				
				
			</form>
			</fieldset>
			<!-- ******************************      Fin del formulario    ***************************************** -->
				
				

		</div>
	</div>
	
	<!-- ***************************** FIN  CONTENIDO PESTANIAS ****************************** -->
	
</div>
</tiles:put>
</tiles:insert>

