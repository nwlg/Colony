<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i"/></h1>
        <p>
            <bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.online.help"/>
        </p>
        <h2><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar"/></h2>
        <p>
            <bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.trabajo"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.trabajo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.grupo.trabajo"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.grupo.trabajo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.trigger"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.trigger.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.grupo.trigger"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.grupo.trigger.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.periodicidad"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.periodicidad.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.tipo.tarea"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.tipo.tarea.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.informe"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.informe.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.formato"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.formato.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.anio"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.anio.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.mes"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.mes.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.dia"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.dia.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.hora"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.hora.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.minutos"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.minutos.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.anio.desde"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.anio.desde.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.mes.desde"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.mes.desde.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.dia.desde"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.dia.desde.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.anio.hasta"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.anio.hasta.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.mes.hasta"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.mes.hasta.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.dia.hasta"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.dia.hasta.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.msg.desc.trabajo"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.msg.desc.trabajo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.msg.informe"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.msg.informe.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.msg.no.informe"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.continuar.param.msg.no.informe.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.cancelar"/></h2>
        <p>
            <bean:message key="obtener.tcarga.odes.formulario.informe.fecha.i.cancelar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

