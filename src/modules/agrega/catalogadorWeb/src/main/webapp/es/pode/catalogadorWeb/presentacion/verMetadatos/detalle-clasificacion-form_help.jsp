<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="ver.metadatos.detalle.clasificacion.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="ver.metadatos.detalle.clasificacion.form"/></h1>
        <p>
            <bean:message key="ver.metadatos.detalle.clasificacion.form.online.help"/>
        </p>
        <h2><bean:message key="ver.metadatos.detalle.clasificacion.form.vuelve.de.detalle.clasificacion"/></h2>
        <p>
            <bean:message key="ver.metadatos.detalle.clasificacion.form.vuelve.de.detalle.clasificacion.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.detalle.clasificacion.form.vuelve.de.detalle.clasificacion.param.proposito"/></td>
                    <td><bean:message key="ver.metadatos.detalle.clasificacion.form.vuelve.de.detalle.clasificacion.param.proposito.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.detalle.clasificacion.form.vuelve.de.detalle.clasificacion.param.source"/></td>
                    <td><bean:message key="ver.metadatos.detalle.clasificacion.form.vuelve.de.detalle.clasificacion.param.source.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.detalle.clasificacion.form.vuelve.de.detalle.clasificacion.param.combo.idioma"/></td>
                    <td><bean:message key="ver.metadatos.detalle.clasificacion.form.vuelve.de.detalle.clasificacion.param.combo.idioma.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

