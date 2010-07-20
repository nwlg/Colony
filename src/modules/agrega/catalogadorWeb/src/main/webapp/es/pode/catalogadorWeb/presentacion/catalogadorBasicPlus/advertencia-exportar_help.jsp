<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="catalogador.basic.plus.advertencia.exportar"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="catalogador.basic.plus.advertencia.exportar"/></h1>
        <p>
            <bean:message key="catalogador.basic.plus.advertencia.exportar.online.help"/>
        </p>
        <h2><bean:message key="catalogador.basic.plus.advertencia.exportar.submit"/></h2>
        <p>
            <bean:message key="catalogador.basic.plus.advertencia.exportar.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="catalogador.basic.plus.advertencia.exportar.submit.param.accion"/></td>
                    <td><bean:message key="catalogador.basic.plus.advertencia.exportar.submit.param.accion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="catalogador.basic.plus.advertencia.exportar.submit.param.arboles"/></td>
                    <td><bean:message key="catalogador.basic.plus.advertencia.exportar.submit.param.arboles.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="catalogador.basic.plus.advertencia.exportar.submit.param.contexto"/></td>
                    <td><bean:message key="catalogador.basic.plus.advertencia.exportar.submit.param.contexto.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="catalogador.basic.plus.advertencia.exportar.submit.param.descripcion"/></td>
                    <td><bean:message key="catalogador.basic.plus.advertencia.exportar.submit.param.descripcion.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="catalogador.basic.plus.advertencia.exportar.submit.param.edad"/></td>
                    <td><bean:message key="catalogador.basic.plus.advertencia.exportar.submit.param.edad.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="catalogador.basic.plus.advertencia.exportar.submit.param.idioma"/></td>
                    <td><bean:message key="catalogador.basic.plus.advertencia.exportar.submit.param.idioma.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="catalogador.basic.plus.advertencia.exportar.submit.param.idioma.destinatario"/></td>
                    <td><bean:message key="catalogador.basic.plus.advertencia.exportar.submit.param.idioma.destinatario.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="catalogador.basic.plus.advertencia.exportar.submit.param.proceso.cognitivo"/></td>
                    <td><bean:message key="catalogador.basic.plus.advertencia.exportar.submit.param.proceso.cognitivo.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="catalogador.basic.plus.advertencia.exportar.submit.param.tipo.recurso"/></td>
                    <td><bean:message key="catalogador.basic.plus.advertencia.exportar.submit.param.tipo.recurso.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="catalogador.basic.plus.advertencia.exportar.submit.param.titulo"/></td>
                    <td><bean:message key="catalogador.basic.plus.advertencia.exportar.submit.param.titulo.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

