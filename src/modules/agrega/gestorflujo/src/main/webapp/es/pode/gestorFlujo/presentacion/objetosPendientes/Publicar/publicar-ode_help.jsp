<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="publicar.cu.publicar.ode"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="publicar.cu.publicar.ode"/></h1>
        <p>
            <bean:message key="publicar.cu.publicar.ode.online.help"/>
        </p>
        <h2><bean:message key="publicar.cu.publicar.ode.cancelar"/></h2>
        <p>
            <bean:message key="publicar.cu.publicar.ode.cancelar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="publicar.cu.publicar.ode.cancelar.param.idioma.buscador"/></td>
                    <td><bean:message key="publicar.cu.publicar.ode.cancelar.param.idioma.buscador.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="publicar.cu.publicar.ode.modificar.licencia"/></h2>
        <p>
            <bean:message key="publicar.cu.publicar.ode.modificar.licencia.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="publicar.cu.publicar.ode.aceptar"/></h2>
        <p>
            <bean:message key="publicar.cu.publicar.ode.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="publicar.cu.publicar.ode.aceptar.param.titulo"/></td>
                    <td><bean:message key="publicar.cu.publicar.ode.aceptar.param.titulo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="publicar.cu.publicar.ode.aceptar.param.id.ode"/></td>
                    <td><bean:message key="publicar.cu.publicar.ode.aceptar.param.id.ode.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="publicar.cu.publicar.ode.aceptar.param.tipo.licencia.seleccionada"/></td>
                    <td><bean:message key="publicar.cu.publicar.ode.aceptar.param.tipo.licencia.seleccionada.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="publicar.cu.publicar.ode.aceptar.param.comunidades.seleccionadas"/></td>
                    <td><bean:message key="publicar.cu.publicar.ode.aceptar.param.comunidades.seleccionadas.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="publicar.cu.publicar.ode.aceptar.param.comentarios"/></td>
                    <td><bean:message key="publicar.cu.publicar.ode.aceptar.param.comentarios.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

