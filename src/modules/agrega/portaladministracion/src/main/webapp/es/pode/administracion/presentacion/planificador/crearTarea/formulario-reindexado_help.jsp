<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="crear.tarea.formulario.reindexado"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="crear.tarea.formulario.reindexado"/></h1>
        <p>
            <bean:message key="crear.tarea.formulario.reindexado.online.help"/>
        </p>
        <h2><bean:message key="crear.tarea.formulario.reindexado.aceptar"/></h2>
        <p>
            <bean:message key="crear.tarea.formulario.reindexado.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.trabajo"/></td>
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.trabajo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.periodicidad"/></td>
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.periodicidad.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.dia"/></td>
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.dia.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.mes"/></td>
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.mes.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.anio"/></td>
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.anio.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.hora"/></td>
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.hora.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.minutos"/></td>
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.minutos.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.repositorio.indices"/></td>
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.repositorio.indices.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.trigger"/></td>
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.trigger.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.tipo.tarea"/></td>
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.tipo.tarea.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.msg.reindexado"/></td>
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.msg.reindexado.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.msg.no.reindexado"/></td>
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.msg.no.reindexado.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.msg.desc.trabajo"/></td>
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.msg.desc.trabajo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.idioma"/></td>
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.tarea.modificada"/></td>
                    <td><bean:message key="crear.tarea.formulario.reindexado.aceptar.param.tarea.modificada.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="crear.tarea.formulario.reindexado.cancelar"/></h2>
        <p>
            <bean:message key="crear.tarea.formulario.reindexado.cancelar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

