<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="tecnica.tecnica.no.valida"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="tecnica.tecnica.no.valida"/></h1>
        <p>
            <bean:message key="tecnica.tecnica.no.valida.online.help"/>
        </p>
        <h2><bean:message key="tecnica.tecnica.no.valida.volver"/></h2>
        <p>
            <bean:message key="tecnica.tecnica.no.valida.volver.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.identificador.ode"/></td>
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.formatos"/></td>
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.formatos.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.combo.formato"/></td>
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.combo.formato.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.tamanio"/></td>
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.tamanio.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.localizacion"/></td>
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.localizacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.requerimiento"/></td>
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.requerimiento.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.agregador.or"/></td>
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.agregador.or.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.combo.tipo"/></td>
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.combo.tipo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.combo.nombre"/></td>
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.combo.nombre.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.descripcion.instalacion"/></td>
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.descripcion.instalacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.combo.idioma"/></td>
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.combo.idioma.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.descripcion.requerimientos"/></td>
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.descripcion.requerimientos.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.descripcion.duracion"/></td>
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.descripcion.duracion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.duracion"/></td>
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.duracion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.anyo"/></td>
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.anyo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.mes"/></td>
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.mes.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.dia"/></td>
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.dia.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.hora"/></td>
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.hora.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.minutos"/></td>
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.minutos.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.segundos.p1"/></td>
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.segundos.p1.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.segundos.p2"/></td>
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.segundos.p2.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.mensajes.error"/></td>
                    <td><bean:message key="tecnica.tecnica.no.valida.volver.param.mensajes.error.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

