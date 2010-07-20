<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="tesauros.cu.tesauros"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="tesauros.cu.tesauros"/></h1>
        <p>
            <bean:message key="tesauros.cu.tesauros.online.help"/>
        </p>
        <h2><bean:message key="tesauros.cu.tesauros.cancelar"/></h2>
        <p>
            <bean:message key="tesauros.cu.tesauros.cancelar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tesauros.cu.tesauros.cancelar.param.tipo.layout.buscador"/></td>
                    <td><bean:message key="tesauros.cu.tesauros.cancelar.param.tipo.layout.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tesauros.cu.tesauros.cancelar.param.nom.tesauros"/></td>
                    <td><bean:message key="tesauros.cu.tesauros.cancelar.param.nom.tesauros.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tesauros.cu.tesauros.cancelar.param.id.tesauro"/></td>
                    <td><bean:message key="tesauros.cu.tesauros.cancelar.param.id.tesauro.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="tesauros.cu.tesauros.asociar.tesauro"/></h2>
        <p>
            <bean:message key="tesauros.cu.tesauros.asociar.tesauro.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tesauros.cu.tesauros.asociar.tesauro.param.nom.tesauros"/></td>
                    <td><bean:message key="tesauros.cu.tesauros.asociar.tesauro.param.nom.tesauros.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tesauros.cu.tesauros.asociar.tesauro.param.idioma"/></td>
                    <td><bean:message key="tesauros.cu.tesauros.asociar.tesauro.param.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tesauros.cu.tesauros.asociar.tesauro.param.id.tesauro"/></td>
                    <td><bean:message key="tesauros.cu.tesauros.asociar.tesauro.param.id.tesauro.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tesauros.cu.tesauros.asociar.tesauro.param.taxones.vo"/></td>
                    <td><bean:message key="tesauros.cu.tesauros.asociar.tesauro.param.taxones.vo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tesauros.cu.tesauros.asociar.tesauro.param.ruta.padre.vo"/></td>
                    <td><bean:message key="tesauros.cu.tesauros.asociar.tesauro.param.ruta.padre.vo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tesauros.cu.tesauros.asociar.tesauro.param.tipo.layout.buscador"/></td>
                    <td><bean:message key="tesauros.cu.tesauros.asociar.tesauro.param.tipo.layout.buscador.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="tesauros.cu.tesauros.buscar.terminos"/></h2>
        <p>
            <bean:message key="tesauros.cu.tesauros.buscar.terminos.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tesauros.cu.tesauros.buscar.terminos.param.nom.tesauros"/></td>
                    <td><bean:message key="tesauros.cu.tesauros.buscar.terminos.param.nom.tesauros.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tesauros.cu.tesauros.buscar.terminos.param.idioma"/></td>
                    <td><bean:message key="tesauros.cu.tesauros.buscar.terminos.param.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tesauros.cu.tesauros.buscar.terminos.param.taxones.vo"/></td>
                    <td><bean:message key="tesauros.cu.tesauros.buscar.terminos.param.taxones.vo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tesauros.cu.tesauros.buscar.terminos.param.ruta.padre.vo"/></td>
                    <td><bean:message key="tesauros.cu.tesauros.buscar.terminos.param.ruta.padre.vo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tesauros.cu.tesauros.buscar.terminos.param.id.tesauro"/></td>
                    <td><bean:message key="tesauros.cu.tesauros.buscar.terminos.param.id.tesauro.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tesauros.cu.tesauros.buscar.terminos.param.texto.busqueda"/></td>
                    <td><bean:message key="tesauros.cu.tesauros.buscar.terminos.param.texto.busqueda.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tesauros.cu.tesauros.buscar.terminos.param.es.ruta"/></td>
                    <td><bean:message key="tesauros.cu.tesauros.buscar.terminos.param.es.ruta.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tesauros.cu.tesauros.buscar.terminos.param.titulo.tesauro"/></td>
                    <td><bean:message key="tesauros.cu.tesauros.buscar.terminos.param.titulo.tesauro.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

