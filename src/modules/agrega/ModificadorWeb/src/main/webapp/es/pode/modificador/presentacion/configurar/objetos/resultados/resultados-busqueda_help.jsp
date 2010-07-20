<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="resultados.buscar.objeto.resultados.busqueda"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="resultados.buscar.objeto.resultados.busqueda"/></h1>
        <p>
            <bean:message key="resultados.buscar.objeto.resultados.busqueda.online.help"/>
        </p>
        <h2><bean:message key="resultados.buscar.objeto.resultados.busqueda.buscar"/></h2>
        <p>
            <bean:message key="resultados.buscar.objeto.resultados.busqueda.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="resultados.buscar.objeto.resultados.busqueda.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="resultados.buscar.objeto.resultados.busqueda.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="resultados.buscar.objeto.resultados.busqueda.eliminar.todos"/></h2>
        <p>
            <bean:message key="resultados.buscar.objeto.resultados.busqueda.eliminar.todos.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="resultados.buscar.objeto.resultados.busqueda.anadir"/></h2>
        <p>
            <bean:message key="resultados.buscar.objeto.resultados.busqueda.anadir.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

