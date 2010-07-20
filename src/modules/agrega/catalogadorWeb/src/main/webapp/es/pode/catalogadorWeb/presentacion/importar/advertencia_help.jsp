<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="importar.lomes.advertencia"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="importar.lomes.advertencia"/></h1>
        <p>
            <bean:message key="importar.lomes.advertencia.online.help"/>
        </p>
        <h2><bean:message key="importar.lomes.advertencia.submit.advertencia"/></h2>
        <p>
            <bean:message key="importar.lomes.advertencia.submit.advertencia.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="importar.lomes.advertencia.submit.advertencia.param.accion"/></td>
                    <td><bean:message key="importar.lomes.advertencia.submit.advertencia.param.accion.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

