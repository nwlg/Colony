<%@ include file="/taglib-imports.jspf" %>

<html:html lang="true">

    <head>
        <title>
            <tiles:insert attribute="title" flush="true"/>
        </title>
        <html:base/>
        <meta http-equiv="Content-Type" content="text/html; charset:ISO-8859-1" />
<%-- uncomment this to enable the browser 'favorites' icons
        <link rel="shortcut icon" href="my-custom-image.ico"></link>
        <link rel="icon" type="image/gif" href="my-custom-image.gif"></link>
--%>
    <!-- Estilo generales aplicadas a todas las paginas de la aplicaci¾n  -->
    <link rel="STYLESHEET" type="text/css" media="screen" href="<%=request.getContextPath()%>/layout/default.css" />
    <link rel="STYLESHEET" type="text/css" media="screen" href="<%=request.getContextPath()%>/layout/default-application.css" />
    <link rel="STYLESHEET" type="text/css" media="screen" href="<%=request.getContextPath()%>/layout/default-calendar.css" />  
    <!--  ****************************************************** -->

	<script type="text/javascript" src="<%=request.getContextPath()%>/layout/ibuilder-domain.js"></script>	
	<!--  Variable para poder obtener el contextPath desde funciones js y permitir la interacci¥n entre ventanas de diferentes aplicaciones -->
   	<script type="text/javascript">
           var contextPath="<%=request.getContextPath()%>";
           setAppDomain();
   	</script>         
   	<!-- ************************************************************************************************************************* -->  


	<!-- Librerias de soporte AJAX 1.2 -->
    <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/layout/js-ajax/ajaxtags.css" />
	<script type="text/javascript" src="<%= request.getContextPath()%>/layout/js-common/prototype.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath()%>/layout/js-ajax/scriptaculous.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath()%>/layout/js-ajax/overlibmws.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath()%>/layout/js-ajax/ajaxtags.js"></script>
    <!--  ****************************************************** --> 

	<!-- Libreria generales de IBUILDER. Permiten el manejo de las ventanas, interaccion entre modulos y otros mecanismos de interfaz de usuario -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/layout/ibuilder-common.js"></script>	
    <!--  ****************************************************** -->			
   	<!--  Ficheros que permiten la gestion de ventanas emergentes del tipo Iframe -->        
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/layout/submodal/subModal.css"></link>
	<script type="text/javascript" src="<%= request.getContextPath()%>/layout/submodal/submodal-common.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath()%>/layout/submodal/subModal.js"></script>
	<!-- ************************************************************************* -->          
	
    <!-- Librerias utilizadas por AndroMDA -->   
    <script type="text/javascript" language="Javascript1.1" src="<%= request.getContextPath()%>/layout/layout-common.js"></script>
    <script type="text/javascript" language="Javascript1.1" src="<%= request.getContextPath()%>/layout/key-events.js"></script>
	<!-- ************************************************************************************************************************* -->   
     

<tiles:insert attribute="style" flush="true"/>
<tiles:insert attribute="javascript" flush="true"/>
 
</head>
 
<body>
<tiles:insert attribute="messages" flush="true"/> 


<!-- ESTRUCTURA GENERICA DE TODAS LAS VENTANAS EMERGENTES -->
<div id="lyFondo" class="ifrmCapaFondo" ></div>
   		
          <div id="container">
 
            <div id="content">

 <p><b>
			        <html:img page="/layout/logo_indra.gif" align="center" />
			        <html:base/>
			     </b><br/>
				
				<%--
				<div class="box1">
				
				     <h4>I-builder 1.1</h4>
				
				     <p><b>Ultimas noticias</b><br/>
				     - Incluido cartridge de estimacion de proyectos<br/>
				     - Soporte al servidor de aplicaciones WebSphere 6.0<br/>
				     - Generacion pruebas unitarias para los servicios <br/>
				     - Soporte desarrollo con Eclipse ....<br/>
				     </p>
				     <p><a href="http://portalesddp.indra.es/C16/I-Builder/default.aspx" title="I-Builder homepage">mas &raquo;</a></p>
				     
				</div>
				--%>
				<p class="spacer"></p>
				
				
				<div class="box3">
				    <p>Esta aplicacion web ha sido generada por I-BUILDER 1.1, visite 
				       <a href="http://portalesddp.indra.es/C16/I-Builder/default.aspx" title="Portal I-builder">Portal DDP/I-Builder</a>
				       para obtener mas información.</p>
				</div>

 				<tiles:insert attribute="menu" flush="true"/>            	            
                <tiles:insert attribute="body" flush="true"/>
			</div>
		</div>      					
</body>
</html:html>


