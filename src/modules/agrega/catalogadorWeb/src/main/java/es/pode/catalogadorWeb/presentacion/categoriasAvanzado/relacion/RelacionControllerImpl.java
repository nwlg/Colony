/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.catalogacion.negocio.servicios.AvRelationVO;
import es.pode.catalogadorWeb.presentacion.CatalogadorAvSession;



/**
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.RelacionController
 */
public class RelacionControllerImpl extends RelacionController
{


	protected static Logger logger = Logger.getLogger(RelacionControllerImpl.class); 



    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.RelacionController#cargarRelaciones(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.CargarRelacionesForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargarRelaciones(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.CargarRelacionesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
//		si expira la sesión, debemos dar error de sesión, comprobamos si el objeto de sesión contiene el identificador
		if ((catalogadorAvSession==null) || (catalogadorAvSession.getIdentificador()==null)) {
			throw new Exception();
		}

    	try{
	    	if (catalogadorAvSession.getMDSesion()!=null) {
	    		AvRelationVO[] relaciones =catalogadorAvSession.getMDSesion().getRelaciones();
	    		
	    		form.setListadoRelacionesAsArray(relaciones);
	    		form.setIdentificadorOde(catalogadorAvSession.getIdentificador());
	    	}
    	}catch (org.acegisecurity.AccessDeniedException ad) {
    		logger.error("Error de Acceso " + ad);
    		throw new java.lang.Exception("relacion", ad);
			
		}catch (Exception e){
			logger.error("Error en Servicio de catalogacion, metodo cargarDatos " + e);
			throw new java.lang.Exception("relacion", e);
		}
		
     }




    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.RelacionController#eliminarRelacion(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.EliminarRelacionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarRelacion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.EliminarRelacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	boolean esta=false;
    	boolean seleccion =false;
    	Object valor = request.getSession().getAttribute("form");
    	//recupero la coleccion de Elementos para borrarle el que coincida con ese id
    	CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
//		si expira la sesión, debemos dar error de sesión, comprobamos si el objeto de sesión contiene el identificador
		if ((catalogadorAvSession==null) || (catalogadorAvSession.getIdentificador()==null)) {
			throw new Exception();
		}
    	try{
	    	if (valor instanceof RelacionFormImpl) {
	    		form.setListadoRelacionesAsArray(((RelacionFormImpl) valor).getListadoRelacionesAsArray());	
			} else if (valor instanceof ConfirmacionEliminarCancelarEliminarFormImpl) {
				form.setListadoRelacionesAsArray(((ConfirmacionEliminarCancelarEliminarFormImpl) valor).getListadoRelacionesAsArray());
			}  else if (valor instanceof ConfirmacionEliminarDatosASesionFormImpl) {
				form.setListadoRelacionesAsArray(((ConfirmacionEliminarDatosASesionFormImpl) valor).getListadoRelacionesAsArray());
			}  	
	    	if ((form.getTituloRelacionRowSelection() != null) && (form.getListadoRelacionesAsArray()!=null) && (form.getListadoRelacionesAsArray().length>0) ) {
	    		AvRelationVO[] relaciones= (AvRelationVO[]) form.getListadoRelacionesAsArray();
	    		ArrayList listaRec= new ArrayList();
	    		for (int indi=0; indi<relaciones.length; indi++) {
	    			int indiTitu=0;
	    			while ((indiTitu<form.getTituloRelacionRowSelection().size() && (!esta))) {
	        			int valorTitu=Integer.parseInt(form.getTituloRelacionRowSelection().get(indiTitu).toString()) -1;
	        			if (valorTitu == indi) {
	        				esta=true;
	        				seleccion=true;
	        			}
	        			indiTitu++;
	    			}
	    			if (!esta) {
	    				listaRec.add(relaciones[indi]);
	    			}
	    			esta=false; //Iniciliazamos para la siguiente iteracion
	    		}
	    		AvRelationVO[] reAux = (AvRelationVO[]) listaRec.toArray(new AvRelationVO[listaRec.size()]);
	    		form.setListadoRelacionesAsArray(reAux);
			  
	    	}
    	
    	}catch (org.acegisecurity.AccessDeniedException ad) {
    		logger.error("Error de Acceso " + ad);
    		throw new java.lang.Exception("relacion", ad);
			
		}catch (Exception e){
			logger.error("Error en catalogadorWeb, categoría Relación, metodo eliminarRelacion " + e);
			throw new java.lang.Exception("relacion", e);
		}
    	
    	if(!seleccion)
    		throw new ValidatorException("{error.EliminarNoSeleccion}");
    		
     }






	public void cancelar(ActionMapping mapping, CancelarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void guardarEnSesion(ActionMapping mapping, GuardarEnSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Object valor = request.getSession().getAttribute("form");
		try{	
			if (valor instanceof ListadoRelacionesFormEliminarFormImpl) {
				form.setListadoRelacionesAsArray(((ListadoRelacionesFormEliminarFormImpl) valor).getListadoRelacionesAsArray());
			} else if (valor instanceof ConfirmacionEliminarCancelarEliminarFormImpl) {
				form.setListadoRelacionesAsArray(((ConfirmacionEliminarCancelarEliminarFormImpl) valor).getListadoRelacionesAsArray());
			}
			AvRelationVO[] relaciones= (AvRelationVO[]) form.getListadoRelacionesAsArray();
			CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
	    	
	    	if (catalogadorAvSession.getMDSesion()!=null) {
	    		catalogadorAvSession.getMDSesion().setRelaciones(relaciones);
	    	}
	    	
		}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
			throw new java.lang.Exception("relacion", ad);
			
		}catch (Exception e){
			logger.error("Error en catalogadorWeb, categoría Relación, metodo guardarEnSesion " + e);
			throw new java.lang.Exception("relacion", e);
		}
		
	}

	public boolean hayRelaciones(ActionMapping mapping, HayRelacionesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean result = false;
		CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
    	try {
	    	if (catalogadorAvSession.getMDSesion()!=null) {
	    		AvRelationVO[] relaciones =catalogadorAvSession.getMDSesion().getRelaciones();
	    		if (relaciones == null || relaciones.length == 0 ){
	    			result = false;
	    		}
	    		else 
	    			result = true;
	   
	    	}
    	}catch (org.acegisecurity.AccessDeniedException ad) {
    		logger.error("Error Acceso Denegado " + ad);
    		throw new java.lang.Exception("relacion", ad);
		}catch (Exception e) {
			logger.error("Error AnotacionController, método hayRelaciones "+ e);
			throw new java.lang.Exception("relacion", e);
		}
		return result;
	}

}