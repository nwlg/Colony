<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="alta.arboles.form.nuevo.arbol"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="alta.arboles.form.nuevo.arbol"/></h1>
        <p>
            <bean:message key="alta.arboles.form.nuevo.arbol.online.help"/>
        </p>
        <h2><bean:message key="alta.arboles.form.nuevo.arbol.buscar"/></h2>
        <p>
            <bean:message key="alta.arboles.form.nuevo.arbol.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="alta.arboles.form.nuevo.arbol.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="alta.arboles.form.nuevo.arbol.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="alta.arboles.form.nuevo.arbol.submit"/></h2>
        <p>
            <bean:message key="alta.arboles.form.nuevo.arbol.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="alta.arboles.form.nuevo.arbol.submit.param.action"/></td>
                    <td><bean:message key="alta.arboles.form.nuevo.arbol.submit.param.action.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="alta.arboles.form.nuevo.arbol.submit.param.fichero1"/></td>
                    <td><bean:message key="alta.arboles.form.nuevo.arbol.submit.param.fichero1.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="alta.arboles.form.nuevo.arbol.submit.param.fichero2"/></td>
                    <td><bean:message key="alta.arboles.form.nuevo.arbol.submit.param.fichero2.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="alta.arboles.form.nuevo.arbol.submit.param.fichero3"/></td>
                    <td><bean:message key="alta.arboles.form.nuevo.arbol.submit.param.fichero3.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="alta.arboles.form.nuevo.arbol.submit.param.fichero4"/></td>
                    <td><bean:message key="alta.arboles.form.nuevo.arbol.submit.param.fichero4.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="alta.arboles.form.nuevo.arbol.submit.param.fichero5"/></td>
                    <td><bean:message key="alta.arboles.form.nuevo.arbol.submit.param.fichero5.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

