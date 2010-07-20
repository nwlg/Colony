<%@ include file="/taglib-imports.jspf" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="combos" %>

<%@ attribute name="estiloSelect" type="java.lang.String" required="true" %>
<%@ attribute name="estiloOscuro" type="java.lang.String" required="true" %>
<%@ attribute name="name"  type="java.lang.String" required="true" %>
<%@ attribute name="property"  type="java.lang.String" required="true" %>
<%@ attribute name="value"  type="java.lang.String" required="true" %>
<%@ attribute name="backingList"  type="java.lang.Object[]" required="true"  %>
<%@ attribute name="title"  type="java.lang.String" required="false" %>
<%@ attribute name="disabled"  type="java.lang.String" required="false" %>
<%@ attribute name="onchange"  type="java.lang.String" required="false" %>
<%@ attribute name="onfocus"  type="java.lang.String" required="false" %>
<%@ attribute name="estilo"  type="java.lang.String" required="false" %>
<%@ attribute name="id"  type="java.lang.String" required="false" %>

<c:choose>
	<c:when test="${!empty backingList}">	
	
		<html:select styleClass="${estiloSelect}" style="${estilo }" styleId="${id }" onchange="${onchange}" property="${property }" value="${value }" title="${title }">
			<c:set var="claro" value="true"/>
	        <c:forEach  items="${backingList}" var="lista">
	        		<c:choose>
						<c:when test="${claro}">   
							<html:option value="${lista.value }">${lista.label }</html:option>
							<c:set var="claro" value="false"/>
						</c:when>
						<c:otherwise>
							<html:option value="${lista.value }" styleClass="${estiloOscuro}">${lista.label }</html:option>
							<c:set var="claro" value="true"/>
						</c:otherwise>
					</c:choose>
	        </c:forEach>
		</html:select>

    </c:when>
    <c:otherwise>
		<html:select property="${property }" />
    </c:otherwise>
</c:choose>
