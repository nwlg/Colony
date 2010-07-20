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

		<h2><bean:message key="gestorFlujo.proponer.proponer"/></h2>

	
		<form method="post"
			action="<html:rewrite action="/${initParam.url_proponerCatalogacion_aceptar}" />"><!--  INICIO GLOBO GRIS   -->
		<input name="comentarios" value="N/A" type=hidden>
		<!--  INICIO GLOBO GRIS   -->
		<div class="globo_gris">
		<div class="globo_gris_01">
		<div class="globo_gris_02">
		<div class="globo_gris_03"><!--  INICIO CAJA DE FORMULARIO   -->
		<div id="formulario" class="legalese"><!--  INICIO GLOBO Blanco   --> <!--  INICIO GLOBO Blanco   -->

		<input type="hidden" name="idODE" value="${form.idODE}"/>
		<input type="hidden" name="idUsuario" value="${form.idUsuario}"/>
		<input type="hidden" name="titulo" value="${form.titulo}"/>
		<p class="parrafo_comun"><bean:message key="gestorFlujo.legal1" /></p>
		<p class="parrafo_comun"><bean:message key="gestorFlujo.legal2" /></p>
		<p class="parrafo_comun"><bean:message key="gestorFlujo.legal3" />
			<ul>
				<li><bean:message key="gestorFlujo.legal3a" />
				<li><bean:message key="gestorFlujo.legal3b" />
				<li><bean:message key="gestorFlujo.legal3c" />
					<ul>
						<li><bean:message key="gestorFlujo.legal3ci" />
						<li><bean:message key="gestorFlujo.legal3cii" />
						<li><bean:message key="gestorFlujo.legal3ciii" />
					</ul>
				<li><bean:message key="gestorFlujo.legal3d" />
			</ul>
		</p>
		<br />
			<div class="fila_de_tabla">
			<div class="text" ><label for="Disclaimer" class="oculto" ><bean:message key="gestorFlujo.acepto.condiciones" /></label>
			
			<input type="checkbox" name="seleccion" id="Disclaimer" class="boton_radio" /> <span class="vert"><bean:message key="gestorFlujo.acepto.condiciones" /></span></div>
			<div class="linea_separadora"></div>
			<br class="oculto" />
			
		<br />
		<p class="parrafo_comun"><bean:message key="gestorFlujo.legal4" /></p>
		<p class="parrafo_comun"><bean:message key="gestorFlujo.legal5" />
			<ul>
				<li><bean:message key="gestorFlujo.legal5a" />
				<li><bean:message key="gestorFlujo.legal5b" />
			</ul>
		</p>
		</div>
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
			action="<html:rewrite action="${initParam.url_objetosPersonales }"/>"
			method="post"><input class="boton_125_de_2_izq tipo"
			type="submit"
			value="<bean:message key="gestorFlujo.cancelar"/>" /></form>
		<!-- Fin Botones  --></div>
		<!-- <div class="plantilla_contenido"> -->
	</tiles:put>

</tiles:insert>
