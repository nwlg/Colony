<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="misTags" %>

<tiles:insert definition="${sessionScope.offline == true ? 'layout-offline' : 'layout-administrador'}">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">

 
<!-- *****************************   Inicio  Plantilla contenido      ********************************** -->
<div class="plantilla_contenido">

<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />

<h2><bean:message key="navegarArbolCurricular.titulo"/></h2>

<bean:define id="textoSeleccionar"><bean:message key="comun.seleccionar"/></bean:define>
<bean:define id="textoCancelar"><bean:message key="comun.cancelar"/></bean:define>

<misTags:arbol taxonomia="${form.taxonomia}" 
	urlNavegar="/NavegarArbolCurricular/NavegarArbolCurricular.do" 
	urlActionKey="/NavegarArbolCurricular/NavegarArbolCurricularSelectAction.do"
	textoSeleccionar="${textoSeleccionar}"
	textoCancelar="${textoCancelar}"/>


</div>
<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->


    </tiles:put>

</tiles:insert>