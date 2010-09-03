<%@ include file="/taglib-imports.jspf"%>
<%@ taglib uri="/WEB-INF/tags/link.tld" prefix="link" %>

<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- INICIO CABECERA  -->
<div id="cabecera">
<tiles:importAttribute/>
<tiles:useAttribute id="urlGuardar" name="urlGuardar"/>
<logic:empty name="urlGuardar">
<bean:define id="urlGuardar"><html:rewrite action="/GestorBasico/GestorBasico"/>"</bean:define>
</logic:empty>
<bean:define id="parametrosCatalogar">identifier=${empaquetadorSession.ode.identifier }&amp;returnURL=<html:rewrite action="/GestorBasico/GestorBasico"/></bean:define>


<!-- INICIO METANAVEGACION   --> <!-- INICIO METANAVEGACION   -->
<div id="metanavegacion">
<bean:define id="titleAyuda"><bean:message key="cabecera.ayuda"/></bean:define>
<ol>
	<li class="oculto">
	<a href="#contenido_central" title="<bean:message key="metanavegacion.contenido" />"><strong><bean:message key="metanavegacion.contenido" /></strong></a></li>
	<li><a href="<html:rewrite action="/Salir/Salir"/>" title="<bean:message key="metanavegacion.cerrar" />" id="li_inicial"><bean:message key="metanavegacion.cerrar" /></a></li>
	<li><link:link attrProperty="HELP_URL" title="${titleAyuda}" id="ayuda" target="blank" i18nMessage="cabecera.ayuda"/></li>
	<li><a href="<html:rewrite action="/Catalogar/Catalogar"/>?${parametrosCatalogar }" title="<bean:message key="cabecera.catalogar" />"><bean:message key="cabecera.catalogar" /></a></li>
	<li><a href="<html:rewrite action="/Previsualizar/Previsualizar"/>" title="<bean:message key="cabecera.previsualizar" />" target="_blank"><bean:message key="cabecera.previsualizar" /></a></li>
	<li><a href="<html:rewrite action="/Validar/Validar"/>" title="<bean:message key="cabecera.validar" />"><bean:message key="cabecera.validar" /></a></li>
	<li><a href="<html:rewrite action="/Guardar/Guardar"/>?returnURL=${urlGuardar }" title="<bean:message key="cabecera.guardar" />" id="contacto"><bean:message key="cabecera.guardar" /></a></li>
</ol>
</div>
<!-- FIN METANAVEGACION   --> <!-- FIN METANAVEGACION   --> <%-- Comprobamos si hay un lomes y usamos el titulo. Si no, ponemos titulo por defecto --%>
<bean:define id="empaquetadorSesion" name="<%=es.pode.empaquetador.presentacion.EmpaquetadorSession.SESSION_KEY%>" scope="session" />
<bean:define id="ode" name="empaquetadorSesion" property="ode" />
<logic:notEmpty name="ode" property="lom">
	<bean:define id="lom" name="ode" property="lom" />
	<logic:empty name="lom" property="titulo">
		<h2 class="h2_paq"><bean:message key="cabecera.ode.sinTitulo" /></h2>
	</logic:empty>
	<logic:notEmpty name="lom" property="titulo">
		<h2 class="h2_paq">${lom.titulo }</h2>
	</logic:notEmpty>
</logic:notEmpty>
<logic:empty name="ode" property="lom">
	<h2 class="h2_paq"><bean:message key="cabecera.ode.sinTitulo" /></h2>
</logic:empty>
<br class="oculto" />
</div>

