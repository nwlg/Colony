<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="oai.pmh.request.title"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="oai.pmh.request.title"/></h1>
        <p>
            <bean:message key="oai.pmh.request.online.help"/>
        </p>
        <h2><bean:message key="oai.pmh.request.title"/></h2>
        <p>
            <bean:message key="oai.pmh.request.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>

