<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="visualizar.title"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="visualizar.title"/></h1>
        <p>
            <bean:message key="visualizar.online.help"/>
        </p>
        <h2><bean:message key="visualizar.title"/></h2>
        <p>
            <bean:message key="visualizar.online.help"/>
        </p>
        <h2><bean:message key="contenido.inapropiado.title"/></h2>
        <p>
            <bean:message key="contenido.inapropiado.online.help"/>
        </p>
        <h2><bean:message key="tagging.title"/></h2>
        <p>
            <bean:message key="tagging.online.help"/>
        </p>
        <h2><bean:message key="visualizar.adl.title"/></h2>
        <p>
            <bean:message key="visualizar.adl.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>

