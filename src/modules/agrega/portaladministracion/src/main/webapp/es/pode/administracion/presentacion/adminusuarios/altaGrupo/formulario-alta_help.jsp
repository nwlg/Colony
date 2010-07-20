<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="alta.grupo.formulario.alta"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="alta.grupo.formulario.alta"/></h1>
        <p>
            <bean:message key="alta.grupo.formulario.alta.online.help"/>
        </p>
        <h2><bean:message key="alta.grupo.formulario.alta.cancelar"/></h2>
        <p>
            <bean:message key="alta.grupo.formulario.alta.cancelar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

