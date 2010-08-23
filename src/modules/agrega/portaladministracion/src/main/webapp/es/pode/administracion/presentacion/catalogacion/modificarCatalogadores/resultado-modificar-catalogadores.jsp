<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>



<tiles:insert definition="layout-administrador">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>


<!-- 		INICIO DEL BODY		  -->

<tiles:put name="body" type="string">


<!--		Inicio plantilla contenido		-->

<div class="plantilla_contenido">


<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />

<h2><bean:message key="gruposTrabajo.modificarGrupoTrabajo"/></h2>


<!--		Inicio del formulario principal		-->

<form id="modificarCatalogadoresResultadoModificarCatalogadoresVolverForm" action='<html:rewrite action="/ModificarCatalogadores/ResultadoModificarCatalogadoresVolver"/>' method="post"  >


	<!--		INICIO GLOBO GRIS		-->
	
	<div class="globo_gris" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
				
				
				<!--		INICIO CAJA DE FORMULARIO		-->
					<input id="idModificado" name="idModificado" type="hidden" value="${form.idModificado }" >
					<div id="formulario" class="ali_c">
						<br />
						<logic:equal name="form" property="resultado" value="gruposTrabajo.modificar.OK" >
							<p><em class="correcto"><bean:message key="${form.resultado}" /></em></p>
	                    </logic:equal>
						<logic:equal name="form" property="resultado" value="gruposTrabajo.modificar.FALLO" >
                        	<p><em class="incorrecto"><bean:message key="${form.resultado}" /></em></p>
	                    </logic:equal>
						<br />
					</div>
				
				<!--  FIN CAJA DE FORMULARIO   -->
				
				
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

<!--		FIN DEL BODY		-->


</tiles:insert>