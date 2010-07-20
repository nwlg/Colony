<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="eliminar.cu.resultado"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="eliminar.cu.resultado"/></h1>
        <p>
            <bean:message key="eliminar.cu.resultado.online.help"/>
        </p>
        <h2><bean:message key="eliminar.cu.resultado.volver"/></h2>
        <p>
            <bean:message key="eliminar.cu.resultado.volver.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

