/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.buscar;


import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.dozer.util.mapping.DozerBeanMapperSingletonWrapper;
import net.sf.dozer.util.mapping.MapperIF;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.tiles.ComponentContext;
import org.apache.struts.tiles.Controller;

import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.i18n.LocalizacionIdiomaVO;
import es.pode.soporte.menu.MenuController;
import es.pode.soporte.nodosSQI.servicio.NodoSQIVO;
import es.pode.soporte.nodosSQI.servicio.SrvGestionSqiService;
import es.pode.soporte.nodosSQI.servicio.SrvGestionSqiServiceServiceLocator;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

public class BuscarController implements Controller {
	
	public static java.util.Properties pSpringProperties = null;

	protected static final String FILE_NAME_PROPERTIES = "/buscador.properties";
	public static final String IDIOMAS_BUSCABLES_PLATAFORMA = BuscarController.getPropertyValue("idiomas.buscables.plataforma");
	public static final String LOCALIZACION_BUSQUEDA = BuscarController.getPropertyValue("localizaciones.busqueda.plataforma");
	public static final String EXISTEN_NODOS_SQI = BuscarController.getPropertyValue("flag.nodos.sqi");
	protected static Log logger = LogFactory.getLog(MenuController.class); 
	private MapperIF beanMapper = DozerBeanMapperSingletonWrapper.getInstance();

	public void perform(ComponentContext arg0, HttpServletRequest arg1, HttpServletResponse arg2, ServletContext arg3) throws ServletException, IOException {
		try {
			execute(arg0, arg1, arg2, arg3);
		} 
		catch (Exception e) 
		{
			logger.error(e);
		}
	}

	public MapperIF getBeanMapper() {
		return beanMapper;
	}

	public void setBeanMapper(MapperIF beanMapper) {
		this.beanMapper = beanMapper;
	}
	
	/**Metodos estáticos**/
	public static String getPropertyValue(String sKey) 
	{
		String sReturn = null;
		try {
			if (pSpringProperties == null)
			{
				InputStream fIsSpringProperties = MenuController.class.getResourceAsStream(FILE_NAME_PROPERTIES);
				pSpringProperties = new java.util.Properties();
				pSpringProperties.load(fIsSpringProperties);
			}
			sReturn = pSpringProperties.getProperty(sKey); 
		} catch (IOException e) {
			logger.error(e);
		}
		
		// devolvemos la propiedad
		return sReturn;
	}


	
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
		try {
			LocalizacionBusquedaItem locBusqueda = new LocalizacionBusquedaItem();
			locBusqueda.setTipoBusqueda("01");
//			En todo caso, pongo la seleccion de la busqueda a local
			context.putAttribute(LOCALIZACION_BUSQUEDA, locBusqueda);
//			Inicializamos la lista de idiomas
			context.putAttribute(IDIOMAS_BUSCABLES_PLATAFORMA, new String[0]);
//			Inicializamos el valor del flag para saber si existen nodos SQI
			context.putAttribute(EXISTEN_NODOS_SQI, new Boolean(false));
			
			SrvGestionSqiServiceServiceLocator serviceLocator = new SrvGestionSqiServiceServiceLocator();						
			SrvGestionSqiService servicio = null;
			try{
				/* Para la invocacion del ws con seguridad*/
				servicio = serviceLocator.getSrvGestionSqiService();
				log("Referencia al servicio web " + servicio);
				log("Recuperamos los nodos SQI");
                                
                NodoSQIVO[]	nodos = servicio.obtenerNodosSQI();
                log("Numero de nodos obtenidos: " + nodos.length);
                if(nodos!=null && nodos.length>0){
                   	context.putAttribute(EXISTEN_NODOS_SQI, new Boolean(true));
                   	log("Valor de existenNodosSQI: " + context.getAttribute(EXISTEN_NODOS_SQI));
                   }
             }catch (Exception e){
               	log("ERROR al llamar al servicio SrvGestionSqiService para obtener los nodos SQI de la tabla");
               	context.putAttribute(EXISTEN_NODOS_SQI, new Boolean(false));
             }			
			
			IdiomaItem[] idiomasLocalizados;
//			Voy a rescatar el idioma de navegacion del usuario para extraer la lista de idiomas buscables traducidas al idioma de navegacion
			String idiomaNavegacion;
			if (LdapUserDetailsUtils.estaAutenticado()) // si el tipo esta autenticado, cojo el idioma de navegacion del tipo
				idiomaNavegacion = LdapUserDetailsUtils.getIdioma();
			else  // si el tipo no esta logado, cojo el idioma de navegacion del navegador y miro si esta en la lista de
				// los idiomas de navegacion que manejo
			{
				idiomaNavegacion = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
//				Si el idioma de navegacion del navegador del tipo no esta entre los idiomas de navegacion que tiene la plataforma
//				escojo el idioma de navegacion por defecto de la plataforma
				if (!I18n.getInstance().idiomaSoportadoPorPlataforma(idiomaNavegacion).booleanValue()) {
					idiomaNavegacion = I18n.getInstance().getInstance().obtenerIdiomaDefectoPlataforma();
				}
			}
			
			if (idiomaNavegacion != null && !idiomaNavegacion.equals(""))
			{
//				Con el idioma de navegacion, me saco la lista de idiomas buscables en la plataforma
				LocalizacionIdiomaVO[] localizaciones = I18n.getInstance().obtenerIdiomasBuscablesLocalizados(idiomaNavegacion);
				if (localizaciones != null && localizaciones.length > 0) {
					idiomasLocalizados = new IdiomaItem[localizaciones.length];
					for (int i = 0; i < localizaciones.length; i++) {
						//Mapeamos los resultados	
						idiomasLocalizados[i] = (IdiomaItem)getBeanMapper().map(localizaciones[i], IdiomaItem.class);
					}
					context.putAttribute(IDIOMAS_BUSCABLES_PLATAFORMA, idiomasLocalizados);
				}
				else
				{
					logger.error("Error obteniendo localizacion de idioma["+idiomaNavegacion+"]de navegacion del usuario["+(LdapUserDetailsUtils.estaAutenticado()?LdapUserDetailsUtils.getUsuario():"Acceso Anonimo")+"]");
				}
			}
			else
			{
				logger.error("Error obteniendo idioma de navegacion del usuario["+(LdapUserDetailsUtils.estaAutenticado()?LdapUserDetailsUtils.getUsuario():"Acceso Anonimo")+"]");
			}
		} catch (Exception e) {
			if (logger.isDebugEnabled())
				logger.debug("Error general intentando obtener idiomas buscables  Mensaje[" + e.getMessage() + "] Causa[" + e.getCause()+ "]");
		}
	}
	
	private static void log (Object obj)
	{
		if (logger.isDebugEnabled())
			logger.debug(obj);
	}
}
