<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="alta.nodo.formulario"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="alta.nodo.formulario"/></h1>
        <p>
            <bean:message key="alta.nodo.formulario.online.help"/>
        </p>
        <h2><bean:message key="alta.nodo.formulario.cancelar"/></h2>
        <p>
            <bean:message key="alta.nodo.formulario.cancelar.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="alta.nodo.formulario.aceptar"/></h2>
        <p>
            <bean:message key="alta.nodo.formulario.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="alta.nodo.formulario.aceptar.param.nodo"/></td>
                    <td><bean:message key="alta.nodo.formulario.aceptar.param.nodo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="alta.nodo.formulario.aceptar.param.url"/></td>
                    <td><bean:message key="alta.nodo.formulario.aceptar.param.url.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="alta.nodo.formulario.aceptar.param.puerto"/></td>
                    <td><bean:message key="alta.nodo.formulario.aceptar.param.puerto.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="alta.nodo.formulario.aceptar.param.comunidad"/></td>
                    <td><bean:message key="alta.nodo.formulario.aceptar.param.comunidad.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="alta.nodo.formulario.aceptar.param.url.ws"/></td>
                    <td><bean:message key="alta.nodo.formulario.aceptar.param.url.ws.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

