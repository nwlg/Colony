<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="eliminar.odes.cu.resultado.eliminacion"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="eliminar.odes.cu.resultado.eliminacion"/></h1>
        <p>
            <bean:message key="eliminar.odes.cu.resultado.eliminacion.online.help"/>
        </p>
        <h2><bean:message key="eliminar.odes.cu.resultado.eliminacion.aceptar"/></h2>
        <p>
            <bean:message key="eliminar.odes.cu.resultado.eliminacion.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="eliminar.odes.cu.resultado.eliminacion.aceptar.param.idioma"/></td>
                    <td><bean:message key="eliminar.odes.cu.resultado.eliminacion.aceptar.param.idioma.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="eliminar.odes.cu.resultado.eliminacion.aceptar.param.busqueda.simple.avanzada"/></td>
                    <td><bean:message key="eliminar.odes.cu.resultado.eliminacion.aceptar.param.busqueda.simple.avanzada.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="eliminar.odes.cu.resultado.eliminacion.aceptar.param.numero.resultados"/></td>
                    <td><bean:message key="eliminar.odes.cu.resultado.eliminacion.aceptar.param.numero.resultados.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="eliminar.odes.cu.resultado.eliminacion.buscar"/></h2>
        <p>
            <bean:message key="eliminar.odes.cu.resultado.eliminacion.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="eliminar.odes.cu.resultado.eliminacion.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="eliminar.odes.cu.resultado.eliminacion.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="eliminar.odes.cu.resultado.eliminacion.buscar.param.tipo.busqueda"/></td>
                    <td><bean:message key="eliminar.odes.cu.resultado.eliminacion.buscar.param.tipo.busqueda.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="eliminar.odes.cu.resultado.eliminacion.buscar.param.numero.resultados"/></td>
                    <td><bean:message key="eliminar.odes.cu.resultado.eliminacion.buscar.param.numero.resultados.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

