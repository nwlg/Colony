<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="inicio.empaquetador.titulo2"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="inicio.empaquetador.titulo2"/></h1>
        <p>
            <bean:message key="inicio.empaquetador.titulo2.online.help"/>
        </p>
        <h2><bean:message key="inicio.empaquetador.titulo2.submit"/></h2>
        <p>
            <bean:message key="inicio.empaquetador.titulo2.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="inicio.empaquetador.titulo2.submit.param.titulo"/></td>
                    <td><bean:message key="inicio.empaquetador.titulo2.submit.param.titulo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="inicio.empaquetador.titulo2.submit.param.identificador"/></td>
                    <td><bean:message key="inicio.empaquetador.titulo2.submit.param.identificador.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="inicio.empaquetador.titulo2.submit.param.action"/></td>
                    <td><bean:message key="inicio.empaquetador.titulo2.submit.param.action.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

