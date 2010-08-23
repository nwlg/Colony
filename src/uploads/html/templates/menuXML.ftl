<#ftl ns_prefixes={"D":"http://www.imsglobal.org/xsd/imscp_v1p1",
					"xml":"http://www.w3.org/XML/1998/namespace"}>
<#-- inicio el contador para definir el id de los div del menu -->
<#assign i = -1>
<#-- inicializar la pagina inicial.. lo que se vera al inicio en la pagina del contenido -->
<#assign inicioHref='contenido_index.html'>
<#-- inicializar el indice que sera marcado al mostrar por primera vez la pagina -->
<#assign primerSeleccion='-1'>

<#-- llamo al primer nodo del xml .. el nodo manifest -->
<#recurse doc>



<#-- template que se ejecuta cuando se analiza el elemento manifest del xml -->
<#macro manifest>
<?xml version="1.0" encoding="iso-8859-1" ?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">

<head lang="es" dir="ltr">

<title>${redes}</title>
<link rel="stylesheet" media="screen" href="static/css/red.css" type="text/css" />
<script type="text/javascript" src="static/js/menu.js"></script>
<body class="fondo_menu_frame"  onload=invarGlob();>
<div id="menu_frame">
<#-- listar los nodos hijos del manifest -->
	<#list .node.organizations.organization as org >
		<#-- por cada hijo llamo a la funcion arbol -->
		<@arbol id="${org.@identifier}" nivel= 1 xmlbase=""/>
	</#list>
</div>

<#-- form que define las variables que se utilizaran para acceder desde los otros frames -->
<form name=f1>
<#-- variable: indica el indice seleccionado actualmente..   -->
	<input type=hidden value="${primerSeleccion}" name=variable>
<#-- maximo: indica la cantidad total de elementos en el menu.. para controlar que no se pueda
 acceder mas alla del maximo permitido -->	
	<input type=hidden value="${i}" name=maximo>
</form>

</body>
</html>	

<script type="text/javascript" language="JavaScript">
<!--
function invarGlob()
{
	vActual=document.f1.variable;
	vMaximo=document.f1.maximo;
	document.getElementById(${primerSeleccion}).className = 'escogido';
	parent.contenido_principal.location='${inicioHref}';
}

function cambiar(id)
{
	if(id!=vActual.value)
	{
		document.getElementById(vActual.value).className = '';
		document.getElementById(id).className = 'escogido';
		vActual.value=id;

		var href= document.getElementById(vActual.value).href;
		var largo=href.length;
		var ultimo =href.charAt(largo-1);
		
		if(ultimo!='#')
		{
			parent.contenido_principal.location=href;
		}else
		{
			parent.contenido_principal.location='blanco.html';
		}
	}
} 
//-->
</script>


</#macro>
<#-- fin de la macro que responde al elemento manifest -->



<#-- macro recursiva que permite dibujar el arbol del menu -->
<#macro arbol id nivel xmlbase >
 	
	<#-- localizo el nodo con el id que me llega de parametro -->
	<#list doc["//*[@identifier='${id}']"] as f>
		<#-- si el nodo es un elemento y un item analizo posibilidades -->
		<#if (f?node_type = 'element' && f?node_name = 'item')>

			<#-- verifico si el item tiene un recurso asociado -->
			<#if f.@identifierref[0]?? >
			<#assign i = i+1>
				<#-- listo los recursos que tengan como identifier el valor del parametro identifierref del item actual -->
				<#list doc["//*[@identifier='${f.@identifierref}']"] as n>
					<#-- controlo que el nodo sea un recurso -->
					<#if (n?node_type= 'element') && ( n?node_name = 'resource')>
						<#-- construyo el href agregandole el parametro xmlbase si viniera -->
						<#if xmlbase="">
							<#assign href="${n.@href}">
						<#else>
							<#assign href="${xmlbase}/${n.@href}">
						</#if>
						<#-- si es el primer recurso que encuentro.. redefino las variables primerSeleccion e inicioHref -->
						<#if primerSeleccion='-1'>
							<#assign primerSeleccion="${i}">
							<#assign inicioHref="${href}">
						</#if>
						<#-- dibujo el elemento del menu con el href correspondiente -->
						<ul>
							<li class="item"><span>&nbsp;<a id="${i}" onclick="cambiar('${i}')" href="${href}" target="contenido_principal">${f.title}</a> </span></li>
						</ul>
						<#-- llamo nuevamente a la macro arbol con los parametros correspondientes -->
						<@arbol id="${n.@identifier}" nivel= (nivel+1) xmlbase="${xmlbase}"/>
					<#else>
					<#-- el elemento es un item con una referencia a otro item -->		
					<#-- dibujo el elemento del arbol sin href y llamo otra vez a la macro recursiva arbol -->
							<ul>
								<li id="${id}" class="nivel0${nivel}_grupo_abierto">
								<span  onclick="P7_swapClass(1,'${id}','nivel0${nivel}_grupo_abierto','nivel0${nivel}_grupo_cerrado','li');return false" onkeypress="P7_swapClass(1,'${id}','nivel0${nivel}_grupo_abierto','nivel0${nivel}_grupo_cerrado','li');return false">&nbsp;</span>
								<a  id="${i}"  onclick="cambiar('${i}')"  href="#">${f.title}</a>
									<@arbol id="${n.@identifier}" nivel= (nivel+1) xmlbase="${xmlbase}"/>
								</li>
							</ul>
						
					</#if>
				</#list>
			<#else>
			<#-- el item no tiene recurso asociado.. solo items hijos.. recorro los items hijos que podria tener.. -->
				<#list f.item as itemHijo>
				<#assign i = i+1>
					<ul>
						<li id="${id}" class="nivel0${nivel}_grupo_abierto">
						<span  onclick="P7_swapClass(1,'${id}','nivel0${nivel}_grupo_abierto','nivel0${nivel}_grupo_cerrado','li');return false" onkeypress="P7_swapClass(1,'${id}','nivel0${nivel}_grupo_abierto','nivel0${nivel}_grupo_cerrado','li');return false">&nbsp;</span>
						<a  id="${i}"  onclick="cambiar('${i}')"  href="#">${f.title}</a>
							<@arbol id="${itemHijo.@identifier}" nivel= (nivel+1) xmlbase="${xmlbase}"/>
						</li>
					</ul>
				
				</#list>
			
				
			</#if>
			
			
		</#if>
		
		<#-- el elemento es una organizacion -->
		<#if (f?node_type = 'element' && f?node_name = 'organization')>
		<#assign i = i+1>
			<#-- dibujo el elemento del menu y hago la llamada a la macro recursiva por cada hijo de la organizacion -->
			<li id="${id}" class="nivel0${nivel}_organizacion_abierto" >
				<span onclick="P7_swapClass(1,'${id}','nivel0${nivel}_grupo_abierto','nivel0${nivel}_grupo_cerrado','li');return false" onkeypress="P7_swapClass(1,'${id}','nivel0${nivel}_grupo_abierto','nivel0${nivel}_grupo_cerrado','li');return false">&nbsp;</span>
				<a  id="${i}"  onclick="cambiar('${i}')"  href="#"> ${f.title} </a>
				<#list f.item as item>
					<@arbol id="${item.@identifier}" nivel= (nivel+1) xmlbase="${xmlbase}"/>
				</#list>
				
			</li>
		</#if>

		<#-- el elemento es un submanifiesto -->
		<#if (f?node_type = 'element' && f?node_name = 'manifest')>
		<#assign i = i+1>
			<#-- asigno xmlbase para la proxima llamada recursiva -->			
			<#assign base =  xmlbase+ f["@xml:base"] >
			<#-- proceso los hijos del manifest -->
			<#list f.organizations.organization as n>
				<#-- dibujo el menu y sus hijos -->
				<ul>
					<li id="${id}" class="nivel0${nivel}_grupo_abierto">
						<span  onclick="P7_swapClass(1,'${id}','nivel0${nivel}_grupo_abierto','nivel0${nivel}_grupo_cerrado','li');return false" onkeypress="P7_swapClass(1,'${id}','nivel0${nivel}_grupo_abierto','nivel0${nivel}_grupo_cerrado','li');return false">&nbsp;</span>
						<a  id="${i}" onclick="cambiar('${i}')"  href="#">${n.title}</a>
							<#list n.item as item>
								<@arbol id="${item.@identifier}" nivel= (nivel+1) xmlbase="${base}"/>
							</#list>
					</li>
				</ul>
			</#list>
		</#if>
	</#list>
</#macro>
<#-- din de la macro recursiva arbol -->


