<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="tecnica.tecnica.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="tecnica.tecnica.form"/></h1>
        <p>
            <bean:message key="tecnica.tecnica.form.online.help"/>
        </p>
        <h2><bean:message key="tecnica.tecnica.form.accion.submit"/></h2>
        <p>
            <bean:message key="tecnica.tecnica.form.accion.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.accion"/></td>
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.accion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.identificador.ode"/></td>
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.formatos"/></td>
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.formatos.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.combo.formato"/></td>
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.combo.formato.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.tamanio"/></td>
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.tamanio.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.localizacion"/></td>
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.localizacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.requerimiento"/></td>
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.requerimiento.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.agregador.or"/></td>
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.agregador.or.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.combo.tipo"/></td>
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.combo.tipo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.combo.nombre"/></td>
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.combo.nombre.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.descripcion.instalacion"/></td>
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.descripcion.instalacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.combo.idioma"/></td>
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.combo.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.descripcion.requerimientos"/></td>
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.descripcion.requerimientos.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.descripcion.duracion"/></td>
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.descripcion.duracion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.duracion"/></td>
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.duracion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.anyo"/></td>
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.anyo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.mes"/></td>
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.mes.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.dia"/></td>
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.dia.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.hora"/></td>
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.hora.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.minutos"/></td>
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.minutos.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.segundos.p1"/></td>
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.segundos.p1.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.segundos.p2"/></td>
                    <td><bean:message key="tecnica.tecnica.form.accion.submit.param.segundos.p2.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

