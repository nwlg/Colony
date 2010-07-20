<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="navegar.tesauro.cu.navegar.tesauro"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="navegar.tesauro.cu.navegar.tesauro"/></h1>
        <p>
            <bean:message key="navegar.tesauro.cu.navegar.tesauro.online.help"/>
        </p>
        <h2><bean:message key="navegar.tesauro.cu.navegar.tesauro.listar.odetesauro"/></h2>
        <p>
            <bean:message key="navegar.tesauro.cu.navegar.tesauro.listar.odetesauro.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.listar.odetesauro.param.id.tesauro"/></td>
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.listar.odetesauro.param.id.tesauro.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.listar.odetesauro.param.ruta.padre.vo"/></td>
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.listar.odetesauro.param.ruta.padre.vo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.listar.odetesauro.param.idioma.buscador"/></td>
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.listar.odetesauro.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.listar.odetesauro.param.idioma"/></td>
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.listar.odetesauro.param.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.listar.odetesauro.param.titulo.tesauro"/></td>
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.listar.odetesauro.param.titulo.tesauro.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.listar.odetesauro.param.num.max.resultados"/></td>
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.listar.odetesauro.param.num.max.resultados.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos"/></h2>
        <p>
            <bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.taxones.vo"/></td>
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.taxones.vo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.idioma"/></td>
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.ruta.padre.vo"/></td>
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.ruta.padre.vo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.id.tesauro"/></td>
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.id.tesauro.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.texto.busqueda"/></td>
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.texto.busqueda.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.es.ruta"/></td>
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.es.ruta.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.idioma.buscador"/></td>
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.numero.resultados"/></td>
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.numero.resultados.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.tipo.busqueda"/></td>
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.tipo.busqueda.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.tipo.busqueda.arbol"/></td>
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.tipo.busqueda.arbol.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.tipo.layoutbuscador"/></td>
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.tipo.layoutbuscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.nom.tesauro"/></td>
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.nom.tesauro.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.titulo.tesauro"/></td>
                    <td><bean:message key="navegar.tesauro.cu.navegar.tesauro.buscar.terminos.param.titulo.tesauro.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

