<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="modificar.nodo.resultado.modificar.nodo"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="modificar.nodo.resultado.modificar.nodo"/></h1>
        <p>
            <bean:message key="modificar.nodo.resultado.modificar.nodo.online.help"/>
        </p>
        <h2><bean:message key="modificar.nodo.resultado.modificar.nodo.aceptar"/></h2>
        <p>
            <bean:message key="modificar.nodo.resultado.modificar.nodo.aceptar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

