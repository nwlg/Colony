<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="navegar.lom.navegar.lom"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="navegar.lom.navegar.lom"/></h1>
        <p>
            <bean:message key="navegar.lom.navegar.lom.online.help"/>
        </p>
        <h2><bean:message key="navegar.lom.navegar.lom.navegar"/></h2>
        <p>
            <bean:message key="navegar.lom.navegar.lom.navegar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.lom.navegar.lom.navegar.param.id.termino"/></td>
                    <td><bean:message key="navegar.lom.navegar.lom.navegar.param.id.termino.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="navegar.lom.navegar.lom.seleccionar"/></h2>
        <p>
            <bean:message key="navegar.lom.navegar.lom.seleccionar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.lom.navegar.lom.seleccionar.param.termino.lom"/></td>
                    <td><bean:message key="navegar.lom.navegar.lom.seleccionar.param.termino.lom.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="navegar.lom.navegar.lom.seleccionar.param.action"/></td>
                    <td><bean:message key="navegar.lom.navegar.lom.seleccionar.param.action.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.lom.navegar.lom.seleccionar.param.id.termino"/></td>
                    <td><bean:message key="navegar.lom.navegar.lom.seleccionar.param.id.termino.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="navegar.lom.navegar.lom.buscar"/></h2>
        <p>
            <bean:message key="navegar.lom.navegar.lom.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.lom.navegar.lom.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="navegar.lom.navegar.lom.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="navegar.lom.navegar.lom.buscar.param.tipo.busqueda"/></td>
                    <td><bean:message key="navegar.lom.navegar.lom.buscar.param.tipo.busqueda.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

