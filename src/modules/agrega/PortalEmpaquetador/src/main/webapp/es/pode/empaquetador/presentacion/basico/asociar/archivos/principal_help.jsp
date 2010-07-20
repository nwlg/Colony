<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="asociacion.archivos.principal"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="asociacion.archivos.principal"/></h1>
        <p>
            <bean:message key="asociacion.archivos.principal.online.help"/>
        </p>
        <h2><bean:message key="asociacion.archivos.principal.submit"/></h2>
        <p>
            <bean:message key="asociacion.archivos.principal.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="asociacion.archivos.principal.submit.param.principal"/></td>
                    <td><bean:message key="asociacion.archivos.principal.submit.param.principal.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="asociacion.archivos.principal.submit.param.action"/></td>
                    <td><bean:message key="asociacion.archivos.principal.submit.param.action.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

