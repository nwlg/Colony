/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.visualizador.presentacion.conexionFlash;

import java.io.OutputStream;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.buscar.negocio.buscar.servicios.ParametrosBusquedaAvanzadaVO;
import es.pode.buscar.negocio.buscar.servicios.ResultadoBusquedaVO;
import es.pode.buscar.negocio.buscar.servicios.ValoresBusquedaVO;
import es.pode.visualizador.presentacion.agregaSlider.AgregaSliderControllerImpl;



/**
 * @see es.pode.visualizador.presentacion.conexionFlash.conexionFlashController
 */
public class conexionFlashControllerImpl extends conexionFlashController
{


	private static Logger log = Logger.getLogger(AgregaSliderControllerImpl.class);
	ResourceBundle ficheroRecursos = null;
 
    /**
     * @see es.pode.visualizador.presentacion.conexionFlash.conexionFlashController#construirXML(org.apache.struts.action.ActionMapping, es.pode.visualizador.presentacion.conexionFlash.ConstruirXMLForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void construirXML(ActionMapping mapping, es.pode.visualizador.presentacion.conexionFlash.ConstruirXMLForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	//Recogemos de la request las palabras con la que hacemos la busqueda y el idioma
    	String palabras = request.getParameter("palabras");
    	String idioma = request.getParameter("idioma");
    	
    	//construimos un locale con el idioma que nos viene como paramatro
    	Locale locale = new Locale(idioma);
    	
    	//recogemos la url por defecto de soporte
    	String urlImagenDefecto = AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.URL_IMAGEN_DEFECTO_GRANDE);
    	String urlLogoAgrega = AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.URL_LOGO_AGREGA);
    	
    	//declaramos ficheroRecursos para poder acceder al fichero de las etiquetas y recoger la url de la ficha
    	ficheroRecursos = ResourceBundle.getBundle("application-resources", locale);
    	String urlFicha = ficheroRecursos.getString("agregaSlider.url.ficha");
    	
		//recogemos el nodo correspodiente desde soporte
		String nodo = AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.HOST);
    	
    	//declaramos los VOs de recogida y envio para la llamada al buscar
    	ParametrosBusquedaAvanzadaVO parametros = new ParametrosBusquedaAvanzadaVO();
    	ResultadoBusquedaVO resultado = new ResultadoBusquedaVO();
    	ValoresBusquedaVO[] valoresBusqueda;
    	
    	
    	//rellenamos el VO que tenemos que pasarle al buscar para realizar la busqueda de imagenes
    	log("Rellenamos el VO para pasarlo al buscar");
    	parametros.setPalabrasClave(palabras);
    	parametros.setIdiomaBusqueda(idioma);
    	parametros.setIdiomaNavegacion(idioma);
    	parametros.setBusquedaSimpleAvanzada("Busqueda AgregaSlider");
    	parametros.setNumeroResultados(new Integer(20));
    	parametros.setOrigenPagina(new Integer(1));
    	parametros.setResultadosPorPagina(new Integer(20));
    	parametros.setComunidadPeticion(nodo);
    	
    	//rellenamos la primera linea del xml
    	String xml = "<?xml version='1.0' encoding='utf-8'?> <GALERIA>";
    	
    	//rellenamos la primera posicion con los datos de la portada de la aplicacion para asociarla al logo agrega
    	xml += "<IMAGEN " +
		"TITULO='portada' " +
		"URL_FICHA='http://" + nodo + AgregaPropertiesImpl.getInstance().getProperty("admin.ws.subdominio")+ "/visualizadorcontenidos/Portada/Portada.do' " +
		"URL_IMAGEN='http://" + nodo + AgregaPropertiesImpl.getInstance().getProperty("admin.ws.subdominio")+  "/" + urlLogoAgrega + "' />";
    	
    	try
    	{
    		
    		//llamamos al servicio buscar
    		resultado = this.getSrvBuscarService().buscarAvanzado(parametros);
    		valoresBusqueda = resultado.getResultadoBusqueda();
    		log("valores de  busqueda : " + valoresBusqueda.length);
        	
        	
        	if(valoresBusqueda.length != 0)
        	{
        		
        		//recorremos el array de imagenes para construir la url de la imagen correstamente y si no tuviera asignarle una por defecto
            	String url = new String();
	        	for(int i=0; i<valoresBusqueda.length; i++)
	        	{
	        		if(valoresBusqueda[i].getUrlImagen() == null || valoresBusqueda[i].getUrlImagen().equalsIgnoreCase(""))
	        		{
	        			valoresBusqueda[i].setUrlImagen(urlImagenDefecto);
	        			log("no hay imagen en" + valoresBusqueda[i].getTitulo());
	        			
	        		}
	        		else
	        		{
	        			//Contruimos la url de la imagen
	        			url = valoresBusqueda[i].getUrlImagen();
	        			String urls[] = url.split("\\.");
	        			url = urls[0] + "_captured.jpg";
	        			valoresBusqueda[i].setUrlImagen(url);
	        			
	        			//filtramos para que en el titulo no aparezcan comillas
	        			String cadena = valoresBusqueda[i].getTitulo();
	        			valoresBusqueda[i].setTitulo(StringEscapeUtils.escapeXml(cadena));
	        		}
	        	}
	        	
	        	
	        	//se rellena el xml con los datos devueltos del busca
	    		
	    		log("se han encontrado" + valoresBusqueda.length + "elementos");
	    		for(int i=0; i<valoresBusqueda.length; i++)
	    		{
	    			log("valoresBusqueda[i].getUrlImagen() "+i+":"+valoresBusqueda[i].getUrlImagen());
	    			xml += "<IMAGEN " +
	    			"TITULO='"+ valoresBusqueda[i].getTitulo() + "' " +
	    			"URL_FICHA='http://" + nodo +AgregaPropertiesImpl.getInstance().getProperty("admin.ws.subdominio")+ "/" + urlFicha + "/" + idioma + "/" + valoresBusqueda[i].getId() + "' " +
	    			"URL_IMAGEN='http://" + nodo + AgregaPropertiesImpl.getInstance().getProperty("admin.ws.subdominio")+ "/" + valoresBusqueda[i].getUrlImagen() + "' />";
	    		}
	    		xml += "</GALERIA>";
        	}
        	else
        	{
        		log("No se ha encontrado nada en el buscar y se rellena manualmente");
        		log("urlImagenDefecto "+urlImagenDefecto);
        		//Se rellena el xml con una imagen por defecto porque no se ha encontrado ninguna
        		xml += 
        		"<IMAGEN TITULO='Imagen Agrega' URL_FICHA='#' " +
        		"URL_IMAGEN='http://" + nodo + AgregaPropertiesImpl.getInstance().getProperty("admin.ws.subdominio")+"/" + urlImagenDefecto + "'/>" +
        		"</GALERIA>";
        	}
    		
    	}
    	catch(Exception e)
    	{
    		log.error("exception en concexion flash " + e);
    		//Se rellena el xml con una imagen por defecto porque no se ha encontrado ninguna
    		xml += "<IMAGEN TITULO='Imagen Agrega' URL_FICHA='#' " +
    		"URL_IMAGEN='http://" + nodo + AgregaPropertiesImpl.getInstance().getProperty("admin.ws.subdominio")+ "/" + urlImagenDefecto + "'/>" +
    		"</GALERIA>";
    	}
    	
    	
    	log(xml);
    	//Mandamos el xml a flash como un array de bytes
    	log("Mandamos el xml a flash como un array de bytes");
    	
		response.setContentType("text/xml");
    	
        OutputStream out = (OutputStream)response.getOutputStream();
        out.write(xml.getBytes());

        out.flush();
        out.close();

        log("Se ha mandado a flash el xml");
    }



    private void log(Object obj) 
    {
    	if (log.isDebugEnabled())
    	    log.debug(obj);
    }







}