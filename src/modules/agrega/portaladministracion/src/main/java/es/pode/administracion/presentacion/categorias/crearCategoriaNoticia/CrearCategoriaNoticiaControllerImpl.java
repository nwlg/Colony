/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.categorias.crearCategoriaNoticia;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.administracion.presentacion.noticias.crear.CrearControllerImpl;
import es.pode.contenidos.negocio.noticias.servicio.CategoriaIdiomaNoticiaVO;
import es.pode.contenidos.negocio.noticias.servicio.CategoriaNoticiaVO;


/**
 * @see es.pode.administracion.presentacion.categorias.crearCategoriaNoticia.CrearCategoriaNoticiaController
 */
public class CrearCategoriaNoticiaControllerImpl extends CrearCategoriaNoticiaController
{


	private static Logger logger = Logger.getLogger(CrearCategoriaNoticiaControllerImpl.class);
	private java.util.Properties pSpringProperties = null;
	
	public static final String ERRORCATEGORIAVACIA = "error.noticia.campo.vacio";
	public static final String ERRORCATEGORIAMAXTAMANHO = "error.categorias.tamanho";
	
	public static final String FICHERO = "application-resources";
	
	private static final String TRUE = "TRUE";
	private static final String FALSE = "FALSE";
	
	private static final String NAMEJSP = "categoriaNoticia";	
	
	public static final String ERRORCATEGORIADUPLICADA = "error.categorias.duplicada";
	
	public static final int MAXTAMCATEGORIA = 50;



    /**
     * @see es.pode.administracion.presentacion.categorias.crearCategoriaNoticia.CrearCategoriaNoticiaController#guardarCategoriaNoticia(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.categorias.crearCategoriaNoticia.GuardarCategoriaNoticiaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void guardarCategoriaNoticia(ActionMapping mapping, es.pode.administracion.presentacion.categorias.crearCategoriaNoticia.GuardarCategoriaNoticiaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
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
				ArrayList listaConTexto = devuelveListaConTexto(categorias, idiomas);
				String[] listaCategorias = (String[])listaConTexto.get(0);
				String[] listaIdiomas = (String[])listaConTexto.get(1);
				
	//			Introducimos las categorias idiomas
				CategoriaNoticiaVO categoriaNoticia = new CategoriaNoticiaVO();
				CategoriaIdiomaNoticiaVO[] categoriaIdiomaNoticia = new CategoriaIdiomaNoticiaVO[listaCategorias.length];
				categoriaNoticia.setNombre(listaCategorias[0]);
				
				for (int i = 0; i < listaCategorias.length; i++)
				{
					CategoriaIdiomaNoticiaVO categoriaIdiomaNoticiaAux = new CategoriaIdiomaNoticiaVO();
						categoriaIdiomaNoticiaAux.setIdioma(listaIdiomas[i].trim());
						categoriaIdiomaNoticiaAux.setNombreCategoria(listaCategorias[i].trim());	
					categoriaIdiomaNoticia[i] = categoriaIdiomaNoticiaAux;
				}
				categoriaNoticia.setCategoriaIdioma(categoriaIdiomaNoticia);
				
				logger.debug("Se introduce en la base de datos la categoria");			
				Long id = this.getSrvNoticiasService().crearCategoria(categoriaNoticia);
				if (logger.isDebugEnabled()) logger.debug("Se ha introducido la categoria con identificador ["+id+"]");
				form.setIdModificado(id);
			}
		
		} catch (Exception e) 
		{
			logger.error("Error insertando la categoria noticia",e);
			throw new ValidatorException("{error.insertando.categoria}");				
		} 
     }

    /**
     * @see es.pode.administracion.presentacion.categorias.crearCategoriaNoticia.CrearCategoriaNoticiaController#validarFormulario(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.categorias.crearCategoriaNoticia.ValidarFormularioForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void validarFormulario(ActionMapping mapping, es.pode.administracion.presentacion.categorias.crearCategoriaNoticia.ValidarFormularioForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
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
		if (logger.isDebugEnabled()) logger.debug("Se han introducido ["+listaCategorias.size()+"] categorias noticias");
		
		logger.debug("Se valida el formulario");
		/**
		 * **************************************************************************************************************************************
		 * ************************************************ SE VALIDA EL FORMULARIO *************************************************************
		 * **************************************************************************************************************************************
		 * */
		//Se ordena los array por este orden: Castellano, gallego, catalan, valenciano, euskera, ingles
		ArrayList listaOrdenada = devuelveArraysOrdenados((String[])listaIdiomas.toArray(new String[0]), (String[])listaCategorias.toArray(new String[0]));
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
     * @see es.pode.administracion.presentacion.categorias.crearCategoriaNoticia.CrearCategoriaNoticiaController#analizaValidacion(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.categorias.crearCategoriaNoticia.AnalizaValidacionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String analizaValidacion(ActionMapping mapping, es.pode.administracion.presentacion.categorias.crearCategoriaNoticia.AnalizaValidacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	//Se comprueba si el formulario ha validado o no
    	if (logger.isDebugEnabled()) logger.debug("El resultado de la validacion del formulario es ["+form.getValido()+"]");
    	return (form.getValido());        
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
    
    /**
     * Metodo que ordena el array:
     * 1º: Castellano 2º: Catalan 3º: Ingles
     * 4º: Euskera    5º: Gallego 6º: Valenciano
     * Se retorna en la primera posicion del arrayList las categorias y en la segunda los idiomas. La posiciones de los dos arrays (categorias e idiomas)
     * estan relacionadas. De manera que si en las primeras posiciones de los dos arrays esta: "categoria" y "es" querra decir que la categoria noticia con
     * nombre "categoria" esta en castellano
     * */
    public ArrayList devuelveArraysOrdenados(String[] idiomas, String[] categorias) throws Exception
    {
//    	Se ordena los array: Castellano, catalan, ingles, euskera, gallego, valenciano. En la primera posicion de la lista estara las categorias y 
//    	en la segunda los idiomas
    	ArrayList listaOrdenada = new ArrayList();
    	ArrayList listaCategorias = new ArrayList();
    	ArrayList listaIdiomas = new ArrayList();   	 
    	int posicion = 7;
    	//Busco el castellano      	
    	posicion = buscarIdioma(idiomas, this.getPropertyValue("castellano"));
    	if (posicion != -1)
    	{
    		logger.debug("Se ha encontrado la categoria en castellano");
    		listaCategorias.add(categorias[posicion]);
    		listaIdiomas.add(idiomas[posicion]);
    	}
    	//Busco gallego
    	posicion = buscarIdioma(idiomas, this.getPropertyValue("gallego"));
    	if (posicion != -1)
    	{
    		logger.debug("Se ha encontrado la categoria en gallego");
    		listaCategorias.add(categorias[posicion]);
    		listaIdiomas.add(idiomas[posicion]);
    	}
    	//Busco catalan
    	posicion = buscarIdioma(idiomas, this.getPropertyValue("catalan"));
    	if (posicion != -1)
    	{
    		logger.debug("Se ha encontrado la categoria en catalan");
    		listaCategorias.add(categorias[posicion]);
    		listaIdiomas.add(idiomas[posicion]);
    	}
    	//Busco valenciano
    	posicion = buscarIdioma(idiomas, this.getPropertyValue("valenciano"));
    	if (posicion != -1)
    	{
    		logger.debug("Se ha encontrado la categoria en valenciano");
    		listaCategorias.add(categorias[posicion]);
    		listaIdiomas.add(idiomas[posicion]);
    	}
    	//Busco euskera
    	posicion = buscarIdioma(idiomas, this.getPropertyValue("euskera"));
    	if (posicion != -1) 
    	{
    		logger.debug("Se ha encontrado la categoria en euskera");
    		listaCategorias.add(categorias[posicion]);
    		listaIdiomas.add(idiomas[posicion]);
    	}
    	//Busco ingles
    	posicion = buscarIdioma(idiomas, this.getPropertyValue("ingles"));
    	if (posicion != -1) 
    	{
    		logger.debug("Se ha encontrado la categoria en ingles");
    		listaCategorias.add(categorias[posicion]);
    		listaIdiomas.add(idiomas[posicion]);
    	}
    	
    	listaOrdenada.add(listaCategorias);
    	listaOrdenada.add(listaIdiomas);    	
    	
    	return listaOrdenada;
    }
    
    /**
     * Parametros de entrada: Idiomas buscables "idiomas e idioma a buscar "idiomaBuscar"
     * Si se encuentra el idioma en el array se retorna la posicion que ocupa*/
    public int buscarIdioma(String[] idiomas, String idiomaBuscar) throws Exception
    {
    	int posicion = -1;
    	for (int i = 0; idiomas != null && i < idiomas.length; i++)    	
    		if (idiomas[i] != null && !idiomas[i].equals("") && idiomas[i].equals(idiomaBuscar))    		
    			posicion = i;
    	return posicion;    		
    	
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
    		if (!comprobarTextoLleno(categorias)){
    			logger.debug("Las categorias tienen solo espacios en blanco");
    			saveErrorMessage(request, ERRORCATEGORIAVACIA);
//        		Se indica que el formulario es incorrecto
    			valido = false;
    		}
    		else{
    			logger.debug("Las categorias estan rellenas con texto");
	    		CrearControllerImpl controller = new CrearControllerImpl();
	    		//Se crea un array de string con el mismo tamaño que categorias hay. Cada posicion de este vector indicara una por una si la categoria es correcta
	    		String[] validaArray = new String[categorias.length];
	    		for (int i = 0; i < categorias.length; i++)
	    		{
	    			if (categorias[i].trim().length() > MAXTAMCATEGORIA)
	    			{    	
	    				if (logger.isDebugEnabled()) logger.debug("La categoria ["+categorias[i]+"] excede el numero de caracteres permitido. Se crea el error");
	    				String[] error = new String[1];
	    				error[0] = controller.dameStringBandera(controller.devuelveClaveError(idiomas[i]), request); 				    				
	    				saveErrorMessage(request, ERRORCATEGORIAMAXTAMANHO, error);
	    				//Se indica que esta categoria no es correcta
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
		    				saveErrorMessage(request, ERRORCATEGORIADUPLICADA, error);
//		    				Se indica que esta categoria no es correcta
		    				validaArray[i] = "false";
	    				}
	    			}
	    		}
	    		boolean encontrado = false;
	    		//Se recorre el array de la validacion de las categorias. Si una de ellas no es correcta el formulario sera incorrecto
	    		for (int j = 0; !encontrado && j < validaArray.length; j++)    		
	    			if ("false".equals(validaArray[j])) encontrado = true;
	    		
	    		valido = !encontrado;
    		}
    	} 
    	if (logger.isDebugEnabled()) logger.debug("El resultado de la validacion del formulario ha sido ["+valido+"]");
    	return valido;
    }

	public void recuperarDatos(ActionMapping mapping, RecuperarDatosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		//Se comprueba los datos que vienen del formulario		
		if (logger.isDebugEnabled()) logger.debug("El valor de nombreCategoria es ["+form.getNombreCategoria()+"] e idiomas es ["+form.getIdiomas()+"]");		
		
	}
	
	/**
	 * Metodo que comprueba si las categorias no estan rellenas solo de espacios en blanco
	 * */
	public boolean comprobarTextoLleno(String[] categorias) throws Exception
	{
		boolean ok = false;
		for (int i = 0; !ok && i < categorias.length; i++)
		{
			if (categorias[i] != null && !"".equals(categorias[i].trim())) ok = true;
		}
		return ok;
	}
	
	/**
	 * Metodo que elimina las categorias que esten vacias
	 */	 
	public ArrayList devuelveListaConTexto(ArrayList categorias, ArrayList idiomas) throws Exception
	{
		//Se elimina los valores que vengan vacios
		ArrayList listaReturn = new ArrayList();
		ArrayList categ = new ArrayList();
		ArrayList idio = new ArrayList();		
		for (int i = 0; i < categorias.size(); i++)
		{
			String categoria = (String)categorias.get(i);
			if (categoria != null && !"".equals(categoria.trim()))
			{
				//El valor es correcto lo introduzco en el idioma correspondiente
				if (logger.isDebugEnabled()) logger.debug("El valor ["+categoria+"] con el idioma ["+idiomas.get(i)+"]");
				categ.add(categoria);
				idio.add((String)idiomas.get(i));
			}
		}
		listaReturn.add((String[])categ.toArray(new String[0]));
		listaReturn.add((String[])idio.toArray(new String[0]));
		
		return listaReturn;

	}
	
	/**
	 * Metodo que comprueba si la categoria esta duplicada.
	 * */
	private boolean estaCategoriaDuplicada(String categoriaACrear) throws Exception
	{
//		Se comprueba si la categoria esta duplicada
		try{
			boolean encontrado = false;
			//La categoria que quiere crear se le elimina los acentos
			String categoriaACrearSinAcentos = removeAccents(categoriaACrear);
			//Se obtienen las categorias que ya existen en la base de datos
			CategoriaNoticiaVO[] categoriasNoticiasBBDD = this.getSrvNoticiasService().obtenerCategorias();
			if (logger.isDebugEnabled()) logger.debug("El numero de categorias introducidas en la BBDD es ["+categoriasNoticiasBBDD.length+"]");
			for (int i = 0; categoriasNoticiasBBDD != null && !encontrado && i < categoriasNoticiasBBDD.length; i++)
			{
//				Se obtienen las traducciones de las categorias que ya existen en la base de datos
				CategoriaIdiomaNoticiaVO[] categoriasIdiomas = categoriasNoticiasBBDD[i].getCategoriaIdioma();
				if (logger.isDebugEnabled()) logger.debug("El numero de traducciones de la categoria ["+categoriasNoticiasBBDD[i].getNombre()+"] es ["+categoriasIdiomas.length+"]");
				for (int j = 0;categoriasIdiomas != null && !encontrado && j < categoriasIdiomas.length; j++)
				{
					//Se obtiene la categoria que hay en base de datos sin acentos
					String categoriaSinAcentos =removeAccents(categoriasIdiomas[j].getNombreCategoria());		
					//Se comprueba en minusculas la categoria de BBDD y la que se pretende crear	
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
	
	/**
	 * Metodo que elimina los acentos del string
	 * */
	public static String removeAccents(String s){
		try {
			logger.debug("removeAccents: Eliminar acentos para="+s);
			s = s.replaceAll( "[ÂÀÄÁÃ]", "A" );
			s = s.replaceAll( "[ÊÈËÉ]", "E" );
			s = s.replaceAll( "[ÎÌÏÍ]", "I" );
			s = s.replaceAll( "[ÔÒÖÓÕ]", "O" );
			s = s.replaceAll( "[ÛÙÜÚ]", "U" );
			s = s.replaceAll( "Ç", "C" );
			s = s.replaceAll( "[àâäá]", "a" );
			s = s.replaceAll( "[éèêë]", "e" );
			s = s.replaceAll( "[ïîìí]", "i" );
			s = s.replaceAll( "[ôöòóõ]", "o" );
			s = s.replaceAll( "[ûüùú]", "u" );
			s = s.replaceAll( "ç", "c" );
			logger.debug("removeAccents: Acentos eliminados="+s);
			return s;
		} catch ( Exception ex ) {
			logger.error("removeAccents: Error generando claves con Normalizer, para cadena="+s, ex);
			return "";
		}
		
	}

}