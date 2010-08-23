<%@ taglib tagdir="/WEB-INF/tags" prefix="arb" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/tags-empaquetador.tld" prefix="emp" %>
<%@ attribute name="arbol" type="es.pode.empaquetador.negocio.servicio.ArchivoVO" required="true" %>
<%@ attribute name="niveles" type="java.lang.Integer" required="true" %>
<%@ attribute name="path" type="java.util.List" required="true" %>
<%@ attribute name="actionNavegar" type="java.lang.String" required="true" %>

<fmt:formatNumber var="nv" value="${niveles}" minIntegerDigits="2" maxIntegerDigits="3" />
<c:set var="claseOrgAbierto" value="nivel${nv }_grupo_abierto" />
<c:set var="claseOrgCerrado" value="nivel${nv }_grupo_cerrado" />
<bean:define id="esProtegido">${arbol.esProtegido}</bean:define>
<logic:equal name="esProtegido" value="false">
	<logic:equal name="arbol" property="esFichero" value="false">
		<c:set var="esAbierta" value="false"/>
		<logic:iterate id="elemento" name="path">
			<logic:equal name="elemento" property="href" value="${arbol.href}">
				<c:set var="esAbierta" value="true"/>
			</logic:equal>
		</logic:iterate>
		<logic:equal name="esAbierta" value="false">
			<li id="${arbol.href}" class="${claseOrgCerrado }">
		</logic:equal>
		<logic:equal name="esAbierta" value="true">
			<li id="${arbol.href}" class="${claseOrgAbierto }">
		</logic:equal>
		<span onclick="P7_swapClass(1,'${arbol.href}','${claseOrgAbierto }','${claseOrgCerrado }','li');return false" onkeypress="P7_swapClass(1,'${arbol.href}','${claseOrgAbierto }','${claseOrgCerrado }','li');return false">&nbsp;</span>
		<a href="<html:rewrite action="${actionNavegar }"/>?href=${arbol.href}" onclick="P7_swapClass(1,'${arbol.href}','${claseOrgAbierto }','${claseOrgCerrado }','li');return true" onkeypress="P7_swapClass(1,'${arbol.href}','${claseOrgAbierto }','${claseOrgCerrado }','li');return true">${arbol.nombre}</a>
		<ul>
			<logic:notEmpty name="arbol" property="contenidos">
				 	<logic:iterate id="archivo" name="arbol" property="contenidos">	 	
				   		<arb:archivos niveles="${niveles +1}" arbol="${archivo}" path="${path}" actionNavegar="${actionNavegar }"/>
					</logic:iterate>
			</logic:notEmpty>
			
		</ul>
		</li>	
		
	</logic:equal>
	<logic:equal name="arbol" property="esFichero" value="true">
	<li class="item3"><span>&nbsp;<a href="<emp:encodeURL url="${arbol.href }"/>">${arbol.nombre }</a></span></li>
	</logic:equal>
</logic:equal>