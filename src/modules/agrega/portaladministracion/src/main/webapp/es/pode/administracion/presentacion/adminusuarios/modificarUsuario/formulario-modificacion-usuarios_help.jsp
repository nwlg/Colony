<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="modificar.usuario.formulario.modificacion.usuarios"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="modificar.usuario.formulario.modificacion.usuarios"/></h1>
        <p>
            <bean:message key="modificar.usuario.formulario.modificacion.usuarios.online.help"/>
        </p>
        <h2><bean:message key="modificar.usuario.formulario.modificacion.usuarios.cancelar"/></h2>
        <p>
            <bean:message key="modificar.usuario.formulario.modificacion.usuarios.cancelar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

