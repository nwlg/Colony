<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="eliminar.cu.confirmacion"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="eliminar.cu.confirmacion"/></h1>
        <p>
            <bean:message key="eliminar.cu.confirmacion.online.help"/>
        </p>
        <h2><bean:message key="eliminar.cu.confirmacion.aceptar"/></h2>
        <p>
            <bean:message key="eliminar.cu.confirmacion.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="eliminar.cu.confirmacion.aceptar.param.idioma.buscador"/></td>
                    <td><bean:message key="eliminar.cu.confirmacion.aceptar.param.idioma.buscador.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="eliminar.cu.confirmacion.cancelar"/></h2>
        <p>
            <bean:message key="eliminar.cu.confirmacion.cancelar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

