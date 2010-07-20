/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.faqs.faqs;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.administracion.presentacion.noticias.noticias.NoticiasControllerImpl;
import es.pode.contenidos.negocio.faqs.servicio.FaqTraducidaVO;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.administracion.presentacion.faqs.faqs.FaqsController
 */
public class FaqsControllerImpl extends FaqsController
{


	private final String todas = "TODAS";
	private static Logger logger = Logger.getLogger(FaqsControllerImpl.class);

	private static final String VERFAQVO = "verFaq";
	private static final String CATEGORIAMODVO = "categoriaModificar";
	private static final String FAQS = "faqs";
	private final static String CATEGORIAVO = "categoriavo";	
	
    /**
     * @see es.pode.administracion.presentacion.faqs.faqs.FaqsController#cargarFaqs(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.faqs.faqs.CargarFaqsForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargarFaqs(ActionMapping mapping, es.pode.administracion.presentacion.faqs.faqs.CargarFaqsForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
//    	 la primera categoria de la collection es todas y el resto son las categoriasVO
    	
    	    	try
    	    	{    
    	    		//Se elimina de la request los valores si estuvieran llenos
    	    		request.getSession().setAttribute(VERFAQVO, null);
    	    		request.getSession().setAttribute(CATEGORIAMODVO, null);
    	    		request.getSession().setAttribute(FAQS, null);
    	    		request.getSession().setAttribute(CATEGORIAVO, null);
    				
    				logger.debug("Recuperando faqs con idioma: "+form.getIdiomaSeleccionado()+", primero los idiomas.");
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
  		
    				NoticiasControllerImpl noticiasController = new NoticiasControllerImpl();	
    				
    				//Se recuperan las categorias de las faqs de la base de datos
//    				CategoriaTraducidaVO[] categorias = this.getSrvFaqService().obtenerCategoriasTraducidas(noticiasController.
//    						devuelveIdiomasTraducibles(idiomasPlataforma, idiomaLogado, idiomaPrioritario, idiomaSecundario));    				
    				
    				ArrayList primeroDeIdiomas = new ArrayList();
    				primeroDeIdiomas.add(this.todas);    				
    				primeroDeIdiomas.add(idiomasPlataforma);
    				//Esto queda muy poco vistoso pero es bastante eficiente, el primer elemento sera todos y el siguiente 
    				// la colección en la que iterar
//    				form.setCategorias(primeroDeCat);
    				form.setIdiomas(primeroDeIdiomas);
    				
    				FaqTraducidaVO[] faqs = null;
    				logger.debug("Despues las faqs");
    				//			si no hay categoria seleccionada escogemos todas, que debiera ser el caso inicial    				
    				
    				if (form.getIdiomaSeleccionado() == null || this.todas.equals(form.getIdiomaSeleccionado())) {
    					form.setIdiomaSeleccionado(this.todas);
    					faqs = this.getSrvFaqService().obtenerFaqsTraducidas(noticiasController.
    						devuelveIdiomasTraducibles(idiomasPlataforma, idiomaLogado, idiomaPrioritario, idiomaSecundario));     					
    				} 
    				else
    					faqs = this.getSrvFaqService().obtenerFaqsPorIdioma(form.getIdiomaSeleccionado());
    					
    		
    				for (int h = 0; h < faqs.length; h++) {
    					//sustituimos los retorno de carro por <br/> en respuesta
    					faqs[h].setRespuesta(faqs[h].getRespuesta().replaceAll("\n\r", "<br/>"));
    					faqs[h].setRespuesta(faqs[h].getRespuesta().replaceAll("\r\n", "<br/>"));
    					faqs[h].setRespuesta(faqs[h].getRespuesta().replaceAll("\n", "<br/>"));
    					faqs[h].setRespuesta(faqs[h].getRespuesta().replaceAll("\r", "<br/>"));
    		
    					//sustituimos @,",:,%,+,-,' por su codigo correspondiente en ASCII
    					faqs[h].setPregunta(faqs[h].getPregunta().replaceAll("@", "&#64"));
    					faqs[h].setPregunta(faqs[h].getPregunta().replaceAll("\\\"", "&#34"));
    					faqs[h].setPregunta(faqs[h].getPregunta().replaceAll(":", "&#58"));
    					faqs[h].setPregunta(faqs[h].getPregunta().replaceAll("%", "&#37"));
    					faqs[h].setPregunta(faqs[h].getPregunta().replaceAll("\\+", "&#43"));
    					faqs[h].setPregunta(faqs[h].getPregunta().replaceAll("-", "&#45"));
    					faqs[h].setPregunta(faqs[h].getPregunta().replaceAll("'", "&#39"));
    				}
    		
    				// Poblando la tabla con el listado de faqs    	
    				form.setFaqsAsArray(faqs);
    	    	}
    	    	catch (Exception ex)
    	    	{
    	    		logger.error("Excepcion no controlada cargando los faqs: " + ex );
    	    		throw(ex);
    	    	}
    					
    }     

	public void getIds(ActionMapping mapping, GetIdsForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		/**
		 * **************************************************************************************************************************************
		 * **************************** SE RECUPERAN LOS IDENTIFICADORES DE LA FAQ A ELIMINAR *********************************************
		 * **************************************************************************************************************************************
		 * */
		List lista = ((FaqsEliminarFormImpl) form).getIdRowSelection();			
		if (lista == null)
		{
			logger.error("Debe seleccionar al menos una faq a eliminar");
			throw new ValidatorException("{errors.borrarFaq.idNulo}");
		}
		else
		{
			form.setIds(lista);
		}
		
	}

}
