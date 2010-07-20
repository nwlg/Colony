<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="ver.noticia.formulario.uno"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="ver.noticia.formulario.uno"/></h1>
        <p>
            <bean:message key="ver.noticia.formulario.uno.online.help"/>
        </p>
        <h2><bean:message key="ver.noticia.formulario.uno.siguiente"/></h2>
        <p>
            <bean:message key="ver.noticia.formulario.uno.siguiente.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.noticia.formulario.uno.siguiente.param.id.noticia"/></td>
                    <td><bean:message key="ver.noticia.formulario.uno.siguiente.param.id.noticia.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.noticia.formulario.uno.siguiente.param.categoria"/></td>
                    <td><bean:message key="ver.noticia.formulario.uno.siguiente.param.categoria.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

