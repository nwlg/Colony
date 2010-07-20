<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="detallar.odecu.mostrar.detalle.ode"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="detallar.odecu.mostrar.detalle.ode"/></h1>
        <p>
            <bean:message key="detallar.odecu.mostrar.detalle.ode.online.help"/>
        </p>
        <h2><bean:message key="detallar.odecu.mostrar.detalle.ode.descargar"/></h2>
        <p>
            <bean:message key="detallar.odecu.mostrar.detalle.ode.descargar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.descargar.param.identificador.ode"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.descargar.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.descargar.param.busqueda.simple.avanzada"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.descargar.param.busqueda.simple.avanzada.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.descargar.param.tipo.layout.buscador"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.descargar.param.tipo.layout.buscador.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.descargar.param.mostrar.vuelta"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.descargar.param.mostrar.vuelta.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="detallar.odecu.mostrar.detalle.ode.previsualizar"/></h2>
        <p>
            <bean:message key="detallar.odecu.mostrar.detalle.ode.previsualizar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.previsualizar.param.localizador.ode"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.previsualizar.param.localizador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.previsualizar.param.idioma.buscador"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.previsualizar.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.previsualizar.param.id.localizador"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.previsualizar.param.id.localizador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.previsualizar.param.identificador.ode"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.previsualizar.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.previsualizar.param.titulo"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.previsualizar.param.titulo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.previsualizar.param.busqueda.simple.avanzada"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.previsualizar.param.busqueda.simple.avanzada.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.previsualizar.param.tipo.busqueda"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.previsualizar.param.tipo.busqueda.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.previsualizar.param.tipo.layout.buscador"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.previsualizar.param.tipo.layout.buscador.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.previsualizar.param.seleccionar.secuencia"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.previsualizar.param.seleccionar.secuencia.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.previsualizar.param.mostrar.vuelta"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.previsualizar.param.mostrar.vuelta.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="detallar.odecu.mostrar.detalle.ode.enviar.mail"/></h2>
        <p>
            <bean:message key="detallar.odecu.mostrar.detalle.ode.enviar.mail.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.enviar.mail.param.identificador.ode"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.enviar.mail.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.enviar.mail.param.url.ode"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.enviar.mail.param.url.ode.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.enviar.mail.param.tipo.layout.buscador"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.enviar.mail.param.tipo.layout.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.enviar.mail.param.mostrar.vuelta"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.enviar.mail.param.mostrar.vuelta.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda"/></h2>
        <p>
            <bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.autor"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.autor.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.buscador.contenido"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.buscador.contenido.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.busqueda.simple.avanzada"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.busqueda.simple.avanzada.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.c.s.secuencia"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.c.s.secuencia.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.contexto"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.contexto.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.descripcion"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.descripcion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.edad"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.edad.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.anyo.publicacion"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.anyo.publicacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.formato"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.formato.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.idioma.buscador"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.area.curricular"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.area.curricular.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.pagina"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.pagina.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.proceso.cognitivo"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.proceso.cognitivo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.recurso"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.recurso.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.titulo"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.titulo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.valoracion"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.valoracion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.mes.publicacion"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.mes.publicacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.dia.publicacion"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.dia.publicacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.area.curricular.busqueda"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.area.curricular.busqueda.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.tipo.visualizacion"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.tipo.visualizacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.tipo.busqueda.arbol"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.tipo.busqueda.arbol.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.tipo.busqueda"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.volver.busqueda.param.tipo.busqueda.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="detallar.odecu.mostrar.detalle.ode.consultar.metadatos"/></h2>
        <p>
            <bean:message key="detallar.odecu.mostrar.detalle.ode.consultar.metadatos.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.consultar.metadatos.param.identificador.ode"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.consultar.metadatos.param.identificador.ode.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="detallar.odecu.mostrar.detalle.ode.gestionar.posicionado"/></h2>
        <p>
            <bean:message key="detallar.odecu.mostrar.detalle.ode.gestionar.posicionado.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="detallar.odecu.mostrar.detalle.ode.que.es.esto"/></h2>
        <p>
            <bean:message key="detallar.odecu.mostrar.detalle.ode.que.es.esto.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.que.es.esto.param.mostrar.vuelta"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.que.es.esto.param.mostrar.vuelta.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="detallar.odecu.mostrar.detalle.ode.introducir.comentarios"/></h2>
        <p>
            <bean:message key="detallar.odecu.mostrar.detalle.ode.introducir.comentarios.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="detallar.odecu.mostrar.detalle.ode.agregacion.ode"/></h2>
        <p>
            <bean:message key="detallar.odecu.mostrar.detalle.ode.agregacion.ode.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.agregacion.ode.param.titulo"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.agregacion.ode.param.titulo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.agregacion.ode.param.identificador.ode"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.agregacion.ode.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.agregacion.ode.param.agregacion.correcta"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.agregacion.ode.param.agregacion.correcta.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.agregacion.ode.param.tipo.layout.buscador"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.agregacion.ode.param.tipo.layout.buscador.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.agregacion.ode.param.tipo.agregacion"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.agregacion.ode.param.tipo.agregacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.agregacion.ode.param.idioma"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.agregacion.ode.param.idioma.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="detallar.odecu.mostrar.detalle.ode.listar.comentarios"/></h2>
        <p>
            <bean:message key="detallar.odecu.mostrar.detalle.ode.listar.comentarios.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.listar.comentarios.param.id.ode"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.listar.comentarios.param.id.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.listar.comentarios.param.titulo.ode"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.listar.comentarios.param.titulo.ode.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.listar.comentarios.param.imagen"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.listar.comentarios.param.imagen.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.listar.comentarios.param.idioma.ode"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.listar.comentarios.param.idioma.ode.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.listar.comentarios.param.tipo.layout.buscador"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.listar.comentarios.param.tipo.layout.buscador.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="detallar.odecu.mostrar.detalle.ode.anadir.odepersonal"/></h2>
        <p>
            <bean:message key="detallar.odecu.mostrar.detalle.ode.anadir.odepersonal.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="detallar.odecu.mostrar.detalle.ode.valorar.ode"/></h2>
        <p>
            <bean:message key="detallar.odecu.mostrar.detalle.ode.valorar.ode.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.valorar.ode.param.identificador.ode"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.valorar.ode.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.valorar.ode.param.idioma"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.valorar.ode.param.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.valorar.ode.param.valoracion"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.valorar.ode.param.valoracion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.valorar.ode.param.mostrar.vuelta"/></td>
                    <td><bean:message key="detallar.odecu.mostrar.detalle.ode.valorar.ode.param.mostrar.vuelta.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

