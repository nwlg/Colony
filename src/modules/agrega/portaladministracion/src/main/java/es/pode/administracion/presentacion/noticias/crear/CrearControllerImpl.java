/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.noticias.crear;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimePartDataSource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import es.pode.administracion.presentacion.noticias.noticias.NoticiasControllerImpl;
import es.pode.contenidos.negocio.noticias.servicio.CategoriaIdiomaNoticiaVO;
import es.pode.contenidos.negocio.noticias.servicio.CategoriaNoticiaVO;
import es.pode.contenidos.negocio.noticias.servicio.DescripcionNoticiaVO;
import es.pode.contenidos.negocio.noticias.servicio.ImagenVO;
import es.pode.contenidos.negocio.noticias.servicio.NoticiaVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

/**
 * @see es.pode.administracion.presentacion.noticias.crear.CrearController
 */
public class CrearControllerImpl extends CrearController {
	private java.util.Properties pSpringProperties = null;
	
	private static Logger logger = Logger.getLogger(CrearControllerImpl.class);
	
	private final static String CATEGORIAVO = "categoriavo";	
	private final static String IMAGEN = "imagen";	
	
	
	private static final String NAMEJSPTITULO = "tituloNoti";
	private static final String NAMEJSPRESUMEN = "resumenNoti";
	private static final String NAMEJSPCUERPO = "cuerpoNoti";	
	private static final String NAMEJSPCATEGORIA = "categoriaNoti";	
	
	private static final String ERRORFORMULARIOCLAVE = "error.noticias.formulario.incorrecto.clave";
	
	public static final String ERRORESOBLIGATORIO = "error.noticia.es.obligatorio";
	public static final String ERRORSONOBLIGATORIOS = "error.noticia.son.obligatorio";
	public static final String ERRORGLOBOES = "error.noticia.globo.castellano";
	public static final String ERRORGLOBOEN = "error.noticia.globo.ingles";
	public static final String ERRORGLOBOCA = "error.noticia.globo.catalan";
	public static final String ERRORGLOBOEU = "error.noticia.globo.euskera";
	public static final String ERRORGLOBOVA = "error.noticia.globo.valenciano";
	public static final String ERRORGLOBOGL = "error.noticia.globo.gallego";	
	public static final String ERRORCATOBLIGATORIO = "error.noticia.categoria.obligatorio";
	public static final String ERRORTITULOOBLIGATORIO = "error.noticia.titulo.obligatorio";
	public static final String ERRORRESUMENOBLIGATORIO = "error.noticia.resumen.obligatorio";
	public static final String ERRORCUERPOOBLIGATORIO = "error.noticia.cuerpo.obligatorio";
	public static final String ERRORMAXTITULO = "error.noticia.titulo.maximo.caracteres";
	public static final String ERRORMAXRESUMEN = "error.noticia.resumen.maximo.caracteres";
	public static final String ERRORMAXCUERPO = "error.noticia.cuerpo.maximo.caracteres";
	public static final String ERRORCATEGORIAMAXTAMANO = "error.noticia.categoria.maximo.caracteres";
	public static final String ERRORNOTICIAFRAMEVACIO = "error.noticia.formulario.vacio";	
	public static final String FICHERO = "application-resources";
	private static final int MAXTAMCATEGORIA = 50;
	
	private static final String CASTELLANO = "globos.castellano";
	private static final String INGLES = "globos.ingles";
	private static final String CATALAN = "globos.catalan";
	private static final String EUSKERA = "globos.euskera";
	private static final String VALENCIANO = "globos.valenciano";
	private static final String GALLEGO = "globos.gallego";
	
	private static final String TRUE = "TRUE";
	private static final String FALSE = "FALSE";
	private static final String COMA = ",";
	private static final String PUNTO = ".";
	private static final String SPACE = " ";
	private static final String AND = "y";
	private static final String RETORNOCARRO = "<br/>";		
	
	private static final String TRES = "3";
	
	public static int CIEN = 100;
	public static int DOSCINCOSEIS = 256;
	public static int CUATROMIL = 4000;
	
	
	public void obtenerCategoria(ActionMapping mapping, ObtenerCategoriaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
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
			Collection categorias = Arrays.asList(this.getSrvNoticiasService().obtenerCategoriasTraducidas(noticiasController.
					devuelveIdiomasTraducibles(idiomasPlataforma, idiomaLogado, idiomaPrioritario, idiomaSecundario)));
			form.setCategoriaBackingList(categorias, "idCategoriaNoticia", "nombreCategoria");	
			
			if (estaLleno(form.getNombreImagen()))				
				form.setActivarImagen(new Integer(1));
						
			//Introducimos los valores por defecto si estos vienen vacios
			if (form.getEstado() == null)//por defecto la noticia esta activa
				form.setEstado(new Boolean(true));
			if (form.getActivarImagen() == null)
			{
				//Por defecto se selecciona la opcion de añadir una imagen a la noticia 
				form.setActivarImagen(new Integer(3));	
				//Por defecto se selecciona el alineamiento arriba-izquierda
				form.setAlineamiento(new Integer(0));
			}
			
		}
		catch (Exception e)
		{
			logger.error("Error recuperando las categorias");
			throw new ValidatorException("{errors.categorias.recuperar}");
		}
		
	}	
	
	public void crearNoticiaUno(ActionMapping mapping, CrearNoticiaUnoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
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
		CategoriaNoticiaVO categoria = this.getSrvNoticiasService().obtenerCategoria(form.getCategoria());	 
		ArrayList idiomasList = new ArrayList();
		CategoriaIdiomaNoticiaVO[] idiomasCategorias = categoria.getCategoriaIdioma();
		for (int i = 0; i < idiomasCategorias.length; i++)
			idiomasList.add(idiomasCategorias[i].getIdioma());
		
		form.setIdiomasCategoriasBBDDAsArray((String[])idiomasList.toArray(new String[0]));
		
		//Se comprueba si el formulario fue invalido pero se recuperan los valores introducidos
		if ((form.getCastellano() != null && form.getCastellano().length > 0) ||
				(form.getCatalan() != null && form.getCatalan().length > 0) ||
				(form.getEuskera() != null && form.getEuskera().length > 0) ||
				(form.getIngles() != null && form.getIngles().length > 0) ||
				(form.getValenciano() != null && form.getValenciano().length > 0) ||
				(form.getGallego() != null && form.getGallego().length > 0))
		{
			logger.debug("El formulario no ha validado, pero se recuperan los valores introducidos en cada globo (castellano, ingles, catalan, gallego, valenciano y euskera)");
			String[] castellano = form.getCastellano();
			String[] catalan = form.getCatalan();
			String[] euskera = form.getEuskera();
			String[] ingles = form.getIngles();
			String[] valenciano = form.getValenciano();
			String[] gallego = form.getGallego();	
			
			form.setIdiomas(dameIdiomas(castellano, catalan, ingles, euskera, gallego, valenciano));
			form.setIdiomasAlta(dameIdiomas(castellano, catalan, ingles, euskera, gallego, valenciano));
			form.setTitulo(dameTitulos(castellano, catalan, ingles, euskera, gallego, valenciano));
			form.setResumen(dameResumenes(castellano, catalan, ingles, euskera, gallego, valenciano));
			form.setCuerpo(dameCuerpos(castellano, catalan, ingles, euskera, gallego, valenciano));
			form.setNombreCategoria(dameCategorias(castellano, catalan, ingles, euskera, gallego, valenciano));
		}
		else
		{        
			
	        /**
    		 * **************************************************************************************************************************************
    		 * ********************************************** SE COMPRUEBA LA IMAGEN ****************************************************************
    		 * **************************************************************************************************************************************
    		 * */
			//Se puede elegir con o sin imagen
			// 2 Sin imagen 3 con imagen
			if (form.getActivarImagen().toString().equals(TRES))
			{
				logger.debug("Noticia con imagen");
				if (form.getImagen().getFileSize() == 0)
				{
					//No se ha seleccionado una imagen
					logger.error("Error se debe seleccionar una imagen");
					throw new ValidatorException ("{errors.noticias.imagenVacio}");
				}
				else
				{
					if (form.getImagen().getFileSize() > 0)
					{
						//comprobamos que sea una imagen de tipo jpg, gif, o png
						if(form.getImagen().getContentType().equalsIgnoreCase("image/jpeg")
								||form.getImagen().getContentType().equalsIgnoreCase("image/png")
								||form.getImagen().getContentType().equalsIgnoreCase("image/gif")
								||form.getImagen().getContentType().equalsIgnoreCase("image/pjpeg"))
						{	
							//Se ha seleccionado una imagen
							//Se comprueba si se ha seleccionado el alineamiento
							if (form.getAlineamiento() == null)
							{
								logger.error("Error se debe seleccionar un alineamiento");
								throw new ValidatorException ("{errors.noticias.alineamientoVacio}");
							}
							if (logger.isDebugEnabled()) logger.debug("El valor de la imagen seleccionado es valido ["+form.getImagen()+"]");							
							form.setNombreImagen(form.getImagen().getFileName());
							request.getSession().setAttribute(IMAGEN, form.getImagen());	
														
						}
						else
						{
							logger.error("Error en la imagen");
							throw new ValidatorException("{errors.noticias.noImagen}");
						}									
					}	
				}
			}
	        
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

	public void crearNoticiaDos(ActionMapping mapping, CrearNoticiaDosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{	
		
		String[] castellano = form.getCastellano();
		String[] catalan = form.getCatalan();
		String[] euskera = form.getEuskera();
		String[] ingles = form.getIngles();
		String[] valenciano = form.getValenciano();
		String[] gallego = form.getGallego();
		
		CategoriaNoticiaVO categoriaNoticia = (CategoriaNoticiaVO)request.getSession().getAttribute(CATEGORIAVO);
		rellenaArrayIdiomaCategoria (castellano,catalan,ingles,euskera,gallego,valenciano,categoriaNoticia);
		
		/**
		 * **************************************************************************************************************************************
		 * ************************************************ CREAR NUEVAS TRADUCCIONES DE CATEGORIAS *********************************************
		 * **************************************************************************************************************************************
		 * */
//		Si hay nuevas traducciones de la categoria se inserta en la base de datos
		//La posicion cinco de cada uno de los idiomas contiene la nueva categoria (si se hubiera insertado)
		ArrayList nuevasCategorias = new ArrayList();
		ArrayList nuevasCategoriasIdiomas = new ArrayList();
		if (castellano != null && castellano[5] != null)
		{
			nuevasCategorias.add(castellano[5]);
			nuevasCategoriasIdiomas.add(castellano[0]);
		}
		if (ingles != null && ingles[5] != null)
		{
			nuevasCategorias.add(ingles[5]);
			nuevasCategoriasIdiomas.add(ingles[0]);
		}
		if (euskera != null && euskera[5] != null)
		{
			nuevasCategorias.add(euskera[5]);
			nuevasCategoriasIdiomas.add(euskera[0]);
		}
		if (valenciano != null && valenciano[5] != null)
		{
			nuevasCategorias.add(valenciano[5]);
			nuevasCategoriasIdiomas.add(valenciano[0]);
		}
		if (catalan != null && catalan[5] != null)
		{
			nuevasCategorias.add(catalan[5]);
			nuevasCategoriasIdiomas.add(catalan[0]);
		}
		if (gallego != null && gallego[5] != null)
		{
			nuevasCategorias.add(gallego[5]);
			nuevasCategoriasIdiomas.add(gallego[0]);
		}
		
		if (nuevasCategorias != null && nuevasCategorias.size() > 0)
		{
			try
			{
				if (logger.isDebugEnabled()) logger.debug("Hay ["+nuevasCategorias.size()+"] nuevas traducciones en la categoria");
				ArrayList categoriasIdiomas = new ArrayList();	
				CategoriaIdiomaNoticiaVO[] categoriasIdiomasArray = categoriaNoticia.getCategoriaIdioma();
				for (int i = 0; categoriasIdiomasArray != null && i < categoriasIdiomasArray.length; i++)			
					categoriasIdiomas.add(categoriasIdiomasArray[i]);
				
				for (int j = 0; j < nuevasCategorias.size(); j++)
				{
					CategoriaIdiomaNoticiaVO categoriaNueva = new CategoriaIdiomaNoticiaVO();
					categoriaNueva.setIdioma(((String)nuevasCategoriasIdiomas.get(j)).trim());					
					categoriaNueva.setNombreCategoria(((String)nuevasCategorias.get(j)).trim());
					categoriasIdiomas.add(categoriaNueva);
				}
				CategoriaIdiomaNoticiaVO[] categoriasIdiomasVector = (CategoriaIdiomaNoticiaVO[])categoriasIdiomas.toArray(new CategoriaIdiomaNoticiaVO[0]);
				
				if (logger.isDebugEnabled()) logger.debug("Se modifica la categoria");
				CategoriaNoticiaVO nueva = new CategoriaNoticiaVO();				
				nueva.setId(categoriaNoticia.getId());
				nueva.setNombre(categoriaNoticia.getNombre());
				nueva.setCategoriaIdioma(categoriasIdiomasVector);
				nueva.setFechaPublicacion(categoriaNoticia.getFechaPublicacion());
				
				this.getSrvNoticiasService().limpiarCategoria(form.getCategoria());
				this.getSrvNoticiasService().modificarCategoria(nueva);
			} catch (Exception e)
			{
				logger.error("Error modificando la categoria", e);
				throw new ValidatorException("{error.modificando.categoria}");						
			}
		}
		
		logger.debug("Se crea la noticia");
		/**
		 * **************************************************************************************************************************************
		 * ************************************************ SE INSERTA LA NOTICIA *************************************************************
		 * **************************************************************************************************************************************
		 * */
		try
		{
	//		Se forma el vo de la noticia
			NoticiaVO noticia = new NoticiaVO();
			noticia.setActiva(form.getEstado());			
			noticia.setAutor(LdapUserDetailsUtils.getLogin());	
			
			CategoriaNoticiaVO categoria = (CategoriaNoticiaVO)request.getSession().getAttribute(CATEGORIAVO);		 
			noticia.setCategoria(categoria);
			
			ArrayList descripcionesNoticia = new ArrayList();	
	//		Se añade las descripciones 
	//		Castellano
			if (castellano != null && castellano[0] != null  && castellano[1] != null && castellano[2] != null && castellano[3] != null)		
				descripcionesNoticia = devuelveListaDescripciones(descripcionesNoticia, castellano[0], castellano[1], castellano[2], castellano[3]);
			
	//		Ingles
			if (ingles != null && ingles[0] != null  && ingles[1] != null && ingles[2] != null && ingles[3] != null)		
				descripcionesNoticia = devuelveListaDescripciones(descripcionesNoticia, ingles[0], ingles[1], ingles[2], ingles[3]);
			
	//		Euskera
			if (euskera != null && euskera[0] != null  && euskera[1] != null && euskera[2] != null && euskera[3] != null)		
				descripcionesNoticia = devuelveListaDescripciones(descripcionesNoticia, euskera[0], euskera[1], euskera[2], euskera[3]);
			
	//		Valenciano
			if (valenciano != null && valenciano[0] != null  && valenciano[1] != null && valenciano[2] != null && valenciano[3] != null)		
				descripcionesNoticia = devuelveListaDescripciones(descripcionesNoticia, valenciano[0], valenciano[1], valenciano[2], valenciano[3]);
			
	//		Catalan
			if (catalan != null && catalan[0] != null  && catalan[1] != null && catalan[2] != null && catalan[3] != null)		
				descripcionesNoticia = devuelveListaDescripciones(descripcionesNoticia, catalan[0], catalan[1], catalan[2], catalan[3]);
			
	//		Gallego
			if (gallego != null && gallego[0] != null  && gallego[1] != null && gallego[2] != null && gallego[3] != null)		
				descripcionesNoticia = devuelveListaDescripciones(descripcionesNoticia, gallego[0], gallego[1], gallego[2], gallego[3]);
			
			DescripcionNoticiaVO[] descripcionesNoticiaArray = (DescripcionNoticiaVO[])descripcionesNoticia.toArray(new DescripcionNoticiaVO[0]);
			noticia.setDescripcionNoticia(descripcionesNoticiaArray);
			
//			Tratamiento de la imagen
			if ((FormFile)request.getSession().getAttribute(IMAGEN) != null){
				noticia.setAlineamientoImg(form.getAlineamiento());	
				noticia.setURLImagen(tratamientoImagen((FormFile)request.getSession().getAttribute(IMAGEN)));
			}
			
			logger.debug("Se introduce en la base de datos la noticia");
			Long id = this.getSrvNoticiasService().crearNoticia(noticia);
			if (logger.isDebugEnabled()) logger.debug("Se ha introducido la noticia con identificador ["+id+"]");
			form.setIdModificado(id);
			//Se elimina el objeto introducido en sesion
			request.getSession().setAttribute(CATEGORIAVO, null);	
			request.getSession().setAttribute(IMAGEN, null);
			
		} catch (Exception e) 
		{
			logger.error("Error al introducir la noticia",e);
			throw new ValidatorException("{errors.noticias.insertar}");					
		}		
		
	}	
	
	/**
	 * Metodo que comprueba desde la request cual es el parametro que se ha introducido
	 * - La posicion 1 equivale al idioma
	 * - La posicion 2 equivale al resumen
	 * - La posicion 3 equivale al cuerpo
	 * - La posicion 4 equivale a la categoria correspondiente al idioma
	 * - La posicion 5 equivale a la categoria nueva (si se ha introducido)
	 * */
	public String[] rellenaArray (HttpServletRequest request, String name, String[] idioma) throws Exception
	{			
		if (name.startsWith(NAMEJSPTITULO))
		{
			if (logger.isDebugEnabled()) logger.debug("Se ha introducido el titulo de la noticia ["+request.getParameter(name)+"]");
			idioma[1] = request.getParameter(name);
		}

	   else if (name.startsWith(NAMEJSPRESUMEN))
	   {
		   if (logger.isDebugEnabled()) logger.debug("Se ha introducido el resumen de la noticia ["+request.getParameter(name)+"]");
		   idioma[2] = request.getParameter(name);
		
	   }
	   else if (name.startsWith(NAMEJSPCUERPO))
	   {
		   if (logger.isDebugEnabled()) logger.debug("Se ha introducido el cuerpo de la noticia ["+request.getParameter(name)+"]");
		   idioma[3] = request.getParameter(name);
		
	   }
	   else if (name.startsWith(NAMEJSPCATEGORIA))
	   {
		   if (logger.isDebugEnabled()) logger.debug("Se ha introducido la categoria de la noticia ["+request.getParameter(name)+"]");
		   idioma[4] = request.getParameter(name);
		   idioma[5] = request.getParameter(name);
	   }
		
		return idioma;
	}
	
	/**
	 * Metodo que devuelve las descripciones de las noticias. (Las traducciones en todos los idiomas)*/
	public ArrayList devuelveListaDescripciones (ArrayList lista, String idioma, String titulo, String resumen, String cuerpo) throws Exception
	{			
		DescripcionNoticiaVO descripcionNoticiaAux = new DescripcionNoticiaVO();
		descripcionNoticiaAux.setCuerpo(cuerpo.trim());
		descripcionNoticiaAux.setIdioma(idioma.trim());
		descripcionNoticiaAux.setResumen(resumen.trim());
		descripcionNoticiaAux.setTitulo(titulo.trim());
		lista.add(descripcionNoticiaAux);
		return lista;
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
	
	public String tratamientoImagen (FormFile imagenFile) throws Exception
	{
		if (logger.isDebugEnabled()) logger.debug("Realizamos el tratamiento de la imagen ["+imagenFile+"]");
		ImagenVO imagen = new ImagenVO();
		InternetHeaders ih = new InternetHeaders();
		MimeBodyPart mbp = new MimeBodyPart(ih,imagenFile.getFileData());
	
		DataSource source = new MimePartDataSource(mbp);
		DataHandler dImagen = 	new DataHandler(source);
	
		imagen.setDatos(dImagen);
		imagen.setNombre(imagenFile.getFileName());
		imagen.setMimeType(imagenFile.getContentType());					
		String sUrlImagen= this.getSrvNoticiasService().almacenarImagenNoticia(imagen);	
		return sUrlImagen;
	}	
	
	/**
	 * Metodo que comprueba si el "globo" del idioma esta relleno*/
	public boolean globoVacio(String[] idioma) throws Exception
	{
		return (idioma[1] == null && idioma[2] == null && idioma[3] == null && idioma[5] == null);						
	}


	public boolean validaFormulario(String[] castellano,String[] catalan,String[] ingles,String[] euskera,String[] gallego,String[] valenciano, HttpServletRequest request) throws Exception
	{
		boolean globoCastellano = true;
		boolean globoCatalan = true;
		boolean globoIngles = true;
		boolean globoEuskera = true;
		boolean globoGallego = true;
		boolean globoValenciano = true;
		boolean validaFormulario = false;
		int contadorGlobosVacios = 0;
		
		//Se valida el castellano
		logger.debug("Se valida el globo de castellano");
		if (globoVacio(castellano))
		{
			//No hay datos introducidos en el globo en castellano
			logger.debug("No hay datos introducidos en el globo de castellano");
			contadorGlobosVacios++;
		}
		else
		{
			//Hay datos introducidos en el globo en castellano. Se valida el formulario
			logger.debug("Hay datos introducidos en el globo de castellano");
			String[] erroresES = validaArrayIdioma(castellano, "es");
			if (erroresES.length > 1)
			{
				globoCastellano = false;
				pintarError (erroresES, request);
			} 
		}
		
//		Se valida el gallego
		logger.debug("Se valida el globo de gallego");
		if (globoVacio(gallego))
		{
			//No hay datos introducidos en el globo en gallego
			logger.debug("No hay datos introducidos en el globo de gallego");
			contadorGlobosVacios++;
		}
		else
		{
			//Hay datos introducidos en el globo en gallego. Se valida el formulario
			logger.debug("Hay datos introducidos en el globo de gallego");
			String[] erroresGL = validaArrayIdioma(gallego, "gl");
			if (erroresGL.length > 1)
			{
				globoGallego = false;
				pintarError (erroresGL, request);
			} 
		}
		
		//Se valida el catalan
		logger.debug("Se valida el globo de catalan");
		if (globoVacio(catalan))
		{
			//No hay datos introducidos en el globo en castellano
			logger.debug("No hay datos introducidos en el globo de catalan");
			contadorGlobosVacios++;
		}
		else
		{
			//Hay datos introducidos en el globo en catalan. Se valida el formulario
			logger.debug("Hay datos introducidos en el globo de catalan");
			String[] erroresCA = validaArrayIdioma(catalan, "ca");
			if (erroresCA.length > 1)
			{
				globoCatalan = false;
				pintarError (erroresCA, request);
			} 
		}
		
//		Se valida el valenciano
		logger.debug("Se valida el globo de valenciano");
		if (globoVacio(valenciano))
		{
			//No hay datos introducidos en el globo en valenciano
			logger.debug("No hay datos introducidos en el globo de valenciano");
			contadorGlobosVacios++;
		}
		else
		{
			//Hay datos introducidos en el globo en valenciano. Se valida el formulario
			logger.debug("Hay datos introducidos en el globo de valenciano");
			String[] erroresVA = validaArrayIdioma(valenciano, "va");
			if (erroresVA.length > 1)
			{
				globoValenciano = false;
				pintarError (erroresVA, request);
			} 
		}

		//Se valida el euskera
		logger.debug("Se valida el globo de euskera");
		if (globoVacio(euskera))
		{
			//No hay datos introducidos en el globo en euskera
			logger.debug("No hay datos introducidos en el globo de euskera");
			contadorGlobosVacios++;
		}
		else
		{
			//Hay datos introducidos en el globo en euskera. Se valida el formulario
			logger.debug("Hay datos introducidos en el globo de euskera");
			String[] erroresEU = validaArrayIdioma(euskera, "eu");
			if (erroresEU.length > 1)
			{
				globoEuskera = false;
				pintarError (erroresEU, request);
			} 
		}
		
//		Se valida el ingles
		logger.debug("Se valida el globo de ingles");
		if (globoVacio(ingles))
		{
			//No hay datos introducidos en el globo en ingles
			logger.debug("No hay datos introducidos en el globo de ingles");
			contadorGlobosVacios++;
		}
		else
		{
			//Hay datos introducidos en el globo en ingles. Se valida el formulario
			logger.debug("Hay datos introducidos en el globo de ingles");
			String[] erroresEN = validaArrayIdioma(ingles, "en");
			if (erroresEN.length > 1)
			{
				globoIngles = false;
				pintarError (erroresEN, request);
			} 
		}		

		//Se comprueba el numero de globos introducidos
		if (contadorGlobosVacios == 6)				
			saveErrorMessage(request, ERRORNOTICIAFRAMEVACIO);	
		
		else		
			if (globoCastellano && globoIngles && globoCatalan && globoEuskera && globoValenciano && globoGallego)		
				validaFormulario = true;		
		
		return validaFormulario;
	}

	/**
	 * Metodo que comprueba si el "globo" tiene introducido correctamente los campos
	 * */
	public String[] validaArrayIdioma (String[] arrayIdioma, String idioma) throws Exception
	{	
		ArrayList listaErrores = new ArrayList();
		listaErrores.add(devuelveClaveError(idioma));
		
		//Campo categoria
		if (arrayIdioma[4] == null)
			listaErrores.add(ERRORCATOBLIGATORIO);
		else
		{
			if (arrayIdioma[4].trim().length() > MAXTAMCATEGORIA)
				listaErrores.add(ERRORCATEGORIAMAXTAMANO);
		}
		
		//Campo titulo
		if (arrayIdioma[1] == null)		
			listaErrores.add(ERRORTITULOOBLIGATORIO);		
		else
		{
			if (arrayIdioma[1].trim().length() > CIEN)			
				//Se comprueba el tamanho de titulo
				listaErrores.add(ERRORMAXTITULO);					
		}

		//resumen
		if (arrayIdioma[2] == null)		
			listaErrores.add(ERRORRESUMENOBLIGATORIO);		
		else
		{
			if (arrayIdioma[2].trim().length() > DOSCINCOSEIS)			
//				Se comprueba el tamanho de resumen
				listaErrores.add(ERRORMAXRESUMEN);
			
		}
		
		//cuerpo
		if (arrayIdioma[3] == null)
			listaErrores.add(ERRORCUERPOOBLIGATORIO);
		else
		{
			if (arrayIdioma[3].trim().length() > CUATROMIL)
				listaErrores.add(ERRORMAXCUERPO);
		}
		
		return (String[])listaErrores.toArray(new String[0]);
	}

	/**
	 * Metodo que devuelve cual es el "globo" de idioma que tiene incorrecta la introduccion de datos
	 * */
	public String devuelveClaveError(String idioma) throws Exception
	{
		String returnValor = "";
		if (this.getPropertyValue("castellano").equals(idioma)) returnValor = ERRORGLOBOES;
		else if (this.getPropertyValue("ingles").equals(idioma)) returnValor = ERRORGLOBOEN;
		else if (this.getPropertyValue("catalan").equals(idioma)) returnValor = ERRORGLOBOCA;
		else if (this.getPropertyValue("euskera").equals(idioma)) returnValor = ERRORGLOBOEU;
		else if (this.getPropertyValue("valenciano").equals(idioma)) returnValor = ERRORGLOBOVA;
		else returnValor = ERRORGLOBOGL;
		return returnValor;
		
	}
	
	public void rellenaArrayIdiomaCategoria (String[] castellano,String[] catalan,String[] ingles,String[] euskera,String[] gallego,String[] valenciano,CategoriaNoticiaVO categoriaNoticia) throws Exception
	{
		CategoriaIdiomaNoticiaVO[] categoriasIdiomas = categoriaNoticia.getCategoriaIdioma();
		for (int i = 0; categoriasIdiomas != null && i < categoriasIdiomas.length; i++)
		{
			if (estaLleno(categoriasIdiomas[i].getNombreCategoria()))
			{
				if (this.getPropertyValue("castellano").equals(categoriasIdiomas[i].getIdioma())){
					castellano[4] = categoriasIdiomas[i].getNombreCategoria();
					castellano[0] = categoriasIdiomas[i].getIdioma();
				}
				else if (this.getPropertyValue("ingles").equals(categoriasIdiomas[i].getIdioma())) 
				{
					ingles[4] = categoriasIdiomas[i].getNombreCategoria();
					ingles[0] = categoriasIdiomas[i].getIdioma();
				}
				else if (this.getPropertyValue("catalan").equals(categoriasIdiomas[i].getIdioma())) 
				{
					catalan[4] = categoriasIdiomas[i].getNombreCategoria();
					catalan[0] = categoriasIdiomas[i].getIdioma();
				}
				else if (this.getPropertyValue("euskera").equals(categoriasIdiomas[i].getIdioma()))
				{
					euskera[4] = categoriasIdiomas[i].getNombreCategoria();
					euskera[0] = categoriasIdiomas[i].getIdioma();
				}
				else if (this.getPropertyValue("valenciano").equals(categoriasIdiomas[i].getIdioma())) 
				{
					valenciano[4] = categoriasIdiomas[i].getNombreCategoria();
					valenciano[0] = categoriasIdiomas[i].getIdioma();
				}
				else if (this.getPropertyValue("gallego").equals(categoriasIdiomas[i].getIdioma())) 
				{
					gallego[4] = categoriasIdiomas[i].getNombreCategoria();
					gallego[0] = categoriasIdiomas[i].getIdioma();
				}
			}
		}
	}
	
	/**
	 * Metodo que pintar los errores que existen globo por globo
	 * */
	public void pintarError (String[] errores, HttpServletRequest request) throws Exception
	{	
		String[] erroresPintar = new String[1];
		ArrayList listaErrores = dameListaErrores(errores);
		String[] erroresObligatorios = (String[])listaErrores.get(0);
		String[] erroresTamanho = (String[])listaErrores.get(1);		
//		String error = traducirError(errores[0], request) + SPACE;
//		String error = "<img src='http://andreslopezjosenge.com/clientes/snr/red/prod/img/01_castellano.gif' alt=\"Castellano\" title=\"Castellano\" />" + traducirError(errores[0], request) + SPACE;	
		String error = dameStringBandera(errores[0], request);
		
		//Se analizan los errores obligatorios
		if (logger.isDebugEnabled()) logger.debug("El array de errores obligatorios es de tamanho ["+erroresObligatorios.length+"]");
		if (erroresObligatorios != null && erroresObligatorios.length > 0)
		{
			//Hay al menos uno
			if (erroresObligatorios.length == 1)			
				error = error + traducirError(erroresObligatorios[0], request) + SPACE + traducirError(ERRORESOBLIGATORIO, request) + PUNTO;
			
			else if (erroresObligatorios.length == 2)	//Hay dos		
				error = error + traducirError(erroresObligatorios[0], request) + SPACE +  AND + SPACE + traducirError(erroresObligatorios[1], request) + SPACE + traducirError(ERRORSONOBLIGATORIOS, request) + PUNTO;
			
			else
			{	//Hay 3							
				error = error + traducirError(erroresObligatorios[0], request) + COMA + SPACE + traducirError(erroresObligatorios[1], request);
				error = error + SPACE + AND + SPACE + traducirError(erroresObligatorios[erroresObligatorios.length - 1], request) + SPACE + traducirError(ERRORSONOBLIGATORIOS, request) + PUNTO;
				
			}
		}		
		
//		Se analizan los errores obligatorios
		if (logger.isDebugEnabled()) logger.debug("El array de errores de tamanho es de tamanho ["+erroresTamanho.length+"]");
		if (erroresTamanho != null && erroresTamanho.length > 0)
		{
			if (erroresTamanho.length == 1)//Hay uno					
				error = error + RETORNOCARRO + traducirError(erroresTamanho[0], request) + PUNTO;
			
			else
			{
				//Hay mas de uno
				for (int k = 0; k < erroresTamanho.length - 1; k++)
					error = error + RETORNOCARRO + traducirError(erroresTamanho[k], request) + PUNTO;
				error = error + RETORNOCARRO + traducirError(erroresTamanho[erroresTamanho.length - 1], request) + PUNTO;
				
			}
		}
		erroresPintar[0] = error;
		saveErrorMessage(request, ERRORFORMULARIOCLAVE, erroresPintar);
		
	}
	
	/**
	 * Metodo que obtiene el codigo html para pintar el error de cada globo con la bandera correspondiente
	 * */
	public String dameStringBandera(String claveError, HttpServletRequest request) throws Exception
	{		
		String stReturn = "";
		if (claveError.endsWith("castellano"))
		{
			String castellano = this.getResource(CASTELLANO, FICHERO, (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
			stReturn = "<h3 class=\"h3_espanol\">"+castellano+"</h3>";
		}		
		if (claveError.endsWith("ingles"))
		{
			String ingles = this.getResource(INGLES, FICHERO, (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
			stReturn = "<h3 class=\"h3_ingles\">"+ingles+"</h3>";
		}
		if (claveError.endsWith("catalan"))
		{
			String catalan = this.getResource(CATALAN, FICHERO, (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
			stReturn = "<h3 class=\"h3_catalan\">"+catalan+"</h3>";
		}
		if (claveError.endsWith("euskera"))
		{
			String euskera = this.getResource(EUSKERA, FICHERO, (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
			stReturn = "<h3 class=\"h3_vasco\">"+euskera+"</h3>";
		}
		if (claveError.endsWith("valenciano"))
		{
			String valenciano = this.getResource(VALENCIANO, FICHERO, (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
			stReturn = "<h3 class=\"h3_valenciano\">"+valenciano+"</h3>";
		}
		if (claveError.endsWith("gallego"))
		{
			String gallego = this.getResource(GALLEGO, FICHERO, (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
			stReturn = "<h3 class=\"h3_gallego\">"+gallego+"</h3>";
			
		}
		return stReturn.trim();
								
	}
	
	/**
	 * Metodo que traduce el error. Nos devuelve el texto internacionalizado
	 * */
	public String traducirError(String error, HttpServletRequest request) throws Exception
	{
		return this.getResource(error, FICHERO, (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
	}
	
	/**
	 * Metodo que devuelve la lista de errores que existen
	 * - En la primera posicion de la lista se almacenan los errores de tipo campo obligatorio
	 * - En la segunda posicion de la lista se almacenan los errores de tipo tamanho maximo superado
	 * */
	public ArrayList dameListaErrores (String[] errores) throws Exception
	{
		ArrayList listaReturn = new ArrayList();
		ArrayList erroresObligatorios = new ArrayList();
		ArrayList erroresTamanho = new ArrayList();
		for (int i = 0; i < errores.length; i++)
		{
			if (!errores[i].startsWith("error.noticia.globo"))
			{
				if (esObligatorio(errores[i]))
					erroresObligatorios.add(errores[i]);
				else
					erroresTamanho.add(errores[i]);
			}
		}
		String[] erroresObligatoriosArray = (String[])erroresObligatorios.toArray(new String[0]);
		String[] erroresTamanhoArray = (String[])erroresTamanho.toArray(new String[0]);
		listaReturn.add(erroresObligatoriosArray);
		listaReturn.add(erroresTamanhoArray);
		
		return listaReturn;
		
	}
	
	/**
	 * Metodo que indica el error que viene como parametro de entrada es de tipo campo obligatorio
	 * */
	public boolean esObligatorio (String error) throws Exception
	{
		boolean encontrado = false;
		String[] erroresObligatorios = this.getPropertyValue("errores.noticia.campos.obligatorios").split(COMA);
		for (int i = 0; !encontrado && i < erroresObligatorios.length; i++)
			if (erroresObligatorios[i].equals(error)) encontrado = true;
		return encontrado;
	}
	 
	 public static String getResource(String key, String baseName, Locale locale){
	        String recurso = "";
	        try{
	           ResourceBundle theResourceBundle = ResourceBundle.getBundle(baseName,locale);
	           if (theResourceBundle!=null){
	                       recurso = theResourceBundle.getString(key);
	           }
	        }catch (MissingResourceException mre){
	        	try{
		        	ResourceBundle theResourceBundle = ResourceBundle.getBundle(baseName);
		            if (theResourceBundle!=null){
		                 recurso = theResourceBundle.getString(key);
		            }
	        	 }catch (MissingResourceException m){
	        		 recurso = key;
	        	 }
	        }
	        return recurso;
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
		
	//		Los array tienen seis posiciones:
	//			[0] es la del idioma
	//			[1] es la del titulo
	//			[2] es la del resumen
	//			[3] es la del cuerpo
	//			[4] es la categoria
	//			[5] si la categoria es nueva
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
						castellano = rellenaArray(request,name, castellano);
						castellano[0] = this.getPropertyValue("castellano");
					}
					else if (name.endsWith(this.getPropertyValue("ingles")))
					{
						ingles = rellenaArray(request,name, ingles);
						ingles[0] = this.getPropertyValue("ingles");
					}
					else if (name.endsWith(this.getPropertyValue("catalan")))
					{
						catalan = rellenaArray(request,name, catalan);
						catalan[0] = this.getPropertyValue("catalan");
					}
					else if (name.endsWith(this.getPropertyValue("euskera")))
					{
						euskera = rellenaArray(request,name, euskera);
						euskera[0] = this.getPropertyValue("euskera");
					}
					else if (name.endsWith(this.getPropertyValue("valenciano")))
					{
						valenciano = rellenaArray(request,name, valenciano);
						valenciano[0] = this.getPropertyValue("valenciano");
					}
					else if (name.endsWith(this.getPropertyValue("gallego")))
					{
						gallego = rellenaArray(request,name, gallego);
						gallego[0] = this.getPropertyValue("gallego");
					}
				}
			}
		
		CategoriaNoticiaVO categoriaNoticia = (CategoriaNoticiaVO)request.getSession().getAttribute(CATEGORIAVO);
		rellenaArrayIdiomaCategoria (castellano,catalan,ingles,euskera,gallego,valenciano,categoriaNoticia);
		
		logger.debug("Se valida el formulario");
		/**
		 * **************************************************************************************************************************************
		 * ************************************************ SE VALIDA EL FORMULARIO *************************************************************
		 * **************************************************************************************************************************************
		 * */
		if (!validaFormulario(castellano, catalan, ingles, euskera, gallego, valenciano, request))
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
	 * Metodo que comprueba si una variable viene rellena o no
	 * */
	public boolean estaLleno (String var) throws Exception
	{
		return (var != null && !"".equals(var));
	}
	
	/**
	 * Metodo que de cada globo de los idiomas selecciona el idioma y los introduce todos en un arrayList
	 * */
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
	
	/**
	 * Metodo que de cada globo de los idiomas selecciona el titulo y los introduce todos en un arrayList
	 * */
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
	
	/**
	 * Metodo que de cada globo de los idiomas selecciona el resumen y los introduce todos en un arrayList
	 * */
	public ArrayList dameResumenes (String[] castellano,String[] catalan,String[] ingles,String[] euskera,String[] gallego,String[] valenciano)throws Exception
	{
		ArrayList resumenes = new ArrayList();
		if (estaLleno(castellano[0])) resumenes.add(castellano[2]);
		if (estaLleno(catalan[0])) resumenes.add(catalan[2]);		
		if (estaLleno(ingles[0])) resumenes.add(ingles[2]);
		if (estaLleno(euskera[0])) resumenes.add(euskera[2]);
		if (estaLleno(gallego[0])) resumenes.add(gallego[2]);
		if (estaLleno(valenciano[0])) resumenes.add(valenciano[2]);
		return resumenes;
	}
	
	/**
	 * Metodo que de cada globo de los idiomas selecciona el cuerpo y los introduce todos en un arrayList
	 * */
	public ArrayList dameCuerpos (String[] castellano,String[] catalan,String[] ingles,String[] euskera,String[] gallego,String[] valenciano)throws Exception
	{
		ArrayList cuerpos = new ArrayList();
		if (estaLleno(castellano[0])) cuerpos.add(castellano[3]);
		if (estaLleno(catalan[0])) cuerpos.add(catalan[3]);		
		if (estaLleno(ingles[0])) cuerpos.add(ingles[3]);
		if (estaLleno(euskera[0])) cuerpos.add(euskera[3]);
		if (estaLleno(gallego[0])) cuerpos.add(gallego[3]);
		if (estaLleno(valenciano[0])) cuerpos.add(valenciano[3]);
		return cuerpos;
	}
	
	/**
	 * Metodo que de cada globo de los idiomas selecciona la categoria y los introduce todos en un arrayList
	 * */
	public ArrayList dameCategorias (String[] castellano,String[] catalan,String[] ingles,String[] euskera,String[] gallego,String[] valenciano)throws Exception
	{
		ArrayList categorias = new ArrayList();
		if (estaLleno(castellano[0])) categorias.add(castellano[4]);
		if (estaLleno(catalan[0])) categorias.add(catalan[4]);		
		if (estaLleno(ingles[0])) categorias.add(ingles[4]);
		if (estaLleno(euskera[0])) categorias.add(euskera[4]);
		if (estaLleno(gallego[0])) categorias.add(gallego[4]);
		if (estaLleno(valenciano[0])) categorias.add(valenciano[4]);
		return categorias;
	}

}