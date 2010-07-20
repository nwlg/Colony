<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="eliminar.submanifiestos.advertencia"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="eliminar.submanifiestos.advertencia"/></h1>
        <p>
            <bean:message key="eliminar.submanifiestos.advertencia.online.help"/>
        </p>
        <h2><bean:message key="eliminar.submanifiestos.advertencia.aceptar"/></h2>
        <p>
            <bean:message key="eliminar.submanifiestos.advertencia.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="eliminar.submanifiestos.advertencia.aceptar.param.action"/></td>
                    <td><bean:message key="eliminar.submanifiestos.advertencia.aceptar.param.action.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="eliminar.submanifiestos.advertencia.aceptar.param.identificadores"/></td>
                    <td><bean:message key="eliminar.submanifiestos.advertencia.aceptar.param.identificadores.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

