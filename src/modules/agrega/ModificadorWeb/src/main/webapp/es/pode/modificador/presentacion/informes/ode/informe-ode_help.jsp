<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="informe.ode.informe.ode"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="informe.ode.informe.ode"/></h1>
        <p>
            <bean:message key="informe.ode.informe.ode.online.help"/>
        </p>
        <h2><bean:message key="informe.ode.informe.ode.volver"/></h2>
        <p>
            <bean:message key="informe.ode.informe.ode.volver.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="informe.ode.informe.ode.buscar"/></h2>
        <p>
            <bean:message key="informe.ode.informe.ode.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="informe.ode.informe.ode.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="informe.ode.informe.ode.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="informe.ode.informe.ode.buscar.param.tipo.busqueda"/></td>
                    <td><bean:message key="informe.ode.informe.ode.buscar.param.tipo.busqueda.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

