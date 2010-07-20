<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="ver.usuario.inactivo.formulario.inicial"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="ver.usuario.inactivo.formulario.inicial"/></h1>
        <p>
            <bean:message key="ver.usuario.inactivo.formulario.inicial.online.help"/>
        </p>
        <h2><bean:message key="ver.usuario.inactivo.formulario.inicial.aceptar"/></h2>
        <p>
            <bean:message key="ver.usuario.inactivo.formulario.inicial.aceptar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

