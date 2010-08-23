<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<tiles:insert definition="layout-usuario">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>


<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>

<!--		Inicio plantilla contenido		-->

<!--  INICIO CUERPO GENERAL   -->
<!--  INICIO CUERPO GENERAL   -->
<div class="plantilla_contenido" >

<h2><bean:message key="feeds.agregador.queEsEsto.titulo"/></h2>

<div class="parrafo_comun" id="separacion"><bean:message key="feeds.agregador.queEsEsto.parrafo1"/>
<br>
	- <a target="_blank" title='<bean:message key="feeds.agregador.google"/>' href="http://www.google.com/reader"><bean:message key="feeds.agregador.google"/></a><br>
	- <a target="_blank" title='<bean:message key="feeds.agregador.blogLines"/>' href="http://www.bloglines.com"><bean:message key="feeds.agregador.blogLines"/></a><br>
	- <a target="_blank" title='<bean:message key="feeds.agregador.netvibes"/>' href="http://www.netvibes.com"><bean:message key="feeds.agregador.netvibes"/></a><br>
	- <a target="_blank" title='<bean:message key="feeds.agregador.live"/>' href="http://www.live.com/"><bean:message key="feeds.agregador.live"/></a><br>
	- <a target="_blank" title='<bean:message key="feeds.agregador.yahoo"/>' href="http://my.yahoo.com"><bean:message key="feeds.agregador.yahoo"/></a><br>
<br>
	- <a href="http://www.feedreader.com/" title='<bean:message key="feeds.agregador.feedReader"/>' target=_blank class=a11r003><bean:message key="feeds.agregador.feedReader"/></a><br>
	- <a href="http://www.rssreader.com" title='<bean:message key="feeds.agregador.rssReader"/>' target=_blank class=a11r003><bean:message key="feeds.agregador.rssReader"/></a><br>
	- <a href="http://www.sharpreader.net" title='<bean:message key="feeds.agregador.sharpReader"/>' target=_blank class=a11r003><bean:message key="feeds.agregador.sharpReader"/></a><br>
	- <a href="http://bradsoft.com/feeddemon/" title='<bean:message key="feeds.agregador.feedDemon"/>' target=_blank class=a11r003><bean:message key="feeds.agregador.feedDemon"/></a><br>

<bean:message key="feeds.agregador.queEsEsto.parrafo2"/>
</div>


<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<fieldset class="tipo ft_centrada">
<form id="agregadorFeedsCUFormularioQueEsEstoVolverForm" action='<html:rewrite action="/AgregadorFeedsCU/FormularioQueEsEstoVolver"/>' method="post"  >
	<input class="boton_125"  type="submit"  value="<bean:message key="feeds.agregador.queEsEsto.volver"/>" />
</form>
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->


</div>
<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>