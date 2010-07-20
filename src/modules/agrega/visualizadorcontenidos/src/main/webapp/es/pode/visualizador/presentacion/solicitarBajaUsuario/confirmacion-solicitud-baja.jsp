<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<tiles:insert definition="layout-usuario">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>



<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>


<!--		Inicio plantilla contenido		-->

<div class="plantilla_contenido">


<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />

<h2><bean:message key="usuarios.solicitarBaja.cabecera"/></h2>


<!--		Inicio del formulario principal		-->

<form id="solicitarBajaUsuarioConfirmacionSolicitudBajaAceptarForm" action='<html:rewrite action="/SolicitarBajaUsuario/ConfirmacionSolicitudBajaAceptar"/>' method="post"  >


	<!--		INICIO GLOBO GRIS		-->
	
	<div class="globo_gris" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
				
				
				<!--		INICIO CAJA DE FORMULARIO		-->
				
				<div id="formulario" class="ali_c">
					<br />
					<p><bean:message key="usuarios.solicitarBaja.confirmacion" /></p>
					<br />
				</div>
				
				<!--  FIN CAJA DE FORMULARIO   -->
				
				
				</div>
			</div>
		</div>
	</div>
	
	<!--		FIN GLOBO GRIS		-->
	
	
	<!--		Boton aceptar		-->

	<input class="boton_125_de_2 tipo"  type="submit"  value="<bean:message key='usuarios.aceptar'/>" />

</form>

<!--		Fin del Formulario principal		-->


<!--		Formulario secundario y boton cancelar		-->

<form id="solicitarBajaUsuarioConfirmacionSolicitudBajaCancelarForm" action="<html:rewrite action='/SolicitarBajaUsuario/ConfirmacionSolicitudBajaCancelar'/>" method="post" >
	<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key='usuarios.cancelar'/>" />
</form>

<!--		Fin del Formulario secundaraio		-->


</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>