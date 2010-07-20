<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="agregar.local.subir.archivo"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="agregar.local.subir.archivo"/></h1>
        <p>
            <bean:message key="agregar.local.subir.archivo.online.help"/>
        </p>
        <h2><bean:message key="agregar.local.subir.archivo.aceptar"/></h2>
        <p>
            <bean:message key="agregar.local.subir.archivo.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="agregar.local.subir.archivo.aceptar.param.archivo"/></td>
                    <td><bean:message key="agregar.local.subir.archivo.aceptar.param.archivo.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

