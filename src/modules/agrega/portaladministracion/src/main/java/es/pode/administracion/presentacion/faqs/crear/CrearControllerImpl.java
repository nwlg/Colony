/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.faqs.crear;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.administracion.presentacion.noticias.noticias.NoticiasControllerImpl;
import es.pode.contenidos.negocio.faqs.servicio.CategoriaFaqVO;
import es.pode.contenidos.negocio.faqs.servicio.CategoriaIdiomaFaqVO;
import es.pode.contenidos.negocio.faqs.servicio.DescripcionFaqVO;
import es.pode.contenidos.negocio.faqs.servicio.FaqTraducidaIdiomaVO;
import es.pode.contenidos.negocio.faqs.servicio.FaqVO;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.administracion.presentacion.faqs.crear.CrearController
 */
public class CrearControllerImpl extends CrearController
{

	private static Logger logger = Logger.getLogger(CrearControllerImpl.class);
	private java.util.Properties pSpringProperties = null;

	private final static String CATEGORIAVO = "categoriavo";
	private final static String FAQS = "faqs";
	
	private static final String NAMEJSPTITULOFAQ = "tituloFaq";
	private static final String NAMEJSPDESCRIPCIONFAQ = "descripcionFaq";		
	private static final String NAMEJSPCATEGORIAFAQ = "categoriaFaq";
	private static final String NAMEJSPPOSICIONFAQ = "posicionFaq";
	
	
	public static final String ERRORESOBLIGATORIO = "error.noticia.es.obligatorio";
	public static final String ERRORSONOBLIGATORIOS = "error.noticia.son.obligatorio";
	public static final String ERRORCATOBLIGATORIO = "error.noticia.categoria.obligatorio";
	public static final String ERRORTITULOOBLIGATORIO = "error.noticia.titulo.obligatorio";
	public static final String ERRORDESCRIPCIONOBLIGATORIO = "error.faq.descripcion.obligatorio";
	public static final String ERRORPOSICIONOBLIGATORIO = "error.faq.posicion.obligatorio";
	public static final String ERRORCATEGORIAMAXTAMANO = "error.noticia.categoria.maximo.caracteres";
	public static final String ERRORMAXTITULOFAQ = "error.faq.titulo.maximo.caracteres";
	public static final String ERRORFAQCARACTERILEGAL = "errors.faq.caracterIlegal";
	public static final String ERRORMAXDESCRIPCION = "error.faq.descripcion.maximo.caracteres";
	public static final String ERRORFAQFRAMEVACIO = "error.faq.formulario.vacio";
	
	public static int CUATROMIL = 4000;
	private static final int MAXTAMCATEGORIA = 50;
	public static int DOSCIENTOSCINCUENTA = 100;
	
	private static final String COMA = ",";
	private static final String TRUE = "TRUE";
	private static final String FALSE = "FALSE";
	

    /**
     * @see es.pode.administracion.presentacion.faqs.crear.CrearController#obtenerCategoria(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.faqs.crear.ObtenerCategoriaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void obtenerCategoria(ActionMapping mapping, es.pode.administracion.presentacion.faqs.crear.ObtenerCategoriaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
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
		
			/**
    		 * **************************************************************************************************************************************
    		 * ******************************************* SE RELLENA EL COMBO DE CATEGORIAS ********************************************************
    		 * **************************************************************************************************************************************
    		 * */
			NoticiasControllerImpl noticiasController = new NoticiasControllerImpl();
			
			Collection categorias = Arrays.asList(this.getSrvFaqService().obtenerCategoriasTraducidas(noticiasController.
					devuelveIdiomasTraducibles(idiomasPlataforma, idiomaLogado, idiomaPrioritario, idiomaSecundario)));
			form.setCategoriaBackingList(categorias, "id", "nombre");				
			
		}
		catch (Exception e)
		{
			logger.error("Error recuperando las categorias");
			throw new ValidatorException("{errors.categorias.recuperar}");
		}
     }

    /**
     * @see es.pode.administracion.presentacion.faqs.crear.CrearController#crearFaqUno(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.faqs.crear.CrearFaqUnoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void crearFaqUno(ActionMapping mapping, es.pode.administracion.presentacion.faqs.crear.CrearFaqUnoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
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
        FaqTraducidaIdiomaVO[] faqs = null;
        CategoriaFaqVO categoria = this.getSrvFaqService().obtenerCategoria(form.getCategoria());			 
		ArrayList idiomasList = new ArrayList();
		CategoriaIdiomaFaqVO[] idiomasCategorias = categoria.getCategoriaIdioma();		
		for (int i = 0; i < idiomasCategorias.length; i++)
			idiomasList.add(idiomasCategorias[i].getIdioma());
		
		form.setIdiomasCategoriasBBDDAsArray((String[])idiomasList.toArray(new String[0]));				
		
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
		
//		Se comprueba la posicion en todos los idiomas
		if (logger.isDebugEnabled()) logger.debug("Gestión de la posicion de los faqs en cada idioma");
//		Castellano		
		String[] faqsEs = dameFaqsIdiomaPosicion(faqs, this.getPropertyValue("castellano"));
		form.setPosicionesCastellanoAsArray(faqsEs);
		//Ingles
		String[] faqsEn = dameFaqsIdiomaPosicion(faqs, this.getPropertyValue("ingles"));
		form.setPosicionesInglesAsArray(faqsEn);
		//Catalan
		String[] faqsCa = dameFaqsIdiomaPosicion(faqs, this.getPropertyValue("catalan"));
		form.setPosicionesCatalanAsArray(faqsCa);
		//Valenciano
		String[] faqsVa = dameFaqsIdiomaPosicion(faqs, this.getPropertyValue("valenciano"));
		form.setPosicionesValencianoAsArray(faqsVa);
		//Gallego
		String[] faqsGl = dameFaqsIdiomaPosicion(faqs, this.getPropertyValue("gallego"));
		form.setPosicionesGallegoAsArray(faqsGl);
		//Euskera
		String[] faqsEu = dameFaqsIdiomaPosicion(faqs, this.getPropertyValue("euskera"));
		form.setPosicionesEuskeraAsArray(faqsEu);		
		
//		Se comprueba si el formulario fue invalido pero se recuperan los valores introducidos
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
			form.setValuePosicion(dameValuePosiciones(castellano, catalan, ingles, euskera, gallego, valenciano));
			
			form.setIdiomas(dameIdiomas(castellano, catalan, ingles, euskera, gallego, valenciano));
			form.setIdiomasAlta(dameIdiomas(castellano, catalan, ingles, euskera, gallego, valenciano));
			form.setTitulo(dameTitulos(castellano, catalan, ingles, euskera, gallego, valenciano));
			form.setDescripcion(dameDescripciones(castellano, catalan, ingles, euskera, gallego, valenciano));			
			form.setNombreCategoria(dameCategorias(castellano, catalan, ingles, euskera, gallego, valenciano));
		}
		else
		{         
	        
	        ArrayList nombreCategoria = new ArrayList();
	    	ArrayList idiomas = new ArrayList();
	    	
	    	if (logger.isDebugEnabled()) logger.debug("Se obtiene la categoria con identificador ["+form.getCategoria()+"]");  
	    	try
	    	{	   	
		    	
		    	/**
	    		 * **************************************************************************************************************************************
	    		 * ********************************************** SE ALMACENA LOS DATOS *****************************************************************
	    		 * **************************************************************************************************************************************
	    		 * */
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
		    	
		    	request.getSession().setAttribute(CATEGORIAVO, categoria);
	    	} catch (Exception e)
	    	{
	    		logger.error("Error obteniendo la categoria");
	    		throw new ValidatorException("{errors.categoria.ver}");
			}	    	
	    	
	    	form.setIdiomas(idiomas);
	    	form.setNombreCategoria(nombreCategoria);
		}
     }

    /**
     * @see es.pode.administracion.presentacion.faqs.crear.CrearController#crearFaqDos(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.faqs.crear.CrearFaqDosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void crearFaqDos(ActionMapping mapping, es.pode.administracion.presentacion.faqs.crear.CrearFaqDosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String[] castellano = form.getCastellano();
		String[] catalan = form.getCatalan();
		String[] euskera = form.getEuskera();
		String[] ingles = form.getIngles();
		String[] valenciano = form.getValenciano();
		String[] gallego = form.getGallego();
		
		CategoriaFaqVO categoriaFaq = (CategoriaFaqVO)request.getSession().getAttribute(CATEGORIAVO);
		rellenaArrayIdiomaCategoriaFaq (castellano,catalan,ingles,euskera,gallego,valenciano,categoriaFaq);
		
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
		
		logger.debug("Se crea la faq");
		/**
		 * **************************************************************************************************************************************
		 * ****************************************************** SE INSERTA LA FAQ *************************************************************
		 * **************************************************************************************************************************************
		 * */
		try
		{
	//		Se forma el vo de la faq
			FaqVO faq = new FaqVO();			
			
			CategoriaFaqVO categoria = (CategoriaFaqVO)request.getSession().getAttribute(CATEGORIAVO);		 
			faq.setCategoria(categoria);
			
			ArrayList descripcionesFaq = new ArrayList();
			
			//Tratamiento de la posicion
			logger.debug("Se recupera las faqs de la sesion");
			FaqTraducidaIdiomaVO[] faqs = (FaqTraducidaIdiomaVO[])request.getSession().getAttribute(FAQS);
//			Castellano		
			String[] faqsEs = dameFaqsIdiomaPosicion(faqs, this.getPropertyValue("castellano"));
			
			//Ingles
			String[] faqsEn = dameFaqsIdiomaPosicion(faqs, this.getPropertyValue("ingles"));
			
			//Catalan
			String[] faqsCa = dameFaqsIdiomaPosicion(faqs, this.getPropertyValue("catalan"));
			
			//Valenciano
			String[] faqsVa = dameFaqsIdiomaPosicion(faqs, this.getPropertyValue("valenciano"));
			
			//Gallego
			String[] faqsGl = dameFaqsIdiomaPosicion(faqs, this.getPropertyValue("gallego"));
			
			//Euskera
			String[] faqsEu = dameFaqsIdiomaPosicion(faqs, this.getPropertyValue("euskera"));
			
			
	//		Se añade las descripciones 
	//		Castellano
			if (castellano != null && castellano[0] != null  && castellano[1] != null && castellano[2] != null)		
				descripcionesFaq = devuelveListaDescripcionesFaq(descripcionesFaq, castellano[0], castellano[1], castellano[2], castellano[5], faqsEs.length);
			
	//		Ingles
			if (ingles != null && ingles[0] != null  && ingles[1] != null && ingles[2] != null)		
				descripcionesFaq = devuelveListaDescripcionesFaq(descripcionesFaq, ingles[0], ingles[1], ingles[2], ingles[5], faqsEn.length);
			
	//		Euskera
			if (euskera != null && euskera[0] != null  && euskera[1] != null && euskera[2] != null)		
				descripcionesFaq = devuelveListaDescripcionesFaq(descripcionesFaq, euskera[0], euskera[1], euskera[2], euskera[5], faqsEu.length);
			
	//		Valenciano
			if (valenciano != null && valenciano[0] != null  && valenciano[1] != null && valenciano[2] != null)		
				descripcionesFaq = devuelveListaDescripcionesFaq(descripcionesFaq, valenciano[0], valenciano[1], valenciano[2], valenciano[5], faqsVa.length);
			
	//		Catalan
			if (catalan != null && catalan[0] != null  && catalan[1] != null && catalan[2] != null)		
				descripcionesFaq = devuelveListaDescripcionesFaq(descripcionesFaq, catalan[0], catalan[1], catalan[2], catalan[5], faqsCa.length);
			
	//		Gallego
			if (gallego != null && gallego[0] != null  && gallego[1] != null && gallego[2] != null)		
				descripcionesFaq = devuelveListaDescripcionesFaq(descripcionesFaq, gallego[0], gallego[1], gallego[2], gallego[5], faqsGl.length);
			
			DescripcionFaqVO[] descripcionesFaqArray = (DescripcionFaqVO[]) descripcionesFaq.toArray(new DescripcionFaqVO[0]);	
			faq.setDescripcionFaq(descripcionesFaqArray);		
			

			logger.debug("Se introduce en la base de datos la faq");
			FaqVO faqReturn = this.getSrvFaqService().crearFaq(faq);
			form.setIdModificado(faqReturn.getId());
			//Se elimina el objeto introducido en sesion
			request.getSession().setAttribute(CATEGORIAVO, null);	
			request.getSession().setAttribute(FAQS, null);	
			
		} catch (Exception e) 
		{
			logger.error("Error al introducir la faq",e);
			throw new ValidatorException("{errors.faqs.insertar}");					
		}		
		
     }


    /**
     * @see es.pode.administracion.presentacion.faqs.crear.CrearController#validarFormulario(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.faqs.crear.ValidarFormularioForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void validarFormulario(ActionMapping mapping, es.pode.administracion.presentacion.faqs.crear.ValidarFormularioForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
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
			
			for (Enumeration names = request.getParameterNames(); names.hasMoreElements();)
			{
				String name = String.valueOf(names.nextElement());
				if (request.getParameter(name) != null && !(request.getParameter(name)).trim().equals(""))
				{
					if (name.endsWith(this.getPropertyValue("castellano")))
					{
						castellano = rellenaArrayFaq(request,name, castellano);
						castellano[0] = this.getPropertyValue("castellano");
					}
					else if (name.endsWith(this.getPropertyValue("ingles")))
					{
						ingles = rellenaArrayFaq(request,name, ingles);
						ingles[0] = this.getPropertyValue("ingles");
					}
					else if (name.endsWith(this.getPropertyValue("catalan")))
					{
						catalan = rellenaArrayFaq(request,name, catalan);
						catalan[0] = this.getPropertyValue("catalan");
					}
					else if (name.endsWith(this.getPropertyValue("euskera")))
					{
						euskera = rellenaArrayFaq(request,name, euskera);
						euskera[0] = this.getPropertyValue("euskera");
					}
					else if (name.endsWith(this.getPropertyValue("valenciano")))
					{
						valenciano = rellenaArrayFaq(request,name, valenciano);
						valenciano[0] = this.getPropertyValue("valenciano");
					}
					else if (name.endsWith(this.getPropertyValue("gallego")))
					{
						gallego = rellenaArrayFaq(request,name, gallego);
						gallego[0] = this.getPropertyValue("gallego");
					}
				}
			}
		
		CategoriaFaqVO categoriaFaq = (CategoriaFaqVO)request.getSession().getAttribute(CATEGORIAVO);
		rellenaArrayIdiomaCategoriaFaq (castellano,catalan,ingles,euskera,gallego,valenciano,categoriaFaq);
		
		logger.debug("Se valida el formulario");
		/**
		 * **************************************************************************************************************************************
		 * ************************************************ SE VALIDA EL FORMULARIO *************************************************************
		 * **************************************************************************************************************************************
		 * */
		if (!validaFormularioFaq(castellano, catalan, ingles, euskera, gallego, valenciano, request))
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
     * @see es.pode.administracion.presentacion.faqs.crear.CrearController#analizaValidacion(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.faqs.crear.AnalizaValidacionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String analizaValidacion(ActionMapping mapping, es.pode.administracion.presentacion.faqs.crear.AnalizaValidacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
//		Se comprueba si el formulario ha validado o no
    	if (logger.isDebugEnabled()) logger.debug("El resultado de la validacion del formulario es ["+form.getValido()+"]");
    	return (form.getValido());  
    }

    public void rellenaArrayIdiomaCategoriaFaq (String[] castellano,String[] catalan,String[] ingles,String[] euskera,String[] gallego,String[] valenciano,CategoriaFaqVO categoriaFaq) throws Exception
	{
		CategoriaIdiomaFaqVO[] categoriasIdiomas = categoriaFaq.getCategoriaIdioma();
		for (int i = 0; categoriasIdiomas != null && i < categoriasIdiomas.length; i++)
		{
			if (estaLleno(categoriasIdiomas[i].getNombre()))
			{
				if (this.getPropertyValue("castellano").equals(categoriasIdiomas[i].getIdioma())){
					castellano[3] = categoriasIdiomas[i].getNombre();
					castellano[0] = categoriasIdiomas[i].getIdioma();
				}
				else if (this.getPropertyValue("ingles").equals(categoriasIdiomas[i].getIdioma())) 
				{
					ingles[3] = categoriasIdiomas[i].getNombre();
					ingles[0] = categoriasIdiomas[i].getIdioma();
				}
				else if (this.getPropertyValue("catalan").equals(categoriasIdiomas[i].getIdioma())) 
				{
					catalan[3] = categoriasIdiomas[i].getNombre();
					catalan[0] = categoriasIdiomas[i].getIdioma();
				}
				else if (this.getPropertyValue("euskera").equals(categoriasIdiomas[i].getIdioma()))
				{
					euskera[3] = categoriasIdiomas[i].getNombre();
					euskera[0] = categoriasIdiomas[i].getIdioma();
				}
				else if (this.getPropertyValue("valenciano").equals(categoriasIdiomas[i].getIdioma())) 
				{
					valenciano[3] = categoriasIdiomas[i].getNombre();
					valenciano[0] = categoriasIdiomas[i].getIdioma();
				}
				else if (this.getPropertyValue("gallego").equals(categoriasIdiomas[i].getIdioma())) 
				{
					gallego[3] = categoriasIdiomas[i].getNombre();
					gallego[0] = categoriasIdiomas[i].getIdioma();
				}
			}
		}
	}

    public boolean estaLleno (String var) throws Exception
	{
		return (var != null && !"".equals(var));
	}
    
    private String getPropertyValue(String sKey) throws IOException {
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/portaladministracion.properties");
		if (this.pSpringProperties == null) {
			pSpringProperties = new java.util.Properties();
			pSpringProperties.load(fIsSpringProperties);
		}
		fIsSpringProperties.close();
		if (logger.isDebugEnabled())logger.debug("getPropertyValue: Propiedad recuperada: " + sKey + " : "+ pSpringProperties.getProperty(sKey));
//		 devolvemos la propiedad
		return pSpringProperties.getProperty(sKey);
	}
    public String[] rellenaArrayFaq (HttpServletRequest request, String name, String[] idioma) throws Exception
	{		
		if (name.startsWith(NAMEJSPTITULOFAQ))
		{
			if (logger.isDebugEnabled()) logger.debug("Se ha introducido el titulo de la faq ["+request.getParameter(name)+"]");
			idioma[1] = request.getParameter(name);
		}

	   else if (name.startsWith(NAMEJSPDESCRIPCIONFAQ))
	   {
		   if (logger.isDebugEnabled()) logger.debug("Se ha introducido el resumen de la faq ["+request.getParameter(name)+"]");
		   idioma[2] = request.getParameter(name);
		
	   }	   
	   else if (name.startsWith(NAMEJSPCATEGORIAFAQ))
	   {
		   if (logger.isDebugEnabled()) logger.debug("Se ha introducido la categoria de la faq ["+request.getParameter(name)+"]");
		   idioma[3] = request.getParameter(name);
		   idioma[4] = request.getParameter(name);
	   }
	   else if (name.startsWith(NAMEJSPPOSICIONFAQ))
	   {
		   if (logger.isDebugEnabled()) logger.debug("Se ha introducido la posicion de la faq ["+request.getParameter(name)+"]");
		   idioma[5] = request.getParameter(name);
	   }
		
		return idioma;
	}
    public ArrayList dameIdiomas (String[] castellano,String[] catalan,String[] ingles,String[] euskera,String[] gallego,String[] valenciano)throws Exception
	{		
		ArrayList idiomas = new ArrayList();
		if (estaLleno(castellano[0])) idiomas.add(castellano[0]);
		if (estaLleno(catalan[0])) idiomas.add(catalan[0]);		
		if (estaLleno(ingles[0])) idiomas.add(ingles[0]);
		if (estaLleno(euskera[0])) idiomas.add(euskera[0]);
		if (estaLleno(gallego[0])) idiomas.add(gallego[0]);
		if (estaLleno(valenciano[0])) idiomas.add(valenciano[0]);		
		return idiomas;
	}
    public ArrayList dameTitulos (String[] castellano,String[] catalan,String[] ingles,String[] euskera,String[] gallego,String[] valenciano)throws Exception
	{
		ArrayList titulos = new ArrayList();
		if (estaLleno(castellano[0])) titulos.add(castellano[1]);
		if (estaLleno(catalan[0])) titulos.add(catalan[1]);		
		if (estaLleno(ingles[0])) titulos.add(ingles[1]);
		if (estaLleno(euskera[0])) titulos.add(euskera[1]);
		if (estaLleno(gallego[0])) titulos.add(gallego[1]);
		if (estaLleno(valenciano[0])) titulos.add(valenciano[1]);
		return titulos;
	}
	
	public ArrayList dameDescripciones (String[] castellano,String[] catalan,String[] ingles,String[] euskera,String[] gallego,String[] valenciano)throws Exception
	{
		ArrayList descripciones = new ArrayList();
		if (estaLleno(castellano[0])) descripciones.add(castellano[2]);
		if (estaLleno(catalan[0])) descripciones.add(catalan[2]);		
		if (estaLleno(ingles[0])) descripciones.add(ingles[2]);
		if (estaLleno(euskera[0])) descripciones.add(euskera[2]);
		if (estaLleno(gallego[0])) descripciones.add(gallego[2]);
		if (estaLleno(valenciano[0])) descripciones.add(valenciano[2]);
		return descripciones;
	}
	
	public ArrayList dameValuePosiciones (String[] castellano,String[] catalan,String[] ingles,String[] euskera,String[] gallego,String[] valenciano)throws Exception
	{
		ArrayList posiciones = new ArrayList();
		if (estaLleno(castellano[0])) posiciones.add(castellano[5]);
		if (estaLleno(catalan[0])) posiciones.add(catalan[5]);		
		if (estaLleno(ingles[0])) posiciones.add(ingles[5]);
		if (estaLleno(euskera[0])) posiciones.add(euskera[5]);
		if (estaLleno(gallego[0])) posiciones.add(gallego[5]);
		if (estaLleno(valenciano[0])) posiciones.add(valenciano[5]);
		return posiciones;
	}
	public ArrayList dameCategorias (String[] castellano,String[] catalan,String[] ingles,String[] euskera,String[] gallego,String[] valenciano)throws Exception
	{
		ArrayList categorias = new ArrayList();
		if (estaLleno(castellano[0])) categorias.add(castellano[3]);
		if (estaLleno(catalan[0])) categorias.add(catalan[3]);		
		if (estaLleno(ingles[0])) categorias.add(ingles[3]);
		if (estaLleno(euskera[0])) categorias.add(euskera[3]);
		if (estaLleno(gallego[0])) categorias.add(gallego[3]);
		if (estaLleno(valenciano[0])) categorias.add(valenciano[3]);
		return categorias;
	}
	public ArrayList devuelveListaDescripcionesFaq (ArrayList lista, String idioma, String titulo, String descripcion, String posicion, int numFaqs) throws Exception
	{			
		DescripcionFaqVO descripcionFaqAux = new DescripcionFaqVO();
		descripcionFaqAux.setIdioma(idioma.trim());
		descripcionFaqAux.setPregunta(titulo.trim());
		descripcionFaqAux.setRespuesta(descripcion.trim());
		if (numFaqs == 0)//Es la primera
			descripcionFaqAux.setPosicion(new Integer(1));
		else if (numFaqs == 1)//Es la segunda
			descripcionFaqAux.setPosicion(new Integer(2));
		else
		{
			//Se modifica la posicion de las faqs sucesivas
			descripcionFaqAux.setPosicion(new Integer(posicion));
		}
		lista.add(descripcionFaqAux);
		return lista;
	}
	public boolean validaFormularioFaq(String[] castellano,String[] catalan,String[] ingles,String[] euskera,String[] gallego,String[] valenciano, HttpServletRequest request) throws Exception
	{
		boolean globoCastellano = true;
		boolean globoCatalan = true;
		boolean globoIngles = true;
		boolean globoEuskera = true;
		boolean globoGallego = true;
		boolean globoValenciano = true;
		boolean validaFormulario = false;
		int contadorGlobosVacios = 0;
		
		es.pode.administracion.presentacion.noticias.crear.CrearControllerImpl controllerNoticias = new es.pode.administracion.presentacion.noticias.crear.CrearControllerImpl();
		//Se valida el castellano
		logger.debug("Se valida el globo de castellano");
		if (globoVacioFaq(castellano))
		{
			//No hay datos introducidos en el globo en castellano
			logger.debug("No hay datos introducidos en el globo de castellano");
			contadorGlobosVacios++;
		}
		else
		{
			//Hay datos introducidos en el globo en castellano. Se valida el formulario
			logger.debug("Hay datos introducidos en el globo de castellano");
			String[] erroresES = validaArrayIdiomaFaq(castellano, "es");
			if (erroresES.length > 1)
			{
				globoCastellano = false;
				controllerNoticias.pintarError(erroresES, request);
			} 
		}
		
//		Se valida el gallego
		logger.debug("Se valida el globo de gallego");
		if (globoVacioFaq(gallego))
		{
			//No hay datos introducidos en el globo en gallego
			logger.debug("No hay datos introducidos en el globo de gallego");
			contadorGlobosVacios++;
		}
		else
		{
			//Hay datos introducidos en el globo en gallego. Se valida el formulario
			logger.debug("Hay datos introducidos en el globo de gallego");
			String[] erroresGL = validaArrayIdiomaFaq(gallego, "gl");
			if (erroresGL.length > 1)
			{
				globoGallego = false;
				controllerNoticias.pintarError(erroresGL, request);
			} 
		}
		
		//Se valida el catalan
		logger.debug("Se valida el globo de catalan");
		if (globoVacioFaq(catalan))
		{
			//No hay datos introducidos en el globo en castellano
			logger.debug("No hay datos introducidos en el globo de catalan");
			contadorGlobosVacios++;
		}
		else
		{
			//Hay datos introducidos en el globo en catalan. Se valida el formulario
			logger.debug("Hay datos introducidos en el globo de catalan");
			String[] erroresCA = validaArrayIdiomaFaq(catalan, "ca");
			if (erroresCA.length > 1)
			{
				globoCatalan = false;
				controllerNoticias.pintarError(erroresCA, request);
			} 
		}
		
//		Se valida el valenciano
		logger.debug("Se valida el globo de valenciano");
		if (globoVacioFaq(valenciano))
		{
			//No hay datos introducidos en el globo en valenciano
			logger.debug("No hay datos introducidos en el globo de valenciano");
			contadorGlobosVacios++;
		}
		else
		{
			//Hay datos introducidos en el globo en valenciano. Se valida el formulario
			logger.debug("Hay datos introducidos en el globo de valenciano");
			String[] erroresVA = validaArrayIdiomaFaq(valenciano, "va");
			if (erroresVA.length > 1)
			{
				globoValenciano = false;
				controllerNoticias.pintarError(erroresVA, request);
			} 
		}

		//Se valida el euskera
		logger.debug("Se valida el globo de euskera");
		if (globoVacioFaq(euskera))
		{
			//No hay datos introducidos en el globo en euskera
			logger.debug("No hay datos introducidos en el globo de euskera");
			contadorGlobosVacios++;
		}
		else
		{
			//Hay datos introducidos en el globo en euskera. Se valida el formulario
			logger.debug("Hay datos introducidos en el globo de euskera");
			String[] erroresEU = validaArrayIdiomaFaq(euskera, "eu");
			if (erroresEU.length > 1)
			{
				globoEuskera = false;
				controllerNoticias.pintarError(erroresEU, request);
			} 
		}
		
//		Se valida el ingles
		logger.debug("Se valida el globo de ingles");
		if (globoVacioFaq(ingles))
		{
			//No hay datos introducidos en el globo en ingles
			logger.debug("No hay datos introducidos en el globo de ingles");
			contadorGlobosVacios++;
		}
		else
		{
			//Hay datos introducidos en el globo en ingles. Se valida el formulario
			logger.debug("Hay datos introducidos en el globo de ingles");
			String[] erroresEN = validaArrayIdiomaFaq(ingles, "en");
			if (erroresEN.length > 1)
			{
				globoIngles = false;
				controllerNoticias.pintarError(erroresEN, request);
			} 
		}		

		//Se comprueba el numero de globos introducidos
		if (contadorGlobosVacios == 6)				
			saveErrorMessage(request, ERRORFAQFRAMEVACIO);	
		
		else		
			if (globoCastellano && globoIngles && globoCatalan && globoEuskera && globoValenciano && globoGallego)		
				validaFormulario = true;		
		
		return validaFormulario;
	}
	public boolean globoVacioFaq(String[] idioma) throws Exception
	{
		return (idioma[1] == null && idioma[2] == null && idioma[4] == null && (idioma[5] == null || "0".equals(idioma[5])));						
	}
	public String[] validaArrayIdiomaFaq (String[] arrayIdioma, String idioma) throws Exception
	{	
		es.pode.administracion.presentacion.noticias.crear.CrearControllerImpl controllerNoticias = new es.pode.administracion.presentacion.noticias.crear.CrearControllerImpl();
		ArrayList listaErrores = new ArrayList();
		listaErrores.add(controllerNoticias.devuelveClaveError(idioma));
		
		//Campo categoria
		if (arrayIdioma[3] == null)
			listaErrores.add(ERRORCATOBLIGATORIO);
		else
		{
			if (arrayIdioma[3].trim().length() > MAXTAMCATEGORIA)
				listaErrores.add(ERRORCATEGORIAMAXTAMANO);
		}
		
		//Campo titulo
		if (arrayIdioma[1] == null)		
			listaErrores.add(ERRORTITULOOBLIGATORIO);		
		else
		{
			if (arrayIdioma[1].trim().length() > DOSCIENTOSCINCUENTA)			
				//Se comprueba el tamanho de titulo
				listaErrores.add(ERRORMAXTITULOFAQ);
			
			//Se comprueban las caracteres del titulo de la fa
			Pattern mask = Pattern.compile("[^\\>\\#\\&\\<]+");
	    	Matcher matcher = mask.matcher(arrayIdioma[1]);
	    	if(!matcher.matches())	    	
	    		listaErrores.add(ERRORFAQCARACTERILEGAL);
	    	
		}

		//descripcion
		if (arrayIdioma[2] == null)		
			listaErrores.add(ERRORDESCRIPCIONOBLIGATORIO);		
		else
		{
			if (arrayIdioma[2].trim().length() > CUATROMIL)			
//				Se comprueba el tamanho de descripcion
				listaErrores.add(ERRORMAXDESCRIPCION);
			
		}	
		
		//Posicion
		if ("0".equals(arrayIdioma[5]))
			listaErrores.add(ERRORPOSICIONOBLIGATORIO);
		
		return (String[])listaErrores.toArray(new String[0]);
	}	
	
	public String[] dameFaqsIdiomaPosicion (FaqTraducidaIdiomaVO[] faqs, String idioma) throws Exception
	{
		ArrayList faqsIdiomasPosicion = new ArrayList();
		for (int i = 0; faqs != null && i < faqs.length; i++)
		{
			if (idioma.equals(faqs[i].getIdioma()))
				faqsIdiomasPosicion.add(faqs[i].getPregunta());				
		}
		return (String[])faqsIdiomasPosicion.toArray(new String[0]);
		
	}

	
	public boolean esObligatorio (String error) throws Exception
	{
		boolean encontrado = false;
		String[] erroresObligatorios = this.getPropertyValue("errores.noticia.campos.obligatorios").split(COMA);
		for (int i = 0; !encontrado && i < erroresObligatorios.length; i++)
			if (erroresObligatorios[i].equals(error)) encontrado = true;
		return encontrado;
	}

}