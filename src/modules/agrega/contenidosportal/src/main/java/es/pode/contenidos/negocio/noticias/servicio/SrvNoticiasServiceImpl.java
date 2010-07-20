/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.contenidos.negocio.noticias.servicio;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import es.pode.contenidos.negocio.noticias.dominio.CategoriaNoticia;
import es.pode.contenidos.negocio.noticias.dominio.CategoriaNoticiaDao;
import es.pode.contenidos.negocio.noticias.dominio.Noticia;
import es.pode.contenidos.negocio.noticias.dominio.NoticiaDao;
import es.pode.contenidos.negocio.noticias.dominio.NoticiasActivasFechaCriteria;


/**
 * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService
 */

public class SrvNoticiasServiceImpl extends
		es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasServiceBase {
	
	private static Logger log = Logger.getLogger(SrvNoticiasServiceImpl.class);

	/**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasServiceImpl#handleAlmacenarImagenNoticia(es.pode.contenidos.negocio.noticias.servicio.ImagenVO)
     * @param Parametros de la imagen
     * @return String Ruta de la imagen
     */
	protected String handleAlmacenarImagenNoticia(ImagenVO imagen) throws Exception {
//		 TODO Auto-generated method stub
		// Guarda en memoria la memoria y devuelve una ruta para acceder a ella
		// Obtenemos las propiedades

		InputStream fIsSpringProperties = this.getClass().getResourceAsStream(
				"/spring.properties");
		java.util.Properties pSpringProperties = new java.util.Properties();
		pSpringProperties.load(fIsSpringProperties);
		// guardamos la imagen
		File fImagen = new File(pSpringProperties.getProperty(
				"noticias.imagenes.path").toString()
				+ imagen.getNombre());
		fImagen.createNewFile();
		FileOutputStream fOsImagen = new FileOutputStream(fImagen);

		// fOsImagen.write(imagen.getDatos());

		imagen.getDatos().writeTo(fOsImagen);

		// liberamos recursos
		fOsImagen.close();

		// devolvemos el path de la imagen
		return pSpringProperties.getProperty("noticias.imagenes.url")
				+ imagen.getNombre();
	}

	/**
	 * Crea una categoria a partir del vo de categoria
	 * @param  CategoriaVO categoria: vo de la categoria que contiene los datos de la categoria a crear
	 * @return Long: Identificador de la categoria creada
	 * @throws Exception
	 */
	protected Long handleCrearCategoria(CategoriaNoticiaVO categoria) throws Exception
	{
		//Insertamos las descripciones
		if (log.isDebugEnabled()) log.debug("Creando la categoriaNoticia ["+categoria+"]");
		CategoriaIdiomaNoticiaVO[] idiomasVO = categoria.getCategoriaIdioma();
		if (idiomasVO!=null && idiomasVO.length>0){
			for (int i=0; i<idiomasVO.length; i++){
				idiomasVO[i] = this.getCategoriaIdiomaNoticiaDao().toCategoriaIdiomaNoticiaVO(
						(this.getCategoriaIdiomaNoticiaDao().create(
								this.getCategoriaIdiomaNoticiaDao().fromCategoriaIdiomaNoticiaVO(idiomasVO[i]))));
			}
		}
		//Añadimos las descripciones
		categoria.setCategoriaIdioma(idiomasVO);
		CategoriaNoticia categoriaEntity = this.getCategoriaNoticiaDao().fromCategoriaNoticiaVO(categoria);
		categoriaEntity.setFechaPublicacion(new Date());
		CategoriaNoticia create = this.getCategoriaNoticiaDao().create(categoriaEntity);
		return create.getId();			
	}
	
	/**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasServiceImpl#handleCrearNoticia(es.pode.contenidos.negocio.noticias.servicio.NoticiaVO)
     * @param Parametros de la noticia
     * @return Long identificador de la noticia en BBDD
     */
	protected Long handleCrearNoticia(NoticiaVO noticia) throws Exception {

		//Creamos las descripciones
		DescripcionNoticiaVO[] descripcionesVO = noticia.getDescripcionNoticia();
		if (descripcionesVO!=null && descripcionesVO.length>0){
			for (int i=0; i<descripcionesVO.length; i++){
				descripcionesVO[i] = this.getDescripcionNoticiaDao().toDescripcionNoticiaVO(
						(this.getDescripcionNoticiaDao().create(
								this.getDescripcionNoticiaDao().fromDescripcionNoticiaVO(descripcionesVO[i]))));
			}
		}
		//Añadimos las descripciones
		noticia.setDescripcionNoticia(descripcionesVO);
		Noticia noticiaEntity = this.getNoticiaDao().fromNoticiaVO(noticia);
		noticiaEntity.setFechaPublicacion(new Date());
		Noticia creada = this.getNoticiaDao().create(noticiaEntity);
		return creada.getId();
	}

	/**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasServiceImpl#handleEliminarCategoria(Long)
     * @param Long Identificador de la categoría
     */
	protected void handleEliminarCategoria(Long id) throws Exception {
		//eliminamos las descripciones
		Collection desc = this.getCategoriaNoticiaDao().load(id).getCategoriaIdioma();
		this.getCategoriaIdiomaNoticiaDao().remove(desc);
		//eliminamos la categoria
		this.getCategoriaNoticiaDao().remove(id);
	}

	/**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasServiceImpl#handleEliminarCategorias(Long[])
     * @param Long[] Identificadores de categorías
     */
	protected void handleEliminarCategorias(Long[] idList) throws Exception {
		for (int i=0; i<idList.length;i++){
			this.handleEliminarCategoria(idList[i]);
		}
	}

	/**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasServiceImpl#handleEliminarNoticia(Long)
     * @param Long Identificador de noticia
     */
	protected void handleEliminarNoticia(Long id) throws Exception {
		//Comprobamos si la noticia tenia imagen; y si era así la eliminamos
		Noticia noticiaEliminar = this.getNoticiaDao().load(id);
		String imagen = noticiaEliminar.getURLImagen();
		if (imagen != null && !"".equals(imagen))
		{
			if (log.isDebugEnabled()) log.debug("Se elimina la imagen de la noticia con identificador ["+id+"]");
			this.handleEliminarImagenNoticia(imagenEliminar(imagen));
		}
		//eliminamos las descripciones
		Collection desc = this.getNoticiaDao().load(id).getDescripcionNoticia();
		this.getDescripcionNoticiaDao().remove(desc);
		//eliminamos la noticia
		this.getNoticiaDao().remove(id);
	}

	/**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasServiceImpl#handleEliminarNoticias(Long[])
     * @param Long[] Identificadores de noticias
     */
	protected void handleEliminarNoticias(Long[] idList) throws Exception {
		for (int i=0; i<idList.length;i++){
			this.handleEliminarNoticia(idList[i]);
		}
	}
	
	/**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasServiceImpl#handleModificarCategoria(es.pode.contenidos.negocio.noticias.servicio.CategoriaNoticiaVO)
     * @param CategoriaNoticiaVO Parámetros de la categoría de la noticia
     */
	protected void handleModificarCategoria(CategoriaNoticiaVO categoria) throws Exception {
		if (log.isDebugEnabled()) log.debug("Modificando la categoriaNoticia ["+categoria+"]");
		//Insertamos las nuevas descripciones
		CategoriaIdiomaNoticiaVO[] idiomasVO = categoria.getCategoriaIdioma();
		if (idiomasVO!=null && idiomasVO.length>0){
			for (int i=0; i<idiomasVO.length; i++){
				idiomasVO[i] = this.getCategoriaIdiomaNoticiaDao().toCategoriaIdiomaNoticiaVO(
						(this.getCategoriaIdiomaNoticiaDao().create(
								this.getCategoriaIdiomaNoticiaDao().fromCategoriaIdiomaNoticiaVO(idiomasVO[i]))));
			}
		}
		categoria.setCategoriaIdioma(idiomasVO);
		//Actualizamos la categoría
		CategoriaNoticia categoriaEntity = this.getCategoriaNoticiaDao().fromCategoriaNoticiaVO(categoria);
		categoriaEntity.setFechaModificacion(new Date());
		this.getCategoriaNoticiaDao().update(categoriaEntity);
	}

	/**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasServiceImpl#handleModificarNoticia(es.pode.contenidos.negocio.noticias.servicio.NoticiaVO)
     * @param CategoriaNoticiaVO Parámetros de la noticia
     */
	protected void handleModificarNoticia(NoticiaVO noticia) throws Exception {
		//Creamos las nuevas descripciones de la noticia
		DescripcionNoticiaVO[] descripcionesVO = noticia.getDescripcionNoticia();
		if (descripcionesVO!=null && descripcionesVO.length>0){
			for (int i=0; i<descripcionesVO.length; i++){
				descripcionesVO[i] = this.getDescripcionNoticiaDao().toDescripcionNoticiaVO(
						(this.getDescripcionNoticiaDao().create(
								this.getDescripcionNoticiaDao().fromDescripcionNoticiaVO(descripcionesVO[i]))));
			}
		}
		noticia.setDescripcionNoticia(descripcionesVO);
		//Actualizamos la noticia
		Noticia noticiaEntity = this.getNoticiaDao().fromNoticiaVO(noticia);
		noticiaEntity.setFechaModificacion(new Date());
		this.getNoticiaDao().update(noticiaEntity);
	}

	/**
	 * Obtiene una categoria noticia a partir de su id
	 * @param  Long id: Identificador de la categoria que se quiere recuperar.
	 * @return CategoriaNoticiaVO: vo que contiene todos los datos de la categoria noticia.
	 * @throws Exception
	 */
	protected CategoriaNoticiaVO handleObtenerCategoria(Long id) throws Exception
	{		
		if(log.isDebugEnabled()) log.debug("Obtenemos la categoriaNoticia con identificador ["+id+"]");		
		CategoriaNoticiaVO categoria = (CategoriaNoticiaVO) this.getCategoriaNoticiaDao().load(CategoriaNoticiaDao.TRANSFORM_CATEGORIANOTICIAVO, id);
		return categoria;		
	}

	/**
	 * Obtiene todas las categorias notica que existen en la base de datos.
	 * @param  void:
	 * @return CategoriaNoticiaVO[]: array de vo que contiene todos los datos de las categorias noticia.
	 * @throws Exception
	 */
	protected CategoriaNoticiaVO[] handleObtenerCategorias() throws Exception 
	{
		log.debug("Recuperando las caterias noticia de la base de datos");	
		CategoriaNoticiaVO[] categorias = (CategoriaNoticiaVO[])this.getCategoriaNoticiaDao().
											obtenerCategorias(CategoriaNoticiaDao.TRANSFORM_CATEGORIANOTICIAVO).toArray(new CategoriaNoticiaVO[0]);
		if(log.isDebugEnabled()) log.debug("El numero de categorias idioma es ["+categorias.length+"]");
		
		return categorias;

	}

	/**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasServiceImpl#handleCrearNoticia(Long)
     * @param Long Identificador de noticia
     * @return NoticiaVO Noticia obtenida
     */
	protected NoticiaVO handleObtenerNoticia(Long id) throws Exception {
		if(log.isDebugEnabled()) log.debug("Obtenemos la Noticia con identificador ["+id+"]");		
		NoticiaVO noticia = (NoticiaVO) this.getNoticiaDao().load(NoticiaDao.TRANSFORM_NOTICIAVO, id);
		return noticia;		
	}

	/**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasServiceImpl#handleObtenerNoticias()
     * @return NoticiaVO[] Noticias obtenidas
     */
	protected NoticiaVO[] handleObtenerNoticias() throws Exception {
		log.debug("Recuperando las noticias de la base de datos");	
		NoticiaVO[] noticias = (NoticiaVO[])this.getNoticiaDao().
											obtenerNoticias(NoticiaDao.TRANSFORM_NOTICIAVO).toArray(new NoticiaVO[0]);
		if(log.isDebugEnabled()) log.debug("El numero de categorias idioma es ["+noticias.length+"]");
		
		return noticias;
	}

	/**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasServiceImpl#handleObtenerNoticiasActivas(Integer)
     * @param Integer Número de noticias a obtener
     * @return NoticiaVO[] Noticias obtenidas
     */
	protected NoticiaVO[] handleObtenerNoticiasActivas(Integer numResultados) throws Exception {
		NoticiasActivasFechaCriteria criteria = new NoticiasActivasFechaCriteria();
		if (numResultados.equals(new Integer(-1)))
			criteria.setMaximumResultSize(null);
		else
			criteria.setMaximumResultSize(numResultados);
		
		return (NoticiaVO[])this.getNoticiaDao()
				.obtenerNoticiasActivas(NoticiaDao.TRANSFORM_NOTICIAVO, criteria).toArray(new NoticiaVO[0]);
	}

	/**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasServiceImpl#handleLimpiarCategoria(Long)
     * @param Long identificador de la categoria a borrar
     */
	protected void handleLimpiarCategoria(Long id) throws Exception {
		Collection desc = this.getCategoriaNoticiaDao().load(id).getCategoriaIdioma();
		this.getCategoriaIdiomaNoticiaDao().remove(desc);
	}

	/**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasServiceImpl#handleLimpiarNoticia(Long)
     * @param Long identificador de la noticia a borrar
     */
	protected void handleLimpiarNoticia(Long id) throws Exception {
		Collection desc = this.getNoticiaDao().load(id).getDescripcionNoticia();
		this.getDescripcionNoticiaDao().remove(desc);
	}
	
	private NoticiaTraducidaVO toNoticiaTraducidaVO (NoticiaVO noticia, String idioma){
		
		NoticiaTraducidaVO resultado= new NoticiaTraducidaVO();
		resultado.setIdNoticia(noticia.getId());
		resultado.setAlineamientoImg(noticia.getAlineamientoImg());
		resultado.setURLImagen(noticia.getURLImagen());
		resultado.setAutor(noticia.getAutor());
		resultado.setFechaPublicacion(noticia.getFechaPublicacion());
		resultado.setActiva(noticia.getActiva());		
		
		//buscamos la traducción de la categoría
		if (noticia.getCategoria()!=null && noticia.getCategoria().getCategoriaIdioma()!=null){
			resultado.setIdCategoria(noticia.getCategoria().getId());
			for (int j=0; j<noticia.getCategoria().getCategoriaIdioma().length;j++){
				if (noticia.getCategoria().getCategoriaIdioma()[j].getIdioma().trim().equals(idioma.trim())){
					resultado.setCategoria(noticia.getCategoria().getCategoriaIdioma()[j].getNombreCategoria());
					break;
				}
			}
		}
		//buscamos la traducción de la descripción
		if (noticia.getDescripcionNoticia()!=null && noticia.getDescripcionNoticia().length>0){
			String idiomas = "";
			for (int j=0; j<noticia.getDescripcionNoticia().length;j++){
				if (noticia.getDescripcionNoticia()[j].getIdioma().trim().equals(idioma.trim())){
					resultado.setTitulo(noticia.getDescripcionNoticia()[j].getTitulo());
					resultado.setCuerpo(noticia.getDescripcionNoticia()[j].getCuerpo());
					resultado.setResumen(noticia.getDescripcionNoticia()[j].getResumen());
				}
				idiomas = idiomas + noticia.getDescripcionNoticia()[j].getIdioma().trim() + " "; 
			}
			resultado.setIdiomas(idiomas.trim().replaceAll(" ", ","));
		}
		return resultado;
	}

	/**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasServiceImpl#handleListarNoticiasActivasPorIdioma(String)
     * @param String idioma
     * @return NoticiaTraducidaVO[] Noticias traducidas obtenidas
     */
	protected NoticiaTraducidaVO[] handleListarNoticiasActivasPorIdioma(String idioma) throws Exception {
		//buscamos las noticias en el idoma por defecto
		NoticiaVO[] noticias = (NoticiaVO[])this.getNoticiaDao().obtenerNoticiasActivasPorIdioma(NoticiaDao.TRANSFORM_NOTICIAVO,idioma).toArray(new NoticiaVO[0]);
		NoticiaTraducidaVO[] resultado = null;
		if (noticias!= null){
			resultado = new NoticiaTraducidaVO[noticias.length];
			for (int i=0; i<noticias.length;i++){
				resultado[i]=toNoticiaTraducidaVO(noticias[i], idioma);
			}
		}
		return resultado;
	}

	/**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasServiceImpl#handleObtenerNoticiaTraducida(Long , String)
     * @param Long identificador de noticia
     * @param Idioma de traducción de noticia 
     * @return NoticiaTraducidaVO Noticia traducida obtenida
     */
	protected NoticiaTraducidaVO handleObtenerNoticiaTraducida(Long id, String idioma) throws Exception {
		try
		{
			if(log.isDebugEnabled()) log.debug("Obtenemos la Noticia con identificador ["+id+"]");			
			NoticiaVO noticia = (NoticiaVO) this.getNoticiaDao().load(NoticiaDao.TRANSFORM_NOTICIAVO, id);
			return toNoticiaTraducidaVO(noticia, idioma);	
		}
		catch (Exception e)
		{
			if (log.isDebugEnabled()) log.debug("No se ha podido cargar la noticia con id ["+id+"]");
			return null;
		}
			
	}	
	
	/**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasServiceImpl#handleObtenerNoticiasActivasPorIdiomayCategoria(String,Long)
     * @param Long identificador de noticia
     * @param Idioma de traducción de noticia 
     * @return NoticiaTraducidaVO[] Noticias activas traducidas obtenidas
     */
	protected NoticiaTraducidaVO[] handleObtenerNoticiasActivasPorIdiomayCategoria(String idioma, Long id) throws Exception {
        if (log.isDebugEnabled()) log.debug("Recuperando las noticias con traduccion en el idioma ["+idioma+"]");
        NoticiaVO[]noticias = (NoticiaVO[])this.getNoticiaDao().obtenerNoticiasActivasPorIdiomayCategoria(NoticiaDao.TRANSFORM_NOTICIAVO, idioma, id).toArray(new NoticiaVO[0]);
        NoticiaTraducidaVO[] resultado = null;
        if (noticias!= null){
              resultado = new NoticiaTraducidaVO[noticias.length];
              for (int i=0; i<noticias.length;i++){
                    resultado[i]=toNoticiaTraducidaVO(noticias[i], idioma);
              }
        }
        return resultado;
    }
	
	/**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasServiceImpl#handleObtenerNoticiasTraducidas(String[])
     * @param String[] Idiomas de traducción de noticia 
     * @return NoticiaTraducidaVO[] Todas las noticias traducidas a determinados idiomas
     */
	protected NoticiaTraducidaVO[] handleObtenerNoticiasTraducidas(String[] idiomasTraducibles) throws Exception {
		
//		Se obtienen todas las noticias que hay en la base de datos.
		NoticiaVO[] listaNoticias = this.handleObtenerNoticias();
		if (log.isDebugEnabled()) log.debug("Hay ["+listaNoticias.length+"] noticias en la base de datos");
		
		List listaNoticiasTraducidas = new ArrayList();	
		
		for (int i = 0; listaNoticias != null && i <listaNoticias.length; i++)
		{
			List listaIdiomas = new ArrayList();		
			listaIdiomas = (List)this.getNoticiaDao().obtenerIdiomasFromIdNoticia(listaNoticias[i].getId());
			String[] idiomas = (String[])listaIdiomas.toArray(new String[0]);			
			NoticiaTraducidaVO noticiaTraducida = this.handleObtenerNoticiaTraducida(listaNoticias[i].getId(), buscarIdioma(idiomasTraducibles, idiomas));
			listaNoticiasTraducidas.add(noticiaTraducida);
			
		}		
		return (NoticiaTraducidaVO[])listaNoticiasTraducidas.toArray(new NoticiaTraducidaVO[0]);
		
	}
	
	private String buscarIdioma(String[] idiomasTraducibles, String[] idiomas) throws Exception
	{
		String idioma = "";
		boolean encontrado = false;
		for (int i = 0; !encontrado && idiomasTraducibles != null && i < idiomasTraducibles.length; i++)
		{
			for (int j = 0; !encontrado && idiomas != null && j < idiomas.length; j++)
			{
				if (idiomasTraducibles[i].trim().equals(idiomas[j].trim()))
				{
					encontrado = true;
					idioma = idiomasTraducibles[i];
				}
			}
		}
		if (log.isDebugEnabled()) log.debug("El idioma al que hay que traducir la noticia es ["+idioma+"]");
		return idioma;
	}	

	/**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasServiceImpl#handleObtenerCategoriaTraducida(Long,String)
     * @param Long Identificador de categoría
     * @param String Idioma de traducción de categoría 
     * @return CategoriaNoticiaTraducidaVO Categoría traducida a un idioma
     */
	protected CategoriaNoticiaTraducidaVO handleObtenerCategoriaTraducida(Long id, String idioma) throws Exception {
		if(log.isDebugEnabled()) log.debug("Obtenemos la Categoria con identificador ["+id+"]");	
		CategoriaNoticiaVO categoria = (CategoriaNoticiaVO) this.getCategoriaNoticiaDao().load(CategoriaNoticiaDao.TRANSFORM_CATEGORIANOTICIAVO, id);
		return toCategoriaTraducidaVO(categoria, idioma);		
	}

	/**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasServiceImpl#handleObtenerCategoriasTraducidas(String[])
     * @param String[] Idiomas de traducción de categorías 
     * @return CategoriaNoticiaTraducidaVO Categorías traducidas a idiomas
     */
	protected CategoriaNoticiaTraducidaVO[] handleObtenerCategoriasTraducidas(String[] idiomasTraducibles) throws Exception {		
//			Se obtienen todas las categorias que hay en la base de datos.
			CategoriaNoticiaVO[] listaCategorias = this.handleObtenerCategorias();
			if (log.isDebugEnabled()) log.debug("Hay ["+listaCategorias.length+"] categorias en la base de datos");
			
			List listaCategoriasTraducidas = new ArrayList();
			
			for (int i = 0; listaCategorias != null && i < listaCategorias.length; i++)
			{
				List listaIdiomas = new ArrayList();
				listaIdiomas = (List)this.getCategoriaNoticiaDao().obtenerIdiomasFromIdCategoria(listaCategorias[i].getId());
				String[] idiomas = (String[])listaIdiomas.toArray(new String[0]);	
				CategoriaNoticiaTraducidaVO categoriaTraducida = this.handleObtenerCategoriaTraducida(listaCategorias[i].getId(), buscarIdioma(idiomasTraducibles, idiomas));
				listaCategoriasTraducidas.add(categoriaTraducida);
			}
			
			return (CategoriaNoticiaTraducidaVO[])listaCategoriasTraducidas.toArray(new CategoriaNoticiaTraducidaVO[0]);				

		}
	
	private CategoriaNoticiaTraducidaVO toCategoriaTraducidaVO (CategoriaNoticiaVO categoria, String idioma) throws Exception
	{
		CategoriaNoticiaTraducidaVO resultado = new CategoriaNoticiaTraducidaVO();
		resultado.setIdCategoriaNoticia(categoria.getId());				
		
//		Buscamos la traduccion de la categoria
		if (categoria.getCategoriaIdioma() != null && categoria.getCategoriaIdioma().length > 0)
		{
			String idiomas = "";
			for (int i = 0; i < categoria.getCategoriaIdioma().length; i++)
			{
				if (categoria.getCategoriaIdioma()[i].getIdioma().equals(idioma))
				{
					resultado.setNombreCategoria(categoria.getCategoriaIdioma()[i].getNombreCategoria());
					resultado.setIdCategoriaIdiomaNoticia(categoria.getCategoriaIdioma()[i].getId());					
				}
				idiomas = idiomas + categoria.getCategoriaIdioma()[i].getIdioma() + " ";
			}
			resultado.setIdioma(idiomas.trim().replaceAll(" ", ","));
		}
		return resultado;	

	}

	/**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasServiceImpl#handleObtenerCategoriaTraducida(Long,String)
     * @param Long Identificador de categoría
     * @param String[] Idiomas de traducción de categorías 
     * @return NoticiaTraducidaVO[] Noticias de una categoría traducidas a determinados idiomas
     */
	protected NoticiaTraducidaVO[] handleObtenerNoticiasFromIdCategoria(Long idCategoria, String[] idiomasTraducibles) throws Exception {
//		Se llama al metodo que obtiene las noticias asociadas al identificador categoria
		if (log.isDebugEnabled()) log.debug("El identificador de la categoria es ["+idCategoria+"]");			
		NoticiaVO[] noticias = (NoticiaVO[])this.getNoticiaDao().obtenerNoticiasByIdCategoria(NoticiaDao.TRANSFORM_NOTICIAVO, idCategoria).toArray(new NoticiaVO[0]);
		if (log.isDebugEnabled()) log.debug("Se han recuperado de la basde de datos ["+noticias.length+"] asociadas a la categoria con id ["+idCategoria+"]");
		
		List listaNoticiasTraducidas = new ArrayList();	
		
		for (int i = 0; noticias != null && i < noticias.length; i++)
		{
			List listaIdiomas = new ArrayList();		
			listaIdiomas = (List)this.getNoticiaDao().obtenerIdiomasFromIdNoticia(noticias[i].getId());
			String[] idiomas = (String[])listaIdiomas.toArray(new String[0]);			
			NoticiaTraducidaVO noticiaTraducida = this.handleObtenerNoticiaTraducida(noticias[i].getId(), buscarIdioma(idiomasTraducibles, idiomas));
			listaNoticiasTraducidas.add(noticiaTraducida);
			
		}		
		return (NoticiaTraducidaVO[])listaNoticiasTraducidas.toArray(new NoticiaTraducidaVO[0]);
	}

	/**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasServiceImpl#handleEliminarImagenNoticia(String)
     * @param String Imagen a eliminar 
     * @return Boolean Flag de eliminación
     */
	protected Boolean handleEliminarImagenNoticia(String imagenEliminarSt) throws Exception
	{
		Boolean resultado = new Boolean(false);		
		
		if(imagenEliminarSt == null || imagenEliminarSt.equals(""))
		{
			if(log.isDebugEnabled()) log.debug("no se ha indicado el nombre del fichero");
			return resultado;
		}
		
		//Se obtiene el directorio
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/spring.properties");
		java.util.Properties pSpringProperties = new java.util.Properties();
		pSpringProperties.load(fIsSpringProperties);

		File fichero = new File(pSpringProperties.getProperty("noticias.imagenes.path").toString() + imagenEliminarSt);		
		
		if(fichero.exists())
		{
			if(log.isDebugEnabled()) log.debug("se procede a eliminar el fichero");
			fichero.delete();
			resultado = new Boolean(true);
		}
		fichero=null;
		if(!resultado.booleanValue())
			if(log.isDebugEnabled()) log.debug("no se ha podido eliminar el fichero indicado");
		return resultado;
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