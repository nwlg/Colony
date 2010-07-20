/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.nodos.bajaNodo;

import java.util.Iterator;
import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import es.pode.buscar.negocio.administrar.servicio.NodoVO;
import es.pode.buscar.negocio.administrar.servicio.SrvNodoService;
import es.pode.buscar.negocio.administrar.servicio.ValidaBajaNodoVO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.administracion.presentacion.nodos.bajaNodo.BajaNodoController
 */
public class BajaNodoControllerImpl extends BajaNodoController
{



	private static Logger log = Logger.getLogger(BajaNodoControllerImpl.class);



    /**
     * @see es.pode.administracion.presentacion.nodos.bajaNodo.BajaNodoController#bajaNodo(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.nodos.bajaNodo.BajaNodoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void bajaNodo(ActionMapping mapping, es.pode.administracion.presentacion.nodos.bajaNodo.BajaNodoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	    	
    	try{
    		
    		
    		//String listaId = request.getParameter("listaId");
    		String listaId = request.getParameter("listaId");
    		if(log.isDebugEnabled())log.debug("los ids de nodos que se quieren eliminar son " + listaId);
    		Object[] objeto = listaId.split(" ");
    		SrvNodoService nodoService = this.getSrvNodoService();
    		ValidaBajaNodoVO validaBajaNodoVO = nodoService.eliminarNodo(obtenerIds(objeto));
    		form.setNodosBorrados(validaBajaNodoVO.getNodosBorrados());
    		form.setDescripcionBaja(validaBajaNodoVO.getDescripcionBaja());
    		
    		//TODO meter en los resources el ok y fallo
    		 		
    	}catch (Exception e){
    		log.error("Se ha producido un error al eliminar el nodo: " + e);
    		throw new ValidatorException("{errors.borrarNodo}");
    	}
    	
    	
     }




    private Long[] obtenerIds(Object[] id) {
    	
    	Long[] resultado = new Long[id.length];
    	for (int i = 0; i < id.length; i++) {
    	    resultado[i] = new Long((String) id[i]);
    	}
    	log.info("Los identificadores recuperados son"+resultado);
    	return resultado;
        }



    /**
     * @see es.pode.administracion.presentacion.nodos.bajaNodo.BajaNodoController#obtenerNodos(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.nodos.bajaNodo.ObtenerNodosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void obtenerNodos(ActionMapping mapping, es.pode.administracion.presentacion.nodos.bajaNodo.ObtenerNodosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	try {
    		log.info("Entramos en obtenerNodos");
    		SrvNodoService srvNodoService = this.getSrvNodoService();

    	    Iterator iter = (form.getIds()).iterator();
    	    NodoVO[] nodos = new NodoVO[form.getIds().size()];
    	    int i = 0;
    	    String listaId = "";
    	    while (iter.hasNext()) {
    	    	log.info("Iteramos");
	    		Long id = new Long((String) iter.next());
	    		listaId = listaId + id.toString() + " ";
	
	    		NodoVO nodoVO = srvNodoService.obtenerNodo(id);
	    		nodos[i] = nodoVO;
	    		i = i + 1;
    	    }
    	    log.info("Salimos con la lista "+listaId);
    	    form.setListaId(listaId.trim());
    	    form.setNodos(nodos);

    	} catch (Exception e) {
    	    log.error("Se ha producido un error al recuperar los nodos: " + e);
    	    throw new ValidatorException("{errors.borrarNodo}");
    	}

     }





}