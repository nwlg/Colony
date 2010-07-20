<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/tags-empaquetador.tld" prefix="emp" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<bean:define id="urlArchivos"><html:rewrite action="/GestorArchivos/GestorArchivos"/></bean:define>
<bean:define id="urlRecursos"><html:rewrite action="/GestorRecursos/GestorRecusos"/></bean:define>
<bean:define id="urlOrganizaciones"><html:rewrite action="/GestorOrganizaciones/GestorOrganizaciones"/></bean:define>
<bean:define id="urlSubmanifiestos"><html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestos"/></bean:define>
<bean:define id="urlGuardar"><html:rewrite action="/GestorRecursos/GestorRecursos"/></bean:define>
<bean:define id="selected" value="recursos"/>
<emp:layout selected="${selected}" urlArchivos="${urlArchivos}" urlRecursos="${urlRecursos}" urlSubmanifiestos="${urlSubmanifiestos}" urlOrganizaciones="${urlOrganizaciones}" urlGuardar="${urlGuardar}" titleKey="title.Comun">
<bean:define id="empaquetadorSesion" name="<%=es.pode.empaquetador.presentacion.EmpaquetadorSession.SESSION_KEY%>" scope="session"/>
<!-- gestor de archivos session -->
<%@ include  file="/es/pode/empaquetador/presentacion/avanzado/recursos/gestor/gestor-recursos-vars.jspf" %>

<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>
<script language="javascript">
function doSubmit(sAction) {
        document.forms["resource"].action.value = sAction;
        document.forms["resource"].submit();
}
</script>

<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- ATENCION!! E3TA ES LA CAPA QUE DEBE REEMPLAZARSE POR LA DEL MISMO NOMBRE (plantilla contenido pestanias ) EN LA PLANTILLA DE  CONTENIDO  CON EL CONTENIDO DE FICHA -->
<div class="plantilla_contenido_pestanias">


<form name="resource" id="gestorRecursosGestorRecursosSubmitForm" 
		method="post" 
		action="<html:rewrite action="/GestorRecursos/GestorRecursosSubmit"/>" >
<input type=hidden name=action value="">

<!--  portapapeles  si es necesario -->




			<h2><bean:message key="presentacion.avanzado.recursos.gestor.cabecera.h2"/></h2>
		<!-- CAJA TABLA -->
		<!-- CAJA TABLA -->
<div class="lb_bubble_topleft">
<div class="lb_bubble_bottomleft">
<div class="lb_bubble_topright">
<div class="lb_bubble_bottomright">
<!-- start bubble -->
<div id=formulario>
<br>
			<div class="caja_tabla bordeada limpiar_breadcrumb" >
			
			<table border="1" class="administracion_tareas" cellpadding="0" cellspacing="0" width="100%" summary="<bean:message key="presentacion.avanzado.recursos.gestor.table.summary"/>">
			
			<caption><strong><bean:message key="presentacion.avanzado.recursos.gestor.table.caption"/></strong></caption>
			
<!--  iteracion para la tabla  -->			
			
			
			
<!--  *****************************PARA QUE HAGA CAMPO GRIS,CAMPO BLANCO  *****************************-->

					<c:set var="contador" value="true"/>
					<c:set var="contflechas" value="0"/>
			
<logic:notEmpty name="listado">
			<logic:iterate id="recurso" name="listado">
						<logic:equal name="contador" value="true">
							<tr class="tr_gris">
						</logic:equal>

						<logic:equal name="contador" value="false">
							<tr class="tr_blanco">
						</logic:equal>
						<c:set var="contador" value="${!contador}"/>
						
<!--  *****************************FIN PARA QUE HAGA CAMPO GRIS,CAMPO BLANCO ***************************** -->

<!--  *****************************dibujo: recurso  ***************************** -->
				<td valign="top"  class="sin_b">
					<input type="checkbox" name="identifierRowSelectionAsArray" value="${recurso.identifier}" />
				</td>
				<td valign="top"  class="tar7" >
			<logic:notEmpty name="recurso" property="href">
			<bean:define id="urlConHost"><rewrite:rewrite url="${recurso.recursoURL}"/></bean:define>
					<a href="<emp:encodeURL url="${urlConHost }"/>" target="_blank" class="recurso">${recurso.href}</a>
			</logic:notEmpty>
			<logic:empty name="recurso" property="href">
					<a href="#" class="recurso">${recurso.identifier}</a>
			</logic:empty>
			</td>
			<logic:empty name="recurso" property="lom" >
				<td valign="top" class="meta_datos_mas" >
			</logic:empty>
			<logic:notEmpty name="recurso" property="lom" >
				<td valign="top" class="meta_datos" >
			</logic:notEmpty>
					<span class="oculto">--</span>
					<a href="<html:rewrite action="/GestorRecursos/GestorRecursosMetadatos"/>?identifier=${recurso.identifier}&amp;returnURL=<html:rewrite action="/GestorRecursos/GestorRecursos"/>" ><bean:message key="presentacion.avanzado.recursos.gestor.table.link.metadatos"/></a>
				</td>
				<td valign="top" class="ejec">
					<span class="oculto">-</span>
					<a href="<html:rewrite action="/GestorRecursos/GestorRecursosModificar"/>?identifier=${recurso.identifier}"><bean:message key="presentacion.avanzado.recursos.gestor.table.link.modificar"/></a>
				</td>
				</tr>
		</logic:iterate>
		</logic:notEmpty>
		<logic:empty name="listado">
		<td><bean:message key="presentacion.avanzado.recursos.gestor.table.empty.message"/></td>
		</logic:empty>
<!-- fin iteracion para la tabla  -->			
			
			</table>
			</div>
		<!-- FIN CAJA TABLA -->
		<!-- FIN CAJA TABLA -->
			
			<!-- Inicio Botones  -->
			<!-- Inicio Botones  -->
</div>
				<fieldset class="tipo_interior_02">

<div class="packer_deleteresource">
        <div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright"><div class="db_bubble_content">
                <a href="javascript:doSubmit('Delete Resource');">Delete Resource</a>
        </div></div></div></div></div>
</div>

<div class="packer_createresource">
        <div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright"><div class="db_bubble_content">
                <a href="javascript:doSubmit('Create Resource');">Create Resource</a>
        </div></div></div></div></div>
</div>

<div class="packer_importresource">
        <div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright"><div class="db_bubble_content">
                <a href="javascript:doSubmit('Import Resource');">Import Resource</a>
        </div></div></div></div></div>
</div>

<div class="packer_exportresource">
        <div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright"><div class="db_bubble_content">
                <a href="javascript:doSubmit('Export Resource');">Export Resource</a>
        </div></div></div></div></div>
</div>
<!--				<br class="oculto" /><br class="oculto" /> -->

				</fieldset>
			<!-- Fin Botones  -->
			<!-- Fin Botones  -->
<!--  FIN CAJA DE FORMULARIO   -->
</div></div></div></div>


</form>
</div>
<!-- HASTA AQUI EL REEEMPLAZO -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->


</div>
<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
</emp:layout>
