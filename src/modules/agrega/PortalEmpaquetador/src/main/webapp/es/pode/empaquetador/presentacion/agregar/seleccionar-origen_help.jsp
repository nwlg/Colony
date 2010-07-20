<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="agregar.submanifiesto.seleccionar.origen"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="agregar.submanifiesto.seleccionar.origen"/></h1>
        <p>
            <bean:message key="agregar.submanifiesto.seleccionar.origen.online.help"/>
        </p>
        <h2><bean:message key="agregar.submanifiesto.seleccionar.origen.aceptar"/></h2>
        <p>
            <bean:message key="agregar.submanifiesto.seleccionar.origen.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="agregar.submanifiesto.seleccionar.origen.aceptar.param.origen"/></td>
                    <td><bean:message key="agregar.submanifiesto.seleccionar.origen.aceptar.param.origen.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

