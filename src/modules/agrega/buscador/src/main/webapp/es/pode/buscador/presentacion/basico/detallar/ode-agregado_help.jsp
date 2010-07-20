<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="detallar.odecu.ode.agregado"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="detallar.odecu.ode.agregado"/></h1>
        <p>
            <bean:message key="detallar.odecu.ode.agregado.online.help"/>
        </p>
        <h2><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo"/></h2>
        <p>
            <bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.autor"/></td>
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.autor.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.buscador.contenido"/></td>
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.buscador.contenido.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.busqueda.simple.avanzada"/></td>
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.busqueda.simple.avanzada.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.c.s.secuencia"/></td>
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.c.s.secuencia.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.contexto"/></td>
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.contexto.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.descripcion"/></td>
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.descripcion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.edad"/></td>
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.edad.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.anyo.publicacion"/></td>
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.anyo.publicacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.formato"/></td>
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.formato.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.idioma.buscador"/></td>
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.area.curricular"/></td>
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.area.curricular.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.pagina"/></td>
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.pagina.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.proceso.cognitivo"/></td>
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.proceso.cognitivo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.recurso"/></td>
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.recurso.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.titulo"/></td>
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.titulo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.valoracion"/></td>
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.valoracion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.mes.publicacion"/></td>
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.mes.publicacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.dia.publicacion"/></td>
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.dia.publicacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.area.curricular.busqueda"/></td>
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.area.curricular.busqueda.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.tipo.visualizacion"/></td>
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.tipo.visualizacion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.tipo.busqueda.arbol"/></td>
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.tipo.busqueda.arbol.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.tipo.busqueda"/></td>
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.tipo.busqueda.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.tipo.layout.buscador"/></td>
                    <td><bean:message key="detallar.odecu.ode.agregado.agregar.nuevo.param.tipo.layout.buscador.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

