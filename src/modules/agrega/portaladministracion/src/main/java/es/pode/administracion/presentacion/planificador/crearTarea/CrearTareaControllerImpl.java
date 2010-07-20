/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.planificador.crearTarea;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
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
import es.pode.planificador.negocio.servicios.TrabajoVO;
import es.pode.soporte.constantes.ConstantesAgrega;
//import es.pode.soporte.i18n.I18n;
import es.pode.soporte.i18n.*;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

public class CrearTareaControllerImpl extends CrearTareaController {
	private static Logger log = Logger
			.getLogger(CrearTareaControllerImpl.class);

	private static TimeZone tz = null;

	private java.util.Properties pSpringProperties = null;

	Utiles utilidades = new Utiles();


	/**
	 * Método que discrimina la tarea a crear
	 * 
	 * Retorna 1: Carga de ODEs 2: Reindexado 3: Eliminar ODEs 4:Infome fecha 5:Informe rango 6:Informe usuario 7:Informe Federado 8:Informe catalogo
	 * 
	 * @param mapping
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public final String crearTarea(ActionMapping mapping, CrearTareaForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		if(log.isDebugEnabled())log.debug("CREAR TAREA");
	
		TrabajoVO trabajo = new TrabajoVO();
		trabajo.setTrabajo(form.getTrabajo());

		Boolean existe = this.getSrvPlanificadorService().existeTrabajo(trabajo);

		/* Comprobamos si la tarea ya existe */
		try 
		{
			if (existe.booleanValue())
				throw new ValidatorException("{tareas.tareaExiste}");	
		} 
		catch (ValidatorException e2) 
		{
			saveErrorMessage(request, "tareas.tareaExiste");
			return "Error";
		}

		/* Comprobamos si el nombre de tarea tiene caracteres raros */
		try 
		{
			if (!utilidades.validacionCaracter(form.getTrabajo()))
				throw new ValidatorException("{tareas.nombreIncorrecto}");
		} 
		catch (ValidatorException e2) {
			saveErrorMessage(request, "tareas.nombreIncorrecto");
			return "Error";
		}
		
		String dia = new String(form.getDia());
		String mes = new String(form.getMes());
		String anio = new String(form.getAnio());
		String hora = new String(form.getHora());
		String minutos= new String(form.getMinutos());
		
		if (dia.equalsIgnoreCase("") || mes.equalsIgnoreCase("") || anio.equalsIgnoreCase("") || 
				hora.equalsIgnoreCase("") || minutos.equalsIgnoreCase(""))
		{
			log.error("Error al introducir la fecha.");
			throw new ValidatorException("{tareas.errors.dateHora.required}") ;
		}
		//}catch(Exception e)
		//{
			//throw new ValidatorException("{tareas.errors.fecha.incorrecta}");
		//}
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
		
		try 
		{
			if(log.isDebugEnabled())log.debug("VALIDAMOS LAS FECHAS");
			Date fechaActual = new Date();
			SimpleDateFormat format = new SimpleDateFormat("ddMMyyyyHHmmss");
			format.setLenient(false);
			Date fechaIn = null;
			
			
			if(log.isDebugEnabled())log.debug("antes de validar la hora");
			boolean horaValida = utilidades.validacionHoraHHMM(hora, minutos);
			
			if(log.isDebugEnabled())log.debug("horaValida es "+horaValida);
			boolean fechaValida = utilidades.validacionFechaDDMMAAAAHHMM(dia, mes, anio, "yyyyMMdd");
			
			if(log.isDebugEnabled())log.debug("fechaValida es "+fechaValida);
			if (!fechaValida && !horaValida)
				throw new ValidatorException("{tareas.fechaYHoraIncorrectas}");

			if (!horaValida)
				throw new ValidatorException("{tareas.horaIncorrecta}");

			if (!fechaValida)
				throw new ValidatorException("{tareas.fechaIncorrecta}");
			
			if ((new Integer(mes).intValue() < 10)&& (mes.length() == 1))
                 mes = "0" + mes;
			
            if ((new Integer(dia).intValue() < 10)&&(dia.length() == 1))
                 dia = "0" + dia;
            
            if ((new Integer(hora).intValue() < 10)&& (hora.length() == 1))
                hora = "0" + hora;
            
           if ((new Integer(minutos).intValue() < 10)&& (minutos.length() == 1))
               minutos = "0" + minutos;

           log.debug("dia "+dia+" mes "+mes+" anio "+anio+" hora "+hora+" minutos "+minutos);
           fechaIn = format.parse(dia + mes + anio + hora + minutos + "59");
           if(fechaActual.getTime() > fechaIn.getTime())
           {
        	   log.error("La fecha introducida es anterior a la actual");
        	   throw new ValidatorException("{tareas.fechaAnteriorActual}");
           }

		}  catch(java.text.ParseException pe)
        {
        	log.error("Error al introducir la fecha "+pe);
			throw new ValidatorException("{tareas.errors.fecha.incorrecta}");
        }
		catch (ValidatorException e2) 
		{
			log.error("e2 "+e2);
			throw e2;
		
		}
		
		
		//seleccionamos la 2ª pantalla a la que se debe ir dependiendo del tipo de tarea seleccionada

		String tipoTarea = null;
		String tipoTareaDevolver = null;
		try{
			
			if(log.isDebugEnabled())log.debug("obtenerTipoInforme");
	        tipoTarea = form.getTipoTarea();

	        //Si el tipoTarea es Reindexado, carga ODEs o eliminar ODEs el tipo tarea se mantiene
	        if(tipoTarea.equalsIgnoreCase("estadoOdes") || tipoTarea.equalsIgnoreCase("operacionesRealizadas") || 
	        		tipoTarea.equalsIgnoreCase("nivelAgregacion") || tipoTarea.equalsIgnoreCase("coberturaCurricular") || 
	        		tipoTarea.equalsIgnoreCase("odesLicencias") || tipoTarea.equalsIgnoreCase("usuarios") || 
	        		tipoTarea.equalsIgnoreCase("procesosPlanificados"))
	        {	
	        	if(log.isDebugEnabled())log.debug("cargo informe con fechas");	
	        	tipoTareaDevolver = "InformeFecha";
	        	
	        }
	        else if(tipoTarea.equalsIgnoreCase("terminosBusqueda") ||  tipoTarea.equalsIgnoreCase("masValorado") || 
	        			tipoTarea.equalsIgnoreCase("masMostrado") || tipoTarea.equalsIgnoreCase("masPrevisualizado") || 
	        			tipoTarea.equalsIgnoreCase("masVisualizado") || tipoTarea.equalsIgnoreCase("masDescargado") || 
	        			tipoTarea.equalsIgnoreCase("tamanio"))
	        {
	        	if(log.isDebugEnabled())log.debug("cargo informe con rango");
	        	tipoTareaDevolver = "InformeFechaRango";
	        }
	        else if(tipoTarea.equalsIgnoreCase("odesUsuario"))
	        {
	        	
	        	if(log.isDebugEnabled())log.debug("cargo informe con usuario");
	        	tipoTareaDevolver = "InformeFechaUsuario";
	        	
	        }
	        else if(tipoTarea.indexOf("Federada") != -1)
	        {
	        	tipoTareaDevolver = "InformeFederado";
	        }
			
	        else if(tipoTarea.equalsIgnoreCase("repositorio"))
	        {
	        	tipoTareaDevolver = "InformeCatalogo";
	        }
	        else
	        	tipoTareaDevolver = tipoTarea;
	        
	        if(log.isDebugEnabled())log.debug("tipoTarea -> " + tipoTarea);
		
		
		}
		catch (Exception e) 
		{
			saveErrorMessage(request, "tareas.error");
			return "Error";
		}
		
		
		if(log.isDebugEnabled())log.debug("devuelvo el tipo de tarea -> " + tipoTareaDevolver);
		return (String) tipoTareaDevolver;
	}
	
	
	/**
	 * Crea una tarea del tipo Carga ODEs el que carga los ODEs especificados en un directorio
	 * determinado que le indicamos
	 * 
	 * @param mapping
	 * @param form
	 *            Formulario que contiene los datos de la tarea
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public final void crearTareaCargaODEs(ActionMapping mapping,
			CrearTareaCargaODEsForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if (tz == null)
			tz = utilidades.asignarZonaHoraria();
		
		TareaCargaODEsVO tareaRecuperada = null;
		
		try {
			Calendar cal = Calendar.getInstance(tz);
			cal = new GregorianCalendar(new Integer(form.getAnio()).intValue(), new Integer(form
					.getMes()).intValue() - 1, new Integer(form.getDia()).intValue(), new Integer(form
					.getHora()).intValue(), new Integer(form.getMinutos()).intValue());
			
			TareaCargaODEsVO tarea = new TareaCargaODEsVO();
			tarea.setFechaInicio(cal);
			tarea.setPeriodicidad(form.getPeriodicidad());
			tarea.setPathODE(form.getPathODEs());
			tarea.setPathODEsCargados(form.getPathODEsCarg());
			tarea.setPathODEsNoCargados(form.getPathODEsNoCarg());
			tarea.setTrabajo(form.getTrabajo());
			tarea.setTrigger(form.getTrigger());
			tarea.setTipoTarea(form.getTipoTarea());
			tarea.setMsgPublicado(form.getMsgPublicado());
			tarea.setMsgNoPublicado(form.getMsgNoPublicado());
			tarea.setMsgDescripcionTrabajo(form.getMsgDescTrabajo());
			
			if (form.getSobrescribir()!=null && form.getSobrescribir().equals("on"))
				tarea.setSobrescribir("s");
			else 
				tarea.setSobrescribir("n");
			tarea.setUsuario(LdapUserDetailsUtils.getUsuario());
			
			tareaRecuperada = this.getSrvPlanificadorService()
			.crearTareaCargaODEs(tarea);
			
			if (tareaRecuperada.getError() != null)
				throw new ValidatorException("{" + tareaRecuperada.getError()
						+ "}");
			form.setTareaModificada(tareaRecuperada.getTrabajo());
			
		} catch (ValidatorException e2) {
			throw new ValidatorException("{" + tareaRecuperada.getError() + "}");
		} catch (Exception e) {
			log.error("Error: " + e);
			throw new ValidatorException("{tareas.error}");
		}
	}
	

	/**
	 * Crea una tarea del tipo Reindexado la que reindexa los ODEs de un idioma
	 * determinado que le indicamos
	 * 
	 * @param mapping
	 * @param form
	 *            Formulario que contiene los datos de la tarea
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public final void crearTareaReindexado(ActionMapping mapping,
			CrearTareaReindexadoForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		if (tz == null)
			tz = utilidades.asignarZonaHoraria();

		try {
			Calendar cal = Calendar.getInstance(tz);
			cal = new GregorianCalendar(new Integer(form.getAnio()).intValue(), new Integer(form
					.getMes()).intValue() - 1, new Integer(form.getDia()).intValue(), new Integer(form
					.getHora()).intValue(), new Integer(form.getMinutos()).intValue());

			TareaReindexadoVO tarea = new TareaReindexadoVO();
			tarea.setTrabajo(form.getTrabajo());
			tarea.setTrigger(form.getTrigger());
			tarea.setTipoTarea(form.getTipoTarea());
			tarea.setFechaInicio(cal);
			tarea.setPeriodicidad(form.getPeriodicidad());
			tarea.setRepositorioIndices(form.getRepositorioIndices());
			tarea.setMsgReindexado(form.getMsgReindexado());
			tarea.setMsgNoReindexado(form.getMsgNoReindexado());
			tarea.setMsgDescripcionTrabajo(form.getMsgDescTrabajo());

			tarea.setUsuario(LdapUserDetailsUtils.getUsuario());

			TareaReindexadoVO tareaRecuperada = this.getSrvPlanificadorService().crearTareaReindexado(tarea);
			form.setTareaModificada(tareaRecuperada.getTrabajo());
		} catch (Exception e) {
			log.error("Error: " + e);
			throw new ValidatorException("{tareas.error}");
		}
	}

	/**
	 * Elimina los ODEs que estan despublicados entre dos fechas
	 * 
	 * @param mapping
	 * @param form
	 *            Formulario del tipo CrearTareasEliminarNoDisponibles
	 * @param request
	 *            Request con los datos que se manden a traves de ella
	 * @param response
	 *            Response con los datos que contenga
	 * @throws Exception
	 */
	public final void crearTareasEliminarNoDisponibles(ActionMapping mapping,
			CrearTareasEliminarNoDisponiblesForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (tz == null)
			tz = utilidades.asignarZonaHoraria();
		
		String dia = new String(form.getDia());
	 	String mes = new String(form.getMes());
	 	String anio = new String(form.getAnio());
	 	String hora = new String(form.getHora());
	 	String minutos = new String(form.getMinutos());
		String diaDesde = new String(form.getDiaDesde());
	 	String mesDesde = new String(form.getMesDesde());
	 	String anioDesde = new String(form.getAnioDesde());
	 	String diaHasta = new String(form.getDiaHasta());
	 	String mesHasta = new String(form.getMesHasta());
	 	String anioHasta = new String(form.getAnioHasta());

		try {
			
			//Comprobamos que todos los campos de la fecha de inicio están rellenos
    		if(anioDesde.equalsIgnoreCase("") || mesDesde.equalsIgnoreCase("") || diaDesde.equalsIgnoreCase(""))
    				throw new ValidatorException("{informes.crearInformes.fechaDesdeCampoVacio}");
    		
    		//Comprobamos que todos los campos de la fecha fin están rellenos
    		if(anioHasta.equalsIgnoreCase("") || mesHasta.equalsIgnoreCase("") || diaHasta.equalsIgnoreCase(""))
    				throw new ValidatorException("{informes.crearInformes.fechaHastaCampoVacio}");
    		
    		if(log.isDebugEnabled())log.debug("comprobamos si las fechas tiene caracteres no numericos");
    		try
    		{
    		 	new Integer(diaDesde).intValue();
    		 	new Integer(mesDesde).intValue();
    		 	new Integer(anioDesde).intValue();
    		 	
    		}catch(Exception e)
    		{
    			log.error("Alguno de los campos de la fecha desde no son números");
    			throw new ValidatorException("{tareas.eliminarOdes.fechaDesde}");
    		}
    		try
    		{
    		 	new Integer(diaHasta).intValue();
    		 	new Integer(mesHasta).intValue();
    		 	new Integer(anioHasta).intValue();
    		 	
    		}catch(Exception e)
    		{
    			log.error("Alguno de los campos de la fecha hasta no son números");
    			throw new ValidatorException("{tareas.eliminarOdes.fechaHasta}");
    		}
    		
			// Comprobamos si las fechas introducidas son correctas
			boolean fechaValidaDesde = utilidades.validacionFechaDDMMAAAAHHMM(diaDesde, mesDesde, anioDesde, "yyyyMMdd");

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

			Calendar cal = Calendar.getInstance(tz);
			cal = new GregorianCalendar(new Integer(anio).intValue(), 
					new Integer(mes).intValue() - 1, new Integer(dia).intValue(), 
					new Integer(hora).intValue(), new Integer(minutos).intValue());

			Calendar calDesde = Calendar.getInstance(tz);
			calDesde = new GregorianCalendar(new Integer(anioDesde).intValue(), new Integer(mesDesde).intValue() - 1, 
					new Integer(diaDesde).intValue(),0,1);

			Calendar calHasta = Calendar.getInstance(tz);
			calHasta = new GregorianCalendar(new Integer(anioHasta).intValue(), new Integer(mesHasta).intValue() - 1, 
					new Integer(diaHasta).intValue(),23,59);

			TareaEliminaNoDisponiblesVO tareaEliminada = new TareaEliminaNoDisponiblesVO();
			tareaEliminada.setFechaInicio(cal);
			tareaEliminada.setFechaDesde(calDesde);
			tareaEliminada.setFechaHasta(calHasta);
			tareaEliminada.setTrabajo(form.getTrabajo());
			tareaEliminada.setTrigger(form.getTrigger());
			tareaEliminada.setTipoTarea(form.getTipoTarea());
			tareaEliminada.setPeriodicidad(form.getPeriodicidad());

			tareaEliminada.setUsuario(LdapUserDetailsUtils.getUsuario());

			TareaEliminaNoDisponiblesVO tareaRecuperada =  this.getSrvPlanificadorService().crearTareaEliminarNoDisponibles(tareaEliminada);
			form.setTareaModificada(tareaRecuperada.getTrabajo());
			
		} catch (ValidatorException e2) {
			throw e2;
		} catch (Exception e) {
			log.info("Exception --> " + e);
			throw new ValidatorException("{tareas.error}");
		}

	}
	
	/**
	 * Recoge los valores de la tarea y del informe y llama al metodo que crea una tarea(siempre no periodica) de informe fecha
	 * @param mapping
	 * @param form
	 *            Formulario en el que se guardan los datos de la tarea
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void crearTareaInformesFecha(org.apache.struts.action.ActionMapping mapping, 
			es.pode.administracion.presentacion.planificador.crearTarea.CrearTareaInformesFechaForm form, 
			javax.servlet.http.HttpServletRequest request, 
			javax.servlet.http.HttpServletResponse response) throws java.lang.Exception 
	{
		if (tz == null)
			tz = utilidades.asignarZonaHoraria();
		
		String dia = new String(form.getDia());
	 	String mes = new String(form.getMes());
	 	String anio = new String(form.getAnio());
	 	String hora = new String(form.getHora());
	 	String minutos = new String(form.getMinutos());
		
		try{
		
		
			//convertimos los datos de fecha de inicio en un calendar
			Calendar fechaInicio = Calendar.getInstance(tz);
			fechaInicio = new GregorianCalendar(new Integer(anio).intValue(), new Integer(mes).intValue() - 1, 
				new Integer(dia).intValue(), new Integer(hora).intValue(), new Integer(minutos).intValue());
					
			TareaInformesVO tareaInformeVO = new TareaInformesVO();
	    	
			//Recogemos el usuario para mandarlo en el TareaInformesVO
			String usuario = LdapUserDetailsUtils.getUsuario();
			
			if(log.isDebugEnabled())log.debug("rellenamos los datos del VO desde el formulario");
	    	//recogemos los valores del formulario y los metemos en el VO para lanzar el servicio
	    	tareaInformeVO.setTrabajo(form.getTrabajo());
	    	tareaInformeVO.setTrigger(form.getTrigger());
	    	tareaInformeVO.setTipoTarea(form.getTipoTarea());
	    	tareaInformeVO.setInforme(form.getTipoTarea());
	    	tareaInformeVO.setMsgDescripcionTrabajo(form.getMsgDescTrabajo());
	    	tareaInformeVO.setMsgInforme(form.getMsgInforme());
	    	tareaInformeVO.setMsgNoInforme(form.getMsgNoInforme());
	    	tareaInformeVO.setPeriodicidad(form.getPeriodicidad());
	    	tareaInformeVO.setFormato(form.getFormato());
	    	tareaInformeVO.setFechaInicio(fechaInicio);
	    	tareaInformeVO.setUsuario(usuario);
    		
			if((form.getPeriodicidad()).equalsIgnoreCase("N"))
			{
				String diaDesde = new String(form.getDiaDesde());
			 	String mesDesde = new String(form.getMesDesde());
			 	String anioDesde = new String(form.getAnioDesde());
			 	String diaHasta = new String(form.getDiaHasta());
			 	String mesHasta = new String(form.getMesHasta());
			 	String anioHasta = new String(form.getAnioHasta());
			
	    		//Comprobamos si estan vacías las dos fechas(Desde y Hasta), si es asi,  asignaríamos fechas de un rango amplio
			 	if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Desde y Hasta estan vacias");
	    		if(anioDesde.equalsIgnoreCase("") && mesDesde.equalsIgnoreCase("") && diaDesde.equalsIgnoreCase("") && 
	    				anioHasta.equalsIgnoreCase("") && mesHasta.equalsIgnoreCase("") && diaHasta.equalsIgnoreCase(""))
	    		{
	    			if(log.isDebugEnabled())log.debug("El rango de fechas esta vacio asignamos unas por defecto");
	    			form.setAnioDesde("2007");
	    			form.setMesDesde("1");
	    			form.setDiaDesde("1");
	    			form.setAnioHasta("2100");
	    			form.setMesHasta("1");
	    			form.setDiaHasta("1");
	    		}
				else
	    		{
	    		
					//Comprobamos que todos los campos de la fecha desde  están rellenos
					if(anioDesde.equalsIgnoreCase("") || mesDesde.equalsIgnoreCase("") || diaDesde.equalsIgnoreCase(""))
						throw new ValidatorException("{informes.crearInformes.fechaDesdeCampoVacio}");
	    		
					//Comprobamos que todos los campos de la fecha hasta  están rellenos
					if(anioHasta.equalsIgnoreCase("") || mesHasta.equalsIgnoreCase("") || diaHasta.equalsIgnoreCase(""))
						throw new ValidatorException("{informes.crearInformes.fechaHastaCampoVacio}");
	    		
	    		}
				
		    	//Comprobamos que la fecha Desde es numerica
	    		if(log.isDebugEnabled())log.debug("comprobamos si las fechas Desde y Hasta tienen caracteres no numericos");
	    		try
	    		{
	    		 	new Integer(diaDesde).intValue();
	    		 	new Integer(mesDesde).intValue();
	    		 	new Integer(anioDesde).intValue();
	    		 	
	    		}
				catch(Exception e)
	    		{
	    			log.error("Alguno de los campos de la fecha desde no son números");
	    			throw new ValidatorException("{tareas.eliminarOdes.fechaDesde}");
	    		}
	    		
				//Comprobamos que la fecha Hasta es numerica
				try
	    		{
	    		 	new Integer(diaHasta).intValue();
	    		 	new Integer(mesHasta).intValue();
	    		 	new Integer(anioHasta).intValue();
	    		 	
	    		}
				catch(Exception e)
	    		{
	    			log.error("Alguno de los campos de la fecha hasta no son números");
	    			throw new ValidatorException("{tareas.eliminarOdes.fechaHasta}");
	    		}
	    		
				//Comprobamos si las fechas son correctas
				if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Desde es correcta");
		    	boolean fechaDesdeValida = utilidades.validacionFechaDDMMAAAAHHMM(diaDesde, mesDesde, anioDesde, "yyyyMMdd");
		
		    	if (!fechaDesdeValida)
		    		throw new ValidatorException("{informes.crearInformes.fechaDesdeIncorrecta}");
		    	
		    	if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Hasta es correcta");
		    	boolean fechaHastaValida = utilidades.validacionFechaDDMMAAAAHHMM(diaHasta, mesHasta, anioHasta, "yyyyMMdd");
		    	
				if (!fechaHastaValida)
					throw new ValidatorException("{informes.crearInformes.fechaHastaIncorrecta}");
		    	
		       	//Comprobamos que la fecha Hasta es mayor o igual que la fecha Desde
				if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Desde es menor que la fecha Hasta");
				boolean comparacionFecha = utilidades.comparacionFechas(anioDesde, mesDesde, diaDesde,anioHasta, mesHasta, diaHasta);
				
				if (!comparacionFecha)
					throw new ValidatorException("{informes.crearInformes.fechasOrdenIncorrectas}");
				
				if(log.isDebugEnabled())log.debug("Comprobamos que los campos dia y mes (de Desde y Hasta) tengan dos digitos");
				
				//Comprobamos si el dia y la hora tienen dos dígitos
				
				if(diaDesde.length() == 1)
					diaDesde = "0" + diaDesde;
					
				if(mesDesde.length() == 1)
					mesDesde = "0" + mesDesde;
				
				if(diaHasta.length() == 1)
					diaHasta = "0" + diaHasta;
				
				if( mesHasta.length() == 1)
					 mesHasta = "0" + mesHasta;
				
				
				//convertimos los datos de fechas Desde y Hasta en un calendar
				
				Calendar fechaDesde = Calendar.getInstance(tz);
				fechaDesde = new GregorianCalendar(new Integer(anioDesde).intValue(), new Integer(mesDesde).intValue() - 1, 
						new Integer(diaDesde).intValue(),00, 00);

				Calendar fechaHasta = Calendar.getInstance(tz);
				fechaHasta = new GregorianCalendar(new Integer(anioHasta).intValue(),
						new Integer(mesHasta).intValue() - 1, new Integer(form.getDiaHasta())
								.intValue(),23, 59);
				
		    	tareaInformeVO.setFechaDesde(fechaDesde);
		    	tareaInformeVO.setFechaHasta(fechaHasta);
		    
			}
			else
				if(log.isDebugEnabled())log.debug("La tarea es periodica y no se pasa fechaDesde y fechaHasta. El servicio lo rellena");
				
			if(log.isDebugEnabled())log.debug("Despues de rellenar el TareaInformeVO");
	    	
	    	//Llamamos al servicio
			if(log.isDebugEnabled())log.debug("LLamamos al servicio");
	    	TareaInformesVO tareaRecuperada = this.getSrvPlanificadorService().crearTareaInformes(tareaInformeVO);
	    	form.setTareaModificada(tareaRecuperada.getTrabajo());
	 		
	    }
    	catch(ValidatorException e2)
    	{
    		log.error("Se ha producido la siguiente excepcion" + e2);
    		throw e2;
    	}
    	catch(Exception e)
    	{
    		if(log.isDebugEnabled())log.debug("se ha producido una excepcion en cargarInformeFechas" + e);
    		throw new ValidatorException("{errors.crearInformes.general}");
    	}
    	
	}

	
	
	/**
	 * Recoge los valores de la tarea y del informe y llama al metodo que crea una tarea(siempre no periodica) de informe de rango
	 * @param mapping
	 * @param form
	 *            Formulario en el que se guardan los datos de la tarea
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void crearTareaInformesFechasRango(org.apache.struts.action.ActionMapping mapping, 
			es.pode.administracion.presentacion.planificador.crearTarea.CrearTareaInformesFechasRangoForm form, 
			javax.servlet.http.HttpServletRequest request, 
			javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
	{
		if (tz == null)
			tz = utilidades.asignarZonaHoraria();
		
		String dia = new String(form.getDia());
	 	String mes = new String(form.getMes());
	 	String anio = new String(form.getAnio());
	 	String hora = new String(form.getHora());
	 	String minutos = new String(form.getMinutos());
		
		try{
		
		
			//convertimos los datos de fecha de inicio en un calendar
			Calendar fechaInicio = Calendar.getInstance(tz);
			fechaInicio = new GregorianCalendar(new Integer(anio).intValue(), new Integer(mes).intValue() - 1, 
				new Integer(dia).intValue(), new Integer(hora).intValue(), new Integer(minutos).intValue());
					
			TareaInformesVO tareaInformeVO = new TareaInformesVO();
	    	
			//Recogemos el usuario para mandarlo en el TareaInformesVO
			String usuario = LdapUserDetailsUtils.getUsuario();
			
	    	//recogemos los valores del formulario y los metemos en el VO para lanzar el servicio
	    	tareaInformeVO.setTrabajo(form.getTrabajo());
	    	tareaInformeVO.setTrigger(form.getTrigger());
	    	tareaInformeVO.setTipoTarea(form.getTipoTarea());
	    	tareaInformeVO.setInforme(form.getTipoTarea());
	    	tareaInformeVO.setMsgDescripcionTrabajo(form.getMsgDescTrabajo());
	    	tareaInformeVO.setMsgInforme(form.getMsgInforme());
	    	tareaInformeVO.setMsgNoInforme(form.getMsgNoInforme());
	    	tareaInformeVO.setPeriodicidad(form.getPeriodicidad());
	    	tareaInformeVO.setFormato(form.getFormato());
	    	tareaInformeVO.setFechaInicio(fechaInicio);
			tareaInformeVO.setRango(form.getRango());
	    	tareaInformeVO.setUsuario(usuario);
    		
			if((form.getPeriodicidad()).equalsIgnoreCase("N"))
			{
				
				String diaDesde = new String(form.getDiaDesde());
			 	String mesDesde = new String(form.getMesDesde());
			 	String anioDesde = new String(form.getAnioDesde());
			 	String diaHasta = new String(form.getDiaHasta());
			 	String mesHasta = new String(form.getMesHasta());
			 	String anioHasta = new String(form.getAnioHasta());
			
	    		//Comprobamos si estan vacías las dos fechas(Desde y Hasta), si es asi,  asignaríamos fechas de un rango amplio
			 	if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Desde y Hasta estan vacias");
	    		if(anioDesde.equalsIgnoreCase("") && mesDesde.equalsIgnoreCase("") && diaDesde.equalsIgnoreCase("") && 
	    				anioHasta.equalsIgnoreCase("") && mesHasta.equalsIgnoreCase("") && diaHasta.equalsIgnoreCase(""))
	    		{
	    			if(log.isDebugEnabled())log.debug("El rango de fechas esta vacio asignamos unas por defecto");
	    			form.setAnioDesde("2007");
	    			form.setMesDesde("1");
	    			form.setDiaDesde("1");
	    			form.setAnioHasta("2100");
	    			form.setMesHasta("1");
	    			form.setDiaHasta("1");
	    		}
				else
	    		{
	    		
					//Comprobamos que todos los campos de la fecha desde  están rellenos
					if(anioDesde.equalsIgnoreCase("") || mesDesde.equalsIgnoreCase("") || diaDesde.equalsIgnoreCase(""))
						throw new ValidatorException("{informes.crearInformes.fechaDesdeCampoVacio}");
	    		
					//Comprobamos que todos los campos de la fecha hasta  están rellenos
					if(anioHasta.equalsIgnoreCase("") || mesHasta.equalsIgnoreCase("") || diaHasta.equalsIgnoreCase(""))
						throw new ValidatorException("{informes.crearInformes.fechaHastaCampoVacio}");
	    		
	    		}
				
		    	//Comprobamos que la fecha Desde es numerica
	    		if(log.isDebugEnabled())log.debug("comprobamos si las fechas Desde y Hasta tienen caracteres no numericos");
	    		try
	    		{
	    		 	new Integer(diaDesde).intValue();
	    		 	new Integer(mesDesde).intValue();
	    		 	new Integer(anioDesde).intValue();
	    		 	
	    		}
				catch(Exception e)
	    		{
	    			log.error("Alguno de los campos de la fecha desde no son números");
	    			throw new ValidatorException("{tareas.eliminarOdes.fechaDesde}");
	    		}
	    		
				//Comprobamos que la fecha Hasta es numerica
				try
	    		{
	    		 	new Integer(diaHasta).intValue();
	    		 	new Integer(mesHasta).intValue();
	    		 	new Integer(anioHasta).intValue();
	    		 	
	    		}
				catch(Exception e)
	    		{
	    			log.error("Alguno de los campos de la fecha hasta no son números");
	    			throw new ValidatorException("{tareas.eliminarOdes.fechaHasta}");
	    		}
	    		
				//Comprobamos si las fechas son correctas
				if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Desde es correcta");
		    	boolean fechaDesdeValida = utilidades.validacionFechaDDMMAAAAHHMM(diaDesde, mesDesde, anioDesde, "yyyyMMdd");
		
		    	if (!fechaDesdeValida)
		    		throw new ValidatorException("{informes.crearInformes.fechaDesdeIncorrecta}");
		    	
		    	if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Hasta es correcta");
		    	boolean fechaHastaValida = utilidades.validacionFechaDDMMAAAAHHMM(diaHasta, mesHasta, anioHasta, "yyyyMMdd");
		    	
				if (!fechaHastaValida)
					throw new ValidatorException("{informes.crearInformes.fechaHastaIncorrecta}");
		    	
		       	//Comprobamos que la fecha Hasta es mayor o igual que la fecha Desde
				if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Desde es menor que la fecha Hasta");
				boolean comparacionFecha = utilidades.comparacionFechas(anioDesde, mesDesde, diaDesde,anioHasta, mesHasta, diaHasta);
				
				if (!comparacionFecha)
					throw new ValidatorException("{informes.crearInformes.fechasOrdenIncorrectas}");
				
				if(log.isDebugEnabled())log.debug("Comprobamos que los campos dia y mes (de Desde y Hasta) tengan dos digitos");
				
				//Comprobamos si el dia y la hora tienen dos dígitos
				
				if(diaDesde.length() == 1)
					diaDesde = "0" + diaDesde;
					
				if(mesDesde.length() == 1)
					mesDesde = "0" + mesDesde;
				
				if(diaHasta.length() == 1)
					diaHasta = "0" + diaHasta;
				
				if( mesHasta.length() == 1)
					 mesHasta = "0" + mesHasta;
				
				
				//convertimos los datos de fechas Desde y Hasta en un calendar
				
				Calendar fechaDesde = Calendar.getInstance(tz);
				fechaDesde = new GregorianCalendar(new Integer(anioDesde).intValue(), new Integer(mesDesde).intValue() - 1, 
						new Integer(diaDesde).intValue(),00, 00);

				Calendar fechaHasta = Calendar.getInstance(tz);
				fechaHasta = new GregorianCalendar(new Integer(anioHasta).intValue(),
						new Integer(mesHasta).intValue() - 1, new Integer(form.getDiaHasta())
								.intValue(),23, 59);
				
		    	tareaInformeVO.setFechaDesde(fechaDesde);
		    	tareaInformeVO.setFechaHasta(fechaHasta);
		    
			}
			else
				if(log.isDebugEnabled())log.debug("La tarea es periodica y no se pasa fechaDesde y fechaHasta. El servicio lo rellena");
				
			if(log.isDebugEnabled())log.debug("Despues de rellenar el TareaInformeVO");
	    	
	    	//Llamamos al servicio
			if(log.isDebugEnabled())log.debug("LLamamos al servicio");
	    	TareaInformesVO tareaRecuperada = this.getSrvPlanificadorService().crearTareaInformes(tareaInformeVO);
	    	form.setTareaModificada(tareaRecuperada.getTrabajo());
	 		
	    }
    	catch(ValidatorException e2)
    	{
    		log.error("Se ha producido la siguiente excepcion" + e2);
    		throw e2;
    	}
    	catch(Exception e)
    	{
    		if(log.isDebugEnabled())log.debug("se ha producido una excepcion en cargarInformeFechas" + e);
    		throw new ValidatorException("{errors.crearInformes.general}");
    	}
	}
	
	/**
	 * Recoge los valores de la tarea y del informe y llama al metodo que crea una tarea(siempre no periodica) de informe de usuario
	 * @param mapping
	 * @param form
	 *            Formulario en el que se guardan los datos de la tarea
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void crearTareaInformesFechaUsuario(org.apache.struts.action.ActionMapping mapping, 
			es.pode.administracion.presentacion.planificador.crearTarea.CrearTareaInformesFechaUsuarioForm form, 
			javax.servlet.http.HttpServletRequest request, 
			javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
	{
		if (tz == null)
			tz = utilidades.asignarZonaHoraria();
		
		String dia = new String(form.getDia());
	 	String mes = new String(form.getMes());
	 	String anio = new String(form.getAnio());
	 	String hora = new String(form.getHora());
	 	String minutos = new String(form.getMinutos());
	 	
		
		try
		{
		
			//convertimos los datos de fecha de inicio en un calendar
			Calendar fechaInicio = Calendar.getInstance(tz);
			fechaInicio = new GregorianCalendar(new Integer(anio).intValue(), new Integer(mes).intValue() - 1, 
				new Integer(dia).intValue(), new Integer(hora).intValue(), new Integer(minutos).intValue());
					
			TareaInformesVO tareaInformeVO = new TareaInformesVO();
	    	
			//Recogemos el usuario para mandarlo en el TareaInformesVO
			String usuario = LdapUserDetailsUtils.getUsuario();
			
			//Comprobamos que el usuario no este vacio
			
			if((form.getUsuarios() == null) || (form.getUsuarios() == "") || (form.getUsuarios().equalsIgnoreCase("#")))
			{
				log.error("Se debe seleccionar al menos un usuario");
				throw new ValidatorException("{informes.crearInformes.usuarioVacio}");
			}
			
			
	    	//recogemos los valores del formulario y los metemos en el VO para lanzar el servicio
	    	tareaInformeVO.setTrabajo(form.getTrabajo());
	    	tareaInformeVO.setTrigger(form.getTrigger());
	    	tareaInformeVO.setTipoTarea(form.getTipoTarea());
	    	tareaInformeVO.setInforme(form.getTipoTarea());
	    	tareaInformeVO.setMsgDescripcionTrabajo(form.getMsgDescTrabajo());
	    	tareaInformeVO.setMsgInforme(form.getMsgInforme());
	    	tareaInformeVO.setMsgNoInforme(form.getMsgNoInforme());
	    	tareaInformeVO.setPeriodicidad(form.getPeriodicidad());
	    	tareaInformeVO.setFormato(form.getFormato());
	    	tareaInformeVO.setFechaInicio(fechaInicio);
			tareaInformeVO.setUsuarioInforme(form.getUsuarios());
	    	tareaInformeVO.setUsuario(usuario);
    		
			if((form.getPeriodicidad()).equalsIgnoreCase("N"))
			{
				String diaDesde = new String(form.getDiaDesde());
			 	String mesDesde = new String(form.getMesDesde());
			 	String anioDesde = new String(form.getAnioDesde());
			 	String diaHasta = new String(form.getDiaHasta());
			 	String mesHasta = new String(form.getMesHasta());
			 	String anioHasta = new String(form.getAnioHasta());
			
	    		//Comprobamos si estan vacías las dos fechas(Desde y Hasta), si es asi,  asignaríamos fechas de un rango amplio
			 	if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Desde y Hasta estan vacias");
	    		if(anioDesde.equalsIgnoreCase("") && mesDesde.equalsIgnoreCase("") && diaDesde.equalsIgnoreCase("") && 
	    				anioHasta.equalsIgnoreCase("") && mesHasta.equalsIgnoreCase("") && diaHasta.equalsIgnoreCase(""))
	    		{
	    			if(log.isDebugEnabled())log.debug("El rango de fechas esta vacio asignamos unas por defecto");
	    			form.setAnioDesde("2007");
	    			form.setMesDesde("1");
	    			form.setDiaDesde("1");
	    			form.setAnioHasta("2100");
	    			form.setMesHasta("1");
	    			form.setDiaHasta("1");
	    		}
				else
	    		{
	    		
					//Comprobamos que todos los campos de la fecha desde  están rellenos
					if(anioDesde.equalsIgnoreCase("") || mesDesde.equalsIgnoreCase("") || diaDesde.equalsIgnoreCase(""))
						throw new ValidatorException("{informes.crearInformes.fechaDesdeCampoVacio}");
	    		
					//Comprobamos que todos los campos de la fecha hasta  están rellenos
					if(anioHasta.equalsIgnoreCase("") || mesHasta.equalsIgnoreCase("") || diaHasta.equalsIgnoreCase(""))
						throw new ValidatorException("{informes.crearInformes.fechaHastaCampoVacio}");
	    		
	    		}
				
		    	//Comprobamos que la fecha Desde es numerica
	    		if(log.isDebugEnabled())log.debug("comprobamos si las fechas Desde y Hasta tienen caracteres no numericos");
	    		try
	    		{
	    		 	new Integer(diaDesde).intValue();
	    		 	new Integer(mesDesde).intValue();
	    		 	new Integer(anioDesde).intValue();
	    		 	
	    		}
				catch(Exception e)
	    		{
	    			log.error("Alguno de los campos de la fecha desde no son números");
	    			throw new ValidatorException("{tareas.eliminarOdes.fechaDesde}");
	    		}
	    		
				//Comprobamos que la fecha Hasta es numerica
				try
	    		{
	    		 	new Integer(diaHasta).intValue();
	    		 	new Integer(mesHasta).intValue();
	    		 	new Integer(anioHasta).intValue();
	    		 	
	    		}
				catch(Exception e)
	    		{
	    			log.error("Alguno de los campos de la fecha hasta no son números");
	    			throw new ValidatorException("{tareas.eliminarOdes.fechaHasta}");
	    		}
	    		
				//Comprobamos si las fechas son correctas
				if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Desde es correcta");
		    	boolean fechaDesdeValida = utilidades.validacionFechaDDMMAAAAHHMM(diaDesde, mesDesde, anioDesde, "yyyyMMdd");
		
		    	if (!fechaDesdeValida)
		    		throw new ValidatorException("{informes.crearInformes.fechaDesdeIncorrecta}");
		    	
		    	if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Hasta es correcta");
		    	boolean fechaHastaValida = utilidades.validacionFechaDDMMAAAAHHMM(diaHasta, mesHasta, anioHasta, "yyyyMMdd");
		    	
				if (!fechaHastaValida)
					throw new ValidatorException("{informes.crearInformes.fechaHastaIncorrecta}");
		    	
		       	//Comprobamos que la fecha Hasta es mayor o igual que la fecha Desde
				if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Desde es menor que la fecha Hasta");
				boolean comparacionFecha = utilidades.comparacionFechas(anioDesde, mesDesde, diaDesde,anioHasta, mesHasta, diaHasta);
				
				if (!comparacionFecha)
					throw new ValidatorException("{informes.crearInformes.fechasOrdenIncorrectas}");
				
				if(log.isDebugEnabled())log.debug("Comprobamos que los campos dia y mes (de Desde y Hasta) tengan dos digitos");
				
				//Comprobamos si el dia y la hora tienen dos dígitos
				
				if(diaDesde.length() == 1)
					diaDesde = "0" + diaDesde;
					
				if(mesDesde.length() == 1)
					mesDesde = "0" + mesDesde;
				
				if(diaHasta.length() == 1)
					diaHasta = "0" + diaHasta;
				
				if( mesHasta.length() == 1)
					 mesHasta = "0" + mesHasta;
				
				
				//convertimos los datos de fechas Desde y Hasta en un calendar
				
				Calendar fechaDesde = Calendar.getInstance(tz);
				fechaDesde = new GregorianCalendar(new Integer(anioDesde).intValue(), new Integer(mesDesde).intValue() - 1, 
						new Integer(diaDesde).intValue(),00, 00);

				Calendar fechaHasta = Calendar.getInstance(tz);
				fechaHasta = new GregorianCalendar(new Integer(anioHasta).intValue(),
						new Integer(mesHasta).intValue() - 1, new Integer(form.getDiaHasta())
								.intValue(),23, 59);
				
		    	tareaInformeVO.setFechaDesde(fechaDesde);
		    	tareaInformeVO.setFechaHasta(fechaHasta);
		    
			}
			else
				if(log.isDebugEnabled())log.debug("La tarea es periodica y no se pasa fechaDesde y fechaHasta. El servicio lo rellena");
				
			if(log.isDebugEnabled())log.debug("Despues de rellenar el TareaInformeVO");
	    	
	    	//Llamamos al servicio
			if(log.isDebugEnabled())log.debug("LLamamos al servicio");
	    	TareaInformesVO tareaRecuperada = this.getSrvPlanificadorService().crearTareaInformes(tareaInformeVO);
	    	form.setTareaModificada(tareaRecuperada.getTrabajo());
	 		
	    }
    	catch(ValidatorException e2)
    	{
    		log.error("Se ha producido la siguiente excepcion" + e2);
    		throw e2;
    	}
    	catch(Exception e)
    	{
    		if(log.isDebugEnabled())log.debug("se ha producido una excepcion en cargarInformeFechas" + e);
    		throw new ValidatorException("{errors.crearInformes.general}");
    	}
	}
	
	
	
	
	/**
	 * Recoge los valores de la tarea y del informe y llama al metodo que crea una tarea de INFORME FEDERADO
	 * @param mapping
	 * @param form Formulario en el que se guardan los datos de la tarea
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void crearTareaInformeFederado(org.apache.struts.action.ActionMapping mapping, 
			es.pode.administracion.presentacion.planificador.crearTarea.CrearTareaInformeFederadoForm form, 
			javax.servlet.http.HttpServletRequest request, 
			javax.servlet.http.HttpServletResponse response) throws java.lang.Exception 
	{
		if (tz == null)
			tz = utilidades.asignarZonaHoraria();
		
		String dia = new String(form.getDia());
	 	String mes = new String(form.getMes());
	 	String anio = new String(form.getAnio());
	 	String hora = new String(form.getHora());
	 	String minutos = new String(form.getMinutos());
		
		try{
		
		
			//convertimos los datos de fecha de inicio en un calendar
			Calendar fechaInicio = Calendar.getInstance(tz);
			fechaInicio = new GregorianCalendar(new Integer(anio).intValue(), new Integer(mes).intValue() - 1, 
				new Integer(dia).intValue(), new Integer(hora).intValue(), new Integer(minutos).intValue());
					
			TareaInformesVO tareaInformeVO = new TareaInformesVO();
	    	
			//Recogemos el usuario para mandarlo en el TareaInformesVO
			String usuario = LdapUserDetailsUtils.getUsuario();
			
			if(log.isDebugEnabled())log.debug("rellenamos los datos del VO desde el formulario");
	    	//recogemos los valores del formulario y los metemos en el VO para lanzar el servicio
	    	tareaInformeVO.setTrabajo(form.getTrabajo());
	    	tareaInformeVO.setTrigger(form.getTrigger());
	    	tareaInformeVO.setTipoTarea(form.getTipoTarea());
	    	tareaInformeVO.setInforme(form.getTipoTarea());
	    	tareaInformeVO.setMsgDescripcionTrabajo(form.getMsgDescTrabajo());
	    	tareaInformeVO.setMsgInforme(form.getMsgInforme());
	    	tareaInformeVO.setMsgNoInforme(form.getMsgNoInforme());
	    	tareaInformeVO.setPeriodicidad(form.getPeriodicidad());
	    	tareaInformeVO.setFormato(form.getFormato());
	    	tareaInformeVO.setFechaInicio(fechaInicio);
	    	tareaInformeVO.setUsuario(usuario);
    		
			//La fechaDesde y fechaHasta es rellenada en la generacion del informe
	    	
	    	if(log.isDebugEnabled())log.debug("Despues de rellenar el TareaInformeVO");
	    	
	    	//Llamamos al servicio
	    	if(log.isDebugEnabled())log.debug("LLamamos al servicio");
	    	TareaInformesVO tareaRecuperada = this.getSrvPlanificadorService().crearTareaInformesFederado(tareaInformeVO);
	    	form.setTareaModificada(tareaRecuperada.getTrabajo());
	 		
	    }
    	catch(ValidatorException e2)
    	{
    		log.error("Se ha producido la siguiente excepcion" + e2);
    		throw e2;
    	}
    	catch(Exception e)
    	{
    		if(log.isDebugEnabled())log.debug("se ha producido una excepcion en cargarInformeFechas" + e);
    		throw new ValidatorException("{errors.crearInformes.general}");
    	}
    	
	}
	
	public void crearTareaInformeCatalogo(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.crearTarea.CrearTareaInformeCatalogoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
	{
		if (tz == null)
			tz = utilidades.asignarZonaHoraria();
		
		String dia = new String(form.getDia());
	 	String mes = new String(form.getMes());
	 	String anio = new String(form.getAnio());
	 	String hora = new String(form.getHora());
	 	String minutos = new String(form.getMinutos());
		
		try{
		
		
			//convertimos los datos de fecha de inicio en un calendar
			Calendar fechaInicio = Calendar.getInstance(tz);
			fechaInicio = new GregorianCalendar(new Integer(anio).intValue(), new Integer(mes).intValue() - 1, 
				new Integer(dia).intValue(), new Integer(hora).intValue(), new Integer(minutos).intValue());
					
			TareaInformesVO tareaInformeVO = new TareaInformesVO();
	    	
			//Recogemos el usuario para mandarlo en el TareaInformesVO
			String usuario = LdapUserDetailsUtils.getUsuario();
			
			if(log.isDebugEnabled())log.debug("rellenamos los datos del VO desde el formulario");
	    	//recogemos los valores del formulario y los metemos en el VO para lanzar el servicio
	    	tareaInformeVO.setTrabajo(form.getTrabajo());
	    	//tareaInformeVO.setTrigger(form.getTrigger());
	    	tareaInformeVO.setTipoTarea(form.getTipoTarea());
	    	tareaInformeVO.setInforme(form.getTipoTarea());
	    	tareaInformeVO.setPeriodicidad(form.getPeriodicidad());
	    	tareaInformeVO.setFechaInicio(fechaInicio);
	    	tareaInformeVO.setUsuario(usuario);
    		
			//La fechaDesde y fechaHasta no hace falta para este informe
	    	
	    	if(log.isDebugEnabled())log.debug("Despues de rellenar el TareaInformeVO");
	    	
	    	//Llamamos al servicio
	    	if(log.isDebugEnabled())log.debug("LLamamos al servicio");
	    	TareaInformesVO tareaRecuperada = this.getSrvPlanificadorService().crearTareaInformesCatalogo(tareaInformeVO);
	    	form.setTareaModificada(tareaRecuperada.getTrabajo());
	 		
	    }
    	catch(ValidatorException e2)
    	{
    		log.error("Se ha producido la siguiente excepcion" + e2);
    		throw e2;
    	}
    	catch(Exception e)
    	{
    		if(log.isDebugEnabled())log.debug("se ha producido una excepcion en cargarInformeFechas" + e);
    		throw new ValidatorException("{errors.crearInformes.general}");
    	}
	}
	
	
	/**
	 * Carga la fecha actual en los datos de fecha y los pasa por le formulario
	 * 
	 * @param mapping
	 * @param form
	 *            Formulario en el que se guardan los datos de la fecha(dia,
	 *            mes, año)
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public final void cargarFechaActual(ActionMapping mapping,
			CargarFechaActualForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		

		if (tz == null)
			tz = utilidades.asignarZonaHoraria();

		Calendar fechaHoy = Calendar.getInstance(tz);
		form.setDia((new Integer(fechaHoy.get(Calendar.DAY_OF_MONTH))).toString());
		form.setMes((new Integer(fechaHoy.get(Calendar.MONTH) + 1)).toString());
		form.setAnio((new Integer(fechaHoy.get(Calendar.YEAR))).toString());

		
	}
	
	/**
	 * Obtiene los usuarios que hay disponilbes en la base de datos
	 * 
	 * @param mapping
	 * @param form Formulario en el que se guardan los datos 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void obtenerUsuarios(org.apache.struts.action.ActionMapping mapping, 
			es.pode.administracion.presentacion.planificador.crearTarea.ObtenerUsuariosForm form, 
			javax.servlet.http.HttpServletRequest request, 
			javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
	{
		//String idiomaSelected = LdapUserDetailsUtils.getIdiomaBusqueda();
		//LocalizacionIdiomaVO[] localizadorIdioma = this.getSrvBuscadorService().obtenerIdiomasLocalizados(idiomaSelected);
		
		List usuariosList = Arrays.asList(this.getSrvAdminUsuariosService().listarTodosUsuarios());
		if(log.isDebugEnabled())log.debug("se recogen los usuarios de la aplicacion, estos son: " + usuariosList);
		// Rellena el combo de usuarios
		form.setUsuariosBackingList(usuariosList, "usuario", "usuario");
	}
	
	
	
	/**
	 * Obtiene los idiomas disponibles para reindexar, obtenemos los idiomas del agrega.properties
	 * 
	 * @param mapping
	 * @param form Formulario en el que se guardan los datos 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void cargarIdiomaReindexado(org.apache.struts.action.ActionMapping mapping, 
			es.pode.administracion.presentacion.planificador.crearTarea.CargarIdiomaReindexadoForm form, 
			javax.servlet.http.HttpServletRequest request, 
			javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
	{
		I18n i18n = I18n.getInstance();
    	
    	//Recogemos el idioma por defecto para mostrar en ese idioma la lista desplegable de idiomas
    	Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
    	
    	
    	//recogemos un array de objetos con la lista de idiomas
    	es.pode.soporte.i18n.LocalizacionIdiomaVO[] localizacionArray = i18n.obtenerIdiomasBuscablesLocalizados(locale.getLanguage());
    	//LocalizacionIdiomaVO[] localizacionArray = i18n.obtenerIdiomasBuscablesLocalizados(locale.getLanguage());
    	
    	//sacamos los idiomas del array de objetos y lo asignamos al combo
    	form.setIdiomaBackingList(Arrays.asList(localizacionArray), "idLocalizacion", "name");
		
	}
	

}
