<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="listar.tesauros.form.listar.tesauros"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="listar.tesauros.form.listar.tesauros"/></h1>
        <p>
            <bean:message key="listar.tesauros.form.listar.tesauros.online.help"/>
        </p>
        <h2><bean:message key="listar.tesauros.form.listar.tesauros.buscar"/></h2>
        <p>
            <bean:message key="listar.tesauros.form.listar.tesauros.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.tesauros.form.listar.tesauros.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="listar.tesauros.form.listar.tesauros.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="listar.tesauros.form.listar.tesauros.alta"/></h2>
        <p>
            <bean:message key="listar.tesauros.form.listar.tesauros.alta.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="listar.tesauros.form.listar.tesauros.exportar"/></h2>
        <p>
            <bean:message key="listar.tesauros.form.listar.tesauros.exportar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.tesauros.form.listar.tesauros.exportar.param.nombre"/></td>
                    <td><bean:message key="listar.tesauros.form.listar.tesauros.exportar.param.nombre.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

