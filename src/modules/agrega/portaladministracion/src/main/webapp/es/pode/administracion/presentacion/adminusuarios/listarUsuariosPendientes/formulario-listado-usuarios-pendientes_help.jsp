<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="listar.usuarios.pendientes.formulario.listado.usuarios.pendientes"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="listar.usuarios.pendientes.formulario.listado.usuarios.pendientes"/></h1>
        <p>
            <bean:message key="listar.usuarios.pendientes.formulario.listado.usuarios.pendientes.online.help"/>
        </p>
        <h2><bean:message key="listar.usuarios.pendientes.formulario.listado.usuarios.pendientes.alta"/></h2>
        <p>
            <bean:message key="listar.usuarios.pendientes.formulario.listado.usuarios.pendientes.alta.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.usuarios.pendientes.formulario.listado.usuarios.pendientes.alta.param.id"/></td>
                    <td><bean:message key="listar.usuarios.pendientes.formulario.listado.usuarios.pendientes.alta.param.id.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="listar.usuarios.pendientes.formulario.listado.usuarios.pendientes.listar.usuarios"/></h2>
        <p>
            <bean:message key="listar.usuarios.pendientes.formulario.listado.usuarios.pendientes.listar.usuarios.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="listar.usuarios.pendientes.formulario.listado.usuarios.pendientes.ver.usuario.pendiente"/></h2>
        <p>
            <bean:message key="listar.usuarios.pendientes.formulario.listado.usuarios.pendientes.ver.usuario.pendiente.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.usuarios.pendientes.formulario.listado.usuarios.pendientes.ver.usuario.pendiente.param.id"/></td>
                    <td><bean:message key="listar.usuarios.pendientes.formulario.listado.usuarios.pendientes.ver.usuario.pendiente.param.id.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="listar.usuarios.pendientes.formulario.listado.usuarios.pendientes.listar.usuarios.inactivos"/></h2>
        <p>
            <bean:message key="listar.usuarios.pendientes.formulario.listado.usuarios.pendientes.listar.usuarios.inactivos.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

