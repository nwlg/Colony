<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="rechazar.pend.catalogacion.cu.rechazar"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="rechazar.pend.catalogacion.cu.rechazar"/></h1>
        <p>
            <bean:message key="rechazar.pend.catalogacion.cu.rechazar.online.help"/>
        </p>
        <h2><bean:message key="rechazar.pend.catalogacion.cu.rechazar.aceptar"/></h2>
        <p>
            <bean:message key="rechazar.pend.catalogacion.cu.rechazar.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="rechazar.pend.catalogacion.cu.rechazar.aceptar.param.titulo"/></td>
                    <td><bean:message key="rechazar.pend.catalogacion.cu.rechazar.aceptar.param.titulo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="rechazar.pend.catalogacion.cu.rechazar.aceptar.param.comentarios"/></td>
                    <td><bean:message key="rechazar.pend.catalogacion.cu.rechazar.aceptar.param.comentarios.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="rechazar.pend.catalogacion.cu.rechazar.aceptar.param.id.ode"/></td>
                    <td><bean:message key="rechazar.pend.catalogacion.cu.rechazar.aceptar.param.id.ode.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="rechazar.pend.catalogacion.cu.rechazar.cancelar"/></h2>
        <p>
            <bean:message key="rechazar.pend.catalogacion.cu.rechazar.cancelar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="rechazar.pend.catalogacion.cu.rechazar.cancelar.param.idioma.buscador"/></td>
                    <td><bean:message key="rechazar.pend.catalogacion.cu.rechazar.cancelar.param.idioma.buscador.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

