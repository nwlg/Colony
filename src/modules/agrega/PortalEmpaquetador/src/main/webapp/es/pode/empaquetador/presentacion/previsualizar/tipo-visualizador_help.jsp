<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="previsualizar.tipo.visualizador"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="previsualizar.tipo.visualizador"/></h1>
        <p>
            <bean:message key="previsualizar.tipo.visualizador.online.help"/>
        </p>
        <h2><bean:message key="previsualizar.tipo.visualizador.aceptar"/></h2>
        <p>
            <bean:message key="previsualizar.tipo.visualizador.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="previsualizar.tipo.visualizador.aceptar.param.tipo.visualizador"/></td>
                    <td><bean:message key="previsualizar.tipo.visualizador.aceptar.param.tipo.visualizador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="previsualizar.tipo.visualizador.aceptar.param.action"/></td>
                    <td><bean:message key="previsualizar.tipo.visualizador.aceptar.param.action.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

