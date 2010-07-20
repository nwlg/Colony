<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="tesauros.relaciones.jerarquicas.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="tesauros.relaciones.jerarquicas.form"/></h1>
        <p>
            <bean:message key="tesauros.relaciones.jerarquicas.form.online.help"/>
        </p>
        <h2><bean:message key="tesauros.relaciones.jerarquicas.form.datos.relacion"/></h2>
        <p>
            <bean:message key="tesauros.relaciones.jerarquicas.form.datos.relacion.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tesauros.relaciones.jerarquicas.form.datos.relacion.param.id"/></td>
                    <td><bean:message key="tesauros.relaciones.jerarquicas.form.datos.relacion.param.id.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tesauros.relaciones.jerarquicas.form.datos.relacion.param.nom.tesauro"/></td>
                    <td><bean:message key="tesauros.relaciones.jerarquicas.form.datos.relacion.param.nom.tesauro.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tesauros.relaciones.jerarquicas.form.datos.relacion.param.idioma"/></td>
                    <td><bean:message key="tesauros.relaciones.jerarquicas.form.datos.relacion.param.idioma.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tesauros.relaciones.jerarquicas.form.datos.relacion.param.taxonesvo"/></td>
                    <td><bean:message key="tesauros.relaciones.jerarquicas.form.datos.relacion.param.taxonesvo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tesauros.relaciones.jerarquicas.form.datos.relacion.param.ruta.padrevo"/></td>
                    <td><bean:message key="tesauros.relaciones.jerarquicas.form.datos.relacion.param.ruta.padrevo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tesauros.relaciones.jerarquicas.form.datos.relacion.param.jerarquias"/></td>
                    <td><bean:message key="tesauros.relaciones.jerarquicas.form.datos.relacion.param.jerarquias.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

