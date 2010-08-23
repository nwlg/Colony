/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.guardar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.empaquetador.presentacion.DecisorOffline;
import es.pode.empaquetador.presentacion.GestorSesion;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.empaquetador.presentacion.guardar.GuardarController
 */
public class GuardarControllerImpl extends GuardarController
{
	private static Logger logger = Logger.getLogger(GuardarControllerImpl.class);

	private GestorSesion gestorSesion = new GestorSesion();
	
	/**
	 * @return the gestorSesion
	 */
	public GestorSesion getGestorSesion() {
		return gestorSesion;
	}


	/**
	 * @param gestorSesion the gestorSesion to set
	 */
	public void setGestorSesion(GestorSesion gestorSesion) {
		this.gestorSesion = gestorSesion;
	}



    /**
     * @see es.pode.empaquetador.presentacion.guardar.GuardarController#guardar(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.guardar.GuardarForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void guardar(ActionMapping mapping, es.pode.empaquetador.presentacion.guardar.GuardarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String returnURL = form.getReturnURL();
        String identificador = this.getEmpaquetadorSession(request).getIdLocalizador();
        try {
        	if(logger.isDebugEnabled()) logger.debug("Comprobando pendientes de catalogar antes de guardar...");
        	gestorSesion.comprobarPendientesCatalogacion(request);
        	if(logger.isDebugEnabled()) logger.debug("Guardando ode " + identificador);
        	if(DecisorOffline.esOffline()){
        		this.getSrvGestorManifestService().guardarManifiesto(identificador);
        		this.saveSuccessMessage(request,"portalempaquetado.presentacion.salir.guardar.correcto");	        		
        	}
        	else{
        		String sEspacioLibre = this.getEmpaquetadorSession(request).getEspacioLibre();
        		String sEspacioOdeInicio = this.getEmpaquetadorSession(request).getEspacioOde();
        		if(logger.isDebugEnabled()) logger.debug("Espacio libre: " + sEspacioLibre + "Espacio ODE inicialmente:" + sEspacioOdeInicio);
        		if(org.apache.commons.lang.StringUtils.isNumeric(sEspacioLibre) &&
        				org.apache.commons.lang.StringUtils.isNumeric(sEspacioOdeInicio)){
		        	Long espacioLibre = new Long(sEspacioLibre);
		        	Long espacioOdeInicio = new Long(sEspacioOdeInicio);
		        	Boolean hayEspacio = this.getSrvGestorArchivosService().consultaCuota(identificador, espacioLibre, espacioOdeInicio);
		        	if(hayEspacio.booleanValue()){
		        		this.getSrvGestorManifestService().guardarManifiesto(identificador);	
		        		this.saveSuccessMessage(request,"portalempaquetado.presentacion.salir.guardar.correcto");
		        	}
		        	else 
		        		saveErrorMessage(request, "gestor.avanzado.guardar.noEspacioEnCuota");
	        	}else{
	        		this.getSrvGestorManifestService().guardarManifiesto(identificador);	
	        		this.saveSuccessMessage(request,"portalempaquetado.presentacion.salir.guardar.correcto");
	        	}
        	}
        } catch (Exception e) {
        	logger.error("Se produjo un error al guardar el manifiesto " + identificador,e);
        	saveErrorMessage(request, "gestor.avanzado.guardar");
        }
        if(returnURL==null || returnURL.trim().equals("")) {
        	String redirect = "http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+mapping.findForward("gestor.archivos").getPath();
        	if(logger.isDebugEnabled()) logger.debug("ReturnURL es null en guardar. Redirijo a " +redirect);
        	response.sendRedirect(redirect);
        } else {
			/*
			 * Concateno host y subdominio para URLs tipo http://host/agrega:
			 * returnURL se genera a partir de una html:rewrite, no es necesario
			 * incluir el subdominio, porque de haberlo, ya esta inluido.
			 */
        	returnURL="http://"+LdapUserDetailsUtils.getHost()+returnURL;
        	if(logger.isDebugEnabled()) logger.debug("ReturnURL es " + returnURL);
        	response.sendRedirect(returnURL);
        }
        
        if(!this.getEmpaquetadorSession(request).isGuardadoPrimeraVez()) {
        	this.getEmpaquetadorSession(request).setGuardadoPrimeraVez(true);
        	logger.debug("Cambiado flag guardadoPorPrimeraVez");
        }
     }

}