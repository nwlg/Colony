<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="listar.usuarios.inactivos.formulario.listado.usuarios.inactivos"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="listar.usuarios.inactivos.formulario.listado.usuarios.inactivos"/></h1>
        <p>
            <bean:message key="listar.usuarios.inactivos.formulario.listado.usuarios.inactivos.online.help"/>
        </p>
        <h2><bean:message key="listar.usuarios.inactivos.formulario.listado.usuarios.inactivos.ver.usuario.inactivo"/></h2>
        <p>
            <bean:message key="listar.usuarios.inactivos.formulario.listado.usuarios.inactivos.ver.usuario.inactivo.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.usuarios.inactivos.formulario.listado.usuarios.inactivos.ver.usuario.inactivo.param.id"/></td>
                    <td><bean:message key="listar.usuarios.inactivos.formulario.listado.usuarios.inactivos.ver.usuario.inactivo.param.id.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="listar.usuarios.inactivos.formulario.listado.usuarios.inactivos.listar.usuarios"/></h2>
        <p>
            <bean:message key="listar.usuarios.inactivos.formulario.listado.usuarios.inactivos.listar.usuarios.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="listar.usuarios.inactivos.formulario.listado.usuarios.inactivos.activar.usuario"/></h2>
        <p>
            <bean:message key="listar.usuarios.inactivos.formulario.listado.usuarios.inactivos.activar.usuario.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.usuarios.inactivos.formulario.listado.usuarios.inactivos.activar.usuario.param.id"/></td>
                    <td><bean:message key="listar.usuarios.inactivos.formulario.listado.usuarios.inactivos.activar.usuario.param.id.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="listar.usuarios.inactivos.formulario.listado.usuarios.inactivos.listar.usuarios.pendientes"/></h2>
        <p>
            <bean:message key="listar.usuarios.inactivos.formulario.listado.usuarios.inactivos.listar.usuarios.pendientes.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

