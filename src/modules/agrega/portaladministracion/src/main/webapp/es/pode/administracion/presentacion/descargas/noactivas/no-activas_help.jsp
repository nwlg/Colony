<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="no.activas.no.activas"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="no.activas.no.activas"/></h1>
        <p>
            <bean:message key="no.activas.no.activas.online.help"/>
        </p>
        <h2><bean:message key="no.activas.no.activas.activas"/></h2>
        <p>
            <bean:message key="no.activas.no.activas.activas.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

