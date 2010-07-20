<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<%@ include file="/taglib-imports.jspf" %>	
<%@ page import="es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tags/cabeceraTag.tld" prefix="cabecera" %>
<%@ taglib uri="/WEB-INF/tags/idiomasBanderas.tld" prefix="banderas" %>
<%@ taglib uri="/WEB-INF/tags/anadirMotorBusqueda.tld" prefix="motorBusqueda" %>


<!-- INICIO METANAVEGACION   -->
<div id="metanavegacion">
<ol>
<cabecera:cabeceraTag/>
<%@ include file="/layout/menu-perfil.jsp" %>
</ol>
</div>
<!-- FIN METANAVEGACION   -->

