/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.planificador.negocio.trabajos;

import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import es.pode.ServiceLocator;
import es.pode.planificador.negocio.comun.CtesPlanificador;
import es.pode.soporte.seguridad.encriptacion.Autenticar;

public class TareaModificacion implements Job {
	
	private static final Logger logger = Logger.getLogger(TareaModificacion.class);

	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("Tarea de modificacion: " + context.getJobDetail().getFullName() + " ejecutandose a las " + new Date());
		ArrayList parametros = (ArrayList)context.getJobDetail().getJobDataMap().get(CtesPlanificador.PARAMETROS);
		Long idModificacion = (Long)parametros.get(0);
		String user = (String)parametros.get(1);
		if(logger.isDebugEnabled()) logger.debug("Identificador de la tarea de modificacion : " + idModificacion + "; Usuario para lanzar la tarea : " + user);
		
		/* Añadimos la seguridad al proceso */
        boolean contextoCargado = Autenticar.cargarContextoSeguridad(user);		
		if(!contextoCargado) {
			logger.error("ERROR: No han cargado los datos en el contexto de seguridad");
			return;			
		}
		try {
			Boolean result = ServiceLocator.instance().getSrvTareaModificadorService().ejecutarTareaModificacion(idModificacion);
			if(!result.booleanValue()) {
				logger.error("No se ha podido enviar el mensaje al modulo Herramienta de modificacion");
			}
		} catch (Exception e) {
			logger.error("Error inesperado durante la ejecucion de la tarea de modificacion " + idModificacion + ": " + e.getMessage());
			if(logger.isDebugEnabled()) logger.debug(e);
		}
	}

}
