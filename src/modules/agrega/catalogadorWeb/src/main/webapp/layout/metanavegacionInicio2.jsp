<%@ include file="/taglib-imports.jspf" %>
<%@ taglib uri="/WEB-INF/tags/link.tld" prefix="link" %>

<!-- INICIO METANAVEGACION   metanavegacionInicio2.jsp -->
<div id="metanavegacion">
<ol>
		<li class="oculto"><a href="#contenido_central" title="Contenido Principal"><strong>Contenido</strong></a></li>
		
		<li>
			<link:link attrProperty="HELP_URL" title="${ayuda }" id="li_inicial" target="blank" i18nMessage="catalogadorBasico.Ayuda"/>
		</li>
<!-- MCA: temporarily disable
		<li><a href="<html:rewrite action="/CatalogadorBasico/CatalogadorFormImportar"/>"  title="<bean:message key="avanzado.Importar" />"><bean:message key="avanzado.Importar" /></a></li>
-->
		<li><a href="<html:rewrite action="/CatalogadorBasicPlus/CatalogadorFormSubmit"/>" title="<bean:message key="catalogadorBasico.Exportar" />" id="contacto"><bean:message key="catalogadorBasico.Exportar" /></a></li>

	<script>
	<!--
		//document.write('<li><a href="#" onclick="document.forms[0].submit();return false;" id="contacto"><bean:message key="catalogadorBasico.Exportar" /></a></li>');
	//-->
	</script>
</ol>
</div>
<!-- FIN METANAVEGACION   -->
