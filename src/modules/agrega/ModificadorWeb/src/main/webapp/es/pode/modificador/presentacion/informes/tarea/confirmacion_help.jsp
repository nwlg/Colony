<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="informe.tarea.confirmacion"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="informe.tarea.confirmacion"/></h1>
        <p>
            <bean:message key="informe.tarea.confirmacion.online.help"/>
        </p>
        <h2><bean:message key="informe.tarea.confirmacion.submit.confirmacion"/></h2>
        <p>
            <bean:message key="informe.tarea.confirmacion.submit.confirmacion.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="informe.tarea.confirmacion.submit.confirmacion.param.action"/></td>
                    <td><bean:message key="informe.tarea.confirmacion.submit.confirmacion.param.action.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="informe.tarea.confirmacion.submit.confirmacion.param.id"/></td>
                    <td><bean:message key="informe.tarea.confirmacion.submit.confirmacion.param.id.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="informe.tarea.confirmacion.buscar"/></h2>
        <p>
            <bean:message key="informe.tarea.confirmacion.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="informe.tarea.confirmacion.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="informe.tarea.confirmacion.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="informe.tarea.confirmacion.buscar.param.tipo.busqueda"/></td>
                    <td><bean:message key="informe.tarea.confirmacion.buscar.param.tipo.busqueda.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

