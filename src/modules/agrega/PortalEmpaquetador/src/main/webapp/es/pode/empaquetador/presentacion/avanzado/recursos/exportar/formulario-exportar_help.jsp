<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="exportar.recursos.avanzado.formulario.exportar"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="exportar.recursos.avanzado.formulario.exportar"/></h1>
        <p>
            <bean:message key="exportar.recursos.avanzado.formulario.exportar.online.help"/>
        </p>
        <h2><bean:message key="exportar.recursos.avanzado.formulario.exportar.select.action"/></h2>
        <p>
            <bean:message key="exportar.recursos.avanzado.formulario.exportar.select.action.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="exportar.recursos.avanzado.formulario.exportar.select.action.param.nombre"/></td>
                    <td><bean:message key="exportar.recursos.avanzado.formulario.exportar.select.action.param.nombre.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="exportar.recursos.avanzado.formulario.exportar.select.action.param.destino"/></td>
                    <td><bean:message key="exportar.recursos.avanzado.formulario.exportar.select.action.param.destino.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="exportar.recursos.avanzado.formulario.exportar.select.action.param.action"/></td>
                    <td><bean:message key="exportar.recursos.avanzado.formulario.exportar.select.action.param.action.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="exportar.recursos.avanzado.formulario.exportar.select.action.param.recursos.vo"/></td>
                    <td><bean:message key="exportar.recursos.avanzado.formulario.exportar.select.action.param.recursos.vo.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

