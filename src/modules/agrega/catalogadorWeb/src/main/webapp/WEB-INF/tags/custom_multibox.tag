<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="custom_multibox" %>

<%@ attribute name="listaSeleccionados"  type="java.util.List" required="true" rtexprvalue="true" %>
<%@ attribute name="value"  type="java.lang.String" required="true" %>
<%@ attribute name="name"  type="java.lang.String" required="true" %>

<%@ attribute name="title"  type="java.lang.String" required="false" rtexprvalue="true" %>
<%@ attribute name="disabled"  type="java.lang.String" required="false" %>
<%@ attribute name="readonly"  type="java.lang.String" required="false" %>
<%@ attribute name="onchange"  type="java.lang.String" required="false" %>
<%@ attribute name="onfocus"  type="java.lang.String" required="false" %>
<%@ attribute name="id"  type="java.lang.String" required="false" %>
<%@ attribute name="clase"  type="java.lang.String" required="false" %>
<%@ attribute name="style"  type="java.lang.String" required="false" %>


<c:set var="encontrado" value="false"/>

<c:if test="${!empty listaSeleccionados}">	
	<logic:iterate id="opcion" name="listaSeleccionados">
		<c:if test="${opcion == value}"> 
			<c:set var="encontrado" value="true"/>
		</c:if> 
	</logic:iterate>

</c:if>

<c:if test="${encontrado}">
	<input type="checkbox" name="${name }" value="${value }" checked id="${id }" class="${clase }" title="${title }"/>
</c:if>
<c:if test="${!encontrado}">
	<input type="checkbox" name="${name }" value="${value }" id="${id }" class="${clase }" title="${title }"/>
</c:if>
