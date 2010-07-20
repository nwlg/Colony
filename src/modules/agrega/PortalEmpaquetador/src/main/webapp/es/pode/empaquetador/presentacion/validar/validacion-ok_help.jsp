<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="validar.validacion.ok"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="validar.validacion.ok"/></h1>
        <p>
            <bean:message key="validar.validacion.ok.online.help"/>
        </p>
        <h2><bean:message key="validar.validacion.ok.cerrar"/></h2>
        <p>
            <bean:message key="validar.validacion.ok.cerrar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

