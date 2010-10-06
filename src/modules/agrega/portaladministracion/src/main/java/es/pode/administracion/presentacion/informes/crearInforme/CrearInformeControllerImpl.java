/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.administracion.presentacion.informes.crearInforme;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import es.pode.administracion.presentacion.planificador.comun.Utiles;
import es.pode.auditoria.negocio.servicios.ParametroCrearInformeVO;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.administracion.presentacion.informes.crearInforme.CrearInformeController
 */
public class CrearInformeControllerImpl extends CrearInformeController
{

	private static Logger log = Logger.getLogger(CrearInformeControllerImpl.class);
	private java.util.Properties pSpringProperties = null;

	Utiles utilidades = new Utiles();



    /**
     * @see es.pode.administracion.presentacion.informes.crearInforme.CrearInformeController#cargarInformes(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.informes.crearInforme.CargarInformesForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargarInformes(ActionMapping mapping, es.pode.administracion.presentacion.informes.crearInforme.CargarInformesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
		String[] informesAuditoria = this.getSrvAuditoriaServicio().obtenerInformes();
		form.setInformesAsArray(map_informes(informesAuditoria, getFicherRecursos(new Locale(LdapUserDetailsUtils.getIdioma()))));
		
				
     } 

    /**
     * @see es.pode.administracion.presentacion.informes.crearInforme.CrearInformeController#obtenerTipoInforme(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.informes.crearInforme.ObtenerTipoInformeForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String obtenerTipoInforme(ActionMapping mapping, es.pode.administracion.presentacion.informes.crearInforme.ObtenerTipoInformeForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	
		String tipoInforme = null;
		
		try{
			
			if(log.isDebugEnabled())log.debug("obtenerTipoInforme");
	        String idInforme = form.getInforme();
	        if((idInforme == null)||(idInforme == ""))
	        {
	        	log.error("No se ha seleccionado ningun informe");
	        	throw new ValidatorException ("{errors.crearInformes.informeNulo}"); 
	        }
	       
	        if(idInforme.equalsIgnoreCase("siteWideActivity") || idInforme.equalsIgnoreCase("estadoOdes") || idInforme.equalsIgnoreCase("operacionesRealizadas") || idInforme.equalsIgnoreCase("nivelAgregacion") || idInforme.equalsIgnoreCase("coberturaCurricular") || idInforme.equalsIgnoreCase("odesLicencias") || idInforme.equalsIgnoreCase("usuarios") || idInforme.equalsIgnoreCase("procesosPlanificados"))
	        {
	        	if(log.isDebugEnabled())log.debug("cargo informe con fechas");	
	        	tipoInforme = "fechas";
	        }else
	        {
	        	if(idInforme.equalsIgnoreCase("mostActiveUsers") || idInforme.equalsIgnoreCase("terminosBusqueda") ||  idInforme.equalsIgnoreCase("masValorado") || idInforme.equalsIgnoreCase("masMostrado") || idInforme.equalsIgnoreCase("masPrevisualizado") || idInforme.equalsIgnoreCase("masVisualizado") || idInforme.equalsIgnoreCase("masDescargado") || idInforme.equalsIgnoreCase("tamanio"))
	        	{
	        		if(log.isDebugEnabled())log.debug("cargo informe con rango");
	        		tipoInforme = "rango";
	        	}else
	        	{
	        		if(idInforme.equalsIgnoreCase("odesUsuario"))
	        		{
	        			if(log.isDebugEnabled())log.debug("cargo informe con usuario");
	        			tipoInforme = "usuario";
	        		}
	        		else
	        			throw new ValidatorException("{errors.crearInforme.noExisteInforme}");
	        		
	        	}
	        }
	        if(log.isDebugEnabled())log.debug("tipoInforme -> "+tipoInforme);
	        if(log.isDebugEnabled())log.debug("El rango de fechas esta vacio asignamos unas por defecto");
 			String diaDesde = this.getPropertyValue("diaDesde"); 
 			String mesDesde = this.getPropertyValue("mesDesde");
 	    	String anioDesde = this.getPropertyValue("anioDesde");
 	    	GregorianCalendar fCalendar = new GregorianCalendar();
 	    	String diaHasta = new Integer(fCalendar.get(GregorianCalendar.DAY_OF_MONTH)).toString();
 	    	String mesHasta = new Integer(fCalendar.get(Calendar.MONTH) + 1).toString();
 	    	String anioHasta = new Integer(fCalendar.get(GregorianCalendar.YEAR)).toString();
 	    	form.setAnioDesde(anioDesde);
 	    	form.setMesDesde(mesDesde);
 	    	form.setDiaDesde(diaDesde);
 	    	form.setAnioHasta(anioHasta);
 	    	form.setMesHasta(mesHasta);
 	    	form.setDiaHasta(diaHasta);
		}
		catch(ValidatorException Ve)
		{
			log.error("Ve ->"+Ve);
			throw Ve;
    	} 
		catch (Exception e)
		{
    		log.error("Se ha producido un error al intentar recuperar los ids de los ficheros de log a borrar: " +e);
    		throw new ValidatorException("{errors.crearInformes.general}");
		}
		return tipoInforme;
    }



    /**
     * @see es.pode.administracion.presentacion.informes.crearInforme.CrearInformeController#cargarInformeFechas(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.informes.crearInforme.CargarInformeFechasForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargarInformeFechas(ActionMapping mapping, es.pode.administracion.presentacion.informes.crearInforme.CargarInformeFechasForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	DataHandler data = null;
        //final int BUFFER_SIZE = 10000;
    	
    	String diaDesde = null;
    	String mesDesde = null;
    	String anioDesde = null;
    	String diaHasta = null;
    	String mesHasta = null;
    	String anioHasta = null;
    	
    	try{
    		
    		diaDesde = new String(form.getDiaDesde());
    		mesDesde = new String(form.getMesDesde());
    		anioDesde = new String(form.getAnioDesde());
    		diaHasta = new String(form.getDiaHasta());
    		mesHasta = new String(form.getMesHasta());
    		anioHasta = new String(form.getAnioHasta());
    		
    		//Comprobamos que los campos fechas no estan vacios
    		if(anioDesde.equalsIgnoreCase("") && mesDesde.equalsIgnoreCase("") && diaDesde.equalsIgnoreCase("") 
    		   && anioHasta.equalsIgnoreCase("") && mesHasta.equalsIgnoreCase("") && diaHasta.equalsIgnoreCase(""))
    		{
    			if(log.isDebugEnabled())log.debug("El rango de fechas esta vacio asignamos unas por defecto");
    			diaDesde = this.getPropertyValue("diaDesde"); 
    			mesDesde = this.getPropertyValue("mesDesde");
    	    	anioDesde = this.getPropertyValue("anioDesde");
    	    	GregorianCalendar fCalendar = new GregorianCalendar();
    	    	diaHasta = new Integer(fCalendar.get(GregorianCalendar.DAY_OF_MONTH)).toString();
    	    	mesHasta = new Integer(fCalendar.get(Calendar.MONTH) + 1).toString();
    	    	anioHasta = new Integer(fCalendar.get(GregorianCalendar.YEAR)).toString();
    	    	
    	    	
    		}else
    		{
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
    			
    			
    			//Comprobamos que las fechas son correctas
        		if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Desde es correcta");
    			boolean fechaDesdeValida = utilidades.validacionFechaDDMMAAAAHHMM(diaDesde, mesDesde, anioDesde, "yyyyMMdd");
	
    			if (!fechaDesdeValida)
    				throw new ValidatorException("{informes.crearInformes.fechaDesdeIncorrecta}");
	    	
    			if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Hasta es correcta");
    			boolean fechaHastaValida = utilidades.validacionFechaDDMMAAAAHHMM(diaHasta, mesHasta, anioHasta, "yyyyMMdd");
	    	
    			if (!fechaHastaValida)
    				throw new ValidatorException("{informes.crearInformes.fechaHastaIncorrecta}");
	    	
    			//Comprobamos que la fecha Hasta es mayor que la fecha Desde
    			if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Desde es menor que la fecha Hasta");
    			boolean comparacionFecha = utilidades.comparacionFechas(anioDesde, mesDesde, diaDesde, anioHasta, mesHasta, diaHasta);

			
    			if (!comparacionFecha)
    				throw new ValidatorException("{informes.crearInformes.fechasOrdenIncorrectas}");
    			if(log.isDebugEnabled())log.debug("Generamos los informes");
    		}
    		
			//Comprobamos si el dia y la hora tienen dos dígitos
			if(diaDesde.length() == 1)
			{
				diaDesde = "0" + diaDesde;
			}
			if(mesDesde.length() == 1)
			{
				mesDesde = "0" + mesDesde;
			}
			if(diaHasta.length() == 1)
			{
				diaHasta = "0" + diaHasta;
			}
			if( mesHasta.length() == 1)
			{
				 mesHasta = "0" + mesHasta;
			}
    		
			if(log.isDebugEnabled())log.debug("form.getInforme() ->"+form.getInforme());
	    	ParametroCrearInformeVO parametroCrearInformeVO = new ParametroCrearInformeVO();
	    	parametroCrearInformeVO.setAnioDesde(anioDesde);
	    	parametroCrearInformeVO.setMesDesde(mesDesde);
	    	parametroCrearInformeVO.setDiaDesde(diaDesde);
	    	parametroCrearInformeVO.setAnioHasta(anioHasta);
	    	parametroCrearInformeVO.setMesHasta(mesHasta);
	    	parametroCrearInformeVO.setDiaHasta(diaHasta);
	    	//El formato se recogera del formulario
	    	parametroCrearInformeVO.setFormato(form.getFormato());
	    	parametroCrearInformeVO.setNombreInforme(form.getInforme());
	    	if(log.isDebugEnabled())log.debug("Despues de parametroCrearInformeVO");
	    	
	    	try {
			
				data = this.getSrvAuditoriaServicio().crearInforme(parametroCrearInformeVO);
				if(log.isDebugEnabled())log.debug("data ->"+data);
				if(form.getFormato().equalsIgnoreCase("html"))
				{   if(log.isDebugEnabled())log.debug("El formato es html");
					response.setContentType("text/html");
				}else
				{
					if(form.getFormato().equalsIgnoreCase("pdf"))
					{
						if(log.isDebugEnabled())log.debug("El formato es pdf");
						response.setContentType("application/pdf");
						response.setHeader("Content-Disposition","attachment;fileName=\""+this.getPropertyValue(form.getInforme())+".pdf\"");
					}else
					{
						if(log.isDebugEnabled())log.debug("el formato es xls");
						response.setContentType("application/xls");
						response.setHeader("Content-Disposition","attachment;fileName=\""+this.getPropertyValue(form.getInforme())+".xls\"");
					}
				}
				if(log.isDebugEnabled())log.debug("response.setContentType");
		    	OutputStream out = (OutputStream)response.getOutputStream();
		    	//InputStream in = data.getInputStream();
		    	data.writeTo(out);
		    	if(log.isDebugEnabled())log.debug("despues de data.writeTo");
		    	out.flush();
		        out.close();
		        if(log.isDebugEnabled())log.debug("Se ha devuelto un datahandler");
				

			} catch (Exception ex)
	    	{
	    		log.error("ex ->"+ex);
	    		throw new ValidatorException("{errors.crearInformes.general}");
	    	}
			
			// si data es null se lanza la exception
			if (data == null)
			{
				log.error("data es null");
				throw new ValidatorException("{errors.crearInformes.general}");
			}
			
	    	
    	}
    	catch(ValidatorException e2)
    	{
    		log.error("Se ha producido la siguiente excepcion" + e2);
    		throw e2;
    	}
    	catch(Exception e)
    	{
    		if(log.isDebugEnabled())log.debug("se ha producido una excepcion en cargarInformeFechas" + e);
    		//throw new ValidatorException("{errors.crearInformes.general}");
    	}
     	
		
     }

    /**
     * @see es.pode.administracion.presentacion.informes.crearInforme.CrearInformeController#cargarInformeFechasRango(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.informes.crearInforme.CargarInformeFechasRangoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargarInformeFechasRango(ActionMapping mapping, es.pode.administracion.presentacion.informes.crearInforme.CargarInformeFechasRangoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	DataHandler data = null;
        final int BUFFER_SIZE = 2048;
        
       String diaDesde = null;
    	String mesDesde = null;
    	String anioDesde = null;
    	String diaHasta = null;
    	String mesHasta = null;
    	String anioHasta = null;
    	
    	try{
    		
    		diaDesde = new String(form.getDiaDesde());
    		mesDesde = new String(form.getMesDesde());
    		anioDesde = new String(form.getAnioDesde());
    		diaHasta = new String(form.getDiaHasta());
    		mesHasta = new String(form.getMesHasta());
    		anioHasta = new String(form.getAnioHasta());
    		
    		//Comprobamos que los campos fechas no estan vacios
       		if(anioDesde.equalsIgnoreCase("") && mesDesde.equalsIgnoreCase("") && diaDesde.equalsIgnoreCase("") && anioHasta.equalsIgnoreCase("") && mesHasta.equalsIgnoreCase("") && diaHasta.equalsIgnoreCase(""))
    		{
       			if(log.isDebugEnabled())log.debug("El rango de fechas esta vacio asignamos unas por defecto");
    			diaDesde = this.getPropertyValue("diaDesde"); 
    			mesDesde = this.getPropertyValue("mesDesde");
    	    	anioDesde = this.getPropertyValue("anioDesde");
    	    	GregorianCalendar fCalendar = new GregorianCalendar();
    	    	diaHasta = new Integer(fCalendar.get(GregorianCalendar.DAY_OF_MONTH)).toString();
    	    	mesHasta = new Integer(fCalendar.get(Calendar.MONTH) + 1).toString();
    	    	anioHasta = new Integer(fCalendar.get(GregorianCalendar.YEAR)).toString();
    		}else
    		{
    			if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Desde esta vacia");
	    		if(anioDesde.equalsIgnoreCase("") && mesDesde.equalsIgnoreCase("") && diaDesde.equalsIgnoreCase(""))
	    			throw new ValidatorException("{informes.crearInformes.fechaDesdeVacia}");
	    		
	    		if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Hasta esta vacia");
	    		if(anioHasta.equalsIgnoreCase("") && mesHasta.equalsIgnoreCase("") && diaDesde.equalsIgnoreCase(""))
	    			throw new ValidatorException("{informes.crearInformes.fechaHastaVacia}");
	    		
	        	
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
	    		
	    		
		    	//Comprobamos que las fechas son correctas
        		if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Desde es correcta");
		    	boolean fechaDesdeValida = utilidades.validacionFechaDDMMAAAAHHMM(diaDesde, mesDesde, anioDesde, "yyyyMMdd");
		
		    	if (!fechaDesdeValida)
		    		throw new ValidatorException("{informes.crearInformes.fechaDesdeIncorrecta}");
		    	
		    	if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Hasta es correcta");
		    	boolean fechaHastaValida = utilidades.validacionFechaDDMMAAAAHHMM(diaHasta, mesHasta, anioHasta, "yyyyMMdd");
		    	
				if (!fechaHastaValida)
					throw new ValidatorException("{informes.crearInformes.fechaHastaIncorrecta}");
		 	    	
		    	//Comprobamos que la fecha Hasta es mayor que la fecha Desde
				if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Desde es menor que la fecha Hasta");
				boolean comparacionFecha = utilidades.comparacionFechas(anioDesde, mesDesde, diaDesde, anioHasta, mesHasta, diaHasta);
				
				if (!comparacionFecha)
					throw new ValidatorException("{informes.crearInformes.fechasOrdenIncorrectas}");
				if(log.isDebugEnabled())log.debug("Cargar Informes con Rango");
    		}
       		
			//Comprobamos si el dia y la hora tienen dos dígitos
			if(diaDesde.length() == 1)
			{
				diaDesde = "0" + diaDesde;
			}
			if(mesDesde.length() == 1)
			{
				mesDesde = "0" + mesDesde;
			}
			if(diaHasta.length() == 1)
			{
				diaHasta = "0" + diaHasta;
			}
			if( mesHasta.length() == 1)
			{
				 mesHasta = "0" + mesHasta;
			}
			ParametroCrearInformeVO parametroCrearInformeVO = new ParametroCrearInformeVO();
	    	parametroCrearInformeVO.setAnioDesde(anioDesde);
	    	parametroCrearInformeVO.setMesDesde(mesDesde);
	    	parametroCrearInformeVO.setDiaDesde(diaDesde);
	    	parametroCrearInformeVO.setAnioHasta(anioHasta);
	    	parametroCrearInformeVO.setMesHasta(mesHasta);
	    	parametroCrearInformeVO.setDiaHasta(diaHasta);
	    	//El formato lo recojo del formulario
	    	parametroCrearInformeVO.setFormato(form.getFormato());
	    	parametroCrearInformeVO.setNombreInforme(form.getInforme());
	    	parametroCrearInformeVO.setRango(new Integer(form.getRango()));
	    	if(log.isDebugEnabled())log.debug("parametroCrearInformeVO ->"+parametroCrearInformeVO);
	    	try 
	    	{
				
				data = this.getSrvAuditoriaServicio().crearInforme(parametroCrearInformeVO);
				if(log.isDebugEnabled())log.debug("data ->"+data);
				if(form.getFormato().equalsIgnoreCase("html"))
				{
					response.setContentType("text/html");
				}else
				{
					if(form.getFormato().equalsIgnoreCase("pdf"))
					{
						response.setContentType("application/pdf");
						response.setHeader("Content-Disposition","attachment;fileName=\""+this.getPropertyValue(form.getInforme())+".pdf\"");
					}else
					{
						response.setContentType("application/xls");
						response.setHeader("Content-Disposition","attachment;fileName=\""+this.getPropertyValue(form.getInforme())+".xls\"");
					}
				}
				
				if(log.isDebugEnabled())log.debug("response.setContentType");
		    	//response.setHeader("Content-Disposition", "attachment;filename="+form.getTitulo().trim().replace(' ', '_')+".zip");
		    	OutputStream out = (OutputStream)response.getOutputStream();
		    	InputStream in = data.getInputStream();
		    	if(log.isDebugEnabled())log.debug("in ->"+in);
				byte[] buffer = new byte[BUFFER_SIZE];
				int count;
				while((count = in.read(buffer, 0, BUFFER_SIZE))!= -1)
				{
					out.write(buffer, 0, count);
				}
				out.flush();
		        out.close();
		        if(log.isDebugEnabled())log.debug("Se ha devuelto un datahandler");
				

			} catch (Exception ex)
	    	{
	    		log.error("ex ->"+ex);
	    		throw new ValidatorException("{errors.crearInformes.general}");
	    	}
			
			if (data == null)
			{
				log.error("data es null");
				throw new ValidatorException("{errors.crearInformes.general}");
			}
	    	
	    	
    	}
    	catch(ValidatorException e2)
    	{
    		log.error("ValidatorException -> "+e2);
    		throw e2;
    	}
    	catch(Exception e)
    	{
    		if(log.isDebugEnabled())log.debug("se ha producido una excepcion en cargarInformeFechasRango -> "+e);
    		//throw new ValidatorException("{errors.crearInformes.general}");
    	}
    	
    	
    	
     }


    /**
     * @see es.pode.administracion.presentacion.informes.crearInforme.CrearInformeController#cargarInformeFechasUsuario(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.informes.crearInforme.CargarInformeFechasUsuarioForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargarInformeFechasUsuario(ActionMapping mapping, es.pode.administracion.presentacion.informes.crearInforme.CargarInformeFechasUsuarioForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	DataHandler data = null;
        final int BUFFER_SIZE = 2048;
        
      String diaDesde = null;
    	String mesDesde = null;
    	String anioDesde = null;
    	String diaHasta = null;
    	String mesHasta = null;
    	String anioHasta = null;
    	
    	try{
    		
    		diaDesde = new String(form.getDiaDesde());
    		mesDesde = new String(form.getMesDesde());
    		anioDesde = new String(form.getAnioDesde());
    		diaHasta = new String(form.getDiaHasta());
    		mesHasta = new String(form.getMesHasta());
    		anioHasta = new String(form.getAnioHasta());
    		
    		//Comprobamos que los campos fechas no estan vacios
    		
    		if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Desde esta vacia");
    		if(anioDesde.equalsIgnoreCase("") && mesDesde.equalsIgnoreCase("") && diaDesde.equalsIgnoreCase("") && anioHasta.equalsIgnoreCase("") && mesHasta.equalsIgnoreCase("") && diaHasta.equalsIgnoreCase(""))
    		{
    			if(log.isDebugEnabled())log.debug("El rango de fechas esta vacio asignamos unas por defecto");
    			diaDesde = this.getPropertyValue("diaDesde"); 
    			mesDesde = this.getPropertyValue("mesDesde");
    	    	anioDesde = this.getPropertyValue("anioDesde");
    	    	GregorianCalendar fCalendar = new GregorianCalendar();
    	    	diaHasta = new Integer(fCalendar.get(GregorianCalendar.DAY_OF_MONTH)).toString();
    	    	mesHasta = new Integer(fCalendar.get(Calendar.MONTH) + 1).toString();
    	    	anioHasta = new Integer(fCalendar.get(GregorianCalendar.YEAR)).toString();
    		}else
    		{
    			
    		if(anioDesde.equalsIgnoreCase("") && mesDesde.equalsIgnoreCase("") && diaDesde.equalsIgnoreCase(""))
    			throw new ValidatorException("{informes.crearInformes.fechaDesdeVacia}");
    		
    		if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Hasta esta vacia");
    		if(anioHasta.equalsIgnoreCase("") && mesHasta.equalsIgnoreCase("") && diaHasta.equalsIgnoreCase(""))
    			throw new ValidatorException("{informes.crearInformes.fechaHastaVacia}");
    		
    		
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
    			log.error("Alguno de los campos de la fecha desde no son números");
    			throw new ValidatorException("{tareas.eliminarOdes.fechaHasta}");
    		}
    		
    		
	    	//Comprobamos que las fechas son correctas
    		if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Desde es correcta");
	    	boolean fechaDesdeValida = utilidades.validacionFechaDDMMAAAAHHMM(diaDesde, mesDesde, anioDesde, "yyyyMMdd");
	
	    	if (!fechaDesdeValida)
	    		throw new ValidatorException("{informes.crearInformes.fechaDesdeIncorrecta}");
	    	
	    	if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Hasta es correcta");
	    	boolean fechaHastaValida = utilidades.validacionFechaDDMMAAAAHHMM(diaHasta, mesHasta, anioHasta, "yyyyMMdd");
	    	
			if (!fechaHastaValida)
				throw new ValidatorException("{informes.crearInformes.fechaHastaIncorrecta}");
	    	
	    	
	    	//Comprobamos que la fecha Hasta es mayor que la fecha Desde
			
			if(log.isDebugEnabled())log.debug("Se comprueba si la fecha Desde es menor que la fecha Hasta");
			boolean comparacionFecha = utilidades.comparacionFechas(anioDesde, mesDesde, diaDesde, anioHasta, mesHasta, diaHasta);
			
			if (!comparacionFecha)
				throw new ValidatorException("{informes.crearInformes.fechasOrdenIncorrectas}");
			
			if(log.isDebugEnabled())log.debug("Cargar informes con usuario");
    		}
			if(diaDesde.length() == 1)
			{
				diaDesde = "0" + diaDesde;
			}
			if(mesDesde.length() == 1)
			{
				mesDesde = "0" + mesDesde;
			}
			if(diaHasta.length() == 1)
			{
				diaHasta = "0" + diaHasta;
			}
			if( mesHasta.length() == 1)
			{
				 mesHasta = "0" + mesHasta;
			}
			
			//Comprobamos que el usuario no este vacio
			
			if((form.getUsuarios() == null) || (form.getUsuarios() == "") || (form.getUsuarios().equalsIgnoreCase("#")))
			{
				log.error("Se debe seleccionar al menos un usuario");
				throw new ValidatorException("{informes.crearInformes.usuarioVacio}");
			}
			
			ParametroCrearInformeVO parametroCrearInformeVO = new ParametroCrearInformeVO();
	    	parametroCrearInformeVO.setAnioDesde(anioDesde);
	    	parametroCrearInformeVO.setMesDesde(mesDesde);
	    	parametroCrearInformeVO.setDiaDesde(diaDesde);
	    	parametroCrearInformeVO.setAnioHasta(anioHasta);
	    	parametroCrearInformeVO.setMesHasta(mesHasta);
	    	parametroCrearInformeVO.setDiaHasta(diaHasta);
	    	//El formato lo recojo del formulario
	    	parametroCrearInformeVO.setFormato(form.getFormato());
	    	parametroCrearInformeVO.setNombreInforme(form.getInforme());
	    	parametroCrearInformeVO.setUsuario(form.getUsuarios());
	    	if(log.isDebugEnabled())log.debug("parametroCrearInformeVO3 ->"+parametroCrearInformeVO);
	    	try {
				
				data = this.getSrvAuditoriaServicio().crearInforme(parametroCrearInformeVO);
				if(log.isDebugEnabled())log.debug("data ->"+data);
				if(form.getFormato().equalsIgnoreCase("html"))
				{
					response.setContentType("text/html");
					
				}else
				{
					if(form.getFormato().equalsIgnoreCase("pdf"))
					{
						if(log.isDebugEnabled())log.debug("El formato es pdf");
						response.setContentType("application/pdf");
						response.setHeader("Content-Disposition","attachment;fileName=\""+this.getPropertyValue(form.getInforme())+".pdf\"");
						
					}else
					{
						response.setContentType("application/vnd.ms-excel");
						response.setHeader("Content-Disposition","attachment;fileName=\""+this.getPropertyValue(form.getInforme())+".xls\""); 
						
					}
				}
				if(log.isDebugEnabled())log.debug("response.setContentType");
		    	//response.setHeader("Content-Disposition", "attachment;filename="+form.getTitulo().trim().replace(' ', '_')+".zip");
		    	OutputStream out = (OutputStream)response.getOutputStream();
		    	InputStream in = data.getInputStream();
		    	if(log.isDebugEnabled())log.debug("in ->"+in);
				byte[] buffer = new byte[BUFFER_SIZE];
				int count;
				while((count = in.read(buffer, 0, BUFFER_SIZE))!= -1)
				{
					out.write(buffer, 0, count);
				}
				out.flush();
		        out.close();
		        if(log.isDebugEnabled())log.debug("Se ha devuelto un datahandler");
				

			} catch (Exception ex)
	    	{
	    		log.error("ex ->"+ex);
	    		throw new ValidatorException("{errors.crearInformes.general}");
	    	}
			
			if (data == null)
			{
				log.error("data es null");
				throw new ValidatorException("{errors.crearInformes.general}");
			}
		
    	}
    	catch(ValidatorException e2)
    	{
    		log.error("ValidatorException -> "+e2);
    		throw e2;
    	}
    	catch(Exception e)
    	{
    		if(log.isDebugEnabled())log.debug("se ha producido una excepcion en cargarInformeFechasUsuario "+e);
    		//throw new ValidatorException("{errors.crearInformes.general}");
    	}
    	
    	
     }

   
    public final void obtenerUsuarios(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.informes.crearInforme.ObtenerUsuariosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
    	
    	
		List usuariosList = Arrays.asList(this.getSrvAdminUsuariosService().listarTodosUsuarios());
		if(log.isDebugEnabled())log.debug("se recogen los usuarios de la aplicacion, estos son: " + usuariosList);
		// 04/10/2010   Fernando Garcia
                //              now you can personalize the user fields that will appear in combos (, is the separator character)
		form.setUsuariosBackingList(usuariosList, "usuario", "nombre,apellido1,email");
    	
    }
         
    private String getPropertyValue(String sKey) throws IOException
	{
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/portaladministracion.properties");
		if (this.pSpringProperties == null)
		{
			pSpringProperties = new java.util.Properties();
			pSpringProperties.load(fIsSpringProperties);
		}
		fIsSpringProperties.close();
		
		// devolvemos la propiedad
		return pSpringProperties.getProperty(sKey);
	}
    
    private InformesAuditoria_VO map_informe (String codigo, String informe)
    {
    	InformesAuditoria_VO map_info = new InformesAuditoria_VO();
    	map_info.setCodigo(codigo);
    	map_info.setInforme(informe);
    	return map_info;
    }
	
    private InformesAuditoria_VO[] map_informes (String[] informes, ResourceBundle ficheroInternacional)
    {
    	if (informes == null || informes.length == 0)
    		return new InformesAuditoria_VO[0];
    	InformesAuditoria_VO[] map_informes = new InformesAuditoria_VO[informes.length];
    	String informeLocalizado;
    	for (int i = 0; i < informes.length; i++) {
    		informeLocalizado = ficheroInternacional.getString("informes."+informes[i]);
    		map_informes[i]= map_informe(informes[i], informeLocalizado);
		}
    	return map_informes;
    }
    
    public class InformesAuditoria_VO {
    	
    	  /* Nombre del informe. */
        private java.lang.String informe;
        
        private java.lang.String codigo;
        
		public java.lang.String getCodigo() {
			return codigo;
		}

		public void setCodigo(java.lang.String codigo) {
			this.codigo = codigo;
		}

		public java.lang.String getInforme() {
			return informe;
		}
		
		public void setInforme(java.lang.String informe) {
			this.informe = informe;
		}
    }
	private ResourceBundle getFicherRecursos(Locale locale)
	{
		ResourceBundle ficheroRecursos = null;
		ficheroRecursos = ResourceBundle.getBundle("application-resources", locale);
		return ficheroRecursos;
	}

	
	public String comprobarFinSesionFechas(ActionMapping mapping, ComprobarFinSesionFechasForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String resultado = "FALSE";
		String informe = form.getInforme();
		if(informe == null)
		{
			if(log.isDebugEnabled())log.debug("Se ha destruido la sesion");
			resultado = "TRUE";
		}
		return resultado;
	}
	
	 /**
     * 
     * Método que comprueba la finalización de la sesión del usuario.
     * Devolverá TRUE si ha terminado la sesión del usuario.
     * 
     */
	  public String comprobarFinSesionRango(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.informes.crearInforme.ComprobarFinSesionRangoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
	  {
		  String resultado = "FALSE";
			String informe = form.getInforme();
			if(informe == null)
			{
				if(log.isDebugEnabled())log.debug("Se ha destruido la sesion");
				resultado = "TRUE";
			}
			return resultado;
	  }

	    /**
	     * 
	     * Método que comprueba la finalización de la sesión del usuario.
	     * Devolverá TRUE si ha terminado la sesión del usuario.
	     * 
	     */
	    public String comprobarFinSesionUsuarios(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.informes.crearInforme.ComprobarFinSesionUsuariosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
	    {
	    	String resultado = "FALSE";
			String informe = form.getInforme();
			if(informe == null)
			{
				if(log.isDebugEnabled())log.debug("Se ha destruido la sesion");
				resultado = "TRUE";
			}
			return resultado;
	    }

	
	
	
}
