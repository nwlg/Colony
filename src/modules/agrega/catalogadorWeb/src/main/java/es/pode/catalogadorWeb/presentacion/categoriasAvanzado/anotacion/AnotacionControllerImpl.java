/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.catalogacion.negocio.servicios.AvAnnotationVO;
import es.pode.catalogadorWeb.presentacion.CatalogadorAvSession;



/**
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.AnotacionController
 */
public class AnotacionControllerImpl extends AnotacionController
{
	private static Logger logger = Logger.getLogger(AnotacionControllerImpl.class);
	
    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.AnotacionController#cargarAnotaciones(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.CargarAnotacionesForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargarAnotaciones(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.CargarAnotacionesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
     
    	CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
    	try {
    		//si expira la sesión, debemos dar error de sesión, comprobamos si el objeto de sesión contiene el identificador
    		if ((catalogadorAvSession==null) || (catalogadorAvSession.getIdentificador()==null)) {
    			throw new Exception();
    		}
	    	if (catalogadorAvSession.getMDSesion()!=null) {
	    		AvAnnotationVO[] anotaciones =catalogadorAvSession.getMDSesion().getAnotaciones();
	    		
	    		form.setListadoAnotacionesAsArray(anotaciones);
	    		form.setIdentificadorOde(catalogadorAvSession.getIdentificador());
	    	}
    	}catch (org.acegisecurity.AccessDeniedException ad) {
    		logger.error("Error Acceso Denegado " + ad);
    		throw new java.lang.Exception("anotacion", ad);
		}catch (Exception e) {
			logger.error("Error AnotacionController, método cargarAnotaciones "+ e);
			throw new java.lang.Exception("anotacion", e);
		}
    	
     }



    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.AnotacionController#eliminarAnotacion(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.EliminarAnotacionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarAnotacion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.EliminarAnotacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	boolean esta=false;
    	Object valor = request.getSession().getAttribute("form");
    	CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
    	boolean seleccion=false;
    	
    	try {
    		
//    		si expira la sesión, debemos dar error de sesión, comprobamos si el objeto de sesión contiene el identificador
    		if ((catalogadorAvSession==null) || (catalogadorAvSession.getIdentificador()==null)) {
    			throw new Exception();
    		}
	    	//recupero la coleccion de Elementos para borrarle el que coincida con ese id
	    	if (valor instanceof AnotacionFormImpl) {
	    		form.setListadoAnotacionesAsArray(((AnotacionFormImpl) valor).getListadoAnotacionesAsArray());
				
			} else if (valor instanceof ConfirmacionEliminarCancelarEliminarFormImpl) {
				form.setListadoAnotacionesAsArray(((ConfirmacionEliminarCancelarEliminarFormImpl) valor).getListadoAnotacionesAsArray());
			} else if (valor instanceof ConfirmacionEliminarDatosAsesionFormImpl) {
				form.setListadoAnotacionesAsArray(((ConfirmacionEliminarDatosAsesionFormImpl) valor).getListadoAnotacionesAsArray());
			}
	    	
	    	
	    	if ((form.getTituloAnotacionRowSelection() != null) && (form.getListadoAnotacionesAsArray()!=null) 
	    			&& (form.getListadoAnotacionesAsArray().length>0) ) {
	    		AvAnnotationVO[] anotaciones= (AvAnnotationVO[]) form.getListadoAnotacionesAsArray();
	    		ArrayList listaRec= new ArrayList();
	    		for (int indi=0; indi<anotaciones.length; indi++) {
	    			int indiTitu=0;
	    			while ((indiTitu<form.getTituloAnotacionRowSelection().size() && (!esta))) {
	        			int valorTitu=Integer.parseInt(form.getTituloAnotacionRowSelection().get(indiTitu).toString()) -1;
	        			if (valorTitu == indi) {
	        				esta=true;
	        				seleccion=true;
	        			}
	        			indiTitu++;
	    			}
	    			if (!esta) {
	    				listaRec.add(anotaciones[indi]);
	    			}
	    			esta=false; //Iniciliazamos para la siguiente iteracion
	    		}
	    		AvAnnotationVO[] anotaAux = (AvAnnotationVO[]) listaRec.toArray(new AvAnnotationVO[listaRec.size()]);
	    		
	    		form.setListadoAnotacionesAsArray(anotaAux);
			  
	    	}
			
	    	
    	
    	}catch (org.acegisecurity.AccessDeniedException ad) {
    		logger.error("Error Acceso Denegado " + ad);
    		throw new java.lang.Exception("anotacion", ad);
		}catch (Exception e) {
			logger.error("Error AnotacionController, método EliminarAnotacion "+ e);
			throw new java.lang.Exception("anotacion", e);
		}
    	//System.out.print("  ");
		//cambiamos la comprobación de Error Validacion, para que esta excepcion no sea capturada por java.lang.Exception
		if(!seleccion)
    		throw new ValidatorException("{error.EliminarNoSeleccion}");
    }


	public void guardarEnSesion(ActionMapping mapping, GuardarEnSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Object valor = request.getSession().getAttribute("form");
		try {
			if (valor instanceof ListadoAnotacionesFormEliminarFormImpl) {
				form.setListadoAnotacionesAsArray(((ListadoAnotacionesFormEliminarFormImpl) valor).getListadoAnotacionesAsArray());
			} else if (valor instanceof ConfirmacionEliminarCancelarEliminarFormImpl) {
				form.setListadoAnotacionesAsArray(((ConfirmacionEliminarCancelarEliminarFormImpl) valor).getListadoAnotacionesAsArray());
			}
			AvAnnotationVO[] anotaciones= (AvAnnotationVO[]) form.getListadoAnotacionesAsArray();
			CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
	    	
	    	if (catalogadorAvSession.getMDSesion()!=null) {
	    		catalogadorAvSession.getMDSesion().setAnotaciones(anotaciones);
	    	}
		}catch (org.acegisecurity.AccessDeniedException ad) {
    		logger.error("Error Acceso Denegado " + ad);
    		throw new java.lang.Exception("anotacion", ad);
		}catch (Exception e) {
			logger.error("Error AnotacionController, método guardarEnSession "+ e);
			throw new java.lang.Exception("anotacion", e);
		}
	}


	public void cancelar(ActionMapping mapping, CancelarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//Vuelve a Inicio Catalogador
//		System.out.print("");
	}


	public boolean hayAnotaciones(ActionMapping mapping, HayAnotacionesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	boolean result = false;
		CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
    	try {
	    	if (catalogadorAvSession.getMDSesion()!=null) {
	    		AvAnnotationVO[] anotaciones =catalogadorAvSession.getMDSesion().getAnotaciones();
	    		if (anotaciones == null || anotaciones.length == 0 ){
	    			result = false;
	    		}
	    		else 
	    			result = true;
	   
	    	}
    	}catch (org.acegisecurity.AccessDeniedException ad) {
    		logger.error("Error Acceso Denegado " + ad);
    		throw new java.lang.Exception("anotacion", ad);
		}catch (Exception e) {
			logger.error("Error AnotacionController, método hayAnotaciones "+ e);
			throw new java.lang.Exception("anotacion", e);
		}
		return result;
	}






}