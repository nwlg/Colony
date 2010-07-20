<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="crear.descarga.crear.descarga"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="crear.descarga.crear.descarga"/></h1>
        <p>
            <bean:message key="crear.descarga.crear.descarga.online.help"/>
        </p>
        <h2><bean:message key="crear.descarga.crear.descarga.submit"/></h2>
        <p>
            <bean:message key="crear.descarga.crear.descarga.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.path"/></td>
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.path.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.action"/></td>
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.action.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.descripcion.es"/></td>
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.descripcion.es.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.titulo.es"/></td>
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.titulo.es.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.descripcion.ca"/></td>
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.descripcion.ca.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.descripcion.en"/></td>
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.descripcion.en.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.descripcion.eu"/></td>
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.descripcion.eu.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.descripcion.gl"/></td>
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.descripcion.gl.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.descripcion.va"/></td>
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.descripcion.va.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.titulo.ca"/></td>
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.titulo.ca.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.titulo.en"/></td>
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.titulo.en.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.titulo.eu"/></td>
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.titulo.eu.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.titulo.gl"/></td>
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.titulo.gl.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.titulo.va"/></td>
                    <td><bean:message key="crear.descarga.crear.descarga.submit.param.titulo.va.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

