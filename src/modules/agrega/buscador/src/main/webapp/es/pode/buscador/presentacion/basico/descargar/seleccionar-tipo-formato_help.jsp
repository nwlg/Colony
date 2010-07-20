<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="descargar.odecu.seleccionar.tipo.formato"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="descargar.odecu.seleccionar.tipo.formato"/></h1>
        <p>
            <bean:message key="descargar.odecu.seleccionar.tipo.formato.online.help"/>
        </p>
        <h2><bean:message key="descargar.odecu.seleccionar.tipo.formato.aceptar"/></h2>
        <p>
            <bean:message key="descargar.odecu.seleccionar.tipo.formato.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descargar.odecu.seleccionar.tipo.formato.aceptar.param.identificador.ode"/></td>
                    <td><bean:message key="descargar.odecu.seleccionar.tipo.formato.aceptar.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descargar.odecu.seleccionar.tipo.formato.aceptar.param.formato"/></td>
                    <td><bean:message key="descargar.odecu.seleccionar.tipo.formato.aceptar.param.formato.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descargar.odecu.seleccionar.tipo.formato.aceptar.param.idioma"/></td>
                    <td><bean:message key="descargar.odecu.seleccionar.tipo.formato.aceptar.param.idioma.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="descargar.odecu.seleccionar.tipo.formato.cancelar"/></h2>
        <p>
            <bean:message key="descargar.odecu.seleccionar.tipo.formato.cancelar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descargar.odecu.seleccionar.tipo.formato.cancelar.param.identificador.ode"/></td>
                    <td><bean:message key="descargar.odecu.seleccionar.tipo.formato.cancelar.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descargar.odecu.seleccionar.tipo.formato.cancelar.param.idioma"/></td>
                    <td><bean:message key="descargar.odecu.seleccionar.tipo.formato.cancelar.param.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descargar.odecu.seleccionar.tipo.formato.cancelar.param.busqueda.simple.avanzada"/></td>
                    <td><bean:message key="descargar.odecu.seleccionar.tipo.formato.cancelar.param.busqueda.simple.avanzada.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="descargar.odecu.seleccionar.tipo.formato.cancelar.param.tipo.layout.buscador"/></td>
                    <td><bean:message key="descargar.odecu.seleccionar.tipo.formato.cancelar.param.tipo.layout.buscador.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="descargar.odecu.seleccionar.tipo.formato.cancelar.param.mostrar.vuelta"/></td>
                    <td><bean:message key="descargar.odecu.seleccionar.tipo.formato.cancelar.param.mostrar.vuelta.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

