<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>


<tiles:insert definition="layout-gestor-flujo-con-style">

	<tiles:put name="title" type="string">
		<bean:message key="title.Comun" />
	</tiles:put>

	<tiles:put name="body" type="string">

		<!-- *****************************   Inicio  Plantilla contenido      ********************************** -->
		<div class="plantilla_contenido"><!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
		<jsp:include page="/layout/messages.jsp" flush="true" />

		<h2><bean:message key="gestorFlujo.proponer.proponerPublicacion"/></h2>

	
		<form method="post"
			action="<html:rewrite action="/${initParam.url_proponer_principal_aceptar}" />"><!--  INICIO GLOBO GRIS   -->
		<!--  INICIO GLOBO GRIS   -->
		<div class="globo_gris">
		<div class="globo_gris_01">
		<div class="globo_gris_02">
		<div class="globo_gris_03"><!--  INICIO CAJA DE FORMULARIO   -->
		<div id="formulario"><!--  INICIO GLOBO Blanco   --> <!--  INICIO GLOBO Blanco   -->
		<div class="globo_blanco">
		<div class="globo_blanco_01">
		<div class="globo_blanco_02">
		<div class="globo_blanco_03">
		<input type="hidden" name="idODE" value="${form.idODE}"/>
		<input type="hidden" name="idUsuario" value="${form.idUsuario}"/>
		<input type="hidden" name="titulo" value="${form.titulo}"/>
		<p class="parrafo_comun"><bean:message
			key="gestorFlujo.proponer.comentarios" /></p>
		<div class="fila_de_tabla">
		<div class="text" style="text-align:center">
			<label 	for="proponer">
				<span class="oculto"><bean:message 	key="gestorFlujo.proponer.proponerPublicacion" />
				</span>
			</label> 
			<textarea name="comentarios" rows="5" cols="40" class="ta_minimo_ancho"
			onfocus="limpiarTexto(this)" onblur="this.style.backgroundColor='#e1e1e1'" 
			id="proponer" title="<bean:message key="gestorFlujo.proponer.introduzca" />"></textarea>
		</div>

		<br class="oculto" />
		</div>
		<br />
		<!-- --></div>
		</div>
		</div>
		</div>
		<!--  Fin GLOBO Blanco   --> <!--  Fin GLOBO Blanco   -->
		</div>
		<!--  FIN CAJA DE FORMULARIO   -->
		</div>
		</div>
		</div>
		</div>

		<!--  FIN GLOBO GRIS   --> <!--  FIN GLOBO GRIS   --> <!-- Inicio Botones  -->
		<!-- Inicio Botones  --> <input class="boton_125_de_2 tipo" type="submit"
			value="<bean:message key="gestorFlujo.aceptar"/>" /></form>
		<form
			action="<html:rewrite action="${initParam.url_proponer_principal_cancelar}"/>"
			method="post"><input class="boton_125_de_2_izq tipo"
			type="submit"
			value="<bean:message key="gestorFlujo.cancelar"/>" /></form>
		<!-- Fin Botones  --></div>
		<!-- <div class="plantilla_contenido"> -->
	</tiles:put>

</tiles:insert>
