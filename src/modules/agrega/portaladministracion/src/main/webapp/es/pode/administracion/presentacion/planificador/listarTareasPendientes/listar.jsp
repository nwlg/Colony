<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>


<tiles:insert definition="layout-administrador">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>

<%@ include file="/es/pode/administracion/presentacion/planificador/listarTareasPendientes/listar-vars.jspf" %>

<!-- *****************************   Inicio  Plantilla contenido      ********************************** -->
<div class="plantilla_contenido">

<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />

<!-- *****************************   Inicio  PESTANIAS de FICHA      ********************************** -->

	<div id="ficha_pestanias">
		<div><h2> <bean:message key="tareas.cabecera"/> </h2></div>
		<ul>
			<li id="pest_activa"><a href="<html:rewrite action="/ListarTareasPendientes/ListarTareasPendientes.do"/>" id="seleccionada"><bean:message key="tareas.Pendientes"/></a></li>
			<li><a href="<html:rewrite action="/ListarTareasEnEjecucion/ListarTareasEnEjecucion.do"/>"><bean:message key="tareas.Ejecutandose"/></a></li>
			<li><a href="<html:rewrite action="/ListarTareasEjecutadas/ListarTareasEjecutadas.do"/>"><bean:message key="tareas.Ejecutadas"/></a></li>
		</ul>
	</div>

<!-- *****************************   Fin  PESTANIAS de FICHA      ********************************** -->

<!-- ***************************** Inicio CONTENIDO PESTANIAS ****************************** -->


	<div class="interno_ficha">

		<div class="plantilla_contenido_pestanias">
			<fieldset>
			<!-- ******************************      Inicio del formulario    ************************************ -->
			<form id="listarTareasPendientesListarEliminarForm" action="<html:rewrite action='ListarTareasPendientes/ListarEliminar'/>" method="post" enctype="multipart/form-data">
			
				<!-- ******************************      CAJA TABLA     ************************************ -->
				<div class="caja_tabla">
					<bean:define id="valor" value="${form.tareaModificada}" scope="page"/>
					<bean:define id="atributo" value="trabajo" scope="page"/>
					<display:table name="${form.tareasPendientes}" requestURI=""
					export="false" id="fila" class="administracion_tareas" 
					style="border:1;width:100%;" cellpadding="0" cellspacing="0" 
					summary="${summary}" sort="list" pagesize="8"
					decorator="es.pode.administracion.presentacion.MarcarModificado">
					


					
			
						<display:setProperty name="css.tr.odd" value="tr_gris"/>
						<display:setProperty name="css.tr.even" value="tr_blanco"/>
						<display:setProperty name="basic.show.header" value="true"/>	
						
						<!--  ******************** COLUMNA DE CHECKBOX ***********************-->
					    
						<display:column style="valign:top;" class="sin_b">  
							<input type="checkbox" name="trabajoRowSelectionAsArray" value="${fila.trabajo}" title='<bean:message key="tareasPendientes.Seleccione"/>'/>
						</display:column>
						
					
						<!--  ******************** COLUMNA QUE MUESTRA LA TAREA **********************-->
						
						<bean:define id="trabajoValue"><bean:message key="tareas.cabeceraTrabajo"/></bean:define>
						<display:column sortable="true" sortProperty="trabajo" style="valign:top;" class="tar" title="${trabajoValue}">
							<html:link action="/ListarTareasPendientes/ListarMostrar?trabajo=${fila.trabajo}&grupoTrabajo=${fila.grupoTrabajo}&trigger=${fila.trigger}&grupoTrigger=${fila.grupoTrigger}">
                				${fila.trabajo}
            				</html:link>
            			</display:column>
						
						
						<!--  ******************** COLUMNA QUE MUESTRA LA PERIODICIDAD **********************-->
						<bean:define id="tareasValue"><bean:message key="tareas.cabeceraPeriodicidad"/></bean:define>
						<display:column property="periodicidad" sortable="true" sortProperty="periodicidad" style="valign:top;" class="fecha" title="${tareasValue}"></display:column>
						
						
						<!--  ******************** COLUMNA QUE MUESTRA LA FECHA **********************-->
						
						<bean:define id="fechaValue"><bean:message key="tareas.cabeceraFecha"/></bean:define>
						<display:column sortable="true" sortProperty="fechaInicio" style="valign:top;" class="tar5" title="${fechaValue}" >
							<fmt:formatDate value="${fila.fechaInicio}" pattern="dd/MM/yyyy, HH:mm"/>
						</display:column>
						
						
							
						<!--  ******************** COLUMNA QUE MUESTRA LA OPCION "MODIFICAR" *******************-->
						
						<display:column style="valign:top;"> 
							<html:link action="/ListarTareasPendientes/ListarModificar?trabajo=${fila.trabajo}&grupoTrabajo=${fila.grupoTrabajo}&trigger=${fila.trigger}&grupoTrigger=${fila.grupoTrigger}">
								<bean:message key="tareasPendientes.Modificar"/>
							</html:link>
				        </display:column>
						
						
						<!--  ******************** COLUMNA QUE MUESTRA LA OPCION "EJECUTAR" *******************-->
						
						<display:column style="valign:top;" class="ejec">
							<html:link action="/ListarTareasPendientes/ListarEjecutarTarea?trabajo=${fila.trabajo}&grupoTrabajo=${fila.grupoTrabajo}&trigger=${fila.trigger}&grupoTrigger=${fila.grupoTrigger}">
								<bean:message key="tareasPendientes.Ejecutar"/>
							</html:link>
				        </display:column>
					
					</display:table>
						
				<!-- No se cierra el div aqui porque se hace en el archivo displaytag.properties al paginar -->
				<!-- en caso de no tener registros de usuarios se tiene que poner el div		-->
			
				<c:if test="${fn:length(form.tareasPendientes) < 1}" >

            		</div>
                  
					<!--		Fin caja tabla		-->
				
           		</c:if>
				<!-- ******************************      FIN CAJA TABLA     ************************************ -->
				
				<!-- ******************************      Inicio de los Botones    ********************************** -->
		
						
				<!-- *********************    Boton Eliminar Tarea    ********************-->
				<c:if test="${!empty form.tareasPendientes}">
					<input class="boton_125_de_2" type="submit" value="<bean:message key='tareasPendientes.Eliminar'/>" />		
				</c:if>							
			</form>
			
			<!-- ******************************      Fin del formulario  con datos  ***************************************** -->
			
			
			<!-- ******************************      Inicio del formulario secundario  ***************************************** -->
			
			<form id="listarTareasPendientesListarCrearTareaForm" action="<html:rewrite action='ListarTareasPendientes/ListarCrearTarea'/>" method="post">
			
				<!-- *********************    Boton Crear Tarea    ********************-->
			
				<input class="boton_125_de_2_izq bot_mar_der" type="submit" value="<bean:message key='tareasPendientes.crearTarea'/>" />
				
			</form>
			</fieldset>
			<!-- ******************************      Fin del formulario secundario  ***************************************** -->
						
	

		</div>
	</div>
	
	<!-- ***************************** FIN  CONTENIDO PESTANIAS ****************************** -->
	
</div>
</tiles:put>
</tiles:insert>