<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="objetos.propuestos.cu.mostrar.odespropuestos"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="objetos.propuestos.cu.mostrar.odespropuestos"/></h1>
        <p>
            <bean:message key="objetos.propuestos.cu.mostrar.odespropuestos.online.help"/>
        </p>
        <h2><bean:message key="objetos.propuestos.cu.mostrar.odespropuestos.personales"/></h2>
        <p>
            <bean:message key="objetos.propuestos.cu.mostrar.odespropuestos.personales.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="objetos.propuestos.cu.mostrar.odespropuestos.publicados"/></h2>
        <p>
            <bean:message key="objetos.propuestos.cu.mostrar.odespropuestos.publicados.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="objetos.propuestos.cu.mostrar.odespropuestos.ver.historial"/></h2>
        <p>
            <bean:message key="objetos.propuestos.cu.mostrar.odespropuestos.ver.historial.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="objetos.propuestos.cu.mostrar.odespropuestos.ver.historial.param.id.ode"/></td>
                    <td><bean:message key="objetos.propuestos.cu.mostrar.odespropuestos.ver.historial.param.id.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="objetos.propuestos.cu.mostrar.odespropuestos.ver.historial.param.titulo"/></td>
                    <td><bean:message key="objetos.propuestos.cu.mostrar.odespropuestos.ver.historial.param.titulo.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

