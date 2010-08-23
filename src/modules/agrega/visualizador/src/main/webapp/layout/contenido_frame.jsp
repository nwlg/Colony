<?xml version="1.0" encoding="iso-8859-1" ?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<%@ include file="/taglib-imports.jspf" %>
<%@ taglib uri="/WEB-INF/tlds/rewriteTag.tld" prefix="rewrite" %> 

<title><bean:message key="title.Comun"/></title>

<script language="javascript">
//<![CDATA[
        /*
        * SCORM API
        */
        function GenericAPIAdaptor(){
        	this.LMSInitialize = LMSInitializeMethod;
        	this.LMSGetValue = LMSGetValueMethod;
        	this.LMSSetValue = LMSSetValueMethod;
        	this.LMSCommit = LMSCommitMethod;
        	this.LMSFinish = LMSFinishMethod;
        	this.LMSGetLastError = LMSGetLastErrorMethod;
        	this.LMSGetErrorString = LMSGetErrorStringMethod;
        	this.LMSGetDiagnostic = LMSGetDiagnosticMethod;
        }
        
        function GenericAPIAdaptor_2004(){
        	this.Initialize = LMSInitializeMethod;
        	this.Terminate = LMSFinishMethod;	
        	this.GetValue = LMSGetValueMethod;
        	this.SetValue = LMSSetValueMethod;
        	this.Commit = LMSCommitMethod;	
        	this.GetLastError = LMSGetLastErrorMethod;
        	this.GetErrorString = LMSGetErrorStringMethod;
        	this.GetDiagnostic = LMSGetDiagnosticMethod;
        }
        
        /*
        * LMSInitialize.
        */
        function LMSInitializeMethod(parameter){return "true";}
        /*
        * LMSFinish.
        */
        function LMSFinishMethod(parameter){return "true";}
        /*
        * LMSCommit.
        */
        function LMSCommitMethod(parameter){return "true";}
        /*
        * LMSGetValue.
        */
        function LMSGetValueMethod(element){return "";}
        /*
        * LMSSetValue.
        */
        function LMSSetValueMethod(element, value){return "true";}
        /*
        * LMSGetLastErrorString
        */
        function LMSGetErrorStringMethod(errorCode){return "No error";}
        /*
        * LMSGetLastError
        */
        function LMSGetLastErrorMethod(){return "0";}
        /*
        * LMSGetDiagnostic
        */
        function LMSGetDiagnosticMethod(errorCode){return "No error. No errors were encountered. Successful API call.";}
        
        var API = new GenericAPIAdaptor;
       	var API_1484_11 = new GenericAPIAdaptor_2004;
//]]>       	
</script>


<script type="text/javascript">
//<![CDATA[
/***********************************************
* Collapsible Frames script- © Dynamic Drive (www.dynamicdrive.com)
* This notice must stay intact for use
* Visit http://www.dynamicdrive.com/ for full source code
***********************************************/

var columntype=""
var defaultsetting="0"

function getCurrentSetting(){
if (document.body)
return (document.body.cols)? document.body.cols : document.body.rows
}

function setframevalue(coltype, settingvalue){
if (coltype=="rows")
document.body.rows=settingvalue
else if (coltype=="cols")
document.body.cols=settingvalue
}

function resizeFrame(contractsetting){
if (getCurrentSetting()!=defaultsetting)
setframevalue(columntype, defaultsetting)
else
setframevalue(columntype, contractsetting)
}

function init(){
if (!document.all && !document.getElementById) return
if (document.body!=null){
columntype=(document.body.cols)? "cols" : "rows"
defaultsetting=(document.body.cols)? document.body.cols : document.body.rows
}
else
setTimeout("init()",100)
}

setTimeout("init()",100)
//]]>
</script>

	<script type="text/javascript" src="visualizador.js"></script>
	<link type="text/css" rel="stylesheet" media="screen" href="<rewrite:rewrite url='static/css/red.css'/>"/>


</head>
<frameset onload="inicializar();" cols="400,*" class="frame_set" border="0" style="max-width:100% !important;">
		<frame name="menu" title="Menu" src="menu.jsp" frameborder="0" scrolling="auto" marginwidth="0" marginheight="0" class="frame_menu"  />
		<frame title="Contenido_Principal" name="contenido_principal" src="contenido_index.jsp" frameborder="0" scrolling="no" scroll="no" marginwidth="0" marginheight="0" />
</frameset>
<noframes>
<body>
<p>
<bean:message key="visualizar.noframes"/><br />
<br />
<bean:message key="visualizar.frames"/>
<html:link action="metanavegacion.jsp"><bean:message key="visualizar.enlaceCabecera"/></html:link>
<html:link action="menu.jsp"><bean:message key="visualizar.enlaceMenu"/></html:link>
<html:link action="contenido_index.jsp"><bean:message key="visualizar.enlaceContenido"/></html:link>
</p>
</body>
</noframes>

</html>