<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="planificar.planificar.modificacion"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="planificar.planificar.modificacion"/></h1>
        <p>
            <bean:message key="planificar.planificar.modificacion.online.help"/>
        </p>
        <h2><bean:message key="planificar.planificar.modificacion.planificar"/></h2>
        <p>
            <bean:message key="planificar.planificar.modificacion.planificar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="planificar.planificar.modificacion.planificar.param.id.modificacion"/></td>
                    <td><bean:message key="planificar.planificar.modificacion.planificar.param.id.modificacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="planificar.planificar.modificacion.planificar.param.horas"/></td>
                    <td><bean:message key="planificar.planificar.modificacion.planificar.param.horas.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="planificar.planificar.modificacion.planificar.param.minutos"/></td>
                    <td><bean:message key="planificar.planificar.modificacion.planificar.param.minutos.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="planificar.planificar.modificacion.planificar.param.action"/></td>
                    <td><bean:message key="planificar.planificar.modificacion.planificar.param.action.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="planificar.planificar.modificacion.planificar.param.fecha"/></td>
                    <td><bean:message key="planificar.planificar.modificacion.planificar.param.fecha.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="planificar.planificar.modificacion.buscar"/></h2>
        <p>
            <bean:message key="planificar.planificar.modificacion.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="planificar.planificar.modificacion.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="planificar.planificar.modificacion.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

