<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/tags-empaquetador.tld" prefix="emp" %>
<bean:define id="urlArchivos"><html:rewrite action="/GestorArchivos/GestorArchivos"/></bean:define>
<bean:define id="urlRecursos"><html:rewrite action="/GestorRecursos/GestorRecursos"/></bean:define>
<bean:define id="urlOrganizaciones"><html:rewrite action="/GestorOrganizaciones/GestorOrganizaciones"/></bean:define>
<bean:define id="urlSubmanifiestos"><html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestos"/></bean:define>
<bean:define id="urlGuardar"><html:rewrite action="/GestorElementos/GestorElementos"/></bean:define>
<bean:define id="selected" value="organizaciones"/>
<emp:layout selected="${selected}" urlArchivos="${urlArchivos}" urlRecursos="${urlRecursos}" urlSubmanifiestos="${urlSubmanifiestos}" urlOrganizaciones="${urlOrganizaciones}" urlGuardar="${urlGuardar}" titleKey="title.Comun">
<bean:define id="empaquetadorSesion" name="<%=es.pode.empaquetador.presentacion.EmpaquetadorSession.SESSION_KEY%>" scope="session"/>
<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>
<form id="secuenciaEditarSecuenciaSubmitForm" method="post" action="<html:rewrite action="/Secuencia/EditarSecuenciaSubmit"/>"  enctype="multipart/form-data">
<h2><bean:message key="secuencia.anadirSecuencia"/></h2>


<div class="caja_tabla bordeada" >
<table border="1" class="generica_02" cellpadding="0" cellspacing="0" width="100%" summary="Tabla de Recursos">
<caption><strong><bean:message key="seleccionar_principal.tablaRecursos"/></strong></caption>
<tr class="tr_gris">
  <td valign="top" class="td_larga">
      <!-- <strong class="tit_iconos"><bean:message key="secuencia.choice"/></strong>-->
	  <bean:message key="secuencia.permitirSeleccionarElemDeEsteGrupo"/>
  </td>
   <td valign="middle"  class="td_corta02" >
   	<html:radio name="form" property="choice" value="true" />&nbsp;&nbsp;<label for="choice_si" class="choice_si">&nbsp;&nbsp;<span><bean:message key="secuencia.si"/></span> </label>
   </td>
  <td valign="middle"  class="td_corta02" >
  	<html:radio name="form" property="choice" value="false" />&nbsp;&nbsp;<label for="choice_no" class="choice_no">&nbsp;&nbsp;<span><bean:message key="secuencia.no"/></span> </label>
  </td>
</tr>

<tr class="tr_blanco">
  <td valign="top" class="td_larga">
  	<!-- <strong class="tit_iconos"><bean:message key="secuencia.choiceExit"/></strong>-->
	<bean:message key="secuencia.permitirSoloSeleccionarElemDeEsteGrupo"/>
  </td>
  <td valign="middle"  class="td_corta02" >
   	<html:radio name="form" property="choiceExit" value="true"/>&nbsp;&nbsp;<label for="choice_exit_si" class="choice_exit_si">&nbsp;&nbsp;<span><bean:message key="secuencia.si"/></span> </label>
  </td>
  <td valign="middle"  class="td_corta02" >
  	<html:radio name="form" property="choiceExit" value="false"/>&nbsp;&nbsp;<label for="choice_exit_no" class="choice_exit_no">&nbsp;&nbsp;<span><bean:message key="secuencia.no"/></span> </label>
  </td>
</tr>
<tr class="tr_gris">
  <td valign="top" class="td_larga">
  	<!-- <strong class="tit_iconos"><bean:message key="secuencia.flow"/></strong>-->
	<bean:message key="secuencia.permitirNavegarEnEsteGrupoAdelanteAtras"/>
  </td>
   <td valign="middle"  class="td_corta02" >
   	<html:radio name="form" property="flow" value="true"/>&nbsp;&nbsp;<label for="flow_si" class="flow_si">&nbsp;&nbsp;<span><bean:message key="secuencia.si"/></span> </label>
  </td>
  <td valign="middle"  class="td_corta02" >
  	<html:radio name="form" property="flow" value="false"/>&nbsp;&nbsp;<label for="flow_no" class="flow_no">&nbsp;&nbsp;<span><bean:message key="secuencia.no"/></span> </label>
  </td>
</tr>
<tr class="tr_blanco">
  <td valign="top" class="td_larga">
  	<!--<strong class="tit_iconos"><bean:message key="secuencia.forwardOnly"/></strong>-->
	<bean:message key="secuencia.permitirNavegarEnEsteGrupoSoloAdelante"/>
  </td>
  <td valign="middle"  class="td_corta02" >
   	<html:radio name="form" property="forwardOnly" value="true"/>&nbsp;&nbsp;<label for="forward_si" class="forward_si">&nbsp;&nbsp;<span><bean:message key="secuencia.si"/></span> </label>
  </td>
  <td valign="middle"  class="td_corta02" >
  	<html:radio name="form" property="forwardOnly" value="false"/>&nbsp;&nbsp;<label for="forward_no" class="forward_no">&nbsp;&nbsp;<span><bean:message key="secuencia.no"/></span> </label>
  </td>
</tr>

</table>
</div>


<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<fieldset class="tipo ft_centrada">
	<input class="boton_125_de_2"  type="submit"  name="action" value="<bean:message key='nuevo_grupo.aceptar'/>" />
	<input class="boton_125_de_2_izq"  type="submit" name="action" value="<bean:message key='nuevo_grupo.cancelar'/>"/>
 	<input class="boton_125"  type="submit" name="action" value="<bean:message key='secuencia.valorPorDefecto'/>" />

</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>
</div>

<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
</emp:layout>
