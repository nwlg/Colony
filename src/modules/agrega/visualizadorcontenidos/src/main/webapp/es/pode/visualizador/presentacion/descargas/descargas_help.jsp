<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="descargas.descargas"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="descargas.descargas"/></h1>
        <p>
            <bean:message key="descargas.descargas.online.help"/>
        </p>
        <h2><bean:message key="descargas.descargas.descarga"/></h2>
        <p>
            <bean:message key="descargas.descargas.descarga.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descargas.descargas.descarga.param.identificador"/></td>
                    <td><bean:message key="descargas.descargas.descarga.param.identificador.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="descargas.descargas.descarga"/></h2>
        <p>
            <bean:message key="descargas.descargas.descarga.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descargas.descargas.descarga.param.identificador"/></td>
                    <td><bean:message key="descargas.descargas.descarga.param.identificador.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

