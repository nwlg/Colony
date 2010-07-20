/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.modificar;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.struts.action.ActionMapping;

import es.pode.modificador.negocio.servicio.FormularioModificarVO;
import es.pode.modificador.presentacion.idiomasBuscador.IdiomasBuscadorSingleton;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.modificador.presentacion.configurar.cambios.modificar.ModificarTerminoController
 */
public class ModificarTerminoControllerImpl extends ModificarTerminoController
{






    /**
     * @see es.pode.modificador.presentacion.configurar.cambios.modificar.ModificarTerminoController#selectAction(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.configurar.cambios.modificar.SelectActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String selectAction(ActionMapping mapping, es.pode.modificador.presentacion.configurar.cambios.modificar.SelectActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String origen = form.getAction();
    	
		String result="";
		java.util.Locale locale = (java.util.Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		// Introduzco en el objeto de sesion la opcion elegida
		
		
		if (origen.equals(i18n.getString("modificarTermino.aceptar")) )
		{
			
			result="Aceptar";
			
		} 
		else if (origen.equals(i18n.getString("modificarTermino.volver"))) 
		{
			result = "Volver";
		} 
		else if (origen.equals(i18n.getString("modificarTermino.cancelar"))) 
		{
			result = "Cancelar";
		} 
		

         return result;
    }


    /**
     * @see es.pode.modificador.presentacion.configurar.cambios.modificar.ModificarTerminoController#modificar(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.configurar.cambios.modificar.ModificarForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void modificar(ActionMapping mapping, es.pode.modificador.presentacion.configurar.cambios.modificar.ModificarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
     if(form.getIdioma()!=null)
     {
    	if(form.getIdioma().equals(""))
    	{
    		this.getCambioSession(request).setIdioma(null);
    	}
    	else
    	{
    		this.getCambioSession(request).setIdioma(form.getIdioma());
    	}
     }
     if(form.getValorViejo()!=null)
     {
    	if(form.getValorViejo().equals(""))
    	{
    		this.getCambioSession(request).setValor(null);
    	}
    	else
    	{
    		this.getCambioSession(request).setValor(form.getValorViejo());
    	}
     }
     if(form.getValorNuevo()!=null)
     {
    
    	if(form.getValorNuevo().equals(""))
    	{
    		throw new ValidatorException("{modificarTermino.msgErrorValorNuevo}");
    	}
    	else
    	{
    		this.getCambioSession(request).setValorNuevo(form.getValorNuevo());
    	}
     }
    	this.getCambioSession(request).setAlcance(Boolean.valueOf(form.getAlcanceMetadatos()));
    	this.getCambioSession(request).setReplaceAll(Boolean.valueOf(form.getAlcanceTermino()));
    	this.getCambioSession(request).setExprReg(Boolean.valueOf(form.getExprReg()));
    	
     }







	public void obtenerValores(ActionMapping mapping, ObtenerValoresForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		FormularioModificarVO formulario = this.getSrvHerramientaModificacion().obtenerFormularioModificar(this.getCambioSession(request).getIdLomTerm());
		if(formulario.getEsCombo().booleanValue())
		{
			form.setValorNuevoLabelList(formulario.getOpcionesCombo());
			form.setValorNuevoValueList(formulario.getOpcionesCombo());		
			
		}	
		
			form.setValorNuevo(this.getCambioSession(request).getValorNuevo());
		
		
		if(formulario.getLangString().booleanValue())
		{
			form.setIdioma(this.getCambioSession(request).getIdioma());
		}
		else
		{
			form.setIdioma(null);
		}
		
		form.setValorViejo(this.getCambioSession(request).getValor());
		
		if(this.getCambioSession(request).getAlcance()==null)
		{
			form.setAlcanceMetadatos("true");
		}
		else
		{
			form.setAlcanceMetadatos(String.valueOf(this.getCambioSession(request).getAlcance()));
		}
		
		if(this.getCambioSession(request).getReplaceAll()==null)
		{
			form.setAlcanceTermino("true");
		}
		else
		{
			form.setAlcanceTermino(String.valueOf(this.getCambioSession(request).getReplaceAll()));
		}
		
		if(this.getCambioSession(request).getExprReg()==null)
		{
			form.setExprReg("false");
		}
		else
		{
			form.setExprReg(String.valueOf(this.getCambioSession(request).getExprReg()));
		}
		
		form.setFormulario(formulario);
		form.setIdiomaBuscadorBackingList(IdiomasBuscadorSingleton.getInstance().obtenerIdiomas(LdapUserDetailsUtils.getIdioma()), "idLocalizacion", "nombre");

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









}