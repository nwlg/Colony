<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="crear.informe.listado.fechas.rango"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="crear.informe.listado.fechas.rango"/></h1>
        <p>
            <bean:message key="crear.informe.listado.fechas.rango.online.help"/>
        </p>
        <h2><bean:message key="crear.informe.listado.fechas.rango.cancelar"/></h2>
        <p>
            <bean:message key="crear.informe.listado.fechas.rango.cancelar.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="crear.informe.listado.fechas.rango.aceptar"/></h2>
        <p>
            <bean:message key="crear.informe.listado.fechas.rango.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.informe.listado.fechas.rango.aceptar.param.anio.hasta"/></td>
                    <td><bean:message key="crear.informe.listado.fechas.rango.aceptar.param.anio.hasta.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.informe.listado.fechas.rango.aceptar.param.mes.hasta"/></td>
                    <td><bean:message key="crear.informe.listado.fechas.rango.aceptar.param.mes.hasta.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.informe.listado.fechas.rango.aceptar.param.dia.hasta"/></td>
                    <td><bean:message key="crear.informe.listado.fechas.rango.aceptar.param.dia.hasta.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.informe.listado.fechas.rango.aceptar.param.anio.desde"/></td>
                    <td><bean:message key="crear.informe.listado.fechas.rango.aceptar.param.anio.desde.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.informe.listado.fechas.rango.aceptar.param.mes.desde"/></td>
                    <td><bean:message key="crear.informe.listado.fechas.rango.aceptar.param.mes.desde.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.informe.listado.fechas.rango.aceptar.param.dia.desde"/></td>
                    <td><bean:message key="crear.informe.listado.fechas.rango.aceptar.param.dia.desde.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.informe.listado.fechas.rango.aceptar.param.rango"/></td>
                    <td><bean:message key="crear.informe.listado.fechas.rango.aceptar.param.rango.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.informe.listado.fechas.rango.aceptar.param.informe"/></td>
                    <td><bean:message key="crear.informe.listado.fechas.rango.aceptar.param.informe.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.informe.listado.fechas.rango.aceptar.param.formato"/></td>
                    <td><bean:message key="crear.informe.listado.fechas.rango.aceptar.param.formato.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

