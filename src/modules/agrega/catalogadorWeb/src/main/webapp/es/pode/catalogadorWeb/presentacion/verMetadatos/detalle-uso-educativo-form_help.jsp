<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="ver.metadatos.detalle.uso.educativo.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="ver.metadatos.detalle.uso.educativo.form"/></h1>
        <p>
            <bean:message key="ver.metadatos.detalle.uso.educativo.form.online.help"/>
        </p>
        <h2><bean:message key="ver.metadatos.detalle.uso.educativo.form.vuelve.de.detalle.uso.educativo"/></h2>
        <p>
            <bean:message key="ver.metadatos.detalle.uso.educativo.form.vuelve.de.detalle.uso.educativo.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.detalle.uso.educativo.form.vuelve.de.detalle.uso.educativo.param.idiomas"/></td>
                    <td><bean:message key="ver.metadatos.detalle.uso.educativo.form.vuelve.de.detalle.uso.educativo.param.idiomas.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.detalle.uso.educativo.form.vuelve.de.detalle.uso.educativo.param.combo.idioma"/></td>
                    <td><bean:message key="ver.metadatos.detalle.uso.educativo.form.vuelve.de.detalle.uso.educativo.param.combo.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.detalle.uso.educativo.form.vuelve.de.detalle.uso.educativo.param.combo.tipo.recurso"/></td>
                    <td><bean:message key="ver.metadatos.detalle.uso.educativo.form.vuelve.de.detalle.uso.educativo.param.combo.tipo.recurso.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.detalle.uso.educativo.form.vuelve.de.detalle.uso.educativo.param.combo.rol"/></td>
                    <td><bean:message key="ver.metadatos.detalle.uso.educativo.form.vuelve.de.detalle.uso.educativo.param.combo.rol.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.detalle.uso.educativo.form.vuelve.de.detalle.uso.educativo.param.combo.contexto"/></td>
                    <td><bean:message key="ver.metadatos.detalle.uso.educativo.form.vuelve.de.detalle.uso.educativo.param.combo.contexto.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.detalle.uso.educativo.form.vuelve.de.detalle.uso.educativo.param.combo.proceso"/></td>
                    <td><bean:message key="ver.metadatos.detalle.uso.educativo.form.vuelve.de.detalle.uso.educativo.param.combo.proceso.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.detalle.uso.educativo.form.vuelve.de.detalle.uso.educativo.param.tipo.interactividad"/></td>
                    <td><bean:message key="ver.metadatos.detalle.uso.educativo.form.vuelve.de.detalle.uso.educativo.param.tipo.interactividad.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.detalle.uso.educativo.form.vuelve.de.detalle.uso.educativo.param.nivel.interactividad"/></td>
                    <td><bean:message key="ver.metadatos.detalle.uso.educativo.form.vuelve.de.detalle.uso.educativo.param.nivel.interactividad.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.detalle.uso.educativo.form.vuelve.de.detalle.uso.educativo.param.densidad.semantica"/></td>
                    <td><bean:message key="ver.metadatos.detalle.uso.educativo.form.vuelve.de.detalle.uso.educativo.param.densidad.semantica.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.detalle.uso.educativo.form.vuelve.de.detalle.uso.educativo.param.dificultad"/></td>
                    <td><bean:message key="ver.metadatos.detalle.uso.educativo.form.vuelve.de.detalle.uso.educativo.param.dificultad.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

