<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/tags-empaquetador.tld" prefix="emp" %>
<bean:define id="urlArchivos"><html:rewrite action="/GestorArchivos/GestorArchivos"/></bean:define>
<bean:define id="urlRecursos"><html:rewrite action="/GestorRecursos/GestorRecusos"/></bean:define>
<bean:define id="urlOrganizaciones"><html:rewrite action="/GestorOrganizaciones/GestorOrganizaciones"/></bean:define>
<bean:define id="urlSubmanifiestos"><html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestos"/></bean:define>
<bean:define id="urlGuardar"><html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestos"/></bean:define>
<bean:define id="urlEstructura"><html:rewrite action="/GestorBasico/GestorBasico"/></bean:define>
<bean:define id="selected" value="submanifiestos"/>
<emp:layout selected="${selected}" urlEstructura="${urlEstructura}" urlArchivos="${urlArchivos}" urlRecursos="${urlRecursos}" urlSubmanifiestos="${urlSubmanifiestos}" urlOrganizaciones="${urlOrganizaciones}" urlGuardar="${urlGuardar}" titleKey="title.Comun">
<bean:define id="empaquetadorSesion" name="<%=es.pode.empaquetador.presentacion.EmpaquetadorSession.SESSION_KEY%>" scope="session"/>


<!-- Inicio plantilla contenido  -->
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>

<h2><bean:message key="portal_empaquetado_gestorSubman_agregar.titulo"/></h2>
<form name="form" id="agregarSubmanifiestoSeleccionarOrigenAceptarForm" method="post" action="<html:rewrite action="/AgregarSubmanifiesto/SeleccionarOrigenAceptar"/>" enctype="multipart/form-data">
<p class="parrafo_comun" id="separacion2"><bean:message key="portal_empaquetado_gestorSubman_agregar.seleccionar"/></p>

<!-- Start of bubble -->
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">

	<!--  INICIO CAJA DE FORMULARIO   -->
	<div id="formulario" >
		<br/>
		<div class="fila_de_tabla">
				<div class="text ft_lateral"><input type="radio" class="boton_radio" id="Personales" checked="checked" name="origen" value="Personales"/><label for="Personales" class="alineada"><bean:message key="portal_empaquetado_gestorSubman_agregar.crearSubmanObjetosPersonales"/></label></div>
		<div class="linea_separadora"></div>
		<br class="oculto" />
		</div>
		<!--     -->
	<div class="fila_de_tabla">
				<div class="text ft_lateral"><input  type="radio" class="boton_radio" id="Local"  name="origen" value="Local" /><label for="Local"  class="alineada2"><bean:message key="portal_empaquetado_gestorSubman_agregar.crearSubmanOrdenador"/></label></div>
		<div class="linea_separadora"></div>
		<br class="oculto" />
		</div>
		<!--     -->
	<c:if test="${!empaquetadorSession.esOffline}">
	<div class="fila_de_tabla">
				<div class="text ft_lateral"><input  type="radio" class="boton_radio" id="Repositorio"  name="origen" value="Repositorio" /><label for="Repositorio"  class="alineada3"><bean:message key="portal_empaquetado_gestorSubman_agregar.crearSubmanRepositorio"/> </label></div>
		<div class="linea_separadora"></div>
		<br class="oculto" />
		</div>
	</c:if>
	</div>
	<!--  FIN CAJA DE FORMULARIO   -->
</div></div></div></div>
<!-- End of bubble -->

<input type="hidden" name="action" value="" />

<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<fieldset class="tipo">

	<div class="packer_newfolder_accept">
		<!-- Start of Accept button -->
		<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
	
		<div class="db_bubble_content">
			<a href="javascript:doSubmit('<bean:message key='portal_empaquetado_gestorSubman_agregar.continuar'/>');"><bean:message key='portal_empaquetado_gestorSubman_agregar.continuar'/></a>
		</div>
	
		</div></div></div></div>
		<!-- End of bubble -->
	</div>

	<div class="packer_newfolder_cancel">
		<!-- Start of Cancel button -->
		<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
	
		<div class="db_bubble_content">
			<a href="javascript:doSubmit('<bean:message key='portal_empaquetado_gestorSubman_agregarLocal.cancelar'/>');"><bean:message key='portal_empaquetado_gestorSubman_agregarLocal.cancelar'/></a>
		</div>
	
		</div></div></div></div>
		<!-- End of bubble -->
	</div>

</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>
<script type="text/javascript">
  document.forms[0].origen[0].focus();

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