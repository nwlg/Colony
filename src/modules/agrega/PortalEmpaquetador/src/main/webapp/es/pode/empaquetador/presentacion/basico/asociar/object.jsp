<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tlds/tags-empaquetador.tld" prefix="emp" %>
<bean:define id="urlGuardar"><html:rewrite action="/Asociar/ObjectEstructura"/></bean:define>
<bean:define id="urlEstructura"><html:rewrite action="/Asociar/ObjectEstructura"/></bean:define>
<bean:define id="urlArchivos"><html:rewrite action="/Asociar/ObjectArchivos"/></bean:define>
<bean:define id="selected" value="estructura"/>
<emp:layout selected="${selected}" urlArchivos="${urlArchivos}" urlEstructura="${urlEstructura}" urlGuardar="${urlGuardar}" titleKey="title.Comun">

<!-- Inicio plantilla contenido  -->
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>

<h2><bean:message key="portalempaquetado.basico.asociar.archivos.titulo"/></h2>
<form id="asociarObjectSubmitForm" method="post" action="<html:rewrite action="/Asociar/ObjectSubmit"/>" >
<p class="parrafo_comun" id="separacion2"><bean:message key="portalempaquetado.basico.asociar.embed"/>:</p>
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" style="padding-top:10px;">

				 <div class="fila_de_tabla">
  						<div class="text" style="text-align:center"><label for="nombre_embed"><span class="oculto"><bean:message key="portalempaquetado.basico.asociar.embedNombre"/></span></label><textarea name="texto" rows="5" cols="40" class="ta_minimo_ancho" onblur="this.style.backgroundColor='#e1e1e1'" id="nombre_embed"  title="Introduzca aqu�" >${form.texto }</textarea></div>
					<br class="oculto" />
				</div>
				<br />
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
<input class="boton_125_de_2"  type="submit"  name="action" value="<bean:message key='portalempaquetado.basico.asociar.archivos.aceptar'/>" />
<input class="boton_125_de_2_izq"  type="submit"  name="action" value="<bean:message key='portalempaquetado.basico.asociar.archivos.cancelar'/>" />

</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>

</div>
<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->

</emp:layout>
<!--  FIN CAPA MADRE   -->