/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo;

import java.util.ArrayList;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.catalogacion.negocio.servicios.AvEducationalVO;
import es.pode.catalogadorWeb.presentacion.CatalogadorAvSession;
import es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.ConfirmacionEliminarCancelarEliminarFormImpl;
import es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.ConfirmacionEliminarDatosASesionFormImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.UsoeducativoController
 */
public class UsoeducativoControllerImpl extends UsoeducativoController
{
	
	protected static Logger logger = Logger.getLogger(UsoeducativoControllerImpl.class);
	
  /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.UsoeducativoController#cargarUsosEducativos(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.CargarUsosEducativosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargarUsosEducativos(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.CargarUsosEducativosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
    	//		si expira la sesión, debemos dar error de sesión, comprobamos si el objeto de sesión contiene el identificador
		if ((catalogadorAvSession==null) || (catalogadorAvSession.getIdentificador()==null)) {
			throw new Exception();
		}
    	try{
	    	if (catalogadorAvSession.getMDSesion()!=null) {
	    		AvEducationalVO[] eduaciones =catalogadorAvSession.getMDSesion().getEducational();
	    		
	    		form.setListadoUsosEduAsArray(eduaciones);
	    		form.setIdentificadorOde(catalogadorAvSession.getIdentificador());
	    	}
    	
    	}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
    		throw new java.lang.Exception("uso.educativo", ad);
			
		}catch (Exception e){
			logger.error("Error en catalogadorWeb, categoría Uso Educativo, metodo cargarUsosEducativos " + e);
			throw new java.lang.Exception("uso.educativo", e);
		
		}
    }

    
    /**
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.UsoeducativoController#eliminarUsoEducativo(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.EliminarUsoEducativoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarUsoEducativo(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.EliminarUsoEducativoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	boolean esta=false;
    	boolean seleccion =false;
    	
    	try{
	    	Object valor = request.getSession().getAttribute("form");
	    	CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
//			si expira la sesión, debemos dar error de sesión, comprobamos si el objeto de sesión contiene el identificador
			if ((catalogadorAvSession==null) || (catalogadorAvSession.getIdentificador()==null)) {
				throw new Exception();
			}
	    	//recupero la coleccion de Elementos para borrarle el que coincida con ese id
	    	if (valor instanceof UsoEducativoFormImpl) {
	    		form.setListadoUsosEduAsArray(((UsoEducativoFormImpl) valor).getListadoUsosEduAsArray());
				
			}else if (valor instanceof ConfirmacionEliminarCancelarEliminarFormImpl) {
				form.setListadoUsosEduAsArray(((ConfirmacionEliminarCancelarEliminarFormImpl) valor).getListadoUsosEduAsArray());
			}    	
			else if (valor instanceof ConfirmacionEliminarDatosASesionFormImpl) {
				form.setListadoUsosEduAsArray(((ConfirmacionEliminarDatosASesionFormImpl) valor).getListadoUsosEduAsArray());
			}
	    	if ((form.getTituloUsoEduRowSelection() != null) && (form.getListadoUsosEduAsArray()!=null) && (form.getListadoUsosEduAsArray().length>0) ) {
	    		AvEducationalVO[] educaciones= (AvEducationalVO[]) form.getListadoUsosEduAsArray();
	    		ArrayList listaRec= new ArrayList();
	    		for (int indi=0; indi<educaciones.length; indi++) {
	    			int indiTitu=0;
	    			while ((indiTitu<form.getTituloUsoEduRowSelection().size() && (!esta))) {
	        			int valorTitu=Integer.parseInt(form.getTituloUsoEduRowSelection().get(indiTitu).toString()) -1;
	        			if (valorTitu == indi) {
	        				esta=true;
	        				seleccion=true;
	        			}
	        			indiTitu++;
	    			}
	    			if (!esta) {
	    				listaRec.add(educaciones[indi]);
	    			}
	    			esta=false; //Iniciliazamos para la siguiente iteracion
	    		}
	    		AvEducationalVO[] eduAux = (AvEducationalVO[]) listaRec.toArray(new AvEducationalVO[listaRec.size()]);
	    		form.setListadoUsosEduAsArray(eduAux);
			  
	    	}
	    	
    	}catch (org.acegisecurity.AccessDeniedException ad) {
			logger.error("Error de Acceso " + ad);
    		throw new java.lang.Exception("uso.educativo", ad);
			
		}catch (Exception e){
			logger.error("Error en catalogadorWeb, categoría Uso Educativo, metodo eliminarUsoEducativo " + e);
			throw new java.lang.Exception("uso.educativo", e);
		
		}
			
    	if(!seleccion)
    		throw new ValidatorException("{error.EliminarNoSeleccion}");
    	
     }


    
    /**
     * This dummy variable is used to populate the "listadoUsosEdu" table.
     * You may delete it when you add you own code in this controller.
     */
    private static final java.util.Collection listadoUsosEduDummyList =
        java.util.Arrays.asList( new Object[] {
            new ListadoUsosEduDummy("tituloUsoEdu-1"),
            new ListadoUsosEduDummy("tituloUsoEdu-2"),
            new ListadoUsosEduDummy("tituloUsoEdu-3"),
            new ListadoUsosEduDummy("tituloUsoEdu-4"),
            new ListadoUsosEduDummy("tituloUsoEdu-5")
        } );

    /**
     * This inner class is used in the dummy implementation in order to get the web application
     * running without any manual programming.
     * You may delete this class when you add you own code in this controller.
     */
    public static final class ListadoUsosEduDummy implements java.io.Serializable
    {
        private String tituloUsoEdu = null;

        public ListadoUsosEduDummy(String tituloUsoEdu)
        {
            this.tituloUsoEdu = tituloUsoEdu;
        }
        
        public void setTituloUsoEdu(String tituloUsoEdu)
        {
            this.tituloUsoEdu = tituloUsoEdu;
        }

        public String getTituloUsoEdu()
        {
            return this.tituloUsoEdu;
        }
        
    }

	public void cancelar(ActionMapping mapping, CancelarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.print("");
	}







	public void guardarEnSesion(ActionMapping mapping, GuardarEnSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Object valor = request.getSession().getAttribute("form");
		if (valor instanceof UsosEducativosFormEliminarFormImpl) {
			form.setListadoUsosEduAsArray(((UsosEducativosFormEliminarFormImpl) valor).getListadoUsosEduAsArray());
		} else if (valor instanceof ConfirmacionEliminarCancelarEliminarFormImpl) {
			form.setListadoUsosEduAsArray(((ConfirmacionEliminarCancelarEliminarFormImpl) valor).getListadoUsosEduAsArray());
		}
		AvEducationalVO[] educaciones= (AvEducationalVO[]) form.getListadoUsosEduAsArray();
		CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
    	
    	if (catalogadorAvSession.getMDSesion()!=null) {
    		catalogadorAvSession.getMDSesion().setEducational(educaciones);
    	}
	}

	public boolean hayUsosEducativos(ActionMapping mapping, HayUsosEducativosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean result = false;
		CatalogadorAvSession catalogadorAvSession=this.getCatalogadorAvSession(request);
    	try {
	    	if (catalogadorAvSession.getMDSesion()!=null) {
	    		AvEducationalVO[] usosEducativos =catalogadorAvSession.getMDSesion().getEducational();
	    		if (usosEducativos == null || usosEducativos.length == 0 ){
	    			result = false;
	    		}
	    		else 
	    			result = true;
	   
	    	}
    	}catch (org.acegisecurity.AccessDeniedException ad) {
    		logger.error("Error Acceso Denegado " + ad);
    		throw new java.lang.Exception("usoEducativo", ad);
		}catch (Exception e) {
			logger.error("Error AnotacionController, método hayUsosEducativos "+ e);
			throw new java.lang.Exception("usosEducativos", e);
		}
		return result;
	}


}