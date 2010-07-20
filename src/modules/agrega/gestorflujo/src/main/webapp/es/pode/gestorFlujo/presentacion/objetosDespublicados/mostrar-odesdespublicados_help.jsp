<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="objetos.despublicados.cu.mostrar.odesdespublicados"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="objetos.despublicados.cu.mostrar.odesdespublicados"/></h1>
        <p>
            <bean:message key="objetos.despublicados.cu.mostrar.odesdespublicados.online.help"/>
        </p>
        <h2><bean:message key="objetos.despublicados.cu.mostrar.odesdespublicados.ver.historial"/></h2>
        <p>
            <bean:message key="objetos.despublicados.cu.mostrar.odesdespublicados.ver.historial.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="objetos.despublicados.cu.mostrar.odesdespublicados.ver.historial.param.id.ode"/></td>
                    <td><bean:message key="objetos.despublicados.cu.mostrar.odesdespublicados.ver.historial.param.id.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="objetos.despublicados.cu.mostrar.odesdespublicados.ver.historial.param.titulo"/></td>
                    <td><bean:message key="objetos.despublicados.cu.mostrar.odesdespublicados.ver.historial.param.titulo.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="objetos.despublicados.cu.mostrar.odesdespublicados.pendientes"/></h2>
        <p>
            <bean:message key="objetos.despublicados.cu.mostrar.odesdespublicados.pendientes.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="objetos.despublicados.cu.mostrar.odesdespublicados.pendientes.param.idioma.buscador"/></td>
                    <td><bean:message key="objetos.despublicados.cu.mostrar.odesdespublicados.pendientes.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="objetos.despublicados.cu.mostrar.odesdespublicados.pendientes.param.tipo.buscador"/></td>
                    <td><bean:message key="objetos.despublicados.cu.mostrar.odesdespublicados.pendientes.param.tipo.buscador.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

