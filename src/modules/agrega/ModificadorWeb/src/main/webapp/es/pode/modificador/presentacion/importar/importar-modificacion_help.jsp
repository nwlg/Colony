<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="importar.modificacion.importar.modificacion"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="importar.modificacion.importar.modificacion"/></h1>
        <p>
            <bean:message key="importar.modificacion.importar.modificacion.online.help"/>
        </p>
        <h2><bean:message key="importar.modificacion.importar.modificacion.buscar"/></h2>
        <p>
            <bean:message key="importar.modificacion.importar.modificacion.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="importar.modificacion.importar.modificacion.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="importar.modificacion.importar.modificacion.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="importar.modificacion.importar.modificacion.buscar.param.tipo.busqueda"/></td>
                    <td><bean:message key="importar.modificacion.importar.modificacion.buscar.param.tipo.busqueda.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="importar.modificacion.importar.modificacion.importar"/></h2>
        <p>
            <bean:message key="importar.modificacion.importar.modificacion.importar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="importar.modificacion.importar.modificacion.importar.param.fichero"/></td>
                    <td><bean:message key="importar.modificacion.importar.modificacion.importar.param.fichero.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="importar.modificacion.importar.modificacion.importar.param.action"/></td>
                    <td><bean:message key="importar.modificacion.importar.modificacion.importar.param.action.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

