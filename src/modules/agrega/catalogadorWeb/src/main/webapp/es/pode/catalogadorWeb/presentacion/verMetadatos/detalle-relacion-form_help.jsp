<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="ver.metadatos.detalle.relacion.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="ver.metadatos.detalle.relacion.form"/></h1>
        <p>
            <bean:message key="ver.metadatos.detalle.relacion.form.online.help"/>
        </p>
        <h2><bean:message key="ver.metadatos.detalle.relacion.form.vuelve.de.detalle.relacion"/></h2>
        <p>
            <bean:message key="ver.metadatos.detalle.relacion.form.vuelve.de.detalle.relacion.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.detalle.relacion.form.vuelve.de.detalle.relacion.param.combo.idioma"/></td>
                    <td><bean:message key="ver.metadatos.detalle.relacion.form.vuelve.de.detalle.relacion.param.combo.idioma.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.detalle.relacion.form.vuelve.de.detalle.relacion.param.tipo"/></td>
                    <td><bean:message key="ver.metadatos.detalle.relacion.form.vuelve.de.detalle.relacion.param.tipo.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

