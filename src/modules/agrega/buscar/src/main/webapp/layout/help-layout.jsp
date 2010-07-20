<%@ include file="/taglib-imports.jspf" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
        "http://www.w3.org/TR/html4/strict.dtd">

<html:html lang="true">

    <head>
        <title>
            <tiles:insert attribute="title" flush="true"/>
        </title>
        <html:base/>
        <meta http-equiv="Content-Type" content="text/html; charset:utf-8" />
        <link rel="stylesheet" type="text/css" media="screen" href="<html:rewrite page="/layout/default-application.css"/>"></link>
        <link rel="stylesheet" type="text/css" media="screen" href="<html:rewrite page="/layout/default.css"/>"></link>
    </head>

    <body>
        <div class="help">
            <tiles:insert attribute="body" flush="true"/>
            <input id="close" type="button" onclick="window.close()" value="<bean:message key="online.help.close"/>"></input>
        </div>
    </body>

</html:html>
