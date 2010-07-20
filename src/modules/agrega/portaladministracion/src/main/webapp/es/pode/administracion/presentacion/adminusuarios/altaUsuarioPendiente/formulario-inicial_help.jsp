<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="alta.usuario.pendiente.formulario.inicial"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="alta.usuario.pendiente.formulario.inicial"/></h1>
        <p>
            <bean:message key="alta.usuario.pendiente.formulario.inicial.online.help"/>
        </p>
        <h2><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar"/></h2>
        <p>
            <bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.nombre"/></td>
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.nombre.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.apellido1"/></td>
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.apellido1.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.apellido2"/></td>
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.apellido2.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.email"/></td>
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.email.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.nif"/></td>
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.nif.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.usuario"/></td>
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.usuario.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.clave"/></td>
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.clave.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.repita.clave"/></td>
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.repita.clave.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.idioma"/></td>
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.idioma.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.idioma.busqueda"/></td>
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.idioma.busqueda.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.tipo.empaquetador"/></td>
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.tipo.empaquetador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.id"/></td>
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.id.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.open.id.url"/></td>
                    <td><bean:message key="alta.usuario.pendiente.formulario.inicial.continuar.param.open.id.url.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="alta.usuario.pendiente.formulario.inicial.cancelar"/></h2>
        <p>
            <bean:message key="alta.usuario.pendiente.formulario.inicial.cancelar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

