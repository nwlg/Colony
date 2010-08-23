<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<tiles:insert definition="layout-usuario">

<tiles:put name="title" type="string">
	<bean:message key="title.Comun"/>
</tiles:put>

    <tiles:put name="style" type="string">
        <link rel="stylesheet" type="text/css" media="screen" href="<html:rewrite page="/es/pode/visualizador/presentacion/informacionLegal/informacion-legal.css"/>"></link>
    </tiles:put>

    
    <tiles:put name="body" type="string">
    <%@ include file="/es/pode/visualizador/presentacion/informacionLegal/informacion-legal-javascript.jspf" %>

	<div class="plantilla_contenido">

	<h2><bean:message key="visualizador.informacionLegal.titulo"/></h2>

	<!-- Read through all of the information -->
	<%int cont=1; %>

	<div id="contenido_noticia">

	<% while (cont <= 78) { %>
		<!-- Check to see if the message exists -->
		<bean:define id="messagekey">visualizador.informacionLegal.texto<%=cont%></bean:define>

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
