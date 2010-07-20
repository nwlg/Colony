<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="modificaciones.ejecutadas.listado"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="modificaciones.ejecutadas.listado"/></h1>
        <p>
            <bean:message key="modificaciones.ejecutadas.listado.online.help"/>
        </p>
        <h2><bean:message key="modificaciones.ejecutadas.listado.ejecutandose"/></h2>
        <p>
            <bean:message key="modificaciones.ejecutadas.listado.ejecutandose.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="modificaciones.ejecutadas.listado.pendientes"/></h2>
        <p>
            <bean:message key="modificaciones.ejecutadas.listado.pendientes.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="modificaciones.ejecutadas.listado.busqueda"/></h2>
        <p>
            <bean:message key="modificaciones.ejecutadas.listado.busqueda.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificaciones.ejecutadas.listado.busqueda.param.idioma.buscador"/></td>
                    <td><bean:message key="modificaciones.ejecutadas.listado.busqueda.param.idioma.buscador.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

