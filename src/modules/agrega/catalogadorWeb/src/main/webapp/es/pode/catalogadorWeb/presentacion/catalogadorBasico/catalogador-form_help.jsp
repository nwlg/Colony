<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="catalogador.basico.catalogador.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="catalogador.basico.catalogador.form"/></h1>
        <p>
            <bean:message key="catalogador.basico.catalogador.form.online.help"/>
        </p>
        <h2><bean:message key="catalogador.basico.catalogador.form.volver"/></h2>
        <p>
            <bean:message key="catalogador.basico.catalogador.form.volver.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="catalogador.basico.catalogador.form.submit"/></h2>
        <p>
            <bean:message key="catalogador.basico.catalogador.form.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="catalogador.basico.catalogador.form.submit.param.titulo"/></td>
                    <td><bean:message key="catalogador.basico.catalogador.form.submit.param.titulo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="catalogador.basico.catalogador.form.submit.param.idioma"/></td>
                    <td><bean:message key="catalogador.basico.catalogador.form.submit.param.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="catalogador.basico.catalogador.form.submit.param.descripcion"/></td>
                    <td><bean:message key="catalogador.basico.catalogador.form.submit.param.descripcion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="catalogador.basico.catalogador.form.submit.param.tipo.recurso"/></td>
                    <td><bean:message key="catalogador.basico.catalogador.form.submit.param.tipo.recurso.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="catalogador.basico.catalogador.form.submit.param.idioma.destinatario"/></td>
                    <td><bean:message key="catalogador.basico.catalogador.form.submit.param.idioma.destinatario.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="catalogador.basico.catalogador.form.submit.param.arboles"/></td>
                    <td><bean:message key="catalogador.basico.catalogador.form.submit.param.arboles.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="catalogador.basico.catalogador.form.submit.param.id.arbol"/></td>
                    <td><bean:message key="catalogador.basico.catalogador.form.submit.param.id.arbol.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="catalogador.basico.catalogador.form.importar"/></h2>
        <p>
            <bean:message key="catalogador.basico.catalogador.form.importar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

