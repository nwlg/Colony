/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.gestor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.struts.action.ActionMapping;

import es.pode.empaquetador.negocio.servicio.OdeVO;
import es.pode.empaquetador.negocio.servicio.OrganizacionVO;
import es.pode.empaquetador.presentacion.EmpaquetadorSession;
import es.pode.empaquetador.presentacion.GestorSesion;
import es.pode.soporte.constantes.ConstantesAgrega;



/**
 * @see es.pode.empaquetador.presentacion.avanzado.organizaciones.gestor.GestorOrganizacionesController
 */
public class GestorOrganizacionesControllerImpl extends GestorOrganizacionesController
{

	
private GestorSesion gestorSesion =  new GestorSesion();
	
	/**
	 * @return the gestorSesion
	 */
	public GestorSesion getGestorSesion() {
		return gestorSesion;
	}


	/**
	 * @param gestorSesion the gestorSesion to set
	 */
	public void setGestorSesion(GestorSesion gestorSesion) {
		this.gestorSesion = gestorSesion;
	}

    	
    public final void cargarDatos(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.gestor.CargarDatosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
       	gestorSesion.refrescarObjetosSesion(request);
       	
     	List<OdeVO> subman = this.getEmpaquetadorSession(request).getSubmanifestPath();
        OdeVO ultimo=subman.get(subman.size()-1);
        OrganizacionVO[] organizacion = ultimo.getOrganizaciones();
        List<OrganizacionVO> organizaciones=Arrays.asList(organizacion);
    	form.setOrganizaciones(organizaciones);
    	
     }

    public final void submit(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.gestor.SubmitForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
		java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		String action = form.getAction();
		if (action.equals(i18n.getString("portal_empaquetado_gestorOrganizaciones.eliminar"))) 
		{
			if((form.getIdentifierRowSelectionAsArray()==null)||(form.getIdentifierRowSelectionAsArray().length==0))
			{
				throw new ValidatorException("{portal_empaquetado.exception.gestorOrganizaciones}");	
			}
		}
		
		String[] identificadores = form.getIdentifierRowSelectionAsArray();
 		
		form.setOrganizacionesAsArray(identificadores);
     }

    public final java.lang.String selectAction(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.gestor.SelectActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
       	/*
		 * Metodo de decision para el action. Analiza los parametros
		 * actionSubmit (value de los botones submit) para redirigir al caso de uso
		 * correspondiente. El actionSubmit llegara
		 * internacionalizado, por lo que es necesario acceder al ResouceBundle
		 * para obtener el valor correcto en la comparacion.
		 */
    	
		String result = null;
		String actionSubmit = form.getAction();
		java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		
		if (form.getAction()== (null))
		{
			throw new ValidatorException("{portal_empaquetado.exception}");
		}
			
		
		else if (actionSubmit.equals(i18n.getString("portal_empaquetado_gestorOrganizaciones.aceptar"))) 
		{
			result = "Crear";
		} 
		else if (actionSubmit.equals(i18n.getString("portal_empaquetado_gestorOrganizaciones.cancelar"))) {
			result = "Cancelar";
		} 
		
		else if (actionSubmit.equals(i18n.getString("portal_empaquetado_gestorOrganizaciones.principal"))) 
		{
			result = "Principal";
		} 
		else if (actionSubmit.equals(i18n.getString("portal_empaquetado_gestorOrganizaciones.eliminar"))) {
			result = "Eliminar";
		} 
		   
         return result;
    }


    public final void subir(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.gestor.SubirForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String idOrganization = form.getIdentifier();
    	EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
        List<OdeVO> subman = sesEmpaq.getSubmanifestPath();
    	
        OdeVO ultimo=subman.get(subman.size()-1);
        Integer index = subman.size()-1;
        String identificador=index==0?sesEmpaq.getIdLocalizador():ultimo.getIdentifier();
     	
        this.getSrvGestorManifestService().subirOrganization(identificador, idOrganization);
    }

    
    public final void bajar(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.gestor.BajarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
     
    	String idOrganization = form.getIdentifier();
    	EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
        List<OdeVO> subman = sesEmpaq.getSubmanifestPath();
    	
        OdeVO ultimo=subman.get(subman.size()-1);
        Integer index = subman.size()-1;
        String identificador=index==0?sesEmpaq.getIdLocalizador():ultimo.getIdentifier();
     	
        this.getSrvGestorManifestService().bajarOrganization(identificador, idOrganization);
    }

    
    public final void eliminar(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.gestor.EliminarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	List organization = form.getOrganizaciones();
    	EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
        List<OdeVO> subman = sesEmpaq.getSubmanifestPath();
    	
        OdeVO ultimo=subman.get(subman.size()-1);
        Integer index = subman.size()-1;
        String identificador=index==0?sesEmpaq.getIdLocalizador():ultimo.getIdentifier();
        OrganizacionVO[] organiz = ultimo.getOrganizaciones();
        //List org=Arrays.asList(organiz);
        String idOrganizacion="";
        for(int i=0;i<organiz.length;i++)
        {
        	if(organization.contains(organiz[i].getIdentifier()))
        	{
        		idOrganizacion=organiz[i].getIdentifier();
        		this.getSrvGestorManifestService().eliminarOrganizacion(identificador, idOrganizacion);
        	}
        }   
     }

	public final void editarOrganizacion(ActionMapping mapping, EditarOrganizacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
		String identificador = form.getIdentifier();
		List portapapeles = sesEmpaq.getPortapapeles();
		if(portapapeles!=null)
		{
			portapapeles.clear();
		}
		else
		{
			List portapapelesN=new ArrayList();
			portapapeles=portapapelesN;
		}
		sesEmpaq.setPortapapeles(portapapeles);
		
		sesEmpaq.setAccion("Normal");
		sesEmpaq.setModoPegar(false);
		
		List<OrganizacionVO> idCollection=sesEmpaq.getIdCollection();
		idCollection.clear();
		List<OdeVO> submanifestPath=sesEmpaq.getSubmanifestPath();
		OdeVO ultima = submanifestPath.get(submanifestPath.size()-1);
		OrganizacionVO[] organizaciones = ultima.getOrganizaciones();
		boolean encontrado=false;
		for(int i=0;(encontrado==false&& i<organizaciones.length);i++)
		{
			if(organizaciones[i].getIdentifier().equals(identificador))
			{
			idCollection.add(organizaciones[i]);
			encontrado=true;
			}
		}
		
		
		sesEmpaq.setIdCollection(idCollection);
	}

}