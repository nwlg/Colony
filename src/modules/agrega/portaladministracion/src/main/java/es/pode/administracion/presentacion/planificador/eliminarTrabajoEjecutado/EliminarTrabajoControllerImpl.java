/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.planificador.eliminarTrabajoEjecutado;



import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;




public class EliminarTrabajoControllerImpl extends EliminarTrabajoController
{
	private static Logger log = Logger.getLogger(EliminarTrabajoControllerImpl.class);

	
	/**
	 * metodo que obtiene los trabajos que se han seleccionado para eliminar
	 */
	public final void obtenerTrabajos(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.eliminarTrabajoEjecutado.ObtenerTrabajosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
	{
		String[] arrayIds;
	    String listaIds = "";
	    String nombreServidor = "";
	    String[] arrayNombreServidor;
	    
      	try
    	{   
      		
     		arrayIds = (String[])form.getIdsAsArray(); 
     		String[] listaNombres = new String[arrayIds.length];
     		
      		//Construimos el array de nombres
    		for (int i=0; i< arrayIds.length; i++)
    		{
    			nombreServidor = this.getSrvPlanificadorService().obtenerTrabajoEjecutado(new Long(arrayIds[i])).getTrabajo();
    			arrayNombreServidor = nombreServidor.split("!!");
    			
    			listaNombres[i] = new String();
    			listaNombres[i] = arrayNombreServidor[0];
    			log.debug("trabajo a eliminar: " + listaNombres[i]);
    			listaIds = listaIds + arrayIds[i] + "#";
    			
    		}
    		
    		form.setListaIds(listaIds);
    		form.setListaNombres(listaNombres);
      		
        }
        catch (Exception e)
        {
        	log.error("Error: " + e);
        	throw new ValidatorException("{tareas.error}");
        }		
	}
	
	
	/**
	 * metodo que elimina los trabajos seleccionados
	 */
    public final void eliminarTrabajoEjecutado(ActionMapping mapping, EliminarTrabajoEjecutadoForm form, 
    		HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	Long[] trabajosIDs = null;
		Boolean resultado;
		String resultadoString = null;
		String mensaje = null;
		
		
		
    	String listaID = form.getListaIds();
    	if(log.isDebugEnabled())log.debug("los nombres de tareas que se quieren eliminar son " + listaID);
    	
		String[] cadenaIds = listaID.split("#");
		trabajosIDs = new Long[cadenaIds.length];
		
		for (int i = 0; i < cadenaIds.length; i++) 
		{
			trabajosIDs[i] = new Long(cadenaIds[i]);
		}
		
		
		ResourceBundle ficheroRecursos = null;
		
      	try
    	{   
      		
      		Locale locale = request.getLocale();
		    ficheroRecursos = this.getFicheroRecursos(locale);
		    
		    
	    	resultado = this.getSrvPlanificadorService().eliminarTrabajoEjecutado(trabajosIDs);
	    	
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
    

    
    private ResourceBundle getFicheroRecursos(Locale locale) 
	 {
		ResourceBundle ficheroRecursos = null;
		ficheroRecursos = ResourceBundle.getBundle("application-resources", locale);
		return ficheroRecursos;
	 }
    
}