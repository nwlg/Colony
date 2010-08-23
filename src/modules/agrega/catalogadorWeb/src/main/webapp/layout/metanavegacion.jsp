<%@ include file="/taglib-imports.jspf" %>
<%@ taglib uri="/WEB-INF/tags/link.tld" prefix="link" %>

<!-- INICIO METANAVEGACION   metanavegacion.jsp -->
<div id="metanavegacion">
<ol>
		<li class="oculto"><a href="#contenido_central" title="Contenido Principal"><strong>Contenido</strong></a></li>
		
		
		<li>
			<bean:define id="ayuda"><bean:message key="catalogadorBasico.Ayuda" /></bean:define>
			<link:link attrProperty="HELP_URL" title="${ayuda}" id="li_inicial" target="blank" i18nMessage="catalogadorBasico.Ayuda"/>
		</li>
</ol>
</div>
<!-- FIN METANAVEGACION   -->