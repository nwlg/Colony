<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="modificar.categoria.noticia.cu.formulario.mod.categorias.noti"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="modificar.categoria.noticia.cu.formulario.mod.categorias.noti"/></h1>
        <p>
            <bean:message key="modificar.categoria.noticia.cu.formulario.mod.categorias.noti.online.help"/>
        </p>
        <h2><bean:message key="modificar.categoria.noticia.cu.formulario.mod.categorias.noti.validar.formulario"/></h2>
        <p>
            <bean:message key="modificar.categoria.noticia.cu.formulario.mod.categorias.noti.validar.formulario.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.categoria.noticia.cu.formulario.mod.categorias.noti.validar.formulario.param.id.categoria.noticia"/></td>
                    <td><bean:message key="modificar.categoria.noticia.cu.formulario.mod.categorias.noti.validar.formulario.param.id.categoria.noticia.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="modificar.categoria.noticia.cu.formulario.mod.categorias.noti.validar.formulario.param.nombre.categoria"/></td>
                    <td><bean:message key="modificar.categoria.noticia.cu.formulario.mod.categorias.noti.validar.formulario.param.nombre.categoria.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="modificar.categoria.noticia.cu.formulario.mod.categorias.noti.validar.formulario.param.idiomas"/></td>
                    <td><bean:message key="modificar.categoria.noticia.cu.formulario.mod.categorias.noti.validar.formulario.param.idiomas.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

