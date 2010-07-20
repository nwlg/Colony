<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="listar.taxonomias.form.listar.taxonomias"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="listar.taxonomias.form.listar.taxonomias"/></h1>
        <p>
            <bean:message key="listar.taxonomias.form.listar.taxonomias.online.help"/>
        </p>
        <h2><bean:message key="listar.taxonomias.form.listar.taxonomias.buscar"/></h2>
        <p>
            <bean:message key="listar.taxonomias.form.listar.taxonomias.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.taxonomias.form.listar.taxonomias.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="listar.taxonomias.form.listar.taxonomias.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="listar.taxonomias.form.listar.taxonomias.alta"/></h2>
        <p>
            <bean:message key="listar.taxonomias.form.listar.taxonomias.alta.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="listar.taxonomias.form.listar.taxonomias.exportar"/></h2>
        <p>
            <bean:message key="listar.taxonomias.form.listar.taxonomias.exportar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.taxonomias.form.listar.taxonomias.exportar.param.nombre"/></td>
                    <td><bean:message key="listar.taxonomias.form.listar.taxonomias.exportar.param.nombre.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="listar.taxonomias.form.listar.taxonomias.exportar.param.tipo"/></td>
                    <td><bean:message key="listar.taxonomias.form.listar.taxonomias.exportar.param.tipo.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

