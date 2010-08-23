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
 
	        <h2><bean:message key="modificarTarea.cabecera2"/></h2>

	        <html:form  styleId="obtenerTCargaODEsFormularioIIAceptarForm" action="/ObtenerTCargaODEs/FormularioIIAceptar" method="post" enctype="multipart/form-data" >
				
				<!-- **********************         INICIO GLOBO GRIS        ***********************  -->
				<div class="globo_gris" >
					<div class="globo_gris_01">
						<div class="globo_gris_02">
							<div class="globo_gris_03">
								<!--  **********************      INICIO CAJA DE FORMULARIO         ***********************   -->
								<div id="formulario" >
								<h3><bean:message key="crearTarea.cargaDeContenidos"/></h3>
								
									<!--  **********************         CAMPOS OCULTOS RECOGIDOS EN LA PANTALLA ANTERIOR      ******************-->
									
				                    <input type="hidden" name="trabajo" value="${form.trabajo}" />
				                    
				                    <input type="hidden" name="grupoTrabajo" value="${form.grupoTrabajo}" />
									
				                    <input type="hidden" name="tipoTarea" value="${form.tipoTarea}" />
				                    	
									<input type="hidden" name="dia" value="${form.dia}" />
							   
									<input type="hidden" name="mes" value="${form.mes}" />
							  
									<input type="hidden" name="anio" value="${form.anio}" />
							 
									<input type="hidden" name="hora" value="${form.hora}" />
									
									<input type="hidden" name="minutos" value="${form.minutos}" />
							 
									<input type="hidden" name="periodicidad" value="${form.periodicidad}" />
									
									<input type="hidden" name="msgPublicado" value="${form.msgPublicado}" />
									
									<input type="hidden" name="msgNoPublicado" value="${form.msgNoPublicado}" />
									
									<input type="hidden" name="msgDescCargaODEs" value="${form.msgDescCargaODEs}" />
				                      
									
									
									<!--  **********************         URL DONDE SE ENCUENTRA EL ODE      ******************-->
									<div class="fila_de_tabla">
					  					<div class="contenedor_izquierda">
					  						<div class="text">
												<label for="URLLocation"><bean:message key="crearTarea.urlLocation"/></label>
											</div>
					 					</div>
										<div class="contenedor_derecha">
											<div class="text">
												<input name="pathODEs" value="${form.pathODEs}" id="URLLocation" type="text" title="<bean:message key="crearTarea.introduzcaUrlLocation"/>"  />
											</div>
										</div>
										<div class="linea_separadora"></div>
										<br class="oculto" />
									</div>
									
									<!--  **********************         URL DONDE VA EL ODE SI TODO VA BIEN      ******************-->
				                    <div class="fila_de_tabla">
					  					<div class="contenedor_izquierda">
					  						<div class="text">
												<label for="URLDestiny"><bean:message key="crearTarea.urlDestiny"/></label>
											</div>
					 					</div>
										<div class="contenedor_derecha">
											<div class="text">
												<input name="pathODEsCarg" value="${form.pathODEsCarg}" id="URLDestiny" type="text" title="<bean:message key="crearTarea.introduzcaUrlDestiny"/> "  />
											</div>
										</div>
										<div class="linea_separadora"></div>
										<br class="oculto" />
									</div>
									
									<!--  **********************         URL DONDE VA EL ODE SI HAY ERROR     ******************-->
				                   <div class="fila_de_tabla">
					  					<div class="contenedor_izquierda">
					  						<div class="text">
												<label for="URLError"><bean:message key="crearTarea.urlError"/></label>
											</div>
					 					</div>
										<div class="contenedor_derecha">
											<div class="text">
												<input name="pathODEsNoCarg" value="${form.pathODEsNoCarg}" id="URLError" type="text" title="<bean:message key="crearTarea.introduzcaUrlError"/> "  />
											</div>
										</div>
										<div class="linea_separadora"></div>
										<br class="oculto" />
									</div>
									
									<!--  **********************        SOBRESCRIBIR     ******************-->
				                   <div class="fila_de_tabla">
					  					<div class="contenedor_izquierda">
					  						<div class="text">
												<label for="sobrescribir"><bean:message key="crearTarea.sobrescribir"/></label>
											</div>
					 					</div>
										<div class="contenedor_derecha">
											<div class="text">
												<c:set var="value" value="${form.sobrescribir}"/>
												<input class="boton_radio" type="checkbox" name="sobrescribir" value="on" <c:if test="${value=='s'}">checked="checked" </c:if> id="sobrescribir" title="<bean:message key="crearTarea.sobrescribir"/> "  />
											</div>
										</div>
										<div class="linea_separadora"></div>
										<br class="oculto" />
									</div>
			
								</div>
								<!--  **********************      FIN CAJA DE FORMULARIO         ***********************   -->
								
							</div>
						</div>
					</div>
				</div>		
				<!-- **********************         FIN GLOBO GRIS        ***********************  -->
          
          
				<!--********************     Boton Aceptar      *********************  -->
					
				<bean:define id="aceptValue"><bean:message key="crearTarea.aceptar"/></bean:define>	
				<html:submit styleClass="boton_125_de_2 tipo" value="${aceptValue}" ></html:submit>
					 
		  
				</html:form>
				
				<!-- ********************     Fin del Formulario    **************** -->
				
				
				<!-- ********************     Inicio del Formulario secundario    **************** -->
				
				<form id="obtenerTCargaODEsFormularioIICancelarForm" action="<html:rewrite action="/ObtenerTCargaODEs/FormularioIICancelar"/>" method="post">
				
				
					<!-- ********************     Boton Cancelar    **************** -->
					
					<bean:define id="cancelValue"><bean:message key="crearTarea.cancelar"/></bean:define>
					<html:submit styleClass="boton_125_de_2_izq tipo" value="${cancelValue}"/>
					
				</form>				

				<!--********************     Fin del formulario secundario      *********************  -->
				
		</div>
		<!--************************             Fin plantilla contenido         **************************  -->
		
		
    </tiles:put>

</tiles:insert>
