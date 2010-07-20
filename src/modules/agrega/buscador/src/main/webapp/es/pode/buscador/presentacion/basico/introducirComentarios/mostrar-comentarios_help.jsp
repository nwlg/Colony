<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="introducir.comentarios.cu.mostrar.comentarios"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="introducir.comentarios.cu.mostrar.comentarios"/></h1>
        <p>
            <bean:message key="introducir.comentarios.cu.mostrar.comentarios.online.help"/>
        </p>
        <h2><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario"/></h2>
        <p>
            <bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.param.titulo"/></td>
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.param.titulo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.param.valoracion"/></td>
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.param.valoracion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.param.comentario"/></td>
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.param.comentario.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.param.id.ode"/></td>
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.param.id.ode.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.param.con.inaprop"/></td>
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.param.con.inaprop.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.param.titulo.ode"/></td>
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.param.titulo.ode.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.param.imagen"/></td>
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.param.imagen.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.param.idioma.ode"/></td>
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.param.idioma.ode.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.param.tipo.layout.buscador"/></td>
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.param.tipo.layout.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.param.mostrar.vuelta"/></td>
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.param.mostrar.vuelta.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.param.busqueda.simple.avanzada"/></td>
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.param.busqueda.simple.avanzada.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.param.url.ode"/></td>
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.insertar.comentario.param.url.ode.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="introducir.comentarios.cu.mostrar.comentarios.cancelar"/></h2>
        <p>
            <bean:message key="introducir.comentarios.cu.mostrar.comentarios.cancelar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.cancelar.param.id.ode"/></td>
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.cancelar.param.id.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.cancelar.param.idioma.ode"/></td>
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.cancelar.param.idioma.ode.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.cancelar.param.titulo.ode"/></td>
                    <td><bean:message key="introducir.comentarios.cu.mostrar.comentarios.cancelar.param.titulo.ode.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

