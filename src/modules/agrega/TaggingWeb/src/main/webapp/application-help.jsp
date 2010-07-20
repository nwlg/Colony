<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="inicio.tagging.title"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="inicio.tagging.title"/></h1>
        <p>
            <bean:message key="inicio.tagging.online.help"/>
        </p>
        <h2><bean:message key="inicio.tagging.title"/></h2>
        <p>
            <bean:message key="inicio.tagging.online.help"/>
        </p>
        <h2><bean:message key="listar.mis.tags.title"/></h2>
        <p>
            <bean:message key="listar.mis.tags.online.help"/>
        </p>
        <h2><bean:message key="listar.agrega.tags.title"/></h2>
        <p>
            <bean:message key="listar.agrega.tags.online.help"/>
        </p>
        <h2><bean:message key="mostrar.odes.mis.tags.title"/></h2>
        <p>
            <bean:message key="mostrar.odes.mis.tags.online.help"/>
        </p>
        <h2><bean:message key="mostrar.odes.agrega.tags.title"/></h2>
        <p>
            <bean:message key="mostrar.odes.agrega.tags.online.help"/>
        </p>
        <h2><bean:message key="modificar.tag.title"/></h2>
        <p>
            <bean:message key="modificar.tag.online.help"/>
        </p>
        <h2><bean:message key="listar.tag.title"/></h2>
        <p>
            <bean:message key="listar.tag.online.help"/>
        </p>
        <h2><bean:message key="modificar.title"/></h2>
        <p>
            <bean:message key="modificar.online.help"/>
        </p>
        <h2><bean:message key="mostrar.odes.title"/></h2>
        <p>
            <bean:message key="mostrar.odes.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>

