<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="desactivar.usuario.confirmacion.desactivar.usuario"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="desactivar.usuario.confirmacion.desactivar.usuario"/></h1>
        <p>
            <bean:message key="desactivar.usuario.confirmacion.desactivar.usuario.online.help"/>
        </p>
        <h2><bean:message key="desactivar.usuario.confirmacion.desactivar.usuario.cancelar"/></h2>
        <p>
            <bean:message key="desactivar.usuario.confirmacion.desactivar.usuario.cancelar.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="desactivar.usuario.confirmacion.desactivar.usuario.aceptar"/></h2>
        <p>
            <bean:message key="desactivar.usuario.confirmacion.desactivar.usuario.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="desactivar.usuario.confirmacion.desactivar.usuario.aceptar.param.id"/></td>
                    <td><bean:message key="desactivar.usuario.confirmacion.desactivar.usuario.aceptar.param.id.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

