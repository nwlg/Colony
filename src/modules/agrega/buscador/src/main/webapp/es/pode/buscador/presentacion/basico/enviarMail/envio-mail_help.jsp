<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="enviar.mail.cu.envio.mail"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="enviar.mail.cu.envio.mail"/></h1>
        <p>
            <bean:message key="enviar.mail.cu.envio.mail.online.help"/>
        </p>
        <h2><bean:message key="enviar.mail.cu.envio.mail.cancelar"/></h2>
        <p>
            <bean:message key="enviar.mail.cu.envio.mail.cancelar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="enviar.mail.cu.envio.mail.cancelar.param.identificador.ode"/></td>
                    <td><bean:message key="enviar.mail.cu.envio.mail.cancelar.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="enviar.mail.cu.envio.mail.cancelar.param.idioma"/></td>
                    <td><bean:message key="enviar.mail.cu.envio.mail.cancelar.param.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="enviar.mail.cu.envio.mail.cancelar.param.tipo.layout.buscador"/></td>
                    <td><bean:message key="enviar.mail.cu.envio.mail.cancelar.param.tipo.layout.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="enviar.mail.cu.envio.mail.cancelar.param.mostrar.vuelta"/></td>
                    <td><bean:message key="enviar.mail.cu.envio.mail.cancelar.param.mostrar.vuelta.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="enviar.mail.cu.envio.mail.aceptar"/></h2>
        <p>
            <bean:message key="enviar.mail.cu.envio.mail.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.correos.hasta"/></td>
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.correos.hasta.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.nombres.hasta"/></td>
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.nombres.hasta.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.correo.desde"/></td>
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.correo.desde.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.nombre.desde"/></td>
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.nombre.desde.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.enviar.remitente"/></td>
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.enviar.remitente.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.resumen"/></td>
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.resumen.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.url.ode"/></td>
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.url.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.identificador.ode"/></td>
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.idioma"/></td>
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.idioma.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.titulo"/></td>
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.titulo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.resultado.validacion"/></td>
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.resultado.validacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.idioma.buscador"/></td>
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.url.imagen"/></td>
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.url.imagen.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.mostrar.vuelta"/></td>
                    <td><bean:message key="enviar.mail.cu.envio.mail.aceptar.param.mostrar.vuelta.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="enviar.mail.cu.envio.mail.buscar"/></h2>
        <p>
            <bean:message key="enviar.mail.cu.envio.mail.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="enviar.mail.cu.envio.mail.buscar.param.tipo.busqueda"/></td>
                    <td><bean:message key="enviar.mail.cu.envio.mail.buscar.param.tipo.busqueda.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="enviar.mail.cu.envio.mail.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="enviar.mail.cu.envio.mail.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="enviar.mail.cu.envio.mail.buscar.param.mostrar.vuelta"/></td>
                    <td><bean:message key="enviar.mail.cu.envio.mail.buscar.param.mostrar.vuelta.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

