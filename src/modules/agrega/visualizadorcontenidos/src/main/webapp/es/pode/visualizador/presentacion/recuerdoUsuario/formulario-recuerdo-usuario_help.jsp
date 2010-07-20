<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="recuerdo.usuario.formulario.recuerdo.usuario"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="recuerdo.usuario.formulario.recuerdo.usuario"/></h1>
        <p>
            <bean:message key="recuerdo.usuario.formulario.recuerdo.usuario.online.help"/>
        </p>
        <h2><bean:message key="recuerdo.usuario.formulario.recuerdo.usuario.cancelar"/></h2>
        <p>
            <bean:message key="recuerdo.usuario.formulario.recuerdo.usuario.cancelar.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="recuerdo.usuario.formulario.recuerdo.usuario.aceptar"/></h2>
        <p>
            <bean:message key="recuerdo.usuario.formulario.recuerdo.usuario.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="recuerdo.usuario.formulario.recuerdo.usuario.aceptar.param.email"/></td>
                    <td><bean:message key="recuerdo.usuario.formulario.recuerdo.usuario.aceptar.param.email.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="recuerdo.usuario.formulario.recuerdo.usuario.aceptar.param.nif"/></td>
                    <td><bean:message key="recuerdo.usuario.formulario.recuerdo.usuario.aceptar.param.nif.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

