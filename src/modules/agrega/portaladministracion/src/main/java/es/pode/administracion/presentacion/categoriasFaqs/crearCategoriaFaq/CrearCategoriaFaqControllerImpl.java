/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.categoriasFaqs.crearCategoriaFaq;

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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @see es.pode.administracion.presentacion.categoriasFaqs.crearCategoriaFaq.CrearCategoriaFaqController
 */
public class CrearCategoriaFaqControllerImpl extends CrearCategoriaFaqController
{


	private static Logger logger = Logger.getLogger(CrearCategoriaFaqControllerImpl.class);
	
	private java.util.Properties pSpringProperties = null;	
	private static final String NAMEJSP = "categoriaFaq";
	
	public static final String FICHERO = "application-resources";
	
	private static final String TRUE = "TRUE";
	private static final String FALSE = "FALSE";	


    /**
     * @see es.pode.administracion.presentacion.categoriasFaqs.crearCategoriaFaq.CrearCategoriaFaqController#guardarCategoriaFaq(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.categoriasFaqs.crearCategoriaFaq.GuardarCategoriaFaqForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void guardarCategoriaFaq(ActionMapping mapping, es.pode.administracion.presentacion.categoriasFaqs.crearCategoriaFaq.GuardarCategoriaFaqForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {   	
		
			
	try
	{
		ArrayList categorias = (ArrayList)form.getNombreCategoria();
		ArrayList idiomas = (ArrayList)form.getIdiomas();
		logger.debug("Se crea la categoria");
		/**
		 * **************************************************************************************************************************************
		 * ************************************************ SE INSERTA LA CATEGORIA *************************************************************
		 * **************************************************************************************************************************************
		 * */
	
		if (categorias != null && categorias.size() > 0)
		{
			CrearCategoriaNoticiaControllerImpl categoriasNoti = new CrearCategoriaNoticiaControllerImpl();
			ArrayList listaConTexto = categoriasNoti.devuelveListaConTexto(categorias, idiomas);
			String[] listaCategorias = (String[])listaConTexto.get(0);
			String[] listaIdiomas = (String[])listaConTexto.get(1);
			
//			Introducimos las categorias idiomas
			CategoriaFaqVO categoriaFaq = new CategoriaFaqVO();						
			
			CategoriaIdiomaFaqVO[] categoriaIdiomaFaq = new CategoriaIdiomaFaqVO[listaCategorias.length];
			categoriaFaq.setNombre((String)listaCategorias[0]);		
			
			for (int i = 0; i < listaCategorias.length; i++)
			{
				CategoriaIdiomaFaqVO categoriaIdiomaFaqAux = new CategoriaIdiomaFaqVO();
				categoriaIdiomaFaqAux.setIdioma(listaIdiomas[i].trim());
				categoriaIdiomaFaqAux.setNombre(listaCategorias[i].trim());	
				categoriaIdiomaFaq[i] = categoriaIdiomaFaqAux;
			}
			categoriaFaq.setCategoriaIdioma(categoriaIdiomaFaq);			
			
			logger.debug("Se introduce en la base de datos la categoria");	
			Long id = this.getSrvFaqService().crearCategoria(categoriaFaq);		
			if (logger.isDebugEnabled()) logger.debug("Se ha creado la categoria de la faq con id ["+id+"]");
			form.setIdModificado(id);
			
		}
	
	} catch (Exception e) 
	{
		logger.error("Error insertando la categoria faq",e);
		throw new ValidatorException("{error.insertando.categoria}");				
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

	public void recuperarDatos(ActionMapping mapping, RecuperarDatosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
//		Se comprueba los datos que vienen del formulario		
		if (logger.isDebugEnabled()) logger.debug("El valor de nombreCategoria es ["+form.getNombreCategoria()+"] e idiomas es ["+form.getIdiomas()+"]");
		
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
		        	 if (logger.isDebugEnabled()) logger.debug("Se ha introducido la categoria con idioma["+this.getPropertyValue("castellano")+"] y nombre["+request.getParameter(name)+"]"); 
		        	 listaIdiomas.add(this.getPropertyValue("castellano"));
	          	 }	
		         else if (name.endsWith(this.getPropertyValue("ingles")))
		         {
	//	        	 Ingles
		        	 if (logger.isDebugEnabled()) logger.debug("Se ha introducido la categoria con idioma["+this.getPropertyValue("ingles")+"] y nombre["+request.getParameter(name)+"]");  
		        	 listaIdiomas.add(this.getPropertyValue("ingles"));
				 }
		         else if (name.endsWith(this.getPropertyValue("catalan")))
		         {
	//	        	 Catalan
		        	 if (logger.isDebugEnabled()) logger.debug("Se ha introducido la categoria con idioma["+this.getPropertyValue("catalan")+"] y nombre["+request.getParameter(name)+"]");  
		        	listaIdiomas.add(this.getPropertyValue("catalan"));
				 }
		         else if (name.endsWith(this.getPropertyValue("euskera")))
		         {
	//	        	 Euskera
		        	 if (logger.isDebugEnabled()) logger.debug("Se ha introducido la categoria con idioma["+this.getPropertyValue("euskera")+"] y nombre["+request.getParameter(name)+"]");  
		        	listaIdiomas.add(this.getPropertyValue("euskera"));
				 }
		         else if (name.endsWith(this.getPropertyValue("valenciano")))
		         {
	//	        	 Valenciano
		        	 if (logger.isDebugEnabled()) logger.debug("Se ha introducido la categoria con idioma["+this.getPropertyValue("valenciano")+"] y nombre["+request.getParameter(name)+"]");  
		        	listaIdiomas.add(this.getPropertyValue("valenciano"));
				 }
		         else if (name.endsWith(this.getPropertyValue("gallego")))
		         {
	//	        	 Gallego
		        	 if (logger.isDebugEnabled()) logger.debug("Se ha introducido la categoria con idioma["+this.getPropertyValue("gallego")+"] y nombre["+request.getParameter(name)+"]");  
		        	listaIdiomas.add(this.getPropertyValue("gallego"));
				 }	
			}
	       }
		}
		if (logger.isDebugEnabled()) logger.debug("Se han introducido ["+listaCategorias.size()+"] categorias faqs");
		
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
		
		if (validaForm((String[])listaCategorias.toArray(new String[0]), (String[])listaIdiomas.toArray(new String[0]), request))
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
     * 
     * Se retorna true o false dependiendo si el formulario ha validado o no
     * */
	private boolean validaForm (String[] categorias, String[] idiomas, HttpServletRequest request) throws Exception
    {
		CrearCategoriaNoticiaControllerImpl controllerCategorias = new CrearCategoriaNoticiaControllerImpl(); 
    	boolean valido = true;
    	if (categorias == null || categorias.length == 0)
    	{
    		logger.debug("El formulario esta vacio");
    		saveErrorMessage(request, controllerCategorias.ERRORCATEGORIAVACIA);
//    		Se indica que el formulario es incorrecto
    		valido = false;
    	}
    	else
    	{
    		logger.debug("El formulario esta relleno");
    		if (!controllerCategorias.comprobarTextoLleno(categorias)){
    			logger.debug("Las categorias tienen solo espacios en blanco");
    			saveErrorMessage(request, controllerCategorias.ERRORCATEGORIAVACIA);
//        		Se indica que el formulario es incorrecto
    			valido = false;
    		}
    		else{
    			logger.debug("Las categorias estan rellenas con texto");
	    		CrearControllerImpl controller = new CrearControllerImpl();
//	    		Se crea un array de string con el mismo tamaño que categorias hay. Cada posicion de este vector indicara una por una si la categoria es correcta
	    		String[] validaArray = new String[categorias.length];
	    		for (int i = 0; i < categorias.length; i++)
	    		{
	    			if (categorias[i].trim().length() > controllerCategorias.MAXTAMCATEGORIA)
	    			{  
	    				if (logger.isDebugEnabled()) logger.debug("La categoria ["+categorias[i]+"] excede el numero de caracteres permitido. Se crea el error");
	    				String[] error = new String[1];
	    				error[0] = controller.dameStringBandera(controller.devuelveClaveError(idiomas[i]), request); 				    				
	    				saveErrorMessage(request, controllerCategorias.ERRORCATEGORIAMAXTAMANHO, error);
//	    				Se indica que esta categoria no es correcta
	    				validaArray[i] = "false";
	    			}
	    			else
	    			{
	    				//Se comprueba si la categoria esta duplicada
	    				if (estaCategoriaDuplicada(categorias[i]))
	    				{
	    					if (logger.isDebugEnabled()) logger.debug("La categoria ["+categorias[i]+"] esta duplicada. Se crea el error");
	    					String[] error = new String[1];
		    				error[0] = controller.dameStringBandera(controller.devuelveClaveError(idiomas[i]), request); 				    				
		    				saveErrorMessage(request, controllerCategorias.ERRORCATEGORIADUPLICADA, error);
//		    				Se indica que esta categoria no es correcta
		    				validaArray[i] = "false";
	    				}
	    			}
	    		}
	    		boolean encontrado = false;
//	    		Se recorre el array de la validacion de las categorias. Si una de ellas no es correcta el formulario sera incorrecto
	    		for (int j = 0; !encontrado && j < validaArray.length; j++)    		
	    			if ("false".equals(validaArray[j])) encontrado = true;
	    		
	    		valido = !encontrado;
    		}
    	}   
    	if (logger.isDebugEnabled()) logger.debug("El resultado de la validacion del formulario ha sido ["+valido+"]");
    	return valido;
    }
	
	/**
	 * Metodo que comprueba si la categoria esta duplicada.
	 * */
	private boolean estaCategoriaDuplicada(String categoriaACrear) throws Exception
	{
		try{
			CrearCategoriaNoticiaControllerImpl controllerCategorias = new CrearCategoriaNoticiaControllerImpl();
	//		Se comprueba si la categoria esta duplicada
			boolean encontrado = false;
//			La categoria que quiere crear se le elimina los acentos
			String categoriaACrearSinAcentos = controllerCategorias.removeAccents(categoriaACrear);	
//			Se obtienen las categorias que ya existen en la base de datos
			CategoriaFaqVO[] categoriasFaqsBBDD = this.getSrvFaqService().obtenerCategorias();	
			if (logger.isDebugEnabled()) logger.debug("El numero de categorias introducidas en la BBDD es ["+categoriasFaqsBBDD.length+"]");
			for (int i = 0; categoriasFaqsBBDD != null && !encontrado && i < categoriasFaqsBBDD.length; i++)
			{
//				Se obtienen las traducciones de las categorias que ya existen en la base de datos
				CategoriaIdiomaFaqVO[] categoriasIdiomas = categoriasFaqsBBDD[i].getCategoriaIdioma();
				if (logger.isDebugEnabled()) logger.debug("El numero de traducciones de la categoria ["+categoriasFaqsBBDD[i].getNombre()+"] es ["+categoriasIdiomas.length+"]");
				for (int j = 0;categoriasIdiomas != null && !encontrado && j < categoriasIdiomas.length; j++)
				{
//					Se obtiene la categoria que hay en base de datos sin acentos
					String categoriaSinAcentos = controllerCategorias.removeAccents(categoriasIdiomas[j].getNombre());	
//					Se comprueba en minusculas la categoria de BBDD y la que se pretende crear	
					if ((categoriaACrearSinAcentos.toLowerCase()).equals((categoriaSinAcentos.toLowerCase()))) encontrado = true;
				}
			}
			return encontrado;
		} catch (Exception e)
		{
			logger.error("Error al comprobar si la categoria esta duplicada");
			return false;
		}
	}
}