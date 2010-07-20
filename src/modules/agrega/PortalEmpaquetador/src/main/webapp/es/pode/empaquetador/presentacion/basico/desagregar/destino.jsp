<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tlds/tags-empaquetador.tld" prefix="emp" %>
<bean:define id="urlGuardar"><html:rewrite action="/GestorBasico/GestorBasico"/></bean:define>
<bean:define id="urlEstructura"><html:rewrite action="/GestorBasico/GestorBasico"/></bean:define>
<bean:define id="urlArchivos"><html:rewrite action="/GestorArchivos/GestorArchivos"/></bean:define>
<bean:define id="selected" value="estructura"/>
<emp:layout selected="${selected}" urlArchivos="${urlArchivos}" urlEstructura="${urlEstructura}" urlGuardar="${urlGuardar}" titleKey="title.Comun">
<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>
<h2><bean:message key="gestor_basico.desagregar.titulo"/></h2>
<form name="form" id="desagregarBasicoDestinoSubmitForm" method="post" action="<html:rewrite action="/DesagregarBasico/DestinoSubmit"/>">
<p class="parrafo_comun" id="separacion2"><bean:message key="gestor_basico.desagregar.texto"/>:</p>

<script language="javascript">

function doSubmit(sAction)
{
	document.forms["form"].action.value = sAction;
	document.forms["form"].submit();
}

</script>

<!-- Start of bubble -->
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">

			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >
			<br/>
			 <div class="fila_de_tabla">
  				<div class="text ft_lateral">
  					<input type="radio" class="boton_radio" id="Origen01" checked="checked" name="destino" value="Personales"/>
  					<label for="Origen01" class="alineada"><bean:message key="gestor_basico.desagregar.personales"/></label>
  				</div>
				<div class="linea_separadora"></div>
				<br class="oculto" />
				</div>
				<!--     -->
			<div class="fila_de_tabla">
  				<div class="text ft_lateral"><input  type="radio" class="boton_radio" id="Origen02"  name="destino" value="Local"/><label for="Origen02"  class="alineada2"><bean:message key="gestor_basico.desagregar.local"/></label></div>
				<div class="linea_separadora"></div>
				<br class="oculto" />
				</div>
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
			<a href="javascript:doSubmit('<bean:message key='gestor_basico.desagregar.aceptar'/>');"><bean:message key='gestor_basico.desagregar.aceptar'/></a>
		</div>
	
		</div></div></div></div>
		<!-- End of bubble -->
	</div>

	<div class="packer_newfolder_cancel">
		<!-- Start of Cancel button -->
		<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
	
		<div class="db_bubble_content">
			<a href="javascript:doSubmit('<bean:message key='gestor_basico.desagregar.cancelar'/>');"><bean:message key='gestor_basico.desagregar.cancelar'/></a>
		</div>
	
		</div></div></div></div>
		<!-- End of bubble -->
	</div>

</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>
</div>
</emp:layout>