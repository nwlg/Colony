<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="solicitar.baja.usuario.confirmacion.solicitud.baja"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="solicitar.baja.usuario.confirmacion.solicitud.baja"/></h1>
        <p>
            <bean:message key="solicitar.baja.usuario.confirmacion.solicitud.baja.online.help"/>
        </p>
        <h2><bean:message key="solicitar.baja.usuario.confirmacion.solicitud.baja.cancelar"/></h2>
        <p>
            <bean:message key="solicitar.baja.usuario.confirmacion.solicitud.baja.cancelar.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="solicitar.baja.usuario.confirmacion.solicitud.baja.aceptar"/></h2>
        <p>
            <bean:message key="solicitar.baja.usuario.confirmacion.solicitud.baja.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="solicitar.baja.usuario.confirmacion.solicitud.baja.aceptar.param.usuario"/></td>
                    <td><bean:message key="solicitar.baja.usuario.confirmacion.solicitud.baja.aceptar.param.usuario.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="solicitar.baja.usuario.confirmacion.solicitud.baja.aceptar.param.resultado.envio"/></td>
                    <td><bean:message key="solicitar.baja.usuario.confirmacion.solicitud.baja.aceptar.param.resultado.envio.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

