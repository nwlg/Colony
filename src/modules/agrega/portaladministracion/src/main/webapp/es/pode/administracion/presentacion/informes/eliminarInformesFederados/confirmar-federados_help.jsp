<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="eliminar.informes.federados.confirmar.federados"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="eliminar.informes.federados.confirmar.federados"/></h1>
        <p>
            <bean:message key="eliminar.informes.federados.confirmar.federados.online.help"/>
        </p>
        <h2><bean:message key="eliminar.informes.federados.confirmar.federados.aceptar"/></h2>
        <p>
            <bean:message key="eliminar.informes.federados.confirmar.federados.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="eliminar.informes.federados.confirmar.federados.aceptar.param.lista.id"/></td>
                    <td><bean:message key="eliminar.informes.federados.confirmar.federados.aceptar.param.lista.id.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="eliminar.informes.federados.confirmar.federados.aceptar.param.informes"/></td>
                    <td><bean:message key="eliminar.informes.federados.confirmar.federados.aceptar.param.informes.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="eliminar.informes.federados.confirmar.federados.cancelar"/></h2>
        <p>
            <bean:message key="eliminar.informes.federados.confirmar.federados.cancelar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

