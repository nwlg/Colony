<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="exportar.lomes.lomes.no.valido"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="exportar.lomes.lomes.no.valido"/></h1>
        <p>
            <bean:message key="exportar.lomes.lomes.no.valido.online.help"/>
        </p>
        <h2><bean:message key="exportar.lomes.lomes.no.valido.volver"/></h2>
        <p>
            <bean:message key="exportar.lomes.lomes.no.valido.volver.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="exportar.lomes.lomes.no.valido.volver.param.regreso"/></td>
                    <td><bean:message key="exportar.lomes.lomes.no.valido.volver.param.regreso.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

