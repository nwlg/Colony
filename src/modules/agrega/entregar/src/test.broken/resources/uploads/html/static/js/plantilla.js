function limpiarTexto(thefield){
if (thefield.defaultValue==thefield.value)
thefield.value = ""

} 

function icono(){
da_image = new Image();
da_image.src="favicon.ico";
}

function MM_jumpMenu(targ,selObj,restore){ //v3.0
  eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
  if (restore) selObj.selectedIndex=0;
 }
