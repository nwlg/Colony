<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="objetos.pendientes.cu.mostrar.odespendientes"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="objetos.pendientes.cu.mostrar.odespendientes"/></h1>
        <p>
            <bean:message key="objetos.pendientes.cu.mostrar.odespendientes.online.help"/>
        </p>
        <h2><bean:message key="objetos.pendientes.cu.mostrar.odespendientes.ver.historial"/></h2>
        <p>
            <bean:message key="objetos.pendientes.cu.mostrar.odespendientes.ver.historial.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="objetos.pendientes.cu.mostrar.odespendientes.ver.historial.param.id.ode"/></td>
                    <td><bean:message key="objetos.pendientes.cu.mostrar.odespendientes.ver.historial.param.id.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="objetos.pendientes.cu.mostrar.odespendientes.ver.historial.param.titulo"/></td>
                    <td><bean:message key="objetos.pendientes.cu.mostrar.odespendientes.ver.historial.param.titulo.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="objetos.pendientes.cu.mostrar.odespendientes.publicar.ode"/></h2>
        <p>
            <bean:message key="objetos.pendientes.cu.mostrar.odespendientes.publicar.ode.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="objetos.pendientes.cu.mostrar.odespendientes.publicar.ode.param.es.despublicado"/></td>
                    <td><bean:message key="objetos.pendientes.cu.mostrar.odespendientes.publicar.ode.param.es.despublicado.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="objetos.pendientes.cu.mostrar.odespendientes.publicar.ode.param.titulo"/></td>
                    <td><bean:message key="objetos.pendientes.cu.mostrar.odespendientes.publicar.ode.param.titulo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="objetos.pendientes.cu.mostrar.odespendientes.publicar.ode.param.id.ode"/></td>
                    <td><bean:message key="objetos.pendientes.cu.mostrar.odespendientes.publicar.ode.param.id.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="objetos.pendientes.cu.mostrar.odespendientes.publicar.ode.param.id.usuario"/></td>
                    <td><bean:message key="objetos.pendientes.cu.mostrar.odespendientes.publicar.ode.param.id.usuario.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

