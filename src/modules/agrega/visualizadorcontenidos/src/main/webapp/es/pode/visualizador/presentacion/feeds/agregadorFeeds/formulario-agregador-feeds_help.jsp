<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="agregador.feeds.cu.formulario.agregador.feeds"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="agregador.feeds.cu.formulario.agregador.feeds"/></h1>
        <p>
            <bean:message key="agregador.feeds.cu.formulario.agregador.feeds.online.help"/>
        </p>
        <h2><bean:message key="agregador.feeds.cu.formulario.agregador.feeds.que.es.esto"/></h2>
        <p>
            <bean:message key="agregador.feeds.cu.formulario.agregador.feeds.que.es.esto.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="agregador.feeds.cu.formulario.agregador.feeds.listar"/></h2>
        <p>
            <bean:message key="agregador.feeds.cu.formulario.agregador.feeds.listar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

