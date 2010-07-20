<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="listar.log.formulario.listado.logs"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="listar.log.formulario.listado.logs"/></h1>
        <p>
            <bean:message key="listar.log.formulario.listado.logs.online.help"/>
        </p>
        <h2><bean:message key="listar.log.formulario.listado.logs.recuperar"/></h2>
        <p>
            <bean:message key="listar.log.formulario.listado.logs.recuperar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.log.formulario.listado.logs.recuperar.param.nombre"/></td>
                    <td><bean:message key="listar.log.formulario.listado.logs.recuperar.param.nombre.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

