<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="busqueda.sqicu.mostrar.resultados"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="busqueda.sqicu.mostrar.resultados"/></h1>
        <p>
            <bean:message key="busqueda.sqicu.mostrar.resultados.online.help"/>
        </p>
        <h2><bean:message key="busqueda.sqicu.mostrar.resultados.analiza.tipo.busqueda"/></h2>
        <p>
            <bean:message key="busqueda.sqicu.mostrar.resultados.analiza.tipo.busqueda.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="busqueda.sqicu.mostrar.resultados.analiza.tipo.busqueda.param.tipo.layout.buscador"/></td>
                    <td><bean:message key="busqueda.sqicu.mostrar.resultados.analiza.tipo.busqueda.param.tipo.layout.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="busqueda.sqicu.mostrar.resultados.analiza.tipo.busqueda.param.buscador.contenido"/></td>
                    <td><bean:message key="busqueda.sqicu.mostrar.resultados.analiza.tipo.busqueda.param.buscador.contenido.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="busqueda.sqicu.mostrar.resultados.analiza.tipo.busqueda.param.tipo.busqueda"/></td>
                    <td><bean:message key="busqueda.sqicu.mostrar.resultados.analiza.tipo.busqueda.param.tipo.busqueda.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="busqueda.sqicu.mostrar.resultados.analiza.tipo.busqueda.param.numero.resultados"/></td>
                    <td><bean:message key="busqueda.sqicu.mostrar.resultados.analiza.tipo.busqueda.param.numero.resultados.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="busqueda.sqicu.mostrar.resultados.analiza.tipo.busqueda.param.idioma.buscador"/></td>
                    <td><bean:message key="busqueda.sqicu.mostrar.resultados.analiza.tipo.busqueda.param.idioma.buscador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="busqueda.sqicu.mostrar.resultados.analiza.tipo.busqueda.param.resultados.desde"/></td>
                    <td><bean:message key="busqueda.sqicu.mostrar.resultados.analiza.tipo.busqueda.param.resultados.desde.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="busqueda.sqicu.mostrar.resultados.paginar.sqi"/></h2>
        <p>
            <bean:message key="busqueda.sqicu.mostrar.resultados.paginar.sqi.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

