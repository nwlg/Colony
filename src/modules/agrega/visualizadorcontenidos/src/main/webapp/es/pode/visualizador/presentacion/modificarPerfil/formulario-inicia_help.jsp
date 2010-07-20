<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="modificar.perfil.formulario.inicia"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="modificar.perfil.formulario.inicia"/></h1>
        <p>
            <bean:message key="modificar.perfil.formulario.inicia.online.help"/>
        </p>
        <h2><bean:message key="modificar.perfil.formulario.inicia.aceptar"/></h2>
        <p>
            <bean:message key="modificar.perfil.formulario.inicia.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.id"/></td>
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.id.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.tipo.empaquetador"/></td>
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.tipo.empaquetador.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.idioma.busqueda"/></td>
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.idioma.busqueda.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.idioma"/></td>
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.repita.clave"/></td>
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.repita.clave.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.clave"/></td>
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.clave.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.email"/></td>
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.email.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.nif"/></td>
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.nif.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.apellido2"/></td>
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.apellido2.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.apellido1"/></td>
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.apellido1.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.nombre"/></td>
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.nombre.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.tipo.catalogador"/></td>
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.tipo.catalogador.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.cuota"/></td>
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.cuota.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.open.id.url"/></td>
                    <td><bean:message key="modificar.perfil.formulario.inicia.aceptar.param.open.id.url.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="modificar.perfil.formulario.inicia.cancelar"/></h2>
        <p>
            <bean:message key="modificar.perfil.formulario.inicia.cancelar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

