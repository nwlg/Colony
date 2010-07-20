<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="baja.catalogadores.resultado.eliminacion.catalogadores"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="baja.catalogadores.resultado.eliminacion.catalogadores"/></h1>
        <p>
            <bean:message key="baja.catalogadores.resultado.eliminacion.catalogadores.online.help"/>
        </p>
        <h2><bean:message key="baja.catalogadores.resultado.eliminacion.catalogadores.volver"/></h2>
        <p>
            <bean:message key="baja.catalogadores.resultado.eliminacion.catalogadores.volver.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

