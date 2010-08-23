<%@ include file="/taglib-imports.jspf" %>

<breadcrumbs:resize size="5"/>
<breadcrumbs:add value="exportar.modificacion.exportar.modificacion.title"/>

<tiles:insert definition="main.layout">

    <tiles:put name="title" type="string">
        <bean:message key="exportar.modificacion.exportar.modificacion.title"/>
    </tiles:put>

    <tiles:put name="style" type="string">
        <link rel="stylesheet" type="text/css" media="screen" href="<html:rewrite page="/es/pode/modificador/presentacion/exportar/exportar-modificacion.css"/>"></link>
    </tiles:put>

    <%@ include file="/es/pode/modificador/presentacion/exportar/exportar-modificacion-javascript.jspf" %>

    <tiles:put name="body" type="string">

        <div>
            <tiles:insert definition="breadcrumbs.tile" flush="false">
                <tiles:put name="current.page.title" type="string" value="exportar.modificacion.exportar.modificacion.title"/>
            </tiles:insert>
            <h1><bean:message key="exportar.modificacion.exportar.modificacion.title"/></h1>
        </div>

        <%@ include file="/es/pode/modificador/presentacion/exportar/exportar-modificacion-vars.jspf" %>

        <%@ include file="/es/pode/modificador/presentacion/exportar/exportar-modificacion-exportar.jspf" %>

        <%@ include file="/es/pode/modificador/presentacion/exportar/exportar-modificacion-buscar.jspf" %>


        <div id="pageHelpSection">
            <blockquote>
                <a href="" id="pageHelp" style="display:inline;" onclick="openWindow('<html:rewrite action="/ExportarModificacionHelp"/>','onlinehelp',true,false,760,540); return false;">
                    <bean:message key="online.help.href"/>
                </a>
                <html:img page="/layout/help.gif" style="display:inline;"/>
            </blockquote>
        </div>

    </tiles:put>

</tiles:insert>
