<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="importar.cu.resultado.importacion"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="importar.cu.resultado.importacion"/></h1>
        <p>
            <bean:message key="importar.cu.resultado.importacion.online.help"/>
        </p>
        <h2><bean:message key="importar.cu.resultado.importacion.continuar"/></h2>
        <p>
            <bean:message key="importar.cu.resultado.importacion.continuar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

