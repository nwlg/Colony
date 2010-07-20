<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="crear.tarea.formulario.inicio"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="crear.tarea.formulario.inicio"/></h1>
        <p>
            <bean:message key="crear.tarea.formulario.inicio.online.help"/>
        </p>
        <h2><bean:message key="crear.tarea.formulario.inicio.crear.tarea"/></h2>
        <p>
            <bean:message key="crear.tarea.formulario.inicio.crear.tarea.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.inicio.crear.tarea.param.trabajo"/></td>
                    <td><bean:message key="crear.tarea.formulario.inicio.crear.tarea.param.trabajo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.inicio.crear.tarea.param.periodicidad"/></td>
                    <td><bean:message key="crear.tarea.formulario.inicio.crear.tarea.param.periodicidad.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.inicio.crear.tarea.param.dia"/></td>
                    <td><bean:message key="crear.tarea.formulario.inicio.crear.tarea.param.dia.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.inicio.crear.tarea.param.mes"/></td>
                    <td><bean:message key="crear.tarea.formulario.inicio.crear.tarea.param.mes.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.inicio.crear.tarea.param.anio"/></td>
                    <td><bean:message key="crear.tarea.formulario.inicio.crear.tarea.param.anio.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.inicio.crear.tarea.param.hora"/></td>
                    <td><bean:message key="crear.tarea.formulario.inicio.crear.tarea.param.hora.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.tarea.formulario.inicio.crear.tarea.param.minutos"/></td>
                    <td><bean:message key="crear.tarea.formulario.inicio.crear.tarea.param.minutos.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.tarea.formulario.inicio.crear.tarea.param.tipo.tarea"/></td>
                    <td><bean:message key="crear.tarea.formulario.inicio.crear.tarea.param.tipo.tarea.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="crear.tarea.formulario.inicio.cancelar"/></h2>
        <p>
            <bean:message key="crear.tarea.formulario.inicio.cancelar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

