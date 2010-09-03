<%@ include file="/taglib-imports.jspf"%>
<tiles:importAttribute name="MENU_PERFIL" scope="page"/>
<logic:iterate name="MENU_PERFIL" id="menuItem">
	<li>
			<a href="<bean:write name="menuItem" property="link"/>" title="<bean:write name="menuItem" property="i18nKey"/>" id="<bean:write name="menuItem" property="id"/>" <logic:equal name="menuItem" property="link" value="#">onClick="alert('Opción no disponible en esta versión');"</logic:equal> <logic:notEqual name="menuItem" property="target" value="">target="<bean:write name="menuItem" property="target"/>"</logic:notEqual>><bean:write name="menuItem" property="i18nKey"/></a>
	</li>
</logic:iterate>