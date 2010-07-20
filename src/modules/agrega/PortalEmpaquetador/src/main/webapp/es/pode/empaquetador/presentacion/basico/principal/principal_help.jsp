<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="principal.principal"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="principal.principal"/></h1>
        <p>
            <bean:message key="principal.principal.online.help"/>
        </p>
        <h2><bean:message key="principal.principal.submit"/></h2>
        <p>
            <bean:message key="principal.principal.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="principal.principal.submit.param.principal"/></td>
                    <td><bean:message key="principal.principal.submit.param.principal.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

