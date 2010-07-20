<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="add.termino.add.termino"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="add.termino.add.termino"/></h1>
        <p>
            <bean:message key="add.termino.add.termino.online.help"/>
        </p>
        <h2><bean:message key="add.termino.add.termino.buscar"/></h2>
        <p>
            <bean:message key="add.termino.add.termino.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="add.termino.add.termino.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="add.termino.add.termino.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="add.termino.add.termino.buscar.param.tipo.busqueda"/></td>
                    <td><bean:message key="add.termino.add.termino.buscar.param.tipo.busqueda.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="add.termino.add.termino.action"/></h2>
        <p>
            <bean:message key="add.termino.add.termino.action.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="add.termino.add.termino.action.param.action"/></td>
                    <td><bean:message key="add.termino.add.termino.action.param.action.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="add.termino.add.termino.action.param.valor"/></td>
                    <td><bean:message key="add.termino.add.termino.action.param.valor.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

