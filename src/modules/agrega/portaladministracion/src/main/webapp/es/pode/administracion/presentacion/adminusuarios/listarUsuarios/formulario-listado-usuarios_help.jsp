<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="listar.usuarios.formulario.listado.usuarios"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="listar.usuarios.formulario.listado.usuarios"/></h1>
        <p>
            <bean:message key="listar.usuarios.formulario.listado.usuarios.online.help"/>
        </p>
        <h2><bean:message key="listar.usuarios.formulario.listado.usuarios.crear.usuario"/></h2>
        <p>
            <bean:message key="listar.usuarios.formulario.listado.usuarios.crear.usuario.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="listar.usuarios.formulario.listado.usuarios.listar.usuarios.pendientes"/></h2>
        <p>
            <bean:message key="listar.usuarios.formulario.listado.usuarios.listar.usuarios.pendientes.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="listar.usuarios.formulario.listado.usuarios.desactivar.usuario"/></h2>
        <p>
            <bean:message key="listar.usuarios.formulario.listado.usuarios.desactivar.usuario.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.usuarios.formulario.listado.usuarios.desactivar.usuario.param.id"/></td>
                    <td><bean:message key="listar.usuarios.formulario.listado.usuarios.desactivar.usuario.param.id.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="listar.usuarios.formulario.listado.usuarios.listar.usuarios.pendientes"/></h2>
        <p>
            <bean:message key="listar.usuarios.formulario.listado.usuarios.listar.usuarios.pendientes.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="listar.usuarios.formulario.listado.usuarios.listar.usuarios.inactivos"/></h2>
        <p>
            <bean:message key="listar.usuarios.formulario.listado.usuarios.listar.usuarios.inactivos.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

