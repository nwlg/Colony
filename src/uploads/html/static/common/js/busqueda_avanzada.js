
function getChildsCount(){
	var count=1;
 	if(trim(document.getElementById("edad").value)!="") count++;
	if(trim(document.getElementById("autor").value)!="") count++;
	if(trim(document.getElementById("diaPublicacion").value)!="" || trim(document.getElementById("mesPublicacion").value)!="" || trim(document.getElementById("anyoPublicacion").value)!="") count++;
	if(trim(document.getElementById("procesoCognitivo").value)!="") count++;
	if(trim(document.getElementById("tipoRecurso").value)!="") count++;
	if(trim(document.getElementById("tipoContexto").value)!="") count++;
	if(trim(document.getElementById("tipoSecuencia").value)!="") count++;
	if(trim(document.getElementById("tipoValoracion").value)!="") count++;
	if(trim(document.getElementById("destinatarios").value)!="") count++;
	return count;
 }
 
   // Trim whitespace from left and right sides of s.
function trim(s) {
	return s.replace( /^\s*/, "" ).replace( /\s*$/, "" );
}

function contarComunidades() 
{

 var checkboxes= document.getElementsByTagName("input");
 var cont = 0; 

for (var x=0; x < checkboxes.length; x++) 
{	
	
	if(checkboxes[x].type=="checkbox")
	{
	   if(checkboxes[x].checked)
	   {
		cont=cont+1;
           }
	}
}
if(cont>0){
	 cont--;
	 if(checkboxes[17].checked) cont--;
}

return cont;
} 
