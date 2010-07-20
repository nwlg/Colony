<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="ver.metadatos.tecnica.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="ver.metadatos.tecnica.form"/></h1>
        <p>
            <bean:message key="ver.metadatos.tecnica.form.online.help"/>
        </p>
        <h2><bean:message key="ver.metadatos.tecnica.form.vuelve.de.tecnica"/></h2>
        <p>
            <bean:message key="ver.metadatos.tecnica.form.vuelve.de.tecnica.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.tecnica.form.vuelve.de.tecnica.param.combo.formato"/></td>
                    <td><bean:message key="ver.metadatos.tecnica.form.vuelve.de.tecnica.param.combo.formato.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.tecnica.form.vuelve.de.tecnica.param.combo.tipo"/></td>
                    <td><bean:message key="ver.metadatos.tecnica.form.vuelve.de.tecnica.param.combo.tipo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.tecnica.form.vuelve.de.tecnica.param.combo.nombre"/></td>
                    <td><bean:message key="ver.metadatos.tecnica.form.vuelve.de.tecnica.param.combo.nombre.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.tecnica.form.vuelve.de.tecnica.param.combo.idioma"/></td>
                    <td><bean:message key="ver.metadatos.tecnica.form.vuelve.de.tecnica.param.combo.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.tecnica.form.vuelve.de.tecnica.param.formatos"/></td>
                    <td><bean:message key="ver.metadatos.tecnica.form.vuelve.de.tecnica.param.formatos.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

