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

<h2><bean:message key="gruposTrabajo.verGrupo.cabecera"/></h2>


<!--		Inicio del formulario principal		-->

<form id="verCatalogadoresVerCatalogadoresVolverForm" action='<html:rewrite action="/VerCatalogadores/VerCatalogadoresVolver"/>' method="post" >


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
									<input DISABLED style="background-color:white" name="nombre" value="${form.nombre}" id="Nombre" type="text" maxlength="50" title="<bean:message key="gruposTrabajo.introduzcaGrupo"/>"  />
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
									<input DISABLED style="background-color:white" name="descripcion" value="${form.descripcion}" id="Descripcion" type="text" maxlength="200" title="<bean:message key="gruposTrabajo.introduzcaDescripcion"/>"  />
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
	
	<input class="boton_125_de_2 tipo"  type="submit"  value="<bean:message key='usuarios.volver'/>" />
	
</form>

<!--		Fin del Formulario principal		-->

	

</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>