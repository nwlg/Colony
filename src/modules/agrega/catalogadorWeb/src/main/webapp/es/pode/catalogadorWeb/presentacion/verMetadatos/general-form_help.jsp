<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="ver.metadatos.general.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="ver.metadatos.general.form"/></h1>
        <p>
            <bean:message key="ver.metadatos.general.form.online.help"/>
        </p>
        <h2><bean:message key="ver.metadatos.general.form.vuelve.de.general"/></h2>
        <p>
            <bean:message key="ver.metadatos.general.form.vuelve.de.general.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.general.form.vuelve.de.general.param.estructura"/></td>
                    <td><bean:message key="ver.metadatos.general.form.vuelve.de.general.param.estructura.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.general.form.vuelve.de.general.param.nivel.agregacion"/></td>
                    <td><bean:message key="ver.metadatos.general.form.vuelve.de.general.param.nivel.agregacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.general.form.vuelve.de.general.param.combo.idioma"/></td>
                    <td><bean:message key="ver.metadatos.general.form.vuelve.de.general.param.combo.idioma.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.general.form.vuelve.de.general.param.idiomas"/></td>
                    <td><bean:message key="ver.metadatos.general.form.vuelve.de.general.param.idiomas.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

