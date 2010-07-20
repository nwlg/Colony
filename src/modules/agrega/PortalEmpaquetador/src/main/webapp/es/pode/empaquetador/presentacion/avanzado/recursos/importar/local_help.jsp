<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="importar.recursos.local"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="importar.recursos.local"/></h1>
        <p>
            <bean:message key="importar.recursos.local.online.help"/>
        </p>
        <h2><bean:message key="importar.recursos.local.aceptar"/></h2>
        <p>
            <bean:message key="importar.recursos.local.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="importar.recursos.local.aceptar.param.fichero"/></td>
                    <td><bean:message key="importar.recursos.local.aceptar.param.fichero.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="importar.recursos.local.aceptar.param.action"/></td>
                    <td><bean:message key="importar.recursos.local.aceptar.param.action.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

