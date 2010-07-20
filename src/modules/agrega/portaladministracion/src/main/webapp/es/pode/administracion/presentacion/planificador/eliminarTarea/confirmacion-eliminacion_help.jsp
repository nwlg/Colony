<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="eliminar.tareas.confirmacion.eliminacion"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="eliminar.tareas.confirmacion.eliminacion"/></h1>
        <p>
            <bean:message key="eliminar.tareas.confirmacion.eliminacion.online.help"/>
        </p>
        <h2><bean:message key="eliminar.tareas.confirmacion.eliminacion.cancelar"/></h2>
        <p>
            <bean:message key="eliminar.tareas.confirmacion.eliminacion.cancelar.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="eliminar.tareas.confirmacion.eliminacion.aceptar"/></h2>
        <p>
            <bean:message key="eliminar.tareas.confirmacion.eliminacion.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="eliminar.tareas.confirmacion.eliminacion.aceptar.param.lista.trabajo.plana"/></td>
                    <td><bean:message key="eliminar.tareas.confirmacion.eliminacion.aceptar.param.lista.trabajo.plana.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

