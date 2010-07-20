<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="general.general.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="general.general.form"/></h1>
        <p>
            <bean:message key="general.general.form.online.help"/>
        </p>
        <h2><bean:message key="general.general.form.submit"/></h2>
        <p>
            <bean:message key="general.general.form.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="general.general.form.submit.param.titulos"/></td>
                    <td><bean:message key="general.general.form.submit.param.titulos.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="general.general.form.submit.param.textos"/></td>
                    <td><bean:message key="general.general.form.submit.param.textos.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="general.general.form.submit.param.texto"/></td>
                    <td><bean:message key="general.general.form.submit.param.texto.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="general.general.form.submit.param.palabras.clave"/></td>
                    <td><bean:message key="general.general.form.submit.param.palabras.clave.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="general.general.form.submit.param.nivel.agregacion"/></td>
                    <td><bean:message key="general.general.form.submit.param.nivel.agregacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="general.general.form.submit.param.idiomas"/></td>
                    <td><bean:message key="general.general.form.submit.param.idiomas.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="general.general.form.submit.param.idioma"/></td>
                    <td><bean:message key="general.general.form.submit.param.idioma.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="general.general.form.submit.param.identificadores"/></td>
                    <td><bean:message key="general.general.form.submit.param.identificadores.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="general.general.form.submit.param.identificador.ode"/></td>
                    <td><bean:message key="general.general.form.submit.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="general.general.form.submit.param.estructura"/></td>
                    <td><bean:message key="general.general.form.submit.param.estructura.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="general.general.form.submit.param.entrada"/></td>
                    <td><bean:message key="general.general.form.submit.param.entrada.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="general.general.form.submit.param.descripciones"/></td>
                    <td><bean:message key="general.general.form.submit.param.descripciones.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="general.general.form.submit.param.caracteristicas"/></td>
                    <td><bean:message key="general.general.form.submit.param.caracteristicas.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="general.general.form.submit.param.combo.idioma"/></td>
                    <td><bean:message key="general.general.form.submit.param.combo.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="general.general.form.submit.param.combo.caract.tipo.plano"/></td>
                    <td><bean:message key="general.general.form.submit.param.combo.caract.tipo.plano.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="general.general.form.submit.param.combo.caract.luz"/></td>
                    <td><bean:message key="general.general.form.submit.param.combo.caract.luz.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="general.general.form.submit.param.combo.caract.formato"/></td>
                    <td><bean:message key="general.general.form.submit.param.combo.caract.formato.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="general.general.form.submit.param.combo.caract.estructura.formal"/></td>
                    <td><bean:message key="general.general.form.submit.param.combo.caract.estructura.formal.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="general.general.form.submit.param.combo.caract.dimension"/></td>
                    <td><bean:message key="general.general.form.submit.param.combo.caract.dimension.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="general.general.form.submit.param.combo.caract.color"/></td>
                    <td><bean:message key="general.general.form.submit.param.combo.caract.color.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="general.general.form.submit.param.combo.caract.banda.sonora"/></td>
                    <td><bean:message key="general.general.form.submit.param.combo.caract.banda.sonora.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="general.general.form.submit.param.combo.caract.angulacion"/></td>
                    <td><bean:message key="general.general.form.submit.param.combo.caract.angulacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="general.general.form.submit.param.catalogo"/></td>
                    <td><bean:message key="general.general.form.submit.param.catalogo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="general.general.form.submit.param.ambitos"/></td>
                    <td><bean:message key="general.general.form.submit.param.ambitos.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="general.general.form.submit.param.accion"/></td>
                    <td><bean:message key="general.general.form.submit.param.accion.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

