
function P7_swapClass(){ //v1.4 by PVII
 var i,x,tB,j=0,tA=new Array(),arg=P7_swapClass.arguments;
if(document.getElementsByTagName){for(i=4;i<arg.length;i++){tB=document.getElementsByTagName(arg[i]);
for(x=0;x<tB.length;x++){tA[j]=tB[x];j++;}}for(i=0;i<tA.length;i++){
if(tA[i].className){if(tA[i].id==arg[1]){if(arg[0]==1){
tA[i].className=(tA[i].className==arg[3])?arg[2]:arg[3];}else{tA[i].className=arg[2];}
}else if(arg[0]==1 && arg[1]=='none'){if(tA[i].className==arg[2] || tA[i].className==arg[3]){
tA[i].className=(tA[i].className==arg[3])?arg[2]:arg[3];}
}else if(tA[i].className==arg[2]){tA[i].className=arg[3];}}}}
}

function P7_writeStyles(a){ 
 var tS="<sty"+"le type=\"text/css\">";
 tS+="\n"+a+"\n<"+"/sty"+"le>";document.write(tS);
}
P7_writeStyles('.nivel01_grupo_cerrado ul{display:none;}.nivel01_grupo_abierto ul{display:block;}.nivel01_submanifiesto_cerrado ul{display:none;}.nivel01_submanifiesto_abierto ul{display:block;}.nivel02_grupo_cerrado ul{display:none;}.nivel02_grupo_abierto ul{display:block;}.nivel02_submanifiesto_cerrado ul{display:none;}.nivel02_submanifiesto_abierto ul{display:block;}.nivel03_grupo_cerrado ul{display:none;}.nivel03_grupo_abierto ul{display:block;}.nivel03_submanifiesto_cerrado ul{display:none;}.nivel03_submanifiesto_abierto ul{display:block;}.nivel04_grupo_cerrado ul{display:none;}.nivel04_grupo_abierto ul{display:block;}.nivel04_submanifiesto_cerrado ul{display:none;}.nivel04_submanifiesto_abierto ul{display:block;}.nivel05_grupo_cerrado ul{display:none;}.nivel05_grupo_abierto ul{display:block;}.nivel05_submanifiesto_cerrado ul{display:none;}.nivel05_submanifiesto_abierto ul{display:block;}.nivel06_grupo_cerrado ul{display:none;}.nivel06_grupo_abierto ul{display:block;}.nivel06_submanifiesto_cerrado ul{display:none;}.nivel06_submanifiesto_abierto ul{display:block;}.nivel07_grupo_cerrado ul{display:none;}.nivel07_grupo_abierto ul{display:block;}.nivel07_submanifiesto_cerrado ul{display:none;}.nivel07_submanifiesto_abierto ul{display:block;}.nivel08_grupo_cerrado ul{display:none;}.nivel08_grupo_abierto ul{display:block;}.nivel08_submanifiesto_cerrado ul{display:none;}.nivel08_submanifiesto_abierto ul{display:block;}.nivel09_grupo_cerrado ul{display:none;}.nivel09_grupo_abierto ul{display:block;}.nivel09_submanifiesto_cerrado ul{display:none;}.nivel09_submanifiesto_abierto ul{display:block;}.nivel10_grupo_cerrado ul{display:none;}.nivel10_grupo_abierto ul{display:block;}.nivel10_submanifiesto_cerrado ul{display:none;}.nivel10_submanifiesto_abierto ul{display:block;}');
