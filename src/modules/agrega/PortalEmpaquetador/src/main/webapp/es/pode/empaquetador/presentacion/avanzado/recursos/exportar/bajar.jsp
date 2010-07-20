<%@ include file="/taglib-imports.jspf" %>

<breadcrumbs:resize size="5"/>
<breadcrumbs:add value="exportar.recursos.avanzado.bajar.title"/>

<tiles:insert definition="main.layout">

    <tiles:put name="title" type="string">
        <bean:message key="exportar.recursos.avanzado.bajar.title"/>
    </tiles:put>

    <tiles:put name="style" type="string">
        <link rel="stylesheet" type="text/css" media="screen" href="<html:rewrite page="/es/pode/empaquetador/presentacion/avanzado/recursos/exportar/bajar.css"/>"></link>
    </tiles:put>

    <%@ include file="/es/pode/empaquetador/presentacion/avanzado/recursos/exportar/bajar-javascript.jspf" %>

    <tiles:put name="body" type="string">

        <div>
            <tiles:insert definition="breadcrumbs.tile" flush="false">
                <tiles:put name="current.page.title" type="string" value="exportar.recursos.avanzado.bajar.title"/>
            </tiles:insert>
            <h1><bean:message key="exportar.recursos.avanzado.bajar.title"/></h1>
        </div>


        <div id="pageHelpSection">
            <blockquote>
                <a href="" id="pageHelp" style="display:inline;" onclick="openWindow('<html:rewrite action="/BajarHelp"/>','onlinehelp',true,false,760,540); return false;">
                    <bean:message key="online.help.href"/>
                </a>
                <html:img page="/layout/help.gif" style="display:inline;"/>
            </blockquote>
        </div>

    </tiles:put>

</tiles:insert>
