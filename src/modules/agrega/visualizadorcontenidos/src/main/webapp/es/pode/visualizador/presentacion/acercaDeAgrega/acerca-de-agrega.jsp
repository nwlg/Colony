<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="agrega" uri="/WEB-INF/tags/agregaProperties.tld" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>

<tiles:insert definition="layout-usuario">
<tiles:put name="title" type="string">
	<bean:message key="portada.title"/>
</tiles:put>

    <tiles:put name="title" type="string">
        <bean:message key="title.Comun"/>
    </tiles:put>

    <tiles:put name="style" type="string">
      <link rel="stylesheet" type="text/css" media="screen" href="<html:rewrite page="/es/pode/visualizador/presentacion/acercaDeAgrega/acerca-de-agrega.css"/>"></link>
    </tiles:put>

    
    <tiles:put name="body" type="string">
     <%@ include file="/es/pode/visualizador/presentacion/acercaDeAgrega/acerca-de-agrega-javascript.jspf" %>

    <div class="plantilla_contenido">

		<bean:define id="changeLog"><agrega:agregaProperties property="pathChangeLog"/></bean:define>
		<h2><bean:message key="visualizador.acercaDeAgrega.titulo"/> <a href="<rewrite:rewrite url="${changeLog}"/>" style="display:none;"><agrega:agregaProperties property="version"/></a></h2>


		<!-- Read through all of the information -->
		<%int cont=1; %>
		
		<div id="contenido_noticia">

		<% while (cont <= 71) { %>
			<!-- Check to see if the message exists -->
			<bean:define id="messagekey">visualizador.acercaDeAgrega.texto<%=cont%></bean:define>

			<p>	
				<bean:message key="${messagekey}"/>
			</p>
			
			<p><br/></p>
			
		<% 
			cont++;
		} %>
		
		</div>

	</div>

    </tiles:put>

</tiles:insert>
