<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="meta.metadatos.meta.metadatos.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="meta.metadatos.meta.metadatos.form"/></h1>
        <p>
            <bean:message key="meta.metadatos.meta.metadatos.form.online.help"/>
        </p>
        <h2><bean:message key="meta.metadatos.meta.metadatos.form.submit"/></h2>
        <p>
            <bean:message key="meta.metadatos.meta.metadatos.form.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.accion"/></td>
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.accion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.combo.idioma.meta"/></td>
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.combo.idioma.meta.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.esquemas.meta"/></td>
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.esquemas.meta.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.combo.idioma"/></td>
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.combo.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.descripciones"/></td>
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.descripciones.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.zh.minutos"/></td>
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.zh.minutos.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.zh.hora"/></td>
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.zh.hora.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.combo.zona.h"/></td>
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.combo.zona.h.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.meridianocero"/></td>
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.meridianocero.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.segundo.p1"/></td>
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.segundo.p1.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.segundo.p2"/></td>
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.segundo.p2.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.minutos"/></td>
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.minutos.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.hora"/></td>
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.hora.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.fecha.corta"/></td>
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.fecha.corta.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.cidentidad"/></td>
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.cidentidad.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.crol"/></td>
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.crol.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.contribucion"/></td>
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.contribucion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.identificadores"/></td>
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.identificadores.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.identificador.ode"/></td>
                    <td><bean:message key="meta.metadatos.meta.metadatos.form.submit.param.identificador.ode.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

