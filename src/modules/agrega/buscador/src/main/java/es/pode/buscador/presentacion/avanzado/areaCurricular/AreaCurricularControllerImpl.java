/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.areaCurricular;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.buscador.presentacion.BuscarSession;
import es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO;
import es.pode.soporte.constantes.ConstantesAgrega;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @see es.pode.buscador.presentacion.avanzado.areaCurricular.AreaCurricularController
 */
public class AreaCurricularControllerImpl extends AreaCurricularController{

	private static final long serialVersionUID = -8190956967834999990L;
	
	private java.util.Properties pSpringProperties = null;

	private static Logger logger = Logger.getLogger(AreaCurricularControllerImpl.class);
	
	public final static String MENSAJE_GENERICO_BUSQUEDA = "listar.odecu.mostrar.resultados.consulta.cabecera.errorBusqueda";

    /**
     * @see es.pode.buscador.presentacion.avanzado.areaCurricular.AreaCurricularController#obtenerAreasCurriculares(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.avanzado.areaCurricular.ObtenerAreasCurricularesForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void obtenerAreasCurriculares(ActionMapping mapping, es.pode.buscador.presentacion.avanzado.areaCurricular.ObtenerAreasCurricularesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
    	try {
    		log("AreaCurricularControllerImpl - obtenerAreasCurriculares");
    		TaxonVO[] taxVO = null;
    		Object[] taxVORutaPadre = null;
    		String idioma=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
//  		Detectamos si se ha pulsado sobre un identificador de la lista de taxones desplegada
    		if (form.getId() == null || form.getId().equals("")){
    			log("AreaCurricularControllerImpl - obtenerAreasCurriculares: Cargando taxones de vacio en busqueda avanzada.");
    			taxVO = this.getSrvTaxonomiaService().obtenerTaxonomia(this.getPropertyValue("nombreAreaCurricularTax"), idioma);
    			taxVORutaPadre = new TaxonVO[0];
    			log("AreaCurricularControllerImpl - obtenerAreasCurriculares: Recuperados["+taxVO.length+"] taxones de vacio en busqueda avanzada.");
    		}else{
    			log("AreaCurricularControllerImpl - obtenerAreasCurriculares: Cargando taxones del identificador["+form.getId()+"] en busqueda avanzada.");
    			taxVO = this.getSrvTaxonomiaService().obtenerNodos(form.getId(),this.getPropertyValue("nombreAreaCurricularTax"), idioma);
    			List rutaPadrevo = Arrays.asList(this.getSrvTaxonomiaService().obtenerTaxonPath(form.getId(), this.getPropertyValue("nombreAreaCurricularTax"), idioma));
    			log("AreaCurricularControllerImpl - obtenerAreasCurriculares: Recuperados["+taxVO.length+"] taxones de del identificador["+form.getId()+"] en busqueda avanzada.");
    			Collections.reverse(rutaPadrevo);
    			taxVORutaPadre = rutaPadrevo.toArray();
    		}
    		log("AreaCurricularControllerImpl - obtenerAreasCurriculares: Cargados["+taxVO.length+"] taxones del identificador ["+(form.getId() == null?"null":form.getId())+"] en busqueda avanzada.");
			form.setNodosAsArray(taxVO);
			form.setRutaArbolAsArray(taxVORutaPadre);
    	} catch (Exception e) {
			logger.error("AreaCurricularControllerImpl - obtenerAreasCurriculares ERROR: Error cargando taxonomias de ["+this.getPropertyValue("nombreAreaCurricularTax")+"] en busqueda avanzada.", e);
			saveErrorMessage(request, MENSAJE_GENERICO_BUSQUEDA);
		}
     }

    /**
     * @see es.pode.buscador.presentacion.avanzado.areaCurricular.AreaCurricularController#volcarAreaCurricularSesion(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.avanzado.areaCurricular.VolcarAreaCurricularSesionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void volcarAreaCurricularSesion(ActionMapping mapping, es.pode.buscador.presentacion.avanzado.areaCurricular.VolcarAreaCurricularSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
    	try{
    		log("AreaCurricularControllerImpl - volcarAreaCurricularSesion");
    		//Almacenamos el capo de nivel educativo que se ha seleccionado con todo el rollo de la seleccion
    		BuscarSession sesion = this.getBuscarSession(request);
    		if ( sesion == null ) // si la sesion no existe (raro) la creamos y metemos el dato.
    		sesion = new BuscarSession();
    		//Metemos en la sesion el nivel educativo traducido 
    		sesion.setAreaCurricular(form.getAreaCurricular());
    	}catch (Exception e){
    		logger.error("AreaCurricularControllerImpl - volcarAreaCurricularSesion ERROR: Error al volcar el area curricular en sesion", e);
    	}
     }

    private String getPropertyValue(String sKey) throws IOException {
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/spring_buscador.properties");
		if (this.pSpringProperties == null) {
			pSpringProperties = new java.util.Properties();
			pSpringProperties.load(fIsSpringProperties);
		}
		fIsSpringProperties.close();
		logger.debug("Propiedad recuperada: " + sKey + " : "+ pSpringProperties.getProperty(sKey));
		// devolvemos la propiedad
		return pSpringProperties.getProperty(sKey);
	}
    
    private void log(String traza){
		if (logger.isDebugEnabled())logger.debug(traza);
	}
}