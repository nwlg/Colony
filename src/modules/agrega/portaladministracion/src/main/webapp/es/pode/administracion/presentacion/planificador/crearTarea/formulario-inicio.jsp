<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>


<tiles:insert definition="layout-administrador">

<tiles:put name="title" type="string">
</tiles:put>


    <tiles:put name="body" type="string">
   
    
	<!-- ************************     INICIO PLANTILLA CONTENIDO     *************************  -->
    <div class="plantilla_contenido">
    
    <!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
	<jsp:include page="/layout/messages.jsp" flush="true" />

	<h2><bean:message key="crearTarea.cabecera"/></h2>
	<html:form styleId="crearTareaFormularioInicioCrearTareaForm" action='/CrearTarea/FormularioInicioCrearTarea' method="post" >
	
		<!--  ********************     INICIO GLOBO GRIS   *********************  -->
		<div class="globo_gris" id="ficha">
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">
					<!--  *********************       INICIO CAJA DE FORMULARIO     *******************  -->
						<div id="formulario" >
						
							<!--  *********************       Caja de Texto de Nombre de Tarea     *******************  -->
							<div class="fila_de_tabla">
								<div class="contenedor_izquierda">
									<div class="text">
										<label for="nombreTarea"><bean:message key="crearTarea.nombreTarea"/></label>
									</div>
								</div>
								<div class="contenedor_derecha">
									<div class="text">
										<input name="trabajo" value="" maxlength="40" id="nombreTarea" type="text" title="<bean:message key='crearTarea.introduzcaNombre'/>" />
									</div>
								</div>
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>
							
							
							<!--  *********************       Desplegable de Tipo de Tarea     *******************  -->
							<div class="fila_de_tabla">
								<div class="contenedor_izquierda">
									<div class="text">
										<label for="tipoTarea"><bean:message key="crearTarea.tipoTarea"/></label>
									</div>
								</div>
								<div class="contenedor_derecha">
									<div class="text">
										<html:select  property="tipoTarea" titleKey="crearTarea.seleccioneTipoTarea" styleId="tipoTarea">
											<html:option key="crearTarea.tareaCargaODEs" value="CargaODEs" />
											<html:option key="crearTarea.tareaReindexada" value="Reindexado" styleClass="oscura" />
											<html:option key="crearTarea.tareaEliminarODEs" value="EliminarNoDisponibles" />
											<html:option key="crearTarea.estadoOdes" value="estadoOdes" styleClass="oscura" />
											<html:option key="crearTarea.operacionesRealizadas" value="operacionesRealizadas" />
											<html:option key="crearTarea.nivelAgregacion" value="nivelAgregacion" styleClass="oscura" />
											<html:option key="crearTarea.coberturaCurricular" value="coberturaCurricular" />
											<html:option key="crearTarea.odesLicencias" value="odesLicencias" styleClass="oscura" />
											<html:option key="crearTarea.procesosPlanificados" value="procesosPlanificados"/>
											<html:option key="crearTarea.usuarios" value="usuarios" styleClass="oscura" />
											<html:option key="crearTarea.odesUsuario" value="odesUsuario" />
											<html:option key="crearTarea.terminosBusqueda" value="terminosBusqueda" styleClass="oscura" />
											<html:option key="crearTarea.masValorado" value="masValorado"  />
											<html:option key="crearTarea.masMostrado" value="masMostrado" styleClass="oscura"  />
											<html:option key="crearTarea.masPrevisualizado" value="masPrevisualizado" />
											<html:option key="crearTarea.masDescargado" value="masDescargado" styleClass="oscura" />
											<html:option key="crearTarea.tamanio" value="tamanio" />
											<html:option key="crearTarea.odesIdiomaFederada" value="odesIdiomaFederada" styleClass="oscura" />
											<html:option key="crearTarea.odesPublicadosFederada" value="odesPublicadosFederada" />
											<html:option key="crearTarea.nivelAgregacionFederada" value="nivelAgregacionFederada" styleClass="oscura"/>
											<html:option key="crearTarea.coberturaCurricularFederada" value="coberturaCurricularFederada" /> 
											<html:option key="crearTarea.repositorio" value="repositorio" />
									</html:select>
									</div>										
								</div>
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>
							
							
							<bean:define id="nomMeses"><bean:message key="catalogadorAvanzado.nombresMeses"/></bean:define>
                            <bean:define id="nomDias"><bean:message key="catalogadorAvanzado.nombresDias"/></bean:define>
							<!--  *********************       Cajas de Texto de Fecha     *******************  -->
							<div class="fila_de_tabla">
								<div class="contenedor_izquierda">
									<div class="text">
										<label for="fecha_inicio"><bean:message key="crearTarea.fechaInicio"/></label>
									</div>
								</div>
								<div class="contenedor_derecha"  id="cont_esp_fech">
						<div class="text"><label class="oculto" for="day2"><bean:message key="crearTarea.fechaDia"/></label><input class="fechazo_02" value="" onblur="this.style.backgroundColor='#e1e1e1'" id="day2" name="dia" type="text" title="<bean:message key="crearTarea.introduzcaDia"/> "/>
						<label class="oculto" for="month2"><bean:message key="crearTarea.mes"/></label><input class="fechazo_02" value="" onblur="this.style.backgroundColor='#e1e1e1'" id="month2" name="mes" type="text" title="<bean:message key="crearTarea.introduzcaMes"/> "/>
						
						
			<label class="oculto"  for="year2" ><bean:message key="crearTarea.fechaAnio"/></label>
			<input class="fechazo_02" id="year2"  value="" onblur="this.style.backgroundColor='#e1e1e1'"  name="anio" type="text" title="<bean:message key="crearTarea.introduzcaAnio"/> "/>
		<span class="vert"><bean:message key="crearTarea.aLas"/></span>
										
										<label class="oculto" for="fecha_hora"><bean:message key="crearTarea.fechaHora"/></label>
										<input name="hora"  value="${form.hora}" maxlength="2" class="fecha_horas" id="fecha_hora" type="text" title="<bean:message key="crearTarea.introduzcaHora"/> "  />
										
										<label class="oculto"  for="fecha_minutos"><bean:message key="crearTarea.fechaMinuto"/></label>
										<input name="minutos" value="${form.minutos}" maxlength="2" class="fecha_minutos" id="fecha_minutos" type="text" title="<bean:message key="crearTarea.introduzcaMinuto"/> "  />
</div>
					</div>
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>
							
							
							<!--  *********************       Desplegable de Periodicidad     *******************  -->
							<div class="fila_de_tabla">
								<div class="contenedor_izquierda">
									<div class="text">
										<label for="repetir_tipoTarea"><bean:message key="crearTarea.repetir"/></label>
									</div>
								</div>
								<div class="contenedor_derecha">
									<div class="text">
										<html:select  property="periodicidad" titleKey="crearTarea.repitaTipoTarea" styleId="repetir_tipoTarea">
											<html:option key="crearTarea.N" 		value="N" />
											<html:option key="crearTarea.D" 		value="D" styleClass="oscura" />
											<html:option key="crearTarea.S" 		value="S" />
											<html:option key="crearTarea.M" 		value="M" styleClass="oscura"/>
											<html:option key="crearTarea.A" 		value="A" />
										</html:select>
									</div>
								</div>
								<div class="linea_separadora"></div>
								
								<br class="oculto" />
							</div>
				 
						
						</div>
						<!--  ********************     FIN CAJA FORMULARIO   *********************  -->
					</div>	
				</div>		
			</div>			
		</div>			
		<!--  ********************     FIN GLOBO GRIS   *********************  -->
		
		<!--********************     Boton aceptar      *********************  -->
		
		<bean:define id="aceptValue"><bean:message key="crearTarea.continuar"/></bean:define>	
		<html:submit styleClass="boton_125_de_2 tipo" value="${aceptValue}" ></html:submit>

	</html:form>
	
	<!-- ********************     Inicio Formulario secundario    **************** -->
	
	<form id="crearTareaFormularioInicioCancelarForm" action="<html:rewrite action="/CrearTarea/FormularioInicioCancelar"/>" method="post" >
	
	
		<!-- ********************     Boton Cancelar    **************** -->
		
		<bean:define id="cancelValue"><bean:message key="crearTarea.cancelar"/></bean:define>
		<html:submit styleClass="boton_125_de_2_izq tipo" value="${cancelValue}"/>
		
	</form> 
	<!-- ********************     FIN formulario secundario      *********************  -->
	
	
	</div>
	<!-- ************************     FIN  PLANTILLA  CONTENIDO   *************************  -->
	
	

    </tiles:put>

</tiles:insert>
<script type="text/javascript">		
//<![CDATA[
	window.addEvent('domready', function() { 
		jsMeses = "${nomMeses}"; arrayMeses = jsMeses.split(",");
		jsDias = "${nomDias}"; arrayDias = jsDias.split(",");
		myCal2 = new Calendar({ year2: { day2: 'd', month2: 'm', year2: 'Y' }}, { direction: 0, tweak: {x: 6, y: 0} ,months: arrayMeses ,days: arrayDias });
			});
	//]]>
</script>
