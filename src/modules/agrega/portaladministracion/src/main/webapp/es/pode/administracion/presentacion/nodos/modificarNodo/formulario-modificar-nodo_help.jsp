<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="modificar.nodo.formulario.modificar.nodo"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="modificar.nodo.formulario.modificar.nodo"/></h1>
        <p>
            <bean:message key="modificar.nodo.formulario.modificar.nodo.online.help"/>
        </p>
        <h2><bean:message key="modificar.nodo.formulario.modificar.nodo.cancelar"/></h2>
        <p>
            <bean:message key="modificar.nodo.formulario.modificar.nodo.cancelar.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="modificar.nodo.formulario.modificar.nodo.aceptar"/></h2>
        <p>
            <bean:message key="modificar.nodo.formulario.modificar.nodo.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.nodo.formulario.modificar.nodo.aceptar.param.id"/></td>
                    <td><bean:message key="modificar.nodo.formulario.modificar.nodo.aceptar.param.id.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.nodo.formulario.modificar.nodo.aceptar.param.nodo"/></td>
                    <td><bean:message key="modificar.nodo.formulario.modificar.nodo.aceptar.param.nodo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.nodo.formulario.modificar.nodo.aceptar.param.url"/></td>
                    <td><bean:message key="modificar.nodo.formulario.modificar.nodo.aceptar.param.url.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.nodo.formulario.modificar.nodo.aceptar.param.puerto"/></td>
                    <td><bean:message key="modificar.nodo.formulario.modificar.nodo.aceptar.param.puerto.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.nodo.formulario.modificar.nodo.aceptar.param.ccaa"/></td>
                    <td><bean:message key="modificar.nodo.formulario.modificar.nodo.aceptar.param.ccaa.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.nodo.formulario.modificar.nodo.aceptar.param.url.ws"/></td>
                    <td><bean:message key="modificar.nodo.formulario.modificar.nodo.aceptar.param.url.ws.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.nodo.formulario.modificar.nodo.aceptar.param.id.nodo"/></td>
                    <td><bean:message key="modificar.nodo.formulario.modificar.nodo.aceptar.param.id.nodo.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

