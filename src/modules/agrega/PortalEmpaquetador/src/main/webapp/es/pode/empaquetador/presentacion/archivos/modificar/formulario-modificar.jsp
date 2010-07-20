<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/tags-empaquetador.tld" prefix="emp" %>
<bean:define id="urlArchivos"><html:rewrite action="/GestorArchivos/GestorArchivos"/></bean:define>
<bean:define id="urlRecursos"><html:rewrite action="/GestorRecursos/GestorRecursos"/></bean:define>
<bean:define id="urlOrganizaciones"><html:rewrite action="/GestorOrganizaciones/GestorOrganizaciones"/></bean:define>
<bean:define id="urlSubmanifiestos"><html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestos"/></bean:define>
<bean:define id="urlGuardar"><html:rewrite action="/GestorArchivos/GestorArchivos"/></bean:define>
<bean:define id="urlEstructura"><html:rewrite action="/GestorBasico/GestorBasico"/></bean:define>
<bean:define id="selected" value="archivos"/>
<emp:layout selected="${selected}" urlEstructura="${urlEstructura}" urlArchivos="${urlArchivos}" urlRecursos="${urlRecursos}" urlSubmanifiestos="${urlSubmanifiestos}" urlOrganizaciones="${urlOrganizaciones}" urlGuardar="${urlGuardar}" titleKey="title.Comun">
 <!-- Inicio plantilla contenido  -->
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>

<script language="javascript">
function doSubmit(sAction) {
	document.forms["modify"].action.value = sAction;
	document.forms["modify"].submit();
}
</script>

<h2><bean:message key="portal_empaquetado.renombrarCarpeta"/></h2>
<bean:define id="archivoVO" value="${form.archivoVO}" scope="session"/>
<form name="modify" id="modificarArchivoFormularioModificarAceptarForm" method="post" action="<html:rewrite action="/ModificarArchivo/FormularioModificarAceptar"/>" >
<input type=hidden name=action value="">
<p class="parrafo_comun" id="separacion2"><bean:message key="portal_empaquetado.explicacionRenombrarFichero"/>&nbsp;${form.archivoVO.nombre }:</p>
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="lb_bubble_topleft" >
	<div class="lb_bubble_bottomleft">
		<div class="lb_bubble_topright">
		

			<div class="lb_bubble_bottomright">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >

			 <div class="fila_de_tabla">
  						<div class="text" style="text-align:center"><label for="nombre"><span class="oculto"><bean:message key="portal_empaquetado.modificarCarpetaNombre"/></span></label><input name="nuevoNombre" class="nombreCarpeta"  value="${form.archivoVO.nombre}"  onblur="this.style.backgroundColor='#e1e1e1'" id="nombre" type="text" title="<bean:message key="portal_empaquetado.explicacionRenombrarFichero"/>&nbsp;${form.archivoVO.nombre }"  /></div>
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

<div class="packer_accept">
	<!-- Start of bubble -->
	<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
	<div class="db_bubble_content">
		<a href="javascript:doSubmit('Accept');"><bean:message key='portal_empaquetado.aceptarCrearCarpeta'/></a>
	</div>
	</div></div></div></div>
	<!-- End of bubble -->
</div>

<div class="packer_cancel">
	<!-- Start of bubble -->
	<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
	<div class="db_bubble_content">
		<a href="javascript:doSubmit('Cancel');"><bean:message key='portal_empaquetado.cancelarCrearCarpeta'/></a>
	</div>
	</div></div></div></div>
	<!-- End of bubble -->
</div>

<!--
<input class="boton_125_de_2"  type="submit"  name="action" value="<bean:message key='portal_empaquetado.aceptarCrearCarpeta'/>" />
<input class="boton_125_de_2_izq"  type="submit" name="action" value="<bean:message key='portal_empaquetado.cancelarCrearCarpeta'/>" />
-->

<input type="hidden" name="extension" value="${form.extension}" />

</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>
<script type="text/javascript">
  document.forms[0].nuevoNombre.focus();
</script>
</div>
<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->
</emp:layout>
