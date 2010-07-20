<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="buscar.objetos.buscar.objeto"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="buscar.objetos.buscar.objeto"/></h1>
        <p>
            <bean:message key="buscar.objetos.buscar.objeto.online.help"/>
        </p>
        <h2><bean:message key="buscar.objetos.buscar.objeto.select.action"/></h2>
        <p>
            <bean:message key="buscar.objetos.buscar.objeto.select.action.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.objetos.buscar.objeto.select.action.param.action"/></td>
                    <td><bean:message key="buscar.objetos.buscar.objeto.select.action.param.action.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.objetos.buscar.objeto.select.action.param.anyo.desde"/></td>
                    <td><bean:message key="buscar.objetos.buscar.objeto.select.action.param.anyo.desde.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.objetos.buscar.objeto.select.action.param.anyo.hasta"/></td>
                    <td><bean:message key="buscar.objetos.buscar.objeto.select.action.param.anyo.hasta.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.objetos.buscar.objeto.select.action.param.autor"/></td>
                    <td><bean:message key="buscar.objetos.buscar.objeto.select.action.param.autor.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.objetos.buscar.objeto.select.action.param.dia.desde"/></td>
                    <td><bean:message key="buscar.objetos.buscar.objeto.select.action.param.dia.desde.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.objetos.buscar.objeto.select.action.param.dia.hasta"/></td>
                    <td><bean:message key="buscar.objetos.buscar.objeto.select.action.param.dia.hasta.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.objetos.buscar.objeto.select.action.param.identificador"/></td>
                    <td><bean:message key="buscar.objetos.buscar.objeto.select.action.param.identificador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.objetos.buscar.objeto.select.action.param.mes.desde"/></td>
                    <td><bean:message key="buscar.objetos.buscar.objeto.select.action.param.mes.desde.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.objetos.buscar.objeto.select.action.param.mes.hasta"/></td>
                    <td><bean:message key="buscar.objetos.buscar.objeto.select.action.param.mes.hasta.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.objetos.buscar.objeto.select.action.param.titulo"/></td>
                    <td><bean:message key="buscar.objetos.buscar.objeto.select.action.param.titulo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.objetos.buscar.objeto.select.action.param.idioma"/></td>
                    <td><bean:message key="buscar.objetos.buscar.objeto.select.action.param.idioma.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="buscar.objetos.buscar.objeto.buscar"/></h2>
        <p>
            <bean:message key="buscar.objetos.buscar.objeto.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.objetos.buscar.objeto.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="buscar.objetos.buscar.objeto.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

