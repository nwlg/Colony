<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="configurar.modificacion.configurar.modificacion"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="configurar.modificacion.configurar.modificacion"/></h1>
        <p>
            <bean:message key="configurar.modificacion.configurar.modificacion.online.help"/>
        </p>
        <h2><bean:message key="configurar.modificacion.configurar.modificacion.buscar"/></h2>
        <p>
            <bean:message key="configurar.modificacion.configurar.modificacion.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="configurar.modificacion.configurar.modificacion.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="configurar.modificacion.configurar.modificacion.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="configurar.modificacion.configurar.modificacion.select.action"/></h2>
        <p>
            <bean:message key="configurar.modificacion.configurar.modificacion.select.action.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="configurar.modificacion.configurar.modificacion.select.action.param.action"/></td>
                    <td><bean:message key="configurar.modificacion.configurar.modificacion.select.action.param.action.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="configurar.modificacion.configurar.modificacion.select.action.param.posiciones"/></td>
                    <td><bean:message key="configurar.modificacion.configurar.modificacion.select.action.param.posiciones.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="configurar.modificacion.configurar.modificacion.select.action.param.idioma.buscador"/></td>
                    <td><bean:message key="configurar.modificacion.configurar.modificacion.select.action.param.idioma.buscador.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="configurar.modificacion.configurar.modificacion.guardar"/></h2>
        <p>
            <bean:message key="configurar.modificacion.configurar.modificacion.guardar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="configurar.modificacion.configurar.modificacion.guardar.param.action"/></td>
                    <td><bean:message key="configurar.modificacion.configurar.modificacion.guardar.param.action.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

