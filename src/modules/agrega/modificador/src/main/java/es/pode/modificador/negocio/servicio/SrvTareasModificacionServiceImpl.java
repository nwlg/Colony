/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point

package es.pode.modificador.negocio.servicio;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import net.sf.dozer.util.mapping.MapperIF;

import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import es.pode.modificador.negocio.cambios.CodigosMensajesError;
import es.pode.modificador.negocio.cambios.FactoriaCambios;
import es.pode.modificador.negocio.cambios.TareaCambios;
import es.pode.modificador.negocio.cambios.configuracion.ConfiguracionDao;
import es.pode.modificador.negocio.cambios.configuracion.ModificadorProperties;
import es.pode.modificador.negocio.cambios.configuracion.castor.ModificationTask;
import es.pode.modificador.negocio.dominio.Modificacion;
import es.pode.modificador.negocio.dominio.ModificacionDao;
import es.pode.modificador.negocio.dominio.ResultadoModificacion;
import es.pode.modificador.negocio.dominio.ResultadoModificacionDao;
import es.pode.modificador.negocio.dominio.ResultadoModificacionDaoBase;
import es.pode.modificador.negocio.servicio.vo.ConfiguracionTarea;
import es.pode.modificador.negocio.utilidades.EstadosTarea;
import es.pode.publicacion.negocio.servicios.ReindexarODEResultadoVO;
import es.pode.publicacion.negocio.servicios.SrvPublicacionService;
import es.pode.soporte.seguridad.encriptacion.Autenticar;
import es.pode.soporte.utiles.ficheros.UtilesFicheros;
import es.pode.soporte.zip.ZipDao;
 




/**
 * @see es.pode.modificador.negocio.servicio.SrvTareasModificacionService
 * Generated file: es/pode/modificador/negocio/servicio/SrvTareasModificacionService
 */
public class SrvTareasModificacionServiceImpl

     extends MessageListenerAdapter
     implements es.pode.modificador.negocio.servicio.SrvTareasModificacionService 
    		
	
{
	private FactoriaCambios factoriaCambios;
	private ConfiguracionDao configuracionDao;
	private ModificadorProperties props = null;
    private ModificacionDao modificacionDao=null;
    private MapperIF mapper=null;
    private ResultadoModificacionDao resultadoModificacionDao=null;
    public static final String CONFIGURACION_FILE_PREFIX="configuracion.file.prefix";
	public static final String CONFIGURACION_FILE_POSTFIX="configuracion.file.postfix";
  // --------- Default Constructor ----------
    
    public ConfiguracionDao getConfiguracionDao() {
		return configuracionDao;
	}

	public void setConfiguracionDao(ConfiguracionDao configuracionDao) {
		this.configuracionDao = configuracionDao;
	}

	public FactoriaCambios getFactoriaCambios() {
		return factoriaCambios;
	}

	public void setFactoriaCambios(FactoriaCambios factoriaCambios) {
		this.factoriaCambios = factoriaCambios;
	}

	public ModificadorProperties getProps() {
		return props;
	}

	public void setProps(ModificadorProperties props) {
		this.props = props;
	}

	public SrvTareasModificacionServiceImpl()
    {
        super();
    }
      
      public  void onMessage(Message msg, Session session) 
     {
     
       try 
       {
    	   logger.debug("Mensaje recibido = " + msg);
	        if (msg instanceof ObjectMessage)
	        {
	        	logger.debug("Tipo de mensaje = " + ObjectMessage.class);
	        	Serializable msgS = ((ObjectMessage)msg).getObject();
	        	if (msgS instanceof Long)
		        {
	        		if(!DecisorOffline.esOffline()) {
		        		logger.debug("idModificacion recuperada del mensaje = " + (Long)msgS);
	        			Modificacion mod = getModificacionDao().load((Long)msgS);
	        			logger.debug("Recuperada tarea de modificacion: mod = " + mod);
		        		String user = mod.getUser();
		        		// Realizamos una autenticacion con el usuario que configuro la tarea.
		        		logger.info("Autenticando al usuario " + user + " para la ejecucion de una tarea de modificacion");
		        		boolean contextoCargado = Autenticar.cargarContextoSeguridad(user);
		        		if(!contextoCargado) {
		        			logger.error("ERROR: No han cargado los datos en el contexto de seguridad");
		        		}
	        		}
	        		Boolean tareaModificacion=ejecutarTareaModificacion((Long)msgS);
	        		logger.info("Resultado de la tarea de modificacion " + msgS + ": " + tareaModificacion);
		        } 
	         
	        }
	        else
	        {
	        	logger.info("Mensaje no procesable por este servicio: "+ msg);
	        }
	   } 
       catch (Exception e) 
       {
             logger.error(e);
       } 
    }
 
    // -------- User Defined Methods  --------------
    
    /**
     * Lanza la ejecucion de una tarea y registra los resultados al finalizar.
     * @param idModificacion Identificador de la tarea a modificar
     * @return True si tuvo éxito
     */
    public java.lang.Boolean ejecutarTareaModificacion(java.lang.Long idModificacion)
    {
    	Modificacion modificaciones = getModificacionDao().load(idModificacion);
    	if(modificaciones!=null) {
	    	String path = modificaciones.getPath();
	    	String pathXml = path + "/"+ props.getProperty(CONFIGURACION_FILE_PREFIX)+ props.getProperty(CONFIGURACION_FILE_POSTFIX);
	    	try
	    	{
	    		Modificacion mod = getModificacionDao().load(idModificacion);
	        	mod.setResultado(EstadosTarea.RUNNING);
	    		modificacionDao.update(mod);
	    		if(logger.isDebugEnabled()) logger.debug("Parseando " + pathXml);
		    	ModificationTask tarea = getConfiguracionDao().leerConfiguracion(pathXml);
		    	ConfiguracionTarea task = (ConfiguracionTarea) mapper.map(tarea, ConfiguracionTarea.class);
		    	TareaCambios cambios = factoriaCambios.generarTareaCambios(task, path);
		    	if(cambios.getOdes()!=null && cambios.getOdes().length>0) {
			    	ResultadoModificacionVO[] resultadoCambios = cambios.ejecutarTarea();
					if (cambios.isDestructiva()) {
						// Busco ODEs publicados para reindexarlos
						ArrayList publicados = new ArrayList();
						ArrayList ids = new ArrayList();
						for (int i = 0; i < resultadoCambios.length; i++) {
							if (resultadoCambios[i].getPublicado()
									.booleanValue()
									&& !EstadosTarea.ERROR
											.equals(resultadoCambios[i]
													.getStatus())) {
								publicados.add(resultadoCambios[i]);
								ids.add(resultadoCambios[i].getIdOde());
							}
						}
						if (publicados.size() > 0) {
							ResultadoModificacionVO[] publicadosArray = (ResultadoModificacionVO[]) publicados
									.toArray(new ResultadoModificacionVO[publicados
											.size()]);
							try {
								if (logger.isDebugEnabled())
									logger.debug("Reindexando "
											+ publicados.size() + " odes");
								SrvPublicacionService publicador = getSrvPublicacionService();
								if (logger.isDebugEnabled())
									logger
											.debug("Publicacion Stub recuperado : "
													+ publicador);
								if (publicador == null) {
									logger
											.error("No se ha podido obtener una referencia al publicador (SrvPublicadorService=null). Restaurando ODEs publicados");
									handleErrorGeneralPublicacion(
											modificaciones,
											cambios.getZipDao(),
											publicadosArray);
								} else {
									String[] idsArray = (String[]) ids
											.toArray(new String[ids.size()]);
									if (logger.isDebugEnabled())
										logger
												.debug("Array de ids para publicar = "
														+ idsArray);
									ReindexarODEResultadoVO[] reindexacion = publicador
											.reindexarODEsPublicados(idsArray);
									for (int i = 0; i < reindexacion.length; i++) {
										if (logger.isDebugEnabled())
											logger
													.debug("Resultado de reindexacion para ode "
															+ publicadosArray[i]
																	.getIdOde()
															+ ": "
															+ reindexacion[i]
																	.getMensaje());
										if (!"0.0".equals(reindexacion[i]
												.getMensaje())) {
											if (logger.isDebugEnabled())
												logger.debug("Restaurando Ode "
														+ publicadosArray[i]
																.getIdOde());
											handleErrorPublicacion(
													publicadosArray[i], cambios
															.getZipDao());
										}
									}
								}
							} catch (Exception e) {
								logger
										.error("Error durante la reindexacion de "
												+ ids.size() + " odes");
								if (logger.isDebugEnabled())
									logger.debug(e);
								handleErrorGeneralPublicacion(modificaciones,
										cambios.getZipDao(), publicadosArray);
							}
						} else {
							if (logger.isDebugEnabled())
								logger
										.debug("No hay ODEs publicados para reindexar");
						}
					} else {
						logger.debug("Las modificaciones no fueron destructivas, luego no hay que reindexar.");
					}
					// Almacenar resultados
			    	List entidades= new ArrayList();
			    	for(int i=0; i<resultadoCambios.length;i++)
			    	{
			    		ResultadoModificacion re=(ResultadoModificacion)mapper.map(resultadoCambios[i], ResultadoModificacion.class,ResultadoModificacionDaoBase.DEF_MAPPING_RESULTADOMODIFICACIONVO_RESULTADOMODIFICACION);
			    		re.setModificacion(modificaciones);
			    		entidades.add(i, re);
			    	}
			    	
			    	getResultadoModificacionDao().create(entidades);
			    	
			    	int finalizadas=0;
			    	
			    	for(int i=0; i<resultadoCambios.length && !EstadosTarea.ERROR.equals(modificaciones.getResultado());i++)
			    	{
			    		if(resultadoCambios[i].getStatus().equals(EstadosTarea.WARNING))
			    		{
			    			modificaciones.setResultado(EstadosTarea.WARNING);
			    			modificaciones.setMsgError(CodigosMensajesError.TAREA_WARNING);
			    		}
			    		else if (resultadoCambios[i].getStatus().equals(EstadosTarea.ERROR)) 
			    		{
			    			modificaciones.setResultado(EstadosTarea.ERROR);
			    			modificaciones.setMsgError(CodigosMensajesError.TAREA_ERROR);
						}
			    		else if (resultadoCambios[i].getStatus().equals(EstadosTarea.FINALIZADA)) 
			    		{
			    			finalizadas=finalizadas+1;
			    		}
			    	}
			    	if(finalizadas==resultadoCambios.length)
			    	{
			    		modificaciones.setResultado(EstadosTarea.FINALIZADA);
			    		modificaciones.setMsgError(CodigosMensajesError.TAREA_EJECUTADA_CORRECTAMENTE);
			    	}
		    	} else {
		    		modificaciones.setResultado(EstadosTarea.WARNING);
		    		modificaciones.setMsgError(CodigosMensajesError.SIN_ODES);
		    	}
		    	modificacionDao.update(modificaciones);
		    	return Boolean.TRUE;
	    	}
	    	catch (Exception e) 
	    	{
	    		modificaciones.setResultado(EstadosTarea.ERROR);
	    		modificacionDao.update(modificaciones);
	    		logger.error(e);
	    		return Boolean.FALSE;
			}
    	} else {
    		logger.error("La modificacion " + idModificacion + " no se encuentra en la base de datos.");
    		return Boolean.FALSE;
    	}
        
    }

	private void handleErrorGeneralPublicacion(Modificacion modificaciones, ZipDao zipDao, ResultadoModificacionVO[] publicadosArray) {
		for(int i=0;i<publicadosArray.length;i++) {
			handleErrorPublicacion(publicadosArray[i],zipDao);
			publicadosArray[i].setStatus(EstadosTarea.ERROR);
			publicadosArray[i].setMsgError(CodigosMensajesError.ERROR_PUBLICACION);
		}
		modificaciones.setResultado(EstadosTarea.ERROR);
		modificaciones.setMsgError(CodigosMensajesError.ERROR_PUBLICACION);
	}

    private void handleErrorPublicacion(ResultadoModificacionVO resultado, ZipDao zipDao) {
    	logger.error("Error durante la reindexación del ODE " + resultado.getIdOde() + ". Restaurando copia original");
		restaurar(resultado.getPathBackup(), resultado.getPathOriginal(),  zipDao);
		resultado.setStatus(EstadosTarea.ERROR);
		resultado.setMsgError(CodigosMensajesError.ERROR_PUBLICACION);
    }
    
    private void restaurar(String pathBackup, String pathOriginal,  ZipDao zipDao) {
		try {
			File backup = new File(pathBackup);
			File original = new File(pathOriginal);
			if(zipDao.esZip(pathOriginal)) {
				if(logger.isDebugEnabled()) logger.debug("Copiando backup de " + pathBackup + " a " + pathOriginal);
				UtilesFicheros.copiar(backup, original);
			} else {
				if(logger.isDebugEnabled()) logger.debug("Descomprimiendo backup " + pathBackup + " en " + pathOriginal);
				zipDao.descomprimir(pathBackup, pathOriginal);
			}
			// Eliminar la copia de backup
			UtilesFicheros.eliminar(backup);
		} catch (Exception e) {
			logger.fatal("No se ha podido restaurar la copia de seguridad");
			if(logger.isDebugEnabled()) logger.debug(e);
		}
	}
    
	/**
	 * @return the modificacionDao
	 */
	public ModificacionDao getModificacionDao()
	{
		return modificacionDao;
	}

	/**
	 * @param modificacionDao the modificacionDao to set
	 */
	public void setModificacionDao(ModificacionDao modificacionDao)
	{
		this.modificacionDao = modificacionDao;
	}

	/**
	 * @return the resultadoModificacionDao
	 */
	public ResultadoModificacionDao getResultadoModificacionDao()
	{
		return resultadoModificacionDao;
	}

	/**
	 * @param resultadoModificacionDao the resultadoModificacionDao to set
	 */
	public void setResultadoModificacionDao(
			ResultadoModificacionDao resultadoModificacionDao)
	{
		this.resultadoModificacionDao = resultadoModificacionDao;
	}

	/**
	 * @return the mapper
	 */
	public MapperIF getMapper()
	{
		return mapper;
	}

	/**
	 * @param mapper the mapper to set
	 */
	public void setMapper(MapperIF mapper)
	{
		this.mapper = mapper;
	}

	protected final es.pode.publicacion.negocio.servicios.SrvPublicacionService getSrvPublicacionService()
			throws java.lang.Exception {

		String srvPublicacionServiceFile = "importedServices.properties";
		java.io.InputStream srvPublicacionServiceInputStream = SrvTareasModificacionServiceImpl.class
				.getClassLoader()
				.getResourceAsStream(srvPublicacionServiceFile);
		logger.debug("srvPublicacionServiceInputStream = " + srvPublicacionServiceInputStream );
		java.util.Properties srvPublicacionServiceProperties = new java.util.Properties();
		srvPublicacionServiceProperties.load(srvPublicacionServiceInputStream);
		String srvPublicacionServiceEndPointAddress = "";
		srvPublicacionServiceEndPointAddress = (String) srvPublicacionServiceProperties
				.get("srvPublicacionServicePort");
		System.out
				.println("srvPublicacionServiceEndPointAddress del fichero --> "
						+ srvPublicacionServiceEndPointAddress);
		es.pode.publicacion.negocio.servicios.SrvPublicacionServiceService srvPublicacionService = new es.pode.publicacion.negocio.servicios.SrvPublicacionServiceServiceLocator();
		logger.debug("srvPublicacionServiceEndPointAddress = " + srvPublicacionServiceEndPointAddress );
		if (srvPublicacionServiceEndPointAddress.length() > 0)
			((es.pode.publicacion.negocio.servicios.SrvPublicacionServiceServiceLocator) srvPublicacionService)
					.setSrvPublicacionServiceEndpointAddress(srvPublicacionServiceEndPointAddress);
		es.pode.publicacion.negocio.servicios.SrvPublicacionService port = srvPublicacionService
				.getSrvPublicacionService();
		logger.debug("retorno : srvPublicacionService = " + srvPublicacionService );
		return port;

	}

}