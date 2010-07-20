<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="modificar.faq.modificar.uno"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="modificar.faq.modificar.uno"/></h1>
        <p>
            <bean:message key="modificar.faq.modificar.uno.online.help"/>
        </p>
        <h2><bean:message key="modificar.faq.modificar.uno.aceptar"/></h2>
        <p>
            <bean:message key="modificar.faq.modificar.uno.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.faq.modificar.uno.aceptar.param.id"/></td>
                    <td><bean:message key="modificar.faq.modificar.uno.aceptar.param.id.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.faq.modificar.uno.aceptar.param.categoria"/></td>
                    <td><bean:message key="modificar.faq.modificar.uno.aceptar.param.categoria.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

