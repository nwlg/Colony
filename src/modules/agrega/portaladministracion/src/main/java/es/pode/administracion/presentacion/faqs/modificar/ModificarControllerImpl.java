/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.faqs.modificar;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.administracion.presentacion.faqs.crear.CrearControllerImpl;
import es.pode.administracion.presentacion.noticias.noticias.NoticiasControllerImpl;
import es.pode.contenidos.negocio.faqs.servicio.CategoriaFaqVO;
import es.pode.contenidos.negocio.faqs.servicio.CategoriaIdiomaFaqVO;
import es.pode.contenidos.negocio.faqs.servicio.DescripcionFaqVO;
import es.pode.contenidos.negocio.faqs.servicio.FaqTraducidaIdiomaVO;
import es.pode.contenidos.negocio.faqs.servicio.FaqVO;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.administracion.presentacion.faqs.modificar.ModificarController
 */
public class ModificarControllerImpl extends ModificarController
{

	private java.util.Properties pSpringProperties = null;
	private static Logger logger = Logger.getLogger(ModificarControllerImpl.class);

	private static final String VERFAQVO = "verFaq";
	private static final String CATEGORIAMODVO = "categoriaModificar";
	private static final String FAQS = "faqs";
	
	private static final String TRUE = "TRUE";
	private static final String FALSE = "FALSE";


    /**
     * @see es.pode.administracion.presentacion.faqs.modificar.ModificarController#obtenerIdentificadores(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.faqs.modificar.ObtenerIdentificadoresForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void obtenerIdentificadores(ActionMapping mapping, es.pode.administracion.presentacion.faqs.modificar.ObtenerIdentificadoresForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
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
			logger.error("Error obteniendo la faq");
			throw new ValidatorException("{errorObteniendoFaq}");			
		}
        
     }

    /**
     * @see es.pode.administracion.presentacion.faqs.modificar.ModificarController#modificarFaqUno(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.faqs.modificar.ModificarFaqUnoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void modificarFaqUno(ActionMapping mapping, es.pode.administracion.presentacion.faqs.modificar.ModificarFaqUnoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	FaqTraducidaIdiomaVO[] faqs = null;
    	CrearControllerImpl crearController = new CrearControllerImpl();
    	/**
		 * **************************************************************************************************************************************
		 * ********************************************** SE COMPRUEBA LA CATEGORIA *************************************************************
		 * **************************************************************************************************************************************
		 * */
        if (form.getCategoria() == null)
        {
        	logger.error("Categoria es un campo obligatorio");
        	throw new ValidatorException("{errors.noticia.categoria}");
        }
        logger.debug("Se recupera el vo de la faq de la request");
        FaqVO faq = (FaqVO)request.getSession().getAttribute(VERFAQVO);   
        
        if (logger.isDebugEnabled()) logger.debug("Se obtiene la categoria con identificador ["+form.getCategoria()+"]"); 
        CategoriaFaqVO categoria = this.getSrvFaqService().obtenerCategoria(form.getCategoria());	
        request.getSession().setAttribute(CATEGORIAMODVO, categoria);
        			 
		ArrayList idiomasList = new ArrayList();
		CategoriaIdiomaFaqVO[] idiomasCategorias = categoria.getCategoriaIdioma();		
		for (int i = 0; i < idiomasCategorias.length; i++)
			idiomasList.add(idiomasCategorias[i].getIdioma());		
		
		form.setIdiomasCategoriasBBDDAsArray((String[])idiomasList.toArray(new String[0]));
		
		//Se comprueba la posicion en todos los idiomas
		if (logger.isDebugEnabled()) logger.debug("Gestión de la posicion de los faqs en cada idioma");		
		
		if (request.getSession().getAttribute(FAQS) != null)
		{
			//Se recupera de la sesion
			faqs = (FaqTraducidaIdiomaVO[])request.getSession().getAttribute(FAQS);
		}
		else
		{
//			Se obtiene los faqs en el servicio
			faqs = this.getSrvFaqService().obtenerFaqsBloquesIdiomas(I18n.getInstance().obtenerIdiomasPlataforma());	
			request.getSession().setAttribute(FAQS, faqs);
		}
//		Castellano		
		String[] faqsEs = crearController.dameFaqsIdiomaPosicion(faqs, this.getPropertyValue("castellano"));
		form.setPosicionesCastellanoAsArray(faqsEs);
		//Ingles
		String[] faqsEn = crearController.dameFaqsIdiomaPosicion(faqs, this.getPropertyValue("ingles"));
		form.setPosicionesInglesAsArray(faqsEn);
		//Catalan
		String[] faqsCa = crearController.dameFaqsIdiomaPosicion(faqs, this.getPropertyValue("catalan"));
		form.setPosicionesCatalanAsArray(faqsCa);
		//Valenciano
		String[] faqsVa = crearController.dameFaqsIdiomaPosicion(faqs, this.getPropertyValue("valenciano"));
		form.setPosicionesValencianoAsArray(faqsVa);
		//Gallego
		String[] faqsGl = crearController.dameFaqsIdiomaPosicion(faqs, this.getPropertyValue("gallego"));
		form.setPosicionesGallegoAsArray(faqsGl);
		//Euskera
		String[] faqsEu = crearController.dameFaqsIdiomaPosicion(faqs, this.getPropertyValue("euskera"));
		form.setPosicionesEuskeraAsArray(faqsEu);		
		
		if ((form.getCastellano() != null && form.getCastellano().length > 0) ||
				(form.getCatalan() != null && form.getCatalan().length > 0) ||
				(form.getEuskera() != null && form.getEuskera().length > 0) ||
				(form.getIngles() != null && form.getIngles().length > 0) ||
				(form.getValenciano() != null && form.getValenciano().length > 0) ||
				(form.getGallego() != null && form.getGallego().length > 0))
		{
			String[] castellano = form.getCastellano();
			String[] catalan = form.getCatalan();
			String[] euskera = form.getEuskera();
			String[] ingles = form.getIngles();
			String[] valenciano = form.getValenciano();
			String[] gallego = form.getGallego();	
			
			//Tratamiento de la posicion			
			form.setValuePosicion(crearController.dameValuePosiciones(castellano, catalan, ingles, euskera, gallego, valenciano));
			
			form.setIdiomas(crearController.dameIdiomas(castellano, catalan, ingles, euskera, gallego, valenciano));
			form.setIdiomasAlta(crearController.dameIdiomas(castellano, catalan, ingles, euskera, gallego, valenciano));
			form.setTitulo(crearController.dameTitulos(castellano, catalan, ingles, euskera, gallego, valenciano));
			form.setDescripcion(crearController.dameDescripciones(castellano, catalan, ingles, euskera, gallego, valenciano));			
			form.setNombreCategoria(crearController.dameCategorias(castellano, catalan, ingles, euskera, gallego, valenciano));
		}
		else
		{         
	       
	        ArrayList idiomasAlta = new ArrayList();
	    	ArrayList titulo = new ArrayList();
	    	ArrayList descripcion = new ArrayList();
	    	ArrayList valuePosicion = new ArrayList();

	        DescripcionFaqVO[] descripcionesFaq = faq.getDescripcionFaq();
	        for (int j = 0; descripcionesFaq != null && j < descripcionesFaq.length; j++)
	        {
	        	if (descripcionesFaq[j].getPregunta() != null && !("").equals(descripcionesFaq[j].getPregunta()))
	        	{
	        		titulo.add(descripcionesFaq[j].getPregunta());
	        		descripcion.add(descripcionesFaq[j].getRespuesta());
	        		valuePosicion.add(descripcionesFaq[j].getPosicion().toString());
	        		idiomasAlta.add(descripcionesFaq[j].getIdioma());
	        	}
	        }


	        form.setValuePosicion(valuePosicion);
	    	form.setTitulo(titulo);
	        form.setDescripcion(descripcion);
	        form.setIdiomasAlta(idiomasAlta);
	    	
	        ArrayList nombreCategoria = new ArrayList();
	    	ArrayList idiomas = new ArrayList();  	    		 
	        
//	    	Se almacena los datos
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
	        
		}
     }

    /**
     * @see es.pode.administracion.presentacion.faqs.modificar.ModificarController#modificarFaqDos(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.faqs.modificar.ModificarFaqDosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void modificarFaqDos(ActionMapping mapping, es.pode.administracion.presentacion.faqs.modificar.ModificarFaqDosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String[] castellano = form.getCastellano();
		String[] catalan = form.getCatalan();
		String[] euskera = form.getEuskera();
		String[] ingles = form.getIngles();
		String[] valenciano = form.getValenciano();
		String[] gallego = form.getGallego();
		
		CrearControllerImpl controllerCrear = new CrearControllerImpl(); 
		CategoriaFaqVO categoriaFaq = (CategoriaFaqVO)request.getSession().getAttribute(CATEGORIAMODVO);
		controllerCrear.rellenaArrayIdiomaCategoriaFaq (castellano,catalan,ingles,euskera,gallego,valenciano,categoriaFaq);
		
		/**
		 * **************************************************************************************************************************************
		 * ************************************************ CREAR NUEVAS TRADUCCIONES DE CATEGORIAS *********************************************
		 * **************************************************************************************************************************************
		 * */
//		Si hay nuevas traducciones de la categoria se inserta en la base de datos
		ArrayList nuevasCategorias = new ArrayList();
		ArrayList nuevasCategoriasIdiomas = new ArrayList();
		if (castellano != null && castellano[4] != null)
		{
			nuevasCategorias.add(castellano[4]);
			nuevasCategoriasIdiomas.add(castellano[0]);
		}
		if (ingles != null && ingles[4] != null)
		{
			nuevasCategorias.add(ingles[4]);
			nuevasCategoriasIdiomas.add(ingles[0]);
		}
		if (euskera != null && euskera[4] != null)
		{
			nuevasCategorias.add(euskera[4]);
			nuevasCategoriasIdiomas.add(euskera[0]);
		}
		if (valenciano != null && valenciano[4] != null)
		{
			nuevasCategorias.add(valenciano[4]);
			nuevasCategoriasIdiomas.add(valenciano[0]);
		}
		if (catalan != null && catalan[4] != null)
		{
			nuevasCategorias.add(catalan[4]);
			nuevasCategoriasIdiomas.add(catalan[0]);
		}
		if (gallego != null && gallego[4] != null)
		{
			nuevasCategorias.add(gallego[4]);
			nuevasCategoriasIdiomas.add(gallego[0]);
		}
		
		if (nuevasCategorias != null && nuevasCategorias.size() > 0)
		{
			try
			{
				if (logger.isDebugEnabled()) logger.debug("Hay ["+nuevasCategorias.size()+"] nuevas traducciones en la categoria");
				ArrayList categoriasIdiomas = new ArrayList();	
				CategoriaIdiomaFaqVO[] categoriasIdiomasArray = categoriaFaq.getCategoriaIdioma();
				for (int i = 0; categoriasIdiomasArray != null && i < categoriasIdiomasArray.length; i++)			
					categoriasIdiomas.add(categoriasIdiomasArray[i]);
				
				for (int j = 0; j < nuevasCategorias.size(); j++)
				{
					CategoriaIdiomaFaqVO categoriaNueva = new CategoriaIdiomaFaqVO();
					categoriaNueva.setIdioma(((String)nuevasCategoriasIdiomas.get(j)).trim());					
					categoriaNueva.setNombre(((String)nuevasCategorias.get(j)).trim());
					categoriasIdiomas.add(categoriaNueva);
				}
				CategoriaIdiomaFaqVO[] categoriasIdiomasVector = (CategoriaIdiomaFaqVO[])categoriasIdiomas.toArray(new CategoriaIdiomaFaqVO[0]);
				
				if (logger.isDebugEnabled()) logger.debug("Se modifica la categoria");
				CategoriaFaqVO nueva = new CategoriaFaqVO();				
				nueva.setId(categoriaFaq.getId());
				nueva.setNombre(categoriaFaq.getNombre());
				nueva.setCategoriaIdioma(categoriasIdiomasVector);
				nueva.setFechaAlta(categoriaFaq.getFechaAlta());
							
				this.getSrvFaqService().limpiarCategoria(form.getCategoria());
				this.getSrvFaqService().modificarCategoria(nueva);				
				
				
			} catch (Exception e)
			{
				logger.error("Error modificando la categoria", e);
				throw new ValidatorException("{error.modificando.categoria}");						
			}
		}
		
		logger.debug("Se modifica la faq");
		/**
		 * **************************************************************************************************************************************
		 * ****************************************************** SE MODIFICA LA FAQ ************************************************************
		 * **************************************************************************************************************************************
		 * */
		try
		{
		
			FaqVO faqModificable = (FaqVO)request.getSession().getAttribute(VERFAQVO);	
			
//			Se forma el vo de la faq
			FaqVO faq = new FaqVO();
				faq.setId(faqModificable.getId());
				faq.setFechaPublicacion(faqModificable.getFechaPublicacion());
			
			CategoriaFaqVO categoria = (CategoriaFaqVO)request.getSession().getAttribute(CATEGORIAMODVO);		 
			faq.setCategoria(categoria);
			
			ArrayList descripcionesFaq = new ArrayList();
			
			//Tratamiento de la posicion
			logger.debug("Se recupera las faqs de la sesion");
			FaqTraducidaIdiomaVO[] faqs = (FaqTraducidaIdiomaVO[])request.getSession().getAttribute(FAQS);
//			Castellano		
			String[] faqsEs = controllerCrear.dameFaqsIdiomaPosicion(faqs, this.getPropertyValue("castellano"));
			
			//Ingles
			String[] faqsEn = controllerCrear.dameFaqsIdiomaPosicion(faqs, this.getPropertyValue("ingles"));
			
			//Catalan
			String[] faqsCa = controllerCrear.dameFaqsIdiomaPosicion(faqs, this.getPropertyValue("catalan"));
			
			//Valenciano
			String[] faqsVa = controllerCrear.dameFaqsIdiomaPosicion(faqs, this.getPropertyValue("valenciano"));
			
			//Gallego
			String[] faqsGl = controllerCrear.dameFaqsIdiomaPosicion(faqs, this.getPropertyValue("gallego"));
			
			//Euskera
			String[] faqsEu = controllerCrear.dameFaqsIdiomaPosicion(faqs, this.getPropertyValue("euskera"));
			
			
	//		Se añade las descripciones 
	//		Castellano
			if (castellano != null && castellano[0] != null  && castellano[1] != null && castellano[2] != null)		
				descripcionesFaq = controllerCrear.devuelveListaDescripcionesFaq(descripcionesFaq, castellano[0], castellano[1], castellano[2], castellano[5], faqsEs.length);
			
	//		Ingles
			if (ingles != null && ingles[0] != null  && ingles[1] != null && ingles[2] != null)		
				descripcionesFaq = controllerCrear.devuelveListaDescripcionesFaq(descripcionesFaq, ingles[0], ingles[1], ingles[2], ingles[5], faqsEn.length);
			
	//		Euskera
			if (euskera != null && euskera[0] != null  && euskera[1] != null && euskera[2] != null)		
				descripcionesFaq = controllerCrear.devuelveListaDescripcionesFaq(descripcionesFaq, euskera[0], euskera[1], euskera[2], euskera[5], faqsEu.length);
			
	//		Valenciano
			if (valenciano != null && valenciano[0] != null  && valenciano[1] != null && valenciano[2] != null)		
				descripcionesFaq = controllerCrear.devuelveListaDescripcionesFaq(descripcionesFaq, valenciano[0], valenciano[1], valenciano[2], valenciano[5], faqsVa.length);
			
	//		Catalan
			if (catalan != null && catalan[0] != null  && catalan[1] != null && catalan[2] != null)		
				descripcionesFaq = controllerCrear.devuelveListaDescripcionesFaq(descripcionesFaq, catalan[0], catalan[1], catalan[2], catalan[5], faqsCa.length);
			
	//		Gallego
			if (gallego != null && gallego[0] != null  && gallego[1] != null && gallego[2] != null)		
				descripcionesFaq = controllerCrear.devuelveListaDescripcionesFaq(descripcionesFaq, gallego[0], gallego[1], gallego[2], gallego[5], faqsGl.length);
			
			DescripcionFaqVO[] descripcionesFaqArray = (DescripcionFaqVO[]) descripcionesFaq.toArray(new DescripcionFaqVO[0]);	
			faq.setDescripcionFaq(descripcionesFaqArray);		
			

			logger.debug("Se modifica en la base de datos la noticia");
			this.getSrvFaqService().limpiarFaq(faq.getId());
			this.getSrvFaqService().modificarFaq(faq);
			
			form.setIdModificado(form.getId());
			
			//Se elimina el objeto introducido en sesion
			request.getSession().setAttribute(CATEGORIAMODVO, null);	
			request.getSession().setAttribute(FAQS, null);	
			request.getSession().setAttribute(VERFAQVO, null);
			
			
		} catch (Exception e) 
		{
			logger.error("Error al modificar la faq",e);
			throw new ValidatorException("{errors.faqs.modificar}");				
		}		
     }

    /**
     * @see es.pode.administracion.presentacion.faqs.modificar.ModificarController#validarFormulario(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.faqs.modificar.ValidarFormularioForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void validarFormulario(ActionMapping mapping, es.pode.administracion.presentacion.faqs.modificar.ValidarFormularioForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	logger.debug("Se recoge los parametros del formulario");
		
		/**
		 * **************************************************************************************************************************************
		 * **************************************** SE RECOGE LOS PARAMETROS DEL FORMULARIO *****************************************************
		 * **************************************************************************************************************************************
		 * */
		
	//		Los array tienen cinco posiciones:
	//			[0] es la del idioma
	//			[1] es la del titulo
	//			[2] es la de la descripcion
	//			[3] es la categoria
	//			[4] si la categoria es nueva
	//			[5] la posicion donde se insertara la faq

			String[] castellano = new String[6];
			String[] ingles = new String[6];
			String[] euskera = new String[6];
			String[] valenciano = new String[6];
			String[] catalan = new String[6];
			String[] gallego = new String[6];
			
			CrearControllerImpl controllerFaqs = new CrearControllerImpl();
			
			for (Enumeration names = request.getParameterNames(); names.hasMoreElements();)
			{
				String name = String.valueOf(names.nextElement());
				if (request.getParameter(name) != null && !(request.getParameter(name)).trim().equals(""))
				{
					if (name.endsWith(this.getPropertyValue("castellano")))
					{
						castellano = controllerFaqs.rellenaArrayFaq(request,name, castellano);
						castellano[0] = this.getPropertyValue("castellano");
					}
					else if (name.endsWith(this.getPropertyValue("ingles")))
					{
						ingles = controllerFaqs.rellenaArrayFaq(request,name, ingles);
						ingles[0] = this.getPropertyValue("ingles");
					}
					else if (name.endsWith(this.getPropertyValue("catalan")))
					{
						catalan = controllerFaqs.rellenaArrayFaq(request,name, catalan);
						catalan[0] = this.getPropertyValue("catalan");
					}
					else if (name.endsWith(this.getPropertyValue("euskera")))
					{
						euskera = controllerFaqs.rellenaArrayFaq(request,name, euskera);
						euskera[0] = this.getPropertyValue("euskera");
					}
					else if (name.endsWith(this.getPropertyValue("valenciano")))
					{
						valenciano = controllerFaqs.rellenaArrayFaq(request,name, valenciano);
						valenciano[0] = this.getPropertyValue("valenciano");
					}
					else if (name.endsWith(this.getPropertyValue("gallego")))
					{
						gallego = controllerFaqs.rellenaArrayFaq(request,name, gallego);
						gallego[0] = this.getPropertyValue("gallego");
					}
				}
			}
		
		CategoriaFaqVO categoriaFaq = (CategoriaFaqVO)request.getSession().getAttribute(CATEGORIAMODVO);
		controllerFaqs.rellenaArrayIdiomaCategoriaFaq (castellano,catalan,ingles,euskera,gallego,valenciano,categoriaFaq);
		
		logger.debug("Se valida el formulario");
		/**
		 * **************************************************************************************************************************************
		 * ************************************************ SE VALIDA EL FORMULARIO *************************************************************
		 * **************************************************************************************************************************************
		 * */
		if (!controllerFaqs.validaFormularioFaq(castellano, catalan, ingles, euskera, gallego, valenciano, request))
		{	
			logger.debug("El formulario ha validado correctamente");
			form.setValido(FALSE);
		}
		else
		{
			logger.debug("El formulario no ha validado");
			form.setValido(TRUE);
		}		
		form.setCastellano(castellano);
		form.setCatalan(catalan);
		form.setEuskera(euskera);
		form.setIngles(ingles);
		form.setValenciano(valenciano);
		form.setGallego(gallego);
     }

    /**
     * @see es.pode.administracion.presentacion.faqs.modificar.ModificarController#analizaValidacion(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.faqs.modificar.AnalizaValidacionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String analizaValidacion(ActionMapping mapping, es.pode.administracion.presentacion.faqs.modificar.AnalizaValidacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
//		Se comprueba si el formulario ha validado o no
    	if (logger.isDebugEnabled()) logger.debug("El resultado de la validacion del formulario es ["+form.getValido()+"]");
    	return (form.getValido());  
    }
    private String getPropertyValue(String sKey) throws IOException
	{
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/portaladministracion.properties");
		if (this.pSpringProperties == null)
		{
			pSpringProperties = new java.util.Properties();
			pSpringProperties.load(fIsSpringProperties);
		}
		fIsSpringProperties.close();
		// devolvemos la propiedad
		return pSpringProperties.getProperty(sKey);
	}

}