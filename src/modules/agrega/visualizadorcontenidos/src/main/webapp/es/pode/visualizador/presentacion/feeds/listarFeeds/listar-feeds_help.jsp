<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="listar.feeds.cu.listar.feeds"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="listar.feeds.cu.listar.feeds"/></h1>
        <p>
            <bean:message key="listar.feeds.cu.listar.feeds.online.help"/>
        </p>
        <h2><bean:message key="listar.feeds.cu.listar.feeds.volver"/></h2>
        <p>
            <bean:message key="listar.feeds.cu.listar.feeds.volver.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

