/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.planificador.negocio.comun;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import es.pode.ServiceLocator;
import es.pode.planificador.negocio.servicios.RegistroTareaEjecutadaVO;
import es.pode.planificador.negocio.servicios.TareaEjecutadaVO;

public class Planificador {

	static Log log = LogFactory.getLog(Planificador.class);
	
	/** 
     *  Método para recuperar la agenda del planificador 
     * */
    public static Scheduler getAgenda() throws Exception
    {   	
		SchedulerFactory sFac = new StdSchedulerFactory(CtesPlanificador.QUARTZ_PROPERTIES);
		Scheduler laAgenda = sFac.getScheduler();
		
		return laAgenda;
    }   
    
    /** Función para recuperar la fecha actual en el formato AAAAMMDDHHMMSS 
     *  Retorna: un String con la fecha en este formato AAAAMMDDHHMMSS
     * */
    public static String getFechaAAAAMMDDHHMMSS() {

    	Calendar cal = new GregorianCalendar();
    	
		String anio = new Integer (cal.get(Calendar.YEAR)).toString();
		
		StringBuffer mes; 
		if (cal.get(Calendar.MONTH) + 1 < 10) 
			mes = new StringBuffer("0" + new Integer(cal.get(Calendar.MONTH) + 1).toString());	
		else
			mes = new StringBuffer(new Integer(cal.get(Calendar.MONTH) + 1).toString());

		StringBuffer dia;
		if (cal.get(Calendar.DAY_OF_MONTH) < 10) 
			dia = new StringBuffer("0" + new Integer(cal.get(Calendar.DAY_OF_MONTH)).toString());	
		else
			dia = new StringBuffer(new Integer(cal.get(Calendar.DAY_OF_MONTH)).toString());

		StringBuffer hora;
		if (cal.get(Calendar.HOUR) < 10) 
			hora = new StringBuffer("0" + new Integer(cal.get(Calendar.HOUR)).toString());	
		else
			hora = new StringBuffer(new Integer(cal.get(Calendar.HOUR)).toString());
		
		StringBuffer minutos;
		if (cal.get(Calendar.MINUTE) < 10) 
			minutos = new StringBuffer("0" + new Integer(cal.get(Calendar.MINUTE)).toString());	
		else
			minutos = new StringBuffer(new Integer(cal.get(Calendar.MINUTE)).toString());

		StringBuffer segundos;
		if (cal.get(Calendar.SECOND) < 10) 
			segundos = new StringBuffer("0" + new Integer(cal.get(Calendar.SECOND)).toString());	
		else
			segundos = new StringBuffer(new Integer(cal.get(Calendar.SECOND)).toString());
		
		StringBuffer aaaammddhhmmss = new StringBuffer(anio + mes + dia + hora + minutos + segundos);
		
		return aaaammddhhmmss.toString();	
    }

    /** Función para recuperar la fecha actual en el formato AAAAMMDDHHMMSSM 
     *  Retorna: un String con la fecha en este formato AAAAMMDDHHMMSSM
     * */
    public static String getFechaAAAAMMDDHHMMSSMIL() {

    	Calendar cal = new GregorianCalendar();
    	
		String anio = new Integer (cal.get(Calendar.YEAR)).toString();
		
		StringBuffer mes; 
		if (cal.get(Calendar.MONTH) + 1 < 10) 
			mes = new StringBuffer("0" + new Integer(cal.get(Calendar.MONTH) + 1).toString());	
		else
			mes = new StringBuffer(new Integer(cal.get(Calendar.MONTH) + 1).toString());

		StringBuffer dia;
		if (cal.get(Calendar.DAY_OF_MONTH) < 10) 
			dia = new StringBuffer("0" + new Integer(cal.get(Calendar.DAY_OF_MONTH)).toString());	
		else
			dia = new StringBuffer(new Integer(cal.get(Calendar.DAY_OF_MONTH)).toString());

		StringBuffer hora;
		if (cal.get(Calendar.HOUR) < 10) 
			hora = new StringBuffer("0" + new Integer(cal.get(Calendar.HOUR)).toString());	
		else
			hora = new StringBuffer(new Integer(cal.get(Calendar.HOUR)).toString());
		
		StringBuffer minutos;
		if (cal.get(Calendar.MINUTE) < 10) 
			minutos = new StringBuffer("0" + new Integer(cal.get(Calendar.MINUTE)).toString());	
		else
			minutos = new StringBuffer(new Integer(cal.get(Calendar.MINUTE)).toString());

		StringBuffer segundos;
		if (cal.get(Calendar.SECOND) < 10) 
			segundos = new StringBuffer("0" + new Integer(cal.get(Calendar.SECOND)).toString());	
		else
			segundos = new StringBuffer(new Integer(cal.get(Calendar.SECOND)).toString());
		
		StringBuffer milisegundos = new StringBuffer(new Integer(cal.get(Calendar.MILLISECOND)).toString());
		
		StringBuffer aaaammddhhmmss = new StringBuffer(anio + mes + dia + hora + minutos + segundos + milisegundos);
		
		return aaaammddhhmmss.toString();	
    }
    
    /** Función para recuperar la fecha actual en el formato AAMMDDHHMMSS 
     *  Retorna: un String con la fecha en este formato AAMMDDHHMMSS

     * */
    public static String getFechaAAMMDDHHMMSS() {

    	Calendar cal = new GregorianCalendar();
    	
		String anio2 = new Integer(cal.get(Calendar.YEAR)).toString().substring(2, 4);
		
		StringBuffer mes; 
		if (cal.get(Calendar.MONTH) + 1 < 10) 
			mes = new StringBuffer("0" + new Integer(cal.get(Calendar.MONTH) + 1).toString());	
		else
			mes = new StringBuffer(new Integer(cal.get(Calendar.MONTH) + 1).toString());

		StringBuffer dia;
		if (cal.get(Calendar.DAY_OF_MONTH) < 10) 
			dia = new StringBuffer("0" + new Integer(cal.get(Calendar.DAY_OF_MONTH)).toString());	
		else
			dia = new StringBuffer(new Integer(cal.get(Calendar.DAY_OF_MONTH)).toString());

		StringBuffer hora;
		if (cal.get(Calendar.HOUR) < 10) 
			hora = new StringBuffer("0" + new Integer(cal.get(Calendar.HOUR)).toString());	
		else
			hora = new StringBuffer(new Integer(cal.get(Calendar.HOUR)).toString());
		
		StringBuffer minutos;
		if (cal.get(Calendar.MINUTE) < 10) 
			minutos = new StringBuffer("0" + new Integer(cal.get(Calendar.MINUTE)).toString());	
		else
			minutos = new StringBuffer(new Integer(cal.get(Calendar.MINUTE)).toString());

		StringBuffer segundos;
		if (cal.get(Calendar.SECOND) < 10) 
			segundos = new StringBuffer("0" + new Integer(cal.get(Calendar.SECOND)).toString());	
		else
			segundos = new StringBuffer(new Integer(cal.get(Calendar.SECOND)).toString());
		
		StringBuffer aammddhhmmss = new StringBuffer(anio2 + mes + dia + hora + minutos + segundos);
		
		return aammddhhmmss.toString();	
    }
    
    /**
     *  Partimos una cadena por el punto (.) y devolvemos el ultimo trozo
     *  Útil para recuperar el nombre de una clase 
     * @param cadena a partir
     * @return último trozo
     */
    public static String ultimoCampo(String cadena) {
    	
        java.util.StringTokenizer tokenizer = new java.util.StringTokenizer(cadena, ".");         
        
        int numCampos = tokenizer.countTokens();
        
        String[] arrayCampos = new String[numCampos];
        
        int contador = 0;
        
        while(tokenizer.hasMoreTokens())
            arrayCampos[contador++] = tokenizer.nextToken();
        
        return arrayCampos[numCampos - 1];
    }
    
    /**
     *  Se registra el inicio de una tarea 
     * @param trabajo Nombre de la tarea a ejecutar
     * @param grupoTrabajo Grupo de la tarea a ejecutar
     * @param descripcion Descripción de la tarea
     * @param usuario Usuario que ha creado la tarea    
     * @return idTarea El identificador de la tarea registrada
     */
	public static Long registrarInicioTarea (String trabajo, String grupoTrabajo, String descripcion, String usuario) 
	{  
		Long idTarea = null;
		
		try {
			if (log.isDebugEnabled()) {
				log.debug("Trabajo registro: " + trabajo);
				log.debug("GrupoTrabajo registro" + grupoTrabajo);
				log.debug("Descripcion registro: " + descripcion);
				log.debug("Usuario registro: " + usuario);				
			}
		
			TareaEjecutadaVO tarea = new TareaEjecutadaVO();
			tarea.setDescripcion(descripcion);
			tarea.setTrabajo(trabajo);
			tarea.setGrupoTrabajo(grupoTrabajo);
			tarea.setFechaInicio(new GregorianCalendar());
			tarea.setUsuario(usuario);
		
			idTarea = ServiceLocator.instance().getSrvRegistroPlanificadorService().registrarTrabajo(tarea);
			
			if (log.isDebugEnabled())
				log.debug("idTarea: " + idTarea);
		}
		catch (Exception e) {
			log.error("No se ha podido registrar el inicio de la tarea " + e);
		}
		
		return idTarea;
	}
	
    /**
     *  Se registra que la tarea ha sido incorrecta 
     * @param idTarea El identificador de la tarea registradaidTarea El identificador de la tarea registrada
     * @param estado Estado a registrar
     * @param descripcion Descripción de la tarea
     */
	public static void registrarTareaIncorrecta(Long idTarea, String estado, String descripcion) 
	{	
		RegistroTareaEjecutadaVO registro = null;
		TareaEjecutadaVO tarea = null;		
		
		try {
			if (log.isDebugEnabled()) {
				log.debug("idTarea registro: " + idTarea);
				log.debug("Estado registro" + estado);
				log.debug("Descripcion registro: " + descripcion);			
			}
			
			tarea.setId(idTarea);
			
			registro = new RegistroTareaEjecutadaVO();
			registro.setTarea_ejecutada(tarea);
			registro.setFecha(new GregorianCalendar());
			registro.setEstado(estado);	
			registro.setDescripcion(descripcion);
			ServiceLocator.instance().getSrvRegistroPlanificadorService().registrarTrabajoHijo(registro);
		}
		catch (Exception e1) {
			log.error("Error: No se ha podido registrar la tarea derivada ");
		}
		
		/* Registramos la hora de finalización de la tarea incorrecta */
		try {
			TareaEjecutadaVO trabajoEjecutado = new TareaEjecutadaVO();
			trabajoEjecutado.setId(idTarea);
			trabajoEjecutado.setFechaFin(new GregorianCalendar());
			trabajoEjecutado.setEstado(descripcion);
			
			ServiceLocator.instance().getSrvRegistroPlanificadorService().registrarTrabajoFechaFin(trabajoEjecutado);
		}
		catch (Exception e1) {
			log.error("Error: No se ha podido registrar el fin del trabajo");
		}
	}	
	
	public static Date fechaDia(Date fch, int dias) {
	     Calendar cal = new GregorianCalendar();
	     cal.setTimeInMillis(fch.getTime());
	     cal.add(Calendar.DATE, dias);
	     
	     return new Date(cal.getTimeInMillis());
	}
	
	public static Date fechaSemanaDesde(Date fch, int sem) {
		int dia;
	    Calendar cal = new GregorianCalendar();
	    cal.setTimeInMillis(fch.getTime());
	    cal.add(Calendar.DATE, sem * 7);
	     
		if (cal.get(Calendar.DAY_OF_WEEK) == 1) // Si es domingo
			dia = 7;
		else
			dia = cal.get(Calendar.DAY_OF_WEEK) - 1;
	     
		cal.add(Calendar.DATE, - dia + 1);
	     
	    return new Date(cal.getTimeInMillis());
	}
	
	public static Date fechaSemanaHasta(Date fch, int sem) {
		int dia;
	    Calendar cal = new GregorianCalendar();
	    cal.setTimeInMillis(fch.getTime());	     
	    cal.add(Calendar.DATE, sem * 7);
	     
	    if (cal.get(Calendar.DAY_OF_WEEK) == 1) // Si es domingo
	    	dia = 7;
	    else
	    	dia = cal.get(Calendar.DAY_OF_WEEK) - 1;
	    
	     cal.add(Calendar.DATE, 7 - dia);	     
	     
	     return new Date(cal.getTimeInMillis());
	}
	
	public static Date fechaMesDesde(Date fch, int meses) {
	     Calendar cal = new GregorianCalendar();
	     cal.setTimeInMillis(fch.getTime());
	     cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + meses, 1);
	     
	     return new Date(cal.getTimeInMillis());
	}

	public static Date fechaMesHasta(Date fch, int meses) {
	     Calendar cal = new GregorianCalendar();
	     cal.setTimeInMillis(fch.getTime());	     
	     cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + meses, 1);
	     cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.getActualMaximum(Calendar.DAY_OF_MONTH));	     

	     return new Date(cal.getTimeInMillis());
	}
	
	public static Date fechaAnualDesde(Date fch, int anios) {
	     Calendar cal = new GregorianCalendar();
	     cal.setTimeInMillis(fch.getTime());
	     cal.set(cal.get(Calendar.YEAR) + anios, Calendar.JANUARY, 1);
	     return new Date(cal.getTimeInMillis());
	}
	
	public static Date fechaAnualHasta(Date fch, int anios) {
	     Calendar cal = new GregorianCalendar();
	     cal.setTimeInMillis(fch.getTime());
	     cal.set(cal.get(Calendar.YEAR) + anios, Calendar.DECEMBER, 31);
	     return new Date(cal.getTimeInMillis());
	}
}
