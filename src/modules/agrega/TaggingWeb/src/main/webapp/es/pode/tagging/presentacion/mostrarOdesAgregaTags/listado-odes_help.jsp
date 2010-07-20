<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="mostrar.odes.agrega.tags.listado.odes"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="mostrar.odes.agrega.tags.listado.odes"/></h1>
        <p>
            <bean:message key="mostrar.odes.agrega.tags.listado.odes.online.help"/>
        </p>
        <h2><bean:message key="mostrar.odes.agrega.tags.listado.odes.volver"/></h2>
        <p>
            <bean:message key="mostrar.odes.agrega.tags.listado.odes.volver.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

