<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="exportar.cu.seleccionar.formato.exportacion"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="exportar.cu.seleccionar.formato.exportacion"/></h1>
        <p>
            <bean:message key="exportar.cu.seleccionar.formato.exportacion.online.help"/>
        </p>
        <h2><bean:message key="exportar.cu.seleccionar.formato.exportacion.cancelar"/></h2>
        <p>
            <bean:message key="exportar.cu.seleccionar.formato.exportacion.cancelar.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="exportar.cu.seleccionar.formato.exportacion.aceptar"/></h2>
        <p>
            <bean:message key="exportar.cu.seleccionar.formato.exportacion.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="exportar.cu.seleccionar.formato.exportacion.aceptar.param.formato.exportacion"/></td>
                    <td><bean:message key="exportar.cu.seleccionar.formato.exportacion.aceptar.param.formato.exportacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="exportar.cu.seleccionar.formato.exportacion.aceptar.param.id.ode"/></td>
                    <td><bean:message key="exportar.cu.seleccionar.formato.exportacion.aceptar.param.id.ode.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="exportar.cu.seleccionar.formato.exportacion.aceptar.param.titulo"/></td>
                    <td><bean:message key="exportar.cu.seleccionar.formato.exportacion.aceptar.param.titulo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="exportar.cu.seleccionar.formato.exportacion.aceptar.param.mensajes"/></td>
                    <td><bean:message key="exportar.cu.seleccionar.formato.exportacion.aceptar.param.mensajes.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="exportar.cu.seleccionar.formato.exportacion.aceptar.param.href"/></td>
                    <td><bean:message key="exportar.cu.seleccionar.formato.exportacion.aceptar.param.href.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

