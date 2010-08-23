/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.categoriasFaqs.modificarCategoriaFaq;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.administracion.presentacion.categorias.crearCategoriaNoticia.CrearCategoriaNoticiaControllerImpl;
import es.pode.administracion.presentacion.noticias.crear.CrearControllerImpl;
import es.pode.contenidos.negocio.faqs.servicio.CategoriaFaqVO;
import es.pode.contenidos.negocio.faqs.servicio.CategoriaIdiomaFaqVO;
import es.pode.contenidos.negocio.faqs.servicio.FaqTraducidaVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.administracion.presentacion.categoriasFaqs.modificarCategoriaFaq.ModificarCategoriaFaqController
 */
public class ModificarCategoriaFaqControllerImpl extends ModificarCategoriaFaqController
{

	private static Logger logger = Logger.getLogger(ModificarCategoriaFaqControllerImpl.class);
	private java.util.Properties pSpringProperties = null;
	
	private static final String NAMEJSP = "categoriaFaq";
	
	private final static String CATEGORIAFAQVO = "categoriaFaqvo";
	
	private static final String TRUE = "TRUE";
	private static final String FALSE = "FALSE";
	
	private static final String ERRORCATEGORIAVACIA = "error.noticia.campo.vacio";
	private static final String ERRORCATEGORIAMAXTAMANHO = "error.categorias.tamanho";
	private static final String ERRORFAQRELACIONADA = "error.categorias.faq.relacionada";	
	
	private static final int MAXTAMCATEGORIA = 50;

	private static final String ERRORMODIFICARCATEGORIAID = "errors.modificarCategoria.identificador";


    /**
     * @see es.pode.administracion.presentacion.categoriasFaqs.modificarCategoriaFaq.ModificarCategoriaFaqController#recuperarDatos(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.categoriasFaqs.modificarCategoriaFaq.RecuperarDatosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperarDatos(ActionMapping mapping, es.pode.administracion.presentacion.categoriasFaqs.modificarCategoriaFaq.RecuperarDatosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try
    	{
    		/**
    		 * **************************************************************************************************************************************
    		 * **************************************** SE RECUPERA LA CATEGORIA A MODIFICAR *********************************************************
    		 * **************************************************************************************************************************************
    		 * */
    		if (form.getNombreCategoria() == null || "".equals(form.getNombreCategoria()))
    		{
		    	ArrayList nombreCategoria = new ArrayList();
		    	ArrayList idiomas = new ArrayList();
		    	
		    	if (logger.isDebugEnabled()) logger.debug("Se obtiene la categoria con identificador ["+form.getId()+"]"); 
		    	CategoriaFaqVO categoriaFaq = this.getSrvFaqService().obtenerCategoria(form.getId());	   
		    	request.getSession().setAttribute(CATEGORIAFAQVO, categoriaFaq);    		
		    	
		//    	Se almacena los datos. Las categorias con todas sus traducciones
		    	if (categoriaFaq != null)
		    	{
//		    		Se obtienen las traducciones de la categoria
		    		if (logger.isDebugEnabled()) logger.debug("Se obtienen las traducciones de la categoria ["+categoriaFaq.getNombre()+"]");
		    		CategoriaIdiomaFaqVO[] categoriasIdiomas = categoriaFaq.getCategoriaIdioma();		    		
		    		for (int i = 0; categoriasIdiomas != null && i < categoriasIdiomas.length; i++)
		    		{
		    			if (categoriasIdiomas[i].getNombre() != null && !("").equals(categoriasIdiomas[i].getNombre()))
		    			{
		    				nombreCategoria.add(categoriasIdiomas[i].getNombre().trim());
		    				idiomas.add(categoriasIdiomas[i].getIdioma().trim());
		    			}    			
		    		}
		    	}     	
		    	form.setIdiomas(idiomas);
		    	form.setNombreCategoria(nombreCategoria);
    		}
	    	
    	} catch (Exception e)
    	{
    		logger.error("Error recuperando el identificador de la categoria a modificar");
    		saveErrorMessage(request, ERRORMODIFICARCATEGORIAID);
    	}
     }

    /**
     * @see es.pode.administracion.presentacion.categoriasFaqs.modificarCategoriaFaq.ModificarCategoriaFaqController#modificarCategoriaFaq(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.categoriasFaqs.modificarCategoriaFaq.ModificarCategoriaFaqForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void modificarCategoriaFaq(ActionMapping mapping, es.pode.administracion.presentacion.categoriasFaqs.modificarCategoriaFaq.ModificarCategoriaFaqForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {  
		ArrayList categorias = (ArrayList)form.getNombreCategoria();
		ArrayList idiomas = (ArrayList)form.getIdiomas();
		
		logger.debug("Se modifica la categoria");
		try
		{
			/**
			 * **************************************************************************************************************************************
			 * ************************************************ SE MODIFICA LA CATEGORIA *************************************************************
			 * **************************************************************************************************************************************
			 * */
					
			if (categorias != null && categorias.size() > 0)
			{
				CrearCategoriaNoticiaControllerImpl categoriasNoti = new CrearCategoriaNoticiaControllerImpl();
//				Se obtienen solo las categorias que estan rellenas
				ArrayList listaConTexto = categoriasNoti.devuelveListaConTexto(categorias, idiomas);
				String[] listaCategorias = (String[])listaConTexto.get(0);
				String[] listaIdiomas = (String[])listaConTexto.get(1);
				
	//			Introducimos las categorias idiomas
				CategoriaFaqVO categoriaFaq = new CategoriaFaqVO();
				CategoriaIdiomaFaqVO[] categoriaIdiomaFaq = new CategoriaIdiomaFaqVO[listaCategorias.length];								
				
				for (int i = 0; i < listaCategorias.length; i++)
				{
					CategoriaIdiomaFaqVO categoriaIdiomaFaqAux = new CategoriaIdiomaFaqVO();
						categoriaIdiomaFaqAux.setIdioma(listaIdiomas[i]);
						categoriaIdiomaFaqAux.setNombre(listaCategorias[i]);	
						categoriaIdiomaFaq[i] = categoriaIdiomaFaqAux;
				}
				
//				Se introducen en el vo de la faq a modificar los datos de la categoria que no han sido modificados. Se obtienen de la request
				CategoriaFaqVO categoriaRequest = (CategoriaFaqVO)request.getSession().getAttribute(CATEGORIAFAQVO);
				categoriaFaq.setFechaAlta(categoriaRequest.getFechaAlta());
				categoriaFaq.setCategoriaIdioma(categoriaIdiomaFaq);				
				categoriaFaq.setId(form.getId());
				categoriaFaq.setNombre(categoriaRequest.getNombre());							
				
				this.getSrvFaqService().limpiarCategoria(form.getId());				
				
				logger.debug("Se modifica en la base de datos la categoria");	
				this.getSrvFaqService().modificarCategoria(categoriaFaq);
				form.setIdModificado(form.getId());
				//Se elimina de la request la categoria
				request.getSession().setAttribute(CATEGORIAFAQVO, null);
			}
		
		} catch (Exception e) 
		{
			logger.error("Error modificando la categoria faq",e);
			throw new ValidatorException("{error.modificando.categoria}");				
		}		
		
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

	public String analizaValidacion(ActionMapping mapping, AnalizaValidacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
//		Se comprueba si el formulario ha validado o no
    	if (logger.isDebugEnabled()) logger.debug("El resultado de la validacion del formulario es ["+form.getValido()+"]");
    	return (form.getValido());  
	}

	public void validarFormulario(ActionMapping mapping, ValidarFormularioForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		logger.debug("Se recoge los parametros del formulario");
		
		/**
		 * **************************************************************************************************************************************
		 * **************************************** SE RECOGE LOS PARAMETROS DEL FORMULARIO *****************************************************
		 * **************************************************************************************************************************************
		 * */
			
		ArrayList listaCategorias = new ArrayList();
		ArrayList listaIdiomas = new ArrayList();
		for (Enumeration names = request.getParameterNames(); names.hasMoreElements();)
		{
			String name = String.valueOf(names.nextElement());
			if (logger.isDebugEnabled()) logger.debug("El name recogido de la request es ["+name+"]");
			if (name.startsWith(NAMEJSP))
			{
			if (request.getParameter(name) != null && !request.getParameter(name).equals(""))
			{
				listaCategorias.add(request.getParameter(name)); 
				
		         if(name.endsWith(this.getPropertyValue("castellano")))
		         {
	//	        	 Castellano
		        	 if (logger.isDebugEnabled()) logger.debug("Se ha modificado la categoria con idioma["+this.getPropertyValue("castellano")+"] y nombre["+request.getParameter(name)+"]"); 
		        	 listaIdiomas.add(this.getPropertyValue("castellano"));
	          	 }	
		         else if (name.endsWith(this.getPropertyValue("ingles")))
		         {
	//	        	 Ingles
		        	 if (logger.isDebugEnabled()) logger.debug("Se ha modificado la categoria con idioma["+this.getPropertyValue("ingles")+"] y nombre["+request.getParameter(name)+"]");  
		        	 listaIdiomas.add(this.getPropertyValue("ingles"));
				 }
		         else if (name.endsWith(this.getPropertyValue("catalan")))
		         {
	//	        	 Catalan
		        	 if (logger.isDebugEnabled()) logger.debug("Se ha modificado la categoria con idioma["+this.getPropertyValue("catalan")+"] y nombre["+request.getParameter(name)+"]");  
		        	listaIdiomas.add(this.getPropertyValue("catalan"));
				 }
		         else if (name.endsWith(this.getPropertyValue("euskera")))
		         {
	//	        	 Euskera
		        	 if (logger.isDebugEnabled()) logger.debug("Se ha modificado la categoria con idioma["+this.getPropertyValue("euskera")+"] y nombre["+request.getParameter(name)+"]");  
		        	listaIdiomas.add(this.getPropertyValue("euskera"));
				 }
		         else if (name.endsWith(this.getPropertyValue("valenciano")))
		         {
	//	        	 Valenciano
		        	 if (logger.isDebugEnabled()) logger.debug("Se ha modificado la categoria con idioma["+this.getPropertyValue("valenciano")+"] y nombre["+request.getParameter(name)+"]");  
		        	listaIdiomas.add(this.getPropertyValue("valenciano"));
				 }
		         else if (name.endsWith(this.getPropertyValue("gallego")))
		         {
	//	        	 Gallego
		        	 if (logger.isDebugEnabled()) logger.debug("Se ha modificado la categoria con idioma["+this.getPropertyValue("gallego")+"] y nombre["+request.getParameter(name)+"]");  
		        	listaIdiomas.add(this.getPropertyValue("gallego"));
				 }	
			}
	       }
		}
		if (logger.isDebugEnabled()) logger.debug("Se han modificado ["+listaCategorias.size()+"] categorias faqs");
		
		logger.debug("Se valida el formulario");
		/**
		 * **************************************************************************************************************************************
		 * ************************************************ SE VALIDA EL FORMULARIO *************************************************************
		 * **************************************************************************************************************************************
		 * */
		
		CrearCategoriaNoticiaControllerImpl controllerCategorias = new CrearCategoriaNoticiaControllerImpl(); 
		
//		Se ordena los array: Castellano, gallego, catalan, valenciano, euskera, ingles
		ArrayList listaOrdenada = controllerCategorias.devuelveArraysOrdenados((String[])listaIdiomas.toArray(new String[0]), (String[])listaCategorias.toArray(new String[0]));
		listaCategorias = (ArrayList)listaOrdenada.get(0);
		listaIdiomas = (ArrayList)listaOrdenada.get(1);
		
		if (validaForm((String[])listaCategorias.toArray(new String[0]), (String[])listaIdiomas.toArray(new String[0]), request, form.getId()))
		{
			logger.debug("El formulario ha validado correctamente");
			form.setValido(TRUE);
		}
		else
		{
			logger.debug("El formulario no ha validado");
			form.setValido(FALSE);
		}
		form.setNombreCategoria(listaCategorias);
		form.setIdiomas(listaIdiomas);	
		
	}
	
	/**
     * Metodo que valida el formulario
     * Los errores son individualizados a cada globo de idioma
     * Los posibles errores son los siguientes:
     * - No hay ninguna categoria rellena
     * 		1 Vacia
     * 		2 Solo con espacios en blanco
     * - El tamaño de la categoria supera el limite permitido
     * - La categoria que se intenta crear ya existe
     * - Se intenta eliminar una traduccion de categoria que lleva asociada una faq
     * 
     * Se retorna true o false dependiendo si el formulario ha validado o no
     * */
	private boolean validaForm (String[] categorias, String[] idiomas, HttpServletRequest request, Long idModificada) throws Exception
    {
		CrearCategoriaNoticiaControllerImpl controllerCategorias = new CrearCategoriaNoticiaControllerImpl(); 
    	boolean valido = true;
    	if (categorias == null || categorias.length == 0)
    	{
    		logger.debug("El formulario esta vacio");
    		saveErrorMessage(request, ERRORCATEGORIAVACIA);
//    		Se indica que el formulario es incorrecto
    		valido = false;
    	}
    	else
    	{
    		logger.debug("El formulario esta relleno");
    		if (!controllerCategorias.comprobarTextoLleno(categorias)){
    			logger.debug("Las categorias tienen solo espacios en blanco");
    			saveErrorMessage(request, ERRORCATEGORIAVACIA);
//        		Se indica que el formulario es incorrecto
    			valido = false;
    		}
    		else{    			
    			
    			logger.debug("Las categorias estan rellenas con texto");
    			CrearControllerImpl controller = new CrearControllerImpl();
    			
//    			Se recuperan las categorias de la request
    			CategoriaFaqVO categoriaRequest = (CategoriaFaqVO)request.getSession().getAttribute(CATEGORIAFAQVO);	
    			CategoriaIdiomaFaqVO[] categoriasIdiomas = categoriaRequest.getCategoriaIdioma();
    			String[] idiomasRequest = dameCategoriasIdiomasRequest(categoriasIdiomas);    			
	    		
//    			Se obtiene los idiomas en los que se ha traducido la categoria
	    		for (int r = 0; r < idiomasRequest.length; r++)
	    		{
	    			boolean encontradoIdioma = false;
	    			for (int h = 0; !encontradoIdioma && h < idiomas.length; h++)
	    			{
	    				if (idiomasRequest[r].equals(idiomas[h]))	    				    					
	    					encontradoIdioma = true;	    				  				
	    			}
	    			if (!encontradoIdioma)
	    			{
//	    				Se ha eliminado alguna categoria
    					//Se comprueba si tiene alguna faq seleccionada
    					logger.debug("Se ha eliminado alguna categoria, se comprueba si tiene alguna faq seleccionada");	    					
    					FaqTraducidaVO[] faqTrad = this.getSrvFaqService().obtenerFaqsFromIdCategoria(categoriaRequest.getId(), new String[]{idiomasRequest[r]});
    					if (faqTrad != null && faqTrad.length > 0)
    					{
    						//Se comprueba si estaba ese idioma en las faq de BBDD
    						if (estaIdiomaBBDD(faqTrad, idiomasRequest[r])){
	    						logger.debug("Tenia alguna faq relacionada");
	    						String[] error = new String[1];
	    	    				error[0] = controller.dameStringBandera(controller.devuelveClaveError(idiomasRequest[r]), request); 
	    	    				saveErrorMessage(request, ERRORFAQRELACIONADA, error);
	    	    				valido = false;
    						}    						
    					}
	    			}
	    		}    			
	    		
	    		if (valido)
	    		{
//	    			Se crea un array de string con el mismo tamaño que categorias hay. Cada posicion de este vector indicara una por una si la categoria es correcta
		    		String[] validaArray = new String[categorias.length];	    			    			    		
		    		
		    		for (int i = 0; i < categorias.length; i++)
		    		{
		    			if (categorias[i].trim().length() > MAXTAMCATEGORIA)
		    			{  
		    				if (logger.isDebugEnabled()) logger.debug("La categoria ["+categorias[i]+"] excede el numero de caracteres permitido. Se crea el error");
		    				String[] error = new String[1];
		    				error[0] = controller.dameStringBandera(controller.devuelveClaveError(idiomas[i]), request); 				    				
		    				saveErrorMessage(request, ERRORCATEGORIAMAXTAMANHO, error);
//		    				Se indica que esta categoria no es correcta
		    				validaArray[i] = "false";
		    			} 	
		    			else
		    			{
		    				//Se comprueba si la categoria esta duplicada
		    				if (estaCategoriaDuplicada(categorias[i], idModificada))
		    				{
		    					if (logger.isDebugEnabled()) logger.debug("La categoria ["+categorias[i]+"] esta duplicada. Se crea el error");
		    					String[] error = new String[1];
			    				error[0] = controller.dameStringBandera(controller.devuelveClaveError(idiomas[i]), request); 				    				
			    				saveErrorMessage(request, controllerCategorias.ERRORCATEGORIADUPLICADA, error);
			    				validaArray[i] = "false";
		    				}
		    			}
		    			
		    		}
		    		boolean encontrado = false;
//		    		Se recorre el array de la validacion de las categorias. Si una de ellas no es correcta el formulario sera incorrecto
		    		for (int j = 0; !encontrado && j < validaArray.length; j++)    		
		    			if ("false".equals(validaArray[j])) encontrado = true;
		    		
		    		valido = !encontrado;
	    		}
    		}
    	}   
    	if (logger.isDebugEnabled()) logger.debug("El resultado de la validacion del formulario ha sido ["+valido+"]");		
    	return valido;
    }
	
	/**
	 * Metodo que comprueba si la categoria esta duplicada.
	 * */
	private boolean estaCategoriaDuplicada(String categoriaACrear, Long idModificada) throws Exception
	{	
		try{
			CrearCategoriaNoticiaControllerImpl controllerCategorias = new CrearCategoriaNoticiaControllerImpl();
	//		Se comprueba si la categoria esta duplicada
			boolean encontrado = false;
			String categoriaACrearSinAcentos = controllerCategorias.removeAccents(categoriaACrear);	
//			Se obtienen las categorias que ya existen en la base de datos
			CategoriaFaqVO[] categoriasFaqsBBDD = this.getSrvFaqService().obtenerCategorias();
			if (logger.isDebugEnabled()) logger.debug("El numero de categorias introducidas en la BBDD es ["+categoriasFaqsBBDD.length+"]");
//			Se obtiene la categoria que se quiere modificar
			CategoriaFaqVO categoriaModificada = this.getSrvFaqService().obtenerCategoria(idModificada);
			for (int i = 0; categoriasFaqsBBDD != null && !encontrado && i < categoriasFaqsBBDD.length; i++)
			{
//				Se obtienen las traducciones de las categorias que ya existen en la base de datos
				CategoriaIdiomaFaqVO[] categoriasIdiomas = categoriasFaqsBBDD[i].getCategoriaIdioma();
//				Se obtienen las traducciones de la categoria que se quiere modificar
				CategoriaIdiomaFaqVO[] categoriasIdiomasBBDD = categoriaModificada.getCategoriaIdioma();
				for (int j = 0;categoriasIdiomas != null && !encontrado && j < categoriasIdiomas.length; j++)
				{
//					Se va a buscar en todas las traducciones de las categorias excepto en las propias de esa categoria.
					if (!esCategoriaAModificar(categoriasIdiomasBBDD, categoriaACrearSinAcentos))
					{
//						Se obtiene la categoria que hay en base de datos sin acentos
						String categoriaSinAcentos = controllerCategorias.removeAccents(categoriasIdiomas[j].getNombre());
//						Se comprueba en minusculas la categoria de BBDD y la que se pretende crear
						if ((categoriaACrearSinAcentos.toLowerCase()).equals((categoriaSinAcentos.toLowerCase()))) encontrado = true;
					}
				}
			}
			return encontrado;
		} catch (Exception e)
		{
			logger.error("Error al comprobar si la categoria esta duplicada");
			return false;
		}
	}
	
	/**
	 * Metodo que comprueba si el nombre de la categoria que se quiere introducir es uno de los nombre de las
	 * traducciones que existen en BBDD de la categoria 
	 * */
	private boolean esCategoriaAModificar (CategoriaIdiomaFaqVO[] categoriasIdiomasBBDD, String categoriaModificar) throws Exception
	{
		CrearCategoriaNoticiaControllerImpl controllerCategorias = new CrearCategoriaNoticiaControllerImpl();
		boolean encontrada = false;
		for (int i = 0; !encontrada && categoriasIdiomasBBDD != null && i < categoriasIdiomasBBDD.length; i++)
		{
			String categoriaSinAcentos = controllerCategorias.removeAccents(categoriasIdiomasBBDD[i].getNombre());
			if ((categoriaModificar.toLowerCase()).equals((categoriaSinAcentos.toLowerCase()))) encontrada = true;
		}
		return encontrada;
	}
	
	/** 
	 * Metodo que devuelve los idiomas en los que esta traducida la categoria
	 * */
	private String[] dameCategoriasIdiomasRequest (CategoriaIdiomaFaqVO[] categoriasIdiomas) throws Exception
	{		
		ArrayList listaIdiomas = new ArrayList();
		for (int i = 0; i < categoriasIdiomas.length; i++)
		{			
			listaIdiomas.add(((String)categoriasIdiomas[i].getIdioma()).trim());
		}
		
		
		return (String[])listaIdiomas.toArray(new String[0]);
	}
	
	/**
	 * Metodo que comprueba si un idioma (parametro de entrada) esta en los idiomas en los que esta traducida las faqs.
	 * Se utiliza para comprobar si la traduccion de la categoria tienen asociado una faq en ese mismo idioma
	 * */
	private boolean estaIdiomaBBDD (FaqTraducidaVO[] faqs, String idioma) throws Exception
	{
		boolean encontrado = false;
		for (int i = 0; !encontrado && i < faqs.length; i++)
		{
			String[] idiomasBBDD = faqs[i].getIdiomas().split(",");
			for (int j = 0; !encontrado && j < idiomasBBDD.length; j++)
			{
				if (idioma.equals(idiomasBBDD[j])) encontrado = true;
			}			
		}
		return encontrado;
	}


}