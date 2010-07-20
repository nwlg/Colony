<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="listar.catalogadores.formulario.listado.catalogadores"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="listar.catalogadores.formulario.listado.catalogadores"/></h1>
        <p>
            <bean:message key="listar.catalogadores.formulario.listado.catalogadores.online.help"/>
        </p>
        <h2><bean:message key="listar.catalogadores.formulario.listado.catalogadores.crear.catalogadores"/></h2>
        <p>
            <bean:message key="listar.catalogadores.formulario.listado.catalogadores.crear.catalogadores.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

