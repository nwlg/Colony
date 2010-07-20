<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="alta.usuario.formulario.grupos.trabajo"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="alta.usuario.formulario.grupos.trabajo"/></h1>
        <p>
            <bean:message key="alta.usuario.formulario.grupos.trabajo.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>

