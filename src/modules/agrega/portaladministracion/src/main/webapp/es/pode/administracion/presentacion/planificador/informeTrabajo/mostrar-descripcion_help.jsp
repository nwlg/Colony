<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="informe.mostrar.descripcion"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="informe.mostrar.descripcion"/></h1>
        <p>
            <bean:message key="informe.mostrar.descripcion.online.help"/>
        </p>
        <h2><bean:message key="informe.mostrar.descripcion.volver"/></h2>
        <p>
            <bean:message key="informe.mostrar.descripcion.volver.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="informe.mostrar.descripcion.volver.param.descripcion"/></td>
                    <td><bean:message key="informe.mostrar.descripcion.volver.param.descripcion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="informe.mostrar.descripcion.volver.param.id"/></td>
                    <td><bean:message key="informe.mostrar.descripcion.volver.param.id.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

