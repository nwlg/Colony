/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.visualizador.presentacion.motorBusqueda;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.visualizador.presentacion.motorBusqueda.MotorBusquedaController
 */
public class MotorBusquedaControllerImpl extends MotorBusquedaController
{

	private static Logger logger = Logger.getLogger(MotorBusquedaControllerImpl.class);
	private static final String COOKIENAME = "motorBusquedaCookie";
	private static final String VALORCOOKIENAME = "MOTORBUSQUEDA";


    /**
     * @see es.pode.visualizador.presentacion.motorBusqueda.MotorBusquedaController#anadirMotorBusqueda(org.apache.struts.action.ActionMapping, es.pode.visualizador.presentacion.motorBusqueda.AnadirMotorBusquedaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void anadirMotorBusqueda(ActionMapping mapping, es.pode.visualizador.presentacion.motorBusqueda.AnadirMotorBusquedaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	 /** ------------------------------------------------------------------------------------------------------------------
         *  ----------------- GUARDAMOS LA COOKIE DE SI SE AÑADIO BUSCADORAGREGA COMO MOTOR DE BUSQUEDA -----------------------
         *  -------------------------------------------------------------------------------------------------------------------
         */
        logger.debug("anadirMotorBusqueda-- Guardamos la cookie que nos indica que el buscadorAgrega se ha añadido como motor de busqueda de nuestro navegador ["+VALORCOOKIENAME+"]");
        this.setCookieIdioma(response);
        
        /** ------------------------------------------------------------------------------------------------------------------
         *  ---------------------------------------- SE REDIRIGE A LA PAGINA DE PORTADA --------------------------------------
         *  ------------------------------------------------------------------------------------------------------------------
         */
        response.sendRedirect("http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+"/"+request.getSession().getServletContext().getInitParameter("url_portada"));
    }

    private void setCookieIdioma(HttpServletResponse response)
    {
    	if (logger.isDebugEnabled()) logger.debug("anadirMotorBusqueda-- Se pone la cookie con nombre: ["+COOKIENAME+"]");
		Cookie cookie = new Cookie(COOKIENAME, VALORCOOKIENAME);
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24*30*600);
		response.addCookie(cookie);

		if (logger.isDebugEnabled()) logger.debug("cambiarIdioma-- Despues de añadir la cookie " + COOKIENAME + ": " + cookie + " con valor: " + VALORCOOKIENAME + " al objeto response");
	}


}