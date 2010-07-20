<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="gestor.archivos.gestor.archivos"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="gestor.archivos.gestor.archivos"/></h1>
        <p>
            <bean:message key="gestor.archivos.gestor.archivos.online.help"/>
        </p>
        <h2><bean:message key="gestor.archivos.gestor.archivos.vista"/></h2>
        <p>
            <bean:message key="gestor.archivos.gestor.archivos.vista.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
            </table>
        <h2><bean:message key="gestor.archivos.gestor.archivos.vaciar.portapapeles"/></h2>
        <p>
            <bean:message key="gestor.archivos.gestor.archivos.vaciar.portapapeles.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="gestor.archivos.gestor.archivos.archivos"/></h2>
        <p>
            <bean:message key="gestor.archivos.gestor.archivos.archivos.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="gestor.archivos.gestor.archivos.organizaciones"/></h2>
        <p>
            <bean:message key="gestor.archivos.gestor.archivos.organizaciones.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="gestor.archivos.gestor.archivos.recursos"/></h2>
        <p>
            <bean:message key="gestor.archivos.gestor.archivos.recursos.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="gestor.archivos.gestor.archivos.submanifiestos"/></h2>
        <p>
            <bean:message key="gestor.archivos.gestor.archivos.submanifiestos.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="gestor.archivos.gestor.archivos.catalogar"/></h2>
        <p>
            <bean:message key="gestor.archivos.gestor.archivos.catalogar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="gestor.archivos.gestor.archivos.catalogar.param.identificador"/></td>
                    <td><bean:message key="gestor.archivos.gestor.archivos.catalogar.param.identificador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="gestor.archivos.gestor.archivos.catalogar.param.return.url"/></td>
                    <td><bean:message key="gestor.archivos.gestor.archivos.catalogar.param.return.url.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="gestor.archivos.gestor.archivos.previsualizar"/></h2>
        <p>
            <bean:message key="gestor.archivos.gestor.archivos.previsualizar.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="gestor.archivos.gestor.archivos.validar"/></h2>
        <p>
            <bean:message key="gestor.archivos.gestor.archivos.validar.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="gestor.archivos.gestor.archivos.guardar"/></h2>
        <p>
            <bean:message key="gestor.archivos.gestor.archivos.guardar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="gestor.archivos.gestor.archivos.guardar.param.return.url"/></td>
                    <td><bean:message key="gestor.archivos.gestor.archivos.guardar.param.return.url.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="gestor.archivos.gestor.archivos.salir"/></h2>
        <p>
            <bean:message key="gestor.archivos.gestor.archivos.salir.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="gestor.archivos.gestor.archivos.estructura"/></h2>
        <p>
            <bean:message key="gestor.archivos.gestor.archivos.estructura.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

