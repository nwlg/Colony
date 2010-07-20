/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.noticias.verNoticia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.administracion.presentacion.noticias.noticias.NoticiasControllerImpl;
import es.pode.contenidos.negocio.noticias.servicio.CategoriaIdiomaNoticiaVO;
import es.pode.contenidos.negocio.noticias.servicio.CategoriaNoticiaVO;
import es.pode.contenidos.negocio.noticias.servicio.DescripcionNoticiaVO;
import es.pode.contenidos.negocio.noticias.servicio.NoticiaVO;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.administracion.presentacion.noticias.verNoticia.VerNoticiaController
 */
public class VerNoticiaControllerImpl extends VerNoticiaController
{


	private static Logger logger = Logger.getLogger(VerNoticiaControllerImpl.class);

	private final static String VERNOTICIAVO = "verNoticiavo";			
	

    /**
     * @see es.pode.administracion.presentacion.noticias.verNoticia.VerNoticiaController#obtenerNoticias(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.noticias.verNoticia.ObtenerNoticiasForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void obtenerNoticias(ActionMapping mapping, es.pode.administracion.presentacion.noticias.verNoticia.ObtenerNoticiasForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try
    	{
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
		
			// Rellena el combo de categorias
			NoticiasControllerImpl noticiasController = new NoticiasControllerImpl();	
			Collection categorias = Arrays.asList(this.getSrvNoticiasService().obtenerCategoriasTraducidas(noticiasController.
					devuelveIdiomasTraducibles(idiomasPlataforma, idiomaLogado, idiomaPrioritario, idiomaSecundario)));
			form.setCategoriaBackingList(categorias, "idCategoriaNoticia", "nombreCategoria");	
	    	
	//      Se obtiene los datos de la noticia
	    	if (logger.isDebugEnabled()) logger.debug("Se obtiene los datos de la noticia con identificador ["+form.getIdNoticia()+"]");
	    	NoticiaVO noticia = this.getSrvNoticiasService().obtenerNoticia(form.getIdNoticia());
	    	request.getSession().setAttribute(VERNOTICIAVO, noticia);  	    	
	    	form.setEstado(noticia.getActiva());
	    	form.setAlineamiento(noticia.getAlineamientoImg());
	    	form.setCategoria(noticia.getCategoria().getId());	
	    	if (form.getActivarImagen() == null)
	    	{
	    		//No viene con valor
//	    		Tratamiento de la imagen	
	    		String sURLImagen = noticia.getURLImagen();	
	    		if (sURLImagen != null && sURLImagen.indexOf("/") != -1)
				{
					form.setActivarImagen(new Integer(1));							
					String sToken[] = sURLImagen.split("/");
					form.setNombreImagen(sToken[sToken.length-1]);
								
				}
	    		else
	    			form.setActivarImagen(new Integer(2));
	    		
	    	}    	
	    	
    	} catch (Exception e)
    	{
    		logger.error("Error obteniendo la noticia a ver");
    		throw new ValidatorException("{error.obteniendo.noticia.ver}");	    		
    	}
    	
        
     }

    /**
     * @see es.pode.administracion.presentacion.noticias.verNoticia.VerNoticiaController#verPasoDos(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.noticias.verNoticia.VerPasoDosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void verPasoDos(ActionMapping mapping, es.pode.administracion.presentacion.noticias.verNoticia.VerPasoDosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try
    	{
	    	logger.debug("Se recupera el vo de la noticia de la request");
	        NoticiaVO noticia = (NoticiaVO)request.getSession().getAttribute(VERNOTICIAVO);        
	
	        ArrayList nombreCategoria = new ArrayList();
	    	ArrayList idiomas = new ArrayList();
	    	ArrayList idiomasAlta = new ArrayList();
	    	ArrayList titulo = new ArrayList();
	    	ArrayList resumen = new ArrayList();
	    	ArrayList cuerpo = new ArrayList();
	        CategoriaNoticiaVO categoria = noticia.getCategoria();
	        DescripcionNoticiaVO[] descripcionesNoticia = noticia.getDescripcionNoticia();
	        for (int j = 0; descripcionesNoticia != null && j < descripcionesNoticia.length; j++)
	        {
	        	if (descripcionesNoticia[j].getCuerpo() != null && !("").equals(descripcionesNoticia[j].getCuerpo()))
	        	{
	        		titulo.add(descripcionesNoticia[j].getTitulo());
	        		resumen.add(descripcionesNoticia[j].getResumen());
	        		cuerpo.add(descripcionesNoticia[j].getCuerpo());
	        		idiomasAlta.add(descripcionesNoticia[j].getIdioma());
	        	}
	        }
	        form.setTitulo(titulo);
	        form.setResumen(resumen);
	        form.setCuerpo(cuerpo);
	        form.setIdiomasAlta(idiomasAlta);
	    	
	//	Se almacena los datos
	    	if (categoria != null)
	    	{
	    		CategoriaIdiomaNoticiaVO[] categoriasIdiomas = categoria.getCategoriaIdioma();
	    		for (int i = 0; categoriasIdiomas != null && i < categoriasIdiomas.length; i++)
	    		{
	    			if (categoriasIdiomas[i].getNombreCategoria() != null && !("").equals(categoriasIdiomas[i].getNombreCategoria()))
	    			{
	    				nombreCategoria.add(categoriasIdiomas[i].getNombreCategoria());
	    				idiomas.add(categoriasIdiomas[i].getIdioma());
	    			}    			
	    		}
	    	} 
	    	
	    	form.setIdiomas(idiomas);
	    	form.setNombreCategoria(nombreCategoria);
	        
	        request.getSession().setAttribute(VERNOTICIAVO, null);
	        
    	} catch (Exception e)
    	{
    		logger.error("Error obteniendo la noticia a ver");
    		throw new ValidatorException("{error.obteniendo.noticia.ver}");	    
    	}
     }

}