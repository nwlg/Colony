<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="indicar.ruta.indicar.ruta"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="indicar.ruta.indicar.ruta"/></h1>
        <p>
            <bean:message key="indicar.ruta.indicar.ruta.online.help"/>
        </p>
        <h2><bean:message key="indicar.ruta.indicar.ruta.buscar"/></h2>
        <p>
            <bean:message key="indicar.ruta.indicar.ruta.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="indicar.ruta.indicar.ruta.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="indicar.ruta.indicar.ruta.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="indicar.ruta.indicar.ruta.select.action"/></h2>
        <p>
            <bean:message key="indicar.ruta.indicar.ruta.select.action.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="indicar.ruta.indicar.ruta.select.action.param.action"/></td>
                    <td><bean:message key="indicar.ruta.indicar.ruta.select.action.param.action.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="indicar.ruta.indicar.ruta.select.action.param.path"/></td>
                    <td><bean:message key="indicar.ruta.indicar.ruta.select.action.param.path.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

