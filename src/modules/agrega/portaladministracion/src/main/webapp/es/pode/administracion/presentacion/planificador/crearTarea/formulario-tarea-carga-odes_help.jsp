<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="crear.tarea.formulario.tarea.carga.odes"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="crear.tarea.formulario.tarea.carga.odes"/></h1>
        <p>
            <bean:message key="crear.tarea.formulario.tarea.carga.odes.online.help"/>
        </p>
        <h2><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar"/></h2>
        <p>
            <bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.trabajo"/></td>
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.trabajo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.trigger"/></td>
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.trigger.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.dia"/></td>
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.dia.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.mes"/></td>
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.mes.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.anio"/></td>
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.anio.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.hora"/></td>
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.hora.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.minutos"/></td>
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.minutos.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.periodicidad"/></td>
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.periodicidad.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.path.odes"/></td>
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.path.odes.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.path.odes.carg"/></td>
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.path.odes.carg.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.path.odes.no.carg"/></td>
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.path.odes.no.carg.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.tipo.tarea"/></td>
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.tipo.tarea.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.msg.publicado"/></td>
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.msg.publicado.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.msg.no.publicado"/></td>
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.msg.no.publicado.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.msg.desc.trabajo"/></td>
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.msg.desc.trabajo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.sobrescribir"/></td>
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.sobrescribir.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.tarea.modificada"/></td>
                    <td><bean:message key="crear.tarea.formulario.tarea.carga.odes.aceptar.param.tarea.modificada.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="crear.tarea.formulario.tarea.carga.odes.cancelar"/></h2>
        <p>
            <bean:message key="crear.tarea.formulario.tarea.carga.odes.cancelar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

