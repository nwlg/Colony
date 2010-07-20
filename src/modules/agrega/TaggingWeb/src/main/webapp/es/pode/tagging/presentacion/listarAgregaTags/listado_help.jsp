<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="listar.agrega.tags.listado"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="listar.agrega.tags.listado"/></h1>
        <p>
            <bean:message key="listar.agrega.tags.listado.online.help"/>
        </p>
        <h2><bean:message key="listar.agrega.tags.listado.mostrar.odes.agrega"/></h2>
        <p>
            <bean:message key="listar.agrega.tags.listado.mostrar.odes.agrega.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.agrega.tags.listado.mostrar.odes.agrega.param.tag"/></td>
                    <td><bean:message key="listar.agrega.tags.listado.mostrar.odes.agrega.param.tag.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

