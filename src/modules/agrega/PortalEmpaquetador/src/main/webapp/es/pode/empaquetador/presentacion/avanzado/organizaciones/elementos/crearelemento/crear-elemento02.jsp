<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tlds/tags-empaquetador.tld" prefix="emp" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<bean:define id="urlArchivos"><html:rewrite action="/GestorArchivos/GestorArchivos"/></bean:define>
<bean:define id="urlRecursos"><html:rewrite action="/GestorRecursos/GestorRecursos"/></bean:define>
<bean:define id="urlOrganizaciones"><html:rewrite action="/GestorOrganizaciones/GestorOrganizaciones"/></bean:define>
<bean:define id="urlSubmanifiestos"><html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestos"/></bean:define>
<bean:define id="urlGuardar"><html:rewrite action="/GestorElementos/GestorElementos"/></bean:define>
<bean:define id="selected" value="organizaciones"/>
<emp:layout selected="${selected}" urlArchivos="${urlArchivos}" urlRecursos="${urlRecursos}" urlSubmanifiestos="${urlSubmanifiestos}" urlOrganizaciones="${urlOrganizaciones}" urlGuardar="${urlGuardar}" titleKey="title.Comun">
 <div class="plantilla_contenido" id="ventana_flotante">
<%@ include file="/layout/messages.jsp" %>
<bean:define id="crear"><bean:message key="portal_empaquetado_crearElemento.paso1.crear"/></bean:define>
<bean:define id="modificar"><bean:message key="portal_empaquetado_crearElemento.paso1.modificar"/></bean:define>
<h2><bean:message key="portal_empaquetado_crearElemento.paso1" arg0="${crearElementoSession.esModificar ? modificar : crear}"/></h2>

<form id="crearElementoCrearElemento02AceptarForm" method="post" action="<html:rewrite action="/CrearElemento/CrearElemento02Aceptar"/>" enctype="multipart/form-data">
<logic:equal name="form" property="referenciado" value="Recurso">
<p class="parrafo_comun" id="separacion2"><bean:message key="portal_empaquetado_crearElemento.paso2.seleccionarRecurso"/>:</p>
</logic:equal>
<logic:equal name="form" property="referenciado" value="Submanifiesto">
<p class="parrafo_comun" id="separacion2"><bean:message key="portal_empaquetado_crearElemento.paso2.seleccionarSubmanifiesto"/>:</p>
</logic:equal>
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >
	
	<!--  INICIO CAPA TABLA   -->					
 <div class="caja_tabla bordeada" >

<table border="1" class="generica_02" cellpadding="0" cellspacing="0" width="100%" summary="Tabla de Recursos">
<caption><strong><bean:message key="portal_empaquetado_crearElemento.paso2.tablaRecursos"/></strong></caption>
<logic:notEmpty name="form" property="elementos">
<logic:iterate id="elemento" name="form" property="elementos">
	<logic:equal name="contador" value="true">
		<tr class="tr_gris">
	</logic:equal>

	<logic:equal name="contador" value="false">
		<tr class="tr_blanco">
	</logic:equal>
	<c:set var="contador" value="${!contador}"/>

	<td valign="top"  class="sin_b">
	<label for="${elemento.identifier}" class="oculto" >Seleccione </label>
	<html:radio property="identifier" styleId="${elemento.identifier}" name="form" value="${elemento.identifier}" /></td>
	
	<logic:equal name="form" property="referenciado" value="Recurso">
		<bean:define id="urlConHost"><rewrite:rewrite url="${elemento.recursoURL }"/></bean:define>
		<td valign="top" class="td_larga"><a href="<emp:encodeURL url="${urlConHost }"/>" target="_blank" class="recurso">${elemento.href}</a></td>
	</logic:equal>
	
	<logic:equal name="form" property="referenciado" value="Submanifiesto">
	 
	  <logic:empty name="elemento" property="lom">
	    <td valign="top" class="td_larga"><a href="#" class="recurso">${elemento.identifier}</a></td>
	 </logic:empty>
	  
	  <logic:notEmpty name="elemento" property="lom">
	    <td valign="top" class="td_larga"><a href="#" class="recurso">${fn:escapeXml(elemento.lom.titulo)}</a></td>
	  </logic:notEmpty>
	  
	</logic:equal>
</tr>
</logic:iterate>
</logic:notEmpty>
<logic:empty name="form" property="elementos">
<logic:equal name="form" property="referenciado" value="Recurso">
<td><bean:message key="portal_empaquetado_crearElemento.paso2.tablaRecursos.noHayRecursos"/></td>
</logic:equal>
<logic:equal name="form" property="referenciado" value="Submanifiesto">
<td><bean:message key="portal_empaquetado_crearElemento.paso2.tablaSubmanifiestos.noHaySubmanifiestos"/></td>
</logic:equal>

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
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->

<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<fieldset class="tipo ft_centrada">
<input class="boton_125_de_2"  type="submit"  name="action"  value="<bean:message key='portal_empaquetado_crearElemento.aceptar2'/>" />
<input class="boton_125_de_2_izq"  type="submit"  name="action" value="<bean:message key='portal_empaquetado_crearElemento.cancelar2'/>" />
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>
</div>
</emp:layout>