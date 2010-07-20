<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="politica.privacidad.politica.privacidad"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="politica.privacidad.politica.privacidad"/></h1>
        <p>
            <bean:message key="politica.privacidad.politica.privacidad.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>

