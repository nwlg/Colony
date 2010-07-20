<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
 

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

	<h2><bean:message key="tareas.cabeceraDescripcion"/></h2>
	
	<!-- ***************************      Inicio del formulario    ************************************ -->
	
	<html:form styleId="informeMostrarDescripcionVolverForm" action="/Informe/MostrarDescripcionVolver" method="post" enctype="multipart/form-data">
	
		<!--  INICIO GLOBO GRIS   -->
		<div class="globo_gris" >
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">
						<!-- **********************       Inicio caja del formulario        ***********************  -->
						<div id="formulario" id="bordeada">
		
							<!-- ******************************      Caja Tabla     ************************************ -->
							<div class="lista_validacion">
								<input type="hidden" name="id" value="${form.id}" />
								
									${form.descripcion}
								
									
							</div>
							<!-- ******************************      Fin caja tabla     ************************************ -->
		
						</div>
						<!-- **********************       Fin caja del formulario        ***********************  -->
					</div>
				</div>
			</div>
		</div>
		<!--  FIN GLOBO GRIS   -->
		
		<!-- ******************************      Boton Volver     ********************************** -->
		
		<html:submit titleKey="informeTrabajo.volver" styleClass="boton_125_de_2 tipo"   styleId="form_submit" >
			<bean:message key='informeTrabajo.volver'/>
		</html:submit>	
		
		
	</html:form>
	<!-- ******************************      Fin del formulario    ***************************************** -->
	
	
			
	
	
</div>
<!-- ***************************** FIN  CONTENIDO  ****************************** -->


</tiles:put>
</tiles:insert>