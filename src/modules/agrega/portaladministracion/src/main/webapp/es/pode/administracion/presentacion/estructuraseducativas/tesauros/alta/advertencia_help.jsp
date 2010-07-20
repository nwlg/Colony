<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="alta.tesauros.advertencia"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="alta.tesauros.advertencia"/></h1>
        <p>
            <bean:message key="alta.tesauros.advertencia.online.help"/>
        </p>
        <h2><bean:message key="alta.tesauros.advertencia.submit.advertencia"/></h2>
        <p>
            <bean:message key="alta.tesauros.advertencia.submit.advertencia.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="alta.tesauros.advertencia.submit.advertencia.param.action"/></td>
                    <td><bean:message key="alta.tesauros.advertencia.submit.advertencia.param.action.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="alta.tesauros.advertencia.buscar"/></h2>
        <p>
            <bean:message key="alta.tesauros.advertencia.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="alta.tesauros.advertencia.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="alta.tesauros.advertencia.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

