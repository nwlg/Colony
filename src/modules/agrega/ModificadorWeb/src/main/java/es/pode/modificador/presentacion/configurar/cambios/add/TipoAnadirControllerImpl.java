/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.add;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.struts.action.ActionMapping;

import es.pode.modificador.presentacion.idiomasBuscador.IdiomasBuscadorSingleton;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.modificador.presentacion.configurar.cambios.add.TipoAnadirController
 */
public class TipoAnadirControllerImpl extends TipoAnadirController
{

    public void obtenerTipo(ActionMapping mapping, ObtenerTipoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        this.getCambioSession(request).setValorNuevo(null);
        this.getCambioSession(request).setLomTerm(null);
        this.getCambioSession(request).setIdLomTerm(null);
        
    	if(this.getCambioSession(request).getTipoAniadir()!=null)
    	{
    		form.setTipoAniadir(this.getCambioSession(request).getTipoAniadir());
    	}
    	else
    	{
    		form.setTipoAniadir("otro");
    	}
    	if(this.getCambioSession(request).getAlcance()!=null)
    	{
    		form.setAlcance(this.getCambioSession(request).getAlcance());
    	}
    	else
    	{
    		form.setAlcance(Boolean.TRUE);
    	}
    	 form.setIdiomaBuscadorBackingList(IdiomasBuscadorSingleton.getInstance().obtenerIdiomas(LdapUserDetailsUtils.getIdioma()), "idLocalizacion", "nombre");

	}
    
	/**
     * @see es.pode.modificador.presentacion.configurar.cambios.add.TipoAnadirController#selectAction(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.configurar.cambios.add.SelectActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String selectAction(ActionMapping mapping, es.pode.modificador.presentacion.configurar.cambios.add.SelectActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	
    	String tipoAniadir = form.getTipoAniadir();
    	Boolean alcance=form.getAlcance();
    	String action=form.getAction();
		String result="";
		String CONTINUAR="Continuar";
		String CANCELAR="Cancelar";
		java.util.Locale locale = (java.util.Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);

		if(action.equals(i18n.getString("tipoAnadirAlcance.continuar")))
		{
			if (tipoAniadir==null)
			{
				throw new ValidatorException("{tipoAnadirTipo.exception}");
			}
			else
			{
				this.getCambioSession(request).setTipoAniadir((form.getTipoAniadir()));
			}
			if (alcance==null)
			{
				throw new ValidatorException("{tipoAnadirAlcance.exception}");
			}
			else
			{
				this.getCambioSession(request).setAlcance(form.getAlcance());
			}
			result=CONTINUAR;
		}
		
		else 
		{
			result=CANCELAR;
		}

      return result;
    }







    /**
     * @see es.pode.modificador.presentacion.configurar.cambios.add.TipoAnadirController#selectTipo(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.configurar.cambios.add.SelectTipoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String selectTipo(ActionMapping mapping, es.pode.modificador.presentacion.configurar.cambios.add.SelectTipoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String tipoAniadir = form.getTipoAniadir();
    	
		String result="";
		
		if (tipoAniadir.equals("etb") )
		{			
			result="ETB";
		} 
		else if (tipoAniadir.equals("arbol-curricular")) 
		{
			result = "ArbolCurricular";
		} 
		else if (tipoAniadir.equals("otro")) 
		{
			result = "Otro";
			form.setIdTermino(this.getCambioSession(request).getIdLomTerm());
		} 		
        return result;
    }









}