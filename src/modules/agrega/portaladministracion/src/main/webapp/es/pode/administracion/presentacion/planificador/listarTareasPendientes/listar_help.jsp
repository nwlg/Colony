<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="listar.tareas.pendientes.listar"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="listar.tareas.pendientes.listar"/></h1>
        <p>
            <bean:message key="listar.tareas.pendientes.listar.online.help"/>
        </p>
        <h2><bean:message key="listar.tareas.pendientes.listar.listar.tareas.pendientes"/></h2>
        <p>
            <bean:message key="listar.tareas.pendientes.listar.listar.tareas.pendientes.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="listar.tareas.pendientes.listar.crear.tarea"/></h2>
        <p>
            <bean:message key="listar.tareas.pendientes.listar.crear.tarea.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="listar.tareas.pendientes.listar.listar.tareas.en.ejecucion"/></h2>
        <p>
            <bean:message key="listar.tareas.pendientes.listar.listar.tareas.en.ejecucion.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="listar.tareas.pendientes.listar.listar.tareas.ejecutadas"/></h2>
        <p>
            <bean:message key="listar.tareas.pendientes.listar.listar.tareas.ejecutadas.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

