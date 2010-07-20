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

<h2><bean:message key="portal_empaquetado.crearCarpeta"/></h2>

<form name="form" method="post" action="<html:rewrite action="/CrearCarpeta/CrearCarpetaAceptar"/>" >
<p class="parrafo_comun" id="separacion2"><bean:message key="portal_empaquetado.crearCarpetaIntroducirNombre"/>:</p>

<!-- Start of bubble -->
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">

			<div id="formulario" ><br/>

			 <div class="fila_de_tabla">
  						<div class="text" style="text-align:center"><label for="nombre"><span class="oculto"><bean:message key="portal_empaquetado.crearCarpetaNombre"/></span></label><input name="nombre" class="nombreCarpeta" onfocus="limpiarTexto(this)" value=""  onblur="this.style.backgroundColor='#e1e1e1'" id="nombre" type="text" title=<bean:message key="portal_empaquetado.crearCarpetaNombre.tooltip"/>  /></div>
					<br class="oculto" />
				</div>
				<br />
				</div>
				<!--  FIN CAJA DE FORMULARIO   -->

</div></div></div></div>
<!-- End of bubble -->


<!-- Inicio Botones  -->
<!-- Inicio Botones  -->

<fieldset class="tipo">

	<input type="hidden" name="action" value="" />

	<div class="packer_newfolder_accept">
		<!-- Start of Accept button -->
		<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
	
		<div class="db_bubble_content">
			<a href="javascript:doSubmit('<bean:message key='portal_empaquetado.aceptarCrearCarpeta'/>');"><bean:message key='portal_empaquetado.aceptarCrearCarpeta'/></a>
		</div>
	
		</div></div></div></div>
		<!-- End of bubble -->
	</div>

	<div class="packer_newfolder_cancel">
		<!-- Start of Cancel button -->
		<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
	
		<div class="db_bubble_content">
			<a href="javascript:doSubmit('<bean:message key='portal_empaquetado.cancelarCrearCarpeta'/>');"><bean:message key='portal_empaquetado.cancelarCrearCarpeta'/></a>
		</div>
	
		</div></div></div></div>
		<!-- End of bubble -->
	</div>

</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>
<script type="text/javascript">
  document.forms[0].nombre.focus();

function doSubmit(sAction)
{
	document.forms["form"].action.value = sAction;
	document.forms["form"].submit();
}

</script>
</div>
<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->

</emp:layout>