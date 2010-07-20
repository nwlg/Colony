<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="asociar.url"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="asociar.url"/></h1>
        <p>
            <bean:message key="asociar.url.online.help"/>
        </p>
        <h2><bean:message key="asociar.url.submit"/></h2>
        <p>
            <bean:message key="asociar.url.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="even">
                    <td><bean:message key="asociar.url.submit.param.url"/></td>
                    <td><bean:message key="asociar.url.submit.param.url.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="asociar.url.submit.param.tipo"/></td>
                    <td><bean:message key="asociar.url.submit.param.tipo.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="asociar.url.estructura"/></h2>
        <p>
            <bean:message key="asociar.url.estructura.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="asociar.url.archivos"/></h2>
        <p>
            <bean:message key="asociar.url.archivos.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

