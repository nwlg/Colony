<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>


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

<bean:define id="usuarioVO" name="altaUsuarioBSession" property="usuario" scope="session" />
<h2><bean:message key="usuarios.alta.cabecera"/> - <bean:write name="usuarioVO" property="usuario" /></h2>


<!--		Inicio del formulario principal		-->

<form id="altaUsuarioFormularioGruposTrabajoAceptarForm" action='<html:rewrite action="/AltaUsuario/FormularioGruposTrabajoAceptar"/>' method="post" >

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
							
										<h3><bean:message key="gruposTrabajo.cabecera"/></h3>
	  									
	  									
	  									<!-- 		Inicio Caja Tabla		 -->
	  									
										<div class="caja_tabla">
	  										
	  										
	  										<display:table name="${form.gruposTrabajo}" uid="fila" requestURI="${pageContext.request.requestURL}"
										        export="false" sort="list" style="border:1;width:100%;" class="administracion_tareas"
												cellpadding="0" cellspacing="0" summary="${summary}">
												
												<display:setProperty name="css.tr.odd" value="tr_gris"/>
												<display:setProperty name="css.tr.even" value="tr_blanco"/>
												<display:setProperty name="basic.show.header" value="true"/>
										
												
												<!--		Columna de checkbox		-->
												
												<display:column style="valign:top;" class="sin_b">
										            <input type="checkbox" name="identificadorRowSelectionAsArray" value="${fila.identificador}" title='<bean:message key="usuarios.seleccione"/>'/>
										        </display:column>
												
												
												<!--		Columna de Grupos		-->
												
												<bean:define id="grupoTrabajoValue"><bean:message key="gruposTrabajo.cabecera"/></bean:define>
												<display:column sortable="true" sortProperty="nombre" style="valign:top;" class="tar14" title="${grupoTrabajoValue}">
													${fila.nombre}
												</display:column>
	  										
	  										</display:table>
	  										
	  										
										<!-- </div> Fin de la caja tabla (SE CIERRA EN displaytag.properties) -->
										<!-- en caso de no tener registros de usuarios se tiene que poner el div	-->
											
											<c:if test="${fn:length(form.gruposTrabajo) < 1}" >
								
								            	</div>
								                  
												<!--		Fin caja tabla		-->
												
								            </c:if>
										
										<!--		Fin Caja Tabla 		-->
										
										
									</div>
								</div>
							</div>
						</div>
						
						<!--		Fin GLOBO Blanco		-->
						
						
					</div>
					
					<!--		FIN CAJA DE FORMULARIO		-->
					
					
				</div>
			</div>
		</div>
	</div>
	
	<!--		FIN GLOBO GRIS		-->


	<!--		Boton Aceptar		-->
	
	<input class="boton_125_de_2 tipo"  type="submit"  value="<bean:message key='usuarios.aceptar'/>" />
	
	
</form>

<!--		Fin del Formulario principal		-->


<!--		Inicio formulario secundario y boton Cancelar		-->
	
<form id="altaUsuarioFormularioAltaUsuarioCancelarForm" action="<html:rewrite action='/AltaUsuario/FormularioAltaUsuarioCancelar'/>" method="post" >
	<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key='usuarios.cancelar'/>" />
</form>
	
<!--		Fin formulario secundario		-->
	

</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>
