<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ attribute name="titleKey" required="true" %>
<%@ attribute name="selected" required="false" %>
<%@ attribute name="urlArchivos" required="false" %>
<%@ attribute name="urlRecursos" required="false" %>
<%@ attribute name="urlOrganizaciones" required="false" %>
<%@ attribute name="urlSubmanifiestos" required="false" %>
<%@ attribute name="urlEstructura" required="false" %>
<%@ attribute name="urlGuardar" required="false" %>
<bean:define id="tipoEmpaquetador" value="${empaquetadorSession.tipoEmpaquetador}"/>
<logic:equal name="tipoEmpaquetador" value="Avanzado">
<tiles:insert definition="layout-empaquetador-avanzado">
<tiles:put name="title" type="string"><bean:message key="${titleKey}"/></tiles:put>
<tiles:put name="selected" type="string" value="${selected}"/>
<tiles:put name="urlArchivos" type="string">${urlArchivos}</tiles:put>
<tiles:put name="urlRecursos" type="string">${urlRecursos}</tiles:put>
<tiles:put name="urlOrganizaciones" type="string">${urlOrganizaciones}</tiles:put>
<tiles:put name="urlSubmanifiestos" type="string">${urlSubmanifiestos}</tiles:put>
<tiles:put name="urlGuardar" type="string">${urlGuardar}</tiles:put>
<tiles:put name="body" type="string">
<jsp:doBody/>
</tiles:put>
</tiles:insert>
</logic:equal>
<logic:notEqual name="tipoEmpaquetador" value="Avanzado">
<tiles:insert definition="layout-empaquetador-basico">
<tiles:put name="title" type="string"><bean:message key="${titleKey}"/></tiles:put>
<tiles:put name="urlArchivos" type="string">${urlArchivos}</tiles:put>
<tiles:put name="urlEstructura" type="string">${urlEstructura}</tiles:put>
<tiles:put name="urlGuardar" type="string">${urlGuardar}</tiles:put>
<tiles:put name="selected" type="string" value="${selected}"/>
<tiles:put name="body" type="string">
<jsp:doBody/>
</tiles:put>
</tiles:insert>
</logic:notEqual>
