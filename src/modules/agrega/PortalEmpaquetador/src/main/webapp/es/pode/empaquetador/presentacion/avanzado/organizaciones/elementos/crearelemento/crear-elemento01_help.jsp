<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="crear.elemento.crear.elemento01"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="crear.elemento.crear.elemento01"/></h1>
        <p>
            <bean:message key="crear.elemento.crear.elemento01.online.help"/>
        </p>
        <h2><bean:message key="crear.elemento.crear.elemento01.submit"/></h2>
        <p>
            <bean:message key="crear.elemento.crear.elemento01.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.elemento.crear.elemento01.submit.param.title"/></td>
                    <td><bean:message key="crear.elemento.crear.elemento01.submit.param.title.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.elemento.crear.elemento01.submit.param.referenciado"/></td>
                    <td><bean:message key="crear.elemento.crear.elemento01.submit.param.referenciado.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.elemento.crear.elemento01.submit.param.action"/></td>
                    <td><bean:message key="crear.elemento.crear.elemento01.submit.param.action.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.elemento.crear.elemento01.submit.param.time.limit.action"/></td>
                    <td><bean:message key="crear.elemento.crear.elemento01.submit.param.time.limit.action.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.elemento.crear.elemento01.submit.param.data.from.lms"/></td>
                    <td><bean:message key="crear.elemento.crear.elemento01.submit.param.data.from.lms.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.elemento.crear.elemento01.submit.param.completion.threshold"/></td>
                    <td><bean:message key="crear.elemento.crear.elemento01.submit.param.completion.threshold.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.elemento.crear.elemento01.submit.param.select.presentation"/></td>
                    <td><bean:message key="crear.elemento.crear.elemento01.submit.param.select.presentation.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.elemento.crear.elemento01.submit.param.is.visible"/></td>
                    <td><bean:message key="crear.elemento.crear.elemento01.submit.param.is.visible.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

