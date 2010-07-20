<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado"/></h1>
        <p>
            <bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.online.help"/>
        </p>
        <h2><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion"/></h2>
        <p>
            <bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.anyo.publicacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.anyo.publicacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.autor"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.autor.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.buscador.contenido"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.buscador.contenido.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.c.s.secuencia"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.c.s.secuencia.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.comunidades.seleccionadas"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.comunidades.seleccionadas.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.enlace.comunidades.seleccionadas"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.enlace.comunidades.seleccionadas.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.contexto"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.contexto.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.descripcion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.descripcion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.dia.publicacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.dia.publicacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.edad"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.edad.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.formato"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.formato.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.idioma.buscador"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.mes.publicacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.mes.publicacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.area.curricular"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.area.curricular.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.proceso.cognitivo"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.proceso.cognitivo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.nivel.agregacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.nivel.agregacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.recurso"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.recurso.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.titulo"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.titulo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.valoracion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.valoracion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.contador.ambito"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.contador.ambito.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.contador.areas.curriculares"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.contador.areas.curriculares.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.contador.propiedades.contenido"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.contador.propiedades.contenido.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.validado"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.validado.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.hora.publicacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.hora.publicacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.destinatarios"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.formulario.avanzado.analiza.pulsacion.param.destinatarios.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

