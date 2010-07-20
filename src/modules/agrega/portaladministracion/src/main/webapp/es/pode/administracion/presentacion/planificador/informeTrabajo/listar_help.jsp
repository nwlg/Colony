<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="informe.listar"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="informe.listar"/></h1>
        <p>
            <bean:message key="informe.listar.online.help"/>
        </p>
        <h2><bean:message key="informe.listar.listar.tareas.ejecutadas"/></h2>
        <p>
            <bean:message key="informe.listar.listar.tareas.ejecutadas.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="informe.listar.listar.tareas.ejecutadas.param.trabajo"/></td>
                    <td><bean:message key="informe.listar.listar.tareas.ejecutadas.param.trabajo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="informe.listar.listar.tareas.ejecutadas.param.descripcion"/></td>
                    <td><bean:message key="informe.listar.listar.tareas.ejecutadas.param.descripcion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="informe.listar.listar.tareas.ejecutadas.param.fecha.inicio"/></td>
                    <td><bean:message key="informe.listar.listar.tareas.ejecutadas.param.fecha.inicio.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="informe.listar.listar.tareas.ejecutadas.param.fecha.fin"/></td>
                    <td><bean:message key="informe.listar.listar.tareas.ejecutadas.param.fecha.fin.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

