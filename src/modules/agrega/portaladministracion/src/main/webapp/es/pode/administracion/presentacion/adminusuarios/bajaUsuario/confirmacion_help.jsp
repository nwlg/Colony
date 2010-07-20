<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="baja.usuario.confirmacion"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="baja.usuario.confirmacion"/></h1>
        <p>
            <bean:message key="baja.usuario.confirmacion.online.help"/>
        </p>
        <h2><bean:message key="baja.usuario.confirmacion.aceptar"/></h2>
        <p>
            <bean:message key="baja.usuario.confirmacion.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="baja.usuario.confirmacion.aceptar.param.lista.id"/></td>
                    <td><bean:message key="baja.usuario.confirmacion.aceptar.param.lista.id.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="baja.usuario.confirmacion.aceptar.param.usuarios"/></td>
                    <td><bean:message key="baja.usuario.confirmacion.aceptar.param.usuarios.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="baja.usuario.confirmacion.cancelar"/></h2>
        <p>
            <bean:message key="baja.usuario.confirmacion.cancelar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

