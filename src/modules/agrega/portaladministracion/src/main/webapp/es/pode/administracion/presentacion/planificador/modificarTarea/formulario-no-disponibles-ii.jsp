<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>


<tiles:insert definition="layout-administrador">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>

	
    <tiles:put name="body" type="string">
  
	<!-- ************************     INICIO PLANTILLA CONTENIDO     *************************  -->
    <div class="plantilla_contenido">
    
    <!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
	<jsp:include page="/layout/messages.jsp" flush="true" />

	<h2><bean:message key="modificarTarea.cabecera2"/></h2>
	<html:form styleId="obtenerTCargaODEsFormularioNoDisponiblesIIAceptarForm" action='/ObtenerTCargaODEs/FormularioNoDisponiblesIIAceptar' method="post" >
	
		<!--  ********************     INICIO GLOBO GRIS   *********************  -->
		<div class="globo_gris" >
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">
					<!--  *********************       INICIO CAJA DE FORMULARIO     *******************  -->
						<div id="formulario" >
							
							
							<!--  *********************       Campos ocultos    *******************  -->
							
							<input type="hidden" name="trabajo" value="${form.trabajo}" />
							
							<input type="hidden" name="grupoTrabajo" value="${form.grupoTrabajo}"/>
									
		                    <input type="hidden" name="tipoTarea" value="${form.tipoTarea}" />
		                    	
							<input type="hidden" name="dia" value="${form.dia}" />
					   
							<input type="hidden" name="mes" value="${form.mes}" />
					  
							<input type="hidden" name="anio" value="${form.anio}" />
					 
							<input type="hidden" name="hora" value="${form.hora}" />
					 
							<input type="hidden" name="minutos" value="${form.minutos}" />
					 
							<input type="hidden" name="periodicidad" value="${form.periodicidad}" />
					
							<bean:define id="nomMeses"><bean:message key="catalogadorAvanzado.nombresMeses"/></bean:define>
                            <bean:define id="nomDias"><bean:message key="catalogadorAvanzado.nombresDias"/></bean:define>
							<!--  *********************       Cajas de Texto de Fecha Desde    *******************  -->
							<div class="fila_de_tabla">
								<div class="contenedor_izquierda">
									<div class="text">
										<label for="fecha_inicio"><bean:message key="crearTarea.fechaDesde"/></label>
									</div>
								</div>
								<div class="contenedor_derecha"  id="cont_esp_fech">
						<div class="text"><label class="oculto" for="day1"><bean:message key="crearTarea.fechaDia"/></label><input  class="fechazo_02" value="${form.diaDesde}" onblur="this.style.backgroundColor='#e1e1e1'" id="day1" name="diaDesde" type="text" title="<bean:message key="crearTarea.introduzcaDia"/> "/>
						<label class="oculto" for="month1"><bean:message key="crearTarea.fechaMes"/></label><input class="fechazo_02" value="${form.mesDesde}" onblur="this.style.backgroundColor='#e1e1e1'" id="month1" name="mesDesde" type="text" title="<bean:message key="crearTarea.introduzcaMes"/> "/>
						
						
			<label class="oculto"  for="year1" ><bean:message key="crearTarea.fechaAnio"/></label>
			<input class="fechazo_02" id="year1"  value="${form.anioDesde}" onblur="this.style.backgroundColor='#e1e1e1'"  name="anioDesde" type="text" title="<bean:message key="crearTarea.introduzcaAnio"/> "/>
		</div>
				</div>
											
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>
							
							
							<!--  *********************       Cajas de Texto de Fecha Hasta     *******************  -->
							<div class="fila_de_tabla">
								<div class="contenedor_izquierda">
									<div class="text">
										<label for="fecha_inicio"><bean:message key="crearTarea.fechaHasta"/></label>
									</div>
								</div>
								<div class="contenedor_derecha"  id="cont_esp_fech">
						<div class="text"><label class="oculto" for="day2"><bean:message key="crearTarea.fechaDia"/></label><input  class="fechazo_02" value="${form.diaHasta}" onblur="this.style.backgroundColor='#e1e1e1'" id="day2" name="diaHasta" type="text" title="<bean:message key="crearTarea.introduzcaDia"/> "/>
						<label class="oculto" for="month2"><bean:message key="crearTarea.fechaMes"/></label><input class="fechazo_02" value="${form.mesHasta}" onblur="this.style.backgroundColor='#e1e1e1'" id="month2" name="mesHasta" type="text" title="<bean:message key="crearTarea.introduzcaMes"/> "/>
						
						
			<label class="oculto"  for="year2" ><bean:message key="crearTarea.fechaAnio"/></label>
			<input class="fechazo_02" id="year2"  value="${form.anioHasta}" onblur="this.style.backgroundColor='#e1e1e1'"  name="anioHasta" type="text" title="<bean:message key="crearTarea.introduzcaAnio"/> "/>
			
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
		
		<!--********************     Boton aceptar      *********************  -->
		
		<bean:define id="aceptValue"><bean:message key="crearTarea.continuar"/></bean:define>	
		<html:submit styleClass="boton_125_de_2 tipo" value="${aceptValue}" ></html:submit>

	</html:form>
	
	<!-- ********************     Inicio Formulario secundario    **************** -->
	
	<form id="obtenerTCargaODEsFormularioNoDisponiblesIICancelarForm" action="<html:rewrite action="/ObtenerTCargaODEs/FormularioNoDisponiblesIICancelar"/>" method="post" >
	
	
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
		myCal1 = new Calendar({ year1: { day1: 'd', month1: 'm', year1: 'Y' }}, { direction: 0, tweak: {x: 6, y: 0} ,months: arrayMeses ,days: arrayDias });
			myCal2 = new Calendar({ year2: { day2: 'd', month2: 'm', year2: 'Y' }}, { direction: 0, tweak: {x: 6, y: 0} ,months: arrayMeses ,days: arrayDias });
			});
	//]]>
</script>