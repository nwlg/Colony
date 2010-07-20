<%@ include file="/taglib-imports.jspf"%>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<!-- INICIO LATERAL IZQUIERDO  -->
<!-- <div id="lateral" > -->

<!-- INICIO NAVEGACIÓN VERTICAL NUEVO -->
<!-- INICIO NAVEGACIÓN VERTICAL -->
<div id="menu_vertical" style="float:left;" >

<br class="oculto" />
<strong class="oculto"><bean:message key="menu.lateral.generico.menuVertical" /></strong>

<!-- Spacer for menu heading -->
<div class="heading_text"></div>

<!-- Navigation menu bubble -->
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">

<ul>
<tiles:importAttribute name="MENU_LATERAL" scope="page"/>
<logic:iterate name="MENU_LATERAL" id="menuItem">
	<li>
		<logic:equal name="menuItem" property="selected" value="false">
			<a href="<bean:write name="menuItem" property="link"/>" <logic:notEqual name="menuItem" property="target" value="">target="<bean:write name="menuItem" property="target"/>"</logic:notEqual>>
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

	</div></div></div></div>
</div>
<!-- End of navigation menu bubble -->

</div>
<!-- FIN NAVEGACIÓN VERTICAL -->
<!-- FIN NAVEGACIÓN VERTICAL -->

<!--
<ul class="destacados">
<li><a href="<rewrite:rewrite url="${initParam.url_feeds}"/>" class="des_01" title="<bean:message key="menu.lateral.generico.rssFeeds" />"><span><bean:message key="menu.lateral.generico.rssFeeds" /></span></a></li>
</ul>
-->



<!-- <hr/> -->
<!-- </div> -->
<!-- FIN LATERAL IZQUIERDO -->
<!-- FIN LATERAL IZQUIERDO -->
