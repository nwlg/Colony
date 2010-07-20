<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="crear.noticia.formulario"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="crear.noticia.formulario"/></h1>
        <p>
            <bean:message key="crear.noticia.formulario.online.help"/>
        </p>
        <h2><bean:message key="crear.noticia.formulario.valida"/></h2>
        <p>
            <bean:message key="crear.noticia.formulario.valida.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.noticia.formulario.valida.param.categoria"/></td>
                    <td><bean:message key="crear.noticia.formulario.valida.param.categoria.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.noticia.formulario.valida.param.imagen"/></td>
                    <td><bean:message key="crear.noticia.formulario.valida.param.imagen.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.noticia.formulario.valida.param.alineamiento"/></td>
                    <td><bean:message key="crear.noticia.formulario.valida.param.alineamiento.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.noticia.formulario.valida.param.estado"/></td>
                    <td><bean:message key="crear.noticia.formulario.valida.param.estado.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.noticia.formulario.valida.param.activar.imagen"/></td>
                    <td><bean:message key="crear.noticia.formulario.valida.param.activar.imagen.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.noticia.formulario.valida.param.nombre.imagen"/></td>
                    <td><bean:message key="crear.noticia.formulario.valida.param.nombre.imagen.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

