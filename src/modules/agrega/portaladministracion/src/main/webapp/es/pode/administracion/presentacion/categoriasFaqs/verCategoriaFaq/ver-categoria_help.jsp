<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="ver.categoria.faq.ver.categoria"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="ver.categoria.faq.ver.categoria"/></h1>
        <p>
            <bean:message key="ver.categoria.faq.ver.categoria.online.help"/>
        </p>
        <h2><bean:message key="ver.categoria.faq.ver.categoria.aceptar"/></h2>
        <p>
            <bean:message key="ver.categoria.faq.ver.categoria.aceptar.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

