<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="obtener.tcarga.odes.formulario.reindexado.i"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="obtener.tcarga.odes.formulario.reindexado.i"/></h1>
        <p>
            <bean:message key="obtener.tcarga.odes.formulario.reindexado.i.online.help"/>
        </p>
        <h2><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.cancelar"/></h2>
        <p>
            <bean:message key="obtener.tcarga.odes.formulario.reindexado.i.cancelar.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar"/></h2>
        <p>
            <bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.trabajo"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.trabajo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.grupo.trabajo"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.grupo.trabajo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.trigger"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.trigger.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.grupo.trigger"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.grupo.trigger.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.periodicidad"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.periodicidad.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.anio"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.anio.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.mes"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.mes.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.dia"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.dia.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.hora"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.hora.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.minutos"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.minutos.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.tipo.tarea"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.tipo.tarea.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.repositorio"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.repositorio.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.msg.reindexado"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.msg.reindexado.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.msg.no.reindexado"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.msg.no.reindexado.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.msg.desc.reindexado"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.reindexado.i.continuar.param.msg.desc.reindexado.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

