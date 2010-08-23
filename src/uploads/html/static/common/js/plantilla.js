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
  if (restore) selObj.selectedIndex=0;}

function expandirCaja (i, txt_show, txt_hide) {

if (document.getElementById(i).className=='caja_abierta') {
document.getElementById('p' + i).className = 'caja_cerrada';
document.getElementById('d'+i).innerHTML=txt_show;
document.getElementById(i).className = 'caja_cerrada';
}
 
 else {
document.getElementById('p' + i).className = 'caja_abierta';
document.getElementById('d'+i).innerHTML=txt_hide;
document.getElementById(i).className = 'caja_abierta';
}
}

 
  var capa
  function cambio(idCapa){
  if (document.layers) capa = eval("document." + idCapa);
  if (document.all) capa = eval(idCapa + ".style");
  if (document.getElementById) capa = eval('document.getElementById("' + idCapa + '").style');if ((capa.visibility == "hidden") || (capa.visibility == "hide")){
  capa.visibility = (document.layers) ? "hide" : "hidden" ;
  }else{
  capa.visibility = (document.layers) ? "show" : "visible" ;
  }
  }