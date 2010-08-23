<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<tiles:insert definition="layout-administrador">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>

    <tiles:put name="body" type="string">
     
    
	<%@ include file="/taglib-imports.jspf" %>
	

		<!--************************             Inicio plantilla contenido         **************************  -->
		<div class="plantilla_contenido">
		
			<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
			<jsp:include page="/layout/messages.jsp" flush="true" />
 
	        <h2><bean:message key="crearTarea.cabecera2"/></h2>

			
			<html:form  styleId="crearTareaFormularioInformeFechasAceptarForm" action="/CrearTarea/FormularioInformeFechasAceptar" method="post" enctype="multipart/form-data" >
	        
				<!--  ********************     INICIO GLOBO GRIS   *********************  -->
				<div class="globo_gris" >
					<div class="globo_gris_01">
						<div class="globo_gris_02">
							<div class="globo_gris_03">
							<!--  *********************       INICIO CAJA DE FORMULARIO     *******************  -->
								<div id="formulario" >
									
									
									
									<!--  **********************         CAMPOS OCULTOS RECOGIDOS EN LA PANTALLA ANTERIOR      ******************-->
									
				                    <input type="hidden" name="trabajo" value="${form.trabajo}" />
									
				                    <input type="hidden" name="tipoTarea" value="${form.tipoTarea}" />
				                    	
									<input type="hidden" name="dia" value="${form.dia}" />
							   
									<input type="hidden" name="mes" value="${form.mes}" />
							  
									<input type="hidden" name="anio" value="${form.anio}" />
							 
									<input type="hidden" name="hora" value="${form.hora}" />
							 
									<input type="hidden" name="minutos" value="${form.minutos}" />
							 
									<input type="hidden" name="periodicidad" value="${form.periodicidad}" />
									
									<input type="hidden" name="msgInforme" value="<bean:message key="informe.crearInforme.msgInforme"/>" />
									
									<input type="hidden" name="msgNoInforme" value="<bean:message key="informe.crearInforme.msgNoInforme"/>" />
									
									<input type="hidden" name="msgDescTrabajo" value="<bean:message key="informe.crearInforme.msgDescTrabajo"/>" />
									
									<input type="hidden" name="informe" value="${form.informe}" />
									
									
									<!--  *********************       Caja de Texto de Nombre de Tarea     *******************  -->
									<div class="fila_de_tabla">
										<div class="contenedor_izquierda">
											<div class="text">
												<label for="informe"><bean:message key="informes.nombreInforme"/></label>
											</div>
										</div>
										<div class="contenedor_derecha">
											<div class="text">
												<label id="informe" style="width:400px;"><bean:message key="informes.${form.tipoTarea}"/></label>
												<br/>
											</div>
										</div>
										<div class="linea_separadora"></div>
										<br class="oculto" />
									</div>
									
									<!--  SI LA TAREA NO TIENE PERIODICIDAD SE MUESTRAN LAS FECHAS DESDE Y HASTA, EN CASO CONTRARIO NO SE MUESTRA  -->
									<c:if test="${form.periodicidad == 'N'}" >
							
											<!--  *********************       Cajas de Texto de Fecha Desde     *******************  -->
											<div class="fila_de_tabla">
												<div class="contenedor_izquierda">
													<div class="text">
														<label for="fecha_inicio"><bean:message key="informes.crearInforme.fechaDesde"/></label>
													</div>
												</div>
												<div class="contenedor_derecha"  id="cont_esp_fech">
						<div class="text"><label class="oculto" for="day1"><bean:message key="crearTarea.fechaDia"/></label><input  class="fechazo_02" value="" onblur="this.style.backgroundColor='#e1e1e1'" id="day1" name="diaDesde" type="text" title="<bean:message key="crearTarea.introduzcaDia"/> "/>
						<label class="oculto" for="month1"><bean:message key="crearTarea.mes"/></label><input class="fechazo_02" value="" onblur="this.style.backgroundColor='#e1e1e1'" id="month1" name="mesDesde" type="text" title="<bean:message key="crearTarea.introduzcaMes"/> "/>
						
						
			<label class="oculto"  for="year1" ><bean:message key="crearTarea.fechaAnio"/></label>
			<input class="fechazo_02" id="year1"  value="" onblur="this.style.backgroundColor='#e1e1e1'"  name="anioDesde" type="text" title="<bean:message key="crearTarea.introduzcaAnio"/> "/>
		</div>
				</div>
				<bean:define id="nomMeses"><bean:message key="catalogadorAvanzado.nombresMeses"/></bean:define>
                            <bean:define id="nomDias"><bean:message key="catalogadorAvanzado.nombresDias"/></bean:define>
				<div class="linea_separadora"></div>
												<br class="oculto" />
											</div>
											
											
											<!--  *********************       Cajas de Texto de Fecha Hasta    *******************  -->
											<div class="fila_de_tabla">
												<div class="contenedor_izquierda">
													<div class="text">
														<label for="fecha_inicio"><bean:message key="informes.crearInforme.fechaHasta"/></label>
													</div>
												</div>
												<div class="contenedor_derecha"  id="cont_esp_fech">
						<div class="text"><label class="oculto" for="day2"><bean:message key="crearTarea.fechaDia"/></label><input  class="fechazo_02" value="" onblur="this.style.backgroundColor='#e1e1e1'" id="day2" name="diaHasta" type="text" title="<bean:message key="crearTarea.introduzcaDia"/> "/>
						<label class="oculto" for="month2"><bean:message key="crearTarea.mes"/></label><input class="fechazo_02" value="" onblur="this.style.backgroundColor='#e1e1e1'" id="month2" name="mesHasta" type="text" title="<bean:message key="crearTarea.introduzcaMes"/> "/>
						
						
			<label class="oculto"  for="year2" ><bean:message key="crearTarea.fechaAnio"/></label>
			<input class="fechazo_02" id="year2"  value="" onblur="this.style.backgroundColor='#e1e1e1'"  name="anioHasta" type="text" title="<bean:message key="crearTarea.introduzcaAnio"/> "/>
			
		</div>
		
				</div>
				<div class="linea_separadora"></div>
												<br class="oculto" />
											</div>
							
											
									</c:if>
									
									
									<!-- *********************		CAMPO formato (desplegable)		********************* -->
								
									<div class="fila_de_tabla">
										<div class="contenedor_izquierda">
											<div class="text">
												<label for="formato"><bean:message key="informes.crearInforme.formato"/></label>
											</div>
										</div>
										<div class="contenedor_derecha">
											<div class="text">
												<html:select  style="width:107px" property="formato" titleKey="informes.crearInforme.seleccioneFormato" styleId="formato">
													<html:option key="informes.crearInforme.formato.html" 		value="html" />
													<html:option key="informes.crearInforme.formato.pdf" 		value="pdf" styleClass="oscura"/>
													<html:option key="informes.crearInforme.formato.excel"	 	value="excel" />
												</html:select>
											</div>
										</div>
										<div class="linea_separadora"></div>
										
										<br class="oculto" />
									</div>	
						 
						 
								</div >
								<!--  ********************     FIN CAJA FORMULARIO   *********************  -->
							</div>	
						</div>		
					</div>			
				</div>			
				<!--  ********************     FIN GLOBO GRIS   *********************  -->
				
				         
				<!--********************     Boton Aceptar      *********************  -->
					
				<bean:define id="aceptValue"><bean:message key="crearTarea.aceptar"/></bean:define>	
				<html:submit styleClass="boton_125_de_2 tipo" value="${aceptValue}" ></html:submit>
					
					
				</html:form>
				
				<!-- ********************     Fin Formulario     **************** -->
				
				
				<!-- ********************     Inicio Formulario secundario    **************** -->
				
				<form id="crearTareaFormularioInformeFechasCancelarForm" action="<html:rewrite action="/CrearTarea/FormularioInformeFechasCancelar"/>" method="post" >
				
				
					<!-- ********************     Boton cancelar    **************** -->
					
					<bean:define id="cancelValue"><bean:message key="crearTarea.cancelar"/></bean:define>
					<html:submit styleClass="boton_125_de_2_izq tipo" value="${cancelValue}"/>
					
				</form> 
				
				<!--********************     Fin formulario secundario      *********************  -->
		  
			


		</div>
		<!--************************             Fin plantilla contenido         **************************  -->
		
				
    </tiles:put>

</tiles:insert>
<script type="text/javascript">		
//<![CDATA[
	window.addEvent('domready', function() { 
		jsMeses = "${nomMeses}"; arrayMeses = jsMeses.split(",");
		jsDias = "${nomDias}"; arrayDias = jsDias.split(",");
		myCal1 = new Calendar({ year1: { day1: 'd', month1: 'm', year1: 'Y' }}, { direction: 0, tweak: {x: 6, y: 0} ,months: arrayMeses ,days: arrayDias });
			myCal2 = new Calendar({ year2: { day2: 'd', month2: 'm', year2: 'Y' }}, { direction: 0, tweak: {x: 6, y: 0} ,months: arrayMeses ,days: arrayDias });
			});
	//]]>
</script>
