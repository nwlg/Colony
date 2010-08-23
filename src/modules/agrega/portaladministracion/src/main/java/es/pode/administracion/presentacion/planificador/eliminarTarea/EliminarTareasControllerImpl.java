/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.planificador.eliminarTarea;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;


import es.pode.planificador.negocio.servicios.TrabajoVO;


/**
 * @see es.pode.administracion.presentacion.planificador.eliminarTarea.EliminarTareasController
 */
public class EliminarTareasControllerImpl extends EliminarTareasController
{
	private static Logger log = Logger.getLogger(EliminarTareasControllerImpl.class);

 
	public void eliminarTareasAdm(ActionMapping mapping, EliminarTareasAdmForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		    	
		TrabajoVO[] trabajos = null;
		Boolean resultado;
		String resultadoString = null;
		String mensaje = null;
		
    	//String listaTrabajo = request.getParameter("listaTrabajo");
		String[] nombresTrabajoArray = form.getListaTrabajoPlana().split("#");
		
		ResourceBundle ficheroRecursos = null;
		
      	try
    	{   
      		
      		Locale locale = request.getLocale();
		    ficheroRecursos = this.getFicheroRecursos(locale);
		    
		    trabajos = new TrabajoVO[nombresTrabajoArray.length];
		    for(int i=0; i < nombresTrabajoArray.length;i++)
		    {
		    	trabajos[i] = new TrabajoVO();
		    	trabajos[i].setTrabajo(nombresTrabajoArray[i]);
		    }
		    
	    	resultado = this.getSrvPlanificadorService().eliminarTareasAdm(trabajos);
	    	
	    	if(resultado.booleanValue() == true)
	    	{
	    		mensaje = ficheroRecursos.getString("eliminarTareasPendientes.tareasEliminadasOk");
	    		resultadoString = ficheroRecursos.getString("tareas.OK");
	    	}
	    	else if(resultado.booleanValue() == false)
	    	{
	    		mensaje = ficheroRecursos.getString("eliminarTareasPendientes.tareasEliminadasError");
	    		resultadoString = ficheroRecursos.getString("tareas.ERROR");
	    	}
	    	
	    	form.setDescripcionBaja(mensaje);
	    	form.setResultado(resultadoString);
      		
        }
        catch (Exception e)
        {
        	log.error("Error: " + e);
        	throw new ValidatorException("{tareas.error}");
        }		
	}
	
	 public void obtenerTareas(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.eliminarTarea.ObtenerTareasForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
	 {
		Object[] sTrabajo;
		String[] listadoTrabajo = null;
		String listaTrabajoPlana = "";
	  
      	try
    	{   
     		sTrabajo = (Object[])form.getTrabajosAsArray(); 
     		listadoTrabajo = new String[sTrabajo.length];
     		
      		//Construimos la lista de nombres de las tareas que se van a eliminar
    		for (int i=0; i< sTrabajo.length; i++)
    		{
    			listadoTrabajo[i] = new String();
    			listadoTrabajo[i] = sTrabajo[i].toString();
    			if(i == sTrabajo.length)
    				listaTrabajoPlana = listaTrabajoPlana + (String)sTrabajo[i];
    			else
    				listaTrabajoPlana = listaTrabajoPlana + (String)sTrabajo[i] + "#";
    		}
    		
    		
    		log.debug("lista de trabajos a eliminar: " + listadoTrabajo);
    		form.setListaTrabajo(listadoTrabajo);
    		form.setListaTrabajoPlana(listaTrabajoPlana);
      		
        }
        catch (Exception e)
        {
        	log.error("Error: " + e);
        	throw new ValidatorException("{tareas.error}");
        }		
	 }
	 
	 
	 private ResourceBundle getFicheroRecursos(Locale locale) 
	 {
		ResourceBundle ficheroRecursos = null;
		ficheroRecursos = ResourceBundle.getBundle("application-resources", locale);
		return ficheroRecursos;
	 }
}