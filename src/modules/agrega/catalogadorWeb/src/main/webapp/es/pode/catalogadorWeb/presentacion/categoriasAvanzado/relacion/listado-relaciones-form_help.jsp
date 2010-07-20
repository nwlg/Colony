<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="relacion.listado.relaciones.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="relacion.listado.relaciones.form"/></h1>
        <p>
            <bean:message key="relacion.listado.relaciones.form.online.help"/>
        </p>
        <h2><bean:message key="relacion.listado.relaciones.form.detalles.relacion"/></h2>
        <p>
            <bean:message key="relacion.listado.relaciones.form.detalles.relacion.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="relacion.listado.relaciones.form.detalles.relacion.param.titulo.relacion"/></td>
                    <td><bean:message key="relacion.listado.relaciones.form.detalles.relacion.param.titulo.relacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="relacion.listado.relaciones.form.detalles.relacion.param.identificador.ode"/></td>
                    <td><bean:message key="relacion.listado.relaciones.form.detalles.relacion.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="relacion.listado.relaciones.form.detalles.relacion.param.boton.pulsado"/></td>
                    <td><bean:message key="relacion.listado.relaciones.form.detalles.relacion.param.boton.pulsado.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="relacion.listado.relaciones.form.cancelar"/></h2>
        <p>
            <bean:message key="relacion.listado.relaciones.form.cancelar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="relacion.listado.relaciones.form.cancelar.param.identificador.ode"/></td>
                    <td><bean:message key="relacion.listado.relaciones.form.cancelar.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="relacion.listado.relaciones.form.cancelar.param.listado.relaciones"/></td>
                    <td><bean:message key="relacion.listado.relaciones.form.cancelar.param.listado.relaciones.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

