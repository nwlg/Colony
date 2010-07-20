<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="abrir.buscador.mensaje.agregar"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="abrir.buscador.mensaje.agregar"/></h1>
        <p>
            <bean:message key="abrir.buscador.mensaje.agregar.online.help"/>
        </p>
        <h2><bean:message key="abrir.buscador.mensaje.agregar.volver"/></h2>
        <p>
            <bean:message key="abrir.buscador.mensaje.agregar.volver.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="abrir.buscador.mensaje.agregar.buscar"/></h2>
        <p>
            <bean:message key="abrir.buscador.mensaje.agregar.buscar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

