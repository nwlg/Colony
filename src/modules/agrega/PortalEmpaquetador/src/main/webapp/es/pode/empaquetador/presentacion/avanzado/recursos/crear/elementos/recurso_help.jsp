<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="crear.recurso.avanzado.elementos.recurso"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="crear.recurso.avanzado.elementos.recurso"/></h1>
        <p>
            <bean:message key="crear.recurso.avanzado.elementos.recurso.online.help"/>
        </p>
        <h2><bean:message key="crear.recurso.avanzado.elementos.recurso.crear"/></h2>
        <p>
            <bean:message key="crear.recurso.avanzado.elementos.recurso.crear.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.recurso.avanzado.elementos.recurso.crear.param.action"/></td>
                    <td><bean:message key="crear.recurso.avanzado.elementos.recurso.crear.param.action.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="crear.recurso.avanzado.elementos.recurso.organizaciones"/></h2>
        <p>
            <bean:message key="crear.recurso.avanzado.elementos.recurso.organizaciones.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="crear.recurso.avanzado.elementos.recurso.archivos"/></h2>
        <p>
            <bean:message key="crear.recurso.avanzado.elementos.recurso.archivos.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="crear.recurso.avanzado.elementos.recurso.submanifiestos"/></h2>
        <p>
            <bean:message key="crear.recurso.avanzado.elementos.recurso.submanifiestos.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="crear.recurso.avanzado.elementos.recurso.recursos"/></h2>
        <p>
            <bean:message key="crear.recurso.avanzado.elementos.recurso.recursos.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="crear.recurso.avanzado.elementos.recurso.submit.principal"/></h2>
        <p>
            <bean:message key="crear.recurso.avanzado.elementos.recurso.submit.principal.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="crear.recurso.avanzado.elementos.recurso.submit.principal.param.action"/></td>
                    <td><bean:message key="crear.recurso.avanzado.elementos.recurso.submit.principal.param.action.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

