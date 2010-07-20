<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="crear.tarea.formulario.informe.fechas"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="crear.tarea.formulario.informe.fechas"/></h1>
        <p>
            <bean:message key="crear.tarea.formulario.informe.fechas.online.help"/>
        </p>
        <h2><bean:message key="crear.tarea.formulario.informe.fechas.cancelar"/></h2>
        <p>
            <bean:message key="crear.tarea.formulario.informe.fechas.cancelar.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="crear.tarea.formulario.informe.fechas.aceptar"/></h2>
        <p>
            <bean:message key="crear.tarea.formulario.informe.fechas.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.anio"/></td>
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.anio.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.mes"/></td>
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.mes.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.dia"/></td>
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.dia.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.hora"/></td>
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.hora.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.minutos"/></td>
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.minutos.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.anio.desde"/></td>
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.anio.desde.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.mes.desde"/></td>
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.mes.desde.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.dia.desde"/></td>
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.dia.desde.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.anio.hasta"/></td>
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.anio.hasta.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.mes.hasta"/></td>
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.mes.hasta.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.dia.hasta"/></td>
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.dia.hasta.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.tipo.tarea"/></td>
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.tipo.tarea.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.trabajo"/></td>
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.trabajo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.trigger"/></td>
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.trigger.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.formato"/></td>
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.formato.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.informe"/></td>
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.informe.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.msg.desc.trabajo"/></td>
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.msg.desc.trabajo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.msg.informe"/></td>
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.msg.informe.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.msg.no.informe"/></td>
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.msg.no.informe.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.periodicidad"/></td>
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.periodicidad.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.tarea.modificada"/></td>
                    <td><bean:message key="crear.tarea.formulario.informe.fechas.aceptar.param.tarea.modificada.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

