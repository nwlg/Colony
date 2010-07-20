<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="alta.usuario.confirmacion.fallo.alta.usuario"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="alta.usuario.confirmacion.fallo.alta.usuario"/></h1>
        <p>
            <bean:message key="alta.usuario.confirmacion.fallo.alta.usuario.online.help"/>
        </p>
        <h2><bean:message key="alta.usuario.confirmacion.fallo.alta.usuario.aceptar"/></h2>
        <p>
            <bean:message key="alta.usuario.confirmacion.fallo.alta.usuario.aceptar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

