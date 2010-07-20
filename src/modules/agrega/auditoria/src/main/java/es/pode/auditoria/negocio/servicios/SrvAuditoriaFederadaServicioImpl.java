/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */


//TODO añadir un método de generación del informe federado planificado, sería semejante al método SrvAuditoriaServicioImpl.handleCrearGuardarInforme
//Los informes federados se guardarán en otro directorio para que luego en el listado de informes aparezca otra pestaña con los informes federados
//Se deberán crear plantillas nuevas para cada uno de los informes federados.

package es.pode.auditoria.negocio.servicios;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.log4j.Logger;
import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.auditoria.negocio.servicios.pool.MultiSearcher;
import es.pode.buscar.negocio.administrar.servicio.NodoVO;
import es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaService;
import es.pode.fuentestaxonomicas.negocio.servicio.TaxonConRutaVO;
import es.pode.indexador.negocio.servicios.auditoria.CoberturaVO;
import es.pode.indexador.negocio.servicios.auditoria.ParametroAuditIndexadorVO;
import es.pode.publicacion.negocio.servicios.ODEsEstadoIdiomaVO;
import es.pode.publicacion.negocio.servicios.ODEsEstadoVO;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaFederadaServicio
 */

public class SrvAuditoriaFederadaServicioImpl
    extends es.pode.auditoria.negocio.servicios.SrvAuditoriaFederadaServicioBase
{

	private Logger logger = Logger.getLogger(this.getClass());
	private java.util.Properties pAuditoriaProperties = null;
	private static String localhost = "localhost";
	
	 /**
	 * Obtiene el informe de Nivel de Agregación federado. Devuelve el número de odes existentes en cada nivel de agregación para cada nodo de la federación 
	 * @param parametros VO con los parámetros de generación del informe
	 * @return InformeAgregacionFederadaVO[]
	 * @throws Exception
	 */
    protected es.pode.auditoria.negocio.servicios.InformeAgregacionFederadaVO[] handleInformeNivelAgregacionFederado(ParametrosInformeFederadoVO parametros)
        throws Exception
    {
    	logger.info("Informe nivel agregacion federado");
    	
    	InformeAgregacionFederadaVO[] informeAgregacionFederadoVO = null;
       	List comunidades=obtenerComunidades();
       	InformeAgregacionFederadaVO nodoActual = null;
       	InformeAgregacionFederadaVO[] resultado = null;
		ArrayList informeAgregacionList = new ArrayList();
		NodoVO nodoComunidadPeticion=new NodoVO();
		
		//metemos las fechas y el idioma por defecto
		//Metemos la fecha desde el 1/1/2007 y la fecha fin la actual
		
		parametros.setFechaDesde(new GregorianCalendar(new Integer("2007").intValue(), new Integer("1").intValue() - 1, new Integer("1").intValue(), new Integer("1").intValue(), new Integer("0").intValue()));
		parametros.setFechaHasta(new GregorianCalendar()); 
		parametros.setIdioma(I18n.getInstance().obtenerIdiomaDefectoPlataforma());
		parametros.setTipoInforme("nivelAgregacionFederada");
		
		//Comprobación de los parámetros de generación del informe
		logger.debug("Valido los parametros");
		//parametros = this.validarParametros(parametros,getPropertyValue("nivelAgregacion"));
		
		//Obtencion de los nodos federados
		
		logger.debug("Obtenemos todas las comunidades");
		nodoComunidadPeticion.setNodo(localhost);
		nodoComunidadPeticion.setUrlWS(localhost);
		nodoComunidadPeticion.setUrl(localhost);
		nodoComunidadPeticion.setPuerto(getPropertyValue("puertoFederada")+LdapUserDetailsUtils.getSubdominio());
		comunidades.add(comunidades.get(0));
		comunidades.set(0, nodoComunidadPeticion);
		
		logger.debug("comunidades.size() "+comunidades.size());
		logger.debug("federada "+getPropertyValue("srvFederada"));
		logger.debug("maxWaitThread "+getPropertyValue("maxWaitThread"));
		logger.debug("maxWaitPool "+getPropertyValue("maxWaitPool"));
		logger.debug("multiSearcher");
		informeAgregacionFederadoVO  = MultiSearcher.searchNivelAgregacion(parametros, comunidades,getPropertyValue("srvFederada"),Integer.parseInt(getPropertyValue("maxWaitThread")),Integer.parseInt(getPropertyValue("maxWaitPool")));
		logger.debug("informeAgregacionFederadoVO.length "+informeAgregacionFederadoVO.length);
		
		//Ordenamos los resultados
		logger.debug("Nodo local "+localhost);
		for(int i=0;i<informeAgregacionFederadoVO.length;i++)
		{
			logger.debug("informeAgregacionFederadoVO[i].getNodo() "+informeAgregacionFederadoVO[i].getNodo());
			logger.debug("getAgregaPropertyValue(AgregaProperties.HOST) "+getAgregaPropertyValue(AgregaProperties.HOST));
			if(informeAgregacionFederadoVO[i].getNodo().equalsIgnoreCase(getAgregaPropertyValue(AgregaProperties.HOST)))
			{
				logger.debug("Los resultados son del nodo del que se ha lanzado la peticion");
				nodoActual = informeAgregacionFederadoVO[i];
			}else
			{
				informeAgregacionList.add(informeAgregacionFederadoVO[i]);
			}
			
		}
		logger.debug("nodoActual "+nodoActual);
		logger.debug("informeAgregacionList "+informeAgregacionList.size());
		if(!(nodoActual == null))
		{
			if(informeAgregacionList.size() > 0)
			{
				logger.debug("Tenemos mas de un nodo federado");
				informeAgregacionList.add((InformeAgregacionFederadaVO)informeAgregacionList.get(0));
				informeAgregacionList.set(0, nodoActual);
			}else
			{
				logger.debug("No tenemos mas de un nodo federado");
				informeAgregacionList.add(nodoActual);
			}
			
			resultado = (InformeAgregacionFederadaVO[])informeAgregacionList.toArray(new InformeAgregacionFederadaVO[0]);
		}else
		{
			logger.debug("No tenemos nodo Actual informeAgregacionFederadoVO.length "+informeAgregacionFederadoVO.length);
			resultado = informeAgregacionFederadoVO;
		}
		logger.debug("recorro el resultado "+resultado.length);
		
  		return resultado;
    	
    	
    }
    
    
    /**
	 * Obtiene el informe de Nivel de Agregación local. Devuelve el número de odes existentes en cada nivel de agregación para un nodo en concreto 
	 * @param parametros VO con los parámetros de generación del informe
	 * @return InformeAgregacionFederadaVO. VO con los odes existentes por nivel de agregación
	 * @throws Exception
	 */
	protected InformeAgregacionFederadaVO handleNivelAgregacionFederadoLocal(ParametrosInformeFederadoVO parametros) throws Exception
	{
		
		
		InformeAgregacionFederadaVO resultado = null;
		NivelAgregacionContenido[] nivelAgregacionContenido = null;
		ParametroAuditIndexadorVO parametroAuditIndexadorVO = new ParametroAuditIndexadorVO();
		Calendar gcDesde = parametros.getFechaDesde();
		Calendar gcHasta = parametros.getFechaHasta();
		CoberturaVO[] coberturaVO = null;
		String[] ids = null;
		Integer[] numDocs = null;
		
		logger.info("handleNivelAgregacionFederadoLocal");
		
		
		//Validamos las fechas
		
		if(!(this.validarFechas(parametros.getFechaDesde(), parametros.getFechaHasta())).booleanValue())
		{
			logger.error("Las fechas no son correctas.");
			throw new Exception("Error calculando operaciones realizadas. Las fechas no son correctas.");
		}
			
		parametroAuditIndexadorVO.setFechaDesde(gcDesde);
		parametroAuditIndexadorVO.setFechaHasta(gcHasta);
		logger.debug("Parametros del servicio: " + parametroAuditIndexadorVO.getFechaDesde()+" "+ parametroAuditIndexadorVO.getFechaHasta());
		
		coberturaVO = this.getSrvAuditoriaIndexadorService().coberturaNivelAgregacion(parametroAuditIndexadorVO);
		resultado = new InformeAgregacionFederadaVO();
		resultado.setNodo(getAgregaPropertyValue(AgregaProperties.HOST));
		if (coberturaVO == null)
		{
			logger.error("coberturaVO es null " + coberturaVO);
		} else
		{
			nivelAgregacionContenido = new NivelAgregacionContenido[coberturaVO.length];
			ids = new String[coberturaVO.length];
			numDocs = new Integer[coberturaVO.length];
			for (int i = 0; i < coberturaVO.length; i++)
			{
				nivelAgregacionContenido[i] = new NivelAgregacionContenido();
				nivelAgregacionContenido[i].setId(coberturaVO[i].getId());
				nivelAgregacionContenido[i].setNumDoc(coberturaVO[i].getNumDoc());
				
			}
			resultado.setNivelAgregacion(nivelAgregacionContenido);
			logger.debug("El array de resultados (InformeNivelAgregacionVO[]) tiene un tamanio de " + coberturaVO.length);
		
			logger.debug("resultado.getNodo() "+resultado.getNodo());
			if (resultado == null)
			{
				logger.error("Error calculando los odes por nivel de agregacion");
				throw new Exception("Error calculando los odes por nivel de agregacion. No se ha obtenido ningun resultado.");
			}
		}
		logger.debug("[NivelAgregacionFederadoLocal] el resultado devuelto resultado.getNodo() "+resultado.getNodo());
		logger.debug("[NivelAgregacionFederadoLocal] el resultado devuelto resultado.getNivelAgregacion()[0].getId() "+resultado.getNivelAgregacion()[0].getId());
		logger.debug("[NivelAgregacionFederadoLocal] el resultado devuelto resultado.getNivelAgregacion()[0].getNumDoc() "+resultado.getNivelAgregacion()[0].getNumDoc());
		return resultado;
		
	}
    
	
	
	/**
	 * Obtiene el informe de cobertura curricular federado. Devuelve el número de odes existentes en cada rama del árbol curricular para un nodo concreto 
	 * @param parametros VO con los parámetros de generación del informe
	 * @return InformeCoberturaFederadoVO[] 
	 * @throws Exception
	 */
	
	protected InformeCoberturaFederadoVO[] handleInformeCoberturaFederado(ParametrosInformeFederadoVO parametros) throws Exception
	{
		logger.info("Informe cobertura curricular federado");
    	
		InformeCoberturaFederadoVO[] informeCoberturaFederadoVO = null;
       	List comunidades=obtenerComunidades();
       	InformeCoberturaFederadoVO nodoActual = null;
       	InformeCoberturaFederadoVO[] resultado = null;
		ArrayList informeCoberturaList = new ArrayList();
		NodoVO nodoComunidadPeticion=new NodoVO();
		
		//metemos las fechas y el idioma por defecto
		//Metemos la fecha desde el 1/1/2007 y la fecha hasta la actual
		parametros.setFechaDesde(new GregorianCalendar(new Integer("2007").intValue(), new Integer("1").intValue() - 1, new Integer("1").intValue(), new Integer("1").intValue(), new Integer("0").intValue()));
		parametros.setFechaHasta(new GregorianCalendar());
		parametros.setIdioma(I18n.getInstance().obtenerIdiomaDefectoPlataforma());
		parametros.setTipoInforme("coberturaCurricularFederada");
		
		//Comprobación de los parámetros de generación del informe
		logger.debug("Valido los parametros");
		//parametros = this.validarParametros(parametros,getPropertyValue("coberturaCurricular"));
		
		//Obtencion de los nodos federados
		
		logger.debug("Obtenemos todas las comunidades");
		
		nodoComunidadPeticion.setNodo(localhost);
		nodoComunidadPeticion.setUrlWS(localhost);
		nodoComunidadPeticion.setUrl(localhost);
		nodoComunidadPeticion.setPuerto(getPropertyValue("puertoFederada")+LdapUserDetailsUtils.getSubdominio());
		
		//Se añade el primer elemento de la propia lista al final, por lo que estaria en la 1ª y ultima posicion y despues se añade el nodo actual en la posicion 0
		comunidades.add(comunidades.get(0));
		comunidades.set(0, nodoComunidadPeticion);
		
		
		logger.debug("comunidades.size() "+comunidades.size());
		logger.debug("federada "+getPropertyValue("srvFederada"));
		logger.debug("maxWaitThread "+getPropertyValue("maxWaitThread"));
		logger.debug("maxWaitPool "+getPropertyValue("maxWaitPool"));
		logger.debug("multiSearcher");
		
		//se llama al metodo de hilos correspondiente para el metodo
		informeCoberturaFederadoVO  = MultiSearcher.searchCoberturaCurricular(parametros, comunidades,getPropertyValue("srvFederada"),Integer.parseInt(getPropertyValue("maxWaitThreadCoberturaCurricular")),Integer.parseInt(getPropertyValue("maxWaitPoolCoberturaCurricular")));
		logger.debug("informeCoberturaFederadoVO.length "+informeCoberturaFederadoVO.length);
		
		//Ordenamos los resultados
		logger.debug("Nodo local "+localhost);
		for(int i=0;i<informeCoberturaFederadoVO.length;i++)
		{
			logger.debug("informeCoberturaFederadoVO[i].getNodo() "+ informeCoberturaFederadoVO[i].getNodo());
			logger.debug("getAgregaPropertyValue(AgregaProperties.HOST) "+getAgregaPropertyValue(AgregaProperties.HOST));
			if(informeCoberturaFederadoVO[i].getNodo().equalsIgnoreCase(getAgregaPropertyValue(AgregaProperties.HOST)))
			{
				logger.debug("Los resultados son del nodo del que se ha lanzado la peticion");
				nodoActual = informeCoberturaFederadoVO[i];
			}else
			{
				informeCoberturaList.add(informeCoberturaFederadoVO[i]);
			}
			
		}
		logger.debug("nodoActual "+nodoActual);
		logger.debug("informeAgregacionList "+informeCoberturaList.size());
		if(!(nodoActual == null))
		{
			if(informeCoberturaList.size() > 0)
			{
				logger.debug("Tenemos mas de un nodo federado");
				informeCoberturaList.add((InformeCoberturaFederadoVO)informeCoberturaList.get(0));
				informeCoberturaList.set(0, nodoActual);
			}else
			{
				logger.debug("No tenemos mas de un nodo federado");
				informeCoberturaList.add(nodoActual);
			}
			
			resultado = (InformeCoberturaFederadoVO[])informeCoberturaList.toArray(new InformeCoberturaFederadoVO[0]);
		}else
		{
			logger.debug("No tenemos nodo Actual informeCoberturaFederadoVO.length "+informeCoberturaFederadoVO.length);
			resultado = informeCoberturaFederadoVO;
		}
		logger.debug("recorro el resultado "+resultado.length);
		for(int i=0;i<resultado.length;i++)
		{
			logger.debug("nodo "+resultado[i].getNodo());
			logger.debug("id arbol "+resultado[i].getCoberturaCurricular()[0].getCoberturaCurricular());
			logger.debug("total odes primer nodo"+resultado[i].getCoberturaCurricular()[0].getTotalOdes());
		}
  		return resultado;
	}


	/**
	 * Obtiene el informe de cobertura curricular local. Devuelve el número de odes existentes en cada nivel de agregación para un nodo en concreto 
	 * @param parametros VO con los parámetros de generación del informe
	 * @return InformeAgregacionFederadaVO. VO con los odes existentes por nivel de agregación
	 * @throws Exception
	 */
	protected InformeCoberturaFederadoVO handleCoberturaFederadoLocal(ParametrosInformeFederadoVO parametros) throws Exception
	{
		InformeCoberturaFederadoVO informeCoberturaFederadoVO = null;
		CoberturaCurricularContenido[] coberturaCurricularContenido = null;
		ParametroAuditIndexadorVO parametroAuditIndexadorVO = new ParametroAuditIndexadorVO();
		GregorianCalendar gcDesde = new GregorianCalendar();
		GregorianCalendar gcHasta = new GregorianCalendar();
		String idioma = "";
		CoberturaVO[] coberturaVO = null;
		
		logger.info("informeCoberturaCurricular");
		
		idioma = parametros.getIdioma();
		
		//Validamos las fechas
		
		if(!(this.validarFechas(parametros.getFechaDesde(), parametros.getFechaHasta())).booleanValue())
		{
			logger.error("Las fechas no son correctas.");
			throw new Exception("Error calculando operaciones realizadas. Las fechas no son correctas.");
		}
		
		
		gcDesde.setTime((parametros.getFechaDesde()).getTime());
		parametroAuditIndexadorVO.setFechaDesde(gcDesde);
		gcHasta.setTime((parametros.getFechaHasta()).getTime());
		parametroAuditIndexadorVO.setFechaHasta(gcHasta);
		logger.debug("Parametros del informe cobertura curricular: FechaInicio " + parametroAuditIndexadorVO.getFechaDesde() + " FechaFin : " + parametroAuditIndexadorVO.getFechaHasta());
		ArbolCurricularVO[] arbolCurricular = this.obtenerArbolCurricular(idioma);
		if (arbolCurricular == null)
		{
			logger.error("Error obteniendo todo el arbol curricular para el idioma que se pasa por parametro");
			throw new Exception("Error obteniendo todo el arbol curricular para el idioma que se pasa por parametro");
		}else
		{
			logger.debug("El arbolCurricular obtenido es " + arbolCurricular.length);
		}
		String[] idNodos = this.obtenerIdArbolCurricular(arbolCurricular);
		logger.debug("El arbol curricular tiene " + idNodos.length+" nodos");
		logger.debug("El primer nodo es :" + idNodos[0]);
		parametroAuditIndexadorVO.setIdNodo(idNodos);
		coberturaVO = this.getSrvAuditoriaIndexadorService().coberturaArbolCurricular(parametroAuditIndexadorVO);
		
		logger.debug("se ha obtenido el VO  coberturaVO" + coberturaVO);
		if(coberturaVO == null)
		{
			logger.error("El VO coberturaVO es null");
			throw new Exception("Error obteniendo el informe de la cobertura por arbol curricular");
		}else
		{
			coberturaCurricularContenido = new CoberturaCurricularContenido[coberturaVO.length];
			informeCoberturaFederadoVO = new InformeCoberturaFederadoVO();
			for (int i = 0; i < coberturaVO.length; i++)
			{
				coberturaCurricularContenido[i] = new CoberturaCurricularContenido();
				coberturaCurricularContenido[i].setCoberturaCurricular(coberturaVO[i].getId()+" "+arbolCurricular[i].getNombreNodo());
				coberturaCurricularContenido[i].setTotalOdes(coberturaVO[i].getNumDoc());
				
			}
			informeCoberturaFederadoVO.setCoberturaCurricular(coberturaCurricularContenido);
			informeCoberturaFederadoVO.setNodo(getAgregaPropertyValue(AgregaProperties.HOST));
			if (informeCoberturaFederadoVO == null)
			{
				logger.error("Error obteniendo el informe de la cobertura por arbol curricular");
				throw new Exception("Error obteniendo el informe de la cobertura por arbol curricular");
			}else
			{
				logger.debug("El VO informeCoberturaCurricularVO tiene un nodo " + informeCoberturaFederadoVO.getNodo());
				logger.debug("El VO informeCoberturaCurricularVO tiene un tamanio " + informeCoberturaFederadoVO.getCoberturaCurricular().length);
			}
		}
		return informeCoberturaFederadoVO;
	}



	/**
	 * Obtiene el informe de cobertura curricular federado. Devuelve el número de odes existentes en cada rama del árbol curricular para cada nodo de la federación 
	 * @param parametros VO con los parámetros de generación del informe
	 * @return InformeCoberturaFederadoVO[] 
	 * @throws Exception
	 */
	protected InformeOdesIdiomaFederadoVO[] handleInformeOdesIdiomaFederado(ParametrosInformeFederadoVO parametros) throws Exception
	{
		logger.info("Informe odes idioma federado");
    	
		InformeOdesIdiomaFederadoVO[] informeOdesIdiomaFederadoVO = null;
       	List comunidades=obtenerComunidades();
       	InformeOdesIdiomaFederadoVO nodoActual = null;
       	InformeOdesIdiomaFederadoVO[] resultado = null;
		ArrayList informeOdesIdiomaList = new ArrayList();
		NodoVO nodoComunidadPeticion=new NodoVO();
		
		//rellenamos el idioma por defecto
		parametros.setIdioma(I18n.getInstance().obtenerIdiomaDefectoPlataforma());
		parametros.setTipoInforme("odesIdiomaFederada");
		
		//Comprobación de los parámetros de generación del informe
		logger.debug("Valido los parametros");
		//parametros = this.validarParametros(parametros,getPropertyValue("odesIdioma"));
		
		//Obtencion de los nodos federados
		
		logger.debug("Obtenemos todas las comunidades");
		
		nodoComunidadPeticion.setNodo(localhost);
		nodoComunidadPeticion.setUrlWS(localhost);
		nodoComunidadPeticion.setUrl(localhost);
		nodoComunidadPeticion.setPuerto(getPropertyValue("puertoFederada")+LdapUserDetailsUtils.getSubdominio());
		
		//Se añade el primer elemento de la propia lista al final, por lo que estaria en la 1ª y ultima posicion y despues se añade el nodo actual en la posicion 0
		comunidades.add(comunidades.get(0));
		comunidades.set(0, nodoComunidadPeticion);
		
		
		logger.debug("comunidades.size() "+comunidades.size());
		logger.debug("federada "+getPropertyValue("srvFederada"));
		logger.debug("maxWaitThread "+getPropertyValue("maxWaitThread"));
		logger.debug("maxWaitPool "+getPropertyValue("maxWaitPool"));
		logger.debug("multiSearcher");
		
		//se llama al metodo de hilos correspondiente para el metodo
		informeOdesIdiomaFederadoVO  = MultiSearcher.searchOdesIdioma(parametros, comunidades,getPropertyValue("srvFederada"),Integer.parseInt(getPropertyValue("maxWaitThreadCoberturaCurricular")),Integer.parseInt(getPropertyValue("maxWaitPoolCoberturaCurricular")));
		logger.debug("informeOdesIdiomaFederadoVO.length " + informeOdesIdiomaFederadoVO.length);
		
		
		//Ordenamos los resultados
		
		logger.debug("Nodo local "+localhost);
		for(int i=0;i<informeOdesIdiomaFederadoVO.length;i++)
		{
			logger.debug("informeOdesIdiomaFederadoVO[i].getNodo() "+informeOdesIdiomaFederadoVO[i].getNodo());
			logger.debug("getAgregaPropertyValue(AgregaProperties.HOST) "+getAgregaPropertyValue(AgregaProperties.HOST));
			if(informeOdesIdiomaFederadoVO[i].getNodo().equalsIgnoreCase(getAgregaPropertyValue(AgregaProperties.HOST)))
			{
				logger.debug("Los resultados son del nodo del que se ha lanzado la peticion");
				nodoActual = informeOdesIdiomaFederadoVO[i];
			}else
			{
				informeOdesIdiomaList.add(informeOdesIdiomaFederadoVO[i]);
			}
			
		}
		logger.debug("nodoActual " + nodoActual);
		logger.debug("informeAgregacionList " + informeOdesIdiomaList.size());
		
		if(!(nodoActual == null))
		{
			if(informeOdesIdiomaList.size() > 0)
			{
				logger.debug("Tenemos mas de un nodo federado");
				informeOdesIdiomaList.add((InformeOdesIdiomaFederadoVO)informeOdesIdiomaList.get(0));
				informeOdesIdiomaList.set(0, nodoActual);
			}else
			{
				logger.debug("No tenemos mas de un nodo federado");
				informeOdesIdiomaList.add(nodoActual);
			}
			
			resultado = (InformeOdesIdiomaFederadoVO[])informeOdesIdiomaList.toArray(new InformeOdesIdiomaFederadoVO[0]);
		}else
		{
			logger.debug("No tenemos nodo Actual informeOdesIdiomaFederadoVO.length " + informeOdesIdiomaFederadoVO.length);
			resultado = informeOdesIdiomaFederadoVO;
		}
		logger.debug("recorro el resultado "+resultado.length);
		for(int i=0;i<resultado.length;i++)
		{
			logger.debug("nodo "+resultado[i].getNodo());
			logger.debug("idioma "+resultado[i].getOdesIdioma()[0].getIdioma());
			logger.debug("total odes primer idioma"+resultado[i].getOdesIdioma()[0].getNumeroOdes());
		}
		
  		return resultado;
	}


	/**
	 * Obtiene los idiomas de los nodos federados. Devuelve el número de odes existentes de cada idioma para cada nodo de la federación 
	 * @param parametros VO con los parámetros de generación del informe
	 * @return InformeOdesIdiomaFederadoVO[] 
	 * @throws Exception
	 */
	protected InformeOdesIdiomaFederadoVO handleInformeOdesIdiomaLocal(ParametrosInformeFederadoVO parametros) throws Exception
	{
		InformeOdesIdiomaFederadoVO informeOdesIdiomaFederadoVO = null;
		OdesPorIdioma[] odesPorIdioma = null;
		
		String idioma = "";
		ODEsEstadoIdiomaVO[] odesEstadoIdiomaVO = null;
		
		logger.info("informeOdesIdioma");
		
		idioma = parametros.getIdioma();
		
		odesEstadoIdiomaVO = this.getSrvAuditaPublicacionService().odesPublicadosPorIdioma();
		
		logger.debug("se ha obtenido el VO de odesEstadoIdiomaVO" + odesEstadoIdiomaVO);
		if(odesEstadoIdiomaVO == null)
		{
			logger.error("El VO coberturaVO es null");
			throw new Exception("Error obteniendo el informe de idioma por nodo");
		}else
		{
			odesPorIdioma = new OdesPorIdioma[odesEstadoIdiomaVO.length];
			informeOdesIdiomaFederadoVO = new InformeOdesIdiomaFederadoVO();
			for (int i = 0; i < odesEstadoIdiomaVO.length; i++)
			{
				odesPorIdioma[i] = new OdesPorIdioma();
				odesPorIdioma[i].setIdioma(odesEstadoIdiomaVO[i].getIdioma());
				odesPorIdioma[i].setNumeroOdes(odesEstadoIdiomaVO[i].getNumODES());
				I18n i18n = new I18n();
				odesPorIdioma[i].setIdiomaTraducido(i18n.obtenerIdiomaTraducido(odesEstadoIdiomaVO[i].getIdioma(), idioma));
				
			}
			informeOdesIdiomaFederadoVO.setOdesIdioma(odesPorIdioma);
			informeOdesIdiomaFederadoVO.setNodo(getAgregaPropertyValue(AgregaProperties.HOST));
			if (informeOdesIdiomaFederadoVO == null)
			{
				logger.error("Error obteniendo el informe de idioma por nodos");
				throw new Exception("Error obteniendo el informe de idioma por nodos");
			}else
			{
				logger.debug("El VO informeOdesIdiomaFederadoVO tiene un nodo " + informeOdesIdiomaFederadoVO.getNodo());
				logger.debug("El VO informeOdesIdiomaFederadoVO tiene un tamanio " + informeOdesIdiomaFederadoVO.getOdesIdioma().length);
			}
		}
		return informeOdesIdiomaFederadoVO;
	}


	/**
	 * Obtiene los odes publicados en los nodos federados. Devuelve el número de odes publicados en cada nodo federado
	 * @param parametros VO con los parámetros de generación del informe
	 * @return InformeOdesPublicadosFederadaVO[] 
	 * @throws Exception
	 */

	protected InformeOdesPublicadosFederadaVO[] handleInformeOdesPublicadosFederado(ParametrosInformeFederadoVO parametros) throws Exception
	{
		logger.info("Informe odes idioma federado");
    	
		InformeOdesPublicadosFederadaVO[] informeOdesPublicadosFederadoVO = null;
       	List comunidades=obtenerComunidades();
       	InformeOdesPublicadosFederadaVO nodoActual = null;
       	InformeOdesPublicadosFederadaVO[] resultado = null;
		ArrayList informeOdesPublicadosList = new ArrayList();
		NodoVO nodoComunidadPeticion=new NodoVO();
		
		//rellenamos el idioma por defecto
		parametros.setIdioma(I18n.getInstance().obtenerIdiomaDefectoPlataforma());
		parametros.setTipoInforme("odesPublicadosFederada");
		
		//Comprobación de los parámetros de generación del informe
		logger.debug("Valido los parametros");
		//parametros = this.validarParametros(parametros,getPropertyValue("odesPublicados"));
		
		//Obtencion de los nodos federados
		
		logger.debug("Obtenemos todas las comunidades");
		
		nodoComunidadPeticion.setNodo(localhost);
		nodoComunidadPeticion.setUrlWS(localhost);
		nodoComunidadPeticion.setUrl(localhost);
		nodoComunidadPeticion.setPuerto(getPropertyValue("puertoFederada")+LdapUserDetailsUtils.getSubdominio());
		
		//Se añade el primer elemento de la propia lista al final, por lo que estaria en la 1ª y ultima posicion y despues se añade el nodo actual en la posicion 0
		comunidades.add(comunidades.get(0));
		comunidades.set(0, nodoComunidadPeticion);
		
		
		logger.debug("comunidades.size() "+comunidades.size());
		logger.debug("federada "+getPropertyValue("srvFederada"));
		logger.debug("maxWaitThread "+getPropertyValue("maxWaitThread"));
		logger.debug("maxWaitPool "+getPropertyValue("maxWaitPool"));
		logger.debug("multiSearcher");
		
		//se llama al metodo de hilos correspondiente para el metodo
		informeOdesPublicadosFederadoVO  = MultiSearcher.searchOdesPublicados(parametros, comunidades,getPropertyValue("srvFederada"),Integer.parseInt(getPropertyValue("maxWaitThreadCoberturaCurricular")),Integer.parseInt(getPropertyValue("maxWaitPoolCoberturaCurricular")));
		logger.debug("informeOdesIdiomaFederadoVO.length " + informeOdesPublicadosFederadoVO.length);
		
		
		//Ordenamos los resultados
		
		logger.debug("Nodo local "+localhost);
		for(int i=0;i<informeOdesPublicadosFederadoVO.length;i++)
		{
			logger.debug("informeOdesPublicadosFederadoVO[i].getNodo() "+informeOdesPublicadosFederadoVO[i].getNodo());
			logger.debug("getAgregaPropertyValue(AgregaProperties.HOST) "+getAgregaPropertyValue(AgregaProperties.HOST));
			if(informeOdesPublicadosFederadoVO[i].getNodo().equalsIgnoreCase(getAgregaPropertyValue(AgregaProperties.HOST)))
			{
				logger.debug("Los resultados son del nodo del que se ha lanzado la peticion");
				nodoActual = informeOdesPublicadosFederadoVO[i];
			}else
			{
				informeOdesPublicadosList.add(informeOdesPublicadosFederadoVO[i]);
			}
			
		}
		logger.debug("nodoActual " + nodoActual);
		logger.debug("informeAgregacionList " + informeOdesPublicadosList.size());
		
		if(!(nodoActual == null))
		{
			if(informeOdesPublicadosList.size() > 0)
			{
				logger.debug("Tenemos mas de un nodo federado");
				informeOdesPublicadosList.add((InformeOdesPublicadosFederadaVO)informeOdesPublicadosList.get(0));
				informeOdesPublicadosList.set(0, nodoActual);
			}else
			{
				logger.debug("No tenemos mas de un nodo federado");
				informeOdesPublicadosList.add(nodoActual);
			}
			
			resultado = (InformeOdesPublicadosFederadaVO[])informeOdesPublicadosList.toArray(new InformeOdesPublicadosFederadaVO[0]);
		}else
		{
			logger.debug("No tenemos nodo Actual informeOdesIdiomaFederadoVO.length " + informeOdesPublicadosFederadoVO.length);
			resultado = informeOdesPublicadosFederadoVO;
		}
		logger.debug("recorro el resultado "+resultado.length);
		for(int i=0;i<resultado.length;i++)
		{
			logger.debug("nodo "+resultado[i].getNodo());
			logger.debug("numero de odes "+resultado[i].getNumeroOdes());
		}
  		return resultado;
	}

	/**
	 * Obtiene los odes publicados en el nodo local. 
	 * @param parametros VO con los parámetros de generación del informe
	 * @return InformeOdesPublicadosFederadaVO 
	 * @throws Exception
	 */

	
	protected InformeOdesPublicadosFederadaVO handleOdesPublicadosFederadoLocal(ParametrosInformeFederadoVO parametros) throws Exception
	{
		InformeOdesPublicadosFederadaVO informeOdesPublicadosFederadaVO = null;
		
		String idioma = "";
		ODEsEstadoVO odesEstadoVO = null;
		
		logger.info("informeOdesEstado");
		
		idioma = parametros.getIdioma();
		
		odesEstadoVO = this.getSrvAuditaPublicacionService().odesPublicados();
		
		logger.debug("se ha obtenido el VO de odesEstadoIdiomaVO" + odesEstadoVO);
		if(odesEstadoVO == null)
		{
			logger.error("El VO odesEstadoVO es null");
			throw new Exception("Error obteniendo el informe de estado de odes federado");
		}else
		{
			informeOdesPublicadosFederadaVO = new InformeOdesPublicadosFederadaVO();
			
			informeOdesPublicadosFederadaVO.setNumeroOdes(odesEstadoVO.getCantidad());
			informeOdesPublicadosFederadaVO.setNodo(getAgregaPropertyValue(AgregaProperties.HOST));
			if (informeOdesPublicadosFederadaVO == null)
			{
				logger.error("Error obteniendo el informe de estado de odes federado");
				throw new Exception("Error obteniendo el informe de estado de odes federado");
			}else
			{
				logger.debug("El VO informeOdesIdiomaFederadoVO tiene un nodo " + informeOdesPublicadosFederadaVO.getNodo());
				logger.debug("El VO informeOdesIdiomaFederadoVO tiene un tamanio " + informeOdesPublicadosFederadaVO.getNumeroOdes());
			}
		}
		return informeOdesPublicadosFederadaVO;
		
	}
	
	
	
	 /**
	 * Obtiene la lista de nodos federados con el nodo en el que se ejecuta el informe 
	 * @return List lista de nodos federados
	 * @throws Exception
	 */
	
	private List obtenerComunidades() throws Exception
    {
    	logger.debug("ObtenerComunidades!");
    	List listaNodos = new ArrayList();
    	    	
    	
    	
		NodoVO[] nodoLista = this.getSrvNodoService().listarNodos();
		if(!(nodoLista == null))
		{
			for(int i=0;i<nodoLista.length;i++)
			{
				
				logger.debug("Nodo de la lista "+i+" "+nodoLista[i].getNodo()+" puerto "+nodoLista[i].getPuerto()+ "urlWS "+nodoLista[i].getUrlWS());
				listaNodos.add(nodoLista[i]);
				
			}
		}
		
		logger.debug("Devuelvo la listaNodos");
		
		/*
		 // Para hacer pruebas en local, así se federa únicamente con localhost y desarrollo
    	NodoVO nodo = new NodoVO();
    	nodo.setNodo("desarrollo.agrega.indra.es");
    	nodo.setPuerto("8080");
    	nodo.setUrl("desarrollo.agrega.indra.es");
    	nodo.setUrlWS("desarrollo.agrega.indra.es");
    	listaNodos.add(nodo);
    	*/
    	
		return listaNodos;
	}
    
    /**
	 * Obtiene el valor almacenado en el fichero properties agrega de determinada cadena 
	 * @param  sKey cadena de la que se quiere obtener el valor
	 * @return String
	 * @throws Exception
	 */
	private String getAgregaPropertyValue(String sKey) throws IOException
	{
		logger.debug("getAgregaPropertyValue");
		AgregaProperties properties = AgregaPropertiesImpl.getInstance();
		// devolvemos la propiedad
		logger.debug("properties.getProperty(sKey) "+properties.getProperty(sKey));
		return properties.getProperty(sKey);
	}
	
	/**
	 * Obtiene el valor almacenado en el fichero properties auditoria de una determinada cadena 
	 * @param  sKey cadena de la que se quiere obtener el valor
	 * @return String
	 * @throws Exception
	 */
	private String getPropertyValue(String sKey) throws IOException
	{
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/auditoria.properties");
		if (this.pAuditoriaProperties == null)
		{
			pAuditoriaProperties = new java.util.Properties();
			pAuditoriaProperties.load(fIsSpringProperties);
		}
		fIsSpringProperties.close();

		// devolvemos la propiedad
		return pAuditoriaProperties.getProperty(sKey);
	}
	
	/**
	 * Comprueba si la fechas son correctas 
	 * @param  nombreInforme nombre del fichero con el informe
	 * @return Boolean
	 */
	
	private Boolean validarFechas(java.util.Calendar fechaDesde, java.util.Calendar fechaHasta)
	{
		
		Boolean resultado = new Boolean(true);
		if (fechaDesde == null || fechaHasta == null)
		{
			logger.error("Error calculando el informe federado. Fechas desde[" + fechaDesde == null ? null : fechaDesde + "] y hasta[" + fechaHasta == null ? null : fechaHasta + "] vacias.");
			resultado = new Boolean(false);
			
		}else if(fechaDesde.after(fechaHasta))
		{
			logger.error("Error calculando el informe federado. Fechas desde[" + fechaDesde + "] y hasta[" + fechaHasta + "] incoherentes.");
			resultado = new Boolean(false);
			
		}
		return resultado;
	}


	/**
	 * Comprueba si los parámetros para la generación del informe federado son correctos.
	 * @param  parametros VO con los parámetros de ejecución,
	 * @param  tipoInforme nombre del informe federado que se ejecutará
	 * @return ParametrosInformeFederadoVO VO con los valores correctos de los parámetros o los valores por defecto en el caso de que no sean correctos
	 */
	
	private ParametrosInformeFederadoVO validarParametros(ParametrosInformeFederadoVO parametros,String tipoInforme) throws Exception
	{
		
		if(parametros == null)
		{
			logger.debug("no se pasan parámetros");
			parametros = new ParametrosInformeFederadoVO();
			
			//parametros.setFechaDesde(new GregorianCalendar());
			//logger.debug(new GregorianCalendar().getTime());
			//parametros.setFechaHasta(new GregorianCalendar());
			//El idioma será el del usuario que lanza la tarea
			String idioma = LdapUserDetailsUtils.getIdioma();
			if(idioma == null)
			{
				idioma = "es";
			}
			parametros.setIdioma(idioma);
			parametros.setTipoInforme(tipoInforme);
		}else
		{
			logger.debug("Se pasan parametros");
			/*
			 if(parametros.getFechaDesde() == null)
			{
				parametros.setFechaDesde(new GregorianCalendar());
			}
			if(parametros.getFechaHasta() == null)
			{
				parametros.setFechaHasta(new GregorianCalendar());
			}
			*/
			if(parametros.getIdioma() == null)
			{
				String idioma = LdapUserDetailsUtils.getIdioma();
				if(idioma == null)
				{
					idioma = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
				}
				parametros.setIdioma(idioma);
			}
			if(parametros.getTipoInforme() == null)
			{
				parametros.setTipoInforme(tipoInforme);
			}
		}
		return parametros;
	}
	
	
	/**
	 * Obtiene un array de ArbolCurricularVO con la información del árbol curricular: el identificador y el nombre del nodo 
	 * @param  idioma del árbol curricular
	 * @return ArbolCurricularVO[] 
	 * @throws Exception
	 */
	private es.pode.auditoria.negocio.servicios.ArbolCurricularVO[] obtenerArbolCurricular(java.lang.String idioma) throws java.lang.Exception
	{
		SrvTaxonomiaService srvTaxonomiaService = this.getSrvTaxonomiaService();
		logger.debug("Nombre taxonomia " + this.getPropertyValue("nombreTaxonomia"));
		TaxonConRutaVO[] taxonConRutaVO = srvTaxonomiaService.obtenerTaxonomiaCompletaPreorden(this.getPropertyValue("nombreTaxonomia"), idioma);
		logger.debug("taxonConRutaVO vale " + taxonConRutaVO.length);
		ArbolCurricularVO[] arbolCurricularVO = new ArbolCurricularVO[taxonConRutaVO.length - 1];
		logger.debug("arbolCurricularVO.length " + arbolCurricularVO.length);
		if (!(taxonConRutaVO == null))
		{

			for (int i = 0; i < taxonConRutaVO.length - 1; i++)
			{
				arbolCurricularVO[i] = new ArbolCurricularVO();
				TaxonConRutaVO taxon = taxonConRutaVO[i + 1];
				arbolCurricularVO[i].setIdNodo(taxon.getId());
				arbolCurricularVO[i].setNombreNodo(taxon.getValorTax());

			}
		}
		logger.debug("devuelvo arbolCurricularVO.length " + arbolCurricularVO.length);
		return arbolCurricularVO;
	}
	
	/**
	 * Obtiene un array de String  con los identificadores de los nodos del árbol curricular 
	 * @param  arbolCurricular ArbolCurricularVO[]
	 * @return String[] 
	 */
	private String[] obtenerIdArbolCurricular(ArbolCurricularVO[] arbolCurricular)
	{
		logger.info("obtenerIdArbolCurricular ");
		String[] idNodos = null;
		idNodos = new String[arbolCurricular.length];
		for (int i = 0; i < arbolCurricular.length; i++)
		{
			idNodos[i] = new String();
			idNodos[i] = arbolCurricular[i].getIdNodo();
		}
		logger.debug("El tamanio del array de id nodos  es " + idNodos.length);
		return idNodos;
	}
	

}