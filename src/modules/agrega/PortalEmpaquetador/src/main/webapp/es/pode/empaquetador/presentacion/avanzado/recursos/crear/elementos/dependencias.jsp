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

<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>
<script language="javascript">
function doSubmit(formname, sAction) {
        document.forms[formname].action.value = sAction;
        document.forms[formname].submit();
}
</script>




<h2><bean:message key="portalempaquetado.avanzado.recursos.crear.dependencias.titulo"/></h2>


<form name="mainform" method="post" 
	  id="crearRecursoAvanzadoElementosDependenciasCrearForm"
	  action="<html:rewrite action="/CrearRecursoAvanzadoElementos/DependenciasCrear" />" >
<input type=hidden name=action value="">
	  
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

		<table border="1" class="generica_02" cellpadding="0" cellspacing="0" width="100%" summary="Tabla de Dependencias (recursos)">
		<caption><strong><bean:message key="portalempaquetado.avanzado.recursos.crear.elementos.tablaDependencias"/></strong></caption>

<c:set var="contador" value="true"/>
<logic:notEmpty name="form" property= "recursos">
<logic:iterate name="form" property="recursos" id="recurso">
<logic:equal name="contador" value="true">
		<tr class="tr_gris">
</logic:equal>
<logic:equal name="contador" value="false">
		<tr class="tr_blanco">
</logic:equal>
<c:set var="contador" value="${!contador}"/>
			<td valign="top"  class="sin_b">
			<label for="Recurso01" class="oculto" >Seleccione </label>
	<logic:notEmpty name="form" property="dependencias">
	
	<c:set var="checked" value="false"/>
	<logic:iterate id="dependencia" name="form" property="dependencias" >
		<logic:equal name="dependencia" property="identifier" value="${recurso.identifier}" >
			<c:set var="checked" value="true"/>
		</logic:equal>
	</logic:iterate>
		<logic:equal name="checked" value="true" >
			<input type="checkbox" name="identifierRowSelectionAsArray" checked="checked" value="${recurso.identifier }"/></td>
		</logic:equal>
		<logic:equal name="checked" value="false" >
			<input type="checkbox" name="identifierRowSelectionAsArray" value="${recurso.identifier }"/></td>
		</logic:equal>
		
	</logic:notEmpty>
	<logic:empty name="form" property="dependencias">
		<input type="checkbox" name="identifierRowSelectionAsArray" value="${recurso.identifier }"/></td>
	</logic:empty>
		<td valign="top" class="td_larga">	
			<logic:notEmpty name="recurso" property="href">
					<bean:define id="urlConHost"><rewrite:rewrite url="${empaquetadorSesion.ode.localizadorURL}/${recurso.href}"/></bean:define>
					<a href="<emp:encodeURL url="${urlConHost }"/>" target="_blank" class="recurso">${recurso.href}</a>
			</logic:notEmpty>
			<logic:empty name="recurso" property="href">
					<a href="#" class="recurso">${recurso.identifier}</a>
			</logic:empty>
		</td>
		</tr>
</logic:iterate>
</logic:notEmpty>
<logic:empty name="form" property= "recursos">
<td><bean:message key="portalempaquetado.avanzado.recursos.gestor.noHayDependencias"/></td>
		</logic:empty>
		 </table>

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
 <a href='javascript:doSubmit("mainform", "<bean:message key="portalempaquetado.avanzado.recursos.crear.dependencias.aceptar"/>");'><bean:message key="portalempaquetado.avanzado.recursos.crear.dependencias.aceptar"/></a>
 </div></div></div></div></div>
</div>

<div class="packer_cancel">
 <div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright"><div class="db_bubble_content">
 <a href='javascript:doSubmit("mainform", "<bean:message key="portalempaquetado.avanzado.recursos.crear.dependencias.cancelar"/>");'><bean:message key="portalempaquetado.avanzado.recursos.crear.dependencias.cancelar"/></a>
 </div></div></div></div></div>
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
