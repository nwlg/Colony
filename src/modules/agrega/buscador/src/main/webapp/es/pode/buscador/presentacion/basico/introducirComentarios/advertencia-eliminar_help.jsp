<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="introducir.comentarios.cu.advertencia.eliminar"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="introducir.comentarios.cu.advertencia.eliminar"/></h1>
        <p>
            <bean:message key="introducir.comentarios.cu.advertencia.eliminar.online.help"/>
        </p>
        <h2><bean:message key="introducir.comentarios.cu.advertencia.eliminar.analiza.pulsacion"/></h2>
        <p>
            <bean:message key="introducir.comentarios.cu.advertencia.eliminar.analiza.pulsacion.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="introducir.comentarios.cu.advertencia.eliminar.analiza.pulsacion.param.ids"/></td>
                    <td><bean:message key="introducir.comentarios.cu.advertencia.eliminar.analiza.pulsacion.param.ids.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="introducir.comentarios.cu.advertencia.eliminar.analiza.pulsacion.param.id.ode"/></td>
                    <td><bean:message key="introducir.comentarios.cu.advertencia.eliminar.analiza.pulsacion.param.id.ode.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="introducir.comentarios.cu.advertencia.eliminar.analiza.pulsacion.param.imagen"/></td>
                    <td><bean:message key="introducir.comentarios.cu.advertencia.eliminar.analiza.pulsacion.param.imagen.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="introducir.comentarios.cu.advertencia.eliminar.analiza.pulsacion.param.tipo.layout.buscador"/></td>
                    <td><bean:message key="introducir.comentarios.cu.advertencia.eliminar.analiza.pulsacion.param.tipo.layout.buscador.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="introducir.comentarios.cu.advertencia.eliminar.analiza.pulsacion.param.action"/></td>
                    <td><bean:message key="introducir.comentarios.cu.advertencia.eliminar.analiza.pulsacion.param.action.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="introducir.comentarios.cu.advertencia.eliminar.analiza.pulsacion.param.mostrar.vuelta"/></td>
                    <td><bean:message key="introducir.comentarios.cu.advertencia.eliminar.analiza.pulsacion.param.mostrar.vuelta.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="introducir.comentarios.cu.advertencia.eliminar.analiza.pulsacion.param.busqueda.simple.avanzada"/></td>
                    <td><bean:message key="introducir.comentarios.cu.advertencia.eliminar.analiza.pulsacion.param.busqueda.simple.avanzada.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="introducir.comentarios.cu.advertencia.eliminar.analiza.pulsacion.param.url.ode"/></td>
                    <td><bean:message key="introducir.comentarios.cu.advertencia.eliminar.analiza.pulsacion.param.url.ode.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

