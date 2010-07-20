<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="sesion.caducada.error"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="sesion.caducada.error"/></h1>
        <p>
            <bean:message key="sesion.caducada.error.online.help"/>
        </p>
        <h2><bean:message key="sesion.caducada.error.aceptar"/></h2>
        <p>
            <bean:message key="sesion.caducada.error.aceptar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

