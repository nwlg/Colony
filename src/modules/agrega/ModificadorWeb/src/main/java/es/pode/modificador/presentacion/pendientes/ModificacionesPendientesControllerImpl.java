/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.modificador.presentacion.pendientes;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

import es.pode.modificador.negocio.servicio.ConfiguracionTarea;
import es.pode.modificador.negocio.servicio.ModificacionVO;
import es.pode.modificador.presentacion.DecisorOffline;
import es.pode.modificador.presentacion.configurar.ConfigurarModificacionSession;
import es.pode.modificador.presentacion.idiomasBuscador.IdiomasBuscadorSingleton;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.modificador.presentacion.pendientes.ModificacionesPendientesController
 */
public class ModificacionesPendientesControllerImpl extends ModificacionesPendientesController
{

	private final static String MENSAJE_ERROR_DETALLES = "modificacionesPendientes.msgErrorEliminar";
	private static final Logger logger =Logger.getLogger(ModificacionesPendientesControllerImpl.class);
	private final static String MENSAJE_EXITO_DETALLE = "modificacionesPendientes.msgExitoEliminar";
	/**
     * @see es.pode.modificador.presentacion.pendientes.ModificacionesPendientesController#recuperarModificaciones(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.pendientes.RecuperarModificacionesForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperarModificaciones(ActionMapping mapping, es.pode.modificador.presentacion.pendientes.RecuperarModificacionesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	request.getSession().setAttribute("offline", new Boolean(DecisorOffline.esOffline()));
    	// Meto en sesion la URL de vuelta en la version offline
    	if(request.getParameter("urlCerrar")!=null) request.getSession().setAttribute("urlCerrar", request.getParameter("urlCerrar"));
		ModificacionVO[] modificacionesPendientes = this.getSrvHerramientaModificacion().obtenerModificacionesConfiguradas();
		List modificacionesPendientesList=new ArrayList();
	
		for(int i=0; i<modificacionesPendientes.length;i++)
		{
			modificacionesPendientesList.add(i, modificacionesPendientes[i]);
		}

		form.setOffline(DecisorOffline.esOffline());
		form.setModificaciones(modificacionesPendientesList);
		logger.debug("Se ha recuperado las modificaciones pendientes+ "+form.getModificaciones());
		form.setIdiomaBuscadorBackingList(IdiomasBuscadorSingleton.getInstance().obtenerIdiomas(LdapUserDetailsUtils.getIdioma()), "idLocalizacion", "nombre");
		
     }


    /**
     * @see es.pode.modificador.presentacion.pendientes.ModificacionesPendientesController#eliminarModificaciones(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.pendientes.EliminarModificacionesForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarModificaciones(ActionMapping mapping, es.pode.modificador.presentacion.pendientes.EliminarModificacionesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    
			Long[] identificadores=(Long[])form.getIdentificadores().toArray(new Long[form.getIdentificadores().size()]);
	    	Boolean resultadoEliminacion=this.getSrvHerramientaModificacion().eliminarModificacion(identificadores);
	    	if(resultadoEliminacion.equals(Boolean.FALSE))
	    	{
	    		saveErrorMessage(request, MENSAJE_ERROR_DETALLES);
	    	}
	    	else if (resultadoEliminacion.equals(Boolean.TRUE)) 
	    	{
	    		saveSuccessMessage(request, MENSAJE_EXITO_DETALLE);
			}
    	
     }


    /**
     * @see es.pode.modificador.presentacion.pendientes.ModificacionesPendientesController#recuperarTarea(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.pendientes.RecuperarTareaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperarTarea(ActionMapping mapping, es.pode.modificador.presentacion.pendientes.RecuperarTareaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try
    	{
	    	String idModificacion = form.getIdModificacion();
	    	Long idModificacionLong = Long.valueOf(idModificacion);
	    	ModificacionVO mod = this.getSrvHerramientaModificacion().obtenerModificacion(idModificacionLong);
	    	ConfiguracionTarea confTarea = this.getSrvHerramientaModificacion().obtenerConfiguracionTarea(idModificacionLong);
	    	form.setTarea(confTarea);
	    	logger.debug("Se ha recuperado la tarea: "+idModificacion);
	    	this.getConfigurarModificacionSession(request).setConfiguracion(confTarea);
	    	this.getConfigurarModificacionSession(request).setIdModificacion(idModificacionLong);
	    	this.getConfigurarModificacionSession(request).setNombre(mod.getNombre());
    	}
    	catch (Exception e) {
			logger.error("Error al recuperar la Tarea(" + e.getMessage()+")");
			if(logger.isDebugEnabled()) logger.debug(e);
    	}
     }

    /**
     * @see es.pode.modificador.presentacion.pendientes.ModificacionesPendientesController#selectAction(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.pendientes.SelectActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String selectAction(ActionMapping mapping, es.pode.modificador.presentacion.pendientes.SelectActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String result = null;
		String actionSubmit = form.getAction();
		java.util.Locale locale = (java.util.Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		
		if (form.getAction()== (null))
		{
			throw new ValidatorException("{modificacionesPendientes.exception}");
		}
			
		else if (actionSubmit.equals(i18n.getString("modificacionesPendientes.crearTarea")) )
		{
			result = "Crear";
		} 
		else if (actionSubmit.equals(i18n.getString("modificacionesPendientes.importarTarea")))
		{
			result = "Importar";
		} 
		else if (actionSubmit.equals(i18n.getString("modificacionesPendientes.eliminar")))
		{
//			 Para no perderla en la pantalla de confirmacion, la meto en sesion.
    		request.getSession().setAttribute("identificadores", form.getIdentificadores());
			result = "Eliminar";
		} 
		form.setIdiomaBuscadorBackingList(IdiomasBuscadorSingleton.getInstance().obtenerIdiomas(LdapUserDetailsUtils.getIdioma()), "idLocalizacion", "nombre");
         return result;
    	
    }


    /**
     * @see es.pode.modificador.presentacion.pendientes.ModificacionesPendientesController#submit(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.pendientes.SubmitForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void submit(ActionMapping mapping, es.pode.modificador.presentacion.pendientes.SubmitForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	java.util.Locale locale = (java.util.Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
    	String accion = form.getAction();
    	if (accion.equals(i18n.getString("modificacionesPendientes.eliminar")))
    	{
    		
    		if(form.getIdModificacionRowSelection()==null || form.getIdModificacionRowSelection().size()==0)
    		{
    			throw new ValidatorException("{modificacionesPendientes.elementoSeleccionado.exception}");	
    		}
    		// Transformo a Long[]
    		ArrayList lista = new ArrayList();
    		String[] ids = form.getIdModificacionRowSelectionAsArray();
    		for(int i=0;i<ids.length;i++) {
    			lista.add(Long.valueOf(ids[i]));
    		}
    		form.setIdentificadores(lista);
    	}
    }


	public void ejecutarTarea(ActionMapping mapping, EjecutarTareaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long idModificacion = form.getIdModificacion();
		try
		{
			logger.debug("Se llama al método ejecutarModificacion con id:"+idModificacion);
			this.getSrvHerramientaModificacion().ejecutarModificacion(idModificacion);
		}
		catch (Exception e) 
		{
			logger.error("No se ha podido ejecutar: idmodificacion= "+idModificacion+
							"con excepción+"+e);
		}
	}


	public void iniciarTarea(ActionMapping mapping, IniciarTareaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		this.setConfigurarModificacionSession(request, new ConfigurarModificacionSession(),true);
	}


	public void exportarTarea(ActionMapping mapping, ExportarTareaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		final int BUFFER_SIZE = 2048;
		Long idModificacion = form.getIdModificacion();
		ModificacionVO mod = this.getSrvHerramientaModificacion().obtenerModificacion(idModificacion);
		String nombre = mod.getNombre();
		ConfiguracionTarea tarea=this.getSrvHerramientaModificacion().obtenerConfiguracionTarea(idModificacion);
		DataHandler data;
		try {
			data = this.getSrvHerramientaModificacion().exportarModificacion(
					tarea);
		} catch (Exception e) {
			logger.debug("Error al exportar modificacion: "+e);
			throw new ValidatorException("{exportarModificacion.error}");
		}		

    	response.setContentType("text/xml");
    	response.setHeader("Content-Disposition", "attachment;filename="+ nombre.replace(' ','_').trim() + ".xml");
    	OutputStream out = response.getOutputStream();
    	InputStream in = data.getInputStream();
    	logger.debug("Descargando fichero Configuracion.xml");
		byte[] buffer = new byte[BUFFER_SIZE];
		int count;
		while((count = in.read(buffer, 0, BUFFER_SIZE))!= -1)
		{
			out.write(buffer, 0, count);
		}
		
		out.flush();
	}


	public String submitConfirmacion(ActionMapping mapping, SubmitConfirmacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String result = null;
		MessageResources resources = MessageResources.getMessageResources("application-resources");
		String action = form.getAction();
		if(resources.getMessage((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE),"tareasPendientes.eliminar.confirmacion.aceptar").equals(action)) {
			form.setIdentificadores((List)request.getSession().getAttribute("identificadores"));
			result = "Aceptar";
		} else {
			result = "Cancelar";
		}
		request.getSession().removeAttribute("identificadores");
		return result;
	}


	public boolean esOffline(ActionMapping mapping, EsOfflineForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return DecisorOffline.esOffline();
	}

 
}