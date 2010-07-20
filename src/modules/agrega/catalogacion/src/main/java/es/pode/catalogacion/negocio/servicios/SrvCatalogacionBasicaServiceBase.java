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
 * Spring Service base class for <code>es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService</code>,
 * provides access to all services and entities referenced by this service.
 * </p>
 *
 * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService
 */
public abstract class SrvCatalogacionBasicaServiceBase
    implements es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService
{

		 protected static final Logger logger = Logger.getLogger(SrvCatalogacionBasicaServiceBase.class);


	
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
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService#obtenerLomBasico(java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.catalogacion.negocio.servicios.LomBasicoVO obtenerLomBasico(java.lang.String identificador, java.lang.String usuario, java.lang.String idioma)
    {
        if (identificador == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.obtenerLomBasico(java.lang.String identificador, java.lang.String usuario, java.lang.String idioma) - 'identificador' can not be null");
        }
        if (usuario == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.obtenerLomBasico(java.lang.String identificador, java.lang.String usuario, java.lang.String idioma) - 'usuario' can not be null");
        }
        if (idioma == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.obtenerLomBasico(java.lang.String identificador, java.lang.String usuario, java.lang.String idioma) - 'idioma' can not be null");
        }
        try
        {
            return this.handleObtenerLomBasico(identificador, usuario, idioma);
        }
        catch (Throwable th)
        {
            throw new es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaServiceException(
                "Error performing 'es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.obtenerLomBasico(java.lang.String identificador, java.lang.String usuario, java.lang.String idioma)' --> " + th,
                th);
        }
    }

     /**
      * Performs the core logic for {@link #obtenerLomBasico(java.lang.String, java.lang.String, java.lang.String)}
      */
    protected abstract es.pode.catalogacion.negocio.servicios.LomBasicoVO handleObtenerLomBasico(java.lang.String identificador, java.lang.String usuario, java.lang.String idioma)
        throws java.lang.Exception;

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService#generarMetadatos(java.lang.String, java.lang.String, es.pode.catalogacion.negocio.servicios.LomBasicoVO, java.lang.String)
     */
    public es.pode.catalogacion.negocio.servicios.LomBasicoVO generarMetadatos(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, java.lang.String idioma)
    {
        if (identificador == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.generarMetadatos(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, java.lang.String idioma) - 'identificador' can not be null");
        }
        if (usuario == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.generarMetadatos(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, java.lang.String idioma) - 'usuario' can not be null");
        }
        if (lomBasico == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.generarMetadatos(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, java.lang.String idioma) - 'lomBasico' can not be null");
        }
        if (idioma == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.generarMetadatos(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, java.lang.String idioma) - 'idioma' can not be null");
        }
        try
        {
            return this.handleGenerarMetadatos(identificador, usuario, lomBasico, idioma);
        }
        catch (Throwable th)
        {
            throw new es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaServiceException(
                "Error performing 'es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.generarMetadatos(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, java.lang.String idioma)' --> " + th,
                th);
        }
    }

     /**
      * Performs the core logic for {@link #generarMetadatos(java.lang.String, java.lang.String, es.pode.catalogacion.negocio.servicios.LomBasicoVO, java.lang.String)}
      */
    protected abstract es.pode.catalogacion.negocio.servicios.LomBasicoVO handleGenerarMetadatos(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, java.lang.String idioma)
        throws java.lang.Exception;

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService#asociarTaxonomia(java.lang.String, java.lang.String, es.pode.catalogacion.negocio.servicios.CBTaxonVO[], java.lang.String)
     */
    public void asociarTaxonomia(java.lang.String identificador, java.lang.String nomTaxonomia, es.pode.catalogacion.negocio.servicios.CBTaxonVO[] taxonList, java.lang.String idioma)
    {
        if (identificador == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.asociarTaxonomia(java.lang.String identificador, java.lang.String nomTaxonomia, es.pode.catalogacion.negocio.servicios.CBTaxonVO[] taxonList, java.lang.String idioma) - 'identificador' can not be null");
        }
        if (nomTaxonomia == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.asociarTaxonomia(java.lang.String identificador, java.lang.String nomTaxonomia, es.pode.catalogacion.negocio.servicios.CBTaxonVO[] taxonList, java.lang.String idioma) - 'nomTaxonomia' can not be null");
        }
        if (taxonList == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.asociarTaxonomia(java.lang.String identificador, java.lang.String nomTaxonomia, es.pode.catalogacion.negocio.servicios.CBTaxonVO[] taxonList, java.lang.String idioma) - 'taxonList' can not be null");
        }
        if (idioma == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.asociarTaxonomia(java.lang.String identificador, java.lang.String nomTaxonomia, es.pode.catalogacion.negocio.servicios.CBTaxonVO[] taxonList, java.lang.String idioma) - 'idioma' can not be null");
        }
        try
        {
            this.handleAsociarTaxonomia(identificador, nomTaxonomia, taxonList, idioma);
        }
        catch (Throwable th)
        {
            throw new es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaServiceException(
                "Error performing 'es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.asociarTaxonomia(java.lang.String identificador, java.lang.String nomTaxonomia, es.pode.catalogacion.negocio.servicios.CBTaxonVO[] taxonList, java.lang.String idioma)' --> " + th,
                th);
        }
    }

     /**
      * Performs the core logic for {@link #asociarTaxonomia(java.lang.String, java.lang.String, es.pode.catalogacion.negocio.servicios.CBTaxonVO[], java.lang.String)}
      */
    protected abstract void handleAsociarTaxonomia(java.lang.String identificador, java.lang.String nomTaxonomia, es.pode.catalogacion.negocio.servicios.CBTaxonVO[] taxonList, java.lang.String idioma)
        throws java.lang.Exception;

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService#cargarObjLom(java.lang.String, java.lang.String, javax.activation.DataHandler)
     */
    public java.lang.String cargarObjLom(java.lang.String identificador, java.lang.String usuario, javax.activation.DataHandler lom)
    {
        if (identificador == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.cargarObjLom(java.lang.String identificador, java.lang.String usuario, javax.activation.DataHandler lom) - 'identificador' can not be null");
        }
        if (usuario == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.cargarObjLom(java.lang.String identificador, java.lang.String usuario, javax.activation.DataHandler lom) - 'usuario' can not be null");
        }
        if (lom == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.cargarObjLom(java.lang.String identificador, java.lang.String usuario, javax.activation.DataHandler lom) - 'lom' can not be null");
        }
        try
        {
            return this.handleCargarObjLom(identificador, usuario, lom);
        }
        catch (Throwable th)
        {
            throw new es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaServiceException(
                "Error performing 'es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.cargarObjLom(java.lang.String identificador, java.lang.String usuario, javax.activation.DataHandler lom)' --> " + th,
                th);
        }
    }

     /**
      * Performs the core logic for {@link #cargarObjLom(java.lang.String, java.lang.String, javax.activation.DataHandler)}
      */
    protected abstract java.lang.String handleCargarObjLom(java.lang.String identificador, java.lang.String usuario, javax.activation.DataHandler lom)
        throws java.lang.Exception;

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService#eliminarObjLoms(java.lang.String[])
     */
    public void eliminarObjLoms(java.lang.String[] ids)
    {
        if (ids == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.eliminarObjLoms(java.lang.String[] ids) - 'ids' can not be null");
        }
        try
        {
            this.handleEliminarObjLoms(ids);
        }
        catch (Throwable th)
        {
            throw new es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaServiceException(
                "Error performing 'es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.eliminarObjLoms(java.lang.String[] ids)' --> " + th,
                th);
        }
    }

     /**
      * Performs the core logic for {@link #eliminarObjLoms(java.lang.String[])}
      */
    protected abstract void handleEliminarObjLoms(java.lang.String[] ids)
        throws java.lang.Exception;

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService#obtenerObjLoms(java.lang.String[])
     */
    public es.pode.catalogacion.negocio.servicios.IdLomVO[] obtenerObjLoms(java.lang.String[] ids)
    {
        if (ids == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.obtenerObjLoms(java.lang.String[] ids) - 'ids' can not be null");
        }
        try
        {
            return this.handleObtenerObjLoms(ids);
        }
        catch (Throwable th)
        {
            throw new es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaServiceException(
                "Error performing 'es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.obtenerObjLoms(java.lang.String[] ids)' --> " + th,
                th);
        }
    }

     /**
      * Performs the core logic for {@link #obtenerObjLoms(java.lang.String[])}
      */
    protected abstract es.pode.catalogacion.negocio.servicios.IdLomVO[] handleObtenerObjLoms(java.lang.String[] ids)
        throws java.lang.Exception;

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService#eliminarTaxonomia(java.lang.String, java.lang.String, int)
     */
    public void eliminarTaxonomia(java.lang.String identificador, java.lang.String nomTaxonomia, int idArbol)
    {
        if (identificador == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.eliminarTaxonomia(java.lang.String identificador, java.lang.String nomTaxonomia, int idArbol) - 'identificador' can not be null");
        }
        if (nomTaxonomia == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.eliminarTaxonomia(java.lang.String identificador, java.lang.String nomTaxonomia, int idArbol) - 'nomTaxonomia' can not be null");
        }
        try
        {
            this.handleEliminarTaxonomia(identificador, nomTaxonomia, idArbol);
        }
        catch (Throwable th)
        {
            throw new es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaServiceException(
                "Error performing 'es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.eliminarTaxonomia(java.lang.String identificador, java.lang.String nomTaxonomia, int idArbol)' --> " + th,
                th);
        }
    }

     /**
      * Performs the core logic for {@link #eliminarTaxonomia(java.lang.String, java.lang.String, int)}
      */
    protected abstract void handleEliminarTaxonomia(java.lang.String identificador, java.lang.String nomTaxonomia, int idArbol)
        throws java.lang.Exception;

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService#asociarTaxonomiaEnLomBasico(java.lang.String, es.pode.catalogacion.negocio.servicios.LomBasicoVO, es.pode.catalogacion.negocio.servicios.CBTaxonVO[])
     */
    public es.pode.catalogacion.negocio.servicios.LomBasicoVO asociarTaxonomiaEnLomBasico(java.lang.String identificador, es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, es.pode.catalogacion.negocio.servicios.CBTaxonVO[] taxonList)
    {
        if (identificador == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.asociarTaxonomiaEnLomBasico(java.lang.String identificador, es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, es.pode.catalogacion.negocio.servicios.CBTaxonVO[] taxonList) - 'identificador' can not be null");
        }
        if (lomBasico == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.asociarTaxonomiaEnLomBasico(java.lang.String identificador, es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, es.pode.catalogacion.negocio.servicios.CBTaxonVO[] taxonList) - 'lomBasico' can not be null");
        }
        if (taxonList == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.asociarTaxonomiaEnLomBasico(java.lang.String identificador, es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, es.pode.catalogacion.negocio.servicios.CBTaxonVO[] taxonList) - 'taxonList' can not be null");
        }
        try
        {
            return this.handleAsociarTaxonomiaEnLomBasico(identificador, lomBasico, taxonList);
        }
        catch (Throwable th)
        {
            throw new es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaServiceException(
                "Error performing 'es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.asociarTaxonomiaEnLomBasico(java.lang.String identificador, es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, es.pode.catalogacion.negocio.servicios.CBTaxonVO[] taxonList)' --> " + th,
                th);
        }
    }

     /**
      * Performs the core logic for {@link #asociarTaxonomiaEnLomBasico(java.lang.String, es.pode.catalogacion.negocio.servicios.LomBasicoVO, es.pode.catalogacion.negocio.servicios.CBTaxonVO[])}
      */
    protected abstract es.pode.catalogacion.negocio.servicios.LomBasicoVO handleAsociarTaxonomiaEnLomBasico(java.lang.String identificador, es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, es.pode.catalogacion.negocio.servicios.CBTaxonVO[] taxonList)
        throws java.lang.Exception;

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService#eliminarTaxonomiasEnLomBasico(es.pode.catalogacion.negocio.servicios.LomBasicoVO, java.lang.String[])
     */
    public es.pode.catalogacion.negocio.servicios.LomBasicoVO eliminarTaxonomiasEnLomBasico(es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, java.lang.String[] idArbol)
    {
        if (lomBasico == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.eliminarTaxonomiasEnLomBasico(es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, java.lang.String[] idArbol) - 'lomBasico' can not be null");
        }
        if (idArbol == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.eliminarTaxonomiasEnLomBasico(es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, java.lang.String[] idArbol) - 'idArbol' can not be null");
        }
        try
        {
            return this.handleEliminarTaxonomiasEnLomBasico(lomBasico, idArbol);
        }
        catch (Throwable th)
        {
            throw new es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaServiceException(
                "Error performing 'es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.eliminarTaxonomiasEnLomBasico(es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, java.lang.String[] idArbol)' --> " + th,
                th);
        }
    }

     /**
      * Performs the core logic for {@link #eliminarTaxonomiasEnLomBasico(es.pode.catalogacion.negocio.servicios.LomBasicoVO, java.lang.String[])}
      */
    protected abstract es.pode.catalogacion.negocio.servicios.LomBasicoVO handleEliminarTaxonomiasEnLomBasico(es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, java.lang.String[] idArbol)
        throws java.lang.Exception;

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService#exportarLomes(java.lang.String, java.lang.String, es.pode.catalogacion.negocio.servicios.LomBasicoVO, java.lang.String)
     */
    public javax.activation.DataHandler exportarLomes(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, java.lang.String idioma)
    {
        if (identificador == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.exportarLomes(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, java.lang.String idioma) - 'identificador' can not be null");
        }
        if (usuario == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.exportarLomes(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, java.lang.String idioma) - 'usuario' can not be null");
        }
        if (lomBasico == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.exportarLomes(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, java.lang.String idioma) - 'lomBasico' can not be null");
        }
        if (idioma == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.exportarLomes(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, java.lang.String idioma) - 'idioma' can not be null");
        }
        try
        {
            return this.handleExportarLomes(identificador, usuario, lomBasico, idioma);
        }
        catch (Throwable th)
        {
            throw new es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaServiceException(
                "Error performing 'es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.exportarLomes(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, java.lang.String idioma)' --> " + th,
                th);
        }
    }

     /**
      * Performs the core logic for {@link #exportarLomes(java.lang.String, java.lang.String, es.pode.catalogacion.negocio.servicios.LomBasicoVO, java.lang.String)}
      */
    protected abstract javax.activation.DataHandler handleExportarLomes(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, java.lang.String idioma)
        throws java.lang.Exception;

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService#importarLomes(javax.activation.DataHandler, java.lang.String)
     */
    public es.pode.catalogacion.negocio.servicios.LomBasicoVO importarLomes(javax.activation.DataHandler ficheroLomes, java.lang.String idioma)
    {
        if (ficheroLomes == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.importarLomes(javax.activation.DataHandler ficheroLomes, java.lang.String idioma) - 'ficheroLomes' can not be null");
        }
        if (idioma == null)
        {
            throw new IllegalArgumentException(
                "es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.importarLomes(javax.activation.DataHandler ficheroLomes, java.lang.String idioma) - 'idioma' can not be null");
        }
        try
        {
            return this.handleImportarLomes(ficheroLomes, idioma);
        }
        catch (Throwable th)
        {
            throw new es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaServiceException(
                "Error performing 'es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService.importarLomes(javax.activation.DataHandler ficheroLomes, java.lang.String idioma)' --> " + th,
                th);
        }
    }

     /**
      * Performs the core logic for {@link #importarLomes(javax.activation.DataHandler, java.lang.String)}
      */
    protected abstract es.pode.catalogacion.negocio.servicios.LomBasicoVO handleImportarLomes(javax.activation.DataHandler ficheroLomes, java.lang.String idioma)
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