<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="crear.recurso.avanzado.elementos.archivo.principal"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="crear.recurso.avanzado.elementos.archivo.principal"/></h1>
        <p>
            <bean:message key="crear.recurso.avanzado.elementos.archivo.principal.online.help"/>
        </p>
        <h2><bean:message key="crear.recurso.avanzado.elementos.archivo.principal.aceptar"/></h2>
        <p>
            <bean:message key="crear.recurso.avanzado.elementos.archivo.principal.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.recurso.avanzado.elementos.archivo.principal.aceptar.param.action"/></td>
                    <td><bean:message key="crear.recurso.avanzado.elementos.archivo.principal.aceptar.param.action.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.recurso.avanzado.elementos.archivo.principal.aceptar.param.principal"/></td>
                    <td><bean:message key="crear.recurso.avanzado.elementos.archivo.principal.aceptar.param.principal.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

