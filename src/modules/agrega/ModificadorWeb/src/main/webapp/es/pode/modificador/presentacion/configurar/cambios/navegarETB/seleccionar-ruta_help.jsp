<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="navegar.etb.seleccionar.ruta"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="navegar.etb.seleccionar.ruta"/></h1>
        <p>
            <bean:message key="navegar.etb.seleccionar.ruta.online.help"/>
        </p>
        <h2><bean:message key="navegar.etb.seleccionar.ruta.submit"/></h2>
        <p>
            <bean:message key="navegar.etb.seleccionar.ruta.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.etb.seleccionar.ruta.submit.param.posicion"/></td>
                    <td><bean:message key="navegar.etb.seleccionar.ruta.submit.param.posicion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="navegar.etb.seleccionar.ruta.submit.param.id.termino"/></td>
                    <td><bean:message key="navegar.etb.seleccionar.ruta.submit.param.id.termino.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.etb.seleccionar.ruta.submit.param.action"/></td>
                    <td><bean:message key="navegar.etb.seleccionar.ruta.submit.param.action.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="navegar.etb.seleccionar.ruta.buscar"/></h2>
        <p>
            <bean:message key="navegar.etb.seleccionar.ruta.buscar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="navegar.etb.seleccionar.ruta.buscar.param.idioma.buscador"/></td>
                    <td><bean:message key="navegar.etb.seleccionar.ruta.buscar.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="navegar.etb.seleccionar.ruta.buscar.param.tipo.busqueda"/></td>
                    <td><bean:message key="navegar.etb.seleccionar.ruta.buscar.param.tipo.busqueda.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

