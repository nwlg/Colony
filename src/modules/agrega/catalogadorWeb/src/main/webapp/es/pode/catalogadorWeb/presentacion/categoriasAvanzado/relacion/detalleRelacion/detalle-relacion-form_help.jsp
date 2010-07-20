<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="detalle.relacion.cu.detalle.relacion.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="detalle.relacion.cu.detalle.relacion.form"/></h1>
        <p>
            <bean:message key="detalle.relacion.cu.detalle.relacion.form.online.help"/>
        </p>
        <h2><bean:message key="detalle.relacion.cu.detalle.relacion.form.submit.form"/></h2>
        <p>
            <bean:message key="detalle.relacion.cu.detalle.relacion.form.submit.form.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.relacion.cu.detalle.relacion.form.submit.form.param.accion"/></td>
                    <td><bean:message key="detalle.relacion.cu.detalle.relacion.form.submit.form.param.accion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.relacion.cu.detalle.relacion.form.submit.form.param.titulo.relacion"/></td>
                    <td><bean:message key="detalle.relacion.cu.detalle.relacion.form.submit.form.param.titulo.relacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.relacion.cu.detalle.relacion.form.submit.form.param.identificador.ode"/></td>
                    <td><bean:message key="detalle.relacion.cu.detalle.relacion.form.submit.form.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.relacion.cu.detalle.relacion.form.submit.form.param.boton.pulsado"/></td>
                    <td><bean:message key="detalle.relacion.cu.detalle.relacion.form.submit.form.param.boton.pulsado.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.relacion.cu.detalle.relacion.form.submit.form.param.combo.idioma"/></td>
                    <td><bean:message key="detalle.relacion.cu.detalle.relacion.form.submit.form.param.combo.idioma.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.relacion.cu.detalle.relacion.form.submit.form.param.descripcion"/></td>
                    <td><bean:message key="detalle.relacion.cu.detalle.relacion.form.submit.form.param.descripcion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.relacion.cu.detalle.relacion.form.submit.form.param.tipo"/></td>
                    <td><bean:message key="detalle.relacion.cu.detalle.relacion.form.submit.form.param.tipo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.relacion.cu.detalle.relacion.form.submit.form.param.catalogo"/></td>
                    <td><bean:message key="detalle.relacion.cu.detalle.relacion.form.submit.form.param.catalogo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.relacion.cu.detalle.relacion.form.submit.form.param.entrada"/></td>
                    <td><bean:message key="detalle.relacion.cu.detalle.relacion.form.submit.form.param.entrada.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

