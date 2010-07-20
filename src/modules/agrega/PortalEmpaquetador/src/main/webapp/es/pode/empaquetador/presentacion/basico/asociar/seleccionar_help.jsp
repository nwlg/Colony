<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="asociar.seleccionar"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="asociar.seleccionar"/></h1>
        <p>
            <bean:message key="asociar.seleccionar.online.help"/>
        </p>
        <h2><bean:message key="asociar.seleccionar.submit"/></h2>
        <p>
            <bean:message key="asociar.seleccionar.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="asociar.seleccionar.submit.param.tipo"/></td>
                    <td><bean:message key="asociar.seleccionar.submit.param.tipo.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="asociar.seleccionar.estructura"/></h2>
        <p>
            <bean:message key="asociar.seleccionar.estructura.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="asociar.seleccionar.archivos"/></h2>
        <p>
            <bean:message key="asociar.seleccionar.archivos.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

