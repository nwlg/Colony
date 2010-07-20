<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="eliminar.categoria.faq.confirmar.baja"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="eliminar.categoria.faq.confirmar.baja"/></h1>
        <p>
            <bean:message key="eliminar.categoria.faq.confirmar.baja.online.help"/>
        </p>
        <h2><bean:message key="eliminar.categoria.faq.confirmar.baja.cancelar"/></h2>
        <p>
            <bean:message key="eliminar.categoria.faq.confirmar.baja.cancelar.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="eliminar.categoria.faq.confirmar.baja.aceptar"/></h2>
        <p>
            <bean:message key="eliminar.categoria.faq.confirmar.baja.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="eliminar.categoria.faq.confirmar.baja.aceptar.param.categorias.borradas"/></td>
                    <td><bean:message key="eliminar.categoria.faq.confirmar.baja.aceptar.param.categorias.borradas.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="eliminar.categoria.faq.confirmar.baja.aceptar.param.lista.ids"/></td>
                    <td><bean:message key="eliminar.categoria.faq.confirmar.baja.aceptar.param.lista.ids.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

