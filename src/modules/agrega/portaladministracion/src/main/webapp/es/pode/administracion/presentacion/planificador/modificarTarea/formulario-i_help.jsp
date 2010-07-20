<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="obtener.tcarga.odes.formulario.i"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="obtener.tcarga.odes.formulario.i"/></h1>
        <p>
            <bean:message key="obtener.tcarga.odes.formulario.i.online.help"/>
        </p>
        <h2><bean:message key="obtener.tcarga.odes.formulario.i.cancelar"/></h2>
        <p>
            <bean:message key="obtener.tcarga.odes.formulario.i.cancelar.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="obtener.tcarga.odes.formulario.i.continuar"/></h2>
        <p>
            <bean:message key="obtener.tcarga.odes.formulario.i.continuar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.trabajo"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.trabajo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.grupo.trabajo"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.grupo.trabajo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.trigger"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.trigger.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.grupo.trigger"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.grupo.trigger.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.periodicidad"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.periodicidad.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.dia"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.dia.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.mes"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.mes.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.anio"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.anio.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.hora"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.hora.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.minutos"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.minutos.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.path.odes"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.path.odes.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.path.odes.carg"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.path.odes.carg.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.path.odes.no.carg"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.path.odes.no.carg.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.tipo.tarea"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.tipo.tarea.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.msg.publicado"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.msg.publicado.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.msg.no.publicado"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.msg.no.publicado.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.msg.desc.carga.odes"/></td>
                    <td><bean:message key="obtener.tcarga.odes.formulario.i.continuar.param.msg.desc.carga.odes.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

