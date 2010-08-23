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

<h2><bean:message key="nodos.verNodo.cabeceraSQI"/></h2>


<!--		Inicio del formulario principal		-->
<fielset>
<form id="verNodoSQIDetalleNodoSQIAceptarForm" action='<html:rewrite action="/${initParam.url_nodoSQI_ver_aceptar }"/>' method="post" >
	
	
	<!--		INICIO GLOBO GRIS		-->
	
	<div class="globo_gris" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
					
					
					<!--		INICIO CAJA DE FORMULARIO		-->
					
					<div id="formulario" >

										
			  			<!-- 		CAMPO NOMBRE		-->
			  							
							<div class="fila_de_tabla">
  								<div class="contenedor_izquierda_may">
  									<div class="text"><label for="NombreNodo"><bean:message key="nodos.nombreNodoSQI"/></label></div>
 								</div>
								<div class="contenedor_derecha">
									<div class="text">
										<input readonly="readonly" style="background-color:white" name="nombreNodo" maxlength="70" value="${form.nombreNodo}" id="NombreNodo" type="text" />
									</div>
								</div>
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>
							
							
							<!-- 		CAMPO URL NODO		-->
			  							
							<div class="fila_de_tabla">
  								<div class="contenedor_izquierda_may">
  									<div class="text"><label for="NombreURL"><bean:message key="nodos.urlNodoSQI"/></label></div>
 								</div>
								<div class="contenedor_derecha">
									<div class="text">
										<input readonly="readonly" style="background-color:white" name="url" maxlength="150" value="${form.urlServicio}" id="NombreURL" type="text" />
									</div>
								</div>
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>
							
							<!-- 		CAMPO DESCRIPCION NODO		-->
			  							
							<div class="fila_de_tabla">
  								<div class="contenedor_izquierda_may">
  									<div class="text"><label for="DescripcionNodo"><bean:message key="nodos.descripcionNodoSQI"/></label></div>
 								</div>
								<div class="contenedor_derecha">
									<div class="text">
										<input readonly="readonly" style="background-color:white" name="descripcionNodo" maxlength="150" value="${form.descripcionNodo}" id="DescripcionNodo" type="text" />
									</div>
								</div>
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>
							
							
							<!-- 		CAMPO LENGUAJE CONSULTA		-->
			  							
							<div class="fila_de_tabla">
  								<div class="contenedor_izquierda_may">
  									<div class="text"><label for="LenguajeConsulta"><bean:message key="nodos.lenguajeConsultaSQI"/></label></div>
 								</div>
								<div class="contenedor_derecha">
									<div class="text">
										<input readonly="readonly" style="background-color:white" name="lenguajeConsulta" maxlength="4" value="${form.lenguajeConsulta}" id="lenguajeConsulta" type="text" />
									</div>
								</div>
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>
						
							<!-- 		CAMPO LENGUAJE RESPUESTA		-->
			  							
							<div class="fila_de_tabla">
  								<div class="contenedor_izquierda_may">
  									<div class="text"><label for="LenguajeRespuesta"><bean:message key="nodos.lenguajeRespuestaSQI"/></label></div>
 								</div>
								<div class="contenedor_derecha">
									<div class="text">
										<input readonly="readonly" style="background-color:white" name="lenguajeRespuesta" maxlength="6" value="${form.lenguajeRespuesta}" id="lenguajeRespuesta" type="text" />
									</div>
								</div>
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>
							
							<br />
				</div>
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>

<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario_02" >
							
							<!-- 		CAMPO IDENTIFICADOR SESION		-->
			  							
							<div class="fila_de_tabla">
  								<div class="contenedor_izquierda_may">
  									<div class="text"><label for="IdentificadorSesion"><bean:message key="nodos.identificadorSesion"/></label></div>
 								</div>
								<div class="contenedor_derecha">
									<div class="text">
										<input readonly="readonly" style="background-color:white" name="identificadorSesion" maxlength="100" value="${form.identificadorSesion}" id="identificadorSesion" type="text" />
									</div>
								</div>
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>
							
							<!-- 		CAMPO GESTOR SESION		-->
			  							
							<div class="fila_de_tabla">
  								<div class="contenedor_izquierda_may">
  									<div class="text"><label for="LenguajeConsulta"><bean:message key="nodos.gestorSesion"/></label></div>
 								</div>
								<div class="contenedor_derecha">
									<div class="text">
										<input readonly="readonly" style="background-color:white" name="gestorSesion" maxlength="100" value="${form.gestorSesion}" id="gestorSesion" type="text" />
									</div>
								</div>
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>
							
							</div>
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>

	</div>
</div>

<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">

			<!--  INICIO CAJA DE FORMULARIO   -->
			<div  id="formulario_03" >
							
							<!-- 		CAMPO USUARIO	-->
			  							
							<div class="fila_de_tabla">
  								<div class="contenedor_izquierda_may">
  									<div class="text"><label for="Usuario"><bean:message key="nodos.usuarioSQI"/></label></div>
 								</div>
								<div class="contenedor_derecha">
									<div class="text">
										<input readonly="readonly" style="background-color:white" name="usuario" maxlength="25" value="${form.usuario}" id="usuario" type="text" />
									</div>
								</div>
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>
							
							<!-- 		CAMPO CLAVE	-->
			  							
							<div class="fila_de_tabla">
  								<div class="contenedor_izquierda_may">
  									<div class="text"><label for="Clave"><bean:message key="nodos.claveSQI"/></label></div>
 								</div>
								<div class="contenedor_derecha">
									<div class="text">
										<input readonly="readonly" style="background-color:white" name="clave" maxlength="25" value="${form.clave}" id="clave" type="text" />
									</div>
								</div>
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>
					</div>
					
					<!--		FIN CAJA DE FORMULARIO		-->
						
					
				</div>
			</div>
		</div>
	</div>
	
	<!--		FIN GLOBO GRIS		-->
	
	
	<!--		Boton Siguiente		-->
	
	<input class="boton_125 tipo ft_centrada"  type="submit"  value="<bean:message key='nodos.volver'/>" />
	
	
</form>
</fieldset>
<!--		Fin del Formulario principal		-->
	

</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>