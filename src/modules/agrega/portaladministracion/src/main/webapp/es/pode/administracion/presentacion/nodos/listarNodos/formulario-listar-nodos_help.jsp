<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="listar.nodos.formulario.listar.nodos"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="listar.nodos.formulario.listar.nodos"/></h1>
        <p>
            <bean:message key="listar.nodos.formulario.listar.nodos.online.help"/>
        </p>
        <h2><bean:message key="listar.nodos.formulario.listar.nodos.crear.nodo"/></h2>
        <p>
            <bean:message key="listar.nodos.formulario.listar.nodos.crear.nodo.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="listar.nodos.formulario.listar.nodos.modificar.nodo"/></h2>
        <p>
            <bean:message key="listar.nodos.formulario.listar.nodos.modificar.nodo.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.nodos.formulario.listar.nodos.modificar.nodo.param.id"/></td>
                    <td><bean:message key="listar.nodos.formulario.listar.nodos.modificar.nodo.param.id.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="listar.nodos.formulario.listar.nodos.ver.nodo"/></h2>
        <p>
            <bean:message key="listar.nodos.formulario.listar.nodos.ver.nodo.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.nodos.formulario.listar.nodos.ver.nodo.param.id"/></td>
                    <td><bean:message key="listar.nodos.formulario.listar.nodos.ver.nodo.param.id.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

