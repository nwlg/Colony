<%@ include file="/taglib-imports.jspf" %>

<breadcrumbs:define id="breadcrumbs" toScope="page"/>
<bean:size id="crumbsCount" name="breadcrumbs" scope="page"/>

<div id="breadcrumbs">

    <%
        String length = String.valueOf(crumbsCount.intValue() - 1);
    %>
    <logic:iterate indexId="index" id="crumb" name="breadcrumbs" scope="page">
        <logic:lessThan name="index" scope="page" value="<%=length%>">
            <a href="${crumb.url}" target="_self">
                <bean:message key="${crumb.value}"/>
            </a>
            <html:img page="/layout/breadcrumb.gif" alt="&gt;"/>
        </logic:lessThan>
        <logic:greaterEqual name="index" scope="page" value="<%=length%>">
            <bean:message key="${crumb.value}"/>
        </logic:greaterEqual>
    </logic:iterate>

</div>
