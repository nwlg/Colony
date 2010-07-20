/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.repositoriosExternos.bajaRepositoriosExternos;


import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.buscar.negocio.nodosSQI.servicio.NodoSQIVO;
import es.pode.buscar.negocio.nodosSQI.servicio.SrvGestionSqiService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.administracion.presentacion.repositoriosExternos.bajaNodoSQI.BajaNodoSQIController
 */
public class BajaNodoSQIControllerImpl extends BajaNodoSQIController
{



	private static Logger logger = Logger.getLogger(BajaNodoSQIControllerImpl.class);

	public void bajaNodoSQI(ActionMapping mapping, BajaNodoSQIForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
    		if(form.getListaId()!=null && !form.getListaId().equals("")){
    			String[]listIDsStrings=form.getListaId().split(",");
    			if(logger.isDebugEnabled())
    				logger.debug("La lista de identificadores:"+form.getListaId());
				Long[] listIDs =new Long[listIDsStrings.length];
				for(int i=0; i<listIDsStrings.length;i++)
				{
					listIDs[i]=Long.valueOf(listIDsStrings[i]);
				}

	    		SrvGestionSqiService nodoService = this.getSrvGestionSqiService();
	    		NodoSQIVO[] nodo = nodoService.consultaNodosSQI(listIDs);
	    		form.setNodosSQIEliminarAsArray(nodo);
	    		nodoService.bajaNodosSQI(listIDs);
	    		
    		}else{
    			throw new ValidatorException("{errors.bajanodosSQI.idNulo}");
    		}
    		 		
    	}catch (Exception e){
    		logger.error("Se ha producido un error al eliminar el nodoSQI: " + e);
    		throw new ValidatorException("{errors.bajanodoSQI}");
    	}
		
	}



	public void obtenerNodosSQI(ActionMapping mapping, ObtenerNodosSQIForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			
			   if(form.getIdsAsArray()!=null && form.getIdsAsArray().length>0){
				   Object[] arrayIds= form.getIdsAsArray();
				   if(logger.isDebugEnabled())
					   logger.debug("los ids de nodosSQI que se quieren eliminar son " + arrayIds);
		    		Long[] ident=new Long[arrayIds.length];
		    		String lista="";
		    		for(int i=0;i<arrayIds.length;i++){
		    			ident[i]= new Long((String) arrayIds[i]);
		    			lista=lista+ ident[i].toString() + ",";
		    		}
		  	     NodoSQIVO[] nodos = this.getSrvGestionSqiService().consultaNodosSQI(ident);
		  	     form.setIdsAsArray(ident);
		  	     form.setListaId(lista);
		  	     form.setNodosSQI(nodos);
			   }else{
				   throw new ValidatorException("{errors.bajanodosSQI.idNulo}");
			   }
	      	}catch (Exception e) {
	  	      	    logger.error("Se ha producido un error al recuperar los nodosSQI: " + e);
	  	      	    throw new ValidatorException("{errors.bajanodoSQI.recuperar}");
	  	     }  
	}









}