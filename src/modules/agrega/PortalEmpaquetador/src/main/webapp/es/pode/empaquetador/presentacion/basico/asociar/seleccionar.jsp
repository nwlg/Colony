<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tlds/tags-empaquetador.tld" prefix="emp" %>

<bean:define id="urlGuardar"><html:rewrite action="/Asociar/SeleccionarEstructura"/></bean:define>
<bean:define id="urlEstructura"><html:rewrite action="/Asociar/SeleccionarEstructura"/></bean:define>
<bean:define id="urlArchivos"><html:rewrite action="/Asociar/SeleccionarArchivos"/></bean:define>
<bean:define id="selected" value="none"/>
<emp:layout selected="${selected}" urlArchivos="${urlArchivos}" urlEstructura="${urlEstructura}" urlGuardar="${urlGuardar}" titleKey="title.Comun">
<html:xhtml/>
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- ATENCION!! RREMPLAZAR ESTA CAPA DE LA  PLANTILLA DE CONTENIDO ("plantilla_contenido") POR LA QUE SE DESEE EN LA PLANTILLA BASE  -->
<!-- Inicio plantilla contenido  -->
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>
<h2><bean:message key="portalempaquetado.basico.asociar.titulo" /></h2>
<form name="form" id="asociarSeleccionarSubmitForm" method="post" action="<html:rewrite action="/Asociar/SeleccionarSubmit"/>" >
<p class="parrafo_comun" id="separacion2"><bean:message key="portalempaquetado.basico.asociar.seleccioneTipo" />:</p>

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
				<div class="text ft_lateral" ><html:radio styleClass="boton_radio" styleId="Archivo" value="Archivos" name="form" property="tipo" /><label for="Archivo" class="alineada"><bean:message key="portalempaquetado.basico.asociar.archivos" /></label></div>
		<div class="linea_separadora"></div>
		<br class="oculto" />
		</div>
		<!--     -->
	<div class="fila_de_tabla">
				<div class="text ft_lateral"><html:radio styleClass="boton_radio" styleId="embed_opcion" value="Object" name="form" property="tipo" /><label for="embed_opcion"  class="alineada2"><bean:message key="portalempaquetado.basico.asociar.opciones.embed" /></label></div>

		<div class="linea_separadora"></div>
		<br class="oculto" />
		</div>
		<!--     -->
	<div class="fila_de_tabla">
				<div class="text ft_lateral"><html:radio  styleClass="boton_radio" styleId="url" value="URL" name="form" property="tipo" /><label for="url"  class="alineada3"><bean:message key="portalempaquetado.basico.asociar.url" /></label></div>
		<div class="linea_separadora"></div>
		<br class="oculto" />

		</div>
		</div>
		<!--  FIN CAJA DE FORMULARIO   -->

</div></div></div></div>
<!-- End of bubble -->

<input type="hidden" name="action" value="" />

<!-- Inicio Botones  -->
<fieldset class="tipo">

	<div class="packer_newfolder_accept">
		<!-- Start of Accept button -->
		<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
	
		<div class="db_bubble_content">
			<a href="javascript:doSubmit('<bean:message key='portalempaquetado.Continuar' />');"><bean:message key='portalempaquetado.Continuar' /></a>
		</div>
	
		</div></div></div></div>
		<!-- End of bubble -->
	</div>

	<div class="packer_newfolder_cancel">
		<!-- Start of Cancel button -->
		<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
	
		<div class="db_bubble_content">
			<a href="javascript:doSubmit('<bean:message key='portalempaquetado.Cancelar' />');"><bean:message key='portalempaquetado.Cancelar' /></a>
		</div>
	
		</div></div></div></div>
		<!-- End of bubble -->
	</div>

</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>
</div>
<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
</emp:layout>