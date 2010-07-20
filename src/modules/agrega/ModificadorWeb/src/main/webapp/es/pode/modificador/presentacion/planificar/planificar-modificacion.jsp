<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<tiles:insert definition="${sessionScope.offline == true ? 'layout-offline' : 'layout-administrador'}">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>

	<!-- ************************     INICIO DEL BODY     *************************  -->
    <tiles:put name="body" type="string">
    
	<%@ include file="/taglib-imports.jspf" %>
	
	
	<!-- ************************     INICIO PLANTILLA CONTENIDO     *************************  -->
    <div class="plantilla_contenido">
    
    <!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
	<jsp:include page="/layout/messages.jsp" flush="true" />

	<h2><bean:message key="crearTarea.cabecera"/></h2>
	<form id="planificarPlanificarModificacionPlanificarForm" action="<html:rewrite action="/Planificar/PlanificarModificacionPlanificar"/>" method="post" enctype="multipart/form-data">
	<p class="parrafo_comun" id="separacion2"><bean:message key="crearTarea.instrucciones"/></p>
		<!--  ********************     INICIO GLOBO GRIS   *********************  -->
		<div class="globo_gris" id="ficha">
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">
					<!--  *********************       INICIO CAJA DE FORMULARIO     *******************  -->
						<div id="formulario" >
							<div class="yui-skin-sam">
								
							<!--  *********************       Cajas de Texto de Fecha     *******************  -->
							<div class="fila_de_tabla">
								<div class="contenedor_izquierda">
			  						<div class="text"><label for="date1"><bean:message key="crearTarea.fechaInicio"/></label></div>
			 					</div>
								<div class="contenedor_derecha">
									<div class="text">
										<c:choose>
											<c:when test="${empty form.fecha }">
												<bean:define id="fechainicial" value="dd/mm/aaaa"/>
											</c:when>
											<c:otherwise>
												<bean:define id="fechainicial" value="${form.fecha}"/>
											</c:otherwise>
										</c:choose>
										<input type="hidden" name="idModificacion" value="${form.idModificacion}" />
										<input type="text" class="fechazo" value="${fechainicial }"  onblur="this.style.backgroundColor='#e1e1e1'" name="fecha" id="date1" title="<bean:message key="crearTarea.introduzcaFecha"/>"  />
										<script type="text/javascript">		
										//<![CDATA[
											window.addEvent('domready', function() { 
											myCal1 = new Calendar({ date1:'d/m/Y'} , { direction: 0, tweak: {x: 6, y: 0} }); });
											//]]>
										</script>										
										<span class="vert"><bean:message key="crearTarea.aLas"/></span>
										
										<label class="oculto" for="fecha_hora"><bean:message key="crearTarea.fechaHora"/></label>
										<input name="horas" value="${form.horas}" maxlength="2" class="fecha_horas" id="fecha_hora" type="text" title="<bean:message key="crearTarea.introduzcaHora"/> "  />
										
										<label class="oculto" for="fecha_minutos"><bean:message key="crearTarea.fechaMinuto"/></label>
										<input name="minutos" value="${form.minutos}" maxlength="2" class="fecha_minutos" id="fecha_minutos" type="text" title="<bean:message key="crearTarea.introduzcaMinuto"/> "  />
										
									</div>
								</div>
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>
							</div>
							</div>
						<!--  ********************     FIN CAJA FORMULARIO   *********************  -->
				</div>		
			</div>			
		</div>			
	</div>
		<!--  ********************     FIN GLOBO GRIS   *********************  -->
		
		<!--********************     Boton Continuar      *********************  -->
		<fieldset class="tipo ft_centrada">
			<input class="boton_125_de_2" name="action" type="submit" value="<bean:message key="comun.aceptar"/>" />
			<input class="boton_125_de_2_izq"  name="action" type="submit"  value="<bean:message key="comun.cancelar"/>" />	
		</fieldset>
	
	<!-- ********************     Inicio Formulario secundario    **************** -->
			
	</form>
	
	<!--********************     Fin formulario secundario      *********************  -->			


	</div>
	<!-- ************************     FIN  PLANTILLA  CONTENIDO   *************************  -->
	

    </tiles:put>
	<!-- ************************     FIN DEL BODY     *************************  -->

</tiles:insert>
