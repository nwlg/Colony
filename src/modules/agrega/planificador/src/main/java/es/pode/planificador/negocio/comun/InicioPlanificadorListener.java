/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.planificador.negocio.comun;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import es.pode.ServiceLocator;

public class InicioPlanificadorListener implements ServletContextListener {

	private static Logger log = Logger.getLogger(InicioPlanificadorListener.class);
	
	public void contextInitialized(ServletContextEvent arg0) 
	{
		try 
		{
			log.info("Inicializaci�n del planificador en el contextInitialized");
			if (!Planificador.getAgenda().isStarted()) 
			{
				Planificador.getAgenda().start();
				log.info("Planificador iniciado");
			}
				
			
			/* Los trabajos que se quedaron a media ejecuci�n al parar el servidor se ponen a interrumpidos */
			ServiceLocator.instance().getSrvRegistroPlanificadorService().registrarTrabajoInterrumpido();
		}
		catch (Exception e)
		{
			log.error("Error en la inicializaci�n del planificador " + e);
		}
	}

	public void contextDestroyed(ServletContextEvent arg0) 
	{
		try 
		{
			log.info("Parada del planificador en el contextDestroyed");
			if (Planificador.getAgenda().isStarted()) 
			{
				Planificador.getAgenda().shutdown();
				log.info("Planificador parado");
			}
			
			/* Los trabajos que se quedaron a media ejecuci�n al parar el servidor se ponen a interrumpidos */
			ServiceLocator.instance().getSrvRegistroPlanificadorService().registrarTrabajoInterrumpido();
		}
		catch (Exception e)
		{
			log.error("Error en la parada del planificador en la destrucci�n del contexto " + e);
		}
	}
}
