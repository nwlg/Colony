<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="detalle.anotacion.cu.detalle.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="detalle.anotacion.cu.detalle.form"/></h1>
        <p>
            <bean:message key="detalle.anotacion.cu.detalle.form.online.help"/>
        </p>
        <h2><bean:message key="detalle.anotacion.cu.detalle.form.submit.form"/></h2>
        <p>
            <bean:message key="detalle.anotacion.cu.detalle.form.submit.form.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.titulo.anotacion"/></td>
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.titulo.anotacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.nombre"/></td>
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.nombre.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.organizacion"/></td>
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.organizacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.email"/></td>
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.email.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.thora"/></td>
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.thora.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.tminuto"/></td>
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.tminuto.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.tsegundo.p1"/></td>
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.tsegundo.p1.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.tsegundo.p2"/></td>
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.tsegundo.p2.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.meridiano.cero"/></td>
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.meridiano.cero.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.combo.zona.h"/></td>
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.combo.zona.h.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.zh.hora"/></td>
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.zh.hora.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.zh.minutos"/></td>
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.zh.minutos.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.descripcion.fecha"/></td>
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.descripcion.fecha.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.combo.idioma"/></td>
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.combo.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.descripcion"/></td>
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.descripcion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.accion"/></td>
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.accion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.boton.pulsado"/></td>
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.boton.pulsado.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.fecha.corta"/></td>
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.fecha.corta.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.formato"/></td>
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.formato.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.off.set"/></td>
                    <td><bean:message key="detalle.anotacion.cu.detalle.form.submit.form.param.off.set.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

