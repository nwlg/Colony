/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.informes.eliminarInformesFederados;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.contenidos.negocio.informes.servicio.SrvInformeService;
import es.pode.contenidos.negocio.informes.servicio.ValidaBajaInformeVO;



/**
 * @see es.pode.administracion.presentacion.informes.eliminarInformesFederados.EliminarInformesFederadosController
 */
public class EliminarInformesFederadosControllerImpl extends EliminarInformesFederadosController
{

	private static Logger logger = Logger.getLogger(EliminarInformesFederadosControllerImpl.class);




    /**
     * @see es.pode.administracion.presentacion.informes.eliminarInformesFederados.EliminarInformesFederadosController#obtenerInformeFederado(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.informes.eliminarInformesFederados.ObtenerInformeFederadoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void obtenerInformeFederado(ActionMapping mapping, es.pode.administracion.presentacion.informes.eliminarInformesFederados.ObtenerInformeFederadoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try {
    		
    		
    		Iterator iter = (form.getIds()).iterator();
    		int i = 0;
    	    String listaId = "";
    	    while (iter.hasNext()) {
	    		String nombre = (String) iter.next();
	    		listaId = listaId + nombre + ":";
	    		i = i + 1;
    	    }
    	    form.setListaId(listaId.trim());
    	    form.setInformes((String[])form.getIds().toArray(new String[0]));
    		
    	} catch (Exception e) {
    	    logger.error("Se ha producido un error al recuperar los informes federados: " + e);
    	    throw new ValidatorException("{errors.obtenerInformeFederado}");
    	}
     }







    /**
     * @see es.pode.administracion.presentacion.informes.eliminarInformesFederados.EliminarInformesFederadosController#eliminarInformeFederado(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.informes.eliminarInformesFederados.EliminarInformeFederadoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarInformeFederado(ActionMapping mapping, es.pode.administracion.presentacion.informes.eliminarInformesFederados.EliminarInformeFederadoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
try{
    		
    		String listaId = request.getParameter("listaId");
    		
    		if(logger.isDebugEnabled()) logger.debug("los ids de los informes federados que se quieren eliminar son " + listaId);
    		String[] informes = listaId.split(":");

    		if(logger.isDebugEnabled()) logger.debug("los ids de los informes federados que se quieren eliminar son " + listaId);
    		SrvInformeService informeService = this.getSrvInformeService();
    		ValidaBajaInformeVO bajaInformeVO = informeService.eliminarInformeFederado(informes);
    		form.setInformesBorrados(bajaInformeVO.getInformesBorrados());
    		form.setResultado(bajaInformeVO.getDescripcionBaja());
    		
    	}catch (Exception e){
    		logger.error("Se ha producido un error al eliminar el informe federado: " + e);
    		throw new ValidatorException("{errors.eliminarInformeFederado}");
    	}
     }









}