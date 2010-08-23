/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.oaipmh.presentacion.pmhServer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.agrega.soporte.sitemapProperties.SitemapPropertiesImpl;
import es.pode.oaipmh.negocio.servicios.DescripcionOaiIdentifierVO;
import es.pode.oaipmh.negocio.servicios.IdentifyVO;
import es.pode.oaipmh.negocio.servicios.ListMetadataFormatVO;
import es.pode.oaipmh.negocio.servicios.ParametrosOaiPmhVO;
import es.pode.oaipmh.negocio.servicios.ReanudacionTokenVO;
import es.pode.oaipmh.negocio.servicios.ResultadoHeaderVO;
import es.pode.oaipmh.negocio.servicios.ResultadoOAIRequest;
import es.pode.oaipmh.negocio.servicios.ResultadoRecordVO;
import es.pode.oaipmh.negocio.servicios.SetVO;
import es.pode.oaipmh.soporte.OAIPMHProperties;
import es.pode.parseadorXML.OaiPmhDao;
import es.pode.parseadorXML.ParseadorException;
import es.pode.parseadorXML.oai_dc.Dc;
import es.pode.parseadorXML.oai_dc.DcContributor;
import es.pode.parseadorXML.oai_dc.DcCoverage;
import es.pode.parseadorXML.oai_dc.DcCreator;
import es.pode.parseadorXML.oai_dc.DcDate;
import es.pode.parseadorXML.oai_dc.DcDescription;
import es.pode.parseadorXML.oai_dc.DcFormat;
import es.pode.parseadorXML.oai_dc.DcIdentifier;
import es.pode.parseadorXML.oai_dc.DcLanguage;
import es.pode.parseadorXML.oai_dc.DcPublisher;
import es.pode.parseadorXML.oai_dc.DcRelation;
import es.pode.parseadorXML.oai_dc.DcRights;
import es.pode.parseadorXML.oai_dc.DcSource;
import es.pode.parseadorXML.oai_dc.DcSubject;
import es.pode.parseadorXML.oai_dc.DcTitle;
import es.pode.parseadorXML.oai_dc.DcType;
import es.pode.parseadorXML.oai_dc.Oai_dcTypeItem;
import es.pode.parseadorXML.oai_pmh.Description;
import es.pode.parseadorXML.oai_pmh.Error;
import es.pode.parseadorXML.oai_pmh.Identify;
import es.pode.parseadorXML.oai_pmh.ListIdentifiers;
import es.pode.parseadorXML.oai_pmh.ListIdentifiersTypeHeader;
import es.pode.parseadorXML.oai_pmh.ListIdentifiersTypeResumptionToken;
import es.pode.parseadorXML.oai_pmh.ListMetadataFormats;
import es.pode.parseadorXML.oai_pmh.ListRecords;
import es.pode.parseadorXML.oai_pmh.ListRecordsTypeRecord;
import es.pode.parseadorXML.oai_pmh.ListRecordsTypeResumptionToken;
import es.pode.parseadorXML.oai_pmh.ListSets;
import es.pode.parseadorXML.oai_pmh.Metadata;
import es.pode.parseadorXML.oai_pmh.MetadataFormat;
import es.pode.parseadorXML.oai_pmh.RecordTypeHeader;
import es.pode.parseadorXML.oai_pmh.Request;
import es.pode.parseadorXML.oai_pmh.Set;
import es.pode.parseadorXML.oai_pmh.oai_pmhAgrega.ListRecordsAgrega;
import es.pode.parseadorXML.oai_pmh.oai_pmhAgrega.OAIPMHAgrega;
import es.pode.parseadorXML.oai_pmh.oai_pmhAgrega.RecordAgrega;
import es.pode.parseadorXML.oai_pmh.types.DeletedRecordType;
import es.pode.parseadorXML.oai_pmh.types.GranularityType;
import es.pode.parseadorXML.oai_pmh.types.OAIPMHerrorcodeType;
import es.pode.parseadorXML.oai_pmh.types.ProtocolVersionType;
import es.pode.parseadorXML.oai_pmh.types.VerbType;
import es.pode.parseadorXML.oai_pmh_id.OaiIdentifier;
import es.pode.soporte.utiles.date.DateManager;
import es.pode.soporte.utiles.ficheros.UtilesFicheros;



/**
 * @see es.pode.oaipmh.presentacion.pmhServer.OaiPmhServerController
 */

public class OaiPmhServerControllerImpl extends OaiPmhServerController
{



	private static Logger logger = Logger.getLogger(OaiPmhServerControllerImpl.class);
	private java.util.Properties pOaiPmhProperties = null;
	private OaiPmhDao dao = null;


  

	 /**
	 * Genera la llamada Identify del protocolo Oai-pmh
	 * @throws Exception
	 */
    public final void identify(ActionMapping mapping, es.pode.oaipmh.presentacion.pmhServer.IdentifyForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try
    	{
    		if(logger.isDebugEnabled())logger.debug("Identify");
    		ResultadoOAIRequest resultadoOAIRequest = this.getSrvOaiPmhService().identify();
    		form.setResultadoOAIRequest(resultadoOAIRequest);
    		if(logger.isDebugEnabled())logger.debug("Almaceno en el formulario el objeto resultadoOAIRequest");
    	}catch(Exception e)
    	{
    		logger.error("Exception en el método identify "+e);
    		response.sendError(503, "Service unavailable"); 
    		
    	}
       
    }


    /**
	 * Genera la llamada ListIdentifiers del protocolo Oai-pmh
	 * @throws Exception
	 */
    public final void listIdentifiers(ActionMapping mapping, es.pode.oaipmh.presentacion.pmhServer.ListIdentifiersForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try
    	{
    		if(logger.isDebugEnabled())logger.debug("ListIdentifiers");
    		ParametrosOaiPmhVO parametroLlamada = new ParametrosOaiPmhVO();
    		ParametrosRequestVO parametrosRequestVO = form.getParametrosRequestVO();
    	//Mapeo ParametrosRequestVO - ParametrosOaiPmhVO
    		parametroLlamada.setCodigoPaginacion(parametrosRequestVO.getCodigoPaginacion());
    	//fechaDesde
    		if(parametrosRequestVO.getFechaDesde() == null)
    		{
    			parametroLlamada.setFechaDesde(null);
    		}else
    		{
    			parametroLlamada.setFechaDesde(DateManager.dateToCalendar(getFecha(parametrosRequestVO.getFechaDesde())));
    		}
    	//fechaHasta
    		if(parametrosRequestVO.getFechaHasta() == null)
    		{
    			parametroLlamada.setFechaHasta(null);
    		}else
    		{
    			parametroLlamada.setFechaHasta(DateManager.dateToCalendar(getFecha(parametrosRequestVO.getFechaHasta())));
    		}
    	//Identificador
    		parametroLlamada.setIdentificador(parametrosRequestVO.getIdentificador());
    	//identificador conjunto
    		parametroLlamada.setIdentificadorConjunto(parametrosRequestVO.getIdentificadorConjunto());
    	//tipo de metadato
    		parametroLlamada.setPrefijoMetadato(parametrosRequestVO.getPrefijoMetadato());
    	
    	//this.getBeanMapper().map(parametrosRequestVO, parametroLlamada);
    		ResultadoOAIRequest resultadoOAIRequest = this.getSrvOaiPmhService().listIdentifiers(parametroLlamada);
    		if(logger.isDebugEnabled()){
    			logger.debug("resultadoOAIRequest "+resultadoOAIRequest);
    			logger.debug("resultadoOAIRequest.getErrorCode() "+resultadoOAIRequest.getErrorCode());
    			logger.debug("resultadoOAIRequest.getListIdentifiers() "+resultadoOAIRequest.getListIdentifiers());
    		}
    		form.setResultadoOAIRequest(resultadoOAIRequest);
    		if(logger.isDebugEnabled())logger.debug("Almaceno en el formulario el objeto resultadoOAIRequest");
    	}catch(Exception e)
    	{
    		logger.error("Exception en el método ListIdentifiers "+e);
    		response.sendError(503, "Service unavailable"); 
    		
    	}
        
    }



    /**
	 * Genera la llamada ListMetadataFormat del protocolo Oai-pmh
	 * @throws Exception
	 */
    public final void listMetadataFormat(ActionMapping mapping, es.pode.oaipmh.presentacion.pmhServer.ListMetadataFormatForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try
    	{
    		if(logger.isDebugEnabled())logger.debug("ListMetadataFormat");
    		ParametrosOaiPmhVO parametroLlamada = new ParametrosOaiPmhVO();
    		ParametrosRequestVO parametrosRequestVO = form.getParametrosRequestVO();
    		this.getBeanMapper().map(parametrosRequestVO, parametroLlamada);
    		ResultadoOAIRequest resultadoOAIRequest = this.getSrvOaiPmhService().listMetadataFormat(parametroLlamada);
    		form.setResultadoOAIRequest(resultadoOAIRequest);
    		if(logger.isDebugEnabled())logger.debug("Almaceno en el formulario el objeto resultadoOAIRequest");
    		form.setParametrosRequestVO(parametrosRequestVO);
    	}catch(Exception e)
    	{
    		logger.error("Exception en el método ListMetadataFormat "+e);
    		response.sendError(503, "Service unavailable"); 
    		
    	}
       
    }


    /**
	 * Genera la llamada ListSets del protocolo Oai-pmh
	 * @throws Exception
	 */
    public final void listSets(ActionMapping mapping, es.pode.oaipmh.presentacion.pmhServer.ListSetsForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try
    	{
    		if(logger.isDebugEnabled())logger.debug("ListSets");
    		ParametrosRequestVO parametrosRequestVO = form.getParametrosRequestVO();
    		ResultadoOAIRequest resultadoOAIRequest = this.getSrvOaiPmhService().listSets();
    		form.setResultadoOAIRequest(resultadoOAIRequest);
    		if(logger.isDebugEnabled())logger.debug("Almaceno en el formulario el objeto resultadoOAIRequest");
    		form.setParametrosRequestVO(parametrosRequestVO);
    	}catch(Exception e)
    	{
    		logger.error("Exception en el método ListSets "+e);
    		response.sendError(503, "Service unavailable"); 
    		
    	}
         
    }


    /**
	 * Genera la llamada ListRecords del protocolo Oai-pmh
	 * @throws Exception
	 */
    public final void listRecords(ActionMapping mapping, es.pode.oaipmh.presentacion.pmhServer.ListRecordsForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try
    	{
    		if(logger.isDebugEnabled())logger.debug("ListRecords");
    		ParametrosOaiPmhVO parametroLlamada = new ParametrosOaiPmhVO();
    		ParametrosRequestVO parametrosRequestVO = form.getParametrosRequestVO();
//    	Mapeo ParametrosRequestVO - ParametrosOaiPmhVO
    		parametroLlamada.setCodigoPaginacion(parametrosRequestVO.getCodigoPaginacion());
    	//fecha Desde
    		if(parametrosRequestVO.getFechaDesde() == null)
    		{
    			parametroLlamada.setFechaDesde(null);
    		}else
    		{
    			parametroLlamada.setFechaDesde(DateManager.dateToCalendar(getFecha(parametrosRequestVO.getFechaDesde())));
    		}
    	//fechaHasta
    		if(parametrosRequestVO.getFechaHasta() == null)
    		{
    			parametroLlamada.setFechaHasta(null);
    		}else
    		{
    			parametroLlamada.setFechaHasta(DateManager.dateToCalendar(getFecha(parametrosRequestVO.getFechaHasta())));
    		}
    		
    	//Identificador
    		parametroLlamada.setIdentificador(parametrosRequestVO.getIdentificador());
    	//identificador conjunto
    		parametroLlamada.setIdentificadorConjunto(parametrosRequestVO.getIdentificadorConjunto());
    	//tipo de metadato
    		parametroLlamada.setPrefijoMetadato(parametrosRequestVO.getPrefijoMetadato());
    	//this.getBeanMapper().map(parametrosRequestVO, parametroLlamada);
    		ResultadoOAIRequest resultadoOAIRequest = this.getSrvOaiPmhService().listRecords(parametroLlamada);
    		form.setResultadoOAIRequest(resultadoOAIRequest);
    		if(logger.isDebugEnabled())logger.debug("Almaceno en el formulario el objeto resultadoOAIRequest");
    		form.setParametrosRequestVO(parametrosRequestVO); 
    	}catch(Exception e)
    	{
    		logger.error("Exception en el método ListRecords "+e);
    		response.sendError(503, "Service unavailable"); 
    		
    	}
         
    }


    /**
	 * Genera la llamada GetRecord del protocolo Oai-pmh
	 * @throws Exception
	 */
    public final void getRecord(ActionMapping mapping, es.pode.oaipmh.presentacion.pmhServer.GetRecordForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try
    	{
    		if(logger.isDebugEnabled())logger.debug("GetRecord");
    		ParametrosOaiPmhVO parametroLlamada = new ParametrosOaiPmhVO();
    		ParametrosRequestVO parametrosRequestVO = form.getParametrosRequestVO();
    		if(logger.isDebugEnabled()){
    			logger.debug("parametrosRequestVO "+parametrosRequestVO);
    			logger.debug("parametrosRequestVO.getIdentificador "+parametrosRequestVO.getIdentificador());
    			logger.debug("parametrosRequestVO.getPrefijoMetadato "+parametrosRequestVO.getPrefijoMetadato());
    		}
    		this.getBeanMapper().map(parametrosRequestVO, parametroLlamada);
    		ResultadoOAIRequest resultadoOAIRequest = this.getSrvOaiPmhService().getRecord(parametroLlamada);
    		form.setResultadoOAIRequest(resultadoOAIRequest);
    		if(logger.isDebugEnabled()) logger.debug("Almaceno en el formulario el objeto resultadoOAIRequest");
    		form.setParametrosRequestVO(parametrosRequestVO); 
    	}catch(Exception e)
    	{
    		logger.error("Exception en el método GetRecord "+e);
    		response.sendError(503, "Service unavailable"); 
    		
    	}
       
    }


    /**
	 * Genera el VO con el error que se produce en la llamada al método del protocolo oai
	 * @throws Exception
	 */
    public final void obtenerResultadoOAIRequest(ActionMapping mapping, es.pode.oaipmh.presentacion.pmhServer.ObtenerResultadoOAIRequestForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	if(logger.isDebugEnabled()) logger.debug("OBTENERRESULTADOOAIREQUEST");
      	ResultadoOAIRequest resultadoOAIRequest = new ResultadoOAIRequest();
        ParametrosRequestVO parametrosRequestVO = form.getParametrosRequestVO();
        this.getBeanMapper().map(parametrosRequestVO, resultadoOAIRequest);
        //Recorremos el VO ResultadoOAIRequest
        if(logger.isDebugEnabled()) {
        	logger.debug("resultadoOAIRequest.getCodigoError "+resultadoOAIRequest.getErrorCode());
        	logger.debug("resultadoOAIRequest.getDescripcionError "+resultadoOAIRequest.getErrorDescripcion());
        	logger.debug("resultadoOAIRequest.getVerb() "+resultadoOAIRequest.getVerb());
        }
        ///
    	form.setResultadoOAIRequest(resultadoOAIRequest);
     }


    /**
     * Recibe el VO con los parámetros de la petición para validar los parámetros 
     * return String devuelve una cadena con el tipo de método del protoco oai-pmh
     */
    public final java.lang.String analizaPeticion(ActionMapping mapping, es.pode.oaipmh.presentacion.pmhServer.AnalizaPeticionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String resultado = "";
        ParametrosRequestVO parametrosRequest = form.getParametrosRequestVO();
        if(logger.isDebugEnabled())logger.debug("Analiza peticion");
        try
        { 
        if(parametrosRequest == null)
        {
        	if(logger.isDebugEnabled())logger.debug("no recibo ningun parametro");
        	resultado = "badVerb";
        	parametrosRequest = new ParametrosRequestVO();
        	parametrosRequest.setErrorCode("badVerb");
        	parametrosRequest.setErrorDescripcion(OAIPMHProperties.ERR_BAD_VERB_DES);
        }else
        {
        	//Antes de comprobar cada uno de los atributos del VO ParametrosRequest miramos si el campo ErrorCode existe, eso significará que hay un error 
        	if(parametrosRequest.getErrorCode() != null)
        	{
        		if(logger.isDebugEnabled())logger.debug("Existe un error en los parámetros, hay mas atributos del mismo tipo en la request");
        		resultado = parametrosRequest.getErrorCode();
        	}else
        	{
        		if(parametrosRequest.getVerb() == null)
        		{
        			logger.error("No se recibe el parametro verb necesario");
        			resultado = "badVerb";
                	parametrosRequest = new ParametrosRequestVO();
                	parametrosRequest.setErrorCode("badVerb");
                	parametrosRequest.setErrorDescripcion(OAIPMHProperties.ERR_BAD_VERB_DES);
        		}else
        		{
        	if(parametrosRequest.getVerb().equalsIgnoreCase("GetRecord"))
        	{
        		
        		//Validamos si aparece el parametro identifier
        		String identificador = parametrosRequest.getIdentificador();
        		String metadatoFormat = parametrosRequest.getPrefijoMetadato();
        		if(((validaParametros(parametrosRequest, parametrosRequest.getVerb())).equalsIgnoreCase("badArgument")))
        		{
        			resultado = "badArgument";
        			parametrosRequest.setErrorCode(resultado);
        			parametrosRequest.setErrorDescripcion(OAIPMHProperties.ERR_BAD_ARGUMENT_DES);
        		}else
        		{
        		if((identificador == null) || (identificador == "") || (identificador == " ") || (metadatoFormat == null) || (metadatoFormat == "") || (metadatoFormat == " "))
        		{
        			if(logger.isDebugEnabled())logger.debug("[GETRECORD] El identificador o el tipo de metadato no es valido");
        			resultado = "badArgument";
        			parametrosRequest.setErrorCode(resultado);
        			parametrosRequest.setErrorDescripcion(OAIPMHProperties.ERR_BAD_ARGUMENT_DES);
        		}else
        		{
        			resultado = "GetRecord";
        		        			
        		}
        		}	
        		
        	}else
        	{
        		if((parametrosRequest.getVerb().equalsIgnoreCase("ListRecords")) || (parametrosRequest.getVerb().equalsIgnoreCase("ListIdentifiers")))
        		{
        			
        			
        			String metadatoFormat = parametrosRequest.getPrefijoMetadato();
        			if(logger.isDebugEnabled())logger.debug("codigo paginacion "+parametrosRequest.getCodigoPaginacion());
        			if(((validaParametros(parametrosRequest, parametrosRequest.getVerb())).equalsIgnoreCase("badArgument")))
            		{
            			resultado = "badArgument";
            			parametrosRequest.setErrorCode(resultado);
            			parametrosRequest.setErrorDescripcion(OAIPMHProperties.ERR_BAD_ARGUMENT_DES);
            		}else
            		{
//            			Validamos si recibimos el parametro metadataPrefix siempre y cuando no recibamos el parámetro resumptionToken
            			if(logger.isDebugEnabled())logger.debug("metadatoFormat "+metadatoFormat);
        			if(((metadatoFormat == null) || (metadatoFormat == "") || (metadatoFormat == " "))&&((parametrosRequest.getCodigoPaginacion() == null)))
        			{
        				if(logger.isDebugEnabled())logger.debug("El tipo de metadato no es valido");
        				resultado = "badArgument";
        				parametrosRequest.setErrorCode(resultado);
            			parametrosRequest.setErrorDescripcion(OAIPMHProperties.ERR_BAD_ARGUMENT_DES);
        			}else
        			{
     					//Validamos las fechas
        				if((!(parametrosRequest.getFechaDesde() == null)) && !(this.validaFecha((parametrosRequest.getFechaDesde()))))
        				{
        					if(logger.isDebugEnabled())logger.debug("El atributo from no es correcto");
        					resultado = "badArgument";
        					parametrosRequest.setErrorCode(resultado);
        					parametrosRequest.setErrorDescripcion(OAIPMHProperties.ERR_BAD_ARGUMENT_DES);
        				}else
        				{
        					if((!(parametrosRequest.getFechaHasta() == null)) && !(this.validaFecha(parametrosRequest.getFechaHasta())))
        					{
        						if(logger.isDebugEnabled())logger.debug("El atributo until no es correcto");
        						resultado = "badArgument";
        						parametrosRequest.setErrorCode(resultado);
        						parametrosRequest.setErrorDescripcion(OAIPMHProperties.ERR_BAD_ARGUMENT_DES);
        					}else
        					{
        						//Comprobar si la granularidad es la misma en la fecha de inicio y la fecha fin
        						if(!(comparacionFechas(parametrosRequest.getFechaDesde(), parametrosRequest.getFechaHasta())))
        						{
        							if(logger.isDebugEnabled())logger.debug("Las fechas no son correctas");
        							resultado = "badArgument";
            						parametrosRequest.setErrorCode(resultado);
            						parametrosRequest.setErrorDescripcion(OAIPMHProperties.ERR_BAD_ARGUMENT_DES);
        						}else
        						{
        							if(parametrosRequest.getVerb().equalsIgnoreCase("ListRecords"))
        							{
        								resultado = "ListRecords";
        							}else
        							{
        								resultado = "ListIdentifiers";
        							}
        						}
        					}
        				}
        			}
            		}
        		}else
        		{
        			if(parametrosRequest.getVerb().equalsIgnoreCase("ListSets"))
        			{
        				
        				if(((validaParametros(parametrosRequest, parametrosRequest.getVerb())).equalsIgnoreCase("badArgument")))
                		{
                			resultado = "badArgument";
                			parametrosRequest.setErrorCode(resultado);
	            			parametrosRequest.setErrorDescripcion(OAIPMHProperties.ERR_BAD_ARGUMENT_DES);
                		}else
                		{
        					resultado = "ListSets";
        				
                		}
        			}else
        			{
        				if(parametrosRequest.getVerb().equalsIgnoreCase("Identify"))
        				{
        					
        					if(((validaParametros(parametrosRequest, parametrosRequest.getVerb())).equalsIgnoreCase("badArgument")))
        	        		{
        	        			resultado = "badArgument";
        	        			parametrosRequest.setErrorCode(resultado);
    	            			parametrosRequest.setErrorDescripcion(OAIPMHProperties.ERR_BAD_ARGUMENT_DES);
        	        		}else
        	        		{
        	        			resultado = "Identify";
        	        		}
        					
        				}else
        				{
        					if(parametrosRequest.getVerb().equalsIgnoreCase("ListMetadataFormats"))
        					{
        						
        						if(((validaParametros(parametrosRequest, parametrosRequest.getVerb())).equalsIgnoreCase("badArgument")))
        		        		{
        		        			resultado = "badArgument";
        		        			parametrosRequest.setErrorCode(resultado);
        	            			parametrosRequest.setErrorDescripcion(OAIPMHProperties.ERR_BAD_ARGUMENT_DES);
        		        		}else
        		        		{
        		        			resultado = "ListMetadataFormat";
        		        		}
        						
        					}else
        					{
        						if(logger.isDebugEnabled())logger.debug("No es ninguno de los métodos reconocidos");
        						resultado = "badVerb";
        						parametrosRequest.setErrorCode(resultado);
    	            			parametrosRequest.setErrorDescripcion(OAIPMHProperties.ERR_BAD_VERB_DES);
        					}
        				}
        			}
        		}
        	}
        		}
        	}
        }
        }catch(Exception e)
        {
        	logger.error("[analizaPeticion] Se produce la siguiente excepcion "+e);
        	resultado = "Error";  
        	
        }
        form.setParametrosRequestVO(parametrosRequest);
       
        return resultado;
    }


    /**
     * Recoge los parámetros de la request y genera un VO con los datos de la misma
     */
    public final void obtenerParametros(ActionMapping mapping, es.pode.oaipmh.presentacion.pmhServer.ObtenerParametrosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	if(logger.isDebugEnabled())logger.debug("Obtener parametros");
    	ParametrosRequestVO parametrosRequestVO = null;
    	Enumeration nombreParametros = request.getParameterNames();
    	if(request.getParameterNames() == null)
    	{
    		if(logger.isDebugEnabled())logger.debug("No tengo parametros");
    	}else
    	{
    		
    		parametrosRequestVO = new ParametrosRequestVO();
    		List listaParametros = new ArrayList();
    		while(nombreParametros.hasMoreElements())
    		{
    			String param = (String)nombreParametros.nextElement();
    			if(logger.isDebugEnabled())logger.debug("param vale "+param);
    			if(param.equals("verb"))
    			{
    				if(request.getParameterValues("verb").length > 1)
    				{
    					if(logger.isDebugEnabled())logger.debug("En la peticion hay mas de un atributo verb");
    					parametrosRequestVO.setErrorDescripcion(OAIPMHProperties.ERR_BAD_VERB_DES);
    					parametrosRequestVO.setErrorCode("badVerb");
    				}else
    				{
    					if(logger.isDebugEnabled())logger.debug("tipo de operacion "+request.getParameter(param));
    					parametrosRequestVO.setVerb(request.getParameter(param));
    				}
    			}else
    			{
    				if(param.equals("identifier"))
    				{
    					if(request.getParameterValues("identifier").length > 1)
        				{
    						if(logger.isDebugEnabled())logger.debug("En la peticion hay mas de un atributo identifier");
        					parametrosRequestVO.setErrorCode("badArgument");
        					parametrosRequestVO.setErrorDescripcion(OAIPMHProperties.ERR_SEVERAL_IDENTIFIER_DES);
        				}else
        				{
        					if(logger.isDebugEnabled())logger.debug("identificador");
        					parametrosRequestVO.setIdentificador(request.getParameter(param));
        				}
    				}else
    				{
    					if(param.equals("metadataPrefix"))
    					{
    						if(request.getParameterValues("metadataPrefix").length > 1)
            				{
    							if(logger.isDebugEnabled())logger.debug("En la peticion hay mas de un atributo metadataPrefix");
            					parametrosRequestVO.setErrorCode("badArgument");
            					parametrosRequestVO.setErrorDescripcion(OAIPMHProperties.ERR_SEVERAL_METADATAPREFIX_DES);
            				}else
            				{
            					parametrosRequestVO.setPrefijoMetadato(request.getParameter(param));
            				}
    					}else
    					{
    						if(param.equals("from"))
    						{
    							if(request.getParameterValues("from").length > 1)
    	        				{
    								if(logger.isDebugEnabled())logger.debug("En la peticion hay mas de un atributo from");
    	        					parametrosRequestVO.setErrorCode("badArgument");
    	        					parametrosRequestVO.setErrorDescripcion(OAIPMHProperties.ERR_SEVERAL_FROM_DES);
    	        				}else
    	        				{
    	        					parametrosRequestVO.setFechaDesde(request.getParameter(param));
    	        				}
    						}else
    						{
    							if(param.equals("until"))
    							{
    								if(request.getParameterValues("until").length > 1)
    		        				{
    									if(logger.isDebugEnabled())logger.debug("En la peticion hay mas de un atributo until");
    		    						parametrosRequestVO.setErrorCode("badArgument");
        	        					parametrosRequestVO.setErrorDescripcion(OAIPMHProperties.ERR_SEVERAL_UNTIL_DES);
    		        				}else
    		        				{
    		        					parametrosRequestVO.setFechaHasta(request.getParameter(param));
    		        				}
    							}else
    							{
    								if(param.equals("set"))
    								{
    									if(request.getParameterValues("set").length > 1)
    			        				{
    										if(logger.isDebugEnabled())logger.debug("En la peticion hay mas de un atributo set");
    			    						parametrosRequestVO.setErrorCode("badArgument");
            	        					parametrosRequestVO.setErrorDescripcion(OAIPMHProperties.ERR_SEVERAL_SET_DES);
    			        				}else
    			        				{
    			        					parametrosRequestVO.setIdentificadorConjunto(request.getParameter(param));
    			        				}
    								}else
    								{
    									if(param.equals("resumptionToken"))
    									{
    										if(logger.isDebugEnabled())logger.debug("resumptionToken");
    										if(request.getParameterValues("resumptionToken").length > 1)
    				        				{
    											if(logger.isDebugEnabled())logger.debug("En la peticion hay mas de un atributo resumptionToken");
    				    						parametrosRequestVO.setErrorCode("badArgument");
                	        					parametrosRequestVO.setErrorDescripcion(OAIPMHProperties.ERR_SEVERAL_RESUMPTIONTOKEN_DES);
    				        				}else
    				        				{
    				        					parametrosRequestVO.setCodigoPaginacion(request.getParameter(param));
    				        					if(logger.isDebugEnabled())logger.debug("parametrosRequestVO.getCodigoPaginacion() "+parametrosRequestVO.getCodigoPaginacion());
    				        				}
    									}else
    									{
    										//Se añade el parametro a la lista de parametros
    										listaParametros.add(param);
    									}
    								}
    							}
    						}
    					}
    				}
    			}
    		}
    		if(!(listaParametros == null) || !(listaParametros.size() == 0))
    		{
    			parametrosRequestVO.setParametros(listaParametros);
    		}
    		
    	}
    	
    	form.setParametrosRequestVO(parametrosRequestVO);
    }


    /**
     * @see es.pode.oaipmh.presentacion.pmhServer.OaiPmhServerController#obtenerRespuestaProtocolo(org.apache.struts.action.ActionMapping, es.pode.oaipmh.presentacion.pmhServer.ObtenerRespuestaProtocoloForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void obtenerRespuestaProtocolo(ActionMapping mapping, es.pode.oaipmh.presentacion.pmhServer.ObtenerRespuestaProtocoloForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try{
    	
	    	int tipoProtocolo = -1;
	        ResultadoOAIRequest resultadoOAIRequest = form.getResultadoOAIRequest();
	        ParametrosRequestVO parametrosRequestVO = form.getParametrosRequestVO();
	        dao = new OaiPmhDao();
	        OAIPMHAgrega oaipmh = new OAIPMHAgrega();
	        oaipmh.setResponseDate(new Date());
	        //Modificamos la fecha para que tenga granularidad diaria
	        if(logger.isDebugEnabled())logger.debug("oaipmh.getResponseDate() "+oaipmh.getResponseDate());
			Request requestOai = new Request();
			requestOai.setContent("http://"+request.getServerName()+request.getRequestURI());
			if(resultadoOAIRequest.getErrorCode() == null)
			{
				requestOai.setVerb(VerbType.valueOf(resultadoOAIRequest.getVerb()));
				if(logger.isDebugEnabled())logger.debug("La respuesta es correcta");
				if(resultadoOAIRequest.getVerb().equalsIgnoreCase("GetRecord"))
				{
					if(logger.isDebugEnabled())logger.debug("getRecord");
					ResultadoRecordVO resultadoRecordVO = resultadoOAIRequest.getGetRecord();
					if(logger.isDebugEnabled())logger.debug("resultadoRecordVO "+resultadoRecordVO);
					//Atributos de request
					requestOai.setIdentifier(parametrosRequestVO.getIdentificador());
					requestOai.setMetadataPrefix(parametrosRequestVO.getPrefijoMetadato());
					oaipmh.setRequest(requestOai);
					RecordAgrega record = new RecordAgrega();
					if(logger.isDebugEnabled())logger.debug("record "+record);
					//CABECERA
					RecordTypeHeader header = new RecordTypeHeader();
					header.setIdentifier(resultadoRecordVO.getIdRepositorio());    		
					if(logger.isDebugEnabled())logger.debug("header.getIdentifier() "+header.getIdentifier());
					//header.setDatestamp((new Date()).toString());
					header.setDatestamp(resultadoRecordVO.getFecha());
					record.setHeader(header);
					record.setMetadata(obtenerMetadato(parametrosRequestVO.getPrefijoMetadato(),resultadoRecordVO));
					oaipmh.setGetRecord(record);
					tipoProtocolo = 3;
	        }else
	        {
	        	if(resultadoOAIRequest.getVerb().equalsIgnoreCase("Identify"))
	        	{
	        		if(logger.isDebugEnabled())logger.debug("Identify");
	            	IdentifyVO identifyVO = resultadoOAIRequest.getIdentifyVO();
	            	oaipmh.setRequest(requestOai);
	            	Identify identify = new Identify();
	        		identify.setRepositoryName(identifyVO.getNombreRepositorio());
	        		if(logger.isDebugEnabled())logger.debug("identify.getRepositoryName() "+identify.getRepositoryName());
	        		identify.setBaseURL(identifyVO.getUrlRepositorio());
	        		if(logger.isDebugEnabled())logger.debug("oaipmh.getBaseURL() "+identify.getBaseURL());
	        		identify.setProtocolVersion(ProtocolVersionType.VALUE_0);
	        		if(logger.isDebugEnabled())logger.debug("identify.getProtocolVersion() "+identify.getProtocolVersion());
	        		identify.addAdminEmail(identifyVO.getEmailAdmin());
	        		if(logger.isDebugEnabled())logger.debug("oaipmh.getAdminEmailCount() "+identify.getAdminEmailCount());
	        		identify.setEarliestDatestamp(identifyVO.getFechaInicioRepositorio());
	        		if(logger.isDebugEnabled())logger.debug("oaipmh.getEarliestDatestamp() "+identify.getEarliestDatestamp());
	        		//No vamos a tener política de borrado
	        		if(logger.isDebugEnabled())logger.debug("identifyVO.getPoliticaBorrado() "+identifyVO.getPoliticaBorrado());
	        		identify.setDeletedRecord(DeletedRecordType.valueOf(identifyVO.getPoliticaBorrado()));
	        		if(logger.isDebugEnabled())logger.debug("identifyVO.getTemporalidad() "+identifyVO.getTemporalidad());
	        		identify.setGranularity(GranularityType.valueOf(identifyVO.getTemporalidad()));
	        		DescripcionOaiIdentifierVO descripcionOaiIdentifierVO = identifyVO.getDescripcionOaiIdentifier();
	        		OaiIdentifier oaiIdentifierType = new OaiIdentifier();
	        		oaiIdentifierType.setDelimiter(descripcionOaiIdentifierVO.getDelimitador());
	        		oaiIdentifierType.setRepositoryIdentifier(descripcionOaiIdentifierVO.getIdentificadorRepositorio());
	        		oaiIdentifierType.setSampleIdentifier(descripcionOaiIdentifierVO.getEjemploIdentificador());
	        		oaiIdentifierType.setScheme(descripcionOaiIdentifierVO.getEsquema());
	        		Description desc = new Description();
	        		desc.setAnyObject(oaiIdentifierType);
	        		identify.addDescription(desc);
	        		oaipmh.setIdentify(identify);	
	        		tipoProtocolo = 0;
	        	}else
	        	{
	        		if(resultadoOAIRequest.getVerb().equalsIgnoreCase("ListIdentifiers"))
	        		{
	        			if(logger.isDebugEnabled())logger.debug("ListIdentifiers");
	        			ResultadoHeaderVO[] resultadoHeaderVO = resultadoOAIRequest.getListIdentifiers();
	        			requestOai.setMetadataPrefix(parametrosRequestVO.getPrefijoMetadato());
	        			if(!(parametrosRequestVO.getFechaDesde() == null))
	        			{
	        				requestOai.setFrom(parametrosRequestVO.getFechaDesde());
	        			}
	        			if(!(parametrosRequestVO.getFechaHasta() == null))
	        			{
	        				requestOai.setUntil(parametrosRequestVO.getFechaHasta());
	        			}
	        			if(!(parametrosRequestVO.getIdentificadorConjunto() == null))
	        			{
	        				requestOai.setSet(parametrosRequestVO.getIdentificadorConjunto());
	        			}
	        			if(!(parametrosRequestVO.getCodigoPaginacion() == null))
	        			{
	        				requestOai.setResumptionToken(parametrosRequestVO.getCodigoPaginacion());
	        			}
	        			oaipmh.setRequest(requestOai);
	        			ListIdentifiers listIdentifiers = new ListIdentifiers();
	        			for(int i=0;i<resultadoHeaderVO.length;i++)
	        			{
	        				ListIdentifiersTypeHeader header = new ListIdentifiersTypeHeader();
	        				header.setIdentifier(resultadoHeaderVO[i].getIdentificador());
	        				header.setDatestamp((resultadoHeaderVO[i].getFecha()).toString());
	        				if(!(resultadoHeaderVO[i].getIdentificadorConjunto() == null))
	        				{
	        					header.setSetSpec(resultadoHeaderVO[i].getIdentificadorConjunto());
	        				}
	        				listIdentifiers.addListIdentifiersTypeHeader(header);
	        			}
	        			if(!(resultadoOAIRequest.getReanudacionToken() == null))
	        			{
	        				ReanudacionTokenVO reanudacionToken = resultadoOAIRequest.getReanudacionToken();
	        				ListIdentifiersTypeResumptionToken listIdentifiersTypeResumptionToken = new ListIdentifiersTypeResumptionToken();
	        				listIdentifiersTypeResumptionToken.setExpirationDate(reanudacionToken.getFechaExpiracion().getTime() );
	        				listIdentifiersTypeResumptionToken.setCompleteListSize((new Long((reanudacionToken.getTamanio()).toString())).longValue());
	        				listIdentifiersTypeResumptionToken.setContent(reanudacionToken.getIdentificador());
	        				listIdentifiersTypeResumptionToken.setCursor((new Long((reanudacionToken.getCursor()).toString())).longValue());
	        				listIdentifiers.setListIdentifiersTypeResumptionToken(listIdentifiersTypeResumptionToken);
	        			}
	        			oaipmh.setListIdentifiers(listIdentifiers);
	        			tipoProtocolo = 4;
	        			
	        		}else
	        		{
	        			if(resultadoOAIRequest.getVerb().equalsIgnoreCase("ListMetadataFormats"))
	        			{
	        				if(logger.isDebugEnabled())logger.debug("ListMetadataFormats");
	        				ListMetadataFormatVO[] listMetadataFormat = resultadoOAIRequest.getListMetadataFormat();
	        				if(!(parametrosRequestVO.getIdentificador() == null))
	            			{
	            				requestOai.setIdentifier(parametrosRequestVO.getIdentificador());
	            				if(logger.isDebugEnabled())logger.debug("requestOai.getIdentifier() "+requestOai.getIdentifier());
	            			}
	            			
	                		oaipmh.setRequest(requestOai);
	                		ListMetadataFormats listMetadataFormats= new ListMetadataFormats();
	                		for(int i=0;i<listMetadataFormat.length;i++)
	                		{
	                			MetadataFormat meta = new MetadataFormat();
	                			meta.setMetadataPrefix(listMetadataFormat[i].getNombreMetadato());
	                			meta.setSchema(listMetadataFormat[i].getEsquema());
	                			meta.setMetadataNamespace(listMetadataFormat[i].getEspacioNombres());
	                			listMetadataFormats.addMetadataFormat(meta);
	                		}
	                		oaipmh.setListMetadataFormats(listMetadataFormats);
	                		tipoProtocolo = 1;
	        			}else
	        			{
	        				if(resultadoOAIRequest.getVerb().equalsIgnoreCase("ListRecords"))
	        				{
	        					if(logger.isDebugEnabled())logger.debug("ListRecords");
	        					ResultadoRecordVO[] resultadoRecordVO = resultadoOAIRequest.getListRecords();
	        					if(parametrosRequestVO.getPrefijoMetadato() == null)
	        					{
	        						requestOai.setMetadataPrefix("oai_dc");
	        					}else
	        					{
	        						requestOai.setMetadataPrefix(parametrosRequestVO.getPrefijoMetadato());
	        					}
	        					
	                			if(!(parametrosRequestVO.getFechaDesde() == null))
	                			{
	                				requestOai.setFrom(parametrosRequestVO.getFechaDesde());
	                			}
	                			if(!(parametrosRequestVO.getFechaHasta() == null))
	                			{
	                				requestOai.setUntil(parametrosRequestVO.getFechaHasta());
	                			}
	                			if(!(parametrosRequestVO.getIdentificadorConjunto() == null))
	                			{
	                				requestOai.setSet(parametrosRequestVO.getIdentificadorConjunto());
	                			}
	                			if(!(parametrosRequestVO.getCodigoPaginacion() == null))
	                			{
	                				requestOai.setResumptionToken(parametrosRequestVO.getCodigoPaginacion());
	                			}
	                    		oaipmh.setRequest(requestOai);
	                    		ListRecordsAgrega listRecordsAgrega = new ListRecordsAgrega();
	                    		ListRecords listRe=new ListRecords();
	                    		ListRecordsTypeRecord[]  aRecord =new ListRecordsTypeRecord[resultadoRecordVO.length];
	                    		
	                    		if(logger.isDebugEnabled())logger.debug("ResultadoRecordVO[0] es "+resultadoRecordVO[0].getIdentificador()[0]);
	                    		if(logger.isDebugEnabled())logger.debug("ResultadoRecordVO[1] es "+resultadoRecordVO[1].getIdentificador()[0]);
	                    		ListRecordsTypeResumptionToken listRecordssTypeResumptionToken = new ListRecordsTypeResumptionToken();
	                    		for(int i=0;i<resultadoRecordVO.length;i++)
	                    		{
	                    			
	                    			aRecord[i] = new ListRecordsTypeRecord();
	                    			if(logger.isDebugEnabled())logger.debug("El resultadoRecordVO numero "+i);
	                    			RecordTypeHeader header = new RecordTypeHeader();
	                    			header.setIdentifier(resultadoRecordVO[i].getIdRepositorio());
	                    			if(logger.isDebugEnabled())logger.debug("El identifier es resultadoRecordVO numero "+header.getIdentifier());
	                    			header.setDatestamp((resultadoRecordVO[i].getFecha()).toString());
                    	
	                    			aRecord[i].setRecordTypeHeader(header);
	                    			Metadata meta=new Metadata();
	                    			meta.setAnyObject(obtenerMetadato(parametrosRequestVO.getPrefijoMetadato(),resultadoRecordVO[i]));
	                    			aRecord[i].setMetadata(meta);
	                    		}
	                    		listRe.setListRecordsTypeRecord(aRecord);
	                    		listRecordsAgrega.setListRecords(listRe);
	                    		if(logger.isDebugEnabled())logger.debug("El listRecordsAgrega tiene ["+listRecordsAgrega.getRecords().length+ "]elementos");
	                    		//ResumptionToken
	                    		if(!(resultadoOAIRequest.getReanudacionToken() == null))
	                			{
	                				ReanudacionTokenVO reanudacionToken = resultadoOAIRequest.getReanudacionToken();
	                				if(logger.isDebugEnabled())logger.debug("El reanudacionToken es ["+reanudacionToken+ "]");
	                				
	                				if(reanudacionToken.getFechaExpiracion()!=null){
	                					listRecordssTypeResumptionToken.setExpirationDate(reanudacionToken.getFechaExpiracion().getTime() );
	                					if(logger.isDebugEnabled())logger.debug("La fecha de expiracion ["+listRecordssTypeResumptionToken.getExpirationDate()+ "]");
	                				}
	                				if(reanudacionToken.getTamanio()!=null){
		                				listRecordssTypeResumptionToken.setCompleteListSize((new Long((reanudacionToken.getTamanio()).toString())).longValue());
		                				if(logger.isDebugEnabled())logger.debug("El tamaino ["+listRecordssTypeResumptionToken.getCompleteListSize()+ "]");
	                				}
	                				if(reanudacionToken.getIdentificador()!=null){
		                				listRecordssTypeResumptionToken.setContent(reanudacionToken.getIdentificador());
		                				if(logger.isDebugEnabled())logger.debug("El identificador ["+listRecordssTypeResumptionToken.getContent()+ "]");
	                				}
	                				if(reanudacionToken.getCursor()!=null){
		                				listRecordssTypeResumptionToken.setCursor((new Long((reanudacionToken.getCursor()).toString())).longValue());
		                				if(logger.isDebugEnabled())logger.debug("El cursor ["+listRecordssTypeResumptionToken.getCursor()+ "]");
	                				}
	                				
	                				listRecordsAgrega.setResumptionToken(listRecordssTypeResumptionToken);
	                				if(logger.isDebugEnabled())logger.debug("Lo introducimos en el listRecordsAgrega ["+listRecordsAgrega.getResumptionToken()+"]");
	                			}
	                    		oaipmh.setListRecords(listRecordsAgrega);
	                    		tipoProtocolo = 5;
	        				}else
	        				{
	        					if(resultadoOAIRequest.getVerb().equalsIgnoreCase("ListSets"))
	        					{
	        						if(logger.isDebugEnabled())logger.debug("ListSets");
	        						requestOai.setVerb(VerbType.LISTSETS);
	                        		ListSets listSets= new ListSets();
	        						SetVO[] setVO = resultadoOAIRequest.getListSets();
	        						for(int i=0;i<setVO.length;i++)
	        						{
	        							Set set = new Set();
	        							set.setSetName(setVO[i].getNombre());
	        							set.setSetSpec(setVO[i].getIdentificador());	
	        							listSets.addSet(set);
	        						}
	        						oaipmh.setListSets(listSets);
	        						tipoProtocolo = 2;
	        					}
	        				}
	        			}
	        		}
	        	}
	        }
			}else
			{
				if(!(resultadoOAIRequest.getErrorCode().equalsIgnoreCase(OAIPMHProperties.ERR_BAD_VERB)))
				{
					if(logger.isDebugEnabled())logger.debug("Se añade el tipo de verb a la request cuando el error no sea del tipo badVerb");
					requestOai.setVerb(VerbType.valueOf(resultadoOAIRequest.getVerb()));
					//Añado los parámetros de la petición a la request
					if(!(parametrosRequestVO.getFechaDesde() == null))
					{
						requestOai.setFrom(parametrosRequestVO.getFechaDesde());
					}
					if(!(parametrosRequestVO.getFechaHasta() == null))
					{
						requestOai.setUntil(parametrosRequestVO.getFechaHasta());
					}
					if(!(parametrosRequestVO.getIdentificador() == null))
					{
						requestOai.setIdentifier(parametrosRequestVO.getIdentificador());
					}
					if(!(parametrosRequestVO.getPrefijoMetadato() == null))
					{
						requestOai.setMetadataPrefix(parametrosRequestVO.getPrefijoMetadato());
					}
					if(!(parametrosRequestVO.getCodigoPaginacion() == null))
					{
						requestOai.setResumptionToken(parametrosRequestVO.getCodigoPaginacion());
					}
					if(!(parametrosRequestVO.getIdentificadorConjunto() == null))
					{
						requestOai.setResumptionToken(parametrosRequestVO.getIdentificadorConjunto());
					}
							
					
				}
				if(logger.isDebugEnabled())logger.debug("la respuesta del protoco es erronea");
				oaipmh.setRequest(requestOai);
				if(logger.isDebugEnabled())logger.debug("oaipmh.getRequest() "+oaipmh.getRequest());
	    		Error error = new Error();
	    		error.setCode(OAIPMHerrorcodeType.valueOf(resultadoOAIRequest.getErrorCode()));
	    		if(logger.isDebugEnabled())logger.debug("resultadoOAIRequest.getErrorDescripcion() "+resultadoOAIRequest.getErrorDescripcion());
	    		error.setContent(resultadoOAIRequest.getErrorDescripcion());	
	    		oaipmh.addError(error);
	    		tipoProtocolo = 6;
			}
	         
	        
	        //Obtenemos el xml codificado en oai-pmh
	    		try {
	    			if(logger.isDebugEnabled())logger.debug("Escribimos el xml en la response");
	    			response.setContentType("text/xml");
	    			response.setCharacterEncoding("UTF-8");
	    			if(logger.isDebugEnabled())logger.debug("TipoProtocolo "+tipoProtocolo);
	    		//	dao.escribirOAIPMH(oaipmh, response.getOutputStream(), tipoProtocolo);
	    		//El xml de la respuesta se escribirá primero en un fichero para poder modificar el valor de la etiqueta <responseDate>
	    			if(logger.isDebugEnabled())logger.debug("FICHERO TEMPORAL "+SitemapPropertiesImpl.getInstance().getProperty(SitemapPropertiesImpl.DIRECTORIO_FICHEROS_SITEMAP)+OAIPMHProperties.getPropertyValue(OAIPMHProperties.KEY_FICHERO_XML));
	    			dao.escribirOAIPMH(oaipmh, new File(SitemapPropertiesImpl.getInstance().getProperty(SitemapPropertiesImpl.DIRECTORIO_FICHEROS_SITEMAP)+OAIPMHProperties.getPropertyValue(OAIPMHProperties.KEY_FICHERO_XML)), tipoProtocolo);
	    			if(logger.isDebugEnabled())logger.debug("Se ha escrito el xml en el fichero");
	    			(response.getOutputStream()).print(obtenerFechaResponseEnXML());
	    		//El fichero con el xml será eliminado
	    			UtilesFicheros.eliminar(new File(SitemapPropertiesImpl.getInstance().getProperty(SitemapPropertiesImpl.DIRECTORIO_FICHEROS_SITEMAP)+OAIPMHProperties.getPropertyValue(OAIPMHProperties.KEY_BARRA)+OAIPMHProperties.getPropertyValue(OAIPMHProperties.KEY_FICHERO_XML)));
	    			if(logger.isDebugEnabled())logger.debug("Se ha eliminado correctamente el fichero xml");
	    		} catch (ParseadorException e1) {
	    			logger.error("Se ha producido una excepcion "+e1);
	    			e1.printStackTrace();
	    		}
    	}catch( Exception e){
    		logger.error("ERROR en el metodo obtenerRespuestaProtocolo",e);
    		throw e;
    	}
    		
         
    }


   

    
    /**
	 * Recoge un literal del archivo properties referenciando el codigo de
	 * dicho literal
	 * 
	 * @param sKey
	 *                codigo del literal
	 * @return String String con el literal
	 * @throws IOException
	 */
	private String getPropertyValue(String sKey) throws IOException
	{
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/oaiPmh.properties");
		if (this.pOaiPmhProperties == null)
		{
			pOaiPmhProperties = new java.util.Properties();
			pOaiPmhProperties.load(fIsSpringProperties);
		}
		fIsSpringProperties.close();

		// devolvemos la propiedad
		return pOaiPmhProperties.getProperty(sKey);
	}

	/**
	 * Valida la fecha que recibe como parámetro
	 * @param sKey fecha a validar
	 * @return Boolean
	 * @throws IOException
	 */
	 private String obtenerFechaValida(Date fecha) throws IOException{
		 if(logger.isDebugEnabled()){
			 logger.debug("obtenerFechaValida");
		 	 logger.debug("granularidad "+OAIPMHProperties.getPropertyValue(OAIPMHProperties.VALUE_GRANULARIDAD_YYYYMMDD));
		 }
			//SimpleDateFormat formatter = new SimpleDateFormat(OAIPMHProperties.getPropertyValue(OAIPMHProperties.VALUE_GRANULARIDAD_YYYYMMDD));
		 	
			String resultado = null;

			try {
									
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
				sdf.applyPattern("yyyy-MM-dd'T'hh:mm:ss'Z'");
				if(logger.isDebugEnabled())logger.debug("despues de applyPattern");
				resultado = sdf.format(new Date());
				if(logger.isDebugEnabled())logger.debug("la fecha ahora vale "+resultado);
				
				
			}
			catch (Exception pe) {
				logger.error("excepcion en la validacion de la fecha "+pe);
				
			}
			
			return resultado;
		    }
	 
	 /**
		 * Valida la fecha que recibe como parámetro
		 * @param sKey fecha a validar
		 * @return Boolean
		 * @throws IOException
		 */
		 private boolean validaFecha(String str) throws IOException{
			 if(logger.isDebugEnabled())logger.debug("validaFecha");
			 	String granularidad = null;
			 	granularidad = OAIPMHProperties.getPropertyValue(OAIPMHProperties.KEY_GRANULARIDAD_FORMATER);
			 	if(logger.isDebugEnabled())logger.debug("granularidad "+granularidad);
				SimpleDateFormat formatter = new SimpleDateFormat(granularidad);
				if(logger.isDebugEnabled())logger.debug("La fecha a validar es "+str);
				boolean resultado = true;
			    //Validamos la longitud de la fecha para ver si concuerda con el formato
				if(!(str.length() == granularidad.length()))
				{
					if(logger.isDebugEnabled())logger.debug("Tienen distinta longitud no se corresponde con la granularidad");
					resultado = false;
				}else 
				{
								
				
					try {
						Date fechaValidada = formatter.parse(str);
						if(logger.isDebugEnabled())logger.debug("fechaValida "+fechaValidada);
					
					}
					catch (ParseException pe) {
						logger.error("excepcion en la validacion de la fecha "+pe);
						resultado = false;
					}
					if(logger.isDebugEnabled())logger.debug("resultado es "+resultado);
				}
				return resultado;
			    }
			 
	 
	/**
	* Valida si cada llamada del protocolo recibe los parametros que necesita
	* @param  parametros VO con los datos que se pasan por parámetro
	* @param  tipoPeticion método del protocolo Oai-Pmh
	* @return String
	*/
	 
	 private String validaParametros(ParametrosRequestVO parametros, String tipoPeticion)
	 {
		 String resultado = "ok";
		 if(logger.isDebugEnabled())logger.debug("validaParametros");
		 if(parametros.getParametros().size() > 0)
		 {
			 if(logger.isDebugEnabled())logger.debug("En la peticion nos han pasado parametros no reconocidos por el repositorio");
			 resultado = "badArgument";
		 }else
		 {
			 //Segun sea el tipo de llamada comprobaré que únicamente recibo los parámetros que necesito
			 if(tipoPeticion.equalsIgnoreCase("GetRecord"))
			 {
				if(!(parametros.getCodigoPaginacion() == null) || !(parametros.getFechaDesde() == null) || !(parametros.getFechaHasta() == null) || !(parametros.getIdentificadorConjunto() == null))
				{
					if(logger.isDebugEnabled())logger.debug("Se pasan al metodo GetRecord más parámetros de los necesarios");
					resultado = "badArgument";
				}
			 }else
			 {
				 if((tipoPeticion.equalsIgnoreCase("ListRecords")) || (tipoPeticion.equalsIgnoreCase("ListIdentifiers")))
				{
					 if(parametros.getIdentificador() != null)
					 {
						 if(logger.isDebugEnabled())logger.debug("Se pasan al método ListRecords o ListIdentifiers más parámetros de los necesarios");
						resultado = "badArgument";
					 }
					
				}else
				{
					if(tipoPeticion.equalsIgnoreCase("ListSets"))
					{
						if(!(parametros.getFechaDesde() == null) || !(parametros.getFechaHasta() == null) || !(parametros.getIdentificador() == null) || !(parametros.getIdentificadorConjunto() == null) || !(parametros.getPrefijoMetadato() == null))
						{
							if(logger.isDebugEnabled())logger.debug("Se pasan al método ListSets más parámetros de los necesarios");
							resultado = "badArgument";
						}
					}else
					{
						if(tipoPeticion.equalsIgnoreCase("Identify"))
						{
							if(logger.isDebugEnabled())logger.debug("identify");
							if(!(parametros.getCodigoPaginacion() ==null) || !(parametros.getFechaDesde() ==null) || !(parametros.getFechaHasta() ==null) || !(parametros.getIdentificador() ==null) || !(parametros.getIdentificadorConjunto() ==null) || !(parametros.getPrefijoMetadato() ==null))
							{
								if(logger.isDebugEnabled())logger.debug("Se pasan al método Identify más parámetros de los necesarios");
								resultado = "badArgument";
							}
						}else
						{
							if(tipoPeticion.equalsIgnoreCase("ListMetadataFormats"))
							{
								if(!(parametros.getCodigoPaginacion() ==null) || !(parametros.getFechaDesde() ==null) || !(parametros.getFechaHasta() ==null) || !(parametros.getIdentificadorConjunto() ==null) || !(parametros.getPrefijoMetadato() ==null))
								{
									if(logger.isDebugEnabled())logger.debug("Se pasan al método ListMetadataFormats más parámetros de los necesarios");
									resultado = "badArgument";
								}
							}
						}
					}
				}
			 }
		 }
		return resultado;
	 }
	 
	 /**
		* Devuelve el tipo de metadato codificado en el lenguage que se pase por parámetro: dublincore, perseus,...
		* @param  resultadoRecordVO VO con la información del registro
		* @param  lenguage String con el lenguage en el que se codificará la etiqueta metadato
		* @return Object 
		*/
	 
	 private Object obtenerMetadato(String lenguage,ResultadoRecordVO resultadoRecordVO)
	 {
		
		 Object resultado = null;
		 if((lenguage == null)||(lenguage.equalsIgnoreCase("oai_dc"))) //El lenguage puede ser null en aquellas peticiones que nos pasen el resumptionToken
		 {
			 
			 if(logger.isDebugEnabled())logger.debug("METADATOS EN DUBLINCORE"); 
		 //METADATOS EN DUBLIN CORE
			Dc dublincore = new Dc();
			
			//title
			if(!(resultadoRecordVO.getTitulo() == null))
			{
				if(logger.isDebugEnabled())logger.debug("añadir el titulo");
				Oai_dcTypeItem item = new Oai_dcTypeItem();
				DcTitle titulo =new DcTitle();
				titulo.setContent(resultadoRecordVO.getTitulo());
				if(logger.isDebugEnabled())logger.debug(" titulo.getContent() "+titulo.getContent());
				item.setDcTitle(titulo);
				dublincore.addOai_dcTypeItem(item);
			}
			
			//creator
			if(!(resultadoRecordVO.getAutores() == null))
			{
				Oai_dcTypeItem item = new Oai_dcTypeItem();
				if(logger.isDebugEnabled())logger.debug("añadir el creator");
				String autores="";
       	 		for(int j=0;j<resultadoRecordVO.getAutores().length;j++)//Todos los autores en uno
       	 		{
       	 			autores=autores+resultadoRecordVO.getAutores()[j]+" ";	
       	 			if(logger.isDebugEnabled())logger.debug("El autor numero "+j+" es:["+resultadoRecordVO.getAutores()[j]+"]");
       	 		}
       	 		
       	 		DcCreator creador = new DcCreator();
	 			creador.setContent(autores);
	 			item.setDcCreator(creador);
	 			dublincore.addOai_dcTypeItem(item);
//				for(int j=0;j<resultadoRecordVO.getAutores().length;j++)//Los autores uno a uno
//       	 		{
//					Oai_dcTypeItem itemAut = new Oai_dcTypeItem();
//	       	 		DcCreator creator = new DcCreator();
//	       	 		creator.setContent((resultadoRecordVO.getAutores()[j]));
//	       	 		itemAut.setDcCreator(creator);
//	       	 		dublincore.addOai_dcTypeItem(itemAut);
//       	 		}
			}
			
       	 	//subject
       	 	if(!(resultadoRecordVO.getTema() == null))
       	 	{
	       	 	if(logger.isDebugEnabled())logger.debug("añadir el subject");
       	 		for(int j=0;j<resultadoRecordVO.getTema().length;j++)
       	 		{
	       	 		Oai_dcTypeItem itemAut = new Oai_dcTypeItem();
	       	 		DcSubject subject = new DcSubject();
	       	 		subject.setContent((resultadoRecordVO.getTema()[j]));
	       	 		if(logger.isDebugEnabled())logger.debug("El tema numero "+j+" es ["+subject.getContent()+"]");
	       	 		itemAut.setDcSubject(subject);
	       	 		dublincore.addOai_dcTypeItem(itemAut);
    		
       	 		}
	       	 }
       	 	
       	 	//coverage
       	 	if(!(resultadoRecordVO.getAmbito() == null))
       	 	{
	       	 	if(logger.isDebugEnabled())logger.debug("añadir el coverage");
	       	 	for(int j=0;j<resultadoRecordVO.getAmbito().length;j++)
	       	 	{
	       	 		Oai_dcTypeItem item = new Oai_dcTypeItem();
	       	 		DcCoverage coverage = new DcCoverage();
	       	 		coverage.setContent((resultadoRecordVO.getAmbito()[j]));
	       	 		if(logger.isDebugEnabled())logger.debug("El ambito numero "+j+" es ["+coverage.getContent()+"]");
	       	 		item.setDcCoverage(coverage);
	       	 		dublincore.addOai_dcTypeItem(item);
	       	 	}
       	 	
       	 	}
       	 //contributor
       	 	if(!(resultadoRecordVO.getContribuidor() == null))
       	 	{
	       	 	if(logger.isDebugEnabled())logger.debug("añadir el contributor");
	       	 	for(int j=0;j<resultadoRecordVO.getContribuidor().length;j++)
	       	 	{
	       	 		Oai_dcTypeItem item = new Oai_dcTypeItem();
	       	 		DcContributor contributor = new DcContributor();
	       	 		contributor.setContent((resultadoRecordVO.getContribuidor()[j]));
	       	 		if(logger.isDebugEnabled())logger.debug("La contribucion numero "+j+" es ["+contributor.getContent()+"]");
	       	 		item.setDcContributor(contributor);
	       	 		dublincore.addOai_dcTypeItem(item);
	       	 	}
       	 	
       	 	}
       	 //rights
       	 	if(!(resultadoRecordVO.getDerechos() == null))
       	 	{
       	 		if(logger.isDebugEnabled())logger.debug("añadir los rights");
	       	 	for(int j=0;j<resultadoRecordVO.getDerechos().length;j++)
	       	 	{
	       	 		Oai_dcTypeItem item = new Oai_dcTypeItem();
	       	 		DcRights rights = new DcRights();
	       	 		rights.setContent((resultadoRecordVO.getDerechos()[j]));
	       	 		if(logger.isDebugEnabled())logger.debug("El derecho numero "+j+" es ["+rights.getContent()+"]");
	       	 		item.setDcRights(rights);
	       	 		dublincore.addOai_dcTypeItem(item);
	  		
	       	 	}
       	 	
       	 	}
       	//description
       	 	if(!(resultadoRecordVO.getDescripcion() == null))
       	 	{
       	 		if(logger.isDebugEnabled())logger.debug("añadir la description");
       	 		Oai_dcTypeItem item = new Oai_dcTypeItem();
       	 		DcDescription descripcion = new DcDescription();
       	 		descripcion.setContent(resultadoRecordVO.getDescripcion());
       	 		if(logger.isDebugEnabled())logger.debug(" descripcion.getContent() "+descripcion.getContent());
       	 		item.setDcDescription(descripcion);
       	 		dublincore.addOai_dcTypeItem(item);
       	 	}
       	//date
       	 	if(!(resultadoRecordVO.getFecha() == null))
       	 	{
       	 		if(logger.isDebugEnabled())logger.debug("añadir el date");
       	 		Oai_dcTypeItem item = new Oai_dcTypeItem();
       	 		DcDate date = new DcDate();
       	 		date.setContent((resultadoRecordVO.getFecha()).toString());
       	 		if(logger.isDebugEnabled())logger.debug(" date.getContent() "+date.getContent());
       	 		item.setDcDate(date);
       	 		dublincore.addOai_dcTypeItem(item);
       	 	}
       	//format
       	 	if(!(resultadoRecordVO.getFormatos() == null))
       	 	{
       	 		if(logger.isDebugEnabled())logger.debug("añadir los format");
	       	 	for(int j=0;j<resultadoRecordVO.getFormatos().length;j++)
	       	 	{
	       	 		
	       	 		Oai_dcTypeItem itemAut = new Oai_dcTypeItem();
	       	 		DcFormat format = new DcFormat();
	       	 		format.setContent((resultadoRecordVO.getFormatos()[j]));
	       	 		if(logger.isDebugEnabled())logger.debug("El formato numero "+j+" es ["+format.getContent()+"]");
	       	 		itemAut.setDcFormat(format);
	       	 		dublincore.addOai_dcTypeItem(itemAut);
	       	 	}
       	 	}
       	//source
       	 	if(!(resultadoRecordVO.getFuente() == null))
       	 	{
       	 		if(logger.isDebugEnabled())logger.debug("añadir los sources");
	       	 	for(int j=0;j<resultadoRecordVO.getFuente().length;j++)
	       	 	{
	       	 		Oai_dcTypeItem item = new Oai_dcTypeItem();
	       	 		DcSource source = new DcSource();
	       	 		source.setContent((resultadoRecordVO.getFuente()[j]));
	       	 		if(logger.isDebugEnabled())logger.debug("La fuente "+j+" es ["+source.getContent()+"]");
	       	 		item.setDcSource(source);
	       	 		dublincore.addOai_dcTypeItem(item);
	       	 	}
       	 	
       	 	}
       	//publisher
       	 	if(!(resultadoRecordVO.getPublicador() == null))
       	 	{
       	 		if(logger.isDebugEnabled())logger.debug("añadir los publisher");
       	 		Oai_dcTypeItem item = new Oai_dcTypeItem();
       	 		String publicadores="";
	       	 	for(int j=0;j<resultadoRecordVO.getPublicador().length;j++)
	       	 	{
	       	 		publicadores=publicadores+resultadoRecordVO.getPublicador()[j]+" ";//Todos los publicadores a la vez
	       	 		if(logger.isDebugEnabled())logger.debug("El publicador numero "+j+" es:["+resultadoRecordVO.getPublicador()[j]+"]");
//		       	 	Oai_dcTypeItem itemAut = new Oai_dcTypeItem();
//		       	 	DcPublisher publisher = new DcPublisher();
//		       	 	publisher.setContent((resultadoRecordVO.getPublicador()[j]));
//		       	 	itemAut.setDcPublisher(publisher);
//		   	 		dublincore.addOai_dcTypeItem(itemAut);
	        	}
	       	 DcPublisher publisher = new DcPublisher();
	       	 publisher.setContent(publicadores);
	       	 item.setDcPublisher(publisher);
	       	 dublincore.addOai_dcTypeItem(item);
       	 	}
       	//relation
       	 	if(!(resultadoRecordVO.getRelacion() == null))
       	 	{
       	 		if(logger.isDebugEnabled())logger.debug("añadir los relation");
	       	 	for(int j=0;j<resultadoRecordVO.getRelacion().length;j++)
	       	 	{
	       	 		Oai_dcTypeItem item = new Oai_dcTypeItem();
	       	 		DcRelation relation = new DcRelation();
	       	 		relation.setContent((resultadoRecordVO.getRelacion()[j]));
	       	 		if(logger.isDebugEnabled())logger.debug("La relacion "+j+" es ["+relation.getContent()+"]");
	       	 		item.setDcRelation(relation);
	       	 		dublincore.addOai_dcTypeItem(item);
	        	}
       	 	
       	 	}
       	
       	//type
       	 	if(!(resultadoRecordVO.getTipo() == null))
       	 	{
       	 		if(logger.isDebugEnabled())logger.debug("añadir los type");
	       	 	for(int j=0;j<resultadoRecordVO.getTipo().length;j++)
	       	 	{
		       	 	Oai_dcTypeItem itemAut = new Oai_dcTypeItem();
		       	 	DcType type = new DcType();
	    	 		type.setContent((resultadoRecordVO.getTipo()[j]));
	    	 		if(logger.isDebugEnabled())logger.debug("El tipo "+j+" es ["+type.getContent()+"]");
		       	 	itemAut.setDcType(type);
		   	 		dublincore.addOai_dcTypeItem(itemAut);
	        	}
       	 	}
       	//identifier
       	 	if(!(resultadoRecordVO.getIdentificador() == null))
       	 	{
       	 		if(logger.isDebugEnabled())logger.debug("añadir los identifier");
       	 		for(int j=0;j<resultadoRecordVO.getIdentificador().length;j++)
       	 		{
       	 			Oai_dcTypeItem item = new Oai_dcTypeItem();
       	 			DcIdentifier identifier = new DcIdentifier();
       	 			identifier.setContent(resultadoRecordVO.getIdentificador()[j]);
       	 			if(logger.isDebugEnabled())logger.debug("El identificador "+j+" es ["+identifier.getContent()+"]");
       	 			item.setDcIdentifier(identifier);
       	 			dublincore.addOai_dcTypeItem(item);
       	 		}
       	 		
       	 	}
       	//language
       	 	if(!(resultadoRecordVO.getIdioma() == null))
       	 	{
       	 		Oai_dcTypeItem item = new Oai_dcTypeItem();
       	 		DcLanguage language = new DcLanguage();
       	 		language.setContent(resultadoRecordVO.getIdioma());
       	 		if(logger.isDebugEnabled())logger.debug("añadir el idioma ["+language.getContent()+"]");
       	 		item.setDcLanguage(language);
       	 		dublincore.addOai_dcTypeItem(item);
       	 	}
       	 	
       	 	resultado = dublincore;
		 }
       	
       	return resultado;
	 }
	 
	 /**
		* Obtiene el tipo Date asociado a la cadena que se manda por parámetro
		* @param  String con la fecha
		* @return Date 
		*/
	 private Date getFecha(String fecha)
	 {
		Date resultado = null;
		if(!(fecha == null))
		{
			int anio = new Integer(fecha.substring(0,4)).intValue();
			int mes = new Integer(fecha.substring(5,7)).intValue() -1;
			int dia = new Integer(fecha.substring(8,10)).intValue();
			resultado = (new GregorianCalendar(anio,mes,dia)).getTime();
		}
		if(logger.isDebugEnabled())logger.debug("[getFecha] "+resultado);
		return resultado;
	 }
	 
	 private boolean comparacionFechas(String fDesde, String fHasta)
		{
		 
			Date fechaDesde = null;
			Date fechaHasta = null;
			
			if(!(fDesde == null))
			{
				fechaDesde = this.getFecha(fDesde);
				if(logger.isDebugEnabled())logger.debug("fecha Desde : " + fechaDesde.toString());
			}
			if(!(fHasta == null))
			{
				fechaHasta = this.getFecha(fHasta);
				if(logger.isDebugEnabled())logger.debug("fecha Hasta : " + fechaHasta.toString());
			}
						
	        
	        if(fechaDesde == null || fechaHasta == null || fechaDesde.before(fechaHasta) || fechaDesde.equals(fechaHasta))
	        	return true;
	        else
	        	return false;
		}
	 
	 private String obtenerFechaResponseEnXML()
	 {
		 String strLine;
	     String resultado = "";
	     if(logger.isDebugEnabled())logger.debug("obtenerFechaResponseEnXML");
		 try
		 {
		
		  FileInputStream fstream = new FileInputStream(SitemapPropertiesImpl.getInstance().getProperty(SitemapPropertiesImpl.DIRECTORIO_FICHEROS_SITEMAP)+OAIPMHProperties.getPropertyValue(OAIPMHProperties.KEY_FICHERO_XML));
	      // Get the object of DataInputStream
	      DataInputStream in = new DataInputStream(fstream);
	      BufferedReader br = new BufferedReader(new InputStreamReader(in));
	      
	      while ((strLine = br.readLine()) != null)
	      {
	    	  if(strLine.indexOf("<responseDate>") != -1)
	    	  {
	    		  if(logger.isDebugEnabled())logger.debug("Transformo la fecha");
	    		 strLine = "<responseDate>"+obtenerFechaValida(new Date())+"</responseDate>";
	    	  }
	    	  resultado = resultado + strLine;
	      }
	      //Close the input stream
	     
	      in.close();
		 }catch(Exception e)
		 {
			 logger.error("Exception en la transformacion de la fecha del xml "+e);
		 }
		return resultado;
	 }



}