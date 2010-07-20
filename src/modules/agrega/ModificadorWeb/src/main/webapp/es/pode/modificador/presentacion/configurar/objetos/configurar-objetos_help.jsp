<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="configurar.objetos.configurar.objetos"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="configurar.objetos.configurar.objetos"/></h1>
        <p>
            <bean:message key="configurar.objetos.configurar.objetos.online.help"/>
        </p>
        <h2><bean:message key="configurar.objetos.configurar.objetos.submit"/></h2>
        <p>
            <bean:message key="configurar.objetos.configurar.objetos.submit.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="configurar.objetos.configurar.objetos.buscar"/></h2>
        <p>
            <bean:message key="configurar.objetos.configurar.objetos.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="configurar.objetos.configurar.objetos.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="configurar.objetos.configurar.objetos.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

