<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="listar.grupos.formulario.listado"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="listar.grupos.formulario.listado"/></h1>
        <p>
            <bean:message key="listar.grupos.formulario.listado.online.help"/>
        </p>
        <h2><bean:message key="listar.grupos.formulario.listado.crear.grupo"/></h2>
        <p>
            <bean:message key="listar.grupos.formulario.listado.crear.grupo.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

