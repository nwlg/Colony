<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="modificaciones.pendientes.confirmacion"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="modificaciones.pendientes.confirmacion"/></h1>
        <p>
            <bean:message key="modificaciones.pendientes.confirmacion.online.help"/>
        </p>
        <h2><bean:message key="modificaciones.pendientes.confirmacion.submit.confirmacion"/></h2>
        <p>
            <bean:message key="modificaciones.pendientes.confirmacion.submit.confirmacion.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificaciones.pendientes.confirmacion.submit.confirmacion.param.action"/></td>
                    <td><bean:message key="modificaciones.pendientes.confirmacion.submit.confirmacion.param.action.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificaciones.pendientes.confirmacion.submit.confirmacion.param.identificadores"/></td>
                    <td><bean:message key="modificaciones.pendientes.confirmacion.submit.confirmacion.param.identificadores.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="modificaciones.pendientes.confirmacion.buscar"/></h2>
        <p>
            <bean:message key="modificaciones.pendientes.confirmacion.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificaciones.pendientes.confirmacion.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="modificaciones.pendientes.confirmacion.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificaciones.pendientes.confirmacion.buscar.param.tipo.busqueda"/></td>
                    <td><bean:message key="modificaciones.pendientes.confirmacion.buscar.param.tipo.busqueda.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

