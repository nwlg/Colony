<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="modificar.noticia.modificar.paso2"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="modificar.noticia.modificar.paso2"/></h1>
        <p>
            <bean:message key="modificar.noticia.modificar.paso2.online.help"/>
        </p>
        <h2><bean:message key="modificar.noticia.modificar.paso2.validar.formulario"/></h2>
        <p>
            <bean:message key="modificar.noticia.modificar.paso2.validar.formulario.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.id.noticia"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.id.noticia.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.imagen"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.imagen.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.alineamiento"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.alineamiento.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.estado"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.estado.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.categoria"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.categoria.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.nombre.imagen"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.nombre.imagen.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.castellano"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.castellano.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.catalan"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.catalan.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.euskera"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.euskera.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.ingles"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.ingles.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.valenciano"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.valenciano.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.gallego"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.gallego.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.activar.imagen"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.activar.imagen.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.nombre.imagen.vo"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso2.validar.formulario.param.nombre.imagen.vo.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="modificar.noticia.modificar.paso2.volver"/></h2>
        <p>
            <bean:message key="modificar.noticia.modificar.paso2.volver.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.noticia.modificar.paso2.volver.param.alineamiento"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso2.volver.param.alineamiento.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.noticia.modificar.paso2.volver.param.categoria"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso2.volver.param.categoria.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.noticia.modificar.paso2.volver.param.estado"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso2.volver.param.estado.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.noticia.modificar.paso2.volver.param.nombre.imagen"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso2.volver.param.nombre.imagen.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.noticia.modificar.paso2.volver.param.activar.imagen"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso2.volver.param.activar.imagen.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.noticia.modificar.paso2.volver.param.nombre.imagen.vo"/></td>
                    <td><bean:message key="modificar.noticia.modificar.paso2.volver.param.nombre.imagen.vo.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

