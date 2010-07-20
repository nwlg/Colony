<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="listar.odearea.cu.listado.ode"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="listar.odearea.cu.listado.ode"/></h1>
        <p>
            <bean:message key="listar.odearea.cu.listado.ode.online.help"/>
        </p>
        <h2><bean:message key="listar.odearea.cu.listado.ode.decidir.salida"/></h2>
        <p>
            <bean:message key="listar.odearea.cu.listado.ode.decidir.salida.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.odearea.cu.listado.ode.decidir.salida.param.area.curricular.busqueda"/></td>
                    <td><bean:message key="listar.odearea.cu.listado.ode.decidir.salida.param.area.curricular.busqueda.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="listar.odearea.cu.listado.ode.decidir.salida.param.idioma"/></td>
                    <td><bean:message key="listar.odearea.cu.listado.ode.decidir.salida.param.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.odearea.cu.listado.ode.decidir.salida.param.idioma.buscador"/></td>
                    <td><bean:message key="listar.odearea.cu.listado.ode.decidir.salida.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="listar.odearea.cu.listado.ode.decidir.salida.param.identificador.ode"/></td>
                    <td><bean:message key="listar.odearea.cu.listado.ode.decidir.salida.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.odearea.cu.listado.ode.decidir.salida.param.pagina"/></td>
                    <td><bean:message key="listar.odearea.cu.listado.ode.decidir.salida.param.pagina.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="listar.odearea.cu.listado.ode.decidir.salida.param.ruta.arbol"/></td>
                    <td><bean:message key="listar.odearea.cu.listado.ode.decidir.salida.param.ruta.arbol.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.odearea.cu.listado.ode.decidir.salida.param.nodo"/></td>
                    <td><bean:message key="listar.odearea.cu.listado.ode.decidir.salida.param.nodo.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

