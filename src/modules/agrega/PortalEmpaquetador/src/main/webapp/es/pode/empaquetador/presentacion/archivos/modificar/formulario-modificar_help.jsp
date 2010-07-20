<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="modificar.archivo.formulario.modificar"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="modificar.archivo.formulario.modificar"/></h1>
        <p>
            <bean:message key="modificar.archivo.formulario.modificar.online.help"/>
        </p>
        <h2><bean:message key="modificar.archivo.formulario.modificar.aceptar"/></h2>
        <p>
            <bean:message key="modificar.archivo.formulario.modificar.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.archivo.formulario.modificar.aceptar.param.nuevo.nombre"/></td>
                    <td><bean:message key="modificar.archivo.formulario.modificar.aceptar.param.nuevo.nombre.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.archivo.formulario.modificar.aceptar.param.archivo.vo"/></td>
                    <td><bean:message key="modificar.archivo.formulario.modificar.aceptar.param.archivo.vo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.archivo.formulario.modificar.aceptar.param.action"/></td>
                    <td><bean:message key="modificar.archivo.formulario.modificar.aceptar.param.action.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.archivo.formulario.modificar.aceptar.param.extension"/></td>
                    <td><bean:message key="modificar.archivo.formulario.modificar.aceptar.param.extension.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

