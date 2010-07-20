<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="baja.tesauros.confirmacion"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="baja.tesauros.confirmacion"/></h1>
        <p>
            <bean:message key="baja.tesauros.confirmacion.online.help"/>
        </p>
        <h2><bean:message key="baja.tesauros.confirmacion.buscar"/></h2>
        <p>
            <bean:message key="baja.tesauros.confirmacion.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="baja.tesauros.confirmacion.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="baja.tesauros.confirmacion.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="baja.tesauros.confirmacion.submit"/></h2>
        <p>
            <bean:message key="baja.tesauros.confirmacion.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="baja.tesauros.confirmacion.submit.param.action"/></td>
                    <td><bean:message key="baja.tesauros.confirmacion.submit.param.action.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

