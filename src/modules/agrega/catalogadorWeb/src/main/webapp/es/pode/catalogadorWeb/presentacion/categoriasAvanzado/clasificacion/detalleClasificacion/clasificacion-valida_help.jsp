<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="detalle.clasificacion.clasificacion.valida"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="detalle.clasificacion.clasificacion.valida"/></h1>
        <p>
            <bean:message key="detalle.clasificacion.clasificacion.valida.online.help"/>
        </p>
        <h2><bean:message key="detalle.clasificacion.clasificacion.valida.volver"/></h2>
        <p>
            <bean:message key="detalle.clasificacion.clasificacion.valida.volver.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.clasificacion.clasificacion.valida.volver.param.titulo.clasificacion"/></td>
                    <td><bean:message key="detalle.clasificacion.clasificacion.valida.volver.param.titulo.clasificacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.clasificacion.clasificacion.valida.volver.param.razon"/></td>
                    <td><bean:message key="detalle.clasificacion.clasificacion.valida.volver.param.razon.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.clasificacion.clasificacion.valida.volver.param.ruta.taxonomica"/></td>
                    <td><bean:message key="detalle.clasificacion.clasificacion.valida.volver.param.ruta.taxonomica.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.clasificacion.clasificacion.valida.volver.param.source"/></td>
                    <td><bean:message key="detalle.clasificacion.clasificacion.valida.volver.param.source.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.clasificacion.clasificacion.valida.volver.param.combo.idioma"/></td>
                    <td><bean:message key="detalle.clasificacion.clasificacion.valida.volver.param.combo.idioma.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.clasificacion.clasificacion.valida.volver.param.descripciones"/></td>
                    <td><bean:message key="detalle.clasificacion.clasificacion.valida.volver.param.descripciones.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.clasificacion.clasificacion.valida.volver.param.palabras.clave"/></td>
                    <td><bean:message key="detalle.clasificacion.clasificacion.valida.volver.param.palabras.clave.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.clasificacion.clasificacion.valida.volver.param.boton.pulsado"/></td>
                    <td><bean:message key="detalle.clasificacion.clasificacion.valida.volver.param.boton.pulsado.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.clasificacion.clasificacion.valida.volver.param.mensajes.error"/></td>
                    <td><bean:message key="detalle.clasificacion.clasificacion.valida.volver.param.mensajes.error.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

