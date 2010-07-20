<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="eliminar.odes.cu.confirmacion"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="eliminar.odes.cu.confirmacion"/></h1>
        <p>
            <bean:message key="eliminar.odes.cu.confirmacion.online.help"/>
        </p>
        <h2><bean:message key="eliminar.odes.cu.confirmacion.cancelar"/></h2>
        <p>
            <bean:message key="eliminar.odes.cu.confirmacion.cancelar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="eliminar.odes.cu.confirmacion.cancelar.param.idioma"/></td>
                    <td><bean:message key="eliminar.odes.cu.confirmacion.cancelar.param.idioma.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="eliminar.odes.cu.confirmacion.cancelar.param.busqueda.simple.avanzada"/></td>
                    <td><bean:message key="eliminar.odes.cu.confirmacion.cancelar.param.busqueda.simple.avanzada.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="eliminar.odes.cu.confirmacion.cancelar.param.numero.resultados"/></td>
                    <td><bean:message key="eliminar.odes.cu.confirmacion.cancelar.param.numero.resultados.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="eliminar.odes.cu.confirmacion.aceptar"/></h2>
        <p>
            <bean:message key="eliminar.odes.cu.confirmacion.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="eliminar.odes.cu.confirmacion.aceptar.param.lista.ids"/></td>
                    <td><bean:message key="eliminar.odes.cu.confirmacion.aceptar.param.lista.ids.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="eliminar.odes.cu.confirmacion.aceptar.param.odes.deleted"/></td>
                    <td><bean:message key="eliminar.odes.cu.confirmacion.aceptar.param.odes.deleted.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="eliminar.odes.cu.confirmacion.aceptar.param.tipo.busqueda"/></td>
                    <td><bean:message key="eliminar.odes.cu.confirmacion.aceptar.param.tipo.busqueda.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="eliminar.odes.cu.confirmacion.aceptar.param.idioma.buscador"/></td>
                    <td><bean:message key="eliminar.odes.cu.confirmacion.aceptar.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="eliminar.odes.cu.confirmacion.aceptar.param.id.hits"/></td>
                    <td><bean:message key="eliminar.odes.cu.confirmacion.aceptar.param.id.hits.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="eliminar.odes.cu.confirmacion.aceptar.param.idioma"/></td>
                    <td><bean:message key="eliminar.odes.cu.confirmacion.aceptar.param.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="eliminar.odes.cu.confirmacion.aceptar.param.busqueda.simple.avanzada"/></td>
                    <td><bean:message key="eliminar.odes.cu.confirmacion.aceptar.param.busqueda.simple.avanzada.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="eliminar.odes.cu.confirmacion.aceptar.param.tipo.layout.buscador"/></td>
                    <td><bean:message key="eliminar.odes.cu.confirmacion.aceptar.param.tipo.layout.buscador.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="eliminar.odes.cu.confirmacion.aceptar.param.numero.resultados"/></td>
                    <td><bean:message key="eliminar.odes.cu.confirmacion.aceptar.param.numero.resultados.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="eliminar.odes.cu.confirmacion.buscar"/></h2>
        <p>
            <bean:message key="eliminar.odes.cu.confirmacion.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="eliminar.odes.cu.confirmacion.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="eliminar.odes.cu.confirmacion.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="eliminar.odes.cu.confirmacion.buscar.param.tipo.busqueda"/></td>
                    <td><bean:message key="eliminar.odes.cu.confirmacion.buscar.param.tipo.busqueda.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="eliminar.odes.cu.confirmacion.buscar.param.numero.resultados"/></td>
                    <td><bean:message key="eliminar.odes.cu.confirmacion.buscar.param.numero.resultados.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

