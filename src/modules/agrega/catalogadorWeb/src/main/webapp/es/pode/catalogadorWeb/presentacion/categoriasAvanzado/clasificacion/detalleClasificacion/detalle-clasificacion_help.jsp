<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="detalle.clasificacion.detalle.clasificacion"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="detalle.clasificacion.detalle.clasificacion"/></h1>
        <p>
            <bean:message key="detalle.clasificacion.detalle.clasificacion.online.help"/>
        </p>
        <h2><bean:message key="detalle.clasificacion.detalle.clasificacion.submit"/></h2>
        <p>
            <bean:message key="detalle.clasificacion.detalle.clasificacion.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.clasificacion.detalle.clasificacion.submit.param.accion"/></td>
                    <td><bean:message key="detalle.clasificacion.detalle.clasificacion.submit.param.accion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.clasificacion.detalle.clasificacion.submit.param.titulo.clasificacion"/></td>
                    <td><bean:message key="detalle.clasificacion.detalle.clasificacion.submit.param.titulo.clasificacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.clasificacion.detalle.clasificacion.submit.param.razon"/></td>
                    <td><bean:message key="detalle.clasificacion.detalle.clasificacion.submit.param.razon.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.clasificacion.detalle.clasificacion.submit.param.ruta.taxonomica"/></td>
                    <td><bean:message key="detalle.clasificacion.detalle.clasificacion.submit.param.ruta.taxonomica.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.clasificacion.detalle.clasificacion.submit.param.source"/></td>
                    <td><bean:message key="detalle.clasificacion.detalle.clasificacion.submit.param.source.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.clasificacion.detalle.clasificacion.submit.param.combo.idioma"/></td>
                    <td><bean:message key="detalle.clasificacion.detalle.clasificacion.submit.param.combo.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.clasificacion.detalle.clasificacion.submit.param.descripciones"/></td>
                    <td><bean:message key="detalle.clasificacion.detalle.clasificacion.submit.param.descripciones.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.clasificacion.detalle.clasificacion.submit.param.palabras.clave"/></td>
                    <td><bean:message key="detalle.clasificacion.detalle.clasificacion.submit.param.palabras.clave.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.clasificacion.detalle.clasificacion.submit.param.boton.pulsado"/></td>
                    <td><bean:message key="detalle.clasificacion.detalle.clasificacion.submit.param.boton.pulsado.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.clasificacion.detalle.clasificacion.submit.param.vocab.name"/></td>
                    <td><bean:message key="detalle.clasificacion.detalle.clasificacion.submit.param.vocab.name.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

