<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="meta.metadatos.metadatos.no.valido"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="meta.metadatos.metadatos.no.valido"/></h1>
        <p>
            <bean:message key="meta.metadatos.metadatos.no.valido.online.help"/>
        </p>
        <h2><bean:message key="meta.metadatos.metadatos.no.valido.volver"/></h2>
        <p>
            <bean:message key="meta.metadatos.metadatos.no.valido.volver.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.identificador.ode"/></td>
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.identificadores"/></td>
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.identificadores.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.contribucion"/></td>
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.contribucion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.descripciones"/></td>
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.descripciones.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.combo.idioma"/></td>
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.combo.idioma.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.esquemas.meta"/></td>
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.esquemas.meta.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.combo.idioma.meta"/></td>
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.combo.idioma.meta.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.mensajes.error"/></td>
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.mensajes.error.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.crol"/></td>
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.crol.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.cidentidad"/></td>
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.cidentidad.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.fecha.corta"/></td>
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.fecha.corta.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.mes"/></td>
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.mes.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.anyo"/></td>
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.anyo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.hora"/></td>
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.hora.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.minutos"/></td>
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.minutos.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.segundo.p1"/></td>
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.segundo.p1.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.segundo.p2"/></td>
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.segundo.p2.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.meridianocero"/></td>
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.meridianocero.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.combo.zona.h"/></td>
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.combo.zona.h.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.zh.hora"/></td>
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.zh.hora.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.zh.minutos"/></td>
                    <td><bean:message key="meta.metadatos.metadatos.no.valido.volver.param.zh.minutos.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

