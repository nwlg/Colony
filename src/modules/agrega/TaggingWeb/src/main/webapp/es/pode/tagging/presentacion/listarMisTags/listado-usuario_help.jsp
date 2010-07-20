<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="listar.mis.tags.listado.usuario"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="listar.mis.tags.listado.usuario"/></h1>
        <p>
            <bean:message key="listar.mis.tags.listado.usuario.online.help"/>
        </p>
        <h2><bean:message key="listar.mis.tags.listado.usuario.mostrar.odes"/></h2>
        <p>
            <bean:message key="listar.mis.tags.listado.usuario.mostrar.odes.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.mis.tags.listado.usuario.mostrar.odes.param.tag"/></td>
                    <td><bean:message key="listar.mis.tags.listado.usuario.mostrar.odes.param.tag.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="listar.mis.tags.listado.usuario.modificar.tag"/></h2>
        <p>
            <bean:message key="listar.mis.tags.listado.usuario.modificar.tag.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.mis.tags.listado.usuario.modificar.tag.param.tag"/></td>
                    <td><bean:message key="listar.mis.tags.listado.usuario.modificar.tag.param.tag.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

