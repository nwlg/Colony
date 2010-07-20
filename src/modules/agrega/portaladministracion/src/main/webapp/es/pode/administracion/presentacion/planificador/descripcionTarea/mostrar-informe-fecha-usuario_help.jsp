<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario"/></h1>
        <p>
            <bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.online.help"/>
        </p>
        <h2><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver"/></h2>
        <p>
            <bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.grupo.trabajo"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.grupo.trabajo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.trigger"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.trigger.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.grupo.trigger"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.grupo.trigger.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.tipo.tarea"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.tipo.tarea.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.periodicidad"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.periodicidad.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.formato"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.formato.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.informe"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.informe.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.usuario"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.usuario.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.anio"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.anio.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.mes"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.mes.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.dia"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.dia.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.hora"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.hora.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.minutos"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.minutos.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.anio.desde"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.anio.desde.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.mes.desde"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.mes.desde.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.dia.desde"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.dia.desde.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.anio.hasta"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.anio.hasta.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.mes.hasta"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.mes.hasta.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.dia.hasta"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.dia.hasta.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.msg.desc.trabajo"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.msg.desc.trabajo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.msg.informe"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.msg.informe.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.msg.no.informe"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.usuario.volver.param.msg.no.informe.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

