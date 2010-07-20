<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="ver.noticia.formulario.dos"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="ver.noticia.formulario.dos"/></h1>
        <p>
            <bean:message key="ver.noticia.formulario.dos.online.help"/>
        </p>
        <h2><bean:message key="$trigger.triggerKey"/></h2>
        <p>
            <bean:message key="null.is.an.action.without.trigger.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

