<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="crear.organizacion.organizacion"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="crear.organizacion.organizacion"/></h1>
        <p>
            <bean:message key="crear.organizacion.organizacion.online.help"/>
        </p>
        <h2><bean:message key="crear.organizacion.organizacion.submit"/></h2>
        <p>
            <bean:message key="crear.organizacion.organizacion.submit.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.organizacion.organizacion.submit.param.title"/></td>
                    <td><bean:message key="crear.organizacion.organizacion.submit.param.title.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="crear.organizacion.organizacion.archivos"/></h2>
        <p>
            <bean:message key="crear.organizacion.organizacion.archivos.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="crear.organizacion.organizacion.recursos"/></h2>
        <p>
            <bean:message key="crear.organizacion.organizacion.recursos.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="crear.organizacion.organizacion.submanifiestos"/></h2>
        <p>
            <bean:message key="crear.organizacion.organizacion.submanifiestos.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="crear.organizacion.organizacion.organizaciones"/></h2>
        <p>
            <bean:message key="crear.organizacion.organizacion.organizaciones.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

