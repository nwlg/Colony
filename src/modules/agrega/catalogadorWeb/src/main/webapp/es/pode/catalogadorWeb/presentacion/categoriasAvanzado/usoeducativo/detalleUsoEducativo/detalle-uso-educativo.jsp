<%@ include file="/taglib-imports.jspf" %>
<%@ taglib uri="/WEB-INF/tlds/tags-catalogador.tld" prefix="cat" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/categoriasAvanzado/usoeducativo/detalleUsoEducativo/detalle-uso-educativo-vars.jspf" %>


<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido" id="rea">
<jsp:include page="/layout/messages.jsp" flush="true"/>
<h2><bean:message key="educaciones.Educacion"/> ${form.tituloUsoEducativo}</h2>
<form method="post" action="<html:rewrite action="/DetalleUsoEdu/DetalleUsoEducativoSubmit" />" >
<p class="parrafo_comun" id="separacion2"><bean:message key="catalogadorAvanzado.General.TextoObligacion"/></p>


<input type="hidden" id="seleccionar" name="seleccionar" value="<bean:write name="form" property="accion"/>"/> 
		
<script type="text/javascript" >

function inicio() {
	var input= document.getElementsByTagName("input");
	for (var x=0; x < input.length; x++){
		if(input[x].type=="radio" && input[x].checked)
		{
			var nombrePartes = input[x].name.split("_");
			i =  nombrePartes[0].substring(3,nombrePartes[0].length);
			j =  nombrePartes[1].substring(3,nombrePartes[1].length);
	   	 	sel= input[x].value;
	   	 	habilitarDescripcion( i, j , sel );
		}
	}

}

function seleccionarCampo() {
	inicio();
	ancla=document.getElementById('seleccionar').value;
	if (ancla != null) {
		var partes = new Array();
		partes=ancla.split("-");
		
		if(partes[0] == "Añadir Tipo Recurso"){
			document.location.href="#tipoRecurso";
		}
		else if(partes[0]=="Eliminar Tipo Recurso"){
			document.location.href="#tipoRecurso";
		}
		else if(partes[0]=="Añadir Rol Usuario"){
			document.location.href="#rolUsuario";
		}
		else if(partes[0]=="Eliminar Rol Usuario"){
			document.location.href="#rolUsuario";
		}
		else if(partes[0]=="Añadir Contexto"){
			document.location.href="#contexto";
		}
		else if(partes[0]=="Eliminar Contexto"){
			document.location.href="#contexto";
		}
		else if(partes[0]=="Añadir Idioma"){
			document.location.href="#idioma";
		}
		else if(partes[0]=="Eliminar Idioma"){
			document.location.href="#idioma";
		}
		else if(partes[0]=="Añadir Proceso Cognitivo"){
			document.location.href="#proceso";
		}
		else if(partes[0]=="Eliminar Proceso Cognitivo"){
			document.location.href="#proceso";
		}
		else if(partes[0]=="Añadir Descripcion TiempoAp"){
			document.location.href="#descTiempoAp";
		}
		else if(partes[0]=="Eliminar Descripcion TiempoAp"){
			indice = partes[1];
			if(indice>0){
				indice = indice -1;
			}
			document.location.href="#descTiempoAp-"+indice;
		}
		else if(partes[0]=="Añadir Descripcion"){
			document.location.href="#descripciones";
		}
		else if(partes[0]=="Eliminar Descripcion"){
			indice = partes[1];
			if(indice>0){
				indice = indice -1;
			}
			document.location.href="#descripcion-"+indice;
		}
		else if(partes[0]=="Añadir Contenido Descripcion"){
			indice = partes[1];//indice de la descripcion
			document.location.href="#contDescripciones-"+indice;
		}
		else if(partes[0]=="Eliminar Contenido Descripcion"){
			indice1 = partes[1];//indice dentro de la descripcion
			indice2 = partes[2];//indice de la descripcion
			if(indice1>0){
				indice1 = indice1 -1;
			}
			document.location.href="#contDescripcion-"+indice1+"-"+indice2;
		}
		else if( partes[0]=="Añadir DescripcionCat" || partes[0]=="Eliminar DescripcionCat"){
			indice1 = partes[1];//indice dentro de la descripcion
			indice2 = partes[2];//indice de la descripcion
			document.location.href="#contDescripcion-"+indice2+"-"+indice1;
		}
		else if(partes[0]=="Añadir Edad Tipica"){
			document.location.href="#edadTipica";
		}
		else if(partes[0]=="Eliminar Edad Tipica"){
			indice = partes[1];
			if(indice>0){
				indice = indice -1;
			}
			document.location.href="#edadTipica-"+indice;
		}
		else if(partes[0]=="Añadir Contenido Edad Tipica"){
			indice = partes[1];//indice de la descripcion
			document.location.href="#contEdadTipica-"+indice;
		}
		else if(partes[0]=="Eliminar Contenido Edad Tipica"){
			indice1 = partes[1];
			indice2 = partes[2];
			if(indice1>0){
				indice1 = indice1 -1;
			}
			document.location.href="#contEdadTipica-"+indice1+"-"+indice2;
		}
	}
}
window.onload=seleccionarCampo;

	function expandirCaja (nomcaja) 
	{
		if (document.getElementById(nomcaja).className == 'caja_cerrada')
		{ 
			document.getElementById(nomcaja).className = 'caja_abierta';
			document.getElementById('enlace-'+nomcaja).innerHTML = '<bean:message key="catalogadorAvanzado.DetalleEdu.Descripciones.Ocultar"/>';
			return false;
		} else {
			document.getElementById(nomcaja).className = 'caja_cerrada';
			document.getElementById('enlace-'+ nomcaja).innerHTML = '<bean:message key="catalogadorAvanzado.DetalleEdu.Descripciones.masDatos"/>';
			return false;
		}
		
	}

	function habilitarDescripcion( i, j , seleccionado )
	{
		if(seleccionado == 0)
		{
			document.getElementById('Des'+i +'_Tex'+ j ).readOnly=false;
			//document.getElementById('Des'+i +'_Tex'+ j ).focus();
			document.getElementById('Des'+i +'_CPre'+ j ).readOnly=true;
			document.getElementById('Des'+i +'_ODid'+ j ).readOnly=true;
			
			var checkboxes= document.getElementsByTagName("input");
			for (var x=0; x < checkboxes.length; x++){
					if(checkboxes[x].type=="checkbox" && checkboxes[x].id=='Des'+i +'_TCon'+ j )
					{
				   	 	checkboxes[x].disabled =true;
					}
			}
			return false;
		}
		if(seleccionado == 1)
		{
			document.getElementById('Des'+i +'_Tex'+ j ).readOnly=true;
			document.getElementById('Des'+i +'_CPre'+ j ).readOnly=false;
			//document.getElementById('Des'+i +'_CPre'+ j ).focus();
			document.getElementById('Des'+i +'_ODid'+ j ).readOnly=true;
			var checkboxes= document.getElementsByTagName("input");
			for (var x=0; x < checkboxes.length; x++){
					if(checkboxes[x].type=="checkbox" && checkboxes[x].id=='Des'+i +'_TCon'+ j )
					{
				   	 	checkboxes[x].disabled =true;
					}
			}
			return false;
		}
		if(seleccionado == 2)
		{
			document.getElementById('Des'+i +'_Tex'+ j ).readOnly=true;
			document.getElementById('Des'+i +'_CPre'+ j ).readOnly=true;
			document.getElementById('Des'+i +'_ODid'+ j ).readOnly=false;
			//document.getElementById('Des'+i +'_ODid'+ j ).focus();
			var checkboxes= document.getElementsByTagName("input");
			for (var x=0; x < checkboxes.length; x++){
					if(checkboxes[x].type=="checkbox" && checkboxes[x].id=='Des'+i +'_TCon'+ j )
					{
				   	 	checkboxes[x].disabled =true;
					}
			}
			return false;
		}
		if(seleccionado == 3)
		{
			document.getElementById('Des'+i +'_Tex'+ j ).readOnly=true;
			document.getElementById('Des'+i +'_CPre'+ j ).readOnly=true;
			document.getElementById('Des'+i +'_ODid'+ j ).readOnly=true;

			var checkboxes= document.getElementsByTagName("input");
			for (var x=0; x < checkboxes.length; x++){
					if(checkboxes[x].type=="checkbox" && checkboxes[x].id=='Des'+i +'_TCon'+ j )
					{
				   	 	checkboxes[x].disabled =false;
					}
			}
			return false;
		}
		return false;
	}

</script>



<!--  INICIO GLOBO GRIS Tipo de Interactividad   -->
<!--  INICIO GLOBO GRIS Tipo de Interactividad  -->
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
					
					<h3><bean:message key="catalogadorAvanzado.DetalleEdu.TipoInteractividad"/></h3>
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
			<div class="globo_blanco pos_relative conmargen" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
						<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp" >
  						<div class="text">
  							<label for="Interactividad01" class="oculto" >Tipo:</label>
							<bean:define id="tipe"><bean:message key="catalogadorAvanzado.SeleccioneTipoDeInteractividad"/></bean:define>
							<cat:select name="form" property="tipoInteractividad" value="${form.tipoInteractividad}" backingList="${form.tipoInteractividadBackingList}" estiloSelect="select_lrg"  estiloOscuro="oscura" title="${tipe}"/>
						</div>
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				<!--  FIn Fila de Campos   -->
				<!--  fIN Fila de Campos   -->
				</div>
		</div>
	</div>
</div>
</div>
		<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS  Tipo de Interactividad -->
<!--  FIN GLOBO GRIS  Tipo de Interactividad -->




<!--  INICIO GLOBO GRIS Tipo de Recurso de Aprendizaje  -->
<!--  INICIO GLOBO GRIS Tipo de Recurso de Aprendizaje  -->
<a id="tipoRecurso"></a>
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
		<div class="formu" >
					
					<h3><bean:message key="catalogadorAvanzado.DetalleEdu.TipoRecurso"/></h3>
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
<logic:iterate id="recurso" name="tipoRecurso" indexId="i">
			<div class="globo_blanco globito flotder" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
							
						<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp">
  						<div class="text">
  							<label for="Tipo01" class="oculto" >Tipo:</label>
							<bean:define id="tipoR"><bean:message key="catalogadorAvanzado.SeleccioneTipoDeRecursoDeAprendizaje"/></bean:define>
							<cat:select name="form" estilo="width:420px !important" property="TRecur${i}" value="${recurso.valor}" backingList="${form.tipoRecursoBackingList}" estiloSelect="select_lrg2 inp_se_ie" title="${tipoR}"  estiloOscuro="oscura"/>
						</div>
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
						</div>
					</div>
				</div>
			</div>
		</div>
					<div class="flotder">
						<c:choose>
                			<c:when test="${i==0}">   
		                        <span class="oculto">-</span>
		                        <span class="flotder enlace_anadir_02"> 
		                        <input class="boton_anadir flotder" type="submit" name="accion_Añadir Tipo Recurso" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/> 
		        				</span>
             				</c:when>
	                        <c:otherwise>
	                        <span class="oculto">-</span>
		                        <span class="flotder enlace_anadir_02"> 
             					&nbsp;
             					</span>
	                        </c:otherwise>
             			</c:choose>
					</div>
					<div class="flotder">
						<c:set var="longitud" value="${ fn:length(form.tipoRecurso) }"/>
						<c:choose>
	                        <c:when test="${longitud>1}">   
          				    	<span class="oculto">-</span>
          				    	<span class="flotder enlace_eliminar_02"> 
          				        <input class="boton_eliminar flotder" type="submit" name="accion_Eliminar Tipo Recurso-${i}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/> 					            
			    				</span>
	                        </c:when>
             				<c:otherwise>
             				<span class="oculto">-</span>
          				    	<span class="flotder enlace_eliminar_02"> 
                      			&nbsp;
                      			</span>
	                        </c:otherwise>
             			</c:choose>
					</div>
					<div class="limpiar"></div>	
				</logic:iterate>
				<!--  Fin Fila de Campos   -->
				<!--  Fin Fila de Campos   -->	
				<!--  FIN GLOBO BLANCO   -->
				<!--  FIN GLOBO BLANCO   -->
</div>
			
<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS  Tipo de Recurso de Aprendizaje -->
<!--  FIN GLOBO GRIS   -->

<!--  INICIO GLOBO GRIS Nivel    -->
<!--  INICIO GLOBO GRIS Nivel   -->
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
					
					<h3><bean:message key="catalogadorAvanzado.DetalleEdu.NivelInteractividad"/></h3>
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
			<div class="globo_blanco pos_relative conmargen" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
						<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp" >
  						<div class="text">
  						
  							<label for="Interactividad02" class="oculto" >Interactividad:</label>
							<bean:define id="nivel"><bean:message key="catalogadorAvanzado.SeleccioneNivelDeInteractividad"/></bean:define>
							<cat:select name="form" property="nivelInteractividad" value="${form.nivelInteractividad}" backingList="${form.nivelInteractividadBackingList}" estiloSelect="select_lrg"  title="${nivel}" estiloOscuro="oscura"/>
							
						</div>
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				<!--  FIn Fila de Campos   -->
				<!--  fIN Fila de Campos   -->
				</div>
		</div>
	</div>
</div>
</div>
		<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS Nivel    -->
<!--  FIN GLOBO GRIS Nivel   -->


<!--  INICIO GLOBO GRIS Densidad  -->
<!--  INICIO GLOBO GRIS Densidad  -->
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
					
					<h3><bean:message key="catalogadorAvanzado.DetalleEdu.DensidadSemantica"/></h3>
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
			<div class="globo_blanco pos_relative conmargen" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
						<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp" >
  						<div class="text">
  							<label for="Densidad01" class="oculto" >Densidad:</label>
							<bean:define id="densidad"><bean:message key="catalogadorAvanzado.SeleccioneDensidadSemantica"/></bean:define>
							<cat:select name="form" property="densidadSemantica" value="${form.densidadSemantica}" backingList="${form.densidadSemanticaBackingList}" estiloSelect="select_lrg"  title="${densidad}" estiloOscuro="oscura"/>
						</div>
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				<!--  FIn Fila de Campos   -->
				<!--  fIN Fila de Campos   -->
				</div>
		</div>
	</div>
</div>
</div>
		<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS Densidad  -->
<!--  FIN GLOBO GRIS Densidad  -->


<!--  INICIO GLOBO GRIS Rol Usuario  -->
<!--  INICIO GLOBO GRIS Rol Usuario  -->
<a id="rolUsuario"></a>
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
					
					<h3><bean:message key="catalogadorAvanzado.DetalleEdu.RolUsuario"/></h3>
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
<logic:iterate id="rol" name="rolUsuario" indexId="i">
			<div class="globo_blanco globito flotder" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
							
						<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp">
  						<div class="text">
  							<label for="Rol01" class="oculto" >Rol usuario:</label>
							<bean:define id="rols"><bean:message key="catalogadorAvanzado.SeleccioneRolUsuarioFinal"/></bean:define>
							<cat:select name="form" estilo="width:420px !important" property="Rol${i}" value="${rol.valor}" backingList="${form.rolUsuarioBackingList}" estiloSelect="select_lrg inp_se_ie"  title="${rols}" estiloOscuro="oscura"/>
							
						</div>
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
					</div>
					</div>
					</div>
					</div>
					</div>
					<div class="flotder">
						<c:choose>
                			<c:when test="${i==0}">   
		                        <span class="oculto">-</span>
		                        <span class="flotder enlace_anadir_02"> 
		                        <input class="boton_anadir flotder" type="submit" name="accion_Añadir Rol Usuario" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/> 
		        				</span>
             				</c:when>
	                        <c:otherwise>
	                        <span class="oculto">-</span>
		                        <span class="flotder enlace_anadir_02"> 
             					&nbsp;
             					</span>
	                        </c:otherwise>
             			</c:choose>
					</div>
					<div class="flotder">
						<c:set var="longitud" value="${ fn:length(form.rolUsuario) }"/>
						<c:choose>
	                        <c:when test="${longitud>1}">   
          				    	<span class="oculto">-</span>
          				    	<span class="flotder enlace_eliminar_02"> 
          				        <input class="boton_eliminar flotder" type="submit" name="accion_Eliminar Rol Usuario-${i}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/> 					            
			    				</span>
	                        </c:when>
             				<c:otherwise>
             				<span class="oculto">-</span>
          				    	<span class="flotder enlace_eliminar_02"> 
                      			&nbsp;
                      			</span>
	                        </c:otherwise>
             			</c:choose>
					</div>
					<div class="limpiar"></div>
				</logic:iterate>
				<!--  Fin Fila de Campos   -->
				<!--  Fin Fila de Campos   -->
				<!--  FIN GLOBO BLANCO   -->
				<!--  FIN GLOBO BLANCO   -->
				</div>
		</div>
	</div>
</div>
</div>
		<!--  FIN CAJA DE FORMULARIO   -->
<!--  FIN GLOBO GRIS Rol Usuario  -->
<!--  FIN GLOBO GRIS Rol Usuario  -->


<!--  INICIO GLOBO GRIS Contexto  -->
<!--  INICIO GLOBO GRIS Contexto  -->
<a id="contexto"></a>
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
					
					<h3><bean:message key="catalogadorAvanzado.DetalleEdu.Contexto"/></h3>
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
<logic:iterate id="context" name="contexto" indexId="i">
			<div class="globo_blanco globito flotder" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
							
						<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp">
  						<div class="text">
  							<label for="Contexto01" class="oculto" >Contexto:</label>
  							<bean:define id="contex"><bean:message key="catalogadorAvanzado.SeleccioneContexto"/></bean:define>
							<cat:select name="form" estilo="width:420px !important" property="Contxt${i}" value="${context.valor}" backingList="${form.comboContextoBackingList}" estiloSelect="select_lrg inp_se_ie" title="${contex}" estiloOscuro="oscura"/>
							
						</div>
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
					</div>
					</div>
					</div>
					</div>
					</div>
					<div class="flotder">
						<c:choose>
                			<c:when test="${i==0}">   
		                        <span class="oculto">-</span> 
		                        <span class="flotder enlace_anadir_02">
		                        <input class="boton_anadir flotder" type="submit" name="accion_Añadir Contexto" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/> 
		        				</span>
             				</c:when>
	                        <c:otherwise>
	                        <span class="oculto">-</span> 
		                        <span class="flotder enlace_anadir_02">
             					&nbsp;
             					</span>
	                        </c:otherwise>
             			</c:choose>
					</div>
					<div class="flotder">
						<c:set var="longitud" value="${ fn:length(form.contexto) }"/>
						<c:choose>
	                        <c:when test="${longitud>1}">   
          				    	<span class="oculto">-</span>
          				    	<span class="flotder enlace_eliminar_02"> 
          				        <input class="boton_eliminar flotder" type="submit" name="accion_Eliminar Contexto-${i}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/> 					            
			    				</span>
	                        </c:when>
             				<c:otherwise>
             				<span class="oculto">-</span>
          				    	<span class="flotder enlace_eliminar_02">
                      			&nbsp;
                      			</span>
	                        </c:otherwise>
             			</c:choose>
					</div>
					<div class="limpiar"></div>
</logic:iterate>
			
				
				<!--  Fin Fila de Campos   -->
				<!--  Fin Fila de Campos   -->
				<!--  FIN GLOBO BLANCO   -->
				<!--  FIN GLOBO BLANCO   -->
</div>
		<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS Contexto  -->
<!--  FIN GLOBO GRIS Contexto  -->

<!--  INICIO GLOBO GRIS  Edad Típica -->
<!--  INICIO GLOBO GRIS Edad Típica  -->
				<div class="globo_gris conmargen">
					<div class="globo_gris_01">
						<div class="globo_gris_02">
							<div class="globo_gris_03">	<!--  INICIO CAJA DE FORMULARIO   -->
								<div class="formu">
									<h3 class="h3flotante"><bean:message key="catalogadorAvanzado.DetalleEdu.EdadTipica"/></h3>
									<c:set var="longEdadAnterior" value="0"/>
									<logic:iterate id="edad" name="edadTipica" indexId="i">
													<!--anclas-->
													<c:choose>
								                        <c:when test="${i== fn:length(form.edadTipica)-1}">   
									                     <a id="edadTipica"></a>
								                        </c:when>
								                    </c:choose>	
													<a id="edadTipica-${i}"></a>
													<!--fin de anclas-->
									<!--  INICIO GLOBO BLANCO   -->
									<!--  INICIO GLOBO BLANCO   -->
									<div class="globo_blanco globito flotder">
										<div class="globo_blanco_01">
											<div class="globo_blanco_02">
												<div class="globo_blanco_03">	<!--  INICIO Fila de Campos   -->
								<!--  INICIO Fila de Campos   -->
										<c:set var="textos" value="${edad.textos }"/>
										<c:set var="longEdad" value="${ fn:length(textos) }"/>				
										<logic:iterate id="contenido" name="textos" indexId="j">
													<!--anclas-->
													<c:choose>
								                        <c:when test="${j== fn:length(textos)-1}">   
									                     <a id="contEdadTipica-${i}"></a>
								                        </c:when>
								                    </c:choose>	
													<a id="contEdadTipica-${j}-${i}"></a>
													<!--fin de anclas-->
											<c:set var="indice" value="${j + longEdadAnterior}"/>
													<div class="fila_de_tabla_especial_03">
														<div class="contenedor_izquierda_esp">
															<div class="text">
															<label for="Edad${j}" class="oculto" ><bean:message key="catalogadorAvanzado.DetalleEdu.SoloEdadTipica"/>:</label>
															<html:text styleClass="input_medio_largo input_mder" property="Edad${i}_Tex${j}" value="${contenido.texto}" styleId="Edad${i}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaEdadTipica"/>
															</div>
														</div>
														<div class="contenedor_izquierda_esp">
															<div class="text">
																<label for="Idio05" class="oculto" >
																	<bean:message key="catalogadorAvanzado.DetalleEdu.SoloIdioma"/>:</label>
																	<bean:define id="edad"><bean:message key="catalogadorAvanzado.SeleccioneIdioma"/></bean:define>
																	<cat:select name="form" property="Edad${i}_Idio${j}" value="${contenido.idioma}" backingList="${form.comboIdiomaBackingList}" estiloSelect="select_peq_n inp_se_ie" estiloOscuro="oscura" title="${edad}"/>
																	
															</div>
														</div>
														<div class="float_izquierda_n">
															<c:choose>
																<c:when test="${j==0}">   
																	<span class="oculto">-</span> 
																	<input class="boton_anadir cms_ie" type="submit" name="accion_Añadir Contenido Edad Tipica-${i}" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/> 
																	
																
																</c:when>
																<c:otherwise>
																	&nbsp;
																</c:otherwise>
															</c:choose>
														</div>
														<div class="float_izquierda_n">
															<c:set var="longitud" value="${ longEdad }"/>
															<c:choose>
																<c:when test="${longitud>1}">   
																	<span class="oculto">-</span>
																	<input class="boton_eliminar cms_ie" type="submit" name="accion_Eliminar Contenido Edad Tipica-${j}-${i}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/> 
																	
																</c:when>
																<c:otherwise>
																	&nbsp;
																</c:otherwise>
															</c:choose>	 
														</div>
														<div class="limpiar">
														</div><br class="oculto"/>
													</div>
										</logic:iterate>	
										<c:set var="longDescripcionAnterior" value="${ longEdad + longEdadAnterior }"/>
				    <!--  Fin Fila de Campos   -->
					<!--  Fin Fila de Campos   -->
												</div>
											</div>
										</div>
									</div>	
	<!--  FIN GLOBO GRIS   -->
	<!--  FIN GLOBO GRIS   -->
									<!--  Enlaces de fuera   -->
									<div class="flotder">
										<c:choose>
											<c:when test="${i==0}">   
												<span class="oculto">-</span>	
												<span class="flotder enlace_anadir_02">
													<input class="boton_anadir flotder" type="submit" name="accion_Añadir Edad Tipica" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/> 
													
												</span>
											</c:when>
											<c:otherwise>
												<span class="oculto">-</span>	
												<span class="flotder enlace_anadir_02">											
												&nbsp;
												</span>
											</c:otherwise>
										</c:choose>	
										<c:set var="longitud" value="${ fn:length(form.edadTipica) }"/>
										<c:choose>
											<c:when test="${longitud>1}">   
												<span class="oculto">-</span>	
												<span class="flotder enlace_eliminar_02">
													<input class="boton_eliminar flotder" type="submit" name="accion_Eliminar Edad Tipica-${i }" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/>
												</span>
											</c:when>
											<c:otherwise>
												<span class="oculto">-</span>	
												<span class="flotder enlace_eliminar_02">
												&nbsp;
												</span>
											</c:otherwise>
										</c:choose>
									</div>
									<!--  Fin Enlaces de fuera   -->
									<div class="limpiar">
									</div>
									</logic:iterate>
								</div>	
								<!--  FIN CAJA DE FORMULARIO   -->							
							</div>
						</div>
					</div>
				</div>	<!--  FIN GLOBO GRIS   -->
	<!--  FIN GLOBO GRIS   -->

<!--  INICIO GLOBO GRIS Dificultad -->
<!--  INICIO GLOBO GRIS Dificultad  -->
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
					
					<h3><bean:message key="catalogadorAvanzado.DetalleEdu.Dificultad"/></h3>
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
			<div class="globo_blanco pos_relative conmargen" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
						<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp" >
  						<div class="text">
  							<label for="Dificultad01" class="oculto" >Tipo:</label>
							<bean:define id="dificult"><bean:message key="catalogadorAvanzado.SeleccioneDificultad"/></bean:define>
							<cat:select name="form" property="dificultad" value="${form.dificultad}" backingList="${form.dificultadBackingList}" estiloSelect="select_lrg" title="${dificult}" estiloOscuro="oscura"/>
							
							
						</div>
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				<!--  FIn Fila de Campos   -->
				<!--  fIN Fila de Campos   -->
				</div>
		</div>
	</div>
</div>
</div>
		<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS Dificultad  -->
<!--  FIN GLOBO GRIS Dificultad  -->

<!--  INICIO GLOBO GRIS  Tiempo de Aprendizaje Típico  -->
<!--  INICIO GLOBO GRIS  Tiempo de Aprendizaje Típico  -->
<div class="globo_gris pos_relative conmargen" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
			
			<h3><bean:message key="catalogadorAvanzado.DetalleEdu.TiempoAprendizaje"/></h3>
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
			<div class="globo_blanco pos_relative conmargen" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
						<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="AnioDur" class="rdr" ><bean:message key="catalogadorAvanzado.DetalleEdu.Años"/>:</label>
							<html:text styleClass="in_peq input_mder2 acentrado" property="Anyos" value="${anyo}" styleId="Anyos" onfocus="limpiarTexto(this)" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaAnos"/>
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="MesDur" class="rdr" ><bean:message key="catalogadorAvanzado.DetalleEdu.Meses"/>:</label>
							<html:text styleClass="in_peq input_mder2 acentrado" property="Meses" value="${mes}" styleId="Meses" onfocus="limpiarTexto(this)" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaMeses"/>						
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="DiaDur" class="rdr" ><bean:message key="catalogadorAvanzado.DetalleEdu.Dias"/>:</label>
							<html:text styleClass="in_peq input_mder2 acentrado" property="Dias" value="${dia}" styleId="Anyos" onfocus="limpiarTexto(this)" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaDias"/>
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="HoraDur" class="rdr" ><bean:message key="catalogadorAvanzado.DetalleEdu.Horas"/>:</label>
							<html:text styleClass="in_peq input_mder2 acentrado" property="Horas" value="${hora}" styleId="Horas" onfocus="limpiarTexto(this)" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaHoras"/>
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="MinutosDur" class="rdr" ><bean:message key="catalogadorAvanzado.DetalleEdu.Minutos"/>:</label>
							<html:text styleClass="in_peq input_mder2 acentrado" property="Minutos" value="${minutos}" styleId="Minutos" onfocus="limpiarTexto(this)" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaMinutos"/>
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="SegundosDur" class="rdr" ><bean:message key="catalogadorAvanzado.DetalleEdu.Segundos"/>:</label>
							<html:text styleClass="in_peq input_mder2 acentrado" property="SegundosP1" value="${segundosP1}" styleId="SegundosP1" onfocus="limpiarTexto(this)" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaSegundos"/>
						</div>
					</div>
					<div class="contenedor_izquierda_esp " >
					<div class="text input_mder2">.</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="SegundosDur2" class="oculto" ><bean:message key="catalogadorAvanzado.DetalleEdu.Segundos"/>:</label>
							<html:text styleClass="in_peq input_mder2 acentrado" property="SegundosP2" value="${segundosP2}" styleId="SegundosP2" onfocus="limpiarTexto(this)" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaSegundos"/>
						</div>
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				<!--  FIn Fila de Campos   -->
				<!--  fIN Fila de Campos   -->
				</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO BLANCO   -->
<!--  FIN GLOBO BLANCO   -->
		<!--  INICIO GLOBO Blanco   -->
			<!--  INICIO GLOBO Blanco   -->
			<div class="globo_blanco" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
					<div class="globo_blanco_03">
				<!-- -->
	<!--  INICIO Fila de Campos   -->
				<logic:iterate id="taDesc" name="tiempoApDescripcion" indexId="i">	
						
					<c:set var="textos" value="${taDesc.textos }"/>
					<logic:iterate id="texto" name="textos" indexId="j">	
								<!--anclas-->
									<c:choose>
				                        <c:when test="${j== fn:length(textos)-1}">   
					                     <a id="descTiempoAp"></a>
				                        </c:when>
				                    </c:choose>	
									<a id="descTiempoAp-${j}"></a>
									<!--fin de anclas-->
					<div class="fila_de_tabla_especial" style="padding-left:0 !important">
  					<div class="contenedor_izquierda_esp">
  						<div class="text"><label for="Dur01" ><bean:message key="catalogadorAvanzado.DetalleEdu.SoloDescripcion"/>:</label></div>
 					</div>
  					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="DesTA${j} }" class="oculto" ><bean:message key="catalogadorAvanzado.DetalleEdu.SoloDescripcion"/>:</label>
  						<html:textarea styleClass="input_medio_largo input_mder" property="TADesTex${j}" value="${texto.texto}" styleId="TADes${j}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaDescripcion" cols="5" rows="4"/>
  						</div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text">
							<label for="Idio01" class="oculto" ><bean:message key="catalogadorAvanzado.DetalleEdu.SoloDescripcion"/>:</label>
							<bean:define id="tDesc"><bean:message key="catalogadorAvanzado.SeleccioneIdioma"/></bean:define>
							<cat:select name="form" property="TADesIdio${j}" value="${texto.idioma}" backingList="${form.comboIdiomaBackingList}" estiloSelect="select_peq_n inp_se_ie" estiloOscuro="oscura" title="${tDesc}"/>
							
						</div>
					</div>
					<div class="float_izquierda_n">
					<c:choose>
                   		<c:when test="${j==0}">   
					    	<span class="oculto">-</span> 
	                        <input class="boton_anadir cms_ie" type="submit" name="accion_Añadir Descripcion TiempoAp" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/> 
					        
                		</c:when>
				        <c:otherwise>
                			&nbsp;
				        </c:otherwise>
                	</c:choose> 
					</div>
					<div class="float_izquierda_n"> 
					<c:set var="longitud" value="${ fn:length(textos) }"/>
					<c:choose>
				    	<c:when test="${longitud>1}">   
	            			<span class="oculto">-</span> 
	            			<input class="boton_eliminar cms_ie" type="submit" name="accion_Eliminar Descripcion TiempoAp-${j}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/> 
					        
				        </c:when>
                		<c:otherwise>
                        &nbsp;
				        </c:otherwise>
                	</c:choose>	
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				</logic:iterate>
				</logic:iterate>
	<!--  Fin Fila de Campos   -->
				<!-- -->
				<!-- -->
				</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO BLANCO   -->
<!--  FIN GLOBO BLANCO   -->
	</div>
	<!--  FIN CAJA DE FORMULARIO   -->
		</div>
	</div>
</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->

	<!--  INICIO GLOBO GRIS  Descripción -->
	<!--  INICIO GLOBO GRIS Descripción  -->
				<div class="globo_gris conmargen">
					<div class="globo_gris_01">
						<div class="globo_gris_02">
							<div class="globo_gris_03">	<!--  INICIO CAJA DE FORMULARIO   -->
								<div class="formu">
									<h3 class="h3flotante"><bean:message key="catalogadorAvanzado.DetalleEdu.Descripcion"/></h3>
									<c:set var="longDescripcionAnterior" value="0"/>
									<logic:iterate id="descripcion" name="descripciones" indexId="i">
													<!--anclas-->
													<c:choose>
								                        <c:when test="${i== fn:length(form.descripciones)-1}">   
									                     <a id="descripciones"></a>
								                        </c:when>
								                    </c:choose>	
													<a id="descripcion-${i}"></a>
													<!--fin de anclas-->
									<!--  INICIO GLOBO BLANCO   -->
									<!--  INICIO GLOBO BLANCO   -->
									<div class="globo_blanco globito flotder">
										<div class="globo_blanco_01">
											<div class="globo_blanco_02">
												<div class="globo_blanco_03">	
								<!--  INICIO Fila de Campos   -->
								<!--  INICIO Fila de Campos   -->

										<c:set var="textos" value="${descripcion.textos }"/>
										<c:set var="longDescripcion" value="${ fn:length(textos) }"/>
										<logic:iterate id="contenido" name="textos" indexId="j">
													<!--anclas-->
													<c:choose>
								                        <c:when test="${j== fn:length(textos)-1}">   
									                     <a id="contDescripciones-${i}"></a>
								                        </c:when>
								                    </c:choose>	
													<a id="contDescripcion-${j}-${i}"></a>
													<!--fin de anclas-->	
			<c:set var="caracteristica" value="${ form.descripcionesCat[i][j] }"/>
			<c:set var="indice" value="${j + longDescripcionAnterior}"/>



													<div class="fila_de_tabla_especial_03">
		<c:if test="${caracteristica.seleccionado==0 }">		
								  					<input type="radio"  class="boton_radio" name="Des${i}_Sel${j}" value="0" checked="checked" onclick="javascript:habilitarDescripcion(${i},${j},0);" style="display:none;">
		</c:if>
		<c:if test="${caracteristica.seleccionado!=0 }">		
								  					<input type="radio"  class="boton_radio" name="Des${i}_Sel${j}" value="0" onclick="javascript:habilitarDescripcion(${i},${j},0);" style="display:none;">
		</c:if>
														<div class="contenedor_izquierda_esp">
															<div class="text">
															<label for="Des${j}" class="oculto" ><bean:message key="catalogadorAvanzado.DetalleEdu.SoloDescripcion"/>:</label>
															<html:textarea styleClass="input_medio_largo input_mder" property="Des${i}_Tex${j}" value="${contenido.texto}" styleId="Des${i}_Tex${j}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaUtilizar" cols="5" rows="4" />
															</div>
														</div>
														<div class="contenedor_izquierda_esp">
															<div class="text">
																<label for="Idio05" class="oculto" ><bean:message key="catalogadorAvanzado.DetalleEdu.SoloIdioma"/>:</label>
																<bean:define id="descrip"><bean:message key="catalogadorAvanzado.SeleccioneIdioma"/></bean:define>
																<cat:select name="form" property="Des${i}_Idio${j}" value="${contenido.idioma}" backingList="${form.comboIdiomaBackingList}" estiloSelect="select_peq_n inp_se_ie" estiloOscuro="oscura" title="${descrip}"/>
																
															</div>
														</div>
														<div class="float_izquierda_n">
															<c:choose>
																<c:when test="${j==0}">   
																	<span class="oculto">-</span> 
																	<input class="boton_anadir cms_ie" type="submit" name="accion_Añadir Contenido Descripcion-${i}" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/> 
																</c:when>
																<c:otherwise>
																	&nbsp;
																</c:otherwise>
															</c:choose>
														</div>
														<div class="float_izquierda_n">
																	<span class="oculto">-</span>
																	<input class="boton_eliminar cms_ie" type="submit" name="accion_Eliminar Contenido Descripcion-${j}-${i}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/> 
														</div>
														<br class="limpiar" />
														
														
														<a class="desplegado" id="enlace-caract-${i}-${j}" href="javascript:;" onclick="expandirCaja('caract-${i}-${j}');return false;" onkeypress="expandirCaja('caract-${i}-${j}');return false;">
														<br class="falso"><span id="dm1"><bean:message key="catalogadorAvanzado.DetalleEdu.Descripciones.masDatos"/></span></a>
														
							
										</div>													
				<br />								

			<!--  Fila de Campos  caracteristica -->
			<!--  INICIO CAJA DE FORMULARIO   -->
			
			
			<script type="text/javascript" languaje="JavaScript">
			//<![CDATA[
				document.write('<div id="caract-${i}-${j}" class="caja_cerrada" >');
			//]]>
			</script>
			<noscript><div id="caract-${i}-${j}" class="caja_abierta" ></noscript>
			
			  <!-- INICIO TABLA  -->
				<div class="globo_blanco_trans" >
					<div class="globo_blanco_01_trans">
						<div class="globo_blanco_02_trans">
							<div class="globo_blanco_03_trans">

										<!--  INICIO Fila de Campos - Conocimiento previo  -->

								  					<label class="oculto" for="Conocimiento previo" ><bean:message key="catalogadorAvanzado.DetalleEdu.Descripciones.ConocimientoPrevio.label"/></label>
		<c:if test="${caracteristica.seleccionado==1 }">
								  					<input type="radio"  class="boton_radio" name="Des${i}_Sel${j}" value="1" checked="checked" onclick="javascript:habilitarDescripcion(${i},${j},1);">
		</c:if>
		<c:if test="${caracteristica.seleccionado!=1 }">		
								  					<input type="radio"  class="boton_radio" name="Des${i}_Sel${j}" value="1" onclick="javascript:habilitarDescripcion(${i},${j},1);">
		</c:if>
							  					<span class="vert"><bean:message key="catalogadorAvanzado.DetalleEdu.Descripciones.ConocimientoPrevio.label"/></span>

								  				<br class="limpiar" />
					  							<label class="oculto" for="Conocimiento previo" ><bean:message key="catalogadorAvanzado.DetalleEdu.Descripciones.ConocimientoPrevio.label"/></label>
					  							<html:textarea styleClass="input_medio_largo input_mder lr" property="Des${i}_CPre${j}" value="${caracteristica.conocimientoPrevio}" styleId="Des${i}_CPre${j}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.DetalleEdu.Descripciones.ConocimientoPrevio.title"  cols="5" rows="4"  />
												<br class="limpiar" />
										<!--  Fin Fila de Campos - Conocimiento previo  -->


										<!--  INICIO Fila de Campos -  Objetivos didácticos -->
												<label class="oculto"  for="Objetos Didacticos" ><bean:message key="catalogadorAvanzado.DetalleEdu.Descripciones.ObjetivosDidacticos.label"/></label>
 			<c:if test="${caracteristica.seleccionado==2 }">
									  			<input type="radio" class="boton_radio"  name="Des${i}_Sel${j}" value="2" checked="checked" onclick="javascript:habilitarDescripcion(${i},${j},2);">
 			</c:if>
  			<c:if test="${caracteristica.seleccionado!=2 }">		
									  			<input type="radio" class="boton_radio"  name="Des${i}_Sel${j}" value="2" onclick="javascript:habilitarDescripcion(${i},${j},2);">
									  					
  			</c:if>
  												<span class="vert"><bean:message key="catalogadorAvanzado.DetalleEdu.Descripciones.ObjetivosDidacticos.label"/></span>
  												<br class="limpiar" />
  												
					  							<label class="oculto"  for="Objetos Didacticos" ><bean:message key="catalogadorAvanzado.DetalleEdu.Descripciones.ObjetivosDidacticos.label"/></label>
						 					    <html:textarea styleClass="input_medio_largo input_mder lr" property="Des${i}_ODid${j}" value="${caracteristica.objetivosDidacticos}" styleId="Des${i}_ODid${j}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.DetalleEdu.Descripciones.ObjetivosDidacticos.title"  cols="5" rows="4"  />
												<br class="limpiar" />
												
										<!--  Fin Fila de Campos -   Objetivos didácticos -->


										<!--  INICIO Fila de Campos  - Tipo de Conocimientos -->
										<div class="fila_de_tabla_especial_03">
										<label for="TipCon01" class="oculto">Tipo de Conocimiento</label>
  			<c:if test="${caracteristica.seleccionado==3 }">
								  					<input type="radio" class="boton_radio"  name="Des${i}_Sel${j}" value="3" checked="checked" onclick="javascript:habilitarDescripcion(${i},${j},3);">
  			</c:if>
  			<c:if test="${caracteristica.seleccionado!=3 }">		
								  					<input type="radio" class="boton_radio"  name="Des${i}_Sel${j}" value="3" onclick="javascript:habilitarDescripcion(${i},${j},3);">
 			</c:if>
										<span class="vert">Tipo de Conocimiento</span>
						  				<br class="limpiar" />
						  				
						  				<div class="caja_de_tabla_invisible" id="sd_bor4">
												<table border="0" cellspacing="0" cellpadding="0" border="0"  width="100%"  summary="opciones">
										<logic:iterate id="tipoC" name="form" property="descripcionTipoConocimiento">
													<tr>
														<td >
															<bean:define id="tituloTipoConocimiento"><bean:message key="catalogadorAvanzado.DetalleEdu.Descripciones.TipoConocimientos.title"/></bean:define>
															<cat:custom_multibox listaSeleccionados="${caracteristica.tipoConocimiento}" name="Des${i}_TCon${j}"  value="${tipoC.idTermino}" id="Des${i}_TCon${j}" clase="check" title="${tituloTipoConocimiento}" />
														</td>
														<td class="td_largo_09" valign="top">
															<label for="tipoConocimiento-${i}-${j}">${tipoC.nomTermino}</label>
														</td>
													</tr>
										</logic:iterate>
												</table>
											</div>
											
											<br class="oculto" />
										<!--  Fin Fila de Campos -   Tipo Conocimientos -->

										<fieldset class="tipo ft_centrada" style="margin-top:0 !important;">
											<input class="boton_125" style="height:2.2em;"  type="submit" name="accion_Añadir DescripcionCat-${i}-${j}" value="<bean:message key="catalogadorAvanzado.DetalleEdu.Descripciones.Anadir"/>" />
										</fieldset>
										</div>	
										
								</div> 
							</div>
						</div>
					</div>
					
			<script type="text/javascript" languaje="JavaScript">
			//<![CDATA[
				document.write('</div>');
			//]]>
			</script>
				<br class="limpiar"/>

				
					<!--  Fin Fila de Campos  caracteristica  -->
													
													
													
													
													
													
													
													
													
													
													
													
										</logic:iterate>	
										<c:set var="longDescripcionAnterior" value="${ longDescripcion + longDescripcionAnterior }"/>
				    <!--  Fin Fila de Campos   -->
					<!--  Fin Fila de Campos   -->
												</div>
											</div>
										</div>
									</div>	
	<!--  FIN GLOBO GRIS   -->
	<!--  FIN GLOBO GRIS   -->
									<!--  Enlaces de fuera   -->
									<div class="flotder">
										<c:choose>
											<c:when test="${i==0}">   
												<span class="oculto">-</span>	
												<span class="flotder enlace_anadir_02">
													<input class="boton_anadir flotder" type="submit" name="accion_Añadir Descripcion" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/> 
													
												</span>
											</c:when>
											<c:otherwise>
												<span class="oculto">-</span>	
												<span class="flotder enlace_anadir_02">											
												&nbsp;
												</span>
											</c:otherwise>
										</c:choose>	
										<c:set var="longitud" value="${ fn:length(form.descripciones) }"/>
										<c:choose>
											<c:when test="${longitud>1}">   
												<span class="oculto">-</span>	
												<span class="flotder enlace_eliminar_02">
													<input class="boton_eliminar flotder" type="submit" name="accion_Eliminar Descripcion-${i }" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/> 
													
												</span>
											</c:when>
											<c:otherwise>
												<span class="oculto">-</span>	
												<span class="flotder enlace_eliminar_02">
												&nbsp;
												</span>
											</c:otherwise>
										</c:choose>
									</div>
									<!--  Fin Enlaces de fuera   -->
									<div class="limpiar">
									</div>
									</logic:iterate>
								</div>	
								<!--  FIN CAJA DE FORMULARIO   -->							
							</div>
						</div>
					</div>
				</div>	<!--  FIN GLOBO GRIS   -->
	<!--  FIN GLOBO GRIS   -->


<!--  INICIO GLOBO GRIS Idioma -->
<!--  INICIO GLOBO GRIS Idioma  -->
<a id="idioma"></a>
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
					
					<h3><bean:message key="catalogadorAvanzado.DetalleEdu.Idioma"/></h3>
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
<logic:iterate id="idioma" name="idiomas" indexId="i">
			<div class="globo_blanco globito flotder" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
					
					<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp" >
  						<div class="text">
  							<label for="Idioma_tipo01" class="oculto" ><bean:message key="catalogadorAvanzado.DetalleEdu.SoloIdioma"/>:</label>
							<bean:define id="idiom"><bean:message key="catalogadorAvanzado.SeleccioneIdioma"/></bean:define>
							<cat:select name="form" estilo="width:430px !important" property="Idio${i}" value="${idioma.texto}" backingList="${form.idiomasBackingList}" estiloSelect="select_lrg inp_se_ie" estiloOscuro="oscura" title="${idiom}"/>
							
						</div>
					</div>
					<div class="limpiar">
					</div><br class="oculto"/>
					</div>
					</div>
					</div>
					</div>
					</div>
					<div class="flotder">
						<c:choose>
                			<c:when test="${i==0}">   
		                        <span class="oculto">-</span>
		                        <span class="flotder enlace_anadir_02"> 
		                        <input class="boton_anadir flotder" type="submit" name="accion_Añadir Idioma" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/> 
		        				</span>
             				</c:when>
	                        <c:otherwise>
	                        <span class="oculto">-</span>
		                        <span class="flotder enlace_anadir_02"> 
             					&nbsp;
             					</span>
	                        </c:otherwise>
             			</c:choose>
					</div>
					<div class="flotder">
						<c:set var="longitud" value="${ fn:length(form.idiomas) }"/>
						<c:choose>
	                        <c:when test="${longitud>1}">   
          				            <span class="oculto">-</span> 
          				            <span class="flotder enlace_eliminar_02">
          				             <input class="boton_eliminar flotder" type="submit" name="accion_Eliminar Idioma-${i}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/> 					            
			    				 	</span>
	                        </c:when>
             				        <c:otherwise>
             				        <span class="oculto">-</span> 
          				            <span class="flotder enlace_eliminar_02">
                      				&nbsp;
                      				</span>
	                        </c:otherwise>
             			</c:choose>
					</div>
					<div class="limpiar"></div>
				</logic:iterate>
				</div>	

				<!--  Fin Fila de Campos   -->
				</div>
		</div>
	</div>
</div>

<!--  FIN GLOBO GRIS   -->


<!--  INICIO GLOBO GRIS Proceso Cognitivo -->
<!--  INICIO GLOBO GRIS Proceso Cognitivo  -->
<a id="proceso"></a>
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
					
					<h3><bean:message key="catalogadorAvanzado.DetalleEdu.ProcesoCognitivo"/></h3>
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
<logic:iterate id="proceso" name="procesoCognitivo" indexId="i">
			<div class="globo_blanco globito flotder" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
							
						<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp" >
  						<div class="text">
  							<label for="Proceso_cognitivo01" class="oculto" ><bean:message key="catalogadorAvanzado.DetalleEdu.SoloProcesoCognitivo"/>:</label>
							<bean:define id="proces"><bean:message key="catalogadorAvanzado.SeleccioneProcesoCognitivo"/></bean:define>
							<cat:select name="form" estilo="width:430px !important" property="PCog${i}" value="${proceso.valor}" backingList="${form.comboProcesoBackingList}" estiloSelect="select_lrg inp_se_ie" estiloOscuro="oscura" title="${proces}"/>
							
						</div>
					</div>
					<div class="limpiar">
					</div><br class="oculto"/>
					</div>
					</div>
					</div>
					</div>
					</div>
					<div class="flotder">
						<c:choose>
                			<c:when test="${i==0}">   
		                        <span class="oculto">-</span> 
		                        <span class="flotder enlace_anadir_02">
		                        <input class="boton_anadir flotder" type="submit" name="accion_Añadir Proceso Cognitivo" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/> 
		        				</span>
             				</c:when>
	                        <c:otherwise>
	                        <span class="oculto">-</span> 
		                        <span class="flotder enlace_anadir_02">
             				   	&nbsp;
             				   	</span>
	                        </c:otherwise>
             			</c:choose>
					</div>
					<div class="flotder">
						<c:set var="longitud" value="${ fn:length(form.procesoCognitivo) }"/>
						<c:choose>
		                	<c:when test="${longitud>1}">   
		        				<span class="oculto">-</span> 
		        				<span class="flotder enlace_eliminar_02">
		        				<input class="boton_eliminar flotder" type="submit" name="accion_Eliminar Proceso Cognitivo-${i}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/> 					            
			    				</span>
		                  	</c:when>
		           			<c:otherwise>
		           			<span class="oculto">-</span> 
		        				<span class="flotder enlace_eliminar_02">
		                    	&nbsp;
		                    	</span>
		                    </c:otherwise>
		           		</c:choose>	
					</div>
					<div class="limpiar"></div>	
				</logic:iterate>
				<!--  FIn Fila de Campos   -->
				<!--  fIN Fila de Campos   -->
	
		<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS   -->




</div>

<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<fieldset class="tipo ft_centrada">
	<input class="boton_125" id="reset_but" type="submit" name="accion" value="<bean:message key="detalleusoedu.Reset"/>" /><br />

	<input class="boton_125_de_2"  type="submit" name="accion" value="<bean:message key="detalleusoedu.Aceptar"/>" />
	<input class="boton_125_de_2_izq"  type="submit"  name="accion"  value="<bean:message key="detalleusoedu.Cancelar"/>" />
	<input class="boton_125"  type="submit"  name="accion" value="<bean:message key="detalleusoedu.Validar"/>" />
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->

</form>
<!-- Fin plantilla contenido  -->
</tiles:put>

</tiles:insert>

