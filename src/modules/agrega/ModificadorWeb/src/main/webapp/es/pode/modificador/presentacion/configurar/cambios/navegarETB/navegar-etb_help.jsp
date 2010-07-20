<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="navegar.etb.navegar.etb"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="navegar.etb.navegar.etb"/></h1>
        <p>
            <bean:message key="navegar.etb.navegar.etb.online.help"/>
        </p>
        <h2><bean:message key="navegar.etb.navegar.etb.navegar"/></h2>
        <p>
            <bean:message key="navegar.etb.navegar.etb.navegar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.etb.navegar.etb.navegar.param.id.termino"/></td>
                    <td><bean:message key="navegar.etb.navegar.etb.navegar.param.id.termino.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="navegar.etb.navegar.etb.buscar"/></h2>
        <p>
            <bean:message key="navegar.etb.navegar.etb.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.etb.navegar.etb.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="navegar.etb.navegar.etb.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="navegar.etb.navegar.etb.buscar.param.tipo.busqueda"/></td>
                    <td><bean:message key="navegar.etb.navegar.etb.buscar.param.tipo.busqueda.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="navegar.etb.navegar.etb.seleccionar"/></h2>
        <p>
            <bean:message key="navegar.etb.navegar.etb.seleccionar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.etb.navegar.etb.seleccionar.param.id.termino"/></td>
                    <td><bean:message key="navegar.etb.navegar.etb.seleccionar.param.id.termino.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="navegar.etb.navegar.etb.seleccionar.param.action"/></td>
                    <td><bean:message key="navegar.etb.navegar.etb.seleccionar.param.action.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

