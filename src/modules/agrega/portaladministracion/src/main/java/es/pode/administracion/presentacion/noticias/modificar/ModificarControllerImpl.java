/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.noticias.modificar;

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
import org.apache.struts.upload.FormFile;

import es.pode.administracion.presentacion.noticias.crear.CrearControllerImpl;
import es.pode.administracion.presentacion.noticias.noticias.NoticiasControllerImpl;
import es.pode.contenidos.negocio.noticias.servicio.CategoriaIdiomaNoticiaVO;
import es.pode.contenidos.negocio.noticias.servicio.CategoriaNoticiaVO;
import es.pode.contenidos.negocio.noticias.servicio.DescripcionNoticiaVO;
import es.pode.contenidos.negocio.noticias.servicio.NoticiaVO;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

/**
 * @see es.pode.administracion.presentacion.noticias.modificar.ModificarController
 */
public class ModificarControllerImpl extends ModificarController {
	private java.util.Properties pSpringProperties = null;
	
	private static Logger logger = Logger.getLogger(ModificarControllerImpl.class);
	private final static String VERNOTICIAVO = "verNoticiavo";
	private final static String CATEGORIAMODVO = "categoriamodvo";	
	private final static String IMAGEN = "imagen";		
	
	private static final String UNO = "1";
	private static final String DOS = "2";
	private static final String TRES = "3";	
	
	private static final String TRUE = "TRUE";
	private static final String FALSE = "FALSE";


	/**
	 * @see es.pode.administracion.presentacion.noticias.modificar.ModificarController#cargarCombos(org.apache.struts.action.ActionMapping,
	 *      es.pode.administracion.presentacion.noticias.modificar.CargarCombosForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
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



	public void obtenerIdentificador(ActionMapping mapping, ObtenerIdentificadorForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		try
		{
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
	    	if (form.getEstado() == null) form.setEstado(noticia.getActiva());
	    	if (form.getCategoria() == null) form.setCategoria(noticia.getCategoria().getId());	  
	    	
	    	if (form.getActivarImagen() == null)
	    	{
	    		//No viene con valor
//	    		Tratamiento de la imagen	
	    		String sURLImagen = noticia.getURLImagen();	
	    		if (sURLImagen != null && sURLImagen.indexOf("/") != -1)
				{
					form.setActivarImagen(new Integer(1));							
					String sToken[] = sURLImagen.split("/");
					//form.setNombreImagen(sToken[sToken.length-1]);
					form.setNombreImagenVO(sToken[sToken.length-1]);					
					form.setAlineamiento(noticia.getAlineamientoImg());													
				}
	    		else   			    			
	    			form.setActivarImagen(new Integer(2));	    		
	    		
	    	}
	    	else if (form.getActivarImagen().intValue() == 3)
	    	{
	    		form.setActivarImagen(new Integer(4));	 
	    	}
	    		
		} catch (Exception e)
		{
			logger.error("Error obteniendo la noticia");
			throw new ValidatorException("{errorObteniendoNoticia}");			
		}
    	
	}

	public void modificarNoticiaUno(ActionMapping mapping, ModificarNoticiaUnoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{	
		if (form.getCategoria() == null)
        {
        	throw new ValidatorException("{errors.notiticia.categoria}");
        }
		logger.debug("Se recupera el vo de la noticia de la request");		
        NoticiaVO noticia = (NoticiaVO)request.getSession().getAttribute(VERNOTICIAVO);  
        if (logger.isDebugEnabled()) logger.debug("Se obtiene la categoria con identificador ["+form.getCategoria()+"]"); 
    	CategoriaNoticiaVO categoria = this.getSrvNoticiasService().obtenerCategoria(form.getCategoria());
    	request.getSession().setAttribute(CATEGORIAMODVO, categoria);
        ArrayList idiomasList = new ArrayList();
		CategoriaIdiomaNoticiaVO[] idiomasCategorias = categoria.getCategoriaIdioma();
		for (int i = 0; i < idiomasCategorias.length; i++)
			idiomasList.add(idiomasCategorias[i].getIdioma());
		
		form.setIdiomasCategoriasBBDDAsArray((String[])idiomasList.toArray(new String[0]));
		if ((form.getCastellano() != null && form.getCastellano().length > 0) ||
				(form.getCatalan() != null && form.getCatalan().length > 0) ||
				(form.getEuskera() != null && form.getEuskera().length > 0) ||
				(form.getIngles() != null && form.getIngles().length > 0) ||
				(form.getValenciano() != null && form.getValenciano().length > 0) ||
				(form.getGallego() != null && form.getGallego().length > 0))
		{
			CrearControllerImpl controller = new CrearControllerImpl();
			String[] castellano = form.getCastellano();
			String[] catalan = form.getCatalan();
			String[] euskera = form.getEuskera();
			String[] ingles = form.getIngles();
			String[] valenciano = form.getValenciano();
			String[] gallego = form.getGallego();	
			
			form.setIdiomas(controller.dameIdiomas(castellano, catalan, ingles, euskera, gallego, valenciano));
			form.setIdiomasAlta(controller.dameIdiomas(castellano, catalan, ingles, euskera, gallego, valenciano));
			form.setTitulo(controller.dameTitulos(castellano, catalan, ingles, euskera, gallego, valenciano));
			form.setResumen(controller.dameResumenes(castellano, catalan, ingles, euskera, gallego, valenciano));
			form.setCuerpo(controller.dameCuerpos(castellano, catalan, ingles, euskera, gallego, valenciano));
			form.setNombreCategoria(controller.dameCategorias(castellano, catalan, ingles, euskera, gallego, valenciano));
		}
		else
		{	   
			//Tratamiento de la imagen
			if (form.getActivarImagen() != null)
			{
				if (DOS.equals(form.getActivarImagen().toString()))
				{
				//Sin imagen
				form.setNombreImagen(null);
				//Si habia una imagen anterior la recupero
				String sURLImagen = noticia.getURLImagen();	
				if (sURLImagen != null && sURLImagen.indexOf("/") != -1)
				{
					String sToken[] = sURLImagen.split("/");
						form.setNombreImagenVO(sToken[sToken.length-1]);
					}		
				}				
				else if (TRES.equals(form.getActivarImagen().toString()))
				{
					//Se modifica la imagen
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
			}
			
	    	ArrayList idiomasAlta = new ArrayList();
	    	ArrayList titulo = new ArrayList();
	    	ArrayList resumen = new ArrayList();
	    	ArrayList cuerpo = new ArrayList();

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
	    	
	        ArrayList nombreCategoria = new ArrayList();
	    	ArrayList idiomas = new ArrayList(); 	        
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

	    	form.setIdiomas(idiomas);
	    	form.setNombreCategoria(nombreCategoria);
		}				
	}
	
	public void modificarNoticiaDos(ActionMapping mapping, ModificarNoticiaDosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{		
		/**
		 * **************************************************************************************************************************************
		 * ************************************************ CREAR NUEVAS TRADUCCIONES DE CATEGORIAS *********************************************
		 * **************************************************************************************************************************************
		 * */
		String[] castellano = form.getCastellano();
		String[] catalan = form.getCatalan();
		String[] euskera = form.getEuskera();
		String[] ingles = form.getIngles();
		String[] valenciano = form.getValenciano();
		String[] gallego = form.getGallego();
		
		CrearControllerImpl crearNoticiaController = new CrearControllerImpl();
		CategoriaNoticiaVO categoriaNoticia = (CategoriaNoticiaVO)request.getSession().getAttribute(CATEGORIAMODVO);
		crearNoticiaController.rellenaArrayIdiomaCategoria (castellano,catalan,ingles,euskera,gallego,valenciano,categoriaNoticia);
		
//		Si hay nuevas traducciones de la categoria se inserta en la base de datos
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
				nueva.setFechaPublicacion(categoriaNoticia.getFechaPublicacion());
				nueva.setCategoriaIdioma(categoriasIdiomasVector);
				this.getSrvNoticiasService().limpiarCategoria(form.getCategoria());
				this.getSrvNoticiasService().modificarCategoria(nueva);
			} catch (Exception e)
			{
				logger.error("Error modificando la categoria", e);
				throw new ValidatorException("{error.modificando.categoria}");
			}
		}
		
		logger.debug("Se modifica la noticia");
		/**
		 * **************************************************************************************************************************************
		 * ************************************************ SE INSERTA LA NOTICIA *************************************************************
		 * **************************************************************************************************************************************
		 * */
		try
		{
			NoticiaVO noticiaModificable = (NoticiaVO)request.getSession().getAttribute(VERNOTICIAVO);     
	//		Se forma el vo de la noticia
			NoticiaVO noticia = new NoticiaVO();
			noticia.setActiva(form.getEstado());			
			noticia.setAutor(LdapUserDetailsUtils.getLogin());	
			noticia.setId(noticiaModificable.getId());
			noticia.setFechaPublicacion(noticiaModificable.getFechaPublicacion());			
			
			
			CategoriaNoticiaVO categoria = (CategoriaNoticiaVO)request.getSession().getAttribute(CATEGORIAMODVO);		 
			noticia.setCategoria(categoria);
			
			ArrayList descripcionesNoticia = new ArrayList();	
	//		Se añade las descripciones 
	//		Castellano
			if (castellano != null && castellano[0] != null  && castellano[1] != null && castellano[2] != null && castellano[3] != null)		
				descripcionesNoticia = crearNoticiaController.devuelveListaDescripciones(descripcionesNoticia, castellano[0], castellano[1], castellano[2], castellano[3]);
			
	//		Ingles
			if (ingles != null && ingles[0] != null  && ingles[1] != null && ingles[2] != null && ingles[3] != null)		
				descripcionesNoticia = crearNoticiaController.devuelveListaDescripciones(descripcionesNoticia, ingles[0], ingles[1], ingles[2], ingles[3]);
			
	//		Euskera
			if (euskera != null && euskera[0] != null  && euskera[1] != null && euskera[2] != null && euskera[3] != null)		
				descripcionesNoticia = crearNoticiaController.devuelveListaDescripciones(descripcionesNoticia, euskera[0], euskera[1], euskera[2], euskera[3]);
			
	//		Valenciano
			if (valenciano != null && valenciano[0] != null  && valenciano[1] != null && valenciano[2] != null && valenciano[3] != null)		
				descripcionesNoticia = crearNoticiaController.devuelveListaDescripciones(descripcionesNoticia, valenciano[0], valenciano[1], valenciano[2], valenciano[3]);
			
	//		Catalan
			if (catalan != null && catalan[0] != null  && catalan[1] != null && catalan[2] != null && catalan[3] != null)		
				descripcionesNoticia = crearNoticiaController.devuelveListaDescripciones(descripcionesNoticia, catalan[0], catalan[1], catalan[2], catalan[3]);
			
	//		Gallego
			if (gallego != null && gallego[0] != null  && gallego[1] != null && gallego[2] != null && gallego[3] != null)		
				descripcionesNoticia = crearNoticiaController.devuelveListaDescripciones(descripcionesNoticia, gallego[0], gallego[1], gallego[2], gallego[3]);
			
			DescripcionNoticiaVO[] descripcionesNoticiaArray = (DescripcionNoticiaVO[])descripcionesNoticia.toArray(new DescripcionNoticiaVO[0]);
			noticia.setDescripcionNoticia(descripcionesNoticiaArray);
			
//			Tratamiento de la imagen
			String imagenModificar = null;
			if (DOS.equals(form.getActivarImagen().toString()))
			{
				logger.debug("Sin imagen");
				imagenModificar = null;
				//Se comprueba si habia una imagen y si era asi se elimina
				if (noticiaModificable.getURLImagen() != null)
				{
//					Se elimina la imagen anterior
					this.getSrvNoticiasService().eliminarImagenNoticia(imagenEliminar(noticiaModificable.getURLImagen()));
				}
			}
			else if (UNO.equals(form.getActivarImagen().toString()))
			{
				logger.debug("Se conserva la imagen anterior");
//				Sigue la misma imagen
				imagenModificar = noticiaModificable.getURLImagen();				
				
			}
			else
			{
				logger.debug("Cambia la imagen o se introduce una nueva");
//				Cambio en la imagen
				imagenModificar = crearNoticiaController.tratamientoImagen((FormFile)request.getSession().getAttribute(IMAGEN));
				
//				Se elimina la imagen anterior si hubiera
				if (noticiaModificable.getURLImagen() != null)
				{
//					Se elimina la imagen anterior
					this.getSrvNoticiasService().eliminarImagenNoticia(imagenEliminar(noticiaModificable.getURLImagen()));
				}								
			}
			
			noticia.setAlineamientoImg(form.getAlineamiento());	
			noticia.setURLImagen(imagenModificar);			

			
			logger.debug("Se modifica en la base de datos la noticia");
			this.getSrvNoticiasService().limpiarNoticia(noticia.getId());
			this.getSrvNoticiasService().modificarNoticia(noticia);
			
			form.setIdModificado(form.getIdNoticia());
			
			//Se elimina el objeto introducido en sesion
			request.getSession().setAttribute(CATEGORIAMODVO, null);
			request.getSession().setAttribute(IMAGEN, null);
			request.getSession().setAttribute(VERNOTICIAVO, null);
			
		} catch (Exception e) 
		{
			logger.error("Error al modificar la noticia",e);
			throw new ValidatorException("{errors.noticias.modificar}");
			
		}
		
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
		
//		Los array tienen cuatro posiciones:
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
		
		CrearControllerImpl crearNoticiaController = new CrearControllerImpl();
		
		for (Enumeration names = request.getParameterNames(); names.hasMoreElements();)
		{
			String name = String.valueOf(names.nextElement());
			if (request.getParameter(name) != null && !(request.getParameter(name)).trim().equals(""))
			{
				if (name.endsWith(this.getPropertyValue("castellano")))
				{
					castellano = crearNoticiaController.rellenaArray(request,name, castellano);
					castellano[0] = this.getPropertyValue("castellano");
				}
				else if (name.endsWith(this.getPropertyValue("ingles")))
				{
					ingles = crearNoticiaController.rellenaArray(request,name, ingles);
					ingles[0] = this.getPropertyValue("ingles");
				}
				else if (name.endsWith(this.getPropertyValue("catalan")))
				{
					catalan = crearNoticiaController.rellenaArray(request,name, catalan);
					catalan[0] = this.getPropertyValue("catalan");
				}
				else if (name.endsWith(this.getPropertyValue("euskera")))
				{
					euskera = crearNoticiaController.rellenaArray(request,name, euskera);
					euskera[0] = this.getPropertyValue("euskera");
				}
				else if (name.endsWith(this.getPropertyValue("valenciano")))
				{
					valenciano = crearNoticiaController.rellenaArray(request,name, valenciano);
					valenciano[0] = this.getPropertyValue("valenciano");
				}
				else if (name.endsWith(this.getPropertyValue("gallego")))
				{
					gallego = crearNoticiaController.rellenaArray(request,name, gallego);
					gallego[0] = this.getPropertyValue("gallego");
				}
			}
			
		}		
		CategoriaNoticiaVO categoriaNoticia = (CategoriaNoticiaVO)request.getSession().getAttribute(CATEGORIAMODVO);
		crearNoticiaController.rellenaArrayIdiomaCategoria (castellano,catalan,ingles,euskera,gallego,valenciano,categoriaNoticia);
		
		logger.debug("Se valida el formulario");
		/**
		 * **************************************************************************************************************************************
		 * ************************************************ SE VALIDA EL FORMULARIO *************************************************************
		 * **************************************************************************************************************************************
		 * */
		if (!crearNoticiaController.validaFormulario(castellano, catalan, ingles, euskera, gallego, valenciano, request))
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
	
	private String imagenEliminar (String urlImagen) throws Exception
	{
		String stResult = null;
		if (urlImagen != null && !"".equals(urlImagen))
		{
			String[] urlImagenSplit = urlImagen.split("/");
			stResult = urlImagenSplit [urlImagenSplit.length - 1];
		}
		return stResult.trim();
	}
}