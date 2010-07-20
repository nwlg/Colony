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

<bean:define id="usuarioVO" name="modificarUsuarioBSession" property="usuario" scope="session" />
<h2><bean:message key="usuarios.modificar.cabecera"/> - <bean:write name="usuarioVO" property="usuario" /></h2>


<!--		Inicio del formulario principal		-->

<form id="modificarUsuarioFormularioGruposTrabajoAceptarForm" action='<html:rewrite action="/ModificarUsuario/FormularioGruposTrabajoAceptar"/>' method="post" >

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
												cellpadding="0" cellspacing="0" summary="${summary}"
												decorator="es.pode.administracion.presentacion.adminusuarios.modificarUsuario.ChequearFilasGruposTrabajo">
												
												<display:setProperty name="css.tr.odd" value="tr_gris"/>
												<display:setProperty name="css.tr.even" value="tr_blanco"/>
												<display:setProperty name="basic.show.header" value="true"/>
										
												
												<!--		Columna de checkbox		
												(llamamos a la getCheck que esta en la clase
												decorator creada para recuperar las casillas que estan marcadas)
												-->
												
												<display:column style="valign:top;" class="sin_b" property="check" title=""/>
												
												
												<!--		Columna de Usuario		-->
												
												<bean:define id="grupoValue"><bean:message key="gruposTrabajo.cabecera"/></bean:define>
												<display:column sortable="true" sortProperty="nombre" style="valign:top;" class="tar14" title="${grupoValue}">
													${fila.nombre}
												</display:column>
	  										
	  										</display:table>
	  										
	  										
										<!-- </div> Se cierra en el displaytag.properties -->
										
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
	
<form id="FormularioGruposTrabajoCancelarForm" action='<html:rewrite action="/ModificarUsuario/FormularioGruposTrabajoCancelar"/>' method="post">
	<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key='usuarios.cancelar'/>" />
</form>
	
<!--		Fin formulario secundario		-->
	

</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>