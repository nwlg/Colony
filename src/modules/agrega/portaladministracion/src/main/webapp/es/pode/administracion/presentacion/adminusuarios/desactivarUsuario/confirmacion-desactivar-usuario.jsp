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

<h2><bean:message key="usuarios.desactivarUsuario.cabecera"/></h2>


<!--		Inicio del formulario principal		-->

<form id="desactivarUsuarioConfirmacionDesactivarUsuarioAceptarForm" action='<html:rewrite action="/DesactivarUsuario/ConfirmacionDesactivarUsuarioAceptar"/>' method="post"  >

	<!--		INICIO GLOBO GRIS		-->
	
	<div class="globo_gris" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
					
					<input type="hidden" name="id" value="${form.id}"/>
					
					<!--		INICIO CAJA DE FORMULARIO		-->
					
					<div id="formulario" class="ali_c">
						
						
						<p><bean:message key="usuarios.desactivarUsuario.confirmacion"/> ${form.usuario}</p>
						
						
					</div>
					
					<!--		FIN CAJA DE FORMULARIO		-->
					
					
				</div>
			</div>
		</div>
	</div>
	
	<!--		FIN GLOBO GRIS		-->



	<!-- Inicio Botones  -->

	<input class="boton_125_de_2 tipo"  type="submit"  value="<bean:message key='usuarios.aceptar'/>" />
	
</form>


<!--		Formulario secundario y boton cancelar		-->

<form id="desactivarUsuarioConfirmacionDesactivarUsuarioCancelarForm" action='<html:rewrite action="/DesactivarUsuario/ConfirmacionDesactivarUsuarioCancelar"/>' method="post">
	<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key='usuarios.cancelar'/>" />
</form>


</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>