<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="agregador.feeds.cu.formulario.que.es.esto"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="agregador.feeds.cu.formulario.que.es.esto"/></h1>
        <p>
            <bean:message key="agregador.feeds.cu.formulario.que.es.esto.online.help"/>
        </p>
        <h2><bean:message key="agregador.feeds.cu.formulario.que.es.esto.volver"/></h2>
        <p>
            <bean:message key="agregador.feeds.cu.formulario.que.es.esto.volver.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

