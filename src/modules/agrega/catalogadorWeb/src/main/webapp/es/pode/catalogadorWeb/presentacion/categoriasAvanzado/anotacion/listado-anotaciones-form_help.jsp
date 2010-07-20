<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="anotacion.listado.anotaciones.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="anotacion.listado.anotaciones.form"/></h1>
        <p>
            <bean:message key="anotacion.listado.anotaciones.form.online.help"/>
        </p>
        <h2><bean:message key="anotacion.listado.anotaciones.form.detalles"/></h2>
        <p>
            <bean:message key="anotacion.listado.anotaciones.form.detalles.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="anotacion.listado.anotaciones.form.detalles.param.titulo.anotacion"/></td>
                    <td><bean:message key="anotacion.listado.anotaciones.form.detalles.param.titulo.anotacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="anotacion.listado.anotaciones.form.detalles.param.identificador.ode"/></td>
                    <td><bean:message key="anotacion.listado.anotaciones.form.detalles.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="anotacion.listado.anotaciones.form.detalles.param.boton.pulsado"/></td>
                    <td><bean:message key="anotacion.listado.anotaciones.form.detalles.param.boton.pulsado.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="anotacion.listado.anotaciones.form.inicio.avanzado"/></h2>
        <p>
            <bean:message key="anotacion.listado.anotaciones.form.inicio.avanzado.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="anotacion.listado.anotaciones.form.inicio.avanzado.param.identificador.ode"/></td>
                    <td><bean:message key="anotacion.listado.anotaciones.form.inicio.avanzado.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="anotacion.listado.anotaciones.form.inicio.avanzado.param.titulo.anotacion"/></td>
                    <td><bean:message key="anotacion.listado.anotaciones.form.inicio.avanzado.param.titulo.anotacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="anotacion.listado.anotaciones.form.inicio.avanzado.param.listado.anotaciones"/></td>
                    <td><bean:message key="anotacion.listado.anotaciones.form.inicio.avanzado.param.listado.anotaciones.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

