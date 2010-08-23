/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.planificador.descripcionTarea;


import java.util.Calendar;
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
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;


public class DescripcionTareaControllerImpl extends DescripcionTareaController
{

	private static Logger log = Logger.getLogger(DescripcionTareaControllerImpl.class);
	private static TimeZone tz = null;
	Utiles utilidades = new Utiles();
	private Properties pSpringProperties = null;

	
	/**
	 * Método que discrimina la tarea a crear
	 * 
	 * Retorna 1: Carga de ODEs 2: Reindexado 3: Eliminar ODEs 4:Infome fecha 5:Informe rango 6:Informe usuario 7:Informe Federado 8:Informe catalogo
	 */
    public final String obtenerTipoTarea(ActionMapping mapping, ObtenerTipoTareaForm form, 
    		HttpServletRequest request, HttpServletResponse response) throws Exception
    {
		String tipoTarea = null;
		String tipoTareaDevolver = null;
		
	    try
	    {	
	    	//obtnemos el tipoTarea
	        TrabajoVO trabajo = new TrabajoVO();
	        
	        trabajo.setTrabajo(form.getTrabajo());
	        trabajo.setGrupoTrabajo(form.getGrupoTrabajo());
	        trabajo.setUsuario(LdapUserDetailsUtils.getUsuario());
	        
	        tipoTarea = this.getSrvPlanificadorService().obtenerTipoTarea(trabajo);
	        if(log.isDebugEnabled())log.debug("el tipo de tarea al recogerlo vale -> " + tipoTarea);

	        //si el tipoTarea es de informes debemos mirar que informe concreto es para redirigirnos a una de las 3 pantallas de informes
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
	        
	        //el tipoTarea es informeFederado
	        else if(tipoTarea.equalsIgnoreCase("GenerarInformeFederado"))
			{
				tipoTareaDevolver = "InformeFederado";
			}
	        else if(tipoTarea.equalsIgnoreCase("repositorio"))
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


    public final void obtenerTareaModificarCargaODEs(ActionMapping mapping, ObtenerTareaModificarCargaODEsForm form, 
    		HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    
    	
    	if (tz == null) 
    		tz = utilidades.asignarZonaHoraria();
    	
    	TareaVO tarea = new TareaVO();
 	 
    	try
        {       		   		
       		
    		tarea.setTrabajo(((DescripcionTareaFormImpl) form).getTrabajo());
    		tarea.setGrupoTrabajo(((DescripcionTareaFormImpl) form).getGrupoTrabajo());
    		tarea.setTrigger(((DescripcionTareaFormImpl) form).getTrigger());
    		tarea.setGrupoTrigger(((DescripcionTareaFormImpl) form).getGrupoTrigger());
    		tarea.setPeriodicidad(((DescripcionTareaFormImpl) form).getPeriodicidad());
    		
    		TareaCargaODEsVO tareaCargaODEs = this.getSrvPlanificadorService().obtenerTareaModificarCargaODEs(tarea);
    	
    		tareaCargaODEs.getFechaInicio().setTimeZone(tz);

    		((DescripcionTareaFormImpl) form).setPeriodicidad(tareaCargaODEs.getPeriodicidad());
    		((DescripcionTareaFormImpl) form).setPathODEs(tareaCargaODEs.getPathODE());
    		((DescripcionTareaFormImpl) form).setPathODEsCargados(tareaCargaODEs.getPathODEsCargados());
    		((DescripcionTareaFormImpl) form).setPathODEsNoCargados(tareaCargaODEs.getPathODEsNoCargados());
    		((DescripcionTareaFormImpl) form).setTipoTarea(tareaCargaODEs.getTipoTarea());  
    		((DescripcionTareaFormImpl) form).setAnio(new Integer (tareaCargaODEs.getFechaInicio().get(Calendar.YEAR)));
    		((DescripcionTareaFormImpl) form).setMes(new Integer (tareaCargaODEs.getFechaInicio().get(Calendar.MONTH) + 1));
    		((DescripcionTareaFormImpl) form).setDia(new Integer (tareaCargaODEs.getFechaInicio().get(Calendar.DAY_OF_MONTH)));
    		((DescripcionTareaFormImpl) form).setHora(new Integer (tareaCargaODEs.getFechaInicio().get(Calendar.HOUR_OF_DAY)));
    		((DescripcionTareaFormImpl) form).setMinutos(new Integer (tareaCargaODEs.getFechaInicio().get(Calendar.MINUTE)));
    		((DescripcionTareaFormImpl) form).setMsgPublicado(tareaCargaODEs.getMsgPublicado());
    		((DescripcionTareaFormImpl) form).setMsgNoPublicado(tareaCargaODEs.getMsgNoPublicado());
    		((DescripcionTareaFormImpl) form).setMsgDescCargaODEs(tareaCargaODEs.getMsgDescripcionTrabajo());
    		((DescripcionTareaFormImpl) form).setSobrescribir(tareaCargaODEs.getSobrescribir());

        }
        catch (Exception e)
        {
        	log.error("Error: " + e);
        	throw new ValidatorException("{tareas.error}");
        }	
     }


    public final void obtenerTareaReindexado(ActionMapping mapping, 
    		es.pode.administracion.presentacion.planificador.descripcionTarea.ObtenerTareaReindexadoForm form, 
    		HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	
    	
    	if (tz == null) 
    		tz = utilidades.asignarZonaHoraria();
    	
    	TareaVO tarea = new TareaVO();
    	
    	try
        {    	
       		
    		tarea.setTrabajo(((DescripcionTareaFormImpl) form).getTrabajo());
    		tarea.setGrupoTrabajo(((DescripcionTareaFormImpl) form).getGrupoTrabajo());
    		tarea.setTrigger(((DescripcionTareaFormImpl) form).getTrigger());
    		tarea.setGrupoTrigger(((DescripcionTareaFormImpl) form).getGrupoTrigger());
    		tarea.setPeriodicidad(((DescripcionTareaFormImpl) form).getPeriodicidad());
    		
    		TareaReindexadoVO tareaReindexado = this.getSrvPlanificadorService().obtenerTareaReindexado(tarea);
    		
    		tareaReindexado.getFechaInicio().setTimeZone(tz);
    		
    		((DescripcionTareaFormImpl) form).setPeriodicidad(tareaReindexado.getPeriodicidad());
    		((DescripcionTareaFormImpl) form).setRepositorio(tareaReindexado.getRepositorioIndices());
    		((DescripcionTareaFormImpl) form).setTipoTarea(tareaReindexado.getTipoTarea());    		
    		((DescripcionTareaFormImpl) form).setAnio(new Integer (tareaReindexado.getFechaInicio().get(Calendar.YEAR)));
    		((DescripcionTareaFormImpl) form).setMes(new Integer (tareaReindexado.getFechaInicio().get(Calendar.MONTH) + 1));
    		((DescripcionTareaFormImpl) form).setDia(new Integer (tareaReindexado.getFechaInicio().get(Calendar.DAY_OF_MONTH)));
    		((DescripcionTareaFormImpl) form).setHora(new Integer (tareaReindexado.getFechaInicio().get(Calendar.HOUR_OF_DAY)));
    		((DescripcionTareaFormImpl) form).setMinutos(new Integer (tareaReindexado.getFechaInicio().get(Calendar.MINUTE)));
    		((DescripcionTareaFormImpl) form).setMsgReindexado(tareaReindexado.getMsgReindexado());
    		((DescripcionTareaFormImpl) form).setMsgNoReindexado(tareaReindexado.getMsgNoReindexado());
    		((DescripcionTareaFormImpl) form).setMsgDescReindexado(tareaReindexado.getMsgDescripcionTrabajo());
        }
        catch (Exception e)
        {
        	log.error("Error: " + e);
        	throw new ValidatorException("{tareas.error}");
        }
     }
    
    public void obtenerTareaEliminarOdes(org.apache.struts.action.ActionMapping mapping, 
    		es.pode.administracion.presentacion.planificador.descripcionTarea.ObtenerTareaEliminarOdesForm form, 
    		javax.servlet.http.HttpServletRequest request, 
    		javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	
    	
    	if (tz == null) 
    		tz = utilidades.asignarZonaHoraria();
    	
    	TareaVO tarea = new TareaVO();
    	
    	try
        {    	
       		
    		tarea.setTrabajo(((DescripcionTareaFormImpl) form).getTrabajo());
    		tarea.setGrupoTrabajo(((DescripcionTareaFormImpl) form).getGrupoTrabajo());
    		tarea.setTrigger(((DescripcionTareaFormImpl) form).getTrigger());
    		tarea.setGrupoTrigger(((DescripcionTareaFormImpl) form).getGrupoTrigger());
    		tarea.setPeriodicidad(((DescripcionTareaFormImpl) form).getPeriodicidad());
    		
    		TareaEliminaNoDisponiblesVO tareaEliminarOdes = this.getSrvPlanificadorService().obtenerTareaEliminarrNoDisponibles(tarea);
    		
    		tareaEliminarOdes.getFechaInicio().setTimeZone(tz);
    		tareaEliminarOdes.getFechaDesde().setTimeZone(tz);
    		tareaEliminarOdes.getFechaHasta().setTimeZone(tz);
    		
    		((DescripcionTareaFormImpl) form).setPeriodicidad(tareaEliminarOdes.getPeriodicidad());
    		((DescripcionTareaFormImpl) form).setTipoTarea(tareaEliminarOdes.getTipoTarea());    		
    		((DescripcionTareaFormImpl) form).setAnio(new Integer (tareaEliminarOdes.getFechaInicio().get(Calendar.YEAR)));
    		((DescripcionTareaFormImpl) form).setMes(new Integer (tareaEliminarOdes.getFechaInicio().get(Calendar.MONTH) + 1));
    		((DescripcionTareaFormImpl) form).setDia(new Integer (tareaEliminarOdes.getFechaInicio().get(Calendar.DAY_OF_MONTH)));
    		((DescripcionTareaFormImpl) form).setHora(new Integer (tareaEliminarOdes.getFechaInicio().get(Calendar.HOUR_OF_DAY)));
    		((DescripcionTareaFormImpl) form).setMinutos(new Integer (tareaEliminarOdes.getFechaInicio().get(Calendar.MINUTE)));
    		((DescripcionTareaFormImpl) form).setAnioDesde(new Integer (tareaEliminarOdes.getFechaDesde().get(Calendar.YEAR)));
    		((DescripcionTareaFormImpl) form).setMesDesde(new Integer (tareaEliminarOdes.getFechaDesde().get(Calendar.MONTH) + 1));
    		((DescripcionTareaFormImpl) form).setDiaDesde(new Integer (tareaEliminarOdes.getFechaDesde().get(Calendar.DAY_OF_MONTH)));
    		((DescripcionTareaFormImpl) form).setAnioHasta(new Integer (tareaEliminarOdes.getFechaHasta().get(Calendar.YEAR)));
    		((DescripcionTareaFormImpl) form).setMesHasta(new Integer (tareaEliminarOdes.getFechaHasta().get(Calendar.MONTH) + 1));
    		((DescripcionTareaFormImpl) form).setDiaHasta(new Integer (tareaEliminarOdes.getFechaHasta().get(Calendar.DAY_OF_MONTH)));
    		((DescripcionTareaFormImpl) form).setMsgEliminado(tareaEliminarOdes.getMsgEliminado());
    		((DescripcionTareaFormImpl) form).setMsgNoEliminado(tareaEliminarOdes.getMsgNoEliminado());
    		((DescripcionTareaFormImpl) form).setMsgDescTrabajo(tareaEliminarOdes.getMsgDescripcionTrabajo());
        }
        catch (Exception e)
        {
        	log.error("Error: " + e);
        	throw new ValidatorException("{tareas.error}");
        }
       
    }
    
    
    /**
     * 
     */
    public void obtenerTareaInformeFecha(org.apache.struts.action.ActionMapping mapping, 
    		es.pode.administracion.presentacion.planificador.descripcionTarea.ObtenerTareaInformeFechaForm form, 
    		javax.servlet.http.HttpServletRequest request, 
    		javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	
    	if (tz == null) 
    		tz = utilidades.asignarZonaHoraria();
    	
    	TareaInformesVO tarea = new TareaInformesVO();
    	
    	try
        {    	
       		
    		//cargamos la tarea con lo valores esenciales para recuperar los demas valores de esta misma tarea
    		tarea.setTrabajo(((DescripcionTareaFormImpl) form).getTrabajo());
    		tarea.setGrupoTrabajo(((DescripcionTareaFormImpl) form).getGrupoTrabajo());
    		tarea.setTrigger(((DescripcionTareaFormImpl) form).getTrigger());
    		tarea.setGrupoTrigger(((DescripcionTareaFormImpl) form).getGrupoTrigger());
    		tarea.setPeriodicidad(((DescripcionTareaFormImpl) form).getPeriodicidad());
    		
    		//llamamos al servicio para que carge los valores en la tarea del tipo correspondiente
    		TareaInformesVO tareaInformes = this.getSrvPlanificadorService().obtenerTareaInformes(tarea);
    		
    		//asignamos a las fechas la franja horaria correspondiente
    		tareaInformes.getFechaInicio().setTimeZone(tz);
    		if(tareaInformes.getPeriodicidad().equalsIgnoreCase("N"))
    		{
    			if(log.isDebugEnabled())log.debug("No es periodica");
    			tareaInformes.getFechaDesde().setTimeZone(tz);
        		tareaInformes.getFechaHasta().setTimeZone(tz);
        		((DescripcionTareaFormImpl) form).setDiaDesde(new Integer (tareaInformes.getFechaDesde().get(Calendar.DAY_OF_MONTH)));
        		((DescripcionTareaFormImpl) form).setMesDesde(new Integer (tareaInformes.getFechaDesde().get(Calendar.MONTH) + 1));
        		((DescripcionTareaFormImpl) form).setAnioDesde(new Integer (tareaInformes.getFechaDesde().get(Calendar.YEAR)));
        		((DescripcionTareaFormImpl) form).setDiaHasta(new Integer (tareaInformes.getFechaHasta().get(Calendar.DAY_OF_MONTH)));
        		((DescripcionTareaFormImpl) form).setMesHasta(new Integer (tareaInformes.getFechaHasta().get(Calendar.MONTH) + 1));
        		((DescripcionTareaFormImpl) form).setAnioHasta(new Integer (tareaInformes.getFechaHasta().get(Calendar.YEAR)));
    		}else
    		{
    			if(log.isDebugEnabled())log.debug("es periodica");
    		}
    		
    		//rellenamos los datos especificos de este tipo de tarea
    		((DescripcionTareaFormImpl) form).setPeriodicidad(tareaInformes.getPeriodicidad());
    		((DescripcionTareaFormImpl) form).setTipoTarea(tareaInformes.getInforme());
    		((DescripcionTareaFormImpl) form).setFormato(tareaInformes.getFormato());
    		((DescripcionTareaFormImpl) form).setInforme(tareaInformes.getInforme());
    		((DescripcionTareaFormImpl) form).setAnio(new Integer (tareaInformes.getFechaInicio().get(Calendar.YEAR)));
    		((DescripcionTareaFormImpl) form).setMes(new Integer (tareaInformes.getFechaInicio().get(Calendar.MONTH) + 1));
    		((DescripcionTareaFormImpl) form).setDia(new Integer (tareaInformes.getFechaInicio().get(Calendar.DAY_OF_MONTH)));
    		((DescripcionTareaFormImpl) form).setHora(new Integer (tareaInformes.getFechaInicio().get(Calendar.HOUR_OF_DAY)));
    		((DescripcionTareaFormImpl) form).setMinutos(new Integer (tareaInformes.getFechaInicio().get(Calendar.MINUTE)));
       		((DescripcionTareaFormImpl) form).setMsgInforme(tareaInformes.getMsgInforme());
    		((DescripcionTareaFormImpl) form).setMsgNoInforme(tareaInformes.getMsgNoInforme());
    		((DescripcionTareaFormImpl) form).setMsgDescTrabajo(tareaInformes.getMsgDescripcionTrabajo());
        }
        catch (Exception e)
        {
        	log.error("Error: " + e);
        	throw new ValidatorException("{tareas.error}");
        }	
    }

    /**
     * 
     */
    public void obtenerTareaInformeFechaRango(org.apache.struts.action.ActionMapping mapping, 
    		es.pode.administracion.presentacion.planificador.descripcionTarea.ObtenerTareaInformeFechaRangoForm form, 
    		javax.servlet.http.HttpServletRequest request, 
    		javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	
    	
    	if (tz == null) 
    		tz = utilidades.asignarZonaHoraria();
    	
    	TareaInformesVO tarea = new TareaInformesVO();
    	
    	try
        {    	
       		
    		//cargamos la tarea con lo valores esenciales para recuperar los demas valores de esta misma tarea
    		tarea.setTrabajo(((DescripcionTareaFormImpl) form).getTrabajo());
    		tarea.setGrupoTrabajo(((DescripcionTareaFormImpl) form).getGrupoTrabajo());
    		tarea.setTrigger(((DescripcionTareaFormImpl) form).getTrigger());
    		tarea.setGrupoTrigger(((DescripcionTareaFormImpl) form).getGrupoTrigger());
    		tarea.setPeriodicidad(((DescripcionTareaFormImpl) form).getPeriodicidad());
    		
    		//llamamos al servicio para que carge los valores en la tarea del tipo correspondiente
    		TareaInformesVO tareaInformes = this.getSrvPlanificadorService().obtenerTareaInformes(tarea);
    		
    		//asignamos a las fechas la franja horaria correspondiente
    		tareaInformes.getFechaInicio().setTimeZone(tz);
    		if(tareaInformes.getPeriodicidad().equalsIgnoreCase("N"))
    		{
    			if(log.isDebugEnabled())log.debug("No es periodica");
    			tareaInformes.getFechaDesde().setTimeZone(tz);
        		tareaInformes.getFechaHasta().setTimeZone(tz);
        		((DescripcionTareaFormImpl) form).setDiaDesde(new Integer (tareaInformes.getFechaDesde().get(Calendar.DAY_OF_MONTH)));
        		((DescripcionTareaFormImpl) form).setMesDesde(new Integer (tareaInformes.getFechaDesde().get(Calendar.MONTH) + 1));
        		((DescripcionTareaFormImpl) form).setAnioDesde(new Integer (tareaInformes.getFechaDesde().get(Calendar.YEAR)));
        		((DescripcionTareaFormImpl) form).setDiaHasta(new Integer (tareaInformes.getFechaHasta().get(Calendar.DAY_OF_MONTH)));
        		((DescripcionTareaFormImpl) form).setMesHasta(new Integer (tareaInformes.getFechaHasta().get(Calendar.MONTH) + 1));
        		((DescripcionTareaFormImpl) form).setAnioHasta(new Integer (tareaInformes.getFechaHasta().get(Calendar.YEAR)));
    		}else
    		{
    			if(log.isDebugEnabled())log.debug("es periodica");
    		}
    		
    		
    		//rellenamos los datos especificos de este tipo de tarea
    		((DescripcionTareaFormImpl) form).setPeriodicidad(tareaInformes.getPeriodicidad());
    		((DescripcionTareaFormImpl) form).setTipoTarea(tareaInformes.getInforme());
    		((DescripcionTareaFormImpl) form).setFormato(tareaInformes.getFormato());
    		((DescripcionTareaFormImpl) form).setInforme(tareaInformes.getInforme());
    		((DescripcionTareaFormImpl) form).setRango(tareaInformes.getRango());
    		((DescripcionTareaFormImpl) form).setAnio(new Integer (tareaInformes.getFechaInicio().get(Calendar.YEAR)));
    		((DescripcionTareaFormImpl) form).setMes(new Integer (tareaInformes.getFechaInicio().get(Calendar.MONTH) + 1));
    		((DescripcionTareaFormImpl) form).setDia(new Integer (tareaInformes.getFechaInicio().get(Calendar.DAY_OF_MONTH)));
    		((DescripcionTareaFormImpl) form).setHora(new Integer (tareaInformes.getFechaInicio().get(Calendar.HOUR_OF_DAY)));
    		((DescripcionTareaFormImpl) form).setMinutos(new Integer (tareaInformes.getFechaInicio().get(Calendar.MINUTE)));
       		((DescripcionTareaFormImpl) form).setMsgInforme(tareaInformes.getMsgInforme());
    		((DescripcionTareaFormImpl) form).setMsgNoInforme(tareaInformes.getMsgNoInforme());
    		((DescripcionTareaFormImpl) form).setMsgDescTrabajo(tareaInformes.getMsgDescripcionTrabajo());
        }
        catch (Exception e)
        {
        	log.error("Error: " + e);
        	throw new ValidatorException("{tareas.error}");
        }
    }

    /**
     * 
     */
    public void obtenerTareaInformeFechaUsuario(org.apache.struts.action.ActionMapping mapping, 
    		es.pode.administracion.presentacion.planificador.descripcionTarea.ObtenerTareaInformeFechaUsuarioForm form, 
    		javax.servlet.http.HttpServletRequest request, 
    		javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	
    	if (tz == null) 
    		tz = utilidades.asignarZonaHoraria();
    	
    	TareaInformesVO tarea = new TareaInformesVO();
    	
    	try
        {    	
       		    		
    		//cargamos la tarea con lo valores esenciales para recuperar los demas valores de esta misma tarea
    		tarea.setTrabajo(((DescripcionTareaFormImpl) form).getTrabajo());
    		tarea.setGrupoTrabajo(((DescripcionTareaFormImpl) form).getGrupoTrabajo());
    		tarea.setTrigger(((DescripcionTareaFormImpl) form).getTrigger());
    		tarea.setGrupoTrigger(((DescripcionTareaFormImpl) form).getGrupoTrigger());
    		tarea.setPeriodicidad(((DescripcionTareaFormImpl) form).getPeriodicidad());
    		
    		//llamamos al servicio para que carge los valores en la tarea del tipo correspondiente
    		TareaInformesVO tareaInformes = this.getSrvPlanificadorService().obtenerTareaInformes(tarea);
    		
    		//asignamos a las fechas la franja horaria correspondiente
    		tareaInformes.getFechaInicio().setTimeZone(tz);
    		if(tareaInformes.getPeriodicidad().equalsIgnoreCase("N"))
    		{
    			if(log.isDebugEnabled())log.debug("No es periodica");
    			tareaInformes.getFechaDesde().setTimeZone(tz);
        		tareaInformes.getFechaHasta().setTimeZone(tz);
        		((DescripcionTareaFormImpl) form).setDiaDesde(new Integer (tareaInformes.getFechaDesde().get(Calendar.DAY_OF_MONTH)));
        		((DescripcionTareaFormImpl) form).setMesDesde(new Integer (tareaInformes.getFechaDesde().get(Calendar.MONTH) + 1));
        		((DescripcionTareaFormImpl) form).setAnioDesde(new Integer (tareaInformes.getFechaDesde().get(Calendar.YEAR)));
        		((DescripcionTareaFormImpl) form).setDiaHasta(new Integer (tareaInformes.getFechaHasta().get(Calendar.DAY_OF_MONTH)));
        		((DescripcionTareaFormImpl) form).setMesHasta(new Integer (tareaInformes.getFechaHasta().get(Calendar.MONTH) + 1));
        		((DescripcionTareaFormImpl) form).setAnioHasta(new Integer (tareaInformes.getFechaHasta().get(Calendar.YEAR)));    		

    		}else
    		{
    			if(log.isDebugEnabled())log.debug("es periodica");
    		}
    		
    		
    		//rellenamos los datos especificos de este tipo de tarea
    		((DescripcionTareaFormImpl) form).setPeriodicidad(tareaInformes.getPeriodicidad());
    		((DescripcionTareaFormImpl) form).setTipoTarea(tareaInformes.getInforme());
    		((DescripcionTareaFormImpl) form).setFormato(tareaInformes.getFormato());
    		((DescripcionTareaFormImpl) form).setInforme(tareaInformes.getInforme());
    		((DescripcionTareaFormImpl) form).setUsuario(tareaInformes.getUsuarioInforme());
    		((DescripcionTareaFormImpl) form).setAnio(new Integer (tareaInformes.getFechaInicio().get(Calendar.YEAR)));
    		((DescripcionTareaFormImpl) form).setMes(new Integer (tareaInformes.getFechaInicio().get(Calendar.MONTH) + 1));
    		((DescripcionTareaFormImpl) form).setDia(new Integer (tareaInformes.getFechaInicio().get(Calendar.DAY_OF_MONTH)));
    		((DescripcionTareaFormImpl) form).setHora(new Integer (tareaInformes.getFechaInicio().get(Calendar.HOUR_OF_DAY)));
    		((DescripcionTareaFormImpl) form).setMinutos(new Integer (tareaInformes.getFechaInicio().get(Calendar.MINUTE)));
       		((DescripcionTareaFormImpl) form).setMsgInforme(tareaInformes.getMsgInforme());
    		((DescripcionTareaFormImpl) form).setMsgNoInforme(tareaInformes.getMsgNoInforme());
    		((DescripcionTareaFormImpl) form).setMsgDescTrabajo(tareaInformes.getMsgDescripcionTrabajo());
        }
        catch (Exception e)
        {
        	log.error("Error: " + e);
        	throw new ValidatorException("{tareas.error}");
        }
    }
    
    
    public void obternerTareaInformeFederado(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.descripcionTarea.ObternerTareaInformeFederadoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	if (tz == null) 
    		tz = utilidades.asignarZonaHoraria();
    	
    	TareaInformesVO tarea = new TareaInformesVO();
    	
    	try
        {    	
       		    		
    		//cargamos la tarea con lo valores esenciales para recuperar los demas valores de esta misma tarea
    		tarea.setTrabajo(((DescripcionTareaFormImpl) form).getTrabajo());
    		tarea.setGrupoTrabajo(((DescripcionTareaFormImpl) form).getGrupoTrabajo());
    		tarea.setTrigger(((DescripcionTareaFormImpl) form).getTrigger());
    		tarea.setGrupoTrigger(((DescripcionTareaFormImpl) form).getGrupoTrigger());
    		tarea.setPeriodicidad(((DescripcionTareaFormImpl) form).getPeriodicidad());
    		
    		//llamamos al servicio para que carge los valores en la tarea del tipo correspondiente
    		TareaInformesVO tareaInformes = this.getSrvPlanificadorService().obtenerTareaInformes(tarea);
    		
    		//asignamos a las fechas la franja horaria correspondiente
    		tareaInformes.getFechaInicio().setTimeZone(tz);
    		
    		
    		//rellenamos los datos especificos de este tipo de tarea
    		((DescripcionTareaFormImpl) form).setPeriodicidad(tareaInformes.getPeriodicidad());
    		((DescripcionTareaFormImpl) form).setTipoTarea(tareaInformes.getInforme());
    		((DescripcionTareaFormImpl) form).setFormato(tareaInformes.getFormato());
    		((DescripcionTareaFormImpl) form).setInforme(tareaInformes.getInforme());
    		((DescripcionTareaFormImpl) form).setAnio(new Integer (tareaInformes.getFechaInicio().get(Calendar.YEAR)));
    		((DescripcionTareaFormImpl) form).setMes(new Integer (tareaInformes.getFechaInicio().get(Calendar.MONTH) + 1));
    		((DescripcionTareaFormImpl) form).setDia(new Integer (tareaInformes.getFechaInicio().get(Calendar.DAY_OF_MONTH)));
    		((DescripcionTareaFormImpl) form).setHora(new Integer (tareaInformes.getFechaInicio().get(Calendar.HOUR_OF_DAY)));
    		((DescripcionTareaFormImpl) form).setMinutos(new Integer (tareaInformes.getFechaInicio().get(Calendar.MINUTE)));
       		((DescripcionTareaFormImpl) form).setMsgInforme(tareaInformes.getMsgInforme());
    		((DescripcionTareaFormImpl) form).setMsgNoInforme(tareaInformes.getMsgNoInforme());
    		((DescripcionTareaFormImpl) form).setMsgDescTrabajo(tareaInformes.getMsgDescripcionTrabajo());
        }
        catch (Exception e)
        {
        	log.error("Error: " + e);
        	throw new ValidatorException("{tareas.error}");
        }
    }
    
    
    public void obtenerTareaInformeCatalogo(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.descripcionTarea.ObtenerTareaInformeCatalogoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	if (tz == null) 
    		tz = utilidades.asignarZonaHoraria();
    	
    	TareaInformesVO tarea = new TareaInformesVO();
    	
    	try
        {    	
       		    		
    		//cargamos la tarea con lo valores esenciales para recuperar los demas valores de esta misma tarea
    		tarea.setTrabajo(((DescripcionTareaFormImpl) form).getTrabajo());
    		tarea.setGrupoTrabajo(((DescripcionTareaFormImpl) form).getGrupoTrabajo());
    		tarea.setTrigger(((DescripcionTareaFormImpl) form).getTrigger());
    		tarea.setGrupoTrigger(((DescripcionTareaFormImpl) form).getGrupoTrigger());
    		tarea.setPeriodicidad(((DescripcionTareaFormImpl) form).getPeriodicidad());
    		
    		//llamamos al servicio para que carge los valores en la tarea del tipo correspondiente
    		TareaInformesVO tareaInformes = this.getSrvPlanificadorService().obtenerTareaInformes(tarea);
    		
    		//asignamos a las fechas la franja horaria correspondiente
    		tareaInformes.getFechaInicio().setTimeZone(tz);
    		
    		
    		//rellenamos los datos especificos de este tipo de tarea
    		((DescripcionTareaFormImpl) form).setPeriodicidad(tareaInformes.getPeriodicidad());
    		((DescripcionTareaFormImpl) form).setTipoTarea(tareaInformes.getInforme());
    		((DescripcionTareaFormImpl) form).setFormato(tareaInformes.getFormato());
    		((DescripcionTareaFormImpl) form).setInforme(tareaInformes.getInforme());
    		((DescripcionTareaFormImpl) form).setAnio(new Integer (tareaInformes.getFechaInicio().get(Calendar.YEAR)));
    		((DescripcionTareaFormImpl) form).setMes(new Integer (tareaInformes.getFechaInicio().get(Calendar.MONTH) + 1));
    		((DescripcionTareaFormImpl) form).setDia(new Integer (tareaInformes.getFechaInicio().get(Calendar.DAY_OF_MONTH)));
    		((DescripcionTareaFormImpl) form).setHora(new Integer (tareaInformes.getFechaInicio().get(Calendar.HOUR_OF_DAY)));
    		((DescripcionTareaFormImpl) form).setMinutos(new Integer (tareaInformes.getFechaInicio().get(Calendar.MINUTE)));
       		((DescripcionTareaFormImpl) form).setMsgInforme(tareaInformes.getMsgInforme());
    		((DescripcionTareaFormImpl) form).setMsgNoInforme(tareaInformes.getMsgNoInforme());
    		((DescripcionTareaFormImpl) form).setMsgDescTrabajo(tareaInformes.getMsgDescripcionTrabajo());
        }
        catch (Exception e)
        {
        	log.error("Error: " + e);
        	throw new ValidatorException("{tareas.error}");
        }
    }
    
    

    
    
}