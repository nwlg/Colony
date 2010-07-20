<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="mostrar.odes.listado.odes.admin"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="mostrar.odes.listado.odes.admin"/></h1>
        <p>
            <bean:message key="mostrar.odes.listado.odes.admin.online.help"/>
        </p>
        <h2><bean:message key="mostrar.odes.listado.odes.admin.volver"/></h2>
        <p>
            <bean:message key="mostrar.odes.listado.odes.admin.volver.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

