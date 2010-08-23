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

<h2><bean:message key="usuarios.modificarPerfil.cabecera"/></h2>


<!--		Inicio del formulario principal		-->

<form id="modificarPerfilConfirmacionModificacionAceptarForm" action='<html:rewrite action="/ModificarPerfil/ConfirmacionModificacionAceptar"/>' method="post"  >


	<!--		INICIO GLOBO GRIS		-->
	
	<div class="globo_gris" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
				
				
				<!--		INICIO CAJA DE FORMULARIO		-->
				
				<div id="formulario" class="ali_c">
					<br />
					<p><em class="correcto"><bean:message key="usuarios.modificadoPerfil" /></em></p>
					<br />
				</div>
				
				<!--		FIN CAJA DE FORMULARIO		-->
				
				
				</div>
			</div>
		</div>
	</div>
	
	<!--		FIN GLOBO GRIS		-->

	<input class="boton_125 tipo ft_centrada"  type="submit"  value="<bean:message key="usuarios.aceptar"/>" />

</form>

<!--		Fin del Formulario principal		-->


</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>