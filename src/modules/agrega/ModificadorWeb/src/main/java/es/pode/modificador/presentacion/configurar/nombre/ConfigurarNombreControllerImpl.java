/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.modificador.presentacion.configurar.nombre;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

import es.pode.modificador.presentacion.idiomasBuscador.IdiomasBuscadorSingleton;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.modificador.presentacion.configurar.nombre.ConfigurarNombreController
 */
public class ConfigurarNombreControllerImpl extends ConfigurarNombreController
{

	private final static String MENSAJE_ERROR_DETALLES = "configurarNombre.msgError";
	private static final Logger logger = Logger.getLogger(ConfigurarNombreControllerImpl.class);


    /**
     * @see es.pode.modificador.presentacion.configurar.nombre.ConfigurarNombreController#guardarNombre(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.configurar.nombre.GuardarNombreForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void guardarNombre(ActionMapping mapping, es.pode.modificador.presentacion.configurar.nombre.GuardarNombreForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
	    	if(form.getNombre()!=null && !form.getNombre().equals(""))
	    	{
	    		this.getConfigurarModificacionSession(request).setNombre(form.getNombre());
	    	}
	    	else
	    	{
	    		throw new ValidatorException("{configurarNombre.msgError}");
	    	}
     }

    /**
     * @see es.pode.modificador.presentacion.configurar.nombre.ConfigurarNombreController#cerrarSesion(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.configurar.nombre.CerrarSesionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cerrarSesion(ActionMapping mapping, es.pode.modificador.presentacion.configurar.nombre.CerrarSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	this.removeConfigurarModificacionSession(request);
    }

	public String selectAction(ActionMapping mapping, SelectActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String result = null;
		String action = form.getAction();
		MessageResources resources = MessageResources.getMessageResources("application-resources");
		if(logger.isDebugEnabled()) logger.debug("Action del submit = " + action);
		if(resources.getMessage((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE),"nombre.continuar").equals(action)) {
			result ="Continuar";
		} else {
			result = "Cancelar";
		}
		return result;
	}

	public void recuperaNombre(ActionMapping mapping, RecuperaNombreForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(this.getConfigurarModificacionSession(request)!= null && this.getConfigurarModificacionSession(request).getNombre()!=null) {
			form.setNombre(this.getConfigurarModificacionSession(request).getNombre());
		}
		form.setIdiomaBuscadorBackingList(IdiomasBuscadorSingleton.getInstance().obtenerIdiomas(LdapUserDetailsUtils.getIdioma()), "idLocalizacion", "nombre");
	}

}