<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>


<tiles:insert definition="${sessionScope.offline == true ? 'layout-offline' : 'layout-administrador'}">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">

<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />

<h2><bean:message key="configurarObjeto.anyadirObjeto"/></h2>
<form method="post" action="<html:rewrite action="/ConfigurarObjetos/ConfigurarObjetosSubmit"/>" id="configurarObjetosSubmitForm">
<p class="parrafo_comun" id="separacion2"><bean:message key="configurarObjeto.introduzca"/></p>
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >

			 <div class="fila_de_tabla">
  						<div class="text"><input type="radio" class="boton_radio" id="Ruta" checked="checked" name="option" value=<bean:message key="configurarObjeto.boton.ruta"/> /><label for="Introducir_ruta" class="alineada"><bean:message key="configurarObjeto.ruta"/></label></div>
				<div class="linea_separadora"></div>
				<br class="oculto" />
				</div>
				<!--     -->
			<div class="fila_de_tabla">
  						<div class="text"><input  type="radio" class="boton_radio" id="Buscar"  name="option" value=<bean:message key="configurarObjeto.boton.buscar"/> /><label for="buscar_Objeto"  class="alineada2"><bean:message key="configurarObjeto.buscar"/></label></div>

				<div class="linea_separadora"></div>
				<br class="oculto" />
				</div>
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
<input class="boton_125_de_2_izq"  name="action" type="submit"  value=<bean:message key="comun.cancelar"/> />
<input class="boton_125_de_2"  name="action" type="submit"  value=<bean:message key="configurarObjeto.Continuar"/> />
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->

</form>
</div>
<!-- Fin plantilla contenido  -->


    </tiles:put>

</tiles:insert>
