<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado"/></h1>
        <p>
            <bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.online.help"/>
        </p>
        <h2><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle"/></h2>
        <p>
            <bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.anyo.publicacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.anyo.publicacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.area.curricular"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.area.curricular.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.autor"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.autor.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.buscador.contenido"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.buscador.contenido.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.busqueda.simple.avanzada"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.busqueda.simple.avanzada.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.c.s.secuencia"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.c.s.secuencia.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.comunidades.seleccionadas"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.comunidades.seleccionadas.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.contexto"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.contexto.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.dia.publicacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.dia.publicacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.edad"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.edad.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.enlace.comunidades.seleccionadas"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.enlace.comunidades.seleccionadas.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.enlace.todo.agrega"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.enlace.todo.agrega.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.formato"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.formato.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.id.tesauro"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.id.tesauro.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.id.tesauro.sugerencia"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.id.tesauro.sugerencia.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.identificador.ode"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.idioma.buscador"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.keyword"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.keyword.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.lista.ids"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.lista.ids.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.mes.publicacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.mes.publicacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.nivel.agregacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.nivel.agregacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.nodo.destino"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.nodo.destino.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.nom.tesauros"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.nom.tesauros.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.pagina"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.pagina.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.proceso.cognitivo"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.proceso.cognitivo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.recurso"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.recurso.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.tipo.busqueda"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.tipo.busqueda.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.tipo.layout.buscador"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.tipo.layout.buscador.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.tipo.visualizacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.tipo.visualizacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.valoracion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.preparar.retorno.detalle.param.valoracion.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados"/></h2>
        <p>
            <bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.anyo.publicacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.anyo.publicacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.mes.publicacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.mes.publicacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.dia.publicacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.dia.publicacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.autor"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.autor.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.buscador.contenido"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.buscador.contenido.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.buscador.contenido.solo"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.buscador.contenido.solo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.c.s.secuencia"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.c.s.secuencia.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.enlace.comunidades.seleccionadas"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.enlace.comunidades.seleccionadas.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.comunidades.seleccionadas"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.comunidades.seleccionadas.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.contexto"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.contexto.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.descripcion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.descripcion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.edad"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.edad.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.formato"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.formato.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.idioma.buscador"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.id.tesauro"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.id.tesauro.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.area.curricular"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.area.curricular.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.proceso.cognitivo"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.proceso.cognitivo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.recurso"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.recurso.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.titulo"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.titulo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.valoracion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.valoracion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.contador.ambito"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.contador.ambito.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.contador.areas.curriculares"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.contador.areas.curriculares.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.contador.propiedades.contenido"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.contador.propiedades.contenido.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.validado"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.validado.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.tipo.busqueda"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.tipo.busqueda.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.tipo.visualizacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.tipo.visualizacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.keyword"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.keyword.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.mostrar.ambito"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.mostrar.ambito.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.id.tesauro.sugerencia"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.param.id.tesauro.sugerencia.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.paginar"/></h2>
        <p>
            <bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.paginar.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes"/></h2>
        <p>
            <bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.anyo.publicacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.anyo.publicacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.mes.publicacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.mes.publicacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.dia.publicacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.dia.publicacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.autor"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.autor.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.buscador.contenido"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.buscador.contenido.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.buscador.contenido.solo"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.buscador.contenido.solo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.c.s.secuencia"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.c.s.secuencia.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.enlace.comunidades.seleccionadas"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.enlace.comunidades.seleccionadas.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.comunidades.seleccionadas"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.comunidades.seleccionadas.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.contexto"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.contexto.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.descripcion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.descripcion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.edad"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.edad.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.formato"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.formato.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.idioma.buscador"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.area.curricular"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.area.curricular.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.proceso.cognitivo"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.proceso.cognitivo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.recurso"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.recurso.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.titulo"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.titulo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.valoracion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.valoracion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.contador.ambito"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.contador.ambito.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.contador.areas.curriculares"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.contador.areas.curriculares.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.contador.propiedades.contenido"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.contador.propiedades.contenido.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.validado"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.validado.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.tipo.busqueda"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.tipo.busqueda.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.tipo.visualizacion"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.tipo.visualizacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.mostrar.ambito"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.mostrar.ambito.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.id.tesauro.sugerencia"/></td>
                    <td><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.buscar.resultados.imagenes.param.id.tesauro.sugerencia.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.mostrar.avanzado.imagenes"/></h2>
        <p>
            <bean:message key="buscar.avanzado.cu.mostrar.resultados.avanzado.mostrar.avanzado.imagenes.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

