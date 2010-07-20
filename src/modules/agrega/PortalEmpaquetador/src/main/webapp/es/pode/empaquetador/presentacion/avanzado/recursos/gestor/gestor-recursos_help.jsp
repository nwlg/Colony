<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="gestor.recursos.gestor.recursos"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="gestor.recursos.gestor.recursos"/></h1>
        <p>
            <bean:message key="gestor.recursos.gestor.recursos.online.help"/>
        </p>
        <h2><bean:message key="gestor.recursos.gestor.recursos.archivos"/></h2>
        <p>
            <bean:message key="gestor.recursos.gestor.recursos.archivos.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="gestor.recursos.gestor.recursos.organizaciones"/></h2>
        <p>
            <bean:message key="gestor.recursos.gestor.recursos.organizaciones.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="gestor.recursos.gestor.recursos.recursos"/></h2>
        <p>
            <bean:message key="gestor.recursos.gestor.recursos.recursos.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="gestor.recursos.gestor.recursos.submanifiestos"/></h2>
        <p>
            <bean:message key="gestor.recursos.gestor.recursos.submanifiestos.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="gestor.recursos.gestor.recursos.guardar"/></h2>
        <p>
            <bean:message key="gestor.recursos.gestor.recursos.guardar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="gestor.recursos.gestor.recursos.guardar.param.return.url"/></td>
                    <td><bean:message key="gestor.recursos.gestor.recursos.guardar.param.return.url.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="gestor.recursos.gestor.recursos.catalogar"/></h2>
        <p>
            <bean:message key="gestor.recursos.gestor.recursos.catalogar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="gestor.recursos.gestor.recursos.catalogar.param.identificador"/></td>
                    <td><bean:message key="gestor.recursos.gestor.recursos.catalogar.param.identificador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="gestor.recursos.gestor.recursos.catalogar.param.return.url"/></td>
                    <td><bean:message key="gestor.recursos.gestor.recursos.catalogar.param.return.url.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="gestor.recursos.gestor.recursos.previsualizar"/></h2>
        <p>
            <bean:message key="gestor.recursos.gestor.recursos.previsualizar.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="gestor.recursos.gestor.recursos.salir"/></h2>
        <p>
            <bean:message key="gestor.recursos.gestor.recursos.salir.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="gestor.recursos.gestor.recursos.validar"/></h2>
        <p>
            <bean:message key="gestor.recursos.gestor.recursos.validar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

