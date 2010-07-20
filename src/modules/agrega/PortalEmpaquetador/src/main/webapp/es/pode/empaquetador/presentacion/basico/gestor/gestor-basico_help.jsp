<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="gestor.basico.gestor.basico"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="gestor.basico.gestor.basico"/></h1>
        <p>
            <bean:message key="gestor.basico.gestor.basico.online.help"/>
        </p>
        <h2><bean:message key="gestor.basico.gestor.basico.vista.carpeta"/></h2>
        <p>
            <bean:message key="gestor.basico.gestor.basico.vista.carpeta.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="gestor.basico.gestor.basico.vista.carpeta.param.vista.carpeta"/></td>
                    <td><bean:message key="gestor.basico.gestor.basico.vista.carpeta.param.vista.carpeta.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="gestor.basico.gestor.basico.vaciar.portapapeles"/></h2>
        <p>
            <bean:message key="gestor.basico.gestor.basico.vaciar.portapapeles.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="gestor.basico.gestor.basico.secuencia"/></h2>
        <p>
            <bean:message key="gestor.basico.gestor.basico.secuencia.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="gestor.basico.gestor.basico.catalogar"/></h2>
        <p>
            <bean:message key="gestor.basico.gestor.basico.catalogar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="gestor.basico.gestor.basico.catalogar.param.identifier"/></td>
                    <td><bean:message key="gestor.basico.gestor.basico.catalogar.param.identifier.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="gestor.basico.gestor.basico.catalogar.param.return.url"/></td>
                    <td><bean:message key="gestor.basico.gestor.basico.catalogar.param.return.url.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="gestor.basico.gestor.basico.archivos"/></h2>
        <p>
            <bean:message key="gestor.basico.gestor.basico.archivos.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="gestor.basico.gestor.basico.guardar"/></h2>
        <p>
            <bean:message key="gestor.basico.gestor.basico.guardar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="gestor.basico.gestor.basico.guardar.param.return.url"/></td>
                    <td><bean:message key="gestor.basico.gestor.basico.guardar.param.return.url.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

