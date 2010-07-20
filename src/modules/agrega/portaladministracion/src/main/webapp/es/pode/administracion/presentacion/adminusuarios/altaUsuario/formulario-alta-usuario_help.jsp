<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="alta.usuario.formulario.alta.usuario"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="alta.usuario.formulario.alta.usuario"/></h1>
        <p>
            <bean:message key="alta.usuario.formulario.alta.usuario.online.help"/>
        </p>
        <h2><bean:message key="alta.usuario.formulario.alta.usuario.cancelar"/></h2>
        <p>
            <bean:message key="alta.usuario.formulario.alta.usuario.cancelar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

