<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="ver.metadatos.relaciones.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="ver.metadatos.relaciones.form"/></h1>
        <p>
            <bean:message key="ver.metadatos.relaciones.form.online.help"/>
        </p>
        <h2><bean:message key="ver.metadatos.relaciones.form.detalle.relacion"/></h2>
        <p>
            <bean:message key="ver.metadatos.relaciones.form.detalle.relacion.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.relaciones.form.detalle.relacion.param.identificador.ode"/></td>
                    <td><bean:message key="ver.metadatos.relaciones.form.detalle.relacion.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.relaciones.form.detalle.relacion.param.listado.relaciones"/></td>
                    <td><bean:message key="ver.metadatos.relaciones.form.detalle.relacion.param.listado.relaciones.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.relaciones.form.detalle.relacion.param.boton.pulsado"/></td>
                    <td><bean:message key="ver.metadatos.relaciones.form.detalle.relacion.param.boton.pulsado.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="ver.metadatos.relaciones.form.vuelve.de.relaciones"/></h2>
        <p>
            <bean:message key="ver.metadatos.relaciones.form.vuelve.de.relaciones.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

