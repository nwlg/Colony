<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="eliminar.informes.federados.resultado.eliminacion.federados"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="eliminar.informes.federados.resultado.eliminacion.federados"/></h1>
        <p>
            <bean:message key="eliminar.informes.federados.resultado.eliminacion.federados.online.help"/>
        </p>
        <h2><bean:message key="eliminar.informes.federados.resultado.eliminacion.federados.aceptar"/></h2>
        <p>
            <bean:message key="eliminar.informes.federados.resultado.eliminacion.federados.aceptar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

