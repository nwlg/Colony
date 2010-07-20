<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tlds/tags-empaquetador.tld" prefix="emp" %>
<bean:define id="urlArchivos"><html:rewrite action="/GestorArchivos/GestorArchivos"/></bean:define>
<bean:define id="urlRecursos"><html:rewrite action="/GestorRecursos/GestorRecursos"/></bean:define>
<bean:define id="urlOrganizaciones"><html:rewrite action="/GestorOrganizaciones/GestorOrganizaciones"/></bean:define>
<bean:define id="urlSubmanifiestos"><html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestos"/></bean:define>
<bean:define id="urlGuardar"><html:rewrite action="/GestorOrganizaciones/GestorOrganizaciones"/></bean:define>
<bean:define id="selected" value="organizaciones"/>
<emp:layout selected="${selected}" urlArchivos="${urlArchivos}" urlRecursos="${urlRecursos}" urlSubmanifiestos="${urlSubmanifiestos}" urlOrganizaciones="${urlOrganizaciones}" urlGuardar="${urlGuardar}" titleKey="title.Comun">
<bean:define id="empaquetadorSesion" name="<%=es.pode.empaquetador.presentacion.EmpaquetadorSession.SESSION_KEY%>" scope="session"/>
<div class="plantilla_contenido" id="ventana_flotante">
<%@ include file="/layout/messages.jsp" %>
<h2><bean:message key="portal_empaquetado_organizacionDefecto"/></h2>

<form id="organizacionPrincipalOrganizacionesAceptarForm" method="post" action="<html:rewrite action="/OrganizacionPrincipal/OrganizacionesAceptar"/>" enctype="multipart/form-data">
<p class="parrafo_comun" id="separacion2"><bean:message key="portal_empaquetado_seleccionarOrganizacionDefecto"/>:</p>
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

<table border="1" class="generica_02" cellpadding="0" cellspacing="0" width="100%" summary="Tabla de Organizaci�n">
<caption><strong><bean:message key="portal_empaquetado_gestorOrganizaciones.tablaDeOrganizaciones"/></strong></caption>


 <c:set var="contador" value="true"/>
 <c:set var="contflechas" value="0"/>
			
 <logic:iterate id="organizacion" name="form" property="organizaciones">
	<logic:equal name="contador" value="true">
		<tr class="tr_gris">
	</logic:equal>

	<logic:equal name="contador" value="false">
		<tr class="tr_blanco">
	</logic:equal>
	<c:set var="contador" value="${!contador}"/>

	<td valign="top"  class="sin_b">
	<label for="Org01" class="oculto" >Seleccione </label>
	<html:radio property="identifier" styleId="Org01" name="form" value="${organizacion.identifier}" /></td>
	<td valign="top" class="td_larga"><a href="#" class="organiz">${fn:escapeXml(organizacion.title)}</a></td>
</logic:iterate>

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
<input class="boton_125_de_2"  type="submit"  name="action"  value="<bean:message key='portal_empaquetado_gestorOrganizaciones.principalAceptar'/>"  />
<input class="boton_125_de_2_izq"  type="submit"  name="action"  value="<bean:message key='portal_empaquetado_gestorOrganizaciones.principalCancelar'/>" />
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>
<script type="text/javascript">
  document.forms[0].identifier[0].focus();
</script>
</div>
</emp:layout>