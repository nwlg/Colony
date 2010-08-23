/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.inicioCatalogador;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.catalogadorWeb.presentacion.CatalogadorAvSession;
import es.pode.catalogadorWeb.presentacion.CatalogadorBPSession;
import es.pode.catalogadorWeb.presentacion.CatalogadorBSession;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.catalogadorWeb.presentacion.inicioCatalogador.inicioController
 */
public class InicioControllerImpl extends InicioController
{

	private static Logger logger = Logger.getLogger(InicioControllerImpl.class);

    /**
	 * @see es.pode.catalogadorWeb.presentacion.inicioCatalogador.inicioController#cargarTipoCatalogador(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.inicioCatalogador.CargarTipoCatalogadorForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public final java.lang.String cargarTipoCatalogador(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.inicioCatalogador.CargarTipoCatalogadorForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String tipoCatalogador=null;
		
		try{
			String ct = LdapUserDetailsUtils.getCatalogador();

			if ("avanzado".equals(ct))
				tipoCatalogador="Avanzado";
			else if ("basico".equals(ct))
				tipoCatalogador="Basico";
			else if ("basicplus".equals(ct))
				tipoCatalogador="BasicPlus";

			if (tipoCatalogador == null) {
				tipoCatalogador="Avanzado";
				saveErrorMessage(request, "Error. Por defecto vamos a catalogador Avanzado");
			} else {
				if (logger.isDebugEnabled())
					logger.debug("Estamos en Catalogador " + tipoCatalogador);
			}
		}catch (org.acegisecurity.AccessDeniedException ad) {
			throw new java.lang.Exception("inicio.catalogador", ad);
			
		}catch (Exception e){
			tipoCatalogador="Avanzado";
			logger.error("Error al leer la sesión de usuario. Trabaja en Avanzado");
			throw new java.lang.Exception("inicio.catalogador", e);
    		
    	}
    	//this.getEmpaquetadorSession(request).setTipoEmpaquetador(tipoSesion);
    	return tipoCatalogador;
    }







    /**
     * @see es.pode.catalogadorWeb.presentacion.inicioCatalogador.inicioController#crearSesion(org.apache.struts.action.ActionMapping, es.pode.catalogadorWeb.presentacion.inicioCatalogador.CrearSesionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void crearSesion(ActionMapping mapping, es.pode.catalogadorWeb.presentacion.inicioCatalogador.CrearSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String tipoCatalogador=null;
    	
    	try{
    		if ("basico".equals(LdapUserDetailsUtils.getCatalogador())){
    			tipoCatalogador="Basico";
    			if (logger.isDebugEnabled()) 
    				logger.debug("Estamos en Catalogador " + tipoCatalogador);
//    			borramos los datos de la sesion al iniciar el catalogador básico
    			request.getSession().removeAttribute(es.pode.catalogadorWeb.presentacion.CatalogadorBSession.SESSION_KEY);
//    			Iniciamos Una nueva sesion
    			CatalogadorBSession catBasicoSession = this.getCatalogadorBSession(request);	
    			String identificador = request.getParameter("identificador");
    			String returnURL=request.getParameter("returnURL");
    			String idioma=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
    			
    			String usuario = LdapUserDetailsUtils.getUsuario();
    				//los metemos en sesion
    			catBasicoSession.setIdentificador(identificador);
    			catBasicoSession.setIdioma(idioma);
    			catBasicoSession.setUsuario(usuario);
    			catBasicoSession.setReturnURL(returnURL);
//    			catBasicoSession.setArbolesController(arbolesController);
//    			catBasicoSession.setMBOSesion(MBOSesion);	
    				
    			
    		} else if ("basicplus".equals(LdapUserDetailsUtils.getCatalogador())){
    			
    			tipoCatalogador="BasicPlus";
    			if (logger.isDebugEnabled()) 
    				logger.debug("Estamos en Catalogador " + tipoCatalogador);
//    			borramos los datos de la sesion al iniciar el catalogador básico
    			request.getSession().removeAttribute(es.pode.catalogadorWeb.presentacion.CatalogadorBPSession.SESSION_KEY);
//    			Iniciamos Una nueva sesion
    			CatalogadorBPSession catBasicPlusSession = this.getCatalogadorBPSession(request);	
    			String identificador = request.getParameter("identificador");
    			String returnURL=request.getParameter("returnURL");
    			String idioma=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
    			
    			String usuario = LdapUserDetailsUtils.getUsuario();
    				//los metemos en sesion
    			catBasicPlusSession.setIdentificador(identificador);
    			catBasicPlusSession.setIdioma(idioma);
    			catBasicPlusSession.setUsuario(usuario);
    			catBasicPlusSession.setReturnURL(returnURL);
    		
    		}else {//Por defecto inicializamos el catalogador avanzado
    			tipoCatalogador="Avanzado";
    			if (logger.isDebugEnabled()) 
    				logger.debug("Estamos en Catalogador " + tipoCatalogador);
        		
//    			borramos los datos de la sesion al iniciar el catalogador avanzado
    			request.getSession().removeAttribute(es.pode.catalogadorWeb.presentacion.CatalogadorAvSession.SESSION_KEY);
//    			Iniciamos Una nueva sesion
    			CatalogadorAvSession catAvanzadoSession = this.getCatalogadorAvSession(request);	
    			String identificador = request.getParameter("identificador");
    			String returnURL=request.getParameter("returnURL");
    			
    			String idioma=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
    			
    			String usuario = LdapUserDetailsUtils.getUsuario();
    				//los metemos en sesion
    			catAvanzadoSession.setIdentificador(identificador);
    			catAvanzadoSession.setIdioma(idioma);
    			catAvanzadoSession.setUsuario(usuario);
    			catAvanzadoSession.setReturnURL(returnURL);
//    			catAvanzadoSession.setArbolesController(arbolesController);
//    			catAvanzadoSession.setMDSesion(MDSesion);
    			
    		}
    			    		
    	}catch (org.acegisecurity.AccessDeniedException ad) {
    		throw new java.lang.Exception("inicio.catalogador", ad);
			
		}catch (Exception e){
    		tipoCatalogador="Avanzado";
    		logger.error("Error al leer la sesión de usuario. Trabaja en Avanzado");
    		throw new java.lang.Exception("inicio.catalogador", e);
    	}
    }









}