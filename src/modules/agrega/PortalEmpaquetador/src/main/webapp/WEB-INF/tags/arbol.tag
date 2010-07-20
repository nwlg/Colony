<%@ include file="/taglib-imports.jspf" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="arb" %>
<%@ attribute name="datosIter" type="es.pode.empaquetador.negocio.servicio.GrupoVO" required="true" %>
<%@ attribute name="niveles" type="java.lang.Integer" required="true" %>
<%@ attribute name="idCollection" type="java.util.List" required="true" %>
<%@ attribute name="actionNavegar" type="java.lang.String" required="true" %>
<%@ attribute name="tipoEmpaquetador" type="java.lang.String" required="true" %>
	<bean:define id="datos" name="datosIter"/>
	<fmt:formatNumber var="nv" value="${niveles}" minIntegerDigits="2" maxIntegerDigits="3" />
	<c:set var="claseOrgAbierto" value="nivel${nv }_grupo_abierto" />
	<c:set var="claseOrgCerrado" value="nivel${nv }_grupo_cerrado" />
<ul>
<c:set var="esAbierta" value="false"/>
<logic:iterate id="elemento" name="idCollection">
	<logic:equal name="elemento" property="identifier" value="${datosIter.identifier }">
		<c:set var="esAbierta" value="true"/>
	</logic:equal>
</logic:iterate>

<logic:equal name="esAbierta" value="false">
	<li id="${datosIter.identifier }" class="${claseOrgCerrado }">
</logic:equal>
<logic:equal name="esAbierta" value="true">
	<li id="${datosIter.identifier }" class="${claseOrgAbierto }">
</logic:equal>


<span onclick="P7_swapClass(1,'${datosIter.identifier }','${claseOrgAbierto}','${claseOrgCerrado}','li');return false" onkeypress="P7_swapClass(1,'${datosIter.identifier }','${claseOrgAbierto}','${claseOrgCerrado}','li');return false">&nbsp;</span>
<a href="<html:rewrite action="${actionNavegar }"/>?identifier=${datosIter.identifier }" onclick="P7_swapClass(1,'${datosIter.identifier }','${claseOrgAbierto }','${claseOrgCerrado }','li');return true" onkeypress="P7_swapClass(1,'${datosIter.identifier }','${claseOrgAbierto }','${claseOrgCerrado }','li');return true">${datosIter.title}</a>
<logic:notEmpty name="datosIter" property="grupos">
	 	<logic:iterate id="grupo" name="datosIter" property="grupos">	 	
	   		<arb:arbol niveles ="${niveles +1}" datosIter="${grupo}" idCollection="${idCollection}" actionNavegar="${actionNavegar }" tipoEmpaquetador="${tipoEmpaquetador}"/>
		</logic:iterate>
</logic:notEmpty>
</li>
</ul>