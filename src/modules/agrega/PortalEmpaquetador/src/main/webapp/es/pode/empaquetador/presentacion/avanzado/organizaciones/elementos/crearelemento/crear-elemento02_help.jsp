<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="crear.elemento.crear.elemento02"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="crear.elemento.crear.elemento02"/></h1>
        <p>
            <bean:message key="crear.elemento.crear.elemento02.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>

