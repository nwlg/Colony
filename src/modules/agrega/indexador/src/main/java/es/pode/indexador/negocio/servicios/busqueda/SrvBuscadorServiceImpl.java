/* Agrega es una federaci n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut nomas propiedad de Red.es. Este c digo ha sido desarrollado por la Entidad P blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav s de la Secretar a de Estado de Telecomunicaciones y para la Sociedad de la Informaci n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci n y de Convergencia con Europa y entre Comunidades Aut nomas y Ciudades Aut nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006  Sociedad de la Informaci n 

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
//license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */

package es.pode.indexador.negocio.servicios.busqueda;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.io.StringReader;

import net.sf.dozer.util.mapping.MapperIF;

import org.apache.log4j.Logger;
import org.apache.lucene.analysis.KeywordAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.TermEnum;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.ConstantScoreRangeQuery;
import org.apache.lucene.search.DefaultSimilarity;
import org.apache.lucene.search.DisjunctionMaxQuery;
import org.apache.lucene.search.Filter;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.PhraseQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.RangeQuery;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TermsFilter;
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.search.spell.SpellChecker;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;

import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.agrega.soporte.serverProperties.DependentServerProperties;
import es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO;
import es.pode.indexador.negocio.dominio.Indice;
import es.pode.indexador.negocio.dominio.IndiceDao;
import es.pode.indexador.negocio.servicios.indexado.IndexaODEException;
import es.pode.indexador.negocio.servicios.indexado.IndiceVO;
import es.pode.indexador.negocio.servicios.indexado.SrvIndexadorServiceImpl;
import es.pode.indexador.negocio.soporte.HighFreqTerms;
import es.pode.indexador.negocio.soporte.NumTermsArbol;
import es.pode.parseadorXML.castor.Lom;
import es.pode.parseadorXML.lomes.lomesAgrega.LomAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.TechnicalAgrega;
import es.pode.parseadorXML.scorm2004.agrega.ManifestAgrega;
import es.pode.parseadorXML.castor.Manifest;
import es.pode.parseadorXML.castor.Metadata;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.utiles.date.DateManager;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.apache.lucene.analysis.WhitespaceAnalyzer;

/**
 * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService
 */

public class SrvBuscadorServiceImpl extends
		es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorServiceBase {
	private Logger logger = Logger.getLogger(this.getClass());
	public static Properties props = null;
	
	private static final char COMILLAS = '"';
	private static final char SUMAS = '+';
	private static final char ESPACIO_BLANCO = ' ';
	private static final char CHAR_ASTERISK = '*';
	private static final char CHAR_QUESTIONMARK = '?';
	private static final String ASTERISK = "*";
	private static final String QUESTIONMARK = "?";
	private static final String SQI_LANG = "VSQL";
	private static final String LUCENE_LANG = "LQS";
	private static final String SEPARADOR_PALABRAS = " ";
	private static final String SEPARADOR_CLAVES = "&";
	public static final String SEPARADOR_STOP_WORDS = ",";
	private static final String BUSCARRSS = "BUSCARRSS";
	private static final String SEPARADOR_PHRASE = "\"";
	private static final String PREFIJO_CAMPO = "campo_";
	private static final String CAMPOS_AND = "campos_and_avanzada";
	private static final String CAMPOS_OR = "campos_or_avanzada";
	private static final String CAMPOS_LOWER_CASE = "campos_minusculas";
	private static final String CAMPOS_PHRASE_SIMPLE = "campos_phrase_simple";
	private static final String CAMPOS_PHRASE_AVANZADA = "campos_phrase_avanzada";
	private static final String CAMPOS_WILDCARD_SIMPLE = "campos_wildcard_simple";
	private static final String CAMPOS_WILDCARD_AVANZADA = "campos_wildcard_avanzada";
	private static final String CAMPOS_RANGE_AVANZADA = "campos_range_avanzada";
	private static final String CAMPOS_TEXTO_LIBRE = "campos_texto_libre";
	private static final String CAMPOS_CLAVE_SIMPLE = "campos_clave_simple";
	private static final String CAMPOS_CLAVE_AVANZADA = "campos_clave_avanzada";
	private static final String CAMPO_AREA_CURRICULAR = "campo_areaCurricular";
	private static final String CAMPO_AREA_CURRICULAR_NODO = "campo_areaCurricular_nodo";
	private static final String DISTANCIA_ENTRE_CAMPOS_FRASE = "distancia_campos_frase";
	private static final String CAMPO_FECHA_PUBLICACION = "campo_fechaPublicacion";
	private static final String CAMPO_LICENCIA = "campo_licencias";
	private static final String CAMPO_NIVEL_AGREGACION = "campo_nivelAgregacion";
	private static final String CAMPO_ARBOL_CURRICULAR_VIGENTE = "campo_arbolCurricularVigente";
	private static final int NUMERO_SUGERENCIAS = 10;
	private static final String MAX = "5";
	private static final String MIN_NIVEL_CATALOGO = "3";
	private static final String PROTOCOLO_HTTP = "protocoloHttp";
	private static final String BUSCADOR_FICHA = "buscadorFicha";
	private static final String BARRA = "barra";
	private static final String KEY_HOST_NODO = "host";
	
	//private static final String CAMPOS_WILDCARD_AUTOMATICA = "campos_wildcard_automatica";

	private MapperIF beanMapper = null;
	private DocVO[] resultados = null;
	

	public MapperIF getBeanMapper() {
		return beanMapper;
	}

	public void setBeanMapper(MapperIF beanMapper) {
		this.beanMapper = beanMapper;
	}

	public SrvBuscadorServiceImpl() {
		super();
		if(props==null){
		try {
			props = new Properties();
			props.load(this.getClass().getResourceAsStream(
					"/indexador.properties"));
		} catch (IOException e) {
			logger.error("ERROR: fichero no encontrado: indexador.properties",
					e);
			throw new RuntimeException(e);
			}
		}
		if(resultados == null){
			resultados = new DocVO[1000];
			for(int i = 0; i < resultados.length;i++) resultados[i]= new DocVO();
		}
	}

	/**
	 * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService#busquedaSimple(es.pode.indexador.negocio.servicios.busqueda.ParamSimpleVO)
	 * @param ParamSimpleVO Este VO alberga los parametros aceptados en la busqueda simple.
	 * @return DocumentosVO Esta clase representa los resultados de una busqueda. 
	 */
	protected es.pode.indexador.negocio.servicios.busqueda.DocumentosVO handleBusquedaSimple(
			es.pode.indexador.negocio.servicios.busqueda.ParamSimpleVO paramBusq)
			throws java.lang.Exception {

		DocumentosVO respuesta = new DocumentosVO();
		
		
		if (logger.isDebugEnabled())
			logger.debug("Los par metros son idiomaBusqueda["	+ paramBusq.getIdiomaBusqueda() 
				+ "] idiomaNavegacion ["+ paramBusq.getIdiomaNavegacion() 
				+ "] palabarasclave ["+ paramBusq.getPalabrasClave() + "]");

		DisjunctionMaxQuery query = new DisjunctionMaxQuery(0.01f);
		Hits hits = this.internaBusquedaSimple(paramBusq, query);
		if (logger.isDebugEnabled())
			logger.debug("Se devuelven los hits");

		if (hits != null && hits.length() == 0) {
			if (logger.isDebugEnabled())
				logger.debug("Se devuelven los hits NULL o 0 vamos a por las sugerencias");
			Directory directorioIndiceSpell = this.indiceSpell(paramBusq.getIdiomaBusqueda());

			if (logger.isDebugEnabled())
				logger.debug("El indice de spellchecker es " + directorioIndiceSpell);
			SpellChecker spellChecker = new SpellChecker(directorioIndiceSpell);
			String sQuery = query.toString();

			if (!spellChecker.exist(sQuery)
					&& (paramBusq.getPalabrasClave() != null && !paramBusq.getPalabrasClave().equals(""))) {
				String[] sugerencias = spellChecker.suggestSimilar(paramBusq.getPalabrasClave().toLowerCase(), 10);
				respuesta.setSugerencias(sugerencias);
			} else
				respuesta.setSugerencias(new String[] {});
		} else {
			 respuesta.setResultados(this.getArrayDocsFromHits(hits,(hits.length()>paramBusq.getNumeroResultados().intValue())?paramBusq.getNumeroResultados().intValue():hits.length()));
		}
		return respuesta;
	}	

	/**
	 * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService#busquedaAvanzada(es.pode.indexador.negocio.servicios.busqueda.ParamAvanzadoVO)
	 * @param ParamAvanzadoVO VO que alberga los parametros que acepta una busqueda avanzada.
	 * @return DocumentosVO Esta clase representa los resultados de una busqueda. 
	 */
	protected es.pode.indexador.negocio.servicios.busqueda.DocumentosVO handleBusquedaAvanzada(
			es.pode.indexador.negocio.servicios.busqueda.ParamAvanzadoVO paramBusq)
			throws java.lang.Exception {

//		Implementamos la busqueda avanzada.
		DocumentosVO respuesta = new DocumentosVO();
		if (logger.isDebugEnabled())
			logger.debug("SrvBuscadorServiceImpl - handleBusquedaAvanzada: Parametros de la busqueda avanzada "+ paramBusqAvanz2String(paramBusq));
		DisjunctionMaxQuery query = new DisjunctionMaxQuery(0.01f);
		long start = System.currentTimeMillis();
		Object[] hits=null;
		boolean resultadoUnico = false;
		if (paramBusq.getPalabrasClave()!=null){
			if (paramBusq.getPalabrasClave().trim().toLowerCase().startsWith(props.getProperty("agrega_admin") + " ")){
				hits = new Hits[1];
				hits = this.internaBusquedaQuery(paramBusq, paramBusq.getPalabrasClave().toLowerCase().trim().substring((props.getProperty("agrega_admin") + " ").length()), query, false, null);
			}else if(paramBusq.getPalabrasClave().trim().toLowerCase().startsWith(props.getProperty("agrega_todos") + " ")){
				IndiceVO[] idiomas = this.handleObtenerIdiomasBusqueda();
				hits = new Hits[idiomas.length];
				hits = this.internaBusquedaQuery(paramBusq, paramBusq.getPalabrasClave().toLowerCase().trim().substring((props.getProperty("agrega_todos") + " ").length()), query, true, idiomas);
			}else{
				resultadoUnico = true;
				hits = new Hits[1];
				hits[0] = internaBusquedaAvanzada(paramBusq, query);
			}
		}else{
			resultadoUnico = true;
			hits = new Hits[1];
			hits[0] = internaBusquedaAvanzada(paramBusq, query);
		}
		long end = System.currentTimeMillis();
		logger.debug("SrvBuscadorServiceImpl - handleBusquedaAvanzada : Busqueda local realizada en =" + (end - start)+ " milisegundos.");
		if (logger.isDebugEnabled()){
			logger.debug("Se devuelven los hits");
			logger.debug("Se devuelven los hits NULL o 0 vamos a por las sugerencias");
		}
		if(paramBusq.getBusquedaSimpleAvanzada()!=null && !paramBusq.getBusquedaSimpleAvanzada().equals(BUSCARRSS)){
			try{
				Directory directorioIndiceSpell = this.indiceSpell(paramBusq.getIdiomaBusqueda());
				if (logger.isDebugEnabled()) logger.debug("El indice de spellchecker es " + directorioIndiceSpell);
				SpellChecker spellChecker = new SpellChecker(directorioIndiceSpell);
				String sQuery = query.toString();
	//			TODO: retocar las sugerencias para que tengan en cuenta algo mas que los parametros de "keywords"?
				if (!spellChecker.exist(sQuery)&& (paramBusq.getPalabrasClave() != null && !paramBusq.getPalabrasClave().equals(""))){
					List claveBusqueda = this.obtenerPalabrasClave(paramBusq.getPalabrasClave().toLowerCase(),false);
					List <String>sugerencias=new ArrayList<String>();
					if (claveBusqueda!=null && claveBusqueda.size()>0){
						boolean suficientes=false;
						for (int i=0;i<claveBusqueda.size() && !suficientes;i++){
							if (!((String)claveBusqueda.get(i)).equals("")){
									String[] suge = spellChecker.suggestSimilar((String)claveBusqueda.get(i), NUMERO_SUGERENCIAS);
									if (suge!=null && suge.length>0){
										for (int k=0;k<suge.length && sugerencias.size()<NUMERO_SUGERENCIAS;k++){
											boolean encontrado = false;
											for (int j=0;j<sugerencias.size() && !encontrado;j++){
												if(sugerencias.get(j).toString().equals(suge[k])) encontrado=true;
											}
											if(!encontrado && validarPersonalizada(paramBusq)){
												Hits hitSugerencias=null;
												ParamAvanzadoVO paramBusqSug = paramBusq;
												paramBusqSug.setPalabrasClave(suge[k]);
												try{
													hitSugerencias = internaBusquedaAvanzada(paramBusqSug, query);
													if(hitSugerencias!=null && hitSugerencias.length()>0)sugerencias.add(suge[k]);
												}catch(Exception e){
								        			logger.error("SrvBuscadorServiceImpl - handleBuscarAvanzado:Error solicitando comprobaci n sugerencia avanzada. Sugerencia="+suge[k],e);
								        		}
											}else if(!encontrado && !validarPersonalizada(paramBusq)) sugerencias.add(suge[k]);
										}
									}
								if (sugerencias.size()==NUMERO_SUGERENCIAS) suficientes=true;
							}
						}
					}
					String[] cargarSugerencias =new String[]{};
	        		if (sugerencias !=null && sugerencias.size()>0){
	        			cargarSugerencias = new String [sugerencias.size()];
	        			for (int i=0;i<sugerencias.size();i++){
	        				cargarSugerencias[i]=sugerencias.get(i);
	        			}
	        		}       		
					respuesta.setSugerencias(cargarSugerencias);
				} else	respuesta.setSugerencias(new String[] {});
			}catch(Exception e){
    			logger.error("SrvBuscadorServiceImpl - handleBuscarAvanzado:Error solicitando sugerencias para idioma:"+paramBusq.getIdiomaBusqueda(),e);
    			respuesta.setSugerencias(new String[] {});
    		}	
			try{
				es.pode.indexador.negocio.servicios.busqueda.TaxonVO [] cargarTesauros =new es.pode.indexador.negocio.servicios.busqueda.TaxonVO[]{};
	    		if(paramBusq.getPalabrasClave()!=null && !paramBusq.getPalabrasClave().trim().equals("")){
	        		List palabrasTesauro = this.obtenerPalabrasClave(paramBusq.getPalabrasClave().toLowerCase(),true);
	        		List <String>nombreTesauros= new ArrayList<String>();
	        		List <String>identificadorTesauros= new ArrayList<String>();        
	        		if (palabrasTesauro != null && palabrasTesauro.size()>0){
	        			int numeroTax=0;
	        			for (int i=0;i<palabrasTesauro.size() && (numeroTax<Integer.parseInt(props.getProperty("numero_tesauros"))) ;i++){
	        				TaxonVO[] taxones=this.getSrvTesaurosServices().obtenerTerminosRelacionadosPorTexto((String)palabrasTesauro.get(i), props.getProperty("nombre_tesauro"), paramBusq.getIdiomaBusqueda());
	        				String[] idTesauro=new String[taxones.length];
	        				for (int k=0;k<taxones.length;k++){
	        					idTesauro[k]=taxones[k].getId();
	        				}
	        				for (int k=0; k<taxones.length && (numeroTax<Integer.parseInt(props.getProperty("numero_tesauros"))) ;k++){
		        				Integer[] tesauros = NumTermsArbol.obtenerNumeroNodos(idTesauro, getIndexPathByLanguage(paramBusq.getIdiomaBusqueda()), "tesauro").getConteo();
		        				if(idTesauro!=null && idTesauro.length!=0){
									for (int j=0;j<idTesauro.length;j++){
										if (idTesauro[j].equals(taxones[k].getId())){
											if(tesauros[j].intValue() > 0){
												nombreTesauros.add(taxones[k].getValorTax());
												identificadorTesauros.add(taxones[k].getId());
					        					numeroTax = numeroTax + 1;
											}
										}										
									}
								}	        					
	        				}
	        			}
	        		}
 	        		if (nombreTesauros !=null && nombreTesauros.size()>0){
	        			cargarTesauros = new es.pode.indexador.negocio.servicios.busqueda.TaxonVO [nombreTesauros.size()];
	        			for (int i=0;i<nombreTesauros.size();i++){
	        				cargarTesauros[i]=new es.pode.indexador.negocio.servicios.busqueda.TaxonVO(identificadorTesauros.get(i).toString(), nombreTesauros.get(i).toString());
	        			}
	        		}
	        		respuesta.setTesauros(cargarTesauros);
	    		}else respuesta.setTesauros(new es.pode.indexador.negocio.servicios.busqueda.TaxonVO[]{});
			}catch(Exception e){
    			logger.error("SrvBuscadorServiceImpl - handleBuscarAvanzado:Error obteniendo sugerencias de tesauro ["+props.getProperty("nombre_tesauro")+"] con:"+paramBusq.getPalabrasClave()+" n mero de tesauros m ximo solicitado="+props.getProperty("numero_tesauros")+" e idioma="+paramBusq.getIdiomaBusqueda(),e);
    			respuesta.setTesauros(new es.pode.indexador.negocio.servicios.busqueda.TaxonVO[]{});
    		}
		}
		if (hits == null || (resultadoUnico && hits[0]==null)) {
			respuesta.setTotalResultados(new Integer(0));
			respuesta.setNumeroResultados(new Integer(0));
			respuesta.setNumDocumentosIndice(new Integer(0));
		} else{
			long start2 = System.currentTimeMillis();
			if(hits.length > 1){
				int totalResultados = 0;
				List docsList = new ArrayList();
				for(int i = 0; i < hits.length && docsList.size()<= paramBusq.getNumeroResultados().intValue(); i++){
					if(hits[i]!=null && ((Hits)hits[i]).length() > 0){
						totalResultados = totalResultados + ((Hits)hits[i]).length();
						DocVO[] docs = this.getArrayDocsFromHits((Hits)hits[i],((((Hits)hits[i]).length()<paramBusq.getNumeroResultados().intValue()) || paramBusq.getNumeroResultados().intValue()==-1)?((Hits)hits[i]).length():paramBusq.getNumeroResultados().intValue());
						for(int j = 0; j < docs.length ; j++){
							docsList.add(docs[j]);
						}
					}
				}
				DocVO[] docs = new DocVO[docsList.size()];
				for(int i = 0; i < docs.length ; i++){
					docs[i] = (DocVO) docsList.get(i);
				}
				respuesta.setTotalResultados(new Integer(totalResultados));
				respuesta.setResultados(docs);
			}else{
				respuesta.setTotalResultados(new Integer(((Hits)hits[0]).length()));
				respuesta.setResultados(this.getArrayDocsFromHits((Hits)hits[0],((((Hits)hits[0]).length()<paramBusq.getNumeroResultados().intValue()) || paramBusq.getNumeroResultados().intValue()==-1)?((Hits)hits[0]).length():paramBusq.getNumeroResultados().intValue()));
			}
			end = System.currentTimeMillis();
			logger.debug("SrvBuscadorServiceImpl - handleBusquedaAvanzada : Mapeo local realizado en =" + (end - start2)+ " milisegundos.");
			IndexReader reader = IndexReader.open(this.getIndexByLanguage(paramBusq.getIdiomaBusqueda()));
			respuesta.setNumDocumentosIndice(new Integer(reader.numDocs()));
			respuesta.setNumeroResultados(new Integer(respuesta.getResultados().length));
		}
		logger.debug("SrvBuscadorServiceImpl - handleBusquedaAvanzada : Busqueda local realizada en =" + (end - start)+ " milisegundos.");
		return respuesta;
	}

	/**
	 * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService#busquedaLOM_ES(es.pode.indexador.negocio.servicios.busqueda.ParamAvanzadoVO)
	 * @param QuerySimpleVO Parametros de una query simple.
	 * @return DocumentosLOM_ESVO Esta clase representa los documentos resultado de una busqueda por LOM_ES.
	 */
	protected es.pode.indexador.negocio.servicios.busqueda.DocumentosLOM_ESVO handleBusquedaLOM_ES(
			es.pode.indexador.negocio.servicios.busqueda.QuerySimpleVO paramBusq)
			throws java.lang.Exception {
		DocumentosLOM_ESVO respuesta = new DocumentosLOM_ESVO();
		DocLOM_ESVO[] resultados = null;
		DisjunctionMaxQuery query = new DisjunctionMaxQuery(0.01f);
		String queryLang = paramBusq.getLenguajeQuery();
		String idioma = paramBusq.getIdioma();
		String unparsedQuery = paramBusq.getQuery();
		Hits hits = null;
		logger.debug("Se ha recibido una query en lenguaje["+queryLang+"] con contenido["+unparsedQuery+"]");
		// Discriminar SQI / Lucene
		if (SQI_LANG.equals(queryLang)) 
		{
			logger.debug("Parseando query SQI_LANG["+ unparsedQuery+"]");
			String[] terms = parsearVSQL(unparsedQuery);
			// Introduzco los terminos de busqueda en titulo, descripcion y
			// palabras clave
			logger.debug("Creando query a partir de terminos["+terms+"]");
			for (int i = 0; i < terms.length; i++) 
			{
				query.add(getTermQuery(props.getProperty("campo_titulo"), terms[i]
						.toLowerCase()));
				query.add(getTermQuery(props.getProperty("campo_descripcion"),
						terms[i].toLowerCase()));
				query.add(getTermQuery(props.getProperty("campo_palabrasClave"), terms[i]
						.toLowerCase()));
			}
			if (logger.isDebugEnabled())
				logger.debug("Consulta LOM_ES con query["+query.toString()+"] a partir de SQUI lenguaje.");
		} 
		else if (LUCENE_LANG.equals(queryLang)) 
		{
			logger.debug("Parseando query LUCENE_LANG" + unparsedQuery);
			QueryParser parser = new QueryParser(props.getProperty("campo_titulo"), new StandardAnalyzer());
			parser.setLowercaseExpandedTerms(true);
			Query lqsQuery = parser.parse(unparsedQuery);
			query.add(lqsQuery);
			if (logger.isDebugEnabled())
				logger.debug("Consulta LOM_ES con query["+query.toString()+"] a partir de LUCENE lenguaje.");
		}else{
			logger.error("Se ha recibido una query que no es SQI ni Lucene =>["+queryLang+"].");
			throw new Exception("Se ha recibido una query que no es SQI ni Lucene =>["+queryLang+"].");
		}
		
		// Preparando busqueda
		logger.debug("Preparando busqueda");
		Directory directorioIndiceSimple = this.getIndexByLanguage(idioma);
		logger.debug("Directory directorioIndiceSimple["+directorioIndiceSimple+"]");
		IndexSearcher searcher = new IndexSearcher(directorioIndiceSimple);
		searcher.setSimilarity(new DefaultSimilarity());
		if (logger.isDebugEnabled())
			logger.debug("Consulta LOM_ES con query["+query.toString()+"]");
		hits = searcher.search(query);
		logger.debug("Numero de hits obtenidos["+(hits != null?hits.length():0)+"]");
		if (hits != null && hits.length() > 0) 
		{
			logger.debug("Numero de hits[" + hits.length()+"]");

			resultados = new DocLOM_ESVO[hits.length()];

			logger.debug("resultados[" + resultados+"]");
			
			for (int i = 0; i < hits.length(); i++) 
			{
				DocLOM_ESVO hitToDoc = new DocLOM_ESVO();
				Document doc = hits.doc(i);
				logger.debug("Document doc : " + doc);
				String localizador = doc.get(props.getProperty("campo_localizador"));
				
				logger.debug("localizador : " + localizador);
				hitToDoc.setRanking(new Integer(Float.floatToIntBits(hits.score(i))));
				
				Manifest manifest = this.parsearManifiesto(localizador+ File.separator + "imsmanifest.xml");
				Lom lom = null;

				if (manifest != null) 
				{
					logger.debug("manifest!=null " + manifest);
					
					ManifestAgrega ma = new ManifestAgrega(manifest);
					lom = ma.obtenerLom(manifest.getIdentifier(), null);

					/*
					 * Este codigo seguramente es viejo: El mapeo de Lom a Lom
					 * entiendo que es innecesario: para escribir el lomes a un
					 * Write no es necesario tener un clon del objeto Lom.
					 * 
					 * La forma recomendada de obtener el Lom de un Manifest es
					 * mediante los metodos de la clase ManifestAgrega
					 * 
					 * fjespino
					 */
//					lom = this.getLom(manifest.getMetadata(), manifest.getIdentifier());
//					lomCastor = (es.pode.parseadorXML.lomes.Lom) beanMapper
//							.map(lom, es.pode.parseadorXML.lomes.Lom.class);
					
//					creo un writer para escribir los metadatos
					StringWriter sw= new StringWriter();
					//completo el writer
					this.getLomesDao().escribirLom(lom, sw);
					hitToDoc.setDocumento(sw.toString());
					resultados[i] = hitToDoc;
				}
				logger.debug("manifest==null " + manifest);
			}
			respuesta.setResultados(resultados);
		}
		return respuesta;
	}

	/**
	 * Metodo copiado de SrvSQIService para parseo de VSQI. TODO Corregir para
	 * hacer un parseo XML mas fiable.
	 * 
	 * @param queryStatement query a parsear
	 * @return String[] Strings de t rminos para a adir a query
	 */
	private String[] parsearVSQL(String queryStatement) {
		String c = queryStatement.substring(13, queryStatement.length() - 14);
		ArrayList stringList = new ArrayList();
		while (c.startsWith("<term>")) {
			String term = new String(c.substring(6, c.indexOf("</term>")));
			stringList.add(term);
			c = c.substring(13 + term.length());
		}
		return (String[]) stringList.toArray(new String[stringList.size()]);
	}

	/**
	 * Este m todo busca todos los idiomas posibles del indice
	 * @return IndiceVO[] Un array de indices que contienen todos los idiomas de busqueda posibles.
	 */
	protected IndiceVO[] handleObtenerIdiomasBusqueda() throws Exception {
		return (IndiceVO[]) this.getIndiceDao().loadAll(IndiceDao.TRANSFORM_INDICEVO).toArray(new IndiceVO[0]);
	}
	
	/**
	 * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService#handleBusquedaMEC(String identificadorMEC, String idiomaBusqueda)
	 * @param String identificador de archivo a buscar, String idioma de b squeda
	 * @return DocVO Esta clase representa los documentos resultado de una busqueda por LOM_ES.
	 */
	protected DocVO handleBusquedaMEC(String identificadorMEC, String idiomaBusqueda) throws Exception {
		if (logger.isDebugEnabled())
			logger.debug("Busqueda MEC con paramero["+ identificadorMEC + "]MEC.");

		DisjunctionMaxQuery query = new DisjunctionMaxQuery(0.01f);
		Hits hits = this.internaBusquedaMEC(identificadorMEC, idiomaBusqueda, query);
		if (hits == null || (hits != null && hits.length() == 0)) {
			if (logger.isDebugEnabled())
				logger.debug("No hay resultados para una busqueda con MEC["+identificadorMEC+"]");
			return null;
		}
		if (logger.isDebugEnabled())
			logger.debug("Se obtienen ["+hits.length()+"]hits de una busqueda por MEC["+identificadorMEC+"]");
		DocVO docReturn = this.getVOFromLucene(hits.doc(0));
		if (docReturn != null)	return this.getVOFromLucene(hits.doc(0));
		return null;
	}
	
	/**
	 * Metodo copiado de SrvSQIService para parseo de VSQI. TODO Corregir para
	 * hacer un parseo XML mas fiable.
	 * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorServiceBase#handleBusquedaDocsNodoArbolCurricular(ParamNodoArbolCurricularVO)
	 * 
	 * @param ParamNodoArbolCurricularVO VO que alberga los parametros que acepta una busqueda por nodo de arbol curricular.
	 * @return DocumentosVO Esta clase representa los resultados de una busqueda.
	 */
	protected DocumentosVO handleBusquedaDocsNodoArbolCurricular(ParamNodoArbolCurricularVO paramBusq) throws Exception {
		DocumentosVO respuesta = new DocumentosVO();
		if (logger.isDebugEnabled())
			logger.debug("Los par metros son idiomaBusqueda["	+ paramBusq.getIdiomaBusqueda() 
				+ "] idiomaNavegacion ["+ paramBusq.getIdiomaNavegacion() 
				+ "] idNodo ["+ paramBusq.getAreaCurricular() + "]");

		DisjunctionMaxQuery query = new DisjunctionMaxQuery(0.01f);
		Hits hits = this.internaBusquedaNodo(paramBusq, query);
		if (logger.isDebugEnabled())
			logger.debug("Se devuelven los hits");
		respuesta.setResultados(this.getArrayDocsFromHits(hits,(hits.length()>paramBusq.getNumeroResultados().intValue())?paramBusq.getNumeroResultados().intValue():hits.length()));
		return respuesta;
	}

	/**
	 * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorServiceBase#handleSolicitudDocsCountArbolCurricular(ParamDocsCountVO)
	 * 
	 * @param ParamDocsCountVO VO que alberga los parametros que acepta una solicitud de numero de documentos para el nodo de un arbol curricular.
	 * @return ResultadosCountVO VO que alberga el resultado de la solicitud de la suma de documentos para un nodo de arbol curricular.
	 */
	protected ResultadosCountVO handleSolicitudDocsCount(ParamDocsCountVO paramBusq) throws Exception {
//		logger.debug("SrvBuscadorServiceImpl - handleSolicitudDocsCount: AreaCurricular=" + array2String(paramBusq.getAreaCurricular())+ ", Tesauros="+array2String(paramBusq.getTesauros()));
//		return NumTermsArbol.obtenerNumeroNodos(paramBusq.getAreaCurricular(),getIndexPathByLanguage(paramBusq.getIdiomaBusqueda()),(paramBusq.getAreaCurricular()!=null && paramBusq.getAreaCurricular().length > 0)?"areaCurricular":"tesauro");
		Directory directorioIndiceSimple = this.getIndexByLanguage(paramBusq.getIdiomaBusqueda());
		IndexSearcher searcher = new IndexSearcher(directorioIndiceSimple);
		ResultadosCountVO resultado = new ResultadosCountVO();
		searcher.setSimilarity(new DefaultSimilarity());
		int suma = 0;
		if(paramBusq.getAreaCurricular()!=null && paramBusq.getAreaCurricular().length > 0){
			resultado.setConteo(new Integer[paramBusq.getAreaCurricular().length]);
			for(int i = 0 ; i < paramBusq.getAreaCurricular().length; i++){
				BooleanQuery andQuery = new BooleanQuery();
				andQuery.add(getTermQuery(props.getProperty(CAMPO_AREA_CURRICULAR), paramBusq.getAreaCurricular()[i]),BooleanClause.Occur.MUST);
				andQuery.add(getTermQuery(props.getProperty(CAMPO_ARBOL_CURRICULAR_VIGENTE), paramBusq.getArbolCurricularVigente()),BooleanClause.Occur.MUST);
				Hits hits = searcher.search(andQuery);
				resultado.getConteo()[i]=new Integer(hits.length());
				suma = suma + resultado.getConteo()[i].intValue();
			}
			resultado.setDocumentosCount(new Integer(suma));
		}else{
			resultado = NumTermsArbol.obtenerNumeroNodos(paramBusq.getTesauros(),getIndexPathByLanguage(paramBusq.getIdiomaBusqueda()),"tesauro");
		}
		return resultado;
	}

	
	/**
	 * Este metodo busca los documentos indexados que cumplen estar dentro del rango de fechas dado y que tengan el valor de licencia dado.
	 * 
	 * @param licencia Licencia de la que se quiere saber el numero de documentos que la contiene.
	 * @param fechaDesde Fecha desde del periodo en el que se esta interesado.
	 * @param fechaHasta Fecha hasta del periodo en el que se esta interesado.
	 * @param idioma Idioma en el que se esta interesado buscar.
	 * @return ResultadosCountVO VO que alberga el resultado de la solicitud de la suma de documentos que cumplen la condicion.
	 */
	protected ResultadosCountVO handleBusquedaDocsLicenciaFecha(String licencia, Calendar fechaDesde, Calendar fechaHasta, String idioma) throws Exception {
		if (licencia == null || licencia.equals(""))
		{
			logger.error("Error buscando documentos con licencias. Licencia vacia.");
			throw new Exception("Error buscando documentos con licencias. Licencia vacia.");
		}
		if (idioma == null || idioma.equals(""))
		{
			logger.error("Error buscando documentos con licencias. Idioma de busqueda vacio.");
			throw new Exception("Error buscando documentos con licencias. Idioma de busqueda vacio.");
		}
		if (fechaDesde == null || fechaHasta == null)
    	{
    		logger.error("Error buscando documentos con licencias. Fechas desde["+fechaDesde==null?null:fechaDesde.toString()+"] y hasta["+fechaHasta==null?null:fechaHasta.toString()+"] vacias.");
    		throw new Exception("Error buscando documentos con licencias. Fechas desde["+fechaDesde==null?null:fechaDesde.toString()+"] y hasta["+fechaHasta==null?null:fechaHasta.toString()+"] vacias.");
    	}
    	if (fechaDesde.after(fechaHasta))
    	{
    		logger.error("Error buscando documentos con licencias. Fechas desde["+fechaDesde.toString()+"] y hasta["+fechaHasta.toString()+"] incoherentes.");
    		throw new Exception("Error buscando documentos con licencias. Fechas desde["+fechaDesde.toString()+"] y hasta["+fechaHasta.toString()+"] incoherentes.");    		
    	}
    	BooleanQuery andQuery = new BooleanQuery();
//		Configuramos el valor de memoria.	
    	andQuery.setMaxClauseCount(Integer.parseInt(props.getProperty("maxClauseCount")));
    	Calendar antes = Calendar.getInstance();
    	Calendar despues= Calendar.getInstance();
    	antes.setTime(fechaDesde.getTime());
    	despues.setTime(fechaHasta.getTime());
    	String antesS = ""+antes.get(Calendar.YEAR)+formatMonthMM((antes.get(Calendar.MONTH)+1))+formatDayDD(antes.get(Calendar.DAY_OF_MONTH));
    	String despuesS = ""+despues.get(Calendar.YEAR)+formatMonthMM((despues.get(Calendar.MONTH)+1))+formatDayDD(despues.get(Calendar.DAY_OF_MONTH));
    	logger.debug("Buscando documentos con licencia["+licencia+"] desde["+antesS+"] hasta["+despuesS+"]");
		//aniadimos la query con el rango de fechas
    	andQuery.add(getRangeQuery(props.getProperty(CAMPO_FECHA_PUBLICACION),antesS,despuesS),BooleanClause.Occur.MUST);
		//aniadimos la query con el id de la licencia
//    	QueryParser parser = new QueryParser(props.getProperty(CAMPO_LICENCIA), new StandardAnalyzer());
//    		// el standar analyzer utiliza el StandardTokenizer gracias al cual elimina de la licencia los caracteres extranios
//    		// para ver que caracteres tiene en cuenta al tokenizar:http://lucene.zones.apache.org:8080/hudson/job/Lucene-Nightly/javadoc/org/apache/lucene/analysis/standard/StandardTokenizer.html
//		Query licenciaQuery = parser.parse("\""+licencia+"\""); //tenemos en cuenta el texto entre comillas para que el parseo no se pierda.
//			// hemos convertido en tokens las palabras de la licencia
//    	andQuery.add(getPhraseQuery(props.getProperty(CAMPO_LICENCIA), Arrays.asList(licencia.split(" "))),BooleanClause.Occur.MUST);
		andQuery.add(getTermQuery(props.getProperty(CAMPO_LICENCIA), licencia), BooleanClause.Occur.MUST);
//		andQuery.add(licenciaQuery,BooleanClause.Occur.MUST);
    	
//		Utilizamos el idioma seleccionado en la busqueda para buscar el indice sobre el que se ejecuta la query.
		Directory directorioIndiceSimple = this.getIndexByLanguage(idioma);
		if (directorioIndiceSimple == null)
		{
			logger.error("Error buscando documentos con licencias. Indice para idioma["+idioma+"] no accesible. Imposible buscar.");
			throw new Exception("Error buscando documentos con licencias. Indice para idioma["+idioma+"] no accesible. Imposible buscar.");
		}
		Hits hits;
		try {
			IndexSearcher searcher = new IndexSearcher(directorioIndiceSimple);
			searcher.setSimilarity(new DefaultSimilarity());
			hits = searcher.search(andQuery);
		} catch (Exception e) {
			logger.error("Error buscando documentos con licencias. Error buscando en indice["+idioma+"] con query["+andQuery.toString()+"].["+e.getCause()+"]");
			throw new Exception("Error buscando documentos con licencias. Error buscando en indice["+idioma+"] con query["+andQuery.toString()+"].",e);
		}
		ResultadosCountVO resultado = new ResultadosCountVO();
		if (hits != null)
			resultado.setDocumentosCount(new Integer(hits.length()));
		else
			resultado.setDocumentosCount(new Integer(0));
		return resultado;
	}

	/**
	 * Este metodo busca los documentos que tienen fecha entre las fechas desde y hasta dados y que tengan el campo de arbol curricular
	 *  nodo coincidente con el identificador de nodo que le pasan. 
	 * Esto devuelve el numero de documentos indexados que estan catalogados exactamente en ese nodo de arbol curricular.
	 * @param idNodo Identificador del nodo de arbol curricular del que se quiere averiguar el numero de documentos que tiene asociados.
	 * @param fechaDesde Fecha desde del periodo en el que se esta interesado.
	 * @param fechaHasta Fecha hasta del periodo en el que se esta interesado.
	 * @param idioma Idioma en el que se esta interesado buscar.
	 * @return ResultadosCountVO VO que alberga el resultado de la solicitud de la suma de documentos que cumplen la condicion.
	 */
	protected ResultadosCountVO handleBusquedaDocsNodoFechaArbolCurricular(String idNodo, Calendar fechaDesde, Calendar fechaHasta, String idioma) throws Exception {
		if (idNodo == null || idNodo.equals(""))
		{
			logger.error("Error buscando nodo de arbol curricular. Nodo vacio.");
			throw new Exception("Error buscando nodo de arbol curricular. Nodo vacio.");
		}
		if (idioma == null || idioma.equals(""))
		{
			logger.error("Error buscando nodo de arbol curricular. Idioma de busqueda vacio.");
			throw new Exception("Error buscando nodo de arbol curricular. Idioma de busqueda vacio.");
		}
		if (fechaDesde == null || fechaHasta == null)
    	{
    		logger.error("Error buscando nodo de arbol curricular. Fechas desde["+fechaDesde==null?null:fechaDesde.toString()+"] y hasta["+fechaHasta==null?null:fechaHasta.toString()+"] vacias.");
    		throw new Exception("Error buscando nodo de arbol curricular. Fechas desde["+fechaDesde==null?null:fechaDesde.toString()+"] y hasta["+fechaHasta==null?null:fechaHasta.toString()+"] vacias.");
    	}
    	if (fechaDesde.after(fechaHasta))
    	{
    		logger.error("Error buscando nodo de arbol curricular. Fechas desde["+fechaDesde.toString()+"] y hasta["+fechaHasta.toString()+"] incoherentes.");
    		throw new Exception("Error buscando nodo de arbol curricular. Fechas desde["+fechaDesde.toString()+"] y hasta["+fechaHasta.toString()+"] incoherentes.");    		
    	}
    	BooleanQuery andQuery = new BooleanQuery();
//		Configuramos el valor de memoria.	
    	andQuery.setMaxClauseCount(Integer.parseInt(props.getProperty("maxClauseCount")));
    	Calendar antes = Calendar.getInstance();
    	Calendar despues= Calendar.getInstance();
    	antes.setTime(fechaDesde.getTime());
    	despues.setTime(fechaHasta.getTime());
    	String antesS = ""+antes.get(Calendar.YEAR)+formatMonthMM((antes.get(Calendar.MONTH)+1))+formatDayDD(antes.get(Calendar.DAY_OF_MONTH));
    	String despuesS = ""+despues.get(Calendar.YEAR)+formatMonthMM((despues.get(Calendar.MONTH)+1))+formatDayDD(despues.get(Calendar.DAY_OF_MONTH));
    	logger.debug("Buscando nodo de arbol curricular["+idNodo+"] desde["+antesS+"] hasta["+despuesS+"]");
		//aniadimos la query con el rango de fechas
    	andQuery.add(getRangeQuery(props.getProperty(CAMPO_FECHA_PUBLICACION),antesS,despuesS),BooleanClause.Occur.MUST);
		//aniadimos la query con el id del nodo
    	andQuery.add(getTermQuery(props.getProperty(CAMPO_AREA_CURRICULAR_NODO), idNodo),BooleanClause.Occur.MUST);
    	
//		Utilizamos el idioma seleccionado en la busqueda para buscar el indice sobre el que se ejecuta la query.
		Directory directorioIndiceSimple = this.getIndexByLanguage(idioma);
		if (directorioIndiceSimple == null)
		{
			logger.error("Error buscando nodo de arbol curricular. Indice para idioma["+idioma+"] no accesible. Imposible buscar.");
			throw new Exception("Error buscando nodo de arbol curricular. Indice para idioma["+idioma+"] no accesible. Imposible buscar.");
		}
		Hits hits;
		try {
			IndexSearcher searcher = new IndexSearcher(directorioIndiceSimple);
			searcher.setSimilarity(new DefaultSimilarity());
			hits = searcher.search(andQuery);
		} catch (Exception e) {
			logger.error("Error buscando nodo de arbol curricular. Error buscando en indice["+idioma+"] con query["+andQuery.toString()+"].["+e.getCause()+"]");
			throw new Exception("Error buscando nodo de arbol curricular. Error buscando en indice["+idioma+"] con query["+andQuery.toString()+"].",e);
		}
		ResultadosCountVO resultado = new ResultadosCountVO();
		if (hits != null)
			resultado.setDocumentosCount(new Integer(hits.length()));
		else
			resultado.setDocumentosCount(new Integer(0));
		return resultado;
	}

	/**
	 * Este metodo busca los documentos indexados que cumplan estar en el rango de valoraciones que le pasan dentro de las fechas desde y hasta.
	 * @param nivelAgregacion Valor de valoracion.
	 * @param fechaDesde Fecha desde del periodo en el que se esta interesado.
	 * @param fechaHasta Fecha hasta del periodo en el que se esta interesado.
	 * @param idioma Idioma en el que se esta interesado buscar.
	 * @return ResultadosCountVO VO que alberga el resultado de la solicitud de la suma de documentos que cumplen la condicion.
	 */
	protected ResultadosCountVO handleBusquedaDocsRangoFechaNivelAgregacion(String nivelAgregacion, Calendar fechaDesde, Calendar fechaHasta, String idioma) throws Exception {
		if (nivelAgregacion == null || nivelAgregacion.equals(""))
		{
			logger.error("Error buscando documentos con rango de valoracion. Nivel de agregacion vacio.");
			throw new Exception("Error buscando documentos con rango de valoracion. Nivel de agregacion vacio.");
		}
		if (idioma == null || idioma.equals(""))
		{
			logger.error("Error buscando documentos con rango de valoracion. Idioma de busqueda vacio.");
			throw new Exception("Error buscando documentos con rango de valoracion. Idioma de busqueda vacio.");
		}
		if (fechaDesde == null || fechaHasta == null)
    	{
    		logger.error("Error buscando documentos con rango de valoracion. Fechas desde["+fechaDesde==null?null:fechaDesde.toString()+"] y hasta["+fechaHasta==null?null:fechaHasta.toString()+"] vacias.");
    		throw new Exception("Error buscando documentos con rango de valoracion. Fechas desde["+fechaDesde==null?null:fechaDesde.toString()+"] y hasta["+fechaHasta==null?null:fechaHasta.toString()+"] vacias.");
    	}
    	if (fechaDesde.after(fechaHasta))
    	{
    		logger.error("Error buscando documentos con rango de valoracion. Fechas desde["+fechaDesde.toString()+"] y hasta["+fechaHasta.toString()+"] incoherentes.");
    		throw new Exception("Error buscando documentos con rango de valoracion. Fechas desde["+fechaDesde.toString()+"] y hasta["+fechaHasta.toString()+"] incoherentes.");    		
    	}
    	BooleanQuery andQuery = new BooleanQuery();
//		Configuramos el valor de memoria.	
    	andQuery.setMaxClauseCount(Integer.parseInt(props.getProperty("maxClauseCount")));
    	Calendar antes = Calendar.getInstance();
    	Calendar despues= Calendar.getInstance();
    	antes.setTime(fechaDesde.getTime());
    	despues.setTime(fechaHasta.getTime());
    	String antesS = ""+antes.get(Calendar.YEAR)+formatMonthMM((antes.get(Calendar.MONTH)+1))+formatDayDD(antes.get(Calendar.DAY_OF_MONTH));
    	String despuesS = ""+despues.get(Calendar.YEAR)+formatMonthMM((despues.get(Calendar.MONTH)+1))+formatDayDD(despues.get(Calendar.DAY_OF_MONTH));
    	logger.debug("Buscando documentos con nivel de agregacion["+nivelAgregacion+"] desde["+antesS+"] hasta["+despuesS+"]");
		//aniadimos la query con el rango de fechas
    	andQuery.add(getRangeQuery(props.getProperty(CAMPO_FECHA_PUBLICACION),antesS,despuesS),BooleanClause.Occur.MUST);
		//aniadimos la query con la valoracion
    	andQuery.add(getTermQuery(props.getProperty(CAMPO_NIVEL_AGREGACION), nivelAgregacion),BooleanClause.Occur.MUST);
    	
//		Utilizamos el idioma seleccionado en la busqueda para buscar el indice sobre el que se ejecuta la query.
		Directory directorioIndiceSimple = this.getIndexByLanguage(idioma);
		if (directorioIndiceSimple == null)
		{
			logger.error("Error buscando documentos con rango de valoracion. Indice para idioma["+idioma+"] no accesible. Imposible buscar.");
			throw new Exception("Error buscando documentos con rango de valoracion. Indice para idioma["+idioma+"] no accesible. Imposible buscar.");
		}
		Hits hits;
		try {
			IndexSearcher searcher = new IndexSearcher(directorioIndiceSimple);
			searcher.setSimilarity(new DefaultSimilarity());
			hits = searcher.search(andQuery);
		} catch (Exception e) {
			logger.error("Error buscando documentos con rango de valoracion. Error buscando en indice["+idioma+"] con query["+andQuery.toString()+"].["+e.getCause()+"]");
			throw new Exception("Error buscando documentos con rango de valoracion. Error buscando en indice["+idioma+"] con query["+andQuery.toString()+"].",e);
		}
		ResultadosCountVO resultado = new ResultadosCountVO();
		if (hits != null)
			resultado.setDocumentosCount(new Integer(hits.length()));
		else
			resultado.setDocumentosCount(new Integer(0));
		return resultado;
	}
	
	protected PrioridadPalabrasClaveVO handleObtenerPalabrasClave(ParamPalabrasClave paramBusq) throws Exception {
		if(logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleObtenerPalabrasClave con par metros: IdiomaBusqueda="+paramBusq.getIdiomaBusqueda()+" n mero resultados="+paramBusq.getNumeroResultados());
		try{
//		Utilizamos el idioma seleccionado en la busqueda para buscar el indice sobre el que se ejecuta la query.
			String indexPath = getIndexPathByLanguage(paramBusq.getIdiomaBusqueda());
			if(exists(new File(indexPath))){
				PrioridadPalabrasClaveVO resultado = HighFreqTerms.obtenerPalabrasClave(paramBusq,getIndexPathByLanguage(paramBusq.getIdiomaBusqueda()));
				return resultado;
			}else{
				throw new Exception("SrvBuscarServiceImpl - handleObtenerPalabrasClave ERROR: No existe la carpeta para el  ndice="+indexPath);
			}
		}catch(java.lang.Exception e){
			Exception exc = new Exception("SrvBuscarServiceImpl - handleObtenerPalabrasClave ERROR: Con idioma="+paramBusq.getIdiomaBusqueda(), e);
			logger.error(exc);
			throw exc;
		}
	}

	
	 /**
	 * Este metodo busca los ODEs indexados en todos los indices que cumplan las condiciones de busqueda que le pasan como parametro.
	 * Las fechas desde y hasta se interpretan inclusives y en el caso de no estar presentes, sin limite superior o inferior.
	 * @param paramBusq Parametros de busqueda.
	 * @return ResultadoHeaderVO[] Array de VO's que albergan los resulados de la consulta en un contenedor de Headers.
	 */
	protected es.pode.indexador.negocio.servicios.busqueda.ResultadoHeaderVO[] handleBusquedaHeadersRepositorio(ParamPeriodoRepositorioVO paramBusq) throws Exception {

	  	if (paramBusq == null)
    	{
    		logger.error("Error obteniendo las cabeceras del repositorio. No hay parametros de busqueda.");
    		throw new Exception("Error obteniendo las cabeceras del repositorio. No hay parametros de busqueda.");
    	}
    	Date fechaDesde = (paramBusq.getDesde()!= null?paramBusq.getDesde().getTime():null);
    	Date fechaHasta = (paramBusq.getHasta()!= null?paramBusq.getHasta().getTime():null);
    	if (fechaDesde != null && fechaHasta != null && fechaDesde.after(fechaHasta))
    	{
    		logger.error("Error obteniendo las cabeceras del repositorio. Fechas desde["+fechaDesde.toString()+"] y hasta["+fechaHasta.toString()+"] incoherentes.");
    		throw new Exception("Error obteniendo las cabeceras del repositorio. Fechas desde["+fechaDesde.toString()+"] y hasta["+fechaHasta.toString()+"] incoherentes.");    		
    	}
//		Obtenemos todos los indices sobre los que hay objetos
    	IndiceVO[] indices = new IndiceVO[0];
    	try {
    		 indices = handleObtenerIdiomasBusqueda();
    	} catch (Exception e) {
    		logger.error("Error obteniendo las cabeceras del repositorio. Imposible recuperar los indices.["+e.getMessage()+"]");
    		throw new Exception("Error obteniendo las cabeceras del repositorio. Imposible recuperar los indices.", e);
    	}
//  	Para cada indice, tenemos que hacer un recorrido de todos los nodos del arbol y sumar el acumulado.
    	if (indices == null || indices.length == 0)
    	{
    		logger.error("Error obteniendo las cabeceras del repositorio. No existen indices en el indexador. Imposible continuar.");
    		throw new Exception("Error obteniendo las cabeceras del repositorio. No existen indices en el indexador. Imposible continuar.");
    	}
    	
//    	Configuramos la query que se va a realizar sobre el indice
    	BooleanQuery andQuery = new BooleanQuery();
//		Configuramos el valor de memoria.	
    	andQuery.setMaxClauseCount(Integer.parseInt(props.getProperty("maxClauseCount")));
//    	Configuramos la fecha desde
    	String antesS = null;
    	String despuesS = null;
    	if (fechaDesde != null){
    		Calendar antes = Calendar.getInstance();
    		antes.setTime(fechaDesde);
    		antesS = ""+antes.get(Calendar.YEAR)+formatMonthMM((antes.get(Calendar.MONTH)+1))+formatDayDD(antes.get(Calendar.DAY_OF_MONTH));
    	}
//    	Configuramos la fecha hasta
    	if (fechaHasta != null) {
    		Calendar despues = Calendar.getInstance();
    		despues.setTime(fechaHasta);
    		despuesS = "" + despues.get(Calendar.YEAR) + formatMonthMM((despues.get(Calendar.MONTH) + 1))
    		+ formatDayDD(despues.get(Calendar.DAY_OF_MONTH));
    	}
		logger.debug("Buscando headers en repositorio desde["+antesS+"] hasta["+despuesS+"]");
		//aniadimos la query con el rango de fechas
    	andQuery.add(getConstantScoreRangeQuery(props.getProperty(CAMPO_FECHA_PUBLICACION),antesS,despuesS),BooleanClause.Occur.MUST);

//		Nos recorremos todos los indices realizando la misma consulta y recopilando la informacion que saquemos de cada indice
    	ArrayList resultados = new ArrayList();
    	for (int i = 0; i < indices.length; i++) {
    		Directory directorioIndiceSimple = this.getIndexByLanguage(indices[i].getIdentificador());
    		if (directorioIndiceSimple == null)
    		{
    			logger.error("Error obteniendo las cabeceras del repositorio. Indice para idioma["+indices[i].getIdentificador()+"] no accesible. Imposible buscar.");
    			throw new Exception("Error obteniendo las cabeceras del repositorio. Indice para idioma["+indices[i].getIdentificador()+"] no accesible. Imposible buscar.");
    		}
    		Hits hits;
    		try {
    			IndexSearcher searcher = new IndexSearcher(directorioIndiceSimple);
    			searcher.setSimilarity(new DefaultSimilarity());
    			hits = searcher.search(andQuery);
//    			Ahora llamamos a la busqueda en repositorio pero aplicando un filtro de licencia
//    			hits = searcher.search(andQuery, crearFiltroLicencia());
    		} catch (Exception e) {
    			logger.error("Error obteniendo las cabeceras del repositorio. Error buscando en indice["+indices[i].getIdentificador()+"] con query["+andQuery.toString()+"].["+e.getCause()+"]");
    			throw new Exception("Error obteniendo las cabeceras del repositorio. Error buscando en indice["+indices[i].getIdentificador()+"] con query["+andQuery.toString()+"].",e);
    		}
    		if (hits != null && hits.length() > 0)
    		{
    			try {
					resultados.addAll(Arrays.asList(mapDocToHeader(hits)));
				} catch (RuntimeException e) {
					logger.error("Error obteniendo las cabeceras del repositorio. Error mapeando resultados para indice["+indices[i].getIdentificador()+"] con query["+andQuery.toString()+"].["+e.getCause()+"]");
	    			throw new Exception("Error obteniendo las cabeceras del repositorio. Error mapeando resultados para indice["+indices[i].getIdentificador()+"] con query["+andQuery.toString()+"].",e);
				}
    		}
		}
		return (ResultadoHeaderVO[])resultados.toArray(new ResultadoHeaderVO[0]);
	}

	 /**
	 * Este metodo busca el identificador en todo el repositorio del indexador.
	 * @param idMEC Identificador del ODE.
	 * @return DocVO VO con la informacion indexada de un ODE.
	 */
	
	protected es.pode.indexador.negocio.servicios.busqueda.ResultadoRecordVO handleBusquedaMECRepositorio(String idMEC) throws Exception {
	  	
//		Comprobamos el MEC
		if (idMEC == null || idMEC.equals(""))
    	{
    		logger.error("Error buscando ODE por MEC en el repositorio. Identificador MEC vacio["+idMEC+"].");
    		throw new Exception("Error buscando ODE por MEC en el repositorio. Identificador MEC vacio["+idMEC+"].");
    	}
//		Obtenemos todos los indices sobre los que hay objetos
    	IndiceVO[] indices = new IndiceVO[0];
    	try {
    		 indices = handleObtenerIdiomasBusqueda();
    	} catch (Exception e) {
    		logger.error("Error obteniendo las cabeceras del repositorio. Imposible recuperar los indices.["+e.getMessage()+"]");
    		throw new Exception("Error obteniendo las cabeceras del repositorio. Imposible recuperar los indices.", e);
    	}
//  	Para cada indice, tenemos que hacer un recorrido de todos los nodos del arbol y sumar el acumulado.
    	if (indices == null || indices.length == 0)
    	{
    		logger.error("Error obteniendo las cabeceras del repositorio. No existen indices en el indexador. Imposible continuar.");
    		throw new Exception("Error obteniendo las cabeceras del repositorio. No existen indices en el indexador. Imposible continuar.");
    	}
//    	Iteramos sobre los indices para encontrar el ODE
       	for (int i = 0; i < indices.length; i++) {
    		DisjunctionMaxQuery query = new DisjunctionMaxQuery(0.01f);
    		Hits hits = null;
    		if ((hits = this.internaBusquedaMEC(idMEC, indices[i].getIdentificador(), query)) != null) {
//    			Hay hit, mapeamos los resultados 
    			return mapDocToRecord(hits)[0];
    		}
		}
//      Si llegamos aqui es que no ha encontrado el ODE
		return null;
	}

	 /**
	 * Metodo que ejecuta una busqueda en todo el repositorio con los parametros de busqueda que le pasan.
	 * Las fechas desde y hasta se interpretan inclusives y en el caso de no estar presentes, sin limite superior o inferior.
	 * @param paramBusq Parametros de busqueda.
	 * @return ResultadoRecordVO[] Array de VO's que albergan los resulados de la consulta en un contenedor de Records.
	 */
	protected es.pode.indexador.negocio.servicios.busqueda.ResultadoRecordVO[] handleBusquedaRepositorio(ParamPeriodoRepositorioVO paramBusq) throws Exception {
	  	if (paramBusq == null)
    	{
    		logger.error("Error obteniendo los registros del repositorio. No hay parametros de busqueda.");
    		throw new Exception("Error obteniendo los registros del repositorio. No hay parametros de busqueda.");
    	}
    	Date fechaDesde = (paramBusq.getDesde()!=null?paramBusq.getDesde().getTime():null);
    	Date fechaHasta = (paramBusq.getHasta()!=null?paramBusq.getHasta().getTime():null);
    	if (fechaDesde != null && fechaHasta != null && fechaDesde.after(fechaHasta))
    	{
    		logger.error("Error obteniendo los registros del repositorio. Fechas desde["+fechaDesde.toString()+"] y hasta["+fechaHasta.toString()+"] incoherentes.");
    		throw new Exception("Error obteniendo los registros del repositorio. Fechas desde["+fechaDesde.toString()+"] y hasta["+fechaHasta.toString()+"] incoherentes.");    		
    	}
//		Obtenemos todos los indices sobre los que hay objetos
    	IndiceVO[] indices = new IndiceVO[0];
    	try {
    		 indices = handleObtenerIdiomasBusqueda();
    	} catch (Exception e) {
    		logger.error("Error obteniendo los registros del repositorio. Imposible recuperar los indices.["+e.getMessage()+"]");
    		throw new Exception("Error obteniendo los registros del repositorio. Imposible recuperar los indices.", e);
    	}
//  	Para cada indice, tenemos que hacer un recorrido de todos los nodos del arbol y sumar el acumulado.
    	if (indices == null || indices.length == 0)
    	{
    		logger.error("Error obteniendo los registros del repositorio. No existen indices en el indexador. Imposible continuar.");
    		throw new Exception("Error obteniendo los registros del repositorio. No existen indices en el indexador. Imposible continuar.");
    	}
    	
//    	Configuramos la query que se va a realizar sobre el indice
    	BooleanQuery andQuery = new BooleanQuery();
//		Configuramos el valor de memoria.	
    	andQuery.setMaxClauseCount(Integer.parseInt(props.getProperty("maxClauseCount")));
//    	Configuramos la fecha desde
    	String antesS = null;
    	String despuesS = null;
    	if (fechaDesde != null){
    		Calendar antes = Calendar.getInstance();
    		antes.setTime(fechaDesde);
    		antesS = ""+antes.get(Calendar.YEAR)+formatMonthMM((antes.get(Calendar.MONTH)+1))+formatDayDD(antes.get(Calendar.DAY_OF_MONTH));
    	}
//    	Configuramos la fecha hasta
    	if (fechaHasta != null) {
    		Calendar despues = Calendar.getInstance();
    		despues.setTime(fechaHasta);
    		despuesS = "" + despues.get(Calendar.YEAR) + formatMonthMM((despues.get(Calendar.MONTH) + 1))
    		+ formatDayDD(despues.get(Calendar.DAY_OF_MONTH));
    	}
    	logger.debug("Buscando registros en repositorio desde["+antesS+"] hasta["+despuesS+"]");
		//aniadimos la query con el rango de fechas
    	andQuery.add(getConstantScoreRangeQuery(props.getProperty(CAMPO_FECHA_PUBLICACION),antesS,despuesS),BooleanClause.Occur.MUST);
    	
//		Nos recorremos todos los indices realizando la misma consulta y recopilando la informacion que saquemos de cada indice
    	ArrayList resultados = new ArrayList();
    	for (int i = 0; i < indices.length; i++) {
    		Directory directorioIndiceSimple = this.getIndexByLanguage(indices[i].getIdentificador());
    		if (directorioIndiceSimple == null)
    		{
    			logger.error("Error obteniendo los registros del repositorio. Indice para idioma["+indices[i].getIdentificador()+"] no accesible. Imposible buscar.");
    			throw new Exception("Error obteniendo los registros del repositorio. Indice para idioma["+indices[i].getIdentificador()+"] no accesible. Imposible buscar.");
    		}
    		Hits hits;
    		try {
    			IndexSearcher searcher = new IndexSearcher(directorioIndiceSimple);
    			searcher.setSimilarity(new DefaultSimilarity());
    			hits = searcher.search(andQuery);
//    			Ahora llamamos a la busqueda en repositorio pero aplicando un filtro de licencia
//    			hits = searcher.search(andQuery, crearFiltroLicencia());
    		} catch (Exception e) {
    			logger.error("Error obteniendo los registros del repositorio. Error buscando en indice["+indices[i].getIdentificador()+"] con query["+andQuery.toString()+"].["+e.getCause()+"]");
    			throw new Exception("Error obteniendo los registros del repositorio. Error buscando en indice["+indices[i].getIdentificador()+"] con query["+andQuery.toString()+"].",e);
    		}
    		if (hits != null && hits.length() > 0)
    		{
    			try {
					resultados.addAll(Arrays.asList(mapDocToRecord(hits)));
				} catch (RuntimeException e) {
					logger.error("Error obteniendo los registros del repositorio. Error mapeando resultados para indice["+indices[i].getIdentificador()+"] con query["+andQuery.toString()+"].["+e.getCause()+"]");
	    			throw new Exception("Error obteniendo los registros del repositorio. Error mapeando resultados para indice["+indices[i].getIdentificador()+"] con query["+andQuery.toString()+"].",e);
				}
    		}
		}
    	return (ResultadoRecordVO[])resultados.toArray(new ResultadoRecordVO[resultados.size()]);
	}

	/**
	 * Este metodo recoge la fecha de inicio del repositorio
	 * @return Calendar Con la fecha de inicio.
	 * @throws Exception
	 */
	protected Calendar handleFechaInicioRepositorio() throws Exception {
		
//		Obtenemos todos los indices sobre los que hay objetos
    	IndiceVO[] indices = new IndiceVO[0];
    	try {
    		 indices = handleObtenerIdiomasBusqueda();
    	} catch (Exception e) {
    		logger.error("Error obteniendo fecha inicio del repositorio. Imposible recuperar los indices.["+e.getMessage()+"]");
    		throw new Exception("Error obteniendo fecha inicio del repositorio. Imposible recuperar los indices.", e);
    	}
//  	Para cada indice, tenemos que hacer un recorrido de todos los nodos del arbol y sumar el acumulado.
    	if (indices == null || indices.length == 0)
    	{
    		logger.error("Error obteniendo fecha inicio del repositorio. No existen indices en el indexador. Imposible continuar.");
    		throw new Exception("Error obteniendo fecha inicio del repositorio. No existen indices en el indexador. Imposible continuar.");
    	}
//    	Nos recorremos todos los indices a por la fecha mas antigua
		Directory directorioIndiceSimple = null;
		Hashtable fechasIdioma= new Hashtable();
		Hashtable fechasRepositorio= new Hashtable();
		String campoFechaIndice = props.getProperty("campo_fechaPublicacion");
		for (int i = 0; i < indices.length; i++) {
			directorioIndiceSimple = this.getIndexByLanguage(indices[i].getIdentificador());
			IndexReader indiceLectura = null;
			try {
				indiceLectura = IndexReader.open(directorioIndiceSimple);
			} catch (Exception e) {
				logger.warn("Detectando fecha de inicio del repositorio. El indice ["+indices[i].getFile_indice()+"] no existe o no se puede abrir, no lo tenemos en cuenta. Seguimos");
			}
//			Si hay indice de lectura del cual tirar, sigo
			if (indiceLectura != null)
			{
//				Nos sacamos todos los terminos almacenados en el indice
				TermEnum enumeracion = indiceLectura.terms();
				while (enumeracion.next())
				{
//					Si el termino que tratamos es el de fecha, cojemos su valor
					if (campoFechaIndice.equals(enumeracion.term().field()))
						fechasIdioma.put(enumeracion.term().text(), "");
				}
//				Si hay fechas en el indice, las tratamos, si no pasamos
				if (!fechasIdioma.keySet().isEmpty())
				{
					String[] arrayFechas = (String[])fechasIdioma.keySet().toArray(new String[0]);
					bubble(arrayFechas);
//					ya estan ordenadas. 
					fechasRepositorio.put(arrayFechas[0], "");
				}
				else
					logger.warn("Detectando fecha de inicio del repositorio. No hay fechas en el indice["+indices[i].getFile_indice()+"]. Seguimos.");
			}
			fechasIdioma.clear();
		}
//		Si no hay fechas en todo el indice, no puedo dar una fecha!!
		if (fechasRepositorio.keySet().isEmpty())
		{
			logger.error("Error detectando fecha de inicio del repositorio. No hay fechas en los["+indices.length+"] indices revisados.");
			throw new Exception("Error detectando fecha de inicio del repositorio. No hay fechas en los["+indices.length+"] indices revisados.");
		}
		String[] arrayFechasFinal = (String[])fechasRepositorio.keySet().toArray(new String[0]);
		bubble(arrayFechasFinal); // vuelvo a ordenar las fechas iniciales de todos los indices.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return DateManager.dateToCalendar(sdf.parse(arrayFechasFinal[0]));
	}

	/*
	 * Este metodo crea un filtro por ODEs licenciados para una busqueda. Un filtro funciona de tal manera
	 * que se le insertan terminos que se entienden necesarios de cumplir para los resultados de busqueda, de
	 * manera que la busqueda solo se hace en el subconjunto de los documentos que cumplen el filtro y asi la
	 * busqueda se hace mas rapida ya que se tienen en cuenta menos documentos sobre los que buscar.
	 * */
	private Filter crearFiltroLicencia()
	{
//		Al filtro solo hay que introducirle los terminos que deseamos sean necesarios que esten presentes en los
//		documentos sobre los que se hara la busqueda. En el caso de un filtro licencia, se trata de los terminos 
//		de ambito con valor universal y el propio nodo en el que se esta haciendo la busqueda.
		TermsFilter filtro = new TermsFilter();
		filtro.addTerm(new Term(props.getProperty("campo_ambito"),"universal"));
//		Si hay mas valores que tengamos que insertar, hay que hacerlo aqui: por ejemplo el nodo en el que estoy
		return filtro;
	}

	/**
	 * Este metodo busca un ODE al azar de dentro del repositorio.
	 * @return DocVO Detalle de un ODE indexado.
	 */
	protected DocVO handleObtenerODERandom() throws Exception {
		List listaIndices = (List)this.getIndiceDao().loadAll(getIndiceDao().TRANSFORM_INDICEVO);
		if (listaIndices.size() == 0)//		No hay indices que listar, no devuelvo nada
			return null;
		Random random = new Random(Calendar.getInstance().getTimeInMillis());
		Document doc=null;
		boolean noCero=true;
		int intRandom = random.nextInt();
		int i =0;
		int reintentosInt=10; //Puede que intRandom sea 0, para que no sea as  haremos 10 intentos como mucho
		for (i = 0;	 i < reintentosInt && intRandom!=0 && noCero; i++) {
			
	//		Sacamos el indice aleatoriamente de todos los indices del repositorio
			int idiomaSeleciconado = (intRandom<0?(intRandom*(-1)):intRandom)%listaIndices.size();
			IndiceVO indice = (IndiceVO)listaIndices.get(idiomaSeleciconado);
	//		Abrimos el indice y vemos el numero de documentos indexados
			Directory directorioIndiceSimple = null;
			directorioIndiceSimple = this.getIndexByLanguage(indice.getIdentificador());
			IndexReader indiceLectura = IndexReader.open(directorioIndiceSimple);
			int numeroDocumentos = indiceLectura.numDocs();
			logger.debug("El numero de documentos del indice es "+numeroDocumentos);
	//		Seleccionamos el documento que vamos a extraer
			if(numeroDocumentos>0){
				intRandom = random.nextInt();
				noCero=false;
				int documentoSeleccionado = (intRandom<0?(intRandom*(-1)):intRandom)%numeroDocumentos;
				logger.info("Devuelto documento ["+documentoSeleccionado+"] de ["+numeroDocumentos+"] documentos totales indexados.");
				doc = indiceLectura.document(documentoSeleccionado);
			}
			indiceLectura.close();
		}
		if(i==reintentosInt && noCero){
			logger.info("No se ha encontrado ning n random  v lido en ["+reintentosInt+"] intentos");
		}
		if(doc!=null)
			return getVOFromLucene(doc, new DocVO(), 0);
		else
			return null;
	}
	
	 /**
	 * Este metodo devuelve todos los ODEs indexados en el repositorio para todos los idiomas.
	 * @return ResultadoRepositorioVO[] Array de VO's que albergan los resulados del repositorio.
	 */
	protected ResultadoRepositorioVO[] handleObtenerRepositorio() throws Exception {
		
    	Date fechaDesde = handleFechaInicioRepositorio().getTime();
    	Date fechaHasta = Calendar.getInstance().getTime(); // la fecha de hoy como hasta

//		Obtenemos todos los indices sobre los que hay objetos
    	IndiceVO[] indices = new IndiceVO[0];
    	try {
    		 indices = handleObtenerIdiomasBusqueda();
    	} catch (Exception e) {
    		logger.error("Error recuperando repositorio. Imposible recuperar los indices.["+e.getMessage()+"]");
    		throw new Exception("Error recuperando repositorio. Imposible recuperar los indices.", e);
    	}
//  	Para cada indice, tenemos que recoger todos los odes.
    	if (indices == null || indices.length == 0)
    	{
    		logger.error("Error recuperando repositorio. No existen indices en el indexador. Imposible continuar.");
    		throw new Exception("Error recuperando repositorio. No existen indices en el indexador. Imposible continuar.");
    	}
    	
//    	Configuramos la query que se va a realizar sobre el indice
    	BooleanQuery andQuery = new BooleanQuery();
//		Configuramos el valor de memoria.	
    	andQuery.setMaxClauseCount(Integer.parseInt(props.getProperty("maxClauseCount")));
//    	Configuramos la fecha desde
    	String antesS = null;
    	String despuesS = null;
    	if (fechaDesde != null){
    		Calendar antes = Calendar.getInstance();
    		antes.setTime(fechaDesde);
    		antesS = ""+antes.get(Calendar.YEAR)+formatMonthMM((antes.get(Calendar.MONTH)+1))+formatDayDD(antes.get(Calendar.DAY_OF_MONTH));
    	}
//    	Configuramos la fecha hasta
    	if (fechaHasta != null) {
    		Calendar despues = Calendar.getInstance();
    		despues.setTime(fechaHasta);
    		despuesS = "" + despues.get(Calendar.YEAR) + formatMonthMM((despues.get(Calendar.MONTH) + 1))
    		+ formatDayDD(despues.get(Calendar.DAY_OF_MONTH));
    	}
    	logger.debug("Recuperando repositorio desde["+antesS+"] hasta["+despuesS+"]");
		//aniadimos la query con el rango de fechas
    	andQuery.add(getConstantScoreRangeQuery(props.getProperty(CAMPO_FECHA_PUBLICACION),antesS,despuesS),BooleanClause.Occur.MUST);
    	
//		Nos recorremos todos los indices realizando la misma consulta y recopilando la informacion que saquemos de cada indice
    	ArrayList resultados = new ArrayList();
    	for (int i = 0; i < indices.length; i++) {
    		Directory directorioIndiceSimple = this.getIndexByLanguage(indices[i].getIdentificador());
    		if (directorioIndiceSimple == null)
    		{
    			logger.error("Error recuperando repositorio. Indice para idioma["+indices[i].getIdentificador()+"] no accesible. Imposible buscar.");
    			throw new Exception("Error recuperando repositorio. Indice para idioma["+indices[i].getIdentificador()+"] no accesible. Imposible buscar.");
    		}
    		Hits hits = null;
    		try {
    			IndexSearcher searcher = new IndexSearcher(directorioIndiceSimple);
    			searcher.setSimilarity(new DefaultSimilarity());
    			hits = searcher.search(andQuery);
//    			Dejamos de aplicar el filtro de licencia. Nos interesan todos los ODEs del repositorio
//    			hits = searcher.search(andQuery, crearFiltroLicencia());
    		} catch (Exception e) {
    			logger.error("Error recuperando repositorio. Error buscando en indice["+indices[i].getIdentificador()+"] con query["+andQuery.toString()+"].["+e.getCause()+"]");
//    			En el caso de que el indice de error, miro por el resto.
//    			throw new Exception("Error recuperando repositorio. Error buscando en indice["+indices[i].getIdentificador()+"] con query["+andQuery.toString()+"].",e);
    		}
    		if (hits != null && hits.length() > 0)
    		{
    			logger.info("Recuperando repositorio. Informacion de repositorio disponible para idioma["+indices[i].getIdentificador()+"] fechas["+antesS+"-"+despuesS+"] query["+andQuery.toString()+"] documentos["+hits.length()+"]");
    			try {
					resultados.addAll(Arrays.asList(mapDocToRepositorio(hits)));
				} catch (RuntimeException e) {
					logger.error("Error recuperando repositorio. Error mapeando resultados para indice["+indices[i].getIdentificador()+"] con query["+andQuery.toString()+"].["+e.getCause()+"]");
	    			throw new Exception("Error recuperando repositorio. Error mapeando resultados para indice["+indices[i].getIdentificador()+"] con query["+andQuery.toString()+"].",e);
				}
    		}
    		else
    		{
    			logger.info("Recuperando repositorio. No hay informacion de repositorio disponible para idioma["+indices[i].getIdentificador()+"] fechas["+antesS+"-"+despuesS+"] query["+andQuery.toString()+"]");
    		}
		}
    	return (ResultadoRepositorioVO[])resultados.toArray(new ResultadoRepositorioVO[resultados.size()]);
	}
	
	/**
	 * Este metodo devuelve el n mero total de ODEs indexados en el repositorio para todos los idiomas.
	 * @return ResultadosCountVO VO que contiene el total de odes.
	 */
	protected ResultadosCountVO handleObtenerTotalesRepositorio() throws Exception {
		// TODO Auto-generated method stub
		ResultadosCountVO resultado = new ResultadosCountVO();
		IndiceVO[] indices = new IndiceVO[0];
    	try {
    		 indices = handleObtenerIdiomasBusqueda();
    	} catch (Exception e) {
    		logger.error("SrvBuscarServiceImpl - handleObtenerTotalesRepositorio: Error recuperando repositorio. Imposible recuperar los indices.["+e.getMessage()+"]");
    		throw new Exception("SrvBuscarServiceImpl - handleObtenerTotalesRepositorio:Error recuperando repositorio. Imposible recuperar los indices.", e);
    	}
//  	Para cada indice, tenemos que recoger todos los odes.
    	if (indices == null || indices.length == 0)
    	{
    		logger.error("SrvBuscarServiceImpl - handleObtenerTotalesRepositorio:Error recuperando repositorio. No existen indices en el indexador. Imposible continuar.");
    		throw new Exception("SrvBuscarServiceImpl - handleObtenerTotalesRepositorio:Error recuperando repositorio. No existen indices en el indexador. Imposible continuar.");
    	}
		
    	Directory directorioIndiceSimple = null;
    	Integer[] conteo = new Integer[indices.length];
    	for(int i = 0; i < indices.length; i++){
			try{
				directorioIndiceSimple = this.getIndexByLanguage(indices[i].getIdentificador());
				IndexSearcher searcher = new IndexSearcher(directorioIndiceSimple);
				conteo[i]=searcher.maxDoc();
			}catch(java.lang.Exception e){
				logger.error("SrvBuscarServiceImpl - handleObtenerTotalesRepositorio: No existe  ndice para el idioma = "+indices[i].getIdentificador());
			}
		}
    	int documentosCount = 0;
    	for(int i = 0; i < conteo.length; i++){
    		if(conteo[i]!=null)documentosCount = documentosCount + conteo[i];
    	}
    	resultado.setConteo(conteo);
    	resultado.setDocumentosCount(documentosCount);
    	return resultado;
	}
	
	private Lom getLom(Metadata metadato, String identificador) {
		Lom lomReturn = null;

		if (metadato != null && metadato.getGrp_any() != null
				&& metadato.getGrp_any().getAnyObject() != null
				&& metadato.getGrp_any().getAnyObject().length > 0) {
			int iTam = metadato.getGrp_any().getAnyObject().length;
			boolean isLomes = false;
			for (int i = 0; !isLomes && i < iTam; i++) {
				Object any = metadato.getGrp_any().getAnyObject(i);
				if (any != null && any instanceof Lom) {
					if (logger.isDebugEnabled())
						logger.debug("Encontramos el LOMes en la posici n " + i);
					lomReturn = (Lom) any;
					isLomes = true;
				}// if
			}// for
		}// if

		return lomReturn;
	}
	
	private Manifest parsearManifiesto(String localizador) throws IndexaODEException 
	{
		Manifest manifest = null;
		
		try 
		{
			manifest = this.getScormDao().parsearODELazy(new File(localizador));
		} 
		catch (Exception e1) 
		{
			logger.error("No se puede parsear el fichero; localizador"+localizador);
			throw new IndexaODEException(e1);
		}
		return manifest;
	}

	private Directory getIndexByLanguage(String locale) throws Exception {
		Directory directorioIndiceSimple = null;
		if (logger.isDebugEnabled())
		{
			logger.debug("Accedemos a la BD con el idioma = " + locale);
			logger.debug("Path is: " + getIndexPathByLanguage(locale));
		}

		directorioIndiceSimple = FSDirectory.getDirectory(getIndexPathByLanguage(locale));
		return directorioIndiceSimple;
	}
	
	private String getIndexPathByLanguage(String locale) throws Exception {
		List resultado = this.getIndiceDao().buscarIndicePorIdentificador(
				locale);
		if (resultado != null && resultado.size() > 0) {
			Indice indiceSimple = (Indice) resultado.get(0);
			String stringPath = indiceSimple.getPath() + File.separator + indiceSimple.getFile_indice();
			if(exists(new File(stringPath))){
				return stringPath;
			}else throw new Exception("No existe indice para el idioma en carpeta = " + locale);
		} else
			throw new Exception("No existe indice para el idioma en DB= " + locale);
	}
	
	private Directory indiceSpell(String locale) throws IOException {
		Directory directorioIndiceSpell = null;
		if (logger.isDebugEnabled())
			logger.debug("Vamos a buscar el indice para el spellChecker para el idioma= "
						+ locale);
		List resultado = this.getIndiceDao().buscarIndicePorIdentificador(
				locale);

		if (resultado != null && resultado.size() > 0) {
			if (logger.isDebugEnabled())
				logger.debug("Obtenemos el indice = " + resultado);
			Indice indiceSimple = (Indice) resultado.get(0);
			String indiceSimpleDir = indiceSimple.getPath() + File.separator
					+ indiceSimple.getFile_indice() + File.separator
					+ SrvIndexadorServiceImpl.SPELL_CHECKER;
			if (logger.isDebugEnabled())
			logger.debug("El directorio del spellchecker es = "
							+ indiceSimpleDir);
			directorioIndiceSpell = FSDirectory.getDirectory(indiceSimpleDir);
		} else {
			if (logger.isDebugEnabled())
				logger.debug("No existe directorio de spellchecker definido para el idioma = "
							+ locale);
		}

		return directorioIndiceSpell;
	}

	private Hits internaBusquedaSimple(es.pode.indexador.negocio.servicios.busqueda.ParamSimpleVO paramBusq,DisjunctionMaxQuery query) throws Exception {
		Directory directorioIndiceSimple = this.getIndexByLanguage(paramBusq.getIdiomaBusqueda());
		IndexSearcher searcher= null;
 		try{
 			searcher = new IndexSearcher(directorioIndiceSimple);
 		}catch( java.io.FileNotFoundException iO){
 			throw new java.io.FileNotFoundException("Fichero lom-es no disponible");
 		}
		
		searcher.setSimilarity(new DefaultSimilarity());
		List palabras = devolverFrases(paramBusq.getPalabrasClave().trim(), paramBusq.getIdiomaBusqueda());
		String[] claves = props.getProperty(CAMPOS_CLAVE_SIMPLE).split(SEPARADOR_CLAVES);
		for (int i = 0; i < palabras.size(); i++) {
			for(int j = 0; j < claves.length; j++) {
				query.add((List.class.isInstance(palabras.get(i)))?getQuery(palabras.get(i),claves[j],CAMPOS_PHRASE_SIMPLE):getQuery(palabras.get(i).toString(),claves[j],CAMPOS_WILDCARD_SIMPLE));
			}
		}
		if (logger.isDebugEnabled())
			logger.debug("Consulta interna simple con query["+query.toString()+"]");
		Hits hits = searcher.search(query);
		return hits;
	}
	/**
	 * Este m todo verifica que un archivo exista
	 * @param f archivo
	 * @return boolean, si existe treu, si no false
	 */
	
	public static boolean exists(File f) {
	      if (f.isDirectory()) return true;
	      if (f.exists()) {
	    	  return true;
	      } else {
	    	  return false;
	      }
	}
	
	private Hits internaBusquedaNodo(es.pode.indexador.negocio.servicios.busqueda.ParamNodoArbolCurricularVO paramBusq,DisjunctionMaxQuery query) throws Exception {
 		Directory directorioIndiceSimple = this.getIndexByLanguage(paramBusq.getIdiomaBusqueda());
		IndexSearcher searcher = new IndexSearcher(directorioIndiceSimple);
		searcher.setSimilarity(new DefaultSimilarity());
		query.add(getTermQuery(props.getProperty(CAMPO_AREA_CURRICULAR), paramBusq.getAreaCurricular()));
		if (logger.isDebugEnabled())
			logger.debug("Consulta interna nodo arbol curricular con query["+query.toString()+"]");
		Hits hits = searcher.search(query);
		return hits;
	}
	
//	Obtiene una query a partir del campo, valor de campo o palabra y tipo de configuraci n wildcard (simple/avanzada)
	private Query getQuery(Object palabra, String clave, String tipoBusqueda) {
		//String[] camposAccesibles = props.getProperty(tipoBusqueda).split(SEPARADOR_CLAVES);
		//if((tipoBusqueda.equals(CAMPOS_PHRASE_AVANZADA) || tipoBusqueda.equals(CAMPOS_PHRASE_SIMPLE)) && getPhraseAccess(camposAccesibles, clave)) return getPhraseQuery(props.getProperty(clave), (List)palabra);
		//return (getWildcardAccess(camposAccesibles, clave) && (this.contains(palabra.toString(), ASTERISK) || this.contains(palabra.toString(), QUESTIONMARK)))? getWildcardQuery(props.getProperty(clave), (getLowerCaseAccess(props.getProperty(CAMPOS_LOWER_CASE).split(SEPARADOR_CLAVES),clave))?palabra.toString().trim().toLowerCase():palabra.toString().trim()):getTermQuery(props.getProperty(clave), (getLowerCaseAccess(props.getProperty(CAMPOS_LOWER_CASE).split(SEPARADOR_CLAVES),clave))?palabra.toString().trim().toLowerCase():palabra.toString().trim());

		String[] camposAccesibles = props.getProperty(tipoBusqueda).split(SEPARADOR_CLAVES);
		if(
(tipoBusqueda.equals(CAMPOS_PHRASE_AVANZADA) || tipoBusqueda.equals(CAMPOS_PHRASE_SIMPLE)) && getPhraseAccess(camposAccesibles, clave)
) {

                    Query q1 = getPhraseQuery(props.getProperty(clave), (List)palabra);
                    logger.debug("** A getQuery="+tipoBusqueda+ " QueryFrase="+q1);
                    return q1;
  }
		Query q1 = (getWildcardAccess(camposAccesibles, clave) && (this.contains(palabra.toString(), ASTERISK) || this.contains(palabra.toString(), QUESTIONMARK)))? getWildcardQuery(props.getProperty(clave), (getLowerCaseAccess(props.getProperty(CAMPOS_LOWER_CASE).split(SEPARADOR_CLAVES),clave))?palabra.toString().trim().toLowerCase():palabra.toString().trim()):getTermQuery(props.getProperty(clave), (getLowerCaseAccess(props.getProperty(CAMPOS_LOWER_CASE).split(SEPARADOR_CLAVES),clave))?palabra.toString().trim().toLowerCase():palabra.toString().trim());
                logger.debug("** B getQuery="+tipoBusqueda+ " QueryFrase="+q1);
                return q1;

	}
//	Concede o no acceso de tipo wildcard al indice en funci n de configuracion (simple/avanzada)
	private boolean getWildcardAccess(String[] camposWildcard, String campoAcceder) {
		for(int i = 0 ; i < camposWildcard.length ; i++) if(camposWildcard[i].equals(campoAcceder)) return true;
		return false;
	}
//  Comprueba si un campo del indice debe de ser a adido a la query como and u or, en funci n de configuraci n
	private boolean getAndOrAccess(String campoAcceder, boolean tipoAnd) {
		String[] campos = (tipoAnd)?props.getProperty(CAMPOS_AND).split(SEPARADOR_CLAVES):props.getProperty(CAMPOS_OR).split(SEPARADOR_CLAVES);
		for(int i = 0 ; i < campos.length ; i++) if(campos[i].equals(PREFIJO_CAMPO+campoAcceder)) return true;
		return false;
	}
//	Concede o no acceso de tipo wildcard al indice en funci n de configuracion (simple/avanzada)
	private boolean getPhraseAccess(String[] camposPhrase, String campoAcceder) {
		for(int i = 0 ; i < camposPhrase.length ; i++) if(camposPhrase[i].equals(campoAcceder)) return true;
		return false;
	}
	
//	Concede o no acceso de tipo wildcard al indice en funci n de configuracion (simple/avanzada)
	private boolean getLowerCaseAccess(String[] camposLowerCase, String campoAcceder) {
		for(int i = 0 ; i < camposLowerCase.length ; i++) if(camposLowerCase[i].equals(campoAcceder)) return true;
		return false;
	}
	
//	Concede o no acceso de tipo wildcard al indice en funci n de configuracion (simple/avanzada)
	private boolean getRangeQueryAccess(String[] camposRange, String campoAcceder) {
		for(int i = 0 ; i < camposRange.length ; i++) if(camposRange[i].equals(campoAcceder)) return true;
		return false;
	}
	private boolean esTextoLibre(String[] camposTextoLibre, String campoAcceder) {
		for(int i = 0 ; i < camposTextoLibre.length ; i++) if(camposTextoLibre[i].equals(campoAcceder)) return true;
		return false;
	}
//	Obtiene query simple	
	private Query getTermQuery(String f, String t) {
		return new TermQuery(new Term(f, t));
	}
//	Obtiene phrase query	
	private Query getPhraseQuery(String f, List frase) {
		PhraseQuery phraseQuery = new PhraseQuery();
		for(int i = 0 ; i < frase.size(); i++)phraseQuery.add(new Term(f, frase.get(i).toString().trim().toLowerCase()));
		phraseQuery.setSlop(Integer.parseInt(props.getProperty(DISTANCIA_ENTRE_CAMPOS_FRASE)));
		return phraseQuery;
	}
//	Obtiene range query. Se supone que el rango inferior y superior afectan al mismo campo (f)
	private Query getRangeQuery(String f, String rangoInf, String rangoSup)
	{
		RangeQuery rangeQuery = new RangeQuery(new Term(f,rangoInf),
				new Term(f,rangoSup),
				true);//queremos que sea inclusivo
		return rangeQuery;
	}
//	Obtiene wildcard query
	private Query getWildcardQuery(String f, String t) {
		return new WildcardQuery(new Term(f, t));
	}
	
//	Obtiene range query. Se supone que el rango inferior y superior afectan al mismo campo (f)
	private Query getConstantScoreRangeQuery(String f, String rangoInf, String rangoSup)
	{
		ConstantScoreRangeQuery rangeQuery = new ConstantScoreRangeQuery(f,
				rangoInf,
				rangoSup,
				true, //somos inclusivos con el rango inferior
				true); //somos inclusivos con el rango superior
		return rangeQuery;
	}
	
	private List devolverFrases(String palabrasClave, String idioma) {
		List retorno = new ArrayList();
		String[] stopWords = new String[0];
		try{
			stopWords = props.getProperty("stopWords." + idioma).trim().split(SEPARADOR_STOP_WORDS);
		}catch(Exception ex){
			logger.error("SrvBuscarServiceImpl - devolverFrases ERROR: No existe StopWords para idioma="+idioma, ex);
		}
		while(contains(palabrasClave,SEPARADOR_PHRASE) && contains(palabrasClave.substring(palabrasClave.indexOf(SEPARADOR_PHRASE)+1), SEPARADOR_PHRASE)){
			List palabraPhrase = new ArrayList();
			int indiceFinalFrase = palabrasClave.substring(palabrasClave.indexOf(SEPARADOR_PHRASE)+1).indexOf(SEPARADOR_PHRASE)+palabrasClave.indexOf(SEPARADOR_PHRASE)+2;
			String[] words = palabrasClave.substring(palabrasClave.indexOf(SEPARADOR_PHRASE)+1,indiceFinalFrase-1).trim().split(SEPARADOR_PALABRAS);
			for (int i = 0; i < words.length; i++) {
				if(!words[i].toString().trim().equals("") && !stopWord(words[i].trim(), stopWords)) palabraPhrase.add(words[i].trim());
			}
			if(palabraPhrase.size() > 1) {
				palabrasClave = palabrasClave.substring(0 , palabrasClave.indexOf(SEPARADOR_PHRASE)).trim() + SEPARADOR_PALABRAS + palabrasClave.substring(indiceFinalFrase).trim();
				retorno.add(palabraPhrase);
			}else palabrasClave = palabrasClave.substring(0 , palabrasClave.indexOf(SEPARADOR_PHRASE)).trim() + SEPARADOR_PALABRAS + words[0] + SEPARADOR_PALABRAS + palabrasClave.substring(indiceFinalFrase).trim();
		}
		Object[] palabras = (palabrasClave!=null && !palabrasClave.trim().equals(""))?palabrasClave.trim().replaceAll(SEPARADOR_PHRASE, SEPARADOR_PALABRAS).split(SEPARADOR_PALABRAS):new Object[0];
		for (int i = 0; i < palabras.length; i++) if(!palabras[i].toString().trim().equals("")) retorno.add(palabras[i].toString());
		return retorno;
	}
	
	private List devolverAnds(List palabrasClave) {
		List retorno = new ArrayList(), tempAnds = new ArrayList(), tempWords = new ArrayList();
		while(palabrasClave.size()>0){
			if(palabrasClave.size()>1 && palabrasClave.get(1).equals("+")){
				List tempAnd = new ArrayList();
				if(tempAnd==null || tempAnd.size()==0){
					tempAnd.add(palabrasClave.get(0));
					tempAnd.add(palabrasClave.get(2));
					for(int j = 0; j < 3; j++)palabrasClave.remove(0);
				}
				while(palabrasClave.size()>0 && palabrasClave.get(0).equals("+")){
					tempAnd.add(palabrasClave.get(1));
					for(int j = 0; j < 2; j++)palabrasClave.remove(0);
				}
				if(tempAnd!=null || tempAnd.size()>0) tempAnds.add(tempAnd);
			}else if(palabrasClave.size()==1 || !palabrasClave.get(1).equals("+")){
				tempWords.add(palabrasClave.get(0));
				palabrasClave.remove(0);
			}
		}
		retorno.add(tempAnds);
		retorno.add(tempWords);
		return retorno;
	}
	
//	Concede o no acceso de tipo wildcard al indice en funci n de configuracion (simple/avanzada)
	private boolean stopWord(String campo, String[] stopWords) {
		for(int i = 0 ; i < stopWords.length ; i++) if(stopWords[i].equals(campo)) return true;
		return false;
	}	
	
	private Hits internaBusquedaAvanzada(es.pode.indexador.negocio.servicios.busqueda.ParamAvanzadoVO paramBusq,
			DisjunctionMaxQuery query)  throws Exception
	{
		Directory directorioIndiceSimple = null;
		IndexSearcher searcher = null;
		Hits hits = null;
//		Utilizamos el idioma seleccionado en la busqueda para buscar el indice sobre el que se ejecuta la query.
		try{
//		Utilizamos el idioma seleccionado en la busqueda para buscar el indice sobre el que se ejecuta la query.
			directorioIndiceSimple = this.getIndexByLanguage(paramBusq.getIdiomaBusqueda());
			searcher = new IndexSearcher(directorioIndiceSimple);
			BooleanQuery andQuery = new BooleanQuery();
	//		Las palabras clave (texto libre que se pone en la cabecera de la pantalla de busqueda) sirve para buscar
	//		sobre los campos titulo, descripcion y keywords
	//		Configuramos el valor de memoria.		
			andQuery.setMaxClauseCount(Integer.parseInt(props.getProperty("maxClauseCount")));
	//		Separamos las posibles frases de las palabras sueltas
			if(paramBusq.getPalabrasClave() != null && !paramBusq.getPalabrasClave().trim().equals("")){
				List palabras = devolverFrases(paramBusq.getPalabrasClave().trim(), paramBusq.getIdiomaBusqueda());
				List ands = devolverAnds(palabras);
				String[] claves = props.getProperty(CAMPOS_CLAVE_AVANZADA).split(SEPARADOR_CLAVES);
				if(ands!=null){
					BooleanQuery andQueryClavePrincipal = new BooleanQuery();
					andQueryClavePrincipal.setMaxClauseCount(Integer.parseInt(props.getProperty("maxClauseCount")));
					List andsList = (List) ands.get(0);
					List orList = (List) ands.get(1);

                                        // Two lists ... one with words with a + before andList
                                        //               second one with rest of tokens (common words)   orList
					BooleanQuery andQueryClave = new BooleanQuery();
					andQueryClave.setMaxClauseCount(Integer.parseInt(props.getProperty("maxClauseCount")));
					for(int k = 0; k < claves.length; k++) {
						for (int j = 0; j < andsList.size(); j++){
							BooleanQuery andQueryClaveInterna = new BooleanQuery();
							andQueryClaveInterna.setMaxClauseCount(Integer.parseInt(props.getProperty("maxClauseCount")));
							for (int i = 0; i < ((List)andsList.get(j)).size(); i++){
								andQueryClaveInterna.add(
										(List.class.isInstance(
										((List) andsList.get(j)).get(i))) ?
											getQuery(
											((List) andsList.get(j)).get(i),
											claves[k], CAMPOS_PHRASE_AVANZADA) :
											getQuery(
											((List) andsList.get(j)).get(i).
											toString(),
											claves[k],
											CAMPOS_WILDCARD_AVANZADA),
											BooleanClause.Occur.MUST);
							}
							andQueryClave.add(andQueryClaveInterna,BooleanClause.Occur.MUST);
						}
					} //until here it treats words in the query with + before
                                        // and now is the treatment for orList
					for (int j = 0; j < orList.size(); j++){
						BooleanQuery andQueryClaveInterna = new BooleanQuery();
						andQueryClaveInterna.setMaxClauseCount(Integer.parseInt(props.getProperty("maxClauseCount")));
						for(int k = 0; k < claves.length; k++) {
							//andQueryClaveInterna.add((List.class.isInstance(orList.get(j)))?getQuery(orList.get(j),claves[k],CAMPOS_PHRASE_AVANZADA):getQuery(orList.get(j).toString(),claves[k],CAMPOS_WILDCARD_AVANZADA),BooleanClause.Occur.SHOULD);

        Query q1 = null;
        if (List.class.isInstance(orList.get(j))) {
            logger.debug("* CAMPOS_PHRASE_AVANZADA   j=" + j + "  orList.get(j))=" + orList.get(j));
            q1 = getQuery(orList.get(j),claves[k],CAMPOS_PHRASE_AVANZADA);
        } else {
            logger.debug("* CAMPOS_WILDCARD_AVANZADA j=" + j + "  orList.get(j))=" + orList.get(j));
            q1 = getQuery(orList.get(j).toString(), claves[k], CAMPOS_WILDCARD_AVANZADA);
        }

        andQueryClaveInterna.add(q1,BooleanClause.Occur.SHOULD);


						}
						andQueryClave.add(andQueryClaveInterna,BooleanClause.Occur.MUST);//original MUST
					}
					// Add the filter TermQueries as clauses
					addFiltersToQuery(paramBusq.getSearchFilters(),
								andQueryClave);

					andQuery.add(andQueryClave,BooleanClause.Occur.MUST);
					query.add(andQuery);
				}
			}
	//		Ahora recorremos todos los parametros de la busqueda avanzada, introduciendo los valores de busqueda
	//		en la query de aquellos campos que esten presentes en los parametros de la consulta.
			PropertyDescriptor[] beanPDs = Introspector.getBeanInfo(paramBusq.getClass()).getPropertyDescriptors();
			for (int j = 0; j < beanPDs.length; j++) {
				if(props.getProperty(PREFIJO_CAMPO+beanPDs[j].getName())!=null && (getAndOrAccess(beanPDs[j].getName(),true) || getAndOrAccess(beanPDs[j].getName(),false))){
					if(beanPDs[j].getReadMethod().invoke(paramBusq,new Object[0])!=null && !beanPDs[j].getReadMethod().invoke(paramBusq, new Object[0]).toString().trim().equals("")){
	//					Comprobar analyse para no tener un tratamiento especial para formato
						
						List palabras = new ArrayList();
						if(getRangeQueryAccess(props.getProperty(CAMPOS_RANGE_AVANZADA).split(SEPARADOR_CLAVES),PREFIJO_CAMPO+beanPDs[j].getName()) || esTextoLibre(props.getProperty(CAMPOS_TEXTO_LIBRE).split(SEPARADOR_CLAVES),PREFIJO_CAMPO+beanPDs[j].getName())) palabras = devolverFrases(beanPDs[j].getReadMethod().invoke(paramBusq, new Object[0]).toString().trim(), paramBusq.getIdiomaBusqueda());
						else palabras.add(beanPDs[j].getReadMethod().invoke(paramBusq, new Object[0]).toString().trim());
						if(getRangeQueryAccess(props.getProperty(CAMPOS_RANGE_AVANZADA).split(SEPARADOR_CLAVES),PREFIJO_CAMPO+beanPDs[j].getName())) andQuery.add(getRangeQuery(props.getProperty(PREFIJO_CAMPO+beanPDs[j].getName()), palabras.get(0).toString(), palabras.get(1).toString()), BooleanClause.Occur.MUST);
						else{
							List ands = devolverAnds(palabras);
							List andsList = (List) ands.get(0);
							List orList = (List) ands.get(1);
							BooleanQuery andQueryClave = new BooleanQuery();
							andQueryClave.setMaxClauseCount(Integer.parseInt(props.getProperty("maxClauseCount")));
							for (int k = 0; k < andsList.size(); k++){
								BooleanQuery andQueryClaveInterna = new BooleanQuery();
								andQueryClaveInterna.setMaxClauseCount(Integer.parseInt(props.getProperty("maxClauseCount")));
								for (int i = 0; i < ((List)andsList.get(k)).size(); i++){
									andQueryClaveInterna.add((List.class.isInstance(((List)andsList.get(k)).get(i)))?getQuery(((List)andsList.get(k)).get(i),PREFIJO_CAMPO+beanPDs[j].getName(),CAMPOS_PHRASE_AVANZADA):getQuery(((List)andsList.get(k)).get(i).toString(),PREFIJO_CAMPO+beanPDs[j].getName(),CAMPOS_WILDCARD_AVANZADA),BooleanClause.Occur.MUST);
								}
								andQueryClave.add(andQueryClaveInterna,BooleanClause.Occur.SHOULD);
							}
							for (int k = 0; k < orList.size(); k++){
								andQueryClave.add((List.class.isInstance(orList.get(k)))?getQuery(orList.get(k),PREFIJO_CAMPO+beanPDs[j].getName(),CAMPOS_PHRASE_AVANZADA):getQuery(orList.get(k).toString(),PREFIJO_CAMPO+beanPDs[j].getName(),CAMPOS_WILDCARD_AVANZADA),BooleanClause.Occur.SHOULD);
							}
							if(getAndOrAccess(beanPDs[j].getName(),true)) andQuery.add(andQueryClave, BooleanClause.Occur.MUST);
							else if(getAndOrAccess(beanPDs[j].getName(),false)) andQuery.add(andQueryClave, BooleanClause.Occur.SHOULD);
						}
					}
				}
			}
			if (logger.isDebugEnabled()) logger.debug("Consulta interna simple con query["+query.toString()+"]");
			hits = searcher.search(andQuery, Sort.RELEVANCE);
                        //hits = searcher.search(andQuery, new Sort("fechaPublicacion"));


        Iterator it = hits.iterator();
        int i = 1;
        logger.debug("* Lucene results");
        while (it.hasNext()) {
            org.apache.lucene.search.Hit hit = (org.apache.lucene.search.Hit) it.next();
            logger.debug("* FechaPublicacion="+hit.get("fechaPublicacion")+ " Id="+hit.getId()+" S="+hit.getScore()+ "->" +hit.get("title"));i++;
        }
        logger.debug("* "+ (i!=0?i-1:i) + " results");

					//(paramBusq.getBusquedaSimpleAvanzada()!=null && paramBusq.getBusquedaSimpleAvanzada().equals(BUSCARRSS))?new Sort(new SortField(props.getProperty("campo_fechaPublicacion"),SortField.STRING,true)):new Sort(new SortField(props.getProperty("campo_nivelAgregacion"),SortField.STRING,true)));
		}catch(java.lang.Exception e){
            logger.error("Search failed", e);
			if(directorioIndiceSimple==null || searcher == null)logger.error("SrvBuscarServiceImpl - internaBusquedaAvanzada ERROR: No existe  ndice para el idioma = "+paramBusq.getIdiomaBusqueda());
			else{
				Exception exc = new Exception("SrvBuscarServiceImpl - internaBusquedaAvanzada ERROR: Con query="+paramBusq.getPalabrasClave()+" e idioma="+paramBusq.getIdiomaBusqueda(), e);
    			logger.error(exc);
    			throw exc;
			}
		}
		return hits;
	}

	private void addFiltersToQuery(java.util.HashMap filters, BooleanQuery q)
			throws IOException {

		// Search filters are "nillable" in the WS contract
		if (filters == null)
			return;

		// Add filter terms corresponding to each key in the map
		for (Object k : filters.keySet()) {
			if (k instanceof String) {

                                if(k.equals("campo_formato")) {

                                    BooleanQuery queryFormato = new BooleanQuery();
                                    queryFormato.setMaxClauseCount(Integer.parseInt(props.getProperty("maxClauseCount")));

                                    Analyzer analyser = new StandardAnalyzer();
                                    /// We could change here the analyzer
                                    //Analyzer analyser = new WhitespaceAnalyzer();
                                    
                                    TokenStream stream = analyser.tokenStream(
                                                    (String)k, new StringReader(filters.get(k).toString()));


                                    while (true) {
                                            Token tok = stream.next();
                                            if (tok == null)
                                                    break; // No more tokens for this filter field

                                            queryFormato.add(new TermQuery(new Term(props.getProperty((String) k),
                                                            tok.termText())),
                                                            BooleanClause.Occur.SHOULD);
                                    }

                                    q.add(queryFormato,BooleanClause.Occur.MUST);

                                } else {

				// Each of these filtering fields is tokenised because it is
				// made available for arbitrary search with "contains" behavior.
				//
				// Use the default analyser to tokenise the search filter field
				// values before adding them as query sub-clauses.
				//
				// Note that if you ever need to add a filter corresponding to
				// an non-analysed field DO NOT tokenise it.

                                Analyzer analyser = new StandardAnalyzer();
                                /// We could change here the analyzer
                                //Analyzer analyser = new WhitespaceAnalyzer();

				// Invoke toString() instead of checking and casting.
				// This would allow other Object types as values.

				TokenStream stream = analyser.tokenStream(
						(String)k, new StringReader(filters.get(k).toString()));

				// Unfortunately, stream does not support an iterator interface
				// so we will need to break out of an unbounded loop when done.
				
				while (true) {
					Token tok = stream.next();
					if (tok == null)
						break; // No more tokens for this filter field

					// A key represents a name for an indexed field; the value
					// for which is in the properties configuration.

					q.add(new TermQuery(new Term(props.getProperty((String) k),
							tok.termText())),
                                                        BooleanClause.Occur.MUST);
				}
                            }//k.equals("campo_formato")
			}


		}
	}
	
	private String eliminarCaracteresIncompatibles(String cadena,String[] caracteresIncompatibles){
		for (int i = 0; i < caracteresIncompatibles.length; i++) cadena = cadena.replaceAll(caracteresIncompatibles[i], SEPARADOR_PALABRAS);
		return SEPARADOR_PHRASE + cadena + SEPARADOR_PHRASE;
	}

	private Object[] internaBusquedaQuery (es.pode.indexador.negocio.servicios.busqueda.ParamAvanzadoVO paramBusq,String palabrasClave, DisjunctionMaxQuery query, boolean buscarTodosIndices, IndiceVO[] idiomas) throws Exception{
		Object hits[] = null;
		Directory directorioIndiceSimple = null;
		if(buscarTodosIndices){
			hits = new Object[idiomas.length];
			for(int i = 0; i < idiomas.length; i++){
				try{
					directorioIndiceSimple = this.getIndexByLanguage(idiomas[i].getIdentificador());
					IndexSearcher searcher = new IndexSearcher(directorioIndiceSimple);
					Hits asdf = searcher.search(prepararBusqueda(palabrasClave, query));
					hits[i] = asdf;
				}catch(java.lang.Exception e){
					if(directorioIndiceSimple==null)logger.error("SrvBuscarServiceImpl - internaBusquedaQuery ERROR: No existe  ndice para el idioma = "+idiomas[i].getIdentificador());
					else logger.error("SrvBuscarServiceImpl - internaBusquedaQuery ERROR: Indice corrupto con query="+paramBusq.getPalabrasClave()+" para el idioma="+idiomas[i].getIdentificador(), e);
				}
			}
		}else{
			try{
				hits = new Object[1];
				directorioIndiceSimple = this.getIndexByLanguage(paramBusq.getIdiomaBusqueda());
				IndexSearcher searcher = new IndexSearcher(directorioIndiceSimple);
				hits[0] = searcher.search(prepararBusqueda (palabrasClave, query));
			}catch(java.lang.Exception e){
				if(directorioIndiceSimple==null)logger.error("SrvBuscarServiceImpl - internaBusquedaQuery ERROR: No existe  ndice para el idioma = "+paramBusq.getIdiomaBusqueda());
				else{
					Exception exc = new Exception("SrvBuscarServiceImpl - internaBusquedaQuery ERROR: Con query="+paramBusq.getPalabrasClave()+" e idioma="+paramBusq.getIdiomaBusqueda(), e);
	    			logger.error(exc);
	    			throw exc;
				}
			}
		}
		return hits;
	}
	
	private Query prepararBusqueda (String palabrasClave, DisjunctionMaxQuery query) throws Exception{
		String[] arrayCamposParametro = new String[] {
			props.getProperty("campo_autor"),
			props.getProperty("campo_ambito"),
			props.getProperty("campo_descripcion"),
			props.getProperty("campo_edad"),
			props.getProperty("campo_fechaPublicacion"),
			props.getProperty("campo_formato"),
			props.getProperty("campo_idiomaBusqueda"),
			props.getProperty("campo_nivelEducativo"),
			props.getProperty("campo_palabrasClave"),
			props.getProperty("campo_recurso"),
			props.getProperty("campo_secuencia"),
			props.getProperty("campo_titulo"),
			props.getProperty("campo_valoracion"),
			props.getProperty("campo_areaCurricular"),
			props.getProperty("campo_areaCurricular_path"),
			props.getProperty("campo_areaCurricular_nodo"),
			props.getProperty("campo_localizador"),
			props.getProperty("campo_curso"),
			props.getProperty("campo_destinatarios"),
			props.getProperty("campo_licencias"),
			props.getProperty("campo_identificadorODE"),
			props.getProperty("campo_nivelAgregacion"),
			props.getProperty("campo_imagen"),
			props.getProperty("campo_conditionsOfUse"),
			props.getProperty("campo_relationKind"),
			props.getProperty("campo_relatedResourceTitle"),
			props.getProperty("campo_autor"),
			props.getProperty("campo_contentProvider"),
			props.getProperty("campo_taxonPath"),
			props.getProperty("campo_typicalLearningTime"),
			props.getProperty("campo_relatedResourceIdentifier"),
			props.getProperty("campo_publicador"),
			props.getProperty("campo_authorOrganisation"),
			props.getProperty("campo_annotation")
        };

		org.apache.lucene.search.BooleanClause.Occur[] requeridos =
			new org.apache.lucene.search.BooleanClause.Occur[arrayCamposParametro.length];

		for (int i = 0; i < arrayCamposParametro.length; i++) {
			requeridos[i] = org.apache.lucene.search.BooleanClause.Occur.SHOULD;
		}

		Query lqsQuery = MultiFieldQueryParser.parse(palabrasClave,
			arrayCamposParametro, requeridos, new KeywordAnalyzer());
		query.add(lqsQuery);
		return query;
	}

	private Hits internaBusquedaMEC(
			String mec,
			String idioma,
			DisjunctionMaxQuery query) throws Exception {
		Directory directorioIndiceSimple = this.getIndexByLanguage(idioma);
		IndexSearcher searcher = new IndexSearcher(directorioIndiceSimple);
		searcher.setSimilarity(new DefaultSimilarity());
		query.add(getTermQuery(props.getProperty("campo_identificadorODE"), mec));
		if (logger.isDebugEnabled())
			logger.debug("Consulta MEC con query["+query.toString()+"]");
		Hits hits = searcher.search(query);
		return hits;
	}

	private String paramBusqAvanz2String(es.pode.indexador.negocio.servicios.busqueda.ParamAvanzadoVO paramBusq)
	{
		String tira = "";
		tira+= 
		" ArbolCurricularVigente["+paramBusq.getArbolCurricularVigente()+"]"+
		" AreaCurricular["+paramBusq.getAreaCurricular()+"]"+
		" Autor["+paramBusq.getAutor()+"]"+
		" Comunidades["+paramBusq.getAmbito()+"]"+
		" Contexto["+paramBusq.getContexto()+"]"+
		" Descripcion["+paramBusq.getDescripcion()+"]"+
		" Edad["+paramBusq.getEdad()+"]"+
		" FechaPublicacion["+paramBusq.getFechaPublicacion()+"]"+
		" FechaPublicacionRango["+paramBusq.getFechaPublicacionRango()+"]"+
		" Formato["+paramBusq.getFormato()+"]"+
		" IdentificadorODE["+paramBusq.getIdentificadorODE()+"]"+
		" Idioma["+paramBusq.getIdiomaBusqueda()+"]"+
		" IdiomaNavegacion["+paramBusq.getIdiomaNavegacion()+"]"+
		" IdTesauro["+paramBusq.getIdTesauro()+"]"+
		" NivelAgregacion["+paramBusq.getNivelAgregacion()+"]"+
		" NumeroResultados["+paramBusq.getNumeroResultados()+"]"+
		" PalabrasClave["+paramBusq.getPalabrasClave()+"]"+
		" ProcesoCognitivo["+paramBusq.getProcesoCognitivo()+"]"+
		" Recurso["+paramBusq.getRecurso()+"]"+
		" Secuencia["+paramBusq.getSecuencia()+"]"+
		" Titulo["+paramBusq.getTitulo()+"]"+
		" Valoracion["+paramBusq.getValoracion()+"]";
		return tira;

	}
	
	private DocVO[] getArrayDocsFromHits(Hits hits, int numeroResultados) throws Exception{
		if (hits!= null)
		{ 
			long start = System.currentTimeMillis();
			for (int i = 0; i < numeroResultados; i++) {
				resultados[i] = this.getVOFromLucene(hits.doc(i),resultados[i], Float.floatToIntBits(hits.score(i)));
			}
			long end = System.currentTimeMillis();
			logger.debug("SrvBuscadorServiceImpl - handleBusquedaAvanzada : Mapeo local interno realizado en =" + (end - start)+ " milisegundos.");
			DocVO[] retorno = new DocVO[numeroResultados];
			for (int i = 0; i < numeroResultados; i++)retorno[i]=resultados[i];
			return retorno;
		}
		return null;
	}
	
	private DocVO getVOFromLucene(Document doc) throws Exception
	{
		DocVO hitToDoc = new DocVO();
		try{
			//hitToDoc.setLocalizadorODE(doc.get(props.getProperty("campo_localizador")));
			hitToDoc.setSize((doc.get(props.getProperty("campo_size"))!=null)?doc.get(props.getProperty("campo_size")):"");
			hitToDoc.setAnnotation((doc.get(props.getProperty("campo_annotation"))!=null)?doc.get(props.getProperty("campo_annotation")):"");
            hitToDoc.setTypicalLearningTime((doc.get(props.getProperty("campo_typicalLearningTime"))!=null)?doc.get(props.getProperty("campo_typicalLearningTime")):"");
			hitToDoc.setDescripcion((doc.get(props.getProperty("campo_descripcion"))!=null)?doc.get(props.getProperty("campo_descripcion")):"");
			hitToDoc.setTitulo((doc.get(props.getProperty("campo_titulo"))!=null)?doc.get(props.getProperty("campo_titulo")):"");
			String sValuesAmbito[] = doc.getValues(props.getProperty("campo_ambito"));
			hitToDoc.setAmbito((sValuesAmbito!=null)?sValuesAmbito:new String[0]);
			String sAreaCurricular[] = doc.getValues(props.getProperty("campo_areaCurricular_path"));
			hitToDoc.setAreaCurricular((sAreaCurricular!=null)?sAreaCurricular:new String[0]);
			hitToDoc.setCurso((doc.get(props.getProperty("campo_curso"))==null)?"":doc.get(props.getProperty("campo_curso")));
			
			String sValuesDest[] = doc.getValues(props.getProperty("campo_destinatarios"));
			hitToDoc.setDestinatarios((sValuesDest!=null)?sValuesDest:new String[0]);
			String sCProviders[] = doc.getValues(props.getProperty("campo_contentProvider"));
			hitToDoc.setContentProviders((sCProviders!=null)?sCProviders:new String[0]);
			String sAuthors[] = doc.getValues(props.getProperty("campo_autor"));
			hitToDoc.setAuthors((sAuthors!=null)?sAuthors:new String[0]);
			hitToDoc.setFormato((doc.getValues(props.getProperty("campo_formato"))!=null)?doc.getValues(props.getProperty("campo_formato")):new String[0]);
			
			hitToDoc.setArbolCurricularVigente((doc.get(props.getProperty("campo_arbolCurricularVigente"))!=null)?doc.get(props.getProperty("campo_arbolCurricularVigente")):"");
			
			String sValueIdioma = doc.get(props.getProperty("campo_idiomaBusqueda"));
			hitToDoc.setIdioma((sValueIdioma!=null)?sValueIdioma:"");
			String sValuesLicencias[] = doc.getValues(props.getProperty("campo_licencias"));
			hitToDoc.setLicencias((sValuesLicencias!=null)?sValuesLicencias:new String[0]);
			if (logger.isDebugEnabled() && sValuesLicencias != null)
					logger.debug("Hit con ["+sValuesLicencias.length+"]valores de licencias.");
			
			String sValuesRecurso[] = doc.getValues(props.getProperty("campo_recurso"));
			hitToDoc.setTipoRecurso((sValuesRecurso!=null)?sValuesRecurso:new String[0]);
			hitToDoc.setValoracion((doc.get(props.getProperty("campo_valoracion"))!=null)?new Float(doc.get(props.getProperty("campo_valoracion"))):new Float(0));
			
			hitToDoc.setNivelAgregacion((doc.get(props.getProperty("campo_nivelAgregacion"))!=null)?new Integer(doc.get(props.getProperty("campo_nivelAgregacion"))):new Integer(0));
			hitToDoc.setFechaPublicacion(doc.get(props.getProperty("campo_fechaPublicacion")));
			hitToDoc.setHoraPublicacion(doc.get(props.getProperty("campo_horaPublicacion")));
			hitToDoc.setIdentificadorODE(doc.get(props.getProperty("campo_identificadorODE")));
			hitToDoc.setImagen((doc.get(props.getProperty("campo_imagen"))!=null)?doc.get(props.getProperty("campo_imagen")):"");
			hitToDoc.setTamanio((doc.get(props.getProperty("campo_tamanio"))!=null)?doc.get(props.getProperty("campo_tamanio")):"");
			hitToDoc.setConSinSecuencia((doc.get(props.getProperty("campo_secuencia"))!=null)?new Boolean(doc.get(props.getProperty("campo_secuencia"))):new Boolean(false));
			
			String sValuesTesauro[] = doc.getValues(props.getProperty("campo_idTesauro"));
			hitToDoc.setTesauros((sValuesTesauro!=null)?sValuesTesauro:new String[0]);
			if (logger.isDebugEnabled() && sValuesTesauro != null)
					logger.debug("Hit con ["+sValuesTesauro.length+"]valores de tipoTesauro.");
		}
		catch (Exception ex){
			logger.error(ex);
			throw ex;
		}
		return hitToDoc;
	}
	
	private DocVO getVOFromLucene(Document doc, DocVO hitToDoc, int ranking) throws Exception
	{
		try{
			hitToDoc.setRanking(new Integer(ranking));
			hitToDoc.setLocalizadorODE(doc.get(props.getProperty("campo_localizador")));
			hitToDoc.setSize((doc.get(props.getProperty("campo_size"))!=null)?doc.get(props.getProperty("campo_size")):"");
			hitToDoc.setAnnotation((doc.get(props.getProperty("campo_annotation"))!=null)?doc.get(props.getProperty("campo_annotation")):"");
            hitToDoc.setTypicalLearningTime((doc.get(props.getProperty("campo_typicalLearningTime"))!=null)?doc.get(props.getProperty("campo_typicalLearningTime")):"");
			hitToDoc.setDescripcion((doc.get(props.getProperty("campo_descripcion"))!=null)?doc.get(props.getProperty("campo_descripcion")):"");
			hitToDoc.setTitulo((doc.get(props.getProperty("campo_titulo"))!=null)?doc.get(props.getProperty("campo_titulo")):"");
			String sValuesAmbito[] = doc.getValues(props.getProperty("campo_ambito"));
			hitToDoc.setAmbito((sValuesAmbito!=null)?sValuesAmbito:new String[0]);
			String sAreaCurricular[] = doc.getValues(props.getProperty("campo_areaCurricular_path"));
			hitToDoc.setAreaCurricular((sAreaCurricular!=null)?sAreaCurricular:new String[0]);
			//hitToDoc.setCurso((doc.get(props.getProperty("campo_curso"))==null)?"":doc.get(props.getProperty("campo_curso")));
			
			String sValuesDest[] = doc.getValues(props.getProperty("campo_destinatarios"));
			//hitToDoc.setDestinatarios((sValuesDest!=null)?sValuesDest:new String[0]);
			String sCProviders[] = doc.getValues(props.getProperty("campo_contentProvider"));
			hitToDoc.setContentProviders((sCProviders!=null)?sCProviders:new String[0]);
			String sAuthors[] = doc.getValues(props.getProperty("campo_autor"));
			hitToDoc.setAuthors((sAuthors!=null)?sAuthors:new String[0]);
			hitToDoc.setFormato((doc.getValues(props.getProperty("campo_formato"))!=null)?doc.getValues(props.getProperty("campo_formato")):new String[0]);
			
			hitToDoc.setArbolCurricularVigente((doc.get(props.getProperty("campo_arbolCurricularVigente"))!=null)?doc.get(props.getProperty("campo_arbolCurricularVigente")):"");
			
			String sValueIdioma = doc.get(props.getProperty("campo_idiomaBusqueda"));
			hitToDoc.setIdioma((sValueIdioma!=null)?sValueIdioma:"");
			//String sValuesLicencias[] = doc.getValues(props.getProperty("campo_licencias"));
			//hitToDoc.setLicencias((sValuesLicencias!=null)?sValuesLicencias:new String[0]);
			//if (logger.isDebugEnabled() && sValuesLicencias != null)
			//		logger.debug("Hit con ["+sValuesLicencias.length+"]valores de licencias.");
			
			String sValuesRecurso[] = doc.getValues(props.getProperty("campo_recurso"));
			hitToDoc.setTipoRecurso((sValuesRecurso!=null)?sValuesRecurso:new String[0]);
			hitToDoc.setValoracion((doc.get(props.getProperty("campo_valoracion"))!=null)?new Float(doc.get(props.getProperty("campo_valoracion"))):new Float(0));
			
			hitToDoc.setNivelAgregacion((doc.get(props.getProperty("campo_nivelAgregacion"))!=null)?new Integer(doc.get(props.getProperty("campo_nivelAgregacion"))):new Integer(0));
			hitToDoc.setFechaPublicacion(doc.get(props.getProperty("campo_fechaPublicacion")));
			hitToDoc.setHoraPublicacion(doc.get(props.getProperty("campo_horaPublicacion")));
			hitToDoc.setIdentificadorODE(doc.get(props.getProperty("campo_identificadorODE")));
			hitToDoc.setImagen((doc.get(props.getProperty("campo_imagen"))!=null)?doc.get(props.getProperty("campo_imagen")):"");
                        hitToDoc.setTamanio((doc.get(props.getProperty("campo_tamanio"))!=null)?doc.get(props.getProperty("campo_tamanio")):"");
			//hitToDoc.setConSinSecuencia((doc.get(props.getProperty("campo_secuencia"))!=null)?new Boolean(doc.get(props.getProperty("campo_valoracion"))):new Boolean(false));
			
			//String sValuesTesauro[] = doc.getValues(props.getProperty("campo_idTesauro"));
			//hitToDoc.setTesauros((sValuesTesauro!=null)?sValuesTesauro:new String[0]);
			//if (logger.isDebugEnabled() && sValuesTesauro != null)
				//	logger.debug("Hit con ["+sValuesTesauro.length+"]valores de tipoTesauro.");
		}
		catch (Exception ex){
			logger.error(ex);
			throw ex;
		}
		return hitToDoc;
	}
	
	private ResultadoHeaderVO[] mapDocToHeader(Hits documentos) throws Exception
	{
		ResultadoHeaderVO[] resultados = new ResultadoHeaderVO[documentos.length()];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		for (int i = 0; i < documentos.length(); i++) {
			
			resultados[i] = new ResultadoHeaderVO();
			resultados[i].setFecha(DateManager.dateToCalendar(sdf.parse(documentos.doc(i).get(props.getProperty("campo_fechaPublicacion")))));
			resultados[i].setIdentificador(documentos.doc(i).get(props.getProperty("campo_identificadorODE")));
		}
		return resultados;
	}
	
	private ResultadoRecordVO[] mapDocToRecord(Hits documentos) throws Exception
	{
		ResultadoRecordVO[] resultados = new ResultadoRecordVO[documentos.length()];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		for (int i = 0; i < documentos.length(); i++) {
			
			resultados[i] = new ResultadoRecordVO();
//			ALCANCE
			String sAmbito[] = documentos.doc(i).getValues(props.getProperty("campo_alcance"));
			resultados[i].setAmbito((sAmbito!=null)?sAmbito:new String[0]);
//			AUTOR
			String sAutores[] = documentos.doc(i).getValues(props.getProperty("campo_autor"));
			resultados[i].setAutores((sAutores!=null)?sAutores:new String[0]);
//			CONTRIBUIDOR
			String sContribuidor[] = documentos.doc(i).getValues(props.getProperty("campo_contribuidor"));
			resultados[i].setContribuidor((sContribuidor!=null)?sContribuidor:new String[0]);
//			LICENCIAS
			String sDerechos[] = documentos.doc(i).getValues(props.getProperty("campo_licencias"));
			resultados[i].setDerechos((sDerechos!=null)?sDerechos:new String[0]);
//			DESCRIPCION
			resultados[i].setDescripcion((documentos.doc(i).get(props.getProperty("campo_descripcion"))!=null)?
											documentos.doc(i).get(props.getProperty("campo_descripcion")):"");
//			FECHA PUBLICACION
			resultados[i].setFecha((documentos.doc(i).get(props.getProperty("campo_fechaPublicacion"))!=null)?
										documentos.doc(i).get(props.getProperty("campo_fechaPublicacion")):"");
//			FORMATO
			String sFormato[] = documentos.doc(i).getValues(props.getProperty("campo_formato"));
			resultados[i].setFormatos((sFormato!=null)?sFormato:new String[0]);
//			FUENTE
			String sFuente[] = documentos.doc(i).getValues(props.getProperty("campo_fuente"));
			resultados[i].setFuente((sFuente!=null)?sFuente:new String[0]);
//			IDENTIFICADOR
			resultados[i].setIdentificador(documentos.doc(i).get(props.getProperty("campo_identificadorODE")));
//			IDIOMA
			resultados[i].setIdioma(documentos.doc(i).get(props.getProperty("campo_idiomaBusqueda")));
//			PUBLICADOR
			String sPublicador[] = documentos.doc(i).getValues(props.getProperty("campo_publicador"));
			resultados[i].setPublicador((sPublicador!=null)?sPublicador:new String[0]);
//			RELACION
			String sRelacion[] = documentos.doc(i).getValues(props.getProperty("campo_relacion"));
			resultados[i].setRelacion((sRelacion!=null)?sRelacion:new String[0]);
//			PALABAS CLAVE
			String sTema[] = documentos.doc(i).getValues(props.getProperty("campo_palabrasClave"));
			resultados[i].setTema((sTema!=null)?sTema:new String[0]);
//			RECURSO
			String sTipo[] = documentos.doc(i).getValues(props.getProperty("campo_recurso"));
			resultados[i].setTipo((sTipo!=null)?sTipo:new String[0]);
//			TITULO
			resultados[i].setTitulo(documentos.doc(i).get(props.getProperty("campo_titulo")));
		}
		return resultados;
	}
	
	private ResultadoRepositorioVO[] mapDocToRepositorio(Hits documentos) throws Exception
	{
		ResultadoRepositorioVO[] resultados = new ResultadoRepositorioVO[documentos.length()];
		for (int i = 0; i < documentos.length(); i++) {
			
			resultados[i] = new ResultadoRepositorioVO();
//			FECHA PUBLICACION
			resultados[i].setFechaPublicacion(((documentos.doc(i).get(props.getProperty("campo_fechaPublicacion"))!=null)?
										documentos.doc(i).get(props.getProperty("campo_fechaPublicacion")):""));
//			IDENTIFICADOR
//			resultados[i].setIdentificador(documentos.doc(i).get(props.getProperty("campo_identificadorODE")));
			resultados[i].setIdentificador(((documentos.doc(i).get(props.getProperty("campo_identificadorODE"))!=null)?
					documentos.doc(i).get(props.getProperty("campo_identificadorODE")):""));
//			IDIOMA
//			resultados[i].setIdioma(documentos.doc(i).get(props.getProperty("campo_idiomaBusqueda")));
			resultados[i].setIdioma(((documentos.doc(i).get(props.getProperty("campo_idiomaBusqueda"))!=null)?
					documentos.doc(i).get(props.getProperty("campo_idiomaBusqueda")):""));
//			NIVEL AGREGACION
//			resultados[i].setNivelAgregacion((documentos.doc(i).get(props.getProperty("campo_nivelAgregacion"))));
			resultados[i].setNivelAgregacion(((documentos.doc(i).get(props.getProperty("campo_nivelAgregacion"))!=null)?
					documentos.doc(i).get(props.getProperty("campo_nivelAgregacion")):""));
//			TITULO
//			resultados[i].setTitulo((documentos.doc(i).get(props.getProperty("campo_titulo"))));
			resultados[i].setTitulo(((documentos.doc(i).get(props.getProperty("campo_titulo"))!=null)?
					documentos.doc(i).get(props.getProperty("campo_titulo")):""));
//			DESCRIPCION
			resultados[i].setDescripcion(((documentos.doc(i).get(props.getProperty("campo_descripcion"))!=null)?
					documentos.doc(i).get(props.getProperty("campo_descripcion")):""));
//			EDAD
			resultados[i].setEdad(((documentos.doc(i).get(props.getProperty("campo_edad"))!=null)?
					documentos.doc(i).get(props.getProperty("campo_edad")):""));
//			IDIOMA TRADUCIDO
			String idiomaTraducido = I18n.getInstance().obtenerIdiomaTraducido(resultados[i].getIdioma(), "es"); // estamos poniendo a capon el idioma de traduccion del idioma en el que esta indexado el ODE
			resultados[i].setIdiomaTexto(idiomaTraducido);
//			DESCRIPCIONES OBJETIVO
			resultados[i].setObjetivos(((documentos.doc(i).getValues(props.getProperty("campo_descripcion_objetivo") )!=null)?
					documentos.doc(i).getValues(props.getProperty("campo_descripcion_objetivo")):new String[0]));
//			URL de la imagen
			String urlImagen=((documentos.doc(i).get(props.getProperty("campo_imagen"))!=null)?
					documentos.doc(i).get(props.getProperty("campo_imagen")):"");
			if (urlImagen == null || urlImagen.equals("")) // si el ODE no tiene imagen cojo la de defecto de la plataforma
				urlImagen = "/"+AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.URL_IMAGEN_DEFECTO); 

//			PATH AREA CURRICULAR
			resultados[i].setAreaCurricularPath(((documentos.doc(i).get(props.getProperty("campo_areaCurricular_path"))!=null)?
					documentos.doc(i).getValues(props.getProperty("campo_areaCurricular_path")):new String[0]));
			
			String urlLocal=DependentServerProperties.getInstance().getUrlNodo();
			resultados[i].setUrlImagen(urlLocal + urlImagen);
			
		}
		return resultados;
	}
	
	private boolean contains (String word, String pattern){
		return (word.indexOf(pattern) != -1);
	}
	
	private String formatDayDD(int day)
	{
		if (day > 0 && day < 10)
			return "0"+day;
		else
			return ""+day;
	}
	private String formatMonthMM(int month)
	{
		if (month > 0 && month < 10)
			return "0"+month;
		else
			return ""+month;
	}
	
	private String replaceWords (String palabrasClave, char sustituir, char sustitucion){

		while (this.contains(palabrasClave, String.valueOf(sustituir))){
			palabrasClave=palabrasClave.replace(sustituir,sustitucion);
		}
		return palabrasClave;
	}
	
	
	private List obtenerPalabrasClave (String palabrasClave, boolean tesauro){
		String palabrasClaveLimpias = this.replaceWords(this.replaceWords(this.replaceWords(this.replaceWords(palabrasClave, CHAR_ASTERISK, ESPACIO_BLANCO), CHAR_QUESTIONMARK, ESPACIO_BLANCO), SUMAS, ESPACIO_BLANCO), COMILLAS, ESPACIO_BLANCO);
//		obtengo un array de palabras y espacios en blanco
		String [] palabrasYBlancos =  (palabrasClaveLimpias.trim().split(SEPARADOR_PALABRAS));
//		elimino palabras con ?, *, y los espacios en blanco
		List palabras = new ArrayList();
		if(tesauro){
			palabras.add(palabrasClaveLimpias);
		}else{
			for (int i=0;i<palabrasYBlancos.length;i++){
				if (!palabrasYBlancos[i].equals(SEPARADOR_PALABRAS)){
					palabras.add(palabrasYBlancos[i]);
				}
			}
		}
		return palabras;
	}
	/**
	 * Metodo para ordenar un array dee Strings
	 * @param a
	 * 			El array 
	 */
	public void bubble(String [] a) 
	  {
	    for (int i=1; i<a.length;i++)
	    {
	        for(int j=0;j<a.length-1;j++)
	        {
	            if (a[j].compareTo(a[j+1]) >= 0)
	            {
	                String temp = a[j]; 
	                a[j]= a[j+1];
	                a[j+1]= temp;
	            }
	        }
	    } 
	  }

	private String array2String(Object[] array) {
		String str = "";
		if (array != null && array.length > 0) {
			for (int i = 0; i < array.length; i++) {
				str+=array[i].toString();
				if ((i + 1) < array.length) str+= " ";
			}
		}
		return str;
	}

	/**
	 * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService#handleObtenerCatalogoRepositorio()
	 * @param nivelAgregacion Nivel de agregacion minimo que tienen que cumplir los ODEs del catalogo que se genere.
	 * @return ResultadoRepositorioVO[] Fecha Devuelve un array de objetos de valor con informaci n indexada de los ODEs.
	 */
	protected ResultadoRepositorioVO[] handleObtenerCatalogoRepositorioParam(Integer nivelAgregacion) throws Exception {

			String nivelAgregacionStr ="";
			if (nivelAgregacion == null)
			{
				logger.error("Error recuperando repositorio nivel agregacion["+nivelAgregacion+"]. Nivel de agregacion nulo.");
	    		throw new Exception("Error recuperando repositorio nivel agregacion["+nivelAgregacion+"]. Nivel de agregacion nulo.");
			}
			else
			{
				try {
					nivelAgregacionStr = Integer.toString(nivelAgregacion);
		    	} catch (Exception e) {
		    		logger.error("Error recuperando repositorio nivel agregacion["+nivelAgregacion+"]. Nivel de agregacion invalido.");
		    		throw new Exception("Error recuperando repositorio nivel agregacion["+nivelAgregacion+"]. Nivel de agregacion invalido.",e);
		    	}
			}
//			Obtenemos todos los indices sobre los que hay objetos
	    	IndiceVO[] indices = new IndiceVO[0];
	    	try {
	    		 indices = handleObtenerIdiomasBusqueda();
	    	} catch (Exception e) {
	    		logger.error("Error recuperando repositorio nivel agregacion["+nivelAgregacion+"]. Imposible recuperar los indices.["+e.getMessage()+"]");
	    		throw new Exception("Error recuperando repositorio nivel agregacion["+nivelAgregacion+"]. Imposible recuperar los indices.", e);
	    	}
//	  	Para cada indice, tenemos que recoger todos los odes.
	    	if (indices == null || indices.length == 0)
	    	{
	    		logger.error("Error recuperando repositorio nivel agregacion["+nivelAgregacion+"]. No existen indices en el indexador. Imposible continuar.");
	    		throw new Exception("Error recuperando repositorio nivel agregacion["+nivelAgregacion+"]. No existen indices en el indexador. Imposible continuar.");
	    	}
	    	
//	    	Configuramos la query que se va a realizar sobre el indice
	    	BooleanQuery andQuery = new BooleanQuery();
//			Configuramos el valor de memoria.	
	    	andQuery.setMaxClauseCount(Integer.parseInt(props.getProperty("maxClauseCount")));
	    	logger.debug("Recuperando repositorio  nivel agregacion["+nivelAgregacion+"].");
	    	//Recogemos las descripciones del objetivo y le metemos la l gica, debe tener el nivel de agregacion mayor o igual que el que me pasan
	    	andQuery.add(getConstantScoreRangeQuery(props.getProperty(CAMPO_NIVEL_AGREGACION),nivelAgregacionStr,MAX),BooleanClause.Occur.MUST);
	    	
//			Nos recorremos todos los indices realizando la misma consulta y recopilando la informacion que saquemos de cada indice
	    	ArrayList resultados = new ArrayList();
	    	for (int i = 0; i < indices.length; i++) {
	    		Directory directorioIndiceSimple = this.getIndexByLanguage(indices[i].getIdentificador());
	    		if (directorioIndiceSimple == null)
	    		{
	    			logger.error("Error recuperando repositorio nivel agregacion["+nivelAgregacion+"]. Indice para idioma["+indices[i].getIdentificador()+"] no accesible. Imposible buscar.");
	    			throw new Exception("Error recuperando repositorio nivel agregacion["+nivelAgregacion+"]. Indice para idioma["+indices[i].getIdentificador()+"] no accesible. Imposible buscar.");
	    		}
	    		Hits hits = null;
	    		try {
	    			IndexSearcher searcher = new IndexSearcher(directorioIndiceSimple);
	    			searcher.setSimilarity(new DefaultSimilarity());
	    			
	    			hits = searcher.search(andQuery);
//	    			Dejamos de aplicar el filtro de licencia. Nos interesan todos los ODEs del repositorio
//	    			hits = searcher.search(andQuery, crearFiltroLicencia());
	    		} catch (Exception e) {
	    			logger.error("Error recuperando repositorio nivel agregacion["+nivelAgregacion+"]. Error buscando en indice["+indices[i].getIdentificador()+"] con query["+andQuery.toString()+"].["+e.getCause()+"]");
//	    			En el caso de que el indice de error, miro por el resto.
//	    			throw new Exception("Error recuperando repositorio. Error buscando en indice["+indices[i].getIdentificador()+"] con query["+andQuery.toString()+"].",e);
	    		}
	    		if (hits != null && hits.length() > 0)
	    		{
	    			logger.info("Recuperando repositorio nivel agregacion["+nivelAgregacion+"]. Informacion de repositorio disponible para idioma["+indices[i].getIdentificador()+"] query["+andQuery.toString()+"] documentos["+hits.length()+"]");
	    			try {
						resultados.addAll(Arrays.asList(mapDocToRepositorio(hits)));
					} catch (RuntimeException e) {
						logger.error("Error recuperando repositorio nivel agregacion["+nivelAgregacion+"]. Error mapeando resultados para indice["+indices[i].getIdentificador()+"] con query["+andQuery.toString()+"].["+e.getCause()+"]");
		    			throw new Exception("Error recuperando repositorio nivel agregacion["+nivelAgregacion+"]. Error mapeando resultados para indice["+indices[i].getIdentificador()+"] con query["+andQuery.toString()+"].",e);
					}
	    		}
	    		else
	    		{
	    			logger.info("Recuperando repositorio nivel agregacion["+nivelAgregacion+"]. No hay informacion de repositorio disponible para idioma["+indices[i].getIdentificador()+"] query["+andQuery.toString()+"]");
	    		}
			}
	    	return (ResultadoRepositorioVO[])resultados.toArray(new ResultadoRepositorioVO[resultados.size()]);
		}

	/**
	 * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService#busquedaLOM_ESVSQL(es.pode.indexador.negocio.servicios.busqueda.ParamAvanzadoVO)
	 * @param QuerySimpleVO Parametros de una query simple.
	 * @return DocumentosLOM_ESVO Esta clase representa los documentos resultado de una busqueda por LOM_ES.
	 */
	protected DocumentosLOM_ESVO handleBusquedaLOM_ESVSQL(QuerySimpleVO paramBusqueda) throws Exception {
		DocumentosLOM_ESVO respuesta = new DocumentosLOM_ESVO();
		DocLOM_ESVO[] resultados = null;
		DisjunctionMaxQuery query = new DisjunctionMaxQuery(0.01f);
		String queryLang = paramBusqueda.getLenguajeQuery();
		String idioma = paramBusqueda.getIdioma();
		String unparsedQuery = paramBusqueda.getQuery();
		Hits hits = null;
		logger.debug("Se ha recibido una query en lenguaje["+queryLang+"] con contenido["+unparsedQuery+"]");
		// Discriminar SQI / Lucene
		if (SQI_LANG.equals(queryLang)) 
		{
			logger.debug("Parseando query SQI_LANG["+ unparsedQuery+"]");
			String[] terms = parsearVSQL(unparsedQuery);
			// Introduzco los terminos de busqueda en titulo, descripcion y
			// palabras clave
			logger.debug("Creando query a partir de terminos["+terms+"] con longitud ["+terms.length);
			BooleanQuery query3 = new BooleanQuery();
			for (int i = 0; i < terms.length; i++) 
			{
				BooleanQuery query2 = new BooleanQuery();
				if(this.contains(terms[i], ASTERISK) || this.contains(terms[i], QUESTIONMARK)){
					if (logger.isDebugEnabled())
						logger.debug("Esta query es una WildCardQUery");
					query2.add(getWildcardQuery(props.getProperty("campo_titulo"), terms[i].toLowerCase()),BooleanClause.Occur.SHOULD);
					query2.add(getWildcardQuery(props.getProperty("campo_descripcion"), terms[i].toLowerCase()),BooleanClause.Occur.SHOULD);
					query2.add(getWildcardQuery(props.getProperty("campo_palabrasClave"), terms[i].toLowerCase()),BooleanClause.Occur.SHOULD);
				}
				else{
					if (logger.isDebugEnabled())
						logger.debug("Es una query sin WildCardQuery");
					query2.add(getTermQuery(props.getProperty("campo_titulo"), terms[i].toLowerCase()),BooleanClause.Occur.SHOULD);
					query2.add(getTermQuery(props.getProperty("campo_descripcion"),
							terms[i].toLowerCase()),BooleanClause.Occur.SHOULD);
					query2.add(getTermQuery(props.getProperty("campo_palabrasClave"), terms[i]
							.toLowerCase()),BooleanClause.Occur.SHOULD);
				}
				query3.add(query2,BooleanClause.Occur.MUST);
			}
			query.add(query3);
			if (logger.isDebugEnabled())
				logger.debug("Consulta LOM_ES con query["+query+"] a partir de SQUI lenguaje.");
		} 
		else{
			logger.error("Se ha recibido una query que no es SQI ni Lucene =>["+queryLang+"].");
			throw new Exception("Se ha recibido una query que no es SQI ni Lucene =>["+queryLang+"].");
		}
		
		// Preparando busqueda
		logger.debug("Preparando busqueda");
		Directory directorioIndiceSimple = this.getIndexByLanguage(idioma);
		logger.debug("Directory directorioIndiceSimple["+directorioIndiceSimple+"]");
		IndexSearcher searcher = new IndexSearcher(directorioIndiceSimple);
		searcher.setSimilarity(new DefaultSimilarity());
		if (logger.isDebugEnabled())
			logger.debug("Consulta LOM_ES con query["+query.toString()+"]");
		hits = searcher.search(query);
		logger.debug("Numero de hits obtenidos["+(hits != null?hits.length():0)+"]");
		if (hits != null && hits.length() > 0) 
		{
			logger.debug("Numero de hits[" + hits.length()+"]");

			resultados = new DocLOM_ESVO[hits.length()];

//			logger.debug("resultados[" + resultados+"]");
			
			for (int i = 0; i < hits.length(); i++) 
			{
				DocLOM_ESVO hitToDoc = new DocLOM_ESVO();
				Document doc = hits.doc(i);
//				logger.debug("Document doc : " + doc);
				String localizador = doc.get(props.getProperty("campo_localizador"));
				
				logger.debug("localizador : " + localizador);
				hitToDoc.setRanking(new Integer(Float.floatToIntBits(hits.score(i))));
				
				Manifest manifest = this.parsearManifiesto(localizador+ File.separator + "imsmanifest.xml");
				Lom lom = null;

				if (manifest != null) 
				{
//					logger.debug("manifest!=null " + manifest);
					
					ManifestAgrega ma = new ManifestAgrega(manifest);
					lom = ma.obtenerLom(manifest.getIdentifier(), null);
//					lom = this.getLom(manifest.getMetadata(), manifest.getIdentifier());
//					lomCastor = (es.pode.parseadorXML.lomes.Lom) beanMapper
//							.map(lom, es.pode.parseadorXML.lomes.Lom.class);
					LomAgrega agrega=new LomAgrega(lom);
					TechnicalAgrega tecnica = agrega.getTechnicalAgrega();
					ArrayList localizadores=new ArrayList();
					String hostNodo = AgregaPropertiesImpl.getInstance().getProperty(KEY_HOST_NODO);
					String local=props.getProperty(PROTOCOLO_HTTP) + hostNodo + props.getProperty(BUSCADOR_FICHA) +  idioma + props.getProperty(BARRA) + manifest.getIdentifier();
					localizadores.add(local);
					tecnica.setLocalizadorAv(localizadores);
					agrega.setTechnicalAgrega(tecnica);
					lom=agrega.getLom();
//					creo un writer para escribir los metadatos
					StringWriter sw= new StringWriter();
					//completo el writer
					this.getLomesDao().escribirLom(lom, sw);
					hitToDoc.setDocumento(sw.toString());
					resultados[i] = hitToDoc;
				}
//				logger.debug("manifest==null " + manifest);
			}
			respuesta.setResultados(resultados);
		}
		return respuesta;
	}

	private boolean validarPersonalizada(ParamAvanzadoVO param) throws Exception{
		if ((param.getFechaPublicacion()==null || param.getFechaPublicacion().equals(""))&& (param.getAreaCurricular()==null || param.getAreaCurricular().equals(""))&& 
				(param.getAutor()==null || param.getAutor().equals(""))&& (param.getSecuencia()==null || param.getSecuencia().equals(""))&&		
				(param.getContexto()==null || param.getContexto().equals(""))&& (param.getDescripcion()==null || param.getDescripcion().equals(""))&& 
				(param.getDestinatarios()==null || param.getDestinatarios().equals(""))&&
				(param.getEdad()==null || param.getEdad().equals(""))&&	(param.getFormato()==null || param.getFormato().equals(""))&&(param.getKeyword()==null || param.getKeyword().equals(""))&& 
				(param.getIdTesauro()==null || param.getIdTesauro().equals(""))&&  
				(param.getNivelAgregacion()==null || param.getNivelAgregacion().equals(""))&&  
				(param.getProcesoCognitivo()==null || param.getProcesoCognitivo().equals(""))&& (param.getRecurso()==null || param.getRecurso().equals(""))&& 
				(param.getTitulo()==null || param.getTitulo().equals(""))&&(param.getValoracion()==null || param.getValoracion().equals(""))){
				return false;
		}else return true;
	}
}
