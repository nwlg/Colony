<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="modificar.modificar"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="modificar.modificar"/></h1>
        <p>
            <bean:message key="modificar.modificar.online.help"/>
        </p>
        <h2><bean:message key="modificar.modificar.select.action"/></h2>
        <p>
            <bean:message key="modificar.modificar.select.action.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.modificar.select.action.param.accion"/></td>
                    <td><bean:message key="modificar.modificar.select.action.param.accion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.modificar.select.action.param.tag.old"/></td>
                    <td><bean:message key="modificar.modificar.select.action.param.tag.old.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.modificar.select.action.param.new.tag"/></td>
                    <td><bean:message key="modificar.modificar.select.action.param.new.tag.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

