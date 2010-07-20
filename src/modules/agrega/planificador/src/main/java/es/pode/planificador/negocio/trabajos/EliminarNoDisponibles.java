/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point

package es.pode.planificador.negocio.trabajos;

import java.util.ArrayList;
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
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.encriptacion.Autenticar;


/**
 * Trabajo de eliminacion de ODES
 */
public class EliminarNoDisponibles implements Job
{	
	static Log log = LogFactory.getLog(EliminarNoDisponibles.class);
	
	/**
	 * Ejecución del trabajo eliminacion
	 */
	public void execute(JobExecutionContext context) throws JobExecutionException 
	{
		Long idTarea = null;
		String usuario = (String) context.getJobDetail().getJobDataMap().get(CtesPlanificador.USUARIO);	
		
		/* Añadimos la seguridad al proceso */
		log("Usuario que lanza la tarea: " + usuario);
        boolean contextoCargado = Autenticar.cargarContextoSeguridad(usuario);
		
		if(!contextoCargado) {
			log.error("ERROR: No han cargado los datos en el contexto de seguridad");
			return;			
		}

		ArrayList parametros = (ArrayList)context.getJobDetail().getJobDataMap().get(CtesPlanificador.PARAMETROS);
		GregorianCalendar fechaDesde = (GregorianCalendar) parametros.get(0);  // fecha desde
		GregorianCalendar fechaHasta = (GregorianCalendar) parametros.get(1); // fecha hasta
		String msgEliminado = (String) parametros.get(2);
		String msgNoEliminado = (String) parametros.get(3);
		String msgDescTrabajo = (String) parametros.get(4);
		
		log("Eliminar No Disponibles: " + context.getJobDetail().getFullName());
		
		idTarea = Planificador.registrarInicioTarea(context.getJobDetail().getName(), 
				context.getJobDetail().getGroup(), msgDescTrabajo, usuario);
				
		/* Se realiza el eliminado de no disponibles */
		try {
			Long odesNoDisponibles = null;
			SrvPlanificadorService servicio = ServiceLocator.instance().getSrvPlanificadorService();
			log("Se realiza el reindexado: idTarea: " + idTarea + " servicio: " + servicio.toString());
			String retorno = null;
			retorno = servicio.eliminarNoDisponibles(fechaDesde, fechaHasta, idTarea);
			log("ODEs no disponibles eliminados[" + retorno+"]");
		}
		catch (Exception e) {
			JobExecutionException excepcion = 
					new JobExecutionException("Error: No se ha podido realizar la eliminacion de ODEs no disponibles ", e);
			
			/* Se registra que no se ha realizado la eliminacion correctamente */
			log.error("Error eliminando ODEs no disponibles " + excepcion);			
			Planificador.registrarTareaIncorrecta(idTarea, ConstantesAgrega.TRABAJO_ERRONEO, msgNoEliminado);
			
			throw excepcion;
		}
		
		// TODO: Temporal
		/* Si se ha eliminado correctamente */
		try {
			log("Registramos que la eliminacion de ODEs no disponibles se ha realizado correctamente");
			TareaEjecutadaVO tarea = new TareaEjecutadaVO();
			tarea.setId(idTarea);
			RegistroTareaEjecutadaVO registro = new RegistroTareaEjecutadaVO();
			registro.setTarea_ejecutada(tarea);
			registro.setFecha(new GregorianCalendar());
			registro.setEstado(ConstantesAgrega.TRABAJO_CORRECTO);	
			registro.setDescripcion(msgEliminado);
			ServiceLocator.instance().getSrvRegistroPlanificadorService().registrarTrabajoHijo(registro);
		}
		catch (Exception e1) {
			RegistrarTrabajoException excepcion = 
					new RegistrarTrabajoException("Error: No se ha podido registrar la tarea derivada ", e1);
    		log.error(excepcion);
		}
		
		/* Registramos la hora de finalización de la tarea */
		try {	
			TareaEjecutadaVO trabajoEjecutado = new TareaEjecutadaVO();
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
	}
	
	private void log (Object obj) {
		if (log.isDebugEnabled())
			log.debug(obj);
	}
}
