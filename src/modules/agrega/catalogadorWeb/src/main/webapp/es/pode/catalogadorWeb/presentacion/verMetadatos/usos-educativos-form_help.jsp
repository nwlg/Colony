<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="ver.metadatos.usos.educativos.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="ver.metadatos.usos.educativos.form"/></h1>
        <p>
            <bean:message key="ver.metadatos.usos.educativos.form.online.help"/>
        </p>
        <h2><bean:message key="ver.metadatos.usos.educativos.form.detalle.uso.educativo"/></h2>
        <p>
            <bean:message key="ver.metadatos.usos.educativos.form.detalle.uso.educativo.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.usos.educativos.form.detalle.uso.educativo.param.identificador.ode"/></td>
                    <td><bean:message key="ver.metadatos.usos.educativos.form.detalle.uso.educativo.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.usos.educativos.form.detalle.uso.educativo.param.listado.usos.edu"/></td>
                    <td><bean:message key="ver.metadatos.usos.educativos.form.detalle.uso.educativo.param.listado.usos.edu.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.usos.educativos.form.detalle.uso.educativo.param.boton.pulsado"/></td>
                    <td><bean:message key="ver.metadatos.usos.educativos.form.detalle.uso.educativo.param.boton.pulsado.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="ver.metadatos.usos.educativos.form.vuelve.de.usos.educativos"/></h2>
        <p>
            <bean:message key="ver.metadatos.usos.educativos.form.vuelve.de.usos.educativos.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

