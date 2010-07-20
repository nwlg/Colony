<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="noticia.noticia"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="noticia.noticia"/></h1>
        <p>
            <bean:message key="noticia.noticia.online.help"/>
        </p>
        <h2><bean:message key="noticia.noticia.ver.mas.noticias"/></h2>
        <p>
            <bean:message key="noticia.noticia.ver.mas.noticias.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="noticia.noticia.accesibilidad"/></h2>
        <p>
            <bean:message key="noticia.noticia.accesibilidad.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="noticia.noticia.categoria"/></h2>
        <p>
            <bean:message key="noticia.noticia.categoria.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="noticia.noticia.categoria.param.categoria"/></td>
                    <td><bean:message key="noticia.noticia.categoria.param.categoria.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="noticia.noticia.categoria.param.id.categoria"/></td>
                    <td><bean:message key="noticia.noticia.categoria.param.id.categoria.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

