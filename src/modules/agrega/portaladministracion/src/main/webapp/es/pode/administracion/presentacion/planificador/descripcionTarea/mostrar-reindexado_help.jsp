<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="descripcion.tarea.mostrar.reindexado"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="descripcion.tarea.mostrar.reindexado"/></h1>
        <p>
            <bean:message key="descripcion.tarea.mostrar.reindexado.online.help"/>
        </p>
        <h2><bean:message key="descripcion.tarea.mostrar.reindexado.volver"/></h2>
        <p>
            <bean:message key="descripcion.tarea.mostrar.reindexado.volver.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.grupo.trabajo"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.grupo.trabajo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.trigger"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.trigger.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.grupo.trigger"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.grupo.trigger.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.periodicidad"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.periodicidad.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.repositorio"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.repositorio.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.dia"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.dia.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.mes"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.mes.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.anio"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.anio.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.hora"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.hora.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.minutos"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.minutos.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.tipo.tarea"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.tipo.tarea.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.msg.reindexado"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.msg.reindexado.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.msg.no.reindexado"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.msg.no.reindexado.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.msg.desc.reindexado"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.reindexado.volver.param.msg.desc.reindexado.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

