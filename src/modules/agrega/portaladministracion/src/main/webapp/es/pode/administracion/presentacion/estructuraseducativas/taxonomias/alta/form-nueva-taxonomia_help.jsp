<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="alta.taxonomias.form.nueva.taxonomia"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="alta.taxonomias.form.nueva.taxonomia"/></h1>
        <p>
            <bean:message key="alta.taxonomias.form.nueva.taxonomia.online.help"/>
        </p>
        <h2><bean:message key="alta.taxonomias.form.nueva.taxonomia.buscar"/></h2>
        <p>
            <bean:message key="alta.taxonomias.form.nueva.taxonomia.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="alta.taxonomias.form.nueva.taxonomia.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="alta.taxonomias.form.nueva.taxonomia.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="alta.taxonomias.form.nueva.taxonomia.submit"/></h2>
        <p>
            <bean:message key="alta.taxonomias.form.nueva.taxonomia.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="alta.taxonomias.form.nueva.taxonomia.submit.param.action"/></td>
                    <td><bean:message key="alta.taxonomias.form.nueva.taxonomia.submit.param.action.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="alta.taxonomias.form.nueva.taxonomia.submit.param.fichero1"/></td>
                    <td><bean:message key="alta.taxonomias.form.nueva.taxonomia.submit.param.fichero1.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="alta.taxonomias.form.nueva.taxonomia.submit.param.fichero2"/></td>
                    <td><bean:message key="alta.taxonomias.form.nueva.taxonomia.submit.param.fichero2.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="alta.taxonomias.form.nueva.taxonomia.submit.param.fichero3"/></td>
                    <td><bean:message key="alta.taxonomias.form.nueva.taxonomia.submit.param.fichero3.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="alta.taxonomias.form.nueva.taxonomia.submit.param.fichero4"/></td>
                    <td><bean:message key="alta.taxonomias.form.nueva.taxonomia.submit.param.fichero4.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="alta.taxonomias.form.nueva.taxonomia.submit.param.fichero5"/></td>
                    <td><bean:message key="alta.taxonomias.form.nueva.taxonomia.submit.param.fichero5.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

