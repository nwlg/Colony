<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="baja.nodo.sqi.confirmar"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="baja.nodo.sqi.confirmar"/></h1>
        <p>
            <bean:message key="baja.nodo.sqi.confirmar.online.help"/>
        </p>
        <h2><bean:message key="baja.nodo.sqi.confirmar.aceptar"/></h2>
        <p>
            <bean:message key="baja.nodo.sqi.confirmar.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="baja.nodo.sqi.confirmar.aceptar.param.lista.id"/></td>
                    <td><bean:message key="baja.nodo.sqi.confirmar.aceptar.param.lista.id.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="baja.nodo.sqi.confirmar.aceptar.param.nodos.sqieliminar"/></td>
                    <td><bean:message key="baja.nodo.sqi.confirmar.aceptar.param.nodos.sqieliminar.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="baja.nodo.sqi.confirmar.cancelar"/></h2>
        <p>
            <bean:message key="baja.nodo.sqi.confirmar.cancelar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

