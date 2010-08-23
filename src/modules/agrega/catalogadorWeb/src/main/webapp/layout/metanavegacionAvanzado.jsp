<%@ include file="/taglib-imports.jspf" %>
<%@ taglib uri="/WEB-INF/tags/link.tld" prefix="link" %>
<div id="metanavegacion">
<ol>
		<li class="oculto"><a href="#contenido_central" title="Contenido Principal"><strong>Contenido</strong></a></li>
		<bean:define id="ayuda"><bean:message key="catalogadorAvanzado.Ayuda"/></bean:define>
		<li>
			<link:link attrProperty="HELP_URL" title="${ayuda }" id="li_inicial" target="blank" i18nMessage="catalogadorAvanzado.Ayuda"></link:link>
		</li>
	</ol>
</div>
