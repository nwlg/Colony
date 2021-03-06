// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringServiceBase.vsl in andromda-spring-cartridge.
//
package es.pode.catalogacion.negocio.servicios;

import net.sf.dozer.util.mapping.MapperIF;

import org.apache.log4j.Logger;


/**
 * <p>
 * Spring Service base class for <code>es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService</code>,
 * provides access to all services and entities referenced by this service.
 * </p>
 *
 * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService
 */
public abstract class SrvCatalogacionAvanzadaServiceBase
    implements es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService
{

		 protected static final Logger logger = Logger.getLogger(SrvCatalogacionAvanzadaServiceBase.class);


	
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


	
	        
    
	    	    	    
		    private es.pode.parseadorXML.LomESDao lomesDao;
		
		    /**
		     * Sets the reference to <code>lomesDao</code>.
		     */
		    public void setLomesDao(es.pode.parseadorXML.LomESDao lomesDao)
		    {
		        this.lomesDao = lomesDao;
		    }
		
		    /**
		     * Gets the reference to <code>lomesDao</code>.
		     */
		    protected es.pode.parseadorXML.LomESDao getLomesDao()
		    {
		        return this.lomesDao;
		    }
	    
	        
	
	        
    
	    	    	    
		    private es.pode.catalogacion.servicio.dominio.CatalogacionDozerDao catalogacionDozerDao;
		
		    /**
		     * Sets the reference to <code>catalogacionDozerDao</code>.
		     */
		    public void setCatalogacionDozerDao(es.pode.catalogacion.servicio.dominio.CatalogacionDozerDao catalogacionDozerDao)
		    {
		        this.catalogacionDozerDao = catalogacionDozerDao;
		    }
		
		    /**
		     * Gets the reference to <code>catalogacionDozerDao</code>.
		     */
		    protected es.pode.catalogacion.servicio.dominio.CatalogacionDozerDao getCatalogacionDozerDao()
		    {
		        return this.catalogacionDozerDao;
		    }
	    
	        

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService#obtenerLomAvanzado(java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.catalogacion.negocio.servicios.LomAvanzadoVO obtenerLomAvanzado(java.lang.String identificador, java.lang.String usuario, java.lang.String idioma)
    {
        if (identificador == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.obtenerLomAvanzado(java.lang.String identificador, java.lang.String usuario, java.lang.String idioma) - 'identificador' can not be null");
        }
        if (usuario == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.obtenerLomAvanzado(java.lang.String identificador, java.lang.String usuario, java.lang.String idioma) - 'usuario' can not be null");
        }
        if (idioma == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.obtenerLomAvanzado(java.lang.String identificador, java.lang.String usuario, java.lang.String idioma) - 'idioma' can not be null");
        }
        try
        {
            return this.handleObtenerLomAvanzado(identificador, usuario, idioma);
        }
        catch (Throwable th)
        {
            throw new es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaServiceException(
                "Error performing 'es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.obtenerLomAvanzado(java.lang.String identificador, java.lang.String usuario, java.lang.String idioma)' --> " + th,
                th);
        }
    }

     /**
      * Performs the core logic for {@link #obtenerLomAvanzado(java.lang.String, java.lang.String, java.lang.String)}
      */
    protected abstract es.pode.catalogacion.negocio.servicios.LomAvanzadoVO handleObtenerLomAvanzado(java.lang.String identificador, java.lang.String usuario, java.lang.String idioma)
        throws java.lang.Exception;

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService#generarMetadatos(java.lang.String, java.lang.String, es.pode.catalogacion.negocio.servicios.LomAvanzadoVO, java.lang.String)
     */
    public es.pode.catalogacion.negocio.servicios.LomAvanzadoVO generarMetadatos(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomAvanzadoVO lomAvanzado, java.lang.String idioma)
    {
        if (identificador == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.generarMetadatos(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomAvanzadoVO lomAvanzado, java.lang.String idioma) - 'identificador' can not be null");
        }
        if (usuario == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.generarMetadatos(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomAvanzadoVO lomAvanzado, java.lang.String idioma) - 'usuario' can not be null");
        }
        if (lomAvanzado == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.generarMetadatos(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomAvanzadoVO lomAvanzado, java.lang.String idioma) - 'lomAvanzado' can not be null");
        }
        if (idioma == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.generarMetadatos(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomAvanzadoVO lomAvanzado, java.lang.String idioma) - 'idioma' can not be null");
        }
        try
        {
            return this.handleGenerarMetadatos(identificador, usuario, lomAvanzado, idioma);
        }
        catch (Throwable th)
        {
            throw new es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaServiceException(
                "Error performing 'es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.generarMetadatos(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomAvanzadoVO lomAvanzado, java.lang.String idioma)' --> " + th,
                th);
        }
    }

     /**
      * Performs the core logic for {@link #generarMetadatos(java.lang.String, java.lang.String, es.pode.catalogacion.negocio.servicios.LomAvanzadoVO, java.lang.String)}
      */
    protected abstract es.pode.catalogacion.negocio.servicios.LomAvanzadoVO handleGenerarMetadatos(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomAvanzadoVO lomAvanzado, java.lang.String idioma)
        throws java.lang.Exception;

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService#cargarObjLom(java.lang.String, java.lang.String, javax.activation.DataHandler)
     */
    public java.lang.String cargarObjLom(java.lang.String identificador, java.lang.String usuario, javax.activation.DataHandler lom)
    {
        if (identificador == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.cargarObjLom(java.lang.String identificador, java.lang.String usuario, javax.activation.DataHandler lom) - 'identificador' can not be null");
        }
        if (usuario == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.cargarObjLom(java.lang.String identificador, java.lang.String usuario, javax.activation.DataHandler lom) - 'usuario' can not be null");
        }
        if (lom == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.cargarObjLom(java.lang.String identificador, java.lang.String usuario, javax.activation.DataHandler lom) - 'lom' can not be null");
        }
        try
        {
            return this.handleCargarObjLom(identificador, usuario, lom);
        }
        catch (Throwable th)
        {
            throw new es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaServiceException(
                "Error performing 'es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.cargarObjLom(java.lang.String identificador, java.lang.String usuario, javax.activation.DataHandler lom)' --> " + th,
                th);
        }
    }

     /**
      * Performs the core logic for {@link #cargarObjLom(java.lang.String, java.lang.String, javax.activation.DataHandler)}
      */
    protected abstract java.lang.String handleCargarObjLom(java.lang.String identificador, java.lang.String usuario, javax.activation.DataHandler lom)
        throws java.lang.Exception;

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService#eliminarObjLoms(java.lang.String[])
     */
    public void eliminarObjLoms(java.lang.String[] ids)
    {
        if (ids == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.eliminarObjLoms(java.lang.String[] ids) - 'ids' can not be null");
        }
        try
        {
            this.handleEliminarObjLoms(ids);
        }
        catch (Throwable th)
        {
            throw new es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaServiceException(
                "Error performing 'es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.eliminarObjLoms(java.lang.String[] ids)' --> " + th,
                th);
        }
    }

     /**
      * Performs the core logic for {@link #eliminarObjLoms(java.lang.String[])}
      */
    protected abstract void handleEliminarObjLoms(java.lang.String[] ids)
        throws java.lang.Exception;

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService#obtenerObjLoms(java.lang.String[])
     */
    public es.pode.catalogacion.negocio.servicios.IdLomVO[] obtenerObjLoms(java.lang.String[] ids)
    {
        if (ids == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.obtenerObjLoms(java.lang.String[] ids) - 'ids' can not be null");
        }
        try
        {
            return this.handleObtenerObjLoms(ids);
        }
        catch (Throwable th)
        {
            throw new es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaServiceException(
                "Error performing 'es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.obtenerObjLoms(java.lang.String[] ids)' --> " + th,
                th);
        }
    }

     /**
      * Performs the core logic for {@link #obtenerObjLoms(java.lang.String[])}
      */
    protected abstract es.pode.catalogacion.negocio.servicios.IdLomVO[] handleObtenerObjLoms(java.lang.String[] ids)
        throws java.lang.Exception;

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService#exportarLomes(java.lang.String, java.lang.String, es.pode.catalogacion.negocio.servicios.LomAvanzadoVO, java.lang.String)
     */
    public javax.activation.DataHandler exportarLomes(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomAvanzadoVO lomAvanzado, java.lang.String idioma)
    {
        if (identificador == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.exportarLomes(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomAvanzadoVO lomAvanzado, java.lang.String idioma) - 'identificador' can not be null");
        }
        if (usuario == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.exportarLomes(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomAvanzadoVO lomAvanzado, java.lang.String idioma) - 'usuario' can not be null");
        }
        if (lomAvanzado == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.exportarLomes(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomAvanzadoVO lomAvanzado, java.lang.String idioma) - 'lomAvanzado' can not be null");
        }
        if (idioma == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.exportarLomes(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomAvanzadoVO lomAvanzado, java.lang.String idioma) - 'idioma' can not be null");
        }
        try
        {
            return this.handleExportarLomes(identificador, usuario, lomAvanzado, idioma);
        }
        catch (Throwable th)
        {
            throw new es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaServiceException(
                "Error performing 'es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.exportarLomes(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomAvanzadoVO lomAvanzado, java.lang.String idioma)' --> " + th,
                th);
        }
    }

     /**
      * Performs the core logic for {@link #exportarLomes(java.lang.String, java.lang.String, es.pode.catalogacion.negocio.servicios.LomAvanzadoVO, java.lang.String)}
      */
    protected abstract javax.activation.DataHandler handleExportarLomes(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomAvanzadoVO lomAvanzado, java.lang.String idioma)
        throws java.lang.Exception;

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService#importarLomes(javax.activation.DataHandler)
     */
    public es.pode.catalogacion.negocio.servicios.LomAvanzadoVO importarLomes(javax.activation.DataHandler ficheroLomes)
    {
        if (ficheroLomes == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.importarLomes(javax.activation.DataHandler ficheroLomes) - 'ficheroLomes' can not be null");
        }
        try
        {
            return this.handleImportarLomes(ficheroLomes);
        }
        catch (Throwable th)
        {
            throw new es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaServiceException(
                "Error performing 'es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.importarLomes(javax.activation.DataHandler ficheroLomes)' --> " + th,
                th);
        }
    }

     /**
      * Performs the core logic for {@link #importarLomes(javax.activation.DataHandler)}
      */
    protected abstract es.pode.catalogacion.negocio.servicios.LomAvanzadoVO handleImportarLomes(javax.activation.DataHandler ficheroLomes)
        throws java.lang.Exception;

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService#exportarLomesDesdeLom(java.lang.String, java.lang.String, java.lang.String, javax.activation.DataHandler)
     */
    public javax.activation.DataHandler exportarLomesDesdeLom(java.lang.String identificador, java.lang.String usuario, java.lang.String idioma, javax.activation.DataHandler lom)
    {
        if (identificador == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.exportarLomesDesdeLom(java.lang.String identificador, java.lang.String usuario, java.lang.String idioma, javax.activation.DataHandler lom) - 'identificador' can not be null");
        }
        if (usuario == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.exportarLomesDesdeLom(java.lang.String identificador, java.lang.String usuario, java.lang.String idioma, javax.activation.DataHandler lom) - 'usuario' can not be null");
        }
        if (idioma == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.exportarLomesDesdeLom(java.lang.String identificador, java.lang.String usuario, java.lang.String idioma, javax.activation.DataHandler lom) - 'idioma' can not be null");
        }
        if (lom == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.exportarLomesDesdeLom(java.lang.String identificador, java.lang.String usuario, java.lang.String idioma, javax.activation.DataHandler lom) - 'lom' can not be null");
        }
        try
        {
            return this.handleExportarLomesDesdeLom(identificador, usuario, idioma, lom);
        }
        catch (Throwable th)
        {
            throw new es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaServiceException(
                "Error performing 'es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService.exportarLomesDesdeLom(java.lang.String identificador, java.lang.String usuario, java.lang.String idioma, javax.activation.DataHandler lom)' --> " + th,
                th);
        }
    }

     /**
      * Performs the core logic for {@link #exportarLomesDesdeLom(java.lang.String, java.lang.String, java.lang.String, javax.activation.DataHandler)}
      */
    protected abstract javax.activation.DataHandler handleExportarLomesDesdeLom(java.lang.String identificador, java.lang.String usuario, java.lang.String idioma, javax.activation.DataHandler lom)
        throws java.lang.Exception;

    /**
     * Gets the current <code>principal</code> if one has been set,
     * otherwise returns <code>null</code>.
     *
     * @return the current principal
     */
    protected java.security.Principal getPrincipal()
    {
        return es.pode.catalogacion.negocio.PrincipalStore.get();
    }
}