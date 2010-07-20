<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="baja.grupo.confirmacion.baja"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="baja.grupo.confirmacion.baja"/></h1>
        <p>
            <bean:message key="baja.grupo.confirmacion.baja.online.help"/>
        </p>
        <h2><bean:message key="baja.grupo.confirmacion.baja.aceptar"/></h2>
        <p>
            <bean:message key="baja.grupo.confirmacion.baja.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="baja.grupo.confirmacion.baja.aceptar.param.grupos"/></td>
                    <td><bean:message key="baja.grupo.confirmacion.baja.aceptar.param.grupos.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="baja.grupo.confirmacion.baja.cancelar"/></h2>
        <p>
            <bean:message key="baja.grupo.confirmacion.baja.cancelar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

