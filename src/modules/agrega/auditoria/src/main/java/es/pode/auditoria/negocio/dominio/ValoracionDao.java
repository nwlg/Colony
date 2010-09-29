// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringDao.vsl in andromda-spring-cartridge.
//
package es.pode.auditoria.negocio.dominio;

/**
 * @see es.pode.auditoria.negocio.dominio.Valoracion
 */
public interface ValoracionDao
{
    /**
     * This constant is used as a transformation flag; entities can be converted automatically into value objects
     * or other types, different methods in a class implementing this interface support this feature: look for
     * an <code>int</code> parameter called <code>transform</code>.
     * <p/>
     * This specific flag denotes no transformation will occur.
     */
    public final static int TRANSFORM_NONE = 0;

    /**
     * This constant is used as a transformation flag; entities can be converted automatically into value objects
     * or other types, different methods in a class implementing this interface support this feature: look for
     * an <code>int</code> parameter called <code>transform</code>.
     * <p/>
     * This specific flag denotes entities must be transformed into objects of type
     * {@link es.pode.auditoria.negocio.servicios.ValoracionVO}.
     */
    public final static int TRANSFORM_VALORACIONVO = 1;
    
    
    /**
     * Converts this DAO's entity to an object of type {@link es.pode.auditoria.negocio.servicios.ValoracionVO}.
     * @param entity es.pode.auditoria.negocio.dominio.Valoracion
     * @return es.pode.auditoria.negocio.servicios.ValoracionVO
     */
    public es.pode.auditoria.negocio.servicios.ValoracionVO toValoracionVO(es.pode.auditoria.negocio.dominio.Valoracion entity);

    /**
     * Converts this DAO's entity to a Collection of instances of type {@link es.pode.auditoria.negocio.servicios.ValoracionVO}.
     * @param entities java.util.Collection
     */
    public void toValoracionVOCollection(java.util.Collection entities);

    public es.pode.auditoria.negocio.dominio.Valoracion fromValoracionVO(es.pode.auditoria.negocio.servicios.ValoracionVO vo);
    
    public void fromValoracionVO(es.pode.auditoria.negocio.servicios.ValoracionVO vo, es.pode.auditoria.negocio.dominio.Valoracion entity);


    /**
     * This constant is used as a transformation flag; entities can be converted automatically into value objects
     * or other types, different methods in a class implementing this interface support this feature: look for
     * an <code>int</code> parameter called <code>transform</code>.
     * <p/>
     * This specific flag denotes entities must be transformed into objects of type
     * {@link es.pode.auditoria.negocio.servicios.auditoria.ValoracionIdODEVO}.
     */
    public final static int TRANSFORM_VALORACIONIDODEVO = 2;
    
    
    /**
     * Converts this DAO's entity to an object of type {@link es.pode.auditoria.negocio.servicios.auditoria.ValoracionIdODEVO}.
     * @param entity es.pode.auditoria.negocio.dominio.Valoracion
     * @return es.pode.auditoria.negocio.servicios.auditoria.ValoracionIdODEVO
     */
    public es.pode.auditoria.negocio.servicios.ValoracionIdODEVO toValoracionIdODEVO(es.pode.auditoria.negocio.dominio.Valoracion entity);

    /**
     * Converts this DAO's entity to a Collection of instances of type {@link es.pode.auditoria.negocio.servicios.auditoria.ValoracionIdODEVO}.
     * @param entities java.util.Collection
     */
    public void toValoracionIdODEVOCollection(java.util.Collection entities);

    public es.pode.auditoria.negocio.dominio.Valoracion fromValoracionIdODEVO(es.pode.auditoria.negocio.servicios.ValoracionIdODEVO vo);
    
    public void fromValoracionIdODEVO(es.pode.auditoria.negocio.servicios.ValoracionIdODEVO vo, es.pode.auditoria.negocio.dominio.Valoracion entity);


    /**
     * Loads an instance of es.pode.auditoria.negocio.dominio.Valoracion from the persistent store.
     * @param id java.lang.Long
     * @return es.pode.auditoria.negocio.dominio.Valoracion
     */
    public es.pode.auditoria.negocio.dominio.Valoracion load(java.lang.Long id);

    /**
     * <p>
     *   Does the same thing as {@link #load(java.lang.Long)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined in this class then the result <strong>WILL BE</strong> passed through an operation which can
     *   optionally transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     * </p>
     * @param transform int   
     * @param id the identifier of the entity to load.
     * @return either the entity or the object transformed from the entity.
     */
    public Object load(int transform, java.lang.Long id);
    
    /**
     * Loads all entities of type {@link es.pode.auditoria.negocio.dominio.Valoracion}.
     * 
     * @return the loaded entities.
     */
    public java.util.Collection loadAll();
    
    /** 
     * <p>
     *   Does the same thing as {@link #loadAll()} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     * </p>
     * 
     * @param transform the flag indicating what transformation to use.
     * @return the loaded entities.
     */
    public java.util.Collection loadAll(final int transform);

    /**
     * Creates an instance of es.pode.auditoria.negocio.dominio.Valoracion and adds it to the persistent store.
     * @param valoracion es.pode.auditoria.negocio.dominio.Valoracion
     * @return es.pode.auditoria.negocio.dominio.Valoracion
     */
    public es.pode.auditoria.negocio.dominio.Valoracion create(es.pode.auditoria.negocio.dominio.Valoracion valoracion);

    /**
     * <p>
     *   Does the same thing as {@link #create(es.pode.auditoria.negocio.dominio.Valoracion)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     * </p>
     * @param transform int
     * @param valoracion es.pode.auditoria.negocio.dominio.Valoracion
     * @return Object     
     */
    public Object create(int transform, es.pode.auditoria.negocio.dominio.Valoracion valoracion);

    /**
     * Creates a new instance of es.pode.auditoria.negocio.dominio.Valoracion and adds
     * from the passed in <code>entities</code> collection
     *
     * @param entities the collection of es.pode.auditoria.negocio.dominio.Valoracion
     *        instances to create.
     *
     * @return the created instances.
     */
    public java.util.Collection create(java.util.Collection entities);

    /**
     * <p>
     *   Does the same thing as {@link #create(es.pode.auditoria.negocio.dominio.Valoracion)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     * @param transform int
     * @param entities java.util.Collection
     * @return java.util.Collection        
     */
    public java.util.Collection create(int transform, java.util.Collection entities);

    /**
     * <p>
     *   Creates a new <code>es.pode.auditoria.negocio.dominio.Valoracion</code>
     *   instance from <strong>all</strong> attributes and adds it to
     *   the persistent store.
     * </p>
					 * @param valoracion java.lang.Float  
						    		 * @param idODE java.lang.String  
						    		 * @param fecha java.util.Calendar  
						    		 * @param autor java.lang.String  
						    		 * @param idiomaODE java.lang.String  
			     * @return es.pode.auditoria.negocio.dominio.Valoracion
     */
    public es.pode.auditoria.negocio.dominio.Valoracion create(
					java.lang.Float valoracion 
						,		java.lang.String idODE 
						,		java.util.Calendar fecha 
						,		java.lang.String autor 
						,		java.lang.String idiomaODE 
			);



    /**
     * <p>
     *   Does the same thing as {@link #create(java.lang.Float, java.lang.String, java.util.Calendar, java.lang.String, java.lang.String)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     * </p>
     * @param int
					 * @param valoracion java.lang.Float 
						    		 * @param idODE java.lang.String 
						    		 * @param fecha java.util.Calendar 
						    		 * @param autor java.lang.String 
						    		 * @param idiomaODE java.lang.String 
			     * @return Object
     */
    public Object create(int transform,
					java.lang.Float valoracion 
						,		java.lang.String idODE 
						,		java.util.Calendar fecha 
						,		java.lang.String autor 
						,		java.lang.String idiomaODE 
			);



    /**
     * Updates the <code>valoracion</code> instance in the persistent store.
     * @param valoracion es.pode.auditoria.negocio.dominio.Valoracion
     */
    public void update(es.pode.auditoria.negocio.dominio.Valoracion valoracion);

    /**
     * Updates all instances in the <code>entities</code> collection in the persistent store.
     * @param entities java.util.Collection
     */
    public void update(java.util.Collection entities);

    /**
     * Removes the instance of es.pode.auditoria.negocio.dominio.Valoracion from the persistent store.
     * @param valoracion es.pode.auditoria.negocio.dominio.Valoracion
     */
    public void remove(es.pode.auditoria.negocio.dominio.Valoracion valoracion);

    /**
     * Removes the instance of es.pode.auditoria.negocio.dominio.Valoracion having the given
     * <code>identifier</code> from the persistent store.
     * @param id java.lang.Long
     */
    public void remove(java.lang.Long id);

    /**
     * Removes all entities in the given <code>entities<code> collection.
     * @param entities java.util.Collection
     */
    public void remove(java.util.Collection entities);


    /**
     * TODO: document it
     * @param fechaIni
     * @param fechaFin
     * @return
     */
    public Long totalValoracionesBetweenDates(java.util.Calendar fechaIni, java.util.Calendar fechaFin );



  /**
   * <p>
   * Este metodo devuelve las valoraciones asociadas al criterio de
   * busqueda que le pasan.
   * </p>
   * <p>
   * El criterio de busqueda selecciona las valoraciones de un ODE
   * ordenadas por fecha.
   * </p>
      * @param criterio  Criterio de busqueda de valoraciones asociadas a un ODE ordenadas por fecha.
      * @return java.util.List
   */
    public java.util.List buscarValoracionesPorCriterioODE(es.pode.auditoria.negocio.dominio.IdODEFechaCriteria criterio);

    /**
     * <p>
     *   Does the same thing as {@link #buscarValoracionesPorCriterioODE(es.pode.auditoria.negocio.dominio.IdODEFechaCriteria)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     * @param transform int
        * @param criterio  Criterio de busqueda de valoraciones asociadas a un ODE ordenadas por fecha.
        * @return java.util.List
     */
    public java.util.List buscarValoracionesPorCriterioODE(final int transform, final es.pode.auditoria.negocio.dominio.IdODEFechaCriteria criterio);

  /**
   * <p>
   * Este metodo implementa la busqueda de valoraciones para un ODE
   * dentro de un periodo.
   * </p>
      * @param criterio  Criterio de b�squeda dentro de un rango de fechas.
      * @return java.util.List
   */
    public java.util.List buscarValoracionesPorCriterioODEDesdeHasta(es.pode.auditoria.negocio.dominio.IdODEFechaDesdeHastaCriteria criterio);

    /**
     * <p>
     *   Does the same thing as {@link #buscarValoracionesPorCriterioODEDesdeHasta(es.pode.auditoria.negocio.dominio.IdODEFechaDesdeHastaCriteria)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     * @param transform int
        * @param criterio  Criterio de b�squeda dentro de un rango de fechas.
        * @return java.util.List
     */
    public java.util.List buscarValoracionesPorCriterioODEDesdeHasta(final int transform, final es.pode.auditoria.negocio.dominio.IdODEFechaDesdeHastaCriteria criterio);

  /**
   * <p>
   * Esta consulta implementa la busqueda de los identificadores de
   * ODEs que han tenido valoraciones durante un periodo de tiempo.
   * </p>
         * @return java.util.List
   */
    public java.util.List listarODEsValoradosDesdeHasta(java.util.Calendar fechaDesde, java.util.Calendar fechaHasta);

    /**
     * <p>
     *   Does the same thing as {@link #listarODEsValoradosDesdeHasta(java.util.Calendar, java.util.Calendar)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #listarODEsValoradosDesdeHasta(java.util.Calendar, java.util.Calendar)}.
     * </p>
     * @param queryString String
           * @return java.util.List
     */
    public java.util.List listarODEsValoradosDesdeHasta(String queryString, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta);

    /**
     * <p>
     *   Does the same thing as {@link #listarODEsValoradosDesdeHasta(java.util.Calendar, java.util.Calendar)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     * @param transform int
           * @return java.util.List
     */
    public java.util.List listarODEsValoradosDesdeHasta(int transform, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta);

    /**
     * <p>
     *   Does the same thing as {@link #listarODEsValoradosDesdeHasta(boolean, java.util.Calendar, java.util.Calendar)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #listarODEsValoradosDesdeHasta(int, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta)}.
     * </p>
     * @param transform int
     * @param queryString String     
           * @return java.util.List
     */
    public java.util.List listarODEsValoradosDesdeHasta(int transform, String queryString, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta);


    /**
     * TODO: document it
     * @param transform
     * @param queryString
     * @param fechaDesde
     * @param fechaHasta
     * @return
     */
    public java.util.List listarODEsValoradosDesdeHastaByUser(int transform, String userId, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta);

}