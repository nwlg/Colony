/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.buscador.presentacion.seleccionTipoBusqueda;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.buscador.presentacion.BuscarSession;
import es.pode.buscador.presentacion.basico.detallar.DetallarControllerImpl;
import es.pode.buscador.presentacion.basico.listar.ListarControllerImpl;
import es.pode.buscar.negocio.administrar.servicio.NodoVO;
import es.pode.buscar.negocio.administrar.servicio.SrvNodoService;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;



/**
 * @see es.pode.buscador.presentacion.seleccionTipoBusqueda.seleccionTipoBusquedaController
 */
public class seleccionTipoBusquedaControllerImpl extends seleccionTipoBusquedaController
{

	private static Logger logger = Logger.getLogger(ListarControllerImpl.class);
	private java.util.Properties pSpringProperties = null;	
	public static final String CARGAR_TESAURO = "CARGAR_TESAURO";	
	public static final String CARGAR_ARBOL = "CARGAR_ARBOL";
	public final static String TITULOTESAURO = "navegar.tesauro.nombre";
	
	private static final String FICHERO = "application-resources";
	private static final String EUSKERA = "eu";
	private static final String INGLES = "en";
	private static final String SPACE = " ";
	

    /**
     * @see es.pode.buscador.presentacion.seleccionTipoBusqueda.seleccionTipoBusquedaController#prepararConsulta(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.seleccionTipoBusqueda.PrepararConsultaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void prepararConsulta(ActionMapping mapping, es.pode.buscador.presentacion.seleccionTipoBusqueda.PrepararConsultaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	this.setBuscarSession(request, new BuscarSession());
    	form.setTipoBusquedaArbol("01");
    	form.setTipoNavegacion("01");
    	form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);    	
//		llamada traer nodos
    	try {
			SrvNodoService nodo = this.getSrvNodoService();
			NodoVO[] listaNodos = nodo.listarNodos();
			if(listaNodos == null || listaNodos.length == 0) form.setMostrarAmbito(new Boolean(false));
			else form.setMostrarAmbito(new Boolean(true));
    	} catch (Exception e) {
			logger.error("seleccionTipoBusquedaControllerImpl - prepararConsulta:Error recuperando el locale",e);
		}
    	String idiomaNavegacion = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
    	String nomTesauro = this.getPropertyValue("nombreFichTesauros");
    	log("Se obtiene el nombre del tesauro con el idioma de navegacion ["+idiomaNavegacion+"]");
		Locale locale = null;
		try {
			locale = devuelveLocale(request);
		} catch (Exception e) {
			logger.error("seleccionTipoBusquedaControllerImpl -prepararConsulta:Error recuperando el locale",e);
		}
		String tituloTesauro = "";
		String vocabNameTesauro = this.getSrvTesaurosServices().obtenerVocabName(nomTesauro, idiomaNavegacion);
//		Se forma el titulo del tesauro. El orden cambia dependiendo del idioma		 
		String literalTituloTesauro = this.getResource(TITULOTESAURO, FICHERO, locale);	
		if (EUSKERA.equals(idiomaNavegacion) || INGLES.equals(idiomaNavegacion))tituloTesauro = vocabNameTesauro + SPACE + literalTituloTesauro;
		else tituloTesauro = literalTituloTesauro + SPACE + vocabNameTesauro;
		form.setTituloTesauro(tituloTesauro);
    	
     }

    /**
     * @see es.pode.buscador.presentacion.seleccionTipoBusqueda.seleccionTipoBusquedaController#decidirSalida(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.seleccionTipoBusqueda.DecidirSalidaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String decidirSalida(ActionMapping mapping, es.pode.buscador.presentacion.seleccionTipoBusqueda.DecidirSalidaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    		if(form.getTipoBusquedaArbol()==null || form.getTipoBusquedaArbol().equals(""))form.setTipoBusquedaArbol("02");
    		BuscarSession sesion = this.getBuscarSession(request);
    		sesion.setTipoBusquedaArbol(form.getTipoBusquedaArbol());
    		sesion.setTituloTesauro(form.getTituloTesauro());
    		if (form.getTipoNavegacion().equals("01")){ //si es busqueda por arbol curricular
	    			return CARGAR_ARBOL;
			}else { //si es busqueda por tesauro
				return CARGAR_TESAURO;
			}   	
    	
    }
    
    private String getPropertyValue(String sKey) throws IOException {
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/spring_buscador.properties");
		if (this.pSpringProperties == null) {
			pSpringProperties = new java.util.Properties();
			pSpringProperties.load(fIsSpringProperties);
		}
		fIsSpringProperties.close();
		log("NavegarTesauroControllerImpl - getPropertyValue:Propiedad recuperada: " + sKey + " : "+ pSpringProperties.getProperty(sKey));
		// devolvemos la propiedad
		return pSpringProperties.getProperty(sKey);
	}

//	MÉTODOS PARA PINTAR LOS MENSAJES INTERNACIONALIZADOS
	public static String getResource(String key, String baseName, Locale locale)
	{
        String recurso = "";
        ResourceBundle theResourceBundle = getResource(baseName,locale);
        try{
        	if (theResourceBundle!=null){
               recurso = theResourceBundle.getString(key);
           }
        }catch (MissingResourceException mre){
        	recurso = key;
        }
        return recurso;
    }
	
	public static ResourceBundle getResource(String baseName, Locale locale)
	{
        try{
        	return ResourceBundle.getBundle(baseName,locale);
            
        }catch (MissingResourceException mre){
        		locale = new Locale("","");
        		return ResourceBundle.getBundle(baseName,locale);
             
        }
    }
	
	private Locale devuelveLocale(HttpServletRequest request) throws Exception
	{	
		
		Locale locale=null;
		if (request instanceof HttpServletRequest) {
			locale = (Locale)((HttpServletRequest)request).getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
			
		}
		else{ 	    					
			try {
				locale=new Locale(I18n.getInstance().obtenerIdiomaDefectoPlataforma());
			} catch (Exception e) {								
				logger.error("DevuelveLocale-- Error recuperando el locale del request", e);
			}
		}
		return locale;
	}

	private void log(String traza){
		if (logger.isDebugEnabled())logger.debug(traza);
	}
}