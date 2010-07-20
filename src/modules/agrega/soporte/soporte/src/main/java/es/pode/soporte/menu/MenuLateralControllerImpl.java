/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.tiles.ComponentContext;

import es.pode.soporte.buscador.servicios.PalabraClaveVO;
import es.pode.soporte.buscador.servicios.ParamPalabrasClave;
import es.pode.soporte.buscador.servicios.PrioridadPalabrasClaveVO;
import es.pode.soporte.buscador.servicios.SrvBuscadorService;
import es.pode.soporte.buscador.servicios.SrvBuscadorServiceServiceLocator;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

public class MenuLateralControllerImpl extends MenuController {
	private static final String MENU_LATERAL = MenuController.getPropertyValue("menu_lateral",MenuController.FILE_NAME_PROPERTIES);
	private static final String MENU_LATERAL_CONTENIDOS = MenuController.getPropertyValue("menu_lateral_contenidos",MenuController.FILE_NAME_PROPERTIES);
	private static final String MENU_LATERAL_PLATAFORMA = MenuController.getPropertyValue("menu_lateral_plataforma",MenuController.FILE_NAME_PROPERTIES);
	private static final String MENU_LATERAL_CONFIGURACION = MenuController.getPropertyValue("menu_lateral_configuracion",MenuController.FILE_NAME_PROPERTIES);
	private static final String KEY_MENU_LATERAL_CONTENIDOS = "submenu_contenidos";
	private static final String KEY_MENU_LATERAL_PLATAFORMA = "submenu_plataforma";
	private static final String KEY_MENU_LATERAL_CONFIGURACION = "submenu_configuracion";

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
		
		ArrayList arrayMenu = new ArrayList(3);
		try {
			if (MenuController.logger.isDebugEnabled())
				MenuController.logger.debug( "Estoy en execute" );
			String sUrl = request.getRequestURI();
			String queryString = request.getQueryString();
			//TODO: revisar cuando tenamos los idiomas
			Iterator it = MenuController.menuHandler.hashMenu.keySet().iterator();
			boolean encontrado = false;
			Menu menu = null;
			while (!encontrado && it.hasNext())
			{
				menu = MenuController.getMenu(String.valueOf(it.next()));
				if (menu != null)
					encontrado = MenuController.checkUrlPattern(sUrl, queryString, menu.getPattern());
			}
			//TODO: Se chequeará el usuario para ver los permisos
			if (encontrado)
				arrayMenu = this.menuFilter(menu.getName(), this.getRoles(), sUrl, servletContext,request);

		} catch (Exception e) {
			if (MenuController.logger.isDebugEnabled())
				MenuController.logger.debug("ERROR: Mensaje =" + e.getMessage() + " Causa = " + e.getCause());
		}finally	{
			context.putAttribute(MENU_LATERAL, arrayMenu);
			ArrayList menuContenidos=generarMenus(KEY_MENU_LATERAL_CONTENIDOS, arrayMenu);		
			context.putAttribute(MENU_LATERAL_CONTENIDOS, menuContenidos);
			ArrayList menuPlataforma=generarMenus(KEY_MENU_LATERAL_PLATAFORMA, arrayMenu);
			context.putAttribute(MENU_LATERAL_PLATAFORMA, menuPlataforma);
			ArrayList menuConfiguracion=generarMenus(KEY_MENU_LATERAL_CONFIGURACION, arrayMenu);
			context.putAttribute(MENU_LATERAL_CONFIGURACION, menuConfiguracion);
		}
	}
	
	private String obtenerIdiomaBusqueda() throws Exception{

        String idiomaNavegacion = "";
        if(LdapUserDetailsUtils.estaAutenticado()){
            try{
                 idiomaNavegacion=LdapUserDetailsUtils.getIdiomaBusqueda();
                 if (idiomaNavegacion == null) idiomaNavegacion = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
            } catch (Exception e) {
                 logger.error("MenuLateralController - obtenerIdiomaBusqueda: Error en al obtener idioma búsqueda usuario LDAP, se recoge idioma de fichero propiedades.",e);
                 idiomaNavegacion = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
            }
        }else idiomaNavegacion = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
            return idiomaNavegacion;
	}
	
	
	private ArrayList generarMenus(String nomMenu, ArrayList arrayMenu){
		ArrayList menuCon=new ArrayList();
		String[] arraySubmenus;
		ArrayList listaSubmenus;
		arraySubmenus = (MenuController.getPropertyValue(nomMenu,MenuController.FILE_NAME_PROPERTIES)).split(",");
		listaSubmenus = new ArrayList(Arrays.asList(arraySubmenus));
		for(int i=0;i< arrayMenu.size();i++){
				MenuItem menu=(MenuItem)(arrayMenu.get(i));
				String id=menu.getId();
				if(listaSubmenus.contains(id)){
					menuCon.add(menu);
				}			
		}
		
		return menuCon;
	}
	
	public class PalabraClave {
		String palabraClave;
		String ranking;
		String tamanio;
		
		public String getPalabraClave() {
			return palabraClave;
		}
		public void setPalabraClave(String palabraClave) {
			this.palabraClave = palabraClave;
		}
		public String getRanking() {
			return ranking;
		}
		public void setRanking(String ranking) {
			this.ranking = ranking;
		}
		public String getTamanio() {
			return tamanio;
		}
		public void setTamanio(String tamanio) {
			this.tamanio = tamanio;
		}
		
	}	
}
