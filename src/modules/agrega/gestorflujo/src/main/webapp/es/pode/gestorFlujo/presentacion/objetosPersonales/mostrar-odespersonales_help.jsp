<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="objetos.personales.cu.mostrar.odespersonales"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="objetos.personales.cu.mostrar.odespersonales"/></h1>
        <p>
            <bean:message key="objetos.personales.cu.mostrar.odespersonales.online.help"/>
        </p>
        <h2><bean:message key="objetos.personales.cu.mostrar.odespersonales.ver.historial"/></h2>
        <p>
            <bean:message key="objetos.personales.cu.mostrar.odespersonales.ver.historial.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="objetos.personales.cu.mostrar.odespersonales.ver.historial.param.id.ode"/></td>
                    <td><bean:message key="objetos.personales.cu.mostrar.odespersonales.ver.historial.param.id.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="objetos.personales.cu.mostrar.odespersonales.ver.historial.param.titulo"/></td>
                    <td><bean:message key="objetos.personales.cu.mostrar.odespersonales.ver.historial.param.titulo.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="objetos.personales.cu.mostrar.odespersonales.importar"/></h2>
        <p>
            <bean:message key="objetos.personales.cu.mostrar.odespersonales.importar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="objetos.personales.cu.mostrar.odespersonales.importar.param.id.usuario"/></td>
                    <td><bean:message key="objetos.personales.cu.mostrar.odespersonales.importar.param.id.usuario.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="objetos.personales.cu.mostrar.odespersonales.importar.param.espacio.libre"/></td>
                    <td><bean:message key="objetos.personales.cu.mostrar.odespersonales.importar.param.espacio.libre.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="objetos.personales.cu.mostrar.odespersonales.compartir"/></h2>
        <p>
            <bean:message key="objetos.personales.cu.mostrar.odespersonales.compartir.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="objetos.personales.cu.mostrar.odespersonales.compartir.param.id.ode"/></td>
                    <td><bean:message key="objetos.personales.cu.mostrar.odespersonales.compartir.param.id.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="objetos.personales.cu.mostrar.odespersonales.compartir.param.compartido.sn"/></td>
                    <td><bean:message key="objetos.personales.cu.mostrar.odespersonales.compartir.param.compartido.sn.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

