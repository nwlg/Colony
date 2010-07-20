<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="clasificacion.clasificacion.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="clasificacion.clasificacion.form"/></h1>
        <p>
            <bean:message key="clasificacion.clasificacion.form.online.help"/>
        </p>
        <h2><bean:message key="clasificacion.clasificacion.form.detalle.clasificacion"/></h2>
        <p>
            <bean:message key="clasificacion.clasificacion.form.detalle.clasificacion.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="clasificacion.clasificacion.form.detalle.clasificacion.param.identificador.ode"/></td>
                    <td><bean:message key="clasificacion.clasificacion.form.detalle.clasificacion.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="clasificacion.clasificacion.form.detalle.clasificacion.param.titulo.clasificacion"/></td>
                    <td><bean:message key="clasificacion.clasificacion.form.detalle.clasificacion.param.titulo.clasificacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="clasificacion.clasificacion.form.detalle.clasificacion.param.boton.pulsado"/></td>
                    <td><bean:message key="clasificacion.clasificacion.form.detalle.clasificacion.param.boton.pulsado.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="clasificacion.clasificacion.form.cancelar"/></h2>
        <p>
            <bean:message key="clasificacion.clasificacion.form.cancelar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="clasificacion.clasificacion.form.cancelar.param.identificador.ode"/></td>
                    <td><bean:message key="clasificacion.clasificacion.form.cancelar.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="clasificacion.clasificacion.form.cancelar.param.listado.clasificacion"/></td>
                    <td><bean:message key="clasificacion.clasificacion.form.cancelar.param.listado.clasificacion.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

