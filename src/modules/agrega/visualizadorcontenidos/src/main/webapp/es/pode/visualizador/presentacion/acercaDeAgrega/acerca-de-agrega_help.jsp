<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="acerca.de.agrega.acerca.de.agrega"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="acerca.de.agrega.acerca.de.agrega"/></h1>
        <p>
            <bean:message key="acerca.de.agrega.acerca.de.agrega.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>

