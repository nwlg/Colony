<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="ver.metadatos.detalle.anotacion.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="ver.metadatos.detalle.anotacion.form"/></h1>
        <p>
            <bean:message key="ver.metadatos.detalle.anotacion.form.online.help"/>
        </p>
        <h2><bean:message key="ver.metadatos.detalle.anotacion.form.vuelve.de.detalle.anotacion"/></h2>
        <p>
            <bean:message key="ver.metadatos.detalle.anotacion.form.vuelve.de.detalle.anotacion.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.detalle.anotacion.form.vuelve.de.detalle.anotacion.param.combo.zona.h"/></td>
                    <td><bean:message key="ver.metadatos.detalle.anotacion.form.vuelve.de.detalle.anotacion.param.combo.zona.h.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.detalle.anotacion.form.vuelve.de.detalle.anotacion.param.combo.idioma"/></td>
                    <td><bean:message key="ver.metadatos.detalle.anotacion.form.vuelve.de.detalle.anotacion.param.combo.idioma.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

