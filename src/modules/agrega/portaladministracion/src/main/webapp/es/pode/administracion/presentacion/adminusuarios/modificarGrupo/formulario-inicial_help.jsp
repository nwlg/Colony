<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="modificar.grupo.formulario.inicial"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="modificar.grupo.formulario.inicial"/></h1>
        <p>
            <bean:message key="modificar.grupo.formulario.inicial.online.help"/>
        </p>
        <h2><bean:message key="modificar.grupo.formulario.inicial.continuar"/></h2>
        <p>
            <bean:message key="modificar.grupo.formulario.inicial.continuar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.grupo.formulario.inicial.continuar.param.descripcion"/></td>
                    <td><bean:message key="modificar.grupo.formulario.inicial.continuar.param.descripcion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.grupo.formulario.inicial.continuar.param.id"/></td>
                    <td><bean:message key="modificar.grupo.formulario.inicial.continuar.param.id.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="modificar.grupo.formulario.inicial.cancelar"/></h2>
        <p>
            <bean:message key="modificar.grupo.formulario.inicial.cancelar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

