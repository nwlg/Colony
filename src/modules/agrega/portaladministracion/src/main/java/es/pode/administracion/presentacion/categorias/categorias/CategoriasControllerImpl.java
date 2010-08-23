/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.categorias.categorias;

import java.util.List;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.administracion.presentacion.noticias.noticias.NoticiasControllerImpl;
import es.pode.contenidos.negocio.noticias.servicio.CategoriaNoticiaTraducidaVO;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CategoriasControllerImpl extends CategoriasController
{


	private static Logger logger = Logger.getLogger(CategoriasControllerImpl.class);	

	private final static String CATEGORIAVO = "categoriavo";
	private final static String CATEGORIASNOTICIAS = "categorias";	
	private final static String NOTICIASCATEGORIAS = "noticiasCategorias";
	
    /**
     * @see es.pode.administracion.presentacion.categorias.categorias.CategoriasController#obtenerCategoriasNoticias(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.categorias.categorias.ObtenerCategoriasNoticiasForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void obtenerCategoriasNoticias(ActionMapping mapping, es.pode.administracion.presentacion.categorias.categorias.ObtenerCategoriasNoticiasForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try
    	{
    		//Se elimina de la request los valores
    		request.getSession().setAttribute(CATEGORIAVO, null);
    		request.getSession().setAttribute(CATEGORIASNOTICIAS, null);
			request.getSession().setAttribute(NOTICIASCATEGORIAS, null);
    		
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
			 * ******************************************* SE RECUPERAN LAS CATEGORIAS **************************************************************
			 * **************************************************************************************************************************************
			 * */
			NoticiasControllerImpl noticiasController = new NoticiasControllerImpl();		
			CategoriaNoticiaTraducidaVO[] categorias = this.getSrvNoticiasService().obtenerCategoriasTraducidas(noticiasController.devuelveIdiomasTraducibles(idiomasPlataforma, idiomaLogado, idiomaPrioritario, idiomaSecundario));
			if (logger.isDebugEnabled()) logger.debug("Se han recuperado ["+categorias.length+"] categorias noticias");
			
			for (int i = 0; i < categorias.length; i++)
			{
	//			sustituimos @,",:,%,+,-,' por su codigo correspondiente en ASCII			
				categorias[i].setNombreCategoria(categorias[i].getNombreCategoria().replaceAll("@","&#64"));
				categorias[i].setNombreCategoria(categorias[i].getNombreCategoria().replaceAll("\\\"","&#34"));
				categorias[i].setNombreCategoria(categorias[i].getNombreCategoria().replaceAll(":","&#58"));
				categorias[i].setNombreCategoria(categorias[i].getNombreCategoria().replaceAll("%","&#37"));
				categorias[i].setNombreCategoria(categorias[i].getNombreCategoria().replaceAll("\\+","&#43"));
				categorias[i].setNombreCategoria(categorias[i].getNombreCategoria().replaceAll("-","&#45"));
				categorias[i].setNombreCategoria(categorias[i].getNombreCategoria().replaceAll("'","&#39"));
			}   
			
			/**
			 * **************************************************************************************************************************************
			 * ************************************* SE INTRODUCEN LOS DATOS EN EL FORMULARIO *******************************************************
			 * **************************************************************************************************************************************
			 * */
	    	form.setCategoriasNoticiasAsArray(categorias);
	    	
    	} catch (Exception e)
    	{
    		logger.error("Error recuperando las categorias de las noticias", e);
    		throw new ValidatorException("{errors.categorias.borrar.cargar}");    		
    	}

    }

	public void getIds(ActionMapping mapping, GetIdsForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		/**
		 * **************************************************************************************************************************************
		 * **************************** SE RECUPERAN LOS IDENTIFICADORES DE LA CATEGORIA A ELIMINAR *********************************************
		 * **************************************************************************************************************************************
		 * */
		List lista = ((CategoriasNoticiasEliminarFormImpl) form).getIdCategoriaNoticiaRowSelection();		
		if (lista == null)
		{
			logger.error("Debe seleccionar al menos una categoria a eliminar");
			throw new ValidatorException("{errors.borrarCategoria.idNulo}");
		}
		else
		{
			form.setIds(lista);
		}
		
	}

}