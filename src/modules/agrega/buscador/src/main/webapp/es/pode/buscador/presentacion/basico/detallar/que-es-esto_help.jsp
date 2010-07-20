<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="detallar.odecu.que.es.esto"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="detallar.odecu.que.es.esto"/></h1>
        <p>
            <bean:message key="detallar.odecu.que.es.esto.online.help"/>
        </p>
        <h2><bean:message key="detallar.odecu.que.es.esto.volver.detalle"/></h2>
        <p>
            <bean:message key="detallar.odecu.que.es.esto.volver.detalle.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.que.es.esto.volver.detalle.param.mostrar.vuelta"/></td>
                    <td><bean:message key="detallar.odecu.que.es.esto.volver.detalle.param.mostrar.vuelta.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

