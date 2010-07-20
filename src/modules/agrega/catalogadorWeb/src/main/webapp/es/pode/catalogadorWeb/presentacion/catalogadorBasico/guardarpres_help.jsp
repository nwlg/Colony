<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="catalogador.basico.guardarpres"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="catalogador.basico.guardarpres"/></h1>
        <p>
            <bean:message key="catalogador.basico.guardarpres.online.help"/>
        </p>
        <h2><bean:message key="catalogador.basico.guardarpres.aceptar.guardar"/></h2>
        <p>
            <bean:message key="catalogador.basico.guardarpres.aceptar.guardar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="catalogador.basico.guardarpres.aceptar.guardar.param.titulo"/></td>
                    <td><bean:message key="catalogador.basico.guardarpres.aceptar.guardar.param.titulo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="catalogador.basico.guardarpres.aceptar.guardar.param.idioma"/></td>
                    <td><bean:message key="catalogador.basico.guardarpres.aceptar.guardar.param.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="catalogador.basico.guardarpres.aceptar.guardar.param.descripcion"/></td>
                    <td><bean:message key="catalogador.basico.guardarpres.aceptar.guardar.param.descripcion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="catalogador.basico.guardarpres.aceptar.guardar.param.tipo.recurso"/></td>
                    <td><bean:message key="catalogador.basico.guardarpres.aceptar.guardar.param.tipo.recurso.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="catalogador.basico.guardarpres.aceptar.guardar.param.contexto"/></td>
                    <td><bean:message key="catalogador.basico.guardarpres.aceptar.guardar.param.contexto.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="catalogador.basico.guardarpres.aceptar.guardar.param.edad"/></td>
                    <td><bean:message key="catalogador.basico.guardarpres.aceptar.guardar.param.edad.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="catalogador.basico.guardarpres.aceptar.guardar.param.idioma.destinatario"/></td>
                    <td><bean:message key="catalogador.basico.guardarpres.aceptar.guardar.param.idioma.destinatario.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="catalogador.basico.guardarpres.aceptar.guardar.param.proceso.cognitivo"/></td>
                    <td><bean:message key="catalogador.basico.guardarpres.aceptar.guardar.param.proceso.cognitivo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="catalogador.basico.guardarpres.aceptar.guardar.param.identificador"/></td>
                    <td><bean:message key="catalogador.basico.guardarpres.aceptar.guardar.param.identificador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="catalogador.basico.guardarpres.aceptar.guardar.param.usuario"/></td>
                    <td><bean:message key="catalogador.basico.guardarpres.aceptar.guardar.param.usuario.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="catalogador.basico.guardarpres.aceptar.guardar.param.arboles"/></td>
                    <td><bean:message key="catalogador.basico.guardarpres.aceptar.guardar.param.arboles.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="catalogador.basico.guardarpres.cancelar"/></h2>
        <p>
            <bean:message key="catalogador.basico.guardarpres.cancelar.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="catalogador.basico.guardarpres.guardar.datos"/></h2>
        <p>
            <bean:message key="catalogador.basico.guardarpres.guardar.datos.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="catalogador.basico.guardarpres.guardar.datos.param.identificador"/></td>
                    <td><bean:message key="catalogador.basico.guardarpres.guardar.datos.param.identificador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="catalogador.basico.guardarpres.guardar.datos.param.usuario"/></td>
                    <td><bean:message key="catalogador.basico.guardarpres.guardar.datos.param.usuario.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="catalogador.basico.guardarpres.guardar.datos.param.contexto"/></td>
                    <td><bean:message key="catalogador.basico.guardarpres.guardar.datos.param.contexto.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="catalogador.basico.guardarpres.guardar.datos.param.descripcion"/></td>
                    <td><bean:message key="catalogador.basico.guardarpres.guardar.datos.param.descripcion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="catalogador.basico.guardarpres.guardar.datos.param.edad"/></td>
                    <td><bean:message key="catalogador.basico.guardarpres.guardar.datos.param.edad.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="catalogador.basico.guardarpres.guardar.datos.param.idioma"/></td>
                    <td><bean:message key="catalogador.basico.guardarpres.guardar.datos.param.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="catalogador.basico.guardarpres.guardar.datos.param.idioma.destinatario"/></td>
                    <td><bean:message key="catalogador.basico.guardarpres.guardar.datos.param.idioma.destinatario.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="catalogador.basico.guardarpres.guardar.datos.param.proceso.cognitivo"/></td>
                    <td><bean:message key="catalogador.basico.guardarpres.guardar.datos.param.proceso.cognitivo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="catalogador.basico.guardarpres.guardar.datos.param.tipo.recurso"/></td>
                    <td><bean:message key="catalogador.basico.guardarpres.guardar.datos.param.tipo.recurso.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="catalogador.basico.guardarpres.guardar.datos.param.titulo"/></td>
                    <td><bean:message key="catalogador.basico.guardarpres.guardar.datos.param.titulo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="catalogador.basico.guardarpres.guardar.datos.param.accion"/></td>
                    <td><bean:message key="catalogador.basico.guardarpres.guardar.datos.param.accion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="catalogador.basico.guardarpres.guardar.datos.param.arboles"/></td>
                    <td><bean:message key="catalogador.basico.guardarpres.guardar.datos.param.arboles.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

