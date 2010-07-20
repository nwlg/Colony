<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="descripcion.tarea.mostrar.informe.fecha.rango"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango"/></h1>
        <p>
            <bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.online.help"/>
        </p>
        <h2><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver"/></h2>
        <p>
            <bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.grupo.trabajo"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.grupo.trabajo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.trigger"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.trigger.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.grupo.trigger"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.grupo.trigger.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.tipo.tarea"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.tipo.tarea.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.periodicidad"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.periodicidad.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.formato"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.formato.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.informe"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.informe.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.rango"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.rango.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.anio"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.anio.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.mes"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.mes.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.dia"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.dia.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.hora"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.hora.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.minutos"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.minutos.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.anio.desde"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.anio.desde.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.mes.desde"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.mes.desde.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.dia.desde"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.dia.desde.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.anio.hasta"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.anio.hasta.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.mes.hasta"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.mes.hasta.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.dia.hasta"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.dia.hasta.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.msg.desc.trabajo"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.msg.desc.trabajo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.msg.informe"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.msg.informe.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.msg.no.informe"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.fecha.rango.volver.param.msg.no.informe.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

