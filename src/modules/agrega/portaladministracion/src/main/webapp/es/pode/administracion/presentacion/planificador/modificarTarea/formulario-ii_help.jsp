<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="obtener.tcarga.odes.formulario.ii"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="obtener.tcarga.odes.formulario.ii"/></h1>
        <p>
            <bean:message key="obtener.tcarga.odes.formulario.ii.online.help"/>
        </p>
        <h2><bean:message key="obtener.tcarga.odes.formulario.ii.cancelar"/></h2>
        <p>
            <bean:message key="obtener.tcarga.odes.formulario.ii.cancelar.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar"/></h2>
        <p>
            <bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.trabajo"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.trabajo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.grupo.trabajo"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.grupo.trabajo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.trigger"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.trigger.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.grupo.trigger"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.grupo.trigger.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.periodicidad"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.periodicidad.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.path.odes"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.path.odes.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.path.odes.carg"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.path.odes.carg.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.path.odes.no.carg"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.path.odes.no.carg.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.dia"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.dia.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.mes"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.mes.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.anio"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.anio.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.hora"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.hora.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.minutos"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.minutos.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.tipo.tarea"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.tipo.tarea.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.msg.publicado"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.msg.publicado.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.msg.no.publicado"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.msg.no.publicado.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.msg.desc.carga.odes"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.msg.desc.carga.odes.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.sobrescribir"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.sobrescribir.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.tarea.modificada"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.ii.aceptar.param.tarea.modificada.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

