<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="eliminar.faq.confirmacion"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="eliminar.faq.confirmacion"/></h1>
        <p>
            <bean:message key="eliminar.faq.confirmacion.online.help"/>
        </p>
        <h2><bean:message key="eliminar.faq.confirmacion.aceptar"/></h2>
        <p>
            <bean:message key="eliminar.faq.confirmacion.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="eliminar.faq.confirmacion.aceptar.param.faqs.deleted"/></td>
                    <td><bean:message key="eliminar.faq.confirmacion.aceptar.param.faqs.deleted.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="eliminar.faq.confirmacion.aceptar.param.lista.ids"/></td>
                    <td><bean:message key="eliminar.faq.confirmacion.aceptar.param.lista.ids.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="eliminar.faq.confirmacion.cancelar"/></h2>
        <p>
            <bean:message key="eliminar.faq.confirmacion.cancelar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

