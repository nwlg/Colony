/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion;


import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.catalogacion.negocio.servicios.AvClassificationVO;
import es.pode.catalogacion.negocio.servicios.SourceValueVO;
import es.pode.catalogadorWeb.presentacion.CatalogadorAvSession;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoVO;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoYPadreVO;
import es.pode.soporte.constantes.ConstantesAgrega;


/**
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ClasificacionController
 */
public class ClasificacionControllerImpl extends ClasificacionController
{
	
	protected static Logger logger = Logger.getLogger(ClasificacionControllerImpl.class); 
    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ClasificacionController#cargarClasificacion(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.CargarClasificacionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargarClasificacion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.CargarClasificacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
    	try{
//    		si expira la sesión, debemos dar error de sesión, comprobamos si el objeto de sesión contiene el identificador
    		if ((catalogadorAvSession==null) || (catalogadorAvSession.getIdentificador()==null)) {
    			throw new Exception();
    		}
	    	if ((catalogadorAvSession!=null) && (catalogadorAvSession.getMDSesion()!=null)) {
	    		AvClassificationVO[] clasificaciones = catalogadorAvSession.getMDSesion().getClasificaciones();
	    		form.setListadoClasificacionAsArray(clasificaciones);
	    		
	        	String idiomaLdap=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();

	        	if(clasificaciones!=null){
	    			String[] listaProposito=new String[clasificaciones.length];
	    			String[] lista=new String[clasificaciones.length];
		    		for(int i=0;i< clasificaciones.length;i++){
		    			SourceValueVO sourcePro=clasificaciones[i].getProposito();
		    			if(sourcePro!=null && !sourcePro.equals("")){
			    			String propoIngles=sourcePro.getValor();
			    			if(propoIngles!=null && !propoIngles.equals("")){
			    				lista[i]=propoIngles;
			    			}else{
			    				lista[i]="";
			    			}
		    			}else
		    				lista[i]="";
		    			
		    		}
		    		TerminoYPadreVO[] terminoypadre=new TerminoYPadreVO[clasificaciones.length];
		    		for(int k=0;k<terminoypadre.length;k++){
		    			TerminoYPadreVO termino=new TerminoYPadreVO();
		    			termino.setNomTermino(lista[k]);
		    			termino.setIdVocabulario("9.1");
		    			termino.setIdiomaTermino("en");
		    			termino.setIdTermino("");
		    			terminoypadre[k]=termino;
		    		}
		    		TerminoYPadreVO[] listaIds=this.getSrvVocabulariosControladosService().obtenerIdTermino(terminoypadre);
		    		String[] isd=new String[clasificaciones.length];
		    		for(int l=0;l<clasificaciones.length;l++){
		    			if(listaIds[l].getIdTermino()!=null){
		    				isd[l]=listaIds[l].getIdTermino();
		    			}
		    			else{
		    				isd[l]="";
		    			}
		    			
		    		}
		    		int i=0;
		    		TerminoVO[] traduccion = this.getSrvVocabulariosControladosService().crearTraduccionAIdioma(isd, idiomaLdap);
		    		for(int j=0;j<clasificaciones.length;j++){
		    			if(!isd[j].equals("")){
			    			String propoTrad=traduccion[j-i].getNomTermino();
			    			if(propoTrad!=null && !propoTrad.equals("")){
			    				listaProposito[j]=propoTrad;
			    			}
		    			}else{
		    				listaProposito[j]="";
		    				i=i+1;
		    			}
		    		}
		    		catalogadorAvSession.setListaProposito(listaProposito);
	    		}
	    	}
    	}catch (org.acegisecurity.AccessDeniedException ad) {
    		logger.error("Error Acceso Denegado " + ad);
    		throw new java.lang.Exception("clasificacion", ad);
		}catch (Exception e) {
			logger.error("Error categoria clasificacion, método cargarClasificacion " + e);
			throw new java.lang.Exception("clasificacion", e);
		}
    }

	public void eliminarClasificacion(ActionMapping mapping, EliminarClasificacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		boolean esta=false;
		boolean seleccion =false;
    	Object valor = request.getSession().getAttribute("form");
    	CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
    	
    	try {
//    		si expira la sesión, debemos dar error de sesión, comprobamos si el objeto de sesión contiene el identificador
    		if ((catalogadorAvSession==null) || (catalogadorAvSession.getIdentificador()==null)) {
    			throw new Exception();
    		}
	    	if (valor instanceof ClasificacionFormImpl) {
				form.setListadoClasificacionAsArray(((ClasificacionFormImpl)valor).getListadoClasificacionAsArray());
			} 
	    	else if (valor instanceof es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ConfirmacionEliminarDatosASesionFormImpl) {
				form.setListadoClasificacionAsArray(((es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ConfirmacionEliminarDatosASesionFormImpl)valor).getListadoClasificacionAsArray());
			}else if (valor instanceof es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ConfirmacionEliminarCancelarEliminarFormImpl) {
				form.setListadoClasificacionAsArray(((es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ConfirmacionEliminarCancelarEliminarFormImpl)valor).getListadoClasificacionAsArray());
			}
	
	    	if ((form.getTituloClasificacionRowSelection() != null) && (form.getListadoClasificacionAsArray()!=null) && (form.getListadoClasificacionAsArray().length>0) ) {
	    		AvClassificationVO[] clasificaciones= (AvClassificationVO[]) form.getListadoClasificacionAsArray();
	    		ArrayList listaRec= new ArrayList();
	    		for (int indi=0; indi<clasificaciones.length; indi++) {
	    			int indiTitu=0;
	    			while ((indiTitu<form.getTituloClasificacionRowSelection().size() && (!esta))) {
	        			int valorTitu=Integer.parseInt(form.getTituloClasificacionRowSelection().get(indiTitu).toString()) -1;
	        			if (valorTitu == indi) {
	        				esta=true;
	        				seleccion=true;
	        			}
	        			indiTitu++;
	    			}
	    			if (!esta) {
	    				listaRec.add(clasificaciones[indi]);
	    			}
	    			esta=false; //Iniciliazamos para la siguiente iteracion
	    		}
	    		AvClassificationVO[] clasiAux = (AvClassificationVO[]) listaRec.toArray(new AvClassificationVO[listaRec.size()]);
	    		
	    		form.setListadoClasificacionAsArray(clasiAux);
	    	}//fin if
	    
    	}catch (org.acegisecurity.AccessDeniedException ad) {
    		logger.error("Error Acceso Denegado " + ad);
    		throw new java.lang.Exception("clasificacion", ad);
		}catch (Exception e) {
			logger.error("Error categoria clasificacion, método eliminarClasificacion " + e);
			throw new java.lang.Exception("clasificacion", e);
		}
		//Cambiamos aqui, para que no sea caputrada por Exception
    	if(!seleccion)
    		throw new ValidatorException("{error.EliminarNoSeleccion}");
	}
	

	public void cancelar(ActionMapping mapping, CancelarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//vuelve al inicio
		
	}

	public void guardarEnSesion(ActionMapping mapping, GuardarEnSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		logger.debug(" Guardar en sesion ");
		Object valor = request.getSession().getAttribute("form");
		CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
		
		try{
//    		si expira la sesión, debemos dar error de sesión, comprobamos si el objeto de sesión contiene el identificador
    		if ((catalogadorAvSession==null) || (catalogadorAvSession.getIdentificador()==null)) {
    			throw new Exception();
    		}

			if (valor instanceof ClasificacionFormEliminarFormImpl) {
			form.setListadoClasificacionAsArray(((ClasificacionFormEliminarFormImpl) valor).getListadoClasificacionAsArray());
			} else if (valor instanceof es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ConfirmacionEliminarDatosASesionFormImpl) {
				form.setListadoClasificacionAsArray(((es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ConfirmacionEliminarDatosASesionFormImpl) valor).getListadoClasificacionAsArray());
			}
			AvClassificationVO[] clasificaciones= (AvClassificationVO[]) form.getListadoClasificacionAsArray();
			//CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
	    	
	    	if (catalogadorAvSession.getMDSesion()!=null) {
	    		catalogadorAvSession.getMDSesion().setClasificaciones(clasificaciones);
	    	}
	    	
		}catch (org.acegisecurity.AccessDeniedException ad) {
    		logger.error("Error Acceso Denegado " + ad);
    		throw new java.lang.Exception("clasificacion", ad);
		}catch (Exception e) {
			logger.error("Error categoria clasificacion, método cargarClasificacion " + e);
			throw new java.lang.Exception("clasificacion", e);
		}
		
	}


	public boolean hayClasificaciones(ActionMapping mapping, HayClasificacionesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean result = false;
		CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
    	try {
	    	if (catalogadorAvSession.getMDSesion()!=null) {
	    		AvClassificationVO[] clasificaciones =catalogadorAvSession.getMDSesion().getClasificaciones();
	    		if (clasificaciones == null || clasificaciones.length == 0 ){
	    			result = false;
	    		}
	    		else 
	    			result = true;
	   
	    	}
    	}catch (org.acegisecurity.AccessDeniedException ad) {
    		logger.error("Error Acceso Denegado " + ad);
    		throw new java.lang.Exception("clasificacion", ad);
		}catch (Exception e) {
			logger.error("Error AnotacionController, método hayClasificaciones "+ e);
			throw new java.lang.Exception("clasificacion", e);
		}
		return result;
	}






}