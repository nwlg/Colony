<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="asociar.object"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="asociar.object"/></h1>
        <p>
            <bean:message key="asociar.object.online.help"/>
        </p>
        <h2><bean:message key="asociar.object.submit"/></h2>
        <p>
            <bean:message key="asociar.object.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="even">
                    <td><bean:message key="asociar.object.submit.param.texto"/></td>
                    <td><bean:message key="asociar.object.submit.param.texto.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="asociar.object.submit.param.tipo"/></td>
                    <td><bean:message key="asociar.object.submit.param.tipo.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="asociar.object.estructura"/></h2>
        <p>
            <bean:message key="asociar.object.estructura.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="asociar.object.archivos"/></h2>
        <p>
            <bean:message key="asociar.object.archivos.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

