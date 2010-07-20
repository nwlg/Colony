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
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- ATENCION!! RREMPLAZAR ESTA CAPA DE LA  PLANTILLA DE CONTENIDO ("plantilla_contenido") POR LA QUE SE DESEE EN LA PLANTILLA BASE  -->
<!-- Inicio plantilla contenido  -->
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>
<h2><bean:message key="gestor_basico.renombrar.organizacion.h2"/>&nbsp;${form.title }</h2>
<form name="form" id="crearCarpetaBasicoSubmitForm" method="post" action="<html:rewrite action="/RenombrarOrganizacionBasico/RenombrarSubmit"/>" >
<p class="parrafo_comun" id="separacion2"><bean:message key="gestor_basico.renombrar.organizacion.texto"/>:</p>

<!-- Start of bubble -->
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">

	<!--  INICIO CAJA DE FORMULARIO   -->
	<div id="formulario" >
		<br/>
		<div class="fila_de_tabla">
				<div class="text" style="text-align:center"><label for="nombreA"><span class="oculto"><bean:message key="gestor_basico.carpeta.nombre"/></span></label><input name="title" class="nombreGrupo" value="${fn:escapeXml(form.title)}"  onblur="this.style.backgroundColor='#e1e1e1'" id="nombreA" type="text" title="<bean:message key="gestor_basico.carpeta.nombre.introduzca"/>"  /></div>
			<br class="oculto" />
		</div>
		<br />
	</div>
	<!--  FIN CAJA DE FORMULARIO   -->

</div></div></div></div>
<!-- End of bubble -->

<input type="hidden" name="action" value="" />

<!-- Inicio Botones -->
<!-- Inicio Botones  -->
<fieldset class="tipo">

	<div class="packer_newfolder_accept">
		<!-- Start of Accept button -->
		<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
	
		<div class="db_bubble_content">
			<a href="javascript:doSubmit('<bean:message key="gestor_basico.renombrar.organizacion.aceptar"/>');"><bean:message key="gestor_basico.renombrar.organizacion.aceptar"/></a>
		</div>
	
		</div></div></div></div>
		<!-- End of bubble -->
	</div>

	<div class="packer_newfolder_cancel">
		<!-- Start of Cancel button -->
		<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
	
		<div class="db_bubble_content">
			<a href="javascript:doSubmit('<bean:message key="gestor_basico.renombrar.organizacion.cancelar"/>');"><bean:message key="gestor_basico.renombrar.organizacion.cancelar"/></a>
		</div>
	
		</div></div></div></div>
		<!-- End of bubble -->
	</div>

</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>
<script type="text/javascript">
  document.forms[0].title.focus();

function doSubmit(sAction)
{
	document.forms["form"].action.value = sAction;
	document.forms["form"].submit();
}

</script>
</div>
<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
</emp:layout>