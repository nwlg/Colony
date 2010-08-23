<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<tiles:insert definition="layout-usuario">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">

<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- ATENCION!! RREMPLAZAR ESTA CAPA DE LA  PLANTILLA DE CONTENIDO ("plantilla_contenido") POR LA QUE SE DESEE EN LA PLANTILLA BASE  -->
<!-- Inicio plantilla contenido  -->
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">
<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />
<h2><bean:message key="descargas.condiciones.cabecera"/> : ${form.titulo}</h2>
<form method="post" action="<html:rewrite action="/Descargas/CondicionesSubmit"/>" >

<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >
			<p class="parrafo_comun" ><bean:message key="descargas.condiciones.texto1"/></p>
			<p class="parrafo_comun" ><bean:message key="descargas.condiciones.texto2"/></p>
			<p class="parrafo_comun" ><bean:message key="descargas.condiciones.texto3"/></p>
			<p class="parrafo_comun" ><bean:message key="descargas.condiciones.texto4"/></p>
			<p class="parrafo_comun" ><bean:message key="descargas.condiciones.texto5"/></p>
		<!-- -->
		<!-- -->
			<div class="fila_de_tabla">
					<input type="hidden" name="identificador" value="${form.identificador }"/>
					<div class="text" ><label for="Disclaimer" class="oculto" ><bean:message key="descargas.condiciones.acepto"/></label>
					<input type="checkbox" id="Disclaimer" name="condiciones" class="boton_radio" /><span class="vert"><bean:message key="descargas.condiciones.acepto"/></span></div>
					<div class="linea_separadora"></div>
					<br class="oculto" />
				</div>
				<!-- -->	
</div>
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->

<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<fieldset class="tipo">
<input class="boton_125_de_2_izq" name="action" type="submit"  value="<bean:message key="descargas.condiciones.cancelar"/>" />
<input class="boton_125_de_2" name="action" type="submit"  value="<bean:message key="descargas.condiciones.aceptar"/>" />
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>

</div>
</tiles:put>
</tiles:insert>