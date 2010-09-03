<%@ include file="/taglib-imports.jspf" %>	
<%@ page import="es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tags/anadirMotorBusqueda.tld" prefix="motorBusqueda" %>


<motorBusqueda:anadirMotorBusquedaTag urlMotorBusqueda="${initParam.url_motor_busqueda}"/>
 
