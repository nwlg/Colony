<!-- *****************************************************************************************************
*********************************       Listar.jsp de Tareas Pendientes      ** ***********************************
******************************************************************************************************-->
  
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>


<tiles:insert definition="${sessionScope.offline == true ? 'layout-offline' : 'layout-administrador'}">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>


<!-- *****************************   Inicio  Plantilla contenido      ********************************** -->
<div class="plantilla_contenido">

<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />

<!-- *****************************   Inicio  PESTANIAS de FICHA      ********************************** -->

	<div id="ficha_pestanias">
		<div><h2> <bean:message key="tareas.cabeceraPendientes"/> </h2></div>
		<ul>
			<li id="pest_activa"><a href="<html:rewrite action="/ModificacionesPendientes/ModificacionesPendientes"/>" id="seleccionada"><bean:message key="tareas.Pendientes"/></a></li>
			<c:if test="${!offline}"><li><a href="<html:rewrite action="/ModificacionesPendientes/ListadoEjecutandose"/>"> <bean:message key="tareas.Ejecutandose"/></a></li></c:if>
			<li><a href="<html:rewrite action="/ModificacionesPendientes/ListadoEjecutadas"/>"> <bean:message key="tareas.Ejecutadas"/></a></li>
		</ul>
	</div>

<!-- *****************************   Fin  PESTANIAS de FICHA      ********************************** -->

<!-- ***************************** Inicio CONTENIDO PESTANIAS ****************************** -->


	<div class="interno_ficha">

		<div class="plantilla_contenido_pestanias">
			
			<!-- ******************************      Inicio del formulario    ************************************ -->
			<form id="modificacionesPendientesListadoSubmitForm" action="<html:rewrite action="/ModificacionesPendientes/ListadoSubmit"/>" method="post" enctype="multipart/form-data">
			
				<!-- ******************************      CAJA TABLA     ************************************ -->
				<div class="caja_tabla">
					<bean:define id="valor" value="${form.idModificacion}" scope="page"/>
					<bean:define id="atributo" value="idModificacion" scope="page"/>
					<display:table name="${form.modificaciones}" requestURI=""
					export="false" id="fila" class="administracion_tareas" 
					style="width:100%;" cellpadding="0" cellspacing="0" 
					summary="${summary}" sort="list" pagesize="8"
					decorator="es.pode.modificador.presentacion.pendientes.MarcarModificado" >
					
						<display:setProperty name="css.tr.odd" value="tr_gris"/>
						<display:setProperty name="css.tr.even" value="tr_blanco"/>
						<display:setProperty name="basic.show.header" value="false"/>	
	
						<!--  ******************** COLUMNA DE CHECKBOX ***********************-->

						<display:column style="valign:top;" class="sin_b"> 
							<input type="checkbox" name="idModificacionRowSelectionAsArray" value="${fila.idModificacion}" title='<bean:message key="tareasPendientes.Seleccione"/>'/>
						</display:column>
						
						<!--  ******************** COLUMNA QUE MUESTRA LA TAREA **********************-->
			
						<display:column style="valign:top;" class="tar">
								
                				${fila.nombre}
            			</display:column>
            	
            			<!--  ******************** COLUMNA QUE MUESTRA LA OPCION "MODIFICAR" *******************-->

						<display:column style="valign:top;" class="tar11"> 
							<html:link action="/ModificacionesPendientes/ListadoModificar?idModificacion=${fila.idModificacion}">
								<bean:message key="tareasPendientes.Modificar"/>
							</html:link>
				        </display:column>
        
            			<!--  ******************** COLUMNA EXPORTAR **********************-->

            			<display:column style="valign:top;" class="tar11">
							<html:link action="/ModificacionesPendientes/ListadoExportar?idModificacion=${fila.idModificacion}">
								<bean:message key="tareasPendientes.Exportar"/>
							</html:link>
				        </display:column>
					
							<!--  ******************** COLUMNA QUE MUESTRA LA FECHA (version on-line solo) **********************-->
						<c:if test="${!offline}">
		
								<display:column style="valign:top;" class="tar16">
								<c:if test="${!empty fila.fechaEjecucion}">
									<html:link action="/ModificacionesPendientes/ListadoPlanificar?idPlanificador=${fila.idPlanificador}&amp;idModificacion=${fila.idModificacion}">
										<bean:message key="link.planificar"/>
									</html:link>
								</c:if>
								<c:if test="${empty fila.fechaEjecucion}">
									<html:link action="/ModificacionesPendientes/ListadoPlanificar?idPlanificador=${fila.idPlanificador}&amp;idModificacion=${fila.idModificacion}">
										<bean:message key="link.sinPlanificar"/>
									</html:link>
								</c:if>
								</display:column>
							
						</c:if>
						
						
						<!--  ******************** COLUMNA QUE MUESTRA LA OPCION "EJECUTAR" *******************-->

							<display:column style="valign:top;" class="ejec">
								<html:link action="/ModificacionesPendientes/ListadoEjecutar?idModificacion=${fila.idModificacion}">
									<bean:message key="tareasPendientes.Ejecutar"/>
								</html:link>
					        </display:column>
					
					</display:table>

						
				<!-- No se cierra el div aqui porque se hace en el archivo displaytag.properties al paginar -->
				<!-- en caso de no tener registros de usuarios se tiene que poner el div		-->
			
				<c:if test="${fn:length(form.modificaciones) < 1}" >

            		</div>
                  
					<!--		Fin caja tabla		-->
				
           		</c:if>
           		
           		<hr />

				<!-- ******************************      FIN CAJA TABLA     ************************************ -->
<!--  FIN PAGINACION   -->		

<!-- Inicio Botones  -->

<!-- Inicio Botones  -->

<fieldset class="tipo">			
	<c:if test="${fn:length(form.modificaciones) > 0}" >			
		<input class="boton_125_de_2" name="action" type="submit" value="<bean:message key="modificacionesPendientes.eliminar"/>" />		
	</c:if>
	<br class="oculto" /><br class="oculto" />
	<input class="boton_125_de_2_izq bot_mar_der" name="action" type="submit" value="<bean:message key="modificacionesPendientes.crearTarea"/>" />				
	<input class="boton_125_de_2_izq bot_mar_der" name="action" type="submit" value="<bean:message key="modificacionesPendientes.importarTarea"/>" />
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
			</form>
			
			<!-- ******************************      Fin del formulario  con datos  ***************************************** -->
		</div>
	</div>
	
	<!-- ***************************** FIN  CONTENIDO PESTANIAS ****************************** -->
	
</div>
</tiles:put>
</tiles:insert>