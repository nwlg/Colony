<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="crear.archivo.crear.archivo"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="crear.archivo.crear.archivo"/></h1>
        <p>
            <bean:message key="crear.archivo.crear.archivo.online.help"/>
        </p>
        <h2><bean:message key="crear.archivo.crear.archivo.aceptar"/></h2>
        <p>
            <bean:message key="crear.archivo.crear.archivo.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.archivo.crear.archivo.aceptar.param.tipo1"/></td>
                    <td><bean:message key="crear.archivo.crear.archivo.aceptar.param.tipo1.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.archivo.crear.archivo.aceptar.param.fichero1"/></td>
                    <td><bean:message key="crear.archivo.crear.archivo.aceptar.param.fichero1.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.archivo.crear.archivo.aceptar.param.action"/></td>
                    <td><bean:message key="crear.archivo.crear.archivo.aceptar.param.action.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.archivo.crear.archivo.aceptar.param.fichero2"/></td>
                    <td><bean:message key="crear.archivo.crear.archivo.aceptar.param.fichero2.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.archivo.crear.archivo.aceptar.param.fichero3"/></td>
                    <td><bean:message key="crear.archivo.crear.archivo.aceptar.param.fichero3.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.archivo.crear.archivo.aceptar.param.tipo2"/></td>
                    <td><bean:message key="crear.archivo.crear.archivo.aceptar.param.tipo2.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.archivo.crear.archivo.aceptar.param.tipo3"/></td>
                    <td><bean:message key="crear.archivo.crear.archivo.aceptar.param.tipo3.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

