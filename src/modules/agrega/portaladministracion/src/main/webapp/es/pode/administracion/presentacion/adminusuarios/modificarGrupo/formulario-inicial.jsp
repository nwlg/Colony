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

<h2><bean:message key="grupos.modificar1.cabecera"/></h2>


<!--		Inicio del formulario principal		-->

<form id="modificarGrupoFormularioInicialContinuarForm" action='<html:rewrite action="/ModificarGrupo/FormularioInicialContinuar"/>' method="post" >


	<!--		INICIO GLOBO GRIS		-->
	
	<div class="globo_gris" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
				
				
					<!--		INICIO CAJA DE FORMULARIO		-->
				
					<div id="formulario" >
					
						<!-- 		CAMPO DE ID (OCULTO)		-->
										
						<input name="id" value="${form.id}" type="hidden" />
										
						
						<!-- 		CAMPO DE DESCRIPCION 		-->
						
						<div class="fila_de_tabla">
							<div class="contenedor_izquierda">
								<div class="text"><label for="Descripcion"><bean:message key="grupos.nombreGrupo"/></label></div>
							</div>
							<div class="contenedor_derecha">
								<div class="text">
									<input name="descripcion" value="${form.descripcion}" id="Descripcion" maxlength="50" type="text" title="<bean:message key="grupos.introduzcaGrupo"/>"  />
								</div>
							</div>
							<div class="linea_separadora">
							</div><br />
						</div>
						<!-- -->
					</div>
					
					<!--		FIN CAJA DE FORMULARIO		-->
					
					
				</div>
			</div>
		</div>
	</div>
	
	<!--		FIN GLOBO GRIS		-->


	<!--		Boton Siguiente		-->
	
	<input class="boton_125_de_2 tipo"  type="submit"  value="<bean:message key='usuarios.siguiente'/>" />
	
</form>

<!--		Fin del Formulario principal		-->


<!--		Inicio formulario secundario y boton Cancelar		-->
	
<form id="modificarGrupoFormularioInicialCancelarForm" action="<html:rewrite action='/ModificarGrupo/FormularioInicialCancelar'/>" method="post" >
	<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key='usuarios.cancelar'/>" />
</form>
	
<!--		Fin formulario secundario		-->
	

</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>