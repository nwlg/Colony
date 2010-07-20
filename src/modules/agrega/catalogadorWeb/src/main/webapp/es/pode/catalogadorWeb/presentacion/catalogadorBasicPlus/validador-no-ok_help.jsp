<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="catalogador.basic.plus.validador.no.ok"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="catalogador.basic.plus.validador.no.ok"/></h1>
        <p>
            <bean:message key="catalogador.basic.plus.validador.no.ok.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>

