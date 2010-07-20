/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.navegarLom;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

import es.pode.modificador.negocio.servicio.CambioTypes;
import es.pode.modificador.negocio.servicio.TerminoLomVO;
import es.pode.modificador.presentacion.idiomasBuscador.IdiomasBuscadorSingleton;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.modificador.presentacion.configurar.cambios.navegarLom.NavegarLomController
 */
public class NavegarLomControllerImpl extends NavegarLomController
{
	private static final Logger logger = Logger.getLogger(NavegarLomControllerImpl.class);
    /**
     * @see es.pode.modificador.presentacion.configurar.cambios.navegarLom.NavegarLomController#navegarLom(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.configurar.cambios.navegarLom.NavegarLomForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void navegarLom(ActionMapping mapping, es.pode.modificador.presentacion.configurar.cambios.navegarLom.NavegarLomForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String idTermino =form.getIdTermino();
        // Si idTermino es null, se recupera el raiz (lom)
        TerminoLomVO termino = this.getSrvHerramientaModificacion().navegarLom(idTermino);
        form.setTermino(termino);
        form.setIdiomaBuscadorBackingList(IdiomasBuscadorSingleton.getInstance().obtenerIdiomas(LdapUserDetailsUtils.getIdioma()), "idLocalizacion", "nombre");

    }


    /**
     * @see es.pode.modificador.presentacion.configurar.cambios.navegarLom.NavegarLomController#selectTipo(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.configurar.cambios.navegarLom.SelectTipoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String selectTipo(ActionMapping mapping, es.pode.modificador.presentacion.configurar.cambios.navegarLom.SelectTipoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String result = null;
    	MessageResources resources = MessageResources.getMessageResources("application-resources");
    	String action = form.getAction();
    	String tipo = this.getCambioSession(request).getTipo();
    	
    	if(logger.isDebugEnabled()) logger.debug("selectTipo con action = " + action + " : tipo = " + tipo);
    	if(resources.getMessage((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE),"comun.seleccionar").equals(action)) {
    		// Examino los tipos
    		if(CambioTypes._addition.equals(tipo)) {
    			result = "AddOtro";
    		} else if(CambioTypes._modification.equals(tipo)) {
    			result = "Modificar";
    		} else if(CambioTypes._removal.equals(tipo)) {
    			result = "Eliminar";
    		} else if(CambioTypes._check.equals(tipo)) {
    			result = "Comprobar";
    		}
    		else
    		{
    			result="AddOtro";
    		}
    	} else {
    		// Examino los tipos
    		if(CambioTypes._addition.equals(tipo)) {
    			result = "Volver2";
    		} else {
    			result = "Volver1";
    		}
    		
    	}
    	if(logger.isDebugEnabled()) logger.debug("Resultado de selectTipo = " + result);
        return result;
        
    }

    /**
     * @see es.pode.modificador.presentacion.configurar.cambios.navegarLom.NavegarLomController#guardarTermino(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.configurar.cambios.navegarLom.GuardarTerminoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void guardarTermino(ActionMapping mapping, es.pode.modificador.presentacion.configurar.cambios.navegarLom.GuardarTerminoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String actionSubmit = form.getAction();
    	java.util.Locale locale = (java.util.Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		
			
		if (!actionSubmit.equals(i18n.getString("comun.cancelar")) )
		{
	        String idTermino = form.getIdTermino();
	        String terminoLom = form.getTerminoLom();
	
	        if(logger.isDebugEnabled()) logger.debug("guardarTermino() : idTermino = " + idTermino + " : terminoLom = " + terminoLom + " : action = " + form.getAction());
	        
	        if(idTermino == null || terminoLom == null) {
	        	logger.error("Error en guardarTermino");
	        	throw new ValidatorException("{navegarLom.error}");
	        }
	        
	        this.getCambioSession(request).setIdLomTerm(idTermino);
	        this.getCambioSession(request).setLomTerm(terminoLom);
		}
		
    }

}