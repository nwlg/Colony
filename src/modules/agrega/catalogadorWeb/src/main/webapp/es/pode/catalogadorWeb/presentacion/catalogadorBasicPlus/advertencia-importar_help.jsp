<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="catalogador.basic.plus.advertencia.importar"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="catalogador.basic.plus.advertencia.importar"/></h1>
        <p>
            <bean:message key="catalogador.basic.plus.advertencia.importar.online.help"/>
        </p>
        <h2><bean:message key="catalogador.basic.plus.advertencia.importar.submit"/></h2>
        <p>
            <bean:message key="catalogador.basic.plus.advertencia.importar.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="catalogador.basic.plus.advertencia.importar.submit.param.accion"/></td>
                    <td><bean:message key="catalogador.basic.plus.advertencia.importar.submit.param.accion.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

