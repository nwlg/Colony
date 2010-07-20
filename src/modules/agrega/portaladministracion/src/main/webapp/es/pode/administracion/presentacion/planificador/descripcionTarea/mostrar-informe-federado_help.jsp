<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="descripcion.tarea.mostrar.informe.federado"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="descripcion.tarea.mostrar.informe.federado"/></h1>
        <p>
            <bean:message key="descripcion.tarea.mostrar.informe.federado.online.help"/>
        </p>
        <h2><bean:message key="descripcion.tarea.mostrar.informe.federado.volver"/></h2>
        <p>
            <bean:message key="descripcion.tarea.mostrar.informe.federado.volver.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.grupo.trabajo"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.grupo.trabajo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.trigger"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.trigger.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.grupo.trigger"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.grupo.trigger.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.tipo.tarea"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.tipo.tarea.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.periodicidad"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.periodicidad.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.formato"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.formato.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.informe"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.informe.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.anio"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.anio.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.mes"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.mes.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.dia"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.dia.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.hora"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.hora.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.minutos"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.minutos.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.msg.desc.trabajo"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.msg.desc.trabajo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.msg.informe"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.msg.informe.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.msg.no.informe"/></td>
                    <td><bean:message key="descripcion.tarea.mostrar.informe.federado.volver.param.msg.no.informe.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

