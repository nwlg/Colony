<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="detalle.uso.edu.uso.educativo.no.valido"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="detalle.uso.edu.uso.educativo.no.valido"/></h1>
        <p>
            <bean:message key="detalle.uso.edu.uso.educativo.no.valido.online.help"/>
        </p>
        <h2><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver"/></h2>
        <p>
            <bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.titulo.uso.educativo"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.titulo.uso.educativo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.tipo.interactividad"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.tipo.interactividad.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.tipo.recurso"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.tipo.recurso.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.combo.tipo.recurso"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.combo.tipo.recurso.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.nivel.interactividad"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.nivel.interactividad.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.densidad.semantica"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.densidad.semantica.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.rol.usuario"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.rol.usuario.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.combo.rol"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.combo.rol.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.contexto"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.contexto.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.combo.contexto"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.combo.contexto.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.edad.tipica"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.edad.tipica.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.combo.idioma"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.combo.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.dificultad"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.dificultad.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.tiempo.aprendizaje"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.tiempo.aprendizaje.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.anyo"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.anyo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.mes"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.mes.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.dia"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.dia.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.hora"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.hora.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.minutos"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.minutos.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.segundos.p1"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.segundos.p1.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.segundos.p2"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.segundos.p2.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.tiempo.ap.descripcion"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.tiempo.ap.descripcion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.descripciones"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.descripciones.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.idiomas"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.idiomas.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.proceso.cognitivo"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.proceso.cognitivo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.combo.proceso"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.combo.proceso.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.boton.pulsado"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.boton.pulsado.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.mensajes.error"/></td>
                    <td><bean:message key="detalle.uso.edu.uso.educativo.no.valido.volver.param.mensajes.error.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

