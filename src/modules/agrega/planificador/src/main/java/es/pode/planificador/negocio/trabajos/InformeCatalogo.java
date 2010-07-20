/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.planificador.negocio.trabajos;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import es.pode.ServiceLocator;
import es.pode.planificador.negocio.comun.CtesPlanificador;
import es.pode.planificador.negocio.servicios.SrvPlanificadorService;
import es.pode.soporte.seguridad.encriptacion.Autenticar;

public class InformeCatalogo implements Job {

	static Log log = LogFactory.getLog(InformeCatalogo.class);
	
	/**
	 * Ejecuci�n del trabajo InformeCat�logo
	 */
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		String usuario = (String) context.getJobDetail().getJobDataMap().get(CtesPlanificador.USUARIO);
		
		/* A�adimos la seguridad al proceso */
		log("Usuario que lanza la tarea: " + usuario);
        boolean contextoCargado = Autenticar.cargarContextoSeguridad(usuario);
		
		if(!contextoCargado) {
			log.error("ERROR: No han cargado los datos en el contexto de seguridad");
			return;			
		}

		log("InformeCat�logo: " + context.getJobDetail().getFullName() + " ejecutandose a las " + new Date());
		
		try {			
			SrvPlanificadorService servicio = ServiceLocator.instance().getSrvPlanificadorService();					
			servicio.generarCatalogo();
			log("Se han generado el informe del cat�logo");
		}
		catch (Exception e) {
			JobExecutionException excepcion = 
					new JobExecutionException("Error: No se ha podido realizar el informe del cat�logo ", e);
			
			log.error("Error " + excepcion);
						
			/* Se lanza el error */
			throw excepcion;
		}				
	}
	
	private void log (Object obj) {
		if (log.isDebugEnabled())
			log.debug(obj);
	}
}
