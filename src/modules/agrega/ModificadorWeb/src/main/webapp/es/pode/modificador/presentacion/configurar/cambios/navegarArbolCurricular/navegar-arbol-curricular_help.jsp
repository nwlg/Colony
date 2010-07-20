<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="navegar.arbol.curricular.navegar.arbol.curricular"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="navegar.arbol.curricular.navegar.arbol.curricular"/></h1>
        <p>
            <bean:message key="navegar.arbol.curricular.navegar.arbol.curricular.online.help"/>
        </p>
        <h2><bean:message key="navegar.arbol.curricular.navegar.arbol.curricular.navegar"/></h2>
        <p>
            <bean:message key="navegar.arbol.curricular.navegar.arbol.curricular.navegar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.arbol.curricular.navegar.arbol.curricular.navegar.param.id.termino"/></td>
                    <td><bean:message key="navegar.arbol.curricular.navegar.arbol.curricular.navegar.param.id.termino.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="navegar.arbol.curricular.navegar.arbol.curricular.buscar"/></h2>
        <p>
            <bean:message key="navegar.arbol.curricular.navegar.arbol.curricular.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.arbol.curricular.navegar.arbol.curricular.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="navegar.arbol.curricular.navegar.arbol.curricular.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="navegar.arbol.curricular.navegar.arbol.curricular.buscar.param.tipo.busqueda"/></td>
                    <td><bean:message key="navegar.arbol.curricular.navegar.arbol.curricular.buscar.param.tipo.busqueda.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="navegar.arbol.curricular.navegar.arbol.curricular.select.action"/></h2>
        <p>
            <bean:message key="navegar.arbol.curricular.navegar.arbol.curricular.select.action.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.arbol.curricular.navegar.arbol.curricular.select.action.param.action"/></td>
                    <td><bean:message key="navegar.arbol.curricular.navegar.arbol.curricular.select.action.param.action.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="navegar.arbol.curricular.navegar.arbol.curricular.select.action.param.id.termino"/></td>
                    <td><bean:message key="navegar.arbol.curricular.navegar.arbol.curricular.select.action.param.id.termino.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

