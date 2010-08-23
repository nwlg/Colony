/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point

package es.pode.planificador.negocio.trabajos;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import es.pode.ServiceLocator;
import es.pode.planificador.negocio.comun.CtesPlanificador;
import es.pode.planificador.negocio.comun.Planificador;
import es.pode.planificador.negocio.servicios.RegistrarTrabajoException;
import es.pode.planificador.negocio.servicios.RegistroTareaEjecutadaVO;
import es.pode.planificador.negocio.servicios.SrvPlanificadorService;
import es.pode.planificador.negocio.servicios.TareaEjecutadaVO;
import es.pode.planificador.negocio.servicios.TareaInformesVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.encriptacion.Autenticar;


public class GenerarInformeFederado implements Job {
	
	static Log log = LogFactory.getLog(GenerarInformeFederado.class);
	
	/**
	 * Ejecución del trabajo de generación de informes
	 */
	public void execute(JobExecutionContext context) throws JobExecutionException 
	{
		log("Entramos en el trabajo de informes federados");
		Long idTarea = null;
		ArrayList parametros = (ArrayList)context.getJobDetail().getJobDataMap().get(CtesPlanificador.PARAMETROS);
		String usuario = (String) context.getJobDetail().getJobDataMap().get(CtesPlanificador.USUARIO);
		TareaInformesVO datosInforme = (TareaInformesVO) parametros.get(0);
		
		/* Añadimos la seguridad al proceso */
		log("Usuario que lanza la tarea: " + usuario);
		//boolean seguridad = Autenticar.anadirSeguridad(usuario);
		 boolean seguridad = Autenticar.cargarContextoSeguridad(usuario);
		
		if(!seguridad) {
			log.error("ERROR: No se lanza el proceso. La seguridad no está confirmada");
			return;			
		}
		
		log("Generación de informe federado: " + context.getJobDetail().getFullName() + " ejecutandose a las " + new Date());
				
		idTarea = Planificador.registrarInicioTarea(context.getJobDetail().getName(), 
				context.getJobDetail().getGroup(), datosInforme.getMsgDescripcionTrabajo(), usuario);
		
		/* Se genera el informe */
		try {
			SrvPlanificadorService servicio = ServiceLocator.instance().getSrvPlanificadorService();
			
			log("Se genera el informe federado: idTarea: " + idTarea + " servicio: " + servicio.toString());		
			servicio.generarInformeFederado(datosInforme, idTarea);
		}
		catch (Exception e) {
			JobExecutionException excepcion = 
					new JobExecutionException("Error: No se ha podido generar el informe ", e);
			
			/* Se registra que no se ha realizado correctamente */
			log.error("Error generando el informe " + excepcion);			
			Planificador.registrarTareaIncorrecta(idTarea, ConstantesAgrega.TRABAJO_ERRONEO, datosInforme.getMsgNoInforme());
			
			throw excepcion;
		}
		
		// TODO: Temporal ya que la fecha de finalización la deberá guardar la tarea ejecutada	
		TareaEjecutadaVO trabajoEjecutado = null;
		
		try {
			trabajoEjecutado = new TareaEjecutadaVO();
			trabajoEjecutado.setId(idTarea);
			trabajoEjecutado.setFechaFin(new GregorianCalendar());
			trabajoEjecutado.setEstado(ConstantesAgrega.TRABAJO_CORRECTO);
			ServiceLocator.instance().getSrvRegistroPlanificadorService().registrarTrabajoFechaFin(trabajoEjecutado);
		}
		catch (Exception e1) {
			RegistrarTrabajoException excepcion = 
					new RegistrarTrabajoException("Error: No se ha podido registrar el fin del trabajo", e1);
	    	log.error(excepcion);
		}
		
		try {
			log("Registramos que el informe federado se ha realizado correctamente");
					
			RegistroTareaEjecutadaVO registro = new RegistroTareaEjecutadaVO();
			registro.setTarea_ejecutada(trabajoEjecutado);
			registro.setFecha(new GregorianCalendar());
			registro.setEstado(ConstantesAgrega.TRABAJO_CORRECTO);	
            registro.setDescripcion(datosInforme.getMsgInforme());
			ServiceLocator.instance().getSrvRegistroPlanificadorService().registrarTrabajoHijo(registro);
		}
		catch (Exception e1) {
			RegistrarTrabajoException excepcion = 
					new RegistrarTrabajoException("Error: No se ha podido registrar la tarea derivada de la generación de informe ", e1);
    		log.error(excepcion);
		}
	}
	
	public static Date calculoFechaDesde (Date fechaHoy, TareaInformesVO datosInforme) {
		
		Date fechaDesde = null;
		
		if (ConstantesAgrega.NO_PERIODICA.equals(datosInforme.getPeriodicidad()))  
			fechaDesde = datosInforme.getFechaDesde().getTime();
		else if (ConstantesAgrega.DIARIA.equals(datosInforme.getPeriodicidad())) 
			fechaDesde = Planificador.fechaDia(fechaHoy, -1);			
		else if (ConstantesAgrega.SEMANAL.equals(datosInforme.getPeriodicidad())) 
			fechaDesde = Planificador.fechaSemanaDesde(fechaHoy, -1);			
		else if (ConstantesAgrega.MENSUAL.equals(datosInforme.getPeriodicidad())) 
			fechaDesde = Planificador.fechaMesDesde(fechaHoy, -1);
		else if (ConstantesAgrega.ANUAL.equals(datosInforme.getPeriodicidad())) 
			fechaDesde = Planificador.fechaAnualDesde(fechaHoy, -1);
		
		if (log.isDebugEnabled())
			log.debug("Fecha informe desde: " + fechaDesde);
		
		return fechaDesde;
	}
	
	public static Date calculoFechaHasta(Date fechaHoy, TareaInformesVO datosInforme) {
		
		Date fechaHasta = null;
		
		if (ConstantesAgrega.NO_PERIODICA.equals(datosInforme.getPeriodicidad()))  
			fechaHasta = datosInforme.getFechaHasta().getTime();
		else if (ConstantesAgrega.DIARIA.equals(datosInforme.getPeriodicidad())) 
			fechaHasta = Planificador.fechaDia(fechaHoy, -1);			
		else if (ConstantesAgrega.SEMANAL.equals(datosInforme.getPeriodicidad())) 
			fechaHasta = Planificador.fechaSemanaHasta(fechaHoy, -1);			
		else if (ConstantesAgrega.MENSUAL.equals(datosInforme.getPeriodicidad())) 
			fechaHasta = Planificador.fechaMesHasta(fechaHoy, -1);
		else if (ConstantesAgrega.ANUAL.equals(datosInforme.getPeriodicidad())) 
			fechaHasta = Planificador.fechaAnualHasta(fechaHoy, -1);
		
		if (log.isDebugEnabled())
			log.debug("Fecha informe hasta: " + fechaHasta);
		
		return fechaHasta;
	}
	
	private void log (Object obj) {
		if (log.isDebugEnabled())
			log.debug(obj);
	}
}
