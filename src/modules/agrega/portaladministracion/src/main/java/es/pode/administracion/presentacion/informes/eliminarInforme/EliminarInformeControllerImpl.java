/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.informes.eliminarInforme;


import java.util.Iterator;
import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import es.pode.contenidos.negocio.informes.servicio.SrvInformeService;
import es.pode.contenidos.negocio.informes.servicio.ValidaBajaInformeVO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.administracion.presentacion.informes.eliminarInforme.EliminarInformeController
 */
public class EliminarInformeControllerImpl extends EliminarInformeController
{

	private static Logger log = Logger.getLogger(EliminarInformeControllerImpl.class);




    /**
     * @see es.pode.administracion.presentacion.informes.eliminarInforme.EliminarInformeController#eliminarInforme(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.informes.eliminarInforme.EliminarInformeForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarInforme(ActionMapping mapping, es.pode.administracion.presentacion.informes.eliminarInforme.EliminarInformeForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	
    	try{
    		
    		String listaId = request.getParameter("listaId");
    		
    		if(log.isDebugEnabled())log.debug("los ids de los informes que se quieren eliminar son " + listaId);
    		String[] informes = listaId.split(":");

    		if(log.isDebugEnabled())log.debug("los ids de los informes que se quieren eliminar son " + listaId);
    		SrvInformeService informeService = this.getSrvInformeService();
    		ValidaBajaInformeVO bajaInformeVO = informeService.eliminarInforme(informes);
    		form.setInformesBorrados(bajaInformeVO.getInformesBorrados());
    		form.setResultado(bajaInformeVO.getDescripcionBaja());
    		
    	}catch (Exception e){
    		log.error("Se ha producido un error al eliminar el informe: " + e);
    		throw new ValidatorException("{errors.eliminarInforme}");
    	}

     }






    /**
     * @see es.pode.administracion.presentacion.informes.eliminarInforme.EliminarInformeController#obtenerInforme(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.informes.eliminarInforme.ObtenerInformeForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void obtenerInforme(ActionMapping mapping, es.pode.administracion.presentacion.informes.eliminarInforme.ObtenerInformeForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
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
    	    log.error("Se ha producido un error al recuperar los informes: " + e);
    	    throw new ValidatorException("{errors.obtenerInforme}");
    	}
    	
     }









}