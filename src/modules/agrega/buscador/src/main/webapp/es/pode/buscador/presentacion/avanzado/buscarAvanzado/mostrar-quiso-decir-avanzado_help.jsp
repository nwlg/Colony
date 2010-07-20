<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado"/></h1>
        <p>
            <bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.online.help"/>
        </p>
        <h2><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir"/></h2>
        <p>
            <bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.anyo.publicacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.anyo.publicacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.mes.publicacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.mes.publicacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.dia.publicacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.dia.publicacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.autor"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.autor.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.buscador.contenido"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.buscador.contenido.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.c.s.secuencia"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.c.s.secuencia.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.comunidades.seleccionadas"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.comunidades.seleccionadas.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.enlace.comunidades.seleccionadas"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.enlace.comunidades.seleccionadas.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.contexto"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.contexto.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.descripcion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.descripcion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.edad"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.edad.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.formato"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.formato.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.idioma"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.idioma.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.idioma.buscador"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.buscador.contenido.solo"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.buscador.contenido.solo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.tipo.busqueda"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.tipo.busqueda.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.tipo.visualizacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.tipo.visualizacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.tipo.layout.buscador"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.tipo.layout.buscador.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.id.tesauro"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.id.tesauro.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.nivel.agregacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.nivel.agregacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.keyword"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.keyword.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.mostrar.ambito"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.mostrar.ambito.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.id.tesauro.sugerencia"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.buscar.quiso.decir.param.id.tesauro.sugerencia.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.quiso.decir"/></h2>
        <p>
            <bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.quiso.decir.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.mostrar.avanzado.quiso.decir"/></h2>
        <p>
            <bean:message key="buscar.avanzado.cu.mostrar.quiso.decir.avanzado.mostrar.avanzado.quiso.decir.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

