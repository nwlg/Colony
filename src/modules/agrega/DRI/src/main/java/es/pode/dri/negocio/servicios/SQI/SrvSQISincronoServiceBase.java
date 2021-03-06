// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringServiceBase.vsl in andromda-spring-cartridge.
//
package es.pode.dri.negocio.servicios.SQI;

import net.sf.dozer.util.mapping.MapperIF;

import org.apache.log4j.Logger;


/**
 * <p>
 * Spring Service base class for <code>es.pode.dri.negocio.servicios.SQI.SrvSQISincronoService</code>,
 * provides access to all services and entities referenced by this service.
 * </p>
 *
 * @see es.pode.dri.negocio.servicios.SQI.SrvSQISincronoService
 */
public abstract class SrvSQISincronoServiceBase
    implements es.pode.dri.negocio.servicios.SQI.SrvSQISincronoService
{

		 protected static final Logger logger = Logger.getLogger(SrvSQISincronoServiceBase.class);


	
	/**
	 * Reference to the dozer bean mapper used in the application (singleton).
	 */
	private MapperIF beanMapper;
	
	/**
	 * Gets the reference to the dozer bean mapper used in the application (singleton).
	 * @return MapperIF
	 */
    protected MapperIF getBeanMapper() {
		return beanMapper;
	}

    /**
     * Sets the instance of the Dozer bean mapper to be used.
     * @param beanMapper
     */
	public void setBeanMapper(MapperIF beanMapper) {
		this.beanMapper = beanMapper;
	}


	
	        
    
	    	    private es.pode.dri.negocio.servicios.Sesion.SrvSesionesService srvSesionesService;
	
	    /**
	     * Sets the reference to <code>srvSesionesService</code>.
	     */
	    public void setSrvSesionesService(es.pode.dri.negocio.servicios.Sesion.SrvSesionesService srvSesionesService)
	    {
	        this.srvSesionesService = srvSesionesService;
	    }
	
	    /**
	     * Gets the reference to <code>srvSesionesService</code>.
	     */
	    protected es.pode.dri.negocio.servicios.Sesion.SrvSesionesService getSrvSesionesService()
	    {
	        return this.srvSesionesService;
	    }
	    
	        
	
			
    protected final es.pode.buscar.negocio.buscar.servicios.SrvBuscarService getSrvBuscarService()
	        throws java.lang.Exception
	    {
            String srvBuscarServiceFile="importedServices.properties";	    
	          java.io.InputStream srvBuscarServiceInputStream=SrvSQISincronoServiceBase.class.getClassLoader().getResourceAsStream(srvBuscarServiceFile);
	          java.util.Properties srvBuscarServiceProperties = new java.util.Properties();
	          srvBuscarServiceProperties.load(srvBuscarServiceInputStream);
	          String srvBuscarServiceEndPointAddress="";
	          srvBuscarServiceEndPointAddress=(String) srvBuscarServiceProperties.get("srvBuscarServicePort");
			  logger.debug("srvBuscarServiceEndPointAddress del fichero --> " + srvBuscarServiceEndPointAddress);
			  es.pode.buscar.negocio.buscar.servicios.SrvBuscarServiceService srvBuscarService = new es.pode.buscar.negocio.buscar.servicios.SrvBuscarServiceServiceLocator();                                                                                                                                                                                                                                                    
            if (srvBuscarServiceEndPointAddress.length()>0) 
					  ((es.pode.buscar.negocio.buscar.servicios.SrvBuscarServiceServiceLocator)srvBuscarService).setSrvBuscarServiceEndpointAddress(srvBuscarServiceEndPointAddress);
	    	    es.pode.buscar.negocio.buscar.servicios.SrvBuscarService port = srvBuscarService.getSrvBuscarService();	    
	          return port;
	    }

    
    
    private es.pode.dri.negocio.dominio.ConsultaDao consultaDao;

    /**
     * Sets the reference to <code>consulta</code>'s DAO.
     */
    public void setConsultaDao(es.pode.dri.negocio.dominio.ConsultaDao consultaDao)
    {
        this.consultaDao = consultaDao;
    }

    /**
     * Gets the reference to <code>consulta</code>'s DAO.
     */
    protected es.pode.dri.negocio.dominio.ConsultaDao getConsultaDao()
    {
        return this.consultaDao;
    }


    /**
     * @see es.pode.dri.negocio.servicios.SQI.SrvSQISincronoService#synchronousQuery(java.lang.String, java.lang.String, java.lang.Integer)
     */
    public java.lang.String synchronousQuery(java.lang.String targetSessionID, java.lang.String queryStatement, java.lang.Integer startResult)
    {
        if (targetSessionID == null)
        {
            throw new IllegalArgumentException(
                "es.pode.dri.negocio.servicios.SQI.SrvSQISincronoService.synchronousQuery(java.lang.String targetSessionID, java.lang.String queryStatement, java.lang.Integer startResult) - 'targetSessionID' can not be null");
        }
        if (queryStatement == null)
        {
            throw new IllegalArgumentException(
                "es.pode.dri.negocio.servicios.SQI.SrvSQISincronoService.synchronousQuery(java.lang.String targetSessionID, java.lang.String queryStatement, java.lang.Integer startResult) - 'queryStatement' can not be null");
        }
        if (startResult == null)
        {
            throw new IllegalArgumentException(
                "es.pode.dri.negocio.servicios.SQI.SrvSQISincronoService.synchronousQuery(java.lang.String targetSessionID, java.lang.String queryStatement, java.lang.Integer startResult) - 'startResult' can not be null");
        }
        try
        {
            return this.handleSynchronousQuery(targetSessionID, queryStatement, startResult);
        }
        catch (Throwable th)
        {
            throw new es.pode.dri.negocio.servicios.SQI.SrvSQISincronoServiceException(
                "Error performing 'es.pode.dri.negocio.servicios.SQI.SrvSQISincronoService.synchronousQuery(java.lang.String targetSessionID, java.lang.String queryStatement, java.lang.Integer startResult)' --> " + th,
                th);
        }
    }

     /**
      * Performs the core logic for {@link #synchronousQuery(java.lang.String, java.lang.String, java.lang.Integer)}
      */
    protected abstract java.lang.String handleSynchronousQuery(java.lang.String targetSessionID, java.lang.String queryStatement, java.lang.Integer startResult)
        throws java.lang.Exception;

    /**
     * Gets the current <code>principal</code> if one has been set,
     * otherwise returns <code>null</code>.
     *
     * @return the current principal
     */
    protected java.security.Principal getPrincipal()
    {
        return es.pode.dri.negocio.PrincipalStore.get();
    }
}