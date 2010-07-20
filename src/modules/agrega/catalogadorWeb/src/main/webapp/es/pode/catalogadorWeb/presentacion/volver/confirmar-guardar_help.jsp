<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="volver.confirmar.guardar"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="volver.confirmar.guardar"/></h1>
        <p>
            <bean:message key="volver.confirmar.guardar.online.help"/>
        </p>
        <h2><bean:message key="volver.confirmar.guardar.datos.submit"/></h2>
        <p>
            <bean:message key="volver.confirmar.guardar.datos.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="volver.confirmar.guardar.datos.submit.param.accion"/></td>
                    <td><bean:message key="volver.confirmar.guardar.datos.submit.param.accion.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

