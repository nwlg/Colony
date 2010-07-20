    //Parseador propio de Ibuilder que soporta valores vacios en los SELECT
    ResponseXmlParserIbuilder = Class.create();
	ResponseXmlParserIbuilder.prototype = Object.extend(new AbstractResponseParser(), {
		  initialize: function() {
		  this.type = "xml";
	  },

	  load: function(request) {
    	this.content = request.responseXML;
	    this.parse();
	  },

	  parse: function() {
	    var root = this.content.documentElement;
	    var responseNodes = root.getElementsByTagName("response");
	    this.itemList = new Array();
	    if (responseNodes.length > 0) {
	      var responseNode = responseNodes[0];
	      var itemNodes = responseNode.getElementsByTagName("item");
	      for (var i=0; i<itemNodes.length; i++) {
	        var nameNodes = itemNodes[i].getElementsByTagName("name");
	        var valueNodes = itemNodes[i].getElementsByTagName("value");
	        if (nameNodes.length > 0 && valueNodes.length > 0) {
	          var name="";
	          var value="";	
	          if (nameNodes[0].firstChild!=null){
	          	name = nameNodes[0].firstChild.nodeValue;
	          }
	          else name="";	
	          if (valueNodes[0].firstChild!=null){	
	          	value = valueNodes[0].firstChild.nodeValue;
	          }
	          else value="";
	          this.itemList.push(new Array(name, value));
	        }
    	  }
	    }
	  }
	});
	

//RLA 20060919
    /**Esta funcion permite mostrar una ventana de confirmacion.
     * 
     */
    function pantallaConfirmacion(functionCallback,mensaje,EtiquetaBotonConfirm,EtiquetaBotonCancel,Titulo){	 
	      var url=contextPath+'/layout/confirm.jsp?';
		  var param;
		  if (mensaje!=null) {
		  	param = 'message=' + mensaje;
		  }
		  if (EtiquetaBotonConfirm!=null) {
		  	if (param == null) {
				param = 'botonConfirm=' + EtiquetaBotonConfirm;
			} else{
				param = param + '&botonConfirm=' + EtiquetaBotonConfirm;
			}
		  }
		  if (EtiquetaBotonCancel!=null) {
			if (param == null) {
				param = 'botonCancel=' + EtiquetaBotonCancel;
			} else{
			  	param = param + '&botonCancel=' + EtiquetaBotonCancel;			
			}
		  }
		  if (Titulo!=null) {
		  	if (param == null) {
				param = 'titulo=' + Titulo;
			} else{
			  	param = param + '&titulo=' + Titulo;			
			}
		  }	
  
		  showPopWin(url + param, 300, 110, functionCallback);
    }
//FIN RLA 20060919