<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="publicar.cu.agregar.licencia"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="publicar.cu.agregar.licencia"/></h1>
        <p>
            <bean:message key="publicar.cu.agregar.licencia.online.help"/>
        </p>
        <h2><bean:message key="publicar.cu.agregar.licencia.aceptar"/></h2>
        <p>
            <bean:message key="publicar.cu.agregar.licencia.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="publicar.cu.agregar.licencia.aceptar.param.tipo.licencia.seleccionada"/></td>
                    <td><bean:message key="publicar.cu.agregar.licencia.aceptar.param.tipo.licencia.seleccionada.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="publicar.cu.agregar.licencia.aceptar.param.comunidades.seleccionadas"/></td>
                    <td><bean:message key="publicar.cu.agregar.licencia.aceptar.param.comunidades.seleccionadas.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="publicar.cu.agregar.licencia.aceptar.param.universal"/></td>
                    <td><bean:message key="publicar.cu.agregar.licencia.aceptar.param.universal.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="publicar.cu.agregar.licencia.cancelar"/></h2>
        <p>
            <bean:message key="publicar.cu.agregar.licencia.cancelar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

