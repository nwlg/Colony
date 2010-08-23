/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.visualizador.presentacion.feeds.agregadorFeeds;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.agregador.negocio.agregador.servicio.FeedVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.visualizador.presentacion.feeds.agregadorFeeds.AgregadorFeedsController
 */
public class AgregadorFeedsControllerImpl extends AgregadorFeedsController
{


	private static Logger log = Logger.getLogger(AgregadorFeedsControllerImpl.class);




    /**
     * @see es.pode.visualizador.presentacion.feeds.agregadorFeeds.AgregadorFeedsController#obtenerFeeds(org.apache.struts.action.ActionMapping, es.pode.visualizador.presentacion.feeds.agregadorFeeds.ObtenerFeedsForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void obtenerFeeds(ActionMapping mapping, es.pode.visualizador.presentacion.feeds.agregadorFeeds.ObtenerFeedsForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {

    	try{
	    	FeedVO[] feeds = this.getSrvAgregadorRssService().devuelveFeeds();
	    	if (log.isDebugEnabled())log.debug("AgregadorFeedsControllerImpl - Se han recuperado "+ feeds.length + " feeds");
	    	form.setFeeds(feeds);
	    } catch (Exception e){
	    	log.error("AgregadorFeedsControllerImpl - Se ha producido un error al recuperar los feeds: " + e);
	    	throw new ValidatorException ("{errors.obtenerFeeds}");
	    }
    	
    }




	public void queEsEsto(ActionMapping mapping, QueEsEstoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
	}









}