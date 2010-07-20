<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="crear.informe.listado.fechas.usuarios"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="crear.informe.listado.fechas.usuarios"/></h1>
        <p>
            <bean:message key="crear.informe.listado.fechas.usuarios.online.help"/>
        </p>
        <h2><bean:message key="crear.informe.listado.fechas.usuarios.cancelar"/></h2>
        <p>
            <bean:message key="crear.informe.listado.fechas.usuarios.cancelar.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="crear.informe.listado.fechas.usuarios.aceptar"/></h2>
        <p>
            <bean:message key="crear.informe.listado.fechas.usuarios.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.informe.listado.fechas.usuarios.aceptar.param.anio.hasta"/></td>
                    <td><bean:message key="crear.informe.listado.fechas.usuarios.aceptar.param.anio.hasta.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.informe.listado.fechas.usuarios.aceptar.param.mes.hasta"/></td>
                    <td><bean:message key="crear.informe.listado.fechas.usuarios.aceptar.param.mes.hasta.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.informe.listado.fechas.usuarios.aceptar.param.dia.hasta"/></td>
                    <td><bean:message key="crear.informe.listado.fechas.usuarios.aceptar.param.dia.hasta.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.informe.listado.fechas.usuarios.aceptar.param.anio.desde"/></td>
                    <td><bean:message key="crear.informe.listado.fechas.usuarios.aceptar.param.anio.desde.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.informe.listado.fechas.usuarios.aceptar.param.mes.desde"/></td>
                    <td><bean:message key="crear.informe.listado.fechas.usuarios.aceptar.param.mes.desde.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.informe.listado.fechas.usuarios.aceptar.param.dia.desde"/></td>
                    <td><bean:message key="crear.informe.listado.fechas.usuarios.aceptar.param.dia.desde.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.informe.listado.fechas.usuarios.aceptar.param.informe"/></td>
                    <td><bean:message key="crear.informe.listado.fechas.usuarios.aceptar.param.informe.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.informe.listado.fechas.usuarios.aceptar.param.usuarios"/></td>
                    <td><bean:message key="crear.informe.listado.fechas.usuarios.aceptar.param.usuarios.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.informe.listado.fechas.usuarios.aceptar.param.formato"/></td>
                    <td><bean:message key="crear.informe.listado.fechas.usuarios.aceptar.param.formato.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

