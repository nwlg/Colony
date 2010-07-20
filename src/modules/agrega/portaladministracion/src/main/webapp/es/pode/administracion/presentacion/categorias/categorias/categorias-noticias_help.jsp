<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="categorias.noticias.cu.categorias.noticias"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="categorias.noticias.cu.categorias.noticias"/></h1>
        <p>
            <bean:message key="categorias.noticias.cu.categorias.noticias.online.help"/>
        </p>
        <h2><bean:message key="categorias.noticias.cu.categorias.noticias.crear"/></h2>
        <p>
            <bean:message key="categorias.noticias.cu.categorias.noticias.crear.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

