<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="modificar.noticia.modificar.paso1"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="modificar.noticia.modificar.paso1"/></h1>
        <p>
            <bean:message key="modificar.noticia.modificar.paso1.online.help"/>
        </p>
        <h2><bean:message key="modificar.noticia.modificar.paso1.aceptar"/></h2>
        <p>
            <bean:message key="modificar.noticia.modificar.paso1.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.noticia.modificar.paso1.aceptar.param.id.noticia"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso1.aceptar.param.id.noticia.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.noticia.modificar.paso1.aceptar.param.imagen"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso1.aceptar.param.imagen.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.noticia.modificar.paso1.aceptar.param.alineamiento"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso1.aceptar.param.alineamiento.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.noticia.modificar.paso1.aceptar.param.estado"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso1.aceptar.param.estado.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.noticia.modificar.paso1.aceptar.param.categoria"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso1.aceptar.param.categoria.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.noticia.modificar.paso1.aceptar.param.nombre.imagen"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso1.aceptar.param.nombre.imagen.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.noticia.modificar.paso1.aceptar.param.activar.imagen"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso1.aceptar.param.activar.imagen.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.noticia.modificar.paso1.aceptar.param.nombre.imagen.vo"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso1.aceptar.param.nombre.imagen.vo.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

