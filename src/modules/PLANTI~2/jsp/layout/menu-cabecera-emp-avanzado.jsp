<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!-- Inicio MENU PRINCIPAL -->
<!-- Inicio MENU PRINCIPAL -->
<div id="madre_menu_horizontal">
<div id="cabecera_menu">
<div id="menu_principal0">
<div id="menu_principal">
<div id="menu_principal2">
<tiles:importAttribute/>
<tiles:useAttribute id="selected" name="selected"/>
<tiles:useAttribute id="urlArchivos" name="urlArchivos"/>
<tiles:useAttribute id="urlRecursos" name="urlRecursos"/>
<tiles:useAttribute id="urlOrganizaciones" name="urlOrganizaciones"/>
<tiles:useAttribute id="urlSubmanifiestos" name="urlSubmanifiestos"/>

<ul>
<logic:equal name="selected" value="archivos">
	<li id="archivos"><div><span><span><bean:message key="emp.avanzado.menu.archivos"/></span></span></div></li>
</logic:equal>
<logic:notEqual name="selected" value="archivos">
	<li id="archivos"><a href="<tiles:getAsString name="urlArchivos"/>"><span><span><bean:message key="emp.avanzado.menu.archivos"/></span></span></a></li>
</logic:notEqual>
<logic:equal name="selected" value="recursos">
	<li id="recursos"><div><span><span><bean:message key="emp.avanzado.menu.recursos"/></span></span></div></li>
</logic:equal>
<logic:notEqual name="selected" value="recursos">
	<li id="recursos"><a href="<tiles:getAsString name="urlRecursos"/>"><span><span><bean:message key="emp.avanzado.menu.recursos"/></span></span></a></li>
</logic:notEqual>
<logic:equal name="selected" value="organizaciones">
	<li id="organizaciones"><div><span><span><bean:message key="emp.avanzado.menu.organizaciones"/></span></span></div></li>
</logic:equal>
<logic:notEqual name="selected" value="organizaciones">
	<li id="organizaciones"><a href="<tiles:getAsString name="urlOrganizaciones"/>"><span><span><bean:message key="emp.avanzado.menu.organizaciones"/></span></span></a></li>
</logic:notEqual>
<logic:equal name="selected" value="submanifiestos">
	<li id="submanifiestos"><div><span><span><bean:message key="emp.avanzado.menu.submanifiestos"/></span></span></div></li>
</logic:equal>
<logic:notEqual name="selected" value="submanifiestos">
	<li id="submanifiestos"><a href="<tiles:getAsString name="urlSubmanifiestos"/>"><span><span><bean:message key="emp.avanzado.menu.submanifiestos"/></span></span></a></li>
</logic:notEqual>
</ul>
</div>
</div>
</div>
</div>
</div>
<!-- Fin MENU PRINCIPAL -->
<!-- Fin MENU PRINCIPAL -->
