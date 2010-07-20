<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="utilidades.utilidades"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="utilidades.utilidades"/></h1>
        <p>
            <bean:message key="utilidades.utilidades.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>

