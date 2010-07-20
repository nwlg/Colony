<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="detallar.odecu.selecciona.cssecuencia"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="detallar.odecu.selecciona.cssecuencia"/></h1>
        <p>
            <bean:message key="detallar.odecu.selecciona.cssecuencia.online.help"/>
        </p>
        <h2><bean:message key="detallar.odecu.selecciona.cssecuencia.cancelar"/></h2>
        <p>
            <bean:message key="detallar.odecu.selecciona.cssecuencia.cancelar.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="detallar.odecu.selecciona.cssecuencia.mostrar.odecssecuencia"/></h2>
        <p>
            <bean:message key="detallar.odecu.selecciona.cssecuencia.mostrar.odecssecuencia.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.selecciona.cssecuencia.mostrar.odecssecuencia.param.identificador.ode"/></td>
                    <td><bean:message key="detallar.odecu.selecciona.cssecuencia.mostrar.odecssecuencia.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.selecciona.cssecuencia.mostrar.odecssecuencia.param.tipo.visualizador"/></td>
                    <td><bean:message key="detallar.odecu.selecciona.cssecuencia.mostrar.odecssecuencia.param.tipo.visualizador.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

