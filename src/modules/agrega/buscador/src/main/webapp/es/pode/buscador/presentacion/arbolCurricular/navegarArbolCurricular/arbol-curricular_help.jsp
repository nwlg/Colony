<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="navegar.arbol.curricular.cu.arbol.curricular"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="navegar.arbol.curricular.cu.arbol.curricular"/></h1>
        <p>
            <bean:message key="navegar.arbol.curricular.cu.arbol.curricular.online.help"/>
        </p>
        <h2><bean:message key="navegar.arbol.curricular.cu.arbol.curricular.seleccionar.hijo"/></h2>
        <p>
            <bean:message key="navegar.arbol.curricular.cu.arbol.curricular.seleccionar.hijo.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.arbol.curricular.cu.arbol.curricular.seleccionar.hijo.param.id"/></td>
                    <td><bean:message key="navegar.arbol.curricular.cu.arbol.curricular.seleccionar.hijo.param.id.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="navegar.arbol.curricular.cu.arbol.curricular.seleccionar.hijo.param.tipo.layout.buscador"/></td>
                    <td><bean:message key="navegar.arbol.curricular.cu.arbol.curricular.seleccionar.hijo.param.tipo.layout.buscador.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="navegar.arbol.curricular.cu.arbol.curricular.seleccionar.padre"/></h2>
        <p>
            <bean:message key="navegar.arbol.curricular.cu.arbol.curricular.seleccionar.padre.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.arbol.curricular.cu.arbol.curricular.seleccionar.padre.param.id"/></td>
                    <td><bean:message key="navegar.arbol.curricular.cu.arbol.curricular.seleccionar.padre.param.id.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="navegar.arbol.curricular.cu.arbol.curricular.seleccionar.padre.param.tipo.layout.buscador"/></td>
                    <td><bean:message key="navegar.arbol.curricular.cu.arbol.curricular.seleccionar.padre.param.tipo.layout.buscador.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="navegar.arbol.curricular.cu.arbol.curricular.listar.odearea"/></h2>
        <p>
            <bean:message key="navegar.arbol.curricular.cu.arbol.curricular.listar.odearea.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.arbol.curricular.cu.arbol.curricular.listar.odearea.param.area.curricular.busqueda"/></td>
                    <td><bean:message key="navegar.arbol.curricular.cu.arbol.curricular.listar.odearea.param.area.curricular.busqueda.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="navegar.arbol.curricular.cu.arbol.curricular.listar.odearea.param.ruta.arbol"/></td>
                    <td><bean:message key="navegar.arbol.curricular.cu.arbol.curricular.listar.odearea.param.ruta.arbol.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.arbol.curricular.cu.arbol.curricular.listar.odearea.param.idioma.buscador"/></td>
                    <td><bean:message key="navegar.arbol.curricular.cu.arbol.curricular.listar.odearea.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="navegar.arbol.curricular.cu.arbol.curricular.listar.odearea.param.idioma"/></td>
                    <td><bean:message key="navegar.arbol.curricular.cu.arbol.curricular.listar.odearea.param.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.arbol.curricular.cu.arbol.curricular.listar.odearea.param.num.max.resultados"/></td>
                    <td><bean:message key="navegar.arbol.curricular.cu.arbol.curricular.listar.odearea.param.num.max.resultados.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

