<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="modificar.faq.modificar.dos"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="modificar.faq.modificar.dos"/></h1>
        <p>
            <bean:message key="modificar.faq.modificar.dos.online.help"/>
        </p>
        <h2><bean:message key="modificar.faq.modificar.dos.validar.formu"/></h2>
        <p>
            <bean:message key="modificar.faq.modificar.dos.validar.formu.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.faq.modificar.dos.validar.formu.param.id"/></td>
                    <td><bean:message key="modificar.faq.modificar.dos.validar.formu.param.id.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.faq.modificar.dos.validar.formu.param.categoria"/></td>
                    <td><bean:message key="modificar.faq.modificar.dos.validar.formu.param.categoria.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.faq.modificar.dos.validar.formu.param.castellano"/></td>
                    <td><bean:message key="modificar.faq.modificar.dos.validar.formu.param.castellano.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.faq.modificar.dos.validar.formu.param.ingles"/></td>
                    <td><bean:message key="modificar.faq.modificar.dos.validar.formu.param.ingles.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.faq.modificar.dos.validar.formu.param.catalan"/></td>
                    <td><bean:message key="modificar.faq.modificar.dos.validar.formu.param.catalan.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.faq.modificar.dos.validar.formu.param.valenciano"/></td>
                    <td><bean:message key="modificar.faq.modificar.dos.validar.formu.param.valenciano.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.faq.modificar.dos.validar.formu.param.gallego"/></td>
                    <td><bean:message key="modificar.faq.modificar.dos.validar.formu.param.gallego.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.faq.modificar.dos.validar.formu.param.euskera"/></td>
                    <td><bean:message key="modificar.faq.modificar.dos.validar.formu.param.euskera.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="modificar.faq.modificar.dos.volver"/></h2>
        <p>
            <bean:message key="modificar.faq.modificar.dos.volver.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.faq.modificar.dos.volver.param.id"/></td>
                    <td><bean:message key="modificar.faq.modificar.dos.volver.param.id.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.faq.modificar.dos.volver.param.categoria"/></td>
                    <td><bean:message key="modificar.faq.modificar.dos.volver.param.categoria.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

