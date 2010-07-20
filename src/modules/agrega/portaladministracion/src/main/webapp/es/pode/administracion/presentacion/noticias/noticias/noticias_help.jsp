<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="noticias.noticias"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="noticias.noticias"/></h1>
        <p>
            <bean:message key="noticias.noticias.online.help"/>
        </p>
        <h2><bean:message key="noticias.noticias.crear.noticia"/></h2>
        <p>
            <bean:message key="noticias.noticias.crear.noticia.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="noticias.noticias.gestion.categorias"/></h2>
        <p>
            <bean:message key="noticias.noticias.gestion.categorias.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

