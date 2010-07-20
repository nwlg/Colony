<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="derechos.valido.no.ok"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="derechos.valido.no.ok"/></h1>
        <p>
            <bean:message key="derechos.valido.no.ok.online.help"/>
        </p>
        <h2><bean:message key="derechos.valido.no.ok.volver"/></h2>
        <p>
            <bean:message key="derechos.valido.no.ok.volver.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="derechos.valido.no.ok.volver.param.identificador.ode"/></td>
                    <td><bean:message key="derechos.valido.no.ok.volver.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="derechos.valido.no.ok.volver.param.coste"/></td>
                    <td><bean:message key="derechos.valido.no.ok.volver.param.coste.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="derechos.valido.no.ok.volver.param.copy.restricciones"/></td>
                    <td><bean:message key="derechos.valido.no.ok.volver.param.copy.restricciones.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="derechos.valido.no.ok.volver.param.descripciones"/></td>
                    <td><bean:message key="derechos.valido.no.ok.volver.param.descripciones.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="derechos.valido.no.ok.volver.param.combo.idioma"/></td>
                    <td><bean:message key="derechos.valido.no.ok.volver.param.combo.idioma.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="derechos.valido.no.ok.volver.param.tipo.acceso"/></td>
                    <td><bean:message key="derechos.valido.no.ok.volver.param.tipo.acceso.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="derechos.valido.no.ok.volver.param.listado.comunidades"/></td>
                    <td><bean:message key="derechos.valido.no.ok.volver.param.listado.comunidades.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

