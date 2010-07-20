<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="alta.catalogadores.formulario.inicio.catalogadores"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="alta.catalogadores.formulario.inicio.catalogadores"/></h1>
        <p>
            <bean:message key="alta.catalogadores.formulario.inicio.catalogadores.online.help"/>
        </p>
        <h2><bean:message key="alta.catalogadores.formulario.inicio.catalogadores.aceptar"/></h2>
        <p>
            <bean:message key="alta.catalogadores.formulario.inicio.catalogadores.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="alta.catalogadores.formulario.inicio.catalogadores.aceptar.param.descripcion"/></td>
                    <td><bean:message key="alta.catalogadores.formulario.inicio.catalogadores.aceptar.param.descripcion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="alta.catalogadores.formulario.inicio.catalogadores.aceptar.param.nombre"/></td>
                    <td><bean:message key="alta.catalogadores.formulario.inicio.catalogadores.aceptar.param.nombre.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="alta.catalogadores.formulario.inicio.catalogadores.cancelar"/></h2>
        <p>
            <bean:message key="alta.catalogadores.formulario.inicio.catalogadores.cancelar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

