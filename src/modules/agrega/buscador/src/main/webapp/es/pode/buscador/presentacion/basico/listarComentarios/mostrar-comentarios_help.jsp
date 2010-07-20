<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="listar.comentarios.cu.mostrar.comentarios"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="listar.comentarios.cu.mostrar.comentarios"/></h1>
        <p>
            <bean:message key="listar.comentarios.cu.mostrar.comentarios.online.help"/>
        </p>
        <h2><bean:message key="listar.comentarios.cu.mostrar.comentarios.cancelar"/></h2>
        <p>
            <bean:message key="listar.comentarios.cu.mostrar.comentarios.cancelar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.comentarios.cu.mostrar.comentarios.cancelar.param.id.ode"/></td>
                    <td><bean:message key="listar.comentarios.cu.mostrar.comentarios.cancelar.param.id.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="listar.comentarios.cu.mostrar.comentarios.cancelar.param.idioma.ode"/></td>
                    <td><bean:message key="listar.comentarios.cu.mostrar.comentarios.cancelar.param.idioma.ode.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.comentarios.cu.mostrar.comentarios.cancelar.param.titulo.ode"/></td>
                    <td><bean:message key="listar.comentarios.cu.mostrar.comentarios.cancelar.param.titulo.ode.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

