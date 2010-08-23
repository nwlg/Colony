/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

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
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;


import es.pode.buscar.negocio.buscar.servicios.LomEsVO;
import es.pode.buscar.negocio.buscar.servicios.ParametrosBusquedaSQIVO;
import es.pode.buscar.negocio.buscar.servicios.ResultadoBusquedaSQIVO;
import es.pode.dri.negocio.dominio.Consulta;
import es.pode.dri.negocio.dominio.ConsultaDao;
import es.pode.dri.negocio.dominio.ConsultaPorSesionCriteria;
import es.pode.dri.negocio.servicios.ConsultaVO;
import es.pode.dri.negocio.servicios.SesionVO;



/**
 * @see es.pode.dri.negocio.servicios.SQI.SrvSQISincronoService
 */

public class SrvSQISincronoServiceImpl
extends es.pode.dri.negocio.servicios.SQI.SrvSQISincronoServiceBase
{

	private Logger logger = Logger.getLogger(this.getClass());
	private String  INICIO_RESULTS="<results>";
	private String FIN_RESULTS="</results>";
	private static Properties props = null;
	

	public SrvSQISincronoServiceImpl()
	{
		super();
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
	}

	/**
	 * compruba que la query sea correcta.
     * @param consulta Value Object con los valores recogidos que vamos a lanzar para hacer la búsqueda.   
     * @param startResult Número apartir del que vamos a enviar resultados.
     * @return boolean que nos dice si la consulta está bien generada.
     *      
     */
	protected boolean comprobacionQuery(Consulta consulta, int startResult) 
	{
		boolean correcto=true;
		if(logger.isDebugEnabled())logger.debug("SrvSQISincronoServiceImpl- comprobacionQuery");
		if((consulta.getMaxResultados()!=null)&&(consulta.getMaxResultados().intValue()>=0)
				&& (consulta.getResultadosDevueltos()!=null)&&(consulta.getResultadosDevueltos().intValue()>=0)
				&& (consulta.getLenguaje()!="")&&(consulta.getLenguaje().toUpperCase().equals(VocabulariosConsulta.LQS.toString())
						|| consulta.getLenguaje().toUpperCase().equals(VocabulariosConsulta.VSQL.toString()))
						&& (startResult>=0))

		{
			correcto=true;
		}
		else
		{
			correcto=false;
		}

		return correcto;
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
	protected java.lang.String handleSynchronousQuery(java.lang.String targetSessionID, java.lang.String queryStatement, java.lang.Integer startResult)
	throws java.lang.Exception
	{
		try 
		{
			if(logger.isDebugEnabled())logger.debug("SrvSQISincronoServiceImpl- handleSynchronousQuery");
			ConsultaDao consultaDao = this.getConsultaDao();
			ConsultaPorSesionCriteria criterio=new ConsultaPorSesionCriteria();
			if(logger.isDebugEnabled())logger.debug("Generamos el criteria");
			criterio.setSesion(targetSessionID);
			if(logger.isDebugEnabled())logger.debug("Hacemos la consulta");
			List consulta = consultaDao.buscaConsultaPorCriterioSesion(ConsultaDao.TRANSFORM_NONE, criterio);
			Consulta consul=null;


			if (consulta==null || consulta.isEmpty())
			{
				if(logger.isDebugEnabled())logger.debug("No existe la consulta");
				ConsultaVO nuevaConsulta= new ConsultaVO();
				nuevaConsulta.setMaxResultados(new Integer(props.getProperty("maxResultados")));
				nuevaConsulta.setResultadosDevueltos(new Integer(props.getProperty("resultadosDevueltos")));
				nuevaConsulta.setFormatoResultados(VocabulariosRespuesta.LOM_ES.toString());
				nuevaConsulta.setLenguaje(VocabulariosConsulta.VSQL.toString());
				SesionVO sesion=this.getSrvSesionesService().consultaSesion(targetSessionID);
				nuevaConsulta.setSesion(sesion);
				consul= consultaDao.create(this.getConsultaDao().fromConsultaVO(nuevaConsulta));
				logger.debug("creada consulta de sesion ["+targetSessionID+"]");
			}
			else
			{
				if(logger.isDebugEnabled())logger.debug("Existe la consulta");
				SesionVO sesion=this.getSrvSesionesService().consultaSesion(targetSessionID);
				
				consul=(Consulta)consulta.get(0);
			}

			consul.setQuery(queryStatement);

			if(comprobacionQuery(consul, startResult.intValue()))
			{	

				if(logger.isDebugEnabled()){
					logger.debug("Despues de comprobar la query con startResult ["+startResult);
					logger.debug("query ejecutada"+queryStatement+" " +
						"con maximos resultados"+consul.getMaxResultados()+" " +
						"con query"+consul.getQuery()+" " +
						"con resultador devueltos"+consul.getResultadosDevueltos()+" " +
						"con startResult()"+startResult+" " +
						"con VocabularioConsulta"+consul.getLenguaje());
				}

				ParametrosBusquedaSQIVO parametro=new ParametrosBusquedaSQIVO();
				parametro.setMaxResultados(consul.getMaxResultados());
				parametro.setQuery(consul.getQuery());
				parametro.setResultadosDevueltos(consul.getResultadosDevueltos());
				parametro.setStartResult(startResult);
				parametro.setVocabularioConsulta(consul.getLenguaje());
				//el idioma de busqueda se deberia extraer del modulo indexador/buscador
				parametro.setIdiomaBusqueda("");
				ResultadoBusquedaSQIVO resultados=null;
				if(startResult>=0){
					if(consul.getMaxResultados()>0){
						if(0<=consul.getResultadosDevueltos()){
							
							if(consul.getResultadosDevueltos()>consul.getMaxResultados()){
								if(logger.isDebugEnabled())logger.debug("Cambiamos la cantidad de resultados devueltos por el maximo de resultados en la base de datos; el devuelto era mas grande que el maximo resultado");
								consul.setResultadosDevueltos(consul.getMaxResultados().intValue());
								parametro.setResultadosDevueltos(consul.getMaxResultados().intValue());
							}
//							if(startResult>consul.getResultadosDevueltos()){
//								if(logger.isDebugEnabled())logger.debug("Cambiamos la cantidad de resultados de inicio por el resultado de devueltos en la base de datos; el inicio era mas grande que el resultado devuelto");
//								startResult=consul.getResultadosDevueltos();
//								parametro.setStartResult(startResult);
//							}
							resultados= this.getSrvBuscarService().buscarLomEs(parametro);
						}
						else{
							ServiceSQIException exception = new ServiceSQIException("Error en parametros de la query. los resultados devueltos deben ser mayores que cero pero menores que el maximo de resultados");
							String detallesParametros="con maximos resultados ["+consul.getMaxResultados()+"]"
							+ "con query["+consul.getQuery()+"]"
							+"con resultador devueltos["+consul.getResultadosDevueltos()+"]"
							+"con startResult()["+startResult+"]"
							+"con VocabularioConsulta["+consul.getLenguaje()+"]";

							logger.warn("los maximos resultados deben ser positivos, ["+ detallesParametros+"]" );
							throw exception;
						}
					}else{
						ServiceSQIException exception = new ServiceSQIException("Error en parametros de la query. los resultados devueltos deben ser mayores que cero pero menores que el maximo de resultados");
						String detallesParametros="con maximos resultados ["+consul.getMaxResultados()+"]"
						+ "con query["+consul.getQuery()+"]"
						+"con resultador devueltos["+consul.getResultadosDevueltos()+"]"
						+"con startResult()["+startResult+"]"
						+"con VocabularioConsulta["+consul.getLenguaje()+"]";

						logger.warn("los maximos resultados deben ser positivos, ["+ detallesParametros+"]" );
						throw exception;
					}
				}else{
					ServiceSQIException exception = new ServiceSQIException("Error en parametros de la query. startResult debe ser positivo");
					String detallesParametros="con maximos resultados ["+consul.getMaxResultados()+"]"
					+ "con query["+consul.getQuery()+"]"
					+"con resultador devueltos["+consul.getResultadosDevueltos()+"]"
					+"con startResult()["+startResult+"]"
					+"con VocabularioConsulta["+consul.getLenguaje()+"]";

					logger.warn("el startResult debe ser positivo, ["+ detallesParametros+"]" );
					throw exception;
				}


				if (resultados==null)
				{
					if(logger.isDebugEnabled()) logger.debug("No había resultados, insertamos la consulta con query ejecutada"+queryStatement+" " +
						"con maximos resultados"+consul.getMaxResultados()+" " +
						"con query"+consul.getQuery()+" " +
						"con resultador devueltos"+consul.getResultadosDevueltos()+" " +
						"con startResult()"+startResult+" " +
						"con VocabularioConsulta"+consul.getLenguaje()+"]");
					consul.setTotalResultados(new Integer(0));
					consultaDao.update(consul);
					return "";	
				}
				if(logger.isDebugEnabled()) logger.debug("Había resultados");
				LomEsVO[] arrayLomes = resultados.getResultadoBusqueda();
				String concatenarArray=INICIO_RESULTS;

				for (int i=0;arrayLomes!=null && i<arrayLomes.length;i++)
				{
					String lomes = arrayLomes[i].getLomES();
					int indice=lomes.indexOf("<lom");
					String subLomes=lomes.substring(indice);
					
					concatenarArray=concatenarArray.concat(subLomes);
				}
				concatenarArray=concatenarArray+FIN_RESULTS;

				String detallesParametros="con maximos resultados"+consul.getMaxResultados()+
				"con query"+consul.getQuery()+
				"con resultador devueltos"+consul.getResultadosDevueltos()+
				"con STARTRESULT()"+startResult+
				"con VocabularioConsulta"+consul.getLenguaje()+"";

				logger.debug("exito en la ejecucion de la consulta"+consul.getQuery()+"con"+detallesParametros + " y numero de resultados obtenidos ["+resultados.getNumeroResultados()+"]");
				consul.setTotalResultados(resultados.getNumeroResultados());
				consul.setMaxResultados(parametro.getMaxResultados());
				consul.setResultadosDevueltos(parametro.getResultadosDevueltos());
				consultaDao.update(consul);

				return concatenarArray;
			}
			else
			{
				ServiceSQIException exception = new ServiceSQIException("Error en parametros de la query.");
				String detallesParametros="con maximos resultados ["+consul.getMaxResultados()+"]"
				+ "con query["+consul.getQuery()+"]"
				+"con resultador devueltos["+consul.getResultadosDevueltos()+"]"
				+"con startResult()["+startResult+"]"
				+"con VocabularioConsulta["+consul.getLenguaje()+"]";

				logger.warn("no todos los parámetros están rellenos o correctos, ["+ detallesParametros+"]" );
				throw exception;
			}
		} 

		catch(Exception e) 
		{
			ServiceSQIException exception = new ServiceSQIException("Fallo al realizar query síncrona.",e);
			logger.warn(e);
			throw exception;
		}
	}
}