/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.repositoriosExternos.listarRepositoriosExternos;

import java.util.List;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.buscar.negocio.nodosSQI.servicio.NodoDescripcionSQIVO;
import es.pode.buscar.negocio.nodosSQI.servicio.SrvGestionSqiService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.administracion.presentacion.repositoriosExternos.listarNodosSQI.ListarNodosSQIController
 */
public class ListarNodosSQIControllerImpl extends ListarNodosSQIController
{




	private static Logger logger = Logger.getLogger(ListarNodosSQIControllerImpl.class);

	public void getIds(ActionMapping mapping, GetIdsForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
	    	List lista = ((FormularioNodosSQIEliminarNodoSQIFormImpl) form).getIdNodoRowSelection();
	    	if(logger.isDebugEnabled())
	    		logger.debug("Los nodos que se van a eliminar son ["+lista);
	       if (lista == null){
	    	   throw new ValidatorException ("{errors.bajanodosSQI.idNulo}");
	       }
	       form.setIds(lista);
	       logger.info("Se van a eliminar los siguientes nodosSQI: " + lista);
	       
       } catch (ValidatorException e){
    	   throw e;
	    	   
       } catch (Exception e){
    	   
    	   logger.error("Se ha producido un error al intentar recuperar los ids para borrar: " +e);
    	   throw new ValidatorException ("{errors.eliminarnodos.idError}");
    	   
       }
		
	}


	public void listarNodosSQI(ActionMapping mapping, ListarNodosSQIForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
        	
	    	SrvGestionSqiService service =  this.getSrvGestionSqiService();
        	NodoDescripcionSQIVO[] nodos = service.listarNodosSQI();
        	form.setNodosAsArray(nodos);
        } catch (Exception e){
        	logger.error("Se ha producido un error al listar los nodosSQI: " + e);
        	throw new ValidatorException ("{errors.listarnodoSQI} ");
        }
		
	}




}