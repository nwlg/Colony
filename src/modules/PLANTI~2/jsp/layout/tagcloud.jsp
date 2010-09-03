<%@ include file="/taglib-imports.jspf"%>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>

<!-- NUBE TAGS -->
<div class="tag_bubble">

<!-- Start of bubble -->
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">

<logic:notEqual name="NUBE_TAGS" value="nopresentar">
	<div class="tags">
		<h3><bean:message key="menu.lateral.generico.etiquetas" /></h3>
		<ul>
			<tiles:importAttribute name="NUBE_TAGS" scope="page"/>
			<logic:iterate name="NUBE_TAGS" id="palabrasClave">
				<li><a title="<bean:write name="palabrasClave" property="palabraClave"/> <bean:write name="palabrasClave" property="ranking"/>" href="<rewrite:rewrite url="buscador/ListarODECU/ListarODECU.do"/>?keyword=<bean:write name="palabrasClave" property="palabraClave"/>&tipoBusqueda=03&subjectSearchFilter=&keystageSearchFilter=&learningTimeSearchFilter=&intendedEndUserRoleSearchFilter=" class="t<bean:write name="palabrasClave" property="tamanio"/>"><bean:write name="palabrasClave" property="palabraClave"/></a></li>
			</logic:iterate>
		</ul>
	</div>
</logic:notEqual>

</div></div></div></div>

</div>
<!-- End of bubble -->

<!-- FIN NUBE TAGS -->
</div>
