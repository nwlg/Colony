<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="modificar.catalogadores.modificar.catalogadores"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="modificar.catalogadores.modificar.catalogadores"/></h1>
        <p>
            <bean:message key="modificar.catalogadores.modificar.catalogadores.online.help"/>
        </p>
        <h2><bean:message key="modificar.catalogadores.modificar.catalogadores.aceptar"/></h2>
        <p>
            <bean:message key="modificar.catalogadores.modificar.catalogadores.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.catalogadores.modificar.catalogadores.aceptar.param.id"/></td>
                    <td><bean:message key="modificar.catalogadores.modificar.catalogadores.aceptar.param.id.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.catalogadores.modificar.catalogadores.aceptar.param.descripcion"/></td>
                    <td><bean:message key="modificar.catalogadores.modificar.catalogadores.aceptar.param.descripcion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.catalogadores.modificar.catalogadores.aceptar.param.nombre"/></td>
                    <td><bean:message key="modificar.catalogadores.modificar.catalogadores.aceptar.param.nombre.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="modificar.catalogadores.modificar.catalogadores.cancelar"/></h2>
        <p>
            <bean:message key="modificar.catalogadores.modificar.catalogadores.cancelar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

