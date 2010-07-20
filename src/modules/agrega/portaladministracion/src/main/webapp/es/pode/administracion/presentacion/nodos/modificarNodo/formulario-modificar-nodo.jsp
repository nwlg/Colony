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

<h2><bean:message key="nodos.modificar.cabecera"/></h2>


<!--		Inicio del formulario principal		-->

<form id="modificarNodoFormularioModificarNodoAceptarForm" action='<html:rewrite action="/ModificarNodo/FormularioModificarNodoAceptar"/>' method="post" >


	<!--		INICIO GLOBO GRIS		-->
	
	<div class="globo_gris" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
				
				
					<!--		INICIO CAJA DE FORMULARIO		-->
				
					<div id="formulario" >
					
						<!-- 		CAMPO DE ID (OCULTO)		-->
										
						<input name="id" value="${form.id}" type="hidden" />
					
					
						<!--		CAMPO NODO		-->
						
						<div class="fila_de_tabla">
							<div class="contenedor_izquierda">
								<div class="text"><label for="Nodo">*<bean:message key="nodos.nombreNodo"/></label></div>
							</div>
							<div class="contenedor_derecha">
								<div class="text">
									<input name="nodo" value="${form.nodo}" id="Nodo" type="text" maxlength="70" title="<bean:message key="nodos.introduzcaNodo"/>"  />
								</div>
							</div>
							<div class="linea_separadora"></div>
							<br class="oculto" />
						</div>
						
						
						<!--		CAMPO URL NODO		-->
						
						<div class="fila_de_tabla">
							<div class="contenedor_izquierda">
								<div class="text"><label for="url">*<bean:message key="nodos.nombreUrl"/></label></div>
							</div>
							<div class="contenedor_derecha">
								<div class="text">
									<input name="url" value="${form.url}" id="url" type="text" maxlength="150" title="<bean:message key="nodos.introduzcaUrl"/>"  />
								</div>
							</div>
							<div class="linea_separadora"></div>
							<br class="oculto" />
						</div>
						
						<!--		CAMPO URL WS		-->
						
						<div class="fila_de_tabla">
							<div class="contenedor_izquierda">
								<div class="text"><label for="urlWS">*<bean:message key="nodos.nombreUrlWS"/></label></div>
							</div>
							<div class="contenedor_derecha">
								<div class="text">
									<input name="urlWS" value="${form.urlWS}" id="urlWS" type="text" maxlength="150" title="<bean:message key="nodos.introduzcaUrlWS"/>"  />
								</div>
							</div>
							<div class="linea_separadora"></div>
							<br class="oculto" />
						</div>
						
						<!--		CAMPO PUERTO		-->
						
						<div class="fila_de_tabla">
							<div class="contenedor_izquierda">
								<div class="text"><label for="puerto"><bean:message key="nodos.nombrePuerto"/></label></div>
							</div>
							<div class="contenedor_derecha">
								<div class="text">
									<input name="puerto" value="${form.puerto}" id="puerto" type="text" maxlength="5" title="<bean:message key="nodos.introduzcaPuerto"/>"  />
								</div>
							</div>
							<div class="linea_separadora"></div>
							<br class="oculto" />
						</div>
						
						
						<!--		CAMPO ccaa (desplegable)		-->
						
						<div class="fila_de_tabla">
		  					<div class="contenedor_izquierda">
		  						<div class="text"><label for="ccaa" ><bean:message key="nodos.nombreCcaa"/></label></div>
		 					</div>
							<div class="contenedor_derecha">
								<div class="text">
								
									<bean:define id="introCcaa" ><bean:message key="nodos.introduzcaCcaa"/></bean:define>	
									<c:choose>
			                        	<c:when test="${!empty form.ccaaBackingList}">
			                        		<html:select name="form" property="ccaa" styleId="ccaa" title="${introCcaa} " >
			                        			<option value="#" selected="selected" ><bean:message key="tareas.vacia"/></option>
			                    				<html:optionsCollection name="form" property="ccaaBackingList"  label="label" value="value"/>
			                        		</html:select>
			                        	</c:when>
			                        	<c:otherwise>
			                        		<html:select name="form" property="ccaa" styleId="ccaa" title="${introCcaa}"/>
			                        	</c:otherwise>
			                        </c:choose>
								
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
	
	<input class="boton_125_de_2 tipo"  type="submit"  value="<bean:message key='usuarios.aceptar'/>" />
	<input name="idNodo" value="${form.idNodo}" type="hidden">
	
</form>

<!--		Fin del Formulario principal		-->


<!--		Inicio formulario secundario y boton Cancelar		-->
	
<form id="modificarNodoFormularioModificarNodoCancelarForm" action="<html:rewrite action='/ModificarNodo/FormularioModificarNodoCancelar'/>" method="post" >
	<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key='usuarios.cancelar'/>" />	
</form>
	
<!--		Fin formulario secundario		-->
	

</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>