<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="crear.recurso.avanzado.tipo.recurso"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="crear.recurso.avanzado.tipo.recurso"/></h1>
        <p>
            <bean:message key="crear.recurso.avanzado.tipo.recurso.online.help"/>
        </p>
        <h2><bean:message key="crear.recurso.avanzado.tipo.recurso.continuar"/></h2>
        <p>
            <bean:message key="crear.recurso.avanzado.tipo.recurso.continuar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.recurso.avanzado.tipo.recurso.continuar.param.tipo"/></td>
                    <td><bean:message key="crear.recurso.avanzado.tipo.recurso.continuar.param.tipo.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="crear.recurso.avanzado.tipo.recurso.continuar.param.action"/></td>
                    <td><bean:message key="crear.recurso.avanzado.tipo.recurso.continuar.param.action.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="crear.recurso.avanzado.tipo.recurso.archivos"/></h2>
        <p>
            <bean:message key="crear.recurso.avanzado.tipo.recurso.archivos.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="crear.recurso.avanzado.tipo.recurso.organizaciones"/></h2>
        <p>
            <bean:message key="crear.recurso.avanzado.tipo.recurso.organizaciones.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="crear.recurso.avanzado.tipo.recurso.submanifiestos"/></h2>
        <p>
            <bean:message key="crear.recurso.avanzado.tipo.recurso.submanifiestos.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="crear.recurso.avanzado.tipo.recurso.recursos"/></h2>
        <p>
            <bean:message key="crear.recurso.avanzado.tipo.recurso.recursos.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

