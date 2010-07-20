<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="visualizar.adl.lmsmain"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="visualizar.adl.lmsmain"/></h1>
        <p>
            <bean:message key="visualizar.adl.lmsmain.online.help"/>
        </p>
        <h2><bean:message key="visualizar.adl.lmsmain.fin"/></h2>
        <p>
            <bean:message key="visualizar.adl.lmsmain.fin.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="visualizar.adl.lmsmain.datos.borrar"/></h2>
        <p>
            <bean:message key="visualizar.adl.lmsmain.datos.borrar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="visualizar.adl.lmsmain.datos.borrar.param.usuario"/></td>
                    <td><bean:message key="visualizar.adl.lmsmain.datos.borrar.param.usuario.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="visualizar.adl.lmsmain.datos.borrar.param.identificador"/></td>
                    <td><bean:message key="visualizar.adl.lmsmain.datos.borrar.param.identificador.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

