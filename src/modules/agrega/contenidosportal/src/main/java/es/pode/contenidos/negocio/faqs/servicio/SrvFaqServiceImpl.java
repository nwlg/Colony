/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.contenidos.negocio.faqs.servicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import es.pode.contenidos.negocio.comun.ListaOrdenada;
import es.pode.contenidos.negocio.faqs.dominio.CategoriaFaq;
import es.pode.contenidos.negocio.faqs.dominio.CategoriaFaqDao;
import es.pode.contenidos.negocio.faqs.dominio.DescripcionFaq;
import es.pode.contenidos.negocio.faqs.dominio.Faq;
import es.pode.contenidos.negocio.faqs.dominio.FaqDao;

/**
 * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService
 */

public class SrvFaqServiceImpl extends
		es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceBase {
	
	private static Logger logger = Logger.getLogger(SrvFaqServiceImpl.class);	
	
	/**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceImpl#handleCrearFaq() 
     * @return FaqVO[] Faqs obtenidas
     */
	protected es.pode.contenidos.negocio.faqs.servicio.FaqVO[] handleObtenerFaqs()
			throws java.lang.Exception {
		java.util.Collection faqs = this.getFaqDao().obtenerFaqs(
				FaqDao.TRANSFORM_FAQVO);
		return (FaqVO[]) faqs.toArray(new FaqVO[] {});
	}

	/**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceImpl#handleCrearFaq(es.pode.contenidos.negocio.faqs.servicio.FaqVO)
     * @param FaqVO Faq a crear 
     * @return FaqVO creada
     */
	protected es.pode.contenidos.negocio.faqs.servicio.FaqVO handleCrearFaq(es.pode.contenidos.negocio.faqs.servicio.FaqVO faq)
			throws java.lang.Exception {
		// Comprueba la posicion y desplaza los que esten por debajo
		if (faq.getDescripcionFaq()!=null && faq.getDescripcionFaq().length>0){
			DescripcionFaqVO[] desc = faq.getDescripcionFaq(); 
			for (int i=0; i<desc.length; i++){
				List faqs = this.getDescripcionFaqDao().obtenerFaqsDesde(desc[i].getPosicion(), desc[i].getIdioma());
				if (faqs.size() > 0) {
					for (int j = 0; j < faqs.size(); j++) {
						int pos = ((DescripcionFaq) faqs.get(j)).getPosicion().intValue() + 1;
						((DescripcionFaq) faqs.get(j)).setPosicion(new Integer(pos));
					}
					this.getDescripcionFaqDao().update(faqs);
				}
			}
		}
		
		//Creamos las descripciones
		DescripcionFaqVO[] descripcionesVO = faq.getDescripcionFaq();
		if (descripcionesVO!=null && descripcionesVO.length>0){
			for (int i=0; i<descripcionesVO.length; i++){
				descripcionesVO[i] = this.getDescripcionFaqDao().toDescripcionFaqVO(
						(this.getDescripcionFaqDao().create(
								this.getDescripcionFaqDao().fromDescripcionFaqVO(descripcionesVO[i]))));
			}
		}
		//Añadimos las descripciones
		faq.setDescripcionFaq(descripcionesVO);

		// Crea la nueva FAQ
		Faq entityFaq = this.getFaqDao().fromFaqVO(faq);
		entityFaq.setFechaPublicacion(new Date());		
		
//		CategoriaFaq categoria = obtenerCategoriaFaq(faq.getCategoriaFaq());
//		entityFaq.setCategoriaFaq(categoria);
		
		Faq nuevoFaq = this.getFaqDao().create(entityFaq);
		return this.getFaqDao().toFaqVO(nuevoFaq);
	}

	/**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceImpl#handleModificarFaq(es.pode.contenidos.negocio.faqs.servicio.FaqVO)
     * @param FaqVO Faq a modificar
     * @return FaqVO modificada
     */
	protected es.pode.contenidos.negocio.faqs.servicio.FaqVO handleModificarFaq(es.pode.contenidos.negocio.faqs.servicio.FaqVO faq)
			throws java.lang.Exception {
		
		
		
		// Comprueba la posicion y desplaza los que esten por debajo
		if (faq.getDescripcionFaq()!=null && faq.getDescripcionFaq().length>0){
			DescripcionFaqVO[] desc = faq.getDescripcionFaq(); 
			for (int i=0; i<desc.length; i++){
				List faqs = this.getDescripcionFaqDao().obtenerFaqsDesde(desc[i].getPosicion(), desc[i].getIdioma());
				if (faqs.size() > 0) {
					for (int j = 0; j < faqs.size(); j++) {
						int pos = ((DescripcionFaq) faqs.get(j)).getPosicion().intValue() + 1;
						((DescripcionFaq) faqs.get(j)).setPosicion(new Integer(pos));
					}
					this.getDescripcionFaqDao().update(faqs);
				}
			}
		}

		
		//Creamos las descripciones
		DescripcionFaqVO[] descripcionesVO = faq.getDescripcionFaq();
		if (descripcionesVO!=null && descripcionesVO.length>0){
			for (int i=0; i<descripcionesVO.length; i++){
				descripcionesVO[i] = this.getDescripcionFaqDao().toDescripcionFaqVO(
						(this.getDescripcionFaqDao().create(
								this.getDescripcionFaqDao().fromDescripcionFaqVO(descripcionesVO[i]))));
			}
		}
		//Añadimos las descripciones
		faq.setDescripcionFaq(descripcionesVO);
		
		
		Faq faqEntity = this.getFaqDao().fromFaqVO(faq);
		faqEntity.setFechaModificacion(new Date());
		this.getFaqDao().update(faqEntity);		
		return this.getFaqDao().toFaqVO(faqEntity);
	}

	/**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceImpl#handleConsultaFaq(java.lang.Long)
     * @param FaqVO Identificador de Faq
     * @return FaqVO obtenida
     */
	protected es.pode.contenidos.negocio.faqs.servicio.FaqVO handleConsultaFaq(java.lang.Long id) throws java.lang.Exception {
		FaqVO faqVO = (FaqVO) this.getFaqDao().load(FaqDao.TRANSFORM_FAQVO, id);
		return faqVO;
	}

	/**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceImpl#handleObtenerFaqsPorIdioma(java.lang.String)
     * @param String Idioma
     * @return es.pode.contenidos.negocio.faqs.servicio.FaqTraducidaVO[] Faqs traducidas obtenidas
     */
	protected es.pode.contenidos.negocio.faqs.servicio.FaqTraducidaVO[] handleObtenerFaqsPorIdioma(java.lang.String idioma) throws java.lang.Exception {
		logger.debug("obteniendo todas las faqs por idioma: " + idioma);
		FaqVO[] faqs = (FaqVO[]) this.getFaqDao().obtenerFaqsPorIdioma(
				FaqDao.TRANSFORM_FAQVO, idioma).toArray(new FaqVO[] {});
		FaqTraducidaVO[] resultado = null;
		if (faqs!= null){
			resultado = new FaqTraducidaVO[faqs.length];
			for (int i=0; i<faqs.length;i++){
				resultado[i]=toFaqTraducidaVO(faqs[i], idioma);
			}
		}
		return resultado;
	}

	/**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceImpl#handleObtenCategoriasFaqs(java.lang.String)
     * @param String Idioma
     * @return es.pode.contenidos.negocio.faqs.servicio.CategoriaTraducidaVO[] Categorías de faq traducidas obtenidas
     */
	protected CategoriaTraducidaVO[] handleObtenCategoriasFaqs(String idioma) throws Exception {
		
		logger.debug("Obteniendo las categorias faqs para idioma: "+ idioma );				
		CategoriaFaqVO[] categorias = (CategoriaFaqVO[])this.getCategoriaFaqDao().obtenCategoriasFaqs(CategoriaFaqDao.TRANSFORM_CATEGORIAFAQVO, idioma).toArray(new CategoriaFaqVO[] {});
		
		CategoriaTraducidaVO[] resultado = null;
		if (categorias!= null){
			resultado = new CategoriaTraducidaVO[categorias.length];
			for (int i=0; i<categorias.length;i++){
				resultado[i]=toCategoriaTraducidaVO(categorias[i], idioma);
			}
		}
		return resultado;
	}
	
	/**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceImpl#handleObtenFaqsPorIdiomaCategoria(String, Long)
     * @param String Idioma
     * @param Long Identificador de categoría
     * @return FaqTraducidaVO[] Faqs traducidas para una categoría e idioma obtenidas
     */
	protected FaqTraducidaVO[] handleObtenFaqsPorIdiomaCategoria(String idioma, Long categoria) throws Exception {
				
		//teoricamente no hace falta el idioma para la categoria pq el nombre de la categoria es unique
		logger.debug("Obtenienido faqs por categoria: " + categoria + " en idioma: "+idioma);
		FaqVO[] faqs = (FaqVO[]) this.getFaqDao().obtenerFaqsPorIdiomaCategoria(FaqDao.TRANSFORM_FAQVO, idioma, categoria).toArray(new FaqVO[] {});		

		FaqTraducidaVO[] resultado = null;
		if (faqs!= null){
			resultado = new FaqTraducidaVO[faqs.length];
			for (int i=0; i<faqs.length;i++){
				resultado[i]=toFaqTraducidaVO(faqs[i], idioma);
			}
		}
		return resultado;

		
	}

	/**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceImpl#handleObtenFaqsPorIdiomaCategoria(String, Long)
     * @param String Idioma
     * @param Long Identificador faq
     * @return FaqTraducidaVO Faq traducida obtenida
     */
	protected FaqTraducidaVO handleObtenerFaqTraducida(Long id, String idioma) throws Exception {
		FaqVO faqVO = (FaqVO) this.getFaqDao().load(FaqDao.TRANSFORM_FAQVO, id);
		return toFaqTraducidaVO(faqVO, idioma);
	}
	
	
	private FaqTraducidaVO toFaqTraducidaVO (FaqVO faq, String idioma){
		
		FaqTraducidaVO resultado= new FaqTraducidaVO();
		resultado.setId(faq.getId());
		resultado.setFechaPublicacion(faq.getFechaPublicacion());
		resultado.setIdCategoria(faq.getCategoria().getId());
		
		//buscamos la traducción de la categoría
		if (faq.getCategoria()!=null && faq.getCategoria().getCategoriaIdioma()!=null){
			resultado.setIdCategoria(faq.getCategoria().getId());
			for (int j=0; j<faq.getCategoria().getCategoriaIdioma().length;j++){
				if (faq.getCategoria().getCategoriaIdioma()[j].getIdioma().trim().equals(idioma.trim())){
					resultado.setCategoria(faq.getCategoria().getCategoriaIdioma()[j].getNombre());
					break;
				}
			}
		}
		//buscamos la traducción de la descripción
		if (faq.getDescripcionFaq()!=null && faq.getDescripcionFaq().length>0){
			String idiomas = "";
			for (int j=0; j<faq.getDescripcionFaq().length;j++){
				if (faq.getDescripcionFaq()[j].getIdioma().trim().equals(idioma.trim())){
					resultado.setPregunta(faq.getDescripcionFaq()[j].getPregunta());
					resultado.setRespuesta(faq.getDescripcionFaq()[j].getRespuesta());
					resultado.setPosicion(faq.getDescripcionFaq()[j].getPosicion());
					
				}
				idiomas = idiomas + faq.getDescripcionFaq()[j].getIdioma().trim() + " "; 
			}
			resultado.setIdiomas(idiomas.trim().replaceAll(" ", ","));
		}
		return resultado;
	}

	/**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceImpl#handleCrearCategoria(CategoriaFaqVO)
     * @param CategoriaFaqVO Categoría de faq a crear
     * @return Long identificador de categoria
     */
	protected Long handleCrearCategoria(CategoriaFaqVO categoria) throws Exception {
		//Insertamos las descripciones
		CategoriaIdiomaFaqVO[] idiomasVO = categoria.getCategoriaIdioma();
		if (idiomasVO!=null && idiomasVO.length>0){
			for (int i=0; i<idiomasVO.length; i++){
				idiomasVO[i] = this.getCategoriaIdiomaFaqDao().toCategoriaIdiomaFaqVO(
						(this.getCategoriaIdiomaFaqDao().create(
								this.getCategoriaIdiomaFaqDao().fromCategoriaIdiomaFaqVO(idiomasVO[i]))));
			}
		}
		//Añadimos las descripciones
		categoria.setCategoriaIdioma(idiomasVO);
		CategoriaFaq categoriaEntity = this.getCategoriaFaqDao().fromCategoriaFaqVO(categoria);
		categoriaEntity.setFechaAlta(new Date());
		CategoriaFaq create = this.getCategoriaFaqDao().create(categoriaEntity);
		return create.getId();
		
	}

	/**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceImpl#handleEliminarCategoria(Long)
     * @param Long identificador de categoria
     */
	protected void handleEliminarCategoria(Long id) throws Exception {
		//eliminamos las descripciones
		Collection desc = this.getCategoriaFaqDao().load(id).getCategoriaIdioma();
		this.getCategoriaIdiomaFaqDao().remove(desc);
		//eliminamos la categoria
		this.getCategoriaFaqDao().remove(id);
	}

	/**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceImpl#handleEliminarCategorias(Long[])
     * @param Long[] identificadores de categorias
     */
	protected void handleEliminarCategorias(Long[] ids) throws Exception {
		for (int i=0; i<ids.length;i++){
			this.handleEliminarCategoria(ids[i]);
		}	}

	/**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceImpl#handleListarCategorias()
     * @return CategoriaFaqVO[] Todas las categorias de faq
     */
	protected CategoriaFaqVO[] handleListarCategorias() throws Exception {
		CategoriaFaqVO[] categorias = (CategoriaFaqVO[])this.getCategoriaFaqDao().
											obtenerCategorias(CategoriaFaqDao.TRANSFORM_CATEGORIAFAQVO).toArray(new CategoriaFaqVO[0]);
		return categorias;
	}

	/**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceImpl#handleModificarCategoria(CategoriaFaqVO)
     * @param CategoriaFaqVO Categoría de faq a modificar
     */
	protected void handleModificarCategoria(CategoriaFaqVO categoria) throws Exception {
		//Insertamos las nuevas descripciones
		CategoriaIdiomaFaqVO[] idiomasVO = categoria.getCategoriaIdioma();
		if (idiomasVO!=null && idiomasVO.length>0){
			for (int i=0; i<idiomasVO.length; i++){
				idiomasVO[i] = this.getCategoriaIdiomaFaqDao().toCategoriaIdiomaFaqVO(
						(this.getCategoriaIdiomaFaqDao().create(
								this.getCategoriaIdiomaFaqDao().fromCategoriaIdiomaFaqVO(idiomasVO[i]))));
			}
		}
		categoria.setCategoriaIdioma(idiomasVO);
		//Actualizamos la categoría
		CategoriaFaq categoriaEntity = this.getCategoriaFaqDao().fromCategoriaFaqVO(categoria);
		categoriaEntity.setFechaModificacion(new Date());
		this.getCategoriaFaqDao().update(categoriaEntity);
	}

	/**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceImpl#handleObtenerCategoria(Long)
     * @param Long identificador de categoria
     * @return CategoriaFaqVO categoria obtenida
     */
	protected CategoriaFaqVO handleObtenerCategoria(Long id) throws Exception {
		CategoriaFaqVO categoria = (CategoriaFaqVO) this.getCategoriaFaqDao().load(CategoriaFaqDao.TRANSFORM_CATEGORIAFAQVO, id);
		return categoria;		
	}
	
	/**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceImpl#handleObtenerCategoriaTraducida(Long, String)
     * @param Long identificador de categoria
     * @param String idioma 
     * @return CategoriaTraducidaVO categoria obtenida
     */
	protected CategoriaTraducidaVO handleObtenerCategoriaTraducida(Long id, String idioma) throws Exception {
		CategoriaFaqVO categoria = (CategoriaFaqVO) this.getCategoriaFaqDao().load(CategoriaFaqDao.TRANSFORM_CATEGORIAFAQVO, id);
		return toCategoriaTraducidaVO(categoria, idioma);		
	}
	
	private CategoriaTraducidaVO toCategoriaTraducidaVO (CategoriaFaqVO categoria, String idioma) throws Exception
	{
		CategoriaTraducidaVO resultado = new CategoriaTraducidaVO();
		resultado.setId(categoria.getId());		
		
//		Buscamos la traduccion de la categoria
		if (categoria.getCategoriaIdioma() != null && categoria.getCategoriaIdioma().length > 0)
		{
			String idiomas = "";
			for (int i = 0; i < categoria.getCategoriaIdioma().length; i++)
			{
				if (categoria.getCategoriaIdioma()[i].getIdioma().equals(idioma))
				{
					resultado.setNombre(categoria.getCategoriaIdioma()[i].getNombre());
				}
				idiomas = idiomas + categoria.getCategoriaIdioma()[i].getIdioma() + " ";
			}
			resultado.setIdiomas(idiomas.trim().replaceAll(" ", ","));
		}
		return resultado;	

	}

	/**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceImpl#handleLimpiarCategoria(Long)
     * @param Long identificador de categoria
     */
	protected void handleLimpiarCategoria(Long id) throws Exception {
		Collection desc = this.getCategoriaFaqDao().load(id).getCategoriaIdioma();
		this.getCategoriaIdiomaFaqDao().remove(desc);
	}

	/**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceImpl#hhandleLimpiarFaq(Long)
     * @param Long identificador de faq
     */
	protected void handleLimpiarFaq(Long id) throws Exception {
		Collection desc = this.getFaqDao().load(id).getDescripcionFaq();
		this.getDescripcionFaqDao().remove(desc);
		
		//Actualizamos las posiciones
		List idiomas = this.getDescripcionFaqDao().obtenerIdiomas();
		if (idiomas != null){
			for (int i=0; i< idiomas.size(); i++){
				List faqs = this.getDescripcionFaqDao().obtenerDescripcionesPorIdioma((String)idiomas.get(i));
				for (int j = 0; j < faqs.size(); j++) {
					((DescripcionFaq) faqs.get(j)).setPosicion(new Integer(j + 1));
				}
				this.getDescripcionFaqDao().update(faqs);
			}
		}

	}

	/**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceImpl#handleObtenerCategoriasTraducidas(String[])
     * @param String [] Idiomas
     * @return CategoriaTraducidaVO[] categorias obtenidas traducidas
     */
	protected CategoriaTraducidaVO[] handleObtenerCategoriasTraducidas(String[] idiomasTraducibles) throws Exception {		
//		Se obtienen todas las categorias que hay en la base de datos.
		CategoriaFaqVO[] listaCategorias = this.handleObtenerCategorias();
		
		List listaCategoriasTraducidas = new ArrayList();
		
		for (int i = 0; listaCategorias != null && i < listaCategorias.length; i++)
		{
			List listaIdiomas = new ArrayList();
			listaIdiomas = (List)this.getCategoriaFaqDao().obtenerIdiomasFromIdCategoria(listaCategorias[i].getId());
			String[] idiomas = (String[])listaIdiomas.toArray(new String[0]);	
			CategoriaTraducidaVO categoriaTraducida = this.handleObtenerCategoriaTraducida(listaCategorias[i].getId(), buscarIdioma(idiomasTraducibles, idiomas));
			listaCategoriasTraducidas.add(categoriaTraducida);
		}
		
		return (CategoriaTraducidaVO[])listaCategoriasTraducidas.toArray(new CategoriaTraducidaVO[0]);				

	}
	
	/**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceImpl#handleObtenerCategorias()
     * @return CategoriaFaqVO[] Todas las categorias 
     */
	protected CategoriaFaqVO[] handleObtenerCategorias() throws Exception 
	{
		CategoriaFaqVO[] categorias = (CategoriaFaqVO[])this.getCategoriaFaqDao().
											obtenerCategorias(CategoriaFaqDao.TRANSFORM_CATEGORIAFAQVO).toArray(new CategoriaFaqVO[0]);
		
		return categorias;

	}

	/**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceImpl#handleObtenerFaqsFromIdCategoria(Long, String[])
     * @param String [] Idiomas
     * @param Long identificador de categoria
     * @return FaqTraducidaVO[] faqs obtenidas por categoría e idiomas
     */
	protected FaqTraducidaVO[] handleObtenerFaqsFromIdCategoria(Long idCategoria, String[] idiomasTraducibles) throws Exception {
		FaqVO[] faqs = (FaqVO[])this.getFaqDao().obtenerFaqsPorIdCategoria(FaqDao.TRANSFORM_FAQVO, idCategoria).toArray(new FaqVO[0]);
		
		List listaFaqsTraducidas = new ArrayList();	
		
		for (int i = 0; faqs != null && i < faqs.length; i++)
		{
			List listaIdiomas = new ArrayList();		
			listaIdiomas = (List)this.getFaqDao().obtenerIdiomasPorIdFaq(faqs[i].getId());
			String[] idiomas = (String[])listaIdiomas.toArray(new String[0]);			
			FaqTraducidaVO faqTraducida = this.handleObtenerFaqTraducida(faqs[i].getId(), buscarIdioma(idiomasTraducibles, idiomas));
			listaFaqsTraducidas.add(faqTraducida);
			
		}		
		return (FaqTraducidaVO[])listaFaqsTraducidas.toArray(new FaqTraducidaVO[0]);
	}

	/**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceImpl#handleObtenerFaqsTraducidas(String[])
     * @param String [] Idiomas
     * @return FaqTraducidaVO[] faqs obtenidas por idiomas
     */
	protected FaqTraducidaVO[] handleObtenerFaqsTraducidas(String[] idiomasTraducibles) throws Exception {
		FaqVO[] listaFaqs = this.handleObtenerFaqs();
		
		List listaFaqsTraducidas = new ArrayList();	
		
		for (int i = 0; listaFaqs != null && i <listaFaqs.length; i++)
		{
			List listaIdiomas = new ArrayList();		
			listaIdiomas = (List)this.getFaqDao().obtenerIdiomasPorIdFaq(listaFaqs[i].getId());
			String[] idiomas = (String[])listaIdiomas.toArray(new String[0]);			
			FaqTraducidaVO faqTraducida = this.handleObtenerFaqTraducida(listaFaqs[i].getId(), buscarIdioma(idiomasTraducibles, idiomas));
			listaFaqsTraducidas.add(faqTraducida);
			
		}		
		return (FaqTraducidaVO[])listaFaqsTraducidas.toArray(new FaqTraducidaVO[0]);
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
		return idioma;
	}

	/**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceImpl#handleEliminarFaq(Long)
     * @param Long identificador de faq
     */
	protected void handleEliminarFaq(Long id) throws Exception {
		Collection desc =  this.getFaqDao().load(id).getDescripcionFaq();
		this.getDescripcionFaqDao().remove(desc);
		this.getFaqDao().remove(id);
		
		List idiomas = this.getDescripcionFaqDao().obtenerIdiomas();
		if (idiomas != null){
			for (int i=0; i< idiomas.size(); i++){
				List faqs = this.getDescripcionFaqDao().obtenerDescripcionesPorIdioma((String)idiomas.get(i));
				for (int j = 0; j < faqs.size(); j++) {
					((DescripcionFaq) faqs.get(j)).setPosicion(new Integer(j + 1));
				}
				this.getDescripcionFaqDao().update(faqs);
			}
		}
	}

	/**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceImpl#handleEliminarFaqs(Long[])
     * @param Long[] identificadores de faqs
     */
	protected void handleEliminarFaqs(Long[] faqIDs) throws Exception {
		// Elimina las FAQ solicitadas
		Collection desc = null;
		for (int i = 0; i < faqIDs.length; i++) {
			desc =  this.getFaqDao().load(faqIDs[i]).getDescripcionFaq();
			this.getDescripcionFaqDao().remove(desc);
			this.getFaqDao().remove(faqIDs[i]);
		}
		// Actualizar posiciones de FAQ restantes.
		List idiomas = this.getDescripcionFaqDao().obtenerIdiomas();
		if (idiomas != null){
			for (int i=0; i< idiomas.size(); i++){
				List faqs = this.getDescripcionFaqDao().obtenerDescripcionesPorIdioma((String)idiomas.get(i));
				for (int j = 0; j < faqs.size(); j++) {
					((DescripcionFaq) faqs.get(j)).setPosicion(new Integer(j + 1));
				}
				this.getDescripcionFaqDao().update(faqs);
			}
		}
	}
	
	/**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqServiceImpl#handleObtenerFaqsBloquesIdiomas(String[])
     * @param String [] Idiomas
     * @return FaqTraducidaIdiomaVO[] faqs obtenidas por idiomas
     */
	protected FaqTraducidaIdiomaVO[] handleObtenerFaqsBloquesIdiomas(String[] idiomasTraducibles) throws Exception 
	{
		//Se obtienen los faqs en cada idioma		
		ArrayList listaFaqs = new ArrayList();
		ArrayList listaFaqsReturn = new ArrayList();
		for (int i = 0; i < idiomasTraducibles.length; i++)
		{
			FaqTraducidaVO[] faqs = this.obtenerFaqsPorIdioma(idiomasTraducibles[i]);
			
			if (logger.isDebugEnabled()) logger.debug("Hay ["+faqs.length+"] faqs en el idioma ["+idiomasTraducibles[i]+"]");
			if (faqs != null && faqs.length > 0)
			{		
				FaqTraducidaIdiomaVO[] faqsIdioma = mappingToTraducidaIdiomaVO(faqs, idiomasTraducibles[i] );
				//Se ordena la lista por posicion
				Collections.sort(Arrays.asList(faqsIdioma), new ListaOrdenada());
				listaFaqs.add(faqsIdioma);
			} 
		}
		for (int j = 0; listaFaqs != null && j < listaFaqs.size(); j++)
		{
			FaqTraducidaIdiomaVO[] faqsAux = (FaqTraducidaIdiomaVO[])listaFaqs.get(j);
			for (int k = 0; k < faqsAux.length; k++)
				listaFaqsReturn.add(faqsAux[k]);
		}
		
		return (FaqTraducidaIdiomaVO[])listaFaqsReturn.toArray(new FaqTraducidaIdiomaVO[0]);
	
	}	
	
	private FaqTraducidaIdiomaVO[] mappingToTraducidaIdiomaVO(FaqTraducidaVO[] faqs, String idioma) throws Exception
	{
		FaqTraducidaIdiomaVO[] faqsReturn = new FaqTraducidaIdiomaVO[faqs.length];
		for (int i = 0; i < faqs.length; i++)
		{
			FaqTraducidaIdiomaVO faqAux = new FaqTraducidaIdiomaVO();
				faqAux.setCategoria(faqs[i].getCategoria());
				faqAux.setFechaPublicacion(faqs[i].getFechaPublicacion());
				faqAux.setId(faqs[i].getId());
				faqAux.setIdioma(idioma);
				faqAux.setPosicion(faqs[i].getPosicion());
				faqAux.setPregunta(faqs[i].getPregunta());
				faqAux.setRespuesta(faqs[i].getRespuesta());
			faqsReturn[i] = faqAux;
		}
		return faqsReturn;
	}


}