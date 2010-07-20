<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<tiles:insert definition="layout-usuario">
<tiles:put name="title" type="string">
	<bean:message key="portada.title"/>
</tiles:put>

    <tiles:put name="title" type="string">
        <bean:message key="title.Comun"/>
    </tiles:put>

    <tiles:put name="style" type="string">
        <link rel="stylesheet" type="text/css" media="screen" href="<html:rewrite page="/es/pode/visualizador/presentacion/accesibilidad/accesibilidad.css"/>"></link>
    </tiles:put>

    
    <tiles:put name="body" type="string">
    <%@ include file="/es/pode/visualizador/presentacion/accesibilidad/accesibilidad-javascript.jspf" %>

    <div class="plantilla_contenido">

<h2><bean:message key="visualizador.accesibilidad.titulo"/></h2>

<div id="contenido_noticia">

<p><bean:message key="visualizador.accesibilidad.web"/><strong><bean:message key="visualizador.accesibilidad.red"/></strong> <bean:message key="visualizador.accesibilidad.texto1"/><br /><br />

<bean:message key="visualizador.accesibilidad.texto2"/><br /><br /> </p>
</div>

</div>

    </tiles:put>

</tiles:insert>
