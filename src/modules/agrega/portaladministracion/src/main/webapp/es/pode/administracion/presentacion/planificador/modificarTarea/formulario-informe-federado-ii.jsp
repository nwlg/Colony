<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>


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

	<h2><bean:message key="modificarTarea.cabecera2"/></h2>
	<html:form styleId="obtenerTCargaODEsFormularioInformeFederadoIIAceptarForm" action="/ObtenerTCargaODEs/FormularioInformeFederadoIIAceptar" method="post" >
	
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
		                    
		                    <input type="hidden" name="informe" value="${form.informe}" />
		                    	
							<input type="hidden" name="dia" value="${form.dia}" />
					   
							<input type="hidden" name="mes" value="${form.mes}" />
					  
							<input type="hidden" name="anio" value="${form.anio}" />
					 
							<input type="hidden" name="hora" value="${form.hora}" />
					 
							<input type="hidden" name="minutos" value="${form.minutos}" />
					 
							<input type="hidden" name="periodicidad" value="${form.periodicidad}" />
					
					
							<!--  *********************       Caja de Texto de Nombre de Tarea     *******************  -->
							<div class="fila_de_tabla">
								<div class="contenedor_izquierda">
									<div class="text">
										<label for="informe"><bean:message key="informes.nombreInforme"/></label>
									</div>
								</div>
								<div class="contenedor_derecha">
									<div class="text">
										<label id="informe" style="width:400px;"><bean:message key="informes.${form.informe}"/></label>
										<br/>
									</div>
								</div>
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>
							
							
							<!-- *********************		CAMPO formato (desplegable)		********************* -->
							<div class="fila_de_tabla">
								<div class="contenedor_izquierda">
									<div class="text">
										<label for="formato"><bean:message key="informes.crearInforme.formato"/></label>
									</div>
								</div>
								<div class="contenedor_derecha">
									<div class="text">
										<html:select property="formato" value="${form.formato}" style="width:107px" titleKey="informes.crearInforme.seleccioneFormato" styleId="formato">
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
		
		<!--********************     Boton aceptar      *********************  -->
		
		<bean:define id="aceptValue"><bean:message key="crearTarea.continuar"/></bean:define>	
		<html:submit styleClass="boton_125_de_2 tipo" value="${aceptValue}" ></html:submit>

	</html:form>
	
	<!-- ********************     Inicio Formulario secundario    **************** -->
	
	<form id="obtenerTCargaODEsFormularioInformeFederadoIICancelarForm" action='<html:rewrite action="/ObtenerTCargaODEs/FormularioInformeFederadoIICancelar"/>' method="post" >
	
	
		<!-- ********************     Boton Cancelar    **************** -->
		
		<bean:define id="cancelValue"><bean:message key="crearTarea.cancelar"/></bean:define>
		<html:submit styleClass="boton_125_de_2_izq tipo" value="${cancelValue}"/>
		
	</form> 
	<!-- ********************     FIN formulario secundario      *********************  -->
	
	
	</div>
	<!-- ************************     FIN  PLANTILLA  CONTENIDO   *************************  -->
	
	

    </tiles:put>
    
</tiles:insert>
