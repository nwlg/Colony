<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="crear.recurso.avanzado.archivos.archivos"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="crear.recurso.avanzado.archivos.archivos"/></h1>
        <p>
            <bean:message key="crear.recurso.avanzado.archivos.archivos.online.help"/>
        </p>
        <h2><bean:message key="crear.recurso.avanzado.archivos.archivos.vista"/></h2>
        <p>
            <bean:message key="crear.recurso.avanzado.archivos.archivos.vista.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
            </table>
        <h2><bean:message key="crear.recurso.avanzado.archivos.archivos.a.adir"/></h2>
        <p>
            <bean:message key="crear.recurso.avanzado.archivos.archivos.a.adir.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="crear.recurso.avanzado.archivos.archivos.eliminar.todos"/></h2>
        <p>
            <bean:message key="crear.recurso.avanzado.archivos.archivos.eliminar.todos.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="crear.recurso.avanzado.archivos.archivos.recursos"/></h2>
        <p>
            <bean:message key="crear.recurso.avanzado.archivos.archivos.recursos.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="crear.recurso.avanzado.archivos.archivos.submanifiestos"/></h2>
        <p>
            <bean:message key="crear.recurso.avanzado.archivos.archivos.submanifiestos.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="crear.recurso.avanzado.archivos.archivos.organizaciones"/></h2>
        <p>
            <bean:message key="crear.recurso.avanzado.archivos.archivos.organizaciones.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="crear.recurso.avanzado.archivos.archivos.archivos"/></h2>
        <p>
            <bean:message key="crear.recurso.avanzado.archivos.archivos.archivos.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

