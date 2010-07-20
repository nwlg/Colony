/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.buscar.negocio.buscar.servicios;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import net.sf.ehcache.Element;

import org.apache.log4j.Logger;

import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.agrega.soporte.serverProperties.DependentServerProperties;
import es.pode.buscar.negocio.administrar.servicio.NodoVO;
import es.pode.buscar.negocio.buscar.cache.EHCacheConfig;
import es.pode.buscar.negocio.buscar.comparators.DocFechaPublicacionComparator;
import es.pode.buscar.negocio.buscar.comparators.DocRankingComparator;
import es.pode.buscar.negocio.buscar.comparators.TaxonNombreComparator;
import es.pode.buscar.negocio.buscar.pool.MultiSearcher;
import es.pode.buscar.negocio.buscar.pool.MultiSearcherSQI;
import es.pode.buscar.negocio.nodosSQI.servicio.NodoSQIVO;
import es.pode.indexador.negocio.servicios.busqueda.DocVO;
import es.pode.indexador.negocio.servicios.busqueda.DocumentosLOM_ESVO;
import es.pode.indexador.negocio.servicios.busqueda.DocumentosVO;
import es.pode.indexador.negocio.servicios.busqueda.ParamAvanzadoVO;
import es.pode.indexador.negocio.servicios.busqueda.ParamDocsCountVO;
import es.pode.indexador.negocio.servicios.busqueda.QuerySimpleVO;
import es.pode.indexador.negocio.servicios.busqueda.ResultadosCountVO;
import es.pode.indexador.negocio.servicios.busqueda.TaxonVO;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @see es.pode.buscar.negocio.servicios.SrvBuscarService
 */

public class SrvBuscarServiceImpl
    extends es.pode.buscar.negocio.buscar.servicios.SrvBuscarServiceBase
{
	private Logger logger = Logger.getLogger(this.getClass());
	private static Properties props = null;
	private static EHCacheConfig cacheConfig = null;
	private static final String AMBITO_UNIVERSAL = "universal";
	public static final String LOCALHOST = "localhost";
	private static final String IDENTIFICADOR_NODO = "server.id";
	public static final String BUSCARRSS = "BUSCARRSS";
	private static final String CACHE_RESET ="agregaadmin cachereset";
	private static final String CACHE_RESET_SQI ="agregaadmin cachesqireset";
	private static final char COMILLAS = '"';
	private static final char SUMAS = '+';
	private static final char ESPACIO_BLANCO = ' ';
	private static final String ASTERISCO = "*";
	private static final String INTERROGACION = "?";
	
	public SrvBuscarServiceImpl(){
		super();
		if(cacheConfig == null) cacheConfig = new EHCacheConfig();
		if(props == null){
			InputStream is = null;
			try {
		//		Configuramos la clase de propiedades
				is = this.getClass().getResourceAsStream("/buscar.properties");
				props = new Properties();
				props.load(is);
			} catch (IOException e) {
				logger.error("ERROR: fichero no encontrado: buscar.properties",e);
				throw new RuntimeException(e);
			} finally {
				if( is != null ) {
					try {
						is.close();
					} catch (IOException e) {
						logger.error(e);
					}
					
				}
			}
		}
	}

    /**
	 * @see es.pode.buscar.negocio.servicios.SrvBuscarService#buscarAvanzado(es.pode.buscar.negocio.servicios.ParametrosBusquedaAvanzadaVO)
	 * @param es.pode.buscar.negocio.servicios.ParametrosBusquedaAvanzadaVO Este VO alberga los parametros que configuran la busqueda avanzada
	 * @return es.pode.buscar.negocio.servicios.ResultadoBusquedaVO Esta clase representa los resultados de una busqueda encontrados en el repositorio de ODE's
	 */

    protected es.pode.buscar.negocio.buscar.servicios.ResultadoBusquedaVO handleBuscarAvanzado(es.pode.buscar.negocio.buscar.servicios.ParametrosBusquedaAvanzadaVO parametros)
        throws java.lang.Exception
    {
    	if(parametros.getPalabrasClave()!=null && parametros.getPalabrasClave().equals(CACHE_RESET)){
    		cacheConfig.removeHitsCache();
    		cacheConfig.removeHitsLenghtCache();
    		ResultadoBusquedaVO failHit = new ResultadoBusquedaVO();
    		failHit.setResultadoBusqueda(new ValoresBusquedaVO[]{});
    		failHit.setNumeroResultados(new Integer(0));
			failHit.setTotalResultados(new Integer(0)); 
			failHit.setIdBusqueda("");
			return failHit;
    	}
    	if(parametros.getPalabrasClave()!=null && parametros.getPalabrasClave().equals(CACHE_RESET_SQI)){
    		cacheConfig.removeHitsSQICache();
    		cacheConfig.removeHitsSQIAriadneCache();
    		ResultadoBusquedaVO failHit = new ResultadoBusquedaVO();
    		failHit.setResultadoBusqueda(new ValoresBusquedaVO[]{});
    		failHit.setNumeroResultados(new Integer(0));
			failHit.setTotalResultados(new Integer(0)); 
			failHit.setIdBusqueda("");
			return failHit;
    	}
//   	 Con los valores de la busqueda genero el id de cache que tendre y miro a ver si existe ya en la cache.
    	String idCache = this.handleGeneradorIdentificadorAvanzado(parametros);
    	if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBuscarAvanzado:Buscando en cache con idBusqueda["+idCache+"]");
////    	Busco en la cache si esta busqueda ya se realizo. Si tengo exito, la devuelvo, si no realizamos la busqueda.   	
    	Element elemento = cacheConfig.getHits().get(idCache);
    	HitCacheVO resultadoCache = null; //este obj alberga los resultados en la cache
////    	Se ha producido un fallo de cache, tengo que ir a buscar los elementos nuevos
    	if (elemento == null){
    		if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBuscarAvanzado:Fallo de cache con idBusqueda["+idCache+"]. Se procede a buscar.");
//    		Realizamos la busqueda avanzada con los parametros de busqueda.
        	DocumentosVO resultados = new DocumentosVO();
        	if(parametros.getComunidadesSeleccionadas()!=null && parametros.getComunidadesSeleccionadas().length!=0) resultados = handleBusquedaFederadaLocal(parametros);
        	else {
        		resultados = this.handleBusquedaAvanzadaLocal(parametros);
        		if(resultados!=null && resultados.getNumeroResultados().intValue() > 0){
	        		String[] sugerencias = resultados.getSugerencias();
	        		TaxonVO[] tesauros = resultados.getTesauros();
	        		resultados = ordenarResultados(Arrays.asList(resultados));
	        		resultados.setTesauros(tesauros);
	        		resultados.setSugerencias(sugerencias);
        		}
        	}
//        	Cuando tengamos la busqueda federada, habra que realizar la busqueda federada y combinar los resultados.
//        	Si la busqueda no da resultados no cacheo la busqueda. Devuelvo las sugerencias si las hay
        	ResultadoBusquedaVO failHit = new ResultadoBusquedaVO();
        	
        	if ( resultados.getSugerencias() == null || resultados.getSugerencias().length==0)
//        		No hay sugerencias, pero devolvemos un resultado vacio.
        		failHit.setSugerencias(new String[]{});
        	else failHit.setSugerencias(resultados.getSugerencias());
        	
        	if ( resultados.getTesauros() == null || resultados.getTesauros().length==0)
//        		No hay sugerencias, pero devolvemos un resultado vacio.
        		failHit.setTesauros(new ResultadosTaxonVO[]{});
        	else {
        		ResultadosTaxonVO[] tesauros= new ResultadosTaxonVO[resultados.getTesauros().length];
        		for (int i=0;i<resultados.getTesauros().length;i++){
        			if(resultados.getTesauros()[i]!=null){
	        			ResultadosTaxonVO tesauro = new ResultadosTaxonVO();
	        			tesauro.setIdentificador(resultados.getTesauros()[i].getIdentificador());
	        			tesauro.setNombre(resultados.getTesauros()[i].getNombre());
	        			tesauros[i] = tesauro;
        			}
        		}
        		failHit.setTesauros(tesauros);        		
        	}
        	
        	if (resultados == null || resultados.getResultados() == null || resultados.getResultados().length == 0){
//        		logger.debug("SrvBuscarServiceImpl - handleBuscarAvanzado:Resultados de busqueda en Indexador/Buscador vacios con idBusqueda["+idCache+"]");
        		// Si no hay nada que mostrar, devuelvo un resultado vacio
        		failHit.setResultadoBusqueda(new ValoresBusquedaVO[]{});
        		failHit.setNumeroResultados(new Integer(0));
				failHit.setTotalResultados(new Integer(0)); 
				failHit.setIdBusqueda("");
				return failHit;
        	}else{
//       		 La busqueda da resultados, cacheo la busqueda.
//        		logger.debug("SrvBuscarServiceImpl - handleBuscarAvanzado:Cacheamos resultados obtenidos con idBusqueda["+idCache+"]");
        		try{
//	        		// Creamos el hit de cache y le asociamos los documentos de hit. Tambien le decimos el identificador del hit
        			
	        		HitCacheVO res = creaHitCache(idCache,parametros.getPalabrasClave(),resultados);
	        		resultadoCache = res;
	        		
	        		cacheConfig.getHits().put(new Element(idCache, res));
	        		if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBuscarAvanzado:Cacheados ["+resultados.getResultados().length+"] documentos con idBusqueda["+idCache+"]");
	        		
        		}catch (Exception e){
        			Exception exc = new Exception("ERROR: generando hit de cache con idiomaNavegacion["+parametros.getIdiomaNavegacion()+"], numeroResultados["+parametros.getNumeroResultados()+"], idNodo["+parametros.getAreaCurricular()+"] e idiomaBusqueda["+parametros.getIdiomaBusqueda()+"] y ["+resultados.getResultados()+"]resultados encontrados en Indexador/Buscador.", e);
        			logger.error(exc);
        			throw exc;
        		}
        	}
    	}else{
////    		se han encontrado elementos en la cache
    		if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBuscarAvanzado:Hit de cache con idBusqueda["+idCache+"].");
    		resultadoCache = (HitCacheVO)elemento.getObjectValue();
    	}
//    	Devolvemos los resultados de la pagina
    	if(parametros.getBusquedaSimpleAvanzada()!=null && parametros.getBusquedaSimpleAvanzada().equals(BUSCARRSS))return generaPaginaResultadosRSS(parametros, idCache, resultadoCache, resultadoCache.getResultadoBusquedaWeb());
    	return generaPaginaResultadosBusqueda(parametros, idCache, resultadoCache, resultadoCache.getResultadoBusquedaWeb());
    }
    
    /**
     * @see es.pode.buscar.negocio.servicios.SrvBuscarServiceBase#handleBusquedaAvanzadaLocal(es.pode.buscar.negocio.servicios.ParametrosBusquedaAvanzadaVO)
     * @param ParametrosBusquedaAvanzadaVO Este VO alberga los parametros que configuran la busqueda avanzada
     * @return DocumentosVO Representa los resultados de la busqueda avanzada en el nodo local
     */
    
	protected DocumentosVO handleBusquedaAvanzadaLocal(ParametrosBusquedaAvanzadaVO parametros) throws Exception {
//		Configuramos la llamada al indexador/buscador con los parametros de busqueda.
		try {
			if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBusquedaAvanzadaLocal:Comienzo");
			ParamAvanzadoVO paramBusq = new ParamAvanzadoVO();
			paramBusq.setIdiomaNavegacion(parametros.getIdiomaNavegacion());
			paramBusq.setNumeroResultados(parametros.getNumeroResultados());
			paramBusq.setPalabrasClave(parametros.getPalabrasClave());
			paramBusq.setIdiomaBusqueda(parametros.getIdiomaBusqueda());
			paramBusq.setTitulo(parametros.getTitulo());
			paramBusq.setDescripcion(parametros.getDescripcion());
			paramBusq.setAutor(parametros.getAutor());
			paramBusq.setContexto(parametros.getContexto());
			paramBusq.setAmbito(parametros.getAmbito());
			paramBusq.setEdad(parametros.getEdad());
			paramBusq.setFechaPublicacion(parametros.getFechaPublicacion());
			paramBusq.setFormato(parametros.getFormato());
			paramBusq.setAreaCurricular(parametros.getAreaCurricular());
			paramBusq.setArbolCurricularVigente(parametros.getArbolCurricularVigente());
			paramBusq.setProcesoCognitivo(parametros.getProcesoCognitivo());
			paramBusq.setRecurso(parametros.getRecurso());
			paramBusq.setKeyword(parametros.getKeyword());
			paramBusq.setSecuencia(parametros.getSecuencia());
			paramBusq.setValoracion(parametros.getValoracion());
			paramBusq.setDestinatarios(parametros.getDestinatarios());
			paramBusq.setNivelAgregacion(parametros.getNivelAgregacion());
			paramBusq.setIdTesauro(parametros.getIdTesauro());
			paramBusq.setBusquedaSimpleAvanzada(parametros.getBusquedaSimpleAvanzada());
			paramBusq.setSearchFilters(parametros.getSearchFilters());
			// Si llegan comunidades seleccionadas es porque se llega aqui desde una b�squeda federada
			if(parametros!=null && parametros.getComunidadesSeleccionadas() != null && parametros.getComunidadesSeleccionadas().length>0){
				parametros.setComunidadesSeleccionadas(null);
		    	String idCache = this.handleGeneradorIdentificadorAvanzado(parametros);
		    	if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBusquedaAvanzadaLocal:Buscando en cache con idBusqueda["+idCache+"]");
//		    	Busco en la cache si esta busqueda ya se realizo. Si tengo exito, la devuelvo, si no realizamos la busqueda.   	
		    	Element elemento = cacheConfig.getHits().get(idCache);
		    	if(elemento!=null){
			    	HitCacheVO resultadoCache = null; //este obj alberga los resultados en la cache
			    	if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBusquedaAvanzadaLocal:Hit de cache con idBusqueda["+idCache+"].");
		    		resultadoCache = (HitCacheVO)elemento.getObjectValue();
		    		return new DocumentosVO(mapValoresBusquedaVO2DocVO(resultadoCache.getResultadoBusquedaWeb()),new String[0],resultadoCache.getNumeroResultados(),resultadoCache.getTotalResultados(),new Integer(0),new es.pode.indexador.negocio.servicios.busqueda.TaxonVO [0]);
		    	}
	    	}else parametros.setComunidadesSeleccionadas(null);
			DocumentosVO resultados = this.getSrvBuscadorService().busquedaAvanzada(paramBusq);
			return resultados;
		} 
		catch (Exception e){
			Exception exc = new Exception("SrvBuscarServiceImpl - handleBusquedaAvanzadaLocal ERROR: invocacion al servicio busquedaAvanzada de Indexados/Buscador con idiomaNavegacion["+parametros.getIdiomaNavegacion()+"], numeroResultados["+parametros.getNumeroResultados()+"], palabrasClave["+parametros.getPalabrasClave()+"] e idiomaBusqueda["+parametros.getIdiomaBusqueda()+"]", e);
			logger.error(e);
			throw exc;
		}
	}
	
	/**
     * @see es.pode.buscar.negocio.servicios.SrvBuscarServiceBase#handleBusquedaFederadaLocal(es.pode.buscar.negocio.servicios.ParametrosBusquedaAvanzadaVO)
     * @param ParametrosBusquedaAvanzadaVO Este VO alberga los parametros que configuran la busqueda avanzada
     * @return DocumentosVO Representa los resultados de la busqueda avanzada en todos los nodos
     */
	protected DocumentosVO handleBusquedaFederadaLocal(ParametrosBusquedaAvanzadaVO parametros) throws Exception
	{
		if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBusquedaFederadaLocal : Comienzo");
		List <DocumentosVO>documentos= new ArrayList<DocumentosVO>();
		List <String>sugerencias=new ArrayList<String>();
		HashMap <String,TaxonVO> tesauros = new HashMap<String,TaxonVO>();
		boolean existenResultados=false;
		List<NodoVO> comunidades=obtenerComunidades(parametros.getComunidadesSeleccionadas());
		NodoVO nodoComunidadPeticion=new NodoVO();
		int numeroSugerencias=0;
		int numeroTesauros=0;
		nodoComunidadPeticion.setNodo(LOCALHOST);
		nodoComunidadPeticion.setUrlWS(LOCALHOST);
		nodoComunidadPeticion.setUrl(LOCALHOST);
		nodoComunidadPeticion.setPuerto(props.getProperty("puertoFederada"));
		comunidades.add(comunidades.get(0));
		comunidades.set(0, nodoComunidadPeticion);
		if(parametros.getNumeroResultados()!=null && parametros.getNumeroResultados().intValue()!=-1)parametros.setNumeroResultados(Integer.valueOf(parametros.getNumeroResultados().intValue()/(comunidades.size()<5?5:comunidades.size())));
		DocumentosVO[] documents = MultiSearcher.searchDocuments(parametros, comunidades,props.getProperty("srvFederada"),Integer.parseInt(props.getProperty("maxWaitThread")),Integer.parseInt(props.getProperty("maxWaitPool")));
		for(int i = 0; i < documents.length ; i++ ){
			if(documents[i]!=null && documents[i].getResultados()!=null && documents[i].getResultados().length>0){
				if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBusquedaFederadaLocal: "+documents[i].getResultados().length+" docuemntos para ="+ comunidades.get(i).toString());
				existenResultados = true;
				documentos.add(documents[i]);
			}
			if(documents[i]!=null && documents[i].getSugerencias()!=null && documents[i].getSugerencias().length>0){
				if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBusquedaFederadaLocal: "+documents[i].getSugerencias().length+" sugerencias para ="+ comunidades.get(i).toString());
				for(int j=0; j<documents[i].getSugerencias().length && Integer.parseInt(props.getProperty("numero_sugerencias")) >= numeroSugerencias;j++){
					if(!sugerencias.contains(documents[i].getSugerencias()[j])){
						sugerencias.add(documents[i].getSugerencias()[j]);
						numeroSugerencias++;
					}
				}
			}
			if(documents[i]!=null && documents[i].getTesauros()!=null && documents[i].getTesauros().length>0){
				if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBusquedaFederadaLocal: "+documents[i].getTesauros().length+" tesauros para ="+ comunidades.get(i).toString());
				for(int j=0; j<documents[i].getTesauros().length && Integer.parseInt(props.getProperty("numero_tesauros")) >= numeroTesauros;j++){
					if(!tesauros.containsKey(documents[i].getTesauros()[j].getNombre())){
						tesauros.put(documents[i].getTesauros()[j].getNombre(),documents[i].getTesauros()[j]);
						numeroTesauros++;
					}
				}
			}
		}
		if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBusquedaFederadaLocal :Se ordenan resultados o sugerencias y se devuelve resultado.");
		DocumentosVO documentosSugerenciasTesauros= new DocumentosVO();
	  	if((documentos!=null) && (documentos.size()>0) && existenResultados){
	  		DocumentosVO resultadosOrdenados= ordenarResultados(documentos);
	  		documentosSugerenciasTesauros.setNumDocumentosIndice(resultadosOrdenados.getNumDocumentosIndice());
	  		documentosSugerenciasTesauros.setNumeroResultados(resultadosOrdenados.getNumeroResultados());
	  		documentosSugerenciasTesauros.setResultados(resultadosOrdenados.getResultados());
	  		documentosSugerenciasTesauros.setTotalResultados(resultadosOrdenados.getTotalResultados());
	  	}
  		if(sugerencias!=null && sugerencias.size()>0){
	  		Collections.sort(sugerencias);
	  		documentosSugerenciasTesauros.setSugerencias(sugerencias.toArray(new String[0]));
	  	}else documentosSugerenciasTesauros.setSugerencias(new String[]{});
  		if(tesauros!=null && tesauros.size()>0){
  			List <TaxonVO>tesaurosOrdenados = new ArrayList<TaxonVO>(tesauros.values());
  	        Collections.sort(tesaurosOrdenados,new TaxonNombreComparator());
  	        documentosSugerenciasTesauros.setTesauros(tesaurosOrdenados.toArray(new TaxonVO[0]));
	  	}else documentosSugerenciasTesauros.setTesauros(new es.pode.indexador.negocio.servicios.busqueda.TaxonVO[]{});
  		return documentosSugerenciasTesauros;
	}

	/**
     * @see es.pode.buscar.negocio.servicios.SrvBuscarServiceBase#handleBuscarSQI()
     * @param Parametros de busqueda SQI
     * @return ResultadoBusquedaVO Numero de documentos resultantes de la busqueda por SQI
     */
	protected ResultadoBusquedaSQIVO handleBuscarSQI(ParamBusquedaSQIVO consulta) throws Exception {
		// TODO Auto-generated method stub
		if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBuscarSQI : Comienzo");
    	if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBuscarSQI:Buscando en cache con idBusqueda["+consulta.getPalabrasClave()+"]");
////    	Busco en la cache si esta busqueda ya se realizo. Si tengo exito, la devuelvo, si no realizamos la busqueda.   	
    	Element elemento = cacheConfig.getHits().get(consulta.getPalabrasClave());
    	ResultadoBusquedaSQIVO resultadoCache = null; //este obj alberga los resultados en la cache
////    	Se ha producido un fallo de cache, tengo que ir a buscar los elementos nuevos
    	if (elemento == null){
			List <LomEsVO>documentos= new ArrayList<LomEsVO>();
			boolean existenResultados=false;
	//		Obtenemos los nodos SQI
			NodoSQIVO[] nodosSQI=this.getSrvGestionSqiService().obtenerNodosSQI();
	//		Realizamos la b�squeda SQI invocando al gestor de hilos con todos los parametros.
	//		TODO: revisar la recoleccion y el ordenamiento de los resultados devueltos.
			LomEsVO[] documents = MultiSearcherSQI.searchDocuments(consulta, Arrays.asList(nodosSQI),Integer.parseInt(props.getProperty("maxWaitThreadSQI")),Integer.parseInt(props.getProperty("maxWaitPoolSQI")));
			if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBuscarSQI: Hemos recogido los documentos de longitud ["+documents.length+"]");
			for(int i = 0; i < documents.length ; i++ ){
				if(documents[i]!=null && documents[i].getTitulo()!=null && documents[i].getDescripcion()!=null){
					existenResultados = true;
					documentos.add(documents[i]);
				}
			}		
			if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBuscarSQI :Se ordenan resultados o sugerencias y se devuelve resultado.");
		  	if((documentos!=null) && (documentos.size()>0) && existenResultados){
	//	  		Habr� que ordenar los resultados de los difetentes nodos SQI.
		  		resultadoCache= ordenarResultadosSQI(documentos);
		  		cacheConfig.getHitsSQI().put(new Element(consulta.getPalabrasClave(), resultadoCache));
		  	}else{
		  		return new ResultadoBusquedaSQIVO(new LomEsVO[0],0);
		  	}
    	}else{
    		if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBuscarSQI:Hit de cache con idBusqueda["+consulta.getPalabrasClave()+"].");
    		resultadoCache = (ResultadoBusquedaSQIVO)elemento.getObjectValue();
    	}
    	// Resolvemos la paginacion. Devolvemos los elementos de la pagina.
    	int pagina = consulta.getOrigenPagina().intValue();
    	int resPorPagina = consulta.getResultadoPorPagina().intValue();
//    	Devolvemos los resultados de la pagina
    	return generaPaginaResultadosBusquedaSQI(resultadoCache, pagina, resPorPagina);
	}

	/**
     * @see es.pode.buscar.negocio.servicios.SrvBuscarServiceBase#handleSolicitarDocsCountArbolCurricular(ParametrosDocsCountVO)
     * @param ParametrosDocsCountVO Este VO alberga los parametros necesarios para realizar el calculo del numero de documentos resultantes en la busqueda por arbol curricular
     * @return ResultadosNodoCountVO Numero de documentos resultantes de la busqueda por arbol curricular
     */
	
	protected ResultadosNodoCountVO handleSolicitarDocsCount(ParametrosDocsCountVO parametros) throws Exception {
//  	 Con los valores de la busqueda genero el id de cache que tendre y miro a ver si existe ya en la cache.
    	String idCache = parametros.getIdiomaBusqueda() + parametros.getIdiomaNavegacion() +parametros.getTipoBusqueda()+ array2String(parametros.getAreaCurricular())+ parametros.getArbolCurricularVigente()+array2String(parametros.getTesauros());
    	if (logger.isDebugEnabled())logger.debug("Buscando en cache con idBusqueda["+idCache+"]");
//    	Busco en la cache si esta busqueda ya se realizo. Si tengo exito, la devuelvo, si no realizamos la busqueda.   	
    	Element elemento = cacheConfig.getHitsLength().get(idCache);
    	ResultadosNodoCountVO resultado = null; //este obj alberga los resultados en la cache
//    	Se ha producido un fallo de cache, tengo que ir a buscar los elementos nuevos
    	if (elemento == null)
    	{
    		if (logger.isDebugEnabled())logger.debug("Fallo de cache con idBusqueda["+idCache+"]. Se procede a buscar.");
//    		Realizamos la busqueda local o federada con los parametros de busqueda.
    		if (parametros.getTipoBusqueda().equals("01")){
    			resultado = this.handleSolicitudDocsCountFederada(parametros);
    		}else{
    			resultado = this.handleSolicitudDocsCountLocal(parametros);
    		}
//        	Si la busqueda no da resultados no cacheo la busqueda. Devuelvo las sugerencias si las hay
    		if (logger.isDebugEnabled())logger.debug("Cacheamos resultados obtenidos con idBusqueda["+idCache+"]");
        	cacheConfig.getHitsLength().put(new Element(idCache, resultado));
        	if (logger.isDebugEnabled())logger.debug("Cacheados [1] documentos con idBusqueda["+idCache+"]");
    	}else{
//    		se han encontrado elementos en la cache
    		if (logger.isDebugEnabled())logger.debug("Hit de cache con idBusqueda["+idCache+"].");
    		resultado = (ResultadosNodoCountVO)elemento.getObjectValue();
    	}
    	return resultado;
	}

	/**
     * @see es.pode.buscar.negocio.servicios.SrvBuscarServiceBase#handleSolicitudDocsCountArbolLocal(ParametrosDocsCountVO)
     * @param ParametrosDocsCountVO Este VO alberga los parametros necesarios para realizar el calculo del numero de documentos resultantes en la busqueda local por arbol curricular
     * @return ResultadosNodoCountVO Numero de documentos resultantes de la busqueda por arbol curricular en local
     */
	
	protected ResultadosNodoCountVO handleSolicitudDocsCountLocal(ParametrosDocsCountVO parametros) throws Exception {
		try{
			if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleSolicitudDocsCountArbolLocal: Inicio.");
			ParamDocsCountVO paramBusq = new ParamDocsCountVO(parametros.getAreaCurricular(),parametros.getIdiomaBusqueda(),parametros.getArbolCurricularVigente(), parametros.getTesauros());
			ResultadosCountVO resultado = this.getSrvBuscadorService().solicitudDocsCount(paramBusq);
			return new ResultadosNodoCountVO(resultado.getDocumentosCount(),resultado.getConteo());
		} 
		catch (Exception e) 
		{
			Exception exc = new Exception("SrvBuscarServiceImpl - handleSolicitudDocsCountArbolLocal ERROR: invocacion al servicio solicitudDocsCountArbolCurricular de Indexados/Buscador con idiomaNavegacion["+parametros.getIdiomaNavegacion()+"], idNodo["+parametros.getAreaCurricular()+"]", e);
			logger.error(exc);
			throw exc;
		}
	}
	
	/**
     * @see es.pode.buscar.negocio.servicios.SrvBuscarServiceBase#handleSolicitudDocsCountArbolFederada(ParametrosDocsCountVO)
     * @param ParametrosDocsCountVO Este VO alberga los parametros necesarios para realizar el calculo del numero de documentos resultantes en la busqueda en todos los nodos por arbol curricular
     * @return ResultadosNodoCountVO Numero de documentos resultantes de la busqueda por arbol curricular en todos los nodos
     */
	protected ResultadosNodoCountVO handleSolicitudDocsCountFederada(ParametrosDocsCountVO parametros) throws Exception {
		if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleSolicitudDocsCountArbolFederada: Inicio.");
		NodoVO[] nodosDB=this.getSrvNodoService().listarNodos();
		NodoVO[] nodos=new NodoVO[nodosDB.length+1];
		NodoVO nodoLocal=new NodoVO();
		nodoLocal.setNodo(LOCALHOST);
		nodoLocal.setUrlWS(LOCALHOST);
		nodoLocal.setUrl(LOCALHOST);
		nodoLocal.setPuerto(props.getProperty("puertoFederada"));
		nodos[0]=nodoLocal;
		for (int i=1; i<nodos.length; i++){
			nodos[i]=nodosDB[i-1];
		}
		int numeroResultados=0;
		ResultadosNodoCountVO[] documents = MultiSearcher.searchDocsCountArbolCurricularFederada(parametros, nodos, props.getProperty("srvFederada"),Integer.parseInt(props.getProperty("maxWaitThread")),Integer.parseInt(props.getProperty("maxWaitPool")));
		Integer[] conteo=new Integer[(parametros.getAreaCurricular()!=null)?parametros.getAreaCurricular().length:parametros.getTesauros().length];
		for (int i=0;i<documents.length;i++){
			try{
				//if no null de i
				if (documents[i]!=null){
				    numeroResultados = numeroResultados + (documents[i].getNumeroResultados()).intValue();
				    for (int j=0;j<documents[i].getConteo().length;j++){
				    	conteo[j]=(conteo[j]==null)?new Integer(documents[i].getConteo()[j].intValue()):new Integer(conteo[j].intValue()+documents[i].getConteo()[j].intValue());
				    }
				}
	  		}catch (Exception e){
				logger.error("SrvBuscarServiceImpl - handleSolicitudDocsCountArbolFederada:"+e+"llamada al servicio:"+"http://"+ nodos[i].getUrl() +":"+ nodos[i].getPuerto() +props.getProperty("srvFederada")+"ha fallado");
			}
		}
		Integer sumaResultados= new Integer(numeroResultados);
		ResultadosNodoCountVO totalResultados = new ResultadosNodoCountVO();
		totalResultados.setNumeroResultados(sumaResultados);
		totalResultados.setConteo(conteo);
		if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleSolicitudDocsCountArbolFederada: Total resultados="+sumaResultados);
		return totalResultados;
	}
	
    /**
     * @see es.pode.buscar.negocio.servicios.SrvBuscarService#generadorIdentificadorAvanzado(es.pode.buscar.negocio.servicios.ParametrosBusquedaAvanzadaVO)
     * @param es.pode.buscar.negocio.servicios.ParametrosBusquedaAvanzadaVO Este VO alberga los parametros que configuran la busqueda avanzada
     * @return java.lang.String Identificaodor para la cache a partir de los parametros de una busqueda avanzada
     */
    
    protected java.lang.String handleGeneradorIdentificadorAvanzado(es.pode.buscar.negocio.buscar.servicios.ParametrosBusquedaAvanzadaVO parametrosAvanzada)
        throws java.lang.Exception
    {
    	if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleGeneradorIdentificadorAvanzado: Inicio.");
    	String comunidades="";
    	if (parametrosAvanzada.getComunidadesSeleccionadas()!=null){
    		for (int i=0; i<parametrosAvanzada.getComunidadesSeleccionadas().length;i++){
    			comunidades += parametrosAvanzada.getComunidadesSeleccionadas()[i];
    		}
    	}
        return 	""+
        (parametrosAvanzada.getAutor() != null?parametrosAvanzada.getAutor():"") + 
         comunidades + 
        (parametrosAvanzada.getContexto() != null?parametrosAvanzada.getContexto():"") + 
        (parametrosAvanzada.getDescripcion() != null?parametrosAvanzada.getDescripcion():"") + 
        (parametrosAvanzada.getEdad() != null?parametrosAvanzada.getEdad():"") + 
        (parametrosAvanzada.getFechaPublicacion() != null?parametrosAvanzada.getFechaPublicacion():"") + 
        (parametrosAvanzada.getFormato() != null?parametrosAvanzada.getFormato():"") + 
        (parametrosAvanzada.getKeyword() != null?parametrosAvanzada.getKeyword():"") + 
        (parametrosAvanzada.getIdiomaBusqueda() != null?parametrosAvanzada.getIdiomaBusqueda():"") + 
        (parametrosAvanzada.getNivelAgregacion() != null?parametrosAvanzada.getNivelAgregacion().toString():"") + 
        (parametrosAvanzada.getIdiomaNavegacion() != null?parametrosAvanzada.getIdiomaNavegacion():"") + 
        (parametrosAvanzada.getAreaCurricular() != null?parametrosAvanzada.getAreaCurricular():"") + 
        (parametrosAvanzada.getArbolCurricularVigente() != null?parametrosAvanzada.getArbolCurricularVigente():"") +
        (parametrosAvanzada.getPalabrasClave() != null?parametrosAvanzada.getPalabrasClave():"") + 
        (parametrosAvanzada.getProcesoCognitivo() != null?parametrosAvanzada.getProcesoCognitivo():"") + 
        (parametrosAvanzada.getRecurso() != null?parametrosAvanzada.getRecurso():"") + 
        (parametrosAvanzada.getSecuencia() != null?parametrosAvanzada.getSecuencia().toString():"") + 
        (parametrosAvanzada.getTitulo() != null?parametrosAvanzada.getTitulo():"") + 
        (parametrosAvanzada.getValoracion() != null?parametrosAvanzada.getValoracion().toString():"") + 
        (parametrosAvanzada.getAmbito() != null?parametrosAvanzada.getAmbito().toString():"") + 
        (parametrosAvanzada.getIdTesauro() != null?parametrosAvanzada.getIdTesauro():"")+
        (parametrosAvanzada.getBusquedaSimpleAvanzada() != null && parametrosAvanzada.getBusquedaSimpleAvanzada().equals(BUSCARRSS)?parametrosAvanzada.getBusquedaSimpleAvanzada():"") +
		(parametrosAvanzada.getSearchFilters() != null ?
			parametrosAvanzada.getSearchFilters().toString() : "");
    }
    
    
    private java.lang.String generadorIdentificadorSQIAriadne(QuerySimpleVO parametrosSQI, String idioma)
    throws java.lang.Exception
{
	if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - generadorIdentificadorSQIAriadne: Inicio.");
    return 	""+
    (parametrosSQI.getQuery() != null?parametrosSQI.getQuery():"") + (idioma !=null? idioma:"");
    
}
    
    /**
	 * @see es.pode.buscar.negocio.servicios.SrvBuscarServiceBase#handleBuscarLomEs(es.pode.buscar.negocio.servicios.ParametrosBusquedaSQIVO)
	 * @param ParametrosBusquedaSQIVO Este VO alberga los parametros que configuran la busqueda
	 * @return ResultadoBusquedaSQIVO Esta clase representa los resultados de una busqueda en el formato necesario para el m�dulo SQI
	 */
    
    protected ResultadoBusquedaSQIVO handleBuscarLomEs(ParametrosBusquedaSQIVO parametros) throws Exception {
    	try {
    		if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBuscarLomEs: Inicio con los parametros vocabularioConsulta:["+parametros.getVocabularioConsulta()+"]," +
    				"resultadosDevueltos:["+parametros.getResultadosDevueltos()+"], la query:"+parametros.getQuery()+"] y el maximo de resultados"+parametros.getMaxResultados());
    		QuerySimpleVO paramLom= new QuerySimpleVO();
    		
    		paramLom.setLenguajeQuery(parametros.getVocabularioConsulta());
    		paramLom.setNumResultados(parametros.getResultadosDevueltos());
    		paramLom.setQuery(parametros.getQuery());
    		String[] idiomas=I18n.getInstance().obtenerIdiomasBuscables();
    		if(parametros.getResultadosDevueltos().intValue()>0 && parametros.getResultadosDevueltos().intValue()>parametros.getMaxResultados().intValue()){
    			parametros.setResultadosDevueltos(parametros.getMaxResultados().intValue());//Si el numero de devueltos es mas grande lo cambiamos por los resultados maximos		
    		}//No deber�a entrar nunca, esto lo controlamos en el servicio
    			
    		ResultadoBusquedaSQIVO paramLom_ResultadosBusqSQIVO= new ResultadoBusquedaSQIVO();
    		boolean sobrePasar=false;
    		int contador=0;
    		ArrayList<LomEsVO> array=new ArrayList();
    		int maximo=0;
    		int grupos=0;
    		int max=0;
    		int resta=0;
    		LomEsVO[] loms=null;
    		if(parametros.getResultadosDevueltos().intValue()>=0){//Si hay resultados devueltos
    			if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBuscarLomEs Hay resultados devueltos:["+parametros.getResultadosDevueltos().intValue()+"]");
    			if(parametros.getStartResult().intValue()>1){//Empezamos a contar en una posicion que no es el 1
    				if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBuscarLomEs Empezamos por:["+parametros.getStartResult().intValue()+"]");
    				maximo = parametros.getMaxResultados().intValue()+(parametros.getStartResult().intValue()-1);// Si quiero empezar del 3 y 15 resultados, necesito hasta 18
    				if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBuscarLomEs Maximos:["+maximo+"]");
    				grupos=parametros.getResultadosDevueltos().intValue()+(parametros.getStartResult().intValue()-1);// Si quiero empezar del 3 y 15 resultados, necesito hasta 18
    				if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBuscarLomEs Paginado:["+grupos+"]");
    			}else{
    				maximo=parametros.getMaxResultados().intValue();//Necesito 15
    				if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBuscarLomEs Empezamos por, sin inicio:["+maximo+"]");
    				grupos=parametros.getResultadosDevueltos().intValue();//Necesito 15
    				if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBuscarLomEs Paginado, sin inicio:["+grupos+"]");
    			}
    		}else{//Sin resultados devueltos
    			if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBuscarLomEs Sin resultados devueltos");
    			if(parametros.getStartResult().intValue()>1){//Empezamos a contar en una posicion que no es el 1
    				if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBuscarLomEs Empezamos por:["+parametros.getStartResult().intValue()+"]");
    				maximo = parametros.getMaxResultados().intValue()+(parametros.getStartResult().intValue()-1);// Si quiero empezar del 3 y 15 resultados, necesito hasta 18
    				if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBuscarLomEs Maximos:["+maximo+"]");
    			}else{
    				maximo=parametros.getMaxResultados().intValue();//Necesito 15
    				if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBuscarLomEs Maximos, sin inicio:["+maximo+"]");
    			}
    		}
    		if(grupos>0){//Si hay grupos, nos quedamos con este n�mero ( que ser� mas peque�o que el siguiente
    			max=grupos;
    			if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBuscarLomEs Hay grupos, nos quedamos con ese maximo:["+max+"]");
    		}else{//Sin grupos
    			max=maximo;
    			if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBuscarLomEs No hay grupo, maximo:["+max+"]");
    		}
    		resta=parametros.getMaxResultados().intValue()-(parametros.getStartResult().intValue()-1);
    		if( resta>0){
	    		for(int i=0;i<idiomas.length && !sobrePasar ;i++){
	    			paramLom.setIdioma(idiomas[i]);
	    			if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - llamada con el idioma:["+idiomas[i]+"]");
	    			
	    			String idCache = generadorIdentificadorSQIAriadne(paramLom, idiomas[i]);
	    			DocumentosLOM_ESVO doc =null;
	    			Element elemento = cacheConfig.getHitsSQIAriadne().get(idCache);
	    	    	if (elemento == null){
	    	    		if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - No existe en la cache, hacemos la busqueda");
	    	    		doc= this.getSrvBuscadorService().busquedaLOM_ESVSQL(paramLom);
	    	    		if(doc.getResultados()!=null) 
	    	    			if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - Nos devuelve un elemento de ["+ doc.getResultados().length+"] posiciones");
	    	    		if(doc.getResultados()!=null && doc.getResultados().length>0){
	    	    			cacheConfig.getHitsSQIAriadne().put(new Element(idCache, doc));
	    	    		}
	    	    	}else{
	    	    		if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleBuscarLomEs:Hit de cache con idBusqueda["+paramLom.getQuery()+"] y idioma "+ idiomas[i]);
	    	    		doc = (DocumentosLOM_ESVO)elemento.getObjectValue();
	    	    	}
	    			if (doc.getResultados()!=null && doc.getResultados().length >0)
	        		{
	    				if(contador>=max){//Si en esta vuelta nos pasamos
	    					
	    					if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - el contador es mayor que el maximo, nos pasamos:["+max+"]");
	    					contador=doc.getResultados().length;
	    					if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - tenemos elementos "+ contador+"] y ya salimos");
	    					sobrePasar=true;
	    					int n=0;
	    					for(int j=0;j<contador;j++){
		    					LomEsVO temp = new LomEsVO();
			    				temp.setLomES(doc.getResultados()[n].getDocumento());
			    				temp.setRanking(doc.getResultados()[n].getRanking());
			    				n++;
			    				array.add(temp);
	    					}
	    				}else{
	    					int n=0;
	    					
	    					if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - tenemos elementos desde "+ contador+" a "+contador+doc.getResultados().length+"]");
	    					for(int j=contador;j<contador+doc.getResultados().length;j++){//Si no nos pasamos
	    						
		    					LomEsVO temp = new LomEsVO();
			    				temp.setLomES(doc.getResultados()[n].getDocumento());
			    				temp.setRanking(doc.getResultados()[n].getRanking());
			    				n++;
			    				array.add(temp);
	    					}
	    					contador=contador+doc.getResultados().length;
	    					if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - tenemos elementos hasta "+contador+"]");
	    					if(contador>=max){//Si nos pasamos
	    						
	    						if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - Nos pasamos:["+max+"]");
	    						sobrePasar=true;
	    						if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - tenemos elementos hasta "+ contador+" salimos");
	    					}
	    				}
	    				
	        		}
	    			
	    		}
	
	    		if(contador<=max){
	    			max=contador;//Para que si tenemos 5 elementos no intente cargar 95 en el array de VO
	    			if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - El numero de pedido es mayor que el numero de resultados a devolver, "+max+"-->"+contador);
	    		}
	    		if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - Generamos un array de , "+(max)+" posiciones, el array mide:"+array.size()+", y lo queremos a partir de[ "+(parametros.getStartResult().intValue()-1));
	//    		int mr=parametros.getMaxResultados().intValue()-(parametros.getStartResult().intValue()-1);
	    		
				if(max-(parametros.getStartResult().intValue()-1)>0 ){//Mas grandes que 25
					if(logger.isDebugEnabled()) logger.debug("max-(parametros.getStartResult().intValue()-1) es positivo, el array de 0 a ["+(max-(parametros.getStartResult().intValue()-1))+"]");
	//				if(logger.isDebugEnabled()) logger.debug("Nos faltan para devolver  ["+(mr)+"] elementos, para llegar al maximo1");
					int v=0;
					loms=new LomEsVO[max-(parametros.getStartResult().intValue()-1)];
					for(int g=(parametros.getStartResult().intValue()-1);g<max ;g++){
						loms[v]=array.get(g);
						v++;
					}
				}else{
					if(logger.isDebugEnabled()) logger.debug("max-(parametros.getStartResult().intValue()-1) es negativo o 0, ["+(max-(parametros.getStartResult().intValue()-1))+"], el array de max");
					loms=new LomEsVO[max];
					int v=0;
	//				if(logger.isDebugEnabled()) logger.debug("Nos faltan para devolver  ["+(mr)+"] elementos, para llegar al maximo2");
					if(array.size()>=max+(parametros.getStartResult().intValue()-1) ){
						for(int g=parametros.getStartResult().intValue()-1;g<max+(parametros.getStartResult().intValue()-1);g++){
							loms[v]=array.get(g);
							v++;
						}
					}
					else{
						loms=null;;
//						LomEsVO lm=new LomEsVO();
//		    			loms[0]=lm;
					}
				}
	//			if(logger.isDebugEnabled()) logger.debug("Nos faltan para devolver  ["+(mr)+"] elementos, para llegar al maximo3");
				if(loms!=null &&loms.length>0){
					if (logger.isDebugEnabled())logger.debug("Devolvemos loms de longitud ["+loms.length+"] ");
				}
    		}else{
    			if (logger.isDebugEnabled())logger.debug("Hemos llegado al maximo");
    			loms=null;
//    			LomEsVO lm=new LomEsVO();
//    			loms[0]=lm;
    			max=parametros.getMaxResultados();
    		}
			paramLom_ResultadosBusqSQIVO.setNumeroResultados(max);
			paramLom_ResultadosBusqSQIVO.setResultadoBusqueda(loms);

	    	
	    	return paramLom_ResultadosBusqSQIVO;
	    } 
	    catch (Exception e) 
	    {
	    	Exception exc = new Exception("SrvBuscarServiceImpl - handleBuscarLomEs ERROR: invocacion al servicio de Indexador/Buscador ", e);
	    	logger.error(exc);
	    	throw exc;
	    }
	}
    
    /**
	 * @see es.pode.buscar.negocio.servicios.SrvBuscarService#solicitarMetadato(es.pode.buscar.negocio.servicios.ParametroMetadatoVO)
	 * @param es.pode.buscar.negocio.servicios.ParametroMetadatoVO Este VO alberga los parametros necesarios para consultar los metadatos de un ODE dado
	 * @return es.pode.buscar.negocio.servicios.MetadatoBasicoVO Esta clase representa la meta informacion de un ODE
	 */
    
    protected es.pode.buscar.negocio.buscar.servicios.MetadatoBasicoVO handleSolicitarMetadato(es.pode.buscar.negocio.buscar.servicios.ParametroMetadatoVO parametros)
        throws java.lang.Exception
    {
    	try {
    		if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - handleSolicitarMetadato:Buscando metadatos para MEC["+parametros.getIdentificadorODE()+"] en el idioma["+parametros.getIdioma()+"]");
			DocVO documentoBusqueda = this.getSrvBuscadorService().busquedaMEC(parametros.getIdentificadorODE(), parametros.getIdioma());
			if (documentoBusqueda != null){
				if (logger.isDebugEnabled()){
					logger.debug("SrvBuscarServiceImpl - handleSolicitarMetadato:Encontrados metadatos para MEC["+parametros.getIdentificadorODE()+"] en el idioma["+parametros.getIdioma()+"]");
					logger.debug("SrvBuscarServiceImpl - handleSolicitarMetadato: MetadatoBasico= Licencias-"+documentoBusqueda.getLicencias()+" Titulo-"+documentoBusqueda.getTitulo()+" Descripcion-"+documentoBusqueda.getDescripcion()+" Formato-"+documentoBusqueda.getFormato()+" Destinatarios-"+documentoBusqueda.getDestinatarios()+" Idioma-"+documentoBusqueda.getIdioma()+" Ambito-"+documentoBusqueda.getAmbito()+" Valoracion-"+documentoBusqueda.getValoracion()+" LocalizadorODE-"+documentoBusqueda.getLocalizadorODE()+" IdentificadorODE-"+documentoBusqueda.getIdentificadorODE()+" Imagen-"+documentoBusqueda.getImagen()+" NivelAgregacion-"+documentoBusqueda.getNivelAgregacion()+" Tamanio-"+documentoBusqueda.getTamanio()+" conSinSecuencia-"+documentoBusqueda.getConSinSecuencia());
				}
				String[] ambitosTraducidos = null;
				if(documentoBusqueda.getAmbito()!=null && documentoBusqueda.getAmbito().length>0 && !documentoBusqueda.getAmbito().equals(AMBITO_UNIVERSAL)){
					String[] ambitos = documentoBusqueda.getAmbito();
					ambitosTraducidos = new String[ambitos.length];
					NodoVO[] nodos = this.getSrvNodoService().listarNodos();
					if(nodos!=null){
						for(int j= 0; j<ambitos.length;j++){
							boolean encontrado=false;
							for(int i= 0; i<nodos.length;i++){
								if(nodos[i].getIdNodo().equals(ambitos[j])){
									ambitosTraducidos[j]=nodos[i].getNodo();
									encontrado=true;
								}else if(DependentServerProperties.getInstance().getProperty(IDENTIFICADOR_NODO).equals(ambitos[j])){
									ambitosTraducidos[j]=DependentServerProperties.getInstance().getServerOn();
									encontrado=true;
								}
							}
							if(!encontrado){
								ambitosTraducidos[j]=ambitos[j];
							}
						}
					}
				}
				
				return new MetadatoBasicoVO(documentoBusqueda.getLicencias(),
						documentoBusqueda.getTitulo(),
						documentoBusqueda.getDescripcion(),
						documentoBusqueda.getFormato(),
						documentoBusqueda.getDestinatarios(),
						documentoBusqueda.getIdioma(),
						(ambitosTraducidos!=null)?ambitosTraducidos:documentoBusqueda.getAmbito(),
						documentoBusqueda.getValoracion(),
						documentoBusqueda.getLocalizadorODE(),
						documentoBusqueda.getIdentificadorODE(),
						documentoBusqueda.getImagen(),
						documentoBusqueda.getNivelAgregacion(),
						documentoBusqueda.getTamanio(),
						documentoBusqueda.getConSinSecuencia(),
						documentoBusqueda.getFechaPublicacion(),
						documentoBusqueda.getHoraPublicacion(),
						documentoBusqueda.getSize(),
						array2String(documentoBusqueda.getTipoRecurso(), ","),
						documentoBusqueda.getAnnotation());
			}else{
				logger.error("SrvBuscarServiceImpl - handleSolicitarMetadato:Error buscando metadatos para MEC["+parametros.getIdentificadorODE()+"] en el idioma["+parametros.getIdioma()+"]. No hay resultados disponibles.");
				throw new Exception("SrvBuscarServiceImpl - handleSolicitarMetadato:Error buscando metadatos para MEC["+parametros.getIdentificadorODE()+"] en el idioma["+parametros.getIdioma()+"]. No hay resultados disponibles.");
			}
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("SrvBuscarServiceImpl - handleSolicitarMetadato:Excepcion buscando metadatos para MEC["+parametros.getIdentificadorODE()+"] en el idioma["+parametros.getIdioma()+"].",e);
		}
    }
    /**
	 * @see es.pode.buscar.negocio.servicios.SrvBuscarService#borrarHitCache(String)
	 * @param String Este par�metro contiene el identificador de un registro de la cach�
	 * @return boolean Este par�metro contiene un flag con el resultado de la operaci�n
	 */
	protected boolean handleBorrarHitCache(String hit) throws Exception {
		return cacheConfig.removeHitsCache();
	}
	
    private List<NodoVO> obtenerComunidades(String[] indicesComunidades) throws Exception{
		List<NodoVO> comunidades=new ArrayList<NodoVO>();
   	 	NodoVO nodo= new NodoVO();
   	 	for(int i=0; i<indicesComunidades.length;i++){
   	 		if(!indicesComunidades[i].equals("0")){
		   	 	nodo = this.getSrvNodoService().obtenerNodo(new Long (indicesComunidades[i]));	
		   	 	comunidades.add(nodo);
   	 		}
   	 	}
		return comunidades;
	}
    
	private HitCacheVO creaHitCache(String idBusqueda, String palabrasClave, DocumentosVO resultados) throws java.lang.Exception {
		Date ahora = new Date();
		TaxonVO[] tesauros=null;
		if (resultados.getTesauros()!= null){
			tesauros=resultados.getTesauros();
		}else tesauros=new TaxonVO[0];
			HitCacheVO hitCache = new HitCacheVO(new Long(1),
				palabrasClave,
				new Integer(String.valueOf(resultados.getNumeroResultados())),
				"",
				new Timestamp(ahora.getTime() + Long.parseLong(props.getProperty("segundosCaducidadHit"))),
				new Timestamp(ahora.getTime()),
//				DateManager.timestampToCalendar(new Timestamp(ahora.getTime() + Long.parseLong(props.getProperty("segundosCaducidadHit")))),
//				DateManager.timestampToCalendar(new Timestamp(ahora.getTime())),
				"",
				idBusqueda,mapHitDocVO2ValoresBusquedaVO(resultados.getResultados()),
				new Integer(String.valueOf(resultados.getTotalResultados())),
				resultados.getSugerencias(),
				mapHitTaxonVO2ResultadosTaxonVO(tesauros)
				);
		return hitCache;
	}
	
	private ResultadoBusquedaSQIVO ordenarResultadosSQI(List documentos)
	{
//		TODO: implementar un algoritmo de ordenado. Esta por decidir que algoritmo vamos a utilizar.
		return new ResultadoBusquedaSQIVO((LomEsVO[])documentos.toArray(new LomEsVO[0]),documentos.size());
	}
	
	private DocumentosVO ordenarResultados(List documentos) throws NumberFormatException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - ordenarResultados: Inicio.");
        int totalResultados = 0, numeroResultados = 0, numDocumentosIndice=0;
        HashMap <String,DocVO> eliminarRepetidos = new HashMap<String,DocVO>();
        for(int i=0; i<documentos.size();i++){
        	DocumentosVO doc=(DocumentosVO)documentos.get(i);
        	int resultadosRepetidos=0;
        	//if(documentos.size()==1 || (doc.getResultados()[0].getNodo()==null && resultadoMayor.getResultados()[0].getNodo()==null) || (doc.getResultados()[0].getNodo()==null && resultadoMayor.getResultados()[0].getNodo()!=null) || (doc.getResultados()[0].getNodo()!=null && resultadoMayor.getResultados()[0].getNodo()==null) || !doc.getResultados()[0].getNodo().equals(resultadoMayor.getResultados()[0].getNodo())){
        	DocVO[] resultados = ((DocumentosVO)documentos.get(i)).getResultados();
        	 for(int j=0; (j<resultados.length && resultados[j]!=null);j++){
        		if(eliminarRepetidos.containsKey(resultados[j].getIdentificadorODE())){
					resultadosRepetidos++;
					if(resultados[j].getNodo()==null) eliminarRepetidos.put(resultados[j].getIdentificadorODE(),resultados[j]);
				}else eliminarRepetidos.put(resultados[j].getIdentificadorODE(),resultados[j]);
        	 }
        	totalResultados = totalResultados + doc.getTotalResultados().intValue()-resultadosRepetidos;
			numeroResultados = numeroResultados + doc.getNumeroResultados().intValue()-resultadosRepetidos;
			numDocumentosIndice=numDocumentosIndice+doc.getNumDocumentosIndice();
        }
        List <DocVO>documentosOrdenados = new ArrayList<DocVO>(eliminarRepetidos.values());
        Collections.sort(documentosOrdenados,new DocRankingComparator());
	    DocumentosVO documento= new DocumentosVO();
	    documento.setResultados(documentosOrdenados.toArray(new DocVO[0]));
	    documento.setNumeroResultados(numeroResultados);
	    documento.setNumDocumentosIndice(numDocumentosIndice);
	    documento.setTotalResultados(totalResultados);
	    if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - ordenarResultados: Resultados ordenados");
	    return documento; 
	}

	
	private ResultadoBusquedaVO generaPaginaResultadosRSS(ParametrosBusquedaAvanzadaVO parametros,String idCache, HitCacheVO resultadoCache, ValoresBusquedaVO[] temp) {
    	List <ValoresBusquedaVO>documentosOrdenados = Arrays.asList(temp);
        Collections.sort(documentosOrdenados,new DocFechaPublicacionComparator());
    		ValoresBusquedaVO valoresBusquedaReturn[] = new ValoresBusquedaVO[(parametros.getResultadosPorPagina()>documentosOrdenados.size())?documentosOrdenados.size():parametros.getResultadosPorPagina()];

    		for (int i = 0; i < valoresBusquedaReturn.length; i++) {
    			//    		logger.debug("Empaquetando resulado de cache["+(i+desde)+"] como posicion en la pagina ["+i+"] con contenido?["+(temp[i+desde]!=null)+"].");
    			valoresBusquedaReturn[i] = temp[i];
    			valoresBusquedaReturn[i].setUrlImagen(comprobarImagen(parametros.getComunidadPeticion(),valoresBusquedaReturn[i].getNodo(),valoresBusquedaReturn[i].getUrlImagen()));
    			//valoresBusquedaReturn[i].setUrlImagen(valoresBusquedaReturn[i].getUrlImagen());
    		}
    		if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - generaPaginaResultadosBusquedaRSS: Devolvemos ["+valoresBusquedaReturn.length+"] resultados correspondientes a la b�squeda RSS con idBusqueda["+idCache+"]");
    		return new ResultadoBusquedaVO(valoresBusquedaReturn,
    				resultadoCache.getSugerencias(), 
    				new Integer(String.valueOf(resultadoCache.getNumeroResultados())), 
    				resultadoCache.getIdCache(),
    				new Integer(String.valueOf(resultadoCache.getTotalResultados())),
    				resultadoCache.getTesauros()
    				);
    }
	
	private ResultadoBusquedaVO generaPaginaResultadosBusqueda(ParametrosBusquedaAvanzadaVO parametros, String idCache, HitCacheVO resultadoCache, ValoresBusquedaVO[] temp) {		
		int pagina = parametros.getOrigenPagina();
		if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - generaPaginaResultadosBusqueda:Paginamos ["+resultadoCache.getResultadoBusquedaWeb().length+"] resultados de cache sobre la pagina ["+pagina+"] con idBusqueda["+idCache+"] con ["+parametros.getResultadosPorPagina()+"] resultados por pagina.");
		int desde;
		int hasta;
		//    	Tenemos que tener cuidaddo con la siguiente situacion: un usuario busca X y quiere la pagina n. Pasado el rato
		//    	(en el que caduca su busqueda) el usuario pulsa la pagina n+1, eso dispara una nueva busqueda, y puede que se
		//    	hayan modificado el numero de resultados posibles con lo que puede que la pagina que se requiere ya no sea
		//    	disponible, con lo que hay que tener cuidado con los extremos.
		int paginasTotal = temp.length / parametros.getResultadosPorPagina();
		if ((temp.length % parametros.getResultadosPorPagina()) > 0) // Hay resto de dividir entre los resultados por pagina, hay una pagina no completa mas
			paginasTotal++;
		if (pagina > paginasTotal) // Si me piden una pagina que se sale del rango maximo, le doy la ultima pagina
			pagina = paginasTotal;
		else if (pagina < 1) // Si me piden una pagina ilegal, muestro la primera
			pagina = 1;

		if (pagina == 1) {  // me piden la primera pagina
			desde = 0;
			hasta = (parametros.getResultadosPorPagina() > temp.length) ? temp.length - 1
					: parametros.getResultadosPorPagina() - 1;
		} else if (pagina == paginasTotal) { // me piden la ultima pagina
			hasta = temp.length - 1;
			desde = (parametros.getResultadosPorPagina() * (pagina - 1));
		} else { // me piden una pagina intermedia
			desde = parametros.getResultadosPorPagina() * (pagina - 1);
			hasta = parametros.getResultadosPorPagina() * pagina - 1;
		}
		//    	logger.debug("Devolvemos ["+(hasta-desde+1)+"] valores de cache sobre la pagina ["+pagina+"] con idBusqueda["+idCache+"] desde el hit ["+desde+"] hasta el hit["+hasta+"].");
		ValoresBusquedaVO valoresBusquedaReturn[] = new ValoresBusquedaVO[hasta- desde + 1];

		for (int i = 0; i < valoresBusquedaReturn.length; i++) {
			//    		logger.debug("Empaquetando resulado de cache["+(i+desde)+"] como posicion en la pagina ["+i+"] con contenido?["+(temp[i+desde]!=null)+"].");
			valoresBusquedaReturn[i] = temp[i+desde];
			valoresBusquedaReturn[i].setUrlImagen(comprobarImagen(parametros.getComunidadPeticion(),valoresBusquedaReturn[i].getNodo(),valoresBusquedaReturn[i].getUrlImagen()));
			//valoresBusquedaReturn[i].setUrlImagen(valoresBusquedaReturn[i].getUrlImagen());
		}
		if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - generaPaginaResultadosBusqueda: Devolvemos ["+(hasta-desde+1)+"] resultados correspondientes a la pagina ["+pagina+"] con idBusqueda["+idCache+"]");
		return new ResultadoBusquedaVO(valoresBusquedaReturn,
				resultadoCache.getSugerencias(), 
				new Integer(String.valueOf(resultadoCache.getNumeroResultados())), 
				resultadoCache.getIdCache(),
				new Integer(String.valueOf(resultadoCache.getTotalResultados())),
				resultadoCache.getTesauros()
				);
	}

	private ResultadoBusquedaSQIVO generaPaginaResultadosBusquedaSQI(ResultadoBusquedaSQIVO resultadoCache, int pagina, int resPorPagina) {		
		if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - generaPaginaResultadosBusquedaSQI:Paginamos ["+resultadoCache.getResultadoBusqueda().length+"] resultados de cache sobre la pagina ["+pagina+"] con ["+resPorPagina+"] resultados por pagina.");
		int desde;
		int hasta;
		//    	Tenemos que tener cuidaddo con la siguiente situacion: un usuario busca X y quiere la pagina n. Pasado el rato
		//    	(en el que caduca su busqueda) el usuario pulsa la pagina n+1, eso dispara una nueva busqueda, y puede que se
		//    	hayan modificado el numero de resultados posibles con lo que puede que la pagina que se requiere ya no sea
		//    	disponible, con lo que hay que tener cuidado con los extremos.
		int paginasTotal = resultadoCache.getResultadoBusqueda().length / resPorPagina;
		if ((resultadoCache.getResultadoBusqueda().length % resPorPagina) > 0) // Hay resto de dividir entre los resultados por pagina, hay una pagina no completa mas
			paginasTotal++;
		if (pagina > paginasTotal) // Si me piden una pagina que se sale del rango maximo, le doy la ultima pagina
			pagina = paginasTotal;
		else if (pagina < 1) // Si me piden una pagina ilegal, muestro la primera
			pagina = 1;

		if (pagina == 1) {  // me piden la primera pagina
			desde = 0;
			hasta = (resPorPagina > resultadoCache.getResultadoBusqueda().length) ? resultadoCache.getResultadoBusqueda().length - 1
					: resPorPagina - 1;
		} else if (pagina == paginasTotal) { // me piden la ultima pagina
			hasta = resultadoCache.getResultadoBusqueda().length - 1;
			desde = (resPorPagina * (pagina - 1));
		} else { // me piden una pagina intermedia
			desde = resPorPagina * (pagina - 1);
			hasta = resPorPagina * pagina - 1;
		}
		//    	logger.debug("Devolvemos ["+(hasta-desde+1)+"] valores de cache sobre la pagina ["+pagina+"] con idBusqueda["+idCache+"] desde el hit ["+desde+"] hasta el hit["+hasta+"].");
		LomEsVO[] valoresBusquedaReturn = new LomEsVO[hasta- desde + 1];

		for (int i = 0; i < valoresBusquedaReturn.length; i++) {
			//    		logger.debug("Empaquetando resulado de cache["+(i+desde)+"] como posicion en la pagina ["+i+"] con contenido?["+(temp[i+desde]!=null)+"].");
			valoresBusquedaReturn[i] = resultadoCache.getResultadoBusqueda()[i+desde];
		}
		if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - generaPaginaResultadosBusqueda: Devolvemos ["+(hasta-desde+1)+"] resultados correspondientes a la pagina ["+pagina+"]");
		return new ResultadoBusquedaSQIVO(valoresBusquedaReturn,
				resultadoCache.getResultadoBusqueda().length);
	}
	
	private ResultadosTaxonVO[] mapHitTaxonVO2ResultadosTaxonVO(TaxonVO[] temp){
		if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - mapHitTaxonVO2ResultadosTaxonVO: Inicio.");
		ResultadosTaxonVO[] actual = new ResultadosTaxonVO[temp.length];
//		Mapeamos con Dozer
		for(int i=0; i < temp.length;i++){
			if(temp[i]!=null){
				ResultadosTaxonVO actualVO = new ResultadosTaxonVO();
				this.getBeanMapper().map(temp[i], actualVO);
				actualVO.setIdentificador(temp[i].getIdentificador());
				actualVO.setNombre(temp[i].getNombre());
				actual[i]=actualVO;
			}
		}
		return actual;
	}
	
	
	private ValoresBusquedaVO[] mapHitDocVO2ValoresBusquedaVO(DocVO[] temp){
		if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - mapHitDocVO2ValoresBusquedaVO: Inicio.");
		ValoresBusquedaVO[] actual = new ValoresBusquedaVO[temp.length];
//		Mapeamos con Dozer
		for(int i=0; i < temp.length;i++){
			ValoresBusquedaVO actualVO = new ValoresBusquedaVO();
			this.getBeanMapper().map(temp[i], actualVO);
			actualVO.setId(temp[i].getIdentificadorODE());
			actualVO.setUrlImagen(temp[i].getImagen());
			actualVO.setNodo(temp[i].getNodo());
			actualVO.setArbolCurricularVigente(temp[i].getArbolCurricularVigente());
			actualVO.setFormato(temp[i].getFormato());
			actualVO.setNivelAgregacion(temp[i].getNivelAgregacion());
			actualVO.setAmbito(temp[i].getAmbito());
			actualVO.setFechaPublicacion(temp[i].getFechaPublicacion());
			actualVO.setHoraPublicacion(temp[i].getHoraPublicacion());
			actualVO.setDescripcion(temp[i].getDescripcion());
			actualVO.setSize(temp[i].getSize());
			actualVO.setContentProviders(temp[i].getContentProviders());
			actual[i]=actualVO;
		}
		return actual;
	}

	private DocVO[] mapValoresBusquedaVO2DocVO(ValoresBusquedaVO[] temp){
		if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - mapValoresBusquedaVO2DocVO: Inicio.");
		DocVO[] actual = new DocVO[temp.length];
//		Mapeamos con Dozer
		for(int i=0; i < temp.length;i++){
			DocVO actualVO = new DocVO();
			this.getBeanMapper().map(temp[i], actualVO);
			actualVO.setIdentificadorODE(temp[i].getId());
			actualVO.setImagen(temp[i].getUrlImagen());
			actualVO.setNodo(temp[i].getNodo());
			actualVO.setArbolCurricularVigente(temp[i].getArbolCurricularVigente());
			actualVO.setFormato(temp[i].getFormato());
			actualVO.setNivelAgregacion(temp[i].getNivelAgregacion());
			actualVO.setAmbito(temp[i].getAmbito());
			actualVO.setFechaPublicacion(temp[i].getFechaPublicacion());
			actualVO.setHoraPublicacion(temp[i].getHoraPublicacion());
			actualVO.setDescripcion(temp[i].getDescripcion());
            actualVO.setSize(temp[i].getSize());
            actualVO.setContentProviders(temp[i].getContentProviders());
			actual[i]=actualVO;
		}
		return actual;
	}
	
	
	private boolean exists (String word, String pattern){
		return (word.indexOf(pattern) != -1);
	}
	
	private String replaceWords (String palabrasClave, char sustituir, char sustitucion){

		while (this.exists(palabrasClave, String.valueOf(sustituir))){
			palabrasClave=palabrasClave.replace(sustituir,sustitucion);
		}
		return palabrasClave;
	}
	
	
	private List obtenerPalabrasClave (String palabrasClave){
		if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - obtenerPalabrasClave: Inicio.");
//		quito las " y + y los reemplazo por espacios en blanco
		String palabrasClaveLimp = this.replaceWords(palabrasClave, COMILLAS, ESPACIO_BLANCO);
		String palabrasClaveLimpias = this.replaceWords(palabrasClaveLimp, SUMAS, ESPACIO_BLANCO);
//		obtengo un array de palabras y espacios en blanco
		String [] palabrasYBlancos = palabrasClaveLimpias.trim().split(String.valueOf(ESPACIO_BLANCO));
//		elimino palabras con ?, *, y los espacios en blanco
		List palabrasTesauro = new ArrayList();
		for (int i=0;i<palabrasYBlancos.length;i++){
			if ((!palabrasYBlancos[i].equals(String.valueOf(ESPACIO_BLANCO))) && (!this.exists(palabrasYBlancos[i], ASTERISCO)) && (!this.exists(palabrasYBlancos[i], INTERROGACION))){
				palabrasTesauro.add(palabrasYBlancos[i]);
			}
		}
		return palabrasTesauro;
	}

	private String array2String(String[] array) {
		return array2String(array, "");
	}
	
	private String array2String(String arr[], String sep) {
		return StringUtils.join(arr, sep);
	}
	
	private String comprobarImagen(String servidorLocal, String servidorRemoto, String imagen){
		String servidor="";
		try{
			InputStreamReader in = null;
			if(servidorRemoto!=null)servidor=servidorRemoto;
			else if(servidorLocal!=null)servidor=servidorLocal+LdapUserDetailsUtils.getSubdominio();
			else  servidor=LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio();
			in = new InputStreamReader(new URL("http://"+servidor+imagen).openStream());
			return imagen;
		}catch(Exception ex){
			if (logger.isDebugEnabled())logger.debug("SrvBuscarServiceImpl - comprobarImagen=http://"+servidor+imagen);
			return "/"+AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.URL_IMAGEN_DEFECTO_100x100);
		}
	}
}