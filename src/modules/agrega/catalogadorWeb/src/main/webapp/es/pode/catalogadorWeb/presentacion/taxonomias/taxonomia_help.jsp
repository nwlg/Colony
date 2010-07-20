<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="taxonomias.taxonomia"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="taxonomias.taxonomia"/></h1>
        <p>
            <bean:message key="taxonomias.taxonomia.online.help"/>
        </p>
        <h2><bean:message key="taxonomias.taxonomia.asociar"/></h2>
        <p>
            <bean:message key="taxonomias.taxonomia.asociar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="taxonomias.taxonomia.asociar.param.ruta.padrevo"/></td>
                    <td><bean:message key="taxonomias.taxonomia.asociar.param.ruta.padrevo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="taxonomias.taxonomia.asociar.param.idioma"/></td>
                    <td><bean:message key="taxonomias.taxonomia.asociar.param.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="taxonomias.taxonomia.asociar.param.nom.taxonomia"/></td>
                    <td><bean:message key="taxonomias.taxonomia.asociar.param.nom.taxonomia.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="taxonomias.taxonomia.asociar.param.id"/></td>
                    <td><bean:message key="taxonomias.taxonomia.asociar.param.id.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="taxonomias.taxonomia.asociar.param.vocab.name"/></td>
                    <td><bean:message key="taxonomias.taxonomia.asociar.param.vocab.name.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="taxonomias.taxonomia.cancelar"/></h2>
        <p>
            <bean:message key="taxonomias.taxonomia.cancelar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

