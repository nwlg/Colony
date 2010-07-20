<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="visualizar.visualizar.datos.nav"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="visualizar.visualizar.datos.nav"/></h1>
        <p>
            <bean:message key="visualizar.visualizar.datos.nav.online.help"/>
        </p>
        <h2><bean:message key="visualizar.visualizar.datos.nav.secuencia.boton"/></h2>
        <p>
            <bean:message key="visualizar.visualizar.datos.nav.secuencia.boton.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="visualizar.visualizar.datos.nav.secuencia.boton.param.contador"/></td>
                    <td><bean:message key="visualizar.visualizar.datos.nav.secuencia.boton.param.contador.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="visualizar.visualizar.datos.nav.salir"/></h2>
        <p>
            <bean:message key="visualizar.visualizar.datos.nav.salir.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

