<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="crear.categoria.noticia.cu.formulario.categorias.noticia"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="crear.categoria.noticia.cu.formulario.categorias.noticia"/></h1>
        <p>
            <bean:message key="crear.categoria.noticia.cu.formulario.categorias.noticia.online.help"/>
        </p>
        <h2><bean:message key="crear.categoria.noticia.cu.formulario.categorias.noticia.valida.formulario"/></h2>
        <p>
            <bean:message key="crear.categoria.noticia.cu.formulario.categorias.noticia.valida.formulario.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.categoria.noticia.cu.formulario.categorias.noticia.valida.formulario.param.nombre.categoria"/></td>
                    <td><bean:message key="crear.categoria.noticia.cu.formulario.categorias.noticia.valida.formulario.param.nombre.categoria.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.categoria.noticia.cu.formulario.categorias.noticia.valida.formulario.param.idiomas"/></td>
                    <td><bean:message key="crear.categoria.noticia.cu.formulario.categorias.noticia.valida.formulario.param.idiomas.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

