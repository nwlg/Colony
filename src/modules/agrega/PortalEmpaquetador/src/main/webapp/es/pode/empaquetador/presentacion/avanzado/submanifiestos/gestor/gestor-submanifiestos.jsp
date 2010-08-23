<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="arb" %>
<tiles:insert definition="layout-empaquetador-avanzado">

 <tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
 </tiles:put>

<tiles:put name="selected" type="string" value="submanifiestos"/>
<tiles:put name="urlArchivos" type="string">
      <html:rewrite action="/GestorArchivos/GestorArchivos"/>
</tiles:put>
<tiles:put name="urlRecursos" type="string">
      <html:rewrite action="/GestorRecursos/GestorRecursos"/>
</tiles:put>
<tiles:put name="urlGuardar" type="string"><html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestos"/>
</tiles:put>
<tiles:put name="urlOrganizaciones" type="string">
      <html:rewrite action="/GestorOrganizaciones/GestorOrganizaciones"/>
</tiles:put>
<tiles:put name="urlSubmanifiestos" type="string">
      <html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestos"/>
</tiles:put>
    <tiles:put name="body" type="string">
<bean:define id="empaquetadorSesion" name="<%=es.pode.empaquetador.presentacion.EmpaquetadorSession.SESSION_KEY%>" scope="session"/>

    

 <div class="plantilla_contenido">

<%@ include file="/layout/messages.jsp" %>

<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- ATENCION!! E3TA ES LA CAPA QUE DEBE REEMPLAZARSE POR LA DEL MISMO NOMBRE (plantilla contenido pestanias ) EN LA PLANTILLA DE  CONTENIDO  CON EL CONTENIDO DE FICHA -->
<div class="plantilla_contenido_pestanias">



<form id="gestorSubmanifiestosGestorSubmanifiestosSubmitForm" method="post" action="<html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestosSubmit"/>" enctype="multipart/form-data">
<h2 ><bean:message key="portal_empaquetado_gestorSubmanifiestos.Sub-manifiestos"/></h2>
<!-- CAJA TABLA -->
<!-- CAJA TABLA -->
<div class="caja_tabla" >

<table border="1" class="administracion_tareas" cellpadding="0" cellspacing="0" width="100%" summary="Tabla de Sub-Manifiestos">
<caption><strong><bean:message key="portal_empaquetado_gestorSubmanifiestos.tablaDeSubmanifiestos"/></strong></caption>


 <c:set var="contador" value="true"/>
<logic:notEmpty name="form" property="submanifiestos">
 <logic:iterate id="submanifiesto" name="form" property="submanifiestos">
	<logic:equal name="contador" value="true">
		<tr class="tr_gris">
	</logic:equal>

	<logic:equal name="contador" value="false">
		<tr class="tr_blanco">
	</logic:equal>
	<c:set var="contador" value="${!contador}"/>

	<td valign="top" class="sin_b" >
		<label for="Submani01" class="etiq_invisible" >Seleccione </label>
		<input type="checkbox" name="identifierRowSelectionAsArray" id="Submani01"  value="${submanifiesto.identifier}" />
	</td>
    <logic:empty name="submanifiesto" property="lom">
    <td valign="top"  class="tar7" >
    	<a href="<html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestosNavegar"/>?identifier=${submanifiesto.identifier}" class="sub"> ${submanifiesto.identifier} </a>
    </td>
    <td valign="top" class="meta_datos_mas" >
    </logic:empty>
    <logic:notEmpty name="submanifiesto" property="lom">
    <td valign="top"  class="tar7" >
    	<a href="<html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestosNavegar"/>?identifier=${submanifiesto.identifier}" class="sub">${fn:escapeXml(submanifiesto.lom.titulo)}</a>
    </td>
    <td valign="top" class="meta_datos">
    </logic:notEmpty>
    <span class="oculto">--</span>
		<a href="<html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestosMetadato"/>?identifier=${submanifiesto.identifier}&amp;returnURL=<html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestos"/>" ><bean:message key="portalempaquetado.avanzado.recursos.crear.paso2.archivos.metadatos"/></a>
 	</td>
 	</tr>
	</logic:iterate>
	</logic:notEmpty>
	<logic:empty name="form" property="submanifiestos">
	<td><bean:message key="portalempaquetado.avanzado.submanifiestos.noHaySubmanifiestos"/></td>
		</logic:empty>

</table>
</div>
<!-- FIN CAJA TABLA -->
<!-- FIN CAJA TABLA -->

<!-- Inicio Botones  -->
<!-- Inicio Botones  -->

<fieldset class="tipo_interior_03">
<input class="boton_125_de_2"   type="submit"  name="action"  value="<bean:message key='portal_empaquetado_gestorSubmanifiestos.eliminar'/>" />
<br class="oculto" /><br class="oculto" />
<input class="boton_125_de_2_izq bot_mar_der"   type="submit"  name="action"  value="<bean:message key='portal_empaquetado_gestorSubmanifiestos.agregar'/>" />
<input class="boton_125_de_2_izq bot_mar_der"   type="submit"  name="action"  value="<bean:message key='portal_empaquetado_gestorSubmanifiestos.desAgregar'/>" />
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->

<!--  FIN CAJA DE FORMULARIO   -->
</form>
</div>
<!-- HASTA AQUI EL REEEMPLAZO -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->





</div>
    </tiles:put>

</tiles:insert>
