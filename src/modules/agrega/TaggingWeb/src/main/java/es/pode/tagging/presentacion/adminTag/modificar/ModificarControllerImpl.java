/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.tagging.presentacion.adminTag.modificar;

import java.util.Locale;

import org.apache.commons.validator.ValidatorException;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

import es.pode.soporte.constantes.ConstantesAgrega;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.tagging.presentacion.adminTag.modificar.ModificarController
 */
public class ModificarControllerImpl extends ModificarController
{






    /**
     * @see es.pode.tagging.presentacion.adminTag.modificar.ModificarController#modificar(org.apache.struts.action.ActionMapping, es.pode.tagging.presentacion.adminTag.modificar.ModificarForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void modificar(ActionMapping mapping, es.pode.tagging.presentacion.adminTag.modificar.ModificarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String newTag = form.getNewTag();
        String oldTag = form.getTagOld();
        
        //El nuevo valor del tag no puede ser vacio
        if (newTag !=null && !newTag.trim().equals("")){
        	this.getSrvTaggingServer().modificarTag(oldTag, newTag);
        }
        else
			throw new ValidatorException("{tagging.modificarTag.exception}");
     }







    /**
     * @see es.pode.tagging.presentacion.adminTag.modificar.ModificarController#selectAction(org.apache.struts.action.ActionMapping, es.pode.tagging.presentacion.adminTag.modificar.SelectActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String selectAction(ActionMapping mapping, es.pode.tagging.presentacion.adminTag.modificar.SelectActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
		String result = null;
		MessageResources resources = MessageResources.getMessageResources("application-resources");
		String action = form.getAccion();
		if(resources.getMessage((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE),"comun.aceptar").equals(action)) {
			result = "Aceptar";
		} else {
			result = "Cancelar";
		}

		return result;
    }









}