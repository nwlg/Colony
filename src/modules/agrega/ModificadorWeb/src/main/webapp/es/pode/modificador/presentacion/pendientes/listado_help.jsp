<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="modificaciones.pendientes.listado"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="modificaciones.pendientes.listado"/></h1>
        <p>
            <bean:message key="modificaciones.pendientes.listado.online.help"/>
        </p>
        <h2><bean:message key="modificaciones.pendientes.listado.ejecutandose"/></h2>
        <p>
            <bean:message key="modificaciones.pendientes.listado.ejecutandose.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="modificaciones.pendientes.listado.ejecutadas"/></h2>
        <p>
            <bean:message key="modificaciones.pendientes.listado.ejecutadas.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="modificaciones.pendientes.listado.planificar"/></h2>
        <p>
            <bean:message key="modificaciones.pendientes.listado.planificar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificaciones.pendientes.listado.planificar.param.id.modificacion"/></td>
                    <td><bean:message key="modificaciones.pendientes.listado.planificar.param.id.modificacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificaciones.pendientes.listado.planificar.param.id.planificador"/></td>
                    <td><bean:message key="modificaciones.pendientes.listado.planificar.param.id.planificador.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="modificaciones.pendientes.listado.buscar"/></h2>
        <p>
            <bean:message key="modificaciones.pendientes.listado.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificaciones.pendientes.listado.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="modificaciones.pendientes.listado.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

