<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<%@ taglib uri="/WEB-INF/tags/serverProperties.tld" prefix="server" %>

<tiles:insert definition="layout-sinlateralYsinbuscadorSuperior">

    <tiles:put name="title" type="string">
        <bean:message key="title.Comun"/>
    </tiles:put>

    <tiles:put name="body" type="string">
    <%@ include file="/taglib-imports.jspf" %>
<div id="capa_madre">
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">

<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />


<!-- Inicio caja buscador -->
<!--  INICIO GLOBO GRIS   -->
<div class="plantilla_contenido" style="margin-right: 260px;">
<div class="results_header">
<div class="results_header_text"><bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.resultadoBusqueda2"/>: ${form.buscadorContenido} </div>
</div>

<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">

			<!--  INICIO CAJA DE FORMULARIO   -->
				<div class="results_bubble_text">
					Showing 0 of 0
				</div>
				<div class="results_box">
					<div class="results_outline">
						No results found<br><br>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!-- Fin caja buscador -->


</form>

<div class="packer_cancel">
        <div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
                <div class="db_bubble_content">
                <a href="<%= request.getHeader("Referer") != null ?
                             request.getHeader("Referer") : "/" %>">Back</a>
                </div>
        </div></div></div></div>
</div>

</div>
<!-- Fin plantilla contenido  -->
</div>


    </tiles:put>



<tiles:put name="menu-rhs" type="string">
<!-- Front page contains the search box and the tag cloud -->
<div id="search-menu-rhs">

<div id="searchbox">
<div class="heading_text">search</div>
<tiles:insert definition="agrega.search" flush="false"/>
</div>

<div id="tagcloud" style="margin-top:24px;">
<div class="heading_text">social tags </div>
<tiles:insert definition="agrega.tagcloud" flush="false"/>
</div>

</div>
</tiles:put>


</tiles:insert>

<SCRIPT LANGUAGE="JavaScript">
function deshabilitarCombos(){
	var oComboIdioma = document.getElementById('idiomaBuscadorContenido');
	var oComboNumeroResultados = document.getElementById('numeroResultados');
	oComboIdioma.disabled=true;
	oComboNumeroResultados.disabled=true;
}

function habilitarCombos(){
	var oComboIdioma = document.getElementById('idiomaBuscadorContenido');
	var oComboNumeroResultados = document.getElementById('numeroResultados');
	oComboIdioma.disabled=false;
	oComboNumeroResultados.disabled=false;
}
</SCRIPT>
