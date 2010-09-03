<%@ include file="/taglib-imports.jspf"%>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>

<br class="oculto" />
<a href="<rewrite:rewrite url="${initParam.url_portada}"/>" title="<bean:message key="buscador.pagina.inicio"/>"
	id="logo"><span><bean:message key="buscador.pagina.inicio" /></span></a>
<br class="oculto" />