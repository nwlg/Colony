<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="enviar.mail.cu.resultado.envio"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="enviar.mail.cu.resultado.envio"/></h1>
        <p>
            <bean:message key="enviar.mail.cu.resultado.envio.online.help"/>
        </p>
        <h2><bean:message key="enviar.mail.cu.resultado.envio.aceptar"/></h2>
        <p>
            <bean:message key="enviar.mail.cu.resultado.envio.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="enviar.mail.cu.resultado.envio.aceptar.param.identificador.ode"/></td>
                    <td><bean:message key="enviar.mail.cu.resultado.envio.aceptar.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="enviar.mail.cu.resultado.envio.aceptar.param.idioma"/></td>
                    <td><bean:message key="enviar.mail.cu.resultado.envio.aceptar.param.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="enviar.mail.cu.resultado.envio.aceptar.param.tipo.layout.buscador"/></td>
                    <td><bean:message key="enviar.mail.cu.resultado.envio.aceptar.param.tipo.layout.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="enviar.mail.cu.resultado.envio.aceptar.param.mostrar.vuelta"/></td>
                    <td><bean:message key="enviar.mail.cu.resultado.envio.aceptar.param.mostrar.vuelta.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="enviar.mail.cu.resultado.envio.buscar"/></h2>
        <p>
            <bean:message key="enviar.mail.cu.resultado.envio.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="enviar.mail.cu.resultado.envio.buscar.param.tipo.busqueda"/></td>
                    <td><bean:message key="enviar.mail.cu.resultado.envio.buscar.param.tipo.busqueda.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="enviar.mail.cu.resultado.envio.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="enviar.mail.cu.resultado.envio.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="enviar.mail.cu.resultado.envio.buscar.param.mostrar.vuelta"/></td>
                    <td><bean:message key="enviar.mail.cu.resultado.envio.buscar.param.mostrar.vuelta.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

