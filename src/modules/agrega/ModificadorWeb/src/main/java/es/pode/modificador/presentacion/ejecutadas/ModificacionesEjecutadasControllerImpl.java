/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.modificador.presentacion.ejecutadas;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.modificador.negocio.servicio.EstadosTarea;
import es.pode.modificador.negocio.servicio.ModificacionVO;
import es.pode.modificador.negocio.servicio.ResultadoModificacionVO;
import es.pode.modificador.presentacion.DecisorOffline;
import es.pode.modificador.presentacion.idiomasBuscador.IdiomasBuscadorSingleton;
import es.pode.modificador.presentacion.informes.tarea.ConstantesInforme;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.modificador.presentacion.ejecutadas.ModificacionesEjecutadasController
 */
public class ModificacionesEjecutadasControllerImpl extends ModificacionesEjecutadasController
{

	private final static String MENSAJE_ERROR_DETALLES = "modificacionesPendientes.msgErrorEliminar";
	private final static String MENSAJE_EXITO_DETALLE = "modificacionesPendientes.msgExitoEliminar";

	private static final Logger logger =Logger.getLogger(ModificacionesEjecutadasControllerImpl.class);


    /**
     * @see es.pode.modificador.presentacion.ejecutadas.ModificacionesEjecutadasController#recuperarModificaciones(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.ejecutadas.RecuperarModificacionesForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperarModificaciones(ActionMapping mapping, es.pode.modificador.presentacion.ejecutadas.RecuperarModificacionesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	request.getSession().setAttribute("offline", new Boolean(DecisorOffline.esOffline()));
    	ModificacionVO[] modificacionesEjecutadas = this.getSrvHerramientaModificacion().obtenerModificacionesEjecutadas();
		List modificacionesPendientesList=new ArrayList();
		for(int i=0; i<modificacionesEjecutadas.length;i++)
		{
			modificacionesPendientesList.add(i, modificacionesEjecutadas[i]);
		}
		logger.debug("las modificaciones se han recuperado con éxito");
		form.setModificaciones(modificacionesPendientesList);
		form.setIdiomaBuscadorBackingList(IdiomasBuscadorSingleton.getInstance().obtenerIdiomas(LdapUserDetailsUtils.getIdioma()), "idLocalizacion", "nombre");
		form.setOffline(DecisorOffline.esOffline());
	}

    
    public final void eliminarModificaciones(ActionMapping mapping, es.pode.modificador.presentacion.ejecutadas.EliminarModificacionesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {

		Long[] identificadores=form.getIdModificaciones();
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


	public void recuperarInforme(ActionMapping mapping, RecuperarInformeForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		java.util.Locale locale = (java.util.Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		String idModificacion=form.getIdModificacion();
		Long idModificacionLong=Long.valueOf(idModificacion);
		ModificacionVO modificacionVO = this.getSrvHerramientaModificacion().obtenerModificacion(idModificacionLong);
		String nombreTarea=modificacionVO.getNombre();
		EstadosTarea status = modificacionVO.getResultado();
		String EstadoTarea = status.getValue();
		ResultadoModificacionVO[] resultadosModificacion = this.getSrvHerramientaModificacion().obtenerResultadoModificacion(idModificacionLong);
		List odes= new ArrayList();
		this.getInformeSession(request).setIdModificacion(idModificacionLong);
		
		for(int i=0; i<resultadosModificacion.length;i++)
		{
			//Si Titulo es vacio, le pongo ultimo token path
			ResultadoModificacionVO resultado = resultadosModificacion[i];
			if(resultado.getTitulo()==null||resultado.getTitulo().equals("")) {
				String path = resultado.getPathOriginal();
				if(path.lastIndexOf('/')==path.length()-1) {
					path=path.substring(0,path.lastIndexOf('/'));
				}
				String nombre= path.substring(path.lastIndexOf('/')+1);
				resultado.setTitulo(nombre);
			}
			odes.add(i, resultado);
			
		}
		
		this.getInformeSession(request).setNombreTarea(nombreTarea);
		this.getInformeSession(request).setResultadoTarea(EstadoTarea);
		this.getInformeSession(request).setDescResultado(modificacionVO.getMsgError());
		this.getInformeSession(request).setOdes(odes);
		this.getInformeSession(request).setOrigen(ConstantesInforme.Ejecutadas);
		
	}


	public String submitConfirmacion(ActionMapping mapping, SubmitConfirmacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String result = null;
		java.util.Locale locale = (java.util.Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
    	String accion = form.getAction();
    	if (accion.equals(i18n.getString("tareasEjecutadas.eliminar.confirmacion.aceptar")))
    	{
    		result = "Aceptar";
    	} else {
    		result = "Cancelar";
    	}
    	form.setIdModificaciones((Long[])request.getSession().getAttribute("idModificaciones"));
    	request.getSession().removeAttribute("idModificaciones");
    	
    	return result;
	}


	public void submitEliminar(ActionMapping mapping, SubmitEliminarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] idModificacionRowSelection = form.getIdModificacionRowSelectionAsArray();
		if(idModificacionRowSelection==null || idModificacionRowSelection.length==0) {
			throw new ValidatorException("{tareasEjecutadas.eliminar.error}");
		}
		Long[] idModificaciones = new Long[idModificacionRowSelection.length];
		for(int i=0;i<idModificacionRowSelection.length;i++) {
			idModificaciones[i]=Long.valueOf(idModificacionRowSelection[i]);
		}
		// Lo meto en sesion para no perderlo en la pantalla de confirmacion
		form.setIdModificaciones(idModificaciones);
		request.getSession().setAttribute("idModificaciones", idModificaciones);
	    form.setIdiomaBuscadorBackingList(IdiomasBuscadorSingleton.getInstance().obtenerIdiomas(LdapUserDetailsUtils.getIdioma()), "idLocalizacion", "nombre");

	}

}