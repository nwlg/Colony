<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<tiles:insert definition="layout-administrador">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>

	
    <tiles:put name="body" type="string">
    
    
	<%@ include file="/taglib-imports.jspf" %>
	
	
	<!-- ************************     INICIO PLANTILLA CONTENIDO     *************************  -->
    <div class="plantilla_contenido">
    
    <!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
	<jsp:include page="/layout/messages.jsp" flush="true" />

	<h2><bean:message key="modificarTarea.cabecera"/></h2>
	<html:form styleId="obtenerTCargaODEsFormularioInformeFederadoIContinuarForm" action="/ObtenerTCargaODEs/FormularioInformeFederadoIContinuar" method="post" enctype="multipart/form-data">
	
		<!--  ********************     INICIO GLOBO GRIS   *********************  -->
		<div class="globo_gris" >
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">
					<!--  *********************       INICIO CAJA DE FORMULARIO     *******************  -->
						<div id="formulario" >
							
							<!--  *********************       Campos ocultos para usar en la pantalla siguiente     *******************  -->
							
							<input type="hidden" name="grupoTrabajo" value="${form.grupoTrabajo}"/>
							<input type="hidden" name="formato" value="${form.formato}" />
							<input type="hidden" name="tipoTarea" value="${form.tipoTarea}" />
							<input type="hidden" name="anioDesde" value="${form.anioDesde}" />
							<input type="hidden" name="mesDesde" value="${form.mesDesde}" />
							<input type="hidden" name="diaDesde" value="${form.diaDesde}" />
							<input type="hidden" name="anioHasta" value="${form.anioHasta}" />
							<input type="hidden" name="mesHasta" value="${form.mesHasta}" />
							<input type="hidden" name="diaHasta" value="${form.diaHasta}" />
							<input type="hidden" name="msgInforme" value="${form.msgInforme}" />
							<input type="hidden" name="msgNoInforme" value="${form.msgNoInforme}" />
							<input type="hidden" name="msgDescTrabajo" value="${form.msgDescTrabajo}" />
							
							
							
							<!--  *********************       Caja de Texto de Nombre de Tarea     *******************  -->
							<div class="fila_de_tabla">
								<div class="contenedor_izquierda">
									<div class="text">
										<label for="nombreTarea"><bean:message key="crearTarea.nombreTarea"/></label>
									</div>
								</div>
								<div class="contenedor_derecha">
									<div class="text">
										<input name="trabajo" READONLY value="${form.trabajo}" style="background-color: #e1e1e1" id="nombreTarea" type="text" title="<bean:message key='crearTarea.introduzcaNombre'/>" />
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
										<input name="informe" READONLY value="${form.informe}" style="background-color: #e1e1e1" id="tipoTarea" type="text" title="<bean:message key='crearTarea.seleccioneTipoTarea'/>" />
									</div>
								</div>
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>
							
							
							<!--  *********************       Cajas de Texto de Fecha     *******************  -->
							<bean:define id="nomMeses"><bean:message key="catalogadorAvanzado.nombresMeses"/></bean:define>
                            <bean:define id="nomDias"><bean:message key="catalogadorAvanzado.nombresDias"/></bean:define>
							<div class="fila_de_tabla">
								<div class="contenedor_izquierda">
									<div class="text">
										<label for="fecha_inicio"><bean:message key="crearTarea.fechaInicio"/></label>
									</div>
								</div>
								<div class="contenedor_derecha"  id="cont_esp_fech">
									<div class="text"><label class="oculto" for="day2"><bean:message key="crearTarea.fechaDia"/></label><input  class="fechazo_02" value="${form.dia}" onblur="this.style.backgroundColor='#e1e1e1'" id="day2" name="dia" type="text" title="<bean:message key="crearTarea.introduzcaDia"/> "/>
										<label class="oculto" for="month2"><bean:message key="crearTarea.fechaMes"/></label><input class="fechazo_02" value="${form.mes}" onblur="this.style.backgroundColor='#e1e1e1'" id="month2" name="mes" type="text" title="<bean:message key="crearTarea.introduzcaMes"/> "/>
										
										<label class="oculto"  for="year2" ><bean:message key="crearTarea.fechaAnio"/></label>
										<input class="fechazo_02" id="year2"  value="${form.anio}" onblur="this.style.backgroundColor='#e1e1e1'"  name="anio" type="text" title="<bean:message key="crearTarea.introduzcaAnio"/> "/>
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
										<html:select value="${form.periodicidad}" property="periodicidad" styleId="repetir_tipoTarea"  titleKey="crearTarea.repitaTipoTarea" >
											<html:option  key="crearTarea.N" value="N" />
											<html:option  key="crearTarea.D" value="D" styleClass="oscura" />
											<html:option  key="crearTarea.S" value="S"/>
											<html:option  key="crearTarea.M" value="M" styleClass="oscura" />
											<html:option  key="crearTarea.A" value="A" />
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
		
		<!--********************     Boton Continuar      *********************  -->
		
		<bean:define id="aceptValue"><bean:message key="crearTarea.continuar"/></bean:define>	
		<html:submit styleClass="boton_125_de_2 tipo" value="${aceptValue}" ></html:submit>
			 
	</html:form>
	
	
	<!-- ********************     Inicio Formulario secundario    **************** -->
	
	<form id="obtenerTCargaODEsFormularioInformeFederadoICancelarForm" action='<html:rewrite action="/ObtenerTCargaODEs/FormularioInformeFederadoICancelar"/>' method="post" >
		
		
		<!-- ********************     Boton Cancelar    **************** -->
	
		<bean:define id="cancelValue"><bean:message key="crearTarea.cancelar"/></bean:define>
		<html:submit styleClass="boton_125_de_2_izq tipo" value="${cancelValue}"/>
		
	</form>
	
	<!--********************     Fin formulario secundario      *********************  -->			


	</div>
	<!-- ************************     FIN  PLANTILLA  CONTENIDO   *************************  -->
	

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