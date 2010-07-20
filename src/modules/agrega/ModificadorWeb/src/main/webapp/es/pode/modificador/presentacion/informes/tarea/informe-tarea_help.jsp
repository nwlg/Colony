<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="informe.tarea.informe.tarea"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="informe.tarea.informe.tarea"/></h1>
        <p>
            <bean:message key="informe.tarea.informe.tarea.online.help"/>
        </p>
        <h2><bean:message key="informe.tarea.informe.tarea.buscar"/></h2>
        <p>
            <bean:message key="informe.tarea.informe.tarea.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="informe.tarea.informe.tarea.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="informe.tarea.informe.tarea.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="informe.tarea.informe.tarea.select.origin"/></h2>
        <p>
            <bean:message key="informe.tarea.informe.tarea.select.origin.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

