<script type="text/javascript" language="JavaScript">
<!--
function invarGlob()
{
      vActual=document.f1.variable;
      vMaximo=document.f1.maximo;
      document.getElementById(0).className = 'escogido';
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


<?xml version="1.0" encoding="iso-8859-1" ?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">

<head lang="es" dir="ltr">

<title>${redes}</title>
<link rel="stylesheet" media="screen" href="static/css/red.css" type="text/css" />
<script type="text/javascript" src="static/js/menu.js"></script>
</head>

<body class="fondo_menu_frame" onload="invarGlob();">

<div id="menu_frame">


<#assign items = "es.pode.entregar.negocio.utils.menuTemplate.MenuDirective"?new()>  
<@items> </@items>

<br class="oculto" />

</body>
</html>