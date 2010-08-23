/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.visualizador.presentacion.agregaSlider;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.i18n.LocalizacionIdiomaVO;

/**
 * @see es.pode.visualizador.presentacion.agregaSlider.AgregaSliderController
 */
public class AgregaSliderControllerImpl extends AgregaSliderController
{

	private static Logger log = Logger.getLogger(AgregaSliderControllerImpl.class);
	ResourceBundle ficheroRecursos = null;



	/**
	 * Metodo que construye el codigo html que el usuario debe copiar en su web para añadir
	 * la galeria de imagenes
	 * 
	 * @param mapping
	 * @param form Formulario con los datos necesarios
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    public final void construirCodigo(ActionMapping mapping, es.pode.visualizador.presentacion.agregaSlider.ConstruirCodigoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	String keywords = form.getKeywords();
    	String idioma  = form.getIdiomasCombo();
    	
	    	
    	try
    	{
    		if(keywords == null || keywords == "")
    		{
    			//Lanzamos la excepcion porque las keywords estan vacias
    			throw new ValidatorException("{agregaSlider.keywordVacia}");
    		}
    		
    		boolean keywordsOK = comprobarKeywords(keywords);
    		
    		if(keywordsOK)
    		{
    			//Construimos el codigo html embebido
    			String codigo = new String();
    			    			
    			ficheroRecursos = ResourceBundle.getBundle("application-resources", request.getLocale());
    			
    			String controller = ficheroRecursos.getString("agregaSlider.url.controller");
    			String nodo = AgregaPropertiesImpl.getInstance().getProperty("host")+AgregaPropertiesImpl.getInstance().getProperty("admin.ws.subdominio");
    			
    			String url = "http://" + nodo +"/" + ficheroRecursos.getString("agregaSlider.url.sfw");
    			
    			
    			//rellenamos el codigo que le pasamos a la jsp para que el usuario lo recoja
    			
    			codigo ="<object width='400' height='400' classid='clsid:d27cdb6e-ae6d-11cf-96b8-444553540000' " +
    						"codebase='http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,0,0'>" +
    						"<param name='movie' value='" + url + "' />" +
    						"<param name='Flashvars' value='palabras=" + keywords + "&amp;idioma=" + idioma + "&amp;nodo=" + nodo + "&amp;controller=" + controller + "' />" +
    						"<param name='bgcolor' value='#FFFFFF' /> " +
    						"<embed src='"+ url + "' " +
    							"type='application/x-shockwave-flash' " +
    							"Flashvars='palabras=" + keywords + "&amp;idioma=" + idioma + "&amp;nodo=" + nodo + "&amp;controller=" + controller + "' " +
    							"bgcolor='#FFFFFF' " +
    							"pluginspage='http://www.macromedia.com/go/getflashplayer'" +
    							"width='400' " +
    							"height='400'>" +
    						"</embed>" +
    					"</object> ";
    			
    			form.setCodigo(codigo);
    		}
    		else
    			//Lanzamos la excepcion porque alguna keywords no esta bien metida
    			throw new ValidatorException("{agregaSlider.keywordIncorrecta}");
    			
    	}
    	catch(ValidatorException Ve)
		{
			log.error("Ve ->" + Ve);
			throw Ve;
    	} 
		catch (Exception e)
		{
    		log.error("Error al crear el codigo embebido para el agregaSlider: " + e);
    		throw new ValidatorException("{agregaSilder.errorCrearCodigoEmbebido}");
		}
    	
    }




    /**
     * Metodo que carga los idiomas que van a aparecer en el combo de idiomas de la pantalla
     * de keywords
     */
    public final void cargarIdioma(org.apache.struts.action.ActionMapping mapping, es.pode.visualizador.presentacion.agregaSlider.CargarIdiomaForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	
    	I18n i18n = I18n.getInstance();
    	
    	//Recogemos el idioma por defecto para mostrar en ese idioma la lista desplegable de idiomas
    	Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
    	
    	
    	//recogemos un array de objetos con la lista de idiomas
    	LocalizacionIdiomaVO[] localizacionArray = i18n.obtenerIdiomasBuscablesLocalizados(locale.getLanguage());
    	
    	//sacamos los idiomas del array de objetos y lo asignamos al combo
    	form.setIdiomasComboBackingList(Arrays.asList(localizacionArray), "idLocalizacion", "name");
    	
    }
    
    
 
    
    /**
     * Metodo que comprueba que las keywords introducidas no tienen caracteres incorrectos
     */
    private boolean comprobarKeywords(String keywordsJuntas)
    {
    	String[] keyword;
    	keyword = keywordsJuntas.split(" ");
    	
    	for(int i=0; i < keyword.length; i++)
    	{
	    	if(keyword[i].indexOf("#") > 0 || keyword[i].indexOf("%") > 0 || keyword[i].indexOf("&") > 0 || 
	    			keyword[i].indexOf("+") > 0	|| keyword[i].indexOf("\"") > 0 || keyword[i].indexOf("<") > 0 ||
	    			keyword[i].indexOf(">") > 0 || keyword[i].indexOf("\'") > 0 || keyword[i].indexOf("*") > 0 ||
	    			keyword[i].indexOf("?") > 0)
	    		
	    		return false;
	    	
    	}
    	
    	return true;
    }



    private void log(Object obj) 
    {
    	if (log.isDebugEnabled())
    	    log.debug(obj);
    }






}