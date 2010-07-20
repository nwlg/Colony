<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="listar.tareas.ejecutadas.listar"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="listar.tareas.ejecutadas.listar"/></h1>
        <p>
            <bean:message key="listar.tareas.ejecutadas.listar.online.help"/>
        </p>
        <h2><bean:message key="listar.tareas.ejecutadas.listar.listar.tareas.ejecutadas"/></h2>
        <p>
            <bean:message key="listar.tareas.ejecutadas.listar.listar.tareas.ejecutadas.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

