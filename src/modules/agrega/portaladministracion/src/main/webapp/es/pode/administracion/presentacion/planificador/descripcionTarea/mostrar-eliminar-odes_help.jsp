<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="descripcion.tarea.mostrar.eliminar.odes"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="descripcion.tarea.mostrar.eliminar.odes"/></h1>
        <p>
            <bean:message key="descripcion.tarea.mostrar.eliminar.odes.online.help"/>
        </p>
        <h2><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver"/></h2>
        <p>
            <bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.grupo.trabajo"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.grupo.trabajo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.trigger"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.trigger.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.grupo.trigger"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.grupo.trigger.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.periodicidad"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.periodicidad.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.tipo.tarea"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.tipo.tarea.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.dia"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.dia.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.mes"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.mes.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.anio"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.anio.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.dia.desde"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.dia.desde.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.mes.desde"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.mes.desde.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.anio.desde"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.anio.desde.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.dia.hasta"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.dia.hasta.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.mes.hasta"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.mes.hasta.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.anio.hasta"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.anio.hasta.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.msg.eliminado"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.msg.eliminado.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.msg.no.eliminado"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.msg.no.eliminado.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.msg.desc.trabajo"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.eliminar.odes.volver.param.msg.desc.trabajo.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

