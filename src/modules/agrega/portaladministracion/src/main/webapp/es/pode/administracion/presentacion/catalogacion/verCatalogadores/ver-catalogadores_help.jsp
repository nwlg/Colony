<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="ver.catalogadores.ver.catalogadores"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="ver.catalogadores.ver.catalogadores"/></h1>
        <p>
            <bean:message key="ver.catalogadores.ver.catalogadores.online.help"/>
        </p>
        <h2><bean:message key="ver.catalogadores.ver.catalogadores.volver"/></h2>
        <p>
            <bean:message key="ver.catalogadores.ver.catalogadores.volver.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

