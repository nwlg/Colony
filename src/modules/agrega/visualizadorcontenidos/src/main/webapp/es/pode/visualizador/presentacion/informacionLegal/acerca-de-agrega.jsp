<%@ include file="/taglib-imports.jspf" %>

<breadcrumbs:resize size="5"/>
<breadcrumbs:add value="informacion.legal.acerca.de.agrega.title"/>

<tiles:insert definition="main.layout">

    <tiles:put name="title" type="string">
        <bean:message key="informacion.legal.acerca.de.agrega.title"/>
    </tiles:put>

    <tiles:put name="style" type="string">
        <link rel="stylesheet" type="text/css" media="screen" href="<html:rewrite page="/es/pode/visualizador/presentacion/informacionLegal/acerca-de-agrega.css"/>"></link>
    </tiles:put>

    <%@ include file="/es/pode/visualizador/presentacion/informacionLegal/acerca-de-agrega-javascript.jspf" %>

    <tiles:put name="body" type="string">

        <div>
            <tiles:insert definition="breadcrumbs.tile" flush="false">
                <tiles:put name="current.page.title" type="string" value="informacion.legal.acerca.de.agrega.title"/>
            </tiles:insert>
            <h1><bean:message key="informacion.legal.acerca.de.agrega.title"/></h1>
        </div>


        <div id="pageHelpSection">
            <blockquote>
                <a href="" id="pageHelp" style="display:inline;" onclick="openWindow('<html:rewrite action="/AcercaDeAgregaHelp"/>','onlinehelp',true,false,760,540); return false;">
                    <bean:message key="online.help.href"/>
                </a>
                <html:img page="/layout/help.gif" style="display:inline;"/>
            </blockquote>
        </div>

    </tiles:put>

</tiles:insert>
