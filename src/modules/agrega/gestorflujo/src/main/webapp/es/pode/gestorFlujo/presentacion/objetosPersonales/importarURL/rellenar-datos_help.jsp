<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="importar.urlcu.rellenar.datos"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="importar.urlcu.rellenar.datos"/></h1>
        <p>
            <bean:message key="importar.urlcu.rellenar.datos.online.help"/>
        </p>
        <h2><bean:message key="importar.urlcu.rellenar.datos.submit"/></h2>
        <p>
            <bean:message key="importar.urlcu.rellenar.datos.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="importar.urlcu.rellenar.datos.submit.param.url"/></td>
                    <td><bean:message key="importar.urlcu.rellenar.datos.submit.param.url.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="importar.urlcu.rellenar.datos.submit.param.comentarios"/></td>
                    <td><bean:message key="importar.urlcu.rellenar.datos.submit.param.comentarios.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="importar.urlcu.rellenar.datos.submit.param.titulo"/></td>
                    <td><bean:message key="importar.urlcu.rellenar.datos.submit.param.titulo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="importar.urlcu.rellenar.datos.submit.param.idioma"/></td>
                    <td><bean:message key="importar.urlcu.rellenar.datos.submit.param.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="importar.urlcu.rellenar.datos.submit.param.idioma.destinatario"/></td>
                    <td><bean:message key="importar.urlcu.rellenar.datos.submit.param.idioma.destinatario.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="importar.urlcu.rellenar.datos.submit.param.action"/></td>
                    <td><bean:message key="importar.urlcu.rellenar.datos.submit.param.action.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="importar.urlcu.rellenar.datos.submit.param.tipo"/></td>
                    <td><bean:message key="importar.urlcu.rellenar.datos.submit.param.tipo.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

