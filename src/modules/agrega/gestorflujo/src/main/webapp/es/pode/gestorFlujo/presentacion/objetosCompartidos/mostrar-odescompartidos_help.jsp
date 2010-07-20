<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="objetos.compartidos.cu.mostrar.odescompartidos"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="objetos.compartidos.cu.mostrar.odescompartidos"/></h1>
        <p>
            <bean:message key="objetos.compartidos.cu.mostrar.odescompartidos.online.help"/>
        </p>
        <h2><bean:message key="objetos.compartidos.cu.mostrar.odescompartidos.exportar.compartidos"/></h2>
        <p>
            <bean:message key="objetos.compartidos.cu.mostrar.odescompartidos.exportar.compartidos.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="objetos.compartidos.cu.mostrar.odescompartidos.exportar.compartidos.param.id.ode"/></td>
                    <td><bean:message key="objetos.compartidos.cu.mostrar.odescompartidos.exportar.compartidos.param.id.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="objetos.compartidos.cu.mostrar.odescompartidos.exportar.compartidos.param.titulo"/></td>
                    <td><bean:message key="objetos.compartidos.cu.mostrar.odescompartidos.exportar.compartidos.param.titulo.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="objetos.compartidos.cu.mostrar.odescompartidos.importar.compartido"/></h2>
        <p>
            <bean:message key="objetos.compartidos.cu.mostrar.odescompartidos.importar.compartido.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="objetos.compartidos.cu.mostrar.odescompartidos.importar.compartido.param.id.ode"/></td>
                    <td><bean:message key="objetos.compartidos.cu.mostrar.odescompartidos.importar.compartido.param.id.ode.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

