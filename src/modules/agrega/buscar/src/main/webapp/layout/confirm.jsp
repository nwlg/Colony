<%@ include file="/taglib-imports.jspf" %>

<HTML>

<HEAD>
	<c:if test="${empty param.titulo}">
		<TITLE><bean:message key="general.confirmacion.titulo"/></TITLE>	
		
	</c:if> 
	<c:if test="${!empty param.titulo}">
		<TITLE><%=request.getParameter("titulo")%></TITLE>	
		
	</c:if> 	
	<script type="text/javascript" src="<%=request.getContextPath()%>/layout/npa-domain.js"></script>
         <link rel="STYLESHEET" type="text/css" media="screen" href="<%=request.getContextPath()%>/layout/default-application.css" />	
</HEAD>



<BODY id="ConfBody">

<!--SCRIPT>
    setDomain();
</SCRIPT-->

<FORM>
		<img src="<%=request.getContextPath()%>/layout/warning.gif" class="Imagen"/>
		
		<c:if test="${empty param.message}">
			<div class="mensajeConf"><bean:message key="general.confirmacion.mensaje"/></div>
		</c:if> 
		<c:if test="${!empty param.message}">	
			<div class="mensajeConf"><%=request.getParameter("message")%></div>		
		</c:if> 
	
	<div id="Acciones">
		<c:if test="${empty param.botonConfirm}">
			<INPUT TYPE="BUTTON" class="aceptar" value="<bean:message key="general.confirmacion.boton_aceptar"/>" name="btnAceptar" onclick="window.parent.hidePopWin(true);" />		
		</c:if> 
		<c:if test="${!empty param.botonConfirm}">	
			<INPUT TYPE="BUTTON" class="aceptar" value="<%=request.getParameter("botonConfirm")%>" name="btnAceptar" onclick="window.parent.hidePopWin(true);" />		
		</c:if> 

		<c:if test="${empty param.botonCancel}">
			<INPUT TYPE="BUTTON" class="cancelar" value="<bean:message key="general.confirmacion.boton_cancelar"/>" name="btnCancelar" onclick="window.parent.hidePopWin();" />
		</c:if> 
		<c:if test="${!empty param.botonCancel}">	
			<INPUT TYPE="BUTTON" class="cancelar" value="<%=request.getParameter("botonCancel")%>" name="btnCancelar" onclick="window.parent.hidePopWin();" />	
		</c:if> 		
		
		
	</div>
</FORM>

</BODY>

</HTML>
