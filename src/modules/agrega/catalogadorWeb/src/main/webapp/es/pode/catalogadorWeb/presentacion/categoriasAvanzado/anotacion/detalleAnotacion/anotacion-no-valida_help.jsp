<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="detalle.anotacion.cu.anotacion.no.valida"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="detalle.anotacion.cu.anotacion.no.valida"/></h1>
        <p>
            <bean:message key="detalle.anotacion.cu.anotacion.no.valida.online.help"/>
        </p>
        <h2><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver"/></h2>
        <p>
            <bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.titulo.anotacion"/></td>
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.titulo.anotacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.identificador.ode"/></td>
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.boton.pulsado"/></td>
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.boton.pulsado.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.nombre"/></td>
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.nombre.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.organizacion"/></td>
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.organizacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.email"/></td>
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.email.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.dia"/></td>
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.dia.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.mes"/></td>
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.mes.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.anyo"/></td>
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.anyo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.thora"/></td>
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.thora.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.tminuto"/></td>
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.tminuto.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.tsegundo.p1"/></td>
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.tsegundo.p1.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.tsegundo.p2"/></td>
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.tsegundo.p2.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.meridiano.cero"/></td>
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.meridiano.cero.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.combo.zona.h"/></td>
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.combo.zona.h.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.zn.hora"/></td>
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.zn.hora.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.zn.minutos"/></td>
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.zn.minutos.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.descripcion.fecha"/></td>
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.descripcion.fecha.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.combo.idioma"/></td>
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.combo.idioma.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.descripcion"/></td>
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.descripcion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.mensajes.error"/></td>
                    <td><bean:message key="detalle.anotacion.cu.anotacion.no.valida.volver.param.mensajes.error.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

