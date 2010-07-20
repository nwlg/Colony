<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="configurar.modificacion.confirmacion.objetos"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="configurar.modificacion.confirmacion.objetos"/></h1>
        <p>
            <bean:message key="configurar.modificacion.confirmacion.objetos.online.help"/>
        </p>
        <h2><bean:message key="configurar.modificacion.confirmacion.objetos.submit.confirmacion.objetos"/></h2>
        <p>
            <bean:message key="configurar.modificacion.confirmacion.objetos.submit.confirmacion.objetos.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="configurar.modificacion.confirmacion.objetos.submit.confirmacion.objetos.param.action"/></td>
                    <td><bean:message key="configurar.modificacion.confirmacion.objetos.submit.confirmacion.objetos.param.action.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="configurar.modificacion.confirmacion.objetos.submit.confirmacion.objetos.param.paths"/></td>
                    <td><bean:message key="configurar.modificacion.confirmacion.objetos.submit.confirmacion.objetos.param.paths.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="configurar.modificacion.confirmacion.objetos.buscar"/></h2>
        <p>
            <bean:message key="configurar.modificacion.confirmacion.objetos.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="configurar.modificacion.confirmacion.objetos.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="configurar.modificacion.confirmacion.objetos.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="configurar.modificacion.confirmacion.objetos.buscar.param.tipo.busqueda"/></td>
                    <td><bean:message key="configurar.modificacion.confirmacion.objetos.buscar.param.tipo.busqueda.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

