<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="listar.nodos.sqi.formulario.nodos.sqi"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="listar.nodos.sqi.formulario.nodos.sqi"/></h1>
        <p>
            <bean:message key="listar.nodos.sqi.formulario.nodos.sqi.online.help"/>
        </p>
        <h2><bean:message key="listar.nodos.sqi.formulario.nodos.sqi.crear.nodo.sqi"/></h2>
        <p>
            <bean:message key="listar.nodos.sqi.formulario.nodos.sqi.crear.nodo.sqi.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="listar.nodos.sqi.formulario.nodos.sqi.modificar.nodo.sqi"/></h2>
        <p>
            <bean:message key="listar.nodos.sqi.formulario.nodos.sqi.modificar.nodo.sqi.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.nodos.sqi.formulario.nodos.sqi.modificar.nodo.sqi.param.id"/></td>
                    <td><bean:message key="listar.nodos.sqi.formulario.nodos.sqi.modificar.nodo.sqi.param.id.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="listar.nodos.sqi.formulario.nodos.sqi.ver.nodo.sqi"/></h2>
        <p>
            <bean:message key="listar.nodos.sqi.formulario.nodos.sqi.ver.nodo.sqi.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.nodos.sqi.formulario.nodos.sqi.ver.nodo.sqi.param.id"/></td>
                    <td><bean:message key="listar.nodos.sqi.formulario.nodos.sqi.ver.nodo.sqi.param.id.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

