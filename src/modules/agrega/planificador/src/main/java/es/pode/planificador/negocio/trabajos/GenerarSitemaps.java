/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.planificador.negocio.trabajos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import es.pode.ServiceLocator;
import es.pode.planificador.negocio.comun.CtesPlanificador;
import es.pode.planificador.negocio.servicios.SrvPlanificadorService;
import es.pode.planificador.negocio.servicios.SrvPlanificadorServiceImpl;
import es.pode.planificador.negocio.servicios.TareaVO;
import es.pode.planificador.negocio.servicios.TrabajoVO;
import es.pode.soporte.seguridad.encriptacion.Autenticar;
import es.pode.soporte.utiles.date.DateManager;
import es.agrega.soporte.sitemapProperties.SitemapPropertiesImpl;
import es.agrega.soporte.sitemapProperties.SitemapProperties;


public class GenerarSitemaps implements Job {

	static Log log = LogFactory.getLog(InformesPortada.class);
	
	/**
	 * Ejecuci�n del trabajo Generar ficheros sitemaps
	 */
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		
		String usuario = (String) context.getJobDetail().getJobDataMap().get(CtesPlanificador.USUARIO);
		String horaTrigger, minutosTrigger, segundosTrigger = "";
		GregorianCalendar fechaTriggerCalendar = null;
		Date fechaCreacionTrigger = null;
		String periodicidad = "";
		TrabajoVO trabajo = null;
		TrabajoVO[] trabajoArray = null;
		boolean resultadoEliminacion = false;
		TareaVO tareaCreada = null;
		
		/* A�adimos la seguridad al proceso */
		log("Usuario que lanza la tarea: " + usuario);
        boolean contextoCargado = Autenticar.cargarContextoSeguridad(usuario);
		
		if(!contextoCargado) {
			log.error("ERROR: No han cargado los datos en el contexto de seguridad");
			return;			
		}
		
		//Cogeremos la fecha de StartTime para comprobar si coincide con los valores que aparecen en el fichero sitemap.xml
		// en el caso de que no coincidan modificar� la tarea de generaci�n de los ficheros sitemap 
		
		periodicidad = (String) context.getJobDetail().getJobDataMap().get(CtesPlanificador.PERIODICIDAD);
		log("periodicidad "+periodicidad);
		log("context.getTrigger().getStartTime() "+context.getTrigger().getStartTime());
		fechaCreacionTrigger =  context.getTrigger().getStartTime();
		fechaTriggerCalendar = new GregorianCalendar();
		fechaTriggerCalendar.setTime(fechaCreacionTrigger);
		//Obtenemos la hora, minutos y segundos en los que se lanzar� la tarea
		horaTrigger = new Integer(fechaTriggerCalendar.get(Calendar.HOUR_OF_DAY)).toString();
		log("horaTrigger "+horaTrigger);
		minutosTrigger = new Integer(fechaTriggerCalendar.get(Calendar.MINUTE)).toString();
		log("minutosTrigger "+minutosTrigger);
		segundosTrigger = new Integer(fechaTriggerCalendar.get(Calendar.SECOND)).toString();
		log("segundosTrigger "+segundosTrigger);
		
		
		
		try {
			log("Invocamos la tarea de generacion de sitemaps");
			SrvPlanificadorService servicio = ServiceLocator.instance().getSrvPlanificadorService();
			servicio.generarSitemaps();
			log("Se han generado los ficheros sitemaps");
			//comprobar� si se ha modificado el fichero sitemap.xml,en ese caso
			//eliminar� la tarea de generaci�n de sitemaps y la volver� a crear con los nuevos atributos
			
			
			if(this.modificadoFicheroSitemap(periodicidad, horaTrigger, minutosTrigger, segundosTrigger))
			{
				log("Elimino la tarea de generaci�n de informes");
				trabajo = new TrabajoVO();
				trabajo.setGrupoTrabajo(context.getJobDetail().getGroup());
				log("trabajo.getGrupoTrabajo() "+trabajo.getGrupoTrabajo());
				trabajo.setTrabajo(context.getJobDetail().getName());
				log("trabajo.getTrabajo() "+trabajo.getTrabajo());
				trabajo.setUsuario(usuario);
				trabajoArray = new TrabajoVO[1];
				trabajoArray[0] = trabajo;
				resultadoEliminacion = (servicio.eliminarTareas(trabajoArray)).booleanValue();

				if (resultadoEliminacion) {
					log("Creamos la tarea de generaci�n de sitemaps. Ser� una tarea gen�rica");
					tareaCreada = new TareaVO();
					tareaCreada.setTrabajo("Sitemaps");
					tareaCreada.setGrupoTrabajo("GrupoTrabajoSitemaps");
					tareaCreada.setTrigger("TriggerSitemaps");
					tareaCreada.setGrupoTrigger("GrupoTriggerSitemaps");
					tareaCreada.setUsuario("administrador");
					tareaCreada.setPeriodicidad(SitemapPropertiesImpl.getInstance().getProperty(SitemapProperties.PERIODICIDADTAREA));
					log("tareaCreada.getPeriodicidad() "+tareaCreada.getPeriodicidad());
    	    	 
					Calendar calInicio = new GregorianCalendar(2008, Calendar.JANUARY, 1);
					calInicio.set(calInicio.HOUR_OF_DAY, (new Integer(SitemapPropertiesImpl.getInstance().getProperty(SitemapProperties.HORATAREA))).intValue());
					calInicio.set(calInicio.MINUTE, (new Integer(SitemapPropertiesImpl.getInstance().getProperty(SitemapProperties.MINUTOTAREA))).intValue());
					calInicio.set(calInicio.SECOND, (new Integer(SitemapPropertiesImpl.getInstance().getProperty(SitemapProperties.SEGUNDOTAREA))).intValue());
					calInicio.set(calInicio.MILLISECOND, 0);
					Date fechaInicio = calInicio.getTime();
					tareaCreada.setFechaInicio(DateManager.dateToCalendar(fechaInicio));
					log("tareaCreada.getFechaInicio() "+tareaCreada.getFechaInicio());
    	    	 
					List parametrosTareaInformesPortada = new ArrayList();
					SrvPlanificadorServiceImpl servicioPlanificador = new SrvPlanificadorServiceImpl();
					servicioPlanificador.handleCrearTarea(tareaCreada, parametrosTareaInformesPortada, GenerarSitemaps.class);
    	    	
				}
			}
		}
		catch (Exception e) {
			log.error("Se produce la siguiente excepcion "+e);
			JobExecutionException excepcion = 
					new JobExecutionException("Error: No se ha podido generar los ficheros sitemaps ", e);
			
			log.error("Error " + excepcion);
						
			/* Se lanza el error */
			throw excepcion;
		}				
	}
	
	private void log (Object obj) {
		if (log.isDebugEnabled())
			log.debug(obj);
	}
	
	/*
	 * Comprueba si se han modificado los atributos: periodicidad, hora, minutos y segundos en el fichero sitemap.properties
	 * en el caso de que se hayan modificado habr�a que volver a generar una tarea con esos nuevos valores
	 */
	private boolean modificadoFicheroSitemap(String periodicidad,String horas, String minutos, String segundos)
	{
		log("ModificacionFicheroSitemap");
		boolean resultado = false;
		String periodicidadSitemap, horaSitemap, minutosSitemap, segundosSitemap = "";
		periodicidadSitemap = SitemapPropertiesImpl.getInstance().getProperty(SitemapProperties.PERIODICIDADTAREA);
		horaSitemap = SitemapPropertiesImpl.getInstance().getProperty(SitemapProperties.HORATAREA);
		minutosSitemap = SitemapPropertiesImpl.getInstance().getProperty(SitemapProperties.MINUTOTAREA);
		segundosSitemap = SitemapPropertiesImpl.getInstance().getProperty(SitemapProperties.SEGUNDOTAREA);
		if((!(periodicidadSitemap.equalsIgnoreCase(periodicidad))) || (!(horaSitemap.equalsIgnoreCase(horas))) || (!(minutosSitemap.equalsIgnoreCase(minutos))) || (!(segundosSitemap.equalsIgnoreCase(segundos))))
		{
			resultado = true;
		}
		log("Se ha modificado el fichero "+resultado);
		return resultado;
	}
}
