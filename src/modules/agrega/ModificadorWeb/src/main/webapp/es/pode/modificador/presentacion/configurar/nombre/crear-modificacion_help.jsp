<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="configurar.nombre.crear.modificacion"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="configurar.nombre.crear.modificacion"/></h1>
        <p>
            <bean:message key="configurar.nombre.crear.modificacion.online.help"/>
        </p>
        <h2><bean:message key="configurar.nombre.crear.modificacion.buscar"/></h2>
        <p>
            <bean:message key="configurar.nombre.crear.modificacion.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="configurar.nombre.crear.modificacion.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="configurar.nombre.crear.modificacion.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="configurar.nombre.crear.modificacion.continuar"/></h2>
        <p>
            <bean:message key="configurar.nombre.crear.modificacion.continuar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="configurar.nombre.crear.modificacion.continuar.param.nombre"/></td>
                    <td><bean:message key="configurar.nombre.crear.modificacion.continuar.param.nombre.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="configurar.nombre.crear.modificacion.continuar.param.action"/></td>
                    <td><bean:message key="configurar.nombre.crear.modificacion.continuar.param.action.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

