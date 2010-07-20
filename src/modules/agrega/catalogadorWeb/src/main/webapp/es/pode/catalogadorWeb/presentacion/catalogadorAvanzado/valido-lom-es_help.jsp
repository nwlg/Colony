<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="catalogador.avanzado.valido.lom.es"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="catalogador.avanzado.valido.lom.es"/></h1>
        <p>
            <bean:message key="catalogador.avanzado.valido.lom.es.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>

