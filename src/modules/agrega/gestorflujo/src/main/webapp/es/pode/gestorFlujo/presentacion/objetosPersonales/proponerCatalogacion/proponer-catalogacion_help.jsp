<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="proponer.catalogacion.cu.proponer.catalogacion"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="proponer.catalogacion.cu.proponer.catalogacion"/></h1>
        <p>
            <bean:message key="proponer.catalogacion.cu.proponer.catalogacion.online.help"/>
        </p>
        <h2><bean:message key="proponer.catalogacion.cu.proponer.catalogacion.aceptar"/></h2>
        <p>
            <bean:message key="proponer.catalogacion.cu.proponer.catalogacion.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="proponer.catalogacion.cu.proponer.catalogacion.aceptar.param.id.ode"/></td>
                    <td><bean:message key="proponer.catalogacion.cu.proponer.catalogacion.aceptar.param.id.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="proponer.catalogacion.cu.proponer.catalogacion.aceptar.param.comentarios"/></td>
                    <td><bean:message key="proponer.catalogacion.cu.proponer.catalogacion.aceptar.param.comentarios.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="proponer.catalogacion.cu.proponer.catalogacion.aceptar.param.titulo"/></td>
                    <td><bean:message key="proponer.catalogacion.cu.proponer.catalogacion.aceptar.param.titulo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="proponer.catalogacion.cu.proponer.catalogacion.aceptar.param.seleccion"/></td>
                    <td><bean:message key="proponer.catalogacion.cu.proponer.catalogacion.aceptar.param.seleccion.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="proponer.catalogacion.cu.proponer.catalogacion.cancelar"/></h2>
        <p>
            <bean:message key="proponer.catalogacion.cu.proponer.catalogacion.cancelar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

