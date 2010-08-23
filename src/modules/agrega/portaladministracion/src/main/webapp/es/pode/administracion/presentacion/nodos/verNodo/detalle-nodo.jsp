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

<h2><bean:message key="nodos.verNodo.cabecera"/></h2>


<!--		Inicio del formulario principal		-->

<form id="verNodoDetalleNodoAceptarForm" action='<html:rewrite action="/VerNodo/DetalleNodoAceptar"/>' method="post" >
	
	
	<!--		INICIO GLOBO GRIS		-->
	
	<div class="globo_gris" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
					
					
					<!--		INICIO CAJA DE FORMULARIO		-->
					
					<div id="formulario" >

										
			  			<!-- 		CAMPO DESCRIPCION		-->
			  							
							<div class="fila_de_tabla">
  								<div class="contenedor_izquierda">
  									<div class="text"><label for="NombreNodo"><bean:message key="nodos.nombreNodo"/></label></div>
 								</div>
								<div class="contenedor_derecha">
									<div class="text">
										<input readonly="readonly" style="background-color:white" name="nodo" maxlength="70" value="${form.nodo}" id="NombreNodo" type="text" />
									</div>
								</div>
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>
							
							
							<!-- 		CAMPO URL NODO		-->
			  							
							<div class="fila_de_tabla">
  								<div class="contenedor_izquierda">
  									<div class="text"><label for="NombreURL"><bean:message key="nodos.nombreUrl"/></label></div>
 								</div>
								<div class="contenedor_derecha">
									<div class="text">
										<input readonly="readonly" style="background-color:white" name="url" maxlength="150" value="${form.url}" id="NombreURL" type="text" />
									</div>
								</div>
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>
							
							<!-- 		CAMPO URL WS		-->
			  							
							<div class="fila_de_tabla">
  								<div class="contenedor_izquierda">
  									<div class="text"><label for="NombreURLWS"><bean:message key="nodos.nombreUrlWS"/></label></div>
 								</div>
								<div class="contenedor_derecha">
									<div class="text">
										<input readonly="readonly" style="background-color:white" name="urlWS" maxlength="150" value="${form.urlWS}" id="NombreURLWS" type="text" />
									</div>
								</div>
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>
							
							<!-- 		CAMPO PUERTO		-->
			  							
							<div class="fila_de_tabla">
  								<div class="contenedor_izquierda">
  									<div class="text"><label for="NombrePuerto"><bean:message key="nodos.nombrePuerto"/></label></div>
 								</div>
								<div class="contenedor_derecha">
									<div class="text">
										<input readonly="readonly" style="background-color:white" name="puerto" maxlength="5" value="${form.puerto}" id="NombrePuerto" type="text" />
									</div>
								</div>
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>
							
							
							<!-- 		CAMPO COMUNIDAD AUTONOMA		-->
			  							
							<div class="fila_de_tabla">
  								<div class="contenedor_izquierda">
  									<div class="text"><label for="NombreCcaa"><bean:message key="nodos.nombreCcaa"/></label></div>
 								</div>
								<div class="contenedor_derecha">
									<div class="text">
										<input readonly="readonly" style="background-color:white" name="comunidad" value="${form.comunidad}" id="NombreCcaa" type="text" />
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
	
	<input class="boton_125 tipo"  type="submit"  value="<bean:message key='nodos.volver'/>" />
	
	
</form>

<!--		Fin del Formulario principal		-->
	

</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>