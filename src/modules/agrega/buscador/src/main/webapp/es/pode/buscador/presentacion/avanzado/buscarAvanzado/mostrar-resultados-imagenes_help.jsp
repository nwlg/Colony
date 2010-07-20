<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes"/></h1>
        <p>
            <bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.online.help"/>
        </p>
        <h2><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes"/></h2>
        <p>
            <bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.anyo.publicacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.anyo.publicacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.area.curricular"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.area.curricular.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.autor"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.autor.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.buscador.contenido"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.buscador.contenido.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.busqueda.simple.avanzada"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.busqueda.simple.avanzada.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.c.s.secuencia"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.c.s.secuencia.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.comunidades.seleccionadas"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.comunidades.seleccionadas.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.contexto"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.contexto.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.dia.publicacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.dia.publicacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.edad"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.edad.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.enlace.comunidades.seleccionadas"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.enlace.comunidades.seleccionadas.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.enlace.todo.agrega"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.enlace.todo.agrega.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.formato"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.formato.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.id.tesauro"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.id.tesauro.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.id.tesauro.sugerencia"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.id.tesauro.sugerencia.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.identificador.ode"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.idioma.buscador"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.keyword"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.keyword.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.lista.ids"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.lista.ids.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.mes.publicacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.mes.publicacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.nivel.agregacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.nivel.agregacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.nodo.destino"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.nodo.destino.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.nom.tesauros"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.nom.tesauros.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.numero.resultados"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.numero.resultados.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.pagina"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.pagina.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.proceso.cognitivo"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.proceso.cognitivo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.recurso"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.recurso.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.tipo.busqueda"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.tipo.busqueda.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.tipo.layout.buscador"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.tipo.layout.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.tipo.visualizacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.tipo.visualizacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.valoracion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.preparar.retorno.detalle.imagenes.param.valoracion.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.paginar.imagenes"/></h2>
        <p>
            <bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.paginar.imagenes.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss"/></h2>
        <p>
            <bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.anyo.publicacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.anyo.publicacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.area.curricular"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.area.curricular.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.autor"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.autor.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.buscador.contenido"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.buscador.contenido.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.c.s.secuencia"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.c.s.secuencia.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.contexto"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.contexto.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.descripcion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.descripcion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.dia.publicacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.dia.publicacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.edad"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.edad.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.formato"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.formato.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.idioma"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.idioma.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.keyword"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.keyword.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.id.tesauro"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.id.tesauro.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.id.tesauro.sugerencia"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.id.tesauro.sugerencia.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.mes.publicacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.mes.publicacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.proceso.cognitivo"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.proceso.cognitivo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.recurso"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.recurso.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.valoracion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.valoracion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.nivel.agregacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.nivel.agregacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.destinatarios"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.destinatarios.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.enlace.todo.agrega"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.enlace.todo.agrega.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.enlace.comunidades.seleccionadas"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.enlace.comunidades.seleccionadas.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.tipo.busqueda"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.generar.rss.param.tipo.busqueda.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.mostrar.avanzado.resultados"/></h2>
        <p>
            <bean:message key="buscar.avanzado.cu.mostrar.resultados.imagenes.mostrar.avanzado.resultados.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

