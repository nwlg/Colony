<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="ver.metadatos.meta.metadatos.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="ver.metadatos.meta.metadatos.form"/></h1>
        <p>
            <bean:message key="ver.metadatos.meta.metadatos.form.online.help"/>
        </p>
        <h2><bean:message key="ver.metadatos.meta.metadatos.form.vuelve.de.meta.metadatos"/></h2>
        <p>
            <bean:message key="ver.metadatos.meta.metadatos.form.vuelve.de.meta.metadatos.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.meta.metadatos.form.vuelve.de.meta.metadatos.param.combo.idioma.meta"/></td>
                    <td><bean:message key="ver.metadatos.meta.metadatos.form.vuelve.de.meta.metadatos.param.combo.idioma.meta.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.meta.metadatos.form.vuelve.de.meta.metadatos.param.crol"/></td>
                    <td><bean:message key="ver.metadatos.meta.metadatos.form.vuelve.de.meta.metadatos.param.crol.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.meta.metadatos.form.vuelve.de.meta.metadatos.param.combo.idioma"/></td>
                    <td><bean:message key="ver.metadatos.meta.metadatos.form.vuelve.de.meta.metadatos.param.combo.idioma.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

