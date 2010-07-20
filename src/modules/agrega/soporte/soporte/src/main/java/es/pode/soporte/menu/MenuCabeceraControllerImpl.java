/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.menu;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.tiles.ComponentContext;

public class MenuCabeceraControllerImpl extends MenuController {
	
	public static final String MENU_CABECERA = MenuController.getPropertyValue("key_cabecera",MenuController.FILE_NAME_PROPERTIES);
	public static final String MENU_CABECERA_KEY = MenuController.getPropertyValue("menu_cabecera",MenuController.FILE_NAME_PROPERTIES);

	/**
	* Process http request (controller)
	* @param context The current Tile context, containing Tile attributes
	* @param mapping The ActionMapping used to select this instance
	* @param form The optional ActionForm bean for this request (if any)
	* @param request The HTTP request we are processing
	* @param response The HTTP response we are creating
	*
	* @exception IOException if an input/output error occurs
	* @exception ServletException if a servlet exception occurs
	*/
	public void execute(ComponentContext context, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws Exception 
	{
		
		//TODO: Se chequeará el usuario para ver los permisos

		if (logger.isDebugEnabled())
			logger.debug( "Estoy en execute" );
		ArrayList arrayMenu = new ArrayList(3);   
		try {
			arrayMenu = this.menuFilter(MENU_CABECERA, this.getRoles(), request.getRequestURI(),request.getQueryString(), servletContext, request);
		} catch (Exception e) {
			if (logger.isDebugEnabled())
				logger.debug("ERROR: Mensaje " + e.getMessage() + " Causa = " + e.getCause());
			logger.error(e);
		}finally {
			context.putAttribute(MENU_CABECERA_KEY, arrayMenu);
		}
	}
}
