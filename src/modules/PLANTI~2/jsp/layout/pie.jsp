<%@ include file="/taglib-imports.jspf"%>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<!-- INICIO PIE DE PAGINA -->
<!-- INICIO PIE DE PAGINA -->
<div id="pie_pagina">
<div id="footer_space">

<!-- Logos -->
<div id="footer_logos">
<ul>
<li><a href="http://www.nwlg.org" id="nwlg" target="_blank" title="<bean:message key="pie.nwlg"/>"><span><bean:message key="pie.nwlg"/></span></a></li>
<li><a href="http://www.nen.gov.uk" id="nen" target="_blank" title="<bean:message key="pie.nen"/>"><span><bean:message key="pie.nen"/></span></a></li>
<li><a id="footertext" title="<bean:message key="pie.footertext"/>"><span><bean:message key="pie.footertext"/></span></a></li>
</ul>
</div>

<!-- Powered by Agrega -->
<div id="footer_poweredby">
<a href="http://proyectoagrega.es/"><img src="/static/img/powered_by_agrega.jpg"></a>
</div>

<!-- Link bar div -->
<div id="footer_linkbar">
<a href="<rewrite:rewrite url="${initParam.url_acercaDeAgrega}"/>" class="bar leftpad" title="<bean:message key="metanavegacion.acercade"/>" ><span><bean:message key="metanavegacion.acercade"/></span></a> <br class="oculto" />
<a href="<rewrite:rewrite url="${initParam.url_contacto}"/>" class="bar leftpad" title="<bean:message key="metanavegacion.contacto"/>" id="contacto"><span><bean:message key="metanavegacion.contacto"/></span></a>

<!-- MCA: remove link for this version
<a href="http://www.proyectoagrega.es" target="_blank" class="bar leftpad" title="<bean:message key="metanavegacion.comunidad.title"/>"><span><bean:message key="metanavegacion.comunidad"/></span></a>
-->
<!-- MCA: remove link for this version
<a href="<rewrite:rewrite url="${initParam.url_faqs}"/>" class="bar leftpad" title="<bean:message key="metanavegacion.faqs"/>"><span><bean:message key="metanavegacion.faqs"/></span></a>
-->
<!-- MCA: remove link for this version
<a href="<rewrite:rewrite url="${initParam.url_accesibilidad}"/>" class="bar leftpad" title="<bean:message key="metanavegacion.accesibilidad"/>"><span><bean:message key="metanavegacion.accesibilidad"/></span></a>
-->
<!-- MCA: remove link for this version
<a href="<rewrite:rewrite url="${initParam.url_mapa}"/>" class="bar leftpad" title="<bean:message key="metanavegacion.mapa"/>"><span><bean:message key="metanavegacion.mapa"/></span></a>
-->

<a href="<rewrite:rewrite url="${initParam.url_informacionLegal}"/>"  class="bar leftpad" title="<bean:message key="pie.informacionLegal"/>" ><span><bean:message key="pie.informacionLegal"/></span></a> 
<!-- MCA: remove link for this version
<a href="<rewrite:rewrite url="${initParam.url_politicaPrivacidad }"/>" class="leftpad" title="<bean:message key="pie.politicaPrivacidad"/>"><span><bean:message key="pie.politicaPrivacidad"/></span></a> <br class="oculto" />
-->
</div>
<!-- End of linkbar -->

</div>
<!-- End of footer_space -->

</div>
<!-- PIE DE PAGINA -->

