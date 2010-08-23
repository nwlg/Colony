/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.faqs.verFaq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.administracion.presentacion.noticias.noticias.NoticiasControllerImpl;
import es.pode.contenidos.negocio.faqs.servicio.CategoriaFaqVO;
import es.pode.contenidos.negocio.faqs.servicio.CategoriaIdiomaFaqVO;
import es.pode.contenidos.negocio.faqs.servicio.DescripcionFaqVO;
import es.pode.contenidos.negocio.faqs.servicio.FaqVO;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @see es.pode.administracion.presentacion.faqs.verFaq.VerFaqController
 */
public class VerFaqControllerImpl extends VerFaqController
{

	private static Logger logger = Logger.getLogger(VerFaqControllerImpl.class);

	private final static String VERFAQVO = "verFaqvo";		

    /**
     * @see es.pode.administracion.presentacion.faqs.verFaq.VerFaqController#obtenerFaqs(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.faqs.verFaq.ObtenerFaqsForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void obtenerFaqs(ActionMapping mapping, es.pode.administracion.presentacion.faqs.verFaq.ObtenerFaqsForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
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
			Collection categorias = Arrays.asList(this.getSrvFaqService().obtenerCategoriasTraducidas(noticiasController.
					devuelveIdiomasTraducibles(idiomasPlataforma, idiomaLogado, idiomaPrioritario, idiomaSecundario)));
			form.setCategoriaBackingList(categorias, "id", "nombre");	
	    	
	//      Se obtiene los datos de la faq
	    	if (logger.isDebugEnabled()) logger.debug("Se obtiene los datos de la faq con identificador ["+form.getId()+"]");
	    	FaqVO faq = this.getSrvFaqService().consultaFaq(form.getId());
	    	request.getSession().setAttribute(VERFAQVO, faq);	    		    	
	    	form.setCategoria(faq.getCategoria().getId());	
	    	
    	} catch (Exception e)
    	{
    		logger.error("Error obteniendo la faq a ver");
    		throw new ValidatorException("{error.obteniendo.faq.ver}");	    		
    	}
    	
     }

    /**
     * @see es.pode.administracion.presentacion.faqs.verFaq.VerFaqController#verPasoDos(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.faqs.verFaq.VerPasoDosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void verPasoDos(ActionMapping mapping, es.pode.administracion.presentacion.faqs.verFaq.VerPasoDosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try
    	{
	    	logger.debug("Se recupera el vo de la faq de la request");
	        FaqVO faq = (FaqVO)request.getSession().getAttribute(VERFAQVO);        
	
	        ArrayList nombreCategoria = new ArrayList();
	    	ArrayList idiomas = new ArrayList();
	    	ArrayList idiomasAlta = new ArrayList();
	    	ArrayList titulo = new ArrayList();
	    	ArrayList descripcion = new ArrayList();
	    	ArrayList valuePosicion = new ArrayList();
	    	
	        CategoriaFaqVO categoria = faq.getCategoria();
	        DescripcionFaqVO[] descripcionesFaq = faq.getDescripcionFaq();
	        for (int j = 0; descripcionesFaq != null && j < descripcionesFaq.length; j++)
	        {
	        	if (descripcionesFaq[j].getRespuesta() != null && !("").equals(descripcionesFaq[j].getRespuesta()))
	        	{
	        		titulo.add(descripcionesFaq[j].getPregunta());
	        		descripcion.add(descripcionesFaq[j].getRespuesta());
	        		valuePosicion.add(descripcionesFaq[j].getPosicion().toString());
	        		idiomasAlta.add(descripcionesFaq[j].getIdioma());
	        	}
	        }
	        form.setTitulo(titulo);
	        form.setDescripcion(descripcion);	        
	        form.setIdiomasAlta(idiomasAlta);
	        form.setValuePosicion(valuePosicion);
	    	
	//	Se almacena los datos
	    	if (categoria != null)
	    	{
	    		CategoriaIdiomaFaqVO[] categoriasIdiomas = categoria.getCategoriaIdioma();
	    		for (int i = 0; categoriasIdiomas != null && i < categoriasIdiomas.length; i++)
	    		{
	    			if (categoriasIdiomas[i].getNombre() != null && !("").equals(categoriasIdiomas[i].getNombre()))
	    			{
	    				nombreCategoria.add(categoriasIdiomas[i].getNombre());
	    				idiomas.add(categoriasIdiomas[i].getIdioma());
	    			}    			
	    		}
	    	} 
	    	
	    	form.setIdiomas(idiomas);
	    	form.setNombreCategoria(nombreCategoria);
	        
	        request.getSession().setAttribute(VERFAQVO, null);
	        
    	} catch (Exception e)
    	{
    		logger.error("Error obteniendo la faq a ver");
    		throw new ValidatorException("{error.obteniendo.faq.ver}");	    
    	}
     }

}