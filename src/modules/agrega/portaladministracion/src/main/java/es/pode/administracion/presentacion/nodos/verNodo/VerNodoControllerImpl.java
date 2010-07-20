/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.nodos.verNodo;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import es.pode.buscar.negocio.administrar.servicio.CcaaVO;
import es.pode.buscar.negocio.administrar.servicio.NodoVO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.administracion.presentacion.nodos.verNodo.VerNodoController
 */
public class VerNodoControllerImpl extends VerNodoController
{
	private static Logger log = Logger.getLogger(VerNodoControllerImpl.class);

    /**
     * Este metodo muestra los detalles de un nodo determinado
     * @param mapping 
     * @param form Formulario del tipo CargarNodoForm que contiene los datos que se necesitan pasar para
     * 		  mostrar los detalles del nodo
     * @param request
     * @param response
     */
    public final void cargarNodo(ActionMapping mapping, es.pode.administracion.presentacion.nodos.verNodo.CargarNodoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	try{
    		
	    	Long id = Long.valueOf(request.getParameter("id"));
	    	NodoVO nodo = this.getSrvNodoService().obtenerNodo(id);
			CcaaVO ccaa = nodo.getCcaa();
	    		
			form.setNodo(nodo.getNodo());
			form.setUrl(nodo.getUrl());
			form.setPuerto(nodo.getPuerto());
			form.setId(nodo.getId());
			form.setUrlWS(nodo.getUrlWS());
			form.setIdNodo(nodo.getIdNodo());
			if (ccaa!=null){
				form.setComunidad(ccaa.getDescripcion());
			}
			
    	} catch (Exception e) {
    		log.error("Error: " + e);
    		throw new ValidatorException("{verGrupo.error}");
    	}
    	
    	
    	
    }
    	
   
    	
        









}