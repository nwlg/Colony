<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="detalle.uso.edu.detalle.uso.educativo"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="detalle.uso.edu.detalle.uso.educativo"/></h1>
        <p>
            <bean:message key="detalle.uso.edu.detalle.uso.educativo.online.help"/>
        </p>
        <h2><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit"/></h2>
        <p>
            <bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.accion"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.accion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.titulo.uso.educativo"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.titulo.uso.educativo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.tipo.interactividad"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.tipo.interactividad.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.tipo.recurso"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.tipo.recurso.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.combo.tipo.recurso"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.combo.tipo.recurso.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.nivel.interactividad"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.nivel.interactividad.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.densidad.semantica"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.densidad.semantica.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.rol.usuario"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.rol.usuario.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.combo.rol"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.combo.rol.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.contexto"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.contexto.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.combo.contexto"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.combo.contexto.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.edad.tipica"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.edad.tipica.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.combo.idioma"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.combo.idioma.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.dificultad"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.dificultad.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.tiempo.aprendizaje"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.tiempo.aprendizaje.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.anyo"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.anyo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.mes"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.mes.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.dia"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.dia.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.hora"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.hora.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.minutos"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.minutos.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.segundos.p1"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.segundos.p1.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.segundos.p2"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.segundos.p2.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.tiempo.ap.descripcion"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.tiempo.ap.descripcion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.descripciones"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.descripciones.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.idiomas"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.idiomas.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.proceso.cognitivo"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.proceso.cognitivo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.combo.proceso"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.combo.proceso.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.boton.pulsado"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.boton.pulsado.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.descripcion.tipo.conocimiento"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.descripcion.tipo.conocimiento.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.descripcion.cat"/></td>
                    <td><bean:message key="detalle.uso.edu.detalle.uso.educativo.submit.param.descripcion.cat.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

