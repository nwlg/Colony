/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.visualizador.presentacion.contenidoDinamico;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.agrega.soporte.serverProperties.DependentServerProperties;
import es.pode.contenidos.negocio.generacionDinamica.servicio.ContenidoODEVO;




/**
 * @see es.pode.visualizador.presentacion.contenidoDinamico.ContenidoDinamicoController
 */
public class ContenidoDinamicoControllerImpl extends ContenidoDinamicoController
{


	private static final Logger logger = Logger.getLogger(ContenidoDinamicoControllerImpl.class);

	private static final String PARAMETRO_IDIOMA = "idioma";
	private static final String PARAMETRO_IDENTIFICADORODE = "identificadorODE";
	private static final String URL_PROTADA = "visualizadorcontenidos/Portada/Portada.do";

    /**
     * @see es.pode.visualizador.presentacion.contenidoDinamico.ContenidoDinamicoController#obtenerContenidoDinamico(org.apache.struts.action.ActionMapping, es.pode.visualizador.presentacion.contenidoDinamico.ObtenerContenidoDinamicoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void obtenerContenidoDinamico(ActionMapping mapping, es.pode.visualizador.presentacion.contenidoDinamico.ObtenerContenidoDinamicoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
		 Calendar calendario=Calendar.getInstance();
	 	 GregorianCalendar gregoriano=new GregorianCalendar(calendario.get(Calendar.YEAR),
	 			calendario.get(Calendar.MONTH),
	 			calendario.get(Calendar.DATE));
	   	 ContenidoODEVO odeDiario=new ContenidoODEVO();
	   	 String  url="";
	   	 String urlLocal=DependentServerProperties.getInstance().getUrlNodo();
	   	 try{
	   		 //Obtenemos el ODE diario
	   		 odeDiario = this.getSrvGeneracionDinamicaService().obtenODEDiario(gregoriano);
	   		 
	   		 if(odeDiario !=null){
		   		 String idioma=odeDiario.getIdioma();
		   		 String identificadorODE=odeDiario.getIdODE();
		   		 //Recogemos la URL a la que tenemos que redireccionarlo
		   		 
		   		 String urlRequest=(String)request.getSession().getServletContext().getInitParameter("url_buscadorDetalleCorta");
		   		 
		   		 url=urlLocal+"/"+urlRequest+"/"+idioma+"/"+identificadorODE;	 
	   		 }else{
	   			 url=urlLocal+"/"+(String)request.getSession().getServletContext().getInitParameter("url_portada");
	   			logger.error("El odeDiario era nulo, por lo que cambiamos la url por [ "+ url+" ]");
	   		 }
	   		 
		}catch(Exception e){
			logger.error("No se pudo obtener el contenido dinámico de la fecha [ "+gregoriano.toString()+" ] redireccionado a [ "+ url+" ]",e);
			url=urlLocal+"/"+(String)request.getSession().getServletContext().getInitParameter("url_portada");
			logger.error("Cambiamos la url por [ "+ url+" ]");
			//throw new Exception("No se pudo obtener el contenido dinámico de la fecha [ "+gregoriano.toString()+" ] redireccionado a [ "+ url+" ]",e);
		}
		response.sendRedirect(url);
    }









}