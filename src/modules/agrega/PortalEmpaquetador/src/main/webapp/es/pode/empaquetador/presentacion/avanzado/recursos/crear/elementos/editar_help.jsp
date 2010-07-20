<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="crear.recurso.avanzado.elementos.editar"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="crear.recurso.avanzado.elementos.editar"/></h1>
        <p>
            <bean:message key="crear.recurso.avanzado.elementos.editar.online.help"/>
        </p>
        <h2><bean:message key="crear.recurso.avanzado.elementos.editar.submit"/></h2>
        <p>
            <bean:message key="crear.recurso.avanzado.elementos.editar.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.recurso.avanzado.elementos.editar.submit.param.url"/></td>
                    <td><bean:message key="crear.recurso.avanzado.elementos.editar.submit.param.url.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.recurso.avanzado.elementos.editar.submit.param.action"/></td>
                    <td><bean:message key="crear.recurso.avanzado.elementos.editar.submit.param.action.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

