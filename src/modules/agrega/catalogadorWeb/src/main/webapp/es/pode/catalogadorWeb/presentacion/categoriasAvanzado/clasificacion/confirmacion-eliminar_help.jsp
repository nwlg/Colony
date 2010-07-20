<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="clasificacion.confirmacion.eliminar"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="clasificacion.confirmacion.eliminar"/></h1>
        <p>
            <bean:message key="clasificacion.confirmacion.eliminar.online.help"/>
        </p>
        <h2><bean:message key="clasificacion.confirmacion.eliminar.datos.asesion"/></h2>
        <p>
            <bean:message key="clasificacion.confirmacion.eliminar.datos.asesion.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="clasificacion.confirmacion.eliminar.datos.asesion.param.listado.clasificacion"/></td>
                    <td><bean:message key="clasificacion.confirmacion.eliminar.datos.asesion.param.listado.clasificacion.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="clasificacion.confirmacion.eliminar.datos.asesion.param.titulo.clasificacion"/></td>
                    <td><bean:message key="clasificacion.confirmacion.eliminar.datos.asesion.param.titulo.clasificacion.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="clasificacion.confirmacion.eliminar.cancelar.eliminar"/></h2>
        <p>
            <bean:message key="clasificacion.confirmacion.eliminar.cancelar.eliminar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

