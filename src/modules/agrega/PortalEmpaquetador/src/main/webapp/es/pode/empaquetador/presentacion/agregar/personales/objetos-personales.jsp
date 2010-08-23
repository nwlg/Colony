<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="/WEB-INF/tlds/tags-empaquetador.tld" prefix="emp" %>
<bean:define id="urlArchivos"><html:rewrite action="/GestorArchivos/GestorArchivos"/></bean:define>
<bean:define id="urlRecursos"><html:rewrite action="/GestorRecursos/GestorRecusos"/></bean:define>
<bean:define id="urlOrganizaciones"><html:rewrite action="/GestorOrganizaciones/GestorOrganizaciones"/></bean:define>
<bean:define id="urlSubmanifiestos"><html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestos"/></bean:define>
<bean:define id="urlGuardar"><html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestos"/></bean:define>
<bean:define id="urlEstructura"><html:rewrite action="/GestorBasico/GestorBasico"/></bean:define>
<bean:define id="selected" value="submanifiestos"/>
<emp:layout selected="${selected}" urlEstructura="${urlEstructura}" urlArchivos="${urlArchivos}" urlRecursos="${urlRecursos}" urlSubmanifiestos="${urlSubmanifiestos}" urlOrganizaciones="${urlOrganizaciones}" urlGuardar="${urlGuardar}" titleKey="title.Comun">
<bean:define id="empaquetadorSesion" name="<%=es.pode.empaquetador.presentacion.EmpaquetadorSession.SESSION_KEY%>" scope="session"/>

<script language="javascript">

function doSubmit(sAction)
{
	document.forms["form"].action.value = sAction;
	document.forms["form"].submit();
}

</script>

<div id="capa_madre">

<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>
<h2><bean:message key="portal_empaquetado_agregarSubmanifiestos.desdeObjetosPersonales"/></h2>
<form name="form" id="agregarPersonalesObjetosPersonalesAceptarForm" method="get" action="<html:rewrite action="/AgregarPersonales/ObjetosPersonalesAceptar"/>" enctype="multipart/form-data">
<p class="parrafo_comun" id="separacion2"><bean:message key="portal_empaquetado_agregarSubmanifiestos.seleccionarObjeto"/></p>
		
		<bean:define id="offline">${empaquetadorSesion.esOffline}</bean:define>

<c:if test="${!offline}">
		<!-- Inicio  PESTANIAS de FICHA -->
		<bean:define id="compartidosValue">${form.compartidos}</bean:define>
		<div id="ficha_pestanias">
		<ul>
			<logic:equal name="compartidosValue" value="false">
				<li id="pest_activa"><a
					href="<html:rewrite action="/AgregarPersonales/AgregarPersonales"/>"
					id="seleccionada"><bean:message
					key="portal_empaquetado_agregarSubmanifiestos.personales" /></a></li>
				<!-- Remove Shared Folders from NDRB
				<li><a
					href="<html:rewrite action="/AgregarPersonales/AgregarPersonales"/>?compartidos=true"><bean:message
					key="portal_empaquetado_agregarSubmanifiestos.compartidos" /></a></li>
 				-->
			</logic:equal>
			<logic:equal name="compartidosValue" value="true">
			<!-- Remove shared objects from NDRB				
					<li><a
						href="<html:rewrite action="/AgregarPersonales/AgregarPersonales"/>"><bean:message
						key="portal_empaquetado_agregarSubmanifiestos.personales" /></a></li>
					<!-- Remove Shared Folders from NDRB 
					<li id="pest_activa"><a
						href="<html:rewrite action="/AgregarPersonales/AgregarPersonales"/>?compartidos=true"
						id="seleccionada"><bean:message
						key="portal_empaquetado_agregarSubmanifiestos.compartidos" /></a></li>
			-->
			</logic:equal>
		</ul>
		</div>
		<!-- Fin PESTANIAS de FICHA -->
<!-- Inicio Interior ficha-->
		<div class="interno_ficha">
		<div class="plantilla_contenido_pestanias">

</c:if>
<div class="caja_tabla">

	<display:table name="${form.personales}" requestURI=""
					id="fila" class="administracion_tareas" 
					style="border:1;width:100%;" cellpadding="0" cellspacing="0" 
					summary="${summary}" sort="list" pagesize="10">
					
		<display:setProperty name="css.tr.odd" value="tr_gris"/>
		<display:setProperty name="css.tr.even" value="tr_blanco"/>
		<display:setProperty name="basic.show.header" value="false"/>

	
	<!--		Columna de 	Radiobutton	(html)	-->
	   <display:column style="valign:top;" class="sin_b">
	   	   <label for="${fila.idODE}" class="etiq_invisible" ><bean:message key="portal_empaquetado_agregarSubmanifiestos.seleccionar"/></label>
           <input type="radio" class="boton_radio" name="idODE" id="${fila.idODE}" value="${fila.idODE}" />
       </display:column>
	<!--		Columna de Titulo de ODE (html)		-->

		<display:column style="valign:top;" class="tar2">
			<html:link href="#" styleClass="paquete">
				 ${fila.titulo}
			</html:link>
		</display:column>				
	</display:table>

<c:if test="${!offline}">
</div>
</div>
</c:if>

<!-- Fin Interior ficha-->
<input type="hidden" name="action" value="" />

<fieldset class="tipo">

	<div class="packer_newfolder_accept">
		<!-- Start of Accept button -->
		<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
	
		<div class="db_bubble_content">
			<a href="javascript:doSubmit('<bean:message key="portal_empaquetado_agregarSubmanifiestos.aceptar"/>');"><bean:message key="portal_empaquetado_agregarSubmanifiestos.aceptar"/></a>
		</div>
	
		</div></div></div></div>
		<!-- End of bubble -->
	</div>

	<div class="packer_newfolder_cancel">
		<!-- Start of Cancel button -->
		<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
	
		<div class="db_bubble_content">
			<a href="javascript:doSubmit('<bean:message key="portal_empaquetado_agregarSubmanifiestos.cancelar"/>');"><bean:message key="portal_empaquetado_agregarSubmanifiestos.cancelar"/></a>
		</div>
	
		</div></div></div></div>
		<!-- End of bubble -->
	</div>

</fieldset>	
</form>

</div>

</div>
</emp:layout>