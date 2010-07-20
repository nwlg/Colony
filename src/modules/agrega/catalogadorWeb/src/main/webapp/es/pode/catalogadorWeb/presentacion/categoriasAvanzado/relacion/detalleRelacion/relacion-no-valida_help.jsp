<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="detalle.relacion.cu.relacion.no.valida"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="detalle.relacion.cu.relacion.no.valida"/></h1>
        <p>
            <bean:message key="detalle.relacion.cu.relacion.no.valida.online.help"/>
        </p>
        <h2><bean:message key="detalle.relacion.cu.relacion.no.valida.volver"/></h2>
        <p>
            <bean:message key="detalle.relacion.cu.relacion.no.valida.volver.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.relacion.cu.relacion.no.valida.volver.param.titulo.relacion"/></td>
                    <td><bean:message key="detalle.relacion.cu.relacion.no.valida.volver.param.titulo.relacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.relacion.cu.relacion.no.valida.volver.param.identificador.ode"/></td>
                    <td><bean:message key="detalle.relacion.cu.relacion.no.valida.volver.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.relacion.cu.relacion.no.valida.volver.param.boton.pulsado"/></td>
                    <td><bean:message key="detalle.relacion.cu.relacion.no.valida.volver.param.boton.pulsado.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.relacion.cu.relacion.no.valida.volver.param.combo.idioma"/></td>
                    <td><bean:message key="detalle.relacion.cu.relacion.no.valida.volver.param.combo.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.relacion.cu.relacion.no.valida.volver.param.descripcion"/></td>
                    <td><bean:message key="detalle.relacion.cu.relacion.no.valida.volver.param.descripcion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.relacion.cu.relacion.no.valida.volver.param.tipo"/></td>
                    <td><bean:message key="detalle.relacion.cu.relacion.no.valida.volver.param.tipo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.relacion.cu.relacion.no.valida.volver.param.catalogo"/></td>
                    <td><bean:message key="detalle.relacion.cu.relacion.no.valida.volver.param.catalogo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.relacion.cu.relacion.no.valida.volver.param.entrada"/></td>
                    <td><bean:message key="detalle.relacion.cu.relacion.no.valida.volver.param.entrada.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.relacion.cu.relacion.no.valida.volver.param.mensajes.error"/></td>
                    <td><bean:message key="detalle.relacion.cu.relacion.no.valida.volver.param.mensajes.error.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

