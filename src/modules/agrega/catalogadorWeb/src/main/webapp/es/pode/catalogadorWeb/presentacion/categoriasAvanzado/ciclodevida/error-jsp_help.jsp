<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="ciclo.de.vida.error.jsp"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="ciclo.de.vida.error.jsp"/></h1>
        <p>
            <bean:message key="ciclo.de.vida.error.jsp.online.help"/>
        </p>
        <h2><bean:message key="ciclo.de.vida.error.jsp.salir"/></h2>
        <p>
            <bean:message key="ciclo.de.vida.error.jsp.salir.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

