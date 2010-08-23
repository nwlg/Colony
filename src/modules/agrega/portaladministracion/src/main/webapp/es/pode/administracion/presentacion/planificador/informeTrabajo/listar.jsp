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


<!-- ***************************** Inicio CONTENIDO  ****************************** -->
<div class="plantilla_contenido">

	<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
	<jsp:include page="/layout/messages.jsp" flush="true" />

	<!-- *********************      Cabecera Informe     ************************************ -->

	<h2>
		${form.trabajo}
	</h2>
	
	<!-- ***************************      Inicio del formulario    ************************************ -->
	
	<html:form styleId="informeListarListarTareasEjecutadasForm" action="/Informe/ListarListarTareasEjecutadas" method="post">
	
		<!--  INICIO GLOBO GRIS   -->
		<div class="globo_gris" >
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">
						<!-- **********************       Inicio caja del formulario        ***********************  -->
						<div id="formulario">
							
							<h3 class="column"><strong><bean:message key="tareas.tituloDescripcion"/></strong> <span> ${form.descripcion}</span></h3> 
							<h3 class="column"><strong><bean:message key="tareas.tituloFechaInicio"/></strong> <span> ${form.fechaInicio}</span></h3> 
							<h3 class="column"><strong><bean:message key="tareas.tituloFechaFin"/></strong> <span> ${form.fechaFin}</span></h3>
							
							<br />
							<!-- ******************************      Caja Tabla     ************************************ -->
							<div class="caja_tabla" id="bordeada">
								
								
								<display:table name="${form.informeTrabajo}" requestURI=""
									export="true" id="fila" class="administracion_tareas" 
									style="border:1;width:100%;" cellpadding="0" cellspacing="0" 
									summary="${summary}" sort="list" pagesize="20">
								
								
						
									<display:setProperty name="css.tr.odd" value="tr_gris"/>
									<display:setProperty name="css.tr.even" value="tr_blanco"/>
									<display:setProperty name="basic.show.header" value="true"/>	
									
									<!--  ******************** COLUMNA DE DESCRIPCION ***********************-->
									<bean:define id="descripcionValueExport"><bean:message key="tareas.cabeceraDescripcion.export"/></bean:define>
								    <display:column media="excel pdf"
            							title="${descripcionValueExport}" 
            							autolink="true" paramId="descripcion">
            							${fila.descripcion}
        							</display:column>
        							
								    <bean:define id="descripcionValue"><bean:message key="tareas.cabeceraDescripcion"/></bean:define>
									<display:column media="html" autolink="true" sortable="true" sortProperty="descripcion" title="${descripcionValue}" style="valign:top;" class="tar7" maxLength="90">  
										<html:link action="/Informe/ListarDescripcion?descripcion=${fila.descripcion}&id=${fila.id}" >
											${fila.descripcion}
										</html:link>							
									</display:column>
									
									<!--  ******************** COLUMNA DE FECHA **********************-->
									<bean:define id="fechaValue"><bean:message key="tareas.cabeceraFecha"/></bean:define>
									
									<display:column media="excel pdf"
            							title="${fechaValue}"
            							autolink="true" paramId="fecha">
            							<fmt:formatDate value="${fila.fecha}" pattern="dd/MM/yyyy, HH:mm"/>
        							</display:column>
        							
									<display:column media="html" sortable="true" sortProperty="fecha" title="${fechaValue}" style="valign:top;" class="tar6" >
										<fmt:formatDate value="${fila.fecha}" pattern="dd/MM/yyyy, HH:mm"/>
									</display:column>
									
									<!--  ******************** COLUMNA DE ESTADO **********************-->
									<bean:define id="estadoValue"><bean:message key="tareas.cabeceraEstado"/></bean:define>
									
									<display:column media="excel pdf"
            							title="${estadoValue}"
            							autolink="true" paramId="estado">
            							${fila.estado}
        							</display:column>
        							
									<display:column  media="html" sortable="true" sortProperty="estado" title="${estadoValue}" style="valign:top;" class="" >
										${fila.estado}
									</display:column>
								
								</display:table>
									
							<!-- No se cierra el div aqui porque se hace en el archivo displaytag.properties al paginar -->
							<!-- en caso de no tener registros de usuarios se tiene que poner el div		-->
			
							<c:if test="${fn:length(form.informeTrabajo) < 1}" >

            					</div>
                  
								<!--		Fin caja tabla		-->
				
            				</c:if>
							<!-- ******************************      Fin caja tabla     ************************************ -->
		
						</div>
						<!-- **********************       Fin caja del formulario        ***********************  -->
					</div>
				</div>
			</div>
		</div>
		<!--  FIN GLOBO GRIS   -->
		
		<!-- ******************************      Boton Volver    ********************************** -->
		
		<html:submit titleKey="informeTrabajo.volver" styleClass="boton_125_de_2 tipo" styleId="form_submit" >
			<bean:message key='informeTrabajo.volver'/>
		</html:submit>	
		
		
	</html:form>
	<!-- ******************************      Fin del formulario    ***************************************** -->
	
	
			
	
	
</div>
<!-- ***************************** FIN  CONTENIDO  ****************************** -->


</tiles:put>
</tiles:insert>