/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.crear;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.empaquetador.negocio.servicio.GrupoVO;
import es.pode.empaquetador.negocio.servicio.OdeVO;
import es.pode.empaquetador.negocio.servicio.OrganizacionVO;
import es.pode.empaquetador.presentacion.CatalogacionBean;
import es.pode.empaquetador.presentacion.EmpaquetadorSession;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.uuid.PodeUUIDGenerator;



/**
 * @see es.pode.empaquetador.presentacion.avanzado.organizaciones.crear.CrearOrganizacionController
 */
public class CrearOrganizacionControllerImpl extends CrearOrganizacionController
{

	private Logger logger = Logger.getLogger(CrearOrganizacionControllerImpl.class);

    public final void terminarCreacion(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.crear.TerminarCreacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	 if(this.getCrearOrganizacionSession(request)!=null)
         {
      	   request.getSession().removeAttribute(CrearOrganizacionSession.SESSION_KEY);
      	 
         }
    }

    public final void crearOrganizacion(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.crear.CrearOrganizacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	 CrearOrganizacionSession sesOrga=this.getCrearOrganizacionSession(request);
    	 EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
    	 List subman = sesEmpaq.getSubmanifestPath();
      	
    	 Integer index = subman.size()-1;
         OdeVO submanifestPath=(OdeVO) subman.get(index);
         OrganizacionVO organizacion =new OrganizacionVO();
         organizacion.setTitle(sesOrga.getTitle());
         organizacion.setIdentifier(sesOrga.getIdentifier());
         
         GrupoVO[] grupos =	null;
         organizacion.setGrupos(grupos);
         String identificador=(index==0?sesEmpaq.getIdLocalizador():submanifestPath.getIdentifier());
         
    	 if(sesOrga.isEsModificar())
    	 {
    		 this.getSrvGestorManifestService().modificarOrganizacion(identificador, organizacion);
    	 }	
    	 else
    	 {
        		 this.getSrvGestorManifestService().crearOrganizacion(identificador, organizacion);
    	 }
    	
    }



    public final void submit(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.crear.SubmitForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	CrearOrganizacionSession sesOrga=this.getCrearOrganizacionSession(request);
    	
    	String titulo = form.getTitle();
    	titulo=titulo.trim();
    	java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		String action = form.getAction();
		if (action.equals(i18n.getString("portal_empaquetado_crearOrganizaciones.aceptar"))) 
		{
			if((titulo==null)||(titulo.equals("")))
			{
				throw new ValidatorException("{portal_empaquetado.exception}");
			}
			
		}
		sesOrga.setTitle(titulo);
     }


    public final java.lang.String selectAction(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.crear.SelectActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
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
			
		
		else if (actionSubmit.equals(i18n.getString("portal_empaquetado_crearOrganizaciones.aceptar"))) 
		{
			result = "Aceptar";
		} 
		else if (actionSubmit.equals(i18n.getString("portal_empaquetado_crearOrganizaciones.cancelar"))) {
			result = "Cancelar";
		} 
		
		else if (actionSubmit.equals(i18n.getString("portal_empaquetado_crearOrganizaciones.metadatos"))) 
		{
			result = "Metadatos";
		} 
		Logger.getLogger(this.getClass()).error("El valor del submit no es correcto (actionSubmit = "
							+ actionSubmit + ";");
       
         return result;
    }

    public final void recuperarDatos(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.crear.RecuperarDatosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
       CrearOrganizacionSession sesOrga=this.getCrearOrganizacionSession(request);
    	String identificador=form.getIdentifier();
    	// Lo uso para comprobar si vengo de catalogacion
    	CatalogacionBean cb = new CatalogacionBean();
    	cb.setIdentifier(sesOrga.getIdentifier());
    	List pendientes = this.getEmpaquetadorSession(request).getPendientesCatalogacion();
    	if((identificador!=null))
    	{
    		if(logger.isDebugEnabled()) logger.debug("RecuperarDatos: Modificando organizacion " + form.getIdentifier());
    		sesOrga.setEsModificar(true);
    		sesOrga.setIdentifier(identificador);
    		
    		EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
	    	List subman = sesEmpaq.getSubmanifestPath();
	      	
	        OdeVO submanifestPath=(OdeVO) subman.get(subman.size()-1);
	        OrganizacionVO[] organizaciones = submanifestPath.getOrganizaciones();
	        boolean encontrado=false;
	        for(int i=0;(encontrado==false && i<organizaciones.length);i++)
	        {
	        	if(organizaciones[i].getIdentifier().equals(identificador))
	        	{
	        		sesOrga.setTitle(organizaciones[i].getTitle());
	        		form.setTitle(organizaciones[i].getTitle());
	        		encontrado=true;
	        	}
	        }
     	}
    	else if(sesOrga.getIdentifier()!= null && pendientes.contains(cb)) {
    		// vengo de añadir un metadato a la nueva organizacion
    		if(logger.isDebugEnabled()) logger.debug("RecuperarDatos no realiza acción ninguna. Viene de añadir un metadato");
    	}
    	else
    	{
    		if(logger.isDebugEnabled()) logger.debug("RecuperarDatos: Creando nueva organizacion");
    		String identificadorNuevo=PodeUUIDGenerator.getOrganizacionUUID(this.getClass().toString());
    		sesOrga.setEsModificar(false);
    		sesOrga.setIdentifier(identificadorNuevo);
    		sesOrga.setTitle(null);
    	}
    	
     }


}