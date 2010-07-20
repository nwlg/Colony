<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="faqs.faqs"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="faqs.faqs"/></h1>
        <p>
            <bean:message key="faqs.faqs.online.help"/>
        </p>
        <h2><bean:message key="faqs.faqs.idioma"/></h2>
        <p>
            <bean:message key="faqs.faqs.idioma.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="faqs.faqs.crear.faq"/></h2>
        <p>
            <bean:message key="faqs.faqs.crear.faq.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

