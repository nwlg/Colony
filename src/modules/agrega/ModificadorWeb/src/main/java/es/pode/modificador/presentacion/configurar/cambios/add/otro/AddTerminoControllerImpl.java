/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.add.otro;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.modificador.presentacion.idiomasBuscador.IdiomasBuscadorSingleton;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.modificador.presentacion.configurar.cambios.add.otro.AddTerminoController
 */
public class AddTerminoControllerImpl extends AddTerminoController
{
	
	private static final Logger logger = Logger.getLogger(AddTerminoControllerImpl.class);

    public void recuperarDatos(ActionMapping mapping, RecuperarDatosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
		if(this.getCambioSession(request).getValor()==null) {
			// Recupero la plantilla para insertar un nuevo termino LOM-ES
			String plantilla = this.getSrvHerramientaModificacion().recuperarPlantillaLomes(this.getCambioSession(request).getIdLomTerm());
			if(logger.isDebugEnabled()) logger.debug("Plantilla lomes recuperada:\n" + plantilla);
			form.setValor(plantilla);
		} else {
			form.setValor(this.getCambioSession(request).getValor());
		}
		form.setIdiomaBuscadorBackingList(IdiomasBuscadorSingleton.getInstance().obtenerIdiomas(LdapUserDetailsUtils.getIdioma()), "idLocalizacion", "nombre");

	}

	/**
     * @see es.pode.modificador.presentacion.configurar.cambios.add.otro.AddTerminoController#guardarDatos(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.configurar.cambios.add.otro.GuardarDatosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void guardarDatos(ActionMapping mapping, es.pode.modificador.presentacion.configurar.cambios.add.otro.GuardarDatosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
		if (form.getValor()!=null)
		{
			
			this.getCambioSession(request).setValorNuevo(form.getValor());
			
		} 
    	
     }

	public void borrarSesion(ActionMapping mapping, BorrarSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		this.removeCambioSession(request);
		
	}

	public void recuperarIdTermino(ActionMapping mapping, RecuperarIdTerminoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String IdLomTerm = this.getCambioSession(request).getIdLomTerm();
		form.setIdTermino(IdLomTerm);
		
	}

	public String selectAction(ActionMapping mapping, SelectActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String origen = form.getAction();
		java.util.Locale locale = (java.util.Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		
		if (origen.equals(i18n.getString("otroAddTermino.aceptar")) )
		{
			return "Aceptar";
		}
		else if (origen.equals(i18n.getString("otroAddTermino.cancelar")) )
		{
			return "Cancelar";
		}
		else
		{
			return "Volver";
		}
	}

}