<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="modificaciones.ejecutandose.listado"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="modificaciones.ejecutandose.listado"/></h1>
        <p>
            <bean:message key="modificaciones.ejecutandose.listado.online.help"/>
        </p>
        <h2><bean:message key="modificaciones.ejecutandose.listado.ejecutadas"/></h2>
        <p>
            <bean:message key="modificaciones.ejecutandose.listado.ejecutadas.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="modificaciones.ejecutandose.listado.pendientes"/></h2>
        <p>
            <bean:message key="modificaciones.ejecutandose.listado.pendientes.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="modificaciones.ejecutandose.listado.busqueda"/></h2>
        <p>
            <bean:message key="modificaciones.ejecutandose.listado.busqueda.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificaciones.ejecutandose.listado.busqueda.param.idioma.buscador"/></td>
                    <td><bean:message key="modificaciones.ejecutandose.listado.busqueda.param.idioma.buscador.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

