<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="proponer.cu.proponer.principal"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="proponer.cu.proponer.principal"/></h1>
        <p>
            <bean:message key="proponer.cu.proponer.principal.online.help"/>
        </p>
        <h2><bean:message key="proponer.cu.proponer.principal.aceptar"/></h2>
        <p>
            <bean:message key="proponer.cu.proponer.principal.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="proponer.cu.proponer.principal.aceptar.param.id.ode"/></td>
                    <td><bean:message key="proponer.cu.proponer.principal.aceptar.param.id.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="proponer.cu.proponer.principal.aceptar.param.titulo"/></td>
                    <td><bean:message key="proponer.cu.proponer.principal.aceptar.param.titulo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="proponer.cu.proponer.principal.aceptar.param.comentarios"/></td>
                    <td><bean:message key="proponer.cu.proponer.principal.aceptar.param.comentarios.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="proponer.cu.proponer.principal.cancelar"/></h2>
        <p>
            <bean:message key="proponer.cu.proponer.principal.cancelar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

