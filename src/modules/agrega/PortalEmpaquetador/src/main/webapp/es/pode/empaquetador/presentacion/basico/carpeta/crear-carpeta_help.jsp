<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="crear.carpeta.basico.crear.carpeta"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="crear.carpeta.basico.crear.carpeta"/></h1>
        <p>
            <bean:message key="crear.carpeta.basico.crear.carpeta.online.help"/>
        </p>
        <h2><bean:message key="crear.carpeta.basico.crear.carpeta.submit"/></h2>
        <p>
            <bean:message key="crear.carpeta.basico.crear.carpeta.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.carpeta.basico.crear.carpeta.submit.param.title"/></td>
                    <td><bean:message key="crear.carpeta.basico.crear.carpeta.submit.param.title.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

