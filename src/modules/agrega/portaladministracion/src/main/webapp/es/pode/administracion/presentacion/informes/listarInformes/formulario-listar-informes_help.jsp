<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="listar.informes.formulario.listar.informes"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="listar.informes.formulario.listar.informes"/></h1>
        <p>
            <bean:message key="listar.informes.formulario.listar.informes.online.help"/>
        </p>
        <h2><bean:message key="listar.informes.formulario.listar.informes.recuperar"/></h2>
        <p>
            <bean:message key="listar.informes.formulario.listar.informes.recuperar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="listar.informes.formulario.listar.informes.recuperar.param.nombre"/></td>
                    <td><bean:message key="listar.informes.formulario.listar.informes.recuperar.param.nombre.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="listar.informes.formulario.listar.informes.crear.informe"/></h2>
        <p>
            <bean:message key="listar.informes.formulario.listar.informes.crear.informe.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="listar.informes.formulario.listar.informes.listar.informes.federados"/></h2>
        <p>
            <bean:message key="listar.informes.formulario.listar.informes.listar.informes.federados.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

