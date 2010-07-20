<%@ include file="/taglib-imports.jspf" %>
<%@ taglib uri="/WEB-INF/tags/link.tld" prefix="link" %>
<div id="metanavegacion">
<bean:define id="cerrar"><bean:message key="avanzado.Cerrar"/></bean:define>
<ol>
		<li class="oculto"><a href="#contenido_central" title="Contenido Principal"><strong>Contenido</strong></a></li>
		<li><html:link href="#" title="${cerrar}" styleId="li_inicial" onclick="window.close()"><bean:message key="avanzado.Cerrar"/></html:link></li>
		<li>
		<link:link attrProperty="HELP_URL" title="${ayuda }" id="li_inicial" target="blank" i18nMessage="catalogadorAvanzado.Ayuda"></link:link>
		</li>
		<li><a href="<html:rewrite action="/ExportarLomes/ExportarLomes?regreso=VerMetadatos"/>" title="<bean:message key="avanzado.Exportar"/>"  id="contacto" ><bean:message key="avanzado.Exportar" /></a></li>
	</ol>
</div>



