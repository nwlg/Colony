<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="/WEB-INF/tags/cabeceraTag.tld" prefix="cabecera" %>

<tiles:insert definition="layout-portada">
<tiles:put name="title" type="string">
	<bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/es/pode/visualizador/presentacion/portada/noticias-vars.jspf" %>
<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>

<!-- Middle column -->

<div id="contenido_central_middle">
<div class="heading_text heading_indent">logout</div>

<!-- Start of bubble -->
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">

<div class="lb_bubble_content">
	<p style="font-size:0.75em">To log out securely, please close your browser.</p>
</div>

	</div></div></div></div>
<!-- End of search box bubble -->

<div class="lb_bubble_end"></div>

</div>

<!-- End of plantilla_contenido -->
</div>

</tiles:put>

<tiles:put name="menu.cabacera.top.rhs" type="string">
<!-- User and object counts -->
<div style="float: right;">
<span class="header_users">${form.usuarios} <bean:message key="portada.mensaje.usuarios"/></span>
<br class="oculto" />
<span class="header_objects">${form.objetos} <bean:message key="portada.mensaje.objetos"/></span>
<br class="oculto" />
</div> 

</tiles:put>

</tiles:insert>
