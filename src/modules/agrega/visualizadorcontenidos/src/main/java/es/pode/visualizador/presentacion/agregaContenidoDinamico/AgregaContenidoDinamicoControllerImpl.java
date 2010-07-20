/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.visualizador.presentacion.agregaContenidoDinamico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.agrega.soporte.serverProperties.DependentServerProperties;



/**
 * @see es.pode.visualizador.presentacion.agregaContenidoDinamico.AgregaContenidoDinamicoController
 */
public class AgregaContenidoDinamicoControllerImpl extends AgregaContenidoDinamicoController
{

	private static final Logger logger = Logger.getLogger(AgregaContenidoDinamicoControllerImpl.class);
	




    /**
     * @see es.pode.visualizador.presentacion.agregaContenidoDinamico.AgregaContenidoDinamicoController#crearCodigoContenido(org.apache.struts.action.ActionMapping, es.pode.visualizador.presentacion.agregaContenidoDinamico.CrearCodigoContenidoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void crearCodigoContenido(ActionMapping mapping, es.pode.visualizador.presentacion.agregaContenidoDinamico.CrearCodigoContenidoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {

		String ulrUploads=AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.URL_IMAGEN_DINAMICA_DISCO);
    	String urlFicha=(String) request.getSession().getServletContext().getInitParameter("url_contenido_dinamico");
    	String urlLocal=DependentServerProperties.getInstance().getUrlNodo();
    	String urlImagen=urlLocal+"/"+ulrUploads;
    	String urlTexto=urlLocal+"/"+urlFicha;
//    	rellenamos el codigo que le pasamos a la jsp para que el usuario lo recoja
		
		String codigo ="<a href='"+ urlTexto + "'> <img src='"+urlImagen +"' width='100' height='100'></a>";
		
		form.setCodigo(codigo);
    	
     }









}