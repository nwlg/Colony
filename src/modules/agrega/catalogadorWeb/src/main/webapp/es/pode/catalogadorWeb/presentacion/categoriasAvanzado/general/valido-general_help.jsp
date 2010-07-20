<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="general.valido.general"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="general.valido.general"/></h1>
        <p>
            <bean:message key="general.valido.general.online.help"/>
        </p>
        <h2><bean:message key="general.valido.general.volver"/></h2>
        <p>
            <bean:message key="general.valido.general.volver.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="general.valido.general.volver.param.identificador.ode"/></td>
                    <td><bean:message key="general.valido.general.volver.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="general.valido.general.volver.param.estructura"/></td>
                    <td><bean:message key="general.valido.general.volver.param.estructura.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="general.valido.general.volver.param.nivel.agregacion"/></td>
                    <td><bean:message key="general.valido.general.volver.param.nivel.agregacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="general.valido.general.volver.param.identificadores"/></td>
                    <td><bean:message key="general.valido.general.volver.param.identificadores.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="general.valido.general.volver.param.titulos"/></td>
                    <td><bean:message key="general.valido.general.volver.param.titulos.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="general.valido.general.volver.param.idiomas"/></td>
                    <td><bean:message key="general.valido.general.volver.param.idiomas.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="general.valido.general.volver.param.descripciones"/></td>
                    <td><bean:message key="general.valido.general.volver.param.descripciones.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="general.valido.general.volver.param.palabras.clave"/></td>
                    <td><bean:message key="general.valido.general.volver.param.palabras.clave.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="general.valido.general.volver.param.ambitos"/></td>
                    <td><bean:message key="general.valido.general.volver.param.ambitos.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="general.valido.general.volver.param.combo.idioma"/></td>
                    <td><bean:message key="general.valido.general.volver.param.combo.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="general.valido.general.volver.param.mensajes.error"/></td>
                    <td><bean:message key="general.valido.general.volver.param.mensajes.error.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

