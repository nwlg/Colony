<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="recuerdo.usuario.confirmacion.envio.correo"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="recuerdo.usuario.confirmacion.envio.correo"/></h1>
        <p>
            <bean:message key="recuerdo.usuario.confirmacion.envio.correo.online.help"/>
        </p>
        <h2><bean:message key="recuerdo.usuario.confirmacion.envio.correo.aceptar"/></h2>
        <p>
            <bean:message key="recuerdo.usuario.confirmacion.envio.correo.aceptar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

