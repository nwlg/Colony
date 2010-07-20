<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="login.layout">

    <tiles:put name="title" type="string">
        <bean:message key="login.title"/>
    </tiles:put>

    <tiles:put name="menu" type="string">
        <div class="box1">
            <h4><bean:message key="login.howto.title"/></h4>
            <p><bean:message key="login.howto"/></p>
        </div>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="login.title"/></h1>
        <div class="col-a1">
            <h3><bean:message key="login.register.user"/></h3>
            <p><bean:message key="login.na"/></p>
        </div>
        <div class="col-a2">
            <h3><bean:message key="login.login.user"/></h3>
            <div class="login">
                <form id="login" name="login" action="j_security_check" method="post">
                    <div><bean:message key="login.username"/> :</div>
                    <div><input class="login" type="text" name="j_username" title="<bean:message key="login.username"/>"/></div>
                    <div><bean:message key="login.password"/> :</div>
                    <div><input class="login" type="password" name="j_password" title="<bean:message key="login.password"/>"/></div>
                    <c:choose>
                        <c:when test="${param.action == 'error'}">
                            <p class="error">
                                <bean:message key="login.error"/>
                            </p>
                        </c:when>   
                        <c:otherwise>
                            <br/>                        
                        </c:otherwise> 
                    </c:choose>
                    <div class="submit">
                        <html:submit titleKey="login.submit.title"><bean:message key="login.submit"/></html:submit>
                        <html:reset titleKey="login.reset.title"><bean:message key="login.reset"/></html:reset>
                    </div>
                </form>
                <script type="text/javascript" language="Javascript1.1">
                //<!--
                    var field = document.forms["login"].elements["j_username"];
                    field.focus();
                    field.select();
                //-->
                </script>
            </div>
        </div>
    </tiles:put>

</tiles:insert>
