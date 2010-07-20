<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="editar.secuencia.secuencia"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="editar.secuencia.secuencia"/></h1>
        <p>
            <bean:message key="editar.secuencia.secuencia.online.help"/>
        </p>
        <h2><bean:message key="editar.secuencia.secuencia.aceptar"/></h2>
        <p>
            <bean:message key="editar.secuencia.secuencia.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="editar.secuencia.secuencia.aceptar.param.choice"/></td>
                    <td><bean:message key="editar.secuencia.secuencia.aceptar.param.choice.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="editar.secuencia.secuencia.aceptar.param.choice.exit"/></td>
                    <td><bean:message key="editar.secuencia.secuencia.aceptar.param.choice.exit.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="editar.secuencia.secuencia.aceptar.param.flow"/></td>
                    <td><bean:message key="editar.secuencia.secuencia.aceptar.param.flow.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="editar.secuencia.secuencia.aceptar.param.forward.only"/></td>
                    <td><bean:message key="editar.secuencia.secuencia.aceptar.param.forward.only.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

