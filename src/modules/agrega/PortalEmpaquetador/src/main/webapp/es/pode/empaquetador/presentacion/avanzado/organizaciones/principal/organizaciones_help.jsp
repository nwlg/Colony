<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="organizacion.principal.organizaciones"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="organizacion.principal.organizaciones"/></h1>
        <p>
            <bean:message key="organizacion.principal.organizaciones.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>

