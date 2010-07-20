<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="crear.faq.formulario.categoria"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="crear.faq.formulario.categoria"/></h1>
        <p>
            <bean:message key="crear.faq.formulario.categoria.online.help"/>
        </p>
        <h2><bean:message key="crear.faq.formulario.categoria.valida"/></h2>
        <p>
            <bean:message key="crear.faq.formulario.categoria.valida.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.faq.formulario.categoria.valida.param.categoria"/></td>
                    <td><bean:message key="crear.faq.formulario.categoria.valida.param.categoria.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

