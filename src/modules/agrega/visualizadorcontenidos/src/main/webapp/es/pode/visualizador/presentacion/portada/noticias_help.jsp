<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="portada.noticias"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="portada.noticias"/></h1>
        <p>
            <bean:message key="portada.noticias.online.help"/>
        </p>
        <h2><bean:message key="portada.noticias.accesibilidad"/></h2>
        <p>
            <bean:message key="portada.noticias.accesibilidad.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="portada.noticias.mapa"/></h2>
        <p>
            <bean:message key="portada.noticias.mapa.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="portada.noticias.contacto"/></h2>
        <p>
            <bean:message key="portada.noticias.contacto.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="portada.noticias.acerca.de.agrega"/></h2>
        <p>
            <bean:message key="portada.noticias.acerca.de.agrega.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="portada.noticias.informacion.legal"/></h2>
        <p>
            <bean:message key="portada.noticias.informacion.legal.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="portada.noticias.politica.privacidad"/></h2>
        <p>
            <bean:message key="portada.noticias.politica.privacidad.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="portada.noticias.acceso"/></h2>
        <p>
            <bean:message key="portada.noticias.acceso.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="portada.noticias.descargas"/></h2>
        <p>
            <bean:message key="portada.noticias.descargas.online.help"/>
        </p>
        <br/>
    </tiles:put>

</tiles:insert>

