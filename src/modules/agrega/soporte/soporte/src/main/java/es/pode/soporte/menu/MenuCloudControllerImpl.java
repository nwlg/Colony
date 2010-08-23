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
import org.apache.struts.tiles.Controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.pode.soporte.buscador.servicios.PalabraClaveVO;
import es.pode.soporte.buscador.servicios.ParamPalabrasClave;
import es.pode.soporte.buscador.servicios.PrioridadPalabrasClaveVO;
import es.pode.soporte.buscador.servicios.SrvBuscadorService;
import es.pode.soporte.buscador.servicios.SrvBuscadorServiceServiceLocator;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

public class MenuCloudControllerImpl implements Controller {

	protected static Log logger = LogFactory.getLog(MenuController.class);

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
			// Cargamos la nube de tags
			int tamanioNube = 13;
			ArrayList nubeTags = new ArrayList(13);
			SrvBuscadorServiceServiceLocator serviceLocator = new SrvBuscadorServiceServiceLocator();
			SrvBuscadorService servicio = serviceLocator
					.getSrvBuscadorService();
			ParamPalabrasClave paramPalabrasClave = new ParamPalabrasClave();
			paramPalabrasClave.setIdiomaBusqueda(obtenerIdiomaBusqueda());
			paramPalabrasClave
					.setIdiomaNavegacion(((Locale) request.getSession()
							.getAttribute(ConstantesAgrega.DEFAULT_LOCALE))
							.getLanguage());
			paramPalabrasClave.setNumeroResultados(new Integer(tamanioNube));
			try {
				PrioridadPalabrasClaveVO prioridadPalabrasClaveVO = servicio
						.obtenerPalabrasClave(paramPalabrasClave);
				PalabraClaveVO[] palabraClaveVOs = prioridadPalabrasClaveVO
						.getPalabrasClave();
				PalabraClave[] palabrasClave = new PalabraClave[tamanioNube];
				// Arrays.sort(palabraClaveVOs);

				if(palabraClaveVOs.length >= tamanioNube) {
					for (int i=0; i<tamanioNube; i++){
						palabrasClave[i] = new PalabraClave();
						palabrasClave[i].setPalabraClave(palabraClaveVOs[i].getPalabraClave());
						palabrasClave[i].setRanking(palabraClaveVOs[i].getRanking().toString());
					}

					// Asigno los tamaños
					palabrasClave[0].setTamanio("7");
					palabrasClave[1].setTamanio("6");
					palabrasClave[2].setTamanio("5");
					palabrasClave[3].setTamanio("5");
					palabrasClave[4].setTamanio("5");
					palabrasClave[5].setTamanio("4");
					palabrasClave[6].setTamanio("4");
					palabrasClave[7].setTamanio("4");
					palabrasClave[8].setTamanio("3");
					palabrasClave[9].setTamanio("2");
					palabrasClave[10].setTamanio("2");
					palabrasClave[11].setTamanio("1");
					palabrasClave[12].setTamanio("1");
					// Asigno las posiciones
					nubeTags.add(palabrasClave[1]);
					nubeTags.add(palabrasClave[12]);
					nubeTags.add(palabrasClave[0]);
					nubeTags.add(palabrasClave[4]);
					nubeTags.add(palabrasClave[7]);
					nubeTags.add(palabrasClave[11]);
					nubeTags.add(palabrasClave[3]);
					nubeTags.add(palabrasClave[9]);
					nubeTags.add(palabrasClave[5]);
					nubeTags.add(palabrasClave[6]);
					nubeTags.add(palabrasClave[2]);
					nubeTags.add(palabrasClave[10]);
					nubeTags.add(palabrasClave[8]);
					logger.info("MenuCloudController - SI ha cargado correctamente la nube de tags");
				}
				else {
					logger.info("MenuCloudController - not enough tags available for cloud");
				}
			} catch (Exception e){
				logger.error("MenuCloudController - NO ha cargado correctamente la nube de tags",e);
			} finally{
				context.putAttribute("NUBE_TAGS", nubeTags);
			}
			
		} catch (Exception e) {
			if (logger.isDebugEnabled())
				logger.debug("ERROR: Mensaje =" + e.getMessage() + " Causa = " + e.getCause());
		}
	}


	/* Deprecated interface method */
	public void perform(ComponentContext arg0, HttpServletRequest arg1, HttpServletResponse arg2, ServletContext arg3) throws ServletException, IOException {
		try {
			execute(arg0, arg1, arg2, arg3);
		}
		catch (Exception e)
		{
			logger.error(e);
		}
	}


	private String obtenerIdiomaBusqueda() throws Exception{
		String idiomaNavegacion = "";

		if(LdapUserDetailsUtils.estaAutenticado()){
			try{
				idiomaNavegacion=LdapUserDetailsUtils.getIdiomaBusqueda();
				if (idiomaNavegacion == null) idiomaNavegacion = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
			} catch (Exception e) {
				logger.error("MenuLateralController - obtenerIdiomaBusqueda: Error en al obtener idioma bï¿½squeda usuario LDAP, se recoge idioma de fichero propiedades.",e);

			idiomaNavegacion = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
			}
        	}
		else 
			idiomaNavegacion = I18n.getInstance().obtenerIdiomaDefectoPlataforma();

		return idiomaNavegacion;
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
