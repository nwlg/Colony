<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="modificar.grupo.resultado.modificar.grupo"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="modificar.grupo.resultado.modificar.grupo"/></h1>
        <p>
            <bean:message key="modificar.grupo.resultado.modificar.grupo.online.help"/>
        </p>
        <h2><bean:message key="modificar.grupo.resultado.modificar.grupo.aceptar"/></h2>
        <p>
            <bean:message key="modificar.grupo.resultado.modificar.grupo.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.grupo.resultado.modificar.grupo.aceptar.param.id.modificado"/></td>
                    <td><bean:message key="modificar.grupo.resultado.modificar.grupo.aceptar.param.id.modificado.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

