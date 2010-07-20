<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="seleccion.tipo.busqueda.cu.seleccion.tipo.busqueda"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="seleccion.tipo.busqueda.cu.seleccion.tipo.busqueda"/></h1>
        <p>
            <bean:message key="seleccion.tipo.busqueda.cu.seleccion.tipo.busqueda.online.help"/>
        </p>
        <h2><bean:message key="seleccion.tipo.busqueda.cu.seleccion.tipo.busqueda.decidir.salida"/></h2>
        <p>
            <bean:message key="seleccion.tipo.busqueda.cu.seleccion.tipo.busqueda.decidir.salida.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="seleccion.tipo.busqueda.cu.seleccion.tipo.busqueda.decidir.salida.param.tipo.busqueda.arbol"/></td>
                    <td><bean:message key="seleccion.tipo.busqueda.cu.seleccion.tipo.busqueda.decidir.salida.param.tipo.busqueda.arbol.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="seleccion.tipo.busqueda.cu.seleccion.tipo.busqueda.decidir.salida.param.tipo.layout.buscador"/></td>
                    <td><bean:message key="seleccion.tipo.busqueda.cu.seleccion.tipo.busqueda.decidir.salida.param.tipo.layout.buscador.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="seleccion.tipo.busqueda.cu.seleccion.tipo.busqueda.decidir.salida.param.tipo.navegacion"/></td>
                    <td><bean:message key="seleccion.tipo.busqueda.cu.seleccion.tipo.busqueda.decidir.salida.param.tipo.navegacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="seleccion.tipo.busqueda.cu.seleccion.tipo.busqueda.decidir.salida.param.titulo.tesauro"/></td>
                    <td><bean:message key="seleccion.tipo.busqueda.cu.seleccion.tipo.busqueda.decidir.salida.param.titulo.tesauro.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

