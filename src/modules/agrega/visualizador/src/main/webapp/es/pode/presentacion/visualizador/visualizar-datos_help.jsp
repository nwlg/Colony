<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="visualizar.visualizar.datos"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="visualizar.visualizar.datos"/></h1>
        <p>
            <bean:message key="visualizar.visualizar.datos.online.help"/>
        </p>
        <h2><bean:message key="visualizar.visualizar.datos.fin"/></h2>
        <p>
            <bean:message key="visualizar.visualizar.datos.fin.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

