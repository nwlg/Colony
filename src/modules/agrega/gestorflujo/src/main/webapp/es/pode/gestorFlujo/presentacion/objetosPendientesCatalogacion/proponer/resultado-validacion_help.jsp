<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="proponer.cu.resultado.validacion"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="proponer.cu.resultado.validacion"/></h1>
        <p>
            <bean:message key="proponer.cu.resultado.validacion.online.help"/>
        </p>
        <h2><bean:message key="proponer.cu.resultado.validacion.aceptar"/></h2>
        <p>
            <bean:message key="proponer.cu.resultado.validacion.aceptar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

