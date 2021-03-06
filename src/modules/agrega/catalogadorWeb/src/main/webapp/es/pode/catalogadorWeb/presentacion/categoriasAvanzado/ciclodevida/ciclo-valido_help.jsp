<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="ciclo.de.vida.ciclo.valido"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="ciclo.de.vida.ciclo.valido"/></h1>
        <p>
            <bean:message key="ciclo.de.vida.ciclo.valido.online.help"/>
        </p>
        <h2><bean:message key="ciclo.de.vida.ciclo.valido.volver"/></h2>
        <p>
            <bean:message key="ciclo.de.vida.ciclo.valido.volver.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.identificador.ode"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.versiones"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.versiones.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.estatus"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.estatus.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.contribuciones"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.contribuciones.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.descripciones"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.descripciones.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.combo.idioma"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.combo.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.mensajes.error"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.mensajes.error.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.crol"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.crol.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.cidentidad"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.cidentidad.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.dia"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.dia.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.mes"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.mes.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.anyo"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.anyo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.hora"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.hora.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.minutos"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.minutos.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.segundo.p1"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.segundo.p1.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.segundo.p2"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.segundo.p2.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.meridianocero"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.meridianocero.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.combo.zona.h"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.combo.zona.h.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.zh.hora"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.zh.hora.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.zh.minutos"/></td>
                    <td><bean:message key="ciclo.de.vida.ciclo.valido.volver.param.zh.minutos.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

