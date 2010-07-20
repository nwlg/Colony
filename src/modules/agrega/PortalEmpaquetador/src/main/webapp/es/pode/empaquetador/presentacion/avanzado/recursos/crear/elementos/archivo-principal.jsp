<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/tags-empaquetador.tld" prefix="emp" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<bean:define id="urlArchivos"><html:rewrite action="/CrearRecursoAvanzadoElementos/RecursoArchivos"/></bean:define>
<bean:define id="urlRecursos"><html:rewrite action="/CrearRecursoAvanzadoElementos/RecursoRecursos"/></bean:define>
<bean:define id="urlOrganizaciones"><html:rewrite action="/CrearRecursoAvanzadoElementos/RecursoOrganizaciones"/></bean:define>
<bean:define id="urlSubmanifiestos"><html:rewrite action="/CrearRecursoAvanzadoElementos/RecursoSubmanifiestos"/></bean:define>
<bean:define id="urlGuardar"><html:rewrite action="/CrearRecursoAvanzadoElementos/RecursoRecursos"/></bean:define>
<bean:define id="selected" value="recursos"/>
<emp:layout selected="${selected}" urlArchivos="${urlArchivos}" urlRecursos="${urlRecursos}" urlSubmanifiestos="${urlSubmanifiestos}" urlOrganizaciones="${urlOrganizaciones}" urlGuardar="${urlGuardar}" titleKey="title.Comun">
<bean:define id="empaquetadorSesion" name="<%=es.pode.empaquetador.presentacion.EmpaquetadorSession.SESSION_KEY%>" scope="session"/>
<bean:define id="crearRecursoArchivoSession" name="<%=es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoArchivosSession.SESSION_KEY %>" scope="session"/>

<!--  INICIO CAPA MADRE   -->
<div id="capa_madre">

<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- ATENCION!! RREMPLAZAR ESTA CAPA DE LA  PLANTILLA DE CONTENIDO ("plantilla_contenido") POR LA QUE SE DESEE EN LA PLANTILLA BASE  -->
<!-- Inicio plantilla contenido  -->
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido" id="ventana_flotante">
<%@ include file="/layout/messages.jsp" %>
<script language="javascript">
function doSubmit(formname, sAction) {
        document.forms[formname].action.value = sAction;
        document.forms[formname].submit();
}
</script>

<h2><bean:message key="portalempaquetado.avanzado.recursos.crear.archivo.principal.titulo"/></h2>

<form name=mainform
	method="post" 
	id="crearRecursoAvanzadoElementosArchivoPrincipalAceptarForm"
	action="<html:rewrite action="/CrearRecursoAvanzadoElementos/ArchivoPrincipalAceptar"/>" >
<input type=hidden name=action value="">

<p class="parrafo_comun" id="separacion2"><bean:message key="portalempaquetado.avanzado.recursos.crear.archivo.principal.mensaje"/></p>
<!--  start bubble -->
<div class="lb_bubble_topleft" >
	<div class="lb_bubble_bottomleft">
		<div class="lb_bubble_topright">
			<div class="lb_bubble_bottomright">
			<div class="lb_bubble_content">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >
	
	<!--  INICIO CAPA TABLA   -->					
 <div class="caja_tabla bordeada" >

<logic:notEmpty name="crearRecursoArchivoSession" property= "archivos">

		<table border="1" class="generica_02" cellpadding="0" cellspacing="0" width="100%" summary="Tabla de Recursos">
		<caption><strong><bean:message key="portalempaquetado.avanzado.recursos.crear.tablaArchivoPrincipal"/></strong></caption>

<c:set var="contador" value="true"/>


<bean:define id="principal" value="${form.principal}" />

<logic:iterate id="file" name="crearRecursoArchivoSession" property="archivos">
<logic:equal name="contador" value="true">
		<tr class="tr_gris">
</logic:equal>
<logic:equal name="contador" value="false">
		<tr class="tr_blanco">
</logic:equal>
<c:set var="contador" value="${!contador}"/>
			<td valign="top"  class="sin_b">
			<label for="${file.href}" class="oculto" >Seleccione </label>
		
		<html:radio styleId="${file.href}" name="form" property="principal" value="${file.href }"/></td>
		<bean:define id="urlConHost"><rewrite:rewrite url="${file.url}"/></bean:define>		
		<td valign="top" class="td_larga"><a target="_blank" href="<emp:encodeURL url="${urlConHost}"/>" class="archivo">${file.href}</a></td>
		</tr>

</logic:iterate>

		 </table>
</logic:notEmpty>
</div>
	<!--  FIN CAPA TABLA   -->	
	
			</div>
				<!--  FIN CAJA DE FORMULARIO   -->

			</div>
		</div>
	</div>
</div>
</div>
<!--  end bubble -->

<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<fieldset class="tipo ft_centrada">

<div class="packer_accept">
 <div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright"><div class="db_bubble_content">
 <a href='javascript:doSubmit("mainform", "<bean:message key="portalempaquetado.avanzado.recursos.crear.archivo.principal.aceptar"/>");'><bean:message key="portalempaquetado.avanzado.recursos.crear.archivo.principal.aceptar"/></a>
 </div></div></div></div></div>
</div>

<div class="packer_cancel">
 <div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright"><div class="db_bubble_content">
 <a href='javascript:doSubmit("mainform", "<bean:message key="portalempaquetado.avanzado.recursos.crear.archivo.principal.cancelar"/>");'><bean:message key="portalempaquetado.avanzado.recursos.crear.archivo.principal.cancelar"/></a>
 </div></div></div></div></div>
</div>
</fieldset>
<!-- Fin Botones  -->

<!-- Fin Botones  -->
</form>
<script type="text/javascript">
  document.forms[0].principal[0].focus();
</script>
</div>
<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->


</div>
<!--  FIN CAPA MADRE   -->
</emp:layout>
