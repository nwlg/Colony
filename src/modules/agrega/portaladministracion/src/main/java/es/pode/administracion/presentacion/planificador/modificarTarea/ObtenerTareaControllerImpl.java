/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.planificador.modificarTarea;


import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import es.pode.administracion.presentacion.planificador.comun.Utiles;
import es.pode.planificador.negocio.servicios.TareaCargaODEsVO;
import es.pode.planificador.negocio.servicios.TareaEliminaNoDisponiblesVO;
import es.pode.planificador.negocio.servicios.TareaInformesVO;
import es.pode.planificador.negocio.servicios.TareaReindexadoVO;
import es.pode.planificador.negocio.servicios.TareaVO;
import es.pode.planificador.negocio.servicios.TrabajoVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;


public class ObtenerTareaControllerImpl extends ObtenerTareaController
{
	private static Logger log = Logger.getLogger(ObtenerTareaControllerImpl.class);
	private static TimeZone tz = null;
	Utiles utilidades = new Utiles();
	private Properties pSpringProperties = null;
	
	
	
	/**
     * Metodo que optiene cual es la tarea que se va a modificar y bifurcara a ese tipo concreto
     */
    public final java.lang.String obtenerTipoTarea(ActionMapping mapping, ObtenerTipoTareaForm form, 
    		HttpServletRequest request, HttpServletResponse response) throws Exception
    {
		String tipoTarea = null;
		String tipoTareaDevolver = null;
		
	    try
	    {	
	    	//obtenemos el tipoTarea
	        TrabajoVO trabajo = new TrabajoVO();
	        
	        trabajo.setTrabajo(form.getTrabajo());
	        trabajo.setGrupoTrabajo(form.getGrupoTrabajo());
	        trabajo.setUsuario(LdapUserDetailsUtils.getUsuario());
	        
	        tipoTarea = this.getSrvPlanificadorService().obtenerTipoTarea(trabajo); 
	        
	        
	        //si la tarea es Generar informes comprobamos de que informe se trata y si no se devuleve la tarea que venga(cargaOdes, reindexado o eliminarODes)
	        if(tipoTarea.equalsIgnoreCase("GenerarInforme"))
	        {
	        	//obtenemos el tipo de informe
		        TareaInformesVO tarea = new TareaInformesVO();
		        
		        tarea.setTrabajo(form.getTrabajo());
		        tarea.setGrupoTrabajo(form.getGrupoTrabajo());
		        tarea.setTrigger(form.getTrigger());
		        tarea.setGrupoTrigger(form.getGrupoTrigger());
		        
		        TareaInformesVO tareaInformes = this.getSrvPlanificadorService().obtenerTareaInformes(tarea);
		        String informe = tareaInformes.getInforme();
	        
		        //si el tipoTarea es de informes debemos mirar que informe concreto es para redirigirnos a una de las 3 pantallas de informes
		        if(log.isDebugEnabled())log.debug("estamos dentro de generar informe");
	        	if(informe.equalsIgnoreCase("estadoOdes") || informe.equalsIgnoreCase("operacionesRealizadas") || 
	        			informe.equalsIgnoreCase("nivelAgregacion") || informe.equalsIgnoreCase("coberturaCurricular") || 
	        			informe.equalsIgnoreCase("odesLicencias") || informe.equalsIgnoreCase("usuarios") || 
	        			informe.equalsIgnoreCase("procesosPlanificados"))
		        {
	        		if(log.isDebugEnabled())log.debug("cargo informe con fechas");	
		        	tipoTareaDevolver = "InformeFecha";
		        }
	        	
	        	else if(informe.equalsIgnoreCase("terminosBusqueda") ||  informe.equalsIgnoreCase("masValorado") || 
		        		informe.equalsIgnoreCase("masMostrado") || informe.equalsIgnoreCase("masPrevisualizado") || 
		        		informe.equalsIgnoreCase("masVisualizado") || informe.equalsIgnoreCase("masDescargado") || 
		        		informe.equalsIgnoreCase("tamanio"))
		        {
		        	if(log.isDebugEnabled())log.debug("cargo informe con rango");
		        	tipoTareaDevolver = "InformeFechaRango";
		        }
	        	
		        else if(informe.equalsIgnoreCase("odesUsuario"))
		        {
		        	if(log.isDebugEnabled())log.debug("cargo informe con usuario");
		        	tipoTareaDevolver = "InformeFechaUsuario";
		        }
	        	
		    }
	        
	        //si el tipo de informe es federado
	        else if(tipoTarea.equalsIgnoreCase("GenerarInformeFederado"))
	        {
        			tipoTareaDevolver = "InformeFederado";
	        }
	        
	        //si el tipo es informe de catalogo
	        else if(tipoTarea.equalsIgnoreCase("InformeCatalogo"))
	        {
	        	tipoTareaDevolver = "InformeCatalogo";
	        }
	        
	        //Si el tipoTarea es Reindexado, carga ODEs o eliminar ODEs el tipo tarea se mantiene
	        else
    			tipoTareaDevolver = tipoTarea;
	        
	        if(log.isDebugEnabled())log.debug("tipoTarea -> " + tipoTarea);
	        
	    }
	    catch (Exception e)
	    {
	    	log.error("Error: " + e);
        	throw new ValidatorException("{tareas.error}");
	    }
	
	    log.debug("tipoTarea: " + tipoTarea);
		return tipoTareaDevolver;
    }
    
    
    
    
    /**
     * ******************************			METODOS DE OBTENCION DE LA TAREA			****************************************
     */
    
    
    
    
    /**
     * Metodo que obtiene los datos de la tarea de carga de odes que se selecciona
     */
    public final void obtenerTareaModificarCargaODEs(ActionMapping mapping, ObtenerTareaModificarCargaODEsForm form, 
    		HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	
    	if (tz == null) 
    		tz = utilidades.asignarZonaHoraria();
    	
    	TareaVO tarea = new TareaVO();
 	 
    	try
        {       		   		
       		
    		//cargamos la tarea con lo valores esenciales para recuperar los demas valores de esta misma tarea 
    		tarea.setTrabajo(((ObtenerTCargaODEsFormImpl) form).getTrabajo());
    		tarea.setGrupoTrabajo(((ObtenerTCargaODEsFormImpl) form).getGrupoTrabajo());
    		tarea.setTrigger(((ObtenerTCargaODEsFormImpl) form).getTrigger());
    		tarea.setGrupoTrigger(((ObtenerTCargaODEsFormImpl) form).getGrupoTrigger());
    		tarea.setPeriodicidad(((ObtenerTCargaODEsFormImpl) form).getPeriodicidad());
    		
    		//llamamos al servicio para que carge los valores en la tarea del tipo correspondiente
    		TareaCargaODEsVO tareaCargaODEs = this.getSrvPlanificadorService().obtenerTareaModificarCargaODEs(tarea);
    	
    		//asignamos a las fechas la franja horaria correspondiente
    		tareaCargaODEs.getFechaInicio().setTimeZone(tz);

       		//rellenamos los datos especificos de este tipo de tarea
    		((ObtenerTCargaODEsFormImpl) form).setPeriodicidad(tareaCargaODEs.getPeriodicidad());
    		((ObtenerTCargaODEsFormImpl) form).setPathODEs(tareaCargaODEs.getPathODE());
    		((ObtenerTCargaODEsFormImpl) form).setPathODEsCarg(tareaCargaODEs.getPathODEsCargados());
    		((ObtenerTCargaODEsFormImpl) form).setPathODEsNoCarg(tareaCargaODEs.getPathODEsNoCargados());
    		((ObtenerTCargaODEsFormImpl) form).setTipoTarea(tareaCargaODEs.getTipoTarea());
    		int anio = (tareaCargaODEs.getFechaInicio().get(Calendar.YEAR));
    		Integer anioI = new Integer(anio);
    		anioI.toString();
    		
    		((ObtenerTCargaODEsFormImpl) form).setAnio((new Integer (tareaCargaODEs.getFechaInicio().get(Calendar.YEAR))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMes((new Integer (tareaCargaODEs.getFechaInicio().get(Calendar.MONTH) + 1)).toString());
    		((ObtenerTCargaODEsFormImpl) form).setDia((new Integer (tareaCargaODEs.getFechaInicio().get(Calendar.DAY_OF_MONTH))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setHora((new Integer (tareaCargaODEs.getFechaInicio().get(Calendar.HOUR_OF_DAY))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMinutos((new Integer (tareaCargaODEs.getFechaInicio().get(Calendar.MINUTE))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMsgPublicado(tareaCargaODEs.getMsgPublicado());
    		((ObtenerTCargaODEsFormImpl) form).setMsgNoPublicado(tareaCargaODEs.getMsgNoPublicado());
    		((ObtenerTCargaODEsFormImpl) form).setMsgDescCargaODEs(tareaCargaODEs.getMsgDescripcionTrabajo());
    		((ObtenerTCargaODEsFormImpl) form).setSobrescribir(tareaCargaODEs.getSobrescribir());

        }
        catch (Exception e)
        {
        	log.error("Error: " + e);
        	throw new ValidatorException("{tareas.error}");
        }	
    }

    
    /**
     * Metodo que obtiene los datos de la tarea de reindexado que se selecciona
     */
    public final void obtenerTareaReindexado(ActionMapping mapping, ObtenerTareaReindexadoForm form, 
    		HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    
    	if (tz == null) 
    		tz = utilidades.asignarZonaHoraria();
    	
    	TareaVO tarea = new TareaVO();
    	
    	try
        {    	
       		
    		//cargamos la tarea con lo valores esenciales para recuperar los demas valores de esta misma tarea 
    		tarea.setTrabajo(((ObtenerTCargaODEsFormImpl) form).getTrabajo());
    		tarea.setGrupoTrabajo(((ObtenerTCargaODEsFormImpl) form).getGrupoTrabajo());
    		tarea.setTrigger(((ObtenerTCargaODEsFormImpl) form).getTrigger());
    		tarea.setGrupoTrigger(((ObtenerTCargaODEsFormImpl) form).getGrupoTrigger());
    		tarea.setPeriodicidad(((ObtenerTCargaODEsFormImpl) form).getPeriodicidad());
    		
    		//llamamos al servicio para que carge los valores en la tarea del tipo correspondiente
    		TareaReindexadoVO tareaReindexado = this.getSrvPlanificadorService().obtenerTareaReindexado(tarea);
    		
    		//asignamos a las fechas la franja horaria correspondiente
    		tareaReindexado.getFechaInicio().setTimeZone(tz);
    		
    		//rellenamos los datos especificos de este tipo de tarea
    		((ObtenerTCargaODEsFormImpl) form).setPeriodicidad(tareaReindexado.getPeriodicidad());
    		((ObtenerTCargaODEsFormImpl) form).setRepositorio(tareaReindexado.getRepositorioIndices());
    		((ObtenerTCargaODEsFormImpl) form).setTipoTarea(tareaReindexado.getTipoTarea());    		
    		((ObtenerTCargaODEsFormImpl) form).setAnio((new Integer (tareaReindexado.getFechaInicio().get(Calendar.YEAR))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMes((new Integer (tareaReindexado.getFechaInicio().get(Calendar.MONTH) + 1)).toString());
    		((ObtenerTCargaODEsFormImpl) form).setDia((new Integer (tareaReindexado.getFechaInicio().get(Calendar.DAY_OF_MONTH))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setHora((new Integer (tareaReindexado.getFechaInicio().get(Calendar.HOUR_OF_DAY))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMinutos((new Integer (tareaReindexado.getFechaInicio().get(Calendar.MINUTE))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMsgReindexado(tareaReindexado.getMsgReindexado());
    		((ObtenerTCargaODEsFormImpl) form).setMsgNoReindexado(tareaReindexado.getMsgNoReindexado());
    		((ObtenerTCargaODEsFormImpl) form).setMsgDescReindexado(tareaReindexado.getMsgDescripcionTrabajo());
        }
        catch (Exception e)
        {
        	log.error("Error: " + e);
        	throw new ValidatorException("{tareas.error}");
        }	
    }
    
    
    
    /**
     * Metodo que obtiene los datos de la tarea de eliminar odes que se selecciona
     */
    public void obtenerTareaNoDisponible(org.apache.struts.action.ActionMapping mapping, 
			es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaNoDisponibleForm form, 
			javax.servlet.http.HttpServletRequest request, 
			javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
	{
	
    
    	if (tz == null) 
    		tz = utilidades.asignarZonaHoraria();
    	
    	TareaVO tarea = new TareaVO();
    	
    	try
        {    	
       		
    		//cargamos la tarea con lo valores esenciales para recuperar los demas valores de esta misma tarea 
    		tarea.setTrabajo(((ObtenerTCargaODEsFormImpl) form).getTrabajo());
    		tarea.setGrupoTrabajo(((ObtenerTCargaODEsFormImpl) form).getGrupoTrabajo());
    		tarea.setTrigger(((ObtenerTCargaODEsFormImpl) form).getTrigger());
    		tarea.setGrupoTrigger(((ObtenerTCargaODEsFormImpl) form).getGrupoTrigger());
    		tarea.setPeriodicidad(((ObtenerTCargaODEsFormImpl) form).getPeriodicidad());
    		
    		//llamamos al servicio para que carge los valores en la tarea del tipo correspondiente
    		TareaEliminaNoDisponiblesVO tareaEliminarODEs = this.getSrvPlanificadorService().obtenerTareaEliminarrNoDisponibles(tarea);
    		
    		//asignamos a las fechas la franja horaria correspondiente
    		tareaEliminarODEs.getFechaInicio().setTimeZone(tz);
    		tareaEliminarODEs.getFechaDesde().setTimeZone(tz);
    		tareaEliminarODEs.getFechaHasta().setTimeZone(tz);
    		
    		//rellenamos los datos especificos de este tipo de tarea
    		((ObtenerTCargaODEsFormImpl) form).setPeriodicidad(tareaEliminarODEs.getPeriodicidad());
    		((ObtenerTCargaODEsFormImpl) form).setTipoTarea(tareaEliminarODEs.getTipoTarea());    		
    		((ObtenerTCargaODEsFormImpl) form).setAnio((new Integer (tareaEliminarODEs.getFechaInicio().get(Calendar.YEAR))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMes((new Integer (tareaEliminarODEs.getFechaInicio().get(Calendar.MONTH) + 1)).toString());
    		((ObtenerTCargaODEsFormImpl) form).setDia((new Integer (tareaEliminarODEs.getFechaInicio().get(Calendar.DAY_OF_MONTH))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setHora((new Integer (tareaEliminarODEs.getFechaInicio().get(Calendar.HOUR_OF_DAY))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMinutos((new Integer (tareaEliminarODEs.getFechaInicio().get(Calendar.MINUTE))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setDiaDesde((new Integer (tareaEliminarODEs.getFechaDesde().get(Calendar.DAY_OF_MONTH))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMesDesde((new Integer (tareaEliminarODEs.getFechaDesde().get(Calendar.MONTH) + 1)).toString());
    		((ObtenerTCargaODEsFormImpl) form).setAnioDesde((new Integer (tareaEliminarODEs.getFechaDesde().get(Calendar.YEAR))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setDiaHasta((new Integer (tareaEliminarODEs.getFechaHasta().get(Calendar.DAY_OF_MONTH))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMesHasta((new Integer (tareaEliminarODEs.getFechaHasta().get(Calendar.MONTH) + 1)).toString());
    		((ObtenerTCargaODEsFormImpl) form).setAnioHasta((new Integer (tareaEliminarODEs.getFechaHasta().get(Calendar.YEAR))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMsgEliminado(tareaEliminarODEs.getMsgEliminado());
    		((ObtenerTCargaODEsFormImpl) form).setMsgNoEliminado(tareaEliminarODEs.getMsgNoEliminado());
    		((ObtenerTCargaODEsFormImpl) form).setMsgDescTrabajo(tareaEliminarODEs.getMsgDescripcionTrabajo());
        }
        catch (Exception e)
        {
        	log.error("Error: " + e);
        	throw new ValidatorException("{tareas.error}");
        }	
	}
    
    
    /**
     * Metodo que obtiene los datos de la tarea de informeFecha que se selecciona
     */
    public void obtenerTareaInformeFecha(org.apache.struts.action.ActionMapping mapping, 
    		es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaInformeFechaForm form, 
    		javax.servlet.http.HttpServletRequest request, 
    		javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	
    	
    	if (tz == null) 
    		tz = utilidades.asignarZonaHoraria();
    	
    	TareaInformesVO tarea = new TareaInformesVO();
    	
    	try
        {    	
       		
    		//cargamos la tarea con lo valores esenciales para recuperar los demas valores de esta misma tarea
    		tarea.setTrabajo(((ObtenerTCargaODEsFormImpl) form).getTrabajo());
    		tarea.setGrupoTrabajo(((ObtenerTCargaODEsFormImpl) form).getGrupoTrabajo());
    		tarea.setTrigger(((ObtenerTCargaODEsFormImpl) form).getTrigger());
    		tarea.setGrupoTrigger(((ObtenerTCargaODEsFormImpl) form).getGrupoTrigger());
    		tarea.setPeriodicidad(((ObtenerTCargaODEsFormImpl) form).getPeriodicidad());
    		
    		//llamamos al servicio para que carge los valores en la tarea del tipo correspondiente
    		TareaInformesVO tareaInformes = this.getSrvPlanificadorService().obtenerTareaInformes(tarea);
			
			//Si tiene periodicidad no se obtienen las fechas Desde y Hasta
			if(tareaInformes.getPeriodicidad().equalsIgnoreCase("N"))
			{
				if(log.isDebugEnabled())log.debug(tareaInformes + "No es periodica");
				
				//asignamos a la fecha Desde y Hasta la franja horaria correspondiente
				tareaInformes.getFechaDesde().setTimeZone(tz);
				tareaInformes.getFechaHasta().setTimeZone(tz);
				
				((ObtenerTCargaODEsFormImpl) form).setDiaDesde((new Integer (tareaInformes.getFechaDesde().get(Calendar.DAY_OF_MONTH))).toString());
				((ObtenerTCargaODEsFormImpl) form).setMesDesde((new Integer (tareaInformes.getFechaDesde().get(Calendar.MONTH) + 1)).toString());
				((ObtenerTCargaODEsFormImpl) form).setAnioDesde((new Integer (tareaInformes.getFechaDesde().get(Calendar.YEAR))).toString());
				((ObtenerTCargaODEsFormImpl) form).setDiaHasta((new Integer (tareaInformes.getFechaHasta().get(Calendar.DAY_OF_MONTH))).toString());
				((ObtenerTCargaODEsFormImpl) form).setMesHasta((new Integer (tareaInformes.getFechaHasta().get(Calendar.MONTH) + 1)).toString());
				((ObtenerTCargaODEsFormImpl) form).setAnioHasta((new Integer (tareaInformes.getFechaHasta().get(Calendar.YEAR))).toString());
			}
			else
			{
				if(log.isDebugEnabled())log.debug(tareaInformes + "Es periodica");
			}
    		
    		//asignamos a la fecha inicio la franja horaria correspondiente
    		tareaInformes.getFechaInicio().setTimeZone(tz);
			
    		//rellenamos los datos especificos de este tipo de tarea
    		((ObtenerTCargaODEsFormImpl) form).setPeriodicidad(tareaInformes.getPeriodicidad());
    		((ObtenerTCargaODEsFormImpl) form).setTipoTarea(tareaInformes.getInforme());
    		((ObtenerTCargaODEsFormImpl) form).setFormato(tareaInformes.getFormato());
    		((ObtenerTCargaODEsFormImpl) form).setInforme(tareaInformes.getInforme());
    		((ObtenerTCargaODEsFormImpl) form).setAnio((new Integer (tareaInformes.getFechaInicio().get(Calendar.YEAR))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMes((new Integer (tareaInformes.getFechaInicio().get(Calendar.MONTH) + 1)).toString());
    		((ObtenerTCargaODEsFormImpl) form).setDia((new Integer (tareaInformes.getFechaInicio().get(Calendar.DAY_OF_MONTH))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setHora((new Integer (tareaInformes.getFechaInicio().get(Calendar.HOUR_OF_DAY))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMinutos((new Integer (tareaInformes.getFechaInicio().get(Calendar.MINUTE))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMsgInforme(tareaInformes.getMsgInforme());
    		((ObtenerTCargaODEsFormImpl) form).setMsgNoInforme(tareaInformes.getMsgNoInforme());
    		((ObtenerTCargaODEsFormImpl) form).setMsgDescTrabajo(tareaInformes.getMsgDescripcionTrabajo());
        }
        catch (Exception e)
        {
        	log.error("Error: " + e);
        	throw new ValidatorException("{tareas.error}");
        }	
    }

    
    /**
     * Metodo que obtiene los datos de la tarea de informeFechaRango que se selecciona
     */
    public void obtenerTareaInformeFechaRango(org.apache.struts.action.ActionMapping mapping, 
    		es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaInformeFechaRangoForm form, 
    		javax.servlet.http.HttpServletRequest request, 
    		javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	
    	if (tz == null) 
    		tz = utilidades.asignarZonaHoraria();
    	
    	TareaInformesVO tarea = new TareaInformesVO();
    	
    	try
        {    	
       		
    		//cargamos la tarea con lo valores esenciales para recuperar los demas valores de esta misma tarea
    		tarea.setTrabajo(((ObtenerTCargaODEsFormImpl) form).getTrabajo());
    		tarea.setGrupoTrabajo(((ObtenerTCargaODEsFormImpl) form).getGrupoTrabajo());
    		tarea.setTrigger(((ObtenerTCargaODEsFormImpl) form).getTrigger());
    		tarea.setGrupoTrigger(((ObtenerTCargaODEsFormImpl) form).getGrupoTrigger());
    		tarea.setPeriodicidad(((ObtenerTCargaODEsFormImpl) form).getPeriodicidad());
    		
    		//llamamos al servicio para que carge los valores en la tarea del tipo correspondiente
    		TareaInformesVO tareaInformes = this.getSrvPlanificadorService().obtenerTareaInformes(tarea);
			
    		//Si tiene periodicidad no se obtienen las fechas Desde y Hasta
			if(tareaInformes.getPeriodicidad().equalsIgnoreCase("N"))
			{
				if(log.isDebugEnabled())log.debug(tareaInformes + "No es periodica");
				
				//asignamos a la fecha Desde y Hasta la franja horaria correspondiente
				tareaInformes.getFechaDesde().setTimeZone(tz);
				tareaInformes.getFechaHasta().setTimeZone(tz);
				
				((ObtenerTCargaODEsFormImpl) form).setDiaDesde((new Integer (tareaInformes.getFechaDesde().get(Calendar.DAY_OF_MONTH))).toString());
				((ObtenerTCargaODEsFormImpl) form).setMesDesde((new Integer (tareaInformes.getFechaDesde().get(Calendar.MONTH) + 1)).toString());
				((ObtenerTCargaODEsFormImpl) form).setAnioDesde((new Integer (tareaInformes.getFechaDesde().get(Calendar.YEAR))).toString());
				((ObtenerTCargaODEsFormImpl) form).setDiaHasta((new Integer (tareaInformes.getFechaHasta().get(Calendar.DAY_OF_MONTH))).toString());
				((ObtenerTCargaODEsFormImpl) form).setMesHasta((new Integer (tareaInformes.getFechaHasta().get(Calendar.MONTH) + 1)).toString());
				((ObtenerTCargaODEsFormImpl) form).setAnioHasta((new Integer (tareaInformes.getFechaHasta().get(Calendar.YEAR))).toString());
			}
			else
			{
				if(log.isDebugEnabled())log.debug(tareaInformes + "Es periodica");
			}
			
			//asignamos a las fechas la franja horaria correspondiente
    		tareaInformes.getFechaInicio().setTimeZone(tz);
    		
    		//rellenamos los datos especificos de este tipo de tarea
    		((ObtenerTCargaODEsFormImpl) form).setPeriodicidad(tareaInformes.getPeriodicidad());
    		((ObtenerTCargaODEsFormImpl) form).setTipoTarea(tareaInformes.getInforme());
    		((ObtenerTCargaODEsFormImpl) form).setFormato(tareaInformes.getFormato());
    		((ObtenerTCargaODEsFormImpl) form).setInforme(tareaInformes.getInforme());
    		((ObtenerTCargaODEsFormImpl) form).setRango(tareaInformes.getRango());
    		((ObtenerTCargaODEsFormImpl) form).setAnio((new Integer (tareaInformes.getFechaInicio().get(Calendar.YEAR))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMes((new Integer (tareaInformes.getFechaInicio().get(Calendar.MONTH) + 1)).toString());
    		((ObtenerTCargaODEsFormImpl) form).setDia((new Integer (tareaInformes.getFechaInicio().get(Calendar.DAY_OF_MONTH))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setHora((new Integer (tareaInformes.getFechaInicio().get(Calendar.HOUR_OF_DAY))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMinutos((new Integer (tareaInformes.getFechaInicio().get(Calendar.MINUTE))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMsgReindexado(tareaInformes.getMsgInforme());
    		((ObtenerTCargaODEsFormImpl) form).setMsgNoReindexado(tareaInformes.getMsgNoInforme());
    		((ObtenerTCargaODEsFormImpl) form).setMsgDescReindexado(tareaInformes.getMsgDescripcionTrabajo());
        }
        catch (Exception e)
        {
        	log.error("Error: " + e);
        	throw new ValidatorException("{tareas.error}");
        }
        
    }

    
    /**
     * Metodo que obtiene los datos de la tarea de informeFechaUsuario que se selecciona
     */
    public void obtenerTareaInformeFechaUsuario(org.apache.struts.action.ActionMapping mapping, 
    		es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaInformeFechaUsuarioForm form, 
    		javax.servlet.http.HttpServletRequest request, 
    		javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	
    	
    	if (tz == null) 
    		tz = utilidades.asignarZonaHoraria();
    	
    	TareaInformesVO tarea = new TareaInformesVO();
    	
    	try
        {    	
       		
    		//cargamos la tarea con lo valores esenciales para recuperar los demas valores de esta misma tarea
    		tarea.setTrabajo(((ObtenerTCargaODEsFormImpl) form).getTrabajo());
    		tarea.setGrupoTrabajo(((ObtenerTCargaODEsFormImpl) form).getGrupoTrabajo());
    		tarea.setTrigger(((ObtenerTCargaODEsFormImpl) form).getTrigger());
    		tarea.setGrupoTrigger(((ObtenerTCargaODEsFormImpl) form).getGrupoTrigger());
    		tarea.setPeriodicidad(((ObtenerTCargaODEsFormImpl) form).getPeriodicidad());
    		
    		//llamamos al servicio para que carge los valores en la tarea del tipo correspondiente
    		TareaInformesVO tareaInformes = this.getSrvPlanificadorService().obtenerTareaInformes(tarea);
			
			//Si tiene periodicidad no se obtienen las fechas Desde y Hasta
			if(tareaInformes.getPeriodicidad().equalsIgnoreCase("N"))
			{
				if(log.isDebugEnabled())log.debug(tareaInformes + "No es periodica");
				
				//asignamos a la fecha Desde y Hasta la franja horaria correspondiente
				tareaInformes.getFechaDesde().setTimeZone(tz);
				tareaInformes.getFechaHasta().setTimeZone(tz);
				
				((ObtenerTCargaODEsFormImpl) form).setDiaDesde((new Integer (tareaInformes.getFechaDesde().get(Calendar.DAY_OF_MONTH))).toString());
				((ObtenerTCargaODEsFormImpl) form).setMesDesde((new Integer (tareaInformes.getFechaDesde().get(Calendar.MONTH) + 1)).toString());
				((ObtenerTCargaODEsFormImpl) form).setAnioDesde((new Integer (tareaInformes.getFechaDesde().get(Calendar.YEAR))).toString());
				((ObtenerTCargaODEsFormImpl) form).setDiaHasta((new Integer (tareaInformes.getFechaHasta().get(Calendar.DAY_OF_MONTH))).toString());
				((ObtenerTCargaODEsFormImpl) form).setMesHasta((new Integer (tareaInformes.getFechaHasta().get(Calendar.MONTH) + 1)).toString());
				((ObtenerTCargaODEsFormImpl) form).setAnioHasta((new Integer (tareaInformes.getFechaHasta().get(Calendar.YEAR))).toString());
			}
			else
			{
				if(log.isDebugEnabled())log.debug(tareaInformes + "Es periodica");
			}
    		
			//asignamos a las fechas la franja horaria correspondiente
    		tareaInformes.getFechaInicio().setTimeZone(tz);
			
    		//rellenamos los datos especificos de este tipo de tarea
    		((ObtenerTCargaODEsFormImpl) form).setPeriodicidad(tareaInformes.getPeriodicidad());
    		((ObtenerTCargaODEsFormImpl) form).setTipoTarea(tareaInformes.getInforme());
    		((ObtenerTCargaODEsFormImpl) form).setFormato(tareaInformes.getFormato());
    		((ObtenerTCargaODEsFormImpl) form).setInforme(tareaInformes.getInforme());
    		((ObtenerTCargaODEsFormImpl) form).setUsuario(tareaInformes.getUsuarioInforme());
    		((ObtenerTCargaODEsFormImpl) form).setAnio((new Integer (tareaInformes.getFechaInicio().get(Calendar.YEAR))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMes((new Integer (tareaInformes.getFechaInicio().get(Calendar.MONTH) + 1)).toString());
    		((ObtenerTCargaODEsFormImpl) form).setDia((new Integer (tareaInformes.getFechaInicio().get(Calendar.DAY_OF_MONTH))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setHora((new Integer (tareaInformes.getFechaInicio().get(Calendar.HOUR_OF_DAY))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMinutos((new Integer (tareaInformes.getFechaInicio().get(Calendar.MINUTE))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMsgInforme(tareaInformes.getMsgInforme());
    		((ObtenerTCargaODEsFormImpl) form).setMsgNoInforme(tareaInformes.getMsgNoInforme());
    		((ObtenerTCargaODEsFormImpl) form).setMsgDescTrabajo(tareaInformes.getMsgDescripcionTrabajo());
        }
        catch (Exception e)
        {
        	log.error("Error: " + e);
        	throw new ValidatorException("{tareas.error}");
        }
        
    }

    /**
     * Metodo que obtiene los datos de la tarea de informe federado que hay almacenados actualmente
     */
    public void obtenerTareaInformeFederado(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaInformeFederadoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	if (tz == null) 
    		tz = utilidades.asignarZonaHoraria();
    	
    	TareaInformesVO tarea = new TareaInformesVO();
    	
    	try
        {    	
       		
    		//cargamos la tarea con lo valores esenciales para recuperar los demas valores de esta misma tarea
    		tarea.setTrabajo(((ObtenerTCargaODEsFormImpl) form).getTrabajo());
    		tarea.setGrupoTrabajo(((ObtenerTCargaODEsFormImpl) form).getGrupoTrabajo());
    		tarea.setTrigger(((ObtenerTCargaODEsFormImpl) form).getTrigger());
    		tarea.setGrupoTrigger(((ObtenerTCargaODEsFormImpl) form).getGrupoTrigger());
    		tarea.setPeriodicidad(((ObtenerTCargaODEsFormImpl) form).getPeriodicidad());
    		
    		//llamamos al servicio para que carge los valores en la tarea del tipo correspondiente
    		TareaInformesVO tareaInformes = this.getSrvPlanificadorService().obtenerTareaInformes(tarea);
			
			//Si tiene periodicidad no se obtienen las fechas Desde y Hasta
			
    		//Las fechas desde y hasta se las asignamos en el servicio
    		
			//asignamos a las fechas la franja horaria correspondiente
    		tareaInformes.getFechaInicio().setTimeZone(tz);
			
    		//rellenamos los datos especificos de este tipo de tarea
    		((ObtenerTCargaODEsFormImpl) form).setPeriodicidad(tareaInformes.getPeriodicidad());
    		((ObtenerTCargaODEsFormImpl) form).setTipoTarea(tareaInformes.getInforme());
    		((ObtenerTCargaODEsFormImpl) form).setFormato(tareaInformes.getFormato());
    		((ObtenerTCargaODEsFormImpl) form).setInforme(tareaInformes.getInforme());
    		((ObtenerTCargaODEsFormImpl) form).setAnio((new Integer (tareaInformes.getFechaInicio().get(Calendar.YEAR))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMes((new Integer (tareaInformes.getFechaInicio().get(Calendar.MONTH) + 1)).toString());
    		((ObtenerTCargaODEsFormImpl) form).setDia((new Integer (tareaInformes.getFechaInicio().get(Calendar.DAY_OF_MONTH))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setHora((new Integer (tareaInformes.getFechaInicio().get(Calendar.HOUR_OF_DAY))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMinutos((new Integer (tareaInformes.getFechaInicio().get(Calendar.MINUTE))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMsgInforme(tareaInformes.getMsgInforme());
    		((ObtenerTCargaODEsFormImpl) form).setMsgNoInforme(tareaInformes.getMsgNoInforme());
    		((ObtenerTCargaODEsFormImpl) form).setMsgDescTrabajo(tareaInformes.getMsgDescripcionTrabajo());
        }
        catch (Exception e)
        {
        	log.error("Error: " + e);
        	throw new ValidatorException("{tareas.error}");
        }
    }
    
    /**
     * Metodo que obtiene los datos que estan registrados de la tarea de informe catalogo
     */
    public void obtenerTareaInformeCatalogo(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaInformeCatalogoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	if (tz == null) 
    		tz = utilidades.asignarZonaHoraria();
    	
    	TareaInformesVO tarea = new TareaInformesVO();
    	
    	try
        {    	
       		
    		//cargamos la tarea con lo valores esenciales para recuperar los demas valores de esta misma tarea
    		tarea.setTrabajo(((ObtenerTCargaODEsFormImpl) form).getTrabajo());
    		tarea.setGrupoTrabajo(((ObtenerTCargaODEsFormImpl) form).getGrupoTrabajo());
    		tarea.setTrigger(((ObtenerTCargaODEsFormImpl) form).getTrigger());
    		tarea.setGrupoTrigger(((ObtenerTCargaODEsFormImpl) form).getGrupoTrigger());
    		tarea.setPeriodicidad(((ObtenerTCargaODEsFormImpl) form).getPeriodicidad());
    		
    		//llamamos al servicio para que carge los valores en la tarea del tipo correspondiente
    		TareaInformesVO tareaInformes = this.getSrvPlanificadorService().obtenerTareaInformes(tarea);
			
			//Si tiene periodicidad no se obtienen las fechas Desde y Hasta
			
    		//Las fechas desde y hasta se las asignamos en el servicio
    		
			//asignamos a las fechas la franja horaria correspondiente
    		tareaInformes.getFechaInicio().setTimeZone(tz);
			
    		//rellenamos los datos especificos de este tipo de tarea
    		((ObtenerTCargaODEsFormImpl) form).setPeriodicidad(tareaInformes.getPeriodicidad());
    		((ObtenerTCargaODEsFormImpl) form).setTipoTarea(tareaInformes.getInforme());
    		((ObtenerTCargaODEsFormImpl) form).setFormato(tareaInformes.getFormato());
    		((ObtenerTCargaODEsFormImpl) form).setInforme(tareaInformes.getInforme());
    		((ObtenerTCargaODEsFormImpl) form).setAnio((new Integer (tareaInformes.getFechaInicio().get(Calendar.YEAR))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMes((new Integer (tareaInformes.getFechaInicio().get(Calendar.MONTH) + 1)).toString());
    		((ObtenerTCargaODEsFormImpl) form).setDia((new Integer (tareaInformes.getFechaInicio().get(Calendar.DAY_OF_MONTH))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setHora((new Integer (tareaInformes.getFechaInicio().get(Calendar.HOUR_OF_DAY))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMinutos((new Integer (tareaInformes.getFechaInicio().get(Calendar.MINUTE))).toString());
    		((ObtenerTCargaODEsFormImpl) form).setMsgInforme(tareaInformes.getMsgInforme());
    		((ObtenerTCargaODEsFormImpl) form).setMsgNoInforme(tareaInformes.getMsgNoInforme());
    		((ObtenerTCargaODEsFormImpl) form).setMsgDescTrabajo(tareaInformes.getMsgDescripcionTrabajo());
        }
        catch (Exception e)
        {
        	log.error("Error: " + e);
        	throw new ValidatorException("{tareas.error}");
        }
    }
    
    
    /**
     * ******************************			METODOS DE VALIDACION			****************************************
     */
    
    
    
    /**
     * metodo que valida los campos de la tarea carga de odes(pantalla comun de la tareas)
     */
	public void validarFormularioCargaODEs(ActionMapping mapping, ValidarFormularioCargaODEsForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		
		FormularioIContinuarFormImpl formCarga = (FormularioIContinuarFormImpl) form;
		
		String dia = new String(formCarga.getDia());
	 	String mes = new String(formCarga.getMes());
	 	String anio = new String(formCarga.getAnio());
	 	String hora = new String(formCarga.getHora());
	 	String minutos = new String(formCarga.getMinutos());
		
	 	
		if (dia.equalsIgnoreCase("") || mes.equalsIgnoreCase("") || anio.equalsIgnoreCase("") || hora.equalsIgnoreCase("") || minutos.equalsIgnoreCase(""))
		{
			log.error("Error al introducir la fecha.");
			throw new ValidatorException("{tareas.errors.dateHora.required}") ;
		}

		try
		{
			new Integer(dia).intValue();
    		new Integer(mes).intValue();
    		new Integer(anio).intValue();
		 	
		}
		catch(Exception e)
		{
			log.error("Alguno de los campos de la fecha desde no son números");
			throw new ValidatorException("{tareas.fechaIncorrecta}");
		}
		
		try
		{
		 	new Integer(hora).intValue();
		  	new Integer(minutos).intValue();
		 		 	
		}catch(Exception e)
		{
			log.error("Alguno de los campos de la fecha desde no son números");
			throw new ValidatorException("{tareas.horaIncorrecta}");
		}
		
		
		Logger.getLogger(this.getClass()).debug("validamos la fecha");
		boolean fechaValida = utilidades.validacionFechaDDMMAAAAHHMM(dia, mes, anio, "yyyyMMdd");
        
        Logger.getLogger(this.getClass()).debug("validamos la hora");
        boolean horaValida= utilidades.validacionHoraHHMM(hora, minutos);
        
        
        if (!fechaValida && !horaValida)
			throw new ValidatorException("{tareas.fechaYHoraIncorrectas}");

		if (!horaValida)
			throw new ValidatorException("{tareas.horaIncorrecta}");

		if (!fechaValida)
			throw new ValidatorException("{tareas.fechaIncorrecta}");
		
	}

	
	 /**
     * metodo que valida los campos de la tarea reindexado(pantalla comun de la tareas)
     */
	public void validarFormularioReindexado(ActionMapping mapping, ValidarFormularioReindexadoForm form,  
			HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
	
		I18n i18n = I18n.getInstance();
    	
    	//Recogemos el idioma por defecto para mostrar en ese idioma la lista desplegable de idiomas
    	Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
    	
    	
    	//recogemos un array de objetos con la lista de idiomas
    	es.pode.soporte.i18n.LocalizacionIdiomaVO[] localizacionArray = i18n.obtenerIdiomasBuscablesLocalizados(locale.getLanguage());
    	
    	//sacamos los idiomas del array de objetos y lo asignamos al combo
    	form.setRepositorioBackingList(Arrays.asList(localizacionArray), "idLocalizacion", "name");
		
		FormularioReindexadoIContinuarFormImpl formCarga = (FormularioReindexadoIContinuarFormImpl) form;
		
		String dia = new String(formCarga.getDia());
	 	String mes = new String(formCarga.getMes());
	 	String anio = new String(formCarga.getAnio());
	 	String hora = new String(formCarga.getHora());
	 	String minutos = new String(formCarga.getMinutos());
	 	
	 	if(log.isDebugEnabled())log.debug("Validamos el formulario de la tarea de reindexado");
		
		if (dia.equalsIgnoreCase("") || mes.equalsIgnoreCase("") || anio.equalsIgnoreCase("") || hora.equalsIgnoreCase("") || minutos.equalsIgnoreCase(""))
		{
			log.error("Error al introducir la fecha.");
			throw new ValidatorException("{tareas.errors.dateHora.required}") ;
		}
		try
		{
			new Integer (dia).intValue();
    		new Integer(mes).intValue();
    		new Integer(anio).intValue();
		 	
		}
		catch(Exception e)
		{
			log.error("Alguno de los campos de la fecha desde no son números");
			throw new ValidatorException("{tareas.fechaIncorrecta}");
		}
		
		try
		{
		 	new Integer(hora).intValue();
		  	new Integer(minutos).intValue();
		 		 	
		}catch(Exception e)
		{
			log.error("Alguno de los campos de la hora no son números");
			throw new ValidatorException("{tareas.horaIncorrecta}");
		}
		
		
		Logger.getLogger(this.getClass()).debug("validamos la fecha");
		boolean fechaValida = utilidades.validacionFechaDDMMAAAAHHMM(dia, mes, anio, "yyyyMMdd");
        
        Logger.getLogger(this.getClass()).debug("validamos la hora");
        boolean horaValida= utilidades.validacionHoraHHMM(hora, minutos);
        
        
        if (!fechaValida && !horaValida)
			throw new ValidatorException("{tareas.fechaYHoraIncorrectas}");

		if (!horaValida)
			throw new ValidatorException("{tareas.horaIncorrecta}");

		if (!fechaValida)
			throw new ValidatorException("{tareas.fechaIncorrecta}");
		
	}
	
	
	
	/**
     * metodo que valida los campos de la tarea eliminar odes
     */
	public void validarFormularioNoDisponibles(org.apache.struts.action.ActionMapping mapping, 
    		es.pode.administracion.presentacion.planificador.modificarTarea.ValidarFormularioNoDisponiblesForm form, 
    		javax.servlet.http.HttpServletRequest request, 
    		javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
		
		FormularioNoDisponiblesIContinuarFormImpl formCarga = (FormularioNoDisponiblesIContinuarFormImpl) form;
		
		String dia = new String(formCarga.getDia());
	 	String mes = new String(formCarga.getMes());
	 	String anio = new String(formCarga.getAnio());
	 	String hora = new String(formCarga.getHora());
	 	String minutos = new String(formCarga.getMinutos());
		
	 	if(log.isDebugEnabled())log.debug("Validamos el formulario de la tarea de eliminar odes");
		
		if (dia.equalsIgnoreCase("") || mes.equalsIgnoreCase("") || anio.equalsIgnoreCase("") || hora.equalsIgnoreCase("") || minutos.equalsIgnoreCase(""))
		{
			log.error("Error al introducir la fecha.");
			throw new ValidatorException("{tareas.errors.dateHora.required}") ;
		}
		try
		{
			new Integer (dia).intValue();
    		new Integer(mes).intValue();
    		new Integer(anio).intValue();
		 	
		}catch(Exception e)
		{
			log.error("Alguno de los campos de la fecha no son números");
			throw new ValidatorException("{tareas.fechaIncorrecta}");
		}
		
		try
		{
		 	new Integer(hora).intValue();
		  	new Integer(minutos).intValue();
		 		 	
		}catch(Exception e)
		{
			log.error("Alguno de los campos de la hora no son números");
			throw new ValidatorException("{tareas.horaIncorrecta}");
		}
		

		
		//Comprobamos si las fecha y la hora son correctas
		Logger.getLogger(this.getClass()).debug("validamos la fecha");
		boolean fechaValida = utilidades.validacionFechaDDMMAAAAHHMM(dia, mes, anio, "yyyyMMdd");
        
        Logger.getLogger(this.getClass()).debug("validamos la hora");
        boolean horaValida= utilidades.validacionHoraHHMM(hora, minutos);
        
        
        if (!fechaValida && !horaValida)
			throw new ValidatorException("{tareas.fechaYHoraIncorrectas}");

		if (!horaValida)
			throw new ValidatorException("{tareas.horaIncorrecta}");

		if (!fechaValida)
			throw new ValidatorException("{tareas.fechaIncorrecta}");
		
		
    }
	
	
	/**
     * metodo que valida los campos de la tarea informeFecha(pantalla comun de la tareas)
     */
    public void validarFormularioFecha(org.apache.struts.action.ActionMapping mapping, 
    		es.pode.administracion.presentacion.planificador.modificarTarea.ValidarFormularioFechaForm form, 
    		javax.servlet.http.HttpServletRequest request, 
    		javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	
		FormularioInformeFechaIContinuarFormImpl formCarga = (FormularioInformeFechaIContinuarFormImpl) form;
		
		String dia = new String(formCarga.getDia());
	 	String mes = new String(formCarga.getMes());
	 	String anio = new String(formCarga.getAnio());
	 	String hora = new String(formCarga.getHora());
	 	String minutos = new String(formCarga.getMinutos());
		
	 	if(log.isDebugEnabled())log.debug("Validamos el formulario de la tarea de informe con fechas");
		
		if (dia.equalsIgnoreCase("") || mes.equalsIgnoreCase("") || anio.equalsIgnoreCase("") || hora.equalsIgnoreCase("") || minutos.equalsIgnoreCase(""))
		{
			log.error("Error al introducir la fecha.");
			throw new ValidatorException("{tareas.errors.dateHora.required}") ;
		}
		try
		{
			new Integer (dia).intValue();
    		new Integer(mes).intValue();
    		new Integer(anio).intValue();
		 	
		}catch(Exception e)
		{
			log.error("Alguno de los campos de la fecha no son números");
			throw new ValidatorException("{tareas.fechaIncorrecta}");
		}
		
		try
		{
		 	new Integer(hora).intValue();
		  	new Integer(minutos).intValue();
		 		 	
		}catch(Exception e)
		{
			log.error("Alguno de los campos de la hora no son números");
			throw new ValidatorException("{tareas.horaIncorrecta}");
		}
		

		
		Logger.getLogger(this.getClass()).debug("validamos la fecha");
		boolean fechaValida = utilidades.validacionFechaDDMMAAAAHHMM(dia, mes, anio, "yyyyMMdd");
        
        Logger.getLogger(this.getClass()).debug("validamos la hora");
        boolean horaValida= utilidades.validacionHoraHHMM(hora, minutos);
        
        
        if (!fechaValida && !horaValida)
			throw new ValidatorException("{tareas.fechaYHoraIncorrectas}");

		if (!horaValida)
			throw new ValidatorException("{tareas.horaIncorrecta}");

		if (!fechaValida)
			throw new ValidatorException("{tareas.fechaIncorrecta}");
		
    }

    
    /**
     * metodo que valida los campos de la tarea informeFechaRango(pantalla comun de la tareas)
     */
    public void validarInformeFechaRango(org.apache.struts.action.ActionMapping mapping, 
    		es.pode.administracion.presentacion.planificador.modificarTarea.ValidarInformeFechaRangoForm form, 
    		javax.servlet.http.HttpServletRequest request, 
    		javax.servlet.http.HttpServletResponse response) throws java.lang.Exception		
    {
    	
		FormularioInformesFechaRangoIContinuarFormImpl formCarga = (FormularioInformesFechaRangoIContinuarFormImpl) form;
		
		String dia = new String(formCarga.getDia());
	 	String mes = new String(formCarga.getMes());
	 	String anio = new String(formCarga.getAnio());
	 	String hora = new String(formCarga.getHora());
	 	String minutos = new String(formCarga.getMinutos());
		
	 	if(log.isDebugEnabled())log.debug("Validamos el formulario de la tarea de fechas rango");
		
		if (dia.equalsIgnoreCase("") || mes.equalsIgnoreCase("") || anio.equalsIgnoreCase("") || hora.equalsIgnoreCase("") || minutos.equalsIgnoreCase(""))
		{
			log.error("Error al introducir la fecha.");
			throw new ValidatorException("{tareas.errors.dateHora.required}") ;
		}
		try
		{
			new Integer (dia).intValue();
    		new Integer(mes).intValue();
    		new Integer(anio).intValue();
		 	
		}catch(Exception e)
		{
			log.error("Alguno de los campos de la fecha no son números");
			throw new ValidatorException("{tareas.fechaIncorrecta}");
		}
		
		try
		{
		 	new Integer(hora).intValue();
		  	new Integer(minutos).intValue();
		 		 	
		}catch(Exception e)
		{
			log.error("Alguno de los campos de la hora no son números");
			throw new ValidatorException("{tareas.horaIncorrecta}");
		}
		

		
		Logger.getLogger(this.getClass()).debug("validamos la fecha");
		boolean fechaValida = utilidades.validacionFechaDDMMAAAAHHMM(dia, mes, anio, "yyyyMMdd");
        
        Logger.getLogger(this.getClass()).debug("validamos la hora");
        boolean horaValida= utilidades.validacionHoraHHMM(hora, minutos);
        
        
        if (!fechaValida && !horaValida)
			throw new ValidatorException("{tareas.fechaYHoraIncorrectas}");

		if (!horaValida)
			throw new ValidatorException("{tareas.horaIncorrecta}");

		if (!fechaValida)
			throw new ValidatorException("{tareas.fechaIncorrecta}");
		
    }

    
    /**
     * metodo que valida los campos de la tarea informeFechaUsuario(pantalla comun de la tareas)
     */
    public void validarInformeFechaUsuario(org.apache.struts.action.ActionMapping mapping, 
    		es.pode.administracion.presentacion.planificador.modificarTarea.ValidarInformeFechaUsuarioForm form, 
    		javax.servlet.http.HttpServletRequest request, 
    		javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	
		//cargamos el combo de usuarios
		List usuariosList = Arrays.asList(this.getSrvAdminUsuariosService().listarTodosUsuarios());
		if(log.isDebugEnabled())log.debug("se recogen los usuarios de la aplicacion, estos son: " + usuariosList);
		form.setUsuarioBackingList(usuariosList, "usuario", "usuario");
		
		FormularioInformeFechaUsuarioIContinuarFormImpl formCarga = (FormularioInformeFechaUsuarioIContinuarFormImpl) form;
		
		String dia = new String(formCarga.getDia());
	 	String mes = new String(formCarga.getMes());
	 	String anio = new String(formCarga.getAnio());
	 	String hora = new String(formCarga.getHora());
	 	String minutos = new String(formCarga.getMinutos());
		
	 	if(log.isDebugEnabled())log.debug("Validamos el formulario de la tarea de informe usuarios");
		
		if (dia.equalsIgnoreCase("") || mes.equalsIgnoreCase("") || anio.equalsIgnoreCase("") || hora.equalsIgnoreCase("") || minutos.equalsIgnoreCase(""))
		{
			log.error("Error al introducir la fecha.");
			throw new ValidatorException("{tareas.errors.dateHora.required}") ;
		}
		try
		{
			new Integer (dia).intValue();
    		new Integer(mes).intValue();
    		new Integer(anio).intValue();
		 	
		}catch(Exception e)
		{
			log.error("Alguno de los campos de la fecha no son números");
			throw new ValidatorException("{tareas.fechaIncorrecta}");
		}
		
		try
		{
		 	new Integer(hora).intValue();
		  	new Integer(minutos).intValue();
		 		 	
		}catch(Exception e)
		{
			log.error("Alguno de los campos de la hora no son números");
			throw new ValidatorException("{tareas.horaIncorrecta}");
		}
		

		
		Logger.getLogger(this.getClass()).debug("validamos la fecha");
		boolean fechaValida = utilidades.validacionFechaDDMMAAAAHHMM(dia, mes, anio, "yyyyMMdd");
        
        Logger.getLogger(this.getClass()).debug("validamos la hora");
        boolean horaValida= utilidades.validacionHoraHHMM(hora, minutos);
        
        
        if (!fechaValida && !horaValida)
			throw new ValidatorException("{tareas.fechaYHoraIncorrectas}");

		if (!horaValida)
			throw new ValidatorException("{tareas.horaIncorrecta}");

		if (!fechaValida)
			throw new ValidatorException("{tareas.fechaIncorrecta}");
		
    }
	
    
    /**
     * Metodo que valida los campos introducidos en la modificacion del la tarea de informe de catalogo
     */
    public void validarInformeFederado(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ValidarInformeFederadoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	FormularioInformeFederadoIContinuarFormImpl formCarga = (FormularioInformeFederadoIContinuarFormImpl) form;
		
		String dia = new String(formCarga.getDia());
	 	String mes = new String(formCarga.getMes());
	 	String anio = new String(formCarga.getAnio());
	 	String hora = new String(formCarga.getHora());
	 	String minutos = new String(formCarga.getMinutos());
		
	 	if(log.isDebugEnabled())log.debug("Validamos el formulario de la tarea de fechas rango");
		
		if (dia.equalsIgnoreCase("") || mes.equalsIgnoreCase("") || anio.equalsIgnoreCase("") || hora.equalsIgnoreCase("") || minutos.equalsIgnoreCase(""))
		{
			log.error("Error al introducir la fecha.");
			throw new ValidatorException("{tareas.errors.dateHora.required}") ;
		}
		try
		{
			new Integer (dia).intValue();
    		new Integer(mes).intValue();
    		new Integer(anio).intValue();
		 	
		}catch(Exception e)
		{
			log.error("Alguno de los campos de la fecha no son números");
			throw new ValidatorException("{tareas.fechaIncorrecta}");
		}
		
		try
		{
		 	new Integer(hora).intValue();
		  	new Integer(minutos).intValue();
		 		 	
		}catch(Exception e)
		{
			log.error("Alguno de los campos de la hora no son números");
			throw new ValidatorException("{tareas.horaIncorrecta}");
		}
		

		
		Logger.getLogger(this.getClass()).debug("validamos la fecha");
		boolean fechaValida = utilidades.validacionFechaDDMMAAAAHHMM(dia, mes, anio, "yyyyMMdd");
        
        Logger.getLogger(this.getClass()).debug("validamos la hora");
        boolean horaValida= utilidades.validacionHoraHHMM(hora, minutos);
        
        
        if (!fechaValida && !horaValida)
			throw new ValidatorException("{tareas.fechaYHoraIncorrectas}");

		if (!horaValida)
			throw new ValidatorException("{tareas.horaIncorrecta}");

		if (!fechaValida)
			throw new ValidatorException("{tareas.fechaIncorrecta}");
    }
	
    
    public void validarInformeCatalogo(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ValidarInformeCatalogoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	FormularioInformeCatalogoIContinuarFormImpl formCarga = (FormularioInformeCatalogoIContinuarFormImpl) form;
		
		String dia = new String(formCarga.getDia());
	 	String mes = new String(formCarga.getMes());
	 	String anio = new String(formCarga.getAnio());
	 	String hora = new String(formCarga.getHora());
	 	String minutos = new String(formCarga.getMinutos());
		
	 	if(log.isDebugEnabled())log.debug("Validamos el formulario de la tarea de fechas rango");
		
		if (dia.equalsIgnoreCase("") || mes.equalsIgnoreCase("") || anio.equalsIgnoreCase("") || hora.equalsIgnoreCase("") || minutos.equalsIgnoreCase(""))
		{
			log.error("Error al introducir la fecha.");
			throw new ValidatorException("{tareas.errors.dateHora.required}") ;
		}
		try
		{
			new Integer (dia).intValue();
    		new Integer(mes).intValue();
    		new Integer(anio).intValue();
		 	
		}catch(Exception e)
		{
			log.error("Alguno de los campos de la fecha no son números");
			throw new ValidatorException("{tareas.fechaIncorrecta}");
		}
		
		try
		{
		 	new Integer(hora).intValue();
		  	new Integer(minutos).intValue();
		 		 	
		}catch(Exception e)
		{
			log.error("Alguno de los campos de la hora no son números");
			throw new ValidatorException("{tareas.horaIncorrecta}");
		}
		

		
		Logger.getLogger(this.getClass()).debug("validamos la fecha");
		boolean fechaValida = utilidades.validacionFechaDDMMAAAAHHMM(dia, mes, anio, "yyyyMMdd");
        
        Logger.getLogger(this.getClass()).debug("validamos la hora");
        boolean horaValida= utilidades.validacionHoraHHMM(hora, minutos);
        
        
        if (!fechaValida && !horaValida)
			throw new ValidatorException("{tareas.fechaYHoraIncorrectas}");

		if (!horaValida)
			throw new ValidatorException("{tareas.horaIncorrecta}");

		if (!fechaValida)
			throw new ValidatorException("{tareas.fechaIncorrecta}");
		

		if (tz == null) 
    		tz = utilidades.asignarZonaHoraria();
    	
    	
		TrabajoVO trabajo = new TrabajoVO(); // Trabajo a modificar
		TareaInformesVO datosTarea = new TareaInformesVO(); // Datos a modificar
					
				
		try
		{
		
		trabajo.setTrabajo(formCarga.getTrabajo());
		trabajo.setGrupoTrabajo(formCarga.getGrupoTrabajo());
		
		datosTarea.setTrabajo(formCarga.getTrabajo());
		datosTarea.setGrupoTrabajo(formCarga.getGrupoTrabajo());
		datosTarea.setTrigger(formCarga.getTrigger());
		datosTarea.setGrupoTrigger(formCarga.getGrupoTrigger());
		datosTarea.setPeriodicidad(formCarga.getPeriodicidad());
		datosTarea.setFormato(formCarga.getFormato());
		datosTarea.setInforme(formCarga.getInforme());
		datosTarea.setMsgInforme(formCarga.getMsgInforme());
		datosTarea.setMsgNoInforme(formCarga.getMsgNoInforme());
		datosTarea.setMsgDescripcionTrabajo(formCarga.getMsgDescTrabajo());
		
		
        Calendar cal = Calendar.getInstance(tz);    		
        cal = new GregorianCalendar(
        		new Integer (anio).intValue(), 
        		new Integer (mes).intValue() -1,
        		new Integer (dia).intValue() ,
        		new Integer (hora).intValue(), 
        		new Integer (minutos).intValue());
        
        datosTarea.setFechaInicio(cal);
		datosTarea.setUsuario(LdapUserDetailsUtils.getUsuario());
	
		TareaInformesVO tareaRecuperada = this.getSrvPlanificadorService().modificarTareaInformesCatalogo(datosTarea, trabajo);
		form.setTareaModificada(tareaRecuperada.getTrabajo());

		}catch(Exception e)
		{
			log.error("Error: " + e);
        	throw new ValidatorException("{tareas.error}");
		}
		
		
		
		
    }
	
	 /**
     * ******************************			METODOS DE MODIFICACION DE LA TAREA			****************************************
     */
	
	
	

    /**
     * Metodo que guarda los cambios que se han echo en la tarea carga de odes
     */
    public final void modificarTareaCargaODEs(ActionMapping mapping, ModificarTareaCargaODEsForm form, 
    		HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	if (tz == null) 
    		tz = utilidades.asignarZonaHoraria();
    	
		TrabajoVO trabajo = new TrabajoVO(); // Trabajo a modificar
		TareaCargaODEsVO datosTarea = new TareaCargaODEsVO(); // Datos a modificar
		
		TareaCargaODEsVO tareaRecuperada = null;//comprobar si el servicio manda la validacion ok o no
				
    	try
        {    				
    		trabajo.setTrabajo(((FormularioIIAceptarFormImpl) form).getTrabajo());
    		trabajo.setGrupoTrabajo(((FormularioIIAceptarFormImpl) form).getGrupoTrabajo());	
    		datosTarea.setTrabajo(((FormularioIIAceptarFormImpl) form).getTrabajo());
    		datosTarea.setGrupoTrabajo(((FormularioIIAceptarFormImpl) form).getGrupoTrabajo());
    		datosTarea.setTrigger(((FormularioIIAceptarFormImpl) form).getTrigger());
    		datosTarea.setGrupoTrigger(((FormularioIIAceptarFormImpl) form).getGrupoTrigger());
    		datosTarea.setPathODE(((FormularioIIAceptarFormImpl) form).getPathODEs());
    		datosTarea.setPathODEsCargados(((FormularioIIAceptarFormImpl) form).getPathODEsCarg());
    		datosTarea.setPathODEsNoCargados(((FormularioIIAceptarFormImpl) form).getPathODEsNoCarg());
    		datosTarea.setPeriodicidad(((FormularioIIAceptarFormImpl) form).getPeriodicidad());
    		datosTarea.setMsgPublicado(((FormularioIIAceptarFormImpl) form).getMsgPublicado());
    		datosTarea.setMsgNoPublicado(((FormularioIIAceptarFormImpl) form).getMsgNoPublicado());
    		datosTarea.setMsgDescripcionTrabajo(((FormularioIIAceptarFormImpl) form).getMsgDescCargaODEs());
			if (((FormularioIIAceptarFormImpl) form).getSobrescribir()!=null &&((FormularioIIAceptarFormImpl) form).getSobrescribir().equals("on"))
				datosTarea.setSobrescribir("s");
			else 
				datosTarea.setSobrescribir("n");
    		
    		
	        Calendar cal = Calendar.getInstance(tz);    		
	        cal = new GregorianCalendar(
	        		new Integer(((FormularioIIAceptarFormImpl)form).getAnio()).intValue(), 
	        		new Integer(((FormularioIIAceptarFormImpl)form).getMes()).intValue() -1,
	        		new Integer(((FormularioIIAceptarFormImpl)form).getDia()).intValue() ,
	        		new Integer(((FormularioIIAceptarFormImpl)form).getHora()).intValue(), 
	        		new Integer(((FormularioIIAceptarFormImpl)form).getMinutos()).intValue());
	        	        
	        datosTarea.setFechaInicio(cal);
    		
    		datosTarea.setUsuario(LdapUserDetailsUtils.getUsuario());
    		
    		tareaRecuperada = this.getSrvPlanificadorService().modificarTareaCargaODEs(datosTarea, trabajo);
    		form.setTareaModificada(tareaRecuperada.getTrabajo());
    		if (tareaRecuperada.getError() != null)
				throw new ValidatorException("{" + tareaRecuperada.getError()
						+ "}");
        }
    	catch (ValidatorException e2) {
			throw new ValidatorException("{" + tareaRecuperada.getError() + "}");
    	}
        catch (Exception e)
        {
        	log.error("Error: " + e);
        	throw new ValidatorException("{tareas.error}");
        }		
    }

    
    /**
     * Metodo que guarda los cambios que se han echo en la tarea reindexado
     */
    public final void modificarTareaReindexado(ActionMapping mapping, ModificarTareaReindexadoForm form, 
    		HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	if (tz == null) 
    		tz = utilidades.asignarZonaHoraria();
    	
		TrabajoVO trabajo = new TrabajoVO(); // Trabajo a modificar
		TareaReindexadoVO datosTarea = new TareaReindexadoVO(); // Datos a modificar
		
    	try
        {    				
    		trabajo.setTrabajo(((FormularioReindexadoIIAceptarFormImpl) form).getTrabajo());
    		trabajo.setGrupoTrabajo(((FormularioReindexadoIIAceptarFormImpl) form).getGrupoTrabajo());	
    		datosTarea.setTrabajo(((FormularioReindexadoIIAceptarFormImpl) form).getTrabajo());
    		datosTarea.setGrupoTrabajo(((FormularioReindexadoIIAceptarFormImpl) form).getGrupoTrabajo());
    		datosTarea.setTrigger(((FormularioReindexadoIIAceptarFormImpl) form).getTrigger());
    		datosTarea.setGrupoTrigger(((FormularioReindexadoIIAceptarFormImpl) form).getGrupoTrigger());
    		datosTarea.setRepositorioIndices(((FormularioReindexadoIIAceptarFormImpl) form).getRepositorio());
    		datosTarea.setPeriodicidad(((FormularioReindexadoIIAceptarFormImpl) form).getPeriodicidad());
    		
	        Calendar cal = Calendar.getInstance(tz);
	        cal = new GregorianCalendar(
	        		new Integer(((FormularioReindexadoIIAceptarFormImpl)form).getAnio()).intValue(),
	        		new Integer(((FormularioReindexadoIIAceptarFormImpl)form).getMes()).intValue() -1,
	        		new Integer(((FormularioReindexadoIIAceptarFormImpl)form).getDia()).intValue(),
	        		new Integer(((FormularioReindexadoIIAceptarFormImpl)form).getHora()).intValue(),
	        		new Integer(((FormularioReindexadoIIAceptarFormImpl)form).getMinutos()).intValue());
	        	        
	        datosTarea.setFechaInicio(cal);
    		datosTarea.setMsgReindexado(((FormularioReindexadoIIAceptarFormImpl) form).getMsgReindexado());
    		datosTarea.setMsgNoReindexado(((FormularioReindexadoIIAceptarFormImpl) form).getMsgNoReindexado());
    		datosTarea.setMsgDescripcionTrabajo(((FormularioReindexadoIIAceptarFormImpl) form).getMsgDescReindexado());
	        
    		datosTarea.setUsuario(LdapUserDetailsUtils.getUsuario());
    		
    		TareaReindexadoVO tareaRecuperada =this.getSrvPlanificadorService().modificarTareaReindexado(datosTarea, trabajo);
    		form.setTareaModificada(tareaRecuperada.getTrabajo());
        }
        catch (Exception e)
        {
        	log.error("Error: " + e);
        	throw new ValidatorException("{tareas.error}");
        }		
    }
    

	
    /**
     * Metodo que guarda los cambios que se han echo en la tarea eliminar odes
     */
    public void modificarTareaNoDisponibles(org.apache.struts.action.ActionMapping mapping, 
    		es.pode.administracion.presentacion.planificador.modificarTarea.ModificarTareaNoDisponiblesForm form, 
    		javax.servlet.http.HttpServletRequest request, 
    		javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	if (tz == null) 
    		tz = utilidades.asignarZonaHoraria();
    	
    	String dia = new String(((FormularioNoDisponiblesIIAceptarFormImpl)form).getDia());
    	String mes = new String(((FormularioNoDisponiblesIIAceptarFormImpl)form).getMes());
    	String anio = new String(((FormularioNoDisponiblesIIAceptarFormImpl)form).getAnio());
    	String hora = new String(((FormularioNoDisponiblesIIAceptarFormImpl)form).getHora());
    	String minutos = new String(((FormularioNoDisponiblesIIAceptarFormImpl)form).getMinutos());
    	String anioDesde = new String(((FormularioNoDisponiblesIIAceptarFormImpl)form).getAnioDesde());
    	String mesDesde = new String(((FormularioNoDisponiblesIIAceptarFormImpl)form).getMesDesde());
    	String diaDesde = new String(((FormularioNoDisponiblesIIAceptarFormImpl)form).getDiaDesde());
    	String anioHasta = new String(((FormularioNoDisponiblesIIAceptarFormImpl)form).getAnioHasta());
    	String mesHasta = new String(((FormularioNoDisponiblesIIAceptarFormImpl)form).getMesHasta());
    	String diaHasta = new String(((FormularioNoDisponiblesIIAceptarFormImpl)form).getDiaHasta());
    	
		TrabajoVO trabajo = new TrabajoVO(); // Trabajo a modificar
		TareaEliminaNoDisponiblesVO datosTarea = new TareaEliminaNoDisponiblesVO(); // Datos a modificar
				
    	try
        {    				
    		//Comprobamos que todos los campos de la fecha de inicio están rellenos
    		if( anioDesde.equalsIgnoreCase("") || mesDesde.equalsIgnoreCase("") || diaDesde.equalsIgnoreCase(""))
    			
    			throw new ValidatorException("{informes.crearInformes.fechaDesdeCampoVacio}");
    		
    		//Comprobamos que todos los campos de la fecha fin están rellenos
    		if(anioHasta.equalsIgnoreCase("") || mesHasta.equalsIgnoreCase("") || diaHasta.equalsIgnoreCase(""))
    			
    			throw new ValidatorException("{informes.crearInformes.fechaHastaCampoVacio}");
    		
    		//Comprobamos que los campos de las fechas son numeros
    		if(log.isDebugEnabled())log.debug("comprobamos si las fechas tiene caracteres no numericos");
    		try
    		{
    			new Integer (anioDesde).intValue(); 
				new Integer (mesDesde).intValue(); 
				new Integer (diaDesde).intValue();
    		 	
    		 	
    		}catch(Exception e)
    		{
    			log.error("Alguno de los campos de la fecha desde no son números");
    			throw new ValidatorException("{tareas.eliminarOdes.fechaDesde}");
    		}
    		try
    		{
    			new Integer (anioHasta).intValue(); 
				new Integer (mesHasta).intValue(); 
				new Integer (diaHasta).intValue();
    		 	
    		}catch(Exception e)
    		{
    			log.error("Alguno de los campos de la fecha hasta no son números");
    			throw new ValidatorException("{tareas.eliminarOdes.fechaHasta}");
    		}
    		
    		
			// Comprobamos si las fechas introducidas son correctas
			boolean fechaValidaDesde = utilidades.validacionFechaDDMMAAAAHHMM(diaDesde, mesDesde, anioDesde,"yyyyMMdd");

			boolean fechaValidaHasta = utilidades.validacionFechaDDMMAAAAHHMM(diaHasta, mesHasta, anioHasta,"yyyyMMdd");

			boolean comparacionFechaDesdeHasta = utilidades.comparacionFechas(anioDesde, mesDesde, diaDesde, anioHasta, mesHasta, diaHasta);

			if (!fechaValidaHasta && !fechaValidaDesde)
				throw new ValidatorException(
						"{tareas.fechaDesdeHastaIncorrecta}");

			if (!fechaValidaDesde)
				throw new ValidatorException("{tareas.fechaDesdeIncorrecta}");

			if (!fechaValidaHasta)
				throw new ValidatorException("{tareas.fechaHastaIncorrecta}");

			if (!comparacionFechaDesdeHasta)
				throw new ValidatorException("{tareas.fechaDesdeMasQueHasta}");

			try
    		{
			
    		trabajo.setTrabajo(((FormularioNoDisponiblesIIAceptarFormImpl) form).getTrabajo());
    		trabajo.setGrupoTrabajo(((FormularioNoDisponiblesIIAceptarFormImpl) form).getGrupoTrabajo());	
    		datosTarea.setTrabajo(((FormularioNoDisponiblesIIAceptarFormImpl) form).getTrabajo());
    		datosTarea.setGrupoTrabajo(((FormularioNoDisponiblesIIAceptarFormImpl) form).getGrupoTrabajo());
    		datosTarea.setTrigger(((FormularioNoDisponiblesIIAceptarFormImpl) form).getTrigger());
    		datosTarea.setGrupoTrigger(((FormularioNoDisponiblesIIAceptarFormImpl) form).getGrupoTrigger());
    		datosTarea.setPeriodicidad(((FormularioNoDisponiblesIIAceptarFormImpl) form).getPeriodicidad());
    		datosTarea.setMsgEliminado(((FormularioNoDisponiblesIIAceptarFormImpl) form).getMsgEliminado());
    		datosTarea.setMsgNoEliminado(((FormularioNoDisponiblesIIAceptarFormImpl) form).getMsgNoEliminado());
    		datosTarea.setMsgDescripcionTrabajo(((FormularioNoDisponiblesIIAceptarFormImpl) form).getMsgDescTrabajo());
			
    		
	        Calendar cal = Calendar.getInstance(tz);    		
	        cal = new GregorianCalendar(
	        		new Integer (anio).intValue(), 
	        		new Integer (mes).intValue() - 1, 
	        		new Integer (dia).intValue(),
	        		new Integer (hora).intValue(), 
	        		new Integer (minutos).intValue());
	        
	        Calendar calFechaDesde = Calendar.getInstance(tz);
	        calFechaDesde = new GregorianCalendar(
	        		new Integer (anioDesde).intValue(), 
	        		new Integer (mesDesde).intValue() -1,
	        		new Integer (diaDesde).intValue(),0,1);
	        		
	        Calendar calFechaHasta = Calendar.getInstance(tz);
	        calFechaHasta = new GregorianCalendar(
	        		new Integer (anioHasta).intValue(), 
	        		new Integer (mesHasta).intValue() -1,
	        		new Integer (diaHasta).intValue(),23,59);
	        
	        
	        datosTarea.setFechaInicio(cal);
	        datosTarea.setFechaDesde(calFechaDesde);
    		datosTarea.setFechaHasta(calFechaHasta);
    		
    		datosTarea.setUsuario(LdapUserDetailsUtils.getUsuario());
    		
    			TareaEliminaNoDisponiblesVO tareaRecuperada = this.getSrvPlanificadorService().modificarTareaEliminarNoDisponibles(datosTarea, trabajo);
    			form.setTareaModificada(tareaRecuperada.getTrabajo());
    		}catch(Exception e)
    		{
    			log.error("Error: " + e);
            	throw new ValidatorException("{tareas.error}");
    		}
        }catch (ValidatorException ve)
        {
        	log.error("error "+ve);
        	throw ve;
        }
    	catch (Exception e)
        {
        	log.error("Error: " + e);
        	//throw new ValidatorException("{tareas.error}");
        }		
    }
    
    
    /**
     * Metodo que guarda los cambios que se han echo en la tarea informeFecha
     */
    public void modificarTareaInformeFecha(org.apache.struts.action.ActionMapping mapping, 
    		es.pode.administracion.presentacion.planificador.modificarTarea.ModificarTareaInformeFechaForm form, 
    		javax.servlet.http.HttpServletRequest request, 
    		javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	if (tz == null) 
    		tz = utilidades.asignarZonaHoraria();
    	
		TrabajoVO trabajo = new TrabajoVO(); // Trabajo a modificar
		TareaInformesVO datosTarea = new TareaInformesVO(); // Datos a modificar
		
		String dia = new String(((FormularioInformeFechaIIAceptarFormImpl)form).getDia());
    	String mes = new String(((FormularioInformeFechaIIAceptarFormImpl)form).getMes());
    	String anio = new String(((FormularioInformeFechaIIAceptarFormImpl)form).getAnio());
    	String hora = new String(((FormularioInformeFechaIIAceptarFormImpl)form).getHora());
    	String minutos = new String(((FormularioInformeFechaIIAceptarFormImpl)form).getMinutos());
    	
		
    	try
        {    	

			if(((FormularioInformeFechaIIAceptarFormImpl)form).getPeriodicidad().equalsIgnoreCase("N"))
			{
				String anioDesde = new String(((FormularioInformeFechaIIAceptarFormImpl)form).getAnioDesde());
		    	String mesDesde = new String(((FormularioInformeFechaIIAceptarFormImpl)form).getMesDesde());
		    	String diaDesde = new String(((FormularioInformeFechaIIAceptarFormImpl)form).getDiaDesde());
		    	String anioHasta = new String(((FormularioInformeFechaIIAceptarFormImpl)form).getAnioHasta());
		    	String mesHasta = new String(((FormularioInformeFechaIIAceptarFormImpl)form).getMesHasta());
		    	String diaHasta = new String(((FormularioInformeFechaIIAceptarFormImpl)form).getDiaHasta());
			
	    		//Comprobamos que todos los campos de la fecha desde están rellenos
	    		if(anioDesde.equalsIgnoreCase("") || mesDesde.equalsIgnoreCase("") || diaDesde.equalsIgnoreCase(""))
	    			
	    			throw new ValidatorException("{informes.crearInformes.fechaDesdeCampoVacio}");
	    		
	    		//Comprobamos que todos los campos de la fecha hasta están rellenos
	    		if( anioHasta.equalsIgnoreCase("") || mesHasta.equalsIgnoreCase("") || diaHasta.equalsIgnoreCase(""))
	    			
	    			throw new ValidatorException("{informes.crearInformes.fechaHastaCampoVacio}");
	    		
	    		//Comprobamos que los campos de las fechas son numeros
	    		if(log.isDebugEnabled())log.debug("comprobamos si las fechas tiene caracteres no numericos");
	    		try
	    		{
	    			new Integer (anioDesde).intValue(); 
					new Integer (mesDesde).intValue();
					new Integer (diaDesde).intValue();
	    		 	
	    		}catch(Exception e)
	    		{
	    			log.error("Alguno de los campos de la fecha desde no son números");
	    			throw new ValidatorException("{tareas.eliminarOdes.fechaDesde}");
	    		}
	    		try
	    		{
	    			new Integer (anioHasta).intValue(); 
					new Integer (mesHasta).intValue();
					new Integer (diaHasta).intValue();
	    			    		 	
	    		}catch(Exception e)
	    		{
	    			log.error("Alguno de los campos de la fecha hasta no son números");
	    			throw new ValidatorException("{tareas.eliminarOdes.fechaHasta}");
	    		}
	    		
	    		
				// Comprobamos si las fechas introducidas son correctas
				boolean fechaValidaDesde = utilidades.validacionFechaDDMMAAAAHHMM(diaDesde , mesDesde, anioDesde, "yyyyMMdd");

				boolean fechaValidaHasta = utilidades.validacionFechaDDMMAAAAHHMM(diaHasta, mesHasta, anioHasta, "yyyyMMdd");

				boolean comparacionFechaDesdeHasta = utilidades.comparacionFechas(anioDesde, mesDesde, diaDesde, anioHasta, mesHasta, diaHasta);

				if (!fechaValidaHasta && !fechaValidaDesde)
					throw new ValidatorException(
							"{tareas.fechaDesdeHastaIncorrecta}");

				if (!fechaValidaDesde)
					throw new ValidatorException("{tareas.fechaDesdeIncorrecta}");

				if (!fechaValidaHasta)
					throw new ValidatorException("{tareas.fechaHastaIncorrecta}");

				if (!comparacionFechaDesdeHasta)
					throw new ValidatorException("{tareas.fechaDesdeMasQueHasta}");
					
				Calendar calFechaDesde = Calendar.getInstance(tz);
				calFechaDesde = new GregorianCalendar(
	        		new Integer (anioDesde).intValue(), 
	        		new Integer (mesDesde).intValue() -1,
	        		new Integer (diaDesde).intValue(),0,1);
	        		
				Calendar calFechaHasta = Calendar.getInstance(tz);
				calFechaHasta = new GregorianCalendar(
	        		new Integer (anioHasta).intValue(), 
	        		new Integer (mesHasta).intValue() -1,
	        		new Integer (diaHasta).intValue(),23,59);
					
				datosTarea.setFechaDesde(calFechaDesde);
				datosTarea.setFechaHasta(calFechaHasta);
					
				
			}
			else
			{
				if(log.isDebugEnabled())log.debug("es periodica");
			}
				
			try
    		{
			
    		trabajo.setTrabajo(((FormularioInformeFechaIIAceptarFormImpl) form).getTrabajo());
    		trabajo.setGrupoTrabajo(((FormularioInformeFechaIIAceptarFormImpl) form).getGrupoTrabajo());
    		
    		datosTarea.setTrabajo(((FormularioInformeFechaIIAceptarFormImpl) form).getTrabajo());
    		datosTarea.setGrupoTrabajo(((FormularioInformeFechaIIAceptarFormImpl) form).getGrupoTrabajo());
    		datosTarea.setTrigger(((FormularioInformeFechaIIAceptarFormImpl) form).getTrigger());
    		datosTarea.setGrupoTrigger(((FormularioInformeFechaIIAceptarFormImpl) form).getGrupoTrigger());
    		datosTarea.setPeriodicidad(((FormularioInformeFechaIIAceptarFormImpl) form).getPeriodicidad());
    		datosTarea.setFormato(((FormularioInformeFechaIIAceptarFormImpl) form).getFormato());
    		datosTarea.setInforme(((FormularioInformeFechaIIAceptarFormImpl) form).getInforme());
    		datosTarea.setMsgInforme(((FormularioInformeFechaIIAceptarFormImpl) form).getMsgInforme());
    		datosTarea.setMsgNoInforme(((FormularioInformeFechaIIAceptarFormImpl) form).getMsgNoInforme());
    		datosTarea.setMsgDescripcionTrabajo(((FormularioInformeFechaIIAceptarFormImpl) form).getMsgDescTrabajo());
			
    		
	        Calendar cal = Calendar.getInstance(tz);    		
	        cal = new GregorianCalendar(
	        		new Integer (anio).intValue(), 
	        		new Integer (mes).intValue() -1,
	        		new Integer (dia).intValue() ,
	        		new Integer (hora).intValue(), 
	        		new Integer (minutos).intValue());
	        
	        datosTarea.setFechaInicio(cal);
    		
    		datosTarea.setUsuario(LdapUserDetailsUtils.getUsuario());
    		
    		TareaInformesVO tareaRecuperada = this.getSrvPlanificadorService().modificarTareaInformes(datosTarea, trabajo);
    		form.setTareaModificada(tareaRecuperada.getTrabajo());
    		
    		
    		}catch(Exception e)
    		{
    			log.error("Error: " + e);
            	throw new ValidatorException("{tareas.error}");
    		}
    		
        }
    	catch (ValidatorException ve)
        {
        	log.error("error "+ve);
        	throw ve;
        }
    	
        catch (Exception e)
        {
        	log.error("Error: " + e);
        	//throw new ValidatorException("{tareas.error}");
        }
        		
    }

    
    /**
     * Metodo que guarda los cambios que se han echo en la tarea informeFechaRango
     */
    public void modificarTareaInformeFechaRango(org.apache.struts.action.ActionMapping mapping, 
    		es.pode.administracion.presentacion.planificador.modificarTarea.ModificarTareaInformeFechaRangoForm form, 
    		javax.servlet.http.HttpServletRequest request, 
    		javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	
    	if (tz == null) 
    		tz = utilidades.asignarZonaHoraria();
    	
    	String dia = new String(((FormularioInformeFechaRangoIIAceptarFormImpl)form).getDia());
    	String mes = new String(((FormularioInformeFechaRangoIIAceptarFormImpl)form).getMes());
    	String anio = new String(((FormularioInformeFechaRangoIIAceptarFormImpl)form).getAnio());
    	String hora = new String(((FormularioInformeFechaRangoIIAceptarFormImpl)form).getHora());
    	String minutos = new String(((FormularioInformeFechaRangoIIAceptarFormImpl)form).getMinutos());
    	
    	
		TrabajoVO trabajo = new TrabajoVO(); // Trabajo a modificar
		TareaInformesVO datosTarea = new TareaInformesVO(); // Datos a modificar
				
    	try
        {  

			if(((FormularioInformeFechaRangoIIAceptarFormImpl)form).getPeriodicidad().equalsIgnoreCase("N"))
    		{
				String anioDesde = new String(((FormularioInformeFechaRangoIIAceptarFormImpl)form).getAnioDesde());
		    	String mesDesde = new String(((FormularioInformeFechaRangoIIAceptarFormImpl)form).getMesDesde());
		    	String diaDesde = new String(((FormularioInformeFechaRangoIIAceptarFormImpl)form).getDiaDesde());
		    	String anioHasta = new String(((FormularioInformeFechaRangoIIAceptarFormImpl)form).getAnioHasta());
		    	String mesHasta = new String(((FormularioInformeFechaRangoIIAceptarFormImpl)form).getMesHasta());
		    	String diaHasta = new String(((FormularioInformeFechaRangoIIAceptarFormImpl)form).getDiaHasta());
			
	    		//Comprobamos que todos los campos de la fecha de inicio están rellenos
	    		if(anioDesde.equalsIgnoreCase("") || mesDesde.equalsIgnoreCase("") || diaDesde.equalsIgnoreCase(""))
	    			
	    			throw new ValidatorException("{informes.crearInformes.fechaDesdeCampoVacio}");
	    		
	    		//Comprobamos que todos los campos de la fecha fin están rellenos
	    		if(anioHasta.equalsIgnoreCase("") || mesHasta.equalsIgnoreCase("") || diaHasta.equalsIgnoreCase(""))
	    			
	    			throw new ValidatorException("{informes.crearInformes.fechaHastaCampoVacio}");
	    		
	    		
	    		//Comprobamos que los campos de las fechas son numeros
	    		if(log.isDebugEnabled())log.debug("comprobamos si las fechas tiene caracteres no numericos");
	    		try
	    		{
	    			new Integer(anioDesde).intValue();
	    			new Integer(mesDesde).intValue(); 
	    			new Integer(diaDesde).intValue();
	    			
	    			    		 	
	    		}catch(Exception e)
	    		{
	    			log.error("Alguno de los campos de la fecha desde no son números");
	    			throw new ValidatorException("{tareas.eliminarOdes.fechaDesde}");
	    		}
	    		try
	    		{
	    			new Integer(anioHasta).intValue();
	    			new Integer(mesHasta).intValue(); 
	    			new Integer(diaHasta).intValue();
	    			    		 	
	    		}catch(Exception e)
	    		{
	    			log.error("Alguno de los campos de la fecha hasta no son números");
	    			throw new ValidatorException("{tareas.eliminarOdes.fechaHasta}");
	    		}
	    		
	    		
				// Comprobamos si las fechas introducidas son correctas
				boolean fechaValidaDesde = utilidades.validacionFechaDDMMAAAAHHMM(diaDesde, mesDesde, anioDesde,"yyyyMMdd");

				boolean fechaValidaHasta = utilidades.validacionFechaDDMMAAAAHHMM(diaHasta, mesHasta, anioHasta,"yyyyMMdd");

				boolean comparacionFechaDesdeHasta = utilidades.comparacionFechas(anioDesde, mesDesde, diaDesde, anioHasta, mesHasta, diaHasta);

				if (!fechaValidaHasta && !fechaValidaDesde)
					throw new ValidatorException(
							"{tareas.fechaDesdeHastaIncorrecta}");

				if (!fechaValidaDesde)
					throw new ValidatorException("{tareas.fechaDesdeIncorrecta}");

				if (!fechaValidaHasta)
					throw new ValidatorException("{tareas.fechaHastaIncorrecta}");

				if (!comparacionFechaDesdeHasta)
					throw new ValidatorException("{tareas.fechaDesdeMasQueHasta}");
				
				Calendar calFechaDesde = Calendar.getInstance(tz);
				calFechaDesde = new GregorianCalendar(
	        		new Integer (anioDesde).intValue(), 
	        		new Integer (mesDesde).intValue() -1,
	        		new Integer (diaDesde).intValue(),0,1);
	        		
				Calendar calFechaHasta = Calendar.getInstance(tz);
				calFechaHasta = new GregorianCalendar(
	        		new Integer (anioHasta).intValue(), 
	        		new Integer (mesHasta).intValue() -1,
	        		new Integer (diaHasta).intValue(),23,59);
				
				datosTarea.setFechaDesde(calFechaDesde);
				datosTarea.setFechaHasta(calFechaHasta);

				}
				else
				{
					if(log.isDebugEnabled())log.debug("es periodica");
				}
				
			try
			{
			
    		trabajo.setTrabajo(((FormularioInformeFechaRangoIIAceptarFormImpl) form).getTrabajo());
    		trabajo.setGrupoTrabajo(((FormularioInformeFechaRangoIIAceptarFormImpl) form).getGrupoTrabajo());
    		
    		datosTarea.setTrabajo(((FormularioInformeFechaRangoIIAceptarFormImpl) form).getTrabajo());
    		datosTarea.setGrupoTrabajo(((FormularioInformeFechaRangoIIAceptarFormImpl) form).getGrupoTrabajo());
    		datosTarea.setTrigger(((FormularioInformeFechaRangoIIAceptarFormImpl) form).getTrigger());
    		datosTarea.setGrupoTrigger(((FormularioInformeFechaRangoIIAceptarFormImpl) form).getGrupoTrigger());
    		datosTarea.setPeriodicidad(((FormularioInformeFechaRangoIIAceptarFormImpl) form).getPeriodicidad());
    		datosTarea.setFormato(((FormularioInformeFechaRangoIIAceptarFormImpl) form).getFormato());
    		datosTarea.setRango(((FormularioInformeFechaRangoIIAceptarFormImpl) form).getRango());
    		datosTarea.setInforme(((FormularioInformeFechaRangoIIAceptarFormImpl) form).getInforme());
    		datosTarea.setMsgInforme(((FormularioInformeFechaRangoIIAceptarFormImpl) form).getMsgInforme());
    		datosTarea.setMsgNoInforme(((FormularioInformeFechaRangoIIAceptarFormImpl) form).getMsgNoInforme());
    		datosTarea.setMsgDescripcionTrabajo(((FormularioInformeFechaRangoIIAceptarFormImpl) form).getMsgDescTrabajo());
			
    		
	        Calendar cal = Calendar.getInstance(tz);    		
	        cal = new GregorianCalendar(
	        		new Integer (anio).intValue(), 
	        		new Integer (mes).intValue() -1,
	        		new Integer (dia).intValue() ,
	        		new Integer (hora).intValue(), 
	        		new Integer (minutos).intValue());
	        
	        datosTarea.setFechaInicio(cal);
    		
    		datosTarea.setUsuario(LdapUserDetailsUtils.getUsuario());
    	
    		TareaInformesVO tareaRecuperada = this.getSrvPlanificadorService().modificarTareaInformes(datosTarea, trabajo);
    		form.setTareaModificada(tareaRecuperada.getTrabajo());

    		}catch(Exception e)
    		{
    			log.error("Error: " + e);
            	throw new ValidatorException("{tareas.error}");
    		}
        }
    	catch (ValidatorException ve)
        {
        	log.error("error "+ve);
        	throw ve;
        }
        catch (Exception e)
        {
        	log.error("Error: " + e);
        	//throw new ValidatorException("{tareas.error}");
        }
    }

    
    /**
     * Metodo que guarda los cambios que se han echo en la tarea informeFechaUsuario
     */
    public void modificarTareaInformeFechaUsuario(org.apache.struts.action.ActionMapping mapping, 
    		es.pode.administracion.presentacion.planificador.modificarTarea.ModificarTareaInformeFechaUsuarioForm form, 
    		javax.servlet.http.HttpServletRequest request, 
    		javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	if (tz == null) 
    		tz = utilidades.asignarZonaHoraria();
    	
		TrabajoVO trabajo = new TrabajoVO(); // Trabajo a modificar
		TareaInformesVO datosTarea = new TareaInformesVO(); // Datos a modificar
				
		String dia = new String(((FormularioInformeFechaUsuarioIIAceptarFormImpl)form).getDia());
    	String mes = new String(((FormularioInformeFechaUsuarioIIAceptarFormImpl)form).getMes());
    	String anio = new String(((FormularioInformeFechaUsuarioIIAceptarFormImpl)form).getAnio());
    	String hora = new String(((FormularioInformeFechaUsuarioIIAceptarFormImpl)form).getHora());
    	String minutos = new String(((FormularioInformeFechaUsuarioIIAceptarFormImpl)form).getMinutos());
    	
		
    	try
        {    				
		
			if(((FormularioInformeFechaRangoIIAceptarFormImpl)form).getPeriodicidad().equalsIgnoreCase("N"))
			{
				String anioDesde = new String(((FormularioInformeFechaUsuarioIIAceptarFormImpl)form).getAnioDesde());
		    	String mesDesde = new String(((FormularioInformeFechaUsuarioIIAceptarFormImpl)form).getMesDesde());
		    	String diaDesde = new String(((FormularioInformeFechaUsuarioIIAceptarFormImpl)form).getDiaDesde());
		    	String anioHasta = new String(((FormularioInformeFechaUsuarioIIAceptarFormImpl)form).getAnioHasta());
		    	String mesHasta = new String(((FormularioInformeFechaUsuarioIIAceptarFormImpl)form).getMesHasta());
		    	String diaHasta = new String(((FormularioInformeFechaUsuarioIIAceptarFormImpl)form).getDiaHasta());
			
	    		//Comprobamos que todos los campos de la fecha de inicio están rellenos
	    		if(anioDesde.equalsIgnoreCase("") || mesDesde.equalsIgnoreCase("") || diaDesde.equalsIgnoreCase(""))
	    			
	    			throw new ValidatorException("{informes.crearInformes.fechaDesdeCampoVacio}");
	    		
	    		//Comprobamos que todos los campos de la fecha fin están rellenos
	    		if(anioHasta.equalsIgnoreCase("") || mesHasta.equalsIgnoreCase("") || diaHasta.equalsIgnoreCase(""))
	    			
	    			throw new ValidatorException("{informes.crearInformes.fechaHastaCampoVacio}");
	    		
	    		
	    		//Comprobamos que los campos de las fechas son numeros
	    		if(log.isDebugEnabled())log.debug("comprobamos si las fechas tiene caracteres no numericos");
	    		try
	    		{
	    			new Integer(anioDesde).intValue(); 
	    			new Integer(mesDesde).intValue(); 
	    			new Integer(diaDesde).intValue();
	    		
	    		 	
	    		}catch(Exception e)
	    		{
	    			log.error("Alguno de los campos de la fecha desde no son números");
	    			throw new ValidatorException("{tareas.eliminarOdes.fechaDesde}");
	    		}
	    		try
	    		{
	    			new Integer(anioHasta).intValue(); 
	    			new Integer(mesHasta).intValue(); 
	    			new Integer(diaHasta).intValue();
	    			
	    		 	    		 	
	    		}catch(Exception e)
	    		{
	    			log.error("Alguno de los campos de la fecha hasta no son números");
	    			throw new ValidatorException("{tareas.eliminarOdes.fechaHasta}");
	    		}
	    		
	    		
				// Comprobamos si las fechas introducidas son correctas
				boolean fechaValidaDesde = utilidades.validacionFechaDDMMAAAAHHMM(diaDesde, mesDesde, anioDesde,"yyyyMMdd");

				boolean fechaValidaHasta = utilidades.validacionFechaDDMMAAAAHHMM(diaHasta, mesHasta, anioHasta,"yyyyMMdd");

				boolean comparacionFechaDesdeHasta = utilidades.comparacionFechas(anioDesde, mesDesde, diaDesde, anioHasta, mesHasta, diaHasta);

				if (!fechaValidaHasta && !fechaValidaDesde)
					throw new ValidatorException(
							"{tareas.fechaDesdeHastaIncorrecta}");

				if (!fechaValidaDesde)
					throw new ValidatorException("{tareas.fechaDesdeIncorrecta}");

				if (!fechaValidaHasta)
					throw new ValidatorException("{tareas.fechaHastaIncorrecta}");

				if (!comparacionFechaDesdeHasta)
					throw new ValidatorException("{tareas.fechaDesdeMasQueHasta}");
				
				Calendar calFechaDesde = Calendar.getInstance(tz);
				calFechaDesde = new GregorianCalendar(
	        		new Integer (anioDesde).intValue(), 
	        		new Integer (mesDesde).intValue() -1,
	        		new Integer (diaDesde).intValue(),0,1);
	        		
				Calendar calFechaHasta = Calendar.getInstance(tz);
				calFechaHasta = new GregorianCalendar(
	        		new Integer (anioHasta).intValue(), 
	        		new Integer (mesHasta).intValue() -1,
	        		new Integer (diaHasta).intValue(),23,59);
				
				datosTarea.setFechaDesde(calFechaDesde);
				datosTarea.setFechaHasta(calFechaHasta);
				
				}
				else
				{
					if(log.isDebugEnabled())log.debug("es periodica");
				}

			try
			{
			
    		trabajo.setTrabajo(((FormularioInformeFechaUsuarioIIAceptarFormImpl) form).getTrabajo());
    		trabajo.setGrupoTrabajo(((FormularioInformeFechaUsuarioIIAceptarFormImpl) form).getGrupoTrabajo());
    		
    		datosTarea.setTrabajo(((FormularioInformeFechaUsuarioIIAceptarFormImpl) form).getTrabajo());
    		datosTarea.setGrupoTrabajo(((FormularioInformeFechaUsuarioIIAceptarFormImpl) form).getGrupoTrabajo());
    		datosTarea.setTrigger(((FormularioInformeFechaUsuarioIIAceptarFormImpl) form).getTrigger());
    		datosTarea.setGrupoTrigger(((FormularioInformeFechaUsuarioIIAceptarFormImpl) form).getGrupoTrigger());
    		datosTarea.setPeriodicidad(((FormularioInformeFechaUsuarioIIAceptarFormImpl) form).getPeriodicidad());
    		datosTarea.setFormato(((FormularioInformeFechaUsuarioIIAceptarFormImpl) form).getFormato());
    		datosTarea.setUsuarioInforme(((FormularioInformeFechaUsuarioIIAceptarFormImpl) form).getUsuario());
    		datosTarea.setInforme(((FormularioInformeFechaUsuarioIIAceptarFormImpl) form).getInforme());
    		datosTarea.setMsgInforme(((FormularioInformeFechaUsuarioIIAceptarFormImpl) form).getMsgInforme());
    		datosTarea.setMsgNoInforme(((FormularioInformeFechaUsuarioIIAceptarFormImpl) form).getMsgNoInforme());
    		datosTarea.setMsgDescripcionTrabajo(((FormularioInformeFechaUsuarioIIAceptarFormImpl) form).getMsgDescTrabajo());
			
    		
	        Calendar cal = Calendar.getInstance(tz);    		
	        cal = new GregorianCalendar(
	        		new Integer (anio).intValue(), 
	        		new Integer (mes).intValue() -1,
	        		new Integer (dia).intValue() ,
	        		new Integer (hora).intValue(), 
	        		new Integer (minutos).intValue());
	        
	        
	        datosTarea.setFechaInicio(cal);
    		
    		datosTarea.setUsuario(LdapUserDetailsUtils.getUsuario());
    		
    		TareaInformesVO tareaRecuperada = this.getSrvPlanificadorService().modificarTareaInformes(datosTarea, trabajo);
    		form.setTareaModificada(tareaRecuperada.getTrabajo());

    		
			}catch(Exception e)
			{
				log.error("se produce un error "+e);
				throw new ValidatorException("{tareas.error}");
			}
        }
    	catch (ValidatorException ve)
        {
        	log.error("error "+ve);
        	throw ve;
        }
        catch (Exception e)
        {
        	log.error("Error: " + e);
        	//throw new ValidatorException("{tareas.error}");
        }
    }
    
    /**
     * Metodo que modifica la tarea de informes Federados con los nuevos datos
     */
    public void modificarTareaInformeFederado(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ModificarTareaInformeFederadoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	if (tz == null) 
    		tz = utilidades.asignarZonaHoraria();
    	
    	String dia = new String(((FormularioInformeFederadoIIAceptarFormImpl)form).getDia());
    	String mes = new String(((FormularioInformeFederadoIIAceptarFormImpl)form).getMes());
    	String anio = new String(((FormularioInformeFederadoIIAceptarFormImpl)form).getAnio());
    	String hora = new String(((FormularioInformeFederadoIIAceptarFormImpl)form).getHora());
    	String minutos = new String(((FormularioInformeFederadoIIAceptarFormImpl)form).getMinutos());
    	
    	
		TrabajoVO trabajo = new TrabajoVO(); // Trabajo a modificar
		TareaInformesVO datosTarea = new TareaInformesVO(); // Datos a modificar
					
				
		try
		{
		
		trabajo.setTrabajo(((FormularioInformeFederadoIIAceptarFormImpl) form).getTrabajo());
		trabajo.setGrupoTrabajo(((FormularioInformeFederadoIIAceptarFormImpl) form).getGrupoTrabajo());
		
		datosTarea.setTrabajo(((FormularioInformeFederadoIIAceptarFormImpl) form).getTrabajo());
		datosTarea.setGrupoTrabajo(((FormularioInformeFederadoIIAceptarFormImpl) form).getGrupoTrabajo());
		datosTarea.setTrigger(((FormularioInformeFederadoIIAceptarFormImpl) form).getTrigger());
		datosTarea.setGrupoTrigger(((FormularioInformeFederadoIIAceptarFormImpl) form).getGrupoTrigger());
		datosTarea.setPeriodicidad(((FormularioInformeFederadoIIAceptarFormImpl) form).getPeriodicidad());
		datosTarea.setFormato(((FormularioInformeFederadoIIAceptarFormImpl) form).getFormato());
		datosTarea.setInforme(((FormularioInformeFederadoIIAceptarFormImpl) form).getInforme());
		datosTarea.setMsgInforme(((FormularioInformeFederadoIIAceptarFormImpl) form).getMsgInforme());
		datosTarea.setMsgNoInforme(((FormularioInformeFederadoIIAceptarFormImpl) form).getMsgNoInforme());
		datosTarea.setMsgDescripcionTrabajo(((FormularioInformeFederadoIIAceptarFormImpl) form).getMsgDescTrabajo());
		
		
        Calendar cal = Calendar.getInstance(tz);    		
        cal = new GregorianCalendar(
        		new Integer (anio).intValue(), 
        		new Integer (mes).intValue() -1,
        		new Integer (dia).intValue() ,
        		new Integer (hora).intValue(), 
        		new Integer (minutos).intValue());
        
        datosTarea.setFechaInicio(cal);
		
		datosTarea.setUsuario(LdapUserDetailsUtils.getUsuario());
	
		TareaInformesVO tareaRecuperada = this.getSrvPlanificadorService().modificarTareaInformesFederado(datosTarea, trabajo);
		form.setTareaModificada(tareaRecuperada.getTrabajo());

		}catch(Exception e)
		{
			log.error("Error: " + e);
        	throw new ValidatorException("{tareas.error}");
		}
        
        
    }
    
    
   

    
}