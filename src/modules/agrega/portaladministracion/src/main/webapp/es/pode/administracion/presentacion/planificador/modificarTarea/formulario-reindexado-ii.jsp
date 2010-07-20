<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>



<tiles:insert definition="layout-administrador">

    <tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
	</tiles:put>


    <tiles:put name="body" type="string">
    
		<%@ include file="/taglib-imports.jspf" %>

		 
		<!-- ********************       INICIO PLANTILLA CONTENIDOS     ***********************  -->
		<div class="plantilla_contenido">
		
			<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
			<jsp:include page="/layout/messages.jsp" flush="true" />
		  
			<h2><bean:message key="modificarTarea.cabecera2"/></h2>
			
			<html:form styleId="obtenerTCargaODEsFormularioReindexadoIIAceptarForm" action="/ObtenerTCargaODEs/FormularioReindexadoIIAceptar" method="post" enctype="multipart/form-data">
			 
				<!--  *******************        INICIO GLOBO GRIS     ***********************  -->
				<div class="globo_gris" >
					<div class="globo_gris_01">
						<div class="globo_gris_02">
							<div class="globo_gris_03">
						   
								<!--   *****************       INICIO CAJA DE FORMULARIO     ************************** -->
								<div id="formulario" >
									<h3><bean:message key="crearTarea.reindexado"/></h3>
								
									<!--  **********************         CAMPOS OCULTOS RECOGIDOS EN LA PANTALLA ANTERIOR      ******************-->
										
									<input type="hidden" name="trabajo" value="${form.trabajo}" />
									
									<input type="hidden" name="grupoTrabajo" value="${form.grupoTrabajo}"/>
									
				                    <input type="hidden" name="tipoTarea" value="${form.tipoTarea}" />
				                    	
									<input type="hidden" name="dia" value="${form.dia}" />
							   
									<input type="hidden" name="mes" value="${form.mes}" />
							  
									<input type="hidden" name="anio" value="${form.anio}" />
							 
									<input type="hidden" name="hora" value="${form.hora}" />
							 
									<input type="hidden" name="minutos" value="${form.minutos}" />
							 
									<input type="hidden" name="periodicidad" value="${form.periodicidad}" />
									
									<input type="hidden" name="msgReindexado" value="${form.msgReindexado}" />
									
									<input type="hidden" name="msgNoReindexado" value="${form.msgNoReindexado}" />
									
									<input type="hidden" name="msgDescReindexado" value="${form.msgDescReindexado}" />
					                

									<!--   ********************       SELECT PARA INDICAR INDICE DE REINDEXADO         ***********************-->										
									<div class="fila_de_tabla">
									
										<div class="contenedor_izquierda2">
											<div class="text">
												<label for="indices"><bean:message key="crearTarea.indices"/></label>
											</div>
										</div>
										
										<div class="contenedor_derecha2">
										
										
										
										<bean:define id="idiomaAlt"><bean:message key="crearTarea.seleccioneIndices"/></bean:define>
											<c:choose>
						                        <c:when test="${!empty form.repositorioBackingList}">
						                           <html:select name="form" property="repositorio" styleId="Idioma" title="${idiomaAlt}">
						                               <html:optionsCollection name="form" property="repositorioBackingList" label="label" value="value"/>
						                           </html:select>
						                        </c:when>
						                        <c:otherwise>
						                            <html:select name="form" property="repositorio" styleId="Idioma" title="${idiomaAlt}"/>
						                        </c:otherwise>
						                    </c:choose>
											
										</div>
										
										<div class="linea_separadora"></div>
										<br class="oculto" />
									</div>
								   
								</div>
							   	<!--  ********************      FIN CAJA DE FORMULARIO      ************************  -->
							</div>
						</div>
					</div>
				</div>
				<!-- *********************         FIN GLOBO GRIS        *************************  -->
			 
				<!--  ********************          Boton Aceptar       ************************ -->
					
					<bean:define id="aceptValue"><bean:message key="crearTarea.aceptar"/></bean:define>	
					<html:submit styleClass="boton_125_de_2 tipo" value="${aceptValue}"/>
				
			</html:form>

			<!-- ********************     Fin Formulario    **************** -->
			
			
			<!-- ********************     Inicio Formulario secundario    **************** -->
			
			<form id="obtenerTCargaODEsFormularioReindexadoIICancelarForm" action="<html:rewrite action="/ObtenerTCargaODEs/FormularioReindexadoIICancelar"/>" method="post" >
			
			
				<!-- ********************     Boton Cancelar    **************** -->
				
				<bean:define id="cancelValue"><bean:message key="crearTarea.cancelar"/></bean:define>
				<html:submit styleClass="boton_125_de_2_izq tipo" value="${cancelValue}"/>
				
			</form> 
			
			<!--  ********************          Fin formulario secundario        ***********************  -->
				
			
		</div>
		<!-- *********************         FIN PLANTILLA CONTENIDOS        ************************-->


    </tiles:put>

</tiles:insert>
