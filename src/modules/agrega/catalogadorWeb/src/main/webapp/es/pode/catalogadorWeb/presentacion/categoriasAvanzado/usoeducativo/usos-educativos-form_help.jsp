<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="uso.educativo.usos.educativos.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="uso.educativo.usos.educativos.form"/></h1>
        <p>
            <bean:message key="uso.educativo.usos.educativos.form.online.help"/>
        </p>
        <h2><bean:message key="uso.educativo.usos.educativos.form.detalle.uso.edu"/></h2>
        <p>
            <bean:message key="uso.educativo.usos.educativos.form.detalle.uso.edu.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="uso.educativo.usos.educativos.form.detalle.uso.edu.param.identificador.ode"/></td>
                    <td><bean:message key="uso.educativo.usos.educativos.form.detalle.uso.edu.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="uso.educativo.usos.educativos.form.detalle.uso.edu.param.titulo.uso.educativo"/></td>
                    <td><bean:message key="uso.educativo.usos.educativos.form.detalle.uso.edu.param.titulo.uso.educativo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="uso.educativo.usos.educativos.form.detalle.uso.edu.param.boton.pulsado"/></td>
                    <td><bean:message key="uso.educativo.usos.educativos.form.detalle.uso.edu.param.boton.pulsado.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="uso.educativo.usos.educativos.form.cancelar"/></h2>
        <p>
            <bean:message key="uso.educativo.usos.educativos.form.cancelar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="uso.educativo.usos.educativos.form.cancelar.param.identificador.ode"/></td>
                    <td><bean:message key="uso.educativo.usos.educativos.form.cancelar.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="uso.educativo.usos.educativos.form.cancelar.param.listado.usos.edu"/></td>
                    <td><bean:message key="uso.educativo.usos.educativos.form.cancelar.param.listado.usos.edu.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

