<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="modificar.nodos.sqi.formulario.nodo.sqi"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="modificar.nodos.sqi.formulario.nodo.sqi"/></h1>
        <p>
            <bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.online.help"/>
        </p>
        <h2><bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.aceptar"/></h2>
        <p>
            <bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.aceptar.param.id"/></td>
                    <td><bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.aceptar.param.id.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.aceptar.param.clave"/></td>
                    <td><bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.aceptar.param.clave.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.aceptar.param.descripcion.nodo"/></td>
                    <td><bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.aceptar.param.descripcion.nodo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.aceptar.param.gestor.sesion"/></td>
                    <td><bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.aceptar.param.gestor.sesion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.aceptar.param.identificador.sesion"/></td>
                    <td><bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.aceptar.param.identificador.sesion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.aceptar.param.lenguaje.consulta"/></td>
                    <td><bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.aceptar.param.lenguaje.consulta.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.aceptar.param.lenguaje.respuesta"/></td>
                    <td><bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.aceptar.param.lenguaje.respuesta.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.aceptar.param.nombre.nodo"/></td>
                    <td><bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.aceptar.param.nombre.nodo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.aceptar.param.url.servicio"/></td>
                    <td><bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.aceptar.param.url.servicio.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.aceptar.param.usuario"/></td>
                    <td><bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.aceptar.param.usuario.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.cancelar"/></h2>
        <p>
            <bean:message key="modificar.nodos.sqi.formulario.nodo.sqi.cancelar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

