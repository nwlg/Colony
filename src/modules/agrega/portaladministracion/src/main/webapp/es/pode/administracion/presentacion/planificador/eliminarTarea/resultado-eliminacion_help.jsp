<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="eliminar.tareas.resultado.eliminacion"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="eliminar.tareas.resultado.eliminacion"/></h1>
        <p>
            <bean:message key="eliminar.tareas.resultado.eliminacion.online.help"/>
        </p>
        <h2><bean:message key="eliminar.tareas.resultado.eliminacion.aceptar"/></h2>
        <p>
            <bean:message key="eliminar.tareas.resultado.eliminacion.aceptar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

