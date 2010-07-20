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
<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>
<form id="gestorOrganizacionesGestorOrganizacionesSubmitForm" method="post" action="<html:rewrite action="/GestorOrganizaciones/GestorOrganizacionesSubmit"/>" enctype="multipart/form-data">
<h2><bean:message key="presentacion.avanzado.organizaciones.gestor.organizaciones"/></h2>
<!-- CAJA TABLA -->

<!-- CAJA TABLA -->
<div class="caja_tabla" >

<table border="1" class="generica_02" cellpadding="0" cellspacing="0" width="100%" summary="Tabla de Organizaciones">
<caption><strong><bean:message key="presentacion.avanzado.organizaciones.gestor.tablaDeOrganizaciones"/></strong></caption>
 

 <c:set var="contador" value="true"/>
 <c:set var="contflechas" value="0"/>
 <bean:size id="longitud" name="form" property="organizaciones"/>	
<logic:notEmpty name="form" property="organizaciones">
 <logic:iterate id="organizacion" name="form" property="organizaciones">
	<logic:equal name="contador" value="true">
		<tr class="tr_gris">
	</logic:equal>

	<logic:equal name="contador" value="false">
		<tr class="tr_blanco">
	</logic:equal>
	<c:set var="contador" value="${!contador}"/>

	<td valign="top" class="sin_b" >
		<label for="Org01" class="etiq_invisible" >Seleccione </label>
		<input type="checkbox" name="identifierRowSelectionAsArray" id="Org01" value="${organizacion.identifier}" />
	</td>
    <td valign="top"  class="tar3" >
    	<a href="../GestorOrganizaciones/GestorOrganizacionesEditar.do?identifier=${organizacion.identifier}" class="organiz">${fn:escapeXml(organizacion.title)}</a>
    </td>
    <logic:empty name="organizacion" property="lom">
    <td valign="top" class="meta_datos_mas">
    	<span class="oculto">-</span><a href="<html:rewrite action="/GestorOrganizaciones/GestorOrganizacionesMetadatos"/>?identifier=${organizacion.identifier }&amp;returnURL=<html:rewrite action="/GestorOrganizaciones/GestorOrganizaciones"/>"><bean:message key="presentacion.avanzado.organizaciones.gestor.metadatos"/></a>
    </td>
    </logic:empty>
    <logic:notEmpty name="organizacion" property="lom">
    <td valign="top" class="meta_datos">
    	<span class="oculto">-</span><a href="<html:rewrite action="/GestorOrganizaciones/GestorOrganizacionesMetadatos"/>?identifier=${organizacion.identifier }&amp;returnURL=<html:rewrite action="/GestorOrganizaciones/GestorOrganizaciones"/>"><bean:message key="presentacion.avanzado.organizaciones.gestor.metadatos"/></a>
    </td>
    </logic:notEmpty>
	<td valign="top" class="ejec">
		<span class="oculto">-</span><a href="<html:rewrite action="/GestorOrganizaciones/GestorOrganizacionesModificar"/>?identifier=${organizacion.identifier}"><bean:message key="presentacion.avanzado.organizaciones.gestor.modificar"/></a>
	</td>
	<logic:equal name="contflechas" value="0">
	  	<td valign="top" class="td_corta" align="center"><span class="oculto">-</span><a href="<html:rewrite action="/GestorOrganizaciones/GestorOrganizacionesBajar"/>?identifier=${organizacion.identifier}" class="icono_bajar" title="Bajar"><strong><bean:message key="presentacion.avanzado.organizaciones.gestor.bajar"/></a></td>
  	</logic:equal>
  
  	<logic:notEqual name="contflechas" value="0">
    	<logic:notEqual name="contflechas" value="${longitud-1}">
    		<td valign="top" class="td_corta" align="center"><span class="oculto">-</span><a href="<html:rewrite action="/GestorOrganizaciones/GestorOrganizacionesSubir"/>?identifier=${organizacion.identifier}" class="icono_subir_02" title="Subir"><strong><bean:message key="portal_empaquetado_gestorOrganizaciones.subir"/></strong></a><span class="oculto">&nbsp;y&nbsp;</span><a href="../GestorOrganizaciones/GestorOrganizacionesBajar.do?identifier=${organizacion.identifier}" class="icono_bajar_02" title="Bajar"><strong><bean:message key="presentacion.avanzado.organizaciones.gestor.bajar"/></strong></a></td>
    	</logic:notEqual>
  	</logic:notEqual>
  
  	<logic:equal name="contflechas" value="${longitud-1}">
  		<logic:notEqual name="contflechas" value="0">
  		<td valign="top" class="td_corta" align="center"><span class="oculto">-</span><a href="<html:rewrite action="/GestorOrganizaciones/GestorOrganizacionesSubir"/>?identifier=${organizacion.identifier}" class="icono_subir" title="Subir"><strong><bean:message key="presentacion.avanzado.organizaciones.gestor.bajar"/></strong></a></td>
  		</logic:notEqual>
  	</logic:equal>
	</tr>
 	<c:set var="contflechas" value="${contflechas+1}"/>

	</logic:iterate>
	</logic:notEmpty>
	<logic:empty name="form" property="organizaciones">
	<td><bean:message key="presentacion.avanzado.organizaciones.gestor.noHayOrganizaciones"/></td>
		</logic:empty>

</table>
</div>

<!-- FIN CAJA TABLA -->
<!-- FIN CAJA TABLA -->

<!-- Inicio Botones  -->
<!-- Inicio Botones  -->

<fieldset class="tipo ft_centrada">
<input class="boton_150_de_2_izq" type="submit"  name="action"  value="<bean:message key='presentacion.avanzado.organizaciones.gestor.crearOrganizacion'/>" />
<input class="boton_150_de_2"  type="submit"  name="action" value="<bean:message key='presentacion.avanzado.organizaciones.gestor.eliminar'/>" />
<input class="boton_150"  type="submit"  name="action"  value="<bean:message key='presentacion.avanzado.organizaciones.gestor.orgDefecto'/>"/>
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->

			<!--  FIN CAJA DE FORMULARIO   -->

</form>
</div>
</emp:layout>