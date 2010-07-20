<%@ include file="/taglib-imports.jspf"%>
<%@ taglib uri="/WEB-INF/tags/link.tld" prefix="link" %>

<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- INICIO CABECERA  -->
<div id="cabecera">



<!-- INICIO METANAVEGACION   --> <!-- INICIO METANAVEGACION   -->
<tiles:importAttribute/>
<tiles:useAttribute id="urlGuardar" name="urlGuardar"/>
<tiles:useAttribute id="parametrosCatalogar" name="parametrosCatalogar"/>
<logic:empty name="urlGuardar">
<bean:define id="urlGuardar" value="${urlGuardar }"/>
</logic:empty>
<logic:empty name="parametrosCatalogar">
<bean:define id="parametrosCatalogar">identifier=${empaquetadorSession.ode.identifier }&amp;returnURL=<html:rewrite action="/GestorOrganizaciones/GestorOrganizaciones"/></bean:define>
</logic:empty>
<div id="metanavegacion">
<bean:define id="titleAyuda"><bean:message key="cabecera.ayuda"/></bean:define>
<ol>
	<li class="oculto">
	<a href="#contenido_central" title="Contenido Principal"><strong><bean:message key="metanavegacion.contenido" /></strong></a></li>
	<li><a href="<html:rewrite action="/Salir/Salir"/>" title="<bean:message key="metanavegacion.cerrar" />" id="li_inicial"><bean:message key="metanavegacion.cerrar" /></a></li>
	<li><link:link attrProperty="HELP_URL" title="${titleAyuda}" id="ayuda" target="blank" i18nMessage="cabecera.ayuda"/></li>
	<li><a href="<html:rewrite action="/Catalogar/Catalogar"/>?${parametrosCatalogar }" title="<bean:message key="cabecera.catalogar" />"><bean:message key="cabecera.catalogar" /></a></li>
	<li><a href="<html:rewrite action="/Previsualizar/Previsualizar"/>" title="<bean:message key="cabecera.previsualizar" />" target="_blank"><bean:message key="cabecera.previsualizar" /></a></li>
	<li><a href="<html:rewrite action="/Validar/Validar"/>" title="<bean:message key="cabecera.validar" />"><bean:message key="cabecera.validar" /></a></li>
	<li><a href="<html:rewrite action="/Guardar/Guardar"/>?returnURL=${urlGuardar }" title="<bean:message key="cabecera.guardar" />" id="contacto"><bean:message key="cabecera.guardar" /></a></li>
</ol>
</div>
<!-- FIN METANAVEGACION   --> <!-- FIN METANAVEGACION   --> 
<%-- Comprobamos si hay un lomes y usamos el titulo. Si no, ponemos titulo por defecto --%>

<h2 id="arb">
<c:forEach var="ode" items="${empaquetadorSession.submanifestPath}" varStatus="status">
<c:choose>
<%-- Ultimo submanifiesto de la barra: se pinta sin link --%>
<c:when test="${status.last}">
<span>
<logic:notEmpty name="ode" property="lom">
<bean:define id="lom" name="ode" property="lom" />
<logic:empty name="lom" property="titulo"><bean:message key="cabecera.ode.sinTitulo" /></logic:empty>
<logic:notEmpty name="lom" property="titulo">${lom.titulo }</logic:notEmpty>
</logic:notEmpty>
<logic:empty name="ode" property="lom"><bean:message key="cabecera.ode.sinTitulo" /></logic:empty>
</span>
</c:when>
<c:otherwise>
<%-- El resto, se pinta con links para poder navegar al submanifiesto anterior --%>
<a href="<html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestosNavegar"/>?identifier=${ode.identifier }">
<logic:notEmpty name="ode" property="lom">
<bean:define id="lom" name="ode" property="lom" />
<logic:empty name="lom" property="titulo"><bean:message key="cabecera.ode.sinTitulo" /></logic:empty>
<logic:notEmpty name="lom" property="titulo">${lom.titulo }</logic:notEmpty>
</logic:notEmpty>
<logic:empty name="ode" property="lom"><bean:message key="cabecera.ode.sinTitulo" /></logic:empty>
</a>:<em class="oculto">-</em> 
</c:otherwise>
</c:choose>
</c:forEach>
</h2>
<div class="limpiar"><br class="oculto" /></div>
</div>
