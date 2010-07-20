<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="ver.metadatos.anotaciones.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="ver.metadatos.anotaciones.form"/></h1>
        <p>
            <bean:message key="ver.metadatos.anotaciones.form.online.help"/>
        </p>
        <h2><bean:message key="ver.metadatos.anotaciones.form.detalle.anotacion"/></h2>
        <p>
            <bean:message key="ver.metadatos.anotaciones.form.detalle.anotacion.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.anotaciones.form.detalle.anotacion.param.identificador.ode"/></td>
                    <td><bean:message key="ver.metadatos.anotaciones.form.detalle.anotacion.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.anotaciones.form.detalle.anotacion.param.listado.anotaciones"/></td>
                    <td><bean:message key="ver.metadatos.anotaciones.form.detalle.anotacion.param.listado.anotaciones.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.anotaciones.form.detalle.anotacion.param.boton.pulsado"/></td>
                    <td><bean:message key="ver.metadatos.anotaciones.form.detalle.anotacion.param.boton.pulsado.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="ver.metadatos.anotaciones.form.vuelve.de.anotaciones"/></h2>
        <p>
            <bean:message key="ver.metadatos.anotaciones.form.vuelve.de.anotaciones.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

