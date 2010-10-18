<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>
<tiles:insert definition="layout-principalInicio2">
<tiles:put name="title" type="string">
	<bean:message key="title.BasicPlus"/>
</tiles:put> 

<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/catalogadorBasicPlus/catalogador-form-vars.jspf" %>
	

		<div class="plantilla_contenido"><h2><bean:message key="catalogadorBasicPlus.Catalogador"/></h2>
		<jsp:include page="/layout/messages.jsp" flush="true"/>
			<form method="post" enctype="multipart/form-data" action="<html:rewrite action="/CatalogadorBasicPlus/CatalogadorFormSubmit"/>">
					<p class="parrafo_comun" id="separacion2"><bean:message key="catalogadorBasicPlus.Rellenar"/></p>
			<!--  INICIO GLOBO GRIS   -->
			<!--  INICIO GLOBO GRIS   -->
<style type="text/css">
#formulario label, #formulario_02 label, #formulario_03 label, .formu label {
	color:#4B4B4B;
	display:block;
	font-size:125%;
	padding-left:0;
	padding-right:0;
	padding-top:5px;
	width:120px;
}
#formulario input, #formulario_02 input, #formulario_03 input, .formu input {
	border:1px solid #8BA6BF;
	color:#4B4B4B;
	font-size:120%;
	height:17px;
	margin-bottom:10px;
	margin-top:3px;
	width:90%;
}


</style>

				<div class="globo_gris">
					<div class="globo_gris_01">
						<div class="globo_gris_02">
							<div class="globo_gris_03">	<!--  INICIO CAJA DE FORMULARIO   -->
								<div id="formulario">
									<div class="fila_de_tabla">
										<div class="contenedor_izquierda">
											<div class="text"><label for="Titulo"><bean:message key="catalogadorBasicPlus.Titulo"/></label>
											</div>
										</div>
										<div class="contenedor_derecha">
											<div class="text">												
												
												<html:text property="titulo" value="${titulo}" styleId="Titulo" maxlength="125" titleKey="catalogadorBasicPlus.IntroduzcaTitulo" />
												
											</div>
										</div>
										<div class="linea_separadora">
										</div><br class="oculto"/>
									</div>	<!-- -->
									<div class="fila_de_tabla">
										<div class="contenedor_izquierda">
											<div class="text">
											 <label for="Idioma"><bean:message key="catalogadorBasicPlus.Idioma"/></label>
											</div>
										</div>
										<div class="contenedor_derecha">
											<div class="text">											
											                              
											    <c:choose>
				                                <c:when test="${!empty form.idiomaBackingList}">	
                                  					<html:select name="form" property="idioma" titleKey="catalogadorBasicPlus.SeleccioneIdioma" >
                                  						<c:set var="colorblanco" value="true"/>
                                  					    <c:set var="long" value="${fn:length(form.idiomaLabelList)}"/>
                                  						<fmt:formatNumber var="longIdiomaList" value="${long - 1 }" type="number"/>
                                  						<c:forEach  items="${form.idiomaBackingList}" var="listaIdioma" begin ="0" end="${longIdiomaList}">
                                  							<c:choose>
                                  							<c:when test="${colorblanco}">   
                                  								<html:option value="${listaIdioma.value }">${listaIdioma.label }</html:option>
                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
                                  							</c:when>
                                  							<c:otherwise>
                                  								<html:option value="${listaIdioma.value }" styleClass="oscura">${listaIdioma.label }</html:option>
                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
                                  							</c:otherwise>
                                  							</c:choose>	
                                  						</c:forEach>
                                  					</html:select>
                               					</c:when>
                               					<c:otherwise>
                                   					<html:select name="form" property="idiomaBackingList" />
                               					</c:otherwise>
                           						</c:choose>						 	
											</div>
										</div>
										<div class="linea_separadora">
										</div><br class="oculto"/>
									</div>	
									<div class="fila_de_tabla">
										<div class="contenedor_izquierda">
											<div class="text"><label for="Descripcion"><bean:message key="catalogadorBasicPlus.Descripcion"/></label>
											</div>
										</div>
										<div class="contenedor_derecha">
											<div class="text">
												<textarea name="description" style="maxlength: 150; font-style: normal; font-size: 120%;" 
												 rows="10" cols="40" class="ta_minimo_ancho"  id="Descripcion" title="<bean:message key="catalogadorBasicPlus.IntroduzcaDescripcion"/>">${form.description}</textarea>
											</div>
										</div>
										<div class="linea_separadora">
										</div><br class="oculto"/>
									</div>	<!-- -->
									
									<!-- Keyword -->
									<div class="fila_de_tabla">
										<div class="contenedor_izquierda">
											<div class="text"><label for="Keyword"><bean:message key="catalogadorBasicPlus.Keyword"/></label>
											</div>
										</div>
										<div class="contenedor_derecha">
											<div class="text">												
												<html:text property="keyword" value="${keyword}" styleId="Titulo" maxlength="125" titleKey="catalogadorBasicPlus.Keyword" />
											</div>
										</div>
										<div class="linea_separadora">
										</div><br class="oculto"/>
									</div>
									
									<!-- Aggregation Level -->
									<div class="fila_de_tabla">
										<div class="contenedor_izquierda">
											<div class="text">
											 <label for="aggregationLevel"><bean:message key="catalogadorBasicPlus.AggregationLevel"/></label>
											</div>
										</div>
										<div class="contenedor_derecha">
											<div class="text">											
											                              
											    <c:choose>
				                                <c:when test="${!empty form.aggregationLevelBackingList}">	
                                  					<html:select name="form" property="aggregationLevel" titleKey="catalogadorBasicPlus.AggregationLevel" >
                                  						<c:set var="colorblanco" value="true"/>
                                  					    <c:set var="long" value="${fn:length(form.aggregationLevelLabelList)}"/>
                                  						<fmt:formatNumber var="longAggregationLevelList" value="${long - 1 }" type="number"/>
                                  						<c:forEach  items="${form.aggregationLevelBackingList}" var="aggregationLevelList" begin ="0" end="${longAggregationLevelList}">
                                  							<c:choose>
                                  							<c:when test="${colorblanco}">   
                                  								<html:option value="${aggregationLevelList.value }">${aggregationLevelList.label }</html:option>
                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
                                  							</c:when>
                                  							<c:otherwise>
                                  								<html:option value="${aggregationLevelList.value }" styleClass="oscura">${aggregationLevelList.label }</html:option>
                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
                                  							</c:otherwise>
                                  							</c:choose>	
                                  						</c:forEach>
                                  					</html:select>
                               					</c:when>
                               					<c:otherwise>
                                   					<html:select name="form" property="aggregationLevelBackingList" />
                               					</c:otherwise>
                           						</c:choose>						 	
											</div>
										</div>
										<div class="linea_separadora">
										</div><br class="oculto"/>
									</div>

									<!-- Outline section -->
									<div class="basicplus_outline">
									
										<!-- LifeCycle Author Full Name -->									
										<div class="fila_de_tabla">
											<div class="contenedor_izquierda">
												<div class="text"><label for="authorFullName"><bean:message key="catalogadorBasicPlus.AuthorFullName"/></label>
												</div>
											</div>
											<div class="contenedor_derecha">
												<div class="text">																								
													<html:text property="authorFullName" value="${form.authorFullName}" styleId="Titulo" maxlength="125" titleKey="catalogadorBasicPlus.AuthorFullName" />												
												</div>
											</div>
											<div class="linea_separadora">
											</div><br class="oculto"/>
										</div>
	
										<!-- LifeCycle Author Organisation -->
										<div class="fila_de_tabla">
											<div class="contenedor_izquierda">
												<div class="text"><label for="authorOrganisation"><bean:message key="catalogadorBasicPlus.AuthorOrganisation"/></label>
												</div>
											</div>
											<div class="contenedor_derecha">
												<div class="text">																								
													<html:text property="authorOrganisation" value="${form.authorOrganisation}" styleId="Titulo" maxlength="125" titleKey="catalogadorBasicPlus.AuthorOrganisation" />												
												</div>
											</div>
											<div class="linea_separadora">
											</div><br class="oculto"/>
										</div>
									
									</div>
									<!-- End of outline -->
									
									<!-- LifeCycle Provider Full Name -->
									<div class="fila_de_tabla">
										<div class="contenedor_izquierda">
											<div class="text"><label for="providerFullName"><bean:message key="catalogadorBasicPlus.ProviderFullName"/></label>
											</div>
										</div>
										<div class="contenedor_derecha">
											<div class="text">																								
												<html:text property="providerFullName" value="${form.providerFullName}" styleId="Titulo" maxlength="125" titleKey="catalogadorBasicPlus.ProviderFullName" />												
											</div>
										</div>
										<div class="linea_separadora">
										</div><br class="oculto"/>
									</div>
									
<%-- /////////////// --%>

										<!-- Format -->
										<div class="fila_de_tabla">
											<div class="contenedor_izquierda">
												<div class="text">
												 <label for="Format"><bean:message key="catalogadorBasicPlus.Format"/></label>
												</div>
											</div>
											<div class="contenedor_derecha">
												<div class="text">											
												                              
												    <c:choose>
					                                <c:when test="${!empty form.formatBackingList}">	
	                                  					<html:select name="form" property="format" titleKey="catalogadorBasicPlus.Format" >
	                                  						<c:set var="colorblanco" value="true"/>
	                                  					    <c:set var="long" value="${fn:length(form.formatLabelList)}"/>
	                                  						<fmt:formatNumber var="longFormatList" value="${long - 1 }" type="number"/>
	                                  						<c:forEach  items="${form.formatBackingList}" var="formatList" begin ="0" end="${longFormatList}">
	                                  							<c:choose>
	                                  							<c:when test="${colorblanco}">   
	                                  								<html:option value="${formatList.value }">${formatList.label }</html:option>
	                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
	                                  							</c:when>
	                                  							<c:otherwise>
	                                  								<html:option value="${formatList.value }" styleClass="oscura">${formatList.label }</html:option>
	                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
	                                  							</c:otherwise>
	                                  							</c:choose>	
	                                  						</c:forEach>
	                                  					</html:select>
	                               					</c:when>
	                               					<c:otherwise>
	                                   					<html:select name="form" property="formatBackingList" />
	                               					</c:otherwise>
	                           						</c:choose>						 	
												</div>
											</div>
											<div class="linea_separadora">
											</div><br class="oculto"/>
										</div>	
<%-- /////////////// --%>


									<!-- Technical Duration -->
									<div class="fila_de_tabla">
										<div class="contenedor_izquierda">
											<div class="text"><label for="duration"><bean:message key="catalogadorBasicPlus.Technical.Duration"/></label>
											</div>
										</div>
										<div class="contenedor_derecha">
											<div class="text">
												<div class="basicplus_duration">																						
													<html:text property="durationYears" value="${form.durationYears}" styleId="basicplus_duration_text" maxlength="2" titleKey="catalogadorBasicPlus.Technical.Duration.Years" /><label for="durationYears"><bean:message key="catalogadorBasicPlus.Technical.Duration.Years"/></label>
													<html:text property="durationMonths" value="${form.durationMonths}" styleId="basicplus_duration_text" maxlength="2" titleKey="catalogadorBasicPlus.Technical.Duration.Months" /><label for="durationMonths"><bean:message key="catalogadorBasicPlus.Technical.Duration.Months"/></label>
													<html:text property="durationDays" value="${form.durationDays}" styleId="basicplus_duration_text" maxlength="2" titleKey="catalogadorBasicPlus.Technical.Duration.Days" /><label for="durationDays"><bean:message key="catalogadorBasicPlus.Technical.Duration.Days"/></label>
													<html:text property="durationHours" value="${form.durationHours}" styleId="basicplus_duration_text" maxlength="2" titleKey="catalogadorBasicPlus.Technical.Duration.Hours" /><label for="durationHours"><bean:message key="catalogadorBasicPlus.Technical.Duration.Hours"/></label>
													<html:text property="durationMinutes" value="${form.durationMinutes}" styleId="basicplus_duration_text" maxlength="2" titleKey="catalogadorBasicPlus.Technical.Duration.Minutes" /><label for="durationMinutes"><bean:message key="catalogadorBasicPlus.Technical.Duration.Minutes"/></label>
													<html:text property="durationSeconds" value="${form.durationSeconds}" styleId="basicplus_duration_text" maxlength="2" titleKey="catalogadorBasicPlus.Technical.Duration.Seconds" /><label for="durationSeconds"><bean:message key="catalogadorBasicPlus.Technical.Duration.Seconds"/></label>
												</div>
											</div>
										</div>
										<div class="linea_separadora">
										</div><br class="oculto"/>
									</div>


									<!-- Resource Type -->
									<div class="fila_de_tabla">
										<div class="contenedor_izquierda">
											<div class="text"><label for="tipoRecurso"><bean:message key="catalogadorBasicPlus.TipoRecurso"/></label>
											</div>
										</div>
										<div class="contenedor_derecha">
											<div class="text">											
											    <c:choose>
				                                <c:when test="${!empty form.tipoRecursoBackingList}">	
                                  					<html:select name="form" property="tipoRecurso" titleKey="catalogadorBasicPlus.SeleccioneTipoRecurso">
                                  						<c:set var="colorblanco" value="true"/>
                                  					    <c:set var="long" value="${fn:length(form.tipoRecursoLabelList)}"/>
                                  						<fmt:formatNumber var="longTipoRecursoList" value="${long - 1 }" type="number"/>
                                  						<c:forEach  items="${form.tipoRecursoBackingList}" var="listaTipoRecurso" begin ="0" end="${longTipoRecursoList}">
                                  							<c:choose>
                                  							<c:when test="${colorblanco}">   
                                  								<html:option value="${listaTipoRecurso.value }">${listaTipoRecurso.label}</html:option>
                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
                                  							</c:when>
                                  							<c:otherwise>
                                  								<html:option value="${listaTipoRecurso.value }" styleClass="oscura">${listaTipoRecurso.label}</html:option>
                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
                                  							</c:otherwise>
                                  							</c:choose>	
                                  						</c:forEach>
                                  					</html:select>
                               					</c:when>
                               					<c:otherwise>
                                   					<html:select name="form" property="tipoRecurso" />
                               					</c:otherwise>
                           						</c:choose>						 	
											</div>
										</div>
										<div class="linea_separadora">
										</div><br class="oculto"/>
									</div>

									<!-- Intended End User Role -->
									<div class="fila_de_tabla">
										<div class="contenedor_izquierda">
											<div class="text"><label for="intendedEndUserRole"><bean:message key="catalogadorBasicPlus.IntendedEndUserRole"/></label>
											</div>
										</div>
										<div class="contenedor_derecha">
											<div class="text">											
											    <c:choose>
				                                <c:when test="${!empty form.intendedEndUserRoleBackingList}">	
                                  					<html:select name="form" property="intendedEndUserRole" titleKey="catalogadorBasicPlus.IntendedEndUserRole">
                                  						<c:set var="colorblanco" value="true"/>
                                  					    <c:set var="long" value="${fn:length(form.intendedEndUserRoleLabelList)}"/>
                                  						<fmt:formatNumber var="longIntendedEndUserRoleList" value="${long - 1 }" type="number"/>
                                  						<c:forEach  items="${form.intendedEndUserRoleBackingList}" var="listaIntendedEndUserRole" begin ="0" end="${longIntendedEndUserRoleList}">
                                  							<c:choose>
                                  							<c:when test="${colorblanco}">   
                                  								<html:option value="${listaIntendedEndUserRole.value }">${listaIntendedEndUserRole.label}</html:option>
                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
                                  							</c:when>
                                  							<c:otherwise>
                                  								<html:option value="${listaIntendedEndUserRole.value }" styleClass="oscura">${listaIntendedEndUserRole.label}</html:option>
                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
                                  							</c:otherwise>
                                  							</c:choose>	
                                  						</c:forEach>
                                  					</html:select>
                               					</c:when>
                               					<c:otherwise>
                                   					<html:select name="form" property="intendedEndUserRole" />
                               					</c:otherwise>
                           						</c:choose>						 	
											</div>
										</div>
										<div class="linea_separadora">
										</div><br class="oculto"/>
									</div>


									<!-- Typical learning time -->
									<div class="fila_de_tabla">
										<div class="contenedor_izquierda">
											<div class="text"><label for="typicalLearningTime"><bean:message key="catalogadorBasicPlus.TypicalLearningTime"/></label>
											</div>
										</div>
										<div class="contenedor_derecha">
											<div class="text">											
											    <c:choose>
				                                <c:when test="${!empty form.typicalLearningTimeFullBackingList}">	
                                  					<html:select name="form" property="typicalLearningTimeFull" titleKey="catalogadorBasicPlus.TypicalLearningTime">
                                  						<c:set var="colorblanco" value="true"/>
                                  					    <c:set var="long" value="${fn:length(form.typicalLearningTimeFullLabelList)}"/>
                                  						<fmt:formatNumber var="longTypicalLearningTimeFullList" value="${long - 1 }" type="number"/>
                                  						<c:forEach  items="${form.typicalLearningTimeFullBackingList}" var="listaTypicalLearningTimeFull" begin ="0" end="${longTypicalLearningTimeFullList}">
                                  							<c:choose>
                                  							<c:when test="${colorblanco}">   
                                  								<html:option value="${listaTypicalLearningTimeFull.value }">${listaTypicalLearningTimeFull.label}</html:option>
                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
                                  							</c:when>
                                  							<c:otherwise>
                                  								<html:option value="${listaTypicalLearningTimeFull.value }" styleClass="oscura">${listaTypicalLearningTimeFull.label}</html:option>
                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
                                  							</c:otherwise>
                                  							</c:choose>	
                                  						</c:forEach>
                                  					</html:select>
                               					</c:when>
                               					<c:otherwise>
                                   					<html:select name="form" property="typicalLearningTimeFull" />
                               					</c:otherwise>
                           						</c:choose>						 	
											</div>
										</div>
										<div class="linea_separadora">
										</div><br class="oculto"/>
									</div>


									<!-- Outline section -->
									<div class="basicplus_outline">
									
										<div class="basicplus_outline_text">Relation</div>

										<!-- Relation Kind -->
										<div class="fila_de_tabla">
											<div class="contenedor_izquierda">
												<div class="text"><label for="relationKind"><bean:message key="catalogadorBasicPlus.RelationKind"/></label>
												</div>
											</div>
											<div class="contenedor_derecha">
												<div class="text">											
												    <c:choose>
					                                <c:when test="${!empty form.relationKindBackingList}">	
	                                  					<html:select name="form" property="relationKind" titleKey="catalogadorBasicPlus.RelationKind">
	                                  						<c:set var="colorblanco" value="true"/>
	                                  					    <c:set var="long" value="${fn:length(form.relationKindLabelList)}"/>
	                                  						<fmt:formatNumber var="longRelationKindList" value="${long - 1 }" type="number"/>
	                                  						<c:forEach  items="${form.relationKindBackingList}" var="listaRelationKind" begin ="0" end="${longRelationKindList}">
	                                  							<c:choose>
	                                  							<c:when test="${colorblanco}">   
	                                  								<html:option value="${listaRelationKind.value }">${listaRelationKind.label}</html:option>
	                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
	                                  							</c:when>
	                                  							<c:otherwise>
	                                  								<html:option value="${listaRelationKind.value }" styleClass="oscura">${listaRelationKind.label}</html:option>
	                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
	                                  							</c:otherwise>
	                                  							</c:choose>	
	                                  						</c:forEach>
	                                  					</html:select>
	                               					</c:when>
	                               					<c:otherwise>
	                                   					<html:select name="form" property="relationKind" />
	                               					</c:otherwise>
	                           						</c:choose>						 	
												</div>
											</div>
											<div class="linea_separadora">
											</div><br class="oculto"/>
										</div>
	
										<!-- Relation Kind entry -->
										<div class="fila_de_tabla">
											<div class="contenedor_izquierda">
												<div class="text"><label for="relationKindEntry"><bean:message key="catalogadorBasicPlus.RelationKindEntry"/></label>
												</div>
											</div>
											<div class="contenedor_derecha">
												<div class="text">												
													
													<html:text property="relationKindEntry" value="${form.relationKindEntry}" styleId="Titulo" maxlength="125" titleKey="catalogadorBasicPlus.RelationKindEntry" />
													
												</div>
											</div>
											<div class="linea_separadora">
											</div><br class="oculto"/>
										</div>
	
										<!-- Relation Kind description -->
										<div class="fila_de_tabla">
											<div class="contenedor_izquierda">
												<div class="text"><label for="relationKindDescription"><bean:message key="catalogadorBasicPlus.RelationKindDescription"/></label>
												</div>
											</div>
											<div class="contenedor_derecha">
												<div class="text">												
													
													<html:text property="relationKindDescription" value="${form.relationKindDescription}" styleId="Titulo" maxlength="125" titleKey="catalogadorBasicPlus.RelationKindDescription" />
													
												</div>
											</div>
											<div class="linea_separadora">
											</div><br class="oculto"/>
										</div>

									</div>
									<!-- End of outline -->

                                    <!-- Notes -->
									<div class="fila_de_tabla">
										<div class="contenedor_izquierda">
											<div class="text"><label for="Notes"><bean:message key="catalogadorBasicPlus.Notes"/></label>
											</div>
										</div>
										<div class="contenedor_derecha">
											<div class="text">
												<textarea name="notes" style="maxlength: 150; font-style: normal; font-size: 120%;" 
												 rows="10" cols="40" class="ta_minimo_ancho"  id="Notes" title="<bean:message key="catalogadorBasicPlus.IntroduzcaNotes"/>">${form.notes}</textarea>
											</div>
										</div>
										<div class="linea_separadora">
										</div><br class="oculto"/>
									</div>
                                    <!-- End of Notes -->

									<!-- MCA: destination language not required at current time
									<div class="fila_de_tabla">
										<div class="contenedor_izquierda">
											<div class="text"><label for="idiomaDestinatario"><bean:message key="catalogadorBasicPlus.IdiomaDestinatario"/></label>
											</div>
										</div>
										<div class="contenedor_derecha">
											<div class="text">											                      
											    <c:choose>
				                                <c:when test="${!empty form.dummyBackingList}">	
                                  					<html:select name="form" property="dummy" titleKey="catalogadorBasicPlus.SeleccioneIdiomaDestinatario">
                                  						<c:set var="colorblanco" value="true"/>
                                  					    <c:set var="long" value="${fn:length(form.idiomaDestinatarioLabelList)}"/>
                                  						<fmt:formatNumber var="longIdiomaDestinatario" value="${long - 1 }" type="number"/>
                                  						<c:forEach  items="${form.dummyBackingList}" var="listaIdiomaDestinatario" begin ="0" end="${longIdiomaDestinatario}">
                                  							<c:choose>
                                  							<c:when test="${colorblanco}">   
                                  								<html:option value="${listaIdiomaDestinatario.value }">${listaIdiomaDestinatario.label}</html:option>
                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
                                  							</c:when>
                                  							<c:otherwise>
                                  								<html:option value="${listaIdiomaDestinatario.value }" styleClass="oscura">${listaIdiomaDestinatario.label}</html:option>
                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
                                  							</c:otherwise>
                                  							</c:choose>	
                                  						</c:forEach>
                                  					</html:select>
                               					</c:when>
                               					<c:otherwise>
					                                   <html:select name="form" property="dummy" styleId="taxonomiasIdiomaDestinatario"/>
					                               </c:otherwise>
                           						</c:choose>						 	
											</div>
										</div>
										<div class="linea_separadora">
										</div><br class="oculto"/>
									</div>	
									-->



								</div>	<!--  FIN CAJA DE FORMULARIO   -->
							</div>
						</div>
					</div>
				</div>	<!--  FIN GLOBO GRIS   -->
	<!--  FIN GLOBO GRIS   -->
<p class="parrafo_comun" id="separacion3"><bean:message key="catalogadorBasicPlus.frase"/></p>













<!-- Curriculum Tree information -->

<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->

				<div id="formulario_02" >
			<!--  INICIO CAPA TABLA PORTAPAPELES   -->
			<!--  INICIO CAPA TABLA PORTAPAPELES   -->						
 					<div class="caja_tabla bordeada" ><display:table name="${form.curriculumTrees}" id="asociacion" 
							style="border:1;width:100%" class="generica_02" cellpadding="0" 
							cellspacing="0" 
							summary="${summary}" requestURI="${pageContext.request.requestURL}">
				
							<display:caption><strong> <bean:message key="catalogadorBasicPlus.tablaAsociacionSummary"/></strong></display:caption>
							<display:setProperty name="css.tr.even" value="tr_gris"/>
        					<display:setProperty name="css.tr.odd" value="tr_blanco"/>
		    				<display:setProperty name="basic.show.header" value="false"/>
		    
		    				<c:if test="${!empty asociacion.taxones }">
		   	 					<c:set var="longitud" value="${ fn:length(asociacion.taxones)}"/>
		        				<c:set var="rutaAsociada" value=""/>
		        				<c:forEach items="${asociacion.taxones }" var="ruta" begin="0" end="0">
		    						<em class="oculto">-</em>
		    						<c:set var="rutaAsociada" value="${ruta.valorTax }"/>
		  						</c:forEach>
		        				<c:if test="${longitud>1 }">
			   						<c:forEach items="${asociacion.taxones }" var="ruta" begin="1" end="${longitud }">
			    						<em class="oculto">-</em>
			    						<c:set var="rutaAsociada" value="${ruta.valorTax }/${rutaAsociada }"/>
			  						</c:forEach>
			  					</c:if>
		 					</c:if>
		 					<display:column>        	
								<input type="checkbox" name="idArbol" id="asociacion${asociacion.idArbol}" value="${asociacion.idArbol}"/>	
		    				</display:column>
		    				<display:column style="valign:top" class="td_larga" >
		    					${rutaAsociada}

							</display:column>
						</display:table>
					</div>
					
					<fieldset class="tipo acentrado">
						<div class="asociareliminar" style="width:auto">
						<c:choose>
							<c:when test="${!empty form.curriculumTrees}">
								<input class="boton_125_de_2"  style="height:2em" type="submit"  name="accionSubmit"  value="<bean:message key="catalogadorBasicPlus.Eliminar"/>" />
								<input class="boton_125_de_2_izq" style="height:2em" type="submit"  name="accionSubmit"  value="<bean:message key="catalogadorBasicPlus.ArbolCurricular"/>" />
	             			</c:when> 
	             			<c:otherwise>
								<input class="boton_125_de_2_izq" style="height:2em" type="submit"  name="accionSubmit"  value="<bean:message key="catalogadorBasicPlus.ArbolCurricular"/>" />
	             			</c:otherwise>
						</c:choose>
						</div>
					</fieldset>
					<br class="limpiar" />
			<!--  FIN CAPA TABLA PORTAPAPELES   -->
			<!--  FIN CAPA TABLA PORTAPAPELES   -->	
				</div>
				<!--  FIN CAJA DE FORMULARIO   -->




































			</div>
		</div>

	</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->

<!-- Inicio Botones  -->

<fieldset class="tipo ft_centrada">
      <input class="boton_125_de_2" type="submit" name="accionSubmit" value="<bean:message key="catalogadorBasicPlus.Aceptar"/>" />
       <input class="boton_125_de_2_izq"  type="submit" name="accionSubmit" value="<bean:message key="catalogadorBasicPlus.Cancelar"/>" />
      <input class="boton_125"  type="submit" name="accionSubmit" value="<bean:message key="catalogadorBasicPlus.Validar"/>" />

</fieldset>

<!-- Fin Botones  -->

























<%--									<!-- Outline section -->
									<div class="basicplus_outline">
									
										<div class="basicplus_outline_text">Technical Requirement</div>
--%>									
<%-- // --%>

										<!-- Technical Requirement OrComposite type -->
										<div class="fila_de_tabla" style="visibility:hidden;height:1px">

											<div class="contenedor_izquierda">
												<div class="text">
												 <label for="TechnicalOrCompositeType"><bean:message key="catalogadorBasicPlus.TechnicalOrCompositeType"/></label>
												</div>
											</div>

											<div class="contenedor_derecha">
												<div class="text">											
												                              
												    <c:choose>
					                                <c:when test="${!empty form.technicalOrCompositeTypeBackingList}">	
	                                  					<html:select name="form" property="technicalOrCompositeType" titleKey="catalogadorBasicPlus.TechnicalOrCompositeType" >
	                                  						<c:set var="colorblanco" value="true"/>
	                                  					    <c:set var="long" value="${fn:length(form.technicalOrCompositeTypeLabelList)}"/>
	                                  						<fmt:formatNumber var="longTechnicalOrCompositeTypeList" value="${long - 1 }" type="number"/>
	                                  						<c:forEach  items="${form.technicalOrCompositeTypeBackingList}" var="technicalOrCompositeTypeList" begin ="0" end="${longTechnicalOrCompositeTypeList}">
	                                  							<c:choose>
	                                  							<c:when test="${colorblanco}">   
	                                  								<html:option value="${technicalOrCompositeTypeList.value }">${technicalOrCompositeTypeList.label }</html:option>
	                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
	                                  							</c:when>
	                                  							<c:otherwise>
	                                  								<html:option value="${technicalOrCompositeTypeList.value }" styleClass="oscura">${technicalOrCompositeTypeList.label }</html:option>
	                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
	                                  							</c:otherwise>
	                                  							</c:choose>	
	                                  						</c:forEach>
	                                  					</html:select>
	                               					</c:when>
	                               					<c:otherwise> 
	                                   					<html:select name="form" property="technicalOrCompositeTypeBackingList"  />
	                               					</c:otherwise>
	                           						</c:choose>						 	
												</div>
											</div>
											<div class="linea_separadora">
											</div><br class="oculto"/>
										</div>	
	
										<!-- Technical Requirement OrComposite name -->
										<div class="fila_de_tabla" style="visibility:hidden;height:1px">
											<div class="contenedor_izquierda">
												<div class="text">
												 <label for="TechnicalOrCompositeName"><bean:message key="catalogadorBasicPlus.TechnicalOrCompositeName"/></label>
												</div>
											</div>
											<div class="contenedor_derecha">
												<div class="text">											
												                              
												    <c:choose>
					                                <c:when test="${!empty form.technicalOrCompositeNameBackingList}">	
	                                  					<html:select name="form" property="technicalOrCompositeName" titleKey="catalogadorBasicPlus.TechnicalOrCompositeName" >
	                                  						<c:set var="colorblanco" value="true"/>
	                                  					    <c:set var="long" value="${fn:length(form.technicalOrCompositeNameLabelList)}"/>
	                                  						<fmt:formatNumber var="longTechnicalOrCompositeNameList" value="${long - 1 }" type="number"/>
	                                  						<c:forEach  items="${form.technicalOrCompositeNameBackingList}" var="technicalOrCompositeNameList" begin ="0" end="${longTechnicalOrCompositeNameList}">
	                                  							<c:choose>
	                                  							<c:when test="${colorblanco}">   
	                                  								<html:option value="${technicalOrCompositeNameList.value }">${technicalOrCompositeNameList.label }</html:option>
	                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
	                                  							</c:when>
	                                  							<c:otherwise>
	                                  								<html:option value="${technicalOrCompositeNameList.value }" styleClass="oscura">${technicalOrCompositeNameList.label }</html:option>
	                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
	                                  							</c:otherwise>
	                                  							</c:choose>	
	                                  						</c:forEach>
	                                  					</html:select>
	                               					</c:when>
	                               					<c:otherwise>
	                                   					<html:select name="form" property="technicalOrCompositeNameBackingList" />
	                               					</c:otherwise>
	                           						</c:choose>						 	
												</div>
											</div>
											<div class="linea_separadora">
											</div><br class="oculto"/>
										</div>
										
										<!-- Technical Installation Notes -->
										<div class="fila_de_tabla" style="visibility:hidden;height:1px">
											<div class="contenedor_izquierda">
												<div class="text"><label for="installationNotes"><bean:message key="catalogadorBasicPlus.InstallationNotes"/></label>
												</div>
											</div>
											<div class="contenedor_derecha">
												<div class="text">																								
													<html:text property="installationNotes" value="${form.installationNotes}" styleId="Titulo" maxlength="125" titleKey="catalogadorBasicPlus.InstallationNotes" />												
												</div>
											</div>
											<div class="linea_separadora">
											</div><br class="oculto"/>
										</div>
										
										<!-- Technical Platform Requirements -->
										<div class="fila_de_tabla" style="visibility:hidden;height:1px">
											<div class="contenedor_izquierda">
												<div class="text"><label for="platformRequirements"><bean:message key="catalogadorBasicPlus.PlatformRequirements"/></label>
												</div>
											</div>
											<div class="contenedor_derecha">
												<div class="text">																								
													<html:text property="platformRequirements" value="${form.platformRequirements}" styleId="Titulo" maxlength="125" titleKey="catalogadorBasicPlus.PlatformRequirements" />												
												</div>
											</div>
											<div class="linea_separadora">
											</div><br class="oculto"/>
										</div>

<%--
									</div>
									<!-- End of outline -->
--%>








			</form>
		</div>	<!-- Fin plantilla contenido  -->
	<!-- Fin plantilla contenido  -->
	
	
</tiles:put>

</tiles:insert>
