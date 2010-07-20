<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="faqs.listado.faqs"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="faqs.listado.faqs"/></h1>
        <p>
            <bean:message key="faqs.listado.faqs.online.help"/>
        </p>
        <h2><bean:message key="faqs.listado.faqs.accesibilidad"/></h2>
        <p>
            <bean:message key="faqs.listado.faqs.accesibilidad.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="faqs.listado.faqs.categoria"/></h2>
        <p>
            <bean:message key="faqs.listado.faqs.categoria.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

