<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="ver.metadatos.derechos.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="ver.metadatos.derechos.form"/></h1>
        <p>
            <bean:message key="ver.metadatos.derechos.form.online.help"/>
        </p>
        <h2><bean:message key="ver.metadatos.derechos.form.vuelve.de.derechos"/></h2>
        <p>
            <bean:message key="ver.metadatos.derechos.form.vuelve.de.derechos.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.derechos.form.vuelve.de.derechos.param.coste"/></td>
                    <td><bean:message key="ver.metadatos.derechos.form.vuelve.de.derechos.param.coste.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.derechos.form.vuelve.de.derechos.param.copy.restricciones"/></td>
                    <td><bean:message key="ver.metadatos.derechos.form.vuelve.de.derechos.param.copy.restricciones.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.derechos.form.vuelve.de.derechos.param.combo.idioma"/></td>
                    <td><bean:message key="ver.metadatos.derechos.form.vuelve.de.derechos.param.combo.idioma.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.derechos.form.vuelve.de.derechos.param.tipo.acceso"/></td>
                    <td><bean:message key="ver.metadatos.derechos.form.vuelve.de.derechos.param.tipo.acceso.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

