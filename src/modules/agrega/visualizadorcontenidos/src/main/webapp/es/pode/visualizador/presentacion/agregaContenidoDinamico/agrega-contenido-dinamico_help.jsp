<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="agrega.contenido.dinamico.agrega.contenido.dinamico"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="agrega.contenido.dinamico.agrega.contenido.dinamico"/></h1>
        <p>
            <bean:message key="agrega.contenido.dinamico.agrega.contenido.dinamico.online.help"/>
        </p>
        <h2><bean:message key="agrega.contenido.dinamico.agrega.contenido.dinamico.volver"/></h2>
        <p>
            <bean:message key="agrega.contenido.dinamico.agrega.contenido.dinamico.volver.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

