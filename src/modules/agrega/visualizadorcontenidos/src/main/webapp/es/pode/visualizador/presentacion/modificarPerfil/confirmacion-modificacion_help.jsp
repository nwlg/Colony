<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="modificar.perfil.confirmacion.modificacion"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="modificar.perfil.confirmacion.modificacion"/></h1>
        <p>
            <bean:message key="modificar.perfil.confirmacion.modificacion.online.help"/>
        </p>
        <h2><bean:message key="modificar.perfil.confirmacion.modificacion.aceptar"/></h2>
        <p>
            <bean:message key="modificar.perfil.confirmacion.modificacion.aceptar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

