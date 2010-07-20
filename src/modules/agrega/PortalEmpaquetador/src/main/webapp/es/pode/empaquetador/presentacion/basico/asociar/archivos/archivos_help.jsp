<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="asociacion.archivos.archivos"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="asociacion.archivos.archivos"/></h1>
        <p>
            <bean:message key="asociacion.archivos.archivos.online.help"/>
        </p>
        <h2><bean:message key="asociacion.archivos.archivos.submit"/></h2>
        <p>
            <bean:message key="asociacion.archivos.archivos.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="asociacion.archivos.archivos.submit.param.action"/></td>
                    <td><bean:message key="asociacion.archivos.archivos.submit.param.action.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="asociacion.archivos.archivos.archivos"/></h2>
        <p>
            <bean:message key="asociacion.archivos.archivos.archivos.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="asociacion.archivos.archivos.archivos.param.identifier"/></td>
                    <td><bean:message key="asociacion.archivos.archivos.archivos.param.identifier.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="asociacion.archivos.archivos.estructura"/></h2>
        <p>
            <bean:message key="asociacion.archivos.archivos.estructura.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="asociacion.archivos.archivos.estructura.param.identifier"/></td>
                    <td><bean:message key="asociacion.archivos.archivos.estructura.param.identifier.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

