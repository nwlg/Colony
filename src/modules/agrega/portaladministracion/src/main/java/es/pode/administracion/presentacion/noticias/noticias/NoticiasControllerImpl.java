/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.noticias.noticias;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.contenidos.negocio.noticias.servicio.NoticiaTraducidaVO;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.administracion.presentacion.noticias.noticias.NoticiasController
 */
public class NoticiasControllerImpl extends NoticiasController {	

	private static Logger logger = Logger.getLogger(NoticiasControllerImpl.class);	
	
	private final static String VERNOTICIAVO = "verNoticiavo";
	private final static String CATEGORIAMODVO = "categoriamodvo";	
	private final static String CATEGORIAVO = "categoriavo";	
	private final static String IMAGEN = "imagen";		
	
	/**
	 * @see es.pode.administracion.presentacion.noticias.noticias.NoticiasController#obtenerNoticias(org.apache.struts.action.ActionMapping,
	 *      es.pode.administracion.presentacion.noticias.noticias.ObtenerNoticiasForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void obtenerNoticias(
			ActionMapping mapping,
			es.pode.administracion.presentacion.noticias.noticias.ObtenerNoticiasForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try
		{
			//Se borra de la request los valores si estuvieran llenos
			request.getSession().setAttribute(VERNOTICIAVO, null);
			request.getSession().setAttribute(CATEGORIAMODVO, null);
			request.getSession().setAttribute(CATEGORIAVO, null);
			request.getSession().setAttribute(IMAGEN, null);
			
			/**
    		 * **************************************************************************************************************************************
    		 * ****************************************** SE OBTIENEN LOS IDIOMAS TRADUCIBLES *******************************************************
    		 * **************************************************************************************************************************************
    		 * */
			if (logger.isDebugEnabled()) logger.debug("Obtenemos los idiomas traducibles");
			
			String[] idiomasPlataforma = I18n.getInstance().obtenerIdiomasPlataforma();
			if (logger.isDebugEnabled()) logger.debug("Hay ["+idiomasPlataforma.length+"] en la plataforma");		
			
			String idiomaLogado = LdapUserDetailsUtils.getIdioma();
			String idiomaPrioritario = I18n.getInstance().obtenerIdiomaDefectoPlataforma();		
			String idiomaSecundario = I18n.getInstance().obtenerIdiomaSecundarioPlataforma();
			if (logger.isDebugEnabled()) logger.debug("El idioma del usuario es ["+idiomaLogado+"], idioma prioritario de la plataforma es ["+idiomaPrioritario+"] y el secundario es ["+idiomaSecundario+"]");			
			
			/**
			 * **************************************************************************************************************************************
			 * ********************************************* SE RECUPERAN LAS NOTICIAS **************************************************************
			 * **************************************************************************************************************************************
			 * */
			NoticiaTraducidaVO[] noticias = this.getSrvNoticiasService().obtenerNoticiasTraducidas(devuelveIdiomasTraducibles(idiomasPlataforma, idiomaLogado, idiomaPrioritario, idiomaSecundario));
			if (logger.isDebugEnabled()) logger.debug("Se han recuperado ["+noticias.length+"]");
					
			for(int h=0;h<noticias.length;h++)
			{
				//sustituimos @,",:,%,+,-,' por su codigo correspondiente en ASCII
				noticias[h].setTitulo(noticias[h].getTitulo().replaceAll("@","&#64"));
				noticias[h].setTitulo(noticias[h].getTitulo().replaceAll("\\\"","&#34"));
				noticias[h].setTitulo(noticias[h].getTitulo().replaceAll(":","&#58"));
				noticias[h].setTitulo(noticias[h].getTitulo().replaceAll("%","&#37"));
				noticias[h].setTitulo(noticias[h].getTitulo().replaceAll("\\+","&#43"));
				noticias[h].setTitulo(noticias[h].getTitulo().replaceAll("-","&#45"));
				noticias[h].setTitulo(noticias[h].getTitulo().replaceAll("'","&#39"));
			}	
			/**
			 * **************************************************************************************************************************************
			 * ************************************* SE INTRODUCEN LOS DATOS EN EL FORMULARIO *******************************************************
			 * **************************************************************************************************************************************
			 * */
			form.setNoticiasAsArray(noticias);	
			
			
		} catch (Exception e)
		{
			logger.error("Error recuperando las noticias",e);
			throw new ValidatorException("{error.noticias.recuperando}");			
		}
	}
	
	public void getIds(ActionMapping mapping, GetIdsForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{		
		
			/**
			 * **************************************************************************************************************************************
			 * **************************** SE RECUPERAN LOS IDENTIFICADORES DE LA NOTICIA A ELIMINAR *********************************************
			 * **************************************************************************************************************************************
			 * */
			List lista = ((NoticiasEliminarFormImpl) form).getIdNoticiaRowSelection();			
			if (lista == null)
			{
				logger.error("Debe seleccionar al menos una noticia a eliminar");
				throw new ValidatorException("{errors.borrarNoticia.idNulo}");
			}
			else
			{
				form.setIds(lista);
			}
		
	}
	
	/**
	 * Metodo que devuelve un array de idiomas. Las posiciones del array corresponden con el orden de prioridad de los idiomas
	 * Si el array devuelto contiene; es, en , ca, gl ,eu y va. Se buscara la noticia primero en castellano, si no la encuentra en ingles y asi sucesivamente.*/
	public String[] devuelveIdiomasTraducibles(String[] idiomas, String idiomaLogado, String idiomaPrioritario, String idiomaSecundario) throws Exception
	{	
		ArrayList idiomasList = new ArrayList();
		if (idiomaLogado.equals(idiomaPrioritario))
		{
			//El idioma del usuario y el prioritario son iguales
			idiomasList.add(idiomaLogado);
			if (!idiomaPrioritario.equals(idiomaSecundario))			
				idiomasList.add(idiomaSecundario);
			
		}
		else
		{
//			el idioma del del usuario y el prioritario no son iguales
			idiomasList.add(idiomaLogado);
			idiomasList.add(idiomaPrioritario);
			if ((!idiomaLogado.equals(idiomaSecundario) && !idiomaPrioritario.equals(idiomaSecundario)) || (!idiomaPrioritario.equals(idiomaSecundario) && !idiomaSecundario.equals(idiomaLogado)))
				idiomasList.add(idiomaSecundario);			
		}			
		
		String[] idiomasArray = devuelveArraySinIdiomasPrioritarios(idiomas, idiomasList);
		for (int i = 0;idiomasArray != null && i < idiomasArray.length; i++) 
			idiomasList.add(idiomasArray[i]);	
		
		return (String[])idiomasList.toArray(new String[0]);		
		
	}
	
	public String[] devuelveArraySinIdiomasPrioritarios (String[] idiomas, ArrayList listaIdiomas) throws Exception
	{
		ArrayList listaAux = new ArrayList();
		listaAux = devuelveArraySinString(idiomas, (String)listaIdiomas.get(0));
		for (int i = 1; i < listaIdiomas.size(); i++)
		{
			listaAux = devuelveArraySinString((String[])listaAux.toArray(new String[0]), (String)listaIdiomas.get(i));
		}
		return (String[])listaAux.toArray(new String[0]);
		
	}	
	
	public ArrayList devuelveArraySinString (String[] idiomas, String stringBorrar) throws Exception
	{
		ArrayList idiomasReturn = new ArrayList();		
		for (int i = 0; idiomas != null && i < idiomas.length; i++)
		{
			if (!(idiomas[i].equals(stringBorrar)))			
				idiomasReturn.add(idiomas[i]);				
					
		}
		return idiomasReturn;
	}
	
}