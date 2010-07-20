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

<form id="desactivarUsuarioResultadoDesactivarUsuarioAceptarForm" action='<html:rewrite action="/DesactivarUsuario/ResultadoDesactivarUsuarioAceptar"/>' method="post"  >

	<!--		INICIO GLOBO GRIS		-->
	
	<div class="globo_gris" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
					
					
					<!--		INICIO CAJA DE FORMULARIO		-->
					
					<div id="formulario" class="ali_c">
				
							
						<br>
						<logic:equal name="form" property="resultado" value="desactivarUsuario.OK" >
							<p><em class="correcto"><bean:message key="${form.resultado}" /></em></p>
	                    </logic:equal>
						<logic:equal name="form" property="resultado" value="desactivarUsuario.FALLO" >
                        	<p><em class="incorrecto"><bean:message key="${form.resultado}" /></em></p>
	                    </logic:equal>
						<br />
						
				
					</div>
					
					<!--		FIN CAJA DE FORMULARIO		-->
					
					
				</div>
			</div>
		</div>
	</div>
	
	<!--		FIN GLOBO GRIS		-->


	<!--		Boton aceptar		-->

	<input class="boton_125 tipo ft_centrada"  type="submit"  value="<bean:message key="usuarios.aceptar"/>" />

</form>

<!--		Fin formulario principal		-->


</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>