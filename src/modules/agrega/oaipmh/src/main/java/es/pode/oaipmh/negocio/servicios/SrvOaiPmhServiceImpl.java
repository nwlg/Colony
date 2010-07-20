/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.oaipmh.negocio.servicios;



import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.log4j.Logger;

import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.indexador.negocio.servicios.busqueda.ParamPeriodoRepositorioVO;
import es.pode.oaipmh.negocio.resumptionToken.ResumptionTokenManager;
import es.pode.oaipmh.soporte.OAIPMHProperties;
import es.pode.soporte.validador.ValidadorMEC;
import es.agrega.soporte.agregaProperties.AgregaProperties;


/**
 * @see es.pode.oaipmh.negocio.servicios.SrvOaiPmhService
 */

public class SrvOaiPmhServiceImpl
    extends es.pode.oaipmh.negocio.servicios.SrvOaiPmhServiceBase
{

	private static Logger logger = Logger.getLogger(SrvOaiPmhServiceImpl.class);
	
	private static final String PROTOCOLO_HTTP = "protocoloHttp";
	private static final String BUSCADOR_FICHA = "buscadorFicha";
	private static final String INTERROGACION = "interrogacion";
	private static final String IGUAL = "igual";
	private static final String AMPERSAND = "ampersand";
	private static final String PARAMETRO_IDIOMA = "parametroIdioma";	
	private static final String PARAMETRO_ID_ODE = "parametroIdentificadorODE";
	private static final String KEY_HOST_NODO = "host";
	
	public static final String FROM = "From";
	public static final String TO = "to";
	public static final String GUION = "-";
	public static final String DOS_PUNTOS = ":";
	
	public static final String BARRA = "barra";
	
	public static final int numMaxPaginaInt = OAIPMHProperties.numMaxPaginaInt;	
	
	
	private Properties props = null;
	private CacheManager cacheManager;
	private Cache cacheHeaders;	
	private Cache cacheRecords;	
	
	private static ResumptionTokenManager resumptionToken = null;
	
	
	public CacheManager getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}
	
	public Cache getCacheHeaders() {
		return cacheHeaders;
	}

	public void setCacheHeaders(Cache cacheHeaders) {
		this.cacheHeaders = cacheHeaders;
	}
	
	public Cache getCacheRecords() {
		return cacheRecords;
	}

	public void setCacheRecords(Cache cacheRecords) {
		this.cacheRecords = cacheRecords;
	}
	
	public SrvOaiPmhServiceImpl()
	{
		InputStream is = null;
		
		if (resumptionToken == null) resumptionToken = new ResumptionTokenManager();
		
		try {
	//		Configuramos la clase de propiedades
			is = this.getClass().getResourceAsStream("/oaiPmh.properties");
			props = new Properties();
			props.load(is);
	//		Configuramos la cache de headers
			cacheManager= CacheManager.create();
			cacheHeaders = new Cache("cacheHeaders", //name
					100, //maxElementsInMemory
					false, //overflowToDisk
					false, //eternal
					new Long(props.getProperty("segundosCaducidad")).longValue(),//tiempo de vida de los elementos en la cache
					new Long(props.getProperty("segundosCaducidad")).longValue());//tiempo de vida de los elementos desde su ultimo acceso o su ultima modificacion
			cacheManager.addCache(cacheHeaders);
			
//			Configuramos la cache de records
			cacheManager= CacheManager.create();
			cacheRecords = new Cache("cacheRecords", //name
					100, //maxElementsInMemory
					false, //overflowToDisk
					false, //eternal
					new Long(props.getProperty("segundosCaducidad")).longValue(),//tiempo de vida de los elementos en la cache
					new Long(props.getProperty("segundosCaducidad")).longValue());//tiempo de vida de los elementos desde su ultimo acceso o su ultima modificacion
			cacheManager.addCache(cacheRecords);
			
		} catch (IOException e) {
			logger.error("ERROR: Accediendo a la cache manager",e);
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
	
	/**
     * Obtiene información sobre el repositorio      
     * @return ResultadoOaiRequestVo: vo de retorno que es este caso contendra relleno el vo de identify
     * @throws Exception
     * 
     */
    protected es.pode.oaipmh.negocio.servicios.ResultadoOAIRequest handleIdentify()
        throws java.lang.Exception
    {    	
    	
    	logger.debug("IDENTIFY");      	
    	
    	/**
    	 * -------------------------------------------------------------------------
    	 * --------------------DECLARACION DE VARIABLES-----------------------------
    	 * -------------------------------------------------------------------------
    	 * */    			
		IdentifyVO identify = new IdentifyVO();
		DescripcionOaiIdentifierVO descripcionOaiIdentifier = new DescripcionOaiIdentifierVO(); 
    	
    	try{
	    		    	
	    	/**
	    	 * -------------------------------------------------------------------------
	    	 * -------------------- SE RELLENA IDENTIFYVO ------------------------------
	    	 * -------------------------------------------------------------------------
	    	 * */
    			logger.debug("handleIdentify-- Se rellena el vo de identify");
    			
				//Nombre del repositorio
				identify.setNombreRepositorio(AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.NOMBRE_REPOSITORIO));
				if (logger.isDebugEnabled()) logger.debug("handleIdentify-- El valor del nombre del repositorio introducido es ["+identify.getNombreRepositorio()+"]");
				
				//Url del repositorio
				identify.setUrlRepositorio(AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.URL_REPOSITORIO_AGREGA));
				if (logger.isDebugEnabled()) logger.debug("handleIdentify-- El valor de la url del repositorio introducido es ["+identify.getUrlRepositorio()+"]");
				
				//Version del protocolo
				identify.setVersionProtocolo(OAIPMHProperties.getPropertyValue(OAIPMHProperties.KEY_VERSION_PROTOCOLO));
				if (logger.isDebugEnabled()) logger.debug("handleIdentify-- El valor de la version del repositorio introducido es ["+identify.getVersionProtocolo()+"]");
				
//				Email admin
				identify.setEmailAdmin(AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.EMAIL_ADMIN_REPOSITORIO));
					
				if (logger.isDebugEnabled()) logger.debug("handleIdentify-- El valor del emailAdmin del repositorio introducido es ["+identify.getEmailAdmin()+"]");
				
				//Fecha inicio del repositorio
				Calendar fechaInicioRepo = null; 
				try
				{
					logger.debug("handleIdentify-- Se llama al indexador para obtener la fecha inicio del repositorio");
					fechaInicioRepo = this.getSrvBuscadorService().fechaInicioRepositorio();
					
				} catch (Exception e)
				{					
					logger.error("handleIdentify-- Error recuperando la fecha de inicio del repositorio del indexador",e);	
					//Se rellena el resultadoOaiRequestVO
					return devuelveResultadoOaiRequest(OAIPMHProperties.ERR_ERROR_GENERICO, OAIPMHProperties.ERR_ERROR_GENERICO_DES, 
												null, null, OAIPMHProperties.VERB_IDENTIFY);
				}
				identify.setFechaInicioRepositorio(devuelveFechaStringFromCalendar(fechaInicioRepo));				
				if (logger.isDebugEnabled()) logger.debug("handleIdentify-- El valor de la fecha de inicio del repositorio introducido es ["+identify.getFechaInicioRepositorio()+"]");
				
				//Politica de borrado
				identify.setPoliticaBorrado(OAIPMHProperties.getPropertyValue(OAIPMHProperties.KEY_POLITICA_BORRADO));
				if (logger.isDebugEnabled()) logger.debug("handleIdentify-- El valor de la politica de borrado del repositorio introducido es ["+identify.getPoliticaBorrado()+"]");
				
								
				//Temporalidad
				identify.setTemporalidad(OAIPMHProperties.getPropertyValue(OAIPMHProperties.KEY_GRANULARIDAD));
				if (logger.isDebugEnabled()) logger.debug("handleIdentify-- El valor de la temporalidad del repositorio introducido es ["+identify.getTemporalidad()+"]");
				
				//Descripcion del identificador OAI
				descripcionOaiIdentifier.setEsquema(OAIPMHProperties.eschemaIdentifier());
				if (logger.isDebugEnabled()) logger.debug("handleIdentify-- Descripcion OAI-identifier. El valor del esquema del identificador OAI es ["+descripcionOaiIdentifier.getEsquema()+"]");				
				descripcionOaiIdentifier.setIdentificadorRepositorio(OAIPMHProperties.namespaceIdentifier());
				if (logger.isDebugEnabled()) logger.debug("handleIdentify-- Descripcion OAI-identifier. El valor del identificador del repositorio del identificador OAI es ["+descripcionOaiIdentifier.getIdentificadorRepositorio()+"]");				
				descripcionOaiIdentifier.setDelimitador(this.DOS_PUNTOS);
				if (logger.isDebugEnabled()) logger.debug("handleIdentify-- Descripcion OAI-identifier. El valor del delimitador del identificador OAI es ["+descripcionOaiIdentifier.getDelimitador()+"]");
				descripcionOaiIdentifier.setEjemploIdentificador(OAIPMHProperties.getPropertyValue(OAIPMHProperties.KEY_EJEMPLO_IDENTIFIER_OAI));
				if (logger.isDebugEnabled()) logger.debug("handleIdentify-- Descripcion OAI-identifier. El valor del ejemplo del identificador OAI es ["+descripcionOaiIdentifier.getEjemploIdentificador()+"]");
				identify.setDescripcionOaiIdentifier(descripcionOaiIdentifier);
				
				/**
		    	 * -------------------------------------------------------------------------
		    	 * -------------------- SE RELLENA EL VO DE RETORNO ------------------------
		    	 * -------------------------- Y SE DEVUELVE --------------------------------
		    	 * */
				if (logger.isDebugEnabled()) logger.debug("handleIdentify-- Se rellena el vo de retorno con los valores: IdentifyVO:["+identify+"], " +
						"codigo de error ["+null+"] en el verbo ["+OAIPMHProperties.VERB_IDENTIFY+"]");				
				return devuelveResultadoOaiRequest(null, null, 
						identify, null, OAIPMHProperties.VERB_IDENTIFY);			
    	} catch (Exception e)
    	{    		
			logger.error("handleIdentify-- Error recuperando los datos del repositorio",e);
//			Se rellena el resultadoOaiRequestVO
			return devuelveResultadoOaiRequest(OAIPMHProperties.ERR_ERROR_GENERICO, OAIPMHProperties.ERR_ERROR_GENERICO_DES, 
										null, null, OAIPMHProperties.VERB_IDENTIFY);
    	}		
    }

    /**
     * Obtiene el listado de los headers que existen en el repositorio
     * @param ParametrosOaiPmhVO: vo que contiene los parametros de busqueda 
     * @param 	prefijoMetadato     
     * @return ResultadoOaiRequestVo: vo de retorno que es este caso contendra relleno el vo de listIdentfiers
     * @throws Exception
     * 
     */
    protected es.pode.oaipmh.negocio.servicios.ResultadoOAIRequest handleListIdentifiers(es.pode.oaipmh.negocio.servicios.ParametrosOaiPmhVO parametroLlamada)
        throws java.lang.Exception
    {
    	logger.debug("LISTIDENTIFIERS");   	
    	
    	/**
    	 * -------------------------------------------------------------------------
    	 * --------------------DECLARACION DE VARIABLES-----------------------------
    	 * -------------------------------------------------------------------------
    	 * */    		
		ParamPeriodoRepositorioVO paramBusq = new ParamPeriodoRepositorioVO();	
		es.pode.oaipmh.negocio.servicios.ResultadoHeaderVO[] listIdentifiers = null;
		es.pode.indexador.negocio.servicios.busqueda.ResultadoHeaderVO[] resultadosHeaderRetorno = null;
		ArrayList resultadoHeaderAux = new ArrayList();		
		ReanudacionTokenVO token = new ReanudacionTokenVO();

		/**
    	 * -------------------------------------------------------------------------
    	 * ------ COMPROBAMOS SI EL REPOSITORIO ADMITE ESE METADATAPREFIX ----------
    	 * ----------------- PARAMETRO REQUERIDO POR EL PROTOCOLO-------------------
    	 * -------------------------------------------------------------------------
    	 * */
		logger.debug("parametroLlamada.getCodigoPaginacion() "+parametroLlamada.getCodigoPaginacion()+"zz");
		if((parametroLlamada.getCodigoPaginacion() == null)||(parametroLlamada.getCodigoPaginacion() == ""))
		{
			if (!OAIPMHProperties.esFormatoMetadatoAdmitido(parametroLlamada.getPrefijoMetadato()))
			{
				if (logger.isDebugEnabled()) logger.debug("handleListIdentifiers-- El metadataPrefix ["+parametroLlamada.getPrefijoMetadato()+"] no esta admitido en el repositorio");
				//			Se rellena el resultadoOaiRequestVO
				return devuelveResultadoOaiRequest(OAIPMHProperties.ERR_CAN_NOT_DISEMINATE_FORMAT, OAIPMHProperties.ERR_CAN_NOT_DISEMINATE_FORMAT_DES, 
										null, null, OAIPMHProperties.VERB_LIST_IDENTIFIERS);
			}
		}
		
		/**
    	 * -------------------------------------------------------------------------
    	 * --------------- COMPROBAMOS SI EL REPOSITORIO ADMITE SET ----------------
    	 * -------------------------------------------------------------------------
    	 * */  
    	
		if(parametroLlamada.getIdentificadorConjunto()!=null && !parametroLlamada.getIdentificadorConjunto().equals(""))				
		{
			if(!OAIPMHProperties.repositorioAdmiteSets())
			{
	    		logger.debug("handleListIdentifiers-- Sets no estan admitidos en el repositorio");	
//	    		Se rellena el resultadoOaiRequestVO
	    		return devuelveResultadoOaiRequest(OAIPMHProperties.ERR_NO_SET_HIERARCHY, OAIPMHProperties.ERR_NO_SET_HIERARCHY_DES, 
	    									null, null, OAIPMHProperties.VERB_LIST_IDENTIFIERS);				
			}
    		
    	}    	
		
		/**
    	 * -------------------------------------------------------------------------
    	 * -------------TRATAMIENTO DE LA FECHADESDE Y FECHAHASTA-------------------
    	 * ---------------------- PARAMETROS OPCIONALES ----------------------------
    	 * -------------------------------------------------------------------------
    	 * */ 
		
			tratamientoFechaDesdeHasta(parametroLlamada.getFechaDesde(), (parametroLlamada.getFechaHasta()), paramBusq);    	
    	
    	/**
    	 * -------------------------------------------------------------------------
    	 * ------------------- COMPROBAMOS EL RESUMPTION TOKEN ---------------------
    	 * -------------------------------------------------------------------------
    	 * */ 
    	String idResumptionToken = parametroLlamada.getCodigoPaginacion();
    	if(idResumptionToken != null && !"".equals(idResumptionToken))
    	{    		
//    		 Vamos a comprobar a la cache si esta el identificador 
    		Element elemento = resumptionToken.devuelveElementoResumptionToken(idResumptionToken);
    		   		
    		if(elemento != null)
    		{
    			//El identificador se encontro en la cache    			
    			//Buscamos en la cache de resumptionToken el vo de resumptioTokenCacheHit    			
    			ResumptionTokenCacheHit vueltaCacheToken = (ResumptionTokenCacheHit)elemento.getObjectValue();
    			
    			//Se traen los resultados cacheados
    			String claveHeaders = vueltaCacheToken.getIdQuery();
    			if (logger.isDebugEnabled()) logger.debug("handleListIdentifiers-- El valor de la clave de headers es ["+claveHeaders+"]");    			
    			Element elementoCacheHeaders = this.getCacheHeaders().get(claveHeaders);    			
    			es.pode.indexador.negocio.servicios.busqueda.ResultadoHeaderVO[] resultadoHeader = (es.pode.indexador.negocio.servicios.busqueda.ResultadoHeaderVO[])elementoCacheHeaders.getObjectValue();
    			if (logger.isDebugEnabled()) logger.debug("handleListIdentifiers-- El numero de resultados traidos por la cache de headers es ["+resultadoHeader.length+"]");
    			
    			//Se obtienen los resultados a entregar con los parametros de vueltaCacheToken 
    			Integer desdeToken = vueltaCacheToken.getDesde();
    			Integer hastaToken = vueltaCacheToken.getHasta();    			
    			for (int j = desdeToken.intValue(); j <= hastaToken.intValue() && j < resultadoHeader.length; j++)    			
    				resultadoHeaderAux.add(resultadoHeader[j]);
    			
    			resultadosHeaderRetorno = (es.pode.indexador.negocio.servicios.busqueda.ResultadoHeaderVO[])resultadoHeaderAux.toArray(new es.pode.indexador.negocio.servicios.busqueda.ResultadoHeaderVO[0]);
				if (logger.isDebugEnabled()) logger.debug("handleListIdentifiers-- El numero de resultados que se retornan es ["+resultadosHeaderRetorno+"]");
    			
    			//Se llama a generar el nuevo ResumptionToken si hiciera falta
    			ResumptionTokenCacheHit tokenCacheHit = resumptionToken.generateNextResumptionToken(vueltaCacheToken, new Integer(resultadoHeader.length));    			   
    			token = devuelveReanudacionToken(tokenCacheHit, null, desdeToken, resultadoHeader.length, true);
    		}
    		else
    		{
    			//El identificador no se encontro en la cache.
    			logger.debug("handleListIdentifiers-- El identificador del resumptionToken es incorrecto");	
//    			Se rellena el resultadoOaiRequestVO
    			return devuelveResultadoOaiRequest(OAIPMHProperties.ERR_BAD_RESUMPTION_TOK, OAIPMHProperties.ERR_BAD_RESUMPTION_TOK_DES, 
    											   null, null, OAIPMHProperties.VERB_LIST_IDENTIFIERS);    			
    		}

    	}else
    	{ 	
    		logger.debug("Es la primera vez que se ejecuta esa query");
			/*
	    	 * -------------------------------------------------------------------------
	    	 * -------------LLAMAMOS AL INDEXADOR PARA OBTENER EL VO -------------------
	    	 * -------------------------------------------------------------------------
	    	 * */ 		
			es.pode.indexador.negocio.servicios.busqueda.ResultadoHeaderVO[] resultadoHeader = null;			
			
			try
			{
				if (logger.isDebugEnabled()) logger.debug("handleListIdentifiers-- Llamamos al indexador con los parametros: desde ["+paramBusq.getDesde()+"] y hasta ["+paramBusq.getHasta()+"]");
				resultadoHeader = this.getSrvBuscadorService().busquedaHeadersRepositorio(paramBusq);
				if (logger.isDebugEnabled()) logger.debug("handleListIdentifiers-- El tamanho del array resultadoHeader es ["+resultadoHeader.length+"]");
				
				//Se comprueba que la vuelta del indexador es correcta
				if(resultadoHeader == null || resultadoHeader.length == 0)
				{
					logger.debug("handleListIdentifiers-- No se ha podido encontrar ningun header con fechaDesde ["+paramBusq.getDesde()+"] y fechaHasta ["+paramBusq.getHasta()+"]");
//					Se rellena el resultadoOaiRequestVO
					return devuelveResultadoOaiRequest(OAIPMHProperties.ERR_NO_RECORDS_MATCH, OAIPMHProperties.ERR_NO_RECORDS_MATCH_DES, 
												       null, null, OAIPMHProperties.VERB_LIST_IDENTIFIERS);					
				}
				else
				{
					//Se encontraron resultados. Se guardan en la cache de headers				
					String clave = generaClaveDatos(parametroLlamada);
					if (logger.isDebugEnabled()) logger.debug("handleListIdentifiers-- Se encontraron resultados. Se introducen en la cache de headers con clave ["+clave+"]");
					this.getCacheHeaders().put(new Element(clave,resultadoHeader));			
					
					
					//Se prepara los resultados de vuelta y se retornan 
					for (int l = 0; l < numMaxPaginaInt && l < resultadoHeader.length; l++)				
						resultadoHeaderAux.add(resultadoHeader[l]);					
					
					if (logger.isDebugEnabled()) logger.debug("handleListIdentifiers-- El objeto resultadoHeaderRetorno ["+resultadosHeaderRetorno+"]");
					resultadosHeaderRetorno = (es.pode.indexador.negocio.servicios.busqueda.ResultadoHeaderVO[])resultadoHeaderAux.toArray(new es.pode.indexador.negocio.servicios.busqueda.ResultadoHeaderVO[0]);
					if (logger.isDebugEnabled()) logger.debug("handleListIdentifiers-- El numero de resultados que se retornan en la pagina 1 es ["+resultadosHeaderRetorno+"]");
										
//					Se pagina los resultados						
					if (logger.isDebugEnabled()) logger.debug("handleListIdentifiers-- El numero de resultados es ["+resultadoHeader.length+"]");
					if (logger.isDebugEnabled()) logger.debug("handleListIdentifiers-- El numero maximo de resultados por pagina es ["+numMaxPaginaInt+"]");
					
					token = devuelveReanudacionToken(null, clave, null, resultadoHeader.length, false);
					
				}
				
			} catch (Exception e)
			{
				pintarTrazasListIdentifiers(resultadoHeader);				
				logger.error("handleListIdentifiers-- Error recuperando el vo del doc ["+resultadoHeader+"] del servicio de indexacion con tamanho ["+resultadoHeader.length+"]",e);
//				Se rellena el resultadoOaiRequestVO
				return devuelveResultadoOaiRequest(OAIPMHProperties.ERR_ERROR_GENERICO, OAIPMHProperties.ERR_ERROR_GENERICO_DES, 
												   null, null, OAIPMHProperties.VERB_LIST_IDENTIFIERS);				
			}
    	}
		//Pintamos las trazas de la vuelta del indexador
		pintarTrazasListIdentifiers(resultadosHeaderRetorno);
		 
		/**
    	 * -----------------------------------------------------------------------------------
    	 * - REALIZAMOS EL MAPEO DE RESULTADOHEADERVO (INDEXADOR) A RESULTADOHEADER VO (OAI)--
    	 * -----------------------------------------------------------------------------------
    	 * */
		listIdentifiers = mapeoHeaderVO(resultadosHeaderRetorno);	
		if (logger.isDebugEnabled()) logger.debug("handleListIdentifiers-- listIdentifiers ["+listIdentifiers+"] con tamanho ["+listIdentifiers.length+"]");
				
//		Se rellena el resultadoOaiRequestVO
		return devuelveResultadoOaiRequest(null, null, 
										   listIdentifiers, token, OAIPMHProperties.VERB_LIST_IDENTIFIERS);		
    }

    /**
     * Obtiene el listado de los formatos de metadatos que existen en el repositorio
     * @param ParametrosOaiPmhVO: vo que contiene los parametros de busqueda      
     * @return ResultadoOaiRequestVo: vo de retorno que es este caso contendra relleno el vo de listMetadataFormat
     * @throws Exception
     * 
     */
    protected es.pode.oaipmh.negocio.servicios.ResultadoOAIRequest handleListMetadataFormat(es.pode.oaipmh.negocio.servicios.ParametrosOaiPmhVO parametrosLlamada)
        throws java.lang.Exception
    {
    	logger.debug("LISTMETADATAFORMAT");      	
    	
    	/**
    	 * -------------------------------------------------------------------------
    	 * ------ COMPROBAMOS SI EL REPOSITORIO ADMITE ESE IDENTIFICADOR -----------
    	 * ------------------------ PARAMETRO OPCIONAL -----------------------------
    	 * -------------------------------------------------------------------------
    	 * */ 
    	if(parametrosLlamada.getIdentificador() != null && !parametrosLlamada.getIdentificador().equals(""))
    	{
			if (!validateIdentifier(parametrosLlamada.getIdentificador()))
			{
				if (logger.isDebugEnabled()) logger.debug("handleListMetadataFormat-- El identificador ["+parametrosLlamada.getIdentificador()+"] no esta admitido en repositorio");
//				Se rellena el resultadoOaiRequestVO
				return devuelveResultadoOaiRequest(OAIPMHProperties.ERR_ID_DOES_NOT_EXIST, OAIPMHProperties.ERR_ID_DOES_NOT_EXIST_DES, 
								                   null, null, OAIPMHProperties.VERB_LIST_METADATA_FORMATS);				
			} 
    	}
		
		/**
    	 * -------------------------------------------------------------------------
    	 * -----------OBTENEMOS LA LISTA DE FORMATOS DEL REPOSITORIO----------------
    	 * -------------------------------------------------------------------------
    	 * */ 
        try{
	        
        	//Obtenemos el numero de metatada format que existen en el repositorio
	        ListMetadataFormatVO[] listMetadataFormat = new ListMetadataFormatVO[OAIPMHProperties.devuelveNumMetadataFormat()];        	
	        if (logger.isDebugEnabled()) logger.debug("handleListMetadataFormat-- El tamanho del array lostMetadataFormat es ["+listMetadataFormat.length+"]");
	        for (int j = 0; j < listMetadataFormat.length; j++)
	        {
	        	ListMetadataFormatVO metadataFormat = new ListMetadataFormatVO();
		        	metadataFormat.setNombreMetadato(OAIPMHProperties.getPropertyValue(OAIPMHProperties.KEY_METADATOS));
		        	metadataFormat.setEspacioNombres(OAIPMHProperties.namespaceMetadato(OAIPMHProperties.getPropertyValue(OAIPMHProperties.KEY_METADATOS)));
		        	metadataFormat.setEsquema(OAIPMHProperties.esquemaMetadato(OAIPMHProperties.getPropertyValue(OAIPMHProperties.KEY_METADATOS)));
		        listMetadataFormat[j] = metadataFormat;
	        	
	        }
	        
	        //Trazas del listMetadataFormat
	        pintarTrazasListMetadataFormat(listMetadataFormat);
	        
	        /**
	    	 * -------------------------------------------------------------------------
	    	 * -----------INTRODUCIMOS LA INFORMACION EN EL VO DE VUELTA----------------
	    	 * -------------------------------------------------------------------------
	    	 * */ 	    	
	        return devuelveResultadoOaiRequest(null, null, 
	        		                           listMetadataFormat, null, OAIPMHProperties.VERB_LIST_METADATA_FORMATS);       	
       	
        }catch (Exception e)
        {        	
			logger.error("handleListMetadataFormat-- Error recuperando la lista de formatos del repositorio",e);
			return devuelveResultadoOaiRequest(OAIPMHProperties.ERR_ERROR_GENERICO, OAIPMHProperties.ERR_ERROR_GENERICO_DES, 
					                           null, null, OAIPMHProperties.VERB_LIST_METADATA_FORMATS);			
        }        

    }

    /**
     * Obtiene el listado de los sets que existen en el repositorio. El repositorio puede aceptarlos o no. (En nuestro caso no se aceptan)
     * @param ParametrosOaiPmhVO: vo que contiene los parametros de busqueda      
     * @return ResultadoOaiRequestVo: vo de retorno que es este caso contendra relleno el vo de listSets
     * @throws Exception
     * 
     */
    protected es.pode.oaipmh.negocio.servicios.ResultadoOAIRequest handleListSets()
        throws java.lang.Exception
    {
    	logger.debug("LISTSETS");   	
    	
    	/**
    	 * -------------------------------------------------------------------------
    	 * --------------------DECLARACION DE VARIABLES-----------------------------
    	 * -------------------------------------------------------------------------
    	 * */       	
    	ResultadoOAIRequest resultadoOAIRequest = new ResultadoOAIRequest();
    	
    	/**
    	 * -------------------------------------------------------------------------
    	 * --------------- COMPROBAMOS SI EL REPOSITORIO ADMITE SET ----------------
    	 * -------------------------------------------------------------------------
    	 * */  
    	try
    	{
	    	if(!OAIPMHProperties.repositorioAdmiteSets())
	    	{
	    		logger.debug("handleListSets-- Sets no estan admitidos en el repositorio");		
	    		resultadoOAIRequest = devuelveResultadoOaiRequest(OAIPMHProperties.ERR_NO_SET_HIERARCHY, OAIPMHProperties.ERR_NO_SET_HIERARCHY_DES, 
	    				                           null, null, OAIPMHProperties.VERB_LIST_SETS);						
	    	}
	    	else
	    	{
	    		logger.debug("handleListSets-- Sets si estan admitidos en el repositorio");
	    	}	
	    	
	    	return resultadoOAIRequest;
	    	
    	}catch (Exception e)
    	{    		
			logger.error("handleListMetadataFormat-- Error recuperando si el repositorio admite set o no",e);	
//			Se rellena el resultadoOaiRequestVO
			return devuelveResultadoOaiRequest(OAIPMHProperties.ERR_ERROR_GENERICO, OAIPMHProperties.ERR_ERROR_GENERICO_DES, 
					                           null, null, OAIPMHProperties.VERB_LIST_SETS);			
    	}
    }

    /**
     * Obtiene el listado de los records que existen en el repositorio
     * @param ParametrosOaiPmhVO: vo que contiene los parametros de busqueda      
     * @return ResultadoOaiRequestVo: vo de retorno que es este caso contendra relleno el vo de listRecords
     * @throws Exception
     * 
     */
    protected es.pode.oaipmh.negocio.servicios.ResultadoOAIRequest handleListRecords(es.pode.oaipmh.negocio.servicios.ParametrosOaiPmhVO parametrosLlamada)
        throws java.lang.Exception
    {
    	logger.debug("LISTRECORDS");
    	
    	/**
    	 * -------------------------------------------------------------------------
    	 * --------------------DECLARACION DE VARIABLES-----------------------------
    	 * -------------------------------------------------------------------------
    	 * */    	           
        es.pode.oaipmh.negocio.servicios.ResultadoRecordVO[] listRecords = null;  
        ParamPeriodoRepositorioVO paramBusq = new ParamPeriodoRepositorioVO();
        es.pode.indexador.negocio.servicios.busqueda.ResultadoRecordVO[] resultadosRecordRetorno = null;
		ArrayList resultadoRecordAux = new ArrayList();	
		ReanudacionTokenVO token = new ReanudacionTokenVO();
        
        /**
    	 * -------------------------------------------------------------------------
    	 * ------ COMPROBAMOS SI EL REPOSITORIO ADMITE ESE METADATAPREFIX ----------
    	 * -------------------------- PARAMETRO REQUERIDO --------------------------
    	 * -------------------------------------------------------------------------
    	 * */ 	
		if((parametrosLlamada.getCodigoPaginacion() == null)||(parametrosLlamada.getCodigoPaginacion() == ""))
		{
			if (!OAIPMHProperties.esFormatoMetadatoAdmitido(parametrosLlamada.getPrefijoMetadato()))
			{
				if (logger.isDebugEnabled()) logger.debug("handleListRecords-- El metadataPrefix ["+parametrosLlamada.getPrefijoMetadato()+"] no esta admitido en repositorio");
//				Se rellena el resultadoOaiRequestVO
				return devuelveResultadoOaiRequest(OAIPMHProperties.ERR_CAN_NOT_DISEMINATE_FORMAT, OAIPMHProperties.ERR_CAN_NOT_DISEMINATE_FORMAT_DES, 
						                           null, null, OAIPMHProperties.VERB_LIST_RECORDS);				
			}   
		}
		
		 /**
    	 * -------------------------------------------------------------------------
    	 * --------------- COMPROBAMOS SI EL REPOSITORIO ADMITE SET ----------------
    	 * -------------------------- PARAMETRO OPCIONAL ---------------------------
    	 * -------------------------------------------------------------------------
    	 * */  
    	
		    if(parametrosLlamada.getIdentificadorConjunto()!=null && !parametrosLlamada.getIdentificadorConjunto().equals(""))				
			{
		    	if(!OAIPMHProperties.repositorioAdmiteSets())
		    	{
		    		logger.debug("handleListRecords-- Sets no estan admitidos en el repositorio");
//		    		Se rellena el resultadoOaiRequestVO
		    		return devuelveResultadoOaiRequest(OAIPMHProperties.ERR_NO_SET_HIERARCHY, OAIPMHProperties.ERR_NO_SET_HIERARCHY_DES, 
		    				                           null, null, OAIPMHProperties.VERB_LIST_RECORDS);					
		    	}
			}
        	
    		/**
        	 * -------------------------------------------------------------------------
        	 * -------------TRATAMIENTO DE LA FECHADESDE Y FECHAHASTA-------------------
        	 * -------------------------------------------------------------------------
        	 * */ 
		    	tratamientoFechaDesdeHasta(parametrosLlamada.getFechaDesde(), parametrosLlamada.getFechaHasta(), paramBusq);
    			
    			/**
    	    	 * -------------------------------------------------------------------------
    	    	 * ------------------- COMPROBAMOS EL RESUMPTION TOKEN ---------------------
    	    	 * -------------------------------------------------------------------------
    	    	 * */ 
    	    	String idResumptionToken = parametrosLlamada.getCodigoPaginacion();
    	    	if(idResumptionToken != null && !"".equals(idResumptionToken))
    	    	{    		
//    	    		 Vamos a comprobar a la cache si esta el identificador 
    	    		Element elemento = resumptionToken.devuelveElementoResumptionToken(idResumptionToken);
    	    		   		
    	    		if(elemento != null)
    	    		{
    	    			//El identificador se encontro en la cache    			
    	    			//Buscamos en la cache de resumptionToken el vo de resumptioTokenCacheHit    			
    	    			ResumptionTokenCacheHit vueltaCacheToken = (ResumptionTokenCacheHit)elemento.getObjectValue();
    	    			
    	    			//Se traen los resultados cacheados
    	    			String claveRecords = vueltaCacheToken.getIdQuery();
    	    			if (logger.isDebugEnabled()) logger.debug("handleListRecords-- El valor de la clave de records es ["+claveRecords+"]");    			
    	    			Element elementoCacheRecords = this.getCacheRecords().get(claveRecords);
    	    			es.pode.indexador.negocio.servicios.busqueda.ResultadoRecordVO[] resultadoRecord = (es.pode.indexador.negocio.servicios.busqueda.ResultadoRecordVO[])elementoCacheRecords.getObjectValue();
    	    			if (logger.isDebugEnabled()) logger.debug("handleListRecords-- El numero de resultados traidos por la cache de records es ["+resultadoRecord.length+"]");
    	    			
    	    			//Se obtienen los resultados a entregar con los parametros de vueltaCacheToken 
    	    			Integer desdeToken = vueltaCacheToken.getDesde();
    	    			Integer hastaToken = vueltaCacheToken.getHasta();    			
    	    			for (int j = desdeToken.intValue(); j <= hastaToken.intValue() && j < resultadoRecord.length; j++)    			
    	    				resultadoRecordAux.add(resultadoRecord[j]);
    	    			
    	    			resultadosRecordRetorno = (es.pode.indexador.negocio.servicios.busqueda.ResultadoRecordVO[])resultadoRecordAux.toArray(new es.pode.indexador.negocio.servicios.busqueda.ResultadoRecordVO[0]);
    					if (logger.isDebugEnabled()) logger.debug("handleListRecords-- El numero de resultados que se retornan es ["+resultadosRecordRetorno+"]");
    	    			
    	    			//Se llama a generar el nuevo ResumptionToken si hiciera falta
    	    			ResumptionTokenCacheHit tokenCacheHit = resumptionToken.generateNextResumptionToken(vueltaCacheToken, new Integer(resultadoRecord.length));
    	    			  
    	    			token = devuelveReanudacionToken(tokenCacheHit, null, desdeToken, resultadoRecord.length, true);
    	    		}
    	    		else
    	    		{
    	    			//El identificador no se encontro en la cache.
    	    			logger.debug("handleListRecords-- El identificador del resumptionToken es incorrecto");	
//    	    			Se rellena el resultadoOaiRequestVO
    	    			return devuelveResultadoOaiRequest(OAIPMHProperties.ERR_BAD_RESUMPTION_TOK, OAIPMHProperties.ERR_BAD_RESUMPTION_TOK_DES, 
    	    					                           null, null, OAIPMHProperties.VERB_LIST_RECORDS);   	    			
    	    		}

    	    	}else
    	    	{ 	
    	    		logger.debug("Es la primera vez que se ejecuta esa query");
    				/*
    		    	 * -------------------------------------------------------------------------
    		    	 * -------------LLAMAMOS AL INDEXADOR PARA OBTENER EL VO -------------------
    		    	 * -------------------------------------------------------------------------
    		    	 * */ 		
    				es.pode.indexador.negocio.servicios.busqueda.ResultadoRecordVO[] resultadoRecord = null;			
    				
    				try
    				{
    					if (logger.isDebugEnabled()) logger.debug("handleListRecords-- Llamamos al indexador con los parametros: desde ["+paramBusq.getDesde()+"] y hasta ["+paramBusq.getHasta()+"]");
    					resultadoRecord = this.getSrvBuscadorService().busquedaRepositorio(paramBusq);
    					if (logger.isDebugEnabled()) logger.debug("handleListRecords-- El tamanho del array resultadoRecord es ["+resultadoRecord.length+"]");
    					
    					//Se comprueba que la vuelta del indexador es correcta
    					if(resultadoRecord == null || resultadoRecord.length == 0)
    					{
    						logger.debug("handleListRecords-- No se ha podido encontrar ningun record con fechaDesde ["+paramBusq.getDesde()+"] y fechaHasta ["+paramBusq.getHasta()+"]");
//    						Se rellena el resultadoOaiRequestVO
    						return devuelveResultadoOaiRequest(OAIPMHProperties.ERR_NO_RECORDS_MATCH, OAIPMHProperties.ERR_NO_RECORDS_MATCH_DES, 
    								                           null, null, OAIPMHProperties.VERB_LIST_RECORDS);    						
    					}
    					else
    					{
    						//Se encontraron resultados. Se guardan en la cache de records		
    						String clave = generaClaveDatos(parametrosLlamada);
    						if (logger.isDebugEnabled()) logger.debug("handleListRecords-- Se encontraron resultados. Se introducen en la cache de records con clave ["+clave+"]");
    						this.getCacheRecords().put(new Element(clave,resultadoRecord));    						
    						
    						//Se prepara los resultados de vuelta y se retornan 
    						for (int l = 0; l < numMaxPaginaInt && l < resultadoRecord.length; l++)				
    							resultadoRecordAux.add(resultadoRecord[l]);
    						
    						resultadosRecordRetorno = (es.pode.indexador.negocio.servicios.busqueda.ResultadoRecordVO[])resultadoRecordAux.toArray(new es.pode.indexador.negocio.servicios.busqueda.ResultadoRecordVO[0]);
    						if (logger.isDebugEnabled()) logger.debug("handleListRecords-- El numero de resultados que se retornan en la pagina 1 es ["+resultadosRecordRetorno+"]");    						
    						
//    						Se pagina los resultados
    						if (logger.isDebugEnabled()) logger.debug("handleListRecords-- El numero de resultados es ["+resultadoRecord.length+"]");
    						if (logger.isDebugEnabled()) logger.debug("handleListRecords-- El numero maximo de resultados por pagina es ["+numMaxPaginaInt+"]");
    						
    						token = devuelveReanudacionToken(null, clave, null, resultadoRecord.length, false);    						
    					}
    					
    				} catch (Exception e)
    				{
    					pintarTrazasListRecords(resultadoRecord);    					
    					logger.error("handleListRecords-- Error recuperando el vo del doc ["+resultadoRecord+"] del servicio de indexacion con tamanho ["+resultadoRecord.length+"]",e);
//    					Se rellena el resultadoOaiRequestVO
    					return devuelveResultadoOaiRequest(OAIPMHProperties.ERR_ERROR_GENERICO, OAIPMHProperties.ERR_ERROR_GENERICO_DES, 
    							                           null, null, OAIPMHProperties.VERB_LIST_RECORDS);    					
    				}
    	    	}
    			//Pintamos las trazas de la vuelta del indexador
    			pintarTrazasListRecords(resultadosRecordRetorno);
    			
    			/**
    	    	 * -----------------------------------------------------------------------------------
    	    	 * - REALIZAMOS EL MAPEO DE RESULTADORECORDVO (INDEXADOR) A RESULTADORECORD VO (OAI)--
    	    	 * -----------------------------------------------------------------------------------
    	    	 * */
    			listRecords = mapeoListRecordVO(resultadosRecordRetorno);	
    			if (logger.isDebugEnabled()) logger.debug("handleListRecords-- listRecords ["+listRecords+"] con tamanho ["+listRecords.length+"]");
    	    		
//    			Se rellena el resultadoOaiRequestVO
    			return devuelveResultadoOaiRequest(null, null, 
    					                           listRecords, token, OAIPMHProperties.VERB_LIST_RECORDS);    			
    	    }

    			
    			
    /**
     * Obtiene información de un registro del repositorio  
     * @param ParametrosOaiPmhVO: vo que contiene los parametros de busqueda   
     * @return ResultadoOaiRequestVo: vo de retorno que es este caso contendra relleno el vo de getRecord
     * @throws Exception
     * 
     */    
    protected es.pode.oaipmh.negocio.servicios.ResultadoOAIRequest handleGetRecord(es.pode.oaipmh.negocio.servicios.ParametrosOaiPmhVO parametroLlamada)
        throws java.lang.Exception
    {
    	logger.debug("GETRECORD");
    	        
        /**
    	 * -------------------------------------------------------------------------
    	 * ------ COMPROBAMOS SI EL REPOSITORIO ADMITE ESE METADATAPREFIX ----------
    	 * ---------------------- PARAMETRO REQUERIDO ------------------------------
    	 * -------------------------------------------------------------------------
    	 * */ 
		if (!OAIPMHProperties.esFormatoMetadatoAdmitido(parametroLlamada.getPrefijoMetadato()))
		{
			if (logger.isDebugEnabled()) logger.debug("handleGetRecords-- El metadataPrefix ["+parametroLlamada.getPrefijoMetadato()+"] no esta admitido en repositorio");
//			Se rellena el resultadoOaiRequestVO
			return devuelveResultadoOaiRequest(OAIPMHProperties.ERR_CAN_NOT_DISEMINATE_FORMAT, OAIPMHProperties.ERR_CAN_NOT_DISEMINATE_FORMAT_DES, 
					                           null, null, OAIPMHProperties.VERB_GET_RECORD);			
		}   
        
		
		 /**
    	 * -------------------------------------------------------------------------
    	 * ------ COMPROBAMOS SI EL REPOSITORIO ADMITE ESE IDENTIFICADOR -----------
    	 * ----------------------- PARAMETRO REQUERIDO -----------------------------
    	 * -------------------------------------------------------------------------
    	 * */ 
		String idMEC = "";
		
		if (!validateIdentifier(parametroLlamada.getIdentificador()))
		{
			if (logger.isDebugEnabled()) logger.debug("handleGetRecord-- El identificador ["+parametroLlamada.getIdentificador()+"] no esta admitido en repositorio");
//			Se rellena el resultadoOaiRequestVO
			return devuelveResultadoOaiRequest(OAIPMHProperties.ERR_ID_DOES_NOT_EXIST, OAIPMHProperties.ERR_ID_DOES_NOT_EXIST_DES, 
					                           null, null, OAIPMHProperties.VERB_GET_RECORD);			
		}   
		else
		{
			idMEC = devuelveidMec(parametroLlamada.getIdentificador());
		}
		
		/**
    	 * -------------------------------------------------------------------------
    	 * --------SE LLAMA AL INDEXADOR PARA OBTENER EL VO DE LOS RECORDS----------
    	 * -------------------------------------------------------------------------
    	 * */
		
		es.pode.indexador.negocio.servicios.busqueda.ResultadoRecordVO recordVO = null;		 
			
		logger.debug("handleGetRecord-- Antes de llamar al indexador");
		try
		{
			logger.debug("handleGetRecord-- Se llama al servicio de indexacion para obtener el vo del record con identificador ["+parametroLlamada.getIdentificador()+"]");
			recordVO = this.getSrvBuscadorService().busquedaMECRepositorio(idMEC);
			
//			Se comprueba que la vuelta del indexador es correcta
			if(recordVO == null)
			{
				logger.debug("handleGetRecord---- No se ha podido encontrar ningun record");
//				Se rellena el resultadoOaiRequestVO
				return devuelveResultadoOaiRequest(OAIPMHProperties.ERR_NO_RECORDS_MATCH, OAIPMHProperties.ERR_NO_RECORDS_MATCH_DES, 
						                           null, null, OAIPMHProperties.VERB_GET_RECORD);				
			}
			
		}
		catch (Exception e)
		{
//    			Pintamos los valores del record        		
			pintarTrazasGetRecord(recordVO);			
			logger.error("handleGetRecord---- Error recuperando el vo del servicio de indexacion",e);
//			Se rellena el resultadoOaiRequestVO
			return devuelveResultadoOaiRequest(OAIPMHProperties.ERR_ERROR_GENERICO, OAIPMHProperties.ERR_ERROR_GENERICO_DES, 
					                           null, null, OAIPMHProperties.VERB_GET_RECORD);			
		}
		
		logger.debug("handleGetRecord-- Despues de llamar al indexador");
    	
//		Pintamos los valores del recordVO
		pintarTrazasGetRecord(recordVO);
		
		/**
    	 * -----------------------------------------------------------------------------------
    	 * ---------- REALIZAMOS EL MAPEO DE RECORDVO (INDEXADOR) A RECORDVO (OAI)------------
    	 * -----------------------------------------------------------------------------------
    	 * */	
		es.pode.oaipmh.negocio.servicios.ResultadoRecordVO recordVOOai  = mapeoRecordVO(recordVO);	
    		
//		Se rellena el resultadoOaiRequestVO
		return devuelveResultadoOaiRequest(null, null, recordVOOai, null, OAIPMHProperties.VERB_GET_RECORD);
		
    }
    
//  Metodo que devuelve el vo de reanudaciontoken en los metodos listIdentifiers y listRecords
    private ReanudacionTokenVO devuelveReanudacionToken(ResumptionTokenCacheHit tokenCacheHitNext, String clave, Integer desdeToken, int numResultados, boolean encontradoCache) throws Exception
    {
    	ReanudacionTokenVO token = new ReanudacionTokenVO();
    	if (encontradoCache)
    	{
    		logger.debug("devuelveReanudacionToken-- Se encontro el elemento en la cache de resultados");
    		//Se encontro el elemento en la cache
    		if(tokenCacheHitNext == null)
			{
    			logger.debug("devuelveReanudacionToken-- La pagina entregada es la ultima. No hay nuevo resumptionToken");
				//No hay nuevo resumption token la pagina entregada es la ultima
				token.setCursor(desdeToken);
				token.setTamanio(new Integer(numResultados));
			}
			else
			{
				//Hay nuevo resumption token
//				Se rellena el vo de reanudacionToken 
				logger.debug("devuelveReanudacionToken-- Hay nuevo resumptionToken");
				token.setCursor(desdeToken);
				token.setFechaExpiracion(tokenCacheHitNext.getFechaExpiracion());
				token.setIdentificador(tokenCacheHitNext.getIdResumptionToken());
				token.setTamanio(new Integer(numResultados));
				
			}    	
    	}
    	else
    	{			
			// Se calcula el numero de paginas
			int numPaginas = (numResultados/numMaxPaginaInt)+1;				
			if (logger.isDebugEnabled()) logger.debug("reanudacionToken-- El numero de paginas es  ["+numPaginas+"]");
			
			//Si existe mas de una pagina se genera la clave para el resumption token y se guarda en la cache de resumption token.
			if(numPaginas > 1)
			{
				//Se genera el vo del resumptionToken y se introduce en la cache de resumption token
				logger.debug("devuelveReanudacionToken-- Hay mas de una pagina. Se genera el resumptionToken");
				ResumptionTokenCacheHit tokenCacheHit = resumptionToken.generateFirstResumptionToken(clave, OAIPMHProperties.VERB_LIST_RECORDS, new Integer(numResultados));
				//Se rellena el vo de reanudacionToken 
				token.setCursor(new Integer(0));
				token.setFechaExpiracion(tokenCacheHit.getFechaExpiracion());
				token.setIdentificador(tokenCacheHit.getIdResumptionToken());
				token.setTamanio(new Integer(numResultados));
				
			}
			else
			{
				//Solo hay una pagina. El vo de reanudacionToken se rellena con null
				logger.debug("devuelveReanudacionToken-- Solo hay una pagina. No hay resumptionToken");
				token.setCursor(new Integer(0));
				token.setTamanio(new Integer(numResultados));
			}
    	}
    	return token;
    	
    }
    
//  Nos devuelve el idOAI del id-MEC
    private String devuelveidOai(String idMEC) throws Exception
    {
//    	El identificador debe cumplir el siguiente formato: oai-identifier = scheme ":" namespace-identifier ":" local-identifier
    	String idOAI = "";
    	if(idMEC != null && !idMEC.equals(""))
    		idOAI = OAIPMHProperties.eschemaIdentifier() + this.DOS_PUNTOS + OAIPMHProperties.namespaceIdentifier() + this.DOS_PUNTOS +  idMEC;
    	return idOAI;
    }
    
    //Nos devuelve el idMec del identificador-OAIPMH
    private String devuelveidMec (String identifierOai) throws Exception
    {	    	
    	String[] identifierOaiSplit = identifierOai.split(this.DOS_PUNTOS);
    	return identifierOaiSplit[2];
    }
    
    //Valida si el identificador cumple el patron establecido
	private boolean validateIdentifier(String identifier) throws Exception 
	{
		boolean valid = false;		
		//El identificador debe cumplir el siguiente formato: oai-identifier = scheme ":" namespace-identifier ":" local-identifier
		if(identifier != null && !identifier.equals(""))
		{
			String[] identifierSplit = identifier.split(this.DOS_PUNTOS);			
			if(identifierSplit != null && identifierSplit.length > 0)
			{
				/*
		    	 * -------------------------------------------------------------------------
		    	 * Se comprueba 4 cosas:
		    	 * 	1. El tamaño del array sea 3
		    	 * 	2. La posicion primera cumple el patron de scheme
		    	 * 	3. La posicion segunda cumpla el patron de namespace-identifier
		    	 *  4. La posicion tercera cumpla el patron del mec
		    	 * -------------------------------------------------------------------------
		    	 * */
				
				ValidadorMEC validaMec = new ValidadorMEC();
				if(identifierSplit.length == 3 && OAIPMHProperties.eschemaIdentifier().equals(identifierSplit[0]) && OAIPMHProperties.namespaceIdentifier().equals(identifierSplit[1]) && validaMec.validar(identifierSplit[2]))				
					valid = true;				
			}
			
		}		
		return valid;
	}
  
	//Metodo que mapeo un vo de tipo indexador a uno de tipo oaiPmh
    private es.pode.oaipmh.negocio.servicios.ResultadoHeaderVO[] mapeoHeaderVO(es.pode.indexador.negocio.servicios.busqueda.ResultadoHeaderVO[] headerIndexador) throws Exception
    {
    	if (headerIndexador != null && headerIndexador.length > 0){
	    	es.pode.oaipmh.negocio.servicios.ResultadoHeaderVO[] headerOaiPmh = new es.pode.oaipmh.negocio.servicios.ResultadoHeaderVO[headerIndexador.length]; 
	    	for (int i = 0; headerIndexador != null && i < headerIndexador.length; i++)
	    	{	    	
	    		es.pode.oaipmh.negocio.servicios.ResultadoHeaderVO headerOaiPmhAux = new es.pode.oaipmh.negocio.servicios.ResultadoHeaderVO();
	    			headerOaiPmhAux.setFecha(devuelveFechaStringFromCalendar(headerIndexador[i].getFecha()));
		    		headerOaiPmhAux.setIdentificador(devuelveidOai(headerIndexador[i].getIdentificador()));
		    		
	    		headerOaiPmh[i] = headerOaiPmhAux;	    		
	    	}
	    	return headerOaiPmh;
    	}
    	else
    	{
    		return new es.pode.oaipmh.negocio.servicios.ResultadoHeaderVO[]{};
    	}    	
    }
    
    //Devuelve la fecha como string de un calendar
    private String devuelveFechaStringFromCalendar(Calendar calendar) throws Exception
    {
    	String fechaSt = "";

    	if(calendar != null && !"".equals(calendar))
    	{
    		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        	fechaSt = simpleDateFormat.format(calendar.getTime());
    	}
    	
    	return fechaSt;
    }
    
    private es.pode.oaipmh.negocio.servicios.ResultadoRecordVO mapeoRecordVO (es.pode.indexador.negocio.servicios.busqueda.ResultadoRecordVO recordIndexador) throws Exception
    {
    	es.pode.oaipmh.negocio.servicios.ResultadoRecordVO recordOaiPmh = new es.pode.oaipmh.negocio.servicios.ResultadoRecordVO();
    	
		recordOaiPmh.setAmbito(recordIndexador.getAmbito());
		recordOaiPmh.setAutores(recordIndexador.getAutores());
		recordOaiPmh.setContribuidor(recordIndexador.getContribuidor());
		recordOaiPmh.setDerechos(recordIndexador.getDerechos());
		recordOaiPmh.setDescripcion(recordIndexador.getDescripcion()); 		
		recordOaiPmh.setFecha(devuelveFechaString(recordIndexador.getFecha()));		
		recordOaiPmh.setFormatos(recordIndexador.getFormatos());
		recordOaiPmh.setFuente(recordIndexador.getFuente());
		/** Identificadores 
		 * 1. En la primera posicion contiene el mec
		 * 2. En la segunda posicion contiene la url de la ficha del ode
		 * */
		String[] identificadores = new String[2];
			identificadores[0] = recordIndexador.getIdentificador();
			identificadores[1] = devuelveUrlFicha(recordIndexador);	
		recordOaiPmh.setIdentificador(identificadores);
		recordOaiPmh.setIdRepositorio(devuelveidOai(recordIndexador.getIdentificador()));
		recordOaiPmh.setIdioma(recordIndexador.getIdioma());
		recordOaiPmh.setPublicador(recordIndexador.getPublicador());
		recordOaiPmh.setRelacion(recordIndexador.getRelacion());
		recordOaiPmh.setTema(recordIndexador.getTema());
		recordOaiPmh.setTipo(recordIndexador.getTipo());
		recordOaiPmh.setTitulo(recordIndexador.getTitulo());
		
		return recordOaiPmh;
    		
    }
    
    //Metodo que devuelve la fecha como string en formato valido para OAI-PMH
    private String devuelveFechaString (String var) throws Exception    {
    	
    	return(var.substring(0,4) + this.GUION + var.substring(4,6) + this.GUION + var.substring(6,8));    	
    }
    
    //Metodo que devuelve la url de la ficha del Ode
    private String devuelveUrlFicha(es.pode.indexador.negocio.servicios.busqueda.ResultadoRecordVO recordIndexador) throws Exception
    {
    	//La url sera del tipo: http://desarrollo.agrega.indra.es/buscador/BuscarAvanzadoCU/MostrarResultadosAvanzadoPrepararRetornoDetalle.do?idioma=es&identificadorODE=es_20080429_2_9121621    	
    	String hostNodo = AgregaPropertiesImpl.getInstance().getProperty(KEY_HOST_NODO);    	 	
    	String url = props.getProperty("protocoloHttp") + hostNodo + props.getProperty(BUSCADOR_FICHA) +  recordIndexador.getIdioma() + props.getProperty(BARRA) + recordIndexador.getIdentificador();
    	return url;    	
    }
    
    
//  Metodo que mapea un vo de tipo indexador a uno de tipo oaiPmh
    private es.pode.oaipmh.negocio.servicios.ResultadoRecordVO[] mapeoListRecordVO(es.pode.indexador.negocio.servicios.busqueda.ResultadoRecordVO[] recordIndexador) throws Exception
    {
    	if (recordIndexador != null && recordIndexador.length > 0){
	    	es.pode.oaipmh.negocio.servicios.ResultadoRecordVO[] recordOaiPmhArray = new es.pode.oaipmh.negocio.servicios.ResultadoRecordVO[recordIndexador.length]; 
	    	for (int i = 0; recordIndexador != null && i < recordIndexador.length; i++)
	    	{ 
	    		es.pode.oaipmh.negocio.servicios.ResultadoRecordVO recordOaiPmh = mapeoRecordVO(recordIndexador[i]);
	    		recordOaiPmhArray[i] = recordOaiPmh;
	    	}
	    	return recordOaiPmhArray;
    	}
    	else
    	{
    		return new es.pode.oaipmh.negocio.servicios.ResultadoRecordVO[]{};
    	}
    	
    }
    
	 //Metodo para pintar los valores devueltos por el indexador del headerVO
    private void pintarTrazasListIdentifiers (es.pode.indexador.negocio.servicios.busqueda.ResultadoHeaderVO[] headerVO) throws Exception
    {
    	if(headerVO != null)
    	{
    		if(headerVO.length == 0)
    		{
    			logger.debug("handleListIdentifiers-- El tamanho del array headerVO devuelto por el indexador es cero");
    		}
    		else
    		{
//    	    	  Pintamos los valores de el/los headers/s    			
        		for (int i = 0; i < headerVO.length; i++)
        		{
        			if (logger.isDebugEnabled()) logger.debug("handleListIdentifiers-- Headernumero ["+i+"]");
        			if (logger.isDebugEnabled()) logger.debug("handleListIdentifiers-- El valor de la fecha en el header numero ["+i+"] es ["+headerVO[i].getFecha()+"]");
        			if (logger.isDebugEnabled()) logger.debug("handleListIdentifiers-- El valor del identificador en el header numero ["+i+"] es ["+headerVO[i].getIdentificador()+"]");	        				        			
        		}
    		}

    	}
    	else
    	{
    		logger.error("handleListIdentifiers-- El array devuelto por el indexador HeaderVO es nulo");
    	}
    }
//  Metodo para pintar la lista de los formatos de metadatos que hay en el repositorio
    private void pintarTrazasListMetadataFormat (ListMetadataFormatVO[] listMetadataFormat) throws Exception
    {
    	if(listMetadataFormat != null)
    	{
    		if(listMetadataFormat.length == 0)
    		{
    			logger.debug("handleListMetadataFormat-- El tamanho del array listMetadataFormat devuelto es cero");
    		}
    		else
    		{
//    	    	  Pintamos los valores de el/los formatos del metadata  			
        		for (int i = 0; i < listMetadataFormat.length; i++)
        		{
        			if (logger.isDebugEnabled()) logger.debug("handleListMetadataFormat-- Formato de metadato numero ["+i+"]");
        			if (logger.isDebugEnabled()) logger.debug("handleListMetadataFormat-- El valor del espacioNombres en el formato de metadato numero ["+i+"] es ["+listMetadataFormat[i].getEspacioNombres()+"]");
        			if (logger.isDebugEnabled()) logger.debug("handleListMetadataFormat-- El valor del esquema en el formato de metadato numero ["+i+"] es ["+listMetadataFormat[i].getEsquema()+"]");
        			if (logger.isDebugEnabled()) logger.debug("handleListMetadataFormat-- El valor del nombre del metadato en el formato de metadato numero ["+i+"] es ["+listMetadataFormat[i].getNombreMetadato()+"]");        				        				        			
        		}
    		}

    	}
    	else
    	{
    		logger.error("handleListMetadataFormat-- El array listMetadataFormatVO es nulo");
    	}
    }
    
    private void pintarTrazasGetRecord (es.pode.indexador.negocio.servicios.busqueda.ResultadoRecordVO recordVO) throws Exception
    {
    	if(recordVO != null)
    	{ 		
			if (logger.isDebugEnabled()) logger.debug("El valor de el/los ambitos en el record  es ["+recordVO.getAmbito()+"]");
			if (logger.isDebugEnabled()) logger.debug("El valor de el/los autores en el record es ["+recordVO.getAutores()+"]");
			if (logger.isDebugEnabled()) logger.debug("El valor de el/los derechos en el record es ["+recordVO.getDerechos()+"]");
			if (logger.isDebugEnabled()) logger.debug("El valor de la/las descripciones en el record es ["+recordVO.getDescripcion()+"]");
			if (logger.isDebugEnabled()) logger.debug("El valor de la fecha en el record es ["+recordVO.getFecha()!=null?recordVO.getFecha().toString():""+"]");
			if (logger.isDebugEnabled()) logger.debug("El valor de el/los formatos en el record es ["+recordVO.getFormatos()+"]");
			if (logger.isDebugEnabled()) logger.debug("El valor del identificador en el record es ["+recordVO.getIdentificador()+"]");
			if (logger.isDebugEnabled()) logger.debug("El valor del idioma en el record es ["+recordVO.getIdioma()+"]");
			if (logger.isDebugEnabled()) logger.debug("El valor de el/los temas en el record es ["+recordVO.getTema()+"]");
			if (logger.isDebugEnabled()) logger.debug("El valor de el/los tipos en el record es ["+recordVO.getTipo()+"]");
			if (logger.isDebugEnabled()) logger.debug("El valor del titulo en el record es ["+recordVO.getTitulo()+"]");
			if (logger.isDebugEnabled()) logger.debug("El valor de la/las relaciones en el record es ["+recordVO.getRelacion()+"]");
			if (logger.isDebugEnabled()) logger.debug("El valor de el/los publicadores en el record es ["+recordVO.getPublicador()+"]");	
			if (logger.isDebugEnabled()) logger.debug("El valor de la/las fuentes en el record es ["+recordVO.getFuente()+"]");
			if (logger.isDebugEnabled()) logger.debug("El valor de el/los contribuidores en el record es ["+recordVO.getContribuidor()+"]");	        			
    		
    	}
    	else
    	{
    		logger.error("handleGetRecord-- El vo esta vacio");
    	}
    }
    
    //Metodo para pintar los valores devueltos por el indexador del recordVO
    private void pintarTrazasListRecords (es.pode.indexador.negocio.servicios.busqueda.ResultadoRecordVO[] recordVO) throws Exception
    {
    	if(recordVO != null)
    	{
    		if(recordVO.length == 0)
    		{
    			logger.debug("handleListRecords-- El tamanho del array recordVO devuelto por el indexador es cero");
    		}
    		else
    		{
//    	    	  Pintamos los valores de el/los record/s    			
        		for (int i = 0; i < recordVO.length; i++)
        		{
        			if (logger.isDebugEnabled()) logger.debug("handleListRecords-- Record numero ["+i+"]");
        			pintarTrazasGetRecord(recordVO[i]);        				        			
        		}
    		}

    	}
    	else
    	{
    		logger.error("handleListRecords-- El array devuelto por el indexador RecordVO es nulo");
    	}
    }
    
    private String generaClaveDatos(es.pode.oaipmh.negocio.servicios.ParametrosOaiPmhVO parametroLlamada) throws Exception
    {
    	//Genero la clave a partir de la fechaDesde y fechaHasta
    	String desde, hasta, clave = "";
    	if(parametroLlamada.getFechaDesde() == null || ("").equals(parametroLlamada.getFechaDesde()))	desde = this.FROM;
    	else 	desde = parametroLlamada.getFechaDesde().toString();
    	
    	if(parametroLlamada.getFechaHasta() == null || ("").equals(parametroLlamada.getFechaHasta()))	hasta = this.TO;
    	else	hasta = parametroLlamada.getFechaHasta().toString();
    	
    	clave = desde + hasta;
    	if (logger.isDebugEnabled()) logger.debug("Genera clave-- El valor de la clave creada es ["+clave+"]");
    	
    	return clave;
    } 
    
//	Metodo que realiza el tratamiento de la fechaDesde y fechaHasta. En el caso de que venga relleno, 
//  se realiza la transformacion a Calendar y se introduce en el vo de parametros de busqueda
    private void tratamientoFechaDesdeHasta(Calendar fechaDesde, Calendar fechaHasta, ParamPeriodoRepositorioVO paramBusq) throws Exception
    {    	
//    	Fecha Desde
    	if(fechaDesde != null)
		{
    		Calendar fechaDesdeCalendar = Calendar.getInstance();
    		fechaDesdeCalendar.setTime(fechaDesde.getTime());
    		paramBusq.setDesde(fechaDesdeCalendar);
    		if (logger.isDebugEnabled()) logger.debug("El valor de la fecha desde es ["+paramBusq.getDesde()+"]");
	
		}     	
//    	Fecha hasta
    	if(fechaHasta !=null)
    	{
			Calendar fechaHastaCalendar = Calendar.getInstance();
			fechaHastaCalendar.setTime(fechaHasta.getTime());
			paramBusq.setHasta(fechaHastaCalendar);
			if (logger.isDebugEnabled()) logger.debug("El valor de la fecha hasta es ["+paramBusq.getHasta()+"]");
    	}
    	
    }    
        
    //Devuelve  el vo de resultadoOaiRequest
    private ResultadoOAIRequest devuelveResultadoOaiRequest(String errorCode, String errorDescripcion, Object obj, ReanudacionTokenVO reanudacionToken, String verb) throws Exception
    {
    	ResultadoOAIRequest resultadoOAIRequest = new ResultadoOAIRequest();
    		//Se comprueba cual es el verbo
    		if (OAIPMHProperties.VERB_GET_RECORD.equals(verb))	resultadoOAIRequest.setGetRecord((ResultadoRecordVO)obj);    		
    		else if (OAIPMHProperties.VERB_IDENTIFY.equals(verb))	resultadoOAIRequest.setIdentifyVO((IdentifyVO)obj);    		
    		else if (OAIPMHProperties.VERB_LIST_IDENTIFIERS.equals(verb))	resultadoOAIRequest.setListIdentifiers((ResultadoHeaderVO[])obj);    		
    		else if (OAIPMHProperties.VERB_LIST_METADATA_FORMATS.equals(verb))	resultadoOAIRequest.setListMetadataFormat((ListMetadataFormatVO[])obj);    		
    		else if (OAIPMHProperties.VERB_LIST_RECORDS.equals(verb))	resultadoOAIRequest.setListRecords((ResultadoRecordVO[])obj);    		
    		else if (OAIPMHProperties.VERB_LIST_SETS.equals(verb))	resultadoOAIRequest.setListSets((SetVO[])obj);
    		
    		//Se rellena el errorcode, errorDescripcion, reanudacionToken y verb
    		resultadoOAIRequest.setErrorCode(errorCode);
    		resultadoOAIRequest.setErrorDescripcion(errorDescripcion);
    		resultadoOAIRequest.setReanudacionToken(reanudacionToken);
    		resultadoOAIRequest.setVerb(verb);     	
    	
    		return resultadoOAIRequest;
    }

    /** Para saber si el servicio está operativo
	 * 
	 * @return Boolean
	 * @throws Exception
	 * */
	protected Boolean handleEstasActivo() throws Exception {
		// TODO Auto-generated method stub
		return new Boolean(true);
	}     
    	
}