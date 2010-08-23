/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
//license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.dri.negocio.servicios.SQI;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import es.pode.dri.negocio.dominio.Consulta;
import es.pode.dri.negocio.dominio.ConsultaDao;
import es.pode.dri.negocio.dominio.ConsultaPorSesionCriteria;

import es.pode.dri.negocio.servicios.ConsultaVO;
import es.pode.dri.negocio.servicios.SesionVO;


/**
 * @see es.pode.dri.negocio.servicios.SQI.SrvSQIService
 */

public class SrvSQIServiceImpl
extends es.pode.dri.negocio.servicios.SQI.SrvSQIServiceBase
{

	private Logger logger = Logger.getLogger(this.getClass());
	private static Properties props = null;
	/**
	 * Devuelve el numero total de resultados disponibles para una query.
	 * Si la query ya se ha ejecutado, intentamos averiguar dicha informacion sin necesidad de ejecutarla.
	 * Se tiene que comprobar que dicha sesion existe antes de modificarla.
     * @param targetSessionID Identificador de la sesion sobre la que se realiza la operacion.   
     * @param queryStatement Query de la que se quiere saber cuantos resultados dispobibles hay.
     * @return se retorna el numero total de resultados disponibles para una query.
     * @throws Exception
     *      
     */
	protected java.lang.Integer handleGetTotalResultsCount(java.lang.String targetSessionID, java.lang.String queryStatement)
	throws java.lang.Exception
	{
		try 
		{
			if(logger.isDebugEnabled())logger.debug("SrvSQIServiceImpl- handleGetTotalResultsCount con targetSessionID ["+targetSessionID+"] y el queryStatement ["+queryStatement);
			SesionVO sesion = this.getSrvSesionesService().consultaSesion(targetSessionID);
			ConsultaDao consultaDao = this.getConsultaDao();
			List consulta= consultas(targetSessionID,consultaDao);
			Consulta consultaActiva;
//			si no tiene consulta se la creo, por buenas costumbres
			if (consulta == null || consulta.size()<=0) 
			{
				ConsultaVO nuevaConsulta= new ConsultaVO();
				nuevaConsulta.setSesion(sesion);
				consultaDao.create(this.getConsultaDao().fromConsultaVO(nuevaConsulta));
				if(logger.isDebugEnabled())logger.debug("Consulta de sesion ["+targetSessionID+"] creada");
			}
//			Ya tengo una consulta asociada a la sesion, llamo al servicio que resuelve la busqueda y me dira
//			cuantos resultados ha devuelto
			if(logger.isDebugEnabled())logger.debug("La primera llamada a la syncrhronousQuery con startResults 1");
			this.getSrvSQISincronoService().synchronousQuery(targetSessionID, queryStatement, new Integer(1));
//			Ahora consulto el objeto consulta para que obtener el numero de resultados que se han obtenido
			consulta= consultas(targetSessionID,consultaDao);
			consultaActiva = (Consulta)consulta.get(0);
			if(logger.isDebugEnabled())logger.debug("Query ejecutada con exito y numero de resultados obtenidos ["+consultaActiva.getTotalResultados()+"]");
			return consultaActiva.getTotalResultados();
		} 
		catch (Exception e) 
		{
			
			ServiceSQIException exception = new ServiceSQIException("METHOD_ERROR", e);
			logger.warn(exception);
			throw exception;
		}
	}	
	
	/**
	 * Permite establecer un timeout para las consultas asincronas.
     * @param targetSessionID Identificador de la sesion sobre la que se realiza la operacion.   
     * @param maxDuration M�xima duraci�n.
     * @return no se retorna nada
     * @throws Exception
     *      
     */
	protected void handleSetMaxDuration(java.lang.String targetSessionID, java.lang.Integer maxDuration)
	throws java.lang.Exception
	{
		try {
			if(logger.isDebugEnabled())logger.debug("SrvSQIServiceImpl- handleSetMaxDuration con targetSessionID ["+targetSessionID+"] y maxDuration ["+maxDuration);
			SesionVO sesion = this.getSrvSesionesService().consultaSesion(targetSessionID);
			if (maxDuration.intValue()>=0) 
			{
				ConsultaDao consultaDao = this.getConsultaDao();
				List consulta= consultas(targetSessionID,consultaDao);

				//si hay consulta y tiene valor
				if (consulta != null && consulta.size()>0) 
				{
					if(logger.isDebugEnabled())logger.debug("Existia la consulta");
					Consulta consul = (Consulta)consulta.get(0);
					consul.setMaxDuracion(maxDuration);
					consulta.set(0, consul);
					logger.debug("Consulta de sesion ["+targetSessionID+"] actualizada con valor de maxDuration ["+maxDuration+"]");
					consultaDao.update(consulta);

				} 
				else 
				{
					if(logger.isDebugEnabled())logger.debug("No existia la consulta, generamos una por defecto");
					ConsultaVO nuevaConsulta= new ConsultaVO(); 
					nuevaConsulta.setSesion(sesion);
					nuevaConsulta=valoresPorDefecto(nuevaConsulta);
					nuevaConsulta.setMaxDuracion(maxDuration);
					consultaDao.create(this.getConsultaDao().fromConsultaVO(nuevaConsulta));
					logger.debug("Consulta de sesion ["+targetSessionID+"] creada con valor de maxDuration ["+maxDuration+"]");
				}
			} 
			else 
			{
				
				NoValidMaxDurationException e = new NoValidMaxDurationException("INVALID_MAX_DURATION");
				logger.warn(e);
				throw e;
			}
		} 
		catch (Exception e) 
		{
	
			ServiceSQIException exception = new ServiceSQIException("METHOD_ERROR", e);
			logger.warn(exception);
			throw exception;
		}
	}

	/**
	 * Permite especificar el formato del result set que se devuelve como resulado de la ejecucion de una query. 
	 * Este parametro se define como una URI al esquema de como se quieren los resulados o como un valor predefinido.
     * @param targetSessionID Identificador de la sesion sobre la que se realiza la operacion.   
     * @param resultsFormat URI o valor predefinido que define un tipo de formato de generacion de resulados de una query.
     * @return no se retorna nada
     * @throws Exception
     *      
     */
	protected void handleSetResultsFormat(java.lang.String targetSessionID, java.lang.String resultsFormat)
	throws java.lang.Exception
	{
		try 
		{
			if(logger.isDebugEnabled())logger.debug("SrvSQIServiceImpl- handleSetResultsFormat con targetSessionID ["+targetSessionID+"] y resultsFormat ["+resultsFormat);
			SesionVO sesion = this.getSrvSesionesService().consultaSesion(targetSessionID);
			ConsultaDao consultaDao = this.getConsultaDao();
			List consulta= consultas(targetSessionID,consultaDao);

			if (consulta != null && consulta.size()>0) 
			{
				Consulta consul = (Consulta)consulta.get(0);
				if (consul != null)
				{
					if(logger.isDebugEnabled())logger.debug("Existia la consulta");
					consul.setFormatoResultados(resultsFormat);
					consultaDao.update(consulta);
					logger.debug("Consulta de sesion ["+targetSessionID+"] actualizada con valor de resultsFormat ["+resultsFormat+"]");

				}
			}
			else 
			{
				if(logger.isDebugEnabled())logger.debug("No existia la consulta, generamos una por defecto");
				ConsultaVO nuevaConsulta= new ConsultaVO();
				nuevaConsulta.setSesion(sesion);
				nuevaConsulta=valoresPorDefecto(nuevaConsulta);
				nuevaConsulta.setFormatoResultados(VocabulariosRespuesta.LOM_ES.toString());
				consultaDao.create(this.getConsultaDao().fromConsultaVO(nuevaConsulta));
				logger.debug("Consulta de sesion ["+targetSessionID+"] creada con valor de resultsFormat ["+resultsFormat+"]");

			}
		} 
		catch (Exception e) 
		{
			
			ServiceSQIException exception = new ServiceSQIException("METHOD_ERROR", e);
			logger.warn(exception);
			throw exception;
		}
	}

	/**
	 * Define el numero maximo de resultados que se van a devolver en un result set.
     * @param targetSessionID Identificador de la sesion sobre la que se realiza la operacion.   
     * @param resultsSetSize Maxima cantidad de resultados a devolver en una sola consulta.
     * @return no se retorna nada
     * @throws Exception
     *      
     */
	protected void handleSetResultsSetSize(java.lang.String targetSessionID, java.lang.Integer resultsSetSize)
	throws java.lang.Exception
	{
		try {
			if(logger.isDebugEnabled())logger.debug("SrvSQIServiceImpl- handleSetResultsSetSize con targetSessionID ["+targetSessionID+"] y resultSetSize ["+resultsSetSize);
			SesionVO sesion = this.getSrvSesionesService().consultaSesion(targetSessionID);
			if (resultsSetSize.intValue()>=0) 
			{
				ConsultaDao consultaDao = this.getConsultaDao();
				List consulta= consultas(targetSessionID,consultaDao);

				if (consulta != null && consulta.size()>0) 
				{
					if(logger.isDebugEnabled())logger.debug("Existia la consulta");
					Consulta consul = (Consulta)consulta.get(0);
					if (consul != null)
					{
						consul.setResultadosDevueltos(resultsSetSize);
						consultaDao.update(consulta);
						logger.debug("Consulta de sesion ["+targetSessionID+"] actualizada con valor de resultsSize ["+resultsSetSize+"]");

					}
				}
				else 
				{
					if(logger.isDebugEnabled())logger.debug("No existia la consulta");
					ConsultaVO nuevaConsulta= new ConsultaVO();
					nuevaConsulta.setSesion(sesion);
					nuevaConsulta=valoresPorDefecto(nuevaConsulta);
					nuevaConsulta.setResultadosDevueltos(resultsSetSize);
					consultaDao.create(this.getConsultaDao().fromConsultaVO(nuevaConsulta));
					logger.debug("Consulta de sesion ["+targetSessionID+"] creada con valor de resultsSize ["+resultsSetSize+"]");
				}
			} 
			else 
			{
				NoValidResultsSetSizeException e = new NoValidResultsSetSizeException("INVALID_RESULT_SET_SIZE");
				logger.warn(e);
				throw e;
			}
		} 
		catch (Exception e) 
		{
		
			ServiceSQIException exception = new ServiceSQIException("METHOD_FAILURE", e);
			logger.warn(exception);
			throw exception;
		}
	}

	/**
	 * Recoge la localizacion del usuario del API al que debemos devolver los resultados de una query ejecutada asincronamente.
	 * Se tiene que ejecutar por parte del cliente del api antes de la ejecucion del la query de forma asincrona.
     * @param targetSessionID Identificador de la sesion sobre la que se realiza la operacion.   
     * @param sourceLocation Localizacion donde debemos contestar con 
     * los resultados obtenidos por la ejecucion de una query asincrona. Se trata de una URL.
     * @return no se retorna nada
     * @throws Exception
     *      
     */
	protected void handleSetSourceLocation(java.lang.String targetSessionID, java.lang.String sourceLocation)
	throws java.lang.Exception
	{
		try 
		{
			if(logger.isDebugEnabled())logger.debug("SrvSQIServiceImpl- handleSetSourceLocaltion con targetSessionID ["+targetSessionID+"] y sourceLocation "+sourceLocation);
			SesionVO sesion = this.getSrvSesionesService().consultaSesion(targetSessionID);
			ConsultaDao consultaDao = this.getConsultaDao();
			List consulta= consultas(targetSessionID,consultaDao);

			if (consulta != null && consulta.size()>0) 
			{
				Consulta consul = (Consulta)consulta.get(0);
				if (consul != null)
				{
					consul.setLocalizacionRemota(sourceLocation);
					consultaDao.update(consulta);
					logger.debug("Consulta de sesion ["+targetSessionID+"] actualizada con valor de sourceLocation ["+sourceLocation+"]");
				}
			}
			else 
			{
				ConsultaVO nuevaConsulta= new ConsultaVO();
				nuevaConsulta.setSesion(sesion);
				nuevaConsulta=valoresPorDefecto(nuevaConsulta);
				nuevaConsulta.setLocalizacionRemota(sourceLocation);
				consultaDao.create(this.getConsultaDao().fromConsultaVO(nuevaConsulta));
				logger.debug("Consulta de sesion ["+targetSessionID+"] creada con valor de sourceLocation ["+sourceLocation+"]");
			}
		} 
		catch (Exception e) 
		{
		
			ServiceSQIException exception = new ServiceSQIException("METHOD_ERROR"+targetSessionID, e);
			logger.warn(exception);
			throw exception;
		}
	}

	/**
	 * Permite al invocador controlar la sintaxis a utilizar en la sentencia de consulta 
	 * mediante la identificacion del lenguaje de consulta. En nuestro caso, 
	 * estaremos limitados a una coleccion de lenguajes.
     * @param targetSessionID Identificador de la sesion sobre la que se realiza la operacion.   
     * @param queryLanguageID Identificador del lenguaje a utilizar en las queries que se ejecuten en esta sesion.
     * @return no se retorna nada
     * @throws Exception
     *      
     */
	protected void handleSetQueryLanguage(java.lang.String targetSessionID, java.lang.String queryLanguageID)
	throws java.lang.Exception
	{
		try 
		{
			if(logger.isDebugEnabled())logger.debug("SrvSQIServiceImpl- handleSetQueryLanguage");
			SesionVO sesion = this.getSrvSesionesService().consultaSesion(targetSessionID);
			ConsultaDao consultaDao = this.getConsultaDao();
			List consulta= consultas(targetSessionID,consultaDao);

			if (queryLanguageID.toUpperCase().equals(VocabulariosConsulta.LQS.toString())
					|| queryLanguageID.toUpperCase().equals(VocabulariosConsulta.VSQL.toString()))
			{
				if (consulta != null && consulta.size()>0) 
				{
					Consulta consul = (Consulta)consulta.get(0);
					if (consul != null)
					{

						consul.setLenguaje(queryLanguageID);
						consultaDao.update(consulta);
						logger.debug("Consulta de sesion ["+targetSessionID+"] actualizada con valor de queryLanguage ["+queryLanguageID+"]");

					}
				}
				else 
				{
					ConsultaVO nuevaConsulta= new ConsultaVO();
					nuevaConsulta.setSesion(sesion);
					nuevaConsulta=valoresPorDefecto(nuevaConsulta);
					nuevaConsulta.setLenguaje(queryLanguageID);
					consultaDao.create(this.getConsultaDao().fromConsultaVO(nuevaConsulta));
					logger.debug("Consulta de sesion ["+targetSessionID+"] creada con valor de queryLanguage ["+queryLanguageID+"]");
				}
			}
			else
			{
				QueryLanguageNotSupportedException exc= new QueryLanguageNotSupportedException
				("QueryLanguage "+queryLanguageID+" not supported, the only supported languages are "+VocabulariosConsulta.LQS+" or "+VocabulariosConsulta.VSQL);
			}
		}

		catch (Exception e) 
		{
		
			ServiceSQIException exception = new ServiceSQIException("METHOD_ERROR",e);
			logger.warn(exception);
			throw exception;
		}
	}

	/**
	 * Define el maximo numero de resultados que una query puede producir.
     * @param targetSessionID Identificador de la sesion sobre la que se realiza la operacion.   
     * @param maxQueryResults Cifra maxima de resultados permitidos por query.
     * @return no se retorna nada
     * @throws Exception
     *      
     */
	protected void handleSetMaxQueryResults(java.lang.String targetSessionID, java.lang.Integer maxQueryResults)
	throws java.lang.Exception
	{
		try 
		{
			if(logger.isDebugEnabled())logger.debug("SrvSQIServiceImpl- handleSetMaxQueryResults");
			SesionVO sesion = this.getSrvSesionesService().consultaSesion(targetSessionID);
			if (maxQueryResults.intValue()>=0) 
			{
				ConsultaDao consultaDao = this.getConsultaDao();
				List consulta= consultas(targetSessionID,consultaDao);

				if (consulta != null && consulta.size()>0) 
				{
					Consulta consul = (Consulta)consulta.get(0);
					if (consul != null)
					{
						consul.setMaxResultados(maxQueryResults);
						consultaDao.update(consulta);
						logger.debug("Consulta de sesion ["+targetSessionID+"] actualizada con valor de maxQueryResults ["+maxQueryResults+"]");
					}
				} 
				else 
				{

					ConsultaVO nuevaConsulta= new ConsultaVO();
					nuevaConsulta.setSesion(sesion);
					nuevaConsulta=valoresPorDefecto(nuevaConsulta);
					nuevaConsulta.setMaxResultados(maxQueryResults);
					consultaDao.create(this.getConsultaDao().fromConsultaVO(nuevaConsulta));
					logger.debug("Consulta de sesion ["+targetSessionID+"] creada con valor de maxQueryResults ["+maxQueryResults+"]");

				}
			} 
			else 
			{
				NoValidMaxQueryResultsException e = new NoValidMaxQueryResultsException("INVALID_MAX_QUERY_RESULTS");
				logger.warn(e);
				throw e;
			}
		} 
		catch (Exception e) 
		{
			ServiceSQIException exception = new ServiceSQIException("METHOD_ERROR", e);
			logger.warn(exception);
			throw exception;
		}
	}

	/**
	 * Permite realizar ejecuciones de queries en modo asincrono, de manera que el API devuelve 
	 * los resultados de la query cuando termine de ejecutar la busqueda.
	 * Est� en sintonia con setSourceLocation, el cual se tiene que ejecutar antes para suministar 
	 * la localizacion donde se van a devolver los resutlados de la query.
     * @param targetSessionID Identificador de la sesion sobre la que se realiza la operacion.   
     * @param queryStatement Sentencia a ejecutar en modo asincrono.
     * @param queryID Identificador de la query que se va a ejecutar. 
     * Este identifiacador es un valor suministrado por el cliente del API que lo utiliza para identificar su consulta.
     * @return no se retorna nada
     * @throws Exception
     *      
     */
	protected void handleAsynchronousQuery(java.lang.String targetSessionID, java.lang.String queryStatement, java.lang.String queryID)
	throws java.lang.Exception
	{
		//@todo implement protected void handleAsynchronousQuery(java.lang.String targetSessionID, java.lang.String queryStatement, java.lang.String queryID)
		throw new java.lang.UnsupportedOperationException("es.pode.dri.negocio.servicios.SQI.SrvSQIService.handleAsynchronousQuery(java.lang.String targetSessionID, java.lang.String queryStatement, java.lang.String queryID) Not implemented!");
	}

	/**
	 * Este metodo realiza la query que se le pasa sobre la sesion que indica. 
	 * Recoge los resulados que genera y los devuelve teniendo en cuenta el numero maximo de resultados para una query,
	 * el numero de resultados de un result set y el indice del resultado a partir del cual se esta interesado.
     * @param targetSessionID Identificador de la sesion sobre la que se realiza la operacion.   
     * @param queryStatement Sentencia a ejecutar.
     * @param startResult Numero que indica el registro de comienzo del result set devuelto.
     * @return se retorna el resultado de la consulta.
     * @throws Exception
     *      
     */
	protected java.lang.String handleSynchronousQuery(java.lang.String targetSessionID, 
			java.lang.String queryStatement, java.lang.Integer startResult)
	throws java.lang.Exception
	{
		String sincrono="";
		try 
		{
			if(logger.isDebugEnabled())logger.debug("SrvSQIServiceImpl- handleSynchronousQuery con parametros targetSessionID ["+targetSessionID+"]y queryStatement["+queryStatement+"] y startResult" +startResult);
			sincrono=this.getSrvSQISincronoService().synchronousQuery(targetSessionID, queryStatement, startResult);
			if(logger.isDebugEnabled()) logger.debug("metodo sincrono correcto con vuelta ");
			if(sincrono.equals("<results></results>")){
				 logger.debug("metodo sincrono correcto con vuelta ,<results></results>");
			}
		} 
		catch (Exception e) 
		{
		
			ServiceSQIException exception = new ServiceSQIException("METHOD_ERROR", e);
			logger.warn(exception);

		}
		return sincrono;
	}	
	/**
	 * Este metodo realiza las consultas con el gestor de sesiones en la base de datos
     * @param targetSessionID Identificador de la sesion sobre la que se realiza la operacion.   
     * @param consultaDao La consulta a realizar.
     * @return devuelve la lista de consultas.
     *      
     */
	protected List consultas(java.lang.String targetSessionID,ConsultaDao consultaDao) 
	{

		consultaDao = this.getConsultaDao();
		ConsultaPorSesionCriteria criterio= new ConsultaPorSesionCriteria();
		criterio.setSesion(targetSessionID);
		List consulta = consultaDao.buscaConsultaPorCriterioSesion(
				ConsultaDao.TRANSFORM_NONE, criterio);

		return consulta;
	}

	private String[] parsearVSQI(String queryStatement) 
	{
		String c = queryStatement.substring(13, queryStatement.length()-14);
		ArrayList stringList = new ArrayList();
		while (c.startsWith("<term>")) 
		{
			String term = new String(c.substring(6, c.indexOf("</term>")));
			stringList.add(term);
			c = c.substring(13+term.length());
		}
		return (String[]) stringList.toArray(new String[stringList.size()]);
	}
	
	private ConsultaVO valoresPorDefecto(ConsultaVO nuevaConsulta)
	{ 
		if(logger.isDebugEnabled())logger.debug("valoresPorDefecto");
		if(props == null){
			InputStream is = null;
			try {
		//		Configuramos la clase de propiedades
				is = this.getClass().getResourceAsStream("/dri.properties");
				props = new Properties();
				props.load(is);
			} catch (IOException e) {
				logger.error("ERROR: fichero no encontrado: dri.properties",e);
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
		
		nuevaConsulta.setMaxDuracion(new Integer(props.getProperty("maxDuracion")));
		nuevaConsulta.setFormatoResultados(VocabulariosRespuesta.LOM_ES.toString());
		nuevaConsulta.setLenguaje(VocabulariosConsulta.VSQL.toString());
		nuevaConsulta.setMaxResultados(new Integer(props.getProperty("maxResultados")));
		nuevaConsulta.setResultadosDevueltos(new Integer(props.getProperty("resultadosDevueltos")));
		return nuevaConsulta;
	}

	/** Para saber si el servicio est� operativo
	 * 
	 * @return Boolean
	 * @throws Exception
	 * */
	protected Boolean handleEstasActivo() throws Exception {
		// TODO Auto-generated method stub
		return new Boolean(true);
	}	

}