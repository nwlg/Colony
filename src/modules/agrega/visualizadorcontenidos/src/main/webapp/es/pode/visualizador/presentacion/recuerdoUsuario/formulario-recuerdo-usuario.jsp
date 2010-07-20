<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<tiles:insert definition="layout-usuario">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>


<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>


<!--		Inicio plantilla contenido		-->

<div class="plantilla_contenido" id="ventana_flotante">


<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />

<h2><bean:message key="usuarios.recuerdoClave.cabecera"/></h2>


<!--		Inicio del formulario principal		-->

<form id="recuerdoUsuarioFormularioRecuerdoUsuarioAceptarForm" action='<html:rewrite action="/RecuerdoUsuario/FormularioRecuerdoUsuarioAceptar"/>' method="post" >


	<!--		INICIO GLOBO GRIS		-->
	
	<div class="globo_gris" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
				
				
					<!--		INICIO CAJA DE FORMULARIO		-->
					
					<div id="formulario" >
					
					
						<!--		CAMPO DEL NIF		-->
						
						<div class="fila_de_tabla">
		  					<div class="contenedor_izquierda">
		  						<div class="text"><label for="NIF"><bean:message key="usuarios.NIF" /></label></div>
		 					</div>
							<div class="contenedor_derecha">
								<div class="text"><input name="nif"  value="" id="NIF" type="text" title="<bean:message key="usuarios.introduzcaNIF"/>"  /></div>
							</div>
							<div class="linea_separadora"></div>
							<br class="oculto" />
						</div>
						
						
						<!--		CAMPO DEL CORREO ELECTRONICO		-->
						
						<div class="fila_de_tabla">
		  					<div class="contenedor_izquierda">
		  						<div class="text"><label for="email"><bean:message key="usuarios.mail" /></label></div>
		 					</div>
							<div class="contenedor_derecha">
								<div class="text"><input name="email"  value="" id="email" type="text" title="<bean:message key="usuarios.introduzcaMail"/>"  /></div>
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
	
	
	<!--		Boton siguiente		  -->
	
	<input class="boton_125_de_2 tipo"  type="submit"  value="<bean:message key='usuarios.enviar'/>" />


</form>

<!--		Fin del Formulario principal		-->


<!--		Inicio formulario secundario y boton Cancelar		-->
	
<form id="recuerdoUsuarioFormularioRecuerdoUsuarioCancelarForm" action="<html:rewrite action='/RecuerdoUsuario/FormularioRecuerdoUsuarioCancelar'/>" method="post" >
	<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key='usuarios.cancelar'/>" />
</form>
	
<!--		Fin formulario secundario		-->
	

</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>