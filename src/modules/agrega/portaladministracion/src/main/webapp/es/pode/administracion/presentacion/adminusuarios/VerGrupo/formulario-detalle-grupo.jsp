<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<tiles:insert definition="layout-administrador">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>


<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>


<!--		Inicio plantilla contenido		-->

<div class="plantilla_contenido">


<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />

<h2><bean:message key="grupos.verGrupo.cabecera"/></h2>


<!--		Inicio del formulario principal		-->

<form id="verGrupoFormularioDetalleGrupoAceptarForm" action='<html:rewrite action="/VerGrupo/FormularioDetalleGrupoAceptar"/>' method="post" >
	
	
	<!--		INICIO GLOBO GRIS		-->
	
	<div class="globo_gris" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
					
					
					<!--		INICIO CAJA DE FORMULARIO		-->
					
					<div id="formulario" >
				
				
						<!--		INICIO GLOBO Blanco		-->
						
						<div class="globo_blanco" >
							<div class="globo_blanco_01">
								<div class="globo_blanco_02">
									<div class="globo_blanco_03">
									
										<h3><bean:message key="grupos.descripcion"/></h3>

										
			  							<!-- 		CAMPO DESCRIPCION		-->
			  							
										<div class="fila_de_tabla">
			  								<div class="contenedor_izquierda">
			  									<div class="text"><label for="NombreGrupo"><bean:message key="grupos.nombreGrupo"/></label></div>
			 								</div>
											<div class="contenedor_derecha">
												<div class="text">
													<input DISABLED style="background-color:white" name="descripcion" value="${form.descripcion}" id="NombreGrupo" maxlength="50" type="text" />
												</div>
											</div>
											<div class="linea_separadora"></div>
											<br class="oculto" />
										</div>


									</div>
								</div>
							</div>
						</div>
						
						<!--		Fin GLOBO Blanco		-->
						
						
					</div>
					
					<!--		FIN CAJA DE FORMULARIO		-->
					
					
					
					<!--		INICIO CAJA DE FORMULARIO 2 (tabla de permisos)		-->
				
					<div id="formulario_02" >
					
					
						<!--		INICIO GLOBO Blanco		-->
						
						<div class="globo_blanco" >
							<div class="globo_blanco_01">
								<div class="globo_blanco_02">
									<div class="globo_blanco_03">
							
										<h3><bean:message key="usuarios.permisos"/></h3>
	  									
	  									
	  									<!-- 		Inicio Caja Tabla		 -->
	  									
										<div class="caja_tabla">
	  										
	  										
	  										<display:table name="${form.roles}" uid="fila" requestURI="${pageContext.request.requestURL}"
										        export="false" sort="list" style="border:1;width:100%;" class="administracion_tareas"
												cellpadding="0" cellspacing="0" summary="${summary}">
												
												<display:setProperty name="css.tr.odd" value="tr_gris"/>
												<display:setProperty name="css.tr.even" value="tr_blanco"/>
												<display:setProperty name="basic.show.header" value="true"/>
												
												
												<!--		Columna de Usuario		-->
												
												<display:column style="valign:top;" class="tar14" >
													<bean:message key="${fila.descripcion}"/>
												</display:column>
	  										
	  										</display:table>
	  										
	  										
										</div>
										
										<!--		Fin Caja Tabla 		-->
										
										
									</div>
								</div>
							</div>
						</div>
						
						<!--		Fin GLOBO Blanco		-->
						
						
					</div>
					
					<!--		FIN CAJA DE FORMULARIO 2(tala de permisos)	-->
					
					
				</div>
			</div>
		</div>
	</div>
	
	<!--		FIN GLOBO GRIS		-->
	
	
	<!--		Boton Siguiente		-->
	
	<input class="boton_125 tipo"  type="submit"  value="<bean:message key='usuarios.volver'/>" />
	
	
</form>

<!--		Fin del Formulario principal		-->
	

</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>