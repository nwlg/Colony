<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="descripcion.tarea.mostrar.carga.odes"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="descripcion.tarea.mostrar.carga.odes"/></h1>
        <p>
            <bean:message key="descripcion.tarea.mostrar.carga.odes.online.help"/>
        </p>
        <h2><bean:message key="descripcion.tarea.mostrar.carga.odes.volver"/></h2>
        <p>
            <bean:message key="descripcion.tarea.mostrar.carga.odes.volver.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.grupo.trabajo"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.grupo.trabajo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.trigger"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.trigger.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.grupo.trigger"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.grupo.trigger.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.periodicidad"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.periodicidad.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.path.odes"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.path.odes.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.path.odes.cargados"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.path.odes.cargados.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.path.odes.no.cargados"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.path.odes.no.cargados.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.dia"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.dia.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.mes"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.mes.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.anio"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.anio.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.hora"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.hora.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.minutos"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.minutos.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.tipo.tarea"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.tipo.tarea.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.msg.publicado"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.msg.publicado.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.msg.no.publicado"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.msg.no.publicado.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.msg.desc.carga.odes"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.carga.odes.volver.param.msg.desc.carga.odes.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

