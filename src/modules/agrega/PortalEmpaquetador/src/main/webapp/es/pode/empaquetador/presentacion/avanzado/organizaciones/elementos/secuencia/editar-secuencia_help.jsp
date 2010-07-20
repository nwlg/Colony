<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="secuencia.editar.secuencia"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="secuencia.editar.secuencia"/></h1>
        <p>
            <bean:message key="secuencia.editar.secuencia.online.help"/>
        </p>
        <h2><bean:message key="secuencia.editar.secuencia.submit"/></h2>
        <p>
            <bean:message key="secuencia.editar.secuencia.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="secuencia.editar.secuencia.submit.param.choice"/></td>
                    <td><bean:message key="secuencia.editar.secuencia.submit.param.choice.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="secuencia.editar.secuencia.submit.param.choice.exit"/></td>
                    <td><bean:message key="secuencia.editar.secuencia.submit.param.choice.exit.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="secuencia.editar.secuencia.submit.param.flow"/></td>
                    <td><bean:message key="secuencia.editar.secuencia.submit.param.flow.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="secuencia.editar.secuencia.submit.param.forward.only"/></td>
                    <td><bean:message key="secuencia.editar.secuencia.submit.param.forward.only.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

