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

<h2><bean:message key="gruposTrabajo.alta.cabecera"/></h2>


<!--		Inicio del formulario principal		-->

<form id="altaCatalogadoresFormularioInicioCatalogadoresAceptarForm" action='<html:rewrite action="/AltaCatalogadores/FormularioInicioCatalogadoresAceptar"/>' method="post" >


	<!--		INICIO GLOBO GRIS		-->
	
	<div class="globo_gris" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
				
				
					<!--		INICIO CAJA DE FORMULARIO		-->
					<div id="formulario" >
						
						
						<!--		NOMBRE		-->
						<div class="fila_de_tabla">
							<div class="contenedor_izquierda">
								<div class="text"><label for="Nombre"><bean:message key="gruposTrabajo.nombreGrupo"/></label></div>
							</div>
							<div class="contenedor_derecha">
								<div class="text">
									<input name="nombre" value="${form.nombre}" id="Nombre" type="text" maxlength="50" title="<bean:message key="gruposTrabajo.introduzcaGrupo"/>"  />
								</div>
							</div>
							<div class="linea_separadora">
							</div><br />
						</div>
						
						
						<!-- 		DESCRIPCION		-->
						<div class="fila_de_tabla">
							<div class="contenedor_izquierda">
								<div class="text"><label for="Descripcion"><bean:message key="gruposTrabajo.descripcion"/></label></div>
							</div>
							<div class="contenedor_derecha">
								<div class="text">
									<input name="descripcion" value="${form.descripcion}" id="Descripcion" type="text" maxlength="200" title="<bean:message key="gruposTrabajo.introduzcaDescripcion"/>"  />
								</div>
							</div>
							<div class="linea_separadora">
							</div><br />
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
	
</form>

<!--		Fin del Formulario principal		-->


<!--		Inicio formulario secundario y boton Cancelar		-->
	
<form id="altaCatalogadoresFormularioInicioCatalogadoresCancelarForm" action='<html:rewrite action="/AltaCatalogadores/FormularioInicioCatalogadoresCancelar"/>' method="post" >
	<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key='usuarios.cancelar'/>" />
</form>
	
<!--		Fin formulario secundario		-->
	

</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>