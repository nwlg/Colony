<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="listar.tag.listado.tags"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="listar.tag.listado.tags"/></h1>
        <p>
            <bean:message key="listar.tag.listado.tags.online.help"/>
        </p>
        <h2><bean:message key="listar.tag.listado.tags.mostrar.odes"/></h2>
        <p>
            <bean:message key="listar.tag.listado.tags.mostrar.odes.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.tag.listado.tags.mostrar.odes.param.tag"/></td>
                    <td><bean:message key="listar.tag.listado.tags.mostrar.odes.param.tag.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="listar.tag.listado.tags.modificar"/></h2>
        <p>
            <bean:message key="listar.tag.listado.tags.modificar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.tag.listado.tags.modificar.param.tag"/></td>
                    <td><bean:message key="listar.tag.listado.tags.modificar.param.tag.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

