<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="ciclo.de.vida.ciclo.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="ciclo.de.vida.ciclo.form"/></h1>
        <p>
            <bean:message key="ciclo.de.vida.ciclo.form.online.help"/>
        </p>
        <h2><bean:message key="ciclo.de.vida.ciclo.form.accion.submit"/></h2>
        <p>
            <bean:message key="ciclo.de.vida.ciclo.form.accion.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.accion"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.accion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.identificador.ode"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.versiones"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.versiones.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.estatus"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.estatus.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.contribuciones"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.contribuciones.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.crol"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.crol.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.cidentidad"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.cidentidad.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.fecha"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.fecha.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.hora"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.hora.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.minutos"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.minutos.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.segundo.p1"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.segundo.p1.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.segundo.p2"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.segundo.p2.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.meridianocero"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.meridianocero.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.combo.zona.h"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.combo.zona.h.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.zh.hora"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.zh.hora.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.zh.minutos"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.zh.minutos.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.descripciones"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.descripciones.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.combo.idioma"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.form.accion.submit.param.combo.idioma.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

