<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="tesauros.tesauros.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="tesauros.tesauros.form"/></h1>
        <p>
            <bean:message key="tesauros.tesauros.form.online.help"/>
        </p>
        <h2><bean:message key="tesauros.tesauros.form.cancelar"/></h2>
        <p>
            <bean:message key="tesauros.tesauros.form.cancelar.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="tesauros.tesauros.form.asociar.tesauro"/></h2>
        <p>
            <bean:message key="tesauros.tesauros.form.asociar.tesauro.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tesauros.tesauros.form.asociar.tesauro.param.id"/></td>
                    <td><bean:message key="tesauros.tesauros.form.asociar.tesauro.param.id.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tesauros.tesauros.form.asociar.tesauro.param.nom.tesauro"/></td>
                    <td><bean:message key="tesauros.tesauros.form.asociar.tesauro.param.nom.tesauro.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tesauros.tesauros.form.asociar.tesauro.param.idioma"/></td>
                    <td><bean:message key="tesauros.tesauros.form.asociar.tesauro.param.idioma.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tesauros.tesauros.form.asociar.tesauro.param.ruta.padrevo"/></td>
                    <td><bean:message key="tesauros.tesauros.form.asociar.tesauro.param.ruta.padrevo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tesauros.tesauros.form.asociar.tesauro.param.taxonesvo"/></td>
                    <td><bean:message key="tesauros.tesauros.form.asociar.tesauro.param.taxonesvo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tesauros.tesauros.form.asociar.tesauro.param.texto.busqueda"/></td>
                    <td><bean:message key="tesauros.tesauros.form.asociar.tesauro.param.texto.busqueda.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="tesauros.tesauros.form.buscar"/></h2>
        <p>
            <bean:message key="tesauros.tesauros.form.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tesauros.tesauros.form.buscar.param.taxonesvo"/></td>
                    <td><bean:message key="tesauros.tesauros.form.buscar.param.taxonesvo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tesauros.tesauros.form.buscar.param.idioma"/></td>
                    <td><bean:message key="tesauros.tesauros.form.buscar.param.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tesauros.tesauros.form.buscar.param.nom.tesauro"/></td>
                    <td><bean:message key="tesauros.tesauros.form.buscar.param.nom.tesauro.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tesauros.tesauros.form.buscar.param.ruta.padrevo"/></td>
                    <td><bean:message key="tesauros.tesauros.form.buscar.param.ruta.padrevo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tesauros.tesauros.form.buscar.param.id"/></td>
                    <td><bean:message key="tesauros.tesauros.form.buscar.param.id.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="tesauros.tesauros.form.buscar.param.texto.busqueda"/></td>
                    <td><bean:message key="tesauros.tesauros.form.buscar.param.texto.busqueda.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="tesauros.tesauros.form.buscar.param.vocab.name"/></td>
                    <td><bean:message key="tesauros.tesauros.form.buscar.param.vocab.name.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

