<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="solicitar.alta.usuario.cu.formulario.inicial"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="solicitar.alta.usuario.cu.formulario.inicial"/></h1>
        <p>
            <bean:message key="solicitar.alta.usuario.cu.formulario.inicial.online.help"/>
        </p>
        <h2><bean:message key="solicitar.alta.usuario.cu.formulario.inicial.volver"/></h2>
        <p>
            <bean:message key="solicitar.alta.usuario.cu.formulario.inicial.volver.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

