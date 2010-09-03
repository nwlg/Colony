<%@ include file="/taglib-imports.jspf"%>
<!-- INICIO LATERAL IZQUIERDO  -->
<div id="lateral">
<!-- INICIO NAVEGACIÓN VERTICAL -->
<!-- INICIO NAVEGACIÓN VERTICAL -->
<div id="menu_vertical" style="float: left">

<br class="oculto" />
<strong class="oculto"><bean:message key="menu.lateral.generico.menuVertical" />:</strong><br class="oculto" /><br class="oculto" />
<div class="lb_bubble_topleft"> <div class="lb_bubble_bottomleft"> <div class="lb_bubble_topright"> <div class="lb_bubble_bottomright"> <div class="lb_bubble_content">
<b><bean:message key="menu.lateral.administrador.contenidos" /></b>
<br class="oculto" />
<ul class="lista_admin">
<tiles:importAttribute name="MENU_LATERAL_CONTENIDOS" scope="page"/>
<tiles:importAttribute name="MENU_LATERAL_PLATAFORMA" scope="page"/>
<tiles:importAttribute name="MENU_LATERAL_CONFIGURACION" scope="page"/>

<logic:iterate name="MENU_LATERAL_CONTENIDOS" id="menuItem">
	<li>
		<logic:equal name="menuItem" property="selected" value="false">
			<a href="<bean:write name="menuItem" property="link"/>" <logic:equal name="menuItem" property="link" value="#">onclick="alert('Opción no disponible en esta versión');"</logic:equal> <logic:notEqual name="menuItem" property="target" value="">target="<bean:write name="menuItem" property="target"/>"</logic:notEqual>>
		</logic:equal>
		<logic:equal name="menuItem" property="selected" value="true">
			<div>
		</logic:equal>
			<span><bean:write name="menuItem" property="i18nKey"/></span>
		<logic:equal name="menuItem" property="selected" value="false">
			</a>
		</logic:equal>
		<logic:equal name="menuItem" property="selected" value="true">
			</div>
		</logic:equal>
	</li>
</logic:iterate>
</ul>
</div></div></div></div></div>
<br />

<div class="lb_bubble_topleft"> <div class="lb_bubble_bottomleft"> <div class="lb_bubble_topright"> <div class="lb_bubble_bottomright"> <div class="lb_bubble_content">
<b><bean:message key="menu.lateral.administrador.plataforma" /></b>
<br class="oculto" />
<ul class="lista_admin">
<logic:iterate name="MENU_LATERAL_PLATAFORMA" id="menuItem">
	<li>
		<logic:equal name="menuItem" property="selected" value="false">
			<a href="<bean:write name="menuItem" property="link"/>" <logic:equal name="menuItem" property="link" value="#">onclick="alert('Opción no disponible en esta versión');"</logic:equal> <logic:notEqual name="menuItem" property="target" value="">target="<bean:write name="menuItem" property="target"/>"</logic:notEqual>>
		</logic:equal>
		<logic:equal name="menuItem" property="selected" value="true">
			<div>
		</logic:equal>
			<span><bean:write name="menuItem" property="i18nKey"/></span>
		<logic:equal name="menuItem" property="selected" value="false">
			</a>
		</logic:equal>
		<logic:equal name="menuItem" property="selected" value="true">
			</div>
		</logic:equal>
	</li>
</logic:iterate>
</ul>
</div></div></div></div></div>
<br />
<div class="lb_bubble_topleft"> <div class="lb_bubble_bottomleft"> <div class="lb_bubble_topright"> <div class="lb_bubble_bottomright"> <div class="lb_bubble_content">
<b><bean:message key="menu.lateral.administrador.configuracion" /></b>
<br class="oculto" />
<ul>
<logic:iterate name="MENU_LATERAL_CONFIGURACION" id="menuItem">
	<li>
		<logic:equal name="menuItem" property="selected" value="false">
			<a href="<bean:write name="menuItem" property="link"/>" <logic:equal name="menuItem" property="link" value="#">onclick="alert('Opción no disponible en esta versión');"</logic:equal> <logic:notEqual name="menuItem" property="target" value="">target="<bean:write name="menuItem" property="target"/>"</logic:notEqual>>
		</logic:equal>
		<logic:equal name="menuItem" property="selected" value="true">
			<div>
		</logic:equal>
			<span><bean:write name="menuItem" property="i18nKey"/></span>
		<logic:equal name="menuItem" property="selected" value="false">
			</a>
		</logic:equal>
		<logic:equal name="menuItem" property="selected" value="true">
			</div>
		</logic:equal>
	</li>
</logic:iterate>
</ul>
</div></div></div></div></div>
</div>
<!-- FIN NAVEGACIÓN VERTICAL -->
<!-- FIN NAVEGACIÓN VERTICAL -->
<hr />
</div>
<!-- FIN LATERAL IZQUIERDO -->
<!-- FIN LATERAL IZQUIERDO -->